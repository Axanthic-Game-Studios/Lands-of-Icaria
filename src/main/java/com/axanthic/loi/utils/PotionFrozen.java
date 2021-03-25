package com.axanthic.loi.utils;

import com.axanthic.loi.ModInformation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionFrozen extends Potion {

	public static final ResourceLocation ICON = new ResourceLocation(ModInformation.ID, "textures/gui/potion_icons/freezing.png");
	public static final ResourceLocation OVERLAY = new ResourceLocation(ModInformation.ID, "textures/gui/frozen_overlay.png");

	public PotionFrozen() {
		super(true, 0x7FDCFF);
		this.setRegistryName(new ResourceLocation(ModInformation.ID, "frozen"));
		this.setPotionName("effect.frozen.name");
		this.registerPotionAttributeModifier(SharedMonsterAttributes.MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160891", -10.0D, 0);
		this.registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "55FCED67-E92A-486E-9800-B47F202C4387", -10.0D, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderHUDEffect(int x, int y, PotionEffect effect, Minecraft mc, float alpha) {
		mc.renderEngine.bindTexture(ICON);
		Gui.drawModalRectWithCustomSizedTexture(x + 3, y + 3, 0, 0, 18, 18, 18, 18);
		mc.renderEngine.bindTexture(OVERLAY);
		ScaledResolution resolution = new ScaledResolution(mc);
		int width = resolution.getScaledWidth();
		int height = resolution.getScaledHeight();
		//GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		Gui.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, width, height, width, height);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void renderInventoryEffect(int x, int y, PotionEffect effect, Minecraft mc) {
		mc.renderEngine.bindTexture(ICON);
		Gui.drawModalRectWithCustomSizedTexture(x + 6, y + 7, 0, 0, 18, 18, 18, 18);
	}

	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		entityLivingBaseIn.motionY = -0.7;
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}

	@Override
	public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier) {
		super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);
		//double d3 = (double)((float)entityLivingBaseIn.posX + entityLivingBaseIn.world.rand.nextFloat());
		//double d4 = (double)((float)entityLivingBaseIn.posY + entityLivingBaseIn.world.rand.nextFloat());
		//double d5 = (double)((float)entityLivingBaseIn.posZ + entityLivingBaseIn.world.rand.nextFloat());
		//entityLivingBaseIn.world.spawnParticle(EnumParticleTypes.BLOCK_CRACK, d3, d4, d5, 0.0D, 0.0D, 0.0D, Block.getStateId(Blocks.ICE.getDefaultState()));
		if (entityLivingBaseIn instanceof EntityLiving) {
			((EntityLiving) entityLivingBaseIn).setNoAI(false);
		}
	}

	@Override
	public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier) {
		super.applyAttributesModifiersToEntity(entityLivingBaseIn, attributeMapIn, amplifier);
		if (entityLivingBaseIn instanceof EntityLiving) {
			((EntityLiving) entityLivingBaseIn).setNoAI(true);
		}
	}
}
