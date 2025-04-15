package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.provider.tags.IcariaBlockTagsProvider;

import java.util.stream.IntStream;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.phys.AABB;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalShape {
	public int minHeight = 2;
	public int maxHeight = 21;
	public int minWidth = 1;
	public int maxWidth = 21;

	public Direction.Axis axis;

	public BlockPos blockPos;

	public Level level;

	public IcariaPortalShape(Direction.Axis pAxis, BlockPos pBlockPos, Level pLevel) {
		super();
		this.axis = pAxis;
		this.blockPos = pBlockPos;
		this.level = pLevel;
	}

	public boolean canSet() {
		var ground = new AABB(this.getCorner().below().getX(), this.getCorner().below().getY(), this.getCorner().below().getZ(), this.getCorner().below().relative(this.getRight(), this.getWidth() - 1).getX(), this.getCorner().below().getY(), this.getCorner().below().relative(this.getRight(), this.getWidth() - 1).getZ());
		var portal = new AABB(this.getCorner().getX(), this.getCorner().getY(), this.getCorner().getZ(), this.getCorner().relative(this.getRight(), this.getWidth() - 1).getX(), this.getCorner().above(this.getHeight() - 1).getY(), this.getCorner().relative(this.getRight(), this.getWidth() - 1).getZ());
		return this.level.getBlockStates(ground).allMatch(BlockBehaviour.BlockStateBase::isSolidRender) && this.level.getBlockStates(portal).allMatch(BlockBehaviour.BlockStateBase::canBeReplaced);
	}

	public boolean isComplete() {
		var bottomSlabEastAABB = new AABB(this.getCorner().above(this.getHeight()).getX(), this.getCorner().above(this.getHeight()).getY(), this.getCorner().above(this.getHeight()).getZ(), this.getCorner().above(this.getHeight()).relative(this.getLeft()).getX(), this.getCorner().above(this.getHeight()).relative(this.getLeft()).getY(), this.getCorner().above(this.getHeight()).relative(this.getLeft()).getZ());
		var bottomSlabWestAABB = new AABB(this.getCorner().above(this.getHeight()).relative(this.getRight(), this.getWidth() - 1).getX(), this.getCorner().above(this.getHeight()).relative(this.getRight(), this.getWidth() - 1).getY(), this.getCorner().above(this.getHeight()).relative(this.getRight(), this.getWidth() - 1).getZ(), this.getCorner().above(this.getHeight()).relative(this.getRight(), this.getWidth()).getX(), this.getCorner().above(this.getHeight()).relative(this.getRight(), this.getWidth()).getY(), this.getCorner().above(this.getHeight()).relative(this.getRight(), this.getWidth()).getZ());
		var pillarEastAABB = new AABB(this.getCorner().relative(this.getLeft()).getX(), this.getCorner().relative(this.getLeft()).getY(), this.getCorner().relative(this.getLeft()).getZ(), this.getCorner().relative(this.getLeft()).getX(), this.getCorner().above(this.getHeight() - 2).relative(this.getLeft()).getY(), this.getCorner().relative(this.getLeft()).getZ());
		var pillarWestAABB = new AABB(this.getCorner().relative(this.getRight(), this.getWidth()).getX(), this.getCorner().relative(this.getRight(), this.getWidth()).getY(), this.getCorner().relative(this.getRight(), this.getWidth()).getZ(), this.getCorner().relative(this.getRight(), this.getWidth()).getX(), this.getCorner().above(this.getHeight() - 2).relative(this.getRight(), this.getWidth()).getY(), this.getCorner().relative(this.getRight(), this.getWidth()).getZ());

		var bottomSlabEast = this.level.getBlockStates(bottomSlabEastAABB).allMatch((blockState) -> blockState.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_SLAB, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.SLAB_TYPE) == SlabType.BOTTOM));
		var bottomSlabWest = this.level.getBlockStates(bottomSlabWestAABB).allMatch((blockState) -> blockState.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_SLAB, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.SLAB_TYPE) == SlabType.BOTTOM));
		var pillarEast = this.level.getBlockStates(pillarEastAABB).allMatch((blockState) -> blockState.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y));
		var pillarWest = this.level.getBlockStates(pillarWestAABB).allMatch((blockState) -> blockState.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y));

		var pillarHeadEast = this.level.getBlockState(this.getCorner().above(this.getHeight() - 1).relative(this.getLeft())).is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR_HEAD, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.FACING) == Direction.DOWN);
		var pillarHeadWest = this.level.getBlockState(this.getCorner().above(this.getHeight() - 1).relative(this.getRight(), this.getWidth())).is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR_HEAD, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.FACING) == Direction.DOWN);
		var slabEast = this.level.getBlockState(this.getCorner().above(this.getHeight() - 1).relative(this.getLeft(), 2)).is(IcariaBlockTagsProvider.PORTAL_BLOCKS_SLAB, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.SLAB_TYPE) == SlabType.TOP);
		var slabWest = this.level.getBlockState(this.getCorner().above(this.getHeight() - 1).relative(this.getRight(), this.getWidth() + 1)).is(IcariaBlockTagsProvider.PORTAL_BLOCKS_SLAB, (blockStateBase) -> blockStateBase.getValue(BlockStateProperties.SLAB_TYPE) == SlabType.TOP);

		return bottomSlabEast && bottomSlabWest && pillarEast && pillarWest && pillarHeadEast && pillarHeadWest && slabEast && slabWest;
	}

	public boolean isPortalBlocks(BlockPos pBlockPos, Direction pDirection, int pDistance) {
		var blockState = this.level.getBlockState(pBlockPos.relative(pDirection, pDistance));
		return blockState.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR) || blockState.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_PILLAR_HEAD) || blockState.is(IcariaBlockTagsProvider.PORTAL_BLOCKS_SLAB);
	}

	public int getHeight() {
		return this.getHeightDistance(this.getCorner(), Direction.UP);
	}

	public int getHeightDistance(BlockPos pBlockPos, Direction pDirection) {
		return IntStream.rangeClosed(this.minHeight, this.maxHeight).filter((i) -> this.isPortalBlocks(pBlockPos, pDirection, i)).findFirst().orElse(0);
	}

	public int getWidth() {
		return this.getWidthDistance(this.getCorner(), this.getRight());
	}

	public int getWidthDistance(BlockPos pBlockPos, Direction pDirection) {
		return IntStream.rangeClosed(this.minWidth, this.maxWidth).filter((i) -> this.isPortalBlocks(pBlockPos, pDirection, i)).findFirst().orElse(0);
	}

	public void createPortal() {
		for (var h = 0; h < this.getHeight(); h++) {
			for (var w = 0; w < this.getWidth(); w++) {
				this.level.setBlock(this.getCorner().above(h).relative(this.getRight(), w), IcariaBlocks.ICARIA_PORTAL.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, this.axis), 18);
			}
		}
	}

	public BlockPos getCorner() {
		return this.blockPos.relative(this.getLeft(), this.getWidthDistance(this.blockPos, this.getLeft()) - 1);
	}

	public Direction getLeft() {
		return this.axis == Direction.Axis.Z ? Direction.NORTH : Direction.EAST;
	}

	public Direction getRight() {
		return this.axis == Direction.Axis.Z ? Direction.SOUTH : Direction.WEST;
	}
}
