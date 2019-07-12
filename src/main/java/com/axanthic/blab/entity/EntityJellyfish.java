package com.axanthic.blab.entity;

import javax.annotation.Nullable;

import com.axanthic.blab.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.passive.EntityFlying;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityJellyfish extends EntityCreature implements EntityFlying {

	public float squidPitch;
	public float prevSquidPitch;
	public float squidYaw;
	public float prevSquidYaw;
	/** appears to be rotation in radians; we already have pitch & yaw, so this completes the triumvirate. */
	public float squidRotation;
	/** previous squidRotation in radians */
	public float prevSquidRotation;
	/** angle of the tentacles in radians */
	public float tentacleAngle;
	/** the last calculated angle of the tentacles in radians */
	public float lastTentacleAngle;
	private float randomMotionSpeed;
	/** change in squidRotation in radians. */
	private float rotationVelocity;
	private float rotateSpeed;
	private float randomMotionVecX;
	private float randomMotionVecY;
	private float randomMotionVecZ;

	public EntityJellyfish(World worldIn) {
		super(worldIn);
		this.setSize(1.5F, 1.5F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new AIMoveRandom(this));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
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

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_JELLYFISH;
	}

	public boolean isNotColliding()
	{
		return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
	}

	public int getTalkInterval() {
		return 120;
	}

	public boolean getCanSpawnHere()
	{
		return true;
	}

	protected boolean canDespawn() {
		return false;
	}

	protected int getExperiencePoints(EntityPlayer player) {
		return 1 + this.world.rand.nextInt(3);
	}

	public float getEyeHeight() {
		return 0.75F;
	}

	public double getYOffset() {
		return 0.14D;
	}

	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		this.prevSquidPitch = this.squidPitch;
		this.prevSquidYaw = this.squidYaw;
		this.prevSquidRotation = this.squidRotation;
		this.lastTentacleAngle = this.tentacleAngle;
		this.squidRotation += this.rotationVelocity;

		if ((double)this.squidRotation > (Math.PI * 2D))
		{
			if (this.world.isRemote)
			{
				this.squidRotation = ((float)Math.PI * 2F);
			}
			else
			{
				this.squidRotation = (float)((double)this.squidRotation - (Math.PI * 2D));

				if (this.rand.nextInt(10) == 0)
				{
					this.rotationVelocity = 1.0F / (this.rand.nextFloat() + 1.0F) * 0.2F;
				}

				this.world.setEntityState(this, (byte)19);
			}
		}

		if (this.squidRotation < (float)Math.PI)
		{
			float f = this.squidRotation / (float)Math.PI;
			this.tentacleAngle = MathHelper.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;

			if ((double)f > 0.75D)
			{
				this.randomMotionSpeed = 1.0F;
				this.rotateSpeed = 1.0F;
			}
			else
			{
				this.rotateSpeed *= 0.8F;
			}
		}
		else
		{
			this.tentacleAngle = 0.0F;
			this.randomMotionSpeed *= 0.9F;
			this.rotateSpeed *= 0.99F;
		}

		if (!this.world.isRemote)
		{
			this.motionX = (double)(this.randomMotionVecX * this.randomMotionSpeed);
			this.motionY = (double)(this.randomMotionVecY * this.randomMotionSpeed);
			this.motionZ = (double)(this.randomMotionVecZ * this.randomMotionSpeed);
		}

		float f1 = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
		this.renderYawOffset += (-((float)MathHelper.atan2(this.motionX, this.motionZ)) * (180F / (float)Math.PI) - this.renderYawOffset) * 0.1F;
		this.rotationYaw = this.renderYawOffset;
		this.squidYaw = (float)((double)this.squidYaw + Math.PI * (double)this.rotateSpeed * 1.5D);
		this.squidPitch += (-((float)MathHelper.atan2((double)f1, this.motionY)) * (180F / (float)Math.PI) - this.squidPitch) * 0.1F;
	}

	public void travel(float strafe, float vertical, float forward)
	{
		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	}

	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id)
	{
		if (id == 19)
		{
			this.squidRotation = 0.0F;
		}
		else
		{
			super.handleStatusUpdate(id);
		}
	}

	public void setMovementVector(float randomMotionVecXIn, float randomMotionVecYIn, float randomMotionVecZIn)
	{
		this.randomMotionVecX = randomMotionVecXIn;
		this.randomMotionVecY = randomMotionVecYIn;
		this.randomMotionVecZ = randomMotionVecZIn;
	}

	public boolean hasMovementVector()
	{
		return this.randomMotionVecX != 0.0F || this.randomMotionVecY != 0.0F || this.randomMotionVecZ != 0.0F;
	}

	static class AIMoveRandom extends EntityAIBase
	{
		private final EntityJellyfish squid;

		public AIMoveRandom(EntityJellyfish entityJellyfish)
		{
			this.squid = entityJellyfish;
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute()
		{
			return true;
		}

		/**
		 * Keep ticking a continuous task that has already been started
		 */
		public void updateTask()
		{
			int i = this.squid.getIdleTime();

			if (i > 100)
			{
				this.squid.setMovementVector(0.0F, 0.0F, 0.0F);
			}
			else// if (this.squid.getRNG().nextInt(50) == 0 || !this.squid.hasMovementVector())
			{
				float f = this.squid.getRNG().nextFloat() * ((float)Math.PI * 2F);
				float f1 = MathHelper.cos(f) * 0.2F;
				float f2 = -0.1F + this.squid.getRNG().nextFloat() * 0.2F;
				float f3 = MathHelper.sin(f) * 0.2F;
				this.squid.setMovementVector(f1, f2, f3);
			}
		}
	}
}