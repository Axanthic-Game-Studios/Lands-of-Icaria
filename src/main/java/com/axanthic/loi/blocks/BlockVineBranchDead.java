package com.axanthic.loi.blocks;

import com.axanthic.loi.LOIVines;
import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.block.Block;
import net.minecraft.block.BlockVine;
import net.minecraft.block.SoundType;
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

public class BlockVineBranchDead extends BlockVine
{
    public BlockVineBranchDead(String name)
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
        return false;
    }

    @Override
    public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
    {
        return Arrays.asList(new ItemStack(this, 0));
    }

    public boolean isAcceptableNeighbor(World world, BlockPos pos, EnumFacing side)
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

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        if (!worldIn.isRemote && worldIn.getBlockState(pos.up()).getBlock() != LOIVines.vineBranch)
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
            spawnAsEntity(worldIn, pos, new ItemStack(this, 0, 0));
        }

        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }

    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {

    }
}