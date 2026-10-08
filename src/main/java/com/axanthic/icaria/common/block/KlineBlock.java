package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.properties.Mat;
import com.axanthic.icaria.common.properties.Part;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;
import com.axanthic.icaria.common.shapes.KlineVoxelShapes;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KlineBlock extends Block {
	public KlineBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MAT, Mat.TERRY_MAT).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
	}

	@Override
	public boolean canDropFromExplosion(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, Explosion pExplosion) {
		return false;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MAT, IcariaBlockStateProperties.PART);
	}

	public void drop(BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		Block.dropResources(pBlockState, pLevel, pBlockPos);
	}

	public void dropMat(BlockState pBlockState, BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.MAT) != Mat.TERRY_MAT) {
			var itemStack = new ItemStack(IcariaCommonHelper.getItemFromMat(pBlockState.getValue(IcariaBlockStateProperties.MAT)));
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, itemStack);
		}
	}

	@Override
	public void fallOn(Level pLevel, BlockState pBlockState, BlockPos pBlockPos, Entity pEntity, double pFallDistance) {
		pEntity.causeFallDamage(pFallDistance, 0.5F, pLevel.damageSources().fall());
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.drop(pBlockPos, pBlockState, pServerLevel);
		this.removeMultiBlock(KlineBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	public void removeMultiBlock(BlockPos pBlockPos, Direction pDirection, Level pLevel) {
		pLevel.setBlockAndUpdate(pBlockPos, Blocks.AIR.defaultBlockState());
		pLevel.setBlockAndUpdate(pBlockPos.relative(pDirection.getOpposite()), Blocks.AIR.defaultBlockState());
	}

	@Override
	public void setPlacedBy(Level pLevel, BlockPos pBlockPos, BlockState pBlockState, @Nullable LivingEntity pLivingEntity, ItemStack pItemStack) {
		pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.PART, Part.FOOT));
		pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()), pBlockState.setValue(IcariaBlockStateProperties.PART, Part.HEAD));
	}

	public void update(Mat pMat, BlockPos pBlockPos, BlockState pBlockState, Level pLevel) {
		if (pBlockState.getValue(IcariaBlockStateProperties.PART) == Part.HEAD) {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.MAT, pMat).setValue(IcariaBlockStateProperties.PART, Part.HEAD));
			pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)), pBlockState.setValue(IcariaBlockStateProperties.MAT, pMat).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
		} else {
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.MAT, pMat).setValue(IcariaBlockStateProperties.PART, Part.FOOT));
			pLevel.setBlockAndUpdate(pBlockPos.relative(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING).getOpposite()), pBlockState.setValue(IcariaBlockStateProperties.MAT, pMat).setValue(IcariaBlockStateProperties.PART, Part.HEAD));
		}
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
		this.removeMultiBlock(KlineBlock.getPlacedBlockPosition(pBlockPos, pBlockState), pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pLevel);
		return super.playerWillDestroy(pLevel, pBlockPos, pBlockState, pPlayer);
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pItemStack.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof MatBlock matBlock && matBlock.getMat() != pBlockState.getValue(IcariaBlockStateProperties.MAT)) {
			this.dropMat(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.MAT_APPLY, SoundSource.BLOCKS);
			this.update(matBlock.getMat(), pBlockPos, pBlockState, pLevel);
			return InteractionResult.SUCCESS;
		} else if (pItemStack.getItem() == Items.SHEARS && pBlockState.getValue(IcariaBlockStateProperties.MAT) != Mat.TERRY_MAT) {
			this.dropMat(pBlockState, pBlockPos, pBlockHitResult.getDirection(), pLevel);
			pLevel.playSound(pPlayer, pBlockPos, IcariaSoundEvents.MAT_CLEAR, SoundSource.BLOCKS);
			this.update(Mat.TERRY_MAT, pBlockPos, pBlockState, pLevel);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(IcariaBlockStateProperties.PART)) {
			case HEAD -> this.getHead(pBlockState);
			case FOOT -> this.getFoot(pBlockState);
		};
	}

	public VoxelShape getHead(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KlineVoxelShapes.HEAD_NORTH;
			case EAST -> KlineVoxelShapes.HEAD_EAST;
			case SOUTH -> KlineVoxelShapes.HEAD_SOUTH;
			default -> KlineVoxelShapes.HEAD_WEST;
		};
	}

	public VoxelShape getFoot(BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> KlineVoxelShapes.FOOT_NORTH;
			case EAST -> KlineVoxelShapes.FOOT_EAST;
			case SOUTH -> KlineVoxelShapes.FOOT_SOUTH;
			default -> KlineVoxelShapes.FOOT_WEST;
		};
	}
}
