package com.axanthic.loi.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockBasicVineGrowing extends BlockVine {

	public BlockBasicVineGrowing deadVine;

	public boolean damaging = false;

	public BlockBasicVineGrowing(String name, boolean damage) {
		this(name);
		this.damaging = damage;
	}

	public BlockBasicVineGrowing(String name) {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setHardness(0.3F);
		this.setSoundType(SoundType.PLANT);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (damaging)
			entity.attackEntityFrom(net.minecraft.util.DamageSource.CACTUS, 1.0F);
	}

	@Override
	public boolean canAttachTo(World p_193395_1_, BlockPos p_193395_2_, EnumFacing p_193395_3_) {
		Block block = p_193395_1_.getBlockState(p_193395_2_.up()).getBlock();
		return this.isAcceptableNeighbor(p_193395_1_, p_193395_2_.offset(p_193395_3_.getOpposite()), p_193395_3_) && (block == Blocks.AIR || block == this || this.isAcceptableNeighbor(p_193395_1_, p_193395_2_.up(), EnumFacing.UP));
	}

	private boolean isAcceptableNeighbor(World p_193396_1_, BlockPos p_193396_2_, EnumFacing p_193396_3_) {
		IBlockState iblockstate = p_193396_1_.getBlockState(p_193396_2_);
		return iblockstate.getBlockFaceShape(p_193396_1_, p_193396_2_, p_193396_3_) == BlockFaceShape.SOLID && !isExceptBlockForAttaching(iblockstate.getBlock());
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (worldIn.rand.nextInt(4) == 0 && worldIn.isAreaLoaded(pos, 4)) {
				int i = 4;
				int j = 5;
				boolean flag = false;
				label181:
					for (int k = -4; k <= 4; ++k) {
						for (int l = -4; l <= 4; ++l) {
							for (int i1 = -1; i1 <= 1; ++i1) {
								if (worldIn.getBlockState(pos.add(k, i1, l)).getBlock() == this) {
									--j;

									if (j <= 0) {
										flag = true;
										break label181;
									}
								}
							}
						}
					}

				EnumFacing enumfacing1 = EnumFacing.random(rand);
				BlockPos blockpos2 = pos.up();

				if (enumfacing1 == EnumFacing.UP && pos.getY() < 255 && worldIn.isAirBlock(blockpos2)) {
					IBlockState iblockstate2 = state;

					if (rand.nextInt(2) == 0)
						iblockstate2 = deadVine.getStateFromMeta(this.getMetaFromState(state));

					for (EnumFacing enumfacing2 : EnumFacing.Plane.HORIZONTAL) {
						if (rand.nextBoolean() && this.canAttachTo(worldIn, blockpos2, enumfacing2.getOpposite())) {
							iblockstate2 = iblockstate2.withProperty(getPropertyFor(enumfacing2), Boolean.valueOf(true));
						} else {
							iblockstate2 = iblockstate2.withProperty(getPropertyFor(enumfacing2), Boolean.valueOf(false));
						}
					}

					if (((Boolean)iblockstate2.getValue(NORTH)).booleanValue() || ((Boolean)iblockstate2.getValue(EAST)).booleanValue() || ((Boolean)iblockstate2.getValue(SOUTH)).booleanValue() || ((Boolean)iblockstate2.getValue(WEST)).booleanValue()) {
						worldIn.setBlockState(blockpos2, iblockstate2, 2);
					}
				} else if (enumfacing1.getAxis().isHorizontal() && !((Boolean)state.getValue(getPropertyFor(enumfacing1))).booleanValue()) {
					if (!flag) {
						BlockPos blockpos4 = pos.offset(enumfacing1);
						IBlockState iblockstate3 = worldIn.getBlockState(blockpos4);
						Block block1 = iblockstate3.getBlock();
						IBlockState iblockstate4 = this.getDefaultState();

						if (rand.nextInt(2) == 0)
							iblockstate4 = deadVine.getDefaultState();

						if (block1.isAir(iblockstate3, worldIn, blockpos4)) {
							EnumFacing enumfacing3 = enumfacing1.rotateY();
							EnumFacing enumfacing4 = enumfacing1.rotateYCCW();
							boolean flag1 = ((Boolean)state.getValue(getPropertyFor(enumfacing3))).booleanValue();
							boolean flag2 = ((Boolean)state.getValue(getPropertyFor(enumfacing4))).booleanValue();
							BlockPos blockpos = blockpos4.offset(enumfacing3);
							BlockPos blockpos1 = blockpos4.offset(enumfacing4);

							if (flag1 && this.canAttachTo(worldIn, blockpos.offset(enumfacing3), enumfacing3)) {
								worldIn.setBlockState(blockpos4, iblockstate4.withProperty(getPropertyFor(enumfacing3), Boolean.valueOf(true)), 2);
							} else if (flag2 && this.canAttachTo(worldIn, blockpos1.offset(enumfacing4), enumfacing4)) {
								worldIn.setBlockState(blockpos4, iblockstate4.withProperty(getPropertyFor(enumfacing4), Boolean.valueOf(true)), 2);
							} else if (flag1 && worldIn.isAirBlock(blockpos) && this.canAttachTo(worldIn, blockpos, enumfacing1)) {
								worldIn.setBlockState(blockpos, iblockstate4.withProperty(getPropertyFor(enumfacing1.getOpposite()), Boolean.valueOf(true)), 2);
							} else if (flag2 && worldIn.isAirBlock(blockpos1) && this.canAttachTo(worldIn, blockpos1, enumfacing1)) {
								worldIn.setBlockState(blockpos1, iblockstate4.withProperty(getPropertyFor(enumfacing1.getOpposite()), Boolean.valueOf(true)), 2);
							}
						} else if (iblockstate3.getBlockFaceShape(worldIn, blockpos4, enumfacing1) == BlockFaceShape.SOLID) {
							IBlockState iblockstate5 = state;
							if (rand.nextInt(2) == 0)
								iblockstate5 = deadVine.getStateFromMeta(this.getMetaFromState(state));
							worldIn.setBlockState(pos, iblockstate5.withProperty(getPropertyFor(enumfacing1), Boolean.valueOf(true)), 2);
						}
					}
				} else {
					if (pos.getY() > 1) {
						BlockPos blockpos3 = pos.down();
						IBlockState iblockstate = worldIn.getBlockState(blockpos3);
						Block block = iblockstate.getBlock();

						if (block.getMaterial(iblockstate) == Material.AIR) {
							IBlockState iblockstate1 = state;
							if (rand.nextInt(10) == 0)
								iblockstate1 = deadVine.getStateFromMeta(this.getMetaFromState(state));

							for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
								if (rand.nextBoolean()) {
									iblockstate1 = iblockstate1.withProperty(getPropertyFor(enumfacing), Boolean.valueOf(false));
								}
							}

							if (((Boolean)iblockstate1.getValue(NORTH)).booleanValue() || ((Boolean)iblockstate1.getValue(EAST)).booleanValue() || ((Boolean)iblockstate1.getValue(SOUTH)).booleanValue() || ((Boolean)iblockstate1.getValue(WEST)).booleanValue()) {
								worldIn.setBlockState(blockpos3, iblockstate1, 2);
							}
						} else if (block == this) {
							IBlockState iblockstate4 = iblockstate;
							if (rand.nextInt(10) == 0)
								iblockstate4 = deadVine.getStateFromMeta(this.getMetaFromState(iblockstate));

							for (EnumFacing enumfacing5 : EnumFacing.Plane.HORIZONTAL) {
								PropertyBool propertybool = getPropertyFor(enumfacing5);

								if (rand.nextBoolean() && ((Boolean)state.getValue(propertybool)).booleanValue()) {
									iblockstate4 = iblockstate4.withProperty(propertybool, Boolean.valueOf(true));
								}
							}
							if (((Boolean)iblockstate4.getValue(NORTH)).booleanValue() || ((Boolean)iblockstate4.getValue(EAST)).booleanValue() || ((Boolean)iblockstate4.getValue(SOUTH)).booleanValue() || ((Boolean)iblockstate4.getValue(WEST)).booleanValue()) {
								worldIn.setBlockState(blockpos3, iblockstate4, 2);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(StatList.getBlockStats(this));
			spawnAsEntity(worldIn, pos, new ItemStack(this, 1, 0));
		} else {
			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}
}
