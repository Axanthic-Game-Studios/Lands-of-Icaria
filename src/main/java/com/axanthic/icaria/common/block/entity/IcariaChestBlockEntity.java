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
	public NonNullList<ItemStack> items = NonNullList.withSize(18, ItemStack.EMPTY);

	public String textUp;
	public String textNorth;
	public String textEast;
	public String textSouth;
	public String textWest;

	public IcariaChestBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
		super(pType, pPos, pBlockState);
	}

	public IcariaChestBlockEntity(BlockPos pPos, BlockState pBlockState) {
		this(IcariaBlockEntityTypes.CHEST.get(), pPos, pBlockState);
	}

	public boolean hasTextUp() {
		return this.getTextUp() != null;
	}

	public boolean hasTextNorth() {
		return this.getTextNorth() != null;
	}

	public boolean hasTextEast() {
		return this.getTextEast() != null;
	}

	public boolean hasTextSouth() {
		return this.getTextSouth() != null;
	}

	public boolean hasTextWest() {
		return this.getTextWest() != null;
	}

	@Override
	public int getContainerSize() {
		return 18;
	}

	@Override
	public void loadAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pTag, pProvider);
		this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		if (!this.tryLoadLootTable(pTag)) {
			ContainerHelper.loadAllItems(pTag, this.items, pProvider);
		}

		if (pTag.contains("TextUp")) {
			this.textUp = pTag.getString("TextUp");
		}

		if (pTag.contains("TextNorth")) {
			this.textNorth = pTag.getString("TextNorth");
		}

		if (pTag.contains("TextEast")) {
			this.textEast = pTag.getString("TextEast");
		}

		if (pTag.contains("TextSouth")) {
			this.textSouth = pTag.getString("TextSouth");
		}

		if (pTag.contains("TextWest")) {
			this.textWest = pTag.getString("TextWest");
		}
	}

	@Override
	public void saveAdditional(CompoundTag pTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pTag, pProvider);
		if (!this.trySaveLootTable(pTag)) {
			ContainerHelper.saveAllItems(pTag, this.items, pProvider);
		}

		if (this.textUp != null) {
			pTag.putString("TextUp", this.textUp);
		}

		if (this.textNorth != null) {
			pTag.putString("TextNorth", this.textNorth);
		}

		if (this.textEast != null) {
			pTag.putString("TextEast", this.textEast);
		}

		if (this.textSouth != null) {
			pTag.putString("TextSouth", this.textSouth);
		}

		if (this.textWest != null) {
			pTag.putString("TextWest", this.textWest);
		}
	}

	@Override
	public void setItems(NonNullList<ItemStack> pItems) {
		this.items = pItems;
	}

	public void setTextUp(@Nullable String pName) {
		this.textUp = pName;
	}

	public void setTextNorth(@Nullable String pName) {
		this.textNorth = pName;
	}

	public void setTextEast(@Nullable String pName) {
		this.textEast = pName;
	}

	public void setTextSouth(@Nullable String pName) {
		this.textSouth = pName;
	}

	public void setTextWest(@Nullable String pName) {
		this.textWest = pName;
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

	public String getTextUp() {
		return this.textUp;
	}

	public String getTextNorth() {
		return this.textNorth;
	}

	public String getTextEast() {
		return this.textEast;
	}

	public String getTextSouth() {
		return this.textSouth;
	}

	public String getTextWest() {
		return this.textWest;
	}
}
