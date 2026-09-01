package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HutchBlockEntity extends BlockEntity {
	public double bottomLeftAngle;
	public double bottomRightAngle;
	public double topLeftAngle;
	public double topRightAngle;

	public Item bottomLeftItem;
	public Item bottomRightItem;
	public Item topLeftItem;
	public Item topRightItem;

	public HutchBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.HUTCH.get(), pBlockPos, pBlockState);
	}

	public int getAnalogOutputSignal() {
		var i = this.getBottomLeftItem() != null ? 3 : 0;
		var j = this.getBottomRightItem() != null ? 3 : 0;
		var k = this.getTopLeftItem() != null ? 3 : 0;
		var l = this.getTopRightItem() != null ? 3 : 0;
		return i + j + k + l;
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.bottomLeftAngle = pValueInput.getDoubleOr("BottomLeftAngle", 0);
		this.bottomRightAngle = pValueInput.getDoubleOr("BottomRightAngle", 0);
		this.topLeftAngle = pValueInput.getDoubleOr("TopLeftAngle", 0);
		this.topRightAngle = pValueInput.getDoubleOr("TopRightAngle", 0);
		this.bottomLeftItem = pValueInput.read("BottomLeftItem", BuiltInRegistries.ITEM.byNameCodec()).orElse(null);
		this.bottomRightItem = pValueInput.read("BottomRightItem", BuiltInRegistries.ITEM.byNameCodec()).orElse(null);
		this.topLeftItem = pValueInput.read("TopLeftItem", BuiltInRegistries.ITEM.byNameCodec()).orElse(null);
		this.topRightItem = pValueInput.read("TopRightItem", BuiltInRegistries.ITEM.byNameCodec()).orElse(null);
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		pValueOutput.putDouble("BottomLeftAngle", this.bottomLeftAngle);
		pValueOutput.putDouble("BottomRightAngle", this.bottomRightAngle);
		pValueOutput.putDouble("TopLeftAngle", this.topLeftAngle);
		pValueOutput.putDouble("TopRightAngle", this.topRightAngle);
		this.saveItem(pValueOutput, "BottomLeftItem", this.bottomLeftItem);
		this.saveItem(pValueOutput, "BottomRightItem", this.bottomRightItem);
		this.saveItem(pValueOutput, "TopLeftItem", this.topLeftItem);
		this.saveItem(pValueOutput, "TopRightItem", this.topRightItem);
	}

	public void saveItem(ValueOutput pValueOutput, String pName, @Nullable Item pItem) {
		if (pItem != null) {
			pValueOutput.store(pName, BuiltInRegistries.ITEM.byNameCodec(), pItem);
		}
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropItem(serverLevel, pBlockPos, this.getBottomLeftItem());
			this.dropItem(serverLevel, pBlockPos, this.getBottomRightItem());
			this.dropItem(serverLevel, pBlockPos, this.getTopLeftItem());
			this.dropItem(serverLevel, pBlockPos, this.getTopRightItem());
		}
	}

	public void dropItem(ServerLevel pServerLevel, BlockPos pBlockPos, @Nullable Item pItem) {
		if (pItem != null) {
			Block.popResource(pServerLevel, pBlockPos, new ItemStack(pItem));
		}
	}

	public double getBottomLeftAngle() {
		return this.bottomLeftAngle;
	}

	public double getBottomRightAngle() {
		return this.bottomRightAngle;
	}

	public double getTopLeftAngle() {
		return this.topLeftAngle;
	}

	public double getTopRightAngle() {
		return this.topRightAngle;
	}

	@Nullable
	public Item getBottomLeftItem() {
		return this.bottomLeftItem;
	}

	@Nullable
	public Item getBottomRightItem() {
		return this.bottomRightItem;
	}

	@Nullable
	public Item getTopLeftItem() {
		return this.topLeftItem;
	}

	@Nullable
	public Item getTopRightItem() {
		return this.topRightItem;
	}

	public void setBottomLeftAngle(double pAngle) {
		this.bottomLeftAngle = pAngle;
	}

	public void setBottomRightAngle(double pAngle) {
		this.bottomRightAngle = pAngle;
	}

	public void setTopLeftAngle(double pAngle) {
		this.topLeftAngle = pAngle;
	}

	public void setTopRightAngle(double pAngle) {
		this.topRightAngle = pAngle;
	}

	public void setBottomLeftItem(@Nullable Item pItem) {
		this.bottomLeftItem = pItem;
	}

	public void setBottomRightItem(@Nullable Item pItem) {
		this.bottomRightItem = pItem;
	}

	public void setTopLeftItem(@Nullable Item pItem) {
		this.topLeftItem = pItem;
	}

	public void setTopRightItem(@Nullable Item pItem) {
		this.topRightItem = pItem;
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		return this.saveWithoutMetadata(pProvider);
	}

	@Override
	public Packet<ClientGamePacketListener> getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
}
