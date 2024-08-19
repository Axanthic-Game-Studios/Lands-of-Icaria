package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Vine;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaShapes;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaVineBlock extends Block {
	public Map<BlockState, VoxelShape> map;

	public static final Map<Direction, BooleanProperty> SET_PROP_FOR_FACE = ImmutableMap.copyOf(
		Util.make(
			Maps.newEnumMap(Direction.class), (map) -> {
				map.put(Direction.NORTH, BlockStateProperties.NORTH);
				map.put(Direction.EAST, BlockStateProperties.EAST);
				map.put(Direction.SOUTH, BlockStateProperties.SOUTH);
				map.put(Direction.WEST, BlockStateProperties.WEST);
			}
		)
	);

	public IcariaVineBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
		this.map = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), IcariaVineBlock::calculateShape)));
	}

	@Override
	public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
		var blockState = pUseContext.getLevel().getBlockState(pUseContext.getClickedPos());
		return blockState.is(this) ? this.countFaces(blockState) < IcariaVineBlock.SET_PROP_FOR_FACE.size() : super.canBeReplaced(pState, pUseContext);
	}

	public boolean canSupportAtFace(BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return false;
		} else {
			if (IcariaVineBlock.isAcceptableNeighbour(pLevel, pPos.relative(pDirection), pDirection)) {
				return true;
			} else if (pDirection.getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				var blockState = pLevel.getBlockState(pPos.above());
				var booleanProperty = IcariaVineBlock.SET_PROP_FOR_FACE.get(pDirection);
				return blockState.is(this) && blockState.getValue(booleanProperty);
			}
		}
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		var blockState = this.getUpdatedState(pState, pLevel, pPos);
		return this.hasFaces(blockState);
	}

	public boolean hasFaces(BlockState pState) {
		return this.countFaces(pState) > 0;
	}

	public static boolean isAcceptableNeighbour(BlockGetter pBlockReader, BlockPos pNeighborPos, Direction pAttachedFace) {
		return MultifaceBlock.canAttachTo(pBlockReader, pAttachedFace, pNeighborPos, pBlockReader.getBlockState(pNeighborPos));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return true;
	}

	public int countFaces(BlockState pState) {
		int i = 0;
		for (var booleanProperty : IcariaVineBlock.SET_PROP_FOR_FACE.values()) {
			if (pState.getValue(booleanProperty)) {
				++i;
			}
		}

		return i;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, IcariaBlockStateProperties.VINE);
	}

	@Override
	public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
		if (pState.is(IcariaBlocks.THORNY_VINE.get())) {
			pEntity.hurt(pLevel.damageSources().cactus(), 1.0F);
		}
	}

	@Override
	public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
		var direction = Direction.getRandom(pRandom);
		var blockPos = pPos.relative(direction);
		if (pLevel.getGameRules().getBoolean(GameRules.RULE_DO_VINES_SPREAD)) {
			if (pPos.getY() > pLevel.getMinBuildHeight() + 1) {
				if (pLevel.isAreaLoaded(pPos, 0)) {
					if (pRandom.nextInt(4) == 0) {
						if (pState.getValue(IcariaBlockStateProperties.VINE) == Vine.NONE || pState.getValue(IcariaBlockStateProperties.VINE) == Vine.BLOOMING || pState.getValue(IcariaBlockStateProperties.VINE) == Vine.RIPE || pState.getValue(IcariaBlockStateProperties.VINE) == Vine.VINE) {
							if (pLevel.getBlockState(pPos.below()).isAir()) {
								if (pRandom.nextInt(8) == 0) {
									pLevel.setBlockAndUpdate(pPos.below(1), this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.DEAD));
								} else {
									pLevel.setBlockAndUpdate(pPos.below(1), this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.GROWING));
								}
							} else if (pLevel.getBlockState(pPos.below(2)).isAir() && pLevel.getBlockState(pPos.below()).hasProperty(IcariaBlockStateProperties.VINE) && pLevel.getBlockState(pPos.below()).getValue(IcariaBlockStateProperties.VINE) == Vine.GROWING) {
								if (pRandom.nextInt(8) == 0) {
									pLevel.setBlockAndUpdate(pPos.below(2), this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.DEAD));
								} else {
									pLevel.setBlockAndUpdate(pPos.below(2), this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.GROWING));
								}

								if (pRandom.nextInt(2) == 0) {
									pLevel.setBlockAndUpdate(pPos.below(1), this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
								} else {
									pLevel.setBlockAndUpdate(pPos.below(1), this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.VINE));
								}
							}
						}
					} else {
						if (direction.getAxis().isHorizontal()) {
							if (!pState.getValue(IcariaVineBlock.getPropForFace(direction))) {
								if (IcariaVineBlock.isAcceptableNeighbour(pLevel, blockPos, direction)) {
									pLevel.setBlockAndUpdate(pPos, pState.setValue(IcariaVineBlock.getPropForFace(direction), true));
								}
							}
						}

						if (pState.getValue(IcariaBlockStateProperties.VINE) == Vine.NONE) {
							if (pState.is(IcariaBlocks.BLOOMY_VINE.get())) {
								if (pRandom.nextInt(2) == 0) {
									pLevel.setBlockAndUpdate(pPos, this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.BLOOMING));
								}
							} else if (pState.is(IcariaBlocks.BRUSHY_VINE.get())) {
								if (pRandom.nextInt(2) == 0) {
									pLevel.setBlockAndUpdate(pPos, this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.RIPE));
								}
							}
						} else if (pState.getValue(IcariaBlockStateProperties.VINE) == Vine.BLOOMING) {
							if (pState.is(IcariaBlocks.BLOOMY_VINE.get())) {
								if (pRandom.nextInt(2) == 0) {
									pLevel.setBlockAndUpdate(pPos, this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.RIPE));
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public PathType getBlockPathType(BlockState pState, BlockGetter pLevel, BlockPos pPos, @Nullable Mob pMob) {
		return pState.is(IcariaBlocks.THORNY_VINE.get()) ? PathType.DAMAGE_OTHER : super.getBlockPathType(pState, pLevel, pPos, pMob);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var state = pContext.getLevel().getBlockState(pContext.getClickedPos());
		var check = state.is(this);
		var interState = pContext.getLevel().getRandom().nextBoolean() ? this.defaultBlockState() : this.defaultBlockState().setValue(IcariaBlockStateProperties.VINE, Vine.VINE);
		var finalState = check ? state : interState;
		for (var direction : pContext.getNearestLookingDirections()) {
			if (direction != Direction.DOWN && direction != Direction.UP) {
				var booleanProperty = IcariaVineBlock.getPropForFace(direction);
				var finalCheck = check && state.getValue(booleanProperty);
				if (!finalCheck && this.canSupportAtFace(pContext.getLevel(), pContext.getClickedPos(), direction)) {
					return finalState.setValue(booleanProperty, true);
				}
			}
		}

		return check ? finalState : null;
	}

	public BlockState getUpdatedState(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		BlockState blockstate = null;
		for (var direction : Direction.Plane.HORIZONTAL) {
			var booleanProperty = IcariaVineBlock.getPropForFace(direction);
			if (pState.getValue(booleanProperty)) {
				var flag = this.canSupportAtFace(pLevel, pPos, direction);
				if (!flag) {
					if (blockstate == null) {
						blockstate = pLevel.getBlockState(pPos.above());
					}

					flag = blockstate.is(this) && blockstate.getValue(booleanProperty);
				}

				pState = pState.setValue(booleanProperty, flag);
			}
		}

		return pState;
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return switch (pMirror) {
			case LEFT_RIGHT ->
				pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.NORTH));
			case FRONT_BACK ->
				pState.setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.EAST));
			default -> super.mirror(pState, pMirror);
		};
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return switch (pRotation) {
			case CLOCKWISE_90 ->
				pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.SOUTH));
			case CLOCKWISE_180 ->
				pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.EAST));
			case COUNTERCLOCKWISE_90 ->
				pState.setValue(BlockStateProperties.NORTH, pState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.EAST, pState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pState.getValue(BlockStateProperties.NORTH));
			default -> pState;
		};
	}

	public BlockState setPropForFace(BlockState pState) {
		for (var direction : Direction.Plane.HORIZONTAL) {
			var property = IcariaVineBlock.getPropForFace(direction);
			pState = pState.setValue(property, pState.getValue(property));
		}

		return pState;
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
		var interState = this.getUpdatedState(pState, pLevel, pCurrentPos);
		var finalState = this.hasFaces(interState) ? interState : Blocks.AIR.defaultBlockState();
		return pFacing != Direction.DOWN ? finalState : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}

	public static BooleanProperty getPropForFace(Direction pDirection) {
		return IcariaVineBlock.SET_PROP_FOR_FACE.get(pDirection);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pResult) {
		if (pState.is(IcariaBlocks.BLOOMY_VINE.get()) && pState.getValue(IcariaBlockStateProperties.VINE) == Vine.RIPE) {
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pPos, this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
			Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.VINEBERRIES.get()));
			return InteractionResult.sidedSuccess(pLevel.isClientSide());
		} else if (pState.is(IcariaBlocks.BRUSHY_VINE.get()) && pState.getValue(IcariaBlockStateProperties.VINE) == Vine.RIPE) {
			pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pPos, this.setPropForFace(pState).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
			Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.VINE_SPROUT.get()));
			return InteractionResult.sidedSuccess(pLevel.isClientSide());
		} else {
			return InteractionResult.PASS;
		}
	}

	public static VoxelShape calculateShape(BlockState pState) {
		var voxelShape = Shapes.empty();

		if (pState.getValue(BlockStateProperties.NORTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaShapes.IcariaVineShapes.NORTH);
		}

		if (pState.getValue(BlockStateProperties.EAST)) {
			voxelShape = Shapes.or(voxelShape, IcariaShapes.IcariaVineShapes.EAST);
		}

		if (pState.getValue(BlockStateProperties.SOUTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaShapes.IcariaVineShapes.SOUTH);
		}

		if (pState.getValue(BlockStateProperties.WEST)) {
			voxelShape = Shapes.or(voxelShape, IcariaShapes.IcariaVineShapes.WEST);
		}

		return voxelShape.isEmpty() ? Shapes.block() : voxelShape;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return this.map.get(pState);
	}
}
