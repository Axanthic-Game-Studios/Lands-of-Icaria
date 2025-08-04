package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.VerticalCorner;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.TripleBarrelRackShapes;
import com.axanthic.icaria.data.registry.IcariaLootTables;

import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TripleBarrelRackBlock extends Block {
	public TripleBarrelRackBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_LEFT));
	}

	@Override
	public boolean isPathfindable(BlockState pBlockState, PathComputationType pPathComputationType) {
		return false;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.VERTICAL_CORNER);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(TripleBarrelRackBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlock(pBlockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above(), Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.above().offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState(), 3);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pLevel.setBlock(pBlockPos.offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.BOTTOM_RIGHT), 3);
		pLevel.setBlock(pBlockPos.above(), pBlockState.setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_LEFT), 3);
		pLevel.setBlock(pBlockPos.above().offset(direction.getCounterClockWise().getUnitVec3i()), pBlockState.setValue(IcariaBlockStateProperties.VERTICAL_CORNER, VerticalCorner.TOP_RIGHT), 3);
	}

	public static BlockPos getPlacedBlockPosition(BlockPos pBlockPos, BlockState pBlockState) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (pBlockState.getValue(IcariaBlockStateProperties.VERTICAL_CORNER) == VerticalCorner.TOP_RIGHT) {
			return pBlockPos.below().offset(direction.getClockWise().getUnitVec3i());
		} else if (pBlockState.getValue(IcariaBlockStateProperties.VERTICAL_CORNER) == VerticalCorner.TOP_LEFT) {
			return pBlockPos.below();
		} else if (pBlockState.getValue(IcariaBlockStateProperties.VERTICAL_CORNER) == VerticalCorner.BOTTOM_RIGHT) {
			return pBlockPos.offset(direction.getClockWise().getUnitVec3i());
		} else {
			return pBlockPos;
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var direction = pBlockPlaceContext.getHorizontalDirection().getOpposite();
		var level = pBlockPlaceContext.getLevel();
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos.offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.above()).canBeReplaced(pBlockPlaceContext) && level.getBlockState(blockPos.above().offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced(pBlockPlaceContext)) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		var blockState = pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
		return pMirror == Mirror.NONE ? blockState : blockState.setValue(IcariaBlockStateProperties.VERTICAL_CORNER, blockState.getValue(IcariaBlockStateProperties.VERTICAL_CORNER).getOpposite());
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.drop(pBlockPos, pBlockState, pLevel);
		this.removeMultiBlock(TripleBarrelRackBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState pBlockState, LootParams.Builder pBuilder) {
		var lootParams = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pBlockState).create(LootContextParamSets.BLOCK);
		return lootParams.getLevel().getServer().reloadableRegistries().getLootTable(IcariaLootTables.BARREL).getRandomItems(lootParams);
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.VERTICAL_CORNER)) {
			case BOTTOM_LEFT -> this.getNorth(pBlockState);
			case BOTTOM_RIGHT -> this.getEast(pBlockState);
			case TOP_LEFT -> this.getSouth(pBlockState);
			case TOP_RIGHT -> this.getWest(pBlockState);
		};
	}

	public VoxelShape getNorth(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackShapes.BOTTOM_LEFT_NORTH;
			case EAST -> TripleBarrelRackShapes.BOTTOM_LEFT_EAST;
			case SOUTH -> TripleBarrelRackShapes.BOTTOM_LEFT_SOUTH;
			default -> TripleBarrelRackShapes.BOTTOM_LEFT_WEST;
		};
	}

	public VoxelShape getEast(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackShapes.BOTTOM_RIGHT_NORTH;
			case EAST -> TripleBarrelRackShapes.BOTTOM_RIGHT_EAST;
			case SOUTH -> TripleBarrelRackShapes.BOTTOM_RIGHT_SOUTH;
			default -> TripleBarrelRackShapes.BOTTOM_RIGHT_WEST;
		};
	}

	public VoxelShape getSouth(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackShapes.TOP_LEFT_NORTH;
			case EAST -> TripleBarrelRackShapes.TOP_LEFT_EAST;
			case SOUTH -> TripleBarrelRackShapes.TOP_LEFT_SOUTH;
			default -> TripleBarrelRackShapes.TOP_LEFT_WEST;
		};
	}

	public VoxelShape getWest(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackShapes.TOP_RIGHT_NORTH;
			case EAST -> TripleBarrelRackShapes.TOP_RIGHT_EAST;
			case SOUTH -> TripleBarrelRackShapes.TOP_RIGHT_SOUTH;
			default -> TripleBarrelRackShapes.TOP_RIGHT_WEST;
		};
	}
}
