package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderScreen extends AbstractContainerScreen<GrinderMenu> {
	public GrinderScreen(GrinderMenu pMenu, Inventory pInventory, Component pComponent) {
		super(pMenu, pInventory, pComponent, 176, 176);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor pGuiGraphicsExtractor, int pMouseX, int pMouseY, float pPartialTicks) {
		super.extractBackground(pGuiGraphicsExtractor, pMouseX, pMouseY, pPartialTicks);
		var x = (this.width - this.imageWidth) / 2;
		var y = (this.height - this.imageHeight) / 2;
		pGuiGraphicsExtractor.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.GRINDER, x, y, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
		this.extractFuel(pGuiGraphicsExtractor, x, y);
		this.extractProgress(pGuiGraphicsExtractor, x, y);
	}

	@Override
	public void extractLabels(GuiGraphicsExtractor pGuiGraphicsExtractor, int pMouseX, int pMouseY) {
		pGuiGraphicsExtractor.text(this.font, this.title, (this.imageWidth / 2) - (this.getFont().width(this.title) / 2), 8, IcariaColors.TEXT, false);
		pGuiGraphicsExtractor.text(this.font, this.playerInventoryTitle, 7, 80, IcariaColors.TEXT, false);
	}

	public void extractFuel(GuiGraphicsExtractor pGuiGraphicsExtractor, int pX, int pY) {
		var fuelHeight = 48;
		var fuel = this.menu.getFuel();
		var maxFuel = this.menu.getMaxFuel();
		if (maxFuel != 0) {
			var height = fuel * fuelHeight / maxFuel;
			pGuiGraphicsExtractor.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.GRINDER, 82 + pX, 24 + pY + height, this.imageWidth, 16 + height, 4, fuelHeight, 256, 256);
		}
	}

	public void extractProgress(GuiGraphicsExtractor pGuiGraphicsExtractor, int pX, int pY) {
		var progressWidth = 22;
		var progress = this.menu.getProgress();
		var maxProgress = this.menu.getMaxProgress();
		if (maxProgress != 0) {
			var width = progress * progressWidth / maxProgress;
			pGuiGraphicsExtractor.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.GRINDER, 95 + pX, 22 + pY, this.imageWidth, 0, width, 16, 256, 256);
		}
	}
}
