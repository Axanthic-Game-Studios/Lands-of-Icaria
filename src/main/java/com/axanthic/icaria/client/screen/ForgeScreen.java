package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.menu.ForgeMenu;
import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ForgeScreen extends AbstractContainerScreen<ForgeMenu> {
	public ForgeScreen(ForgeMenu pMenu, Inventory pInventory, Component pComponent) {
		super(pMenu, pInventory, pComponent);
		this.imageHeight = 176;
		this.imageWidth = 176;
	}

	@Override
	public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
		super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
		this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
	}

	@Override
	public void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
		var x = (this.width - this.imageWidth) / 2;
		var y = (this.height - this.imageHeight) / 2;
		pGuiGraphics.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.FORGE, x, y, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
		this.renderFuel(pGuiGraphics, x, y);
		this.renderProgress(pGuiGraphics, x, y);
	}

	@Override
	public void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
		pGuiGraphics.drawString(this.font, this.title, (this.getXSize() / 2) - (this.font.width(this.title) / 2), 8, IcariaColors.TEXT, false);
		pGuiGraphics.drawString(this.font, this.playerInventoryTitle, 7, 80, IcariaColors.TEXT, false);
	}

	public void renderFuel(GuiGraphics pGuiGraphics, int pX, int pY) {
		var fuelHeight = 14;
		var fuel = this.menu.getFuel();
		var maxFuel = this.menu.getMaxFuel();
		if (maxFuel != 0) {
			var height = fuel * fuelHeight / maxFuel;
			pGuiGraphics.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.FORGE, 53 + pX, 41 + pY + height, this.imageWidth, 16 + height, 16, fuelHeight, 256, 256);
		}
	}

	public void renderProgress(GuiGraphics pGuiGraphics, int pX, int pY) {
		var progressWidth = 22;
		var progress = this.menu.getProgress();
		var maxProgress = this.menu.getMaxProgress();
		if (maxProgress != 0) {
			var width = progress * progressWidth / maxProgress;
			pGuiGraphics.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.FORGE, 82 + pX, 40 + pY, this.imageWidth, 0, width, 16, 256, 256);
		}
	}
}
