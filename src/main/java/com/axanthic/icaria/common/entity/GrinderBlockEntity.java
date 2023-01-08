package com.axanthic.icaria.common.entity;

import java.util.Optional;

import com.axanthic.icaria.common.recipe.GrinderRecipe;
import com.axanthic.icaria.common.registry.IcariaBlockEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
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
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.ItemStackHandler;

public class GrinderBlockEntity extends BlockEntity {
	public ItemStackHandler itemStackHandler = createHandler();
	public LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> itemStackHandler);

	protected final ContainerData data;

	protected int totalFuelTime = 0;
	protected int currentFuelTime = 0;

	protected int totalProgressTime = 0;
	protected int currentProgressTime = 0;

	public GrinderBlockEntity(BlockPos pPos, BlockState pBlockState) {
		super(IcariaBlockEntities.GRINDER.get(), pPos, pBlockState);

		this.data = new ContainerData() {

			@Override
			public void set(int pIndex, int pValue) {
				switch (pIndex) {
				case 0 -> GrinderBlockEntity.this.totalFuelTime = pValue;
				case 1 -> GrinderBlockEntity.this.currentFuelTime = pValue;
				case 2 -> GrinderBlockEntity.this.totalProgressTime = pValue;
				case 3 -> GrinderBlockEntity.this.currentProgressTime = pValue;
				}

			}

			@Override
			public int getCount() {
				return 4;
			}

			@Override
			public int get(int pIndex) {
				return switch (pIndex) {
				case 0 -> GrinderBlockEntity.this.totalFuelTime;
				case 1 -> GrinderBlockEntity.this.currentFuelTime;
				case 2 -> GrinderBlockEntity.this.totalProgressTime;
				case 3 -> GrinderBlockEntity.this.currentProgressTime;
				default -> 0;
				};
			}
		};
	}

	public int getComparatorInput() {
		return itemHandler.map(ItemHandlerHelper::calcRedstoneFromInventory).orElse(0);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
	
	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag compoundTag = new CompoundTag();
		compoundTag.put("Inventory", itemStackHandler.serializeNBT());
		compoundTag.putInt("TotalFuelTime", totalFuelTime);
		compoundTag.putInt("CurrentFuelTime", currentFuelTime);
		compoundTag.putInt("TotalProgressTime", totalProgressTime);
		compoundTag.putInt("CurrentProgressTime", currentProgressTime);
		return compoundTag;
	}

	@Override
	public void load(CompoundTag pTag) {
		if (pTag.contains("Inventory")) {
			itemStackHandler.deserializeNBT(pTag.getCompound("Inventory"));
			totalFuelTime = pTag.getInt("TotalFuelTime");
			currentFuelTime = pTag.getInt("CurrentFuelTime");
			totalProgressTime = pTag.getInt("TotalProgressTime");
			currentProgressTime = pTag.getInt("CurrentProgressTime");
		}

		super.load(pTag);
	}

	@Override
	public void saveAdditional(CompoundTag pTag) {
		pTag.put("Inventory", itemStackHandler.serializeNBT());
		pTag.putInt("TotalFuelTime", totalFuelTime);
		pTag.putInt("CurrentFuelTime", currentFuelTime);
		pTag.putInt("TotalProgressTime", totalProgressTime);
		pTag.putInt("CurrentProgressTime", currentProgressTime);
	}

	public ItemStack getGear() {
		return itemStackHandler.getStackInSlot(2);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		itemHandler.invalidate();
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
	public <T> LazyOptional<T> getCapability(Capability<T> capability, Direction direction) {
		if (capability == ForgeCapabilities.ITEM_HANDLER) {
			return itemHandler.cast();
		}

		return super.getCapability(capability, direction);
	}

	private void resetProgress() {
		this.currentProgressTime = 0;
		this.totalProgressTime = 0;
	}

	public static void tick(Level level, BlockPos pos, BlockState state, GrinderBlockEntity pEntity) {		
		if (level.isClientSide()) {
			return;
		}

		if (!pEntity.hasFuel()) {
			ItemStack fuel = pEntity.itemStackHandler.getStackInSlot(1);
			if (fuel.getItem() == IcariaItems.SLIVER.get()) {
				int fuelTime = 800;

				pEntity.itemStackHandler.extractItem(1, 1, false);

				pEntity.currentFuelTime = fuelTime;
				pEntity.totalFuelTime = fuelTime;
				pEntity.setChanged();
			} else if (fuel.getItem() == IcariaItems.SLIVER_BLOCK.get()) {
				int fuelTime = 7200;

				pEntity.itemStackHandler.extractItem(1, 1, false);

				pEntity.currentFuelTime = fuelTime;
				pEntity.totalFuelTime = fuelTime;
				pEntity.setChanged();
			}
		}

		if (hasRecipe(pEntity) && pEntity.hasFuel()) {
			pEntity.currentProgressTime++;
			pEntity.currentFuelTime--;
			pEntity.setChanged();

			if (pEntity.currentProgressTime >= pEntity.totalProgressTime) {
				craftItem(pEntity);
				pEntity.setChanged();
			}
		} else {
			pEntity.resetProgress();
			pEntity.setChanged();
		}
	}

	private static void craftItem(GrinderBlockEntity pEntity) {

		Level level = pEntity.level;
		SimpleContainer inventory = new SimpleContainer(3);
		inventory.setItem(0, pEntity.itemStackHandler.getStackInSlot(0));
		inventory.setItem(1, pEntity.itemStackHandler.getStackInSlot(1));
		inventory.setItem(2, pEntity.itemStackHandler.getStackInSlot(2));

		Optional<GrinderRecipe> recipe = level.getRecipeManager()
				.getRecipeFor(GrinderRecipe.Type.INSTANCE, inventory, level);

		ItemStack output = recipe.get().getResultItem();

		if (hasRecipe(pEntity)) {
			pEntity.itemStackHandler.extractItem(0, 1, false);

			ItemStack left = pEntity.itemStackHandler.insertItem(3, output, false);
			if (!left.isEmpty())
				left = pEntity.itemStackHandler.insertItem(4, left, false);
			if (!left.isEmpty())
				left = pEntity.itemStackHandler.insertItem(5, left, false);
			if (!left.isEmpty())
				Containers.dropItemStack(level, pEntity.getBlockPos().getX(), pEntity.getBlockPos().getY(),
						pEntity.getBlockPos().getZ(), left);

			pEntity.resetProgress();
		}
	}

	private static boolean hasRecipe(GrinderBlockEntity pEntity) {

		Level level = pEntity.level;
		SimpleContainer inventory = new SimpleContainer(3);
		inventory.setItem(0, pEntity.itemStackHandler.getStackInSlot(0));
		inventory.setItem(1, pEntity.itemStackHandler.getStackInSlot(1));
		inventory.setItem(2, pEntity.itemStackHandler.getStackInSlot(2));

		SimpleContainer outPutInventory = new SimpleContainer(3);
		outPutInventory.setItem(0, pEntity.itemStackHandler.getStackInSlot(3));
		outPutInventory.setItem(1, pEntity.itemStackHandler.getStackInSlot(4));
		outPutInventory.setItem(1, pEntity.itemStackHandler.getStackInSlot(5));

		Optional<GrinderRecipe> recipe = level.getRecipeManager()
				.getRecipeFor(GrinderRecipe.Type.INSTANCE, inventory, level);

		boolean flag = recipe.isPresent() && canOutput(outPutInventory, recipe.get().getResultItem());

		if (flag) {
			if (pEntity.totalProgressTime != recipe.get().getBurnTime()) {
				pEntity.totalProgressTime = recipe.get().getBurnTime();
			}
		}

		return flag;
	}

	public ContainerData getData() {
		return data;
	}

	public boolean hasFuel() {
		return this.currentFuelTime > 0;
	}

	public boolean isGrinding() {
		return this.currentProgressTime > 0;
	}

	private static boolean canOutput(SimpleContainer output, ItemStack stack) {
		return output.canAddItem(stack);
	}
}
