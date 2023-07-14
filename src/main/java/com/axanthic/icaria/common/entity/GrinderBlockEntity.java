package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.item.GearItem;
import com.axanthic.icaria.common.util.GrinderContainerData;
import com.axanthic.icaria.common.menu.GrinderItemStackHandler;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.recipe.GrindingRecipeType;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlockEntity extends BlockEntity {
	public int lastSound = 6;
	public int maxFuel = 0;
	public int fuel = 0;
	public int maxProgress = 0;
	public int progress = 0;
	public int rotation = 0;

	public ItemStackHandler stackHandler = this.createHandler();

	public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> this.stackHandler);

	public Object2IntOpenHashMap<ResourceLocation> usedRecipes = new Object2IntOpenHashMap<>();

	public GrinderBlockEntity(BlockPos pPos, BlockState pState) {
		super(IcariaBlockEntityTypes.GRINDER.get(), pPos, pState);
	}

	public boolean canOutput(SimpleContainer pContainer, ItemStack pStack) {
		return pContainer.canAddItem(pStack);
	}

	public boolean hasFuel() {
		return this.fuel > 0;
	}

	public boolean hasRecipe() {
		var inputs = new SimpleContainer(3);
		inputs.setItem(0, this.stackHandler.getStackInSlot(0));
		inputs.setItem(1, this.stackHandler.getStackInSlot(1));
		inputs.setItem(2, this.stackHandler.getStackInSlot(2));

		var outputs = new SimpleContainer(3);
		outputs.setItem(0, this.stackHandler.getStackInSlot(3));
		outputs.setItem(1, this.stackHandler.getStackInSlot(4));
		outputs.setItem(2, this.stackHandler.getStackInSlot(5));

		Optional<GrindingRecipe> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(GrindingRecipeType.INSTANCE, inputs, this.level);
		}

		int burnTime = 0;
		boolean canOutput = false;
		if (recipe.isPresent()) {
			burnTime = recipe.get().getBurnTime();
			canOutput = this.canOutput(outputs, recipe.get().result.copy());
		}

		if (canOutput) {
			if (this.maxProgress != burnTime) {
				this.maxProgress = burnTime;
			}
		}

		return canOutput;
	}

	public boolean shouldBreak(GrinderBlockEntity pBlockEntity) {
		var itemStack = pBlockEntity.stackHandler.getStackInSlot(2);
		return itemStack.getMaxDamage() - itemStack.getDamageValue() <= 0;
	}

	public void craftItem() {
		var inputs = new SimpleContainer(3);
		inputs.setItem(0, this.stackHandler.getStackInSlot(0));
		inputs.setItem(1, this.stackHandler.getStackInSlot(1));
		inputs.setItem(2, this.stackHandler.getStackInSlot(2));

		Optional<GrindingRecipe> recipe;
		var output = ItemStack.EMPTY;
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(GrindingRecipeType.INSTANCE, inputs, this.level);
			if (recipe.isPresent()) {
				output = recipe.get().result.copy();
			}

			if (this.hasRecipe()) {
				this.stackHandler.extractItem(0, 1, false);
				if (!output.isEmpty()) {
					output = this.stackHandler.insertItem(3, output, false);
				}

				if (!output.isEmpty()) {
					output = this.stackHandler.insertItem(4, output, false);
				}

				if (!output.isEmpty()) {
					output = this.stackHandler.insertItem(5, output, false);
				}

				if (!output.isEmpty()) {
					Containers.dropItemStack(this.level, this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(), output);
				}

				this.resetProgress();
			}
		}
	}

	@Override
	public void load(CompoundTag pTag) {
		super.load(pTag);
		if (pTag.contains("Inventory")) {
			this.stackHandler.deserializeNBT(pTag.getCompound("Inventory"));
			this.maxFuel = pTag.getInt("TotalFuelTime");
			this.fuel = pTag.getInt("CurrentFuelTime");
			this.maxProgress = pTag.getInt("TotalProgressTime");
			this.progress = pTag.getInt("CurrentProgressTime");
			var compoundTag = pTag.getCompound("RecipesUsed");
			for (var key : compoundTag.getAllKeys()) {
				this.usedRecipes.put(new ResourceLocation(key), compoundTag.getInt(key));
			}
		}
	}

	public void resetProgress() {
		this.progress = 0;
		this.maxProgress = 0;
	}

	@Override
	public void saveAdditional(CompoundTag pTag) {
		super.saveAdditional(pTag);
		pTag.put("Inventory", this.stackHandler.serializeNBT());
		pTag.putInt("TotalFuelTime", this.maxFuel);
		pTag.putInt("CurrentFuelTime", this.fuel);
		pTag.putInt("TotalProgressTime", this.maxProgress);
		pTag.putInt("CurrentProgressTime", this.progress);
		var compoundTag = new CompoundTag();
		this.usedRecipes.forEach((pKey, pCount) -> compoundTag.putInt(pKey.toString(), pCount));
		pTag.put("RecipesUsed", compoundTag);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		this.itemHandler.invalidate();
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GrinderBlockEntity pBlockEntity) {
		var itemStackHandler = pBlockEntity.stackHandler;
		var fuelSlot = itemStackHandler.getStackInSlot(1);
		var gearSlot = itemStackHandler.getStackInSlot(2);
		if (pLevel.isClientSide) {
			return;
		}

		if (!pBlockEntity.hasFuel()) {
			if (fuelSlot.getItem() == IcariaItems.SLIVER.get()) {
				int fuelTime = 800;
				pBlockEntity.stackHandler.extractItem(1, 1, false);
				pBlockEntity.fuel = fuelTime;
				pBlockEntity.maxFuel = fuelTime;
				pBlockEntity.setChanged();
			} else if (fuelSlot.getItem() == IcariaItems.SLIVER_BLOCK.get()) {
				int fuelTime = 7200;
				pBlockEntity.stackHandler.extractItem(1, 1, false);
				pBlockEntity.fuel = fuelTime;
				pBlockEntity.maxFuel = fuelTime;
				pBlockEntity.setChanged();
			}
		}

		if (pBlockEntity.hasFuel() && pBlockEntity.hasRecipe()) {
			if (pBlockEntity.rotation >= 90) {
				pBlockEntity.rotation = 0;
			} else {
				pBlockEntity.rotation++;
			}

			if (IcariaConfig.GRINDER_SOUNDS.get()) {
				if (pBlockEntity.lastSound >= 6) {
					pBlockEntity.lastSound = 0;
					pLevel.playSound(null, pPos, IcariaSoundEvents.GRINDER_GRIND, SoundSource.BLOCKS, 1.0F, 1.0F);
				} else {
					pBlockEntity.lastSound++;
				}
			}

			if (pBlockEntity.progress >= pBlockEntity.maxProgress) {
				pBlockEntity.craftItem();
				pBlockEntity.setChanged();
				if (gearSlot.getItem() instanceof GearItem) {
					gearSlot.hurt(1, RandomSource.create(), null);
					pBlockEntity.setChanged();
					if (pBlockEntity.shouldBreak(pBlockEntity)) {
						itemStackHandler.extractItem(2, 1, false);
						pBlockEntity.setChanged();
					}
				}
			}

			pBlockEntity.progress++;
			pBlockEntity.fuel--;
			pBlockEntity.setChanged();
			pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.GRINDING, true).setValue(IcariaBlockStateProperties.GRINDER_ROTATION, pBlockEntity.rotation), 3);
		} else {
			pBlockEntity.resetProgress();
			pBlockEntity.setChanged();
			pLevel.setBlock(pPos, pState.setValue(IcariaBlockStateProperties.GRINDING, false), 3);
		}
	}

	@Override
	public CompoundTag getUpdateTag() {
		var compoundTag = new CompoundTag();
		compoundTag.put("Inventory", this.stackHandler.serializeNBT());
		compoundTag.putInt("TotalFuelTime", this.maxFuel);
		compoundTag.putInt("CurrentFuelTime", this.fuel);
		compoundTag.putInt("TotalProgressTime", this.maxProgress);
		compoundTag.putInt("CurrentProgressTime", this.progress);
		return compoundTag;
	}

	public ContainerData getData() {
		return new GrinderContainerData(this);
	}

	public ItemStack getGear() {
		return this.stackHandler.getStackInSlot(2);
	}

	public ItemStackHandler createHandler() {
		return new GrinderItemStackHandler(this, 6);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public <T> @Nonnull LazyOptional<T> getCapability(Capability<T> pCapability, @Nullable Direction pDirection) {
		return pCapability == ForgeCapabilities.ITEM_HANDLER ? this.itemHandler.cast() : super.getCapability(pCapability, pDirection);
	}
}
