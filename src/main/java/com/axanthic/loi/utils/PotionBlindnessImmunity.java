package com.axanthic.loi.utils;

import com.axanthic.loi.ModInformation;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionBlindnessImmunity extends Potion {
	public PotionBlindnessImmunity() {
		super(false, 0x8CC6EC);
		this.setRegistryName(new ResourceLocation(ModInformation.ID, "blindness_immunity"));
		this.setPotionName("effect.blindness_immunity.name");
	}
	
	@Override
	public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
		entityLivingBaseIn.removePotionEffect(MobEffects.BLINDNESS);
    }

	@Override
	public boolean isReady(int duration, int amplifier) {
		return true;
	}
}