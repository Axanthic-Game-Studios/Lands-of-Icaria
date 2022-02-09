package com.axanthic.landsoficaria.client.util;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

import net.minecraftforge.common.util.ForgeSoundType;

public class LandsOfIcariaSounds {
    public static final SoundType ARISTONE = new ForgeSoundType(1.0F, 1.0F, () -> SoundEvents.GLASS_BREAK, () -> SoundEvents.SLIME_BLOCK_STEP, () -> SoundEvents.GLASS_PLACE, () -> SoundEvents.GLASS_HIT, () -> SoundEvents.SLIME_BLOCK_FALL);
}
