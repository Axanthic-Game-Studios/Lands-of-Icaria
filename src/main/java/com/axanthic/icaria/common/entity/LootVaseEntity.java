package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.data.loot.IcariaVaseLoot;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseEntity extends Entity {
    public static final EntityDataAccessor<BlockPos> BLOCK_POS = SynchedEntityData.defineId(LootVaseEntity.class, EntityDataSerializers.BLOCK_POS);
    public static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(LootVaseEntity.class, EntityDataSerializers.BLOCK_STATE);

    public LootVaseEntity(EntityType<? extends LootVaseEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public LootVaseEntity(EntityType<? extends LootVaseEntity> pType, Level pLevel, BlockState pState, BlockPos pPos) {
        this(pType, pLevel);
        this.setBlockPos(pPos);
        this.setBlockState(pState);
    }

    @Override
    public boolean displayFireAnimation() {
        return false;
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public boolean isIgnoringBlockTriggers() {
        return true;
    }

    @Override
    public boolean onlyOpCanSetNbt() {
        return true;
    }

    @Override
    public double getMyRidingOffset() {
        return 0.525D;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        // NOOP
    }

    @Override
    public void defineSynchedData() {
        this.entityData.define(BLOCK_POS, BlockPos.ZERO);
        this.entityData.define(BLOCK_STATE, Blocks.AIR.defaultBlockState());
    }

    public void dropFromLootTable(DamageSource pDamageSource) {
        if (this.level.getServer() != null) {
            var lootContextBuilder = new LootContext.Builder((ServerLevel) this.level).withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, pDamageSource.getDirectEntity()).withOptionalParameter(LootContextParams.KILLER_ENTITY, pDamageSource.getEntity()).withParameter(LootContextParams.DAMAGE_SOURCE, pDamageSource).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).withRandom(this.random);
            var lootContext = lootContextBuilder.create(LootContextParamSets.ENTITY);
            var lootTable = lootContext.getLevel().getServer().getLootTables().get(IcariaVaseLoot.LOOT_VASE);
            lootTable.getRandomItems(lootContext).forEach(this::spawnAtLocation);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        // NOOP
    }

    @Override
    public void rideTick() {
        super.rideTick();
        var entity = this.getVehicle();
        if (entity != null) {
            if (entity.isShiftKeyDown()) {
                this.stopRiding();
                this.setDeltaMovement(-Mth.sin(entity.getYRot() * (Mth.PI / 180.0F)), -Mth.sin(entity.getXRot() * (Mth.PI / 180.0F)), Mth.cos(entity.getYRot() * (Mth.PI / 180.0F)));
            }
        }
    }

    public void setBlockPos(BlockPos pStartPos) {
        this.entityData.set(BLOCK_POS, pStartPos);
    }

    public void setBlockState(BlockState pState) {
        this.entityData.set(BLOCK_STATE, pState);
    }

    @Override
    public void tick() {
        if (this.isOnGround()) {
            this.discard();
            this.dropFromLootTable(this.damageSources().fall());
            this.playSound(IcariaSoundEvents.VASE_BREAK);
        } else {
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
        }
    }

    public BlockPos getStartPos() {
        return this.entityData.get(BLOCK_POS);
    }

    public BlockState getBlockState() {
        return this.entityData.get(BLOCK_STATE);
    }

    @Override
    public Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }
}
