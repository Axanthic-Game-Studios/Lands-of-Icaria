package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.shapes.LayerVoxelShapes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpeltCropBlock extends CropBlock {
	public SpeltCropBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public ItemStack getCloneItemStack(LevelReader pLevelReader, BlockPos pBlockPos, BlockState pBlockState, boolean pInfiniteMaterial) {
		return new ItemStack(IcariaItems.SPELT_SEEDS.get());
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		return LayerVoxelShapes.SHAPES.get(pBlockState.getValue(BlockStateProperties.AGE_7));
	}
}
