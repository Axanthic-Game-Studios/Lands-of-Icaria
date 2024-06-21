package com.axanthic.icaria.common.block;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.neoforged.neoforge.common.IPlantable;
import net.neoforged.neoforge.common.PlantType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FertilizedFarmlandBlock extends Block {
	public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

	public FertilizedFarmlandBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSustainPlant(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection, IPlantable pPlantable) {
		return pPlantable.getPlantType(pLevel, pPos.relative(pDirection)) == PlantType.CROP;
	}

	@Override
	public boolean useShapeForLightOcclusion(BlockState pState) {
		return true;
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return FertilizedFarmlandBlock.SHAPE;
	}
}
