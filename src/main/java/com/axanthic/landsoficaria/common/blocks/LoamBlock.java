package com.axanthic.landsoficaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class LoamBlock extends Block {
    public LoamBlock() {
        super(Properties.of(Material.DIRT, MaterialColor.TERRACOTTA_LIGHT_GRAY).sound(SoundType.GRAVEL).explosionResistance(0.6F).strength(0.6F));
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        return false; //TODO
    }
}
