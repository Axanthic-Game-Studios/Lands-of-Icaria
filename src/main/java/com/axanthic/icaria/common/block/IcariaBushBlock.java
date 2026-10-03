package com.axanthic.icaria.common.block;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.shapes.DirectionVoxelShapes;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBushBlock extends BushBlock {
	public IcariaBushBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canBeReplaced(BlockState pBlockState, BlockPlaceContext pBlockPlaceContext) {
		return pBlockState.is(BlockTags.REPLACEABLE);
	}

	@Override
	public boolean canSurvive(BlockState pBlockState, LevelReader pLevelReader, BlockPos pBlockPos) {
		var blockState = pLevelReader.getBlockState(pBlockPos.below());
		if (this == IcariaBlocks.NAMDRAKE.get()) {
			return blockState.is(IcariaBlocks.DRY_LAKE_BED.get());
		} else if (this == IcariaBlocks.MONDANOS.get()) {
			return blockState.is(BlockItemTags.SAND.block());
		} else if (this == IcariaBlocks.BOLBOS.get()) {
			return blockState.is(BlockItemTags.SAND.block());
		} else {
			return blockState.is(BlockTags.SUBSTRATE_OVERWORLD);
		}
	}

	@Override
	public VoxelShape getShape(BlockState pBlockState, BlockGetter pBlockGetter, BlockPos pBlockPos, CollisionContext pCollisionContext) {
		var vec3 = pBlockState.getOffset(pBlockPos);
		return DirectionVoxelShapes.UP.move(vec3.x, vec3.y, vec3.z);
	}
}
