package com.axanthic.loi.utils;

import com.axanthic.loi.ModInformation;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionSlowFalling extends Potion {
	public PotionSlowFalling() {
		super(false, 0x8CC6EC);
		this.setRegistryName(new ResourceLocation(ModInformation.ID, "slowfall"));
		this.setPotionName("effect.slowfall.name");
	}
	
	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
		if (entityLivingBaseIn.motionY < -0.5F) {
			entityLivingBaseIn.motionY = -0.5F;
		}

		entityLivingBaseIn.fallDistance = 0;
	}

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}