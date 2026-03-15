package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestBlockEntity extends ChestBlockEntity {
	public boolean styleUp;
	public boolean styleNorth;
	public boolean styleEast;
	public boolean styleSouth;
	public boolean styleWest;

	public boolean waxed;

	public int colorUp;
	public int colorNorth;
	public int colorEast;
	public int colorSouth;
	public int colorWest;

	public NonNullList<ItemStack> items = NonNullList.withSize(18, ItemStack.EMPTY);

	public String labelUp;
	public String labelNorth;
	public String labelEast;
	public String labelSouth;
	public String labelWest;

	public IcariaChestBlockEntity(BlockEntityType<?> pBlockEntityType, BlockPos pBlockPos, BlockState pBlockState) {
		super(pBlockEntityType, pBlockPos, pBlockState);
	}

	public IcariaChestBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		this(IcariaBlockEntityTypes.CHEST.get(), pBlockPos, pBlockState);
	}

	@Override
	public int getContainerSize() {
		return 18;
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.styleUp = pValueInput.getBooleanOr("StyleUp", false);
		this.styleNorth = pValueInput.getBooleanOr("StyleNorth", false);
		this.styleEast = pValueInput.getBooleanOr("StyleEast", false);
		this.styleSouth = pValueInput.getBooleanOr("StyleSouth", false);
		this.styleWest = pValueInput.getBooleanOr("StyleWest", false);
		this.waxed = pValueInput.getBooleanOr("Waxed", false);
		this.colorUp = pValueInput.getIntOr("ColorUp", 0);
		this.colorNorth = pValueInput.getIntOr("ColorNorth", 0);
		this.colorEast = pValueInput.getIntOr("ColorEast", 0);
		this.colorSouth = pValueInput.getIntOr("ColorSouth", 0);
		this.colorWest = pValueInput.getIntOr("ColorWest", 0);
		this.labelUp = pValueInput.getStringOr("LabelUp", "");
		this.labelNorth = pValueInput.getStringOr("LabelNorth", "");
		this.labelEast = pValueInput.getStringOr("LabelEast", "");
		this.labelSouth = pValueInput.getStringOr("LabelSouth", "");
		this.labelWest = pValueInput.getStringOr("LabelWest", "");
		if (!this.tryLoadLootTable(pValueInput)) {
			ContainerHelper.loadAllItems(pValueInput, this.items);
		}
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		pValueOutput.putBoolean("StyleUp", this.styleUp);
		pValueOutput.putBoolean("StyleNorth", this.styleNorth);
		pValueOutput.putBoolean("StyleEast", this.styleEast);
		pValueOutput.putBoolean("StyleSouth", this.styleSouth);
		pValueOutput.putBoolean("StyleWest", this.styleWest);
		pValueOutput.putBoolean("Waxed", this.waxed);
		pValueOutput.putInt("ColorUp", this.colorUp);
		pValueOutput.putInt("ColorNorth", this.colorNorth);
		pValueOutput.putInt("ColorEast", this.colorEast);
		pValueOutput.putInt("ColorSouth", this.colorSouth);
		pValueOutput.putInt("ColorWest", this.colorWest);
		this.saveString(pValueOutput, "LabelUp", this.labelUp);
		this.saveString(pValueOutput, "LabelNorth", this.labelNorth);
		this.saveString(pValueOutput, "LabelEast", this.labelEast);
		this.saveString(pValueOutput, "LabelSouth", this.labelSouth);
		this.saveString(pValueOutput, "LabelWest", this.labelWest);
		if (!this.trySaveLootTable(pValueOutput)) {
			ContainerHelper.saveAllItems(pValueOutput, this.items);
		}
	}

	public void saveString(ValueOutput pValueOutput, String pName, @Nullable String pString) {
		if (pString != null) {
			pValueOutput.putString(pName, pString);
		}
	}

	@Override
	public void setItems(NonNullList<ItemStack> pItemStacks) {
		this.items = pItemStacks;
	}

	public boolean getStyleUp() {
		return this.styleUp;
	}

	public boolean getStyleNorth() {
		return this.styleNorth;
	}

	public boolean getStyleEast() {
		return this.styleEast;
	}

	public boolean getStyleSouth() {
		return this.styleSouth;
	}

	public boolean getStyleWest() {
		return this.styleWest;
	}

	public boolean getWaxed() {
		return this.waxed;
	}

	public int getColorUp() {
		return this.colorUp;
	}

	public int getColorNorth() {
		return this.colorNorth;
	}

	public int getColorEast() {
		return this.colorEast;
	}

	public int getColorSouth() {
		return this.colorSouth;
	}

	public int getColorWest() {
		return this.colorWest;
	}

	@Nullable
	public String getLabelUp() {
		return this.labelUp;
	}

	@Nullable
	public String getLabelNorth() {
		return this.labelNorth;
	}

	@Nullable
	public String getLabelEast() {
		return this.labelEast;
	}

	@Nullable
	public String getLabelSouth() {
		return this.labelSouth;
	}

	@Nullable
	public String getLabelWest() {
		return this.labelWest;
	}

	public void setStyleUp(boolean pBold) {
		this.styleUp = pBold;
	}

	public void setStyleNorth(boolean pBold) {
		this.styleNorth = pBold;
	}

	public void setStyleEast(boolean pBold) {
		this.styleEast = pBold;
	}

	public void setStyleSouth(boolean pBold) {
		this.styleSouth = pBold;
	}

	public void setStyleWest(boolean pBold) {
		this.styleWest = pBold;
	}

	public void setWaxed(boolean pWaxed) {
		this.waxed = pWaxed;
	}

	public void setColorUp(int pColor) {
		this.colorUp = pColor;
	}

	public void setColorNorth(int pColor) {
		this.colorNorth = pColor;
	}

	public void setColorEast(int pColor) {
		this.colorEast = pColor;
	}

	public void setColorSouth(int pColor) {
		this.colorSouth = pColor;
	}

	public void setColorWest(int pColor) {
		this.colorWest = pColor;
	}

	public void setLabelUp(@Nullable String pName) {
		this.labelUp = pName;
	}

	public void setLabelNorth(@Nullable String pName) {
		this.labelNorth = pName;
	}

	public void setLabelEast(@Nullable String pName) {
		this.labelEast = pName;
	}

	public void setLabelSouth(@Nullable String pName) {
		this.labelSouth = pName;
	}

	public void setLabelWest(@Nullable String pName) {
		this.labelWest = pName;
	}

	@Override
	public AbstractContainerMenu createMenu(int pId, Inventory pInventory) {
		return new ChestMenu(MenuType.GENERIC_9x2, pId, pInventory, this, 2);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		return this.saveWithoutMetadata(pProvider);
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.items;
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
}
