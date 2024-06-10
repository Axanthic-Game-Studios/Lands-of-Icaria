package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.ForgeBlockEntity;
import com.axanthic.icaria.common.entity.ForgeRedirectorBlockEntity;
import com.axanthic.icaria.common.menu.provider.ForgeMenuProvider;
import com.axanthic.icaria.common.properties.Corner;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import net.neoforged.neoforge.network.NetworkHooks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeBlock extends BaseEntityBlock {
    public ForgeBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_LEFT).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.LIT, false));
    }

    @Override
    public boolean canDropFromExplosion(BlockState pState, BlockGetter pLevel, BlockPos pPos, Explosion pExplosion) {
        return false;
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    public double getFlameX(BlockState pState) {
        return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH -> 0.0D;
            case EAST, WEST -> 0.5D;
            default -> 1.0D;
        };
    }

    public double getFlameZ(BlockState pState) {
        return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH, SOUTH -> 0.5D;
            case EAST -> 0.0D;
            default -> 1.0D;
        };
    }

    public double getSmokeX(BlockState pState) {
        return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case NORTH, EAST -> 0.0D;
            default -> 1.0D;
        };
    }

    public double getSmokeZ(BlockState pState) {
        return switch (pState.getValue(BlockStateProperties.HORIZONTAL_FACING)) {
            case EAST, SOUTH -> 0.0D;
            default -> 1.0D;
        };
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return pLevel.getBlockEntity(ForgeBlock.getBlockEntityPosition(pState, pPos)) instanceof ForgeBlockEntity blockEntity ? blockEntity.getComparatorInput() : 0;
    }

    @Override
    public int getLightEmission(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.getValue(BlockStateProperties.LIT) ? 13 : 0;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(BlockStateProperties.LIT)) {
            if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_LEFT) {
                pLevel.addParticle(ParticleTypes.LARGE_SMOKE, pPos.getX() + this.getSmokeX(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 2.0D, pPos.getZ() + this.getSmokeZ(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + this.getSmokeX(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 2.0D, pPos.getZ() + this.getSmokeZ(pState) + pRandom.nextDouble() / 8.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                if (IcariaConfig.FORGE_SOUNDS.get() && pRandom.nextDouble() < 0.1D) {
                    pLevel.playLocalSound(pPos.getX() + this.getFlameX(pState), pPos.getY() + 1.0D, pPos.getZ() + this.getFlameZ(pState), SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                }

                if (IcariaConfig.RENDER_FORGE_ITEMS.get()) {
                    pLevel.addParticle(ParticleTypes.FLAME, pPos.getX() + this.getFlameX(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 0.25D, pPos.getZ() + this.getFlameZ(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                    pLevel.addParticle(ParticleTypes.SMALL_FLAME, pPos.getX() + this.getFlameX(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), pPos.getY() + 0.25D, pPos.getZ() + this.getFlameZ(pState) + pRandom.nextDouble() / 4.0D * (pRandom.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(IcariaBlockStateProperties.CORNER, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT);
    }

    @Override
    public void onBlockExploded(BlockState pState, Level pLevel, BlockPos pPos, Explosion pExplosion) {
        var blockPos = ForgeBlock.getBlockEntityPosition(pState, pPos);
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);

        if (pLevel.getBlockEntity(blockPos) instanceof ForgeBlockEntity) {
            pLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        }

        if (pLevel.getBlockEntity(ForgeBlock.getBlockEntityPosition(pState, blockPos)) == null) {
            pLevel.setBlock(blockPos.offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.offset(facing.getOpposite().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above(), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above().offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above().offset(facing.getOpposite().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above().offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
        }

        super.onBlockExploded(pState, pLevel, pPos, pExplosion);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMovedByPiston) {
        if (pState.getBlock() != pNewState.getBlock()) {
            if (pLevel.getBlockEntity(pPos) instanceof ForgeBlockEntity blockEntity) {
                if (pLevel instanceof ServerLevel serverLevel) {
                    blockEntity.drops(serverLevel);
                    blockEntity.getRecipesToAwardAndPopExperience(serverLevel, Vec3.atCenterOf(pPos));
                    Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.FORGE.get()));
                }
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        var blockPos = ForgeBlock.getBlockEntityPosition(pState, pPos);
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);

        if (pLevel.getBlockEntity(blockPos) instanceof ForgeBlockEntity) {
            pLevel.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
        }

        if (pLevel.getBlockEntity(ForgeBlock.getBlockEntityPosition(pState, blockPos)) == null) {
            pLevel.setBlock(blockPos.offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.offset(facing.getOpposite().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above(), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above().offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above().offset(facing.getOpposite().getNormal()), Blocks.AIR.defaultBlockState(), 3);
            pLevel.setBlock(blockPos.above().offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), Blocks.AIR.defaultBlockState(), 3);
        }

        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        pLevel.setBlock(pPos.offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_FRONT_RIGHT), 3);
        pLevel.setBlock(pPos.offset(facing.getOpposite().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_LEFT), 3);
        pLevel.setBlock(pPos.offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.BOTTOM_BACK_RIGHT), 3);
        pLevel.setBlock(pPos.above(), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_LEFT), 3);
        pLevel.setBlock(pPos.above().offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_FRONT_RIGHT), 3);
        pLevel.setBlock(pPos.above().offset(facing.getOpposite().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_LEFT), 3);
        pLevel.setBlock(pPos.above().offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal()), pState.setValue(IcariaBlockStateProperties.CORNER, Corner.TOP_BACK_RIGHT), 3);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_LEFT) {
            return new ForgeBlockEntity(pPos, pState);
        } else {
            return new ForgeRedirectorBlockEntity(pPos, pState);
        }
    }

    public static BlockPos getBlockEntityPosition(BlockState pState, BlockPos pPos) {
        var facing = pState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_BACK_RIGHT) {
            return pPos.below().offset(facing.getNormal()).offset(facing.getClockWise().getNormal());
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_BACK_LEFT) {
            return pPos.below().offset(facing.getNormal());
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_FRONT_RIGHT) {
            return pPos.below().offset(facing.getClockWise().getNormal());
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.TOP_FRONT_LEFT) {
            return pPos.below();
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_BACK_RIGHT) {
            return pPos.offset(facing.getNormal()).offset(facing.getClockWise().getNormal());
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_BACK_LEFT) {
            return pPos.offset(facing.getNormal());
        } else if (pState.getValue(IcariaBlockStateProperties.CORNER) == Corner.BOTTOM_FRONT_RIGHT) {
            return pPos.offset(facing.getClockWise().getNormal());
        } else {
            return pPos;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        var blockPos = pContext.getClickedPos();
        var facing = pContext.getHorizontalDirection().getOpposite();
        var level = pContext.getLevel();
        if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.offset(facing.getCounterClockWise().getNormal())).canBeReplaced(pContext) && level.getBlockState(blockPos.offset(facing.getOpposite().getNormal())).canBeReplaced(pContext) && level.getBlockState(blockPos.offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal())).canBeReplaced(pContext) && level.getBlockState(blockPos.above()).canBeReplaced(pContext) && level.getBlockState(blockPos.above().offset(facing.getCounterClockWise().getNormal())).canBeReplaced(pContext) && level.getBlockState(blockPos.above().offset(facing.getOpposite().getNormal())).canBeReplaced(pContext) && level.getBlockState(blockPos.above().offset(facing.getOpposite().getNormal()).offset(facing.getCounterClockWise().getNormal())).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection().getOpposite());
        } else {
            return null;
        }
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        var state = pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pMirror.mirror(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
        return pMirror == Mirror.NONE ? state : state.setValue(IcariaBlockStateProperties.CORNER, state.getValue(IcariaBlockStateProperties.CORNER).getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(BlockStateProperties.HORIZONTAL_FACING, pRotation.rotate(pState.getValue(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        var blockEntityPosition = ForgeBlock.getBlockEntityPosition(pState, pPos);
        var blockEntity = pLevel.getBlockEntity(blockEntityPosition);
        if (!pLevel.isClientSide()) {
            if (pPlayer instanceof ServerPlayer serverPlayer) {
                if (blockEntity instanceof ForgeBlockEntity || blockEntity instanceof ForgeRedirectorBlockEntity) {
                    NetworkHooks.openScreen(serverPlayer, new ForgeMenuProvider(blockEntityPosition), blockEntityPosition);
                }
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public VoxelShape getBlockSupportShape(BlockState pState, BlockGetter pReader, BlockPos pPos) {
        return Shapes.empty();
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return !pLevel.isClientSide() ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.FORGE.get(), ForgeBlockEntity::tick) : null;
    }
}
