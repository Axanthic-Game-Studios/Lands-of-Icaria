package com.axanthic.icaria.client.util;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import net.minecraftforge.common.util.ForgeSoundType;

public class IcariaSounds {
	public static ResourceLocation SOUND_CERAMIC_BREAK = new ResourceLocation(IcariaInfo.MODID, "block.ceramic.break");

	public static SoundEvent CERAMIC_BREAK = new SoundEvent(SOUND_CERAMIC_BREAK);

	public static SoundType ARISTONE = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.GLASS_BREAK, () -> SoundEvents.SLIME_BLOCK_STEP, () -> SoundEvents.GLASS_PLACE, () -> SoundEvents.GLASS_HIT, () -> SoundEvents.SLIME_BLOCK_FALL);
	public static SoundType CERAMIC = new ForgeSoundType(1.0F, 1.0F, () -> CERAMIC_BREAK, () -> SoundEvents.GLASS_STEP, () -> SoundEvents.GLASS_PLACE, () -> SoundEvents.GLASS_HIT, () -> SoundEvents.SLIME_BLOCK_FALL);
}
