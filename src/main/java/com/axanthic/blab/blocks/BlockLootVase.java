package com.axanthic.blab.blocks;

import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.entity.EntityFallingVase;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLootVase extends BlockGravity {

	public BlockLootVase() {
		super(Material.ROCK, 0.0F, "loot_vase", MapColor.GRAY);
		this.setSoundType(Resources.CERAMIC);
	}

	@Override
	public boolean canSilkHarvest() {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		//drop sweet loot
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (playerIn.isBeingRidden() || worldIn.isRemote || !playerIn.getHeldItemMainhand().isEmpty() || !playerIn.getHeldItemOffhand().isEmpty())
			return false;

		EntityFallingVase entityfallingblock = new EntityFallingVase(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
		this.onStartFalling(entityfallingblock);
		entityfallingblock.startRiding(playerIn);
		worldIn.spawnEntity(entityfallingblock);
		playerIn.sendStatusMessage(new TextComponentTranslation("message.loot_vase.pickup"), true);
		return true;
	}

	@Override
	public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_) {
		worldIn.destroyBlock(pos, true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {

	}
}
