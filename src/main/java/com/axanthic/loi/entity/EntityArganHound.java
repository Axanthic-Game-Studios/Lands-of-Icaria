package com.axanthic.loi.entity;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityArganHound extends EntityMob {

	public EntityArganHound(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 1.0F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityIronGolem.class, true));
		this.targetTasks.addTask(4, new EntityAINearestAttackableTarget(this, EntityCerver.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityRevenantCaptain.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityRevenantCivilian.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityRevenantCrawler.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityRevenantOvergrown.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityRevenantSoldier.class, true));
	}

	/**
	 * Returns the Y offset from the entity's position for any entity riding this one.
	 */
	public double getMountedYOffset() {
		return (double)(this.height * 0.5F);
	}

	/**
	 * Returns new PathNavigateGround instance
	 */
	protected PathNavigate createNavigator(World worldIn) {
		return new PathNavigateClimber(this, worldIn);
	}

	protected void entityInit() {
		super.entityInit();
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		super.onUpdate();
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_WOLF_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_WOLF_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_WOLF_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
	}

	protected float getSoundVolume() {
		return 1.5F;
	}

	protected float getSoundPitch() {
		return 0.8F;
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
				this.entityDropItem(new ItemStack(Resources.mobHeadArganHound, 1, 0), 0.0F);
			}
		}
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_ARGAN_HOUND;
	}

	public float getEyeHeight() {
		return 0.8F;
	}
}