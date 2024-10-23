package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.DirectionShapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GroundShroomBlock extends Block {
	public GroundShroomBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var blockPos = pPos.below();
		var blockState = pLevel.getBlockState(blockPos);
		return blockState.is(BlockTags.MUSHROOM_GROW_BLOCK) || blockState.isSolidRender(pLevel, blockPos) && pLevel.getRawBrightness(pPos, 0) <= 12;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pRandom.nextInt(25) == 0) {
			int i = 5;
			for (var blockPos : BlockPos.betweenClosed(pPos.offset(-4, -1, -4), pPos.offset(4, 1, 4))) {
				if (pLevel.getBlockState(blockPos).is(this)) {
					--i;
					if (i <= 0) {
						return;
					}
				}
			}

			var offsetPos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
			for (int k = 0; k < 4; ++k) {
				if (pLevel.isEmptyBlock(offsetPos) && pState.canSurvive(pLevel, offsetPos)) {
					pPos = offsetPos;
				}

				offsetPos = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
			}

			if (pLevel.isEmptyBlock(offsetPos) && pState.canSurvive(pLevel, offsetPos)) {
				pLevel.setBlock(offsetPos, pState, 2);
			}
		}
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Vec3 vec3 = pState.getOffset(pLevel, pPos);
		return DirectionShapes.UP.move(vec3.x, vec3.y, vec3.z);
	}
}
