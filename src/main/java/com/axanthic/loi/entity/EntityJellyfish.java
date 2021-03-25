package com.axanthic.loi.entity;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityJellyfish extends EntityFlying {

	public float jellyfishPitch;
	public float prevJellyfishPitch;
	public float jellyfishYaw;
	public float prevJellyfishYaw;
	/** appears to be rotation in radians; we already have pitch & yaw, so this completes the triumvirate. */
	public float jellyfishRotation;
	/** previous jellyfishRotation in radians */
	public float prevJellyfishRotation;
	/** angle of the tentacles in radians */
	public float tentacleAngle;
	/** the last calculated angle of the tentacles in radians */
	public float lastTentacleAngle;
	private float randomMotionSpeed;
	/** change in jellyfishRotation in radians. */
	private float rotationVelocity;
	private float rotateSpeed;
	private float randomMotionVecX;
	private float randomMotionVecY;
	private float randomMotionVecZ;

	public EntityJellyfish(World worldIn) {
		super(worldIn);
		this.setSize(1.5F, 1.5F);
		this.rand.setSeed((long)(1 + this.getEntityId()));
		this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityJellyfish.AIMoveRandom(this));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
	}

	public float getEyeHeight() {
		return 0.75F;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SQUID_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SQUID_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SQUID_DEATH;
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	public boolean canDespawn() {
		return false;
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking() {
		return false;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_JELLYFISH;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
	 * use this to react to sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		super.onLivingUpdate();
		this.prevJellyfishPitch = this.jellyfishPitch;
		this.prevJellyfishYaw = this.jellyfishYaw;
		this.prevJellyfishRotation = this.jellyfishRotation;
		this.lastTentacleAngle = this.tentacleAngle;
		this.jellyfishRotation += this.rotationVelocity;

		if ((double)this.jellyfishRotation > (Math.PI * 2D)) {
			if (this.world.isRemote) {
				this.jellyfishRotation = ((float)Math.PI * 2F);
			} else {
				this.jellyfishRotation = (float)((double)this.jellyfishRotation - (Math.PI * 2D));

				if (this.rand.nextInt(10) == 0) {
					this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
				}
				this.world.setEntityState(this, (byte)19);
			}
		}

		if (this.jellyfishRotation < (float)Math.PI) {
			float f = this.jellyfishRotation / (float)Math.PI;
			this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;

			if ((double)f > 0.75D) {
				this.randomMotionSpeed = 1.0F;
				this.rotateSpeed = 1.0F;
			} else {
				this.rotateSpeed *= 0.8F;
			}
		} else {
			this.tentacleAngle = 0.0F;
			this.randomMotionSpeed *= 0.9F;
			this.rotateSpeed *= 0.99F;
		}

		if (!this.world.isRemote) {
			this.motionX = (double)(this.randomMotionVecX * this.randomMotionSpeed);
			this.motionY = (double)(this.randomMotionVecY * this.randomMotionSpeed);
			this.motionZ = (double)(this.randomMotionVecZ * this.randomMotionSpeed);
		}

		float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		this.renderYawOffset += (-((float)MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float)Math.PI) - this.renderYawOffset) * 0.1F;
		this.rotationYaw = this.renderYawOffset;
		this.jellyfishYaw = (float)((double)this.jellyfishYaw + Math.PI * (double)this.rotateSpeed * 1.5D);
		this.jellyfishPitch += (-((float)MathHelper.atan2((double)f1, this.motionY)) * (180F / (float)Math.PI) - this.jellyfishPitch) * 0.1F;

	}

	public void travel(float strafe, float vertical, float forward) {
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	public boolean getCanSpawnHere() {
		return true;
	}

	/**
	 * Handler for {@link World#setEntityState}
	 */
	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 19) {
			this.jellyfishRotation = 0.0F;
		} else {
			super.handleStatusUpdate(id);
		}
	}

	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn) {
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}

	public boolean hasMovementVector() {
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}

	static class AIMoveRandom extends EntityAIBase {
		private final EntityJellyfish jellyfish;

		public AIMoveRandom(EntityJellyfish entityJellyfish) {
			this.jellyfish = entityJellyfish;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask() {
			int i = this.jellyfish.getIdleTime();

			if (i > 100) {
				this.jellyfish.setMovementVector(0.0F, 0.0F, 0.0F);
			} else if (this.jellyfish.getRNG().nextInt(50) == 0 || !this.jellyfish.hasMovementVector()) {
				float f = this.jellyfish.getRNG().nextFloat() * ((float)Math.PI * 2F);
				float f1 = MathHelper.cos(f) * 0.2F;
				float f2 = -0.1F + this.jellyfish.getRNG().nextFloat() * 0.2F;
				float f3 = MathHelper.sin(f) * 0.2F;
				this.jellyfish.setMovementVector(f1, f2, f3);
			}
		}
	}
}