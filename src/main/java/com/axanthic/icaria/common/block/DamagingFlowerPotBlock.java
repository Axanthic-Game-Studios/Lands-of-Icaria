package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;

import java.util.function.Supplier;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DamagingFlowerPotBlock extends FlowerPotBlock {
	public DamagingFlowerPotBlock(Supplier<FlowerPotBlock> pEmpty, Supplier<? extends Block> pContent, Properties pProperties) {
		super(pEmpty, pContent, pProperties);
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity) {
		IcariaCommonHelper.hurt(pLevel.damageSources().cactus(), pEntity, 1.0F);
	}

	@Override
	public PathType getBlockPathType(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, @Nullable Mob pMob) {
		return PathType.DAMAGE_OTHER;
	}
}
