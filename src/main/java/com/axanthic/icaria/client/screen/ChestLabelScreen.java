package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.network.packet.ChestLabelPacket;
import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaDataComponents;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelScreen extends Screen {
	public int imageHeight;
	public int imageWidth;

	public Button cancel;
	public Button done;

	public EditBox editBox;

	public ItemStack itemStack;

	public ChestLabelScreen(ItemStack pItemStack) {
		super(Component.empty());
		this.imageHeight = 54;
		this.imageWidth = 176;
		this.itemStack = pItemStack;
	}

	public void cancel() {
		if (this.minecraft != null) {
			this.minecraft.setScreen(null);
		}
	}

	public void done() {
		if (this.minecraft != null) {
			this.minecraft.setScreen(null);
			ClientPacketDistributor.sendToServer(new ChestLabelPacket(this.itemStack, this.editBox.getValue()));
		}
	}

	@Override
	public void init() {
		this.cancel = this.addRenderableWidget(Button.builder(CommonComponents.GUI_CANCEL, (button) -> this.cancel()).bounds(this.width / 2 + 2, this.height / 2 + 64, 98, 20).build());
		this.done = this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, (button) -> this.done()).bounds(this.width / 2 - 100, this.height / 2 + 64, 98, 20).build());
		this.editBox = new EditBox(this.font, this.width / 2 - 35, this.height / 2 - 3, 196, 20, Component.translatable("screen" + "." + IcariaIdents.ID + "." + "chest_label"));
		this.editBox.setBordered(false);
		this.editBox.setMaxLength(12);
		this.editBox.setTextColor(IcariaColors.TEXT);
		this.editBox.setTextShadow(false);
		this.editBox.setValue(this.itemStack.getOrDefault(IcariaDataComponents.LABEL, ""));
		this.addWidget(this.editBox);
	}

	@Override
	public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
		super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
		this.editBox.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
	}

	@Override
	public void renderBackground(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
		var x = (this.width - this.imageWidth) / 2;
		var y = (this.height - this.imageHeight) / 2;
		this.renderTransparentBackground(pGuiGraphics);
		pGuiGraphics.blit(RenderPipelines.GUI_TEXTURED, IcariaResourceLocations.CHEST_LABEL, x, y, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
	}

	@Override
	public void setInitialFocus() {
		this.setInitialFocus(this.editBox);
	}
}
