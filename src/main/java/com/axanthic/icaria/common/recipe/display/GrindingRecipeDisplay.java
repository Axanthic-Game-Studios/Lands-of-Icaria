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

public record GrindingRecipeDisplay(SlotDisplay result, SlotDisplay craftingStation, SlotDisplay ingredient, SlotDisplay gear, SlotDisplay fuel, int time, float experience) implements RecipeDisplay {

	public static final MapCodec<GrindingRecipeDisplay> MAP_CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			SlotDisplay.CODEC.fieldOf("result").forGetter(GrindingRecipeDisplay::result),
			SlotDisplay.CODEC.fieldOf("crafting_station").forGetter(GrindingRecipeDisplay::craftingStation),
			SlotDisplay.CODEC.fieldOf("ingredient").forGetter(GrindingRecipeDisplay::ingredient),
			SlotDisplay.CODEC.fieldOf("gear").forGetter(GrindingRecipeDisplay::gear),
			SlotDisplay.CODEC.fieldOf("fuel").forGetter(GrindingRecipeDisplay::fuel),
			Codec.INT.fieldOf("time").forGetter(GrindingRecipeDisplay::time),
			Codec.FLOAT.fieldOf("experience").forGetter(GrindingRecipeDisplay::experience)
		).apply(instance, GrindingRecipeDisplay::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, GrindingRecipeDisplay> STREAM_CODEC = StreamCodec.composite(
		SlotDisplay.STREAM_CODEC,
		GrindingRecipeDisplay::result,
		SlotDisplay.STREAM_CODEC,
		GrindingRecipeDisplay::craftingStation,
		SlotDisplay.STREAM_CODEC,
		GrindingRecipeDisplay::ingredient,
		SlotDisplay.STREAM_CODEC,
		GrindingRecipeDisplay::gear,
		SlotDisplay.STREAM_CODEC,
		GrindingRecipeDisplay::fuel,
		ByteBufCodecs.VAR_INT,
		GrindingRecipeDisplay::time,
		ByteBufCodecs.FLOAT,
		GrindingRecipeDisplay::experience,
		GrindingRecipeDisplay::new
	);

	@Override
	public boolean isEnabled(FeatureFlagSet pFeatureFlagSet) {
		return this.result().isEnabled(pFeatureFlagSet) && this.craftingStation().isEnabled(pFeatureFlagSet) && this.ingredient().isEnabled(pFeatureFlagSet) && this.gear().isEnabled(pFeatureFlagSet) && this.fuel().isEnabled(pFeatureFlagSet);
	}

	@Override
	public Type<GrindingRecipeDisplay> type() {
		return IcariaRecipeDisplays.GRINDING.get();
	}
}
