package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.client.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.menu.GrinderMenu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class GrinderScreen extends AbstractContainerScreen<GrinderMenu> {
	public GrinderScreen(GrinderMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		this.imageHeight = 173;
		this.imageWidth = 176;
	}

	@Override
	public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
		this.renderBackground(pPoseStack);
		super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
		this.renderTooltip(pPoseStack, pMouseX, pMouseY);
	}

	@Override
	public void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShaderTexture(0, IcariaResourceLocations.GRINDER);
		int x = (this.width - this.imageWidth) / 2;
		int y = (this.height - this.imageHeight) / 2;
		GuiComponent.blit(pPoseStack, x, y, 0, 0, this.imageWidth, this.imageHeight);
		this.renderFuel(pPoseStack, x, y);
		this.renderProgress(pPoseStack, x, y);
	}

	@Override
	public void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
		this.font.draw(pPoseStack, this.title, (this.getXSize() / 2.0F) - (this.font.width(this.title) / 2.0F), 6.0F, 5260599);
		this.font.draw(pPoseStack, this.playerInventoryTitle, 7.0F, 80.0F, 5260599);
	}

	public void renderFuel(PoseStack pPoseStack, int pX, int pY) {
		int heightFuel = 52;
		int fuel = this.menu.getFuel();
		int maxFuel = this.menu.getMaxFuel();
		if (maxFuel != 0) {
			int height = fuel * heightFuel / maxFuel;
			GuiComponent.blit(pPoseStack, pX + 85, pY + 20 + heightFuel - height, this.imageWidth, 17 + heightFuel - height, 4, height);
		}
	}

	public void renderProgress(PoseStack pPoseStack, int pX, int pY) {
		int widthProgress = 23;
		int progress = this.menu.getProgress();
		int maxProgress = this.menu.getMaxProgress();
		if (maxProgress != 0) {
			int width = progress * widthProgress / maxProgress;
			GuiComponent.blit(pPoseStack, pX + 95, pY + 21, this.imageWidth, 0, width, 17);
		}
	}
}
