package com.axanthic.loi.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityAeternae extends EntityAnimal {

	private int eatTimer;
	private EntityAIEatMarlGrass entityAIEatGrass;
    private static final UUID ATTACK_SPEED_BOOST_MODIFIER_UUID = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23B1718");
	private static final AttributeModifier ATTACK_SPEED_BOOST_MODIFIER = (new AttributeModifier(ATTACK_SPEED_BOOST_MODIFIER_UUID, "Attacking speed boost", 0.5D, 1)).setSaved(false);
    private int angerLevel;
    private UUID angerTargetUUID;

	public EntityAeternae(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 1.5F);
		this.spawnableBlock = Resources.grass.getBlock();
	}

	public static void registerFixesCow(DataFixer fixer) {
		EntityLiving.registerFixesMob(fixer, EntityAeternae.class);
	}

	protected void initEntityAI() {
		entityAIEatGrass = new EntityAIEatMarlGrass(this);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.WHEAT, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(6, entityAIEatGrass);
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new AIHurtByAggressor(this));
		this.targetTasks.addTask(2, new AITargetAggressor(this));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000298023224D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	protected SoundEvent getAmbientSound() {
		return SoundEvents.ENTITY_COW_AMBIENT;
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return SoundEvents.ENTITY_COW_HURT;
	}

	protected SoundEvent getDeathSound() {
		return SoundEvents.ENTITY_COW_DEATH;
	}

	protected void playStepSound(BlockPos pos, Block blockIn) {
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F;
	}

	protected void updateAITasks() {
		this.eatTimer = this.entityAIEatGrass.getEatingGrassTimer();
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
		super.updateAITasks();
	}

	public void onLivingUpdate() {
		if (this.world.isRemote) {
			this.eatTimer = Math.max(0, this.eatTimer - 1);
		}
		updateArmSwingProgress();
		super.onLivingUpdate();
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
		if (flag) {
			this.applyEnchantments(this, entityIn);
		}
		this.swingArm(EnumHand.MAIN_HAND);
		return flag;
	}

	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.eatTimer = 40;
		} else {
			super.handleStatusUpdate(id);
		}
	}

	@SideOnly(Side.CLIENT)
	public float getHeadRotationAngleX(float partialTick) {
		if (this.eatTimer > 4 && this.eatTimer <= 36) {
			float f = ((float) (this.eatTimer - 4) - partialTick) /64.0F;
			return ((float) Math.PI / 5F) + ((float) Math.PI * 7F / 100F) * MathHelper.sin(f * 28.7F);
		} else if (this.eatTimer > 0) {
			return ((float) Math.PI / 5F);
		}
		float swing = this.getSwingProgress(partialTick);
		if (swing > 0 && swing != 1) {
			if (swing < 0.5F)
				return swing * 4;
			return (swing - 0.5F) * -4 + 2;
		}
		return this.rotationPitch * 0.017453292F;
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_AETERNAE;
	}

	public EntityAeternae createChild(EntityAgeable ageable) {
		return new EntityAeternae(this.world);
	}

	public void eatGrassBonus() {
		this.heal(3.0F);
		if (this.isChild()) {
			this.addGrowth(60);
		}
	}

	public float getEyeHeight() {
		return this.isChild() ? this.height : 1.9F;
	}

	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setShort("Anger", (short) this.angerLevel);

		if (this.angerTargetUUID != null) {
			compound.setString("HurtBy", this.angerTargetUUID.toString());
		} else {
			compound.setString("HurtBy", "");
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
	}

	private void becomeAngryAt(Entity p_70835_1_) {
		this.angerLevel = 400 + this.rand.nextInt(400);

		if (p_70835_1_ instanceof EntityLivingBase) {
			this.setRevengeTarget((EntityLivingBase) p_70835_1_);
		}
	}

	public boolean isAngry() {
		return this.angerLevel > 0;
	}

	static class AIHurtByAggressor extends EntityAIHurtByTarget {
		public AIHurtByAggressor(EntityAeternae p_i45828_1_) {
			super(p_i45828_1_, true);
		}

		protected void setEntityAttackTarget(EntityCreature creatureIn, EntityLivingBase entityLivingBaseIn) {
			super.setEntityAttackTarget(creatureIn, entityLivingBaseIn);

			if (creatureIn instanceof EntityAeternae) {
				((EntityAeternae) creatureIn).becomeAngryAt(entityLivingBaseIn);
			}
		}
	}

	static class AITargetAggressor extends EntityAINearestAttackableTarget<EntityPlayer> {
		public AITargetAggressor(EntityAeternae p_i45829_1_) {
			super(p_i45829_1_, EntityPlayer.class, true);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return ((EntityAeternae) this.taskOwner).isAngry() && super.shouldExecute();
		}
	}
}