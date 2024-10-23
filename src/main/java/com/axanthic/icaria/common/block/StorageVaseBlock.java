package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.StorageVaseBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaFluids;
import com.axanthic.icaria.common.shapes.StorageVaseShapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseBlock extends Block implements EntityBlock, MediterraneanWaterloggedBlock, SimpleWaterloggedBlock {
	public StorageVaseBlock(Properties pProperties) {
		super(pProperties);
		this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, false).setValue(BlockStateProperties.WATERLOGGED, false));
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState pState) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
		return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(pLevel.getBlockEntity(pPos));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, BlockStateProperties.WATERLOGGED);
	}

	@Override
	public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
		if (pState.getBlock() != pNewState.getBlock()) {
			if (pLevel.getBlockEntity(pPos) instanceof StorageVaseBlockEntity blockEntity) {
				Containers.dropContents(pLevel, pPos, blockEntity);
				pLevel.updateNeighbourForOutputSignal(pPos, this);
			}
		}

		super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
		return new StorageVaseBlockEntity(pPos, pState);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		var fluid = pContext.getLevel().getFluidState(pContext.getClickedPos()).getType();
		return super.getStateForPlacement(pContext).setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, fluid == IcariaFluids.MEDITERRANEAN_WATER.get()).setValue(BlockStateProperties.WATERLOGGED, fluid == Fluids.WATER);
	}

	@Override
	public FluidState getFluidState(BlockState pState) {
		return pState.getValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED) ? IcariaFluids.MEDITERRANEAN_WATER.get().getSource(false) : pState.getValue(BlockStateProperties.WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pResult) {
		if (!pLevel.isClientSide()) {
			if (pLevel.getBlockEntity(pPos) instanceof StorageVaseBlockEntity storageVaseBlockEntity) {
				pPlayer.openMenu(storageVaseBlockEntity);
			}
		}

		return InteractionResult.SUCCESS;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return StorageVaseShapes.STORAGE_VASE;
	}
}
