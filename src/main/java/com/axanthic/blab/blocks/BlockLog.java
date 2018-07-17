package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.items.ItemBlockMaterial;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLog extends BlockRotatedPillar implements IBlockMaterial {

	public BlockPlanks.WoodTypes type;
	public boolean stripped;
	public ItemBlockMaterial strippedLog;

	public BlockLog(BlockPlanks.WoodTypes type, MapColor color, ItemBlockMaterial stripped) {
		super(Material.WOOD, color);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(2.0F);
		this.type = type;
		this.strippedLog = stripped;
		this.setSoundType(SoundType.WOOD);
		if (type.mapColor.equals(color)) {
			this.setUnlocalizedName("log_stripped");
			this.setRegistryName(ModInformation.ID, "stripped_" + type.unlocalizedName);
			this.stripped = true;
		} else {
			this.setUnlocalizedName("log");
			this.setRegistryName(ModInformation.ID, "log_" + type.unlocalizedName);
			this.stripped = false;
		}
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5))) {
			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4))) {
				IBlockState iblockstate = worldIn.getBlockState(blockpos);

				if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos)) {
					iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
				}
			}
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isWood(net.minecraft.world.IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if (!stripped && itemstack.getItem() instanceof ItemAxe && playerIn.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
			worldIn.playSound(playerIn, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 1.0F, 1.0F);
			if (!worldIn.isRemote) {
				worldIn.setBlockState(pos, strippedLog.getBlock().getStateFromMeta(this.getMetaFromState(worldIn.getBlockState(pos))));
				itemstack.damageItem(1, playerIn);
			}
			return true;
		}
		return false;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		if (((EnumFacing.Axis)state.getValue(AXIS)).equals(EnumFacing.Axis.Y) || stripped)
			return type.mapColor;
		return type.logColor;
	}

	@Override
	public String getName() {
		return "material." + type.getName();
	}
}
