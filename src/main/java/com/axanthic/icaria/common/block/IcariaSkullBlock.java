package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.shapes.DirectionShapes;
import com.axanthic.icaria.common.util.IcariaSkullBlockType;

import javax.annotation.ParametersAreNonnullByDefault;

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
	public BlockState getStateForPlacement(BlockPlaceContext pBlockPlaceContext) {
		return this.defaultBlockState().setValue(BlockStateProperties.ROTATION_16, Mth.floor((pBlockPlaceContext.getRotation() * 16.0F / 360.0F) + 0.5D) & 15);
	}

	@Override
	public BlockState mirror(BlockState pBlockState, Mirror pMirror) {
		return pBlockState.setValue(BlockStateProperties.ROTATION_16, pMirror.mirror(pBlockState.getValue(BlockStateProperties.ROTATION_16), 16));
	}

	@Override
	public BlockState rotate(BlockState pBlockState, Rotation pRotation) {
		return pBlockState.setValue(BlockStateProperties.ROTATION_16, pRotation.rotate(pBlockState.getValue(BlockStateProperties.ROTATION_16), 16));
	}

	@Override
	public VoxelShape getOcclusionShape(BlockState pBlockState) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return DirectionShapes.UP;
	}
}
