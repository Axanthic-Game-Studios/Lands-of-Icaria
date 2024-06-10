package com.axanthic.icaria.common.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import net.neoforged.neoforge.common.util.DeferredSoundType;

public class IcariaSoundTypes {
	public static final SoundType ARISTONE = new DeferredSoundType(1.0F, 1.0F, () -> SoundEvents.GLASS_BREAK, () -> SoundEvents.SLIME_BLOCK_STEP, () -> SoundEvents.GLASS_PLACE, () -> SoundEvents.GLASS_HIT, () -> SoundEvents.SLIME_BLOCK_FALL);
	public static final SoundType BARREL = new DeferredSoundType(1.0F, 1.0F, () -> IcariaSoundEvents.BARREL_BREAK, () -> SoundEvents.WOOD_STEP, () -> SoundEvents.WOOD_PLACE, () -> SoundEvents.WOOD_HIT, () -> SoundEvents.WOOD_FALL);
	public static final SoundType VASE = new DeferredSoundType(1.0F, 1.0F, () -> IcariaSoundEvents.VASE_BREAK, () -> SoundEvents.GLASS_STEP, () -> SoundEvents.GLASS_PLACE, () -> SoundEvents.GLASS_HIT, () -> SoundEvents.GLASS_FALL);
}
