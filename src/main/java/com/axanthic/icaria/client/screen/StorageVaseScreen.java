package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class StorageVaseScreen extends AbstractContainerScreen<StorageVaseMenu> {
	public StorageVaseScreen(StorageVaseMenu pMenu, Inventory pInventory, Component pComponent) {
		super(pMenu, pInventory, pComponent, 176, 230);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor pGuiGraphicsExtractor, int pMouseX, int pMouseY, float pPartialTicks) {
		super.extractBackground(pGuiGraphicsExtractor, pMouseX, pMouseY, pPartialTicks);
		var x = (this.width - this.imageWidth) / 2;
		var y = (this.height - this.imageHeight) / 2;
		pGuiGraphicsExtractor.blit(RenderPipelines.GUI_TEXTURED, IcariaIdentifiers.STORAGE_VASE, x, y, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
	}

	@Override
	public void extractLabels(GuiGraphicsExtractor pGuiGraphicsExtractor, int pMouseX, int pMouseY) {
		pGuiGraphicsExtractor.text(this.font, this.title, (this.getImageWidth() / 2) - (this.getFont().width(this.title) / 2), 8, IcariaColors.TEXT, false);
		pGuiGraphicsExtractor.text(this.font, this.playerInventoryTitle, 7, 134, IcariaColors.TEXT, false);
	}
}
