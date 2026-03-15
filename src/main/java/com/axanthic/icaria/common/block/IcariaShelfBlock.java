package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaShelfBlockEntity;
import com.axanthic.icaria.common.helper.IcariaCommonHelper;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.ShelfVoxelShapes;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaShelfBlock extends Block implements EntityBlock, MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public IcariaShelfBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(IcariaBlockStateProperties.MULTI_SHELF, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		return this.hasShelfBelow(pBlockPos, pLevelReader) || IcariaCommonHelper.hasSolidBlockBelow(pBlockPos, pLevelReader);
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	public boolean hasShelfBelow(BlockPos pBlockPos, LevelReader pLevelReader) {
		var block = pLevelReader.getBlockState(pBlockPos.below()).getBlock();
		return block instanceof IcariaShelfBlock && !(block instanceof IcariaWallShelfBlock);
	}

	public boolean isBottomRow(BlockHitResult pBlockHitResult) {
		return pBlockHitResult.getLocation().y - pBlockHitResult.getBlockPos().getY() < 0.5D;
	}

	public boolean isTopRow(BlockHitResult pBlockHitResult) {
		return pBlockHitResult.getLocation().y - pBlockHitResult.getBlockPos().getY() > 0.5D;
	}

	public boolean isLeftColumn(BlockHitResult pBlockHitResult, BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> pBlockHitResult.getLocation().x - pBlockHitResult.getBlockPos().getX() > 0.5D;
			case EAST -> pBlockHitResult.getLocation().z - pBlockHitResult.getBlockPos().getZ() > 0.5D;
			case SOUTH -> pBlockHitResult.getLocation().x - pBlockHitResult.getBlockPos().getX() < 0.5D;
			case WEST -> pBlockHitResult.getLocation().z - pBlockHitResult.getBlockPos().getZ() < 0.5D;
			default -> false;
		};
	}

	public boolean isRightColumn(BlockHitResult pBlockHitResult, BlockState pBlockState) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> pBlockHitResult.getLocation().x - pBlockHitResult.getBlockPos().getX() < 0.5D;
			case EAST -> pBlockHitResult.getLocation().z - pBlockHitResult.getBlockPos().getZ() < 0.5D;
			case SOUTH -> pBlockHitResult.getLocation().x - pBlockHitResult.getBlockPos().getX() > 0.5D;
			case WEST -> pBlockHitResult.getLocation().z - pBlockHitResult.getBlockPos().getZ() > 0.5D;
			default -> false;
		};
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pLevel.getBlockEntity(pBlockPos) instanceof IcariaShelfBlockEntity blockEntity ? blockEntity.getAnalogOutputSignal() : 0;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, IcariaBlockStateProperties.MULTI_SHELF, BlockStateProperties.WATERLOGGED);
	}

	public void update(BlockPos pBlockPos, Level pLevel, Player pPlayer, SoundEvent pSoundEvent) {
		pLevel.blockEntityChanged(pBlockPos);
		pLevel.playSound(pPlayer, pBlockPos, pSoundEvent, SoundSource.BLOCKS, 1.0F, 1.0F);
		pLevel.updateNeighbourForOutputSignal(pBlockPos, this);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new IcariaShelfBlockEntity(pBlockPos, pBlockState);
	}

	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		var fluid = pBlockPlaceContext.getLevel().getFluidState(pBlockPlaceContext.getClickedPos()).getType();
		return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pBlockPlaceContext.getHorizontalDirection().getOpposite()).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
	}

	@Override
	public BlockState updateShape(BlockState pBlockState, LevelReader pLevelReader, ScheduledTickAccess pScheduledTickAccess, BlockPos pBlockPos, Direction pDirection, BlockPos pBlockPosFaced, BlockState pBlockStateFaced, RandomSource pRandomSource) {
		return pBlockState.canSurvive(pLevelReader, pBlockPos) ? pBlockState : Blocks.AIR.defaultBlockState();
	}

	@Override
	public FluidState getFluidState(BlockState pBlockState) {
		return pBlockState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pBlockState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		if (pLevel.getBlockEntity(pBlockPos) instanceof IcariaShelfBlockEntity blockEntity) {
			return this.useItemOn(blockEntity, pBlockHitResult, pBlockPos, pBlockState, pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING), pItemStack, pLevel, pPlayer);
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	public InteractionResult useItemOn(IcariaShelfBlockEntity pBlockEntity, BlockHitResult pBlockHitResult, BlockPos pBlockPos, BlockState pBlockState, Direction pDirection, ItemStack pItemStack, Level pLevel, Player pPlayer) {
		if (pBlockEntity.getBottomLeftItem() == null && this.isBottomRow(pBlockHitResult) && this.isLeftColumn(pBlockHitResult, pBlockState) && !pItemStack.isEmpty()) {
			pBlockEntity.setBottomLeftAngle(pLevel.getRandom().nextDouble());
			pBlockEntity.setBottomLeftItem(pItemStack.getItem());
			pItemStack.consume(1, pPlayer);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_ADD_ITEM);
			return InteractionResult.SUCCESS;
		} else if (pBlockEntity.getBottomRightItem() == null && this.isBottomRow(pBlockHitResult) && this.isRightColumn(pBlockHitResult, pBlockState) && !pItemStack.isEmpty()) {
			pBlockEntity.setBottomRightAngle(pLevel.getRandom().nextDouble());
			pBlockEntity.setBottomRightItem(pItemStack.getItem());
			pItemStack.consume(1, pPlayer);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_ADD_ITEM);
			return InteractionResult.SUCCESS;
		} else if (pBlockEntity.getTopLeftItem() == null && this.isTopRow(pBlockHitResult) && this.isLeftColumn(pBlockHitResult, pBlockState) && !pItemStack.isEmpty()) {
			pBlockEntity.setTopLeftAngle(pLevel.getRandom().nextDouble());
			pBlockEntity.setTopLeftItem(pItemStack.getItem());
			pItemStack.consume(1, pPlayer);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_ADD_ITEM);
			return InteractionResult.SUCCESS;
		} else if (pBlockEntity.getTopRightItem() == null && this.isTopRow(pBlockHitResult) && this.isRightColumn(pBlockHitResult, pBlockState) && !pItemStack.isEmpty()) {
			pBlockEntity.setTopRightAngle(pLevel.getRandom().nextDouble());
			pBlockEntity.setTopRightItem(pItemStack.getItem());
			pItemStack.consume(1, pPlayer);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_ADD_ITEM);
			return InteractionResult.SUCCESS;
		} else if (pBlockEntity.getBottomLeftItem() != null && this.isBottomRow(pBlockHitResult) && this.isLeftColumn(pBlockHitResult, pBlockState)) {
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, new ItemStack(pBlockEntity.getBottomLeftItem()));
			pBlockEntity.setBottomLeftAngle(0);
			pBlockEntity.setBottomLeftItem(null);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_REMOVE_ITEM);
			return InteractionResult.SUCCESS;
		} else if (pBlockEntity.getBottomRightItem() != null && this.isBottomRow(pBlockHitResult) && this.isRightColumn(pBlockHitResult, pBlockState)) {
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, new ItemStack(pBlockEntity.getBottomRightItem()));
			pBlockEntity.setBottomRightAngle(0);
			pBlockEntity.setBottomRightItem(null);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_REMOVE_ITEM);
			return InteractionResult.SUCCESS;
		} else if (pBlockEntity.getTopLeftItem() != null && this.isTopRow(pBlockHitResult) && this.isLeftColumn(pBlockHitResult, pBlockState)) {
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, new ItemStack(pBlockEntity.getTopLeftItem()));
			pBlockEntity.setTopLeftAngle(0);
			pBlockEntity.setTopLeftItem(null);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_REMOVE_ITEM);
			return InteractionResult.SUCCESS;
		} else if (pBlockEntity.getTopRightItem() != null && this.isTopRow(pBlockHitResult) && this.isRightColumn(pBlockHitResult, pBlockState)) {
			Block.popResourceFromFace(pLevel, pBlockPos, pDirection, new ItemStack(pBlockEntity.getTopRightItem()));
			pBlockEntity.setTopRightAngle(0);
			pBlockEntity.setTopRightItem(null);
			this.update(pBlockPos, pLevel, pPlayer, SoundEvents.ITEM_FRAME_REMOVE_ITEM);
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return switch (pBlockState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
			case NORTH -> ShelfVoxelShapes.NORTH;
			case EAST -> ShelfVoxelShapes.EAST;
			case SOUTH -> ShelfVoxelShapes.SOUTH;
			default -> ShelfVoxelShapes.WEST;
		};
	}
}
