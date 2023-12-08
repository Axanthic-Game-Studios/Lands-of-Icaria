package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaDimensions;
import com.axanthic.icaria.common.util.IcariaPortalShape;
import com.axanthic.icaria.common.util.IcariaTeleporter;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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

    public static final VoxelShape SHAPE_X = Block.box(0.0D, 0.0D, 6.0D, 16.0D, 16.0D, 10.0D);
    public static final VoxelShape SHAPE_Z = Block.box(6.0D, 0.0D, 0.0D, 10.0D, 16.0D, 16.0D);

    public IcariaPortalBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.HORIZONTAL_AXIS, Direction.Axis.X));
    }

    @Override
    public boolean skipRendering(BlockState pState, BlockState pAdjacentBlockState, Direction pDirection) {
        if (pAdjacentBlockState.is(this)) {
            return true;
        }

        return super.skipRendering(pState, pAdjacentBlockState, pDirection);
    }

    public boolean spawnPortal(LevelAccessor pLevel, BlockPos pPos) {
        var portalShape = this.isPortal(pLevel, pPos);
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
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(100) == 0) {
            pLevel.playLocalSound(pPos.getX() + 0.5D, pPos.getY() + 0.5D, pPos.getZ() + 0.5D, SoundEvents.PORTAL_AMBIENT, SoundSource.BLOCKS, 0.5F, pRandom.nextFloat() * 0.4F + 0.8F, false);
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.HORIZONTAL_AXIS);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        if (!pEntity.isPassenger()) {
            if (!pEntity.isVehicle()) {
                if (pEntity.canChangeDimensions()) {
                    if (pEntity.isOnPortalCooldown()) {
                        pEntity.setPortalCooldown();
                    } else {
                        if (!pEntity.level().isClientSide()) {
                            if (!pPos.equals(entrancePos)) {
                                entrancePos = pPos.immutable();
                            }
                        }

                        var minecraftServer = pEntity.level().getServer();
                        if (minecraftServer != null) {
                            var serverLevel = minecraftServer.getLevel(pEntity.level().dimension() == IcariaDimensions.ICARIA ? Level.OVERWORLD : IcariaDimensions.ICARIA);
                            if (serverLevel != null && !pEntity.isPassenger()) {
                                pEntity.level().getProfiler().push(this.getName().toString());
                                pEntity.changeDimension(serverLevel, new IcariaTeleporter(serverLevel));
                                pEntity.setPortalCooldown();
                                pEntity.level().getProfiler().pop();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public @Nonnull BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        var axis = pDirection.getAxis();
        var horizontalAxis = pState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
        boolean flag = horizontalAxis != axis && axis.isHorizontal();
        return !flag && !pNeighborState.is(this) && !pNeighborState.is(IcariaBlockTags.ICARIA_PORTAL_BLOCKS) && !(new IcariaPortalShape(pLevel, pPos, horizontalAxis)).isComplete() ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    public IcariaPortalShape isPortal(LevelAccessor pLevel, BlockPos pPos) {
        var icariaPortalShapeX = new IcariaPortalShape(pLevel, pPos, Direction.Axis.X);
        if (icariaPortalShapeX.isValid() && icariaPortalShapeX.numPortalBlocks == 0) {
            return icariaPortalShapeX;
        } else {
            var icariaPortalShapeZ = new IcariaPortalShape(pLevel, pPos, Direction.Axis.Z);
            return icariaPortalShapeZ.isValid() && icariaPortalShapeZ.numPortalBlocks == 0 ? icariaPortalShapeZ : null;
        }
    }

    @Override
    public @Nonnull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return pState.getValue(BlockStateProperties.HORIZONTAL_AXIS) == Direction.Axis.X ? IcariaPortalBlock.SHAPE_X : IcariaPortalBlock.SHAPE_Z;
    }
}
