package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.menu.StorageVaseMenu;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

@OnlyIn(Dist.CLIENT)
public class StorageVaseScreen extends AbstractContainerScreen<StorageVaseMenu> {
	public ResourceLocation SCREEN = new ResourceLocation(IcariaInfo.MODID, "textures/screens/storage_vase.png");
	public int imageHeight = 222;

	public StorageVaseScreen(StorageVaseMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
		super(pMenu, pPlayerInventory, pTitle);
	}

	@Override
	public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
		this.renderBackground(pPoseStack);
		super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
		this.renderTooltip(pPoseStack, pMouseX, pMouseY);
	}

	@Override
	public void renderLabels(PoseStack pPoseStack, int pMouseX, int pMouseY) {
		this.font.draw(pPoseStack, this.title, 7.0F, -22.0F, 5260599);
		this.font.draw(pPoseStack, this.playerInventoryTitle, 7.0F, 100.0F, 5260599);
	}

	@Override
	public void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
		RenderSystem.setShaderTexture(0, SCREEN);
		int relX = (this.width - this.imageWidth) / 2;
		int relY = (this.height - this.imageHeight) / 2;
		this.blit(pPoseStack, relX, relY, 0, 0, this.imageWidth, this.imageHeight);
	}
}
