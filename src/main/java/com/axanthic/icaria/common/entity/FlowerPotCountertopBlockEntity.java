package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FlowerPotCountertopBlockEntity extends BlockEntity {
	public ItemStack itemStack;

	public FlowerPotCountertopBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.FLOWER_POT_COUNTERTOP.get(), pBlockPos, pBlockState);
	}

	@Override
	public void loadAdditional(ValueInput pValueInput) {
		super.loadAdditional(pValueInput);
		this.itemStack = pValueInput.read("ItemStack", ItemStack.CODEC).orElse(null);
	}

	@Override
	public void saveAdditional(ValueOutput pValueOutput) {
		super.saveAdditional(pValueOutput);
		this.saveItem(pValueOutput, "ItemStack", this.itemStack);
	}

	public void saveItem(ValueOutput pValueOutput, String pName, @Nullable ItemStack pItemStack) {
		if (pItemStack != null) {
			pValueOutput.store(pName, ItemStack.CODEC, pItemStack);
		}
	}

	@Override
	public void preRemoveSideEffects(BlockPos pBlockPos, BlockState pBlockState) {
		if (this.getLevel() instanceof ServerLevel serverLevel) {
			this.dropItem(serverLevel, pBlockPos, this.getItemStack());
		}
	}

	public void dropItem(ServerLevel pServerLevel, BlockPos pBlockPos, @Nullable ItemStack pItemStack) {
		if (pItemStack != null) {
			Block.popResource(pServerLevel, pBlockPos, pItemStack);
		}
	}

	@Nullable
	public ItemStack getItemStack() {
		return this.itemStack;
	}

	public void setItemStack(@Nullable ItemStack pBlockState) {
		this.itemStack = pBlockState;
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
