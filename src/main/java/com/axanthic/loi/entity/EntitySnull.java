package com.axanthic.loi.entity;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntitySnull extends EntityCreature {

	private static final DataParameter<Float> SNULL_SIZE = EntityDataManager.createKey(EntitySnull.class, DataSerializers.FLOAT);
	private static final float hitboxSize = 0.25F;
	private static final DataParameter<Byte> CLIMBING = EntityDataManager.createKey(EntitySnull.class,
			DataSerializers.BYTE);

	public EntitySnull(World worldIn) {
		super(worldIn);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(SNULL_SIZE, 1F);
		this.dataManager.register(CLIMBING, (byte) 0);
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	protected void setSnullSize(float size, boolean resetHealth)
	{
		this.dataManager.set(SNULL_SIZE, size);
		this.setSize(hitboxSize * size, hitboxSize * size);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D * (size / 2));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.04F * size);

		if (resetHealth)
		{
			this.setHealth(this.getMaxHealth());
		}
	}

	public void notifyDataManagerChange(DataParameter<?> key)
	{
		if (SNULL_SIZE.equals(key))
		{
			float i = this.getSnullSize();
			this.setSize(hitboxSize * i, hitboxSize * i);
			this.rotationYaw = this.rotationYawHead;
			this.renderYawOffset = this.rotationYawHead;
		}

		super.notifyDataManagerChange(key);
	}

	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		float i = (this.rand.nextInt(5) / 0.9F) + 2.5F;
		this.setSnullSize(i, true);
		return super.onInitialSpawn(difficulty, livingdata);
	}

	public void onUpdate() {
		super.onUpdate();

		if (!this.world.isRemote && !this.IsJumpingUp()) {
			this.setBesideClimbableBlock(this.collidedHorizontally);
		}
	}

	/**
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if (cause.getTrueSource() instanceof EntityCreeper) {
			EntityCreeper entitycreeper = (EntityCreeper)cause.getTrueSource();
			if (entitycreeper.getPowered() && entitycreeper.ableToCauseSkullDrop()) {
				entitycreeper.incrementDroppedSkulls();
				this.entityDropItem(new ItemStack(Resources.mobHeadRevenant, 1, 0), 0.0F);
			}
		}
	}

	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setFloat("Size", this.getSnullSize());
	}

	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setSnullSize(compound.getFloat("Size"), false);
	}

	public float getSnullSize()
	{
		return this.dataManager.get(SNULL_SIZE);
	}

	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	public boolean IsJumpingUp() {
		return this.isJumping;
	}

	public boolean isOnLadder() {
		return this.isBesideClimbableBlock();
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

	@Override
	public void fall(float distance, float damageMultiplier) {
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.3F;
	}

	protected float getSoundPitch() {
		return 0.3F;
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_SLIME_SQUISH;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_SMALL_SLIME_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_SMALL_SLIME_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_SLIME_SQUISH, 0.25F, 0.3F);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_SNULL;
	}

	public int getTalkInterval() {
		return 120;
	}

	protected int getExperiencePoints(EntityPlayer player) {
		return 1 + this.world.rand.nextInt(3);
	}

	public double getYOffset() {
		return 0.14D;
	}

	public float getEyeHeight() {
		return 0.9F * this.height;
	}

	protected int decreaseAirSupply(int air) {
		return air - 10;
	}
}