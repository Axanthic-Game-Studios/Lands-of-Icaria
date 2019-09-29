package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.tileentity.TileEntityMobHead;

import net.minecraft.block.BlockSkull;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMobHead extends BlockSkull {

	public String name = null;

	public BlockMobHead(String mobName) {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(1.0F);
		this.setSoundType(SoundType.STONE);
		this.name = mobName;
		this.setUnlocalizedName("head_" + mobName);
		this.setRegistryName(ModInformation.ID, "head_" + mobName);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityMobHead();
	}

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)  {
		return new ItemStack(this, 1, 0);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (player.capabilities.isCreativeMode) {
			state = state.withProperty(NODROP, Boolean.valueOf(true));
			worldIn.setBlockState(pos, state, 4);
		}
	}

	@Override
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
		if (!((Boolean)state.getValue(NODROP)).booleanValue()) {
			drops.add(new ItemStack(this, 1, 0));
		}
	}

	/**
	 * Get the Item that this Block should drop when harvested.
	 */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public boolean canDispenserPlace(World worldIn, BlockPos pos, ItemStack stack) {
		return false;
	}

	@Override
	public void checkWitherSpawn(World worldIn, BlockPos pos, TileEntitySkull te) {}
}
