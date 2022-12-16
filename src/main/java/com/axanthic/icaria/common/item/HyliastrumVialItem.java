package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.entity.HyliasterEntity;
import com.axanthic.icaria.common.registry.IcariaEntities;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliastrumVialItem extends Item {
    public HyliastrumVialItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        BlockPos blockPos = pContext.getClickedPos();
        Direction direction = pContext.getClickedFace();
        ItemStack itemStack = pContext.getItemInHand();
        Level level = pContext.getLevel();
        Player player = pContext.getPlayer();
        BlockPos relative = blockPos.relative(direction);
        HyliasterEntity entity = IcariaEntities.HYLIASTER.get().create(level);

        if (!(level instanceof ServerLevel)) {
            level.playSound(player, blockPos, SoundEvents.BOTTLE_EMPTY, SoundSource.NEUTRAL, 1.0F, 1.0F);
            return InteractionResult.SUCCESS;
        } else {
            if (entity != null) {
                entity.moveTo(relative, 0.0F, 0.0F);
                entity.setSize(1, true);
                level.addFreshEntity(entity);
            }

            if (player != null) {
                if (itemStack.isEmpty()) {
                    player.setItemInHand(player.getUsedItemHand(), new ItemStack(IcariaItems.VIAL_EMPTY.get()));
                } else if (!player.getInventory().add(new ItemStack(IcariaItems.VIAL_EMPTY.get()))) {
                    player.drop(new ItemStack(IcariaItems.VIAL_EMPTY.get()), false);
                }
            }

            itemStack.shrink(1);

            return InteractionResult.CONSUME;
        }
    }
}
