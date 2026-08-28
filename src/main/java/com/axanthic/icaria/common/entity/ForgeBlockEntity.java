package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.data.ForgeContainerData;
import com.axanthic.icaria.common.handler.ForgeHandler;
import com.axanthic.icaria.common.properties.Corner;
import com.axanthic.icaria.common.recipe.ForgingRecipe;
import com.axanthic.icaria.common.recipe.input.TripleRecipeInput;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.mojang.serialization.Codec;

import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;

import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

import net.neoforged.neoforge.transfer.RangedResourceHandler;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeBlockEntity extends BlockEntity {
	public int fuel = 0;
	public int maxFuel = 0;
	public int progress = 0;
	public int maxProgress = 0;

	public static final Codec<Map<ResourceKey<Recipe<?>>, Integer>> RECIPES_CODEC = Codec.unboundedMap(Recipe.KEY_CODEC, Codec.INT);

	public ContainerData data = new ForgeContainerData(this);

	public ItemStacksResourceHandler handler = new ForgeHandler(this);

	public Reference2IntOpenHashMap<ResourceKey<Recipe<?>>> recipes = new Reference2IntOpenHashMap<>();

	public ForgeBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.FORGE.get(), pBlockPos, pBlockState);
	}

	public boolean canAddCount(ServerLevel pServerLevel, int pSlot) {
		return this.hasRecipe(pServerLevel) && this.getResult(pServerLevel).getCount() + this.handler.getAmountAsInt(pSlot) <= 64;
	}

	public boolean canAddItems(ServerLevel pServerLevel, int pSlot) {
		return this.hasRecipe(pServerLevel) && this.getResult(pServerLevel).getItem() == this.handler.getResource(pSlot).getItem() && this.handler.getResource(pSlot).toStack().isStackable() || this.handler.getResource(pSlot).toStack().isEmpty();
	}

	public boolean canAddStack(ServerLevel pServerLevel, int pSlot) {
		return this.canAddCount(pServerLevel, pSlot) && this.canAddItems(pServerLevel, pSlot);
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean hasRecipe(ServerLevel pServerLevel) {
		return this.getRecipe(pServerLevel).isPresent();
	}

	public boolean hasSlot(ServerLevel pServerLevel) {
		return this.canAddStack(pServerLevel, 4) || this.canAddStack(pServerLevel, 5);
	}

	public int getFuelTime(ServerLevel pServerLevel) {
		return this.handler.getResource(0).toStack().getBurnTime(IcariaRecipeTypes.FORGING.get(), pServerLevel.fuelValues());
	}

	public int getRedstoneStrength() {
		var i = this.handler.getAmountAsInt(0) * 15 / 64;
		var j = this.handler.getAmountAsInt(1) * 15 / 64;
		var k = this.handler.getAmountAsInt(2) * 15 / 64;
		var l = this.handler.getAmountAsInt(3) * 15 / 64;
		var m = this.handler.getAmountAsInt(4) * 15 / 64;
		var n = this.handler.getAmountAsInt(5) * 15 / 64;
		var o = i + j + k + l + m + n;
		return o / this.getSize();
	}

	public int getSize() {
		return 6;
	}

	public int getTime(ServerLevel pServerLevel) {
		if (this.getRecipe(pServerLevel).isPresent()) {
			return this.getRecipe(pServerLevel).get().value().time();
		} else {
			return 0;
		}
	}

	public void awardAndClear(BlockPos pBlockPos, ServerLevel pServerLevel) {
		this.dropExperience(pBlockPos, pServerLevel);
		this.recipes.clear();
	}

	public void dropExperience(BlockPos pBlockPos, ServerLevel pServerLevel) {
		this.recipes.forEach((resourceKey, integer) -> pServerLevel.recipeAccess().byKey(resourceKey).ifPresent(recipeHolder -> this.dropExperience(integer, pBlockPos, pServerLevel, recipeHolder)));
	}

	public void dropExperience(int i, BlockPos pBlockPos, ServerLevel pServerLevel, RecipeHolder<?> pRecipeHolder) {
		if (pRecipeHolder.value() instanceof ForgingRecipe forgingRecipe) {
			ExperienceOrb.award(pServerLevel, Vec3.atCenterOf(pBlockPos), Mth.ceil(i * forgingRecipe.experience()));
		}
	}

	public void dropContents(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Containers.dropContents(pServerLevel, pBlockPos, this.handler.copyToList());
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.handler.deserialize(pValueInput.childOrEmpty("Handler"));
		this.fuel = pValueInput.getIntOr("Fuel", 0);
		this.maxFuel = pValueInput.getIntOr("MaxFuel", 0);
		this.progress = pValueInput.getIntOr("Progress", 0);
		this.maxProgress = pValueInput.getIntOr("MaxProgress", 0);
		this.recipes.putAll(pValueInput.read("Recipes", ForgeBlockEntity.RECIPES_CODEC).orElse(Map.of()));
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropContents(pBlockPos, serverLevel);
			this.dropExperience(pBlockPos, serverLevel);
		}
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		this.handler.serialize(pValueOutput.child("Handler"));
		pValueOutput.putInt("Fuel", this.fuel);
		pValueOutput.putInt("MaxFuel", this.maxFuel);
		pValueOutput.putInt("Progress", this.progress);
		pValueOutput.putInt("MaxProgress", this.maxProgress);
		pValueOutput.store("Recipes", ForgeBlockEntity.RECIPES_CODEC, this.recipes);
	}

	public static void tick(ForgeBlockEntity pBlockEntity, ServerLevel pServerLevel) {
		pBlockEntity.tickProgress(pServerLevel);
		pBlockEntity.tickRecipe(pServerLevel);
		pBlockEntity.tickResult(pServerLevel);
		pBlockEntity.tickIntake(pServerLevel);
		pBlockEntity.tickFuel(pServerLevel);
		pBlockEntity.tickUpdate(pServerLevel);
	}

	public void tickProgress(ServerLevel pServerLevel) {
		if (this.progress < this.maxProgress && this.hasFuel() && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.progress++;
		} else if (this.getTime(pServerLevel) > 0 && this.hasFuel() && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.progress = 1;
			this.maxProgress = this.getTime(pServerLevel);
		} else {
			this.progress = 0;
			this.maxProgress = 0;
		}
	}

	public void tickRecipe(ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && this.hasFuel() && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.recipes.addTo(this.getRecipe(pServerLevel).orElseThrow().id(), 1);
		}
	}

	public void tickResult(ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && this.hasFuel() && this.hasRecipe(pServerLevel) && this.canAddStack(pServerLevel, 5)) {
			this.handler.set(5, ItemResource.of(this.getResult(pServerLevel).getItem()), this.getResult(pServerLevel).getCount() + this.handler.getAmountAsInt(5));
		} else if (this.progress == this.maxProgress && this.hasFuel() && this.hasRecipe(pServerLevel) && this.canAddStack(pServerLevel, 4)) {
			this.handler.set(4, ItemResource.of(this.getResult(pServerLevel).getItem()), this.getResult(pServerLevel).getCount() + this.handler.getAmountAsInt(4));
		}
	}

	public void tickIntake(ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && this.hasFuel() && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.setIntake(1);
			this.setIntake(2);
			this.setIntake(3);
		}
	}

	public void setIntake(int pIndex) {
		if (this.handler.getAmountAsInt(pIndex) > 0) {
			this.handler.set(pIndex, this.handler.getResource(pIndex), this.handler.getAmountAsInt(pIndex) - 1);
		}
	}

	public void tickFuel(ServerLevel pServerLevel) {
		if (this.fuel < this.maxFuel) {
			this.fuel++;
		} else if (this.getFuelTime(pServerLevel) > 0 && this.hasRecipe(pServerLevel) && this.hasSlot(pServerLevel)) {
			this.fuel = 1;
			this.maxFuel = this.getFuelTime(pServerLevel);
			this.handler.set(0, this.handler.getResource(0), this.handler.getAmountAsInt(0) - 1);
		} else {
			this.fuel = 0;
			this.maxFuel = 0;
		}
	}

	public void tickUpdate(ServerLevel pServerLevel) {
		var direction = this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (this.getBlockState().getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_LEFT) {
			this.setUpdate(this.hasFuel(), this.getBlockPos(), this.getBlockState(), pServerLevel, Corner.BOTTOM_FRONT_LEFT);
			this.setUpdate(this.hasFuel(), this.getBlockPos().offset(direction.getCounterClockWise().getUnitVec3i()), this.getBlockState(), pServerLevel, Corner.BOTTOM_FRONT_RIGHT);
			this.setUpdate(this.hasFuel(), this.getBlockPos().offset(direction.getOpposite().getUnitVec3i()), this.getBlockState(), pServerLevel, Corner.BOTTOM_BACK_LEFT);
			this.setUpdate(this.hasFuel(), this.getBlockPos().offset(direction.getOpposite().getUnitVec3i()).offset(direction.getCounterClockWise().getUnitVec3i()), this.getBlockState(), pServerLevel, Corner.BOTTOM_BACK_RIGHT);
			this.setUpdate(this.hasFuel(), this.getBlockPos().above(), this.getBlockState(), pServerLevel, Corner.TOP_FRONT_LEFT);
			this.setUpdate(this.hasFuel(), this.getBlockPos().above().offset(direction.getCounterClockWise().getUnitVec3i()), this.getBlockState(), pServerLevel, Corner.TOP_FRONT_RIGHT);
			this.setUpdate(this.hasFuel(), this.getBlockPos().above().offset(direction.getOpposite().getUnitVec3i()), this.getBlockState(), pServerLevel, Corner.TOP_BACK_LEFT);
			this.setUpdate(this.hasFuel(), this.getBlockPos().above().offset(direction.getOpposite().getUnitVec3i()).offset(direction.getCounterClockWise().getUnitVec3i()), this.getBlockState(), pServerLevel, Corner.TOP_BACK_RIGHT);
		}
	}

	public void setUpdate(boolean pLit, BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel, Corner pCorner) {
		pServerLevel.blockEntityChanged(pBlockPos);
		pServerLevel.sendBlockUpdated(pBlockPos, pBlockState, pBlockState, 3);
		pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.CORNER, pCorner).setValue(BlockStateProperties.LIT, pLit));
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos, pBlockState.getBlock());
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = this.getUpdateTagOutput(pProvider);
		compoundTag.putInt("Fuel", this.fuel);
		compoundTag.putInt("MaxFuel", this.maxFuel);
		compoundTag.putInt("Progress", this.progress);
		compoundTag.putInt("MaxProgress", this.maxProgress);
		return compoundTag;
	}

	public CompoundTag getUpdateTagOutput(HolderLookup.Provider pProvider) {
		var tagValueOutput = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, pProvider);
		this.handler.serialize(tagValueOutput.child("Handler"));
		return tagValueOutput.buildResult();
	}

	@Nullable
	public ResourceHandler<ItemResource> getCap(BlockEntity pBlockEntity, @Nullable Direction pDirection) {
		var blockPos = pBlockEntity.getBlockPos();
		var blockState = pBlockEntity.getBlockState();

		var corner = blockState.getValue(IcariaBlockStateProperties.CORNER);
		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);

		if (corner == Corner.BOTTOM_FRONT_LEFT && pDirection == direction.getClockWise()) {
			return this.getCap(pBlockEntity, blockPos, 0, 1);
		} else if (corner == Corner.TOP_FRONT_LEFT && pDirection == Direction.UP) {
			return this.getCap(pBlockEntity, blockPos.below(), 1, 2);
		} else if (corner == Corner.TOP_BACK_LEFT && pDirection == Direction.UP) {
			return this.getCap(pBlockEntity, blockPos.below().relative(direction), 2, 3);
		} else if (corner == Corner.TOP_BACK_RIGHT && pDirection == Direction.UP) {
			return this.getCap(pBlockEntity, blockPos.below().relative(direction).relative(direction.getClockWise()), 3, 4);
		} else if (corner == Corner.BOTTOM_FRONT_LEFT && pDirection == Direction.DOWN) {
			return this.getCap(pBlockEntity, blockPos, 4, 6);
		} else if (corner == Corner.BOTTOM_FRONT_RIGHT && pDirection == Direction.DOWN) {
			return this.getCap(pBlockEntity, blockPos.relative(direction.getClockWise()), 4, 6);
		} else if (corner == Corner.BOTTOM_BACK_LEFT && pDirection == Direction.DOWN) {
			return this.getCap(pBlockEntity, blockPos.relative(direction), 4, 6);
		} else if (corner == Corner.BOTTOM_BACK_RIGHT && pDirection == Direction.DOWN) {
			return this.getCap(pBlockEntity, blockPos.relative(direction).relative(direction.getClockWise()), 4, 6);
		} else {
			return null;
		}
	}

	@Nullable
	public ResourceHandler<ItemResource> getCap(BlockEntity pBlockEntity, BlockPos pBlockPos, int p0, int p1) {
		if (pBlockEntity.getLevel() != null && pBlockEntity.getLevel().getBlockEntity(pBlockPos) instanceof ForgeBlockEntity blockEntity) {
			return RangedResourceHandler.of(blockEntity.handler, p0, p1);
		} else {
			return null;
		}
	}

	public ItemStack getFuel() {
		return this.handler.getResource(0).toStack();
	}

	public ItemStack getOutputA() {
		return this.handler.getResource(4).toStack();
	}

	public ItemStack getOutputB() {
		return this.handler.getResource(5).toStack();
	}

	public ItemStack getResult(ServerLevel pServerLevel) {
		if (this.getRecipe(pServerLevel).isPresent()) {
			return this.getRecipe(pServerLevel).get().value().result();
		} else {
			return ItemStack.EMPTY;
		}
	}

	public Optional<RecipeHolder<ForgingRecipe>> getRecipe(ServerLevel pServerLevel) {
		return pServerLevel.recipeAccess().getRecipeFor(IcariaRecipeTypes.FORGING.get(), this.getRecipeInput(), pServerLevel);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new TripleRecipeInput(this.handler.getResource(1).toStack(), this.handler.getResource(2).toStack(), this.handler.getResource(3).toStack());
	}
}
