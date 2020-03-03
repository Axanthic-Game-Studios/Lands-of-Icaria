package com.axanthic.loi.entity;

import java.util.UUID;
import javax.annotation.Nullable;

import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockPlanks.WoodTypes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public abstract class EntityForestHag extends EntityMob {
	private static final UUID ATTACKING_SPEED_BOOST_ID = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
	private static final DataParameter<Boolean> SCREAMING = EntityDataManager.<Boolean>createKey(EntityForestHag.class, DataSerializers.BOOLEAN);
	private int lastCreepySound;
	private int targetChangeTime;
	public final int type;

	public EntityForestHag(World worldIn, int woodType) {
		super(worldIn);
		this.setSize(0.8F, 2.9F);
		this.stepHeight = 1.0F;
		this.type = woodType;
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.8D, false));
		this.tasks.addTask(2, new EntityAIWanderAvoidWater(this, 0.8D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.tasks.addTask(5, new EntityAIPlantSapling(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(14.0D);
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
		} else {
			this.targetChangeTime = this.ticksExisted;
			this.dataManager.set(SCREAMING, Boolean.valueOf(true));
		}
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SCREAMING, Boolean.valueOf(false));
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
		this.idleTime = 0;
		super.onLivingUpdate();
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {
		Entity entity = source.getTrueSource();
		if (entity != null && entity instanceof EntityLivingBase) {
			ItemStack weapon = ((EntityLivingBase) entity).getHeldItemMainhand();
			if ((weapon.getItem() instanceof ItemAxe || weapon.getItem().getToolClasses(weapon).contains("axe"))) {
				amount *= 2;
			}
		} else if (source.isFireDamage()) {
			amount *= 2;
		}
		return super.attackEntityFrom(source, amount);
	}

	public boolean attackEntityAsMob(Entity entityIn) {
		boolean flag = super.attackEntityAsMob(entityIn);
		if (flag && this.world.getDifficulty() != EnumDifficulty.PEACEFUL) {
			entityIn.addVelocity(0.0D, 0.35D, 0.0D);
		}
		return flag;
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
	 * Called when the mob's health reaches 0.
	 */
	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if (cause.getTrueSource() instanceof EntityCreeper) {
			EntityCreeper entitycreeper = (EntityCreeper)cause.getTrueSource();
			if (entitycreeper.getPowered() && entitycreeper.ableToCauseSkullDrop()) {
				entitycreeper.incrementDroppedSkulls();
				if (type == 0)
					this.entityDropItem(new ItemStack(Resources.mobHeadForesthagPlane, 1, 0), 0.0F);
				else if (type == 1)
					this.entityDropItem(new ItemStack(Resources.mobHeadForesthagPopulus, 1, 0), 0.0F);
				else if (type == 2)
					this.entityDropItem(new ItemStack(Resources.mobHeadForesthagCypress, 1, 0), 0.0F);
				else if (type == 3)
					this.entityDropItem(new ItemStack(Resources.mobHeadForesthagFir, 1, 0), 0.0F);
				else if (type == 4)
					this.entityDropItem(new ItemStack(Resources.mobHeadForesthagOlive, 1, 0), 0.0F);
				else if (type == 5)
					this.entityDropItem(new ItemStack(Resources.mobHeadForesthagLaurel, 1, 0), 0.0F);
				else
					this.entityDropItem(new ItemStack(Resources.mobHeadForesthagDroughtroot, 1, 0), 0.0F);
			}
		}
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.getWoodSetFromType(WoodTypes.byMetadata(type)).hagLoot;
	}

	public boolean isScreaming() {
		return ((Boolean) this.dataManager.get(SCREAMING)).booleanValue();
	}

	public void despawnEntity() {
	}

	public class EntityAIPlantSapling extends EntityAIBase {
		private final EntityLiving entity;
		private final World entityWorld;

		public EntityAIPlantSapling(EntityLiving entitylivingIn) {
			this.entity = entitylivingIn;
			this.entityWorld = entitylivingIn.world;
			this.setMutexBits(4);
		}

		/**
		 * Returns whether the EntityAIBase should begin execution.
		 */
		public boolean shouldExecute() {
			return this.entity.getRNG().nextInt(5000) == 0;
		}

		/**
		 * Execute a one shot task or start executing a continuous task
		 */
		public void startExecuting() {
			BlockPos pos = new BlockPos(this.entity.posX, this.entity.posY, this.entity.posZ);
			IBlockState state = this.entityWorld.getBlockState(pos.down());

			if (this.entityWorld.isAirBlock(pos) && state.getBlock().canSustainPlant(state, this.entityWorld, pos.down(), net.minecraft.util.EnumFacing.UP, (IPlantable) Blocks.SAPLING) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.entity)) {
				this.entityWorld.setBlockState(pos, Resources.getWoodSetFromType(WoodTypes.byMetadata(type)).sapling.getBlock().getDefaultState(), 2);
			}
		}
	}
}