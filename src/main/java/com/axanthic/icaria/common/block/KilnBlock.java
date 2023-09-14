package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.KilnBlockEntity;
import com.axanthic.icaria.common.entity.KilnRedirectorBlockEntity;
import com.axanthic.icaria.common.menu.provider.KilnMenuProvider;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault

public class KilnBlock extends BaseEntityBlock {
    public KilnBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER).setValue(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH).setValue(BlockStateProperties.LIT, false));
    }

    @Override
    public boolean canDropFromExplosion(BlockState pState, BlockGetter pLevel, BlockPos pPos, Explosion pExplosion) {
        return pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER;
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        var blockPos = pPos.below();
        var blockState = pLevel.getBlockState(blockPos);
        return pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER ? blockState.isFaceSturdy(pLevel, blockPos, Direction.UP) : blockState.is(this);
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return (pLevel.getBlockEntity(pPos) instanceof KilnBlockEntity blockEntity) ? blockEntity.getComparatorInput() : 0;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pState.getValue(BlockStateProperties.LIT)) {
            if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
                var randomSource = pLevel.getRandom();
                pLevel.addParticle(ParticleTypes.SMALL_FLAME, pPos.getX() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), pPos.getY() + 0.25D, pPos.getZ() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), pPos.getY() + 0.75D, pPos.getZ() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                if (IcariaConfig.KILN_SOUNDS.get()) {
                    if (pRandom.nextDouble() < 0.5D) {
                        pLevel.playLocalSound(pPos.getX() + 0.5D, pPos.getY(), pPos.getZ() + 0.5D, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F, false);
                    }
                }
            } else if (IcariaConfig.RENDER_KILN_ITEMS.get()) {
                var randomSource = pLevel.getRandom();
                pLevel.addParticle(ParticleTypes.LARGE_SMOKE, pPos.getX() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), pPos.getY() + 1.0D, pPos.getZ() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
                pLevel.addParticle(ParticleTypes.SMOKE, pPos.getX() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), pPos.getY() + 1.0D, pPos.getZ() + 0.5D + randomSource.nextDouble() / 8.0D * (randomSource.nextBoolean() ? 1 : -1), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.DOUBLE_BLOCK_HALF, BlockStateProperties.HORIZONTAL_FACING, BlockStateProperties.LIT);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            if (pLevel.getBlockEntity(pPos) instanceof KilnBlockEntity blockEntity) {
                if (pLevel instanceof ServerLevel serverLevel) {
                    blockEntity.drops(serverLevel);
                    blockEntity.getRecipesToAwardAndPopExperience(serverLevel, Vec3.atCenterOf(pPos));
                }
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            pLevel.setBlock(pPos.above(), Blocks.AIR.defaultBlockState(), 3);
        } else {
            pLevel.setBlock(pPos.below(), Blocks.AIR.defaultBlockState(), 3);
        }
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        pLevel.setBlock(pPos.above(), pState.setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER), 3);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            return new KilnBlockEntity(pPos, pState);
        } else {
            return new KilnRedirectorBlockEntity(pPos, pState);
        }
    }

    public static BlockPos getBlockEntityPosition(BlockState pState, BlockPos pPos) {
        if (pState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF) == DoubleBlockHalf.LOWER) {
            return pPos;
        } else {
            return pPos.below();
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        var blockPos = pContext.getClickedPos();
        var level = pContext.getLevel();
        if (blockPos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockPos.above()).canBeReplaced(pContext)) {
            return this.defaultBlockState().setValue(BlockStateProperties.HORIZONTAL_FACING, pContext.getHorizontalDirection().getOpposite());
        } else {
            return null;
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        var blockEntityPosition = KilnBlock.getBlockEntityPosition(pState, pPos);
        var blockEntity = pLevel.getBlockEntity(blockEntityPosition);
        if (!pLevel.isClientSide()) {
            if (pPlayer instanceof ServerPlayer serverPlayer) {
                if (blockEntity instanceof KilnBlockEntity || blockEntity instanceof KilnRedirectorBlockEntity) {
                    NetworkHooks.openScreen(serverPlayer, new KilnMenuProvider(blockEntityPosition), blockEntityPosition);
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
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return !pLevel.isClientSide ? BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.KILN.get(), KilnBlockEntity::tick) : null;
    }
}
