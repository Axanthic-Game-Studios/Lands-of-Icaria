package com.axanthic.icaria.common.block;

import com.axanthic.icaria.common.entity.LootVaseEntity;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.data.loot.IcariaVaseLoot;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("deprecation")

public class LootVaseBlock extends Block {
    public LootVaseBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (pLevel.isClientSide || !pPlayer.getMainHandItem().isEmpty() || !pPlayer.getOffhandItem().isEmpty() || pPlayer.isPassenger() || pPlayer.isVehicle()) {
            return InteractionResult.FAIL;
        } else {
            var lootVaseEntity = new LootVaseEntity(IcariaEntityTypes.LOOT_VASE.get(), pLevel, pState, pPos);
            lootVaseEntity.startRiding(pPlayer);
            pLevel.addFreshEntity(lootVaseEntity);
            pLevel.removeBlock(pPos, false);
            pPlayer.displayClientMessage(Component.translatable("message." + IcariaInfo.ID + ".loot_vase"), true);
            return InteractionResult.PASS;
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState pState, LootContext.Builder pBuilder) {
        var lootContext = pBuilder.withParameter(LootContextParams.BLOCK_STATE, pState).create(LootContextParamSets.BLOCK);
        var lootTable = lootContext.getLevel().getServer().getLootTables().get(IcariaVaseLoot.LOOT_VASE);
        return lootTable.getRandomItems(lootContext);
    }
}
