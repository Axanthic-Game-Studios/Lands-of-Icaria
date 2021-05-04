package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;

public class BlockTorchLignite extends BlockTorch
{
    public BlockTorchLignite()
    {
        this.setRegistryName("torch_lignite");
        this.setUnlocalizedName("torch_lignite");
        this.setHardness(0.0F);
        this.setResistance(0.0F);
        this.setLightLevel(0.625F);
        this.setSoundType(SoundType.STONE);
        this.setCreativeTab(LandsOfIcaria.modTabBlocks);
    }
}