package com.axanthic.icaria.common.registry;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.food.FoodProperties;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFoods {
	public static final FoodProperties SPELT_BREAD = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5F).build();
	public static final FoodProperties VINE_SPROUT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties VINEBERRIES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties STRAWBERRIES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties PHYSALIS = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties LAUREL_CHERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties BLACK_OLIVES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties GREEN_OLIVES = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties ONION = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties RAW_AETERNAE_MEAT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).build();
	public static final FoodProperties COOKED_AETERNAE_MEAT = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0F).build();
	public static final FoodProperties RAW_CAPELLA_MEAT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties COOKED_CAPELLA_MEAT = new FoodProperties.Builder().nutrition(7).saturationModifier(1.0F).build();
	public static final FoodProperties RAW_CATOBLEPAS_MEAT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties COOKED_CATOBLEPAS_MEAT = new FoodProperties.Builder().nutrition(7).saturationModifier(1.0F).build();
	public static final FoodProperties RAW_CERVER_MEAT = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5F).build();
	public static final FoodProperties COOKED_CERVER_MEAT = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0F).build();
	public static final FoodProperties RAW_CROCOTTA_MEAT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties COOKED_CROCOTTA_MEAT = new FoodProperties.Builder().nutrition(7).saturationModifier(1.0F).build();
	public static final FoodProperties RAW_SOW_MEAT = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties COOKED_SOW_MEAT = new FoodProperties.Builder().nutrition(7).saturationModifier(1.0F).build();
	public static final FoodProperties SNULL_CREAM = new FoodProperties.Builder().nutrition(2).saturationModifier(0.5F).build();
	public static final FoodProperties FRUIT_SALAD = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0F).build();
	public static final FoodProperties ONION_SOUP = new FoodProperties.Builder().nutrition(4).saturationModifier(1.0F).build();
	public static final FoodProperties AETERNAE_STEW = new FoodProperties.Builder().nutrition(9).saturationModifier(1.0F).build();
	public static final FoodProperties CATOBLEPAS_STEW = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0F).build();
	public static final FoodProperties CERVER_STEW = new FoodProperties.Builder().nutrition(9).saturationModifier(1.0F).build();
	public static final FoodProperties SOW_STEW = new FoodProperties.Builder().nutrition(8).saturationModifier(1.0F).build();
}
