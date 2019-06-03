package com.axanthic.blab.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.blab.Resources;
import com.axanthic.loi.worldgen.biome.BiomeForest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSoilGrass extends BlockBasic implements IGrowable {

	public static final PropertyBool MOSSY = PropertyBool.create("mossy");

	public BlockSoilGrass() {
		super(Material.GRASS, 1.2F, "soil_grass", MapColor.GREEN_STAINED_HARDENED_CLAY);
		this.setDefaultState(this.blockState.getBaseState().withProperty(MOSSY, Boolean.valueOf(false)));
		this.setTickRandomly(true);
		this.setSoundType(SoundType.GROUND);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos.up()).getBlock();
		return state.withProperty(MOSSY, Boolean.valueOf(block.equals(Resources.moss.getBlock())));
	}

	@Override
	@Nullable
	public String getHarvestTool(IBlockState state) {
		return "shovel";
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (!worldIn.isRemote) {
			if (!worldIn.isAreaLoaded(pos, 3)) return;
			if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2) {
				worldIn.setBlockState(pos, Resources.soil.getBlock().getDefaultState());
			} else {
				if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
					for (int i = 0; i < 4; ++i) {
						BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

						if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos)) {
							return;
						}

						IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
						IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

						if (iblockstate1.getBlock() == Resources.soil.getBlock() && iblockstate1.getValue(BlockSoil.TYPES) == BlockSoil.SoilTypes.MARL && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(worldIn, pos.up()) <= 2) {
							worldIn.setBlockState(blockpos, this.getDefaultState());
						}
					}
				}
			}
		}
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable) {
		return Blocks.GRASS.canSustainPlant(state, world, pos, direction, plantable) || plantable instanceof BlockBush;
	}

	@Override
	public void onPlantGrow(IBlockState state, World world, BlockPos pos, BlockPos source) {
		world.setBlockState(pos, Resources.soil.getBlock().getDefaultState(), 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.soil;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
		BlockPos blockpos = pos.up();
		for (int i = 0; i < 128; ++i) {
			BlockPos blockpos1 = blockpos;
			int j = 0;
			while (true) {
				if (j >= i / 16) {
					if (worldIn.isAirBlock(blockpos1)) {
						if (rand.nextInt(8) == 0) {
							worldIn.getBiome(blockpos1).plantFlower(worldIn, rand, blockpos1);
						} else {
							IBlockState iblockstate1 = Resources.tallGrass.getBlock().getStateFromMeta(rand.nextInt(BlockTallGrass.GrassTypes.values().length - (worldIn.getBiome(blockpos1) instanceof BiomeForest ? 0 : 1)));
							if (((BlockBush) iblockstate1.getBlock()).canBlockStay(worldIn, blockpos1, iblockstate1)) {
								worldIn.setBlockState(blockpos1, iblockstate1, 3);
							}
						}
					}
					break;
				}
				blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);

				if (worldIn.getBlockState(blockpos1.down()).getBlock() != Resources.grass.getBlock() || worldIn.getBlockState(blockpos1).isNormalCube()) {
					break;
				}
				++j;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT_MIPPED;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {MOSSY});
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}
}
