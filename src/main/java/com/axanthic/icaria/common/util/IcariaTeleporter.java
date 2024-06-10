package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.block.IcariaPortalBlock;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaDimensions;
import com.axanthic.icaria.common.registry.IcariaPoiTypes;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.TicketType;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;

import net.neoforged.neoforge.common.util.ITeleporter;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaTeleporter implements ITeleporter {
    public ServerLevel level;

    public IcariaTeleporter(ServerLevel pLevel) {
        this.level = pLevel;
    }

    public boolean checkRegionForPlacement(BlockPos pPos) {
        return this.level.getBlockState(pPos.below()).is(BlockTags.DIRT) || this.level.getBlockState(pPos.below()).is(BlockTags.SAND);
    }

    public int getY(BlockPos pPos) {
        return Mth.clamp(this.level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pPos.getX(), pPos.getZ()), this.level.dimension() == IcariaDimensions.ICARIA ? 84 : 64, this.level.getHeight() - 5);
    }

    public BlockPos getPos(Entity pEntity, WorldBorder pWorldBorder, double pCoordinateDifference) {
        double maxX = Math.min(2.9999872E7D, pWorldBorder.getMaxX() - 16.0D);
        double maxZ = Math.min(2.9999872E7D, pWorldBorder.getMaxZ() - 16.0D);
        double minX = Math.max(-2.9999872E7D, pWorldBorder.getMinX() + 16.0D);
        double minZ = Math.max(-2.9999872E7D, pWorldBorder.getMinZ() + 16.0D);
        return BlockPos.containing(Mth.clamp(pEntity.getX() * pCoordinateDifference, minX, maxX), this.level.getHeight(), Mth.clamp(pEntity.getZ() * pCoordinateDifference, minZ, maxZ));
    }

    public Optional<BlockUtil.FoundRectangle> makePortal(BlockPos pPos, Direction.Axis pAxis) {
        double d = 0.0D;

        var blockPos = BlockPos.ZERO;
        var direction = Direction.get(Direction.AxisDirection.POSITIVE, pAxis);

        for (var mutablePos : BlockPos.spiralAround(pPos, 64, Direction.NORTH, Direction.EAST)) {
            int y = this.getY(mutablePos);
            mutablePos.setY(y);
            if (this.checkRegionForPlacement(mutablePos)) {
                double e = pPos.distSqr(mutablePos);
                if (d > e || d == 0.0D) {
                    d = e;
                    blockPos = mutablePos.immutable();
                }
            }
        }

        var foundRectangle = new BlockUtil.FoundRectangle(blockPos.immutable(), 3, 4);
        var mutablePos = pPos.mutable();

        for (int k2 = -1; k2 < 4; ++k2) {
            for (int i3 = -1; i3 < 0; ++i3) {
                mutablePos.setWithOffset(blockPos, k2 * direction.getStepX(), i3, k2 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, this.level.getBlockState(blockPos.below()));
            }
        }

        // LEFT PILLARS

        for (int k1 = -1; k1 < 0; ++k1) {
            for (int i2 = 0; i2 < 3; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y));
            }
        }

        // RIGHT PILLARS

        for (int k1 = 3; k1 < 4; ++k1) {
            for (int i2 = 0; i2 < 3; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y));
            }
        }

        // LEFT PILLAR HEAD

        for (int k1 = -1; k1 < 0; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN));
            }
        }

        // RIGHT PILLAR HEAD

        for (int k1 = 3; k1 < 4; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN));
            }
        }

        // LEFT UPPER SLABS

        for (int k1 = -1; k1 < 1; ++k1) {
            for (int i2 = 4; i2 < 5; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM));
            }
        }

        // RIGHT UPPER SLABS

        for (int k1 = 2; k1 < 4; ++k1) {
            for (int i2 = 4; i2 < 5; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM));
            }
        }

        // LEFT LOWER SLAB

        for (int k1 = -2; k1 < -1; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP));
            }
        }

        // RIGHT LOWER SLAB

        for (int k1 = 4; k1 < 5; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos.setWithOffset(blockPos, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP));
            }
        }

        for (int j2 = 0; j2 < 3; ++j2) {
            for (int l2 = 0; l2 < 4; ++l2) {
                mutablePos.setWithOffset(blockPos, j2 * direction.getStepX(), l2, j2 * direction.getStepZ());
                this.level.setBlockAndUpdate(mutablePos, IcariaBlocks.ICARIA_PORTAL.get().defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, pAxis));
            }
        }

        return Optional.of(foundRectangle);
    }

    public Optional<BlockUtil.FoundRectangle> getOrMakePortal(BlockPos pPos) {
        var axis = this.level.getBlockState(IcariaPortalBlock.entrancePos).getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
        var optional = this.getPortal(pPos);
        if (optional.isPresent()) {
            return optional;
        } else {
            return this.makePortal(pPos, axis);
        }
    }

    public Optional<BlockUtil.FoundRectangle> getPortal(BlockPos pPos) {
        this.level.getPoiManager().ensureLoadedAndValid(this.level, pPos, 64);
        var optional =  this.level.getPoiManager().getInSquare((pPoiType) ->
            pPoiType.is(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getKey(IcariaPoiTypes.ICARIA_PORTAL.get())), pPos, 64, PoiManager.Occupancy.ANY).sorted(Comparator.<PoiRecord>comparingDouble((pPoiRecord) ->
            pPoiRecord.getPos().distSqr(pPos)).thenComparingInt((pPoiRecord) ->
            pPoiRecord.getPos().getY())).filter((pPoiRecord) ->
            this.level.getBlockState(pPoiRecord.getPos()).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).findFirst();

        return optional.map(
            (pPoiRecord) -> {
                var blockPos = pPoiRecord.getPos();
                var blockState = this.level.getBlockState(blockPos);
                this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockPos), 3, blockPos);
                return BlockUtil.getLargestRectangleAround(blockPos, blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (pBlockPos) -> this.level.getBlockState(pBlockPos) == blockState);
            }
        );
    }

    @Override
    public PortalInfo getPortalInfo(Entity pEntity, ServerLevel pLevel, Function<ServerLevel, PortalInfo> pFunction) {
        var blockPos = this.getPos(pEntity, pLevel.getWorldBorder(), DimensionType.getTeleportationScale(pEntity.level().dimensionType(), pLevel.dimensionType()));
        var blockState = pEntity.level().getBlockState(IcariaPortalBlock.entrancePos);
        if (pEntity.level().dimension() != IcariaDimensions.ICARIA && pLevel.dimension() != IcariaDimensions.ICARIA) {
            return null;
        } else {
            return this.getOrMakePortal(blockPos).map(
                (pFoundRectangle) -> {
                    Direction.Axis axis;
                    Vec3 vec3;
                    if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
                        axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
                        vec3 = PortalShape.getRelativePosition(BlockUtil.getLargestRectangleAround(IcariaPortalBlock.entrancePos, axis, 21, Direction.Axis.Y, 21, (pBlockPos) -> pEntity.level().getBlockState(pBlockPos) == blockState), axis, pEntity.position(), pEntity.getDimensions(pEntity.getPose()));
                    } else {
                        axis = Direction.Axis.X;
                        vec3 = new Vec3(0.5D, 0.0D, 0.0D);
                    }

                    return PortalShape.createPortalInfo(pLevel, pFoundRectangle, axis, vec3, pEntity, pEntity.getDeltaMovement(), pEntity.getYRot(), pEntity.getXRot());
                }
            ).orElse(null);
        }
    }
}
