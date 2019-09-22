package com.axanthic.loi.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlockForge extends ItemBlock {

	public ItemBlockForge(Block block) {
		super(block);
	}

	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		IBlockState iblockstate = worldIn.getBlockState(pos);
		Block block = iblockstate.getBlock();

		if (!block.isReplaceable(worldIn, pos)) {
			pos = pos.offset(facing);
		}
		ItemStack itemstack = player.getHeldItem(hand);

		if (!itemstack.isEmpty() && player.canPlayerEdit(pos, facing, itemstack) && worldIn.mayPlace(this.block, pos, false, facing, (Entity) null)) {
			int i = this.getMetadata(itemstack.getMetadata());
			IBlockState iblockstate1 = this.block.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, i, player, hand);

			EnumFacing facing2 = (EnumFacing) iblockstate1.getValue(BlockHorizontal.FACING);
			BlockPos[] occupied = new BlockPos[] {
					pos.offset(facing2),
					pos.offset(facing2).offset(facing2.rotateY()),
					pos.offset(facing2.rotateY()),
					pos.offset(EnumFacing.UP),
					pos.offset(EnumFacing.UP).offset(facing2),
					pos.offset(EnumFacing.UP).offset(facing2).offset(facing2.rotateY()),
					pos.offset(EnumFacing.UP).offset(facing2.rotateY())
			};
			for (BlockPos pos2 : occupied) {
				if (!worldIn.getBlockState(pos2).getBlock().isReplaceable(worldIn, pos2) || !player.canPlayerEdit(pos2, facing, itemstack) || !worldIn.mayPlace(this.block, pos2, false, facing, (Entity) null)) {
					return EnumActionResult.FAIL;
				}
			}
			if (placeBlockAt(itemstack, player, worldIn, pos, facing, hitX, hitY, hitZ, iblockstate1)) {
				iblockstate1 = worldIn.getBlockState(pos);
				SoundType soundtype = iblockstate1.getBlock().getSoundType(iblockstate1, worldIn, pos, player);
				worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS,
						(soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
				itemstack.shrink(1);
			}
			return EnumActionResult.SUCCESS;
		} else {
			return EnumActionResult.FAIL;
		}
	}
}
