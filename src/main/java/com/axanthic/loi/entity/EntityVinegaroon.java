package com.axanthic.loi.entity;

import com.axanthic.loi.utils.IcariaSounds;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityVinegaroon extends EntityMob {

	private static final DataParameter<Integer> ACIDTIMER = EntityDataManager.createKey((Class) EntityVinegaroon.class,
			DataSerializers.VARINT);
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntityVinegaroon.class,
			DataSerializers.BYTE);

	public EntityVinegaroon(World worldIn) {
		super(worldIn);
		this.experienceValue = 5;
		setSize(2.0F, 1.0F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(35D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(8D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(ACIDTIMER, 0);
		this.dataManager.register(CLIMBING, (byte) 0);
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(3, new EntityAIRestrictSun(this));
		this.tasks.addTask(4, new EntityAIFleeSun(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 0.8D));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAIWatchClosest(this, EntitySow.class, 8.0F));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.2F, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<>(this, EntitySow.class, true));
	}

	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
	}

	public void setInWeb() {
	}

	public boolean isPotionApplicable(PotionEffect potioneffectIn) {
		return potioneffectIn.getPotion() != MobEffects.POISON && super.isPotionApplicable(potioneffectIn);
	}

	public boolean isBesideClimbableBlock() {
		return (this.dataManager.get(CLIMBING) & 1) != 0;
	}

	public void setBesideClimbableBlock(boolean climbing) {
		byte b0 = this.dataManager.get(CLIMBING);

		if (climbing) {
			b0 = (byte) (b0 | 1);
		} else {
			b0 = (byte) (b0 & -2);
		}

		this.dataManager.set(CLIMBING, b0);
	}

	protected SoundEvent getAmbientSound() {
		return IcariaSounds.SCORPION_IDLE;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return IcariaSounds.SCORPION_HURT;
	}

	protected SoundEvent getDeathSound() {
		return IcariaSounds.SCORPION_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 0.75F);
	}

	protected float getSoundPitch() {
		return (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 0.75F;
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	public int getMaxSpawnedInChunk() {
		return 1;
	}

	public float getEyeHeight() {
		return 0.75F;
	}

	protected int decreaseAirSupply(int air) {
		return air - 10;
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	public void onUpdate() {
		super.onUpdate();
		if (!this.world.isRemote && !this.IsJumpingUp()) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}
		if (this.getAttackTarget() != null) {
			final float distance = (float) this.getDistance(this.getAttackTarget().posX,
					this.getAttackTarget().getEntityBoundingBox().minY, this.getAttackTarget().posZ);
			if (this.getTailTimer() < 100 && distance > 3.0f) {
				this.setTailTimer(this.getTailTimer() + 2);
			} else {
				this.setTailTimer(0);
			}
			if (this.getTailTimer() >= 100 && distance > 3.0f) {
				this.shootVinegar(this.getAttackTarget(), distance);
			}
		}
	}

	public boolean IsJumpingUp() {
		return this.isJumping;
	}

	public void onLivingUpdate() {
		if (!this.getPassengers().isEmpty()) {
			Entity passenger = this.getPassengers().get(0);
			boolean creativeMode = false;
			if (passenger instanceof EntityPlayer)
				creativeMode = ((EntityPlayer)passenger).isCreative();

			// workaround to make fangs non-ejectable
			if (!creativeMode && passenger.isSneaking()) {
				passenger.setSneaking(false);
			}
		}
		super.onLivingUpdate();
		if (!this.getPassengers().isEmpty()) {
			this.getLookHelper().setLookPositionWithEntity(this.getPassengers().get(0), 100.0f, 100.0f);
			final Vec3d riderPos = this.getRiderPosition();
			this.pushOutOfBlocks(riderPos.x, riderPos.y, riderPos.z);
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = this.getPassengers().isEmpty() && entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
				(float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
		if (this.getPassengers().isEmpty() && !entityIn.isRiding()) {
			entityIn.startRiding(this);
		}
		return flag;
	}

	public void setTailTimer(final int size) {
		this.dataManager.set(ACIDTIMER, size);
	}

	public int getTailTimer() {
		return this.dataManager.get(ACIDTIMER);
	}

	protected void shootVinegar(final Entity entity, final float distance) {
		if (distance < 16.0f && entity instanceof EntityLivingBase) {
			final double targetX = entity.posX - this.posX;
			final double targetY = entity.getEntityBoundingBox().minY + entity.height - (this.posY + this.height);
			final double targetZ = entity.posZ - this.posZ;
			this.getEntityWorld().playSound(null, this.getPosition(), SoundEvents.BLOCK_SLIME_PLACE,
					SoundCategory.HOSTILE, 1.0f, 1.0f);
			this.setTailTimer(0);
			final EntityVinegar projectile = new EntityVinegar(this.getEntityWorld(), this);
			projectile.posY = this.posY + this.height + 0.42;
			projectile.shoot(targetX, targetY, targetZ, 1.2f, 0.0f);
			this.getEntityWorld().spawnEntity(projectile);
		}
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	public void updatePassenger(final Entity passenger) {
		if (!this.getPassengers().isEmpty()) {
			final Vec3d riderPos = this.getRiderPosition();
			this.getPassengers().get(0).setPosition(riderPos.x, riderPos.y, riderPos.z);
			passenger.attackEntityFrom(DamageSource.causeMobDamage(this).setDamageBypassesArmor(), 1.0f);
		}
	}

	public double getMountedYOffset() {
		return 0.5;
	}

	private Vec3d getRiderPosition() {
		if (!this.getPassengers().isEmpty()) {
			final float distance = 0.8f;
			final double var1 = Math.cos((this.rotationYaw + 90.0f) * 3.141592653589793 / 180.0) * distance;
			final double var2 = Math.sin((this.rotationYaw + 90.0f) * 3.141592653589793 / 180.0) * distance;
			return new Vec3d(this.posX + var1,
					this.posY + this.getMountedYOffset() + this.getPassengers().get(0).getYOffset(), this.posZ + var2);
		}
		return new Vec3d(this.posX, this.posY, this.posZ);
	}

	public boolean canRiderInteract() {
		return true;
	}
}