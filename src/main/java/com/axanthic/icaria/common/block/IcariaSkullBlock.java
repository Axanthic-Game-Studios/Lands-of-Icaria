package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaShapes;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSkullBlock extends IcariaAbstractSkullBlock {
	public IcariaSkullBlock(float pOffset, IcariaSkullBlockType pType, Properties pProperties) {
		super(pOffset, pType, pProperties);
		this.registerDefaultState(this.getStateDefinition().any().setValue(BlockStateProperties.ROTATION_16, 0));
	}

	@Override
	public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(BlockStateProperties.ROTATION_16);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext pContext) {
		return this.defaultBlockState().setValue(BlockStateProperties.ROTATION_16, Mth.floor((pContext.getRotation() * 16.0F / 360.0F) + 0.5D) & 15);
	}

	@Override
	public BlockState mirror(BlockState pState, Mirror pMirror) {
		return pState.setValue(BlockStateProperties.ROTATION_16, pMirror.mirror(pState.getValue(BlockStateProperties.ROTATION_16), 16));
	}

	@Override
	public BlockState rotate(BlockState pState, Rotation pRotation) {
		return pState.setValue(BlockStateProperties.ROTATION_16, pRotation.rotate(pState.getValue(BlockStateProperties.ROTATION_16), 16));
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return IcariaShapes.UP;
	}
}
