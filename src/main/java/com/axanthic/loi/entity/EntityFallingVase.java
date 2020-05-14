package com.axanthic.loi.entity;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityFallingVase extends EntityFallingBlock {

	protected static final DataParameter<NBTTagCompound> NBT = EntityDataManager.<NBTTagCompound>createKey(EntityFallingVase.class, DataSerializers.COMPOUND_TAG);
	public IBlockState fallTile;

	public EntityFallingVase(World worldIn) {
		super(worldIn);
	}

	public EntityFallingVase(World worldIn, double x, double y, double z, IBlockState fallingBlockState) {
		super(worldIn, x, y, z, fallingBlockState);
		this.fallTile = fallingBlockState;

		NBTTagCompound compound = new NBTTagCompound();
		Block block = this.fallTile != null ? this.fallTile.getBlock() : Resources.lootVase.getBlock();
		ResourceLocation resourcelocation = Block.REGISTRY.getNameForObject(block);
		compound.setString("Block", resourcelocation == null ? "" : resourcelocation.toString());
		compound.setByte("Data", (byte)(this.fallTile != null ? block.getMetaFromState(this.fallTile) : 0));
		this.dataManager.set(NBT, compound);
	}

	public void updateRidden() {
		super.updateRidden();
		this.setRenderYawOffset(((EntityLivingBase)this.getRidingEntity()).renderYawOffset);
		Entity riding = this.getRidingEntity();

		if (this.getRidingEntity().isSneaking()) {
			this.dismountRidingEntity();

			float x = -MathHelper.sin(riding.rotationYaw * 0.017453292F) * MathHelper.cos(riding.rotationPitch * 0.017453292F);
			float y = -MathHelper.sin(riding.rotationPitch * 0.017453292F);
			float z = MathHelper.cos(riding.rotationYaw * 0.017453292F) * MathHelper.cos(riding.rotationPitch * 0.017453292F);

			this.motionX += riding.motionX * 0.6D;
			this.motionZ += riding.motionZ * 0.6D;
			if (!riding.onGround)
				this.motionY += riding.motionY * 0.6D;

			this.addVelocity(x, y, z);
			this.fallTime = 1;
		}
	}

	protected void entityInit() {
		super.entityInit();
		NBTTagCompound compound = new NBTTagCompound();
		Block block = this.fallTile != null ? this.fallTile.getBlock() : Resources.lootVase.getBlock();
		ResourceLocation resourcelocation = Block.REGISTRY.getNameForObject(block);
		compound.setString("Block", resourcelocation == null ? "" : resourcelocation.toString());
		compound.setByte("Data", (byte)(this.fallTile != null ? block.getMetaFromState(this.fallTile) : 0));
		this.dataManager.register(NBT, compound);
	}

	public double getYOffset() {
		return 0.5D;
	}

	public void onUpdate() {
		Block block = this.getBlock().getBlock();
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		if (this.fallTime++ == 0) {
			BlockPos blockpos = new BlockPos(this);

			if (this.world.getBlockState(blockpos).getBlock() == block) {
				this.world.setBlockToAir(blockpos);
			} else if (!this.world.isRemote) {
				this.setDead();
				return;
			}
		}

		if (!this.hasNoGravity()) {
			this.motionY -= 0.03999999910593033D;
		}

		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);

		if (!this.world.isRemote) {
			BlockPos blockpos1 = new BlockPos(this);
			double d0 = this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ;

			if (!this.onGround) {
				if (blockpos1.getY() < 0) {
					this.setDead();
				}
			} else {
				IBlockState iblockstate = this.world.getBlockState(blockpos1);

				if (this.world.isAirBlock(new BlockPos(this.posX, this.posY - 0.009999999776482582D, this.posZ))) //Forge: Don't indent below.
					if (!false && BlockFalling.canFallThrough(this.world.getBlockState(new BlockPos(this.posX, this.posY - 0.009999999776482582D, this.posZ)))) {
						this.onGround = false;
						return;
					}

				this.motionX *= 0.699999988079071D;
				this.motionZ *= 0.699999988079071D;
				this.motionY *= -0.5D;

				if (iblockstate.getBlock() != Blocks.PISTON_EXTENSION) {
					this.setDead();
					if (this.world.mayPlace(block, blockpos1, true, EnumFacing.UP, this) && !BlockFalling.canFallThrough(this.world.getBlockState(blockpos1.down())) && this.world.setBlockState(blockpos1, this.fallTile, 3)) {
						if (block instanceof BlockFalling) {
							((BlockFalling)block).onEndFalling(this.world, blockpos1, this.fallTile, iblockstate);
						}
					}
				}
			}
		}
		this.motionX *= 0.9800000190734863D;
		this.motionY *= 0.9800000190734863D;
		this.motionZ *= 0.9800000190734863D;
	}

	public void fall(float distance, float damageMultiplier) {

	}

	public void applyEntityCollision(Entity entityIn) {
		if (this.fallTime <3)
			return;
		super.applyEntityCollision(entityIn);
		if (entityIn.hurtResistantTime == 0) {
			entityIn.attackEntityFrom(DamageSource.FALLING_BLOCK, (float)Math.min(MathHelper.floor((float)(Math.abs(this.motionX) + Math.abs(this.motionY) + Math.abs(this.motionZ)) * 8), 40));
		}
	}

	public void addEntityCrashInfo(CrashReportCategory category) {
		super.addEntityCrashInfo(category);
		if (this.fallTile != null) {
			Block block = this.fallTile.getBlock();
			category.addCrashSection("Immitating block ID", Integer.valueOf(Block.getIdFromBlock(block)));
			category.addCrashSection("Immitating block data", Integer.valueOf(block.getMetaFromState(this.fallTile)));
		}
	}

	@Nullable
	public IBlockState getBlock() {
		if (fallTile == null) {
			NBTTagCompound compound = this.dataManager.get(NBT);
			int i = compound.getByte("Data") & 255;
			if (compound.hasKey("Block", 8)) {
				this.fallTile = Block.getBlockFromName(compound.getString("Block")).getStateFromMeta(i);
			}
		}
		return this.fallTile;
	}
}

