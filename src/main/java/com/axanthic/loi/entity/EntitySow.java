package com.axanthic.loi.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntitySow extends EntityAnimal {

	private static final UUID ATTACK_SPEED_BOOST_MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23B1718");
	private static final AttributeModifier ATTACK_SPEED_BOOST_MODIFIER = (new AttributeModifier(ATTACK_SPEED_BOOST_MODIFIER_UUID, "Attacking speed boost", 0.5D, 1)).setSaved(false);
	private int angerLevel;
	private UUID angerTargetUUID;
	private int scaredLevel;
	private UUID scaredTargetUUID;
	private EntityPlayer scaredTarget;
	private int scaredTimer;

	public EntitySow(World worldIn) {
		super(worldIn);
		this.setSize(0.8F, 0.9F);
		this.spawnableBlock = Resources.grass.getBlock();
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new AIHurtByAggressor(this));
		this.targetTasks.addTask(2, new AITargetAggressor(this));
		this.targetTasks.addTask(3, new AIFleeAggressor(this));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_PIG_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_PIG_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_PIG_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
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
				this.entityDropItem(new ItemStack(Resources.mobHeadSow, 1, 0), 0.0F);
			}
		}
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	protected void updateAITasks() {
		IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED);
		if (this.isAngry()) {
			if (!this.isChild() && !iattributeinstance.hasModifier(ATTACK_SPEED_BOOST_MODIFIER)) {
				iattributeinstance.applyModifier(ATTACK_SPEED_BOOST_MODIFIER);
			}
			--this.angerLevel;
		} else if (iattributeinstance.hasModifier(ATTACK_SPEED_BOOST_MODIFIER)) {
			iattributeinstance.removeModifier(ATTACK_SPEED_BOOST_MODIFIER);
		}
		if (this.angerLevel > 0 && this.angerTargetUUID != null && this.getRevengeTarget() == null) {
			EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
			this.setRevengeTarget(entityplayer);
			this.attackingPlayer = entityplayer;
			this.recentlyHit = this.getRevengeTimer();
		}

		if (this.isScared())
			--this.scaredLevel;
		if (this.scaredLevel > 0 && this.scaredTargetUUID != null && this.scaredTarget == null) {
			EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.scaredTargetUUID);
			this.setScaredTarget(entityplayer);
		}
		super.updateAITasks();
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}
		this.swingArm(EnumHand.MAIN_HAND);
		return flag;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_SOW;
	}

	public EntitySow createChild(EntityAgeable ageable) {
		return new EntitySow(this.world);
	}

	public float getEyeHeight() {
		return this.isChild() ? 0.5F : 0.7F;
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setShort("Anger", (short) this.angerLevel);

		if (this.angerTargetUUID != null) {
			compound.setString("HurtBy", this.angerTargetUUID.toString());
		} else {
			compound.setString("HurtBy", "");
		}

		compound.setShort("Fear", (short) this.scaredLevel);

		if (this.angerTargetUUID != null) {
			compound.setString("ScaredOf", this.scaredTargetUUID.toString());
		} else {
			compound.setString("ScaredOf", "");
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.angerLevel = compound.getShort("Anger");
		String s = compound.getString("HurtBy");

		if (!s.isEmpty()) {
			this.angerTargetUUID = UUID.fromString(s);
			EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.angerTargetUUID);
			this.setRevengeTarget(entityplayer);

			if (entityplayer != null) {
				this.attackingPlayer = entityplayer;
				this.recentlyHit = this.getRevengeTimer();
			}
		}

		this.scaredLevel = compound.getShort("Fear");
		String b = compound.getString("ScaredOf");

		if (!b.isEmpty()) {
			this.scaredTargetUUID = UUID.fromString(b);
			EntityPlayer entityplayer = this.world.getPlayerEntityByUUID(this.scaredTargetUUID);
			this.setScaredTarget(entityplayer);
		}
	}

	private void becomeAngryAt(Entity p_70835_1_) {
		this.angerLevel = 400 + this.rand.nextInt(400);

		if (p_70835_1_ instanceof EntityLivingBase) {
			this.setRevengeTarget((EntityLivingBase) p_70835_1_);
		}
	}

	public void becomeScaredOf(Entity p_70835_1_) {
		this.scaredLevel = 100 + this.rand.nextInt(100);

		if (p_70835_1_ instanceof EntityPlayer) {
			this.setScaredTarget((EntityPlayer) p_70835_1_);
		}
	}

	public void setScaredTarget(@Nullable EntityPlayer livingBase)
	{
		this.scaredTarget = livingBase;
		if (livingBase == null)
			this.scaredTargetUUID = null;
		else
			this.scaredTargetUUID = livingBase.getUniqueID();
		this.scaredTimer = this.ticksExisted;
	}

	public boolean isAngry() {
		return this.angerLevel > 0;
	}

	public boolean isScared() {
		return this.scaredLevel > 0;
	}

	static class AIHurtByAggressor extends EntityAIHurtByTarget {
		public AIHurtByAggressor(EntitySow entity) {
			super(entity, true);
		}

		protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn) {
			super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

			if (creatureIn instanceof EntitySow) {
				((EntitySow) creatureIn).becomeAngryAt(entityLivingBaseIn);
			}
		}

		protected void alertOthers() {
			double d0 = this.getTargetDistance();

			for (EntityCreature entitycreature : this.taskOwner.world.getEntitiesWithinAABB(this.taskOwner.getClass(), (new AxisAlignedBB(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0D, this.taskOwner.posY + 1.0D, this.taskOwner.posZ + 1.0D)).grow(d0, 10.0D, d0))) {
				if (this.taskOwner != entitycreature && (!(this.taskOwner instanceof EntityTameable) || ((EntityTameable)this.taskOwner).getOwner() == ((EntityTameable)entitycreature).getOwner()) && !entitycreature.isOnSameTeam(this.taskOwner.getRevengeTarget())) {
					if (entitycreature instanceof EntitySow) {
						((EntitySow) entitycreature).becomeScaredOf(this.taskOwner.getRevengeTarget());
					}
				}
			}
		}
	}

	static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer> {
		public AITargetAggressor(EntitySow entity) {
			super(entity, EntityPlayer.class, true);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return ((EntitySow) this.taskOwner).isAngry() && super.shouldExecute();
		}
	}

	static class AIFleeAggressor extends EntityAIAvoidEntity<EntityPlayer> {

		/** The PathEntity of our entity */
		private Path path;
		/** The PathNavigate of our entity */
		private final PathNavigate navigation;
		private final double farSpeed = 1.2D;
		private final double nearSpeed = 1.8D;

		public AIFleeAggressor(EntitySow entity) {
			super(entity, EntityPlayer.class, 8.0F, 1.2D, 1.8D);
			this.navigation = entity.getNavigator();
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			if (!((EntitySow) this.entity).isScared() || ((EntitySow) this.entity).scaredTarget == null)
				return false;

			this.closestLivingEntity = ((EntitySow) this.entity).scaredTarget;
			Vec3d vec3d = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.entity, 16, 7, new Vec3d(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));

			if (vec3d == null) {
				return false;
			} else if (this.closestLivingEntity.getDistanceSq(vec3d.x, vec3d.y, vec3d.z) < this.closestLivingEntity.getDistanceSq(this.entity)) {
				return false;
			} else {
				this.path = this.navigation.getPathToXYZ(vec3d.x, vec3d.y, vec3d.z);
				return this.path != null;
			}
		}

		public boolean shouldContinueExecuting() {
			return !this.navigation.noPath();
		}

		public void startExecuting() {
			this.navigation.setPath(this.path, this.farSpeed);
		}
	}
}