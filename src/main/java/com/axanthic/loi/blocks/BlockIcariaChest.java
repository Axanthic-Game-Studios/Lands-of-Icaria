package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.tileentity.TileEntityIcariaChest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.ILockableContainer;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockIcariaChest extends BlockContainer
{
    public static final PropertyDirection FACING = BlockHorizontal.FACING;

    public static final AxisAlignedBB AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
    public static final AxisAlignedBB EASTAABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 1.0D, 0.875D, 0.9375D);
    public static final AxisAlignedBB WESTAABB = new AxisAlignedBB(0.0D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
    public static final AxisAlignedBB NORTHAABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0D, 0.9375D, 0.875D, 0.9375D);
    public static final AxisAlignedBB SOUTHAABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 1.0D);

    public final Type chestType;

    public BlockIcariaChest(String name, Type chestType)
    {
        super(Material.WOOD);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(2.5F);
        this.setResistance(2.5F);
        this.setHarvestLevel("axe", 0);
        this.setSoundType(SoundType.WOOD);
        this.setCreativeTab(LandsOfIcaria.modTabBlocks);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.chestType = chestType;
    }

    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SuppressWarnings("deprecation")
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @SuppressWarnings("deprecation")
    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state)
    {
        return true;
    }

    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @SuppressWarnings("deprecation")
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        if(source.getBlockState(pos.north()).getBlock() == this)
        {
            return NORTHAABB;
        }

        else if(source.getBlockState(pos.south()).getBlock() == this)
        {
            return SOUTHAABB;
        }

        else if(source.getBlockState(pos.west()).getBlock() == this)
        {
            return WESTAABB;
        }

        else
        {
            return source.getBlockState(pos.east()).getBlock() == this ? EASTAABB : AABB;
        }
    }

    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        this.checkForSurroundingChests(world, pos, state);

        for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
        {
            BlockPos blockpos = pos.offset(enumfacing);
            IBlockState iblockstate = world.getBlockState(blockpos);

            if(iblockstate.getBlock() == this)
            {
                this.checkForSurroundingChests(world, blockpos, iblockstate);
            }
        }
    }

    @SuppressWarnings("deprecation")
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();

        state = state.withProperty(FACING, enumfacing);

        BlockPos blockpos = pos.north();
        BlockPos blockpos1 = pos.south();
        BlockPos blockpos2 = pos.west();
        BlockPos blockpos3 = pos.east();

        boolean flag = this == world.getBlockState(blockpos).getBlock();
        boolean flag1 = this == world.getBlockState(blockpos1).getBlock();
        boolean flag2 = this == world.getBlockState(blockpos2).getBlock();
        boolean flag3 = this == world.getBlockState(blockpos3).getBlock();

        if(!flag && !flag1 && !flag2 && !flag3)
        {
            world.setBlockState(pos, state, 3);
        }

        else if(enumfacing.getAxis() != EnumFacing.Axis.X || !flag && !flag1)
        {
            if(enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3))
            {
                if(flag2)
                {
                    world.setBlockState(blockpos2, state, 3);
                }

                else
                {
                    world.setBlockState(blockpos3, state, 3);
                }

                world.setBlockState(pos, state, 3);
            }
        }

        else
        {
            if(flag)
            {
                world.setBlockState(blockpos, state, 3);
            }

            else
            {
                world.setBlockState(blockpos1, state, 3);
            }

            world.setBlockState(pos, state, 3);
        }

        if(stack.hasDisplayName())
        {
            TileEntity tileentity = world.getTileEntity(pos);

            if(tileentity instanceof TileEntityIcariaChest)
            {
                ((TileEntityIcariaChest)tileentity).setCustomName(stack.getDisplayName());
            }
        }
    }

    public IBlockState checkForSurroundingChests(World world, BlockPos pos, IBlockState state)
    {
        if(world.isRemote)
        {
            return state;
        }

        else
        {
            IBlockState iblockstate = world.getBlockState(pos.north());
            IBlockState iblockstate1 = world.getBlockState(pos.south());
            IBlockState iblockstate2 = world.getBlockState(pos.west());
            IBlockState iblockstate3 = world.getBlockState(pos.east());

            EnumFacing enumfacing = state.getValue(FACING);

            if(iblockstate.getBlock() != this && iblockstate1.getBlock() != this)
            {
                boolean flag = iblockstate.isFullBlock();
                boolean flag1 = iblockstate1.isFullBlock();

                if(iblockstate2.getBlock() == this || iblockstate3.getBlock() == this)
                {
                    BlockPos blockpos1 = iblockstate2.getBlock() == this ? pos.west() : pos.east();

                    IBlockState iblockstate7 = world.getBlockState(blockpos1.north());
                    IBlockState iblockstate6 = world.getBlockState(blockpos1.south());

                    enumfacing = EnumFacing.SOUTH;

                    EnumFacing enumfacing2;

                    if(iblockstate2.getBlock() == this)
                    {
                        enumfacing2 = iblockstate2.getValue(FACING);
                    }

                    else
                    {
                        enumfacing2 = iblockstate3.getValue(FACING);
                    }

                    if(enumfacing2 == EnumFacing.NORTH)
                    {
                        enumfacing = EnumFacing.NORTH;
                    }

                    if((flag || iblockstate7.isFullBlock()) && !flag1 && !iblockstate6.isFullBlock())
                    {
                        enumfacing = EnumFacing.SOUTH;
                    }

                    if((flag1 || iblockstate6.isFullBlock()) && !flag && !iblockstate7.isFullBlock())
                    {
                        enumfacing = EnumFacing.NORTH;
                    }
                }
            }

            else
            {
                BlockPos blockpos = iblockstate.getBlock() == this ? pos.north() : pos.south();

                IBlockState iblockstate4 = world.getBlockState(blockpos.west());
                IBlockState iblockstate5 = world.getBlockState(blockpos.east());

                enumfacing = EnumFacing.EAST;

                EnumFacing enumfacing1;

                if(iblockstate.getBlock() == this)
                {
                    enumfacing1 = iblockstate.getValue(FACING);
                }

                else
                {
                    enumfacing1 = iblockstate1.getValue(FACING);
                }

                if(enumfacing1 == EnumFacing.WEST)
                {
                    enumfacing = EnumFacing.WEST;
                }

                if((iblockstate2.isFullBlock() || iblockstate4.isFullBlock()) && !iblockstate3.isFullBlock() && !iblockstate5.isFullBlock())
                {
                    enumfacing = EnumFacing.EAST;
                }

                if((iblockstate3.isFullBlock() || iblockstate5.isFullBlock()) && !iblockstate2.isFullBlock() && !iblockstate4.isFullBlock())
                {
                    enumfacing = EnumFacing.WEST;
                }
            }

            state = state.withProperty(FACING, enumfacing);

            world.setBlockState(pos, state, 3);

            return state;
        }
    }

    public boolean canPlaceBlockAt(World world, BlockPos pos)
    {
        int i = 0;

        BlockPos blockpos = pos.west();
        BlockPos blockpos1 = pos.east();
        BlockPos blockpos2 = pos.north();
        BlockPos blockpos3 = pos.south();

        if(world.getBlockState(blockpos).getBlock() == this)
        {
            if(this.isDoubleChest(world, blockpos))
            {
                return false;
            }

            ++i;
        }

        if(world.getBlockState(blockpos1).getBlock() == this)
        {
            if(this.isDoubleChest(world, blockpos1))
            {
                return false;
            }

            ++i;
        }

        if(world.getBlockState(blockpos2).getBlock() == this)
        {
            if(this.isDoubleChest(world, blockpos2))
            {
                return false;
            }

            ++i;
        }

        if(world.getBlockState(blockpos3).getBlock() == this)
        {
            if(this.isDoubleChest(world, blockpos3))
            {
                return false;
            }

            ++i;
        }

        return i <= 1;
    }

    public boolean isDoubleChest(World world, BlockPos pos)
    {
        if(world.getBlockState(pos).getBlock() != this)
        {
            return false;
        }

        else
        {
            for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if(world.getBlockState(pos.offset(enumfacing)).getBlock() == this)
                {
                    return true;
                }
            }

            return false;
        }
    }

    @SuppressWarnings("deprecation")
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos)
    {
        super.neighborChanged(state, world, pos, block, fromPos);

        TileEntity tileentity = world.getTileEntity(pos);

        if(tileentity instanceof TileEntityIcariaChest)
        {
            tileentity.updateContainingBlockInfo();
        }
    }

    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        TileEntity tileentity = world.getTileEntity(pos);

        if(tileentity instanceof IInventory)
        {
            InventoryHelper.dropInventoryItems(world, pos, (IInventory)tileentity);

            world.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(world, pos, state);
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!world.isRemote)
        {
            ILockableContainer ilockablecontainer = this.getLockableContainer(world, pos);

            if(ilockablecontainer != null)
            {
                player.displayGUIChest(ilockablecontainer);

                if(this.chestType == Type.BASIC)
                {
                    player.addStat(StatList.CHEST_OPENED);
                }

                else if(this.chestType == Type.TRAP)
                {
                    player.addStat(StatList.TRAPPED_CHEST_TRIGGERED);
                }
            }
        }

        return true;
    }

    @Nullable
    public ILockableContainer getLockableContainer(World world, BlockPos pos)
    {
        return this.getContainer(world, pos, false);
    }

    @Nullable
    public ILockableContainer getContainer(World world, BlockPos pos, boolean allowBlocking)
    {
        TileEntity tileentity = world.getTileEntity(pos);

        if(!(tileentity instanceof TileEntityIcariaChest))
        {
            return null;
        }

        else
        {
            ILockableContainer ilockablecontainer = (TileEntityIcariaChest)tileentity;

            if(!allowBlocking && this.isBlocked(world, pos))
            {
                return null;
            }

            else
            {
                for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
                {
                    BlockPos blockpos = pos.offset(enumfacing);
                    Block block = world.getBlockState(blockpos).getBlock();

                    if(block == this)
                    {
                        if(!allowBlocking && this.isBlocked(world, blockpos))
                        {
                            return null;
                        }

                        TileEntity tileentity1 = world.getTileEntity(blockpos);

                        if(tileentity1 instanceof TileEntityIcariaChest)
                        {
                            if(enumfacing != EnumFacing.WEST && enumfacing != EnumFacing.NORTH)
                            {
                                ilockablecontainer = new InventoryLargeChest("container.chestDouble", ilockablecontainer, (TileEntityIcariaChest)tileentity1);
                            }

                            else
                            {
                                ilockablecontainer = new InventoryLargeChest("container.chestDouble", (TileEntityIcariaChest)tileentity1, ilockablecontainer);
                            }
                        }
                    }
                }

                return ilockablecontainer;
            }
        }
    }

    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityIcariaChest();
    }

    @SuppressWarnings("deprecation")
    public boolean canProvidePower(IBlockState state)
    {
        return this.chestType == Type.TRAP;
    }

    @SuppressWarnings("deprecation")
    public int getWeakPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        if(!blockState.canProvidePower())
        {
            return 0;
        }

        else
        {
            int i = 0;

            TileEntity tileentity = blockAccess.getTileEntity(pos);

            if(tileentity instanceof TileEntityIcariaChest)
            {
                i = ((TileEntityIcariaChest)tileentity).numPlayersUsing;
            }

            return MathHelper.clamp(i, 0, 15);
        }
    }

    @SuppressWarnings("deprecation")
    public int getStrongPower(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return side == EnumFacing.UP ? blockState.getWeakPower(blockAccess, pos, side) : 0;
    }

    public boolean isBlocked(World world, BlockPos pos)
    {
        return this.isBelowSolidBlock(world, pos) || this.isOcelotSittingOnChest(world, pos);
    }

    public boolean isBelowSolidBlock(World world, BlockPos pos)
    {
        return world.getBlockState(pos.up()).doesSideBlockChestOpening(world, pos.up(), EnumFacing.DOWN);
    }

    public boolean isOcelotSittingOnChest(World world, BlockPos pos)
    {
        for(Entity entity : world.getEntitiesWithinAABB(EntityOcelot.class, new AxisAlignedBB(pos.getX(), pos.getY() + 1, pos.getZ(), pos.getX() + 1, pos.getY() + 2, pos.getZ() + 1)))
        {
            EntityOcelot entityocelot = (EntityOcelot)entity;

            if(entityocelot.isSitting())
            {
                return true;
            }
        }

        return false;
    }

    @SuppressWarnings("deprecation")
    public boolean hasComparatorInputOverride(IBlockState state)
    {
        return true;
    }

    @SuppressWarnings("deprecation")
    public int getComparatorInputOverride(IBlockState blockState, World world, BlockPos pos)
    {
        return Container.calcRedstoneFromInventory(this.getLockableContainer(world, pos));
    }

    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if(enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(FACING).getIndex();
    }

    @SuppressWarnings("deprecation")
    public IBlockState withRotation(IBlockState state, Rotation rotation)
    {
        return state.withProperty(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @SuppressWarnings("deprecation")
    public IBlockState withMirror(IBlockState state, Mirror mirror)
    {
        return state.withRotation(mirror.toRotation(state.getValue(FACING)));
    }

    public BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, FACING);
    }

    @SuppressWarnings("deprecation")
    public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

    public enum Type
    {
        BASIC,
        TRAP
    }

    public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis)
    {
        return !isDoubleChest(world, pos) && super.rotateBlock(world, pos, axis);
    }
}