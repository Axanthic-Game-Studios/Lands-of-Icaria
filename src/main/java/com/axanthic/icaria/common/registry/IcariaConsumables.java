package com.axanthic.icaria.common.registry;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConsumables {
	public static final Consumable ANTI_GRAVITY_FLASK = IcariaConsumables.consumable(false, 1.6F, ItemUseAnimation.DRINK, SoundEvents.GENERIC_DRINK, MobEffects.LEVITATION, 1.0F, 600);
	public static final Consumable FORTIFYING_FLASK = IcariaConsumables.consumable(false, 1.6F, ItemUseAnimation.DRINK, SoundEvents.GENERIC_DRINK, MobEffects.RESISTANCE, 1.0F, 600);
	public static final Consumable HEALING_FLASK = IcariaConsumables.consumable(false, 1.6F, ItemUseAnimation.DRINK, SoundEvents.GENERIC_DRINK, MobEffects.REGENERATION, 1.0F, 600);
	public static final Consumable VINE_SPROUT = IcariaConsumables.consumable(true, 0.4F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT);
	public static final Consumable RAW_AETERNAE_MEAT = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_CAPELLA_MEAT = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_CATOBLEPAS_MEAT = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_CERVER_MEAT = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_CROCOTTA_MEAT = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_THOG_MEAT = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BLUE_GRAY_FEESH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BROWN_FEESH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BROWN_ORANGE_FEESH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_PINK_RED_FEESH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_PURPLE_FEESH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_RED_FEESH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BLUE_RED_FICHE = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BROWN_CYAN_FICHE = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_GRAY_FICHE = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_GREEN_MAGENTA_FICHE = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_RED_FICHE = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_WHITE_YELLOW_FICHE = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BLUE_BROWN_FISSHH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BLUE_RED_FISSHH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BLUE_YELLOW_FISSHH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BROWN_FISSHH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_GREEN_MAGENTA_FISSHH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_PURPLE_YELLOW_FISSHH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BLUE_FYSH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_BLUE_PURPLE_FYSH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_GRAY_FYSH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_RAINBOW_FYSH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_RED_FYSH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable RAW_RED_YELLOW_FYSH = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable SNULL_CREAM = IcariaConsumables.consumable(true, 1.6F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.HUNGER, 0.5F, 200);
	public static final Consumable FRUIT_SALAD = IcariaConsumables.consumable(true, 0.4F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT, MobEffects.REGENERATION, 1.0F, 200);
	public static final Consumable ONION_SOUP = IcariaConsumables.consumable(true, 0.4F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT);
	public static final Consumable AETERNAE_STEW = IcariaConsumables.consumable(true, 0.4F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT);
	public static final Consumable CATOBLEPAS_STEW = IcariaConsumables.consumable(true, 0.4F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT);
	public static final Consumable CERVER_STEW = IcariaConsumables.consumable(true, 0.4F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT);
	public static final Consumable THOG_STEW = IcariaConsumables.consumable(true, 0.4F, ItemUseAnimation.EAT, SoundEvents.GENERIC_EAT);

	public static Consumable consumable(boolean pHasConsumeParticles, float pConsumeSeconds, ItemUseAnimation pItemUseAnimation, Holder<SoundEvent> pSoundEvent, Holder<MobEffect> pMobEffect, float pProbability, int pDuration) {
		return Consumable.builder().hasConsumeParticles(pHasConsumeParticles).consumeSeconds(pConsumeSeconds).animation(pItemUseAnimation).sound(pSoundEvent).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(pMobEffect, pDuration), pProbability)).build();
	}

	public static Consumable consumable(boolean pHasConsumeParticles, float pConsumeSeconds, ItemUseAnimation pItemUseAnimation, Holder<SoundEvent> pSoundEvent) {
		return Consumable.builder().hasConsumeParticles(pHasConsumeParticles).consumeSeconds(pConsumeSeconds).animation(pItemUseAnimation).sound(pSoundEvent).build();
	}
}
