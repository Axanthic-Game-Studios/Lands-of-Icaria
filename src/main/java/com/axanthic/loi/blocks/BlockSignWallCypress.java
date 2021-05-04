package com.axanthic.loi.blocks;

import com.axanthic.loi.Resources;
import com.axanthic.loi.tileentity.TESignCypress;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSignWallCypress extends BlockSign
{
    public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 15);

    private static final AxisAlignedBB WALL_NORTH_AABB = new AxisAlignedBB(0.0D, 0.28125D, 0.875D, 1.0D, 0.78125D, 1.0D);
    private static final AxisAlignedBB WALL_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.28125D, 0.0D, 1.0D, 0.78125D, 0.125D);
    private static final AxisAlignedBB WALL_EAST_AABB = new AxisAlignedBB(0.0D, 0.28125D, 0.0D, 0.125D, 0.78125D, 1.0D);
    private static final AxisAlignedBB WALL_WEST_AABB = new AxisAlignedBB(0.875D, 0.28125D, 0.0D, 1.0D, 0.78125D, 1.0D);

    private static final AxisAlignedBB FLAT_NORTH_AABB = new AxisAlignedBB(0.27125D, 0.0D, 0.0D, 0.77125D, 0.125D, 1.0D);
    private static final AxisAlignedBB FLAT_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.23125D, 1.0D, 0.125D, 0.73125D);
    private static final AxisAlignedBB FLAT_EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.27125D, 1.0D, 0.125D, 0.77125D);
    private static final AxisAlignedBB FLAT_WEST_AABB = new AxisAlignedBB(0.23125D, 0.0D, 0.0D, 0.73125D, 0.125D, 1.0D);

    private static final AxisAlignedBB ROOF_NORTH_AABB = new AxisAlignedBB(0.23125D, 0.875D, 0.0D, 0.73125D, 1.0D, 1.0D);
    private static final AxisAlignedBB ROOF_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.875D, 0.27125D, 1.0D, 1.0D, 0.77125D);
    private static final AxisAlignedBB ROOF_EAST_AABB = new AxisAlignedBB(0.0D, 0.875D, 0.23125D, 1.0D, 1.0D, 0.73125D);
    private static final AxisAlignedBB ROOF_WEST_AABB = new AxisAlignedBB(0.27125D, 0.875D, 0.0D, 0.77125D, 1.0D, 1.0D);

    public BlockSignWallCypress()
    {
        this.setRegistryName("sign_wall_cypress");
        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setHarvestLevel("axe", 0);
        this.setSoundType(SoundType.WOOD);
    }

    @SuppressWarnings("deprecation")
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos)
    {
        int rotation = world.getBlockState(pos).getValue(ROTATION);
        boolean wallSign = ((rotation & 8) >> 3) == 1;
        boolean flatSign;
        boolean flag;
        EnumFacing facing = EnumFacing.getFront(rotation & 7);

        if (wallSign)
        {
            flatSign = (rotation & 1) == 1;

            if (flatSign)
            {
                flag = !(world.getBlockState(pos.down()).getMaterial().isSolid());
            }

            else
            {
                flag = !(world.getBlockState(pos.up()).getMaterial().isSolid());
            }
        }

        else
        {
            flag = !(facing == EnumFacing.NORTH && world.getBlockState(pos.south()).getMaterial().isSolid());

            if (world.getBlockState(pos.offset(facing.getOpposite())).getMaterial().isSolid())
            {
                flag = false;
            }
        }

        if (flag)
        {
            this.dropBlockAsItem(world, pos, state, 0);
            world.setBlockToAir(pos);
        }
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(ROTATION).intValue();
    }

    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(ROTATION, Integer.valueOf(meta));
    }

    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, ROTATION);
    }

    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TESignCypress();
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(Resources.signCypress);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Resources.signCypress;
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        int i = state.getBlock().getMetaFromState(state);
        boolean wallSign = ((i & 8) >> 3) == 1;
        boolean flatSign;
        EnumFacing side = EnumFacing.getFront(i & 7);

        if (wallSign)
        {
            int rotation = (i & 6) >> 1;
            flatSign = (i & 1) == 1;

            if (flatSign)
            {
                switch (rotation)
                {
                    case 1:
                        return FLAT_WEST_AABB;
                    case 2:
                        return FLAT_SOUTH_AABB;
                    case 3:
                        return FLAT_NORTH_AABB;
                    default:
                        return FLAT_EAST_AABB;
                }
            }

            else
            {
                switch (rotation)
                {
                    case 1:
                        return ROOF_WEST_AABB;
                    case 2:
                        return ROOF_SOUTH_AABB;
                    case 3:
                        return ROOF_NORTH_AABB;
                    default:
                        return ROOF_EAST_AABB;
                }
            }
        }

        else
        {
            switch (side)
            {
                case NORTH:
                default:
                    return WALL_NORTH_AABB;
                case SOUTH:
                    return WALL_SOUTH_AABB;
                case EAST:
                    return WALL_EAST_AABB;
                case WEST:
                    return WALL_WEST_AABB;
            }
        }
    }
}