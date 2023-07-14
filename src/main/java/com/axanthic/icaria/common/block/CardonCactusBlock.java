package com.axanthic.icaria.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CardonCactusBlock extends PipeBlock implements IPlantable {
	public CardonCactusBlock(Properties pProperties) {
		super(0.25F, pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(BlockStateProperties.UP, false).setValue(BlockStateProperties.DOWN, false));
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var belowState = pLevel.getBlockState(pPos.below());
		for (var direction : Direction.Plane.HORIZONTAL) {
			var relativePos = pPos.relative(direction);
			if (pLevel.getBlockState(relativePos).is(this)) {
				var relativeState = pLevel.getBlockState(relativePos.below());
				if (relativeState.is(this) || relativeState.is(BlockTags.SAND)) {
					return true;
				}
			}
		}

		return belowState.is(this) || belowState.is(BlockTags.SAND);
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, BlockStateProperties.UP, BlockStateProperties.DOWN);
	}

	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		pEntity.hurt(pLevel.damageSources().cactus(), 1.0F);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		var abovePos = pPos.above();
		var direction = Direction.Plane.HORIZONTAL.getRandomDirection(pRandom);
		if (pLevel.isAreaLoaded(pPos, 1)) {
			if (pRandom.nextInt(4) == 0) {
				if (pLevel.getBlockState(abovePos).isAir()) {
					if (!pLevel.getBlockState(pPos.below(4)).is(this) && !pLevel.getBlockState(pPos.north()).is(this) && !pLevel.getBlockState(pPos.east()).is(this) && !pLevel.getBlockState(pPos.south()).is(this) && !pLevel.getBlockState(pPos.west()).is(this)) {
						pLevel.setBlock(abovePos, this.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)).setValue(BlockStateProperties.DOWN, pState.getValue(BlockStateProperties.DOWN)), 2);
					}
				}

				if (pLevel.getBlockState(pPos.relative(direction)).isAir() && pLevel.getBlockState(abovePos.relative(direction)).isAir()) {
					if (pLevel.getBlockState(pPos.above(2)).is(this) && pLevel.getBlockState(pPos.below()).is(this)) {
						pLevel.setBlock(pPos.relative(direction), this.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)).setValue(BlockStateProperties.DOWN, pState.getValue(BlockStateProperties.DOWN)), 2);
						pLevel.setBlock(abovePos.relative(direction), this.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)).setValue(BlockStateProperties.DOWN, pState.getValue(BlockStateProperties.DOWN)), 2);
					}
				}
			}
		}
	}

	@Override
	public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (!pState.canSurvive(pLevel, pPos)) {
			pLevel.destroyBlock(pPos, true);
		}
	}

	@Override
	public BlockPathTypes getBlockPathType(BlockState pState, BlockGetter pLevel, BlockPos pPos, @Nullable Mob pMob) {
		return BlockPathTypes.DAMAGE_OTHER;
	}

	@Override
	public BlockState getPlant(BlockGetter pLevel, BlockPos pPos) {
		return pLevel.getBlockState(pPos);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var blockPos = pContext.getClickedPos();
		var level = pContext.getLevel();
		var aboveState = level.getBlockState(blockPos.above());
		var belowState = level.getBlockState(blockPos.below());
		return this.defaultBlockState().setValue(BlockStateProperties.DOWN, belowState.is(this) || belowState.is(BlockTags.SAND)).setValue(BlockStateProperties.UP, aboveState.is(this));
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		var northPos = pCurrentPos.north();
		var eastPos = pCurrentPos.east();
		var southPos = pCurrentPos.south();
		var westPos = pCurrentPos.west();
		var abovePos = pCurrentPos.above();
		var belowPos = pCurrentPos.below();

		boolean north = pLevel.getBlockState(northPos).is(this);
		boolean east = pLevel.getBlockState(eastPos).is(this);
		boolean south = pLevel.getBlockState(southPos).is(this);
		boolean west = pLevel.getBlockState(westPos).is(this);
		boolean up = pLevel.getBlockState(abovePos).is(this);
		boolean down = pLevel.getBlockState(belowPos).is(this) || pLevel.getBlockState(belowPos).is(BlockTags.SAND);

		if (down) {
			north = north && !pLevel.getBlockState(northPos.below()).is(this);
			east = east && !pLevel.getBlockState(eastPos.below()).is(this);
			south = south && !pLevel.getBlockState(southPos.below()).is(this);
			west = west && !pLevel.getBlockState(westPos.below()).is(this);
		}

		if (!pState.canSurvive(pLevel, pCurrentPos)) {
			pLevel.scheduleTick(pCurrentPos, this, 1);
			return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
		}

		return pState.setValue(BlockStateProperties.NORTH, north).setValue(BlockStateProperties.EAST, east).setValue(BlockStateProperties.SOUTH, south).setValue(BlockStateProperties.WEST, west).setValue(BlockStateProperties.UP, up).setValue(BlockStateProperties.DOWN, down);
	}
}
