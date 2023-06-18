package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaVineBaseBlock extends Block {
	public Block growing;
	public Block dead;

	public Map<BlockState, VoxelShape> map;

	public static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = ImmutableMap.copyOf(Util.make(Maps.newEnumMap(Direction.class), (enumMap) -> {
		enumMap.put(Direction.NORTH, BlockStateProperties.NORTH);
		enumMap.put(Direction.EAST, BlockStateProperties.EAST);
		enumMap.put(Direction.SOUTH, BlockStateProperties.SOUTH);
		enumMap.put(Direction.WEST, BlockStateProperties.WEST);
		enumMap.put(Direction.UP, BlockStateProperties.UP);
	}));

	public static final VoxelShape SHAPE_NORTH = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 1.0D);
	public static final VoxelShape SHAPE_EAST = Block.box(15.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_SOUTH = Block.box(0.0D, 0.0D, 15.0D, 16.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_WEST = Block.box(0.0D, 0.0D, 0.0D, 1.0D, 16.0D, 16.0D);
	public static final VoxelShape SHAPE_UP = Block.box(0.0D, 15.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public IcariaVineBaseBlock(Properties pProperties, Block pGrowing, Block pDead) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(BlockStateProperties.UP, false));
		this.map = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), IcariaVineBaseBlock::calculateShape)));
		this.growing = pGrowing;
		this.dead = pDead;
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		var clickedState = pUseContext.getLevel().getBlockState(pUseContext.getClickedPos());
		if (clickedState.is(this)) {
			return this.countFaces(clickedState) < IcariaVineBaseBlock.PROPERTY_BY_DIRECTION.size();
		} else {
			return super.canBeReplaced(pState, pUseContext);
		}
	}

	public boolean canSpread(BlockGetter pLevel, BlockPos pPos) {
		var iterablePos = BlockPos.betweenClosed(pPos.getX() - 4, pPos.getY() - 1, pPos.getZ() - 4, pPos.getX() + 4, pPos.getY() + 1, pPos.getZ() + 4);
		int j = 5;
		for (BlockPos blockPos : iterablePos) {
			if (pLevel.getBlockState(blockPos).is(this)) {
				--j;
				if (j <= 0) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean canSupportAtFace(BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return false;
		} else {
			var relativePos = pPos.relative(pDirection);
			if (IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, relativePos, pDirection)) {
				return true;
			} else if (pDirection.getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				var aboveState = pLevel.getBlockState(pPos.above());
				return aboveState.is(BlockTags.CLIMBABLE) && aboveState.getValue(IcariaVineBaseBlock.PROPERTY_BY_DIRECTION.get(pDirection));
			}
		}
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		return this.hasFaces(this.getUpdatedState(pState, pLevel, pPos));
	}

	public boolean hasFaces(BlockState pState) {
		return this.countFaces(pState) > 0;
	}

	public boolean hasHorizontalConnection(BlockState pState) {
		return pState.getValue(BlockStateProperties.NORTH) || pState.getValue(BlockStateProperties.EAST) || pState.getValue(BlockStateProperties.SOUTH) || pState.getValue(BlockStateProperties.WEST);
	}

	public static boolean isAcceptableNeighbour(BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		return Block.isFaceFull(pLevel.getBlockState(pPos).getCollisionShape(pLevel, pPos), pDirection.getOpposite());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	public int countFaces(BlockState pState) {
		int i = 0;
		for (BooleanProperty booleanProperty : IcariaVineBaseBlock.PROPERTY_BY_DIRECTION.values()) {
			if (pState.getValue(booleanProperty)) {
				++i;
			}
		}

		return i;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, BlockStateProperties.UP);
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		if (pLevel.random.nextInt(4) == 0) {
			if (pLevel.isAreaLoaded(pPos, 4)) {
				var abovePos = pPos.above();
				var randomDirection = Direction.getRandom(pRandom);
				if (randomDirection.getAxis().isHorizontal() && !pState.getValue(IcariaVineBaseBlock.getPropertyForFace(randomDirection))) {
					if (this.canSpread(pLevel, pPos)) {
						var relativePos = pPos.relative(randomDirection);
						if (pLevel.getBlockState(relativePos).isAir()) {
							var clockWiseDirection = randomDirection.getClockWise();
							var counterClockWiseDirection = randomDirection.getCounterClockWise();
							var clockWisePos = relativePos.relative(clockWiseDirection);
							var counterClockWisePos = relativePos.relative(counterClockWiseDirection);
							boolean clockWiseFlag = pState.getValue(IcariaVineBaseBlock.getPropertyForFace(clockWiseDirection));
							boolean counterClockWiseFlag = pState.getValue(IcariaVineBaseBlock.getPropertyForFace(counterClockWiseDirection));
							if (clockWiseFlag && IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, clockWisePos, clockWiseDirection)) {
								pLevel.setBlock(relativePos, this.defaultBlockState().setValue(IcariaVineBaseBlock.getPropertyForFace(clockWiseDirection), true), 2);
							} else if (counterClockWiseFlag && IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, counterClockWisePos, counterClockWiseDirection)) {
								pLevel.setBlock(relativePos, this.defaultBlockState().setValue(IcariaVineBaseBlock.getPropertyForFace(counterClockWiseDirection), true), 2);
							} else {
								var oppositeDirection = randomDirection.getOpposite();
								if (clockWiseFlag && pLevel.isEmptyBlock(clockWisePos) && IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, pPos.relative(clockWiseDirection), oppositeDirection)) {
									pLevel.setBlock(clockWisePos, this.defaultBlockState().setValue(IcariaVineBaseBlock.getPropertyForFace(oppositeDirection), true), 2);
								} else if (counterClockWiseFlag && pLevel.isEmptyBlock(counterClockWisePos) && IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, pPos.relative(counterClockWiseDirection), oppositeDirection)) {
									pLevel.setBlock(counterClockWisePos, this.defaultBlockState().setValue(IcariaVineBaseBlock.getPropertyForFace(oppositeDirection), true), 2);
								} else if (pRandom.nextFloat() < 0.05D && IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, relativePos.above(), Direction.UP)) {
									pLevel.setBlock(relativePos, this.defaultBlockState().setValue(BlockStateProperties.UP, true), 2);
								}
							}
						} else if (IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, relativePos, randomDirection)) {
							pLevel.setBlock(pPos, pState.setValue(IcariaVineBaseBlock.getPropertyForFace(randomDirection), true), 2);
						}
					}
				} else {
					if (randomDirection == Direction.UP) {
						if (pPos.getY() < pLevel.getMaxBuildHeight() - 1) {
							if (this.canSupportAtFace(pLevel, pPos, randomDirection)) {
								pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.UP, true), 2);
								return;
							}

							if (pLevel.isEmptyBlock(abovePos)) {
								var blockState = pState;
								if (!this.canSpread(pLevel, pPos)) {
									return;
								}

								for (Direction direction : Direction.Plane.HORIZONTAL) {
									if (pRandom.nextBoolean() || !IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, abovePos.relative(direction), direction)) {
										blockState = blockState.setValue(IcariaVineBaseBlock.getPropertyForFace(direction), false);
									}
								}

								if (this.hasHorizontalConnection(blockState)) {
									pLevel.setBlock(abovePos, blockState, 2);
								}

								return;
							}
						}
					}

					if (!pLevel.getBlockState(pPos).equals(this.defaultBlockState().setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)))) {
						if (pLevel.getBlockState(pPos.below()).isAir()) {
							if (pRandom.nextInt(8) == 0) {
								pLevel.setBlock(pPos.below(), this.dead.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)), 2);
							} else {
								pLevel.setBlock(pPos.below(), this.growing.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)), 2);
							}
						}

						if (pLevel.getBlockState(pPos.below()).equals(this.growing.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)))) {
							if (pLevel.getBlockState(pPos.below().below()).isAir()) {
								if (pRandom.nextInt(8) == 0) {
									pLevel.setBlock(pPos.below().below(), this.dead.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)), 2);
								} else {
									pLevel.setBlock(pPos.below().below(), this.growing.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)), 2);
								}

								pLevel.setBlock(pPos.below(), this.defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)), 2);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var clickedState = pContext.getLevel().getBlockState(pContext.getClickedPos());
		boolean clickedFlag = clickedState.is(this);
		var blockState = clickedFlag ? clickedState : this.defaultBlockState();
		for (Direction direction : pContext.getNearestLookingDirections()) {
			if (direction != Direction.DOWN) {
				BooleanProperty booleanProperty = IcariaVineBaseBlock.getPropertyForFace(direction);
				boolean flag = clickedFlag && clickedState.getValue(booleanProperty);
				if (!flag && this.canSupportAtFace(pContext.getLevel(), pContext.getClickedPos(), direction)) {
					return blockState.setValue(booleanProperty, true);
				}
			}
		}

		return clickedFlag ? blockState : null;
	}

	public BlockState getUpdatedState(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		var abovePos = pPos.above();
		if (pState.getValue(BlockStateProperties.UP)) {
			pState = pState.setValue(BlockStateProperties.UP, IcariaVineBaseBlock.isAcceptableNeighbour(pLevel, abovePos, Direction.DOWN));
		}

		BlockState blockState = null;
		for (Direction direction : Direction.Plane.HORIZONTAL) {
			var booleanProperty = IcariaVineBaseBlock.getPropertyForFace(direction);
			if (pState.getValue(booleanProperty)) {
				boolean flag = this.canSupportAtFace(pLevel, pPos, direction);
				if (!flag) {
					if (blockState == null) {
						blockState = pLevel.getBlockState(abovePos);
					}

					flag = (blockState.is(this)) && blockState.getValue(booleanProperty);
				}

				pState = pState.setValue(booleanProperty, flag);
			}
		}

		return pState;
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return switch (pMirror) {
			default -> super.mirror(pState, pMirror);
			case LEFT_RIGHT -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.NORTH));
			case FRONT_BACK -> pState.setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.EAST));
		};
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return switch (pRotation) {
			default -> pState;
			case CLOCKWISE_90 -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.SOUTH));
			case CLOCKWISE_180 -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.EAST));
			case COUNTERCLOCKWISE_90 -> pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.NORTH));
		};
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
		if (pDirection == Direction.DOWN) {
			return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
		} else {
			var blockState = this.getUpdatedState(pState, pLevel, pCurrentPos);
			return !this.hasFaces(blockState) ? Blocks.AIR.defaultBlockState() : blockState;
		}
	}

	public static BooleanProperty getPropertyForFace(Direction pDirection) {
		return IcariaVineBaseBlock.PROPERTY_BY_DIRECTION.get(pDirection);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (pLevel.getBlockState(pPos).equals(IcariaBlocks.RIPE_BLOOMY_VINE.get().defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)))) {
			Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.VINEBERRIES.get(), 1));
			pLevel.playSound(pPlayer, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			pLevel.setBlock(pPos, IcariaBlocks.BLOOMY_VINE.get().defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)), 2);
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		} else if (pLevel.getBlockState(pPos).equals(IcariaBlocks.RIPE_BRUSHY_VINE.get().defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)))) {
			Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.VINE_SPROUT.get(), 1));
			pLevel.playSound(pPlayer, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
			pLevel.setBlock(pPos, IcariaBlocks.BRUSHY_VINE.get().defaultBlockState().setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.UP, pState.getValue(BlockStateProperties.UP)), 2);
			return InteractionResult.sidedSuccess(pLevel.isClientSide);
		} else return InteractionResult.PASS;
	}

	public static VoxelShape calculateShape(BlockState pState) {
		var voxelShape = Shapes.empty();
		if (pState.getValue(BlockStateProperties.NORTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineBaseBlock.SHAPE_NORTH);
		} else if (pState.getValue(BlockStateProperties.EAST)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineBaseBlock.SHAPE_EAST);
		} else if (pState.getValue(BlockStateProperties.SOUTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineBaseBlock.SHAPE_SOUTH);
		} else if (pState.getValue(BlockStateProperties.WEST)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineBaseBlock.SHAPE_WEST);
		} else if (pState.getValue(BlockStateProperties.UP)) {
			voxelShape = IcariaVineBaseBlock.SHAPE_UP;
		}

		return voxelShape.isEmpty() ? Shapes.block() : voxelShape;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return this.map.get(pState);
	}
}
