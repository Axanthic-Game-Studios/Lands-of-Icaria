package com.axanthic.loi.entity;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntitySnull extends EntityCreature {

	public EntitySnull(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.8F);
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.1D);
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

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.3F;
	}

	protected float getSoundPitch() {
		return 0.3F;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_SNULL;
	}

	public int getTalkInterval() {
		return 120;
	}

	protected boolean canDespawn() {
		return false;
	}

	protected int getExperiencePoints(EntityPlayer player) {
		return 1 + this.world.rand.nextInt(3);
	}

	public float getEyeHeight() {
		return 0.9F;
	}

	public double getYOffset() {
		return 0.14D;
	}
}