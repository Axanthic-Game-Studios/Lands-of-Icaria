package com.axanthic.icaria.datagen;

import java.util.function.Consumer;

import javax.annotation.Nullable;

import com.axanthic.icaria.util.IcariaInfo;
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
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
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
				.unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_slab_crafting"));
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.SLAB.get(), 2).unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_slab_cutting"));
			}
			if (deco.STAIRS != null) {
				ShapedRecipeBuilder.shaped(deco.STAIRS.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', deco.originalItem.get())
				.unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_stairs_crafting"));
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.STAIRS.get()).unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_stairs_cutting"));
			}
			if (deco.WALL != null) {
				ShapedRecipeBuilder.shaped(deco.WALL.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', deco.originalItem.get())
				.unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_wall_crafting"));
				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.WALL.get()).unlockedBy("has_block", has(deco.originalItem.get()))
				.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_wall_cutting"));
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
		blockCompression(consumer, IcariaItems.VINE_REED_BLOCK.get(), IcariaItems.VINE_REED.get(), null);
		//blockCompression(consumer, IcariaItems.VINE_SPROUT_BLOCK.get(), IcariaItems.VINE_SPROUT.get(), null);
		blockCompression(consumer, IcariaItems.ROTTEN_BONES_BLOCK.get(), IcariaItems.ROTTEN_BONES.get(), null);
		blockCompression(consumer, IcariaItems.CHALKOS_RAW_BLOCK.get(), IcariaItems.CHALKOS_RAW.get(), IcariaItemTags.RAW_MATERIALS_CHALKOS);
		blockCompression(consumer, IcariaItems.KASSITEROS_RAW_BLOCK.get(), IcariaItems.KASSITEROS_RAW.get(), IcariaItemTags.RAW_MATERIALS_KASSITEROS);
		blockCompression(consumer, IcariaItems.VANADIUM_RAW_BLOCK.get(), IcariaItems.VANADIUM_RAW.get(), IcariaItemTags.RAW_MATERIALS_VANADIUM);
		blockCompression(consumer, IcariaItems.SIDEROS_RAW_BLOCK.get(), IcariaItems.SIDEROS_RAW.get(), IcariaItemTags.RAW_MATERIALS_SIDEROS);
		blockCompression(consumer, IcariaItems.MOLYBDENUM_RAW_BLOCK.get(), IcariaItems.MOLYBDENUM_RAW.get(), IcariaItemTags.RAW_MATERIALS_MOLYBDENUM);
		blockCompression(consumer, IcariaItems.CHERT_BLOCK.get(), IcariaItems.CHERT.get(), IcariaItemTags.GEMS_CHERT);
		blockCompression(consumer, IcariaItems.LIGNITE_BLOCK.get(), IcariaItems.LIGNITE.get(), IcariaItemTags.GEMS_LIGNITE);
		blockCompression(consumer, IcariaItems.SLIVER_BLOCK.get(), IcariaItems.SLIVER.get(), IcariaItemTags.GEMS_SLIVER);
		blockCompression(consumer, IcariaItems.ANTHRACITE_BLOCK.get(), IcariaItems.ANTHRACITE.get(), IcariaItemTags.GEMS_ANTHRACITE);

		blockIngotNuggetCompression(consumer, "chalkos", IcariaItems.CHALKOS_BLOCK.get(), IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_NUGGET.get());
		blockIngotNuggetCompression(consumer, "kassiteros", IcariaItems.KASSITEROS_BLOCK.get(), IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_NUGGET.get());
		blockIngotNuggetCompression(consumer, "orichalcum", IcariaItems.ORICHALCUM_BLOCK.get(), IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_NUGGET.get());
		blockIngotNuggetCompression(consumer, "vanadium", IcariaItems.VANADIUM_BLOCK.get(), IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_NUGGET.get());
		blockIngotNuggetCompression(consumer, "vanadiumsteel", IcariaItems.VANADIUMSTEEL_BLOCK.get(), IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_NUGGET.get());
		blockIngotNuggetCompression(consumer, "sideros", IcariaItems.SIDEROS_BLOCK.get(), IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_NUGGET.get());
		blockIngotNuggetCompression(consumer, "molybdenum", IcariaItems.MOLYBDENUM_BLOCK.get(), IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.MOLYBDENUM_NUGGET.get());
		blockIngotNuggetCompression(consumer, "molybdenumsteel", IcariaItems.MOLYBDENUMSTEEL_BLOCK.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());

		gemToolRecipes(consumer, "chert", IcariaItems.CHERT_TOOLS.SWORD.get(), IcariaItems.CHERT_TOOLS.SHOVEL.get(), IcariaItems.CHERT_TOOLS.PICKAXE.get(), IcariaItems.CHERT_TOOLS.AXE.get(), IcariaItems.CHERT_TOOLS.SCYTHE.get(), IcariaItems.CHERT_TOOLS.BIDENT.get(), IcariaItems.CHERT.get());
		ingotToolRecipes(consumer, "chalkos", IcariaItems.CHALKOS_TOOLS.SWORD.get(), IcariaItems.CHALKOS_TOOLS.SHOVEL.get(), IcariaItems.CHALKOS_TOOLS.PICKAXE.get(), IcariaItems.CHALKOS_TOOLS.AXE.get(), IcariaItems.CHALKOS_TOOLS.SCYTHE.get(), IcariaItems.CHALKOS_TOOLS.BIDENT.get(), IcariaItems.CHALKOS_INGOT.get());
		ingotToolRecipes(consumer, "kassiteros", IcariaItems.KASSITEROS_TOOLS.SWORD.get(), IcariaItems.KASSITEROS_TOOLS.SHOVEL.get(), IcariaItems.KASSITEROS_TOOLS.PICKAXE.get(), IcariaItems.KASSITEROS_TOOLS.AXE.get(), IcariaItems.KASSITEROS_TOOLS.SCYTHE.get(), IcariaItems.KASSITEROS_TOOLS.BIDENT.get(), IcariaItems.KASSITEROS_INGOT.get());
		ingotToolRecipes(consumer, "orichalcum", IcariaItems.ORICHALCUM_TOOLS.SWORD.get(), IcariaItems.ORICHALCUM_TOOLS.SHOVEL.get(), IcariaItems.ORICHALCUM_TOOLS.PICKAXE.get(), IcariaItems.ORICHALCUM_TOOLS.AXE.get(), IcariaItems.ORICHALCUM_TOOLS.SCYTHE.get(), IcariaItems.ORICHALCUM_TOOLS.BIDENT.get(), IcariaItems.ORICHALCUM_INGOT.get());
		ingotToolRecipes(consumer, "vanadiumsteel", IcariaItems.VANADIUMSTEEL_TOOLS.SWORD.get(), IcariaItems.VANADIUMSTEEL_TOOLS.SHOVEL.get(), IcariaItems.VANADIUMSTEEL_TOOLS.PICKAXE.get(), IcariaItems.VANADIUMSTEEL_TOOLS.AXE.get(), IcariaItems.VANADIUMSTEEL_TOOLS.SCYTHE.get(), IcariaItems.VANADIUMSTEEL_TOOLS.BIDENT.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		ingotToolRecipes(consumer, "sideros", IcariaItems.SIDEROS_TOOLS.SWORD.get(), IcariaItems.SIDEROS_TOOLS.SHOVEL.get(), IcariaItems.SIDEROS_TOOLS.PICKAXE.get(), IcariaItems.SIDEROS_TOOLS.AXE.get(), IcariaItems.SIDEROS_TOOLS.SCYTHE.get(), IcariaItems.SIDEROS_TOOLS.BIDENT.get(), IcariaItems.SIDEROS_INGOT.get());
		ingotToolRecipes(consumer, "molybdenumsteel", IcariaItems.MOLYBDENUMSTEEL_TOOLS.SWORD.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.SHOVEL.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.PICKAXE.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.AXE.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.SCYTHE.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.BIDENT.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());

		torchRecipe(consumer, "lignite", IcariaItems.LIGNITE_TORCH.get(), IcariaItems.LIGNITE.get());
		torchRecipe(consumer, "anthracite", IcariaItems.ANTHRACITE_TORCH.get(), IcariaItems.ANTHRACITE.get());

		//dolomite
		ShapedRecipeBuilder.shaped(IcariaItems.DOLOMITE_SMOOTH.get())
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.DOLOMITE.get())
		.unlockedBy("has_dolomite", has(IcariaItems.DOLOMITE.get()))
		.save(consumer, IcariaItems.DOLOMITE_SMOOTH.getId());
		ShapedRecipeBuilder.shaped(IcariaItems.DOLOMITE_BRICKS.get(), 4)
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.DOLOMITE_SMOOTH.get())
		.unlockedBy("has_dolomite", has(IcariaItems.DOLOMITE_SMOOTH.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_BRICKS.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_SMOOTH.get()), IcariaItems.DOLOMITE_BRICKS.get()).unlockedBy("has_dolomite", has(IcariaItems.DOLOMITE_SMOOTH.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_BRICKS.getId(), "_cutting"));
		ShapedRecipeBuilder.shaped(IcariaItems.DOLOMITE_PILLAR.get(), 2)
		.pattern("X")
		.pattern("X")
		.define('X', IcariaItems.DOLOMITE_BRICKS.get())
		.unlockedBy("has_bricks", has(IcariaItems.DOLOMITE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_SMOOTH.get()), IcariaItems.DOLOMITE_PILLAR.get()).unlockedBy("has_dolomite", has(IcariaItems.DOLOMITE_SMOOTH.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR.getId(), "_cutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_BRICKS.get()), IcariaItems.DOLOMITE_PILLAR.get()).unlockedBy("has_bricks", has(IcariaItems.DOLOMITE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR.getId(), "_cutting_bricks"));
		ShapedRecipeBuilder.shaped(IcariaItems.DOLOMITE_PILLAR_HEAD.get(), 2)
		.pattern("X")
		.pattern("Y")
		.define('X', IcariaItems.DOLOMITE_BRICKS.get())
		.define('Y', IcariaItems.DOLOMITE_PILLAR.get())
		.unlockedBy("has_pillar", has(IcariaItems.DOLOMITE_PILLAR.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_SMOOTH.get()), IcariaItems.DOLOMITE_PILLAR_HEAD.get()).unlockedBy("has_dolomite", has(IcariaItems.DOLOMITE_SMOOTH.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_cutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_BRICKS.get()), IcariaItems.DOLOMITE_PILLAR_HEAD.get()).unlockedBy("has_bricks", has(IcariaItems.DOLOMITE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_cutting_bricks"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_PILLAR.get()), IcariaItems.DOLOMITE_PILLAR_HEAD.get()).unlockedBy("has_pillar", has(IcariaItems.DOLOMITE_PILLAR.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_cutting_pillar"));

		//sand
		glassRecipes(consumer, IcariaItems.GRAINEL.get(), IcariaItems.GRAINGLASS.get(), IcariaItems.GRAINGLASS_PANE.get(), IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get());
		glassRecipes(consumer, IcariaItems.SILKSAND.get(), IcariaItems.SILKGLASS.get(), IcariaItems.SILKGLASS_PANE.get(), IcariaItems.SILKGLASS_PANE_HORIZONTAL.get());
		ShapedRecipeBuilder.shaped(IcariaItems.GRAINITE.get())
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.GRAINEL.get())
		.unlockedBy("has_grainel", has(IcariaItems.GRAINEL.get()))
		.save(consumer, appendResource(IcariaItems.GRAINITE.getId(), "_from_sand"));
		ShapedRecipeBuilder.shaped(IcariaItems.SILKSTONE.get())
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.SILKSAND.get())
		.unlockedBy("has_silksand", has(IcariaItems.SILKSAND.get()))
		.save(consumer, appendResource(IcariaItems.SILKSTONE.getId(), "_from_sand"));
		ShapedRecipeBuilder.shaped(IcariaItems.GRAINITE_BRICKS.get(), 4)
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.GRAINITE.get())
		.unlockedBy("has_grainite", has(IcariaItems.GRAINITE.get()))
		.save(consumer, appendResource(IcariaItems.GRAINITE_BRICKS.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE.get()), IcariaItems.GRAINITE_BRICKS.get()).unlockedBy("has_grainite", has(IcariaItems.GRAINITE.get()))
		.save(consumer, appendResource(IcariaItems.GRAINITE_BRICKS.getId(), "_cutting"));
		ShapedRecipeBuilder.shaped(IcariaItems.GRAINITE_CHISELED.get())
		.pattern("X")
		.pattern("X")
		.define('X', IcariaItems.GRAINITE_BRICKS_DECO.SLAB.get())
		.unlockedBy("has_bricks", has(IcariaItems.GRAINITE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.GRAINITE_CHISELED.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE.get()), IcariaItems.GRAINITE_CHISELED.get()).unlockedBy("has_grainite", has(IcariaItems.GRAINITE.get()))
		.save(consumer, appendResource(IcariaItems.GRAINITE_CHISELED.getId(), "_cutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE_BRICKS.get()), IcariaItems.GRAINITE_CHISELED.get()).unlockedBy("has_bricks", has(IcariaItems.GRAINITE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.GRAINITE_CHISELED.getId(), "_cutting_bricks"));
		ShapedRecipeBuilder.shaped(IcariaItems.FLASK_EMPTY.get(), 3)
		.pattern("X X")
		.pattern(" X ")
		.define('X', IcariaItems.SILKGLASS.get())
		.unlockedBy("has_glass", has(IcariaItems.SILKGLASS.get()))
		.save(consumer, IcariaItems.FLASK_EMPTY.getId());

		//loam
		ShapedRecipeBuilder.shaped(IcariaItems.LOAM.get())
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.LOAM_LUMP.get())
		.unlockedBy("has_loam", has(IcariaItems.LOAM_LUMP.get()))
		.save(consumer, appendResource(IcariaItems.LOAM.getId(), "_block"));
		ShapelessRecipeBuilder.shapeless(IcariaItems.LOAM_LUMP.get(), 4)
		.requires(IcariaItems.LOAM.get())
		.unlockedBy("has_loam", has(IcariaItems.LOAM.get()))
		.save(consumer, IcariaItems.LOAM_LUMP.getId());
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.LOAM_LUMP.get()), IcariaItems.LOAM_BRICK.get(), 0.3F, 200).unlockedBy("has_loam", has(IcariaItems.LOAM_LUMP.get()))
		.save(consumer, appendResource(IcariaItems.LOAM_BRICK.getId(), "_smelting"));
		ShapedRecipeBuilder.shaped(IcariaItems.LOAM_BRICKS.get())
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItemTags.INGOTS_LOAM_BRICK)
		.unlockedBy("has_brick", has(IcariaItemTags.INGOTS_LOAM_BRICK))
		.save(consumer, IcariaItems.LOAM_BRICKS.getId());

		//relicstone
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.DOLOMITE_SMOOTH.get(), 0.1F, 200).unlockedBy("has_cobble", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.DOLOMITE_SMOOTH.getId(), "_smelting"));
		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_BRICKS.get(), 4)
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.RELICSTONE.get())
		.unlockedBy("has_stone", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_BRICKS.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_BRICKS.get()).unlockedBy("has_stone", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_BRICKS.getId(), "_cutting"));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_BRICKS_CRACKED.get(), 0.1F, 200).unlockedBy("has_bricks", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, IcariaItems.RELICSTONE_BRICKS_CRACKED.getId());
		ShapelessRecipeBuilder.shapeless(IcariaItems.RELICSTONE_BRICKS_MOSSY.get())
		.requires(IcariaItems.RELICSTONE_BRICKS.get())
		.requires(Items.MOSS_BLOCK)
		.unlockedBy("has_bricks", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, IcariaItems.RELICSTONE_BRICKS_MOSSY.getId());
		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_TILES.get(), 4)
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.RELICSTONE_BRICKS.get())
		.unlockedBy("has_bricks", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_TILES.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_TILES.get()).unlockedBy("has_stone", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_TILES.getId(), "_cutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_TILES.get()).unlockedBy("has_bricks", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_TILES.getId(), "_cutting_bricks"));
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE_TILES.get()), IcariaItems.RELICSTONE_TILES_CRACKED.get(), 0.1F, 200).unlockedBy("has_tiles", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, IcariaItems.RELICSTONE_TILES_CRACKED.getId());
		ShapelessRecipeBuilder.shapeless(IcariaItems.RELICSTONE_TILES_MOSSY.get())
		.requires(IcariaItems.RELICSTONE_TILES.get())
		.requires(Items.MOSS_BLOCK)
		.unlockedBy("has_tiles", has(IcariaItems.RELICSTONE_TILES.get()))
		.save(consumer, IcariaItems.RELICSTONE_TILES_MOSSY.getId());
		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_CHISELED.get())
		.pattern("X")
		.pattern("X")
		.define('X', IcariaItems.RELICSTONE_DECO.SLAB.get())
		.unlockedBy("has_stone", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_CHISELED.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_CHISELED.get()).unlockedBy("has_stone", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_CHISELED.getId(), "_cutting"));
		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_PILLAR.get(), 2)
		.pattern("X")
		.pattern("X")
		.define('X', IcariaItems.RELICSTONE_BRICKS.get())
		.unlockedBy("has_bricks", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_PILLAR.get()).unlockedBy("has_stone", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR.getId(), "_cutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_PILLAR.get()).unlockedBy("has_bricks", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR.getId(), "_cutting_bricks"));
		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_PILLAR_HEAD.get(), 2)
		.pattern("X")
		.pattern("Y")
		.define('X', IcariaItems.RELICSTONE_TILES.get())
		.define('Y', IcariaItems.RELICSTONE_PILLAR.get())
		.unlockedBy("has_pillar", has(IcariaItems.RELICSTONE_PILLAR.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_PILLAR_HEAD.get()).unlockedBy("has_stone", has(IcariaItems.RELICSTONE.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_cutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_TILES.get()), IcariaItems.RELICSTONE_PILLAR_HEAD.get()).unlockedBy("has_tiles", has(IcariaItems.RELICSTONE_TILES.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_cutting_tiles"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_PILLAR_HEAD.get()).unlockedBy("has_bricks", has(IcariaItems.RELICSTONE_BRICKS.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_cutting_bricks"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_PILLAR.get()), IcariaItems.RELICSTONE_PILLAR_HEAD.get()).unlockedBy("has_pillar", has(IcariaItems.RELICSTONE_PILLAR.get()))
		.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_cutting_pillar"));

		//vanilla smooth stone recipes
		ShapedRecipeBuilder.shaped(Blocks.REPEATER).define('#', Blocks.REDSTONE_TORCH)
		.define('X', Items.REDSTONE)
		.define('I', Tags.Items.STONE)
		.pattern("#X#")
		.pattern("III")
		.unlockedBy("has_redstone_torch", has(Blocks.REDSTONE_TORCH))
		.save(consumer, appendResource(Blocks.REPEATER.getRegistryName(), "_any_stone"));
		ShapedRecipeBuilder.shaped(Blocks.COMPARATOR)
		.define('#', Blocks.REDSTONE_TORCH)
		.define('X', Items.QUARTZ)
		.define('I', Tags.Items.STONE)
		.pattern(" # ")
		.pattern("#X#")
		.pattern("III")
		.unlockedBy("has_quartz", has(Items.QUARTZ))
		.save(consumer, appendResource(Blocks.COMPARATOR.getRegistryName(), "_any_stone"));
		ShapedRecipeBuilder.shaped(Blocks.STONECUTTER)
		.define('I', Items.IRON_INGOT)
		.define('#', Tags.Items.STONE)
		.pattern(" I ")
		.pattern("###")
		.unlockedBy("has_stone", has(Blocks.STONE))
		.save(consumer, appendResource(Blocks.STONECUTTER.getRegistryName(), "_any_stone"));

		//miscellaneous
		ShapedRecipeBuilder.shaped(IcariaItems.ARISTONE_PACKED.get())
		.pattern("XXX")
		.pattern("XXX")
		.pattern("XXX")
		.define('X', IcariaItems.ARISTONE.get())
		.unlockedBy("has_stone", has(IcariaItems.ARISTONE.get()))
		.save(consumer, IcariaItems.ARISTONE_PACKED.getId());
		ShapedRecipeBuilder.shaped(IcariaItems.MARL_COARSE.get(), 4)
		.pattern("YX")
		.pattern("XY")
		.define('X', IcariaItems.MARL.get())
		.define('Y', IcariaItems.GRAINEL.get())
		.unlockedBy("has_marl", has(IcariaItems.MARL.get()))
		.save(consumer, IcariaItems.MARL_COARSE.getId());
		ShapedRecipeBuilder.shaped(Items.PAPER, 3)
		.pattern("XXX")
		.define('X', IcariaItems.VINE_REED.get())
		.unlockedBy("has_reeds", has(IcariaItems.VINE_REED.get()))
		.save(consumer, new ResourceLocation(getName(), "paper_from_vine_reeds"));
		ShapelessRecipeBuilder.shapeless(Items.SUGAR)
		.requires(IcariaItems.VINE_REED.get())
		.unlockedBy("has_reeds", has(IcariaItems.VINE_REED.get()))
		.save(consumer, new ResourceLocation(getName(), "sugar_from_vine_reeds"));
		ShapedRecipeBuilder.shaped(IcariaItems.QUARTZ_PILLAR_HEAD.get(), 2)
		.pattern("X")
		.pattern("Y")
		.define('X', Items.CHISELED_QUARTZ_BLOCK)
		.define('Y', Items.QUARTZ_PILLAR)
		.unlockedBy("has_pillar", has(Items.QUARTZ_PILLAR))
		.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.QUARTZ_BLOCK), IcariaItems.QUARTZ_PILLAR_HEAD.get()).unlockedBy("has_dolomite", has(Items.QUARTZ_BLOCK))
		.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_cutting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.QUARTZ_BRICKS), IcariaItems.QUARTZ_PILLAR_HEAD.get()).unlockedBy("has_bricks", has(Items.QUARTZ_BRICKS))
		.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_cutting_bricks"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.QUARTZ_PILLAR), IcariaItems.QUARTZ_PILLAR_HEAD.get()).unlockedBy("has_pillar", has(Items.QUARTZ_PILLAR))
		.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_cutting_pillar"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.CHISELED_QUARTZ_BLOCK), IcariaItems.QUARTZ_PILLAR_HEAD.get()).unlockedBy("has_chiseled", has(Items.CHISELED_QUARTZ_BLOCK))
		.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_cutting_chiseled"));
		ShapedRecipeBuilder.shaped(IcariaItems.SPELT_BREAD.get())
		.pattern("XXX")
		.define('X', IcariaItemTags.SPELT)
		.unlockedBy("has_spelt", has(IcariaItemTags.SPELT))
		.save(consumer, IcariaItems.SPELT_BREAD.getId());
		ShapedRecipeBuilder.shaped(IcariaItems.VINE_SPROUT_BLOCK.get())
		.pattern("XX")
		.pattern("XX")
		.define('X', IcariaItems.VINE_SPROUT.get())
		.unlockedBy("has_sprout", has(IcariaItems.VINE_SPROUT.get()))
		.save(consumer, appendResource(IcariaItems.VINE_SPROUT.getId(), "_to_block"));
		ShapelessRecipeBuilder.shapeless(IcariaItems.VINE_SPROUT.get(), 4)
		.requires(IcariaItems.VINE_SPROUT_BLOCK.get())
		.unlockedBy("has_block", has(IcariaItems.VINE_SPROUT_BLOCK.get()))
		.save(consumer, appendResource(IcariaItems.VINE_SPROUT_BLOCK.getId(), "_decompress"));
	}

	public void stoneTypeRecipes(Consumer<FinishedRecipe> consumer, Item stone, Item cobble, Item bricks, Item chiseled, DecoItemBlockCombination deco) {
		//smelting
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(cobble), stone, 0.1F, 200).unlockedBy("has_cobble", has(cobble))
		.save(consumer, appendResource(stone.getRegistryName(), "_smelting"));
		//bricks
		ShapedRecipeBuilder.shaped(bricks, 4)
		.pattern("XX")
		.pattern("XX")
		.define('X', stone)
		.unlockedBy("has_stone", has(stone))
		.save(consumer, appendResource(bricks.getRegistryName(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), bricks).unlockedBy("has_stone", has(stone))
		.save(consumer, appendResource(bricks.getRegistryName(), "_cutting"));
		//chiseled bricks
		ShapedRecipeBuilder.shaped(chiseled, 1)
		.pattern("X")
		.pattern("X")
		.define('X', deco.SLAB.get())
		.unlockedBy("has_slab", has(deco.SLAB.get()))
		.save(consumer, appendResource(chiseled.getRegistryName(), "_crafting"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), chiseled).unlockedBy("has_stone", has(stone))
		.save(consumer, appendResource(chiseled.getRegistryName(), "_cutting_from_stone"));
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), chiseled).unlockedBy("has_bricks", has(bricks))
		.save(consumer, appendResource(chiseled.getRegistryName(), "_cutting_from_bricks"));
	}

	public void glassRecipes(Consumer<FinishedRecipe> consumer, Item sand, Item glass, Item pane, Item horizontalPane) {
		//smelting
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(sand), glass, 0.1F, 200).unlockedBy("has_sand", has(sand))
		.save(consumer, appendResource(glass.getRegistryName(), "_smelting"));
		//panes
		ShapedRecipeBuilder.shaped(pane, 16)
		.pattern("XXX")
		.pattern("XXX")
		.define('X', glass)
		.unlockedBy("has_glass", has(glass))
		.save(consumer, pane.getRegistryName());
		//horizontal panes
		ShapedRecipeBuilder.shaped(horizontalPane, 2)
		.pattern("XX")
		.define('X', pane)
		.unlockedBy("has_pane", has(pane))
		.save(consumer, horizontalPane.getRegistryName());
	}

	public void blockCompression(Consumer<FinishedRecipe> consumer, Item block, Item uncompressed, @Nullable Named<Item> uncompressedTag) {
		if (uncompressedTag == null) {
			ShapedRecipeBuilder.shaped(block, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', uncompressed)
			.group("")
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(uncompressed.getRegistryName(), "_to_block"));
		} else {
			ShapedRecipeBuilder.shaped(block, 1)
			.pattern("XXX")
			.pattern("XYX")
			.pattern("XXX")
			.define('X', uncompressedTag)
			.define('Y', uncompressed)
			.group("")
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(uncompressed.getRegistryName(), "_to_block"));
		}
		ShapelessRecipeBuilder.shapeless(uncompressed, 9)
		.requires(block)
		.group("")
		.unlockedBy("has_block", has(block))
		.save(consumer, appendResource(block.getRegistryName(), "_decompress"));
	}

	public void blockIngotNuggetCompression(Consumer<FinishedRecipe> consumer, String name, Item block, Item ingot, Item nugget) {
		ShapedRecipeBuilder.shaped(block, 1)
		.pattern("XXX")
		.pattern("XYX")
		.pattern("XXX")
		.define('X', ItemTags.bind("forge:ingots/" + name))
		.define('Y', ingot)
		.group("")
		.unlockedBy("has_ingot", has(ingot))
		.save(consumer, appendResource(ingot.getRegistryName(), "_to_block"));

		ShapelessRecipeBuilder.shapeless(ingot, 9)
		.requires(block)
		.group("")
		.unlockedBy("has_block", has(block))
		.save(consumer, appendResource(block.getRegistryName(), "_to_ingot"));

		ShapedRecipeBuilder.shaped(ingot, 1)
		.pattern("XXX")
		.pattern("XYX")
		.pattern("XXX")
		.define('X', ItemTags.bind("forge:nuggets/" + name))
		.define('Y', nugget)
		.group("")
		.unlockedBy("has_nugget", has(nugget))
		.save(consumer, appendResource(nugget.getRegistryName(), "_to_ingot"));

		ShapelessRecipeBuilder.shapeless(nugget, 9)
		.requires(ingot)
		.group("")
		.unlockedBy("has_ingot", has(ingot))
		.save(consumer, appendResource(ingot.getRegistryName(), "_to_nugget"));
	}

	public void ingotToolRecipes(Consumer<FinishedRecipe> consumer, String name, Item sword, Item shovel, Item pickaxe, Item axe, Item scythe, Item bident, Item ingot) {
		ShapedRecipeBuilder.shaped(sword, 1)
			.pattern(" X ")
			.pattern(" X ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:ingots/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, sword.getRegistryName());

		ShapedRecipeBuilder.shaped(shovel, 1)
			.pattern(" X ")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:ingots/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, shovel.getRegistryName());

		ShapedRecipeBuilder.shaped(pickaxe, 1)
			.pattern("XXX")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:ingots/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, pickaxe.getRegistryName());

		ShapedRecipeBuilder.shaped(axe, 1)
			.pattern("XX ")
			.pattern("XY ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:ingots/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, axe.getRegistryName());

		ShapedRecipeBuilder.shaped(scythe, 1)
			.pattern(" XX")
			.pattern("X Y")
			.pattern("  Y")
			.define('X', ItemTags.bind("forge:ingots/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, scythe.getRegistryName());

		ShapedRecipeBuilder.shaped(bident, 1)
			.pattern("X X")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:ingots/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, bident.getRegistryName());
	}

	public void gemToolRecipes(Consumer<FinishedRecipe> consumer, String name, Item sword, Item shovel, Item pickaxe, Item axe, Item scythe, Item bident, Item gem) {
		ShapedRecipeBuilder.shaped(sword, 1)
			.pattern(" X ")
			.pattern(" X ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:gems/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(gem))
			.save(consumer, sword.getRegistryName());

		ShapedRecipeBuilder.shaped(shovel, 1)
			.pattern(" X ")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:gems/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(gem))
			.save(consumer, shovel.getRegistryName());

		ShapedRecipeBuilder.shaped(pickaxe, 1)
			.pattern("XXX")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:gems/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(gem))
			.save(consumer, pickaxe.getRegistryName());

		ShapedRecipeBuilder.shaped(axe, 1)
			.pattern("XX ")
			.pattern("XY ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:gems/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(gem))
			.save(consumer, axe.getRegistryName());

		ShapedRecipeBuilder.shaped(scythe, 1)
			.pattern(" XX")
			.pattern("X Y")
			.pattern("  Y")
			.define('X', ItemTags.bind("forge:gems/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(gem))
			.save(consumer, scythe.getRegistryName());

		ShapedRecipeBuilder.shaped(bident, 1)
			.pattern("X X")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', ItemTags.bind("forge:gems/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(gem))
			.save(consumer, bident.getRegistryName());
	}

	public void torchRecipe(Consumer<FinishedRecipe> consumer, String name, Item torch, Item material) {
		ShapedRecipeBuilder.shaped(torch, 2)
			.pattern(" X ")
			.pattern(" Y ")
			.pattern("   ")
			.define('X', ItemTags.bind("forge:gems/" + name))
			.define('Y', ItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(material))
			.save(consumer, torch.getRegistryName());
	}

	public ResourceLocation appendResource(ResourceLocation res, String stuff) {
		return new ResourceLocation(res.getNamespace(), res.getPath() + stuff);
	}
}
