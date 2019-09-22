package com.axanthic.loi.gui;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.utils.TileEntityForge;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiInventoryForge extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation(ModInformation.ID, "textures/gui/crafting_forge_gui.png");
	private final InventoryPlayer playerInventory;
	private TileEntityForge tileEntity;

	public GuiInventoryForge(InventoryPlayer invPlayer, TileEntityForge tile) {
		super(new ContainerForge(invPlayer, tile));
		this.playerInventory = invPlayer;
		this.tileEntity = tile;
		xSize = 176;
		ySize = 207;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.tileEntity.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 0x504537);
		this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, 73, 0x504537);
	}

	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

		if (TileEntityFurnace.isBurning(this.tileEntity)) {
			int k = this.getBurnLeftScaled(13);
			this.drawTexturedModalRect(i + 57, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
		}

		int l = this.getCookProgressScaled(32);
		this.drawTexturedModalRect(i + 74, j + 34, 176, 14, l + 1, 16);
	}

	private int getCookProgressScaled(int pixels) {
		int i = this.tileEntity.getField(2);
		int j = this.tileEntity.getField(3);
		return j != 0 && i != 0 ? i * pixels / j : 0;
	}

	private int getBurnLeftScaled(int pixels) {
		int i = this.tileEntity.getField(1);

		if (i == 0) {
			i = 200;
		}

		return this.tileEntity.getField(0) * pixels / i;
	}
}