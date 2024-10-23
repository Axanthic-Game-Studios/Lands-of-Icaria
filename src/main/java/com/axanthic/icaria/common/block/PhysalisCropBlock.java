package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.shapes.DirectionShapes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PhysalisCropBlock extends CropBlock {
	public PhysalisCropBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader pLevel, BlockPos pPos, BlockState pState) {
		return new ItemStack(IcariaItems.PHYSALIS_SEEDS.get());
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return DirectionShapes.UP;
	}
}
