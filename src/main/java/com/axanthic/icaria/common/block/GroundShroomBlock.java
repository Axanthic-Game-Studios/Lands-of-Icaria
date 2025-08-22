package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.DirectionShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GroundShroomBlock extends Block {
	public GroundShroomBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pPpBlockPoss) {
		var blockState = pLevelReader.getBlockState(pPpBlockPoss.below());
		return blockState.is(BlockTags.MUSHROOM_GROW_BLOCK) || blockState.isSolidRender() && pLevelReader.getRawBrightness(pPpBlockPoss, 0) <= 12;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pBlockState) {
		return true;
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		var aabb = AABB.ofSize(pBlockPos.getCenter(), 9, 3, 9);
		var blockPos = pBlockPos.offset(pRandomSource.nextInt(3) - 1, pRandomSource.nextInt(3) - 1, pRandomSource.nextInt(3) - 1);
		if (pServerLevel.getBlockStates(aabb).toList().stream().filter(blockState -> blockState.is(this)).count() < 5) {
			if (pServerLevel.getBlockState(blockPos).isAir()) {
				if (pBlockState.canSurvive(pServerLevel, blockPos)) {
					if (pRandomSource.nextInt(25) == 0) {
						pServerLevel.setBlock(blockPos, pBlockState, 2);
					}
				}
			}
		}
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.canSurvive(pLevelReader, pBlockPos) ? super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource) : Blocks.AIR.defaultBlockState();
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		var vec3 = pBlockState.getOffset(pBlockPos);
		return DirectionShapes.UP.move(vec3.x, vec3.y, vec3.z);
	}
}
