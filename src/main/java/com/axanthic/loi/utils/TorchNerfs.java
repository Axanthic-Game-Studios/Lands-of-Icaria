package com.axanthic.loi.utils;

import com.axanthic.loi.LOIConfig;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TorchNerfs
{
    @SubscribeEvent
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
    }
}