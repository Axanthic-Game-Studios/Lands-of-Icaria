package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.enums.HeightPair;
import com.axanthic.icaria.common.enums.WidthPair;
import com.axanthic.icaria.common.helper.IcariaMultiBlockHelper;
import com.axanthic.icaria.common.ids.IcariaLootTableIds;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.TripleBarrelRackVoxelShapes;

import java.util.List;

import javax.annotation.Nullable;

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
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.HEIGHT_PAIR, HeightPair.BOTTOM).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.WIDTH_PAIR, WidthPair.LEFT));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.HEIGHT_PAIR, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.WIDTH_PAIR);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(TripleBarrelRackBlock.getMultiBlockPos(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlockAndUpdate(pBlockPos, Blocks.AIR.defaultBlockState());
		pLevel.setBlockAndUpdate(pBlockPos.offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState());
		pLevel.setBlockAndUpdate(pBlockPos.above(), Blocks.AIR.defaultBlockState());
		pLevel.setBlockAndUpdate(pBlockPos.above().offset(pDirection.getCounterClockWise().getUnitVec3i()), Blocks.AIR.defaultBlockState());
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		pLevel.setBlockAndUpdate(pBlockPos, IcariaMultiBlockHelper.setValue(pBlockState, HeightPair.BOTTOM, WidthPair.LEFT));
		pLevel.setBlockAndUpdate(pBlockPos.offset(direction.getCounterClockWise().getUnitVec3i()), IcariaMultiBlockHelper.setValue(pBlockState, HeightPair.BOTTOM, WidthPair.RIGHT));
		pLevel.setBlockAndUpdate(pBlockPos.above(), IcariaMultiBlockHelper.setValue(pBlockState, HeightPair.TOP, WidthPair.LEFT));
		pLevel.setBlockAndUpdate(pBlockPos.above().offset(direction.getCounterClockWise().getUnitVec3i()), IcariaMultiBlockHelper.setValue(pBlockState, HeightPair.TOP, WidthPair.RIGHT));
	}

	public static BlockPos getMultiBlockPos(BlockPos pBlockPos, BlockState pBlockState) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (IcariaMultiBlockHelper.hasValue(pBlockState, HeightPair.BOTTOM, WidthPair.LEFT)) {
			return pBlockPos;
		} else if (IcariaMultiBlockHelper.hasValue(pBlockState, HeightPair.BOTTOM, WidthPair.RIGHT)) {
			return pBlockPos.offset(direction.getClockWise().getUnitVec3i());
		} else if (IcariaMultiBlockHelper.hasValue(pBlockState, HeightPair.TOP, WidthPair.LEFT)) {
			return pBlockPos.below();
		} else {
			return pBlockPos.below().offset(direction.getClockWise().getUnitVec3i());
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var direction = pBlockPlaceContext.getHorizontalDirection().getOpposite();
		var level = pBlockPlaceContext.getLevel();
		if (blockPos.getY() < level.getMaxY() && level.getBlockState(blockPos).canBeReplaced() && level.getBlockState(blockPos.offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced() && level.getBlockState(blockPos.above()).canBeReplaced() && level.getBlockState(blockPos.above().offset(direction.getCounterClockWise().getUnitVec3i())).canBeReplaced()) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		var blockState = pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
		return pMirror == Mirror.NONE ? blockState : blockState.setValue(IcariaBlockStateProperties.WIDTH_PAIR, blockState.getValue(IcariaBlockStateProperties.WIDTH_PAIR).getOpposite());
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.drop(pBlockPos, pBlockState, pLevel);
		this.removeMultiBlock(TripleBarrelRackBlock.getMultiBlockPos(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public List<ItemStack> getDrops(BlockState pBlockState, LootParams.Builder pBuilder) {
		var lootParams = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pBlockState).create(LootContextParamSets.BLOCK);
		return lootParams.getLevel().getServer().reloadableRegistries().getLootTable(IcariaLootTableIds.BARREL).getRandomItems(lootParams);
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		if (IcariaMultiBlockHelper.hasValue(pBlockState, HeightPair.BOTTOM, WidthPair.LEFT)) {
			return this.getBottomLeft(pBlockState);
		} else if (IcariaMultiBlockHelper.hasValue(pBlockState, HeightPair.BOTTOM, WidthPair.RIGHT)) {
			return this.getBottomRight(pBlockState);
		} else if (IcariaMultiBlockHelper.hasValue(pBlockState, HeightPair.TOP, WidthPair.LEFT)) {
			return this.getTopLeft(pBlockState);
		} else {
			return this.getTopRight(pBlockState);
		}
	}

	public VoxelShape getBottomLeft(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackVoxelShapes.BOTTOM_LEFT_NORTH;
			case EAST -> TripleBarrelRackVoxelShapes.BOTTOM_LEFT_EAST;
			case SOUTH -> TripleBarrelRackVoxelShapes.BOTTOM_LEFT_SOUTH;
			default -> TripleBarrelRackVoxelShapes.BOTTOM_LEFT_WEST;
		};
	}

	public VoxelShape getBottomRight(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackVoxelShapes.BOTTOM_RIGHT_NORTH;
			case EAST -> TripleBarrelRackVoxelShapes.BOTTOM_RIGHT_EAST;
			case SOUTH -> TripleBarrelRackVoxelShapes.BOTTOM_RIGHT_SOUTH;
			default -> TripleBarrelRackVoxelShapes.BOTTOM_RIGHT_WEST;
		};
	}

	public VoxelShape getTopLeft(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackVoxelShapes.TOP_LEFT_NORTH;
			case EAST -> TripleBarrelRackVoxelShapes.TOP_LEFT_EAST;
			case SOUTH -> TripleBarrelRackVoxelShapes.TOP_LEFT_SOUTH;
			default -> TripleBarrelRackVoxelShapes.TOP_LEFT_WEST;
		};
	}

	public VoxelShape getTopRight(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> TripleBarrelRackVoxelShapes.TOP_RIGHT_NORTH;
			case EAST -> TripleBarrelRackVoxelShapes.TOP_RIGHT_EAST;
			case SOUTH -> TripleBarrelRackVoxelShapes.TOP_RIGHT_SOUTH;
			default -> TripleBarrelRackVoxelShapes.TOP_RIGHT_WEST;
		};
	}
}
