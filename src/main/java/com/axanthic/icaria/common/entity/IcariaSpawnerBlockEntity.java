package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.util.IcariaBaseSpawner;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BaseSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSpawnerBlockEntity extends BlockEntity {
    public IcariaBaseSpawner baseSpawner;

    public BlockState blockState;

    public IcariaSpawnerBlockEntity(BlockPos pPos, BlockState pState) {
        super(IcariaBlockEntityTypes.SPAWNER.get(), pPos, pState);
        this.baseSpawner = this.getBaseSpawner(pState);
        this.blockState = this.getBlockState();
    }

    @Override
    public boolean onlyOpCanSetNbt() {
        return true;
    }

    @Override
    public boolean triggerEvent(int pId, int pType) {
        boolean flag = false;
        if (this.level != null) {
            flag = this.baseSpawner.onEventTriggered(this.level, pId) || super.triggerEvent(pId, pType);
        }

        return flag;
    }

    public static void clientTick(Level pLevel, BlockPos pPos, BlockState pState, IcariaSpawnerBlockEntity pBlockEntity) {
        pBlockEntity.baseSpawner.clientTick(pLevel, pPos);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.baseSpawner.load(this.level, this.worldPosition, pTag);
    }

    @Override
    public void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        this.baseSpawner.save(pTag);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, IcariaSpawnerBlockEntity pBlockEntity) {
        pBlockEntity.baseSpawner.serverTick((ServerLevel) pLevel, pPos);
    }

    public void setEntityId(EntityType<?> pType, RandomSource pRandom) {
        this.baseSpawner.setEntityId(pType, this.level, pRandom, this.worldPosition);
    }

    public BaseSpawner getSpawner() {
        return this.baseSpawner;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        var compoundTag = this.saveWithoutMetadata();
        compoundTag.remove("SpawnPotentials");
        return compoundTag;
    }

    public IcariaBaseSpawner getBaseSpawner(BlockState pBlockState) {
        return new IcariaBaseSpawner(this, pBlockState);
    }
}
