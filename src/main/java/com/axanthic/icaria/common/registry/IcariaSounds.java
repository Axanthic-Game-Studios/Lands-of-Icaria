package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import net.minecraftforge.common.util.ForgeSoundType;

public class IcariaSounds {
	public static final ResourceLocation SOUNDS_GRINDER_GRIND = new ResourceLocation(IcariaInfo.MODID, "block.grinder.grind");
	public static final ResourceLocation SOUNDS_VASE_BREAK = new ResourceLocation(IcariaInfo.MODID, "block.vase.break");

	public static final SoundEvent GRINDER_GRIND = SoundEvent.createVariableRangeEvent(SOUNDS_GRINDER_GRIND);
	public static final SoundEvent VASE_BREAK = SoundEvent.createVariableRangeEvent(SOUNDS_VASE_BREAK);

	public static final SoundType ARISTONE = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.GLASS_BREAK, () -> SoundEvents.SLIME_BLOCK_STEP, () -> SoundEvents.GLASS_PLACE, () -> SoundEvents.GLASS_HIT, () -> SoundEvents.SLIME_BLOCK_FALL);
	public static final SoundType VASE = new ForgeSoundType(1.0F, 1.0F, () -> VASE_BREAK, () -> SoundEvents.GLASS_STEP, () -> SoundEvents.GLASS_PLACE, () -> SoundEvents.GLASS_HIT, () -> SoundEvents.GLASS_FALL);
}
