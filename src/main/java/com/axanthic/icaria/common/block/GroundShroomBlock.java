package com.axanthic.icaria.common.block;

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

import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GroundShroomBlock extends Block implements IPlantable {
	public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

	public GroundShroomBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var pos = pPos.below();
		var state = pLevel.getBlockState(pos);
		if (state.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else {
			return pLevel.getRawBrightness(pPos, 0) <= 12 && state.canSustainPlant(pLevel, pos, Direction.UP, this);
		}
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pRandom.nextInt(25) == 0) {
			int i = 5;
			for (BlockPos posOne : BlockPos.betweenClosed(pPos.offset(-4, -1, -4), pPos.offset(4, 1, 4))) {
				if (pLevel.getBlockState(posOne).is(this)) {
					--i;
					if (i <= 0) {
						return;
					}
				}
			}

			BlockPos posTwo = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
			for (int k = 0; k < 4; ++k) {
				if (pLevel.isEmptyBlock(posTwo) && pState.canSurvive(pLevel, posTwo)) {
					pPos = posTwo;
				}

				posTwo = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);
			}

			if (pLevel.isEmptyBlock(posTwo) && pState.canSurvive(pLevel, posTwo)) {
				pLevel.setBlock(posTwo, pState, 2);
			}
		}
	}

	@Override
	public BlockState getPlant(BlockGetter pLevel, BlockPos pPos) {
		return pLevel.getBlockState(pPos);
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
	}

	@Override
	public PlantType getPlantType(BlockGetter pLevel, BlockPos pPos) {
		return PlantType.CAVE;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Vec3 vec3 = pState.getOffset(pLevel, pPos);
		return SHAPE.move(vec3.x, vec3.y, vec3.z);
	}
}
