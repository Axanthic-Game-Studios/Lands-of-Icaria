package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.*;
import com.axanthic.icaria.common.util.IcariaPortalShape;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.BlockUtil;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.village.poi.PoiManager;
import net.minecraft.world.entity.ai.village.poi.PoiRecord;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Comparator;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalBlock extends Block implements Portal {
    public IcariaPortalBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X));
    }

    public boolean canSet(ServerLevel pLevel, BlockPos pPos) {
        var aabbNorth = AABB.ofSize(pPos.above(3).north().getCenter(), 2, 6, 2);
        var aabbEast = AABB.ofSize(pPos.above(3).east().getCenter(), 2, 6, 2);
        var aabbSouth = AABB.ofSize(pPos.above(3).south().getCenter(), 2, 6, 2);
        var aabbWest = AABB.ofSize(pPos.above(3).west().getCenter(), 2, 6, 2);

        boolean testNorth = pLevel.getBlockStates(aabbNorth).allMatch((pState) -> pState.is(IcariaBlockTags.ICARIA_PORTAL_REPLACE_BLOCKS));
        boolean testEast = pLevel.getBlockStates(aabbEast).allMatch((pState) -> pState.is(IcariaBlockTags.ICARIA_PORTAL_REPLACE_BLOCKS));
        boolean testSouth = pLevel.getBlockStates(aabbSouth).allMatch((pState) -> pState.is(IcariaBlockTags.ICARIA_PORTAL_REPLACE_BLOCKS));
        boolean testWest = pLevel.getBlockStates(aabbWest).allMatch((pState) -> pState.is(IcariaBlockTags.ICARIA_PORTAL_REPLACE_BLOCKS));

        return testNorth && testEast && testSouth && testWest;
    }

    public boolean checkBelow(ServerLevel pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT) || pLevel.getBlockState(pPos.below()).is(BlockTags.SAND);
    }

    @Override
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pDirection) {
        return pAdjacentBlockState.is(this);
    }

    public int getY(ServerLevel pLevel, BlockPos pPos) {
        return Mth.clamp(pLevel.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, pPos.getX(), pPos.getZ()), pLevel.dimension() == IcariaDimensions.ICARIA ? 84 : 64, pLevel.getHeight() - 5);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        var blockPos = pPos.below();
        var revenant = IcariaEntityTypes.CIVILIAN_REVENANT.get();
        if (pLevel.dimension() != IcariaDimensions.ICARIA) {
            if (pLevel.dimensionType().natural()) {
                if (pLevel.getBlockState(blockPos).isValidSpawn(pLevel, blockPos, revenant)) {
                    if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
                        if (pRandom.nextInt(2000) == 0) {
                            var spawn = revenant.spawn(pLevel, pPos, MobSpawnType.STRUCTURE);
                            if (spawn != null) {
                                spawn.setPortalCooldown();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(100) == 0) {
            pLevel.playLocalSound(pPos.getX() + 0.5D, pPos.getY() + 0.5D, pPos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, pRandom.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int i = 0; i < 4; i++) {
            double d0 = pPos.getX() + pRandom.nextDouble();
            double d1 = pPos.getY() + pRandom.nextDouble();
            double d2 = pPos.getZ() + pRandom.nextDouble();
            double d3 = (pRandom.nextFloat() - 0.5D) * 0.5D;
            double d4 = (pRandom.nextFloat() - 0.5D) * 0.5D;
            double d5 = (pRandom.nextFloat() - 0.5D) * 0.5D;
            int j = pRandom.nextInt(2) * 2 - 1;
            if (!pLevel.getBlockState(pPos.west()).is(this) && !pLevel.getBlockState(pPos.east()).is(this)) {
                d0 = pPos.getX() + 0.5D + 0.25D * j;
                d3 = pRandom.nextFloat() * 2.0D * j;
            } else {
                d2 = pPos.getZ() + 0.5D + 0.25D * j;
                d5 = pRandom.nextFloat() * 2.0D * j;
            }

            pLevel.addParticle(IcariaParticleTypes.PORTAL.get(), d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.HORIZONTAL_AXIS);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (pEntity.canUsePortal(false)) {
            pEntity.setAsInsidePortal(this, pPos);
        }
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return switch (pRotation) {
            case CLOCKWISE_90, COUNTERCLOCKWISE_90 -> switch (pState.getValue(BlockStateProperties.HORIZONTAL_AXIS)) {
                case X -> pState.setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.Z);
                case Z -> pState.setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X);
                default -> pState;
            };

            default -> pState;
        };
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        var axis = pDirection.getAxis();
        var horizontalAxis = pState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        var portalShape = new IcariaPortalShape(pLevel, pPos, horizontalAxis);
        boolean flag = axis.isHorizontal() && horizontalAxis != axis;
        return !flag && !portalShape.isComplete() && !pNeighborState.is(this) && !pNeighborState.is(IcariaBlockTags.ICARIA_PORTAL_BLOCKS) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public DimensionTransition getPortalDestination(ServerLevel pLevel, Entity pEntity, BlockPos pPos) {
        var resourceKey = pLevel.dimension() == IcariaDimensions.ICARIA ? Level.OVERWORLD : IcariaDimensions.ICARIA;
        var serverLevel = pLevel.getServer().getLevel(resourceKey);
        if (serverLevel != null) {
            var worldBorder = serverLevel.getWorldBorder();
            var blockPos = worldBorder.clampToBounds(pEntity.getX(), pEntity.getY(), pEntity.getZ());
            return this.getExitPortal(serverLevel, pEntity, pPos, blockPos, worldBorder);
        } else {
            return null;
        }
    }

    public @Nullable DimensionTransition getExitPortal(ServerLevel pLevel, Entity pEntity, BlockPos pPos, BlockPos pExitPos, WorldBorder pWorldBorder) {
        var oldPortal = this.findClosestPortalPosition(pLevel, pExitPos, pWorldBorder);
        DimensionTransition.PostDimensionTransition dimensionTransition;
        BlockUtil.FoundRectangle foundRectangle;
        if (oldPortal.isPresent()) {
            var blockPos = oldPortal.get();
            var blockState = pLevel.getBlockState(blockPos);
            dimensionTransition = DimensionTransition.PLAY_PORTAL_SOUND.then((entity) -> entity.placePortalTicket(blockPos));
            foundRectangle = BlockUtil.getLargestRectangleAround(blockPos, blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, (pos) -> pLevel.getBlockState(pos) == blockState);
        } else {
            var axis = pEntity.level().getBlockState(pPos).getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
            var newPortal = this.createPortal(pLevel, pExitPos, axis);
            if (newPortal.isEmpty()) {
                return null;
            }

            foundRectangle = newPortal.get();
            dimensionTransition = DimensionTransition.PLAY_PORTAL_SOUND.then(DimensionTransition.PLACE_PORTAL_TICKET);
        }

        return this.getDimensionTransitionFromExit(pEntity, pPos, foundRectangle, pLevel, dimensionTransition);
    }

    public Optional<BlockUtil.FoundRectangle> createPortal(ServerLevel pLevel, BlockPos pPos, Direction.Axis pAxis) {
        double d = 0.0D;

        var blockPos = BlockPos.ZERO;
        var direction = Direction.get(Direction.AxisDirection.POSITIVE, pAxis);

        for (var mutablePos : BlockPos.spiralAround(pPos, 64, Direction.NORTH, Direction.EAST)) {
            int y = this.getY(pLevel, mutablePos);
            mutablePos.setY(y);
            if (this.checkBelow(pLevel, mutablePos) && this.canSet(pLevel, mutablePos)) {
                double e = pPos.distSqr(mutablePos);
                if (d > e || d == 0.0D) {
                    d = e;
                    blockPos = mutablePos.immutable();
                }
            }
        }

        var foundRectangle = new BlockUtil.FoundRectangle(blockPos.immutable(), 3, 4);
        var mutablePos = pPos.mutable();

        for (int i = -1; i < 4; ++i) {
            for (int j = -1; j < 0; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, pLevel.getBlockState(blockPos.below()));
            }
        }

        // LEFT PILLARS

        for (int i = -1; i < 0; ++i) {
            for (int j = 0; j < 3; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y));
            }
        }

        // RIGHT PILLARS

        for (int i = 3; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR.get().defaultBlockState().setValue(BlockStateProperties.AXIS, Direction.Axis.Y));
            }
        }

        // LEFT PILLAR HEAD

        for (int i = -1; i < 0; ++i) {
            for (int j = 3; j < 4; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN));
            }
        }

        // RIGHT PILLAR HEAD

        for (int i = 3; i < 4; ++i) {
            for (int j = 3; j < 4; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.DOLOMITE_PILLAR_HEAD.get().defaultBlockState().setValue(BlockStateProperties.FACING, Direction.DOWN));
            }
        }

        // LEFT UPPER SLABS

        for (int i = -1; i < 1; ++i) {
            for (int j = 4; j < 5; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM));
            }
        }

        // RIGHT UPPER SLABS

        for (int i = 2; i < 4; ++i) {
            for (int j = 4; j < 5; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.BOTTOM));
            }
        }

        // LEFT LOWER SLAB

        for (int i = -2; i < -1; ++i) {
            for (int j = 3; j < 4; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP));
            }
        }

        // RIGHT LOWER SLAB

        for (int i = 4; i < 5; ++i) {
            for (int j = 3; j < 4; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get().defaultBlockState().setValue(SlabBlock.TYPE, SlabType.TOP));
            }
        }

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 4; ++j) {
                mutablePos.setWithOffset(blockPos, i * direction.getStepX(), j, i * direction.getStepZ());
                pLevel.setBlockAndUpdate(mutablePos, this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_AXIS, pAxis));
            }
        }

        return Optional.of(foundRectangle);
    }

    public DimensionTransition getDimensionTransitionFromExit(Entity pEntity, BlockPos pPos, BlockUtil.FoundRectangle pRectangle, ServerLevel pLevel, DimensionTransition.PostDimensionTransition pPostDimensionTransition) {
        var blockState = pEntity.level().getBlockState(pPos);
        Direction.Axis axis;
        Vec3 vec3;
        if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
            axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
            vec3 = pEntity.getRelativePortalPosition(axis, BlockUtil.getLargestRectangleAround(pPos, axis, 21, Direction.Axis.Y, 21, (pos) -> pEntity.level().getBlockState(pos) == blockState));
        } else {
            axis = Direction.Axis.X;
            vec3 = new Vec3(0.5, 0.0, 0.0);
        }

        return this.createDimensionTransition(pLevel, pRectangle, axis, vec3, pEntity, pEntity.getDeltaMovement(), pEntity.getYRot(), pEntity.getXRot(), pPostDimensionTransition);
    }

    public DimensionTransition createDimensionTransition(ServerLevel pLevel, BlockUtil.FoundRectangle pRectangle, Direction.Axis pAxis, Vec3 pOffset, Entity pEntity, Vec3 pSpeed, float pYRot, float pXRot, DimensionTransition.PostDimensionTransition pPostDimensionTransition) {
        var entityDimensions = pEntity.getDimensions(pEntity.getPose());
        var blockPos = pRectangle.minCorner;
        var blockState = pLevel.getBlockState(blockPos);
        var axis = blockState.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);

        boolean flag = axis == Direction.Axis.X;

        double d = pRectangle.axis1Size;
        double e = pRectangle.axis2Size;
        double f = pOffset.x() * (d - entityDimensions.width()) + entityDimensions.width() / 2.0D;
        double g = pOffset.y() * (e - entityDimensions.height());
        double h = pOffset.z() + 0.5D;

        int i = pAxis == axis ? 0 : 90;

        var vec3 = new Vec3(blockPos.getX() + (flag ? f : h), blockPos.getY() + g, blockPos.getZ() + (flag ? h : f));
        return new DimensionTransition(pLevel, IcariaPortalShape.findCollisionFreePosition(vec3, pLevel, pEntity, entityDimensions), pAxis == axis ? pSpeed : new Vec3(pSpeed.z, pSpeed.y, -pSpeed.x), pYRot + i, pXRot, pPostDimensionTransition);
    }

    public Optional<BlockPos> findClosestPortalPosition(ServerLevel pLevel, BlockPos pExitPos, WorldBorder pWorldBorder) {
        int i = 128;
        var poiManager = pLevel.getPoiManager();
        poiManager.ensureLoadedAndValid(pLevel, pExitPos, i);
        return poiManager.getInSquare((type) -> type.is(IcariaPoiTypes.ICARIA_PORTAL), pExitPos, i, PoiManager.Occupancy.ANY).map(PoiRecord::getPos).filter(pWorldBorder::isWithinBounds).filter((pos) -> pLevel.getBlockState(pos).hasProperty(BlockStateProperties.HORIZONTAL_AXIS)).min(Comparator.<BlockPos>comparingDouble((pos) -> pos.distSqr(pExitPos)).thenComparingInt(Vec3i::getY));
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(BlockStateProperties.HORIZONTAL_AXIS) == Direction.Axis.X ? IcariaShapes.IcariaPortalShapes.X : IcariaShapes.IcariaPortalShapes.Z;
    }
}
