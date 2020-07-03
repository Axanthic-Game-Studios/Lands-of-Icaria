package com.axanthic.loi.entity;

import com.axanthic.loi.entity.ai.EntityAICharge;
import com.axanthic.loi.entity.ai.ICharger;
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
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntitySolifugae extends EntityMob implements ICharger {

	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntitySolifugae.class,
			DataSerializers.BYTE);
	private static final DataParameter<Boolean> CHARGING = EntityDataManager.createKey(EntitySolifugae.class,
			DataSerializers.BOOLEAN);

	public EntitySolifugae(World worldIn) {
		super(worldIn);
		this.experienceValue = 5;
		setSize(0.9F, 0.55F);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.32D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(22D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5D);
	}
	
	protected void initEntityAI() {
		this.tasks.addTask(6, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAICharge(this, 2.5f));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, false));
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(CLIMBING, (byte) 0);
		this.dataManager.register(CHARGING, false);
	}

	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	public void onUpdate() {
		super.onUpdate();

		if (!this.world.isRemote && !this.IsJumpingUp()) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		super.attackEntityAsMob(entityIn);
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this),
				(float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
		if (flag) {
			if (entityIn instanceof EntityLivingBase) {
				((EntityLivingBase) entityIn).knockBack(this, 0.22F,
						MathHelper.sin(this.rotationYaw * 0.017453292F),
						-MathHelper.cos(this.rotationYaw * 0.017453292F));
				this.motionX *= 0.6D;
				this.motionZ *= 0.6D;
			}
		}
		return flag;
	}

	public boolean IsJumpingUp() {
		return this.isJumping;
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
		return SoundEvents.ENTITY_SPIDER_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SPIDER_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SPIDER_DEATH;
	}

	protected float getSoundVolume() {
		return this.getAttackTarget() != null ? 3.5F : 1.0F;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_SPIDER_STEP, 0.15F, 0.75F);
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.ARTHROPOD;
	}

	public float getEyeHeight() {
		return 0.45F;
	}

	protected int decreaseAirSupply(int air) {
		return air - 10;
	}

	public int getMaxSpawnedInChunk() {
		return 1;
	}

	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier) {
	}
	
	@Override
    public boolean isCharging() {
        return this.dataManager.get(CHARGING);
    }
    
	@Override
    public void setCharging(final boolean flag) {
        this.dataManager.set(CHARGING, flag);
    }
}