package com.axanthic.icaria.common.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelItem extends Item {
	public ChestLabelItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public boolean doesSneakBypassUse(ItemStack pStack, LevelReader pLevel, BlockPos pPos, Player pPlayer) {
		return true;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		var stack = pPlayer.getItemInHand(pUsedHand);
		if (stack.get(DataComponents.CUSTOM_NAME) != null && pPlayer.isShiftKeyDown()) {
			stack.remove(DataComponents.CUSTOM_NAME);
			pPlayer.playSound(SoundEvents.VILLAGER_WORK_CARTOGRAPHER);
			return InteractionResultHolder.success(stack);
		} else {
			return InteractionResultHolder.fail(stack);
		}
	}
}
