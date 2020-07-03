package com.axanthic.loi.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class EntityAICharge extends EntityAIBase {

	private EntityCreature charger;
	private EntityLivingBase chargeTarget;
	private double chargeX;
	private double chargeY;
	private double chargeZ;
	protected float speed;
	private int windup;
	private boolean hasAttacked;

	public EntityAICharge(EntityCreature entityLiving, float f) {
		this.charger = entityLiving;
		this.speed = f;
		this.windup = 0;
		this.hasAttacked = false;
		this.setMutexBits(3);
	}

	@Override
	public boolean shouldExecute() {
		this.chargeTarget = this.charger.getAttackTarget();

		if (this.chargeTarget == null) {
			return false;
		} else {
			double distance = this.charger.getDistanceSq(this.chargeTarget);
			if (distance < 16 || distance > 64) {
				return false;
			} else if (!this.charger.onGround) {
				return false;
			} else {
				Vec3d chargePos = findChargePoint(charger, chargeTarget, 2.1);
				boolean canSeeTargetFromDest = charger.getEntitySenses().canSee(chargeTarget);
				if (!canSeeTargetFromDest) {
					return false;
				} else {
					chargeX = chargePos.x;
					chargeY = chargePos.y;
					chargeZ = chargePos.z;

					return this.charger.getRNG().nextInt(1) == 0;
				}
			}

		}
	}

	@Override
	public void startExecuting() {
		this.windup = 20 + this.charger.getRNG().nextInt(30);
	}

	@Override
	public boolean shouldContinueExecuting() {
		return windup > 0 || !this.charger.getNavigator().noPath();
	}

	@Override
	public void updateTask() {
		this.charger.getLookHelper().setLookPosition(chargeX, chargeY - 1, chargeZ, 10.0F,
				this.charger.getVerticalFaceSpeed());

		if (windup > 0) {
			if (--windup == 0) {

				this.charger.getNavigator().tryMoveToXYZ(chargeX, chargeY, chargeZ, this.speed);
			} else {
				if (this.charger instanceof ICharger) {
					((ICharger) charger).setCharging(true);
				}
			}
		}

		double rangeSq = this.charger.width * 2.1F * this.charger.width * 2.1F;

		if (this.charger.getDistanceSq(this.chargeTarget.posX, this.chargeTarget.getEntityBoundingBox().minY,
				this.chargeTarget.posZ) <= rangeSq) {
			if (!this.hasAttacked) {
				this.hasAttacked = true;
				this.charger.attackEntityAsMob(this.chargeTarget);
			}
		}

	}

	@Override
	public void resetTask() {
		this.windup = 0;
		this.chargeTarget = null;
		this.hasAttacked = false;

		if (this.charger instanceof ICharger) {
			((ICharger) charger).setCharging(false);
		}
	}

	protected Vec3d findChargePoint(Entity attacker, Entity target, double overshoot) {

		double vecx = target.posX - attacker.posX;
		double vecz = target.posZ - attacker.posZ;
		float rangle = (float) (Math.atan2(vecz, vecx));

		double distance = MathHelper.sqrt(vecx * vecx + vecz * vecz);

		double dx = MathHelper.cos(rangle) * (distance + overshoot);
		double dz = MathHelper.sin(rangle) * (distance + overshoot);

		return new Vec3d(attacker.posX + dx, target.posY, attacker.posZ + dz);
	}

}