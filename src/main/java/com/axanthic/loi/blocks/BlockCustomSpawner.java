package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.block.BlockMobSpawner;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCustomSpawner extends BlockMobSpawner {

	public BlockCustomSpawner(float hardness, String name) {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
		this.disableStats();
	}

	@Override
	public TileEntity createTileEntity(World worldIn, IBlockState state) {
		return Blocks.MOB_SPAWNER.createTileEntity(worldIn, state);
	}

	@Override
	public BlockCustomSpawner setSoundType(SoundType sound) {
		super.setSoundType(sound);
		return this;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if (itemstack.getItem() instanceof ItemMonsterPlacer && playerIn.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
			IBlockState iblockstate = worldIn.getBlockState(pos);
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityMobSpawner) {
				MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
				mobspawnerbaselogic.setEntityId(ItemMonsterPlacer.getNamedIdFrom(itemstack));
				tileentity.markDirty();
				worldIn.notifyBlockUpdate(pos, iblockstate, iblockstate, 3);
				if (!playerIn.capabilities.isCreativeMode) {
					itemstack.shrink(1);
				}
				return true;
			}
		}
		return false;
	}
}
