package com.axanthic.loi.blocks;

import com.axanthic.loi.Resources;
import com.axanthic.loi.tileentity.TESignOlive;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockSignStandingOlive extends BlockSign
{
    public static final PropertyInteger ROTATION = PropertyInteger.create("rotation", 0, 15);

    public BlockSignStandingOlive()
    {
        this.setRegistryName("sign_standing_olive");
        this.setHardness(1.0F);
        this.setResistance(1.0F);
        this.setHarvestLevel("axe", 0);
        this.setSoundType(SoundType.WOOD);
    }

    @SuppressWarnings("deprecation")
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos fromPos)
    {
        if (!world.getBlockState(pos.down()).getMaterial().isSolid())
        {
            this.dropBlockAsItem(world, pos, state, 0);
            world.setBlockToAir(pos);
        }

        super.neighborChanged(state, world, pos, block, fromPos);
    }

    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(ROTATION).intValue();
    }

    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(ROTATION, Integer.valueOf(meta % ROTATION.getAllowedValues().size()));
    }

    public BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, ROTATION);
    }

    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TESignOlive();
    }

    public ItemStack getItem(World world, BlockPos pos, IBlockState state)
    {
        return new ItemStack(Resources.signOlive);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Resources.signOlive;
    }
}