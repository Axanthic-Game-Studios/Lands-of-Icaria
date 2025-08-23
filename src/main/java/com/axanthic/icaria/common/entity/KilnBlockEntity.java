package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.container.data.KilnContainerData;
import com.axanthic.icaria.common.handler.stack.KilnFuelItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KilnInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KilnOutputItemStackHandler;
import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

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
import net.minecraft.util.Mth;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnBlockEntity extends BlockEntity {
	public int fuel = 0;
	public int maxFuel = 0;
	public int progress = 0;
	public int maxProgress = 0;
	public int size = 3;

	public static final Codec<Map<ResourceKey<Recipe<?>>, Integer>> RECIPES_CODEC = Codec.unboundedMap(Recipe.KEY_CODEC, Codec.INT);

	public ItemStackHandler fuelHandler = new KilnFuelItemStackHandler(1, this);
	public ItemStackHandler inputHandler = new KilnInputItemStackHandler(1, this);
	public ItemStackHandler outputHandler = new KilnOutputItemStackHandler(1, this);

	public Reference2IntOpenHashMap<ResourceKey<Recipe<?>>> recipes = new Reference2IntOpenHashMap<>();

	public SimpleContainer simpleContainer = new SimpleContainer(this.size);

	public KilnBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.KILN.get(), pBlockPos, pBlockState);
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
		return this.canAddStack(pServerLevel, 2);
	}

	public int getFuelTime(ServerLevel pServerLevel) {
		return this.fuelHandler.getStackInSlot(0).getBurnTime(IcariaRecipeTypes.FIRING.get(), pServerLevel.fuelValues());
	}

	public int getRedstoneStrength() {
		var i = this.fuelHandler.getStackInSlot(0).getCount() * 15 / 64;
		var j = this.inputHandler.getStackInSlot(0).getCount() * 15 / 64;
		var k = this.outputHandler.getStackInSlot(0).getCount() * 15 / 64;
		var l = i + j + k;
		return l / this.size;
	}

	public void awardUsedRecipesAndPopExperience(ServerPlayer pServerPlayer) {
		pServerPlayer.awardRecipes(this.getRecipesToAwardAndPopExperience(pServerPlayer.blockPosition(), pServerPlayer.level()));
		this.recipes.clear();
	}

	public void dropBlock(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Block.popResource(pServerLevel, pBlockPos, new ItemStack(IcariaItems.KILN.get()));
	}

	public void dropItems(BlockPos pBlockPos, ServerLevel pServerLevel) {
		Containers.dropContents(pServerLevel, pBlockPos, this.simpleContainer);
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.fuelHandler.deserialize(pValueInput.childOrEmpty("FuelHandler"));
		this.inputHandler.deserialize(pValueInput.childOrEmpty("InputHandler"));
		this.outputHandler.deserialize(pValueInput.childOrEmpty("OutputHandler"));
		this.fuel = pValueInput.getIntOr("FuelTick", 0);
		this.maxFuel = pValueInput.getIntOr("MaxFuelTick", 0);
		this.progress = pValueInput.getIntOr("ProgressTick", 0);
		this.maxProgress = pValueInput.getIntOr("MaxProgressTick", 0);
		this.recipes.clear();
		this.recipes.putAll(pValueInput.read("Recipes", KilnBlockEntity.RECIPES_CODEC).orElse(Map.of()));
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
		this.inputHandler.serialize(pValueOutput.child("InputHandler"));
		this.outputHandler.serialize(pValueOutput.child("OutputHandler"));
		pValueOutput.putInt("FuelTick", this.fuel);
		pValueOutput.putInt("MaxFuelTick", this.maxFuel);
		pValueOutput.putInt("ProgressTick", this.progress);
		pValueOutput.putInt("MaxProgressTick", this.maxProgress);
		pValueOutput.store("Recipes", KilnBlockEntity.RECIPES_CODEC, this.recipes);
	}

	public void setContainer() {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.outputHandler.getStackInSlot(0));
	}

	public static void tick(KilnBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		var recipe = pBlockEntity.getRecipe(pServerLevel);
		pBlockEntity.setContainer();
		pBlockEntity.tickFuel(recipe, pServerLevel);
		pBlockEntity.tickProgress(recipe, pServerLevel);
		pBlockEntity.tickRecipe(recipe, pServerLevel);
		pBlockEntity.update(pBlockPos, pBlockState, pServerLevel);
		pBlockEntity.updateStates(pBlockPos, pBlockState, pServerLevel, pBlockEntity.hasFuel());
	}

	public void tickFuel(Optional<RecipeHolder<FiringRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (this.fuel < this.maxFuel) {
			this.fuel++;
		} else if (pRecipe.isPresent() && this.getFuelTime(pServerLevel) > 0 && this.hasSlot(pServerLevel)) {
			this.fuel = 1;
			this.maxFuel = this.getFuelTime(pServerLevel);
			this.fuelHandler.extractItem(0, 1, false);
		} else {
			this.fuel = 0;
			this.maxFuel = 0;
		}
	}

	public void tickProgress(Optional<RecipeHolder<FiringRecipe>> pRecipe, ServerLevel pServerLevel) {
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

	public void tickRecipe(Optional<RecipeHolder<FiringRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (this.progress == this.maxProgress && pRecipe.isPresent() && this.hasFuel() && this.hasSlot(pServerLevel)) {
			this.recipes.addTo(pRecipe.get().id(), 1);
			this.inputHandler.extractItem(0, 1, false);
			this.outputHandler.setStackInSlot(0, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount() + this.outputHandler.getStackInSlot(0).getCount()));
		}
	}

	public void update(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		pServerLevel.blockEntityChanged(pBlockPos);
		pServerLevel.sendBlockUpdated(pBlockPos, pBlockState, pBlockState, 3);
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos, pBlockState.getBlock());
		pServerLevel.updateNeighbourForOutputSignal(pBlockPos.above(), pBlockState.getBlock());
	}

	public void updateStates(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel, boolean pLit) {
		pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.LIT, pLit));
		pServerLevel.setBlockAndUpdate(pBlockPos.above(), pBlockState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER).setValue(BlockStateProperties.LIT, pLit));
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
		this.inputHandler.serialize(tagValueOutput.child("InputHandler"));
		this.outputHandler.serialize(tagValueOutput.child("OutputHandler"));
		return tagValueOutput.buildResult();
	}

	public ContainerData getData() {
		return new KilnContainerData(this);
	}

	@Nullable
	public static IItemHandler getCapability(KilnBlockEntity pBlockEntity, Direction pDirection) {
		if (pDirection == pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()) {
			return pBlockEntity.fuelHandler;
		} else if (pDirection == Direction.DOWN) {
			return pBlockEntity.outputHandler;
		}

		return null;
	}

	public ItemStack getFuel() {
		return this.fuelHandler.getStackInSlot(0);
	}

	public ItemStack getInput() {
		return this.inputHandler.getStackInSlot(0);
	}

	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(BlockPos pBlockPos, ServerLevel pServerLevel) {
		var arrayList = new ArrayList<RecipeHolder<?>>();
		for (var entry : this.recipes.reference2IntEntrySet()) {
			pServerLevel.recipeAccess().byKey(entry.getKey()).ifPresent(
				recipeHolder -> {
					arrayList.add(recipeHolder);
					if (recipeHolder.value() instanceof FiringRecipe firingRecipe) {
						ExperienceOrb.award(pServerLevel, Vec3.atCenterOf(pBlockPos), Mth.ceil(entry.getIntValue() * firingRecipe.experience()));
					}
				}
			);
		}

		return arrayList;
	}

	public Optional<RecipeHolder<FiringRecipe>> getRecipe(ServerLevel pServerLevel) {
		return RecipeManager.createCheck(IcariaRecipeTypes.FIRING.get()).getRecipeFor(this.getRecipeInput(), pServerLevel);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new SingleRecipeInput(this.inputHandler.getStackInSlot(0));
	}
}
