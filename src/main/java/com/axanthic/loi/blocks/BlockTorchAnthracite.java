package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;

public class BlockTorchAnthracite extends BlockTorch
{
    public BlockTorchAnthracite()
    {
        this.setRegistryName("torch_anthracite");
        this.setUnlocalizedName("torch_anthracite");
        this.setHardness(0.0F);
        this.setResistance(0.0F);
        this.setLightLevel(0.9375F);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(LandsOfIcaria.modTabBlocks);
    }
}