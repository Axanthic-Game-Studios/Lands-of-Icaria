package com.axanthic.icaria.datagen;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.axanthic.icaria.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.DecoItemBlockCombination;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag.Named;
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
		return IcariaInfo.MODID;
	}

	@Override
	public void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		for (DecoItemBlockCombination deco : IcariaItems.DECO_BLOCKS) {
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
		stoneTypeRecipes(consumer, IcariaItems.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_COBBLE.get(), IcariaItems.YELLOWSTONE_BRICKS.get(), IcariaItems.YELLOWSTONE_CHISELED.get(), IcariaItems.YELLOWSTONE_BRICKS_DECO);
		stoneTypeRecipes(consumer, IcariaItems.SILKSTONE.get(), IcariaItems.SILKSTONE_COBBLE.get(), IcariaItems.SILKSTONE_BRICKS.get(), IcariaItems.SILKSTONE_CHISELED.get(), IcariaItems.SILKSTONE_BRICKS_DECO);
		stoneTypeRecipes(consumer, IcariaItems.SUNSTONE.get(), IcariaItems.SUNSTONE_COBBLE.get(), IcariaItems.SUNSTONE_BRICKS.get(), IcariaItems.SUNSTONE_CHISELED.get(), IcariaItems.SUNSTONE_BRICKS_DECO);
		stoneTypeRecipes(consumer, IcariaItems.VOIDSHALE.get(), IcariaItems.VOIDSHALE_COBBLE.get(), IcariaItems.VOIDSHALE_BRICKS.get(), IcariaItems.VOIDSHALE_CHISELED.get(), IcariaItems.VOIDSHALE_BRICKS_DECO);
		stoneTypeRecipes(consumer, IcariaItems.BAETYL.get(), IcariaItems.BAETYL_COBBLE.get(), IcariaItems.BAETYL_BRICKS.get(), IcariaItems.BAETYL_CHISELED.get(), IcariaItems.BAETYL_BRICKS_DECO);

		blockCompression(consumer, IcariaItems.JELLYFISH_JELLY_BLOCK.get(), IcariaItems.JELLYFISH_JELLY.get(), null);
		blockCompression(consumer, IcariaItems.ARACHNE_STRING_BLOCK.get(), IcariaItems.ARACHNE_STRING.get(), null);
		blockCompression(consumer, IcariaItems.SPELT_BALE_BLOCK.get(), IcariaItems.SPELT.get(), null);
		//blockCompression(consumer, IcariaItems.VINE_SPROUT_BLOCK.get(), IcariaItems.VINE_SPROUT.get(), null);
		blockCompression(consumer, IcariaItems.ROTTEN_BONES_BLOCK.get(), IcariaItems.ROTTEN_BONES.get(), null);
		blockCompression(consumer, IcariaItems.LIGNITE_BLOCK.get(), IcariaItems.LIGNITE.get(), IcariaItemTags.GEMS_LIGNITE);
		blockCompression(consumer, IcariaItems.ANTHRACITE_BLOCK.get(), IcariaItems.ANTHRACITE.get(), IcariaItemTags.GEMS_ANTHRACITE);
		blockCompression(consumer, IcariaItems.CHERT_BLOCK.get(), IcariaItems.CHERT.get(), IcariaItemTags.GEMS_CHERT);
	}

	public void stoneTypeRecipes(Consumer<FinishedRecipe> consumer, Item stone, Item cobble, Item bricks, Item chiseled, DecoItemBlockCombination deco) {
		//smelting
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(cobble), stone, 0.1F, 200).group("").unlockedBy("has_cobble", has(cobble))
		.save(consumer, new ResourceLocation(this.getName(), stone.getRegistryName().getPath() + "_smelting"));
		//bricks
		ShapedRecipeBuilder.shaped(bricks, 4)
		.pattern("XX")
		.pattern("XX")
		.define('X', stone)
		.group("")
		.unlockedBy("has_stone", has(stone))
		.save(consumer, new ResourceLocation(this.getName(), bricks.getRegistryName().getPath() + "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), bricks).unlockedBy("has_stone", has(stone))
		.save(consumer, new ResourceLocation(this.getName(), bricks.getRegistryName().getPath() + "_cutting"));
		//chiseled bricks
		ShapedRecipeBuilder.shaped(chiseled, 1)
		.pattern("X")
		.pattern("X")
		.define('X', deco.SLAB.get())
		.group("")
		.unlockedBy("has_slab", has(deco.SLAB.get()))
		.save(consumer, new ResourceLocation(this.getName(), chiseled.getRegistryName().getPath() + "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), chiseled).unlockedBy("has_stone", has(stone))
		.save(consumer, new ResourceLocation(this.getName(), chiseled.getRegistryName().getPath() + "_cutting_from_stone"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), chiseled).unlockedBy("has_bricks", has(bricks))
		.save(consumer, new ResourceLocation(this.getName(), chiseled.getRegistryName().getPath() + "_cutting_from_bricks"));
	}

	public void blockCompression(Consumer<FinishedRecipe> consumer, Item block, Item uncompressed, @Nullable Named<Item> uncompressedTag) {
		if (uncompressedTag == null) {
			ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
					ShapedRecipeBuilder.shaped(block, 1)
					.pattern("XXX")
					.pattern("XXX")
					.pattern("XXX")
					.define('X', uncompressed)
					.group("")
					.unlockedBy("has_uncompressed", has(uncompressed))
					::save
					)
			.generateAdvancement()
			.build(consumer, new ResourceLocation(this.getName(), uncompressed.getRegistryName().getPath() + "_to_block"));
		} else {
			ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
					ShapedRecipeBuilder.shaped(block, 1)
					.pattern("XXX")
					.pattern("XYX")
					.pattern("XXX")
					.define('X', uncompressedTag)
					.define('Y', uncompressed)
					.group("")
					.unlockedBy("has_uncompressed", has(uncompressed))
					::save
					)
			.generateAdvancement()
			.build(consumer, new ResourceLocation(this.getName(), uncompressed.getRegistryName().getPath() + "_to_block"));
		}

		ConditionalRecipe.builder().addCondition(this.TRUE()).addRecipe(
				ShapelessRecipeBuilder.shapeless(uncompressed, 9)
				.requires(block)
				.group("")
				.unlockedBy("has_block", has(block))
				::save
				)
		.generateAdvancement()
		.build(consumer, new ResourceLocation(this.getName(), block.getRegistryName().getPath() + "_decompress"));
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
