package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockFarmLandFertilized extends BlockFarmland {

	public BlockFarmLandFertilized() {
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(0.6F);
		this.setSoundType(SoundType.GROUND);
		this.setDefaultState(this.blockState.getBaseState());
		this.setUnlocalizedName("farmland_fertilized");
		this.setRegistryName(ModInformation.ID, "farmland_fertilized");
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.soil;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return MapColor.BROWN;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if (this.hasCrops(worldIn, pos)) {
			IBlockState cropState = worldIn.getBlockState(pos.up());
			cropState.getBlock().updateTick(worldIn, pos.up(), cropState, rand);
		}
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		entityIn.fall(fallDistance, 1.0F);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);

		if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
			turnToSoil(worldIn, pos);
		}
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		super.onBlockAdded(worldIn, pos, state);

		if (worldIn.getBlockState(pos.up()).getMaterial().isSolid()) {
			turnToSoil(worldIn, pos);
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable) {
		return plantable.getPlantType(world, pos.offset(direction)).equals(EnumPlantType.Crop);
	}

	@Override
	public boolean isFertile(World world, BlockPos pos) {
		return true;
	}

	public boolean hasCrops(World worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos.up()).getBlock();
		return block instanceof net.minecraftforge.common.IPlantable && canSustainPlant(worldIn.getBlockState(pos), worldIn, pos, net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable)block);
	}

	public static void turnToSoil(World world, BlockPos pos) {
		world.setBlockState(pos, Resources.soil.getBlock().getDefaultState());
		AxisAlignedBB axisalignedbb = field_194405_c.offset(pos);

		for (Entity entity : world.getEntitiesWithinAABBExcludingEntity((Entity)null, axisalignedbb)) {
			double d0 = Math.min(axisalignedbb.maxY - axisalignedbb.minY, axisalignedbb.maxY - entity.getEntityBoundingBox().minY);
			entity.setPositionAndUpdate(entity.posX, entity.posY + d0 + 0.001D, entity.posZ);
		}
	}
}
