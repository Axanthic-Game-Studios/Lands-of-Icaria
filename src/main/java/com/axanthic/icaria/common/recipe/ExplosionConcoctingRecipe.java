package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ExplosionConcoctingRecipe implements Recipe<RecipeInput> {
	public float radius;

	public int colour;
	public int time;

	public Ingredient ingredient;

	public static final MapCodec<ExplosionConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("radius").forGetter(ExplosionConcoctingRecipe::radius),
			Codec.INT.fieldOf("colour").forGetter(ExplosionConcoctingRecipe::colour),
			Codec.INT.fieldOf("time").forGetter(ExplosionConcoctingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(ExplosionConcoctingRecipe::ingredient)
		).apply(instance, ExplosionConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ExplosionConcoctingRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.FLOAT, ExplosionConcoctingRecipe::radius,
		ByteBufCodecs.INT, ExplosionConcoctingRecipe::colour,
		ByteBufCodecs.INT, ExplosionConcoctingRecipe::time,
		Ingredient.CONTENTS_STREAM_CODEC, ExplosionConcoctingRecipe::ingredient,
		ExplosionConcoctingRecipe::new
	);

	public ExplosionConcoctingRecipe(float pRadius, int pColour, int pTime, Ingredient pIngredient) {
		this.radius = pRadius;
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient().getValues().size() < 3 ? this.ingredient().getValues().size() < 2 ? this.matchesSingle(pRecipeInput) : this.matchesDouble(pRecipeInput) : this.matchesTriple(pRecipeInput);
	}

	public boolean matchesSingle(RecipeInput pRecipeInput) {
		return this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesDouble(RecipeInput pRecipeInput) {
		return this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesTriple(RecipeInput pRecipeInput) {
		return this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(2).getItem();
	}

	@Override
	public boolean showNotification() {
		return false;
	}

	public float radius() {
		return this.radius;
	}

	public int colour() {
		return this.colour;
	}

	public int time() {
		return this.time;
	}

	public void performRecipe(BlockPos pBlockPos, Level pLevel) {
		pLevel.explode(null, pBlockPos.getX() + 0.5D, pBlockPos.getY() + 0.75D, pBlockPos.getZ() + 0.5D, this.radius(), Level.ExplosionInteraction.NONE);
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput) {
		return ItemStack.EMPTY;
	}

	public ItemStack result() {
		return ItemStack.EMPTY;
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient());
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.EXPLOSION_CONCOCTING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.EXPLOSION_CONCOCTING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.EXPLOSION_CONCOCTING.get();
	}

	@Override
	public String group() {
		return "";
	}
}
