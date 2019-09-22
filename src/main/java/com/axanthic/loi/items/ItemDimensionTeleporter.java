package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ItemDimensionTeleporter extends Item
{
	public ItemDimensionTeleporter()
	{
		super();
		this.setCreativeTab(LandsOfIcaria.modTabItems);
	}

	/**
	 * Called when a Block is right-clicked with this Item
	 */
	@Override
	public EnumActionResult onItemUse(final EntityPlayer playerIn, final World worldIn, final BlockPos pos, final EnumHand hand, final EnumFacing facing, final float hitX, final float hitY, final float hitZ)
	{
		if (worldIn.isRemote)
		{
			return EnumActionResult.SUCCESS;
		}
		else if (worldIn.getWorldType().getId() == LandsOfIcaria.dimensionId)
		{
			return EnumActionResult.FAIL;
		}
		else
		{
			if (!worldIn.isRemote && !playerIn.isDead)
			{
				if (!net.minecraftforge.common.ForgeHooks.onTravelToDimension(playerIn, LandsOfIcaria.dimensionId)) {
					return null;
				}
				worldIn.profiler.startSection("changeDimension");
				final MinecraftServer minecraftserver = playerIn.getServer();
				final int i = playerIn.dimension;
				final WorldServer worldserver = minecraftserver.getWorld(i);
				final WorldServer worldserver1 = minecraftserver.getWorld(LandsOfIcaria.dimensionId);
				playerIn.dimension = LandsOfIcaria.dimensionId;
				
				worldIn.removeEntity(playerIn);
				playerIn.isDead = true;
				playerIn.setHealth((float) 0.0);
				worldIn.profiler.startSection("reposition");
				final BlockPos blockpos = new BlockPos(0, 180, 0);
				worldserver.updateEntityWithOptionalForce(playerIn, false);
				worldIn.profiler.endStartSection("reloading");
				final Entity entity = EntityList.newEntity(playerIn.getClass(), worldserver1);

				if (entity != null)
				{
					final NBTTagCompound nbttagcompound = playerIn.writeToNBT(new NBTTagCompound());
					nbttagcompound.removeTag("Dimension");
					entity.readFromNBT(nbttagcompound);
					entity.timeUntilPortal = playerIn.timeUntilPortal;
					entity.moveToBlockPosAndAngles(blockpos, entity.rotationYaw, entity.rotationPitch);

					final boolean flag = entity.forceSpawn;
					entity.forceSpawn = true;
					worldserver1.spawnEntity(entity);
					entity.forceSpawn = flag;
					worldserver1.updateEntityWithOptionalForce(entity, false);
				}

				playerIn.isDead = true;
				worldIn.profiler.endSection();
				worldserver.resetUpdateEntityTick();
				worldserver1.resetUpdateEntityTick();
				worldIn.profiler.endSection();
				return EnumActionResult.SUCCESS;
			}
			else
			{
				return EnumActionResult.SUCCESS;
			}
		}
	}
}
