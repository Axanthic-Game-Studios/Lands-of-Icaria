package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaLootTables;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

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
	public void addAdditionalSaveData(CompoundTag pCompound) {

	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(LootVaseEntity.BLOCK_POS, BlockPos.ZERO);
		pBuilder.define(LootVaseEntity.BLOCK_STATE, Blocks.AIR.defaultBlockState());
	}

	public void dropFromLootTable(DamageSource pDamageSource) {
		if (this.level().getServer() != null) {
			if (this.level() instanceof ServerLevel serverLevel) {
				var lootContext = new LootParams.Builder(serverLevel).withOptionalParameter(LootContextParams.DIRECT_ATTACKING_ENTITY, pDamageSource.getDirectEntity()).withOptionalParameter(LootContextParams.ATTACKING_ENTITY, pDamageSource.getEntity()).withParameter(LootContextParams.DAMAGE_SOURCE, pDamageSource).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.ENTITY);
				var lootTable = this.getBlockState().is(IcariaBlocks.RED_LOOT_VASE.get()) ? IcariaLootTables.RED_LOOT_VASE_LOOT : this.getBlockState().is(IcariaBlocks.LOST_LOOT_VASE.get()) ? IcariaLootTables.LOST_LOOT_VASE_LOOT : IcariaLootTables.CYAN_LOOT_VASE_LOOT;
				lootContext.getLevel().getServer().reloadableRegistries().getLootTable(lootTable).getRandomItems(lootContext).forEach(this::spawnAtLocation);
			}
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
		this.entityData.set(LootVaseEntity.BLOCK_POS, pPos);
	}

	public void setBlockState(BlockState pState) {
		this.entityData.set(LootVaseEntity.BLOCK_STATE, pState);
	}

	@Override
	public void tick() {
		if (this.onGround()) {
			this.discard();
			this.dropFromLootTable(this.damageSources().fall());
			this.playSound(IcariaSoundEvents.VASE_BREAK, 1.0F, 1.0F);
		} else {
			this.move(MoverType.SELF, this.getDeltaMovement());
			this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.05D, 0.0D));
		}
	}

	public BlockPos getBlockPos() {
		return this.entityData.get(LootVaseEntity.BLOCK_POS);
	}

	public BlockState getBlockState() {
		return this.entityData.get(LootVaseEntity.BLOCK_STATE);
	}

	@Override
	public Entity.MovementEmission getMovementEmission() {
		return Entity.MovementEmission.NONE;
	}
}
