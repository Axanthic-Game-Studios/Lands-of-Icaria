package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ItemConcoctingRecipe implements Recipe<RecipeInput> {
	public int colour;
	public int time;

	public Ingredient ingredient;

	public ItemStackTemplate result;

	public static final MapCodec<ItemConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.INT.fieldOf("colour").forGetter(ItemConcoctingRecipe::colour),
			Codec.INT.fieldOf("time").forGetter(ItemConcoctingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(ItemConcoctingRecipe::ingredient),
			ItemStackTemplate.CODEC.fieldOf("result").forGetter(ItemConcoctingRecipe::result)
		).apply(instance, ItemConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, ItemConcoctingRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT, ItemConcoctingRecipe::colour,
		ByteBufCodecs.INT, ItemConcoctingRecipe::time,
		Ingredient.CONTENTS_STREAM_CODEC, ItemConcoctingRecipe::ingredient,
		ItemStackTemplate.STREAM_CODEC, ItemConcoctingRecipe::result,
		ItemConcoctingRecipe::new
	);

	public ItemConcoctingRecipe(int pColour, int pTime, Ingredient pIngredient, ItemStackTemplate pResult) {
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.result = pResult;
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

	public int colour() {
		return this.colour;
	}

	public int time() {
		return this.time;
	}

	public void performRecipe(BlockPos pBlockPos, Level pLevel) {
		pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput) {
		return ItemStack.EMPTY;
	}

	public ItemStackTemplate result() {
		return this.result;
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient());
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.ITEM_CONCOCTING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.ITEM_CONCOCTING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.ITEM_CONCOCTING.get();
	}

	@Override
	public String group() {
		return "";
	}
}
