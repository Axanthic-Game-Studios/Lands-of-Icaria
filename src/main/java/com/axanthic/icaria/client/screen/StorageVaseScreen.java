package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.menu.StorageVaseMenu;
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

public class StorageVaseScreen extends AbstractContainerScreen<StorageVaseMenu> {
	public StorageVaseScreen(StorageVaseMenu pMenu, Inventory pInventory, Component pComponent) {
		super(pMenu, pInventory, pComponent);
		this.imageHeight = 230;
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
		pGuiGraphics.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.STORAGE_VASE, x, y, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
	}

	@Override
	public void renderLabels(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY) {
		pGuiGraphics.drawString(this.font, this.title, (this.getXSize() / 2) - (this.font.width(this.title) / 2), 8, IcariaColors.TEXT, false);
		pGuiGraphics.drawString(this.font, this.playerInventoryTitle, 7, 134, IcariaColors.TEXT, false);
	}
}
