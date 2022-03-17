package com.axanthic.icaria.datagen;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.StoneDecoItemBlocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Objects;
import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipes extends RecipeProvider implements IConditionBuilder {
	public IcariaRecipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	public String getName() {
		return IcariaInfo.MODID;
	}

	@Override
	public void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		glassRecipes(consumer, IcariaItems.GRAINEL.get(), IcariaItems.GRAINGLASS.get(), IcariaItems.GRAINGLASS_PANE.get(), IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get());
		glassRecipes(consumer, IcariaItems.SILKSAND.get(), IcariaItems.SILKGLASS.get(), IcariaItems.SILKGLASS_PANE.get(), IcariaItems.SILKGLASS_PANE_HORIZONTAL.get());

		stoneRecipes(consumer, IcariaItems.YELLOWSTONE_COBBLE.get(), IcariaItems.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_BRICKS.get(), IcariaItems.YELLOWSTONE_CHISELED.get(), IcariaItems.YELLOWSTONE_BRICKS_DECO);
		stoneRecipes(consumer, IcariaItems.SILKSTONE_COBBLE.get(), IcariaItems.SILKSTONE.get(), IcariaItems.SILKSTONE_BRICKS.get(), IcariaItems.SILKSTONE_CHISELED.get(), IcariaItems.SILKSTONE_BRICKS_DECO);
		stoneRecipes(consumer, IcariaItems.SUNSTONE_COBBLE.get(), IcariaItems.SUNSTONE.get(), IcariaItems.SUNSTONE_BRICKS.get(), IcariaItems.SUNSTONE_CHISELED.get(), IcariaItems.SUNSTONE_BRICKS_DECO);
		stoneRecipes(consumer, IcariaItems.VOIDSHALE_COBBLE.get(), IcariaItems.VOIDSHALE.get(), IcariaItems.VOIDSHALE_BRICKS.get(), IcariaItems.VOIDSHALE_CHISELED.get(), IcariaItems.VOIDSHALE_BRICKS_DECO);
		stoneRecipes(consumer, IcariaItems.BAETYL_COBBLE.get(), IcariaItems.BAETYL.get(), IcariaItems.BAETYL_BRICKS.get(), IcariaItems.BAETYL_CHISELED.get(), IcariaItems.BAETYL_BRICKS_DECO);

		smallCompressRecipe(consumer, IcariaItems.LOAM_BRICKS.get(), IcariaItems.LOAM_BRICK.get());
		smallCompressRecipe(consumer, IcariaItems.SILKSTONE.get(), IcariaItems.SILKSAND.get());

		smallCompressDecompressRecipes(consumer, IcariaItems.LOAM.get(), IcariaItems.LOAM_LUMP.get());
		smallCompressDecompressRecipes(consumer, IcariaItems.VINE_SPROUT_BLOCK.get(), IcariaItems.VINE_SPROUT.get());

		largeCompressDecompressRecipes(consumer, IcariaItems.JELLYFISH_JELLY_BLOCK.get(), IcariaItems.JELLYFISH_JELLY.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.ARACHNE_STRING_BLOCK.get(), IcariaItems.ARACHNE_STRING.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.SPELT_BALE_BLOCK.get(), IcariaItems.SPELT.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.VINE_REED_BLOCK.get(), IcariaItems.VINE_REED.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.ROTTEN_BONES_BLOCK.get(), IcariaItems.ROTTEN_BONES.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.CALCITE_BLOCK.get(), IcariaItems.CALCITE.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.HALITE_BLOCK.get(), IcariaItems.HALITE.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.JASPER_BLOCK.get(), IcariaItems.JASPER.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.ZIRCON_BLOCK.get(), IcariaItems.ZIRCON.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.CHALKOS_RAW_BLOCK.get(), IcariaItems.CHALKOS_RAW.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.KASSITEROS_RAW_BLOCK.get(), IcariaItems.KASSITEROS_RAW.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.VANADIUM_RAW_BLOCK.get(), IcariaItems.VANADIUM_RAW.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.SIDEROS_RAW_BLOCK.get(), IcariaItems.SIDEROS_RAW.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.MOLYBDENUM_RAW_BLOCK.get(), IcariaItems.MOLYBDENUM_RAW.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.CHERT_BLOCK.get(), IcariaItems.CHERT.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.LIGNITE_BLOCK.get(), IcariaItems.LIGNITE.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.SLIVER_BLOCK.get(), IcariaItems.SLIVER.get());
		largeCompressDecompressRecipes(consumer, IcariaItems.ANTHRACITE_BLOCK.get(), IcariaItems.ANTHRACITE.get());

		woodRecipes(consumer, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get());
		woodRecipes(consumer, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
		woodRecipes(consumer, IcariaItems.FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.FIR_LOG.get(), IcariaItems.STRIPPED_FIR_LOG.get());
		woodRecipes(consumer, IcariaItems.LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.STRIPPED_LAUREL_LOG.get());
		woodRecipes(consumer, IcariaItems.OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.STRIPPED_OLIVE_LOG.get());
		woodRecipes(consumer, IcariaItems.PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.STRIPPED_PLANE_LOG.get());
		woodRecipes(consumer, IcariaItems.POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.STRIPPED_POPULUS_LOG.get());

		planksRecipes(consumer, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get(), IcariaItems.CYPRESS_PLANKS.get());
		planksRecipes(consumer, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		planksRecipes(consumer, IcariaItems.FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.FIR_LOG.get(), IcariaItems.STRIPPED_FIR_LOG.get(), IcariaItems.FIR_PLANKS.get());
		planksRecipes(consumer, IcariaItems.LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.STRIPPED_LAUREL_LOG.get(), IcariaItems.LAUREL_PLANKS.get());
		planksRecipes(consumer, IcariaItems.OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.STRIPPED_OLIVE_LOG.get(), IcariaItems.OLIVE_PLANKS.get());
		planksRecipes(consumer, IcariaItems.PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.STRIPPED_PLANE_LOG.get(), IcariaItems.PLANE_PLANKS.get());
		planksRecipes(consumer, IcariaItems.POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.STRIPPED_POPULUS_LOG.get(), IcariaItems.POPULUS_PLANKS.get());

		doorRecipe(consumer, IcariaItems.CYPRESS_DOOR.get(), IcariaItems.CYPRESS_PLANKS.get());
		doorRecipe(consumer, IcariaItems.DROUGHTROOT_DOOR.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		doorRecipe(consumer, IcariaItems.FIR_DOOR.get(), IcariaItems.FIR_PLANKS.get());
		doorRecipe(consumer, IcariaItems.LAUREL_DOOR.get(), IcariaItems.LAUREL_PLANKS.get());
		doorRecipe(consumer, IcariaItems.OLIVE_DOOR.get(), IcariaItems.OLIVE_PLANKS.get());
		doorRecipe(consumer, IcariaItems.PLANE_DOOR.get(), IcariaItems.PLANE_PLANKS.get());
		doorRecipe(consumer, IcariaItems.POPULUS_DOOR.get(), IcariaItems.POPULUS_PLANKS.get());

		trapdoorRecipe(consumer, IcariaItems.CYPRESS_TRAPDOOR.get(), IcariaItems.CYPRESS_PLANKS.get());
		trapdoorRecipe(consumer, IcariaItems.DROUGHTROOT_TRAPDOOR.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		trapdoorRecipe(consumer, IcariaItems.FIR_TRAPDOOR.get(), IcariaItems.FIR_PLANKS.get());
		trapdoorRecipe(consumer, IcariaItems.LAUREL_TRAPDOOR.get(), IcariaItems.LAUREL_PLANKS.get());
		trapdoorRecipe(consumer, IcariaItems.OLIVE_TRAPDOOR.get(), IcariaItems.OLIVE_PLANKS.get());
		trapdoorRecipe(consumer, IcariaItems.PLANE_TRAPDOOR.get(), IcariaItems.PLANE_PLANKS.get());
		trapdoorRecipe(consumer, IcariaItems.POPULUS_TRAPDOOR.get(), IcariaItems.POPULUS_PLANKS.get());

		ladderRecipe(consumer, IcariaItems.CYPRESS_LADDER.get(), IcariaItems.CYPRESS_PLANKS.get());
		ladderRecipe(consumer, IcariaItems.DROUGHTROOT_LADDER.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		ladderRecipe(consumer, IcariaItems.FIR_LADDER.get(), IcariaItems.FIR_PLANKS.get());
		ladderRecipe(consumer, IcariaItems.LAUREL_LADDER.get(), IcariaItems.LAUREL_PLANKS.get());
		ladderRecipe(consumer, IcariaItems.OLIVE_LADDER.get(), IcariaItems.OLIVE_PLANKS.get());
		ladderRecipe(consumer, IcariaItems.PLANE_LADDER.get(), IcariaItems.PLANE_PLANKS.get());
		ladderRecipe(consumer, IcariaItems.POPULUS_LADDER.get(), IcariaItems.POPULUS_PLANKS.get());

		torchRecipe(consumer, IcariaItems.LIGNITE_TORCH.get(), IcariaItems.LIGNITE.get());
		torchRecipe(consumer, IcariaItems.ANTHRACITE_TORCH.get(), IcariaItems.ANTHRACITE.get());

		blockIngotNuggetRecipes(consumer, IcariaItems.CHALKOS_BLOCK.get(), IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_NUGGET.get());
		blockIngotNuggetRecipes(consumer, IcariaItems.KASSITEROS_BLOCK.get(), IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_NUGGET.get());
		blockIngotNuggetRecipes(consumer, IcariaItems.ORICHALCUM_BLOCK.get(), IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_NUGGET.get());
		blockIngotNuggetRecipes(consumer, IcariaItems.VANADIUM_BLOCK.get(), IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_NUGGET.get());
		blockIngotNuggetRecipes(consumer, IcariaItems.VANADIUMSTEEL_BLOCK.get(), IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_NUGGET.get());
		blockIngotNuggetRecipes(consumer, IcariaItems.SIDEROS_BLOCK.get(), IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_NUGGET.get());
		blockIngotNuggetRecipes(consumer, IcariaItems.MOLYBDENUM_BLOCK.get(), IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.MOLYBDENUM_NUGGET.get());
		blockIngotNuggetRecipes(consumer, IcariaItems.MOLYBDENUMSTEEL_BLOCK.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());

		gemSmeltingRecipe(consumer, IcariaItems.LIGNITE_ORE.get(), IcariaItems.LIGNITE.get());
		gemSmeltingRecipe(consumer, IcariaItems.DOLOMITE_ORE.get(), IcariaItems.DOLOMITE.get());
		gemSmeltingRecipe(consumer, IcariaItems.SLIVER_ORE.get(), IcariaItems.SLIVER.get());
		gemSmeltingRecipe(consumer, IcariaItems.ANTHRACITE_ORE.get(), IcariaItems.ANTHRACITE.get());

		ingotSmeltingRecipes(consumer, IcariaItems.CHALKOS_ORE.get(), IcariaItems.CHALKOS_RAW.get(), IcariaItems.CHALKOS_INGOT.get());
		ingotSmeltingRecipes(consumer, IcariaItems.KASSITEROS_ORE.get(), IcariaItems.KASSITEROS_RAW.get(), IcariaItems.KASSITEROS_INGOT.get());
		ingotSmeltingRecipes(consumer, IcariaItems.VANADIUM_ORE.get(), IcariaItems.VANADIUM_RAW.get(), IcariaItems.VANADIUM_INGOT.get());
		ingotSmeltingRecipes(consumer, IcariaItems.SIDEROS_ORE.get(), IcariaItems.SIDEROS_RAW.get(), IcariaItems.SIDEROS_INGOT.get());
		ingotSmeltingRecipes(consumer, IcariaItems.MOLYBDENUM_ORE.get(), IcariaItems.MOLYBDENUM_RAW.get(), IcariaItems.MOLYBDENUM_INGOT.get());

		toolRecipes(consumer, IcariaItems.CHERT_TOOLS.SWORD.get(), IcariaItems.CHERT_TOOLS.SHOVEL.get(), IcariaItems.CHERT_TOOLS.PICKAXE.get(), IcariaItems.CHERT_TOOLS.AXE.get(), IcariaItems.CHERT_TOOLS.SCYTHE.get(), IcariaItems.CHERT_TOOLS.BIDENT.get(), IcariaItems.CHERT.get());
		toolRecipes(consumer, IcariaItems.CHALKOS_TOOLS.SWORD.get(), IcariaItems.CHALKOS_TOOLS.SHOVEL.get(), IcariaItems.CHALKOS_TOOLS.PICKAXE.get(), IcariaItems.CHALKOS_TOOLS.AXE.get(), IcariaItems.CHALKOS_TOOLS.SCYTHE.get(), IcariaItems.CHALKOS_TOOLS.BIDENT.get(), IcariaItems.CHALKOS_INGOT.get());
		toolRecipes(consumer, IcariaItems.KASSITEROS_TOOLS.SWORD.get(), IcariaItems.KASSITEROS_TOOLS.SHOVEL.get(), IcariaItems.KASSITEROS_TOOLS.PICKAXE.get(), IcariaItems.KASSITEROS_TOOLS.AXE.get(), IcariaItems.KASSITEROS_TOOLS.SCYTHE.get(), IcariaItems.KASSITEROS_TOOLS.BIDENT.get(), IcariaItems.KASSITEROS_INGOT.get());
		toolRecipes(consumer, IcariaItems.ORICHALCUM_TOOLS.SWORD.get(), IcariaItems.ORICHALCUM_TOOLS.SHOVEL.get(), IcariaItems.ORICHALCUM_TOOLS.PICKAXE.get(), IcariaItems.ORICHALCUM_TOOLS.AXE.get(), IcariaItems.ORICHALCUM_TOOLS.SCYTHE.get(), IcariaItems.ORICHALCUM_TOOLS.BIDENT.get(), IcariaItems.ORICHALCUM_INGOT.get());
		toolRecipes(consumer, IcariaItems.VANADIUMSTEEL_TOOLS.SWORD.get(), IcariaItems.VANADIUMSTEEL_TOOLS.SHOVEL.get(), IcariaItems.VANADIUMSTEEL_TOOLS.PICKAXE.get(), IcariaItems.VANADIUMSTEEL_TOOLS.AXE.get(), IcariaItems.VANADIUMSTEEL_TOOLS.SCYTHE.get(), IcariaItems.VANADIUMSTEEL_TOOLS.BIDENT.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		toolRecipes(consumer, IcariaItems.SIDEROS_TOOLS.SWORD.get(), IcariaItems.SIDEROS_TOOLS.SHOVEL.get(), IcariaItems.SIDEROS_TOOLS.PICKAXE.get(), IcariaItems.SIDEROS_TOOLS.AXE.get(), IcariaItems.SIDEROS_TOOLS.SCYTHE.get(), IcariaItems.SIDEROS_TOOLS.BIDENT.get(), IcariaItems.SIDEROS_INGOT.get());
		toolRecipes(consumer, IcariaItems.MOLYBDENUMSTEEL_TOOLS.SWORD.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.SHOVEL.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.PICKAXE.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.AXE.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.SCYTHE.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.BIDENT.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());

		foodCookingRecipes(consumer, IcariaItems.RAW_AETERNAE_MEAT.get(), IcariaItems.COOKED_AETERNAE_MEAT.get());
		foodCookingRecipes(consumer, IcariaItems.RAW_CATOBLEPAS_MEAT.get(), IcariaItems.COOKED_CATOBLEPAS_MEAT.get());
		foodCookingRecipes(consumer, IcariaItems.RAW_CERVER_MEAT.get(), IcariaItems.COOKED_CERVER_MEAT.get());
		foodCookingRecipes(consumer, IcariaItems.RAW_SOW_MEAT.get(), IcariaItems.COOKED_SOW_MEAT.get());

		for (StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
			if (deco.SLAB != null) {
				ShapedRecipeBuilder.shaped(deco.SLAB.get(), 6)
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_slab_crafting"));

				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.SLAB.get(), 2)
					.unlockedBy("has_block", has(deco.originalItem.get()))
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

				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.STAIRS.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_stairs_cutting"));
			}

			if (deco.WALL != null) {
				ShapedRecipeBuilder.shaped(deco.WALL.get(), 6)
					.pattern("XXX")
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_wall_crafting"));

				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.WALL.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_wall_cutting"));
			}
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			if (deco.SLAB != null) {
				ShapedRecipeBuilder.shaped(deco.SLAB.get(), 6)
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_slab_crafting"));
			}

			if (deco.STAIRS != null) {
				ShapedRecipeBuilder.shaped(deco.STAIRS.get(), 4)
					.pattern("X  ")
					.pattern("XX ")
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_stairs_crafting"));
			}

			if (deco.FENCE != null) {
				ShapedRecipeBuilder.shaped(deco.FENCE.get(), 3)
					.pattern("XYX")
					.pattern("XYX")
					.define('X', deco.originalItem.get())
					.define('Y', Items.STICK)
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_fence_crafting"));
			}

			if (deco.GATE != null) {
				ShapedRecipeBuilder.shaped(deco.GATE.get(), 1)
					.pattern("YXY")
					.pattern("YXY")
					.define('X', deco.originalItem.get())
					.define('Y', Items.STICK)
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_fence_gate_crafting"));
			}
		}

		// DOLOMITE
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
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_SMOOTH.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_BRICKS.getId(), "_crafting"));

		ShapedRecipeBuilder.shaped(IcariaItems.DOLOMITE_PILLAR.get(), 2)
			.pattern("X")
			.pattern("X")
			.define('X', IcariaItems.DOLOMITE_BRICKS.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR.getId(), "_crafting"));

		ShapedRecipeBuilder.shaped(IcariaItems.DOLOMITE_PILLAR_HEAD.get(), 2)
			.pattern("X")
			.pattern("Y")
			.define('X', IcariaItems.DOLOMITE_BRICKS.get())
			.define('Y', IcariaItems.DOLOMITE_PILLAR.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_PILLAR.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_crafting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_SMOOTH.get()), IcariaItems.DOLOMITE_BRICKS.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_SMOOTH.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_BRICKS.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_SMOOTH.get()), IcariaItems.DOLOMITE_PILLAR.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_SMOOTH.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_BRICKS.get()), IcariaItems.DOLOMITE_PILLAR.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR.getId(), "_cutting_bricks"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_SMOOTH.get()), IcariaItems.DOLOMITE_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_SMOOTH.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_BRICKS.get()), IcariaItems.DOLOMITE_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_cutting_bricks"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.DOLOMITE_PILLAR.get()), IcariaItems.DOLOMITE_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(IcariaItems.DOLOMITE_PILLAR.get()))
			.save(consumer, appendResource(IcariaItems.DOLOMITE_PILLAR_HEAD.getId(), "_cutting_pillar"));

		// GRAINITE
		ShapedRecipeBuilder.shaped(IcariaItems.GRAINITE.get())
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.GRAINEL.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINEL.get()))
			.save(consumer, IcariaItems.GRAINITE.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.GRAINITE_BRICKS.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.GRAINITE.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINITE.get()))
			.save(consumer, appendResource(IcariaItems.GRAINITE_BRICKS.getId(), "_crafting"));

		ShapedRecipeBuilder.shaped(IcariaItems.GRAINITE_CHISELED.get())
			.pattern("X")
			.pattern("X")
			.define('X', Objects.requireNonNull(IcariaItems.GRAINITE_BRICKS_DECO.SLAB).get())
			.unlockedBy("has_block", has(IcariaItems.GRAINITE_BRICKS_DECO.SLAB.get()))
			.save(consumer, appendResource(IcariaItems.GRAINITE_CHISELED.getId(), "_crafting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE.get()), IcariaItems.GRAINITE_BRICKS.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINITE.get()))
			.save(consumer, appendResource(IcariaItems.GRAINITE_BRICKS.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE.get()), IcariaItems.GRAINITE_CHISELED.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINITE.get()))
			.save(consumer, appendResource(IcariaItems.GRAINITE_CHISELED.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE_BRICKS.get()), IcariaItems.GRAINITE_CHISELED.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINITE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.GRAINITE_CHISELED.getId(), "_cutting_bricks"));

		// RELICSTONE
		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_BRICKS.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.RELICSTONE.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_BRICKS.getId(), "_crafting"));

		ShapelessRecipeBuilder.shapeless(IcariaItems.RELICSTONE_BRICKS_MOSSY.get())
			.requires(IcariaItems.RELICSTONE_BRICKS.get())
			.requires(Items.MOSS_BLOCK)
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, IcariaItems.RELICSTONE_BRICKS_MOSSY.getId() + "_from_moss");

		ShapelessRecipeBuilder.shapeless(IcariaItems.RELICSTONE_BRICKS_MOSSY.get())
			.requires(IcariaItems.RELICSTONE_BRICKS.get())
			.requires(Items.VINE)
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, IcariaItems.RELICSTONE_BRICKS_MOSSY.getId() + "_from_vine");

		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_TILES.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.RELICSTONE_BRICKS.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_TILES.getId(), "_crafting"));

		ShapelessRecipeBuilder.shapeless(IcariaItems.RELICSTONE_TILES_MOSSY.get())
			.requires(IcariaItems.RELICSTONE_TILES.get())
			.requires(Items.MOSS_BLOCK)
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_TILES.get()))
			.save(consumer, IcariaItems.RELICSTONE_TILES_MOSSY.getId() + "_from_moss");

		ShapelessRecipeBuilder.shapeless(IcariaItems.RELICSTONE_TILES_MOSSY.get())
			.requires(IcariaItems.RELICSTONE_TILES.get())
			.requires(Items.VINE)
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_TILES.get()))
			.save(consumer, IcariaItems.RELICSTONE_TILES_MOSSY.getId() + "_from_vine");

		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_CHISELED.get())
			.pattern("X")
			.pattern("X")
			.define('X', Objects.requireNonNull(IcariaItems.RELICSTONE_BRICKS_DECO.SLAB).get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS_DECO.SLAB.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_CHISELED.getId(), "_crafting"));

		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_PILLAR.get(), 2)
			.pattern("X")
			.pattern("X")
			.define('X', IcariaItems.RELICSTONE_BRICKS.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR.getId(), "_crafting"));

		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_PILLAR_HEAD.get(), 2)
			.pattern("X")
			.pattern("Y")
			.define('X', IcariaItems.RELICSTONE_BRICKS.get())
			.define('Y', IcariaItems.RELICSTONE_PILLAR.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_PILLAR.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_crafting"));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_SMOOTH.get(), 0.1F, 200)
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE.get()))
			.save(consumer, IcariaItems.RELICSTONE_SMOOTH.getId());

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_BRICKS_CRACKED.get(), 0.1F, 200)
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, IcariaItems.RELICSTONE_BRICKS_CRACKED.getId());

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE_TILES.get()), IcariaItems.RELICSTONE_TILES_CRACKED.get(), 0.1F, 200)
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_TILES.get()))
			.save(consumer, IcariaItems.RELICSTONE_TILES_CRACKED.getId());

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_BRICKS.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_BRICKS.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_TILES.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_TILES.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_TILES.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_TILES.getId(), "_cutting_bricks"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_CHISELED.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_CHISELED.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_CHISELED.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_CHISELED.getId(), "_cutting_bricks"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_PILLAR.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_PILLAR.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR.getId(), "_cutting_bricks"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), IcariaItems.RELICSTONE_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), IcariaItems.RELICSTONE_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_cutting_bricks"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE_PILLAR.get()), IcariaItems.RELICSTONE_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_PILLAR.get()))
			.save(consumer, appendResource(IcariaItems.RELICSTONE_PILLAR_HEAD.getId(), "_cutting_pillar"));

		// QUARTZ
		ShapedRecipeBuilder.shaped(IcariaItems.QUARTZ_PILLAR_HEAD.get(), 2)
			.pattern("X")
			.pattern("Y")
			.define('X', Items.QUARTZ_BRICKS)
			.define('Y', Items.QUARTZ_PILLAR)
			.unlockedBy("has_block", has(Items.QUARTZ_PILLAR))
			.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_crafting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.QUARTZ_BLOCK), IcariaItems.QUARTZ_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(Items.QUARTZ_BLOCK))
			.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.QUARTZ_BRICKS), IcariaItems.QUARTZ_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(Items.QUARTZ_BRICKS))
			.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_cutting_bricks"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.QUARTZ_PILLAR), IcariaItems.QUARTZ_PILLAR_HEAD.get())
			.unlockedBy("has_block", has(Items.QUARTZ_PILLAR))
			.save(consumer, appendResource(IcariaItems.QUARTZ_PILLAR_HEAD.getId(), "_cutting_pillar"));

		// MISC
		ShapedRecipeBuilder.shaped(IcariaItems.MARL_COARSE.get(), 4)
			.pattern("XY")
			.pattern("YX")
			.define('Y', IcariaItems.MARL.get())
			.define('X', IcariaItems.GRAINEL.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINEL.get()))
			.save(consumer, IcariaItems.MARL_COARSE.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.ARISTONE_PACKED.get())
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', IcariaItems.ARISTONE.get())
			.unlockedBy("has_block", has(IcariaItems.ARISTONE.get()))
			.save(consumer, IcariaItems.ARISTONE_PACKED.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.SPELT_BREAD.get())
			.pattern("XXX")
			.define('X', IcariaItems.SPELT.get())
			.unlockedBy("has_item", has(IcariaItems.SPELT.get()))
			.save(consumer, IcariaItems.SPELT_BREAD.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.FLASK_EMPTY.get(), 3)
			.pattern("X X")
			.pattern(" X ")
			.define('X', IcariaItems.SILKGLASS.get())
			.unlockedBy("has_block", has(IcariaItems.SILKGLASS.get()))
			.save(consumer, IcariaItems.FLASK_EMPTY.getId());

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.SPELT_FLOUR.get()), IcariaItems.SPELT_BREAD.get(), 0.3F, 200)
			.unlockedBy("has_item", has(IcariaItems.SPELT_FLOUR.get()))
			.save(consumer, appendResource(IcariaItems.SPELT_BREAD.getId(), "_smelting"));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.LOAM_LUMP.get()), IcariaItems.LOAM_BRICK.get(), 0.3F, 200)
			.unlockedBy("has_item", has(IcariaItems.LOAM_LUMP.get()))
			.save(consumer, appendResource(IcariaItems.LOAM_BRICK.getId(), "_smelting"));

		// VANILLA
		ShapedRecipeBuilder.shaped(Items.BOOK, 1)
			.pattern("XX")
			.pattern("XY")
			.define('X', Items.PAPER)
			.define('Y', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.BOOK.getRegistryName()), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.COMPARATOR)
			.pattern(" X ")
			.pattern("XYX")
			.pattern("ZZZ")
			.define('X', Items.REDSTONE_TORCH)
			.define('Y', Items.QUARTZ)
			.define('Z', IcariaItems.RELICSTONE_SMOOTH.get())
			.unlockedBy("has_stone", has(IcariaItems.RELICSTONE_SMOOTH.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.COMPARATOR.getRegistryName()), "_from_relicstone"));

		ShapedRecipeBuilder.shaped(Items.ITEM_FRAME, 1)
			.pattern("XXX")
			.pattern("XYX")
			.pattern("XXX")
			.define('X', Items.STICK)
			.define('Y', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.ITEM_FRAME.getRegistryName()), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_BOOTS, 1)
			.pattern("X X")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.LEATHER_BOOTS.getRegistryName()), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_CHESTPLATE, 1)
			.pattern("X X")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.LEATHER_CHESTPLATE.getRegistryName()), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_HELMET, 1)
			.pattern("XXX")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.LEATHER_HELMET.getRegistryName()), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_HORSE_ARMOR, 1)
			.pattern("X X")
			.pattern("XXX")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.LEATHER_HORSE_ARMOR.getRegistryName()), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_LEGGINGS, 1)
			.pattern("XXX")
			.pattern("X X")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.LEATHER_LEGGINGS.getRegistryName()), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.PAPER, 3)
			.pattern("XXX")
			.define('X', IcariaItems.VINE_REED.get())
			.unlockedBy("has_item", has(IcariaItems.VINE_REED.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.PAPER.getRegistryName()), "_from_vine_reeds"));

		ShapedRecipeBuilder.shaped(Items.REPEATER)
			.pattern("XYX")
			.pattern("ZZZ")
			.define('X', Items.REDSTONE_TORCH)
			.define('Y', Items.REDSTONE)
			.define('Z', IcariaItems.RELICSTONE_SMOOTH.get())
			.unlockedBy("has_stone", has(IcariaItems.RELICSTONE_SMOOTH.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.REPEATER.getRegistryName()), "_from_relicstone"));

		ShapedRecipeBuilder.shaped(Items.STONECUTTER)
			.pattern(" X ")
			.pattern("YYY")
			.define('X', Items.IRON_INGOT)
			.define('Y', IcariaItems.RELICSTONE_SMOOTH.get())
			.unlockedBy("has_stone", has(IcariaItems.RELICSTONE_SMOOTH.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.STONECUTTER.getRegistryName()), "_from_relicstone"));

		ShapelessRecipeBuilder.shapeless(Items.SUGAR)
			.requires(IcariaItems.VINE_REED.get())
			.unlockedBy("has_item", has(IcariaItems.VINE_REED.get()))
			.save(consumer, appendResource(Objects.requireNonNull(Items.SUGAR.getRegistryName()), "_from_vine_reeds"));
	}

	public void stoneRecipes(Consumer<FinishedRecipe> consumer, Item cobble, Item stone, Item bricks, Item chiseled, StoneDecoItemBlocks deco) {
		ShapedRecipeBuilder.shaped(bricks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', stone)
			.unlockedBy("has_block", has(stone))
			.save(consumer, appendResource(Objects.requireNonNull(bricks.getRegistryName()), "_crafting"));

		ShapedRecipeBuilder.shaped(chiseled, 1)
			.pattern("X")
			.pattern("X")
			.define('X', Objects.requireNonNull(deco.SLAB).get())
			.unlockedBy("has_block", has(deco.SLAB.get()))
			.save(consumer, appendResource(Objects.requireNonNull(chiseled.getRegistryName()), "_crafting"));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(cobble), stone, 0.1F, 200)
			.unlockedBy("has_block", has(cobble))
			.save(consumer, appendResource(Objects.requireNonNull(stone.getRegistryName()), "_smelting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), bricks)
			.unlockedBy("has_block", has(stone))
			.save(consumer, appendResource(bricks.getRegistryName(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), chiseled)
			.unlockedBy("has_block", has(stone))
			.save(consumer, appendResource(chiseled.getRegistryName(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), chiseled)
			.unlockedBy("has_block", has(bricks))
			.save(consumer, appendResource(chiseled.getRegistryName(), "_cutting_bricks"));
	}

	public void glassRecipes(Consumer<FinishedRecipe> consumer, Item sand, Item glass, Item pane, Item horizontalPane) {
		ShapedRecipeBuilder.shaped(pane, 16)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', glass)
			.unlockedBy("has_block", has(glass))
			.save(consumer, Objects.requireNonNull(pane.getRegistryName()));

		ShapedRecipeBuilder.shaped(horizontalPane, 2)
			.pattern("XX")
			.define('X', pane)
			.unlockedBy("has_block", has(pane))
			.save(consumer, Objects.requireNonNull(horizontalPane.getRegistryName()));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(sand), glass, 0.1F, 200)
			.unlockedBy("has_block", has(sand))
			.save(consumer, Objects.requireNonNull(glass.getRegistryName()));
	}

	public void smallCompressRecipe(Consumer<FinishedRecipe> consumer, Item compressed, Item uncompressed) {
		ShapedRecipeBuilder.shaped(compressed, 1)
			.pattern("XX")
			.pattern("XX")
			.define('X', uncompressed)
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(Objects.requireNonNull(uncompressed.getRegistryName()), "_compress"));
	}

	public void smallCompressDecompressRecipes(Consumer<FinishedRecipe> consumer, Item compressed, Item uncompressed) {
		ShapedRecipeBuilder.shaped(compressed, 1)
			.pattern("XX")
			.pattern("XX")
			.define('X', uncompressed)
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(Objects.requireNonNull(uncompressed.getRegistryName()), "_compress"));

		ShapelessRecipeBuilder.shapeless(uncompressed, 4)
			.requires(compressed)
			.unlockedBy("has_compressed", has(compressed))
			.save(consumer, appendResource(Objects.requireNonNull(compressed.getRegistryName()), "_decompress"));
	}

	public void largeCompressDecompressRecipes(Consumer<FinishedRecipe> consumer, Item compressed, Item uncompressed) {
		ShapedRecipeBuilder.shaped(compressed, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', uncompressed)
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(Objects.requireNonNull(uncompressed.getRegistryName()), "_compress"));

		ShapelessRecipeBuilder.shapeless(uncompressed, 9)
			.requires(compressed)
			.unlockedBy("has_compressed", has(compressed))
			.save(consumer, appendResource(Objects.requireNonNull(compressed.getRegistryName()), "_decompress"));
	}

	public void woodRecipes(Consumer<FinishedRecipe> consumer, Item wood, Item strippedWood, Item log, Item strippedLog) {
		ShapedRecipeBuilder.shaped(wood, 3)
			.pattern("XX")
			.pattern("XX")
			.define('X', log)
			.unlockedBy("has_block", has(log))
			.save(consumer, Objects.requireNonNull(wood.getRegistryName()));

		ShapedRecipeBuilder.shaped(strippedWood, 3)
			.pattern("XX")
			.pattern("XX")
			.define('X', strippedLog)
			.unlockedBy("has_block", has(strippedLog))
			.save(consumer, Objects.requireNonNull(strippedWood.getRegistryName()));
	}

	public void planksRecipes(Consumer<FinishedRecipe> consumer, Item wood, Item strippedWood, Item log, Item strippedLog, Item planks) {
		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', wood)
			.unlockedBy("has_block", has(wood))
			.save(consumer, planks.getRegistryName() + "_from_wood");

		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', strippedWood)
			.unlockedBy("has_block", has(strippedWood))
			.save(consumer, planks.getRegistryName() + "_from_stripped_wood");

		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', log)
			.unlockedBy("has_block", has(log))
			.save(consumer, planks.getRegistryName() + "_from_log");

		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', strippedLog)
			.unlockedBy("has_block", has(strippedLog))
			.save(consumer, planks.getRegistryName() + "_from_stripped_log");
	}

	public void doorRecipe(Consumer<FinishedRecipe> consumer, Item door, Item planks) {
		ShapedRecipeBuilder.shaped(door, 3)
			.pattern("XX")
			.pattern("XX")
			.pattern("XX")
			.define('X', planks)
			.unlockedBy("has_block", has(planks))
			.save(consumer, Objects.requireNonNull(door.getRegistryName()));
	}

	public void trapdoorRecipe(Consumer<FinishedRecipe> consumer, Item trapdoor, Item planks) {
		ShapedRecipeBuilder.shaped(trapdoor, 2)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', planks)
			.unlockedBy("has_block", has(planks))
			.save(consumer, Objects.requireNonNull(trapdoor.getRegistryName()));
	}

	public void ladderRecipe(Consumer<FinishedRecipe> consumer, Item ladder, Item planks) {
		ShapedRecipeBuilder.shaped(ladder, 6)
			.pattern("X X")
			.pattern("XXX")
			.pattern("X X")
			.define('X', planks)
			.unlockedBy("has_block", has(planks))
			.save(consumer, Objects.requireNonNull(ladder.getRegistryName()));
	}

	public void torchRecipe(Consumer<FinishedRecipe> consumer, Item torch, Item gem) {
		ShapedRecipeBuilder.shaped(torch, 2)
			.pattern("X")
			.pattern("Y")
			.define('X', gem)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.unlockedBy("has_gem", has(gem))
			.save(consumer, Objects.requireNonNull(torch.getRegistryName()));
	}

	public void blockIngotNuggetRecipes(Consumer<FinishedRecipe> consumer, Item block, Item ingot, Item nugget) {
		ShapedRecipeBuilder.shaped(block, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', ingot)
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, appendResource(Objects.requireNonNull(ingot.getRegistryName()), "_to_block"));

		ShapedRecipeBuilder.shaped(ingot, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', nugget)
			.unlockedBy("has_nugget", has(nugget))
			.save(consumer, appendResource(Objects.requireNonNull(nugget.getRegistryName()), "_to_ingot"));

		ShapelessRecipeBuilder.shapeless(ingot, 9)
			.requires(block)
			.unlockedBy("has_block", has(block))
			.save(consumer, appendResource((Objects.requireNonNull(block.getRegistryName())), "_to_ingot"));

		ShapelessRecipeBuilder.shapeless(nugget, 9)
			.requires(ingot)
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, appendResource(Objects.requireNonNull(ingot.getRegistryName()), "_to_nugget"));
	}

	public void gemSmeltingRecipe(Consumer<FinishedRecipe> consumer, Item ore, Item result) {
		SimpleCookingRecipeBuilder.smelting((Ingredient.of(ore)), result, 0.7F, 200)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, result.asItem().getRegistryName() + "_from_smelting_ore");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(ore)), result, 0.7F, 100)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, result.asItem().getRegistryName() + "_from_blasting_ore");
	}

	public void ingotSmeltingRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item raw, Item result) {
		SimpleCookingRecipeBuilder.smelting((Ingredient.of(ore)), result, 0.7F, 200)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, result.asItem().getRegistryName() + "_from_smelting_ore");

		SimpleCookingRecipeBuilder.smelting((Ingredient.of(raw)), result, 0.7F, 200)
			.unlockedBy("has_ingredient", has(raw))
			.save(consumer, result.asItem().getRegistryName() + "_from_smelting_raw");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(ore)), result, 0.7F, 100)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, result.asItem().getRegistryName() + "_from_blasting_ore");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(raw)), result, 0.7F, 100)
			.unlockedBy("has_ingredient", has(raw))
			.save(consumer, result.asItem().getRegistryName() + "_from_blasting_raw");
	}

	public void toolRecipes(Consumer<FinishedRecipe> consumer, Item sword, Item shovel, Item pickaxe, Item axe, Item scythe, Item bident, Item resource) {
		ShapedRecipeBuilder.shaped(sword, 1)
			.pattern("X")
			.pattern("X")
			.pattern("Y")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(sword.getRegistryName()));

		ShapedRecipeBuilder.shaped(shovel, 1)
			.pattern("X")
			.pattern("Y")
			.pattern("Y")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(shovel.getRegistryName()));

		ShapedRecipeBuilder.shaped(pickaxe, 1)
			.pattern("XXX")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(pickaxe.getRegistryName()));

		ShapedRecipeBuilder.shaped(axe, 1)
			.pattern("XX ")
			.pattern("XY ")
			.pattern(" Y ")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(axe.getRegistryName()));

		ShapedRecipeBuilder.shaped(scythe, 1)
			.pattern(" XX")
			.pattern("X Y")
			.pattern("  Y")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(scythe.getRegistryName()));

		ShapedRecipeBuilder.shaped(bident, 1)
			.pattern("X X")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(bident.getRegistryName()));
	}

	public void foodCookingRecipes(Consumer<FinishedRecipe> consumer, Item ingredient, Item result) {
		SimpleCookingRecipeBuilder.campfireCooking((Ingredient.of(ingredient)), result, 0.35F, 600)
			.unlockedBy("has_ingredient", has(ingredient))
			.save(consumer, result.asItem().getRegistryName() + "_from_campfire_cooking");

		SimpleCookingRecipeBuilder.smelting((Ingredient.of(ingredient)), result, 0.35F, 200)
			.unlockedBy("has_ingredient", has(ingredient))
			.save(consumer, result.asItem().getRegistryName() + "_from_smelting");

		SimpleCookingRecipeBuilder.smoking((Ingredient.of(ingredient)), result, 0.35F, 100)
			.unlockedBy("has_ingredient", has(ingredient))
			.save(consumer, result.asItem().getRegistryName() + "_from_smoking");
	}

	public ResourceLocation appendResource(ResourceLocation location, String suffix) {
		return new ResourceLocation(location.getNamespace(), location.getPath() + suffix);
	}
}
