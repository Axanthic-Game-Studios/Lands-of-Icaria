package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.util.IcariaBaseSpawner;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Spawner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSpawnerBlockEntity extends BlockEntity implements Spawner {
	public IcariaBaseSpawner baseSpawner = new IcariaBaseSpawner();

	public IcariaSpawnerBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		super(IcariaBlockEntityTypes.SPAWNER.get(), pBlockPos, pBlockState);
	}

	@Override
	public boolean onlyOpCanSetNbt() {
		return true;
	}

	@Override
	public boolean triggerEvent(int pId, int pType) {
		return this.level != null && this.baseSpawner.onEventTriggered(this.level, pId);
	}

	public static void clientTick(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, IcariaSpawnerBlockEntity pBlockEntity) {
		pBlockEntity.baseSpawner.clientTick(pLevel, pBlockPos);
	}

	@Override
	public void loadAdditional(CompoundTag pCompoundTag, HolderLookup.Provider pProvider) {
		super.loadAdditional(pCompoundTag, pProvider);
		this.baseSpawner.load(this.level, this.worldPosition, pCompoundTag);
	}

	@Override
	public void saveAdditional(CompoundTag pCompoundTag, HolderLookup.Provider pProvider) {
		super.saveAdditional(pCompoundTag, pProvider);
		this.baseSpawner.save(pCompoundTag);
	}

	public static void serverTick(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, IcariaSpawnerBlockEntity pBlockEntity) {
		if (pLevel instanceof ServerLevel serverLevel) {
			pBlockEntity.baseSpawner.serverTick(serverLevel, pBlockPos);
		}
	}

	public void setEntityId(EntityType<?> pEntityType, RandomSource pRandomSource) {
		this.baseSpawner.setEntityId(pEntityType, this.level, pRandomSource, this.worldPosition);
		this.setChanged();
	}

	public BaseSpawner getSpawner() {
		return this.baseSpawner;
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag(HolderLookup.Provider pProvider) {
		var compoundTag = this.saveWithoutMetadata(pProvider);
		compoundTag.remove("SpawnPotentials");
		return compoundTag;
	}
}
