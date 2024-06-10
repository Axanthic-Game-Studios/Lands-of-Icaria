package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireBlock extends Block {
    public static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D);

    public GreekFireBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.AGE_15, 0));
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        var belowPos = pPos.below();
        return pLevel.getBlockState(belowPos).isFaceSturdy(pLevel, belowPos, Direction.UP);
    }

    public boolean isNearRain(Level pLevel, BlockPos pPos) {
        return pLevel.isRainingAt(pPos) || pLevel.isRainingAt(pPos.west()) || pLevel.isRainingAt(pPos.east()) || pLevel.isRainingAt(pPos.north()) || pLevel.isRainingAt(pPos.south());
    }

    public int getFireTickDelay(RandomSource pRandom) {
        return pRandom.nextInt(10) + 30;
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextInt(24) == 0) {
            pLevel.playLocalSound(pPos.getX() + 0.5D, pPos.getY() + 0.5D, pPos.getZ() + 0.5D, SoundEvents.FIRE_AMBIENT, SoundSource.BLOCKS, pRandom.nextFloat() + 1.0F, pRandom.nextFloat() * 0.7F + 0.3F, false);
        }

        for (int i = 0; i < 3; ++i) {
            pLevel.addParticle(ParticleTypes.LARGE_SMOKE, pPos.getX() + pRandom.nextDouble(), pPos.getY() + pRandom.nextDouble() * 0.5D + 0.5D, pPos.getZ() + pRandom.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(BlockStateProperties.AGE_15);
    }

    @Override
    public void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity) {
        super.entityInside(pState, pLevel, pPos, pEntity);
        if (!pEntity.fireImmune()) {
            pEntity.setRemainingFireTicks(pEntity.getRemainingFireTicks() + 1);
            if (pEntity.getRemainingFireTicks() == 0) {
                pEntity.setSecondsOnFire(8);
            }
        }

        pEntity.hurt(pLevel.damageSources().inFire(), 1.5F);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        super.onPlace(pState, pLevel, pPos, pOldState, pIsMoving);
        pLevel.scheduleTick(pPos, this, this.getFireTickDelay(pLevel.random));
    }

    @Override
    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
        if (!pLevel.isClientSide()) {
            pLevel.levelEvent(null, 1009, pPos, 0);
        }
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        pLevel.scheduleTick(pPos, this, this.getFireTickDelay(pLevel.random));
        if (pLevel.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = pState.getValue(BlockStateProperties.AGE_15);
            if (pLevel.isRaining() && this.isNearRain(pLevel, pPos) && pRandom.nextFloat() < 0.2F + i * 0.03F) {
                pLevel.removeBlock(pPos, false);
            } else {
                int j = Math.min(15, i + pRandom.nextInt(3) / 2);
                if (i != j) {
                    pLevel.setBlock(pPos, pState.setValue(BlockStateProperties.AGE_15, j), 4);
                }

                if (i > 3) {
                    pLevel.removeBlock(pPos, false);
                }
            }
        }
    }

    public BlockState getStateWithAge(int pAge) {
        var blockState = IcariaBlocks.GREEK_FIRE.get().defaultBlockState();
        return blockState.is(IcariaBlocks.GREEK_FIRE.get()) ? blockState.setValue(BlockStateProperties.AGE_15, pAge) : blockState;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return this.canSurvive(pState, pLevel, pCurrentPos) ? this.getStateWithAge(pState.getValue(BlockStateProperties.AGE_15)) : Blocks.AIR.defaultBlockState();
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return GreekFireBlock.SHAPE;
    }
}
