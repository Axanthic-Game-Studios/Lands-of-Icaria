package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.container.data.KilnContainerData;
import com.axanthic.icaria.common.handler.stack.KilnFuelItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KilnInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.KilnOutputItemStackHandler;
import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
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
		return this.getRecipe(pServerLevel).isPresent() && this.getRecipe(pServerLevel).get().value().result().getItem() == this.simpleContainer.getItem(pSlot).getItem() || this.simpleContainer.getItem(pSlot).isEmpty();
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
		pServerPlayer.awardRecipes(this.getRecipesToAwardAndPopExperience(pServerPlayer.serverLevel(), pServerPlayer.position()));
		this.recipes.clear();
	}

	public void drop(ServerLevel pServerLevel) {
		Containers.dropContents(pServerLevel, this.worldPosition, this.simpleContainer);
	}

	@Override
	public void loadAdditional(CompoundTag pCompoundTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pCompoundTag, pProvider);
		this.fuelHandler.deserializeNBT(pProvider, pCompoundTag.getCompound("FuelHandler"));
		this.inputHandler.deserializeNBT(pProvider, pCompoundTag.getCompound("InputHandler"));
		this.outputHandler.deserializeNBT(pProvider, pCompoundTag.getCompound("OutputHandler"));
		this.fuel = pCompoundTag.getInt("FuelTick");
		this.maxFuel = pCompoundTag.getInt("MaxFuelTick");
		this.progress = pCompoundTag.getInt("ProgressTick");
		this.maxProgress = pCompoundTag.getInt("MaxProgressTick");
		var compoundTag = pCompoundTag.getCompound("Recipes");
		for (var key : compoundTag.getAllKeys()) {
			this.recipes.put(ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(key)), compoundTag.getInt(key));
		}
	}

	@Override
	public void saveAdditional(CompoundTag pCompoundTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pCompoundTag, pProvider);
		pCompoundTag.put("FuelHandler", this.fuelHandler.serializeNBT(pProvider));
		pCompoundTag.put("InputHandler", this.inputHandler.serializeNBT(pProvider));
		pCompoundTag.put("OutputHandler", this.outputHandler.serializeNBT(pProvider));
		pCompoundTag.putInt("FuelTick", this.fuel);
		pCompoundTag.putInt("MaxFuelTick", this.maxFuel);
		pCompoundTag.putInt("ProgressTick", this.progress);
		pCompoundTag.putInt("MaxProgressTick", this.maxProgress);
		var compoundTag = new CompoundTag();
		this.recipes.forEach((resourceKey, integer) -> compoundTag.putInt(resourceKey.location().toString(), integer));
		pCompoundTag.put("Recipes", compoundTag);
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
		var compoundTag = new CompoundTag();
		compoundTag.put("FuelHandler", this.fuelHandler.serializeNBT(pProvider));
		compoundTag.put("InputHandler", this.inputHandler.serializeNBT(pProvider));
		compoundTag.put("OutputHandler", this.outputHandler.serializeNBT(pProvider));
		compoundTag.putInt("FuelTick", this.fuel);
		compoundTag.putInt("MaxFuelTick", this.maxFuel);
		compoundTag.putInt("ProgressTick", this.progress);
		compoundTag.putInt("MaxProgressTick", this.maxProgress);
		return compoundTag;
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

	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pServerLevel, Vec3 pVec3) {
		var arrayList = new ArrayList<RecipeHolder<?>>();
		for (var entry : this.recipes.reference2IntEntrySet()) {
			pServerLevel.recipeAccess().byKey(entry.getKey()).ifPresent(
				(recipeHolder) -> {
					arrayList.add(recipeHolder);
					if (recipeHolder.value() instanceof FiringRecipe firingRecipe) {
						ExperienceOrb.award(pServerLevel, pVec3, Mth.ceil(entry.getIntValue() * firingRecipe.experience()));
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
