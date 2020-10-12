package com.axanthic.loi.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class EntitySiren extends EntityMob {

	private static final DataParameter<Integer> STATE = EntityDataManager.<Integer>createKey(EntityCreeper.class, DataSerializers.VARINT);

	private int lastActiveTime;
	private int timeSinceIgnited;
	private int fuseTime = 20;

	public EntitySiren(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 1.95F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIScream(this));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(STATE, -1);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SKELETON_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SKELETON_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SKELETON_HURT;
	}

	protected SoundEvent getStepSound() {
		return SoundEvents.ENTITY_SKELETON_STEP;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(this.getStepSound(), 0.15F, 1.0F);
	}

	public EnumCreatureAttribute getCreatureAttribute() {
		return EnumCreatureAttribute.UNDEAD;
	}

	public float getEyeHeight() {
		return 1.8F;
	}

	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setShort("Fuse", (short)this.fuseTime);
	}

	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		if (compound.hasKey("Fuse", 99))
		{
			this.fuseTime = compound.getShort("Fuse");
		}
	}

	public int getCreeperState()
	{
		return this.dataManager.get(STATE);
	}

	public void setCreeperState(int state)
	{
		this.dataManager.set(STATE, state);
	}

	public void onUpdate()
	{
		if (this.isEntityAlive())
		{
			this.lastActiveTime = this.timeSinceIgnited;

			int i = this.getCreeperState();
			this.timeSinceIgnited += i;

			if (this.timeSinceIgnited < 0)
			{
				this.timeSinceIgnited = 0;
			}

			if (this.timeSinceIgnited >= this.fuseTime)
			{
				this.timeSinceIgnited = this.fuseTime;
				this.scream();
			}
		}
		super.onUpdate();
	}

	private void scream()
	{
		if (!this.world.isRemote)
		{
			List list = world.getEntitiesWithinAABB(EntityPlayer.class, this.getEntityBoundingBox().expand(10.0D, 10.0D, 10.0D));
				for (int i = 0; i < list.size(); i++) {
				Object o = list.get(i);
					if (o instanceof EntityPlayer) {
						((Entity) o).attackEntityFrom(DamageSource.WITHER, 4.0F);
						this.playSound(SoundEvents.ENTITY_ENDERMEN_SCREAM, 2.0F, 0.4F);
				}
			}
		}
	}

	static class EntityAIScream extends EntityAIBase
	{
		EntitySiren screamer;
		EntityLivingBase target;

		public EntityAIScream(EntitySiren entitycreeperIn)
		{
			this.screamer = entitycreeperIn;
			this.setMutexBits(1);
		}

		public boolean shouldExecute()
		{
			EntityLivingBase entitylivingbase = this.screamer.getAttackTarget();
			return this.screamer.getCreeperState() > 0 || entitylivingbase != null && this.screamer.getDistanceSq(entitylivingbase) < 9.0D;
		}

		public void startExecuting()
		{
			this.screamer.getNavigator().clearPath();
			this.target = this.screamer.getAttackTarget();
		}

		public void resetTask()
		{
			this.target = null;
		}

		public void updateTask()
		{
			if (this.target == null)
			{
				this.screamer.setCreeperState(-1);
			}
			else if (this.screamer.getDistanceSq(this.target) > 49.0D)
			{
				this.screamer.setCreeperState(-1);
			}
			else if (!this.screamer.getEntitySenses().canSee(this.target))
			{
				this.screamer.setCreeperState(-1);
			}
			else
			{
				this.screamer.setCreeperState(1);
			}
		}
	}
}