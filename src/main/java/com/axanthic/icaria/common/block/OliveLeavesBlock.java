package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OliveLeavesBlock extends LeavesBlock {
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 2);

    public OliveLeavesBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, 7).setValue(PERSISTENT, false).setValue(STAGE, 0).setValue(WATERLOGGED, false));
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
    }

    @Override
    public void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DISTANCE, PERSISTENT, STAGE, WATERLOGGED);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
        if (pRandom.nextInt(100) == 0) {
            if (!pState.getValue(OliveLeavesBlock.PERSISTENT)) {
                if (pState.getValue(OliveLeavesBlock.STAGE) == 0) {
                    pLevel.setBlock(pPos, pState.setValue(OliveLeavesBlock.STAGE, 1), 2);
                } else if (pState.getValue(OliveLeavesBlock.STAGE) == 1) {
                    pLevel.setBlock(pPos, pState.setValue(OliveLeavesBlock.STAGE, 2), 2);
                }
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pState.getValue(OliveLeavesBlock.STAGE) == 1) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);
            pLevel.setBlock(pPos, this.defaultBlockState().setValue(OliveLeavesBlock.STAGE, 0), 0);
            Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.GREEN_OLIVES.get(), 1));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        } else if (pState.getValue(OliveLeavesBlock.STAGE) == 2) {
            pLevel.playSound(pPlayer, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);
            pLevel.setBlock(pPos, this.defaultBlockState().setValue(OliveLeavesBlock.STAGE, 0), 0);
            Block.popResource(pLevel, pPos, new ItemStack(IcariaItems.BLACK_OLIVES.get(), 1));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }

        return InteractionResult.PASS;
    }
}
