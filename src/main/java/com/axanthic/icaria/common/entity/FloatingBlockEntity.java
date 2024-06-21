package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FloatingBlockEntity extends Entity {
    public int minTick = 0;
    public int maxTick = 100;

    public static final EntityDataAccessor<BlockPos> BLOCK_POS = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.BLOCK_POS);

    public static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.BLOCK_STATE);

    public static final EntityDataAccessor<Integer> TICK = SynchedEntityData.defineId(FloatingBlockEntity.class, EntityDataSerializers.INT);

    public FloatingBlockEntity(EntityType<? extends FloatingBlockEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public FloatingBlockEntity(EntityType<? extends FloatingBlockEntity> pType, Level pLevel, BlockState pState, BlockPos pPos) {
        this(pType, pLevel);
        this.setBlockPos(pPos);
        this.setBlockState(pState);
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        float amount = Math.min(this.fallDistance, 40);
        var boundingBox = this.getBoundingBox();
        var damageSource = this.damageSources().fallingBlock(this);
        var predicate = EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
        this.level().getEntities(this, boundingBox, predicate).forEach((entity) -> entity.hurt(damageSource, amount));
        return true;
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

    public int getTick() {
        return this.entityData.get(FloatingBlockEntity.TICK);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.put("BlockPos", NbtUtils.writeBlockPos(this.getBlockPos()));
        pCompound.put("BlockState", NbtUtils.writeBlockState(this.getBlockState()));
        pCompound.putInt("Tick", this.getTick());
    }

    @Override
    public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        pBuilder.define(FloatingBlockEntity.BLOCK_POS, BlockPos.ZERO);
        pBuilder.define(FloatingBlockEntity.BLOCK_STATE, Blocks.AIR.defaultBlockState());
        pBuilder.define(FloatingBlockEntity.TICK, this.minTick);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        NbtUtils.readBlockPos(pCompound, "BlockPos").ifPresent(this::setBlockPos);
        this.setBlockState(NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), pCompound.getCompound("BlockState")));
        this.setTick(pCompound.getInt("Tick"));
    }

    public void setBlockPos(BlockPos pPos) {
        this.entityData.set(FloatingBlockEntity.BLOCK_POS, pPos);
    }

    public void setBlockState(BlockState pState) {
        this.entityData.set(FloatingBlockEntity.BLOCK_STATE, pState);
    }

    public void setTick(int pTick) {
        int tick = Mth.clamp(pTick, this.minTick, this.maxTick);
        this.entityData.set(FloatingBlockEntity.TICK, tick);
    }

    @Override
    public void tick() {
        super.tick();
        this.move(MoverType.SELF, this.getDeltaMovement());
        int tick = this.getTick();
        if (tick < this.maxTick) {
            tick++;
            this.setTick(tick);
        } else {
            this.setDeltaMovement(0.0D, -0.7D, 0.0D);
            if (this.onGround()) {
                if (this.level().getBlockState(this.blockPosition()).canBeReplaced() && this.getBlockState().canSurvive(this.level(), this.blockPosition())) {
                    this.level().setBlockAndUpdate(this.blockPosition(), this.getBlockState());
                    this.discard();
                } else if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                    this.spawnAtLocation(this.getBlockState().getBlock());
                    this.discard();
                }
            }
        }
    }

    public BlockPos getBlockPos() {
        return this.entityData.get(FloatingBlockEntity.BLOCK_POS);
    }

    public BlockState getBlockState() {
        return this.entityData.get(FloatingBlockEntity.BLOCK_STATE);
    }

    @Override
    public MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }
}
