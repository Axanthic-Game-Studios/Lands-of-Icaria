package com.axanthic.loi.items;

import com.axanthic.loi.LOISigns;
import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.blocks.BlockSignStandingFir;
import com.axanthic.loi.blocks.BlockSignWallFir;
import com.axanthic.loi.tileentity.TESignFir;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemSign;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemSignFir extends ItemSign
{
	public ItemSignFir()
	{
		this.setMaxStackSize(16);
		this.setRegistryName("sign_fir");
		this.setUnlocalizedName("sign_fir");
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float x, float y, float z)
	{
		IBlockState state = world.getBlockState(pos);
		ItemStack stack = player.getHeldItem(hand);

		if (!state.getMaterial().isSolid())
		{
			return EnumActionResult.PASS;
		}

		else
		{
			pos = pos.offset(facing);

			if (!player.canPlayerEdit(pos, facing, stack) || !LOISigns.signStandingFir.canPlaceBlockAt(world, pos))
			{
				return EnumActionResult.PASS;
			}

			else if (world.isRemote)
			{
				return EnumActionResult.PASS;
			}

			else
			{
				if (facing == EnumFacing.UP && !player.isSneaking())
				{
					int rotation = MathHelper.floor((double)((player.rotationYaw + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
					world.setBlockState(pos, LOISigns.signStandingFir.getDefaultState().withProperty(BlockSignStandingFir.ROTATION, rotation), 3);
				}

				else
				{
					int finalRotation = facing.getIndex();

					if (facing == EnumFacing.DOWN || facing == EnumFacing.UP)
					{
						int rotation = MathHelper.floor((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
						finalRotation += (rotation << 1);
						finalRotation += 8;
					}

					world.setBlockState(pos, LOISigns.signWallFir.getDefaultState().withProperty(BlockSignWallFir.ROTATION, finalRotation), 3);
				}

				TileEntity tileentity = world.getTileEntity(pos);

				if (tileentity instanceof TESignFir)
				{
					player.openEditSign((TileEntitySign) tileentity);
				}

				if (player instanceof EntityPlayerMP)
				{
					CriteriaTriggers.PLACED_BLOCK.trigger((EntityPlayerMP) player, pos, stack);
				}

				stack.shrink(1);
				return EnumActionResult.SUCCESS;
			}
		}
	}
}