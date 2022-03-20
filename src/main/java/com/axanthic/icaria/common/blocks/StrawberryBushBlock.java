package com.axanthic.icaria.common.blocks;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StrawberryBushBlock extends Block {
	public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D);

	public StrawberryBushBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
		BlockPos pos = pPos.below();
		return this.mayPlaceOn(pLevel.getBlockState(pos));
	}

	public boolean mayPlaceOn(BlockState pState) {
		return pState.is(BlockTags.DIRT) || pState.is(IcariaBlocks.MARL.get()) || pState.is(IcariaBlocks.MARL_COARSE.get()) || pState.is(IcariaBlocks.MARL_GRASS.get());
	}

	@Override
	public BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
		return !pState.canSurvive(pLevel, pCurrentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
	}

	@Override
	public OffsetType getOffsetType() {
		return OffsetType.XZ;
	}

	@Override
	public VoxelShape getShape( BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
		Vec3 vec3 = pState.getOffset(pLevel, pPos);
		return SHAPE.move(vec3.x, vec3.y, vec3.z);
	}
}
