package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemResources;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

public class BlockFarmLand extends BlockFarmland {

	public BlockFarmLand() {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(0.6F);
		this.setSoundType(SoundType.GROUND);
		this.setUnlocalizedName("farmland");
		this.setRegistryName(ModInformation.ID, "farmland");
        this.useNeighborBrightness = true;
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
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if (itemstack.getItem() instanceof ItemResources
				&& itemstack.getMetadata() == ItemResources.ResourceType.CALCITE_POWDER.toMeta()
				&& playerIn.canPlayerEdit(pos.offset(facing), facing, itemstack)
				&& ((Integer)state.getValue(MOISTURE)).intValue() == 7) {
			worldIn.setBlockState(pos, Resources.fertilizedFarmLand.getBlock().getDefaultState());
			if(playerIn instanceof EntityPlayerMP)
				Resources.FERTILIZE_TRIGGER.trigger((EntityPlayerMP) playerIn);
			if(!playerIn.isCreative())
				itemstack.shrink(1);
			return true;
		}
		return false;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int i = ((Integer)state.getValue(MOISTURE)).intValue();

		if (!hasWater(worldIn, pos) && !worldIn.isRainingAt(pos.up())) {
			if (i > 0) {
				worldIn.setBlockState(pos, state.withProperty(MOISTURE, Integer.valueOf(i - 1)), 2);
			} else if (!this.hasCrops(worldIn, pos)) {
				turnToSoil(worldIn, pos);
			}
		} else if (i < 7) {
			worldIn.setBlockState(pos, state.withProperty(MOISTURE, Integer.valueOf(7)), 2);
		}
	}

	@Override
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		if (net.minecraftforge.common.ForgeHooks.onFarmlandTrample(worldIn, pos, Resources.soil.getBlock().getDefaultState(), fallDistance, entityIn)) { // Forge: Move logic to Entity#canTrample
			turnToSoil(worldIn, pos);
		}
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
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable) {
		return plantable.getPlantType(world, pos.offset(direction)).equals(EnumPlantType.Crop);
	}

	@Override
	public boolean isFertile(World world, BlockPos pos) {
		return ((Integer)world.getBlockState(pos).getValue(BlockFarmland.MOISTURE)) > 0;
	}

	@Override
	public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return side == EnumFacing.DOWN;
	}

	public boolean hasCrops(World worldIn, BlockPos pos) {
		Block block = worldIn.getBlockState(pos.up()).getBlock();
		return block instanceof net.minecraftforge.common.IPlantable && canSustainPlant(worldIn.getBlockState(pos), worldIn, pos, net.minecraft.util.EnumFacing.UP, (net.minecraftforge.common.IPlantable)block);
	}

	public boolean hasWater(World worldIn, BlockPos pos) {
		for (BlockPos.MutableBlockPos blockpos$mutableblockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
			if (worldIn.getBlockState(blockpos$mutableblockpos).getMaterial() == Material.WATER) {
				return true;
			}
		}
		return false;
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
