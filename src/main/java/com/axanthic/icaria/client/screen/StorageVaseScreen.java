package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.menu.StorageVaseMenu;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class StorageVaseScreen extends AbstractContainerScreen<StorageVaseMenu> {
	public StorageVaseScreen(StorageVaseMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		this.imageHeight = 222;
		this.imageWidth = 176;
	}

	@Override
	public void render(GuiGraphics pGraphics, int pMouseX, int pMouseY, float pPartialTick) {
		this.renderBackground(pGraphics);
		super.render(pGraphics, pMouseX, pMouseY, pPartialTick);
		this.renderTooltip(pGraphics, pMouseX, pMouseY);
	}

	@Override
	public void renderBg(GuiGraphics pGraphics, float pPartialTick, int pMouseX, int pMouseY) {
		int x = (this.width - this.imageWidth) / 2;
		int y = (this.height - this.imageHeight) / 2;
		pGraphics.blit(IcariaResourceLocations.STORAGE_VASE, x, y, 0, 0, this.imageWidth, this.imageHeight);

	}

	@Override
	public void renderLabels(GuiGraphics pGraphics, int pMouseX, int pMouseY) {
		pGraphics.drawString(this.font, this.title, 7, 6, 5260599, false);
		pGraphics.drawString(this.font, this.playerInventoryTitle, 7, 128, 5260599, false);
	}
}
