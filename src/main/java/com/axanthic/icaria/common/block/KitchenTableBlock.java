package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.properties.Part;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.shapes.KitchenTableVoxelShapes;

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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KitchenTableBlock extends Block {
	public KitchenTableBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.PART);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(KitchenTableBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlock(pBlockPos, Blocks.AIR.defaultBlockState(), 3);
		pLevel.setBlock(pBlockPos.relative(pDirection.getOpposite()), Blocks.AIR.defaultBlockState(), 3);
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlock(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.PART, Part.FOOT), 3);
		pLevel.setBlock(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()), pBlockState.setValue(IcariaBlockStateProperties.PART, Part.HEAD), 3);
	}

	public static BlockPos getPlacedBlockPosition(BlockPos pBlockPos, BlockState pBlockState) {
		var direction = pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		if (pBlockState.getValue(IcariaBlockStateProperties.PART) == Part.HEAD) {
			return pBlockPos.relative(direction);
		} else {
			return pBlockPos;
		}
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var blockPos = pBlockPlaceContext.getClickedPos();
		var level = pBlockPlaceContext.getLevel();
		if (level.getBlockState(blockPos.relative(pBlockPlaceContext.getHorizontalDirection())).canBeReplaced()) {
			return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite());
		} else {
			return null;
		}
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState playerWillDestroy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, Player pPlayer) {
		this.drop(pBlockPos, pBlockState, pLevel);
		this.removeMultiBlock(KitchenTableBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pLevel, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.PART)) {
			case HEAD -> this.getHead(pBlockState);
			case FOOT -> this.getFoot(pBlockState);
		};
	}

	public VoxelShape getHead(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KitchenTableVoxelShapes.HEAD_NORTH;
			case EAST -> KitchenTableVoxelShapes.HEAD_EAST;
			case SOUTH -> KitchenTableVoxelShapes.HEAD_SOUTH;
			default -> KitchenTableVoxelShapes.HEAD_WEST;
		};
	}

	public VoxelShape getFoot(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KitchenTableVoxelShapes.FOOT_NORTH;
			case EAST -> KitchenTableVoxelShapes.FOOT_EAST;
			case SOUTH -> KitchenTableVoxelShapes.FOOT_SOUTH;
			default -> KitchenTableVoxelShapes.FOOT_WEST;
		};
	}
}
