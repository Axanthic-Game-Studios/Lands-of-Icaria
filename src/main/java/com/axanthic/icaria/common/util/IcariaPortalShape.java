package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.portal.PortalShape;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaPortalShape extends PortalShape {
    public int height;
    public int minHeight = 4;
    public int maxHeight = 21;
    public int width;
    public int minWidth = 3;
    public int maxWidth = 21;
    public int numPortalBlocks;

    public BlockPos bottomLeft;

    public Direction leftDir;
    public Direction rightDir;

    public Direction.Axis axis;

    public LevelAccessor level;

    public IcariaPortalShape(LevelAccessor pLevel, BlockPos pPos, Direction.Axis pAxis) {
        super(pLevel, pPos, pAxis);
        this.axis = pAxis;
        this.level = pLevel;
        if (pAxis == Direction.Axis.X) {
            this.leftDir = Direction.EAST;
            this.rightDir = Direction.WEST;
        } else {
            this.leftDir = Direction.NORTH;
            this.rightDir = Direction.SOUTH;
        }

        int i = this.getDistanceUntilEdgeAboveFrame(pPos, this.leftDir) - 1;
        if (i >= 0) {
            this.bottomLeft = pPos.relative(this.leftDir, i);
            this.width = this.getDistanceUntilEdgeAboveFrame(this.bottomLeft, this.rightDir);
            if (this.width < this.minWidth || this.width > this.maxWidth) {
                this.bottomLeft = null;
                this.width = 0;
            }
        }

        if (this.bottomLeft != null) {
            this.height = this.calculateHeight();
        }
    }

    @Override
    public boolean isComplete() {
        return this.isValid() && this.height * this.width == this.numPortalBlocks;
    }

    public boolean isEmpty(BlockState pState) {
        return !pState.canBeReplaced() && !pState.is(IcariaBlocks.GREEK_FIRE.get());
    }

    @Override
    public boolean isValid() {
        return this.bottomLeft != null && this.height >= this.minHeight && this.height <= this.maxHeight && this.width >= this.minWidth && this.width <= this.maxWidth;
    }

    public int calculateHeight() {
        label56:
        for (this.height = 0; this.height <= this.maxHeight; ++this.height) {
            for (int i = 0; i < this.width; ++i) {
                var blockPos = this.bottomLeft.relative(this.rightDir, i).above(this.height);
                var blockState = this.level.getBlockState(blockPos);
                if (this.isEmpty(blockState)) {
                    break label56;
                }

                var block = blockState.getBlock();
                if (block == IcariaBlocks.ICARIA_PORTAL.get()) {
                    ++this.numPortalBlocks;
                }
            }
        }

        for (int h = 0; h < this.height - 1; ++h) {

            // LEFT PILLARS

            for (int w = -1; w < 0; ++w) {
                var blockPos = this.bottomLeft.relative(this.rightDir, w).above(h);
                if (!(this.level.getBlockState(blockPos).equals(Blocks.QUARTZ_PILLAR.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y))) &&
                    !(this.level.getBlockState(blockPos).equals(IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y))) &&
                    !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y)))) {
                    this.height = 0;
                    break;
                }
            }

            // RIGHT PILLARS

            for (int w = this.width; w < this.width + 1; ++w) {
                var blockPos = this.bottomLeft.relative(this.rightDir, w).above(h);
                if (!(this.level.getBlockState(blockPos).equals(Blocks.QUARTZ_PILLAR.defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y))) &&
                    !(this.level.getBlockState(blockPos).equals(IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y))) &&
                    !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y)))) {
                    this.height = 0;
                    break;
                }
            }
        }

        // LEFT PILLAR HEAD

        for (int w = -1; w < 0; ++w) {
            var blockPos = this.bottomLeft.relative(this.rightDir, w).above(this.height - 1);
            if (!(this.level.getBlockState(blockPos).equals(IcariaBlocks.QUARTZ_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN)))) {
                this.height = 0;
                break;
            }
        }

        // RIGHT PILLAR HEAD

        for (int w = this.width; w < this.width + 1; ++w) {
            var blockPos = this.bottomLeft.relative(this.rightDir, w).above(this.height - 1);
            if (!(this.level.getBlockState(blockPos).equals(IcariaBlocks.QUARTZ_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN)))) {
                this.height = 0;
                break;
            }
        }

        // LEFT UPPER SLABS

        for (int w = -1; w < 1; ++w) {
            var blockPos = this.bottomLeft.relative(this.rightDir, w).above(this.height);
            if (!(this.level.getBlockState(blockPos).equals(Blocks.QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(Blocks.SMOOTH_QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM)))) {
                this.height = 0;
                break;
            }
        }

        // RIGHT UPPER SLABS

        for (int w = this.width - 1; w < this.width + 1; ++w) {
            var blockPos = this.bottomLeft.relative(this.rightDir, w).above(this.height);
            if (!(this.level.getBlockState(blockPos).equals(Blocks.QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(Blocks.SMOOTH_QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM)))) {
                this.height = 0;
                break;
            }
        }

        // LEFT LOWER SLAB

        for (int w = -2; w < -1; ++w) {
            var blockPos = this.bottomLeft.relative(this.rightDir, w).above(this.height - 1);
            if (!(this.level.getBlockState(blockPos).equals(Blocks.QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(Blocks.SMOOTH_QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP)))) {
                this.height = 0;
                break;
            }
        }

        // RIGHT LOWER SLAB

        for (int w = this.width + 1; w < this.width + 2; ++w) {
            var blockPos = this.bottomLeft.relative(this.rightDir, w).above(this.height - 1);
            if (!(this.level.getBlockState(blockPos).equals(Blocks.QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(Blocks.SMOOTH_QUARTZ_SLAB.defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP))) &&
                !(this.level.getBlockState(blockPos).equals(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP)))) {
                this.height = 0;
                break;
            }
        }

        if (this.height >= this.minHeight && this.height <= this.maxHeight) {
            return this.height;
        } else {
            this.bottomLeft = null;
            this.height = 0;
            this.width = 0;
            return 0;
        }
    }

    public int getDistanceUntilEdgeAboveFrame(BlockPos pPos, Direction pDirection) {
        int i;
        for (i = 0; i <= this.maxWidth; ++i) {
            var blockPos = pPos.relative(pDirection, i);
            if (this.isEmpty(this.level.getBlockState(blockPos)) || !(this.level.getBlockState(blockPos.below()).isFaceSturdy(this.level, blockPos.below(), Direction.UP))) {
                break;
            }
        }

        var blockPos = pPos.relative(pDirection, i);
        return this.level.getBlockState(blockPos).is(IcariaBlockTags.ICARIA_PORTAL_BLOCKS) ? i : 0;
    }

    @Override
    public void createPortalBlocks() {
        for (int w = 0; w < this.width; ++w) {
            var blockPos = this.bottomLeft.relative(this.rightDir, w);
            for (int h = 0; h < this.height; ++h) {
                this.level.setBlock(blockPos.above(h), IcariaBlocks.ICARIA_PORTAL.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, this.axis), 18);
            }
        }
    }
}
