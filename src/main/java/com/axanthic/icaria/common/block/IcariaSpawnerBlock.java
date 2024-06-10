package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockEntityTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSpawnerBlock extends BaseEntityBlock {
    public IcariaSpawnerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public int getExpDrop(BlockState pState, LevelReader pLevel, RandomSource pRandom, BlockPos pPos, int pFortune, int pSilktouch) {
        return pRandom.nextInt(15) + pRandom.nextInt(15) + 15;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new IcariaSpawnerBlockEntity(pPos, pState);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        var itemStack = pPlayer.getItemInHand(pHand);
        if (itemStack.getItem() instanceof SpawnEggItem spawnEggItem) {
            if (pLevel.getBlockEntity(pPos) instanceof IcariaSpawnerBlockEntity icariaSpawnerBlockEntity) {
                icariaSpawnerBlockEntity.setChanged();
                icariaSpawnerBlockEntity.setEntityId(spawnEggItem.getType(itemStack.getTag()), pLevel.getRandom());
                pLevel.gameEvent(pPlayer, GameEvent.BLOCK_CHANGE, pPos);
                pLevel.sendBlockUpdated(pPos, pState, pState, 3);
                if (!pPlayer.isCreative()) {
                    itemStack.shrink(1);
                }

                return InteractionResult.CONSUME;
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return BaseEntityBlock.createTickerHelper(pBlockEntityType, IcariaBlockEntityTypes.SPAWNER.get(), pLevel.isClientSide() ? IcariaSpawnerBlockEntity::clientTick : IcariaSpawnerBlockEntity::serverTick);
    }
}
