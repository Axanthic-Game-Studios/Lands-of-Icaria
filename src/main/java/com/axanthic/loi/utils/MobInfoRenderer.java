package com.axanthic.loi.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.text.DecimalFormat;

@SideOnly(Side.CLIENT)
public class MobInfoRenderer extends Gui {
	public ResourceLocation inventoryBackground;
	DecimalFormat format = new DecimalFormat("#.#");
	DecimalFormat round = new DecimalFormat("#");

	public MobInfoRenderer() {
		this.inventoryBackground = new ResourceLocation("textures/gui/container/inventory.png");
	}

	public void renderMobInfo(final Minecraft mc, final FontRenderer fontRenderer, final EntityLivingBase entity,
			final int x, final int y) {
		final int nameWidth = fontRenderer.getStringWidth(entity.getName());
		final int healthWidth = fontRenderer
				.getStringWidth(format.format(entity.getHealth()) + " / " + round.format(entity.getMaxHealth())) + 12;
		final int width = Math.max(nameWidth, healthWidth) + 14;
		final int height = 67;

		GlStateManager.pushMatrix();
		drawGradientRect(x, y, x + width, y + height - 13, 0, -16777216);
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		mc.renderEngine.bindTexture(MobInfoRenderer.ICONS);
		this.drawTexturedModalRect(x + 5, y + 17, 52, 0, 9, 9);
		mc.getTextureManager().bindTexture(this.inventoryBackground);
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		mc.renderEngine.bindTexture(MobInfoRenderer.ICONS);
		GlStateManager.scale(0.5f, 0.5f, 0.5f);
		GlStateManager.color(0.0f, 1.0f, 0.0f, 1.0f);
		GlStateManager.translate(x, y, 0.0f);
		this.drawTexturedModalRect(x + 10, y + 58, 18, 94, 18, 18);
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		mc.renderEngine.bindTexture(MobInfoRenderer.ICONS);
		GlStateManager.color(0.0f, 0.5f, 1.0f, 1.0f);
		this.drawTexturedModalRect(x + 5, y + 42, 34, 9, 9, 9);
		GlStateManager.popMatrix();
	}

	public void renderHealthText(final EntityLivingBase entity, final int x, final int y) {
		if (entity.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH) != null) {
		final Minecraft mc = Minecraft.getMinecraft();
		final FontRenderer fontRenderer = mc.fontRenderer;
		fontRenderer.drawString(entity.getName(), x + 5, y + 5, 16777215);
		fontRenderer.drawString(format.format(entity.getHealth()) + " / " + round.format(entity.getMaxHealth()), x + 16,
				y + 17, 16777215);
		}
	}

	public void renderAttackText(final EntityLivingBase entity, final int x, final int y) {
		if (entity.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null) {
			double attack = entity.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
			final Minecraft mc = Minecraft.getMinecraft();
			final FontRenderer fontRenderer = mc.fontRenderer;
			fontRenderer.drawString(format.format(attack), x + 16, y + 30, 16777215);
		} else {
			final Minecraft mc = Minecraft.getMinecraft();
			final FontRenderer fontRenderer = mc.fontRenderer;
			fontRenderer.drawString("0", x + 16, y + 30, 16777215);
		}
	}

	public void renderDefenseText(final EntityLivingBase entity, final int x, final int y) {
		if (entity.getEntityAttribute(SharedMonsterAttributes.ARMOR) != null) {
			double defense = entity.getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue();
			final Minecraft mc = Minecraft.getMinecraft();
			final FontRenderer fontRenderer = mc.fontRenderer;
			fontRenderer.drawString(format.format(defense), x + 16, y + 43, 16777215);
		}
	}
}