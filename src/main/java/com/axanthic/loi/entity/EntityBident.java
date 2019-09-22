package com.axanthic.loi.entity;

import javax.annotation.Nonnull;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SPacketChangeGameState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBident extends EntityArrow {

	private static final DataParameter<ItemStack> BIDENT = EntityDataManager.<ItemStack>createKey(EntityBident.class, DataSerializers.ITEM_STACK);
	private ItemStack bident = ItemStack.EMPTY;

	public EntityBident(World worldIn) {
		super(worldIn);
	}

	public EntityBident(World worldIn, EntityLivingBase shooter) {
		super(worldIn, shooter);
		this.bident = shooter.getActiveItemStack();
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		this.dataManager.register(BIDENT, bident);
	}

	public void setItemStack(ItemStack item) {
		dataManager.set(BIDENT, item);
		this.bident = item;
	}

	@Override
	public ItemStack getArrowStack() {
		bident = dataManager.get(BIDENT);
		return bident;
	}

	@Override
	public void writeEntityToNBT(@Nonnull NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		NBTTagCompound stackTag = new NBTTagCompound();
		bident.writeToNBT(stackTag);
		compound.setTag("stack", stackTag);
	}

	@Override
	public void readEntityFromNBT(@Nonnull NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		NBTTagCompound stackTag = compound.getCompoundTag("stack");
		bident = new ItemStack(stackTag);
	}

	@Override
	protected void onHit(RayTraceResult raytraceResult) {
		Entity entity = raytraceResult.entityHit;
		if (raytraceResult != null && raytraceResult.entityHit instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer) raytraceResult.entityHit;

			if (this.shootingEntity instanceof EntityPlayer && !((EntityPlayer) this.shootingEntity).canAttackPlayer(entityplayer)) {
				raytraceResult = null;
			}
		}

		if (raytraceResult != null && entity != null && raytraceResult.typeOfHit == RayTraceResult.Type.ENTITY) {
			float f = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
			int i = MathHelper.ceil((double) f * this.getDamage());
			if (this.getIsCritical()) {
				i += this.rand.nextInt(i / 2 + 2);
			}

			DamageSource damagesource;

			if (this.shootingEntity == null) {
				damagesource = DamageSource.causeArrowDamage(this, this);
			} else {
				damagesource = DamageSource.causeArrowDamage(this, this.shootingEntity);
			}

			if (this.isBurning() && !(entity instanceof EntityEnderman)) {
				entity.setFire(5);
			}

			if (entity.attackEntityFrom(damagesource, (float) i)) {
				if (entity instanceof EntityLivingBase) {
					EntityLivingBase entitylivingbase = (EntityLivingBase) entity;

					if (!this.world.isRemote) {
						entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
					}

					if (this.shootingEntity instanceof EntityLivingBase) {
						EnchantmentHelper.applyThornEnchantments(entitylivingbase, this.shootingEntity);
						EnchantmentHelper.applyArthropodEnchantments(new EntityItemContainer(world, bident), entitylivingbase);
					}

					this.arrowHit(entitylivingbase);

					if (this.shootingEntity != null && entitylivingbase != this.shootingEntity && entitylivingbase instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP) {
						((EntityPlayerMP) this.shootingEntity).connection.sendPacket(new SPacketChangeGameState(6, 0.0F));
					}
				}
			}
		}
		super.onHit(raytraceResult);
		this.isDead = false;
	}
}
