package com.axanthic.icaria.common.block.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

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

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

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

	public IcariaChestBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
		super(pType, pPos, pBlockState);
	}

	public IcariaChestBlockEntity(BlockPos pPos, BlockState pState) {
		this(IcariaBlockEntityTypes.CHEST.get(), pPos, pState);
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
	public void loadAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pTag, pProvider);

		this.styleUp = pTag.getBoolean("StyleUp");
		this.styleNorth = pTag.getBoolean("StyleNorth");
		this.styleEast = pTag.getBoolean("StyleEast");
		this.styleSouth = pTag.getBoolean("StyleSouth");
		this.styleWest = pTag.getBoolean("StyleWest");

		this.waxed = pTag.getBoolean("Waxed");

		this.colorUp = pTag.getInt("ColorUp");
		this.colorNorth = pTag.getInt("ColorNorth");
		this.colorEast = pTag.getInt("ColorEast");
		this.colorSouth = pTag.getInt("ColorSouth");
		this.colorWest = pTag.getInt("ColorWest");

		if (pTag.contains("LabelUp")) {
			this.labelUp = pTag.getString("LabelUp");
		}

		if (pTag.contains("LabelNorth")) {
			this.labelNorth = pTag.getString("LabelNorth");
		}

		if (pTag.contains("LabelEast")) {
			this.labelEast = pTag.getString("LabelEast");
		}

		if (pTag.contains("LabelSouth")) {
			this.labelSouth = pTag.getString("LabelSouth");
		}

		if (pTag.contains("LabelWest")) {
			this.labelWest = pTag.getString("LabelWest");
		}

		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(pTag)) {
			ContainerHelper.loadAllItems(pTag, this.items, pProvider);
		}
	}

	@Override
	public void saveAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pTag, pProvider);

		pTag.putBoolean("StyleUp", this.styleUp);
		pTag.putBoolean("StyleNorth", this.styleNorth);
		pTag.putBoolean("StyleEast", this.styleEast);
		pTag.putBoolean("StyleSouth", this.styleSouth);
		pTag.putBoolean("StyleWest", this.styleWest);

		pTag.putBoolean("Waxed", this.waxed);

		pTag.putInt("ColorUp", this.colorUp);
		pTag.putInt("ColorNorth", this.colorNorth);
		pTag.putInt("ColorEast", this.colorEast);
		pTag.putInt("ColorSouth", this.colorSouth);
		pTag.putInt("ColorWest", this.colorWest);

		if (this.labelUp != null) {
			pTag.putString("LabelUp", this.labelUp);
		}

		if (this.labelNorth != null) {
			pTag.putString("LabelNorth", this.labelNorth);
		}

		if (this.labelEast != null) {
			pTag.putString("LabelEast", this.labelEast);
		}

		if (this.labelSouth != null) {
			pTag.putString("LabelSouth", this.labelSouth);
		}

		if (this.labelWest != null) {
			pTag.putString("LabelWest", this.labelWest);
		}

		if (!this.trySaveLootTable(pTag)) {
			ContainerHelper.saveAllItems(pTag, this.items, pProvider);
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
	public void setItems(NonNullList<ItemStack> pItems) {
		this.items = pItems;
	}

	@Override
	public AbstractContainerMenu createMenu(int pId, Inventory pPlayer) {
		return new ChestMenu(MenuType.GENERIC_9x2, pId, pPlayer, this, 2);
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

	public String getLabelUp() {
		return this.labelUp;
	}

	public String getLabelNorth() {
		return this.labelNorth;
	}

	public String getLabelEast() {
		return this.labelEast;
	}

	public String getLabelSouth() {
		return this.labelSouth;
	}

	public String getLabelWest() {
		return this.labelWest;
	}
}
