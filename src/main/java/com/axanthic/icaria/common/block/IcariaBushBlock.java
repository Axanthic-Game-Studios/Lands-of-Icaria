package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaShapes;

import com.mojang.serialization.MapCodec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBushBlock extends BushBlock {
	public static final MapCodec<IcariaBushBlock> CODEC = Block.simpleCodec(IcariaBushBlock::new);

	public IcariaBushBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		return pState.is(BlockTags.REPLACEABLE);
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var blockState = pLevel.getBlockState(pPos.below());
		if (this.equals(IcariaBlocks.NAMDRAKE.get())) {
			return blockState.is(IcariaBlocks.DRY_LAKE_BED.get());
		} else if (this.equals(IcariaBlocks.MONDANOS.get())) {
			return blockState.is(BlockTags.SAND);
		} else if (this.equals(IcariaBlocks.BOLBOS.get())) {
			return blockState.is(BlockTags.SAND);
		} else {
			return blockState.is(BlockTags.DIRT);
		}
	}

	@Override
	public MapCodec<? extends BushBlock> codec() {
		return IcariaBushBlock.CODEC;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		var vec3 = pState.getOffset(pLevel, pPos);
		return IcariaShapes.UP.move(vec3.x, vec3.y, vec3.z);
	}
}
