package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.neoforge.common.SimpleTier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTiers {
	public static final SimpleTier CHERT = new SimpleTier(IcariaBlockTags.INCORRECT_FOR_CHERT_TOOL, 59, 2.0F, 0.0F, 15, () -> Ingredient.of(IcariaItems.CHERT.get()));
	public static final SimpleTier CHALKOS = new SimpleTier(IcariaBlockTags.INCORRECT_FOR_CHALKOS_TOOL, 174, 5.0F, 1.0F, 15, () -> Ingredient.of(IcariaItems.CHALKOS_INGOT.get()));
	public static final SimpleTier KASSITEROS = new SimpleTier(IcariaBlockTags.INCORRECT_FOR_KASSITEROS_TOOL, 234, 5.0F, 1.5F, 15, () -> Ingredient.of(IcariaItems.KASSITEROS_INGOT.get()));
	public static final SimpleTier ORICHALCUM = new SimpleTier(IcariaBlockTags.INCORRECT_FOR_ORICHALCUM_TOOL, 385, 6.0F, 2.0F, 19, () -> Ingredient.of(IcariaItems.ORICHALCUM_INGOT.get()));
	public static final SimpleTier VANADIUMSTEEL = new SimpleTier(IcariaBlockTags.INCORRECT_FOR_VANADIUMSTEEL_TOOL, 424, 4.0F, 3.0F, 11, () -> Ingredient.of(IcariaItems.VANADIUMSTEEL_INGOT.get()));
	public static final SimpleTier SIDEROS = new SimpleTier(IcariaBlockTags.INCORRECT_FOR_SIDEROS_TOOL, 528, 7.0F, 2.5F, 14, () -> Ingredient.of(IcariaItems.SIDEROS_INGOT.get()));
	public static final SimpleTier MOLYBDENUMSTEEL = new SimpleTier(IcariaBlockTags.INCORRECT_FOR_MOLYBDENUMSTEEL_TOOL, 673, 7.5F, 2.0F, 12, () -> Ingredient.of(IcariaItems.MOLYBDENUMSTEEL_INGOT.get()));
}
