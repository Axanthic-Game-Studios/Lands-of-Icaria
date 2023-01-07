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
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;

public class GrinderRecipe implements Recipe<SimpleContainer> {
	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;
	private final Ingredient gear;
	private final int burnTime;

	public GrinderRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems,
			Ingredient gear,int burnTime) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
		this.gear = gear;
		this.burnTime = burnTime;
	}
	
	public int getBurnTime() {
		return burnTime;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		if (pLevel.isClientSide)
			return false;

		if (gear.test(pContainer.getItem(2))) {
			return recipeItems.get(0).test(pContainer.getItem(0));
		} else
			return false;
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return output.copy();
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

	public static class Type implements RecipeType<GrinderRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "grinder";
	}

	public static class Serializer implements RecipeSerializer<GrinderRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation(IcariaInfo.MODID, "grinder");

		@Override
		public GrinderRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
			Ingredient gear = Ingredient.fromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "gear"));
			int burnTime = pSerializedRecipe.get("burnTime").getAsInt();

			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}

			return new GrinderRecipe(pRecipeId, output, inputs, gear,burnTime);
		}

		@Override
		public @Nullable GrinderRecipe fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
			Ingredient gear = Ingredient.fromNetwork(pBuffer);
			int burnTime = pBuffer.readInt();

			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(pBuffer));
			}

			ItemStack output = pBuffer.readItem();

			return new GrinderRecipe(pRecipeId, output, inputs, gear,burnTime);
		}

		@Override
		public void toNetwork(FriendlyByteBuf pBuffer, GrinderRecipe pRecipe) {

			pBuffer.writeInt(pRecipe.getIngredients().size());
			pRecipe.gear.toNetwork(pBuffer);
			pBuffer.writeInt(pRecipe.burnTime);

			for (Ingredient ing : pRecipe.getIngredients()) {
				ing.toNetwork(pBuffer);
			}

			pBuffer.writeItemStack(pRecipe.getResultItem(), false);

		}
	}

}
