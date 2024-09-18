package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.container.data.GrinderContainerData;
import com.axanthic.icaria.common.handler.stack.GrinderFuelItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderGearItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderInputItemStackHandler;
import com.axanthic.icaria.common.handler.stack.GrinderOutputItemStackHandler;
import com.axanthic.icaria.common.item.GearItem;
import com.axanthic.icaria.common.properties.Side;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.recipe.input.DoubleRecipeInput;
import com.axanthic.icaria.common.registry.*;

import com.google.common.collect.Lists;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlockEntity extends BlockEntity {
	public int lastSound = 6;
	public int fuel = 0;
	public int maxFuel = 0;
	public int progress = 0;
	public int maxProgress = 0;
	public int size = 6;

	public ItemStackHandler fuelHandler = new GrinderFuelItemStackHandler(1, this);
	public ItemStackHandler gearHandler = new GrinderGearItemStackHandler(1, this);
	public ItemStackHandler inputHandler = new GrinderInputItemStackHandler(1, this);
	public ItemStackHandler outputHandler = new GrinderOutputItemStackHandler(3, this);

	public Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

	public SimpleContainer simpleContainer = new SimpleContainer(this.size);

	public GrinderBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.GRINDER.get(), pPos, pState);
	}

	public boolean canInsertInSlot(SimpleContainer pContainer, GrindingRecipe pRecipe, int pSlot) {
		return (pContainer.getItem(pSlot).getItem() == pRecipe.getResultItem(null).getItem() || pContainer.getItem(pSlot).isEmpty()) && pContainer.getItem(pSlot).getCount() + pRecipe.getResultItem(null).getCount() <= 64;
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean hasRecipe() {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.gearHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(4, this.outputHandler.getStackInSlot(1));
		this.simpleContainer.setItem(5, this.outputHandler.getStackInSlot(2));

		Optional<RecipeHolder<GrindingRecipe>> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.GRINDING.get(), this.getRecipeInput(), this.level);
		}

		int burnTime = 0;
		if (recipe.isPresent()) {
			burnTime = recipe.get().value().getBurnTime();
		}

		if (this.maxProgress != burnTime) {
			this.maxProgress = burnTime;
		}

		return (recipe.isPresent() && this.canInsertInSlot(this.simpleContainer, recipe.get().value(), 3)) || (recipe.isPresent() && this.canInsertInSlot(this.simpleContainer, recipe.get().value(), 4)) || (recipe.isPresent() && this.canInsertInSlot(this.simpleContainer, recipe.get().value(), 5));
	}

	public boolean shouldBreak(GrinderBlockEntity pBlockEntity) {
		var itemStack = pBlockEntity.gearHandler.getStackInSlot(0);
		return itemStack.getMaxDamage() - itemStack.getDamageValue() <= 0;
	}

	public int getComparatorInput() {
		int i = (this.fuelHandler.getStackInSlot(0).getCount() * 15) / 64;
		int j = (this.gearHandler.getStackInSlot(0).getCount() * 15);
		int k = (this.inputHandler.getStackInSlot(0).getCount() * 15) / 64;
		int l = (this.outputHandler.getStackInSlot(0).getCount() * 15) / 64;
		int m = (this.outputHandler.getStackInSlot(1).getCount() * 15) / 64;
		int n = (this.outputHandler.getStackInSlot(2).getCount() * 15) / 64;
		return (i + j + k + l + m + n) / this.size;
	}

	public void awardUsedRecipesAndPopExperience(ServerPlayer pPlayer) {
		pPlayer.awardRecipes(this.getRecipesToAwardAndPopExperience(pPlayer.serverLevel(), pPlayer.position()));
		this.recipesUsed.clear();
	}

	public void craftItem() {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.gearHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(4, this.outputHandler.getStackInSlot(1));
		this.simpleContainer.setItem(5, this.outputHandler.getStackInSlot(2));

		Optional<RecipeHolder<GrindingRecipe>> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(IcariaRecipeTypes.GRINDING.get(), this.getRecipeInput(), this.level);
		}

		if (this.hasRecipe() && recipe.isPresent()) {
			this.inputHandler.extractItem(0, 1, false);
			if (this.canInsertInSlot(this.simpleContainer, recipe.get().value(), 5)) {
				this.outputHandler.setStackInSlot(2, new ItemStack(recipe.get().value().getResultItem(null).getItem(), recipe.get().value().getResultItem(null).getCount() + this.outputHandler.getStackInSlot(2).getCount()));
			} else if (this.canInsertInSlot(this.simpleContainer, recipe.get().value(), 4)) {
				this.outputHandler.setStackInSlot(1, new ItemStack(recipe.get().value().getResultItem(null).getItem(), recipe.get().value().getResultItem(null).getCount() + this.outputHandler.getStackInSlot(1).getCount()));
			} else if (this.canInsertInSlot(this.simpleContainer, recipe.get().value(), 3)) {
				this.outputHandler.setStackInSlot(0, new ItemStack(recipe.get().value().getResultItem(null).getItem(), recipe.get().value().getResultItem(null).getCount() + this.outputHandler.getStackInSlot(0).getCount()));
			}

			this.resetProgress();
			this.setRecipeUsed(recipe.get());
		}
	}

	public void createExperience(ServerLevel pLevel, Vec3 pPopVec, int pRecipeIndex, float pExperience) {
		float f = Mth.frac(pRecipeIndex * pExperience);
		int i = Mth.floor(pRecipeIndex * pExperience);
		if (f != 0.0F && Math.random() < f) {
			++i;
		}

		ExperienceOrb.award(pLevel, pPopVec, i);
	}

	public void drops(Level pLevel) {
		this.simpleContainer.setItem(0, this.fuelHandler.getStackInSlot(0));
		this.simpleContainer.setItem(1, this.gearHandler.getStackInSlot(0));
		this.simpleContainer.setItem(2, this.inputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(3, this.outputHandler.getStackInSlot(0));
		this.simpleContainer.setItem(4, this.outputHandler.getStackInSlot(1));
		this.simpleContainer.setItem(5, this.outputHandler.getStackInSlot(2));
		Containers.dropContents(pLevel, this.worldPosition, this.simpleContainer);
	}

	@Override
	public void loadAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pTag, pProvider);
		this.fuelHandler.deserializeNBT(pProvider, pTag.getCompound("FuelInventory"));
		this.gearHandler.deserializeNBT(pProvider, pTag.getCompound("GearInventory"));
		this.inputHandler.deserializeNBT(pProvider, pTag.getCompound("InputInventory"));
		this.outputHandler.deserializeNBT(pProvider, pTag.getCompound("OutputInventory"));
		this.fuel = pTag.getInt("CurrentFuelTime");
		this.maxFuel = pTag.getInt("TotalFuelTime");
		this.progress = pTag.getInt("CurrentProgressTime");
		this.maxProgress = pTag.getInt("TotalProgressTime");
		var compoundTag = pTag.getCompound("RecipesUsed");
		for (var string : compoundTag.getAllKeys()) {
			this.recipesUsed.put(ResourceLocation.parse(string), compoundTag.getInt(string));
		}
	}

	public void resetProgress() {
		this.progress = 0;
		this.maxProgress = 0;
	}

	@Override
	public void saveAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pTag, pProvider);
		pTag.put("FuelInventory", this.fuelHandler.serializeNBT(pProvider));
		pTag.put("GearInventory", this.gearHandler.serializeNBT(pProvider));
		pTag.put("InputInventory", this.inputHandler.serializeNBT(pProvider));
		pTag.put("OutputInventory", this.outputHandler.serializeNBT(pProvider));
		pTag.putInt("CurrentFuelTime", this.fuel);
		pTag.putInt("TotalFuelTime", this.maxFuel);
		pTag.putInt("CurrentProgressTime", this.progress);
		pTag.putInt("TotalProgressTime", this.maxProgress);
		var compoundTag = new CompoundTag();
		this.recipesUsed.forEach((resourceLocation, index) -> compoundTag.putInt(resourceLocation.toString(), index));
		pTag.put("RecipesUsed", compoundTag);
	}

	public void setRecipeUsed(RecipeHolder<?> pRecipe) {
		this.recipesUsed.addTo(pRecipe.id(), 1);
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GrinderBlockEntity pBlockEntity) {
		var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var fuelSlot = pBlockEntity.fuelHandler.getStackInSlot(0);
		var gearSlot = pBlockEntity.gearHandler.getStackInSlot(0);
		if (!pLevel.isClientSide()) {
			pBlockEntity.update(pPos, pState);
			if (!pBlockEntity.hasFuel()) {
				if (fuelSlot.getItem() == IcariaItems.SLIVER.get()) {
					int fuelTime = 800;
					pBlockEntity.fuelHandler.extractItem(0, 1, false);
					pBlockEntity.fuel = fuelTime;
					pBlockEntity.maxFuel = fuelTime;
				} else if (fuelSlot.getItem() == IcariaItems.SLIVER_BLOCK.get()) {
					int fuelTime = 7200;
					pBlockEntity.fuelHandler.extractItem(0, 1, false);
					pBlockEntity.fuel = fuelTime;
					pBlockEntity.maxFuel = fuelTime;
				}
			}

			if (pBlockEntity.hasFuel() && pBlockEntity.hasRecipe()) {
				if (IcariaConfig.GRINDER_SOUNDS.get()) {
					if (pBlockEntity.lastSound >= 6) {
						pBlockEntity.lastSound = 0;
						pLevel.playSound(null, pPos, IcariaSoundEvents.GRINDER_GRIND, SoundSource.BLOCKS);
					} else {
						pBlockEntity.lastSound++;
					}
				}

				if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
					pBlockEntity.craftItem();
					if (gearSlot.getItem() instanceof GearItem) {
						gearSlot.setDamageValue(gearSlot.getDamageValue() + 1);
						if (pBlockEntity.shouldBreak(pBlockEntity)) {
							pBlockEntity.gearHandler.extractItem(0, 1, false);
							pLevel.playSound(null, pPos, SoundEvents.ITEM_BREAK, SoundSource.BLOCKS);
						}
					}
				}

				pBlockEntity.progress++;
				pBlockEntity.fuel--;
				pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.SIDE, Side.LEFT).setValue(IcariaBlockStateProperties.GRINDER_GRINDING, true));
				pLevel.setBlockAndUpdate(pPos.offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.SIDE, Side.RIGHT).setValue(IcariaBlockStateProperties.GRINDER_GRINDING, true));
			} else {
				pBlockEntity.resetProgress();
				pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaBlockStateProperties.SIDE, Side.LEFT).setValue(IcariaBlockStateProperties.GRINDER_GRINDING, false));
				pLevel.setBlockAndUpdate(pPos.offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.SIDE, Side.RIGHT).setValue(IcariaBlockStateProperties.GRINDER_GRINDING, false));
			}
		}
	}

	public void update(BlockPos pPos, BlockState pState) {
		var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (this.getLevel() != null) {
			this.getLevel().sendBlockUpdated(pPos, pState, pState, 3);
			this.getLevel().updateNeighbourForOutputSignal(pPos.offset(facing.getCounterClockWise().getNormal()), pState.getBlock());
			this.setChanged();
		}
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = new CompoundTag();
		compoundTag.put("FuelInventory", this.fuelHandler.serializeNBT(pProvider));
		compoundTag.put("GearInventory", this.gearHandler.serializeNBT(pProvider));
		compoundTag.put("InputInventory", this.inputHandler.serializeNBT(pProvider));
		compoundTag.put("OutputInventory", this.outputHandler.serializeNBT(pProvider));
		compoundTag.putInt("CurrentFuelTime", this.fuel);
		compoundTag.putInt("TotalFuelTime", this.maxFuel);
		compoundTag.putInt("CurrentProgressTime", this.progress);
		compoundTag.putInt("TotalProgressTime", this.maxProgress);
		return compoundTag;
	}

	public ContainerData getData() {
		return new GrinderContainerData(this);
	}

	public static @Nullable IItemHandler getCapability(GrinderBlockEntity pBlockEntity, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return pBlockEntity.outputHandler;
		}

		return null;
	}

	public ItemStack getGear() {
		return this.gearHandler.getStackInSlot(0);
	}

	public List<RecipeHolder<?>> getRecipesToAwardAndPopExperience(ServerLevel pLevel, Vec3 pPopVec) {
		List<RecipeHolder<?>> list = Lists.newArrayList();
		for (var entry : this.recipesUsed.object2IntEntrySet()) {
			pLevel.getRecipeManager().byKey(entry.getKey()).ifPresent(
				(recipe) -> {
					list.add(recipe);
					if (recipe.value() instanceof GrindingRecipe firingRecipe) {
						this.createExperience(pLevel, pPopVec, entry.getIntValue(), firingRecipe.getExperience());
					}
				}
			);
		}

		return list;
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	public RecipeInput getRecipeInput() {
		return new DoubleRecipeInput(this.gearHandler.getStackInSlot(0), this.inputHandler.getStackInSlot(0));
	}
}
