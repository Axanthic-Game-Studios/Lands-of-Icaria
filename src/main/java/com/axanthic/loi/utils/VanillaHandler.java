package com.axanthic.loi.utils;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.Resources;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import static com.axanthic.loi.blocks.BlockIcariaChest.FACING;

public class VanillaHandler
{
	/*@SubscribeEvent
    public void torchNerfs(RightClickBlock event)
    {
        EntityPlayer player = event.getEntityPlayer();
        World world = event.getWorld();

        if(world.provider.getDimension() == LOIConfig.misc.dimensionID && player.dimension == LOIConfig.misc.dimensionID)
        {
            Blocks.TORCH.setLightLevel(0.5F);
        }

        else
        {
            Blocks.TORCH.setLightLevel(0.9375F);
        }
    }*/

	@SubscribeEvent
	public void chestNerfs(PlayerTickEvent event)
	{
		if (LOIConfig.misc.nerfChests) {
			EntityPlayer player = event.player;

			if(player.dimension == LOIConfig.misc.dimensionID)
			{
				for(int slot = 0; slot < player.inventory.getSizeInventory(); slot++)
				{
					ItemStack stack = player.inventory.getStackInSlot(slot);

					if(stack.getItem().equals(Item.getItemFromBlock(Blocks.CHEST)))
					{
						int size = stack.getCount();

						player.inventory.clearMatchingItems(Item.getItemFromBlock(Blocks.CHEST), 0, size, null);
						player.inventory.addItemStackToInventory(new ItemStack(Resources.icariaChest, size));
					}

					if(stack.getItem().equals(Item.getItemFromBlock(Blocks.TRAPPED_CHEST)))
					{
						int size = stack.getCount();

						player.inventory.clearMatchingItems(Item.getItemFromBlock(Blocks.TRAPPED_CHEST), 0, size, null);
						player.inventory.addItemStackToInventory(new ItemStack(Resources.icariaChestTrapped, size));
					}
				}
			}

			if(player.dimension != LOIConfig.misc.dimensionID)
			{
				for(int slot = 0; slot < player.inventory.getSizeInventory(); slot++)
				{
					ItemStack stack = player.inventory.getStackInSlot(slot);

					if(stack.getItem().equals(Item.getItemFromBlock(Block.getBlockFromItem(Resources.icariaChest))))
					{
						int size = stack.getCount();

						player.inventory.clearMatchingItems(Item.getItemFromBlock(Block.getBlockFromItem(Resources.icariaChest)), 0, size, null);
						player.inventory.addItemStackToInventory(new ItemStack(Blocks.CHEST, size));
					}

					if(stack.getItem().equals(Item.getItemFromBlock(Block.getBlockFromItem(Resources.icariaChestTrapped))))
					{
						int size = stack.getCount();

						player.inventory.clearMatchingItems(Item.getItemFromBlock(Block.getBlockFromItem(Resources.icariaChestTrapped)), 0, size, null);
						player.inventory.addItemStackToInventory(new ItemStack(Blocks.TRAPPED_CHEST, size));
					}
				}
			}
		}
	}

	/*@SubscribeEvent
    @SuppressWarnings("deprecation")
    public void onBlockPlaced(PlaceEvent event)
    {
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        EntityPlayer player = event.getPlayer();

        int direction = MathHelper.floor((double)((player.rotationYaw * 4F) / 360F) + 0.5D) & 3;

        // directions
        // 0 = south
        // 1 = west
        // 2 = north
        // 3 = east

        if(world.provider.getDimension() == LOIConfig.misc.dimensionID && !world.isRemote)
        {
            if(event.getPlacedBlock().getBlock() == Blocks.CHEST && direction == 0)
            {
                world.setBlockState(pos, Resources.icariaChest.getBlock().getDefaultState().withProperty(FACING, EnumFacing.NORTH), 3);
            }

            if(event.getPlacedBlock().getBlock() == Blocks.CHEST && direction == 1)
            {
                world.setBlockState(pos, Resources.icariaChest.getBlock().getDefaultState().withProperty(FACING, EnumFacing.EAST), 3);
            }

            if(event.getPlacedBlock().getBlock() == Blocks.CHEST && direction == 2)
            {
                world.setBlockState(pos, Resources.icariaChest.getBlock().getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
            }

            if(event.getPlacedBlock().getBlock() == Blocks.CHEST && direction == 3)
            {
                world.setBlockState(pos, Resources.icariaChest.getBlock().getDefaultState().withProperty(FACING, EnumFacing.WEST), 3);
            }

            if(event.getPlacedBlock().getBlock() == Blocks.TRAPPED_CHEST && direction == 0)
            {
                world.setBlockState(pos, Resources.icariaChestTrapped.getBlock().getDefaultState().withProperty(FACING, EnumFacing.NORTH), 3);
            }

            if(event.getPlacedBlock().getBlock() == Blocks.TRAPPED_CHEST && direction == 1)
            {
                world.setBlockState(pos, Resources.icariaChestTrapped.getBlock().getDefaultState().withProperty(FACING, EnumFacing.EAST), 3);
            }

            if(event.getPlacedBlock().getBlock() == Blocks.TRAPPED_CHEST && direction == 2)
            {
                world.setBlockState(pos, Resources.icariaChestTrapped.getBlock().getDefaultState().withProperty(FACING, EnumFacing.SOUTH), 3);
            }

            if(event.getPlacedBlock().getBlock() == Blocks.TRAPPED_CHEST && direction == 3)
            {
                world.setBlockState(pos, Resources.icariaChestTrapped.getBlock().getDefaultState().withProperty(FACING, EnumFacing.WEST), 3);
            }
        }
    }*/
}