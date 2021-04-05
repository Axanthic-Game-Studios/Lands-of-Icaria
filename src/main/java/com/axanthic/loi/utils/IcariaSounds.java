package com.axanthic.loi.utils;

import com.axanthic.loi.ModInformation;

import net.minecraft.block.SoundType;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class IcariaSounds {

	public static final ResourceLocation SOUND_SCORPION_IDLE = new ResourceLocation(ModInformation.ID, "entity.scorpion.idle");
	public static final SoundEvent SCORPION_IDLE = new SoundEvent(SOUND_SCORPION_IDLE).setRegistryName(SOUND_SCORPION_IDLE);
	public static final ResourceLocation SOUND_SCORPION_HURT = new ResourceLocation(ModInformation.ID, "entity.scorpion.hurt");
	public static final SoundEvent SCORPION_HURT = new SoundEvent(SOUND_SCORPION_HURT).setRegistryName(SOUND_SCORPION_HURT);
	public static final ResourceLocation SOUND_SCORPION_DEATH = new ResourceLocation(ModInformation.ID, "entity.scorpion.death");
	public static final SoundEvent SCORPION_DEATH = new SoundEvent(SOUND_SCORPION_DEATH).setRegistryName(SOUND_SCORPION_DEATH);
	public static final ResourceLocation SOUND_GRIND = new ResourceLocation(ModInformation.ID, "block.grinder.grind");
	public static final SoundEvent GRIND = new SoundEvent(SOUND_GRIND).setRegistryName(SOUND_GRIND);
	public static final ResourceLocation SOUND_CERAMIC_BREAK = new ResourceLocation(ModInformation.ID, "block.ceramic.break");
	public static final SoundEvent CERAMIC_BREAK = new SoundEvent(SOUND_CERAMIC_BREAK).setRegistryName(SOUND_CERAMIC_BREAK);

	public static final SoundType SILENCE = new SoundType(-10.0F, 1.0F, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL);
	public static final SoundType SLICK = new SoundType(1.0F, 1.0F, SoundEvents.BLOCK_GLASS_BREAK, SoundEvents.BLOCK_SLIME_PLACE, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_SLIME_FALL);
	public static final SoundType CERAMIC = new SoundType(1.0F, 1.0F, CERAMIC_BREAK, SoundEvents.BLOCK_GLASS_STEP, SoundEvents.BLOCK_GLASS_PLACE, SoundEvents.BLOCK_GLASS_HIT, SoundEvents.BLOCK_GLASS_FALL);

}
