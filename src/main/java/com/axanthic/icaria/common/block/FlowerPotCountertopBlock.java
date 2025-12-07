package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.FlowerPotCountertopBlockEntity;
import com.axanthic.icaria.common.properties.Fill;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaDataMapTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FlowerPotCountertopBlock extends CountertopBlock implements EntityBlock {
	public FlowerPotCountertopBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(IcariaBlockStateProperties.FILL, Fill.NONE).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pBlockState) {
		return true;
	}

	@Override
	public boolean onDestroyedByPlayer(BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, boolean pWillHarvest, FluidState pFluidState) {
		this.dropItem(pBlockPos, pLevel);
		return super.onDestroyedByPlayer(pBlockState, pLevel, pBlockPos, pPlayer, pWillHarvest, pFluidState);
	}

	@Override
	public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pBlockPos) {
		return pBlockState.getValue(IcariaBlockStateProperties.FILL) == Fill.NONE ? 0 : 15;
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.FILL, BlockStateProperties.HORIZONTAL_FACING, IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	public void dropItem(BlockPos pBlockPos, Level pLevel) {
		if (pLevel.getBlockEntity(pBlockPos) instanceof FlowerPotCountertopBlockEntity blockEntity && blockEntity.getItem() != null) {
			Block.popResource(pLevel, pBlockPos, new ItemStack(blockEntity.getItem()));
		}
	}

	@Override
	public void onBlockExploded(BlockState pBlockState, ServerLevel pServerLevel, BlockPos pBlockPos, Explosion pExplosion) {
		this.dropItem(pBlockPos, pServerLevel);
		super.onBlockExploded(pBlockState, pServerLevel, pBlockPos, pExplosion);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pBlockPos, BlockState pBlockState) {
		return new FlowerPotCountertopBlockEntity(pBlockPos, pBlockState);
	}

	@Override
	public InteractionResult useItemOn(ItemStack pItemStack, BlockState pBlockState, Level pLevel, BlockPos pBlockPos, Player pPlayer, InteractionHand pInteractionHand, BlockHitResult pBlockHitResult) {
		var item = pItemStack.getItem();
		var data = item.builtInRegistryHolder().getData(IcariaDataMapTypes.POTTABLES);
		if (pLevel.getBlockEntity(pBlockPos) instanceof FlowerPotCountertopBlockEntity blockEntity && blockEntity.getItem() == null && data != null) {
			blockEntity.setItem(item);
			pItemStack.consume(1, pPlayer);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.FILL, Fill.FILL));
			return InteractionResult.SUCCESS;
		} else if (pLevel.getBlockEntity(pBlockPos) instanceof FlowerPotCountertopBlockEntity blockEntity && blockEntity.getItem() != null && data == null) {
			this.dropItem(pBlockPos, pLevel);
			blockEntity.setItem(null);
			pLevel.setBlockAndUpdate(pBlockPos, pBlockState.setValue(IcariaBlockStateProperties.FILL, Fill.NONE));
			return InteractionResult.SUCCESS;
		} else {
			return InteractionResult.TRY_WITH_EMPTY_HAND;
		}
	}
}
