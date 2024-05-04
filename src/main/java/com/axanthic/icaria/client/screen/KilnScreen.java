package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.menu.KilnMenu;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.util.IcariaColors;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class KilnScreen extends AbstractContainerScreen<KilnMenu> {
	public KilnScreen(KilnMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		this.imageHeight = 176;
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
		pGraphics.blit(IcariaResourceLocations.KILN, x, y, 0, 0, this.imageWidth, this.imageHeight);
		this.renderFuel(pGraphics, x, y);
		this.renderProgress(pGraphics, x, y);
	}

	@Override
	public void renderLabels(GuiGraphics pGraphics, int pMouseX, int pMouseY) {
		pGraphics.drawString(this.font, this.title, (this.getXSize() / 2) - (this.font.width(this.title) / 2), 8, IcariaColors.TEXT, false);
		pGraphics.drawString(this.font, this.playerInventoryTitle, 7, 80, IcariaColors.TEXT, false);
	}

	public void renderFuel(GuiGraphics pGraphics, int pX, int pY) {
		int fuel = this.menu.getFuel();
		int heightFuel = 14;
		int maxFuel = this.menu.getMaxFuel();
		if (maxFuel != 0) {
			int height = fuel * heightFuel / maxFuel;
			pGraphics.blit(IcariaResourceLocations.KILN, pX + 48, pY + 41 + heightFuel - height, this.imageWidth, 16 + heightFuel - height, 9, height);
		}
	}

	public void renderProgress(GuiGraphics pGraphics, int pX, int pY) {
		int maxProgress = this.menu.getMaxProgress();
		int progress = this.menu.getProgress();
		int widthProgress = 22;
		if (maxProgress != 0) {
			int width = widthProgress * progress / maxProgress;
			pGraphics.blit(IcariaResourceLocations.KILN, pX + 73, pY + 40, this.imageWidth, 0, width, 16);
		}
	}
}
