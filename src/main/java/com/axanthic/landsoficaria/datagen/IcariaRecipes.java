package com.axanthic.landsoficaria.datagen;

import java.util.function.Consumer;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems;
import com.axanthic.landsoficaria.common.registry.LandsOfIcariaItems.DecoItemBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

public class IcariaRecipes extends RecipeProvider implements IConditionBuilder {

	public IcariaRecipes(DataGenerator gen) {
		super(gen);
	}

	@Override
	public String getName() {
		return LandsOfIcariaInfo.MODID;
	}

	@Override
	public void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		for (DecoItemBlockCombination deco : LandsOfIcariaItems.DECO_BLOCKS) {
			if (deco.SLAB != null) {
				ShapedRecipeBuilder.shaped(deco.SLAB.get(), 6)
				.pattern("XXX")
				.define('X', deco.originalItem.get())
				.group("")
				.unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.get().getRegistryName().getPath() + "_slab_crafting"));
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.SLAB.get(), 2).unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.get().getRegistryName().getPath() + "_slab_cutting"));
			}
			if (deco.STAIRS != null) {
				ShapedRecipeBuilder.shaped(deco.STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', deco.originalItem.get())
				.group("")
				.unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.get().getRegistryName().getPath() + "_stairs_crafting"));
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.STAIRS.get()).unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.get().getRegistryName().getPath() + "_stairs_cutting"));
			}
			if (deco.WALL != null) {
				ShapedRecipeBuilder.shaped(deco.WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', deco.originalItem.get())
				.group("")
				.unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.get().getRegistryName().getPath() + "_wall_crafting"));
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.WALL.get()).unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.get().getRegistryName().getPath() + "_wall_cutting"));
			}
		}
	}

	public void blockIngotNuggetCompression(Consumer<FinishedRecipe> consumer, String name, Item block, Item ingot, Item nugget) {
		ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
				ShapedRecipeBuilder.shaped(block, 1)
				.pattern("XXX")
				.pattern("XYX")
				.pattern("XXX")
				.define('X', ItemTags.bind("forge:ingots/" + name))
				.define('Y', ingot)
				.group("")
				.unlockedBy("has_ingot", has(ingot))
				::save
				)
		.generateAdvancement()
		.build(consumer, new ResourceLocation(this.getName(), ingot.getRegistryName().getPath() + "_to_block"));

		ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
				ShapelessRecipeBuilder.shapeless(ingot, 9)
				.requires(block)
				.group("")
				.unlockedBy("has_block", has(block))
				::save
				)
		.generateAdvancement()
		.build(consumer, new ResourceLocation(this.getName(), block.getRegistryName().getPath() + "_to_ingot"));

		ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
				ShapedRecipeBuilder.shaped(ingot, 1)
				.pattern("XXX")
				.pattern("XYX")
				.pattern("XXX")
				.define('X', ItemTags.bind("forge:nuggets/" + name))
				.define('Y', nugget)
				.group("")
				.unlockedBy("has_nugget", has(nugget))
				::save
				)
		.generateAdvancement()
		.build(consumer, new ResourceLocation(this.getName(), nugget.getRegistryName().getPath() + "_to_ingot"));

		ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
				ShapelessRecipeBuilder.shapeless(nugget, 9)
				.requires(ingot)
				.group("")
				.unlockedBy("has_ingot", has(ingot))
				::save
				)
		.generateAdvancement()
		.build(consumer, new ResourceLocation(this.getName(), ingot.getRegistryName().getPath() + "_to_nugget"));
	}
}
