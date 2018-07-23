package com.axanthic.blab.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.axanthic.blab.utils.TileEntityVase;

@SideOnly(Side.CLIENT)
public class GuiInventoryVase extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation("blab", "textures/gui/container_vase_gui.png");
    private final InventoryPlayer playerInventory;
	private TileEntityVase tileEntityVase;

	public GuiInventoryVase(InventoryPlayer invPlayer, TileEntityVase tile) {
		super(new ContainerVase(invPlayer, tile));
        this.playerInventory = invPlayer;
		tileEntityVase = tile;
		xSize = 176;
		ySize = 222;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int x, int y) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		fontRenderer.drawString(tileEntityVase.getDisplayName().getUnformattedText(), 8, 6, 0x504537);
		fontRenderer.drawString(playerInventory.getDisplayName().getUnformattedText(), 8, 128, 0x504537);
	}
}
