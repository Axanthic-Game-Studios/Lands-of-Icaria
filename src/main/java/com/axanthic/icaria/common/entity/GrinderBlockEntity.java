package com.axanthic.icaria.common.entity;

import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.container.data.GrinderContainerData;
import com.axanthic.icaria.common.handler.stack.GrinderFuelItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderGearItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderOutputItemStackHandler;
import com.axanthic.icaria.common.properties.Side;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.recipe.input.DoubleRecipeInput;
import com.axanthic.icaria.common.registry.*;

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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlockEntity extends BlockEntity {
	public int lastSound = 6;
	public int fuel = 0;
	public int maxFuel = 0;
	public int progress = 0;
	public int maxProgress = 0;
	public int size = 6;

	public long prevTime;

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
		return this.getRecipe(pServerLevel).isPresent() && this.getRecipe(pServerLevel).get().value().result().getItem() == this.simpleContainer.getItem(pSlot).getItem() || this.simpleContainer.getItem(pSlot).isEmpty();
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
		this.gearHandler.deserializeNBT(pProvider, pCompoundTag.getCompound("GearHandler"));
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
		pCompoundTag.put("GearHandler", this.gearHandler.serializeNBT(pProvider));
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
		this.simpleContainer.setItem(1, this.gearHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(4, this.outputHandler.getStackInSlot(1));
		this.simpleContainer.setItem(5, this.outputHandler.getStackInSlot(2));
	}

	public static void tick(GrinderBlockEntity pBlockEntity, BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		var recipe = pBlockEntity.getRecipe(pServerLevel);
		pBlockEntity.setContainer();
		pBlockEntity.tickFuel(recipe, pServerLevel);
		pBlockEntity.tickGear(recipe, pServerLevel);
		pBlockEntity.tickProgress(recipe, pServerLevel);
		pBlockEntity.tickRecipe(recipe, pServerLevel);
		pBlockEntity.tickSound(recipe, pServerLevel);
		pBlockEntity.update(pBlockPos, pBlockState, pServerLevel);
		pBlockEntity.updateStates(pBlockPos, pBlockState, pServerLevel, recipe.isPresent() && pBlockEntity.hasFuel());
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
					pServerLevel.playSound(null, this.getBlockPos(), SoundEvents.ITEM_BREAK, SoundSource.BLOCKS);
				}
			}
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
			this.recipes.addTo(pRecipe.get().id(), 1);
			this.inputHandler.extractItem(0, 1, false);
			if (this.canAddStack(pServerLevel, 5)) {
				this.outputHandler.setStackInSlot(2, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount() + this.outputHandler.getStackInSlot(2).getCount()));
			} else if (this.canAddStack(pServerLevel, 4)) {
				this.outputHandler.setStackInSlot(1, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount() + this.outputHandler.getStackInSlot(1).getCount()));
			} else if (this.canAddStack(pServerLevel, 3)) {
				this.outputHandler.setStackInSlot(0, new ItemStack(pRecipe.get().value().result().getItem(), pRecipe.get().value().result().getCount() + this.outputHandler.getStackInSlot(0).getCount()));
			}

		}
	}

	public void tickSound(Optional<RecipeHolder<GrindingRecipe>> pRecipe, ServerLevel pServerLevel) {
		if (IcariaConfig.GRINDER_SOUNDS.get() && pRecipe.isPresent() && this.hasFuel()) {
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
		var compoundTag = new CompoundTag();
		compoundTag.put("FuelHandler", this.fuelHandler.serializeNBT(pProvider));
		compoundTag.put("GearHandler", this.gearHandler.serializeNBT(pProvider));
		compoundTag.put("InputHandler", this.inputHandler.serializeNBT(pProvider));
		compoundTag.put("OutputHandler", this.outputHandler.serializeNBT(pProvider));
		compoundTag.putInt("FuelTick", this.fuel);
		compoundTag.putInt("MaxFuelTick", this.maxFuel);
		compoundTag.putInt("ProgressTick", this.progress);
		compoundTag.putInt("MaxProgressTick", this.maxProgress);
		return compoundTag;
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

	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pServerLevel, Vec3 pVec3) {
		var arrayList = new ArrayList<RecipeHolder<?>>();
		for (var entry : this.recipes.reference2IntEntrySet()) {
			pServerLevel.recipeAccess().byKey(entry.getKey()).ifPresent(
				(recipeHolder) -> {
					arrayList.add(recipeHolder);
					if (recipeHolder.value() instanceof GrindingRecipe grindingRecipe) {
						ExperienceOrb.award(pServerLevel, pVec3, Mth.ceil(entry.getIntValue() * grindingRecipe.experience()));
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
