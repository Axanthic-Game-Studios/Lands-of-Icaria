package com.axanthic.icaria.client.screen;

import javax.annotation.ParametersAreNonnullByDefault;

import com.axanthic.icaria.common.menu.GrinderMenu;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@ParametersAreNonnullByDefault

@OnlyIn(Dist.CLIENT)
public class GrinderScreen extends AbstractContainerScreen<GrinderMenu> {
	public ResourceLocation SCREEN = new ResourceLocation(IcariaInfo.MODID, "textures/screens/grinder.png");

	public GrinderScreen(GrinderMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
		this.imageHeight = 173;
		this.imageWidth = 176;
	}

	@Override
	protected void init() {
		super.init();
	}

	@Override
	public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
		this.renderBackground(pPoseStack);
		super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
		this.renderTooltip(pPoseStack, pMouseX, pMouseY);
	}

	@Override
	public void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
		this.font.draw(pPoseStack, this.title, (this.getXSize() / 2) - (this.font.width(this.title) / 2), 6, 0x504537);
		this.font.draw(pPoseStack, this.playerInventoryTitle, 8, 78, 0x504537);
	}

	@Override
	public void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShaderTexture(0, SCREEN);
		int relX = (this.width - this.imageWidth) / 2;
		int relY = (this.height - this.imageHeight) / 2;
		this.blit(pPoseStack, relX, relY, 0, 0, this.imageWidth, this.imageHeight);

		renderProgresBar(pPoseStack, relX, relY);
		renderFullBar(pPoseStack, relX, relY);
	}

	public void renderProgresBar(PoseStack pPoseStack, int x, int y) {
		int progressArrowSize = 23;
		int progress = menu.getCurrentProgressTime();
		int maxProgress = menu.getTotalProgressTime(); // Max Progress

		if (maxProgress != 0) {

			int width = progress * progressArrowSize / maxProgress;

			blit(pPoseStack, x + 95, y + 21, 176, 0, width, 17);
		}
		return;

	}

	public void renderFullBar(PoseStack pPoseStack, int x, int y) {
		int fuelSize = 52;
		int fuel = menu.getCurrentFuelTime();
		int maxfuel = menu.getTotalFuelTime(); // Max Fuel

		if (maxfuel != 0) {

			int height = fuel * fuelSize / maxfuel;

			blit(pPoseStack, x + 85, y + 20 + (fuelSize - height), 176, 17 + (fuelSize - height), 4, height);
		}
		return;
	}

}
