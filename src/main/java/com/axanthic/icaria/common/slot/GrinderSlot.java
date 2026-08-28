package com.axanthic.icaria.common.slot;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.transfer.IndexModifier;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderSlot extends ResourceHandlerSlot {
	public GrinderBlockEntity blockEntity;

	public Player player;

	public GrinderSlot(@Nullable GrinderBlockEntity pBlockEntity, @Nullable Player pPlayer, ResourceHandler<ItemResource> pResourceHandler, IndexModifier<ItemResource> pIndexModifier, int pIndex, int pX, int pY) {
		super(pResourceHandler, pIndexModifier, pIndex, pX, pY);
		this.setBlockEntity(pBlockEntity);
		this.setPlayer(pPlayer);
	}

	@Override
	public void checkTakeAchievements(ItemStack pItemStack) {
		if (this.getPlayer() instanceof ServerPlayer serverPlayer) {
			this.getBlockEntity().awardAndClear(serverPlayer.blockPosition(), serverPlayer.level());
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

	public void setBlockEntity(@Nullable GrinderBlockEntity pBlockEntity) {
		this.blockEntity = pBlockEntity;
	}

	public void setPlayer(@Nullable Player pPlayer) {
		this.player = pPlayer;
	}

	public GrinderBlockEntity getBlockEntity() {
		return this.blockEntity;
	}

	public Player getPlayer() {
		return this.player;
	}
}
