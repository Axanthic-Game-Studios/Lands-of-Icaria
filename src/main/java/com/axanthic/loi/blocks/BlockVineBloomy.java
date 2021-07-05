package com.axanthic.loi.blocks;

import com.axanthic.loi.LOIVines;
import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemShears;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BlockVineBloomy extends BlockVine
{
    public BlockVineBloomy(String name)
    {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setHardness(0.2F);
        this.setResistance(0.2F);
        this.setSoundType(SoundType.PLANT);
        this.setCreativeTab(LandsOfIcaria.modTabFlora);
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 300;
    }

    @Override
    public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos)
    {
        return true;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return Arrays.asList(new ItemStack(this, 1));
    }

    private boolean isAcceptableNeighbor(World world, BlockPos pos, EnumFacing side)
    {
        IBlockState state = world.getBlockState(pos);
        return state.getBlockFaceShape(world, pos, side) == BlockFaceShape.SOLID && !isExceptBlockForAttaching(state.getBlock());
    }

    @Override
    public boolean canAttachTo(World world, BlockPos pos, EnumFacing side)
    {
        Block block = world.getBlockState(pos.up()).getBlock();
        return this.isAcceptableNeighbor(world, pos.offset(side.getOpposite()), side) && (block == Blocks.AIR || block instanceof BlockVine || this.isAcceptableNeighbor(world, pos.up(), EnumFacing.UP));
    }

    public boolean recheckGrownSides(World worldIn, BlockPos pos, IBlockState state)
    {
        IBlockState iblockstate = state;

        for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
        {
            PropertyBool propertybool = getPropertyFor(enumfacing);

            if (state.getValue(propertybool).booleanValue() && !this.canAttachTo(worldIn, pos, enumfacing.getOpposite()))
            {
                IBlockState blockstate = worldIn.getBlockState(pos.up());

                if (blockstate.getBlock() != this && blockstate.getBlock() != LOIVines.vineBloomyBlooming && blockstate.getBlock() != LOIVines.vineBloomyFruit || !blockstate.getValue(propertybool).booleanValue())
                {
                    state = state.withProperty(propertybool, Boolean.valueOf(false));
                }
            }
        }

        if (getNumGrownFaces(state) == 0)
        {
            return false;
        }

        else
        {
            if (iblockstate != state)
            {
                worldIn.setBlockState(pos, state, 2);
            }

            return true;
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!worldIn.isRemote && !this.recheckGrownSides(worldIn, pos, state))
        {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() instanceof ItemShears)
        {
            player.addStat(StatList.getBlockStats(this));
            spawnAsEntity(worldIn, pos, new ItemStack(this, 1, 0));
        }

        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if(!worldIn.isRemote)
        {
            if(rand.nextInt(4) == 0 && worldIn.isAreaLoaded(pos, 4))
            {
                int i = 5;
                boolean flag = false;
                label181:

                for (int x = -4; x <= 4; ++x)
                {
                    for (int z = -4; z <= 4; ++z)
                    {
                        for (int y = -1; y <= 1; ++y)
                        {
                            if (worldIn.getBlockState(pos.add(x, y, z)).getBlock() == this)
                            {
                                --i;

                                if (i <= 0)
                                {
                                    flag = true;
                                    break label181;
                                }
                            }
                        }
                    }
                }

                if(rand.nextBoolean())
                {
                    if(worldIn.isAirBlock(pos.down()))
                    {
                        worldIn.setBlockState(pos.down(), LOIVines.vineBloomyGrowing.getDefaultState()
                                .withProperty(NORTH, state.getValue(NORTH))
                                .withProperty(EAST, state.getValue(EAST))
                                .withProperty(SOUTH, state.getValue(SOUTH))
                                .withProperty(WEST, state.getValue(WEST)));
                    }
                }

                if(!flag)
                {
                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.east()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.east().north(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.east(), this.getDefaultState().withProperty(NORTH, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.west()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.west().north(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.west(), this.getDefaultState().withProperty(NORTH, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.east()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.east().south(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.east(), this.getDefaultState().withProperty(SOUTH, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(SOUTH, true)
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.west()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.west().south(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.west(), this.getDefaultState().withProperty(SOUTH, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true))
                    {
                        if(worldIn.isAirBlock(pos.north()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.north().east(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.north(), this.getDefaultState().withProperty(EAST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true))
                    {
                        if(worldIn.isAirBlock(pos.south()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.south().east(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.south(), this.getDefaultState().withProperty(EAST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(WEST, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true))
                    {
                        if(worldIn.isAirBlock(pos.north()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.north().west(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.north(), this.getDefaultState().withProperty(WEST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true))
                    {
                        if(worldIn.isAirBlock(pos.south()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.south().west(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.south(), this.getDefaultState().withProperty(WEST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.east()) && worldIn.isAirBlock(pos.east().north()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.east().north(), this.getDefaultState().withProperty(WEST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.west()) && worldIn.isAirBlock(pos.west().north()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.west().north(), this.getDefaultState().withProperty(EAST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.east()) && worldIn.isAirBlock(pos.east().south()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.east().south(), this.getDefaultState().withProperty(WEST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(SOUTH, true)
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(worldIn.isAirBlock(pos.west()) && worldIn.isAirBlock(pos.west().south()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.west().south(), this.getDefaultState().withProperty(EAST, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true))
                    {
                        if(worldIn.isAirBlock(pos.south()) && worldIn.isAirBlock(pos.south().east()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.south().east(), this.getDefaultState().withProperty(NORTH, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(EAST, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true))
                    {
                        if(worldIn.isAirBlock(pos.north()) && worldIn.isAirBlock(pos.north().east()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.north().east(), this.getDefaultState().withProperty(SOUTH, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(WEST, true)
                            .withProperty(SOUTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true))
                    {
                        if(worldIn.isAirBlock(pos.north()) && worldIn.isAirBlock(pos.north().west()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.north().west(), this.getDefaultState().withProperty(SOUTH, true));
                            }
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(WEST, true) || state == this.getDefaultState()
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true) || state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true) || state == getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(NORTH, true)
                            .withProperty(WEST, true))
                    {
                        if(worldIn.isAirBlock(pos.south()) && worldIn.isAirBlock(pos.south().west()))
                        {
                            if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                            {
                                worldIn.setBlockState(pos.south().west(), this.getDefaultState().withProperty(NORTH, true));
                            }
                        }
                    }

                    //N
                    if(state == this.getDefaultState().withProperty(NORTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(EAST, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(NORTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(SOUTH, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(NORTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(WEST, true));
                        }
                    }

                    //E
                    if(state == this.getDefaultState().withProperty(EAST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(SOUTH, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(EAST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(WEST, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(EAST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(NORTH, true));
                        }
                    }

                    //S
                    if(state == this.getDefaultState().withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(SOUTH, true)
                                    .withProperty(NORTH, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(SOUTH, true)
                                    .withProperty(EAST, true));
                        }
                    }

                    //W
                    if(state == this.getDefaultState().withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(WEST, true)
                                    .withProperty(EAST, true));
                        }
                    }

                    if(state == this.getDefaultState().withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(WEST, true)
                                    .withProperty(SOUTH, true));
                        }
                    }

                    //NE
                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(EAST, true)
                                    .withProperty(SOUTH, true));
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(EAST, true)
                                    .withProperty(WEST, true));
                        }
                    }

                    //ES
                    if(state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true));
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(SOUTH, true)
                                    .withProperty(NORTH, true));
                        }
                    }

                    //SW
                    if(state == this.getDefaultState()
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true));
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true)
                                    .withProperty(EAST, true));
                        }
                    }

                    //WN
                    if(state == this.getDefaultState()
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true)
                                    .withProperty(EAST, true));
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true)
                                    .withProperty(SOUTH, true));
                        }
                    }

                    //NS
                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(SOUTH, true)
                                    .withProperty(EAST, true));
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true));
                        }
                    }

                    //EW
                    if(state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true));
                        }
                    }

                    if(state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(WEST, true)
                                    .withProperty(SOUTH, true));
                        }
                    }

                    //NES
                    if(state == this.getDefaultState()
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.west(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(NORTH, true)
                                    .withProperty(EAST, true)
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true));
                        }
                    }

                    //ESW
                    if(state == this.getDefaultState()
                            .withProperty(EAST, true)
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.north(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(EAST, true)
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true));
                        }
                    }

                    //SWN
                    if(state == this.getDefaultState()
                            .withProperty(SOUTH, true)
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.east(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(SOUTH, true)
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true)
                                    .withProperty(EAST, true));
                        }
                    }

                    //WNE
                    if(state == this.getDefaultState()
                            .withProperty(WEST, true)
                            .withProperty(NORTH, true)
                            .withProperty(EAST, true))
                    {
                        if(isAcceptableNeighbor(worldIn, pos.south(), EnumFacing.UP))
                        {
                            worldIn.setBlockState(pos, this.getDefaultState()
                                    .withProperty(WEST, true)
                                    .withProperty(NORTH, true)
                                    .withProperty(EAST, true)
                                    .withProperty(SOUTH, true));
                        }
                    }
                }

                if(rand.nextInt(8) == 0)
                {
                    if(state == this.getDefaultState()
                            .withProperty(NORTH, state.getValue(NORTH))
                            .withProperty(EAST, state.getValue(EAST))
                            .withProperty(SOUTH, state.getValue(SOUTH))
                            .withProperty(WEST, state.getValue(WEST)))
                    {
                        worldIn.setBlockState(pos, LOIVines.vineBloomyBlooming.getDefaultState()
                                .withProperty(NORTH, state.getValue(NORTH))
                                .withProperty(EAST, state.getValue(EAST))
                                .withProperty(SOUTH, state.getValue(SOUTH))
                                .withProperty(WEST, state.getValue(WEST)));
                    }
                }
            }
        }
    }
}