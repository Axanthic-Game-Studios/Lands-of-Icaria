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

	public String labelUp;
	public String labelNorth;
	public String labelEast;
	public String labelSouth;
	public String labelWest;

	public NonNullList<ItemStack> items = NonNullList.withSize(18, ItemStack.EMPTY);

	public IcariaChestBlockEntity(BlockEntityType<?> pBlockEntityType, BlockPos pBlockPos, BlockState pBlockState) {
		super(pBlockEntityType, pBlockPos, pBlockState);
	}

	public IcariaChestBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		this(IcariaBlockEntityTypes.CHEST.get(), pBlockPos, pBlockState);
	}

	public boolean hasLabelUp() {
		return this.getLabelUp() != null;
	}

	public boolean hasLabelNorth() {
		return this.getLabelNorth() != null;
	}

	public boolean hasLabelEast() {
		return this.getLabelEast() != null;
	}

	public boolean hasLabelSouth() {
		return this.getLabelSouth() != null;
	}

	public boolean hasLabelWest() {
		return this.getLabelWest() != null;
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

	@Override
	public int getContainerSize() {
		return 18;
	}

	@Override
	public void loadAdditional(CompoundTag pCompoundTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pCompoundTag, pProvider);

		this.styleUp = pCompoundTag.getBoolean("StyleUp");
		this.styleNorth = pCompoundTag.getBoolean("StyleNorth");
		this.styleEast = pCompoundTag.getBoolean("StyleEast");
		this.styleSouth = pCompoundTag.getBoolean("StyleSouth");
		this.styleWest = pCompoundTag.getBoolean("StyleWest");

		this.waxed = pCompoundTag.getBoolean("Waxed");

		this.colorUp = pCompoundTag.getInt("ColorUp");
		this.colorNorth = pCompoundTag.getInt("ColorNorth");
		this.colorEast = pCompoundTag.getInt("ColorEast");
		this.colorSouth = pCompoundTag.getInt("ColorSouth");
		this.colorWest = pCompoundTag.getInt("ColorWest");

		if (pCompoundTag.contains("LabelUp")) {
			this.labelUp = pCompoundTag.getString("LabelUp");
		}

		if (pCompoundTag.contains("LabelNorth")) {
			this.labelNorth = pCompoundTag.getString("LabelNorth");
		}

		if (pCompoundTag.contains("LabelEast")) {
			this.labelEast = pCompoundTag.getString("LabelEast");
		}

		if (pCompoundTag.contains("LabelSouth")) {
			this.labelSouth = pCompoundTag.getString("LabelSouth");
		}

		if (pCompoundTag.contains("LabelWest")) {
			this.labelWest = pCompoundTag.getString("LabelWest");
		}

		if (!this.tryLoadLootTable(pCompoundTag)) {
			ContainerHelper.loadAllItems(pCompoundTag, this.items, pProvider);
		}
	}

	@Override
	public void saveAdditional(CompoundTag pCompoundTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pCompoundTag, pProvider);

		pCompoundTag.putBoolean("StyleUp", this.styleUp);
		pCompoundTag.putBoolean("StyleNorth", this.styleNorth);
		pCompoundTag.putBoolean("StyleEast", this.styleEast);
		pCompoundTag.putBoolean("StyleSouth", this.styleSouth);
		pCompoundTag.putBoolean("StyleWest", this.styleWest);

		pCompoundTag.putBoolean("Waxed", this.waxed);

		pCompoundTag.putInt("ColorUp", this.colorUp);
		pCompoundTag.putInt("ColorNorth", this.colorNorth);
		pCompoundTag.putInt("ColorEast", this.colorEast);
		pCompoundTag.putInt("ColorSouth", this.colorSouth);
		pCompoundTag.putInt("ColorWest", this.colorWest);

		if (this.labelUp != null) {
			pCompoundTag.putString("LabelUp", this.labelUp);
		}

		if (this.labelNorth != null) {
			pCompoundTag.putString("LabelNorth", this.labelNorth);
		}

		if (this.labelEast != null) {
			pCompoundTag.putString("LabelEast", this.labelEast);
		}

		if (this.labelSouth != null) {
			pCompoundTag.putString("LabelSouth", this.labelSouth);
		}

		if (this.labelWest != null) {
			pCompoundTag.putString("LabelWest", this.labelWest);
		}

		if (!this.trySaveLootTable(pCompoundTag)) {
			ContainerHelper.saveAllItems(pCompoundTag, this.items, pProvider);
		}
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
	public void setItems(NonNullList<ItemStack> pItemStacks) {
		this.items = pItemStacks;
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
}
