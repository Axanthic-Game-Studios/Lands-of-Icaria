package com.axanthic.blab.entity;

import java.util.Random;
import java.util.UUID;
import javax.annotation.Nullable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityForestHag extends EntityMob {
	private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final AttributeModifier ATTACKING_SPEED_BOOST = (new AttributeModifier(ATTACKING_SPEED_BOOST_ID, "Attacking speed boost", 0.15000000596046448D, 0)).setSaved(false);
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(EntityForestHag.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Integer> TYPE = EntityDataManager.<Integer>createKey(EntityForestHag.class, DataSerializers.VARINT);
	private int lastCreepySound;
	private int targetChangeTime;

	public EntityForestHag(World worldIn) {
		super(worldIn);
		this.setSize(0.6F, 2.9F);
		this.stepHeight = 1.0F;
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, false));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.30000001192092896D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(7.0D);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
		super.setAttackTarget(entitylivingbaseIn);
		IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);

		if (entitylivingbaseIn == null) {
			this.targetChangeTime = 0;
			this.dataManager.set(SCREAMING, Boolean.valueOf(false));
			iattributeinstance.removeModifier(ATTACKING_SPEED_BOOST);
		} else {
			this.targetChangeTime = this.ticksExisted;
			this.dataManager.set(SCREAMING, Boolean.valueOf(true));

			if (!iattributeinstance.hasModifier(ATTACKING_SPEED_BOOST)) {
				iattributeinstance.applyModifier(ATTACKING_SPEED_BOOST);
			}
		}
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SCREAMING, Boolean.valueOf(false));
		this.dataManager.register(TYPE, new Random().nextInt(7));
	}

	public void playEndermanSound() {
		if (this.ticksExisted >= this.lastCreepySound + 400) {
			this.lastCreepySound = this.ticksExisted;

			if (!this.isSilent()) {
				this.world.playSound(this.posX, this.posY + (double) this.getEyeHeight(), this.posZ, SoundEvents.ENTITY_ENDERMEN_STARE, this.getSoundCategory(), 2.5F, 1.0F, false);
			}
		}
	}

	public void notifyDataManagerChange(DataParameter<?> key) {
		if (SCREAMING.equals(key) && this.isScreaming() && this.world.isRemote) {
			this.playEndermanSound();
		}
		super.notifyDataManagerChange(key);
	}

	public static void registerFixesEnderman(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityForestHag.class);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("type", this.getType());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		if (compound.hasKey("type"))
			this.dataManager.set(TYPE, compound.getInteger("type"));
	}

	public float getEyeHeight() {
		return 2.55F;
	}

	/**
	 * Called frequently so the entity can update its state every tick as required.
	 * For example, zombies and skeletons use this to react to sunlight and start to
	 * burn.
	 */
	public void onLivingUpdate() {
		this.isJumping = false;
		super.onLivingUpdate();
	}

	protected SoundEvent getAmbientSound() {
		return this.isScreaming() ? SoundEvents.ENTITY_ENDERMEN_SCREAM : SoundEvents.ENTITY_ENDERMEN_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_ENDERMEN_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_ENDERMEN_DEATH;
	}

	/**
	 * Drop the equipment for this entity.
	 */
	protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
		super.dropEquipment(wasRecentlyHit, lootingModifier);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return LootTableList.ENTITIES_ENDERMAN;
	}

	public boolean isScreaming() {
		return ((Boolean) this.dataManager.get(SCREAMING)).booleanValue();
	}

	public int getType() {
		return this.dataManager.get(TYPE);
	}

	public void setType(int type) {
		this.dataManager.set(TYPE, type);
	}

	public void despawnEntity() {
	}
}