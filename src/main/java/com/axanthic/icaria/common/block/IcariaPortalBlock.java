package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.util.IcariaPortalShape;
import com.axanthic.icaria.common.util.IcariaTeleporter;
import com.axanthic.icaria.common.registry.IcariaDimensions;
import com.axanthic.icaria.data.IcariaBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BlockEvent;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault

public class IcariaPortalBlock extends Block {
    public static BlockPos entrancePos;
    public static final EnumProperty<Direction.Axis> HORIZONTAL_AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static final VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    public static final VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public IcariaPortalBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_AXIS, Direction.Axis.X));
    }

    @Override
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pDirection) {
        if (pAdjacentBlockState.is(this)) {
            return true;
        }

        return super.skipRendering(pState, pAdjacentBlockState, pDirection);
    }

    public boolean spawnPortal(LevelAccessor pLevel, BlockPos pPos) {
        IcariaPortalShape portalShape = this.isPortal(pLevel, pPos);
        if (portalShape != null && !this.spawnPortalEvent(pLevel, pPos, portalShape)) {
            portalShape.createPortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    public boolean spawnPortalEvent(LevelAccessor pLevel, BlockPos pPos, IcariaPortalShape pShape) {
        return MinecraftForge.EVENT_BUS.post(new BlockEvent.PortalSpawnEvent(pLevel, pPos, pLevel.getBlockState(pPos), pShape));
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HORIZONTAL_AXIS);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pEntity.isPassenger() && !pEntity.isVehicle() && pEntity.canChangeDimensions()) {
            if (pEntity.isOnPortalCooldown()) {
                pEntity.setPortalCooldown();
            } else {
                if (!pEntity.level.isClientSide && !pPos.equals(entrancePos)) {
                    entrancePos = pPos.immutable();
                }

                Level level = pEntity.level;
                MinecraftServer minecraftServer = level.getServer();
                ResourceKey<Level> destination = pEntity.level.dimension() == IcariaDimensions.ICARIA ? Level.OVERWORLD : IcariaDimensions.ICARIA;
                if (minecraftServer != null) {
                    ServerLevel serverLevel = minecraftServer.getLevel(destination);
                    if (serverLevel != null && !pEntity.isPassenger()) {
                        pEntity.level.getProfiler().push(this.getName().toString());
                        pEntity.changeDimension(serverLevel, new IcariaTeleporter(serverLevel));
                        pEntity.setPortalCooldown();
                        pEntity.level.getProfiler().pop();
                    }
                }
            }
        }
    }

    @Override
    public @Nonnull BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        Direction.Axis axis = pDirection.getAxis();
        Direction.Axis horizontalAxis = pState.getValue(HORIZONTAL_AXIS);
        boolean flag = horizontalAxis != axis && axis.isHorizontal();
        return !flag && !pNeighborState.is(this) && !pNeighborState.is(IcariaBlockTags.ICARIA_PORTAL_BLOCKS) && !(new IcariaPortalShape(pLevel, pPos, horizontalAxis)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    public IcariaPortalShape isPortal(LevelAccessor pLevel, BlockPos pPos) {
        IcariaPortalShape icariaPortalShapeX = new IcariaPortalShape(pLevel, pPos, Direction.Axis.X);
        if (icariaPortalShapeX.isValid() && icariaPortalShapeX.numPortalBlocks == 0) {
            return icariaPortalShapeX;
        } else {
            IcariaPortalShape icariaPortalShapeZ = new IcariaPortalShape(pLevel, pPos, Direction.Axis.Z);
            return icariaPortalShapeZ.isValid() && icariaPortalShapeZ.numPortalBlocks == 0 ? icariaPortalShapeZ : null;
        }
    }

    @Override
    public @Nonnull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(HORIZONTAL_AXIS)) {
            case X:
                return X_AXIS_AABB;
            case Z:
            default:
                return Z_AXIS_AABB;
        }
    }
}
