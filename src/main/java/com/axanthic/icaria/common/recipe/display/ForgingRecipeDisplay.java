package com.axanthic.icaria.common.recipe.display;

import com.axanthic.icaria.common.registry.IcariaRecipeDisplays;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ForgingRecipeDisplay(SlotDisplay result, SlotDisplay craftingStation, SlotDisplay ingredient, SlotDisplay ingredientB, SlotDisplay ingredientC, SlotDisplay fuel, int time, float experience) implements RecipeDisplay {

	public static final MapCodec<ForgingRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			SlotDisplay.CODEC.fieldOf("result").forGetter(ForgingRecipeDisplay::result),
			SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(ForgingRecipeDisplay::craftingStation),
			SlotDisplay.CODEC.fieldOf("ingredient").forGetter(ForgingRecipeDisplay::ingredient),
			SlotDisplay.CODEC.fieldOf("ingredientB").forGetter(ForgingRecipeDisplay::ingredientB),
			SlotDisplay.CODEC.fieldOf("ingredientC").forGetter(ForgingRecipeDisplay::ingredientC),
			SlotDisplay.CODEC.fieldOf("fuel").forGetter(ForgingRecipeDisplay::fuel),
			Codec.INT.fieldOf("time").forGetter(ForgingRecipeDisplay::time),
			Codec.FLOAT.fieldOf("experience").forGetter(ForgingRecipeDisplay::experience)
		).apply(instance, ForgingRecipeDisplay::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ForgingRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
		SlotDisplay.STREAM_CODEC,
		ForgingRecipeDisplay::result,
		SlotDisplay.STREAM_CODEC,
		ForgingRecipeDisplay::craftingStation,
		SlotDisplay.STREAM_CODEC,
		ForgingRecipeDisplay::ingredient,
		SlotDisplay.STREAM_CODEC,
		ForgingRecipeDisplay::ingredientB,
		SlotDisplay.STREAM_CODEC,
		ForgingRecipeDisplay::ingredientC,
		SlotDisplay.STREAM_CODEC,
		ForgingRecipeDisplay::fuel,
		ByteBufCodecs.INT,
		ForgingRecipeDisplay::time,
		ByteBufCodecs.FLOAT,
		ForgingRecipeDisplay::experience,
		ForgingRecipeDisplay::new
	);

	@Override
	public boolean isEnabled(FeatureFlagSet pFeatureFlagSet) {
		return this.result().isEnabled(pFeatureFlagSet) && this.craftingStation().isEnabled(pFeatureFlagSet) && this.ingredient().isEnabled(pFeatureFlagSet) && this.ingredientB().isEnabled(pFeatureFlagSet) && this.ingredientC().isEnabled(pFeatureFlagSet) && this.fuel().isEnabled(pFeatureFlagSet);
	}

	@Override
	public Type<ForgingRecipeDisplay> type() {
		return IcariaRecipeDisplays.FORGING.get();
	}
}
