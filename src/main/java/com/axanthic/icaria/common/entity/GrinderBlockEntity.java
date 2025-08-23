package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.container.data.GrinderContainerData;
import com.axanthic.icaria.common.handler.stack.GrinderFuelItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderGearItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderOutputItemStackHandler;
import com.axanthic.icaria.common.network.packet.GrinderPacket;
import com.axanthic.icaria.common.properties.Side;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.recipe.input.DoubleRecipeInput;
import com.axanthic.icaria.common.registry.*;

import com.mojang.serialization.Codec;

import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;

import java.util.ArrayList;
import java.util.List;
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
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.network.PacketDistributor;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlockEntity extends BlockEntity {
	public boolean tickClient;

	public int lastSound = 6;
	public int fuel = 0;
	public int maxFuel = 0;
	public int progress = 0;
	public int maxProgress = 0;
	public int size = 6;

	public long prevTime;

	public static final Codec<Map<ResourceKey<Recipe<?>>, Integer>> RECIPES_CODEC = Codec.unboundedMap(Recipe.KEY_CODEC, Codec.INT);

	public ItemStackHandler fuelHandler = new GrinderFuelItemStackHandler(1, this);
	public ItemStackHandler gearHandler = new GrinderGearItemStackHandler(1, this);
	public ItemStackHandler inputHandler = new GrinderInputItemStackHandler(1, this);
	public ItemStackHandler outputHandler = new GrinderOutputItemStackHandler(3, this);

	public Reference2IntOpenHashMap<ResourceKey<Recipe<?>>> recipes = new Reference2IntOpenHashMap<>();

	public SimpleContainer simpleContainer = new SimpleContainer(this.size);

	public GrinderBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.GRINDER.get(), pBlockPos, pBlockState);
	}

	public boolean canAddCount(ServerLevel pServerLevel, int pSlot) {
		return this.getRecipe(pServerLevel).isPresent() && this.getRecipe(pServerLevel).get().value().result().getCount() + this.simpleContainer.getItem(pSlot).getCount() <= 64;
	}

	public boolean canAddItems(ServerLevel pServerLevel, int pSlot) {
		return this.getRecipe(pServerLevel).isPresent() && this.getRecipe(pServerLevel).get().value().result().getItem() == this.simpleContainer.getItem(pSlot).getItem() && this.simpleContainer.getItem(pSlot).isStackable() || this.simpleContainer.getItem(pSlot).isEmpty();
	}

	public boolean canAddStack(ServerLevel pServerLevel, int pSlot) {
		return this.canAddCount(pServerLevel, pSlot) && this.canAddItems(pServerLevel, pSlot);
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean hasSlot(ServerLevel pServerLevel) {
		return this.canAddStack(pServerLevel, 3) || this.canAddStack(pServerLevel, 4) || this.canAddStack(pServerLevel, 5);
	}

	public int getFuelTime() {
		if (this.fuelHandler.getStackInSlot(0).getItem() == IcariaItems.SLIVER_BLOCK.get()) {
			return 7200;
		} else if (this.fuelHandler.getStackInSlot(0).getItem() == IcariaItems.SLIVER.get()) {
			return 800;
		} else {
			return 0;
		}
	}

	public int getRedstoneStrength() {
		var i = this.fuelHandler.getStackInSlot(0).getCount() * 15 / 64;
		var j = this.gearHandler.getStackInSlot(0).getCount() * 15;
		var k = this.inputHandler.getStackInSlot(0).getCount() * 15 / 64;
		var l = this.outputHandler.getStackInSlot(0).getCount() * 15 / 64;
		var m = this.outputHandler.getStackInSlot(1).getCount() * 15 / 64;
		var n = this.outputHandler.getStackInSlot(2).getCount() * 15 / 64;
		var o = i + j + k + l + m + n;
		return o / this.size;
	}

	public void awardUsedRecipesAndPopExperience(ServerPlayer pServerPlayer) {
		pServerPlayer.awardRecipes(this.getRecipesToAwardAndPopExperience(pServerPlayer.blockPosition(), pServerPlayer.level()));
		this.recipes.clear();
	}

	public void dropBlock(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Block.popResource(pServerLevel, pBlockPos, new ItemStack(IcariaItems.GRINDER.get()));
	}

	public void dropItems(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Containers.dropContents(pServerLevel, pBlockPos, this.simpleContainer);
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.fuelHandler.deserialize(pValueInput.childOrEmpty("FuelHandler"));
		this.gearHandler.deserialize(pValueInput.childOrEmpty("GearHandler"));
		this.inputHandler.deserialize(pValueInput.childOrEmpty("InputHandler"));
		this.outputHandler.deserialize(pValueInput.childOrEmpty("OutputHandler"));
		this.fuel = pValueInput.getIntOr("FuelTick", 0);
		this.maxFuel = pValueInput.getIntOr("MaxFuelTick", 0);
		this.progress = pValueInput.getIntOr("ProgressTick", 0);
		this.maxProgress = pValueInput.getIntOr("MaxProgressTick", 0);
		this.recipes.clear();
		this.recipes.putAll(pValueInput.read("Recipes", GrinderBlockEntity.RECIPES_CODEC).orElse(Map.of()));
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropBlock(pBlockPos, serverLevel);
			this.dropItems(pBlockPos, serverLevel);
			this.getRecipesToAwardAndPopExperience(pBlockPos, serverLevel);
		}
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		this.fuelHandler.serialize(pValueOutput.child("FuelHandler"));
		this.gearHandler.serialize(pValueOutput.child("GearHandler"));
		this.inputHandler.serialize(pValueOutput.child("InputHandler"));
		this.outputHandler.serialize(pValueOutput.child("OutputHandler"));
		pValueOutput.putInt("FuelTick", this.fuel);
		pValueOutput.putInt("MaxFuelTick", this.maxFuel);
		pValueOutput.putInt("ProgressTick", this.progress);
		pValueOutput.putInt("MaxProgressTick", this.maxProgress);
		pValueOutput.store("Recipes", GrinderBlockEntity.RECIPES_CODEC, this.recipes);
	}

	public void setContainer() {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.gearHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(4, this.outputHandler.getStackInSlot(1));
		this.simpleContainer.setItem(5, this.outputHandler.getStackInSlot(2));
	}

	public static void tick(GrinderBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		var recipe = pBlockEntity.getRecipe(pServerLevel);
		pBlockEntity.setContainer();
		pBlockEntity.tickClient(pBlockEntity, pBlockPos, pServerLevel);
		pBlockEntity.tickFuel(recipe, pServerLevel);
		pBlockEntity.tickGear(recipe, pServerLevel);
		pBlockEntity.tickProgress(recipe, pServerLevel);
		pBlockEntity.tickRecipe(recipe, pServerLevel);
		pBlockEntity.tickSound(recipe, pServerLevel);
		pBlockEntity.update(pBlockPos, pBlockState, pServerLevel);
		pBlockEntity.updateStates(pBlockPos, pBlockState, pServerLevel, recipe.isPresent() && pBlockEntity.hasFuel());
	}

	public void tickClient(GrinderBlockEntity pBlockEntity, BlockPos pBlockPos, ServerLevel pServerLevel) {
		PacketDistributor.sendToAllPlayers(new GrinderPacket(pBlockEntity.hasSlot(pServerLevel), pBlockPos));
	}

	public void tickFuel(Optional<RecipeHolder<GrindingRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (this.fuel < this.maxFuel) {
			this.fuel++;
		} else if (pRecipe.isPresent() && this.getFuelTime() > 0 && this.hasSlot(pServerLevel)) {
			this.fuel = 1;
			this.maxFuel = this.getFuelTime();
			this.fuelHandler.extractItem(0, 1, false);
		} else {
			this.fuel = 0;
			this.maxFuel = 0;
		}
	}

	public void tickGear(Optional<RecipeHolder<GrindingRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && pRecipe.isPresent() && this.hasFuel() && this.hasSlot(pServerLevel)) {
			var gearSlot = this.gearHandler.getStackInSlot(0);
			if (gearSlot.isDamageableItem()) {
				gearSlot.setDamageValue(gearSlot.getDamageValue() + 1);
				if (gearSlot.getMaxDamage() - gearSlot.getDamageValue() <= 0) {
					this.gearHandler.extractItem(0, 1, false);
					pServerLevel.playSound(null, this.getBlockPos(), SoundEvents.ITEM_BREAK.value(), SoundSource.BLOCKS);
				}
			}
		}
	}

	public void tickOutput(Optional<RecipeHolder<GrindingRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (this.canAddStack(pServerLevel, 5) && pRecipe.isPresent()) {
			this.outputHandler.setStackInSlot(2, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount() + this.outputHandler.getStackInSlot(2).getCount()));
		} else if (this.canAddStack(pServerLevel, 4) && pRecipe.isPresent()) {
			this.outputHandler.setStackInSlot(1, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount() + this.outputHandler.getStackInSlot(1).getCount()));
		} else if (this.canAddStack(pServerLevel, 3) && pRecipe.isPresent()) {
			this.outputHandler.setStackInSlot(0, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount() + this.outputHandler.getStackInSlot(0).getCount()));
		}
	}

	public void tickProgress(Optional<RecipeHolder<GrindingRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (this.progress < this.maxProgress && pRecipe.isPresent() && this.hasFuel() && this.hasSlot(pServerLevel)) {
			this.progress++;
		} else if (pRecipe.isPresent() && pRecipe.get().value().time() > 0 && this.hasFuel() && this.hasSlot(pServerLevel)) {
			this.progress = 1;
			this.maxProgress = pRecipe.get().value().time();
		} else {
			this.progress = 0;
			this.maxProgress = 0;
		}
	}

	public void tickRecipe(Optional<RecipeHolder<GrindingRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && pRecipe.isPresent() && this.hasFuel() && this.hasSlot(pServerLevel)) {
			this.tickOutput(pRecipe, pServerLevel);
			this.recipes.addTo(pRecipe.get().id(), 1);
			this.inputHandler.extractItem(0, 1, false);
		}
	}

	public void tickSound(Optional<RecipeHolder<GrindingRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (IcariaConfig.GRINDER_SOUNDS.get() && pRecipe.isPresent() && this.hasFuel() && this.hasSlot(pServerLevel)) {
			if (this.lastSound < 6) {
				this.lastSound++;
			} else {
				this.lastSound = 0;
				pServerLevel.playSound(null, this.getBlockPos(), IcariaSoundEvents.GRINDER_GRIND, SoundSource.BLOCKS);
			}
		}
	}

	public void update(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pServerLevel.blockEntityChanged(pBlockPos);
		pServerLevel.sendBlockUpdated(pBlockPos, pBlockState, pBlockState, 3);
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos, pBlockState.getBlock());
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos.offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.getBlock());
	}

	public void updateStates(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel, boolean pGrinding) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.SIDE, Side.LEFT).setValue(IcariaBlockStateProperties.GRINDER_GRINDING, pGrinding));
		pServerLevel.setBlockAndUpdate(pBlockPos.offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.SIDE, Side.RIGHT).setValue(IcariaBlockStateProperties.GRINDER_GRINDING, pGrinding));
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = this.getUpdateTagOutput(pProvider);
		compoundTag.putInt("FuelTick", this.fuel);
		compoundTag.putInt("MaxFuelTick", this.maxFuel);
		compoundTag.putInt("ProgressTick", this.progress);
		compoundTag.putInt("MaxProgressTick", this.maxProgress);
		return compoundTag;
	}

	public CompoundTag getUpdateTagOutput(HolderLookup.Provider pProvider) {
		var tagValueOutput = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, pProvider);
		this.fuelHandler.serialize(tagValueOutput.child("FuelHandler"));
		this.gearHandler.serialize(tagValueOutput.child("GearHandler"));
		this.inputHandler.serialize(tagValueOutput.child("InputHandler"));
		this.outputHandler.serialize(tagValueOutput.child("OutputHandler"));
		return tagValueOutput.buildResult();
	}

	public ContainerData getData() {
		return new GrinderContainerData(this);
	}

	@Nullable
	public static IItemHandler getCapability(GrinderBlockEntity pBlockEntity, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return pBlockEntity.outputHandler;
		}

		return null;
	}

	public ItemStack getGear() {
		return this.gearHandler.getStackInSlot(0);
	}

	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(BlockPos pBlockPos, ServerLevel pServerLevel) {
		var arrayList = new ArrayList<RecipeHolder<?>>();
		for (var entry : this.recipes.reference2IntEntrySet()) {
			pServerLevel.recipeAccess().byKey(entry.getKey()).ifPresent(
				recipeHolder -> {
					arrayList.add(recipeHolder);
					if (recipeHolder.value() instanceof GrindingRecipe grindingRecipe) {
						ExperienceOrb.award(pServerLevel, Vec3.atCenterOf(pBlockPos), Mth.ceil(entry.getIntValue() * grindingRecipe.experience()));
					}
				}
			);
		}

		return arrayList;
	}

	public Optional<RecipeHolder<GrindingRecipe>> getRecipe(ServerLevel pServerLevel) {
		return RecipeManager.createCheck(IcariaRecipeTypes.GRINDING.get()).getRecipeFor(this.getRecipeInput(), pServerLevel);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new DoubleRecipeInput(this.gearHandler.getStackInSlot(0), this.inputHandler.getStackInSlot(0));
	}
}
