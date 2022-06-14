package com.axanthic.icaria.common.blocks;

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
		return this.mayPlaceOn(pLevel.getBlockState(pPos.below()), pLevel, pPos);
	}

	public boolean mayPlaceOn(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		if (pState.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
			return true;
		} else if (Block.isFaceFull(pLevel.getBlockState(pPos.below()).getCollisionShape(pLevel, pPos.below()), Direction.UP)) {
			return pLevel.getRawBrightness(pPos, 0) < 13 && pState.canSustainPlant(pLevel, pPos, Direction.UP, this);
		}

		return false;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pReader, BlockPos pPos) {
		return true;
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pRandom.nextInt(25) == 0) {
			int i = 5;

			for(BlockPos posOne : BlockPos.betweenClosed(pPos.offset(-4, -1, -4), pPos.offset(4, 1, 4))) {
				if (pLevel.getBlockState(posOne).is(this)) {
					--i;
					if (i <= 0) {
						return;
					}
				}
			}

			BlockPos posTwo = pPos.offset(pRandom.nextInt(3) - 1, pRandom.nextInt(2) - pRandom.nextInt(2), pRandom.nextInt(3) - 1);

			for(int k = 0; k < 4; ++k) {
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
	public BlockState getPlant(BlockGetter level, BlockPos pos) {
		return level.getBlockState(pos);
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
		return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}

	@Override
	public PlantType getPlantType(BlockGetter world, BlockPos pos) {
		return PlantType.CAVE;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Vec3 vec3 = pState.getOffset(pLevel, pPos);
		return SHAPE.move(vec3.x, vec3.y, vec3.z);
	}
}
