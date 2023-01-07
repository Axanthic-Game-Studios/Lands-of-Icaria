package com.axanthic.icaria.common.recipe;

import org.jetbrains.annotations.Nullable;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public class GrinderFuelRecipe implements Recipe<SimpleContainer> {
	private final ResourceLocation id;
	private final NonNullList<Ingredient> recipeItems;
	private final int burnTime;

	public GrinderFuelRecipe(ResourceLocation id, NonNullList<Ingredient> recipeItems, int burnTime) {
		this.id = id;
		this.recipeItems = recipeItems;
		this.burnTime = burnTime;
	}

	public int getBurnTime() {
		return burnTime;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		if (pLevel.isClientSide)
			return false;

		return recipeItems.get(0).test(pContainer.getItem(0));
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer) {
		return ItemStack.EMPTY;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return ItemStack.EMPTY;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	public static class Type implements RecipeType<GrinderFuelRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "grinder_fuel";
	}

	public static class Serializer implements RecipeSerializer<GrinderFuelRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation(IcariaInfo.MODID, "grinder_fuel");

		@Override
		public GrinderFuelRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
			int burnTime = pSerializedRecipe.get("burnTime").getAsInt();

			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}

			return new GrinderFuelRecipe(pRecipeId, inputs, burnTime);
		}

		@Override
		public @Nullable GrinderFuelRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
			int burnTime = pBuffer.readInt();

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(pBuffer));
			}

			return new GrinderFuelRecipe(pRecipeId, inputs, burnTime);
		}

		@Override
		public void toNetwork(FriendlyByteBuf pBuffer, GrinderFuelRecipe pRecipe) {

			pBuffer.writeInt(pRecipe.getIngredients().size());
			pBuffer.writeInt(pRecipe.burnTime);

			for (Ingredient ing : pRecipe.getIngredients()) {
				ing.toNetwork(pBuffer);
			}

			pBuffer.writeItemStack(pRecipe.getResultItem(), false);

		}
	}

}
