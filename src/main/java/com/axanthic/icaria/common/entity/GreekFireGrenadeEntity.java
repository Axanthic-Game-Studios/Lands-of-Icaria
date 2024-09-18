package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaPortalShape;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.HitResult;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeEntity extends AbstractArrow {
	public ItemStack stack = new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get());

	public GreekFireGrenadeEntity(EntityType<? extends GreekFireGrenadeEntity> pType, Level pLevel) {
		super(pType, pLevel);
	}

	public GreekFireGrenadeEntity(Level pLevel, LivingEntity pEntity, ItemStack pStack) {
		super(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), pEntity, pLevel, pStack, null);
		this.stack = pStack.copy();
	}

	@Override
	public boolean displayFireAnimation() {
		return false;
	}

	public boolean spawnPortal(LevelAccessor pLevel, BlockPos pPos) {
		var portalShape = this.getPortalShape(pLevel, pPos);
		if (portalShape != null) {
			portalShape.createPortalBlocks();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void onHit(HitResult pResult) {
		if (!this.level().isClientSide()) {
			if (this.spawnPortal(this.level(), BlockPos.containing(pResult.getLocation().x(), pResult.getLocation().y(), pResult.getLocation().z()))) {
				this.discard();
			} else {
				this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1.5F, Level.ExplosionInteraction.NONE);
				this.discard();
				for (int i = -2; i <= 2; i++) {
					var negPos = BlockPos.containing(this.getX() - i, this.getY() - i, this.getZ() - i);
					var posPos = BlockPos.containing(this.getX() + i, this.getY() + i, this.getZ() + i);
					for (var blockPos : BlockPos.betweenClosed(negPos, posPos)) {
						if (this.getRandom().nextInt(10) == 0) {
							if (this.level().getBlockState(blockPos).isAir()) {
								if (this.level().getBlockState(blockPos.below()).isSolidRender(this.level(), blockPos.below())) {
									this.level().setBlockAndUpdate(blockPos, IcariaBlocks.GREEK_FIRE.get().defaultBlockState());
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void tick() {
		super.tick();
		if (this.getRandom().nextBoolean()) {
			this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
		}
	}

	public @Nullable IcariaPortalShape getPortalShape(LevelAccessor pLevel, BlockPos pPos) {
		var icariaPortalShapeX = new IcariaPortalShape(pLevel, pPos, Direction.Axis.X);
		var icariaPortalShapeZ = new IcariaPortalShape(pLevel, pPos, Direction.Axis.Z);
		if (icariaPortalShapeX.isValid() && icariaPortalShapeX.numPortalBlocks == 0) {
			return icariaPortalShapeX;
		} else if (icariaPortalShapeZ.isValid() && icariaPortalShapeZ.numPortalBlocks == 0) {
			return icariaPortalShapeZ;
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getDefaultPickupItem() {
		return ItemStack.EMPTY;
	}

	public ItemStack getItem() {
		return this.stack;
	}

	@Override
	public SoundEvent getDefaultHitGroundSoundEvent() {
		return SoundEvents.GENERIC_EXPLODE.value();
	}
}
