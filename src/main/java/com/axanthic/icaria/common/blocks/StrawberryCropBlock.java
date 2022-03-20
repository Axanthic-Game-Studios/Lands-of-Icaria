package com.axanthic.icaria.common.blocks;

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

public class StrawberryCropBlock extends CropBlock {
	public static final VoxelShape[] SHAPES = new VoxelShape[]{Block.box(4.0D, 0.0D, 4.0D, 12.0D, 2.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D), Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)};

	public StrawberryCropBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public ItemStack getCloneItemStack(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
		return new ItemStack(IcariaItems.STRAWBERRY_SEEDS.get());
	}

	@Override
	public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		return SHAPES[pState.getValue(this.getAgeProperty())];
	}
}
