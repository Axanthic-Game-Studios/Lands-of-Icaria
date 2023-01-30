package com.axanthic.icaria.common.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrindingRecipe implements Recipe<SimpleContainer> {
	public int burnTime;

	public Ingredient gear;

	public ItemStack result;

	public NonNullList<Ingredient> ingredients;

	public ResourceLocation id;

	public GrindingRecipe(ResourceLocation pId, ItemStack pResult, NonNullList<Ingredient> pIngredients, Ingredient pGear, int pBurnTime) {
		this.id = pId;
		this.result = pResult;
		this.ingredients = pIngredients;
		this.gear = pGear;
		this.burnTime = pBurnTime;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		if (!pLevel.isClientSide) {
			if (this.gear.test(pContainer.getItem(2))) {
				return this.ingredients.get(0).test(pContainer.getItem(0));
			}
		}

		return false;
	}

	public int getBurnTime() {
		return this.burnTime;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer) {
		return this.result.copy();
	}

	@Override
	public ItemStack getResultItem() {
		return this.result.copy();
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return this.ingredients;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public ResourceLocation getId() {
		return this.id;
	}

	public static class Serializer implements RecipeSerializer<GrindingRecipe> {
		public static final Serializer INSTANCE = new Serializer();

		@Override
		public GrindingRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
			int burnTime = pSerializedRecipe.get("burnTime").getAsInt();
			Ingredient gear = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "gear"));
			ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "result"));
			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}

			return new GrindingRecipe(pRecipeId, result, inputs, gear, burnTime);
		}

		@Override
		public GrindingRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			int burnTime = pBuffer.readInt();
			NonNullList<Ingredient> ingredients = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
			ItemStack result = pBuffer.readItem();
			Ingredient gear = Ingredient.fromNetwork(pBuffer);
			ingredients.replaceAll(pIngredient -> Ingredient.fromNetwork(pBuffer));
			return new GrindingRecipe(pRecipeId, result, ingredients, gear, burnTime);
		}

		@Override
		public void toNetwork(FriendlyByteBuf pBuffer, GrindingRecipe pRecipe) {
			pBuffer.writeInt(pRecipe.burnTime);
			pBuffer.writeInt(pRecipe.getIngredients().size());
			pBuffer.writeItemStack(pRecipe.getResultItem(), false);
			pRecipe.gear.toNetwork(pBuffer);
			for (Ingredient ingredient : pRecipe.getIngredients()) {
				ingredient.toNetwork(pBuffer);
			}
		}
	}

	public static class Type implements RecipeType<GrindingRecipe> {
		public static final Type INSTANCE = new Type();

		public Type() {

		}
	}
}
