package com.axanthic.blab.entity;

import javax.annotation.Nullable;

import com.axanthic.blab.Resources;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFallingVase extends EntityFallingBlock {

	private IBlockState fallTile;
	public int fallTime;
	public boolean shouldDropItem = true;
	private boolean dontSetBlock;
	private boolean hurtEntities;
	private int fallHurtMax = 40;
	private float fallHurtAmount = 2.0F;
	public NBTTagCompound tileEntityData;
	protected static final DataParameter<BlockPos> ORIGIN = EntityDataManager.<BlockPos>createKey(EntityFallingBlock.class, DataSerializers.BLOCK_POS);

	public EntityFallingVase(World worldIn) {
		super(worldIn);
	}

	public EntityFallingVase(World worldIn, double x, double y, double z, IBlockState fallingBlockState) {
		super(worldIn, x, y, z, fallingBlockState);
		this.fallTile = fallingBlockState;
		this.preventEntitySpawning = true;
		this.hurtEntities = true;
		this.setSize(0.98F, 0.98F);
		this.setPosition(x, y + (double)((1.0F - this.height) / 2.0F), z);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
		this.setOrigin(new BlockPos(this));
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
		}
	}

	public double getYOffset() {
		return 0.5D;
	}

	/**
	 * Returns true if it's possible to attack this entity with an item.
	 */
	public boolean canBeAttackedWithItem() {
		return false;
	}

	public void setOrigin(BlockPos p_184530_1_) {
		this.dataManager.set(ORIGIN, p_184530_1_);
	}

	@SideOnly(Side.CLIENT)
	public BlockPos getOrigin() {
		return (BlockPos)this.dataManager.get(ORIGIN);
	}

	/**
	 * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
	 * prevent them from trampling crops
	 */
	protected boolean canTriggerWalking() {
		return false;
	}

	protected void entityInit() {
		this.dataManager.register(ORIGIN, BlockPos.ORIGIN);
	}

	/**
	 * Returns true if other Entities should be prevented from moving through this Entity.
	 */
	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	public boolean canBePushed() {
		return !this.isDead;
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		this.fallTile = Resources.lootVase.getBlock().getDefaultState();
		Block block = this.fallTile.getBlock();
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

					if (!this.dontSetBlock) {
						if (this.world.mayPlace(block, blockpos1, true, EnumFacing.UP, (Entity)null) && (false || !BlockFalling.canFallThrough(this.world.getBlockState(blockpos1.down()))) && this.world.setBlockState(blockpos1, this.fallTile, 3)) {
							if (block instanceof BlockFalling) {
								((BlockFalling)block).onEndFalling(this.world, blockpos1, this.fallTile, iblockstate);
							}
						} else if (this.shouldDropItem && this.world.getGameRules().getBoolean("doEntityDrops")) {
							for (ItemStack item : block.getDrops(null, null, null, 0))
								this.entityDropItem(item, 0.0F);
						}
					} else if (block instanceof BlockFalling) {
						((BlockFalling)block).onBroken(this.world, blockpos1);
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
		super.applyEntityCollision(entityIn);
		if (this.hurtEntities) {
			entityIn.attackEntityFrom(DamageSource.FALLING_BLOCK, (float)Math.min(MathHelper.floor((float)(Math.abs(this.motionX) + Math.abs(this.motionY) + Math.abs(this.motionZ)) * this.fallHurtAmount * 4), this.fallHurtMax));
		}
	}

	public static void registerFixesFallingBlock(DataFixer fixer) {

	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	protected void writeEntityToNBT(NBTTagCompound compound) {
		Block block = this.fallTile != null ? this.fallTile.getBlock() : Blocks.AIR;
		ResourceLocation resourcelocation = Block.REGISTRY.getNameForObject(block);
		compound.setString("Block", resourcelocation == null ? "" : resourcelocation.toString());
		compound.setByte("Data", (byte)block.getMetaFromState(this.fallTile));
		compound.setInteger("Time", this.fallTime);
		compound.setBoolean("DropItem", this.shouldDropItem);
		compound.setBoolean("HurtEntities", this.hurtEntities);
		compound.setFloat("FallHurtAmount", this.fallHurtAmount);
		compound.setInteger("FallHurtMax", this.fallHurtMax);

		if (this.tileEntityData != null) {
			compound.setTag("TileEntityData", this.tileEntityData);
		}
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	protected void readEntityFromNBT(NBTTagCompound compound) {
		int i = compound.getByte("Data") & 255;

		if (compound.hasKey("Block", 8)) {
			this.fallTile = Block.getBlockFromName(compound.getString("Block")).getStateFromMeta(i);
		} else if (compound.hasKey("TileID", 99)) {
			this.fallTile = Block.getBlockById(compound.getInteger("TileID")).getStateFromMeta(i);
		} else {
			this.fallTile = Block.getBlockById(compound.getByte("Tile") & 255).getStateFromMeta(i);
		}

		this.fallTime = compound.getInteger("Time");
		Block block = this.fallTile.getBlock();

		if (compound.hasKey("HurtEntities", 99)) {
			this.hurtEntities = compound.getBoolean("HurtEntities");
			this.fallHurtAmount = compound.getFloat("FallHurtAmount");
			this.fallHurtMax = compound.getInteger("FallHurtMax");
		} else if (block == Blocks.ANVIL) {
			this.hurtEntities = true;
		}

		if (compound.hasKey("DropItem", 99)) {
			this.shouldDropItem = compound.getBoolean("DropItem");
		}

		if (compound.hasKey("TileEntityData", 10)) {
			this.tileEntityData = compound.getCompoundTag("TileEntityData");
		}

		if (block == null || block.getDefaultState().getMaterial() == Material.AIR) {
			this.fallTile = Blocks.SAND.getDefaultState();
		}
	}

	public void setHurtEntities(boolean p_145806_1_) {
		this.hurtEntities = p_145806_1_;
	}

	public void addEntityCrashInfo(CrashReportCategory category) {
		super.addEntityCrashInfo(category);

		if (this.fallTile != null) {
			Block block = this.fallTile.getBlock();
			category.addCrashSection("Immitating block ID", Integer.valueOf(Block.getIdFromBlock(block)));
			category.addCrashSection("Immitating block data", Integer.valueOf(block.getMetaFromState(this.fallTile)));
		}
	}

	@SideOnly(Side.CLIENT)
	public World getWorldObj() {
		return this.world;
	}

	/**
	 * Return whether this entity should be rendered as on fire.
	 */
	@SideOnly(Side.CLIENT)
	public boolean canRenderOnFire() {
		return false;
	}

	@Nullable
	public IBlockState getBlock() {
		return this.fallTile;
	}

	public boolean ignoreItemEntityData() {
		return true;
	}
}

