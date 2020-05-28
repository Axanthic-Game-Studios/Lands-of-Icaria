package com.axanthic.loi.entity;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockGreekFire;
import com.axanthic.loi.items.ItemGrenade;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackRangedBow;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityRevenantPyromancer extends EntityRevenant implements IRangedAttackMob {

	private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(EntityRevenantPyromancer.class, DataSerializers.BOOLEAN);

	public EntityRevenantPyromancer(World worldIn) {
		super(worldIn);
	}

	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIRevenantReloadBomb(this, 80));
		this.tasks.addTask(4, new EntityAIRevenantAttackRangedBomb(this, 1.0D, 10, 15.0F));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.applyEntityAI();
	}

	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(SWINGING_ARMS, Boolean.valueOf(false));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_REVENANT_PYROMANCER;
	}

	public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if (cause.getImmediateSource() != null && !(cause.getImmediateSource() instanceof EntityPlayer) && cause.getImmediateSource().isBurning()) {
			Explosion explosion = world.createExplosion(this, posX, posY, posZ, 2.5f, true);
			BlockPos thisPos = new BlockPos(this);

			for (BlockPos blockpos : BlockPos.getAllInBox(thisPos.add(-3, -3, -3), thisPos.add(3, 3, 3))) {
				if (world.getBlockState(blockpos).getMaterial() == Material.AIR && (this.world.getBlockState(blockpos.down()).isFullBlock() || BlockGreekFire.canNeighborCatchFire(world, blockpos)) && rand.nextInt(3) == 0) {
					world.setBlockState(blockpos, Resources.greekFire.getBlock().getDefaultState());
				}
			}
		}
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.grenade));
	}

	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
		EntityGrenade entityGrenade = new EntityGrenade(world, this);
		double d0 = target.posX - this.posX;
		double d1 = target.getEntityBoundingBox().minY + (double)(target.height / 3.0F) - entityGrenade.posY;
		double d2 = target.posZ - this.posZ;
		double d3 = (double)MathHelper.sqrt(d0 * d0 + d2 * d2);
		entityGrenade.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 0.75F, (float)(14 - this.world.getDifficulty().getDifficultyId() * 4));
		this.playSound(SoundEvents.ENTITY_SNOWBALL_THROW, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(entityGrenade);
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.EMPTY);
	}

	@SideOnly(Side.CLIENT)
	public boolean isSwingingArms() {
		return ((Boolean)this.dataManager.get(SWINGING_ARMS)).booleanValue();
	}

	public void setSwingingArms(boolean swingingArms) {
		this.dataManager.set(SWINGING_ARMS, Boolean.valueOf(swingingArms));
	}

	static public class EntityAIRevenantAttackRangedBomb extends EntityAIAttackRangedBow<EntityRevenantPyromancer> {

		private final EntityRevenantPyromancer entity;

		public EntityAIRevenantAttackRangedBomb(EntityRevenantPyromancer entity, double moveSpeedAmp, int attackCooldown, float attackDistance) {
			super(entity, moveSpeedAmp, attackCooldown, attackDistance);
			this.entity = entity;
		}

		protected boolean isBowInMainhand() {
			return !this.entity.getHeldItemMainhand().isEmpty() && this.entity.getHeldItemMainhand().getItem() instanceof ItemGrenade;
		}
	}

	static public class EntityAIRevenantReloadBomb<T extends EntityRevenant> extends EntityAIBase {

		private final T entity;
		private int reloadCooldown;
		private int reloadTime = -1;

		public EntityAIRevenantReloadBomb(T entity, int cooldown) {
			this.entity = entity;
			this.reloadCooldown = cooldown;
		}

		@Override
		public boolean shouldContinueExecuting() {
			return !entity.hasItemInSlot(EntityEquipmentSlot.MAINHAND);
		}

		@Override
		public boolean shouldExecute() {
			return !entity.hasItemInSlot(EntityEquipmentSlot.MAINHAND) && reloadTime == -1;
		}

		@Override
		public void startExecuting() {
			super.startExecuting();
			reloadTime = reloadCooldown;
		}

		@Override
		public void resetTask() {
			super.resetTask();
			reloadTime = -1;
		}

		@Override
		public void updateTask() {
			super.updateTask();
			--reloadTime;
			if (reloadTime == 0) {
				entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.grenade));
				this.resetTask();
			}
		}
	}
}