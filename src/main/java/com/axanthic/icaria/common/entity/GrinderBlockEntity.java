package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.GrinderBlock;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.item.GearItem;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaSounds;

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

	public ContainerData data = new ContainerData() {
		@Override
		public int get(int pIndex) {
			return switch (pIndex) {
				default -> 0;
				case 0 -> GrinderBlockEntity.this.maxFuel;
				case 1 -> GrinderBlockEntity.this.fuel;
				case 2 -> GrinderBlockEntity.this.maxProgress;
				case 3 -> GrinderBlockEntity.this.progress;
			};
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public void set(int pIndex, int pValue) {
			switch (pIndex) {
				case 0 -> GrinderBlockEntity.this.maxFuel = pValue;
				case 1 -> GrinderBlockEntity.this.fuel = pValue;
				case 2 -> GrinderBlockEntity.this.maxProgress = pValue;
				case 3 -> GrinderBlockEntity.this.progress = pValue;
			}
		}
	};

	public ItemStackHandler itemStackHandler = createHandler();
	public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> itemStackHandler);
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
		SimpleContainer inputs = new SimpleContainer(3);
		inputs.setItem(0, this.itemStackHandler.getStackInSlot(0));
		inputs.setItem(1, this.itemStackHandler.getStackInSlot(1));
		inputs.setItem(2, this.itemStackHandler.getStackInSlot(2));

		SimpleContainer outputs = new SimpleContainer(3);
		outputs.setItem(0, this.itemStackHandler.getStackInSlot(3));
		outputs.setItem(1, this.itemStackHandler.getStackInSlot(4));
		outputs.setItem(2, this.itemStackHandler.getStackInSlot(5));

		Optional<GrindingRecipe> recipe = Optional.empty();
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(GrindingRecipe.Type.INSTANCE, inputs, this.level);
		}

		int burnTime = 0;
		boolean canOutput = false;
		if (recipe.isPresent()) {
			burnTime = recipe.get().getBurnTime();
			canOutput = this.canOutput(outputs, recipe.get().getResultItem());
		}

		if (canOutput) {
			if (this.maxProgress != burnTime) {
				this.maxProgress = burnTime;
			}
		}

		return canOutput;
	}

	public boolean shouldBreak(GrinderBlockEntity pBlockEntity) {
		ItemStack itemStack = pBlockEntity.itemStackHandler.getStackInSlot(2);
		return itemStack.getMaxDamage() - itemStack.getDamageValue() <= 0;
	}

	public void craftItem() {
		SimpleContainer inputs = new SimpleContainer(3);
		inputs.setItem(0, this.itemStackHandler.getStackInSlot(0));
		inputs.setItem(1, this.itemStackHandler.getStackInSlot(1));
		inputs.setItem(2, this.itemStackHandler.getStackInSlot(2));

		Optional<GrindingRecipe> recipe;
		ItemStack output = ItemStack.EMPTY;
		if (this.level != null) {
			recipe = this.level.getRecipeManager().getRecipeFor(GrindingRecipe.Type.INSTANCE, inputs, this.level);
			if (recipe.isPresent()) {
				output = recipe.get().getResultItem();
			}

			if (this.hasRecipe()) {
				this.itemStackHandler.extractItem(0, 1, false);
				if (!output.isEmpty()) {
					output = this.itemStackHandler.insertItem(3, output, false);
				}

				if (!output.isEmpty()) {
					output = this.itemStackHandler.insertItem(4, output, false);
				}

				if (!output.isEmpty()) {
					output = this.itemStackHandler.insertItem(5, output, false);
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
			this.itemStackHandler.deserializeNBT(pTag.getCompound("Inventory"));
			this.maxFuel = pTag.getInt("TotalFuelTime");
			this.fuel = pTag.getInt("CurrentFuelTime");
			this.maxProgress = pTag.getInt("TotalProgressTime");
			this.progress = pTag.getInt("CurrentProgressTime");
			CompoundTag compoundTag = pTag.getCompound("RecipesUsed");
			for (String key : compoundTag.getAllKeys()) {
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
		pTag.put("Inventory", this.itemStackHandler.serializeNBT());
		pTag.putInt("TotalFuelTime", this.maxFuel);
		pTag.putInt("CurrentFuelTime", this.fuel);
		pTag.putInt("TotalProgressTime", this.maxProgress);
		pTag.putInt("CurrentProgressTime", this.progress);
		CompoundTag compoundTag = new CompoundTag();
		this.usedRecipes.forEach((pKey, pCount) -> compoundTag.putInt(pKey.toString(), pCount));
		pTag.put("RecipesUsed", compoundTag);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		this.itemHandler.invalidate();
	}

	public static void tick(Level pLevel, BlockPos pPos, BlockState pState, GrinderBlockEntity pBlockEntity) {
		ItemStackHandler itemStackHandler = pBlockEntity.itemStackHandler;
		ItemStack fuelSlot = itemStackHandler.getStackInSlot(1);
		ItemStack gearSlot = itemStackHandler.getStackInSlot(2);
		if (pLevel.isClientSide) {
			return;
		}

		if (!pBlockEntity.hasFuel()) {
			if (fuelSlot.getItem() == IcariaItems.SLIVER.get()) {
				int fuelTime = 800;
				pBlockEntity.itemStackHandler.extractItem(1, 1, false);
				pBlockEntity.fuel = fuelTime;
				pBlockEntity.maxFuel = fuelTime;
				pBlockEntity.setChanged();
			} else if (fuelSlot.getItem() == IcariaItems.SLIVER_BLOCK.get()) {
				int fuelTime = 7200;
				pBlockEntity.itemStackHandler.extractItem(1, 1, false);
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

			if (IcariaConfig.SOUND_GRINDER.get()) {
				if (pBlockEntity.lastSound >= 6) {
					pBlockEntity.lastSound = 0;
					pLevel.playSound(null, pPos, IcariaSounds.GRINDER_GRIND, SoundSource.BLOCKS, IcariaConfig.SOUND_VOLUME_GRINDER.get().floatValue(), 1.0F);
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
			pLevel.setBlock(pPos, pState.setValue(GrinderBlock.GRINDING, true).setValue(GrinderBlock.ROTATION, pBlockEntity.rotation), 3);
		} else {
			pBlockEntity.resetProgress();
			pBlockEntity.setChanged();
			pLevel.setBlock(pPos, pState.setValue(GrinderBlock.GRINDING, false), 3);
		}
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag compoundTag = new CompoundTag();
		compoundTag.put("Inventory", this.itemStackHandler.serializeNBT());
		compoundTag.putInt("TotalFuelTime", this.maxFuel);
		compoundTag.putInt("CurrentFuelTime", this.fuel);
		compoundTag.putInt("TotalProgressTime", this.maxProgress);
		compoundTag.putInt("CurrentProgressTime", this.progress);
		return compoundTag;
	}

	public ContainerData getData() {
		return this.data;
	}

	public ItemStack getGear() {
		return this.itemStackHandler.getStackInSlot(2);
	}

	public ItemStackHandler createHandler() {
		return new ItemStackHandler(6) {
			@Override
			public void onContentsChanged(int slot) {
				setChanged();
			}
		};
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
