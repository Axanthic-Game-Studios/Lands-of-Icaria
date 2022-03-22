package com.axanthic.icaria.common.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

@SuppressWarnings("deprecation")

public class DamagingFlowerPotBlock extends FlowerPotBlock {
	public DamagingFlowerPotBlock(Supplier<FlowerPotBlock> emptyPot, Supplier<? extends Block> pContent, Properties properties) {
		super(emptyPot, pContent, properties);
	}

	@Override
	public void entityInside(@Nonnull BlockState pState, @Nonnull Level pLevel, @Nonnull BlockPos pPos, Entity pEntity) {
		pEntity.hurt(DamageSource.CACTUS, 1.0F);
	}

	@Override
	public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter level, BlockPos pos, Mob entity) {
		return BlockPathTypes.DAMAGE_CACTUS;
	}
}
