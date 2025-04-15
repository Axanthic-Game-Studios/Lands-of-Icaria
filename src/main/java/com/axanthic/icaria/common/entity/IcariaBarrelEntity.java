package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.registry.IcariaValues;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
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

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBarrelEntity extends Entity {
	public static final EntityDataAccessor<BlockPos> BLOCK_POS = SynchedEntityData.defineId(IcariaBarrelEntity.class, EntityDataSerializers.BLOCK_POS);
	public static final EntityDataAccessor<BlockState> BLOCK_STATE = SynchedEntityData.defineId(IcariaBarrelEntity.class, EntityDataSerializers.BLOCK_STATE);

	public IcariaBarrelEntity(EntityType<? extends IcariaBarrelEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public IcariaBarrelEntity(EntityType<? extends IcariaBarrelEntity> pEntityType, Level pLevel, BlockState pBlockState, BlockPos pBlockPos) {
		this(pEntityType, pLevel);
		this.setBlockPos(pBlockPos);
		this.setBlockState(pBlockState);
	}

	@Override
	public boolean displayFireAnimation() {
		return false;
	}

	@Override
	public boolean hurtServer(ServerLevel pServerLevel, DamageSource pDamageSource, float pAmount) {
		return false;
	}

	@Override
	public boolean isAttackable() {
		return false;
	}

	@Override
	public boolean onlyOpCanSetNbt() {
		return true;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag pCompoundTag) {
		pCompoundTag.put("BlockPos", NbtUtils.writeBlockPos(this.getBlockPos()));
		pCompoundTag.put("BlockState", NbtUtils.writeBlockState(this.getBlockState()));
	}

	@Override
	public void defineSynchedData(SynchedEntityData.Builder pBuilder) {
		pBuilder.define(IcariaBarrelEntity.BLOCK_POS, BlockPos.ZERO);
		pBuilder.define(IcariaBarrelEntity.BLOCK_STATE, Blocks.AIR.defaultBlockState());
	}

	public void dropFromLootTable(DamageSource pDamageSource) {
		if (this.level().getServer() != null) {
			if (this.level() instanceof ServerLevel serverLevel) {
				var lootContext = new LootParams.Builder(serverLevel).withOptionalParameter(LootContextParams.DIRECT_ATTACKING_ENTITY, pDamageSource.getDirectEntity()).withOptionalParameter(LootContextParams.ATTACKING_ENTITY, pDamageSource.getEntity()).withParameter(LootContextParams.DAMAGE_SOURCE, pDamageSource).withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.ENTITY);
				lootContext.getLevel().getServer().reloadableRegistries().getLootTable(IcariaLootTables.BARREL_LOOT).getRandomItems(lootContext).forEach(itemStack -> this.spawnAtLocation(serverLevel, itemStack));
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
	public void readAdditionalSaveData(CompoundTag pCompoundTag) {
		this.setBlockPos(NbtUtils.readBlockPos(pCompoundTag, "BlockPos").orElseThrow());
		this.setBlockState(NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), pCompoundTag.getCompound("BlockState")));
	}

	@Override
	public void rideTick() {
		super.rideTick();
		var entity = this.getVehicle();
		if (entity != null) {
			if (entity.isShiftKeyDown()) {
				this.stopRiding();
				this.setDeltaMovement(-Mth.sin(entity.getYRot() / IcariaValues.DEG_2_RAD), -Mth.sin(entity.getXRot() / IcariaValues.DEG_2_RAD), Mth.cos(entity.getYRot() / IcariaValues.DEG_2_RAD));
			}
		}
	}

	public void setBlockPos(BlockPos pBlockPos) {
		this.entityData.set(IcariaBarrelEntity.BLOCK_POS, pBlockPos);
	}

	public void setBlockState(BlockState pBlockState) {
		this.entityData.set(IcariaBarrelEntity.BLOCK_STATE, pBlockState);
	}

	@Override
	public void tick() {
		if (this.onGround()) {
			this.discard();
			this.playSound(IcariaSoundEvents.BARREL_BREAK);
			if (!this.level().isClientSide()) {
				if (this.getBlockState().hasProperty(IcariaBlockStateProperties.LOADED_BARREL) && this.getBlockState().getValue(IcariaBlockStateProperties.LOADED_BARREL) || this.getBlockState().is(IcariaBlockTagsProvider.BARRELS_LOADED)) {
					IcariaCommonHelper.loaded(this.blockPosition(), this, Level.ExplosionInteraction.BLOCK, this.level(), 2, 10);
				} else if (this.getBlockState().hasProperty(IcariaBlockStateProperties.TAPPED_BARREL) && this.getBlockState().getValue(IcariaBlockStateProperties.TAPPED_BARREL) || this.getBlockState().is(IcariaBlockTagsProvider.BARRELS_TAPPED)) {
					IcariaCommonHelper.tapped(this.blockPosition(), this.level());
				} else {
					this.dropFromLootTable(this.damageSources().fall());
				}
			}
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

	@Override
	public MovementEmission getMovementEmission() {
		return MovementEmission.NONE;
	}
}
