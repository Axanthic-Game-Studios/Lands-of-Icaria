package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.shape.PortalShape;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeEntity extends ThrowableItemProjectile {
	public GreekFireGrenadeEntity(EntityType<? extends GreekFireGrenadeEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	public GreekFireGrenadeEntity(Level pLevel, LivingEntity pLivingEntity, ItemStack pItemStack) {
		super(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), pLivingEntity, pLevel, pItemStack);
	}

	public GreekFireGrenadeEntity(Level pLevel, double pX, double pY, double pZ, ItemStack pItemStack) {
		super(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), pX, pY, pZ, pLevel, pItemStack);
	}

	@Override
	public void onHit(HitResult pHitResult) {
		var vec3 = pHitResult.getLocation();
		var icariaPortalShape = this.getIcariaPortalShape(BlockPos.containing(vec3.x(), vec3.y(), vec3.z()), this.level());
		if (!this.level().isClientSide()) {
			this.discard();
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 1.5F, Level.ExplosionInteraction.NONE);
			if (icariaPortalShape != null) {
				icariaPortalShape.createPortal();
			} else {
				IcariaCommonHelper.fire(this.blockPosition(), this.level(), 2, 10);
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

	@Nullable
	public PortalShape getIcariaPortalShape(BlockPos pBlockPos, Level pLevel) {
		var icariaPortalShapeX = new PortalShape(Direction.Axis.X, pBlockPos, pLevel);
		var icariaPortalShapeZ = new PortalShape(Direction.Axis.Z, pBlockPos, pLevel);
		if (icariaPortalShapeX.canSet() && icariaPortalShapeX.isComplete()) {
			return icariaPortalShapeX;
		} else if (icariaPortalShapeZ.canSet() && icariaPortalShapeZ.isComplete()) {
			return icariaPortalShapeZ;
		} else {
			return null;
		}
	}

	@Override
	public Item getDefaultItem() {
		return IcariaItems.GREEK_FIRE_GRENADE.get();
	}
}
