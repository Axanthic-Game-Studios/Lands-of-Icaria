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
    public static EnumProperty<Direction.Axis> HORIZONTAL_AXIS = BlockStateProperties.HORIZONTAL_AXIS;
    public static VoxelShape X_AXIS_AABB = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    public static VoxelShape Z_AXIS_AABB = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public IcariaPortalBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_AXIS, Direction.Axis.X));
    }

    public boolean spawnPortalEvent(LevelAccessor pLevel, BlockPos pPos, IcariaPortalShape pShape) {
        return MinecraftForge.EVENT_BUS.post(new BlockEvent.PortalSpawnEvent(pLevel, pPos, pLevel.getBlockState(pPos), pShape));
    }

    @Override
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pDirection) {
        if (pAdjacentBlockState.is(this)) {
            return true;
        }

        return super.skipRendering(pState, pAdjacentBlockState, pDirection);
    }

    public boolean spawnPortal(LevelAccessor pLevel, BlockPos pPos) {
        IcariaPortalShape icariaPortalShape = this.isPortal(pLevel, pPos);
        if (icariaPortalShape != null && !spawnPortalEvent(pLevel, pPos, icariaPortalShape)) {
            icariaPortalShape.createPortalBlocks();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(HORIZONTAL_AXIS);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if(!pEntity.isPassenger() && !pEntity.isVehicle() && pEntity.canChangeDimensions()) {
            if(pEntity.isOnPortalCooldown()) {
                pEntity.setPortalCooldown();
            } else {
                if(!pEntity.level.isClientSide && !pPos.equals(entrancePos)) {
                    entrancePos = pPos.immutable();
                }
                Level entityLevel = pEntity.level;
                MinecraftServer minecraftServer = entityLevel.getServer();
                ResourceKey<Level> destination = pEntity.level.dimension() == IcariaDimensions.ICARIA ? Level.OVERWORLD : IcariaDimensions.ICARIA;
                if(minecraftServer != null) {
                    ServerLevel destinationLevel = minecraftServer.getLevel(destination);
                    if(destinationLevel != null && !pEntity.isPassenger()) {
                        pEntity.level.getProfiler().push(this.getName().toString());
                        pEntity.setPortalCooldown();
                        pEntity.changeDimension(destinationLevel, new IcariaTeleporter(destinationLevel));
                        pEntity.level.getProfiler().pop();
                    }
                }
            }
        }
    }

    @Override
    public @Nonnull BlockState updateShape(BlockState pState, Direction pDirection, BlockState pFacingState, LevelAccessor pLevel, BlockPos pPos, BlockPos pFacingPos) {
        Direction.Axis direction$axis = pDirection.getAxis();
        Direction.Axis direction$axis1 = pState.getValue(HORIZONTAL_AXIS);
        boolean flag = direction$axis1 != direction$axis && direction$axis.isHorizontal();
        return !flag && !pFacingState.is(this) && !pFacingState.is(IcariaBlockTags.ICARIA_PORTAL_BLOCKS) && !(new IcariaPortalShape(pLevel, pPos, direction$axis1)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pFacingState, pLevel, pPos, pFacingPos);
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
    public @Nonnull VoxelShape getShape(BlockState pState, BlockGetter pGetter, BlockPos pPos, CollisionContext pContext) {
        switch (pState.getValue(HORIZONTAL_AXIS)) {
            case X:
                return X_AXIS_AABB;
            case Z:
            default:
                return Z_AXIS_AABB;
        }
    }
}
