package com.axanthic.loi;

import com.axanthic.loi.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSign;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = ModInformation.ID)
public class LOISigns
{
    public static BlockSign signStandingPlane;
    public static BlockSign signWallPlane;
    public static BlockSign signStandingPopulus;
    public static BlockSign signWallPopulus;
    public static BlockSign signStandingCypress;
    public static BlockSign signWallCypress;
    public static BlockSign signStandingFir;
    public static BlockSign signWallFir;
    public static BlockSign signStandingOlive;
    public static BlockSign signWallOlive;
    public static BlockSign signStandingLaurel;
    public static BlockSign signWallLaurel;
    public static BlockSign signStandingDroughtroot;
    public static BlockSign signWallDroughtroot;

    public static void registerSigns()
    {
        signStandingPlane = new BlockSignStandingPlane();
        signWallPlane = new BlockSignWallPlane();
        signStandingPopulus = new BlockSignStandingPopulus();
        signWallPopulus = new BlockSignWallPopulus();
        signStandingCypress = new BlockSignStandingCypress();
        signWallCypress = new BlockSignWallCypress();
        signStandingFir = new BlockSignStandingFir();
        signWallFir = new BlockSignWallFir();
        signStandingOlive = new BlockSignStandingOlive();
        signWallOlive = new BlockSignWallOlive();
        signStandingLaurel = new BlockSignStandingLaurel();
        signWallLaurel = new BlockSignWallLaurel();
        signStandingDroughtroot = new BlockSignStandingDroughtroot();
        signWallDroughtroot = new BlockSignWallDroughtroot();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(signStandingPlane);
        event.getRegistry().register(signWallPlane);
        event.getRegistry().register(signStandingPopulus);
        event.getRegistry().register(signWallPopulus);
        event.getRegistry().register(signStandingCypress);
        event.getRegistry().register(signWallCypress);
        event.getRegistry().register(signStandingFir);
        event.getRegistry().register(signWallFir);
        event.getRegistry().register(signStandingOlive);
        event.getRegistry().register(signWallOlive);
        event.getRegistry().register(signStandingLaurel);
        event.getRegistry().register(signWallLaurel);
        event.getRegistry().register(signStandingDroughtroot);
        event.getRegistry().register(signWallDroughtroot);
    }
}