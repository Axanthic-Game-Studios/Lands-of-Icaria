package com.axanthic.icaria.common.handler.item;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderOutputSlotItemHandler extends SlotItemHandler {
	public GrinderBlockEntity blockEntity;

	public Player player;

	public GrinderOutputSlotItemHandler(IItemHandler pItemHandler, GrinderBlockEntity pBlockEntity, Player pPlayer, int pIndex, int pX, int pY) {
		super(pItemHandler, pIndex, pX, pY);
		this.blockEntity = pBlockEntity;
		this.player = pPlayer;
	}

	@Override
	public void checkTakeAchievements(ItemStack pItemStack) {
		if (this.player instanceof ServerPlayer serverPlayer) {
			this.blockEntity.awardUsedRecipesAndPopExperience(serverPlayer);
		}
	}

	@Override
	public void onQuickCraft(ItemStack pItemStack, int pAmount) {
		this.checkTakeAchievements(pItemStack);
		this.setChanged();
	}

	@Override
	public void onTake(Player pPlayer, ItemStack pItemStack) {
		this.checkTakeAchievements(pItemStack);
		this.setChanged();
	}
}
