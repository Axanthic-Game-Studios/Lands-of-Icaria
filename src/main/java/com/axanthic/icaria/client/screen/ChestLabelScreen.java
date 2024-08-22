package com.axanthic.icaria.client.screen;

import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaDataComponents;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.GameNarrator;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelScreen extends Screen {
	public Button cancelButton;
	public Button doneButton;

	public EditBox box;

	public ItemStack stack;

	public ChestLabelScreen(ItemStack pStack) {
		super(GameNarrator.NO_TITLE);
		this.stack = pStack;
	}

	public void cancel() {
		this.minecraft.setScreen(null);
	}

	public void done() {
		this.stack.set(IcariaDataComponents.LABEL, this.box.getValue());
		this.minecraft.setScreen(null);
	}

	@Override
	public void init() {
		this.cancelButton = this.addRenderableWidget(Button.builder(CommonComponents.GUI_CANCEL, p_98157_ -> this.cancel()).bounds(this.width / 2 + 2, this.height / 2 + 64, 98, 20).build());
		this.doneButton = this.addRenderableWidget(Button.builder(CommonComponents.GUI_DONE, p_280852_ -> this.done()).bounds(this.width / 2 - 100, this.height / 2 + 64, 98, 20).build());
		this.box = new EditBox(this.font, this.width / 2 - 35, this.height / 2 - 3, 200, 20, Component.translatable("screen" + "." + IcariaIdents.ID + "." + "chest_label"));
		this.box.setBordered(false);
		this.box.setMaxLength(12);
		this.box.setTextColor(IcariaColors.TEXT);
		this.box.setTextShadow(false);
		this.box.setValue(this.stack.getOrDefault(IcariaDataComponents.LABEL, ""));
		this.addWidget(this.box);
	}

	@Override
	public void render(GuiGraphics pGraphics, int pMouseX, int pMouseY, float pPartialTick) {
		super.render(pGraphics, pMouseX, pMouseY, pPartialTick);
		this.box.render(pGraphics, pMouseX, pMouseY, pPartialTick);
	}

	@Override
	public void renderBackground(GuiGraphics pGraphics, int pMouseX, int pMouseY, float pPartialTick) {
		int x = (this.width - 216) / 2;
		int y = (this.height - 80) / 2;
		this.renderTransparentBackground(pGraphics);
		pGraphics.blit(IcariaResourceLocations.CHEST_LABEL, x, y, 0, 0, 216, 80);
	}

	@Override
	public void setInitialFocus() {
		this.setInitialFocus(this.box);
	}
}
