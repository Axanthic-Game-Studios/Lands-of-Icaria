package com.axanthic.icaria.data;

import java.util.Objects;
import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

import com.axanthic.icaria.common.recipe.GrinderRecipeBuilder;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.CompoundIngredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipes extends RecipeProvider implements IConditionBuilder {
	public IcariaRecipes(DataGenerator generator) {
		super(generator);
	}

	@Override
	public void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		this.smeltingRecipe(consumer, IcariaItems.CARDON_CACTUS.get(), Items.GREEN_DYE, 1.0F, 200);
		this.smeltingRecipe(consumer, IcariaItems.LOAM_LUMP.get(), IcariaItems.LOAM_BRICK.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.UNFIRED_STORAGE_VASE.get(), IcariaItems.STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get(), IcariaItems.WHITE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get(), IcariaItems.ORANGE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get(), IcariaItems.MAGENTA_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get(), IcariaItems.LIGHT_BLUE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get(), IcariaItems.YELLOW_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.LIME_UNFIRED_STORAGE_VASE.get(), IcariaItems.LIME_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.PINK_UNFIRED_STORAGE_VASE.get(), IcariaItems.PINK_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get(), IcariaItems.GRAY_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get(), IcariaItems.LIGHT_GRAY_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get(), IcariaItems.CYAN_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get(), IcariaItems.PURPLE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get(), IcariaItems.BLUE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get(), IcariaItems.BROWN_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get(), IcariaItems.GREEN_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.RED_UNFIRED_STORAGE_VASE.get(), IcariaItems.RED_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get(), IcariaItems.BLACK_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.SPELT_FLOUR.get(), IcariaItems.SPELT_BREAD.get(), 0.3F, 200);
		this.smeltingRecipe(consumer, IcariaItems.LOAM_BOWL_UNFIRED.get(), IcariaItems.LOAM_BOWL.get(), 0.3F, 200);

		this.bowlFlaskTypeRecipe(consumer, IcariaItems.SILKGLASS.get(), IcariaItems.FLASK_EMPTY.get(), 3);
		this.bowlFlaskTypeRecipe(consumer, IcariaItems.LOAM_LUMP.get(), IcariaItems.LOAM_BOWL_UNFIRED.get(), 4);

		this.threeIngredientStewRecipe(consumer, IcariaItems.ONION.get(), IcariaItemTags.bind("forge:crops/onion"), IcariaItemTags.bind("forge:crops/onion"), IcariaItems.SOUP_ONION.get());
		this.twoIngredientStewRecipe(consumer, IcariaItems.COOKED_AETERNAE_MEAT.get(), Items.BEETROOT, IcariaItems.STEW_AETERNAE.get());
		this.twoIngredientStewRecipe(consumer, IcariaItems.COOKED_CERVER_MEAT.get(), Items.CARROT, IcariaItems.STEW_CERVER.get());
		this.twoIngredientStewRecipe(consumer, IcariaItems.COOKED_CATOBLEPAS_MEAT.get(), IcariaItems.ONION.get(), IcariaItems.STEW_CATOBLEPAS.get());
		this.threeIngredientStewRecipe(consumer, IcariaItems.COOKED_SOW_MEAT.get(), IcariaItemTags.bind("forge:mushrooms"), IcariaItemTags.bind("forge:mushrooms"), IcariaItems.STEW_SOW.get());

		this.glassRecipes(consumer, IcariaItems.GRAINEL.get(), IcariaItems.GRAINGLASS.get(), IcariaItems.GRAINGLASS_PANE.get(), IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get());
		this.glassRecipes(consumer, IcariaItems.SILKSAND.get(), IcariaItems.SILKGLASS.get(), IcariaItems.SILKGLASS_PANE.get(), IcariaItems.SILKGLASS_PANE_HORIZONTAL.get());

		this.stoneRecipes(consumer, IcariaItems.YELLOWSTONE_COBBLE.get(), IcariaItems.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_BRICKS.get(), IcariaItems.YELLOWSTONE_CHISELED.get(), IcariaItems.YELLOWSTONE_BRICKS_DECO);
		this.stoneRecipes(consumer, IcariaItems.SILKSTONE_COBBLE.get(), IcariaItems.SILKSTONE.get(), IcariaItems.SILKSTONE_BRICKS.get(), IcariaItems.SILKSTONE_CHISELED.get(), IcariaItems.SILKSTONE_BRICKS_DECO);
		this.stoneRecipes(consumer, IcariaItems.SUNSTONE_COBBLE.get(), IcariaItems.SUNSTONE.get(), IcariaItems.SUNSTONE_BRICKS.get(), IcariaItems.SUNSTONE_CHISELED.get(), IcariaItems.SUNSTONE_BRICKS_DECO);
		this.stoneRecipes(consumer, IcariaItems.VOIDSHALE_COBBLE.get(), IcariaItems.VOIDSHALE.get(), IcariaItems.VOIDSHALE_BRICKS.get(), IcariaItems.VOIDSHALE_CHISELED.get(), IcariaItems.VOIDSHALE_BRICKS_DECO);
		this.stoneRecipes(consumer, IcariaItems.BAETYL_COBBLE.get(), IcariaItems.BAETYL.get(), IcariaItems.BAETYL_BRICKS.get(), IcariaItems.BAETYL_CHISELED.get(), IcariaItems.BAETYL_BRICKS_DECO);

		this.smallCompressRecipe(consumer, IcariaItems.LOAM_BRICKS.get(), IcariaItems.LOAM_BRICK.get());
		this.smallCompressRecipe(consumer, IcariaItems.SILKSTONE.get(), IcariaItems.SILKSAND.get());
		this.smallCompressRecipe(consumer, IcariaItems.CALCITE_GEODE_BLOCK.get(), IcariaItems.CALCITE.get());
		this.smallCompressRecipe(consumer, IcariaItems.HALITE_GEODE_BLOCK.get(), IcariaItems.HALITE.get());
		this.smallCompressRecipe(consumer, IcariaItems.JASPER_GEODE_BLOCK.get(), IcariaItems.JASPER.get());
		this.smallCompressRecipe(consumer, IcariaItems.ZIRCON_GEODE_BLOCK.get(), IcariaItems.ZIRCON.get());
		this.smallCompressRecipe(consumer, IcariaItems.CYPRESS_CRAFTING_TABLE.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.smallCompressRecipe(consumer, IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.smallCompressRecipe(consumer, IcariaItems.FIR_CRAFTING_TABLE.get(), IcariaItems.FIR_PLANKS.get());
		this.smallCompressRecipe(consumer, IcariaItems.LAUREL_CRAFTING_TABLE.get(), IcariaItems.LAUREL_PLANKS.get());
		this.smallCompressRecipe(consumer, IcariaItems.OLIVE_CRAFTING_TABLE.get(), IcariaItems.OLIVE_PLANKS.get());
		this.smallCompressRecipe(consumer, IcariaItems.PLANE_CRAFTING_TABLE.get(), IcariaItems.PLANE_PLANKS.get());
		this.smallCompressRecipe(consumer, IcariaItems.POPULUS_CRAFTING_TABLE.get(), IcariaItems.POPULUS_PLANKS.get());

		this.smallCompressDecompressRecipes(consumer, IcariaItems.LOAM.get(), IcariaItems.LOAM_LUMP.get());
		this.smallCompressDecompressRecipes(consumer, IcariaItems.VINE_SPROUT_BLOCK.get(), IcariaItems.VINE_SPROUT.get());

		this.largeCompressDecompressRecipes(consumer, IcariaItems.JELLYFISH_JELLY_BLOCK.get(), IcariaItems.JELLYFISH_JELLY.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.ARACHNE_STRING_BLOCK.get(), IcariaItems.ARACHNE_STRING.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.SPELT_BALE_BLOCK.get(), IcariaItems.SPELT.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.VINE_REED_BLOCK.get(), IcariaItems.VINE_REED.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.ROTTEN_BONES_BLOCK.get(), IcariaItems.ROTTEN_BONES.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.CALCITE_BLOCK.get(), IcariaItems.CALCITE.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.HALITE_BLOCK.get(), IcariaItems.HALITE.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.JASPER_BLOCK.get(), IcariaItems.JASPER.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.ZIRCON_BLOCK.get(), IcariaItems.ZIRCON.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.CHALKOS_RAW_BLOCK.get(), IcariaItems.CHALKOS_RAW.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.KASSITEROS_RAW_BLOCK.get(), IcariaItems.KASSITEROS_RAW.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.VANADIUM_RAW_BLOCK.get(), IcariaItems.VANADIUM_RAW.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.SIDEROS_RAW_BLOCK.get(), IcariaItems.SIDEROS_RAW.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.MOLYBDENUM_RAW_BLOCK.get(), IcariaItems.MOLYBDENUM_RAW.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.CHERT_BLOCK.get(), IcariaItems.CHERT.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.LIGNITE_BLOCK.get(), IcariaItems.LIGNITE.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.SLIVER_BLOCK.get(), IcariaItems.SLIVER.get());
		this.largeCompressDecompressRecipes(consumer, IcariaItems.ANTHRACITE_BLOCK.get(), IcariaItems.ANTHRACITE.get());

		this.vaseRecipe(consumer, Items.WHITE_DYE, IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.ORANGE_DYE, IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.MAGENTA_DYE, IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.LIGHT_BLUE_DYE, IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.YELLOW_DYE, IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.LIME_DYE, IcariaItems.LIME_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.PINK_DYE, IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.GRAY_DYE, IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.LIGHT_GRAY_DYE, IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.CYAN_DYE, IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.PURPLE_DYE, IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.BLUE_DYE, IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.BROWN_DYE, IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.GREEN_DYE, IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.RED_DYE, IcariaItems.RED_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(consumer, Items.BLACK_DYE, IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get());

		this.woodRecipes(consumer, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get());
		this.woodRecipes(consumer, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
		this.woodRecipes(consumer, IcariaItems.FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.FIR_LOG.get(), IcariaItems.STRIPPED_FIR_LOG.get());
		this.woodRecipes(consumer, IcariaItems.LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.STRIPPED_LAUREL_LOG.get());
		this.woodRecipes(consumer, IcariaItems.OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.STRIPPED_OLIVE_LOG.get());
		this.woodRecipes(consumer, IcariaItems.PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.STRIPPED_PLANE_LOG.get());
		this.woodRecipes(consumer, IcariaItems.POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.STRIPPED_POPULUS_LOG.get());

		this.planksRecipes(consumer, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.planksRecipes(consumer, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.planksRecipes(consumer, IcariaItems.FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.FIR_LOG.get(), IcariaItems.STRIPPED_FIR_LOG.get(), IcariaItems.FIR_PLANKS.get());
		this.planksRecipes(consumer, IcariaItems.LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.STRIPPED_LAUREL_LOG.get(), IcariaItems.LAUREL_PLANKS.get());
		this.planksRecipes(consumer, IcariaItems.OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.STRIPPED_OLIVE_LOG.get(), IcariaItems.OLIVE_PLANKS.get());
		this.planksRecipes(consumer, IcariaItems.PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.STRIPPED_PLANE_LOG.get(), IcariaItems.PLANE_PLANKS.get());
		this.planksRecipes(consumer, IcariaItems.POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.STRIPPED_POPULUS_LOG.get(), IcariaItems.POPULUS_PLANKS.get());

		this.doorRecipe(consumer, IcariaItems.CYPRESS_DOOR.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.doorRecipe(consumer, IcariaItems.DROUGHTROOT_DOOR.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.doorRecipe(consumer, IcariaItems.FIR_DOOR.get(), IcariaItems.FIR_PLANKS.get());
		this.doorRecipe(consumer, IcariaItems.LAUREL_DOOR.get(), IcariaItems.LAUREL_PLANKS.get());
		this.doorRecipe(consumer, IcariaItems.OLIVE_DOOR.get(), IcariaItems.OLIVE_PLANKS.get());
		this.doorRecipe(consumer, IcariaItems.PLANE_DOOR.get(), IcariaItems.PLANE_PLANKS.get());
		this.doorRecipe(consumer, IcariaItems.POPULUS_DOOR.get(), IcariaItems.POPULUS_PLANKS.get());

		this.trapdoorRecipe(consumer, IcariaItems.CYPRESS_TRAPDOOR.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.trapdoorRecipe(consumer, IcariaItems.DROUGHTROOT_TRAPDOOR.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.trapdoorRecipe(consumer, IcariaItems.FIR_TRAPDOOR.get(), IcariaItems.FIR_PLANKS.get());
		this.trapdoorRecipe(consumer, IcariaItems.LAUREL_TRAPDOOR.get(), IcariaItems.LAUREL_PLANKS.get());
		this.trapdoorRecipe(consumer, IcariaItems.OLIVE_TRAPDOOR.get(), IcariaItems.OLIVE_PLANKS.get());
		this.trapdoorRecipe(consumer, IcariaItems.PLANE_TRAPDOOR.get(), IcariaItems.PLANE_PLANKS.get());
		this.trapdoorRecipe(consumer, IcariaItems.POPULUS_TRAPDOOR.get(), IcariaItems.POPULUS_PLANKS.get());

		this.ladderRecipe(consumer, IcariaItems.CYPRESS_LADDER.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.ladderRecipe(consumer, IcariaItems.DROUGHTROOT_LADDER.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.ladderRecipe(consumer, IcariaItems.FIR_LADDER.get(), IcariaItems.FIR_PLANKS.get());
		this.ladderRecipe(consumer, IcariaItems.LAUREL_LADDER.get(), IcariaItems.LAUREL_PLANKS.get());
		this.ladderRecipe(consumer, IcariaItems.OLIVE_LADDER.get(), IcariaItems.OLIVE_PLANKS.get());
		this.ladderRecipe(consumer, IcariaItems.PLANE_LADDER.get(), IcariaItems.PLANE_PLANKS.get());
		this.ladderRecipe(consumer, IcariaItems.POPULUS_LADDER.get(), IcariaItems.POPULUS_PLANKS.get());

		this.signRecipe(consumer, IcariaItems.CYPRESS_SIGN.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.signRecipe(consumer, IcariaItems.DROUGHTROOT_SIGN.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.signRecipe(consumer, IcariaItems.FIR_SIGN.get(), IcariaItems.FIR_PLANKS.get());
		this.signRecipe(consumer, IcariaItems.LAUREL_SIGN.get(), IcariaItems.LAUREL_PLANKS.get());
		this.signRecipe(consumer, IcariaItems.OLIVE_SIGN.get(), IcariaItems.OLIVE_PLANKS.get());
		this.signRecipe(consumer, IcariaItems.PLANE_SIGN.get(), IcariaItems.PLANE_PLANKS.get());
		this.signRecipe(consumer, IcariaItems.POPULUS_SIGN.get(), IcariaItems.POPULUS_PLANKS.get());

		this.torchRecipe(consumer, IcariaItems.LIGNITE_TORCH.get(), IcariaItems.LIGNITE.get());
		this.torchRecipe(consumer, IcariaItems.ANTHRACITE_TORCH.get(), IcariaItems.ANTHRACITE.get());

		this.dyesFromFlowerRecipe(consumer, Items.PINK_DYE, IcariaItems.BLINDWEED.get());
		this.dyesFromFlowerRecipe(consumer, Items.WHITE_DYE, IcariaItems.CHAMEOMILE.get());
		this.dyesFromFlowerRecipe(consumer, Items.LIGHT_BLUE_DYE, IcariaItems.CHARMONDER.get());
		this.dyesFromFlowerRecipe(consumer, Items.WHITE_DYE, IcariaItems.CLOVER.get());
		this.dyesFromFlowerRecipe(consumer, Items.RED_DYE, IcariaItems.FIREHILT.get());
		this.dyesFromFlowerRecipe(consumer, Items.BLUE_DYE, IcariaItems.BLUE_HYDRACINTH.get());
		this.dyesFromFlowerRecipe(consumer, Items.MAGENTA_DYE, IcariaItems.PURPLE_HYDRACINTH.get());
		this.dyesFromFlowerRecipe(consumer, Items.PURPLE_DYE, IcariaItems.LIONFANGS.get());
		this.dyesFromFlowerRecipe(consumer, Items.LIME_DYE, IcariaItems.SPEARDROPS.get());
		this.dyesFromFlowerRecipe(consumer, Items.MAGENTA_DYE, IcariaItems.PURPLE_STAGHORN.get());
		this.dyesFromFlowerRecipe(consumer, Items.YELLOW_DYE, IcariaItems.YELLOW_STAGHORN.get());
		this.dyesFromFlowerRecipe(consumer, Items.BLUE_DYE, IcariaItems.BLUE_STORMCOTTON.get());
		this.dyesFromFlowerRecipe(consumer, Items.MAGENTA_DYE, IcariaItems.PINK_STORMCOTTON.get());
		this.dyesFromFlowerRecipe(consumer, Items.PURPLE_DYE, IcariaItems.PURPLE_STORMCOTTON.get());
		this.dyesFromFlowerRecipe(consumer, Items.YELLOW_DYE, IcariaItems.SUNKETTLE.get());
		this.dyesFromFlowerRecipe(consumer, Items.ORANGE_DYE, IcariaItems.SUNSPONGE.get());
		this.dyesFromFlowerRecipe(consumer, Items.BLACK_DYE, IcariaItems.VOIDLILY.get());
		this.dyesFromFlowerRecipe(consumer, Items.BLUE_DYE, IcariaItems.BLUE_GROUND_FLOWERS.get());
		this.dyesFromFlowerRecipe(consumer, Items.CYAN_DYE, IcariaItems.CYAN_GROUND_FLOWERS.get());
		this.dyesFromFlowerRecipe(consumer, Items.PINK_DYE, IcariaItems.PINK_GROUND_FLOWERS.get());
		this.dyesFromFlowerRecipe(consumer, Items.PURPLE_DYE, IcariaItems.PURPLE_GROUND_FLOWERS.get());
		this.dyesFromFlowerRecipe(consumer, Items.RED_DYE, IcariaItems.RED_GROUND_FLOWERS.get());
		this.dyesFromFlowerRecipe(consumer, Items.WHITE_DYE, IcariaItems.WHITE_GROUND_FLOWERS.get());
		this.dyesFromFlowerRecipe(consumer, Items.WHITE_DYE, IcariaItems.WHITE_BROMELIA.get());
		this.dyesFromFlowerRecipe(consumer, Items.ORANGE_DYE, IcariaItems.ORANGE_BROMELIA.get());
		this.dyesFromFlowerRecipe(consumer, Items.PINK_DYE, IcariaItems.PINK_BROMELIA.get());
		this.dyesFromFlowerRecipe(consumer, Items.PURPLE_DYE, IcariaItems.PURPLE_BROMELIA.get());

		this.blockIngotNuggetRecipes(consumer, IcariaItems.CHALKOS_BLOCK.get(), IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.KASSITEROS_BLOCK.get(), IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.ORICHALCUM_BLOCK.get(), IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.VANADIUM_BLOCK.get(), IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.VANADIUMSTEEL_BLOCK.get(), IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.SIDEROS_BLOCK.get(), IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.MOLYBDENUM_BLOCK.get(), IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.MOLYBDENUM_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.MOLYBDENUMSTEEL_BLOCK.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		this.blockIngotNuggetRecipes(consumer, IcariaItems.BLURIDIUM_BLOCK.get(), IcariaItems.BLURIDIUM_INGOT.get(), IcariaItems.BLURIDIUM_NUGGET.get());

		this.gemSmeltingRecipe(consumer, IcariaItems.LIGNITE_ORE.get(), IcariaItems.LIGNITE.get());
		this.gemSmeltingRecipe(consumer, IcariaItems.DOLOMITE_ORE.get(), IcariaItems.DOLOMITE.get());
		this.gemSmeltingRecipe(consumer, IcariaItems.SLIVER_ORE.get(), IcariaItems.SLIVER.get());
		this.gemSmeltingRecipe(consumer, IcariaItems.ANTHRACITE_ORE.get(), IcariaItems.ANTHRACITE.get());

		this.ingotSmeltingRecipes(consumer, IcariaItems.CHALKOS_ORE.get(), IcariaItems.CHALKOS_RAW.get(), IcariaItems.CHALKOS_INGOT.get());
		this.ingotSmeltingRecipes(consumer, IcariaItems.KASSITEROS_ORE.get(), IcariaItems.KASSITEROS_RAW.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.ingotSmeltingRecipes(consumer, IcariaItems.VANADIUM_ORE.get(), IcariaItems.VANADIUM_RAW.get(), IcariaItems.VANADIUM_INGOT.get());
		this.ingotSmeltingRecipes(consumer, IcariaItems.SIDEROS_ORE.get(), IcariaItems.SIDEROS_RAW.get(), IcariaItems.SIDEROS_INGOT.get());
		this.ingotSmeltingRecipes(consumer, IcariaItems.MOLYBDENUM_ORE.get(), IcariaItems.MOLYBDENUM_RAW.get(), IcariaItems.MOLYBDENUM_INGOT.get());

		this.toolRecipes(consumer, IcariaItems.CHERT_TOOLS.sword.get(), IcariaItems.CHERT_TOOLS.dagger.get(), IcariaItems.CHERT_TOOLS.shovel.get(), IcariaItems.CHERT_TOOLS.pickaxe.get(), IcariaItems.CHERT_TOOLS.axe.get(), IcariaItems.CHERT_TOOLS.scythe.get(), IcariaItems.CHERT_TOOLS.bident.get(), IcariaItems.CHERT.get());
		this.toolRecipes(consumer, IcariaItems.CHALKOS_TOOLS.sword.get(), IcariaItems.CHALKOS_TOOLS.dagger.get(), IcariaItems.CHALKOS_TOOLS.shovel.get(), IcariaItems.CHALKOS_TOOLS.pickaxe.get(), IcariaItems.CHALKOS_TOOLS.axe.get(), IcariaItems.CHALKOS_TOOLS.scythe.get(), IcariaItems.CHALKOS_TOOLS.bident.get(), IcariaItems.CHALKOS_INGOT.get());
		this.toolRecipes(consumer, IcariaItems.KASSITEROS_TOOLS.sword.get(), IcariaItems.KASSITEROS_TOOLS.dagger.get(), IcariaItems.KASSITEROS_TOOLS.shovel.get(), IcariaItems.KASSITEROS_TOOLS.pickaxe.get(), IcariaItems.KASSITEROS_TOOLS.axe.get(), IcariaItems.KASSITEROS_TOOLS.scythe.get(), IcariaItems.KASSITEROS_TOOLS.bident.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.toolRecipes(consumer, IcariaItems.ORICHALCUM_TOOLS.sword.get(), IcariaItems.ORICHALCUM_TOOLS.dagger.get(), IcariaItems.ORICHALCUM_TOOLS.shovel.get(), IcariaItems.ORICHALCUM_TOOLS.pickaxe.get(), IcariaItems.ORICHALCUM_TOOLS.axe.get(), IcariaItems.ORICHALCUM_TOOLS.scythe.get(), IcariaItems.ORICHALCUM_TOOLS.bident.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.toolRecipes(consumer, IcariaItems.VANADIUMSTEEL_TOOLS.sword.get(), IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get(), IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get(), IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.VANADIUMSTEEL_TOOLS.axe.get(), IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get(), IcariaItems.VANADIUMSTEEL_TOOLS.bident.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.toolRecipes(consumer, IcariaItems.SIDEROS_TOOLS.sword.get(), IcariaItems.SIDEROS_TOOLS.dagger.get(), IcariaItems.SIDEROS_TOOLS.shovel.get(), IcariaItems.SIDEROS_TOOLS.pickaxe.get(), IcariaItems.SIDEROS_TOOLS.axe.get(), IcariaItems.SIDEROS_TOOLS.scythe.get(), IcariaItems.SIDEROS_TOOLS.bident.get(), IcariaItems.SIDEROS_INGOT.get());
		this.toolRecipes(consumer, IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());

		this.armorRecipes(consumer, IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get(), IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get(), IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get(), IcariaItems.AETERNAE_HIDE_ARMOR.boots.get(), IcariaItems.AETERNAE_HIDE.get());
		this.armorRecipes(consumer, IcariaItems.CHALKOS_ARMOR.helmet.get(), IcariaItems.CHALKOS_ARMOR.chestplate.get(), IcariaItems.CHALKOS_ARMOR.leggings.get(), IcariaItems.CHALKOS_ARMOR.boots.get(), IcariaItems.CHALKOS_INGOT.get());
		this.armorRecipes(consumer, IcariaItems.KASSITEROS_ARMOR.helmet.get(), IcariaItems.KASSITEROS_ARMOR.chestplate.get(), IcariaItems.KASSITEROS_ARMOR.leggings.get(), IcariaItems.KASSITEROS_ARMOR.boots.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.armorRecipes(consumer, IcariaItems.ORICHALCUM_HELMET.get(), IcariaItems.ORICHALCUM_CHESTPLATE.get(), IcariaItems.ORICHALCUM_LEGGINGS.get(), IcariaItems.ORICHALCUM_BOOTS.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.armorRecipes(consumer, IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get(), IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get(), IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get(), IcariaItems.VANADIUMSTEEL_ARMOR.boots.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());

		this.foodCookingRecipes(consumer, IcariaItems.RAW_AETERNAE_MEAT.get(), IcariaItems.COOKED_AETERNAE_MEAT.get());
		this.foodCookingRecipes(consumer, IcariaItems.RAW_CATOBLEPAS_MEAT.get(), IcariaItems.COOKED_CATOBLEPAS_MEAT.get());
		this.foodCookingRecipes(consumer, IcariaItems.RAW_CERVER_MEAT.get(), IcariaItems.COOKED_CERVER_MEAT.get());
		this.foodCookingRecipes(consumer, IcariaItems.RAW_SOW_MEAT.get(), IcariaItems.COOKED_SOW_MEAT.get());

		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
			if (deco.slab != null) {
				ShapedRecipeBuilder.shaped(deco.slab.get(), 6)
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_slab_crafting"));

				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.slab.get(), 2)
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_slab_cutting"));
			}

			if (deco.stairs != null) {
				ShapedRecipeBuilder.shaped(deco.stairs.get(), 4)
					.pattern("X  ")
					.pattern("XX ")
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_stairs_crafting"));

				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.stairs.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_stairs_cutting"));
			}

			if (deco.wall != null) {
				ShapedRecipeBuilder.shaped(deco.wall.get(), 6)
					.pattern("XXX")
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_wall_crafting"));

				SingleItemRecipeBuilder.stonecutting(Ingredient.of(deco.originalItem.get()), deco.wall.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_wall_cutting"));
			}
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			if (deco.slab != null) {
				ShapedRecipeBuilder.shaped(deco.slab.get(), 6)
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_slab_crafting"));
			}

			if (deco.stairs != null) {
				ShapedRecipeBuilder.shaped(deco.stairs.get(), 4)
					.pattern("X  ")
					.pattern("XX ")
					.pattern("XXX")
					.define('X', deco.originalItem.get())
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_stairs_crafting"));
			}

			if (deco.fence != null) {
				ShapedRecipeBuilder.shaped(deco.fence.get(), 3)
					.pattern("XYX")
					.pattern("XYX")
					.define('X', deco.originalItem.get())
					.define('Y', Items.STICK)
					.unlockedBy("has_block", has(deco.originalItem.get()))
					.save(consumer, new ResourceLocation(this.getName(), deco.originalItem.getId().getPath() + "_fence_crafting"));
			}

			if (deco.gate != null) {
				ShapedRecipeBuilder.shaped(deco.gate.get(), 1)
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
			.define('X', Objects.requireNonNull(IcariaItems.GRAINITE_BRICKS_DECO.slab).get())
			.unlockedBy("has_block", has(IcariaItems.GRAINITE_BRICKS_DECO.slab.get()))
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
			.requires(IcariaItemTags.bind("forge:vines"))
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
			.requires(IcariaItemTags.bind("forge:vines"))
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_TILES.get()))
			.save(consumer, IcariaItems.RELICSTONE_TILES_MOSSY.getId() + "_from_vine");

		ShapedRecipeBuilder.shaped(IcariaItems.RELICSTONE_CHISELED.get())
			.pattern("X")
			.pattern("X")
			.define('X', Objects.requireNonNull(IcariaItems.RELICSTONE_BRICKS_DECO.slab).get())
			.unlockedBy("has_block", has(IcariaItems.RELICSTONE_BRICKS_DECO.slab.get()))
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

		// PLATOSHALE
		ShapedRecipeBuilder.shaped(IcariaItems.PLATOSHALE_BRICKS.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.PLATOSHALE.get())
			.unlockedBy("has_block", has(IcariaItems.PLATOSHALE.get()))
			.save(consumer, appendResource(IcariaItems.PLATOSHALE_BRICKS.getId(), "_crafting"));

		ShapedRecipeBuilder.shaped(IcariaItems.PLATOSHALE_CHISELED.get())
			.pattern("X")
			.pattern("X")
			.define('X', Objects.requireNonNull(IcariaItems.PLATOSHALE_BRICKS_DECO.slab).get())
			.unlockedBy("has_block", has(IcariaItems.PLATOSHALE_BRICKS_DECO.slab.get()))
			.save(consumer, appendResource(IcariaItems.PLATOSHALE_CHISELED.getId(), "_crafting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.PLATOSHALE.get()), IcariaItems.PLATOSHALE_BRICKS.get())
			.unlockedBy("has_block", has(IcariaItems.PLATOSHALE.get()))
			.save(consumer, appendResource(IcariaItems.PLATOSHALE_BRICKS.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.PLATOSHALE.get()), IcariaItems.PLATOSHALE_CHISELED.get())
			.unlockedBy("has_block", has(IcariaItems.PLATOSHALE.get()))
			.save(consumer, appendResource(IcariaItems.PLATOSHALE_CHISELED.getId(), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.PLATOSHALE_BRICKS.get()), IcariaItems.PLATOSHALE_CHISELED.get())
			.unlockedBy("has_block", has(IcariaItems.PLATOSHALE_BRICKS.get()))
			.save(consumer, appendResource(IcariaItems.PLATOSHALE_CHISELED.getId(), "_cutting_bricks"));

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

		ShapedRecipeBuilder.shaped(IcariaItems.VANADIUMSTEEL_BARS.get(), 16)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', IcariaItems.VANADIUMSTEEL_INGOT.get())
			.unlockedBy("has_block", has(IcariaItems.VANADIUMSTEEL_INGOT.get()))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(IcariaItems.VANADIUMSTEEL_BARS.get()))));

		ShapedRecipeBuilder.shaped(IcariaItems.VANADIUMSTEEL_BARS_HORIZONTAL.get(), 2)
			.pattern("XX")
			.define('X', IcariaItems.VANADIUMSTEEL_BARS.get())
			.unlockedBy("has_block", has(IcariaItems.VANADIUMSTEEL_BARS.get()))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(IcariaItems.VANADIUMSTEEL_BARS_HORIZONTAL.get()))));

		ShapedRecipeBuilder.shaped(IcariaItems.STRAWBERRY_CAKE.get())
			.pattern("ABA")
			.pattern("CDC")
			.pattern("EEE")
			.define('A', IcariaItems.STRAWBERRIES.get())
			.define('B', Items.MILK_BUCKET)
			.define('C', Items.SUGAR)
			.define('D', IcariaItems.JELLYFISH_JELLY.get())
			.define('E', IcariaItems.SPELT_FLOUR.get())
			.unlockedBy("has_item", has(IcariaItems.SPELT_FLOUR.get()))
			.save(consumer, IcariaItems.STRAWBERRY_CAKE.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.LAUREL_WREATH.get(), 1)
			.pattern("XXX")
			.pattern("X X")
			.define('X', IcariaItems.LAUREL_LEAVES.get())
			.group("")
			.unlockedBy("has_item", has(IcariaItems.LAUREL_LEAVES.get()))
			.save(consumer, IcariaItems.LAUREL_WREATH.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.GREEK_FIRE_GRENADE.get(), 1)
			.pattern(" X ")
			.pattern("YZY")
			.pattern(" Y ")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', IcariaItems.KASSITEROS_NUGGET.get())
			.define('Z', IcariaItems.CALCITE_POWDER.get())
			.group("")
			.unlockedBy("has_item", has(IcariaItems.KASSITEROS_NUGGET.get()))
			.save(consumer, IcariaItems.GREEK_FIRE_GRENADE.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.UNFIRED_STORAGE_VASE.get())
			.pattern("XXX")
			.pattern("X X")
			.pattern("XXX")
			.define('X', IcariaItems.LOAM_LUMP.get())
			.unlockedBy("has_item", has(IcariaItems.LOAM_LUMP.get()))
			.save(consumer, IcariaItems.UNFIRED_STORAGE_VASE.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.VIAL_EMPTY.get(), 3)
			.pattern("X X")
			.pattern(" X ")
			.define('X', IcariaItems.GRAINGLASS_PANE.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINGLASS_PANE.get()))
			.save(consumer, ForgeRegistries.ITEMS.getKey(IcariaItems.VIAL_EMPTY.get()) + "_from_pane");

		ShapedRecipeBuilder.shaped(IcariaItems.VIAL_EMPTY.get(), 3)
			.pattern("X X")
			.pattern(" X ")
			.define('X', IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get())
			.unlockedBy("has_block", has(IcariaItems.GRAINGLASS_PANE_HORIZONTAL.get()))
			.save(consumer, ForgeRegistries.ITEMS.getKey(IcariaItems.VIAL_EMPTY.get()) + "_from_horizontal_pane");

		ShapedRecipeBuilder.shaped(IcariaItems.SPELT_BREAD.get())
			.pattern("XXX")
			.define('X', IcariaItems.SPELT.get())
			.unlockedBy("has_item", has(IcariaItems.SPELT.get()))
			.save(consumer, IcariaItems.SPELT_BREAD.getId());

		ShapedRecipeBuilder.shaped(IcariaItems.SALAD_FRUIT.get())
			.pattern("ABC")
			.pattern("DEF")
			.pattern("G  ")
			.define('A', IcariaItems.STRAWBERRIES.get())
			.define('B', IcariaItems.PHYSALIS.get())
			.define('C', Items.COCOA_BEANS)
			.define('D', Items.MELON_SLICE)
			.define('E', Items.GOLDEN_APPLE)
			.define('F', IcariaItems.LAUREL_CHERRY.get())
			.define('G', IcariaItems.LOAM_BOWL.get())
			.unlockedBy("has_item", has(Items.GOLDEN_APPLE))
			.save(consumer, IcariaItems.SALAD_FRUIT.getId());

		ShapelessRecipeBuilder.shapeless(IcariaItems.STRAWBERRY_SEEDS.get())
			.requires(IcariaItems.STRAWBERRIES.get())
			.unlockedBy("has_item", has(IcariaItems.STRAWBERRIES.get()))
			.save(consumer, IcariaItems.STRAWBERRY_SEEDS.getId());

		// VANILLA
		ShapedRecipeBuilder.shaped(Items.ARROW)
			.pattern("X")
			.pattern("Y")
			.pattern("Z")
			.define('X', IcariaItems.CHERT.get())
			.define('Y', Items.STICK)
			.define('Z', Items.FEATHER)
			.unlockedBy("has_chert", has(IcariaItems.CHERT.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.ARROW)), "_from_chert"));

		ShapedRecipeBuilder.shaped(Items.BOOK)
			.pattern("XX")
			.pattern("XY")
			.define('X', Items.PAPER)
			.define('Y', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.BOOK)), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.BOW)
			.pattern(" XY")
			.pattern("X Y")
			.pattern(" XY")
			.define('X', Items.STICK)
			.define('Y', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.BOW)), "_from_arachne"));

		ShapedRecipeBuilder.shaped(Items.CANDLE)
			.pattern("X")
			.pattern("Y")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', Items.HONEYCOMB)
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.CANDLE)), "_from_arachne"));

		ShapelessRecipeBuilder.shapeless(Items.MOSSY_COBBLESTONE)
			.requires(Items.COBBLESTONE)
			.requires(IcariaItemTags.bind("forge:vines"))
			.unlockedBy("has_vine", has(IcariaItemTags.bind("forge:vines")))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.MOSSY_COBBLESTONE)));

		ShapedRecipeBuilder.shaped(Items.COMPARATOR)
			.pattern(" X ")
			.pattern("XYX")
			.pattern("ZZZ")
			.define('X', Items.REDSTONE_TORCH)
			.define('Y', Items.QUARTZ)
			.define('Z', IcariaItems.RELICSTONE_SMOOTH.get())
			.unlockedBy("has_stone", has(IcariaItems.RELICSTONE_SMOOTH.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.COMPARATOR)), "_from_relicstone"));

		ShapedRecipeBuilder.shaped(Items.CROSSBOW)
			.pattern("ABA")
			.pattern("CDC")
			.pattern(" A ")
			.define('A', Items.STICK)
			.define('B', Items.IRON_INGOT)
			.define('C', IcariaItems.ARACHNE_STRING.get())
			.define('D', Items.TRIPWIRE_HOOK)
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.CROSSBOW)), "_from_arachne"));

		ShapedRecipeBuilder.shaped(Items.FISHING_ROD)
			.pattern("  X")
			.pattern(" XY")
			.pattern("X Y")
			.define('X', Items.STICK)
			.define('Y', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.FISHING_ROD)), "_from_arachne"));

		ShapedRecipeBuilder.shaped(Items.FLETCHING_TABLE)
			.pattern("XX")
			.pattern("YY")
			.pattern("YY")
			.define('X', IcariaItems.CHERT.get())
			.define('Y', IcariaItemTags.bind("minecraft:planks"))
			.unlockedBy("has_chert", has(IcariaItems.CHERT.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.FLETCHING_TABLE)), "_from_chert"));

		ShapelessRecipeBuilder.shapeless(Items.FLINT_AND_STEEL)
			.requires(IcariaItems.CHERT.get())
			.requires(Items.IRON_INGOT)
			.unlockedBy("has_chert", has(IcariaItems.CHERT.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.FLINT_AND_STEEL)), "_from_chert"));

		ShapedRecipeBuilder.shaped(Items.ITEM_FRAME)
			.pattern("XXX")
			.pattern("XYX")
			.pattern("XXX")
			.define('X', Items.STICK)
			.define('Y', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.ITEM_FRAME)), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEAD, 2)
			.pattern("XX ")
			.pattern("XY ")
			.pattern("  X")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', Items.SLIME_BALL)
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEAD)), "_from_arachne"));

		ShapedRecipeBuilder.shaped(Items.LEAD, 2)
			.pattern("XX ")
			.pattern("XY ")
			.pattern("  X")
			.define('X', Items.STRING)
			.define('Y', IcariaItems.JELLYFISH_JELLY.get())
			.unlockedBy("has_jelly", has(IcariaItems.JELLYFISH_JELLY.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEAD)), "_from_jelly"));

		ShapedRecipeBuilder.shaped(Items.LEAD, 2)
			.pattern("XX ")
			.pattern("XY ")
			.pattern("  X")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', IcariaItems.JELLYFISH_JELLY.get())
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEAD)), "_from_arachne_and_jelly"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_BOOTS)
			.pattern("X X")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEATHER_BOOTS)), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_CHESTPLATE)
			.pattern("X X")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEATHER_CHESTPLATE)), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_HELMET)
			.pattern("XXX")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEATHER_HELMET)), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_HORSE_ARMOR)
			.pattern("X X")
			.pattern("XXX")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEATHER_HORSE_ARMOR)), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LEATHER_LEGGINGS)
			.pattern("XXX")
			.pattern("X X")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_leather", has(IcariaItems.AETERNAE_HIDE.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LEATHER_LEGGINGS)), "_from_aeternae"));

		ShapedRecipeBuilder.shaped(Items.LOOM)
			.pattern("XX ")
			.pattern("YY ")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', IcariaItemTags.bind("minecraft:planks"))
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.LOOM)), "_from_arachne"));

		ShapelessRecipeBuilder.shapeless(Items.MAGMA_CREAM)
			.requires(IcariaItems.JELLYFISH_JELLY.get())
			.requires(Items.BLAZE_POWDER)
			.unlockedBy("has_jelly", has(IcariaItems.JELLYFISH_JELLY.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.MAGMA_CREAM)), "_from_jelly"));

		ShapedRecipeBuilder.shaped(Items.PAPER, 3)
			.pattern("XXX")
			.define('X', IcariaItems.VINE_REED.get())
			.unlockedBy("has_item", has(IcariaItems.VINE_REED.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.PAPER)), "_from_vine_reeds"));

		ShapedRecipeBuilder.shaped(Items.REPEATER)
			.pattern("XYX")
			.pattern("ZZZ")
			.define('X', Items.REDSTONE_TORCH)
			.define('Y', Items.REDSTONE)
			.define('Z', IcariaItems.RELICSTONE_SMOOTH.get())
			.unlockedBy("has_stone", has(IcariaItems.RELICSTONE_SMOOTH.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.REPEATER)), "_from_relicstone"));

		ShapedRecipeBuilder.shaped(Items.SCAFFOLDING)
			.pattern("XYX")
			.pattern("X X")
			.pattern("X X")
			.define('X', Items.BAMBOO)
			.define('Y', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.SCAFFOLDING)), "_from_arachne"));

		ShapedRecipeBuilder.shaped(Items.STICKY_PISTON)
			.pattern("X")
			.pattern("Y")
			.define('X', IcariaItems.JELLYFISH_JELLY.get())
			.define('Y', Items.PISTON)
			.unlockedBy("has_jelly", has(IcariaItems.JELLYFISH_JELLY.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.STICKY_PISTON)), "_from_jelly"));

		ShapelessRecipeBuilder.shapeless(Items.MOSSY_STONE_BRICKS)
			.requires(Items.STONE_BRICKS)
			.requires(IcariaItemTags.bind("forge:vines"))
			.unlockedBy("has_vine", has(IcariaItemTags.bind("forge:vines")))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.MOSSY_STONE_BRICKS)));

		ShapedRecipeBuilder.shaped(Items.STONECUTTER)
			.pattern(" X ")
			.pattern("YYY")
			.define('X', Items.IRON_INGOT)
			.define('Y', IcariaItems.RELICSTONE_SMOOTH.get())
			.unlockedBy("has_stone", has(IcariaItems.RELICSTONE_SMOOTH.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.STONECUTTER)), "_from_relicstone"));

		ShapelessRecipeBuilder.shapeless(Items.SUGAR)
			.requires(IcariaItems.VINE_REED.get())
			.unlockedBy("has_item", has(IcariaItems.VINE_REED.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.SUGAR)), "_from_vine_reeds"));

		ShapedRecipeBuilder.shaped(Items.WHITE_WOOL)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_string", has(IcariaItems.ARACHNE_STRING.get()))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.WHITE_WOOL)), "_from_arachne"));
		
		//Workstations
		ShapedRecipeBuilder.shaped(IcariaItems.GRINDER.get())
			.pattern("XXX")
			.pattern("XYX")
			.pattern("XXX")
			.define('X', CompoundIngredient.of(Ingredient.of(IcariaItems.SUNSTONE.get()),Ingredient.of(IcariaItems.SUNSTONE_BRICKS.get())))
			.define('Y', IcariaItems.ORICHALCUM_INGOT.get())
			.unlockedBy("has_item", has(IcariaItems.ORICHALCUM_INGOT.get()))
			.save(consumer, IcariaItems.GRINDER.getId());
		
		//Grinder Recipes
		
		GrinderRecipeBuilder.grind(Items.REDSTONE, Ingredient.of(Items.SANDSTONE), Items.SAND, 4)
			.unlockedBy("has_block", has(Items.SANDSTONE))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.SAND)), "_from_grinder"));
	}

	public void smeltingRecipe(Consumer<FinishedRecipe> consumer, Item resource, Item result, float experience, int cookingTime) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(resource), result, experience, cookingTime)
			.unlockedBy("has_item", has(resource))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result)), "_smelting"));
	}

	public void bowlFlaskTypeRecipe(Consumer<FinishedRecipe> consumer, Item resource, Item result, int amount) {
		ShapedRecipeBuilder.shaped(result, amount)
			.pattern("X X")
			.pattern(" X ")
			.define('X', resource)
			.unlockedBy("has_item", has(resource))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(result))));
	}

	public void twoIngredientStewRecipe(Consumer<FinishedRecipe> consumer, Item meat, Item veggie, Item result) {
		ShapedRecipeBuilder.shaped(result, 1)
			.pattern("AB")
			.pattern("CD")
			.define('A', meat)
			.define('B', veggie)
			.define('C', IcariaItems.ROCK_SALT.get())
			.define('D', IcariaItems.LOAM_BOWL.get())
			.unlockedBy("has_item", has(meat))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(result))));
	}

	public void threeIngredientStewRecipe(Consumer<FinishedRecipe> consumer, Item ingredientOne, TagKey<Item> ingredientTwo, TagKey<Item> ingredientThree, Item result) {
		ShapedRecipeBuilder.shaped(result, 1)
			.pattern("ABC")
			.pattern("DE ")
			.define('A', ingredientOne)
			.define('B', ingredientTwo)
			.define('C', ingredientThree)
			.define('D', IcariaItems.ROCK_SALT.get())
			.define('E', IcariaItems.LOAM_BOWL.get())
			.unlockedBy("has_item", has(ingredientOne))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(result))));
	}

	public void glassRecipes(Consumer<FinishedRecipe> consumer, Item sand, Item glass, Item pane, Item horizontalPane) {
		ShapedRecipeBuilder.shaped(pane, 16)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', glass)
			.unlockedBy("has_block", has(glass))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(pane))));

		ShapedRecipeBuilder.shaped(horizontalPane, 2)
			.pattern("XX")
			.define('X', pane)
			.unlockedBy("has_block", has(pane))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(horizontalPane))));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(sand), glass, 0.1F, 200)
			.unlockedBy("has_block", has(sand))
			.save(consumer, Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(glass))));
	}

	public void stoneRecipes(Consumer<FinishedRecipe> consumer, Item cobble, Item stone, Item bricks, Item chiseled, IcariaItems.StoneDecoItemBlocks deco) {
		ShapedRecipeBuilder.shaped(bricks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', stone)
			.unlockedBy("has_block", has(stone))
			.save(consumer, appendResource(Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(bricks))), "_crafting"));

		ShapedRecipeBuilder.shaped(chiseled, 1)
			.pattern("X")
			.pattern("X")
			.define('X', Objects.requireNonNull(deco.slab).get())
			.unlockedBy("has_block", has(deco.slab.get()))
			.save(consumer, appendResource(Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(chiseled))), "_crafting"));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(cobble), stone, 0.1F, 200)
			.unlockedBy("has_block", has(cobble))
			.save(consumer, appendResource(Objects.requireNonNull((ForgeRegistries.ITEMS.getKey(stone))), "_smelting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), bricks)
			.unlockedBy("has_block", has(stone))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(bricks)), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(stone), chiseled)
			.unlockedBy("has_block", has(stone))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(chiseled)), "_cutting"));

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(bricks), chiseled)
			.unlockedBy("has_block", has(bricks))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(chiseled)), "_cutting_bricks"));
	}

	public void smallCompressRecipe(Consumer<FinishedRecipe> consumer, Item compressed, Item uncompressed) {
		ShapedRecipeBuilder.shaped(compressed, 1)
			.pattern("XX")
			.pattern("XX")
			.define('X', uncompressed)
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(uncompressed)), "_small_compress"));
	}

	public void smallCompressDecompressRecipes(Consumer<FinishedRecipe> consumer, Item compressed, Item uncompressed) {
		ShapedRecipeBuilder.shaped(compressed, 1)
			.pattern("XX")
			.pattern("XX")
			.define('X', uncompressed)
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(uncompressed)), "_small_compress"));

		ShapelessRecipeBuilder.shapeless(uncompressed, 4)
			.requires(compressed)
			.unlockedBy("has_compressed", has(compressed))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(compressed)), "_small_decompress"));
	}

	public void largeCompressDecompressRecipes(Consumer<FinishedRecipe> consumer, Item compressed, Item uncompressed) {
		ShapedRecipeBuilder.shaped(compressed, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', uncompressed)
			.unlockedBy("has_uncompressed", has(uncompressed))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(uncompressed)), "_large_compress"));

		ShapelessRecipeBuilder.shapeless(uncompressed, 9)
			.requires(compressed)
			.unlockedBy("has_compressed", has(compressed))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(compressed)), "_large_decompress"));
	}

	public void vaseRecipe(Consumer<FinishedRecipe> consumer, Item dye, Item vase) {
		ShapelessRecipeBuilder.shapeless(vase, 1)
			.requires(dye)
			.requires(IcariaItems.UNFIRED_STORAGE_VASE.get())
			.unlockedBy("has_vase", has(IcariaItems.UNFIRED_STORAGE_VASE.get()))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(vase)));
	}

	public void woodRecipes(Consumer<FinishedRecipe> consumer, Item wood, Item strippedWood, Item log, Item strippedLog) {
		ShapedRecipeBuilder.shaped(wood, 3)
			.pattern("XX")
			.pattern("XX")
			.define('X', log)
			.unlockedBy("has_block", has(log))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(wood)));

		ShapedRecipeBuilder.shaped(strippedWood, 3)
			.pattern("XX")
			.pattern("XX")
			.define('X', strippedLog)
			.unlockedBy("has_block", has(strippedLog))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(strippedWood)));
	}

	public void planksRecipes(Consumer<FinishedRecipe> consumer, Item wood, Item strippedWood, Item log, Item strippedLog, Item planks) {
		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', wood)
			.unlockedBy("has_block", has(wood))
			.save(consumer, ForgeRegistries.ITEMS.getKey(planks) + "_from_wood");

		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', strippedWood)
			.unlockedBy("has_block", has(strippedWood))
			.save(consumer, ForgeRegistries.ITEMS.getKey(planks) + "_from_stripped_wood");

		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', log)
			.unlockedBy("has_block", has(log))
			.save(consumer, ForgeRegistries.ITEMS.getKey(planks) + "_from_log");

		ShapedRecipeBuilder.shaped(planks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', strippedLog)
			.unlockedBy("has_block", has(strippedLog))
			.save(consumer, ForgeRegistries.ITEMS.getKey(planks) + "_from_stripped_log");
	}

	public void doorRecipe(Consumer<FinishedRecipe> consumer, Item door, Item planks) {
		ShapedRecipeBuilder.shaped(door, 3)
			.pattern("XX")
			.pattern("XX")
			.pattern("XX")
			.define('X', planks)
			.unlockedBy("has_block", has(planks))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(door)));
	}

	public void trapdoorRecipe(Consumer<FinishedRecipe> consumer, Item trapdoor, Item planks) {
		ShapedRecipeBuilder.shaped(trapdoor, 2)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', planks)
			.unlockedBy("has_block", has(planks))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(trapdoor)));
	}

	public void ladderRecipe(Consumer<FinishedRecipe> consumer, Item ladder, Item planks) {
		ShapedRecipeBuilder.shaped(ladder, 6)
			.pattern("X X")
			.pattern("XXX")
			.pattern("X X")
			.define('X', planks)
			.unlockedBy("has_block", has(planks))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(ladder)));
	}

	public void signRecipe(Consumer<FinishedRecipe> consumer, Item sign, Item planks) {
		ShapedRecipeBuilder.shaped(sign, 6)
			.pattern("XXX")
			.pattern("XXX")
			.pattern(" Y ")
			.define('X', planks)
			.define('Y', Items.STICK)
			.unlockedBy("has_block", has(planks))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(sign)));
	}

	public void torchRecipe(Consumer<FinishedRecipe> consumer, Item torch, Item gem) {
		ShapedRecipeBuilder.shaped(torch, 2)
			.pattern("X")
			.pattern("Y")
			.define('X', gem)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.unlockedBy("has_gem", has(gem))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(torch)));
	}

	public void dyesFromFlowerRecipe(Consumer<FinishedRecipe> consumer, Item dye, Item flower) {
		ShapelessRecipeBuilder.shapeless(dye)
			.requires(flower)
			.unlockedBy("has_item", has(flower))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(dye)), "_from_" + Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(flower)).getPath()));
	}

	public void blockIngotNuggetRecipes(Consumer<FinishedRecipe> consumer, Item block, Item ingot, Item nugget) {
		ShapedRecipeBuilder.shaped(block, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', ingot)
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(ingot)), "_to_block"));

		ShapedRecipeBuilder.shaped(ingot, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', nugget)
			.unlockedBy("has_nugget", has(nugget))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(nugget)), "_to_ingot"));

		ShapelessRecipeBuilder.shapeless(ingot, 9)
			.requires(block)
			.unlockedBy("has_block", has(block))
			.save(consumer, appendResource((Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(block))), "_to_ingot"));

		ShapelessRecipeBuilder.shapeless(nugget, 9)
			.requires(ingot)
			.unlockedBy("has_ingot", has(ingot))
			.save(consumer, appendResource(Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(ingot)), "_to_nugget"));
	}

	public void gemSmeltingRecipe(Consumer<FinishedRecipe> consumer, Item ore, Item result) {
		SimpleCookingRecipeBuilder.smelting((Ingredient.of(ore)), result, 0.7F, 200)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_smelting_ore");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(ore)), result, 0.7F, 100)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_blasting_ore");
	}

	public void ingotSmeltingRecipes(Consumer<FinishedRecipe> consumer, Item ore, Item raw, Item result) {
		SimpleCookingRecipeBuilder.smelting((Ingredient.of(ore)), result, 0.7F, 200)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_smelting_ore");

		SimpleCookingRecipeBuilder.smelting((Ingredient.of(raw)), result, 0.7F, 200)
			.unlockedBy("has_ingredient", has(raw))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_smelting_raw");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(ore)), result, 0.7F, 100)
			.unlockedBy("has_ingredient", has(ore))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_blasting_ore");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(raw)), result, 0.7F, 100)
			.unlockedBy("has_ingredient", has(raw))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_blasting_raw");
	}

	public void toolRecipes(Consumer<FinishedRecipe> consumer, Item sword, Item dagger, Item shovel, Item pickaxe, Item axe, Item scythe, Item bident, Item resource) {
		ShapedRecipeBuilder.shaped(sword, 1)
			.pattern("X")
			.pattern("X")
			.pattern("Y")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(sword)));

		ShapedRecipeBuilder.shaped(dagger, 1)
			.pattern("X")
			.pattern("Y")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(dagger)));

		ShapedRecipeBuilder.shaped(shovel, 1)
			.pattern("X")
			.pattern("Y")
			.pattern("Y")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(shovel)));

		ShapedRecipeBuilder.shaped(pickaxe, 1)
			.pattern("XXX")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(pickaxe)));

		ShapedRecipeBuilder.shaped(axe, 1)
			.pattern("XX ")
			.pattern("XY ")
			.pattern(" Y ")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(axe)));

		ShapedRecipeBuilder.shaped(scythe, 1)
			.pattern(" XX")
			.pattern("X Y")
			.pattern("  Y")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(scythe)));

		ShapedRecipeBuilder.shaped(bident, 1)
			.pattern("X X")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', resource)
			.define('Y', IcariaItemTags.bind("forge:bones"))
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(bident)));
	}

	public void armorRecipes(Consumer<FinishedRecipe> consumer, Item helmet, Item chestplate, Item leggings, Item boots, Item resource) {
		ShapedRecipeBuilder.shaped(helmet, 1)
			.pattern("XXX")
			.pattern("X X")
			.define('X', resource)
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(helmet)));

		ShapedRecipeBuilder.shaped(chestplate, 1)
			.pattern("X X")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', resource)
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(chestplate)));

		ShapedRecipeBuilder.shaped(leggings, 1)
			.pattern("XXX")
			.pattern("X X")
			.pattern("X X")
			.define('X', resource)
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(leggings)));

		ShapedRecipeBuilder.shaped(boots, 1)
			.pattern("X X")
			.pattern("X X")
			.define('X', resource)
			.group("")
			.unlockedBy("has_ingot", has(resource))
			.save(consumer, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(boots)));
	}

	public void foodCookingRecipes(Consumer<FinishedRecipe> consumer, Item ingredient, Item result) {
		SimpleCookingRecipeBuilder.campfireCooking((Ingredient.of(ingredient)), result, 0.35F, 600)
			.unlockedBy("has_ingredient", has(ingredient))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_campfire_cooking");

		SimpleCookingRecipeBuilder.smelting((Ingredient.of(ingredient)), result, 0.35F, 200)
			.unlockedBy("has_ingredient", has(ingredient))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_smelting");

		SimpleCookingRecipeBuilder.smoking((Ingredient.of(ingredient)), result, 0.35F, 100)
			.unlockedBy("has_ingredient", has(ingredient))
			.save(consumer, ForgeRegistries.ITEMS.getKey(result) + "_from_smoking");
	}

	public ResourceLocation appendResource(ResourceLocation location, String suffix) {
		return new ResourceLocation(location.getNamespace(), location.getPath() + suffix);
	}

	@Override
	public String getName() {
		return IcariaInfo.MODID;
	}
}
