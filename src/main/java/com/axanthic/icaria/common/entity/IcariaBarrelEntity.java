package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.block.RackBlock;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.registry.IcariaWoodTypes;
import com.axanthic.icaria.data.loot.IcariaBarrelLoot;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBarrelEntity extends Entity {
    public static final EntityDataAccessor<BlockPos> BLOCK_POS = SynchedEntityData.defineId(IcariaBarrelEntity.class, EntityDataSerializers.BLOCK_POS);

    public static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(IcariaBarrelEntity.class, EntityDataSerializers.BLOCK_STATE);

    public IcariaBarrelEntity(EntityType<? extends IcariaBarrelEntity> pType, Level pLevel) {
        super(pType, pLevel);
    }

    public IcariaBarrelEntity(EntityType<? extends IcariaBarrelEntity> pType, Level pLevel, BlockState pState, BlockPos pPos) {
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
        this.entityData.define(IcariaBarrelEntity.BLOCK_POS, BlockPos.ZERO);
        this.entityData.define(IcariaBarrelEntity.BLOCK_STATE, Blocks.AIR.defaultBlockState());
    }

    public void dropFromLootTable(DamageSource pDamageSource) {
        if (this.level().getServer() != null) {
            var lootContext = new LootParams.Builder((ServerLevel) this.level()).withOptionalParameter(LootContextParams.DIRECT_KILLER_ENTITY, pDamageSource.getDirectEntity()).withOptionalParameter(LootContextParams.KILLER_ENTITY, pDamageSource.getEntity()).withParameter(LootContextParams.DAMAGE_SOURCE, pDamageSource).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.ENTITY);
            lootContext.getLevel().getServer().getLootData().getLootTable(IcariaBarrelLoot.BARREL).getRandomItems(lootContext).forEach(this::spawnAtLocation);
        }
    }

    @Override
    public void playerTouch(Player pPlayer) {
        if (pPlayer instanceof ServerPlayer) {
            if (!pPlayer.isCreative()) {
                pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN), this);
            }
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

    public void setBlockPos(BlockPos pPos) {
        this.entityData.set(IcariaBarrelEntity.BLOCK_POS, pPos);
    }

    public void setBlockState(BlockState pState) {
        this.entityData.set(IcariaBarrelEntity.BLOCK_STATE, pState);
    }

    @Override
    public void tick() {
        var x = this.getX();
        var y = this.getY();
        var z = this.getZ();
        if (this.onGround()) {
            if (!this.level().isClientSide()) {
                if (this.getBlockState().hasProperty(IcariaBlockStateProperties.LOADED_BARREL) && this.getBlockState().getValue(IcariaBlockStateProperties.LOADED_BARREL) || this.getBlockState().is(IcariaBlockTags.LOADED_BARRELS)) {
                    this.level().explode(this, x, y, z, 2.0F, Level.ExplosionInteraction.BLOCK);
                    for (int i = -2; i <= 2; i++) {
                        var negPos = BlockPos.containing(x - i, y - i, z - i);
                        var posPos = BlockPos.containing(x + i, y + i, z + i);
                        for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                            var belowPos = blockPos.below();
                            if (this.level().getRandom().nextInt(10) == 0) {
                                if (this.level().getBlockState(blockPos).isAir()) {
                                    if (this.level().getBlockState(belowPos).isSolidRender(this.level(), belowPos)) {
                                        this.level().setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
                                    }
                                }
                            }
                        }
                    }
                } else if (this.getBlockState().hasProperty(IcariaBlockStateProperties.TAPPED_BARREL) && this.getBlockState().getValue(IcariaBlockStateProperties.TAPPED_BARREL) || this.getBlockState().is(IcariaBlockTags.TAPPED_BARRELS)) {
                    for (int i = -1; i <= 1; i++) {
                        var negPos = BlockPos.containing(x - i, y - i, z - i);
                        var posPos = BlockPos.containing(x + i, y + i, z + i);
                        for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
                            var belowPos = blockPos.below();
                            if (this.level().getRandom().nextInt(10) == 0) {
                                if (this.level().getBlockState(blockPos).isAir()) {
                                    if (this.level().getBlockState(belowPos).isSolidRender(this.level(), belowPos)) {
                                        this.level().setBlockAndUpdate(blockPos, IcariaBlocks.MEDITERRANEAN_WATER.get().defaultBlockState());
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.dropFromLootTable(this.damageSources().fall());
                }
            }

            this.discard();
            this.playSound(IcariaSoundEvents.BARREL_BREAK);
        } else {
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
        }
    }

    public BlockPos getBlockPos() {
        return this.entityData.get(IcariaBarrelEntity.BLOCK_POS);
    }

    public BlockState getBlockState() {
        return this.entityData.get(IcariaBarrelEntity.BLOCK_STATE);
    }

    public BlockState getLoaded() {
        if (this.getBlockState().getBlock() instanceof RackBlock block) {
            if (block.getType().equals(IcariaWoodTypes.CYPRESS)) {
                return IcariaBlocks.LOADED_CYPRESS_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.DROUGHTROOT)) {
                return IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.FIR)) {
                return IcariaBlocks.LOADED_FIR_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.LAUREL)) {
                return IcariaBlocks.LOADED_LAUREL_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.OLIVE)) {
                return IcariaBlocks.LOADED_OLIVE_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.PLANE)) {
                return IcariaBlocks.LOADED_PLANE_BARREL.get().defaultBlockState();
            } else {
                return IcariaBlocks.LOADED_POPULUS_BARREL.get().defaultBlockState();
            }
        }

        return this.getBlockState();
    }

    public BlockState getNormal() {
        if (this.getBlockState().getBlock() instanceof RackBlock block) {
            if (block.getType().equals(IcariaWoodTypes.CYPRESS)) {
                return IcariaBlocks.CYPRESS_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.DROUGHTROOT)) {
                return IcariaBlocks.DROUGHTROOT_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.FIR)) {
                return IcariaBlocks.FIR_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.LAUREL)) {
                return IcariaBlocks.LAUREL_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.OLIVE)) {
                return IcariaBlocks.OLIVE_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.PLANE)) {
                return IcariaBlocks.PLANE_BARREL.get().defaultBlockState();
            } else {
                return IcariaBlocks.POPULUS_BARREL.get().defaultBlockState();
            }
        }

        return this.getBlockState();
    }

    public BlockState getTapped() {
        if (this.getBlockState().getBlock() instanceof RackBlock block) {
            if (block.getType().equals(IcariaWoodTypes.CYPRESS)) {
                return IcariaBlocks.TAPPED_CYPRESS_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.DROUGHTROOT)) {
                return IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.FIR)) {
                return IcariaBlocks.TAPPED_FIR_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.LAUREL)) {
                return IcariaBlocks.TAPPED_LAUREL_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.OLIVE)) {
                return IcariaBlocks.TAPPED_OLIVE_BARREL.get().defaultBlockState();
            } else if (block.getType().equals(IcariaWoodTypes.PLANE)) {
                return IcariaBlocks.TAPPED_PLANE_BARREL.get().defaultBlockState();
            } else {
                return IcariaBlocks.TAPPED_POPULUS_BARREL.get().defaultBlockState();
            }
        }

        return this.getBlockState();
    }

    public BlockState getRenderState() {
        if (this.getBlockState().getBlock() instanceof RackBlock) {
            if (this.getBlockState().getValue(IcariaBlockStateProperties.LOADED_BARREL)) {
                return this.getLoaded();
            } else if (this.getBlockState().getValue(IcariaBlockStateProperties.TAPPED_BARREL)) {
                return this.getTapped();
            } else {
                return this.getNormal();
            }
        }

        return this.getBlockState();
    }

    @Override
    public MovementEmission getMovementEmission() {
        return MovementEmission.NONE;
    }
}
