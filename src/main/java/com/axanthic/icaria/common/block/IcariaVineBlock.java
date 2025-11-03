package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Vine;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.shapes.IcariaVineVoxelShapes;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

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
import net.minecraft.world.entity.InsideBlockEffectApplier;
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

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaVineBlock extends Block {
	public Map<BlockState, VoxelShape> map;

	public static final Map<Direction, BooleanProperty> MAP = ImmutableMap.copyOf(
		Util.make(
			Maps.newEnumMap(Direction.class), enumMap -> {
				enumMap.put(Direction.NORTH, BlockStateProperties.NORTH);
				enumMap.put(Direction.EAST, BlockStateProperties.EAST);
				enumMap.put(Direction.SOUTH, BlockStateProperties.SOUTH);
				enumMap.put(Direction.WEST, BlockStateProperties.WEST);
			}
		)
	);

	public IcariaVineBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.NORTH, false).setValue(BlockStateProperties.EAST, false).setValue(BlockStateProperties.SOUTH, false).setValue(BlockStateProperties.WEST, false).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
		this.map = ImmutableMap.copyOf(this.stateDefinition.getPossibleStates().stream().collect(Collectors.toMap(Function.identity(), IcariaVineBlock::calculateShape)));
	}

	@Override
	public boolean canBeReplaced(BlockState pBlockState, BlockPlaceContext pBlockPlaceContext) {
		return pBlockState.is(this) ? this.facesCount(pBlockState) < IcariaVineBlock.MAP.size() : super.canBeReplaced(pBlockState, pBlockPlaceContext);
	}

	public boolean canSupportAtFace(BlockGetter pBlockGetter, BlockPos pBlockPos, Direction pDirection) {
		if (pDirection == Direction.DOWN) {
			return false;
		} else {
			if (IcariaVineBlock.isAcceptableNeighbour(pBlockGetter, pBlockPos.relative(pDirection), pDirection)) {
				return true;
			} else if (pDirection.getAxis() == Direction.Axis.Y) {
				return false;
			} else {
				var blockState = pBlockGetter.getBlockState(pBlockPos.above());
				var booleanProperty = IcariaVineBlock.MAP.get(pDirection);
				return blockState.is(this) && blockState.getValue(booleanProperty);
			}
		}
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var blockState = this.getUpdatedState(pLevelReader, pBlockPos, pBlockState);
		return this.hasFaces(blockState);
	}

	public boolean doGrowDown(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.NONE || pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.BLOOMING || pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.RIPE || pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.VINE;
	}

	public boolean hasFaces(BlockState pBlockState) {
		return this.facesCount(pBlockState) > 0;
	}

	public static boolean isAcceptableNeighbour(BlockGetter pBlockGetter, BlockPos pBlockPos, Direction pDirection) {
		return MultifaceBlock.canAttachTo(pBlockGetter, pDirection, pBlockPos, pBlockGetter.getBlockState(pBlockPos));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState pBlockState) {
		return true;
	}

	public int facesCount(BlockState pBlockState) {
		return IcariaVineBlock.MAP.values().stream().mapToInt(booleanProperty -> pBlockState.getValue(booleanProperty) ? 1 : 0).sum();
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.NORTH, BlockStateProperties.EAST, BlockStateProperties.SOUTH, BlockStateProperties.WEST, IcariaBlockStateProperties.VINE);
	}

	@Override
	public void entityInside(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Entity pEntity, InsideBlockEffectApplier pInsideBlockEffectApplier) {
		if (pBlockState.is(IcariaBlocks.THORNY_VINE.get())) {
			IcariaCommonHelper.hurt(pLevel.damageSources().cactus(), pEntity, 1.0F);
		}
	}

	@Override
	public void randomTick(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, RandomSource pRandomSource) {
		if (pServerLevel.getGameRules().getBoolean(GameRules.RULE_DO_VINES_SPREAD) && pServerLevel.isAreaLoaded(pBlockPos, 1) && pBlockPos.getY() > pServerLevel.getMinY() + 1) {
			this.growOrRipeVine(pBlockPos, pBlockState, pRandomSource, pServerLevel);
		}
	}

	public void deadOrGrow(BlockPos pBlockPos, BlockState pBlockState, RandomSource pRandomSource, ServerLevel pServerLevel, int pDistance) {
		if (pRandomSource.nextInt(8) == 0) {
			pServerLevel.setBlockAndUpdate(pBlockPos.below(pDistance), this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.DEAD));
		} else {
			pServerLevel.setBlockAndUpdate(pBlockPos.below(pDistance), this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.GROWING));
		}
	}

	public void noneOrVine(BlockPos pBlockPos, BlockState pBlockState, RandomSource pRandomSource, ServerLevel pServerLevel) {
		if (pRandomSource.nextInt(2) == 0) {
			pServerLevel.setBlockAndUpdate(pBlockPos.below(), this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
		} else {
			pServerLevel.setBlockAndUpdate(pBlockPos.below(), this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.VINE));
		}
	}

	public void growOrRipeVine(BlockPos pBlockPos, BlockState pBlockState, RandomSource pRandomSource, ServerLevel pServerLevel) {
		if (pRandomSource.nextInt(3) == 0) {
			this.growVineDown(pBlockPos, pBlockState, pRandomSource, pServerLevel);
		} else if (pRandomSource.nextInt(3) == 1) {
			this.growVineSide(pBlockPos, pBlockState, pRandomSource, pServerLevel);
		} else if (pRandomSource.nextInt(3) == 2) {
			this.ripeVine(pBlockPos, pBlockState, pServerLevel);
		}
	}

	public void growVineDown(BlockPos pBlockPos, BlockState pBlockState, RandomSource pRandomSource, ServerLevel pServerLevel) {
		if (this.doGrowDown(pBlockState) && pServerLevel.getBlockState(pBlockPos.below(1)).isAir()) {
			this.deadOrGrow(pBlockPos, pBlockState, pRandomSource, pServerLevel, 1);
		} else if (this.doGrowDown(pBlockState) && pServerLevel.getBlockState(pBlockPos.below(2)).isAir() && pServerLevel.getBlockState(pBlockPos.below()).hasProperty(IcariaBlockStateProperties.VINE) && pServerLevel.getBlockState(pBlockPos.below()).getValue(IcariaBlockStateProperties.VINE) == Vine.GROWING) {
			this.deadOrGrow(pBlockPos, pBlockState, pRandomSource, pServerLevel, 2);
			this.noneOrVine(pBlockPos, pBlockState, pRandomSource, pServerLevel);
		}
	}

	public void growVineSide(BlockPos pBlockPos, BlockState pBlockState, RandomSource pRandomSource, ServerLevel pServerLevel) {
		var direction = Direction.getRandom(pRandomSource);
		if (direction.getAxis().isHorizontal()) {
			if (!pBlockState.getValue(IcariaVineBlock.MAP.get(direction))) {
				if (IcariaVineBlock.isAcceptableNeighbour(pServerLevel, pBlockPos.relative(direction), direction)) {
					pServerLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaVineBlock.MAP.get(direction), true));
				}
			}
		}
	}

	public void ripeVine(BlockPos pBlockPos, BlockState pBlockState, ServerLevel pServerLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.BLOOMING && pBlockState.is(IcariaBlocks.BLOOMY_VINE.get())) {
			pServerLevel.setBlockAndUpdate(pBlockPos, this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.RIPE));
		} else if (pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.NONE && pBlockState.is(IcariaBlocks.BLOOMY_VINE.get())) {
			pServerLevel.setBlockAndUpdate(pBlockPos, this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.BLOOMING));
		} else if (pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.NONE && pBlockState.is(IcariaBlocks.BRUSHY_VINE.get())) {
			pServerLevel.setBlockAndUpdate(pBlockPos, this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.RIPE));
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		var blockState = level.getBlockState(blockPos);
		var check = blockState.is(this);
		var interState = level.getRandom().nextBoolean() ? this.defaultBlockState() : this.defaultBlockState().setValue(IcariaBlockStateProperties.VINE, Vine.VINE);
		var finalState = check ? blockState : interState;
		for (var direction : pBlockPlaceContext.getNearestLookingDirections()) {
			if (direction != Direction.UP && direction != Direction.DOWN) {
				var booleanProperty = IcariaVineBlock.MAP.get(direction);
				var finalCheck = check && blockState.getValue(booleanProperty);
				if (!finalCheck && this.canSupportAtFace(level, blockPos, direction)) {
					return finalState.setValue(booleanProperty, true);
				}
			}
		}

		return check ? finalState : null;
	}

	public BlockState getUpdatedState(BlockGetter pBlockGetter, BlockPos pBlockPos, BlockState pBlockState) {
		for (var direction : Direction.Plane.HORIZONTAL) {
			var booleanProperty = IcariaVineBlock.MAP.get(direction);
			if (pBlockState.getValue(booleanProperty)) {
				var flag = this.canSupportAtFace(pBlockGetter, pBlockPos, direction);
				if (!flag) {
					var blockState = pBlockGetter.getBlockState(pBlockPos.above());
					flag = blockState.is(this) && blockState.getValue(booleanProperty);
				}

				pBlockState = pBlockState.setValue(booleanProperty, flag);
			}
		}

		return pBlockState;
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return switch (pMirror) {
			case FRONT_BACK ->
				pBlockState.setValue(BlockStateProperties.EAST, pBlockState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pBlockState.getValue(BlockStateProperties.EAST));
			case LEFT_RIGHT ->
				pBlockState.setValue(BlockStateProperties.NORTH, pBlockState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pBlockState.getValue(BlockStateProperties.NORTH));
			default -> pBlockState;
		};
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return switch (pRotation) {
			case CLOCKWISE_90 ->
				pBlockState.setValue(BlockStateProperties.NORTH, pBlockState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.EAST, pBlockState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.SOUTH, pBlockState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.WEST, pBlockState.getValue(BlockStateProperties.SOUTH));
			case CLOCKWISE_180 ->
				pBlockState.setValue(BlockStateProperties.NORTH, pBlockState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.EAST, pBlockState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.SOUTH, pBlockState.getValue(BlockStateProperties.NORTH)).setValue(BlockStateProperties.WEST, pBlockState.getValue(BlockStateProperties.EAST));
			case COUNTERCLOCKWISE_90 ->
				pBlockState.setValue(BlockStateProperties.NORTH, pBlockState.getValue(BlockStateProperties.EAST)).setValue(BlockStateProperties.EAST, pBlockState.getValue(BlockStateProperties.SOUTH)).setValue(BlockStateProperties.SOUTH, pBlockState.getValue(BlockStateProperties.WEST)).setValue(BlockStateProperties.WEST, pBlockState.getValue(BlockStateProperties.NORTH));
			default -> pBlockState;
		};
	}

	public BlockState setPropForFace(BlockState pBlockState) {
		for (var direction : Direction.Plane.HORIZONTAL) {
			var booleanProperty = IcariaVineBlock.MAP.get(direction);
			pBlockState = pBlockState.setValue(booleanProperty, pBlockState.getValue(booleanProperty));
		}

		return pBlockState;
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		var interState = this.getUpdatedState(pLevelReader, pBlockPos, pBlockState);
		var finalState = this.hasFaces(interState) ? interState : Blocks.AIR.defaultBlockState();
		return pDirection != Direction.DOWN ? finalState : super.updateShape(pBlockState, pLevelReader, pScheduledTickAccess, pBlockPos, pDirection, pBlockPosFaced, pBlockStateFaced, pRandomSource);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, BlockHitResult pBlockHitResult) {
		if (pBlockState.is(IcariaBlocks.BLOOMY_VINE.get()) && pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.RIPE) {
			Block.popResource(pLevel, pBlockPos, new ItemStack(IcariaItems.VINEBERRIES.get()));
			pLevel.playSound(null, pBlockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
			return InteractionResult.SUCCESS;
		} else if (pBlockState.is(IcariaBlocks.BRUSHY_VINE.get()) && pBlockState.getValue(IcariaBlockStateProperties.VINE) == Vine.RIPE) {
			Block.popResource(pLevel, pBlockPos, new ItemStack(IcariaItems.VINE_SPROUT.get()));
			pLevel.playSound(null, pBlockPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS);
			pLevel.setBlockAndUpdate(pBlockPos, this.setPropForFace(pBlockState).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.PASS;
		}
	}

	@Nullable
	@Override
	public PathType getBlockPathType(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, @Nullable Mob pMob) {
		return pBlockState.is(IcariaBlocks.THORNY_VINE.get()) ? PathType.DAMAGE_OTHER : super.getBlockPathType(pBlockState, pBlockGetter, pBlockPos, pMob);
	}

	public static VoxelShape calculateShape(BlockState pBlockState) {
		var voxelShape = Shapes.empty();

		if (pBlockState.getValue(BlockStateProperties.NORTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineVoxelShapes.NORTH);
		}

		if (pBlockState.getValue(BlockStateProperties.EAST)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineVoxelShapes.EAST);
		}

		if (pBlockState.getValue(BlockStateProperties.SOUTH)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineVoxelShapes.SOUTH);
		}

		if (pBlockState.getValue(BlockStateProperties.WEST)) {
			voxelShape = Shapes.or(voxelShape, IcariaVineVoxelShapes.WEST);
		}

		return voxelShape;
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return this.map.get(pBlockState);
	}
}
