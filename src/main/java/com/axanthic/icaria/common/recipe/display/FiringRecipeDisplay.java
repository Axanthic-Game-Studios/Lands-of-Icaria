package com.axanthic.icaria.common.recipe.display;

import com.axanthic.icaria.common.registry.IcariaRecipeDisplays;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.crafting.display.RecipeDisplay;
import net.minecraft.world.item.crafting.display.SlotDisplay;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FiringRecipeDisplay(SlotDisplay result, SlotDisplay craftingStation, SlotDisplay ingredient, SlotDisplay fuel, int time, float experience) implements RecipeDisplay {

	public static final MapCodec<FiringRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			SlotDisplay.CODEC.fieldOf("result").forGetter(FiringRecipeDisplay::result),
			SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(FiringRecipeDisplay::craftingStation),
			SlotDisplay.CODEC.fieldOf("ingredient").forGetter(FiringRecipeDisplay::ingredient),
			SlotDisplay.CODEC.fieldOf("fuel").forGetter(FiringRecipeDisplay::fuel),
			Codec.INT.fieldOf("time").forGetter(FiringRecipeDisplay::time),
			Codec.FLOAT.fieldOf("experience").forGetter(FiringRecipeDisplay::experience)
		).apply(instance, FiringRecipeDisplay::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, FiringRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
		SlotDisplay.STREAM_CODEC,
		FiringRecipeDisplay::result,
		SlotDisplay.STREAM_CODEC,
		FiringRecipeDisplay::craftingStation,
		SlotDisplay.STREAM_CODEC,
		FiringRecipeDisplay::ingredient,
		SlotDisplay.STREAM_CODEC,
		FiringRecipeDisplay::fuel,
		ByteBufCodecs.VAR_INT,
		FiringRecipeDisplay::time,
		ByteBufCodecs.FLOAT,
		FiringRecipeDisplay::experience,
		FiringRecipeDisplay::new
	);

	@Override
	public boolean isEnabled(FeatureFlagSet pFeatureFlagSet) {
		return this.result().isEnabled(pFeatureFlagSet) && this.craftingStation().isEnabled(pFeatureFlagSet) && this.ingredient().isEnabled(pFeatureFlagSet) && this.fuel().isEnabled(pFeatureFlagSet);
	}

	@Override
	public RecipeDisplay.Type<FiringRecipeDisplay> type() {
		return IcariaRecipeDisplays.FIRING.get();
	}
}
