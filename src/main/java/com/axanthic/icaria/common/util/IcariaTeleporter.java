package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.block.IcariaPortalBlock;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaDimensions;
import com.axanthic.icaria.common.registry.IcariaPOIs;

import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.level.portal.PortalShape;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.common.util.ITeleporter;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaTeleporter implements ITeleporter {
    public static final EnumProperty<Direction.Axis> HORIZONTAL_AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public ServerLevel level;

    public IcariaTeleporter(ServerLevel pLevel) {
        this.level = pLevel;
    }

    public boolean checkRegionForPlacement(BlockPos pPos, BlockPos.MutableBlockPos pMutablePos) {
        for (int i = -1; i < 3; ++i) {
            for (int j = -1; j < 4; ++j) {
                if (this.level.isEmptyBlock(pMutablePos)) {
                    return true;
                }
            }
        }

        return this.level.getBlockState(pPos.below()).getMaterial().isSolid();
    }

    @Override
    public boolean playTeleportSound(ServerPlayer pPlayer, ServerLevel pLevel, ServerLevel pDestination) {
        return true;
    }

    public Optional<BlockUtil.FoundRectangle> makePortal(BlockPos pPos, Direction.Axis pAxis) {
        double d0 = -1.0D;
        double d1 = -1.0D;
        int levelHeight = this.level.getHeight() - 1;
        BlockPos blockPos0 = null;
        BlockPos blockPos1 = null;
        BlockPos.MutableBlockPos mutablePos0 = pPos.mutable();
        Direction direction = Direction.get(Direction.AxisDirection.POSITIVE, pAxis);
        WorldBorder worldBorder = this.level.getWorldBorder();
        for (BlockPos.MutableBlockPos mutablePos1 : BlockPos.spiralAround(pPos, 16, Direction.EAST, Direction.SOUTH)) {
            int j = Math.min(levelHeight, this.level.getHeight(Heightmap.Types.MOTION_BLOCKING, mutablePos1.getX(), mutablePos1.getZ()));
            if (worldBorder.isWithinBounds(mutablePos1) && worldBorder.isWithinBounds(mutablePos1.move(direction, 1))) {
                mutablePos1.move(direction.getOpposite(), 1);
                for (int l = j; l >= 0; --l) {
                    mutablePos1.setY(l);
                    if (this.level.isEmptyBlock(mutablePos1)) {
                        int i1;
                        for (i1 = l; l > 0 && this.level.isEmptyBlock(mutablePos1.move(Direction.DOWN)); --l) {

                        }

                        if (l + 4 <= levelHeight) {
                            int j1 = i1 - l;
                            if (j1 <= 0 || j1 >= 3) {
                                mutablePos1.setY(l);
                                if (this.checkRegionForPlacement(mutablePos1, mutablePos0)) {
                                    double d2 = pPos.distSqr(mutablePos1);
                                    if (this.checkRegionForPlacement(mutablePos1, mutablePos0) && this.checkRegionForPlacement(mutablePos1, mutablePos0) && (d0 == -1.0D || d0 > d2)) {
                                        d0 = d2;
                                        blockPos0 = mutablePos1.immutable();
                                    }

                                    if (d0 == -1.0D && (d1 == -1.0D || d1 > d2)) {
                                        d1 = d2;
                                        blockPos1 = mutablePos1.immutable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (d0 == -1.0D && d1 != -1.0D) {
            blockPos0 = blockPos1;
            d0 = d1;
        }

        if (d0 == -1.0D) {
            blockPos0 = (new BlockPos(pPos.getX(), Mth.clamp(pPos.getY(), 70, this.level.getHeight() - 10), pPos.getZ())).immutable();
            Direction clockWise = direction.getClockWise();
            if (!worldBorder.isWithinBounds(blockPos0)) {
                return Optional.empty();
            }

            for (int l1 = -1; l1 < 2; ++l1) {
                for (int k2 = -1; k2 < 4; ++k2) {
                    for (int i3 = -1; i3 < 3; ++i3) {
                        mutablePos0.setWithOffset(blockPos0, k2 * direction.getStepX() + l1 * clockWise.getStepX(), i3, k2 * direction.getStepZ() + l1 * clockWise.getStepZ());
                        this.level.setBlockAndUpdate(mutablePos0, i3 < 0 ? IcariaBlocks.DOLOMITE_SMOOTH.get().defaultBlockState() : Blocks.AIR.defaultBlockState());
                    }
                }
            }
        }

        // LEFT PILLARS
        for (int k1 = -1; k1 < 0; ++k1) {
            for (int i2 = 0; i2 < 3; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y), 3);
            }
        }

        // RIGHT PILLARS
        for (int k1 = 3; k1 < 4; ++k1) {
            for (int i2 = 0; i2 < 3; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y), 3);
            }
        }

        // LEFT PILLAR HEAD
        for (int k1 = -1; k1 < 0; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN), 3);
            }
        }

        // RIGHT PILLAR HEAD
        for (int k1 = 3; k1 < 4; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN), 3);
            }
        }

        // LEFT UPPER SLABS
        for (int k1 = -1; k1 < 1; ++k1) {
            for (int i2 = 4; i2 < 5; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_SMOOTH_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM), 3);
            }
        }

        // RIGHT UPPER SLABS
        for (int k1 = 2; k1 < 4; ++k1) {
            for (int i2 = 4; i2 < 5; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_SMOOTH_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM), 3);
            }
        }

        // LEFT LOWER SLAB
        for (int k1 = -2; k1 < -1; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_SMOOTH_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP), 3);
            }
        }

        // RIGHT LOWER SLAB
        for (int k1 = 4; k1 < 5; ++k1) {
            for (int i2 = 3; i2 < 4; ++i2) {
                mutablePos0.setWithOffset(blockPos0, k1 * direction.getStepX(), i2, k1 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.DOLOMITE_SMOOTH_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP), 3);
            }
        }

        for (int j2 = 0; j2 < 3; ++j2) {
            for (int l2 = 0; l2 < 4; ++l2) {
                mutablePos0.setWithOffset(blockPos0, j2 * direction.getStepX(), l2, j2 * direction.getStepZ());
                this.level.setBlock(mutablePos0, IcariaBlocks.ICARIA_PORTAL.get().defaultBlockState().setValue(HORIZONTAL_AXIS, pAxis), 18);
            }
        }

        return Optional.of(new BlockUtil.FoundRectangle(blockPos0.immutable(), 2, 3));
    }

    public Optional<BlockUtil.FoundRectangle> getOrMakePortal(BlockPos pPos) {
        Optional<BlockUtil.FoundRectangle> existingPortal = this.getPortal(pPos);
        if (existingPortal.isPresent()) {
            return existingPortal;
        } else {
            Direction.Axis portalAxis = this.level.getBlockState(IcariaPortalBlock.entrancePos).getOptionalValue(HORIZONTAL_AXIS).orElse(Direction.Axis.X);
            return this.makePortal(pPos, portalAxis);
        }
    }

    public Optional<BlockUtil.FoundRectangle> getPortal(BlockPos pPos) {
        PoiManager poiManager = this.level.getPoiManager();
        poiManager.ensureLoadedAndValid(this.level, pPos, 64);
        Optional<PoiRecord> optional = poiManager.getInSquare((poiType) ->
            poiType.is(Objects.requireNonNull(IcariaPOIs.ICARIA_PORTAL.getKey())), pPos, 64, PoiManager.Occupancy.ANY).sorted(Comparator.<PoiRecord>comparingDouble((poi) ->
            poi.getPos().distSqr(pPos)).thenComparingInt((poi) ->
            poi.getPos().getY())).filter((poi) ->
            this.level.getBlockState(poi.getPos()).hasProperty(HORIZONTAL_AXIS)).findFirst();

        return optional.map((poi) -> {
            BlockPos blockPos = poi.getPos();
            this.level.getChunkSource().addRegionTicket(TicketType.PORTAL, new ChunkPos(blockPos), 3, blockPos);
            BlockState blockState = this.level.getBlockState(blockPos);

            return BlockUtil.getLargestRectangleAround(blockPos, blockState.getValue(HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (posIn) ->
                this.level.getBlockState(posIn) == blockState);
        });
    }

    @Override
    public PortalInfo getPortalInfo(Entity pEntity, ServerLevel pLevel, Function<ServerLevel, PortalInfo> pFunction) {
        boolean icaria = pLevel.dimension() == IcariaDimensions.ICARIA;
        if (pEntity.level.dimension() != IcariaDimensions.ICARIA && !icaria) {
            return null;
        } else {
            WorldBorder worldBorder = pLevel.getWorldBorder();
            double coordinateDifference = DimensionType.getTeleportationScale(pEntity.level.dimensionType(), pLevel.dimensionType());
            double maxX = Math.min(2.9999872E7D, worldBorder.getMaxX() - 16.0D);
            double maxZ = Math.min(2.9999872E7D, worldBorder.getMaxZ() - 16.0D);
            double minX = Math.max(-2.9999872E7D, worldBorder.getMinX() + 16.0D);
            double minZ = Math.max(-2.9999872E7D, worldBorder.getMinZ() + 16.0D);
            BlockPos blockPos = new BlockPos(Mth.clamp(pEntity.getX() * coordinateDifference, minX, maxX), pEntity.getY(), Mth.clamp(pEntity.getZ() * coordinateDifference, minZ, maxZ));

            return this.getOrMakePortal(blockPos).map((result) -> {
                BlockState blockState = pEntity.level.getBlockState(IcariaPortalBlock.entrancePos);
                Direction.Axis axis;
                Vec3 vec3;
                if (blockState.hasProperty(HORIZONTAL_AXIS)) {
                    axis = blockState.getValue(HORIZONTAL_AXIS);
                    BlockUtil.FoundRectangle rectangle = BlockUtil.getLargestRectangleAround(IcariaPortalBlock.entrancePos, axis, 21, Direction.Axis.Y, 21, (pos) -> pEntity.level.getBlockState(pos) == blockState);
                    vec3 = PortalShape.getRelativePosition(rectangle, axis, pEntity.position(), pEntity.getDimensions(pEntity.getPose()));
                } else {
                    axis = Direction.Axis.X;
                    vec3 = new Vec3(0.5D, 0.0D, 0.0D);
                }

                return PortalShape.createPortalInfo(pLevel, result, axis, vec3, pEntity.getDimensions(pEntity.getPose()), pEntity.getDeltaMovement(), pEntity.getYRot(), pEntity.getXRot());
            }).orElse(null);
        }
    }
}
