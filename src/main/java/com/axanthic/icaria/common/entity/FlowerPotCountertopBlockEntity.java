package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
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

public class FlowerPotCountertopBlockEntity extends BlockEntity {
	public Item item;

	public FlowerPotCountertopBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.FLOWER_POT_COUNTERTOP.get(), pBlockPos, pBlockState);
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.item = pValueInput.read("Item", BuiltInRegistries.ITEM.byNameCodec()).orElse(null);
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		this.saveItem(pValueOutput, "Item", this.item);
	}

	public void saveItem(ValueOutput pValueOutput, String pName, @Nullable Item pItem) {
		if (pItem != null) {
			pValueOutput.store(pName, BuiltInRegistries.ITEM.byNameCodec(), pItem);
		}
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropItem(serverLevel, pBlockPos, this.getItem());
		}
	}

	public void dropItem(ServerLevel pServerLevel, BlockPos pBlockPos, @Nullable Item pItem) {
		if (pItem != null) {
			Block.popResource(pServerLevel, pBlockPos, new ItemStack(pItem));
		}
	}

	@Nullable
	public Item getItem() {
		return this.item;
	}

	public void setItem(@Nullable Item pItem) {
		this.item = pItem;
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
