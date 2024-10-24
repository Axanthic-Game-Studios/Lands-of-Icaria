package com.axanthic.icaria.common.handler.item;

import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeOutputSlotItemHandler extends SlotItemHandler {
	public int removeCount;

	public ForgeBlockEntity blockEntity;

	public Player player;

	public ForgeOutputSlotItemHandler(IItemHandler pHandler, ForgeBlockEntity pBlockEntity, Player pPlayer, int pIndex, int pX, int pY) {
		super(pHandler, pIndex, pX, pY);
		this.blockEntity = pBlockEntity;
		this.player = pPlayer;
	}

	@Override
	public void checkTakeAchievements(ItemStack pStack) {
		pStack.onCraftedBy(this.player.level(), this.player, this.removeCount);
		if (this.player instanceof ServerPlayer serverPlayer) {
			this.blockEntity.awardUsedRecipesAndPopExperience(serverPlayer);
		}

		this.removeCount = 0;
	}

	@Override
	public void onQuickCraft(ItemStack pStack, int pAmount) {
		this.removeCount += pAmount;
		this.checkTakeAchievements(pStack);
	}

	@Override
	public void onTake(Player pPlayer, ItemStack pStack) {
		this.checkTakeAchievements(pStack);
		super.onTake(pPlayer, pStack);
	}

	@Override
	public ItemStack remove(int pAmount) {
		if (this.hasItem()) {
			this.removeCount += Math.min(pAmount, this.getItem().getCount());
		}

		return super.remove(pAmount);
	}
}
