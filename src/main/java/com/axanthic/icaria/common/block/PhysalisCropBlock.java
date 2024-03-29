package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PhysalisCropBlock extends CropBlock {
	public static final VoxelShape[] SHAPES = new VoxelShape[] {
		Block.box(4.0D, 0.0D, 4.0D, 12.0D, 2.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 14.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)
	};

	public PhysalisCropBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public BlockState getPlant(BlockGetter pLevel, BlockPos pPos) {
		return pLevel.getBlockState(pPos);
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
		return new ItemStack(IcariaItems.PHYSALIS_SEEDS.get());
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return PhysalisCropBlock.SHAPES[pState.getValue(this.getAgeProperty())];
	}
}
