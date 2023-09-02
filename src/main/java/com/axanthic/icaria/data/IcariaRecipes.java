package com.axanthic.icaria.data;

import com.axanthic.icaria.common.recipe.builder.FiringRecipeBuilder;
import com.axanthic.icaria.common.recipe.builder.GrindingRecipeBuilder;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaStoneDecoItems;
import com.axanthic.icaria.common.registry.IcariaWoodDecoItems;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaRecipes extends RecipeProvider {
	public IcariaRecipes(PackOutput pOutput) {
		super(pOutput);
	}

	@Override
	public void buildRecipes(Consumer<FinishedRecipe> pConsumer) {
		this.firingRecipe(pConsumer, IcariaItems.UNFIRED_LOAM_BOWL.get(), IcariaItems.LOAM_BOWL.get(), 1.0F, 200);

		this.grindingRecipe(pConsumer, IcariaItems.YELLOWSTONE_GEAR.get(), Items.SANDSTONE, Items.SAND, 1.0F, 200, 4);

		this.smeltingRecipe(pConsumer, IcariaItems.CARDON_CACTUS.get(), Items.GREEN_DYE, 1.0F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.LOAM_LUMP.get(), IcariaItems.LOAM_BRICK.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.UNFIRED_STORAGE_VASE.get(), IcariaItems.STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get(), IcariaItems.WHITE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get(), IcariaItems.LIGHT_GRAY_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get(), IcariaItems.GRAY_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get(), IcariaItems.BLACK_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get(), IcariaItems.BROWN_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.RED_UNFIRED_STORAGE_VASE.get(), IcariaItems.RED_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get(), IcariaItems.ORANGE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get(), IcariaItems.YELLOW_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.LIME_UNFIRED_STORAGE_VASE.get(), IcariaItems.LIME_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get(), IcariaItems.GREEN_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get(), IcariaItems.CYAN_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get(), IcariaItems.LIGHT_BLUE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get(), IcariaItems.BLUE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get(), IcariaItems.PURPLE_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get(), IcariaItems.MAGENTA_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.PINK_UNFIRED_STORAGE_VASE.get(), IcariaItems.PINK_STORAGE_VASE.get(), 0.3F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.UNFIRED_LOAM_GEAR.get(), IcariaItems.LOAM_GEAR.get(), 3.0F, 200);
		this.smeltingRecipe(pConsumer, IcariaItems.SPELT_FLOUR.get(), IcariaItems.SPELT_BREAD.get(), 0.3F, 200);

		this.smallCompressDecompressRecipes(pConsumer, IcariaItems.LOAM_LUMP.get(), IcariaItems.LOAM.get());
		this.smallCompressDecompressRecipes(pConsumer, IcariaItems.VINE_SPROUT.get(), IcariaItems.VINE_SPROUT_BLOCK.get());

		this.smallCompressRecipe(pConsumer, IcariaItems.LOAM_BRICK.get(), IcariaItems.LOAM_BRICKS.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.SILKSAND.get(), IcariaItems.SILKSTONE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.CALCITE_SHARD.get(), IcariaItems.CALCITE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.HALITE_SHARD.get(), IcariaItems.HALITE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.JASPER_SHARD.get(), IcariaItems.JASPER.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.ZIRCON_SHARD.get(), IcariaItems.ZIRCON.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.CYPRESS_CRAFTING_TABLE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.FIR_PLANKS.get(), IcariaItems.FIR_CRAFTING_TABLE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.LAUREL_PLANKS.get(), IcariaItems.LAUREL_CRAFTING_TABLE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.OLIVE_PLANKS.get(), IcariaItems.OLIVE_CRAFTING_TABLE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.PLANE_PLANKS.get(), IcariaItems.PLANE_CRAFTING_TABLE.get());
		this.smallCompressRecipe(pConsumer, IcariaItems.POPULUS_PLANKS.get(), IcariaItems.POPULUS_CRAFTING_TABLE.get());

		this.glassRecipes(pConsumer, IcariaItems.GRAINEL.get(), IcariaItems.GRAINGLASS.get(), IcariaItems.GRAINGLASS_PANE.get(), IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get());
		this.glassRecipes(pConsumer, IcariaItems.SILKSAND.get(), IcariaItems.SILKGLASS.get(), IcariaItems.SILKGLASS_PANE.get(), IcariaItems.HORIZONTAL_SILKGLASS_PANE.get());

		this.stoneRecipes(pConsumer, IcariaItems.COBBLED_YELLOWSTONE.get(), IcariaItems.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_BRICKS.get(), IcariaItems.CHISELED_YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_BRICK_DECO);
		this.stoneRecipes(pConsumer, IcariaItems.COBBLED_SILKSTONE.get(), IcariaItems.SILKSTONE.get(), IcariaItems.SILKSTONE_BRICKS.get(), IcariaItems.CHISELED_SILKSTONE.get(), IcariaItems.SILKSTONE_BRICK_DECO);
		this.stoneRecipes(pConsumer, IcariaItems.COBBLED_SUNSTONE.get(), IcariaItems.SUNSTONE.get(), IcariaItems.SUNSTONE_BRICKS.get(), IcariaItems.CHISELED_SUNSTONE.get(), IcariaItems.SUNSTONE_BRICK_DECO);
		this.stoneRecipes(pConsumer, IcariaItems.COBBLED_VOIDSHALE.get(), IcariaItems.VOIDSHALE.get(), IcariaItems.VOIDSHALE_BRICKS.get(), IcariaItems.CHISELED_VOIDSHALE.get(), IcariaItems.VOIDSHALE_BRICK_DECO);
		this.stoneRecipes(pConsumer, IcariaItems.COBBLED_BAETYL.get(), IcariaItems.BAETYL.get(), IcariaItems.BAETYL_BRICKS.get(), IcariaItems.CHISELED_BAETYL.get(), IcariaItems.BAETYL_BRICK_DECO);

		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.WATER_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.ARACHNE_STRING.get(), IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.SPELT.get(), IcariaItems.SPELT_BALE_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.VINE_REED.get(), IcariaItems.VINE_REED_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.ROTTEN_BONES.get(), IcariaItems.ROTTEN_BONES_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.CALCITE_SHARD.get(), IcariaItems.CALCITE_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.HALITE_SHARD.get(), IcariaItems.HALITE_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.JASPER_SHARD.get(), IcariaItems.JASPER_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.ZIRCON_SHARD.get(), IcariaItems.ZIRCON_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.RAW_CHALKOS.get(), IcariaItems.RAW_CHALKOS_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.RAW_KASSITEROS.get(), IcariaItems.RAW_KASSITEROS_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.RAW_VANADIUM.get(), IcariaItems.RAW_VANADIUM_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.RAW_SIDEROS.get(), IcariaItems.RAW_SIDEROS_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.RAW_MOLYBDENUM.get(), IcariaItems.RAW_MOLYBDENUM_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.CHERT.get(), IcariaItems.CHERT_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.LIGNITE.get(), IcariaItems.LIGNITE_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.SLIVER.get(), IcariaItems.SLIVER_BLOCK.get());
		this.largeCompressDecompressRecipes(pConsumer, IcariaItems.ANTHRACITE.get(), IcariaItems.ANTHRACITE_BLOCK.get());

		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.CHALKOS_BLOCK.get(), IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.KASSITEROS_BLOCK.get(), IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.ORICHALCUM_BLOCK.get(), IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.VANADIUM_BLOCK.get(), IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.VANADIUMSTEEL_BLOCK.get(), IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.SIDEROS_BLOCK.get(), IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.MOLYBDENUM_BLOCK.get(), IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.MOLYBDENUM_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.MOLYBDENUMSTEEL_BLOCK.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		this.blockIngotNuggetRecipes(pConsumer, IcariaItems.BLURIDIUM_BLOCK.get(), IcariaItems.BLURIDIUM_INGOT.get(), IcariaItems.BLURIDIUM_NUGGET.get());

		this.torchRecipe(pConsumer, IcariaItems.LIGNITE.get(), IcariaItems.LIGNITE_TORCH.get());
		this.torchRecipe(pConsumer, IcariaItems.ANTHRACITE.get(), IcariaItems.ANTHRACITE_TORCH.get());

		this.cakeRecipe(pConsumer, IcariaItems.LAUREL_CHERRY.get(), IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.LAUREL_CHERRY_CAKE.get());
		this.cakeRecipe(pConsumer, IcariaItems.STRAWBERRIES.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.STRAWBERRY_CAKE.get());
		this.cakeRecipe(pConsumer, IcariaItems.PHYSALIS.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.PHYSALIS_CAKE.get());
		this.cakeRecipe(pConsumer, IcariaItems.VINEBERRIES.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.VINE_BERRY_CAKE.get());
		this.cakeRecipe(pConsumer, IcariaItems.VINE_SPROUT.get(), IcariaItems.WATER_JELLYFISH_JELLY.get(), IcariaItems.VINE_SPROUT_CAKE.get());

		this.woodRecipes(pConsumer, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get());
		this.woodRecipes(pConsumer, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
		this.woodRecipes(pConsumer, IcariaItems.FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.FIR_LOG.get(), IcariaItems.STRIPPED_FIR_LOG.get());
		this.woodRecipes(pConsumer, IcariaItems.LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.STRIPPED_LAUREL_LOG.get());
		this.woodRecipes(pConsumer, IcariaItems.OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.STRIPPED_OLIVE_LOG.get());
		this.woodRecipes(pConsumer, IcariaItems.PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.STRIPPED_PLANE_LOG.get());
		this.woodRecipes(pConsumer, IcariaItems.POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.STRIPPED_POPULUS_LOG.get());

		this.planksRecipe(pConsumer, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.planksRecipe(pConsumer, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.planksRecipe(pConsumer, IcariaItems.FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.FIR_LOG.get(), IcariaItems.STRIPPED_FIR_LOG.get(), IcariaItems.FIR_PLANKS.get());
		this.planksRecipe(pConsumer, IcariaItems.LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.STRIPPED_LAUREL_LOG.get(), IcariaItems.LAUREL_PLANKS.get());
		this.planksRecipe(pConsumer, IcariaItems.OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.STRIPPED_OLIVE_LOG.get(), IcariaItems.OLIVE_PLANKS.get());
		this.planksRecipe(pConsumer, IcariaItems.PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.STRIPPED_PLANE_LOG.get(), IcariaItems.PLANE_PLANKS.get());
		this.planksRecipe(pConsumer, IcariaItems.POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.STRIPPED_POPULUS_LOG.get(), IcariaItems.POPULUS_PLANKS.get());

		this.doorRecipe(pConsumer, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.CYPRESS_DOOR.get());
		this.doorRecipe(pConsumer, IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.DROUGHTROOT_DOOR.get());
		this.doorRecipe(pConsumer, IcariaItems.FIR_PLANKS.get(), IcariaItems.FIR_DOOR.get());
		this.doorRecipe(pConsumer, IcariaItems.LAUREL_PLANKS.get(), IcariaItems.LAUREL_DOOR.get());
		this.doorRecipe(pConsumer, IcariaItems.OLIVE_PLANKS.get(), IcariaItems.OLIVE_DOOR.get());
		this.doorRecipe(pConsumer, IcariaItems.PLANE_PLANKS.get(), IcariaItems.PLANE_DOOR.get());
		this.doorRecipe(pConsumer, IcariaItems.POPULUS_PLANKS.get(), IcariaItems.POPULUS_DOOR.get());

		this.trapdoorRecipe(pConsumer, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.CYPRESS_TRAPDOOR.get());
		this.trapdoorRecipe(pConsumer, IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.DROUGHTROOT_TRAPDOOR.get());
		this.trapdoorRecipe(pConsumer, IcariaItems.FIR_PLANKS.get(), IcariaItems.FIR_TRAPDOOR.get());
		this.trapdoorRecipe(pConsumer, IcariaItems.LAUREL_PLANKS.get(), IcariaItems.LAUREL_TRAPDOOR.get());
		this.trapdoorRecipe(pConsumer, IcariaItems.OLIVE_PLANKS.get(), IcariaItems.OLIVE_TRAPDOOR.get());
		this.trapdoorRecipe(pConsumer, IcariaItems.PLANE_PLANKS.get(), IcariaItems.PLANE_TRAPDOOR.get());
		this.trapdoorRecipe(pConsumer, IcariaItems.POPULUS_PLANKS.get(), IcariaItems.POPULUS_TRAPDOOR.get());

		this.ladderRecipe(pConsumer, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.CYPRESS_LADDER.get());
		this.ladderRecipe(pConsumer, IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.DROUGHTROOT_LADDER.get());
		this.ladderRecipe(pConsumer, IcariaItems.FIR_PLANKS.get(), IcariaItems.FIR_LADDER.get());
		this.ladderRecipe(pConsumer, IcariaItems.LAUREL_PLANKS.get(), IcariaItems.LAUREL_LADDER.get());
		this.ladderRecipe(pConsumer, IcariaItems.OLIVE_PLANKS.get(), IcariaItems.OLIVE_LADDER.get());
		this.ladderRecipe(pConsumer, IcariaItems.PLANE_PLANKS.get(), IcariaItems.PLANE_LADDER.get());
		this.ladderRecipe(pConsumer, IcariaItems.POPULUS_PLANKS.get(), IcariaItems.POPULUS_LADDER.get());

		this.signRecipe(pConsumer, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.CYPRESS_SIGN.get());
		this.signRecipe(pConsumer, IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.DROUGHTROOT_SIGN.get());
		this.signRecipe(pConsumer, IcariaItems.FIR_PLANKS.get(), IcariaItems.FIR_SIGN.get());
		this.signRecipe(pConsumer, IcariaItems.LAUREL_PLANKS.get(), IcariaItems.LAUREL_SIGN.get());
		this.signRecipe(pConsumer, IcariaItems.OLIVE_PLANKS.get(), IcariaItems.OLIVE_SIGN.get());
		this.signRecipe(pConsumer, IcariaItems.PLANE_PLANKS.get(), IcariaItems.PLANE_SIGN.get());
		this.signRecipe(pConsumer, IcariaItems.POPULUS_PLANKS.get(), IcariaItems.POPULUS_SIGN.get());

		this.hangingSignRecipe(pConsumer, IcariaItems.STRIPPED_CYPRESS_LOG.get(), IcariaItems.CYPRESS_HANGING_SIGN.get());
		this.hangingSignRecipe(pConsumer, IcariaItems.STRIPPED_DROUGHTROOT_LOG.get(), IcariaItems.DROUGHTROOT_HANGING_SIGN.get());
		this.hangingSignRecipe(pConsumer, IcariaItems.STRIPPED_FIR_LOG.get(), IcariaItems.FIR_HANGING_SIGN.get());
		this.hangingSignRecipe(pConsumer, IcariaItems.STRIPPED_LAUREL_LOG.get(), IcariaItems.LAUREL_HANGING_SIGN.get());
		this.hangingSignRecipe(pConsumer, IcariaItems.STRIPPED_OLIVE_LOG.get(), IcariaItems.OLIVE_HANGING_SIGN.get());
		this.hangingSignRecipe(pConsumer, IcariaItems.STRIPPED_PLANE_LOG.get(), IcariaItems.PLANE_HANGING_SIGN.get());
		this.hangingSignRecipe(pConsumer, IcariaItems.STRIPPED_POPULUS_LOG.get(), IcariaItems.POPULUS_HANGING_SIGN.get());

		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.BLINDWEED.get(), Items.PINK_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.CHAMEOMILE.get(), Items.WHITE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.CHARMONDER.get(), Items.LIGHT_BLUE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.CLOVER.get(), Items.WHITE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.FIREHILT.get(), Items.RED_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.BLUE_HYDRACINTH.get(), Items.BLUE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PURPLE_HYDRACINTH.get(), Items.PURPLE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.LIONFANGS.get(), Items.PURPLE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.SPEARDROPS.get(), Items.LIME_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PURPLE_STAGHORN.get(), Items.PURPLE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.YELLOW_STAGHORN.get(), Items.YELLOW_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.BLUE_STORMCOTTON.get(), Items.BLUE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PINK_STORMCOTTON.get(), Items.PINK_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PURPLE_STORMCOTTON.get(), Items.PURPLE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.SUNKETTLE.get(), Items.YELLOW_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.SUNSPONGE.get(), Items.ORANGE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.VOIDLILY.get(), Items.BLACK_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.BLUE_GROUND_FLOWERS.get(), Items.BLUE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.CYAN_GROUND_FLOWERS.get(), Items.CYAN_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PINK_GROUND_FLOWERS.get(), Items.PINK_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PURPLE_GROUND_FLOWERS.get(), Items.PURPLE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.RED_GROUND_FLOWERS.get(), Items.RED_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.WHITE_GROUND_FLOWERS.get(), Items.WHITE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.WHITE_BROMELIA.get(), Items.WHITE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.ORANGE_BROMELIA.get(), Items.ORANGE_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PINK_BROMELIA.get(), Items.PINK_DYE);
		this.dyesFromFlowerRecipe(pConsumer, IcariaItems.PURPLE_BROMELIA.get(), Items.PURPLE_DYE);

		this.gemSmeltingRecipes(pConsumer, IcariaItems.LIGNITE_ORE.get(), IcariaItems.LIGNITE.get());
		this.gemSmeltingRecipes(pConsumer, IcariaItems.DOLOMITE_ORE.get(), IcariaItems.DOLOMITE.get());
		this.gemSmeltingRecipes(pConsumer, IcariaItems.SLIVER_ORE.get(), IcariaItems.SLIVER.get());
		this.gemSmeltingRecipes(pConsumer, IcariaItems.ANTHRACITE_ORE.get(), IcariaItems.ANTHRACITE.get());

		this.ingotSmeltingRecipes(pConsumer, IcariaItems.CHALKOS_ORE.get(), IcariaItems.RAW_CHALKOS.get(), IcariaItems.CHALKOS_INGOT.get());
		this.ingotSmeltingRecipes(pConsumer, IcariaItems.KASSITEROS_ORE.get(), IcariaItems.RAW_KASSITEROS.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.ingotSmeltingRecipes(pConsumer, IcariaItems.VANADIUM_ORE.get(), IcariaItems.RAW_VANADIUM.get(), IcariaItems.VANADIUM_INGOT.get());
		this.ingotSmeltingRecipes(pConsumer, IcariaItems.SIDEROS_ORE.get(), IcariaItems.RAW_SIDEROS.get(), IcariaItems.SIDEROS_INGOT.get());
		this.ingotSmeltingRecipes(pConsumer, IcariaItems.MOLYBDENUM_ORE.get(), IcariaItems.RAW_MOLYBDENUM.get(), IcariaItems.MOLYBDENUM_INGOT.get());

		this.toolRecipes(pConsumer, IcariaItems.CHERT.get(), IcariaItems.CHERT_TOOLS.sword.get(), IcariaItems.CHERT_TOOLS.dagger.get(), IcariaItems.CHERT_TOOLS.shovel.get(), IcariaItems.CHERT_TOOLS.pickaxe.get(), IcariaItems.CHERT_TOOLS.axe.get(), IcariaItems.CHERT_TOOLS.scythe.get(), IcariaItems.CHERT_TOOLS.bident.get());
		this.toolRecipes(pConsumer, IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_TOOLS.sword.get(), IcariaItems.CHALKOS_TOOLS.dagger.get(), IcariaItems.CHALKOS_TOOLS.shovel.get(), IcariaItems.CHALKOS_TOOLS.pickaxe.get(), IcariaItems.CHALKOS_TOOLS.axe.get(), IcariaItems.CHALKOS_TOOLS.scythe.get(), IcariaItems.CHALKOS_TOOLS.bident.get());
		this.toolRecipes(pConsumer, IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_TOOLS.sword.get(), IcariaItems.KASSITEROS_TOOLS.dagger.get(), IcariaItems.KASSITEROS_TOOLS.shovel.get(), IcariaItems.KASSITEROS_TOOLS.pickaxe.get(), IcariaItems.KASSITEROS_TOOLS.axe.get(), IcariaItems.KASSITEROS_TOOLS.scythe.get(), IcariaItems.KASSITEROS_TOOLS.bident.get());
		this.toolRecipes(pConsumer, IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_TOOLS.sword.get(), IcariaItems.ORICHALCUM_TOOLS.dagger.get(), IcariaItems.ORICHALCUM_TOOLS.shovel.get(), IcariaItems.ORICHALCUM_TOOLS.pickaxe.get(), IcariaItems.ORICHALCUM_TOOLS.axe.get(), IcariaItems.ORICHALCUM_TOOLS.scythe.get(), IcariaItems.ORICHALCUM_TOOLS.bident.get());
		this.toolRecipes(pConsumer, IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_TOOLS.sword.get(), IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get(), IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get(), IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.VANADIUMSTEEL_TOOLS.axe.get(), IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get(), IcariaItems.VANADIUMSTEEL_TOOLS.bident.get());
		this.toolRecipes(pConsumer, IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_TOOLS.sword.get(), IcariaItems.SIDEROS_TOOLS.dagger.get(), IcariaItems.SIDEROS_TOOLS.shovel.get(), IcariaItems.SIDEROS_TOOLS.pickaxe.get(), IcariaItems.SIDEROS_TOOLS.axe.get(), IcariaItems.SIDEROS_TOOLS.scythe.get(), IcariaItems.SIDEROS_TOOLS.bident.get());
		this.toolRecipes(pConsumer, IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get(), IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get());

		this.armorRecipes(pConsumer, IcariaItems.AETERNAE_HIDE.get(), IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get(), IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get(), IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get(), IcariaItems.AETERNAE_HIDE_ARMOR.boots.get());
		this.armorRecipes(pConsumer, IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_ARMOR.helmet.get(), IcariaItems.CHALKOS_ARMOR.chestplate.get(), IcariaItems.CHALKOS_ARMOR.leggings.get(), IcariaItems.CHALKOS_ARMOR.boots.get());
		this.armorRecipes(pConsumer, IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_ARMOR.helmet.get(), IcariaItems.KASSITEROS_ARMOR.chestplate.get(), IcariaItems.KASSITEROS_ARMOR.leggings.get(), IcariaItems.KASSITEROS_ARMOR.boots.get());
		this.armorRecipes(pConsumer, IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_HELMET.get(), IcariaItems.ORICHALCUM_CHESTPLATE.get(), IcariaItems.ORICHALCUM_LEGGINGS.get(), IcariaItems.ORICHALCUM_BOOTS.get());
		this.armorRecipes(pConsumer, IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get(), IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get(), IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get(), IcariaItems.VANADIUMSTEEL_ARMOR.boots.get());

		this.vaseRecipe(pConsumer, Items.WHITE_DYE, IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.LIGHT_GRAY_DYE, IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.GRAY_DYE, IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.BLACK_DYE, IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.BROWN_DYE, IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.RED_DYE, IcariaItems.RED_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.ORANGE_DYE, IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.YELLOW_DYE, IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.LIME_DYE, IcariaItems.LIME_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.GREEN_DYE, IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.CYAN_DYE, IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.LIGHT_BLUE_DYE, IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.BLUE_DYE, IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.PURPLE_DYE, IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.MAGENTA_DYE, IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get());
		this.vaseRecipe(pConsumer, Items.PINK_DYE, IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());

		this.bowlFlaskTypeRecipe(pConsumer, IcariaItems.SILKGLASS.get(), IcariaItems.EMPTY_FLASK.get(), 3);
		this.bowlFlaskTypeRecipe(pConsumer, IcariaItems.LOAM_LUMP.get(), IcariaItems.UNFIRED_LOAM_BOWL.get(), 4);

		this.gearRecipe(pConsumer, IcariaItems.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_GEAR.get());
		this.gearRecipe(pConsumer, IcariaItems.LOAM_LUMP.get(), IcariaItems.UNFIRED_LOAM_GEAR.get());
		this.gearRecipe(pConsumer, IcariaItems.VOIDSHALE.get(), IcariaItems.VOIDSHALE_GEAR.get());
		this.gearRecipe(pConsumer, IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_GEAR.get());

		this.foodCookingRecipes(pConsumer, IcariaItems.RAW_AETERNAE_MEAT.get(), IcariaItems.COOKED_AETERNAE_MEAT.get());
		this.foodCookingRecipes(pConsumer, IcariaItems.RAW_CATOBLEPAS_MEAT.get(), IcariaItems.COOKED_CATOBLEPAS_MEAT.get());
		this.foodCookingRecipes(pConsumer, IcariaItems.RAW_CERVER_MEAT.get(), IcariaItems.COOKED_CERVER_MEAT.get());
		this.foodCookingRecipes(pConsumer, IcariaItems.RAW_SOW_MEAT.get(), IcariaItems.COOKED_SOW_MEAT.get());

		this.stewRecipe(pConsumer, IcariaItems.COOKED_AETERNAE_MEAT.get(), Items.BEETROOT, IcariaItems.AETERNAE_STEW.get());
		this.stewRecipe(pConsumer, IcariaItems.COOKED_CERVER_MEAT.get(), Items.CARROT, IcariaItems.CERVER_STEW.get());
		this.stewRecipe(pConsumer, IcariaItems.COOKED_CATOBLEPAS_MEAT.get(), IcariaItems.ONION.get(), IcariaItems.CATOBLEPAS_STEW.get());

		this.seedRecipe(pConsumer, IcariaItems.STRAWBERRIES.get(), IcariaItems.STRAWBERRY_SEEDS.get());
		this.seedRecipe(pConsumer, IcariaItems.PHYSALIS.get(), IcariaItems.PHYSALIS_SEEDS.get());

		for (var items : IcariaStoneDecoItems.STONE_DECO_ITEMS) {
			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, items.stairs.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', items.item.get())
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.stairs.getId());

			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, items.slab.get(), 6)
				.pattern("XXX")
				.define('X', items.item.get())
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.slab.getId());

			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, items.wall.get(), 6)
				.pattern("XXX")
				.pattern("XXX")
				.define('X', items.item.get())
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.wall.getId());

			SingleItemRecipeBuilder.stonecutting(Ingredient.of(items.item.get()), RecipeCategory.MISC, items.stairs.get())
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.stairs.getId() + "_from_stonecutting");

			SingleItemRecipeBuilder.stonecutting(Ingredient.of(items.item.get()), RecipeCategory.MISC, items.slab.get(), 2)
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.slab.getId() + "_from_stonecutting");

			SingleItemRecipeBuilder.stonecutting(Ingredient.of(items.item.get()), RecipeCategory.MISC, items.wall.get())
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.wall.getId() + "_from_stonecutting");
		}

		for (var items : IcariaWoodDecoItems.WOOD_DECO_ITEMS) {
			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, items.stairs.get(), 4)
				.pattern("X  ")
				.pattern("XX ")
				.pattern("XXX")
				.define('X', items.item.get())
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.stairs.getId());

			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, items.slab.get(), 6)
				.pattern("XXX")
				.define('X', items.item.get())
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.save(pConsumer, items.slab.getId());

			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, items.fence.get(), 3)
				.pattern("XYX")
				.pattern("XYX")
				.define('X', items.item.get())
				.define('Y', Items.STICK)
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
				.save(pConsumer, items.fence.getId());

			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, items.gate.get(), 1)
				.pattern("YXY")
				.pattern("YXY")
				.define('X', items.item.get())
				.define('Y', Items.STICK)
				.unlockedBy("has_" + items.item.get(), RecipeProvider.has(items.item.get()))
				.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
				.save(pConsumer, items.gate.getId());
		}

		// DOLOMITE
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.SMOOTH_DOLOMITE.get())
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.DOLOMITE.get())
			.unlockedBy("has_" + IcariaItems.DOLOMITE.get(), RecipeProvider.has(IcariaItems.DOLOMITE.get()))
			.save(pConsumer, IcariaItems.SMOOTH_DOLOMITE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.DOLOMITE_BRICKS.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.SMOOTH_DOLOMITE.get())
			.unlockedBy("has_" + IcariaItems.SMOOTH_DOLOMITE.get(), RecipeProvider.has(IcariaItems.SMOOTH_DOLOMITE.get()))
			.save(pConsumer, IcariaItems.DOLOMITE_BRICKS.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.DOLOMITE_PILLAR.get(), 2)
			.pattern("X")
			.pattern("X")
			.define('X', IcariaItems.DOLOMITE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.DOLOMITE_BRICKS.get(), RecipeProvider.has(IcariaItems.DOLOMITE_BRICKS.get()))
			.save(pConsumer, IcariaItems.DOLOMITE_PILLAR.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.DOLOMITE_PILLAR_HEAD.get(), 2)
			.pattern("X")
			.pattern("Y")
			.define('X', IcariaItems.DOLOMITE_BRICKS.get())
			.define('Y', IcariaItems.DOLOMITE_PILLAR.get())
			.unlockedBy("has_" + IcariaItems.DOLOMITE_BRICKS.get(), RecipeProvider.has(IcariaItems.DOLOMITE_BRICKS.get()))
			.unlockedBy("has_" + IcariaItems.DOLOMITE_PILLAR.get(), RecipeProvider.has(IcariaItems.DOLOMITE_PILLAR.get()))
			.save(pConsumer, IcariaItems.DOLOMITE_PILLAR_HEAD.getId());

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.SMOOTH_DOLOMITE.get()), RecipeCategory.MISC, IcariaItems.DOLOMITE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.SMOOTH_DOLOMITE.get(), RecipeProvider.has(IcariaItems.SMOOTH_DOLOMITE.get()))
			.save(pConsumer, IcariaItems.DOLOMITE_BRICKS.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.SMOOTH_DOLOMITE.get(), IcariaItems.DOLOMITE_BRICKS.get()), RecipeCategory.MISC, IcariaItems.DOLOMITE_PILLAR.get())
			.unlockedBy("has_" + IcariaItems.SMOOTH_DOLOMITE.get(), RecipeProvider.has(IcariaItems.SMOOTH_DOLOMITE.get()))
			.unlockedBy("has_" + IcariaItems.DOLOMITE_BRICKS.get(), RecipeProvider.has(IcariaItems.DOLOMITE_BRICKS.get()))
			.save(pConsumer, IcariaItems.DOLOMITE_PILLAR.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.SMOOTH_DOLOMITE.get(), IcariaItems.DOLOMITE_BRICKS.get(), IcariaItems.DOLOMITE_PILLAR.get()), RecipeCategory.MISC, IcariaItems.DOLOMITE_PILLAR_HEAD.get())
			.unlockedBy("has_" + IcariaItems.SMOOTH_DOLOMITE.get(), RecipeProvider.has(IcariaItems.SMOOTH_DOLOMITE.get()))
			.unlockedBy("has_" + IcariaItems.DOLOMITE_BRICKS.get(), RecipeProvider.has(IcariaItems.DOLOMITE_BRICKS.get()))
			.unlockedBy("has_" + IcariaItems.DOLOMITE_PILLAR.get(), RecipeProvider.has(IcariaItems.DOLOMITE_PILLAR.get()))
			.save(pConsumer, IcariaItems.DOLOMITE_PILLAR_HEAD.getId() + "_from_stonecutting");

		// GRAINITE
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.GRAINITE.get())
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.GRAINEL.get())
			.unlockedBy("has_" + IcariaItems.GRAINEL.get(), RecipeProvider.has(IcariaItems.GRAINEL.get()))
			.save(pConsumer, IcariaItems.GRAINITE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.GRAINITE_BRICKS.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.GRAINITE.get())
			.unlockedBy("has_" + IcariaItems.GRAINITE.get(), RecipeProvider.has(IcariaItems.GRAINITE.get()))
			.save(pConsumer, IcariaItems.GRAINITE_BRICKS.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.CHISELED_GRAINITE.get())
			.pattern("X")
			.pattern("X")
			.define('X', IcariaItems.GRAINITE_BRICK_DECO.slab.get())
			.unlockedBy("has_" + IcariaItems.GRAINITE_BRICK_DECO.slab.get(), RecipeProvider.has(IcariaItems.GRAINITE_BRICK_DECO.slab.get()))
			.save(pConsumer, IcariaItems.CHISELED_GRAINITE.getId());

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE.get()), RecipeCategory.MISC, IcariaItems.GRAINITE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.GRAINITE.get(), RecipeProvider.has(IcariaItems.GRAINITE.get()))
			.save(pConsumer, IcariaItems.GRAINITE_BRICKS.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.GRAINITE.get(), IcariaItems.GRAINITE_BRICKS.get()), RecipeCategory.MISC, IcariaItems.CHISELED_GRAINITE.get())
			.unlockedBy("has_" + IcariaItems.GRAINITE.get(), RecipeProvider.has(IcariaItems.GRAINITE.get()))
			.unlockedBy("has_" + IcariaItems.GRAINITE_BRICKS.get(), RecipeProvider.has(IcariaItems.GRAINITE_BRICKS.get()))
			.save(pConsumer, IcariaItems.CHISELED_GRAINITE.getId() + "_from_stonecutting");

		// RELICSTONE
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.RELICSTONE_BRICKS.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.RELICSTONE.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE.get(), RecipeProvider.has(IcariaItems.RELICSTONE.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_BRICKS.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.RELICSTONE_TILES.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.RELICSTONE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_TILES.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.CHISELED_RELICSTONE.get())
			.pattern("X")
			.pattern("X")
			.define('X', IcariaItems.RELICSTONE_BRICK_DECO.slab.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICK_DECO.slab.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICK_DECO.slab.get()))
			.save(pConsumer, IcariaItems.CHISELED_RELICSTONE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.RELICSTONE_PILLAR.get(), 2)
			.pattern("X")
			.pattern("X")
			.define('X', IcariaItems.RELICSTONE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_PILLAR.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.RELICSTONE_PILLAR_HEAD.get(), 2)
			.pattern("X")
			.pattern("Y")
			.define('X', IcariaItems.RELICSTONE_BRICKS.get())
			.define('Y', IcariaItems.RELICSTONE_PILLAR.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_PILLAR.get(), RecipeProvider.has(IcariaItems.RELICSTONE_PILLAR.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_PILLAR_HEAD.getId());

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IcariaItems.MOSSY_RELICSTONE_BRICKS.get())
			.requires(IcariaItems.RELICSTONE_BRICKS.get())
			.requires(Items.MOSS_BLOCK)
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.unlockedBy("has_" + Items.MOSS_BLOCK, RecipeProvider.has(Items.MOSS_BLOCK))
			.save(pConsumer, IcariaItems.MOSSY_RELICSTONE_BRICKS.getId() + "_from_moss_block");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IcariaItems.MOSSY_RELICSTONE_BRICKS.get())
			.requires(IcariaItems.RELICSTONE_BRICKS.get())
			.requires(Ingredient.of(Items.VINE, IcariaItems.BLOOMY_VINE.get(), IcariaItems.BRANCHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.DRY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.SWIRLY_VINE.get(), IcariaItems.THORNY_VINE.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.unlockedBy("has_" + Items.VINE, RecipeProvider.has(Items.VINE))
			.unlockedBy("has_" + IcariaItems.BLOOMY_VINE.get(), RecipeProvider.has((IcariaItems.BLOOMY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRANCHY_VINE.get(), RecipeProvider.has((IcariaItems.BRANCHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRUSHY_VINE.get(), RecipeProvider.has((IcariaItems.BRUSHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.DRY_VINE.get(), RecipeProvider.has((IcariaItems.DRY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.REEDY_VINE.get(), RecipeProvider.has((IcariaItems.REEDY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.SWIRLY_VINE.get(), RecipeProvider.has((IcariaItems.SWIRLY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.THORNY_VINE.get(), RecipeProvider.has((IcariaItems.THORNY_VINE.get())))
			.save(pConsumer, IcariaItems.MOSSY_RELICSTONE_BRICKS.getId() + "_from_vine");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IcariaItems.MOSSY_RELICSTONE_TILES.get())
			.requires(IcariaItems.RELICSTONE_TILES.get())
			.requires(Items.MOSS_BLOCK)
			.unlockedBy("has_" + IcariaItems.RELICSTONE_TILES.get(), RecipeProvider.has(IcariaItems.RELICSTONE_TILES.get()))
			.unlockedBy("has_" + Items.MOSS_BLOCK, RecipeProvider.has(Items.MOSS_BLOCK))
			.save(pConsumer, IcariaItems.MOSSY_RELICSTONE_TILES.getId() + "_from_moss_block");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IcariaItems.MOSSY_RELICSTONE_TILES.get())
			.requires(IcariaItems.RELICSTONE_TILES.get())
			.requires(Ingredient.of(Items.VINE, IcariaItems.BLOOMY_VINE.get(), IcariaItems.BRANCHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.DRY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.SWIRLY_VINE.get(), IcariaItems.THORNY_VINE.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_TILES.get(), RecipeProvider.has(IcariaItems.RELICSTONE_TILES.get()))
			.unlockedBy("has_" + Items.VINE, RecipeProvider.has(Items.VINE))
			.unlockedBy("has_" + IcariaItems.BLOOMY_VINE.get(), RecipeProvider.has((IcariaItems.BLOOMY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRANCHY_VINE.get(), RecipeProvider.has((IcariaItems.BRANCHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRUSHY_VINE.get(), RecipeProvider.has((IcariaItems.BRUSHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.DRY_VINE.get(), RecipeProvider.has((IcariaItems.DRY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.REEDY_VINE.get(), RecipeProvider.has((IcariaItems.REEDY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.SWIRLY_VINE.get(), RecipeProvider.has((IcariaItems.SWIRLY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.THORNY_VINE.get(), RecipeProvider.has((IcariaItems.THORNY_VINE.get())))
			.save(pConsumer, IcariaItems.MOSSY_RELICSTONE_TILES.getId() + "_from_vine");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE.get()), RecipeCategory.MISC, IcariaItems.SMOOTH_RELICSTONE.get(), 0.1F, 200)
			.unlockedBy("has_" + IcariaItems.RELICSTONE.get(), RecipeProvider.has(IcariaItems.RELICSTONE.get()))
			.save(pConsumer, IcariaItems.SMOOTH_RELICSTONE.getId() + "_from_smelting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE_BRICKS.get()), RecipeCategory.MISC, IcariaItems.CRACKED_RELICSTONE_BRICKS.get(), 0.1F, 200)
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(pConsumer, IcariaItems.CRACKED_RELICSTONE_BRICKS.getId() + "_from_smelting");

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(IcariaItems.RELICSTONE_TILES.get()), RecipeCategory.MISC, IcariaItems.CRACKED_RELICSTONE_TILES.get(), 0.1F, 200)
			.unlockedBy("has_" + IcariaItems.RELICSTONE_TILES.get(), RecipeProvider.has(IcariaItems.RELICSTONE_TILES.get()))
			.save(pConsumer, IcariaItems.CRACKED_RELICSTONE_TILES.getId() + "_from_smelting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get()), RecipeCategory.MISC, IcariaItems.RELICSTONE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE.get(), RecipeProvider.has(IcariaItems.RELICSTONE.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_BRICKS.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get(), IcariaItems.RELICSTONE_BRICKS.get()), RecipeCategory.MISC, IcariaItems.RELICSTONE_TILES.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE.get(), RecipeProvider.has(IcariaItems.RELICSTONE.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_TILES.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get(), IcariaItems.RELICSTONE_BRICKS.get()), RecipeCategory.MISC, IcariaItems.CHISELED_RELICSTONE.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE.get(), RecipeProvider.has(IcariaItems.RELICSTONE.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(pConsumer, IcariaItems.CHISELED_RELICSTONE.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get(), IcariaItems.RELICSTONE_BRICKS.get()), RecipeCategory.MISC, IcariaItems.RELICSTONE_PILLAR.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE.get(), RecipeProvider.has(IcariaItems.RELICSTONE.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_PILLAR.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.RELICSTONE.get(), IcariaItems.RELICSTONE_BRICKS.get(), IcariaItems.RELICSTONE_PILLAR.get()), RecipeCategory.MISC, IcariaItems.RELICSTONE_PILLAR_HEAD.get())
			.unlockedBy("has_" + IcariaItems.RELICSTONE.get(), RecipeProvider.has(IcariaItems.RELICSTONE.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.RELICSTONE_BRICKS.get()))
			.unlockedBy("has_" + IcariaItems.RELICSTONE_PILLAR.get(), RecipeProvider.has(IcariaItems.RELICSTONE_PILLAR.get()))
			.save(pConsumer, IcariaItems.RELICSTONE_PILLAR_HEAD.getId() + "_from_stonecutting");

		// PLATOSHALE
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.PLATOSHALE_BRICKS.get(), 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.PLATOSHALE.get())
			.unlockedBy("has_" + IcariaItems.PLATOSHALE.get(), RecipeProvider.has(IcariaItems.PLATOSHALE.get()))
			.save(pConsumer, IcariaItems.PLATOSHALE_BRICKS.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.CHISELED_PLATOSHALE.get())
			.pattern("X")
			.pattern("X")
			.define('X', IcariaItems.PLATOSHALE_BRICK_DECO.slab.get())
			.unlockedBy("has_" + IcariaItems.PLATOSHALE_BRICK_DECO.slab.get(), RecipeProvider.has(IcariaItems.PLATOSHALE_BRICK_DECO.slab.get()))
			.save(pConsumer, IcariaItems.CHISELED_PLATOSHALE.getId());

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.PLATOSHALE.get()), RecipeCategory.MISC, IcariaItems.PLATOSHALE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.PLATOSHALE.get(), RecipeProvider.has(IcariaItems.PLATOSHALE.get()))
			.save(pConsumer, IcariaItems.PLATOSHALE_BRICKS.getId() + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(IcariaItems.PLATOSHALE.get(), IcariaItems.PLATOSHALE_BRICKS.get()), RecipeCategory.MISC, IcariaItems.CHISELED_PLATOSHALE.get())
			.unlockedBy("has_" + IcariaItems.PLATOSHALE.get(), RecipeProvider.has(IcariaItems.PLATOSHALE.get()))
			.unlockedBy("has_" + IcariaItems.PLATOSHALE_BRICKS.get(), RecipeProvider.has(IcariaItems.PLATOSHALE_BRICKS.get()))
			.save(pConsumer, IcariaItems.CHISELED_PLATOSHALE.getId() + "_from_stonecutting");

		// QUARTZ
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.QUARTZ_PILLAR_HEAD.get(), 2)
			.pattern("X")
			.pattern("Y")
			.define('X', Items.QUARTZ_BRICKS)
			.define('Y', Items.QUARTZ_PILLAR)
			.unlockedBy("has_" + Items.QUARTZ_BRICKS, RecipeProvider.has(Items.QUARTZ_BRICKS))
			.unlockedBy("has_" + Items.QUARTZ_PILLAR, RecipeProvider.has(Items.QUARTZ_PILLAR))
			.save(pConsumer, IcariaItems.QUARTZ_PILLAR_HEAD.getId());

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.QUARTZ_BLOCK, Items.QUARTZ_BRICKS, Items.QUARTZ_PILLAR), RecipeCategory.MISC, IcariaItems.QUARTZ_PILLAR_HEAD.get())
			.unlockedBy("has_" + Items.QUARTZ_BLOCK, RecipeProvider.has(Items.QUARTZ_BLOCK))
			.unlockedBy("has_" + Items.QUARTZ_BRICKS, RecipeProvider.has(Items.QUARTZ_BRICKS))
			.unlockedBy("has_" + Items.QUARTZ_PILLAR, RecipeProvider.has(Items.QUARTZ_PILLAR))
			.save(pConsumer, IcariaItems.QUARTZ_PILLAR_HEAD.getId() + "_from_stonecutting");

		// MISC
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.COARSE_MARL.get(), 4)
			.pattern("XY")
			.pattern("YX")
			.define('Y', IcariaItems.MARL.get())
			.define('X', IcariaItems.GRAINEL.get())
			.unlockedBy("has_" + IcariaItems.MARL.get(), RecipeProvider.has(IcariaItems.MARL.get()))
			.unlockedBy("has_" + IcariaItems.GRAINEL.get(), RecipeProvider.has(IcariaItems.GRAINEL.get()))
			.save(pConsumer, IcariaItems.COARSE_MARL.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.PACKED_ARISTONE.get())
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', IcariaItems.ARISTONE.get())
			.unlockedBy("has_" + IcariaItems.ARISTONE.get(), RecipeProvider.has(IcariaItems.ARISTONE.get()))
			.save(pConsumer, IcariaItems.PACKED_ARISTONE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.VANADIUMSTEEL_BARS.get(), 16)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', IcariaItems.VANADIUMSTEEL_INGOT.get())
			.unlockedBy("has_" + IcariaItems.VANADIUMSTEEL_INGOT.get(), RecipeProvider.has(IcariaItems.VANADIUMSTEEL_INGOT.get()))
			.save(pConsumer, IcariaItems.VANADIUMSTEEL_BARS.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.HORIZONTAL_VANADIUMSTEEL_BARS.get(), 2)
			.pattern("XX")
			.define('X', IcariaItems.VANADIUMSTEEL_BARS.get())
			.unlockedBy("has_" + IcariaItems.VANADIUMSTEEL_BARS.get(), RecipeProvider.has(IcariaItems.VANADIUMSTEEL_BARS.get()))
			.save(pConsumer, IcariaItems.HORIZONTAL_VANADIUMSTEEL_BARS.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.VANADIUMSTEEL_CHAIN.get(), 1)
			.pattern("X")
			.pattern("Y")
			.pattern("X")
			.define('X', IcariaItems.VANADIUMSTEEL_NUGGET.get())
			.define('Y', IcariaItems.VANADIUMSTEEL_INGOT.get())
			.unlockedBy("has_" + IcariaItems.VANADIUMSTEEL_NUGGET.get(), RecipeProvider.has(IcariaItems.VANADIUMSTEEL_NUGGET.get()))
			.unlockedBy("has_" + IcariaItems.VANADIUMSTEEL_INGOT.get(), RecipeProvider.has(IcariaItems.VANADIUMSTEEL_INGOT.get()))
			.save(pConsumer, IcariaItems.VANADIUMSTEEL_CHAIN.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.KETTLE.get())
			.pattern("X X")
			.pattern("Y Y")
			.pattern("XYX")
			.define('X', IcariaItems.ORICHALCUM_INGOT.get())
			.define('Y', IcariaItems.VANADIUMSTEEL_BLOCK.get())
			.unlockedBy("has_" + IcariaItems.ORICHALCUM_INGOT.get(), RecipeProvider.has(IcariaItems.ORICHALCUM_INGOT.get()))
			.unlockedBy("has_" + IcariaItems.VANADIUMSTEEL_BLOCK.get(), RecipeProvider.has(IcariaItems.VANADIUMSTEEL_BLOCK.get()))
			.save(pConsumer, IcariaItems.KETTLE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.GRINDER.get())
			.pattern("XXX")
			.pattern("XYX")
			.pattern("XXX")
			.define('X', IcariaItems.SUNSTONE_BRICKS.get())
			.define('Y', IcariaItems.ORICHALCUM_INGOT.get())
			.unlockedBy("has_" + IcariaItems.SUNSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.SUNSTONE_BRICKS.get()))
			.unlockedBy("has_" + IcariaItems.ORICHALCUM_INGOT.get(), RecipeProvider.has(IcariaItems.ORICHALCUM_INGOT.get()))
			.save(pConsumer, IcariaItems.GRINDER.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.KILN.get())
			.pattern("XXX")
			.pattern("X X")
			.pattern("XXX")
			.define('X', IcariaItems.YELLOWSTONE_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.YELLOWSTONE_BRICKS.get(), RecipeProvider.has(IcariaItems.YELLOWSTONE_BRICKS.get()))
			.save(pConsumer, IcariaItems.KILN.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.FORGE.get())
			.pattern("XYX")
			.pattern("X X")
			.pattern("XYX")
			.define('X', IcariaItems.GRAINITE_BRICKS.get())
			.define('Y', IcariaItems.LOAM_BRICKS.get())
			.unlockedBy("has_" + IcariaItems.GRAINITE_BRICKS.get(), RecipeProvider.has(IcariaItems.GRAINITE_BRICKS.get()))
			.unlockedBy("has_" + IcariaItems.LOAM_BRICKS.get(), RecipeProvider.has(IcariaItems.LOAM_BRICKS.get()))
			.save(pConsumer, IcariaItems.FORGE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.CHEST.get())
			.pattern("XYX")
			.pattern("X X")
			.pattern("XXX")
			.define('X', IcariaItems.LAUREL_PLANKS.get())
			.define('Y', IcariaItems.STRIPPED_LAUREL_LOG.get())
			.unlockedBy("has_" + IcariaItems.LAUREL_PLANKS.get(), RecipeProvider.has(IcariaItems.LAUREL_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.STRIPPED_LAUREL_LOG.get(), RecipeProvider.has(IcariaItems.STRIPPED_LAUREL_LOG.get()))
			.save(pConsumer, IcariaItems.CHEST.getId());

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IcariaItems.TRAPPED_CHEST.get())
			.requires(IcariaItems.CHEST.get())
			.requires(Items.TRIPWIRE_HOOK)
			.unlockedBy("has_" + IcariaItems.CHEST.get(), RecipeProvider.has(IcariaItems.CHEST.get()))
			.unlockedBy("has_" + Items.TRIPWIRE_HOOK, RecipeProvider.has(Items.TRIPWIRE_HOOK))
			.save(pConsumer, IcariaItems.TRAPPED_CHEST.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.LAUREL_WREATH.get(), 1)
			.pattern("XXX")
			.pattern("X X")
			.define('X', IcariaItems.LAUREL_LEAVES.get())
			.unlockedBy("has_" + IcariaItems.LAUREL_LEAVES.get(), RecipeProvider.has(IcariaItems.LAUREL_LEAVES.get()))
			.save(pConsumer, IcariaItems.LAUREL_WREATH.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.GREEK_FIRE_GRENADE.get(), 1)
			.pattern(" X ")
			.pattern("YZY")
			.pattern(" Y ")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', IcariaItems.KASSITEROS_NUGGET.get())
			.define('Z', IcariaItems.CALCITE_DUST.get())
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy("has_" + IcariaItems.KASSITEROS_NUGGET.get(), RecipeProvider.has(IcariaItems.KASSITEROS_NUGGET.get()))
			.unlockedBy("has_" + IcariaItems.CALCITE_DUST.get(), RecipeProvider.has(IcariaItems.CALCITE_DUST.get()))
			.save(pConsumer, IcariaItems.GREEK_FIRE_GRENADE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.UNFIRED_STORAGE_VASE.get())
			.pattern("XXX")
			.pattern("X X")
			.pattern("XXX")
			.define('X', IcariaItems.LOAM_LUMP.get())
			.unlockedBy("has_" + IcariaItems.LOAM_LUMP.get(), RecipeProvider.has(IcariaItems.LOAM_LUMP.get()))
			.save(pConsumer, IcariaItems.UNFIRED_STORAGE_VASE.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.EMPTY_VIAL.get(), 3)
			.pattern("X X")
			.pattern(" X ")
			.define('X', Ingredient.of(IcariaItems.GRAINGLASS_PANE.get(), IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get()))
			.unlockedBy("has_" + IcariaItems.GRAINGLASS_PANE.get(), RecipeProvider.has(IcariaItems.GRAINGLASS_PANE.get()))
			.unlockedBy("has_" + IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get(), RecipeProvider.has(IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get()))
			.save(pConsumer, IcariaItems.EMPTY_VIAL.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.CHEST_LABEL.get())
			.pattern("XXX")
			.define('X', Items.PAPER)
			.unlockedBy("has_" + Items.PAPER, RecipeProvider.has(Items.PAPER))
			.save(pConsumer, IcariaItems.CHEST_LABEL.getId());

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IcariaItems.DAEDALIAN_GEAR.get())
			.requires(IcariaItems.BLUE_GEARFRAGMENT.get())
			.requires(IcariaItems.GREEN_GEARFRAGMENT.get())
			.requires(IcariaItems.YELLOW_GEARFRAGMENT.get())
			.unlockedBy("has_" + IcariaItems.BLUE_GEARFRAGMENT.get(), RecipeProvider.has(IcariaItems.BLUE_GEARFRAGMENT.get()))
			.unlockedBy("has_" + IcariaItems.GREEN_GEARFRAGMENT.get(), RecipeProvider.has(IcariaItems.GREEN_GEARFRAGMENT.get()))
			.unlockedBy("has_" + IcariaItems.YELLOW_GEARFRAGMENT.get(), RecipeProvider.has(IcariaItems.YELLOW_GEARFRAGMENT.get()))
			.save(pConsumer, IcariaItems.DAEDALIAN_GEAR.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.SPELT_BREAD.get())
			.pattern("XXX")
			.define('X', IcariaItems.SPELT.get())
			.unlockedBy("has_" + IcariaItems.SPELT.get(), RecipeProvider.has(IcariaItems.SPELT.get()))
			.save(pConsumer, IcariaItems.SPELT_BREAD.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.FRUIT_SALAD.get())
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
			.unlockedBy("has_" + IcariaItems.STRAWBERRIES.get(), RecipeProvider.has(IcariaItems.STRAWBERRIES.get()))
			.unlockedBy("has_" + IcariaItems.PHYSALIS.get(), RecipeProvider.has(IcariaItems.PHYSALIS.get()))
			.unlockedBy("has_" + Items.COCOA_BEANS, RecipeProvider.has(Items.COCOA_BEANS))
			.unlockedBy("has_" + Items.MELON_SLICE, RecipeProvider.has(Items.MELON_SLICE))
			.unlockedBy("has_" + Items.GOLDEN_APPLE, RecipeProvider.has(Items.GOLDEN_APPLE))
			.unlockedBy("has_" + IcariaItems.LAUREL_CHERRY.get(), RecipeProvider.has(IcariaItems.LAUREL_CHERRY.get()))
			.unlockedBy("has_" + IcariaItems.LOAM_BOWL.get(), RecipeProvider.has(IcariaItems.LOAM_BOWL.get()))
			.save(pConsumer, IcariaItems.FRUIT_SALAD.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.ONION_SOUP.get(), 1)
			.pattern("XXX")
			.pattern("YZ ")
			.define('X', IcariaItems.ONION.get())
			.define('Y', IcariaItems.HALITE_DUST.get())
			.define('Z', IcariaItems.LOAM_BOWL.get())
			.unlockedBy("has_" + IcariaItems.ONION.get(), RecipeProvider.has(IcariaItems.ONION.get()))
			.unlockedBy("has_" + IcariaItems.HALITE_DUST.get(), RecipeProvider.has(IcariaItems.HALITE_DUST.get()))
			.unlockedBy("has_" + IcariaItems.LOAM_BOWL.get(), RecipeProvider.has(IcariaItems.LOAM_BOWL.get()))
			.save(pConsumer, IcariaItems.ONION_SOUP.getId());

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IcariaItems.SOW_STEW.get(), 1)
			.pattern("ABB")
			.pattern("CD ")
			.define('A', IcariaItems.COOKED_SOW_MEAT.get())
			.define('B', Ingredient.of(Items.BROWN_MUSHROOM, Items.RED_MUSHROOM, IcariaItems.BROWN_GROUND_SHROOMS.get(), IcariaItems.GREEN_GROUND_SHROOMS.get(), IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get(), IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get(), IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get(), IcariaItems.UNNAMED_TREE_SHROOMS.get()))
			.define('C', IcariaItems.HALITE_DUST.get())
			.define('D', IcariaItems.LOAM_BOWL.get())
			.unlockedBy("has_" + IcariaItems.COOKED_SOW_MEAT.get(), RecipeProvider.has(IcariaItems.COOKED_SOW_MEAT.get()))
			.unlockedBy("has_" + Items.BROWN_MUSHROOM, RecipeProvider.has(Items.BROWN_MUSHROOM))
			.unlockedBy("has_" + Items.RED_MUSHROOM, RecipeProvider.has(Items.RED_MUSHROOM))
			.unlockedBy("has_" + IcariaItems.BROWN_GROUND_SHROOMS.get(), RecipeProvider.has(IcariaItems.BROWN_GROUND_SHROOMS.get()))
			.unlockedBy("has_" + IcariaItems.GREEN_GROUND_SHROOMS.get(), RecipeProvider.has(IcariaItems.GREEN_GROUND_SHROOMS.get()))
			.unlockedBy("has_" + IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get(), RecipeProvider.has(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get()))
			.unlockedBy("has_" + IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get(), RecipeProvider.has(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get()))
			.unlockedBy("has_" + IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get(), RecipeProvider.has(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get()))
			.unlockedBy("has_" + IcariaItems.UNNAMED_TREE_SHROOMS.get(), RecipeProvider.has(IcariaItems.UNNAMED_TREE_SHROOMS.get()))
			.unlockedBy("has_" + IcariaItems.HALITE_DUST.get(), RecipeProvider.has(IcariaItems.HALITE_DUST.get()))
			.unlockedBy("has_" + IcariaItems.LOAM_BOWL.get(), RecipeProvider.has(IcariaItems.LOAM_BOWL.get()))
			.save(pConsumer, IcariaItems.SOW_STEW.getId());

		// VANILLA
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ARROW)
			.pattern("X")
			.pattern("Y")
			.pattern("Z")
			.define('X', IcariaItems.CHERT.get())
			.define('Y', Items.STICK)
			.define('Z', Items.FEATHER)
			.unlockedBy("has_" + IcariaItems.CHERT.get(), RecipeProvider.has(IcariaItems.CHERT.get()))
			.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
			.unlockedBy("has_" + Items.FEATHER, RecipeProvider.has(Items.FEATHER))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.ARROW) + "_from_chert");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOOK)
			.pattern("XX")
			.pattern("XY")
			.define('X', Items.PAPER)
			.define('Y', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_" + Items.PAPER, RecipeProvider.has(Items.PAPER))
			.unlockedBy("has_" + IcariaItems.AETERNAE_HIDE.get(), RecipeProvider.has(IcariaItems.AETERNAE_HIDE.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.BOOK) + "_from_aeternae_hide");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.BOW)
			.pattern(" XY")
			.pattern("X Y")
			.pattern(" XY")
			.define('X', Items.STICK)
			.define('Y', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.BOW) + "_from_arachne_string");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CANDLE)
			.pattern("X")
			.pattern("Y")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', Items.HONEYCOMB)
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy("has_" + Items.HONEYCOMB, RecipeProvider.has(Items.HONEYCOMB))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.CANDLE) + "_from_arachne_string");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COMPARATOR)
			.pattern(" X ")
			.pattern("XYX")
			.pattern("ZZZ")
			.define('X', Items.REDSTONE_TORCH)
			.define('Y', Items.QUARTZ)
			.define('Z', IcariaItems.SMOOTH_RELICSTONE.get())
			.unlockedBy("has_" + Items.REDSTONE_TORCH, RecipeProvider.has(Items.REDSTONE_TORCH))
			.unlockedBy("has_" + Items.QUARTZ, RecipeProvider.has(Items.QUARTZ))
			.unlockedBy("has_" + IcariaItems.SMOOTH_RELICSTONE.get(), RecipeProvider.has(IcariaItems.SMOOTH_RELICSTONE.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.COMPARATOR) + "_from_relicstone");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.CROSSBOW)
			.pattern("ABA")
			.pattern("CDC")
			.pattern(" A ")
			.define('A', Items.STICK)
			.define('B', Items.IRON_INGOT)
			.define('C', IcariaItems.ARACHNE_STRING.get())
			.define('D', Items.TRIPWIRE_HOOK)
			.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
			.unlockedBy("has_" + Items.IRON_INGOT, RecipeProvider.has(Items.IRON_INGOT))
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy("has_" + Items.TRIPWIRE_HOOK, RecipeProvider.has(Items.TRIPWIRE_HOOK))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.CROSSBOW) + "_from_arachne_string");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FISHING_ROD)
			.pattern("  X")
			.pattern(" XY")
			.pattern("X Y")
			.define('X', Items.STICK)
			.define('Y', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.FISHING_ROD) + "_from_arachne_string");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE)
			.pattern("XX")
			.pattern("YY")
			.pattern("YY")
			.define('X', IcariaItems.CHERT.get())
			.define('Y', Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.FIR_PLANKS.get(), IcariaItems.LAUREL_PLANKS.get(), IcariaItems.OLIVE_PLANKS.get(), IcariaItems.PLANE_PLANKS.get(), IcariaItems.POPULUS_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.CHERT.get(), RecipeProvider.has(IcariaItems.CHERT.get()))
			.unlockedBy("has_" + Items.OAK_PLANKS, RecipeProvider.has(Items.OAK_PLANKS))
			.unlockedBy("has_" + Items.SPRUCE_PLANKS, RecipeProvider.has(Items.SPRUCE_PLANKS))
			.unlockedBy("has_" + Items.BIRCH_PLANKS, RecipeProvider.has(Items.BIRCH_PLANKS))
			.unlockedBy("has_" + Items.JUNGLE_PLANKS, RecipeProvider.has(Items.JUNGLE_PLANKS))
			.unlockedBy("has_" + Items.ACACIA_PLANKS, RecipeProvider.has(Items.ACACIA_PLANKS))
			.unlockedBy("has_" + Items.DARK_OAK_PLANKS, RecipeProvider.has(Items.DARK_OAK_PLANKS))
			.unlockedBy("has_" + Items.MANGROVE_PLANKS, RecipeProvider.has(Items.MANGROVE_PLANKS))
			.unlockedBy("has_" + Items.CRIMSON_PLANKS, RecipeProvider.has(Items.CRIMSON_PLANKS))
			.unlockedBy("has_" + Items.WARPED_PLANKS, RecipeProvider.has(Items.WARPED_PLANKS))
			.unlockedBy("has_" + IcariaItems.CYPRESS_PLANKS.get(), RecipeProvider.has(IcariaItems.CYPRESS_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.DROUGHTROOT_PLANKS.get(), RecipeProvider.has(IcariaItems.DROUGHTROOT_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.FIR_PLANKS.get(), RecipeProvider.has(IcariaItems.FIR_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.LAUREL_PLANKS.get(), RecipeProvider.has(IcariaItems.LAUREL_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.OLIVE_PLANKS.get(), RecipeProvider.has(IcariaItems.OLIVE_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.PLANE_PLANKS.get(), RecipeProvider.has(IcariaItems.PLANE_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.POPULUS_PLANKS.get(), RecipeProvider.has(IcariaItems.POPULUS_PLANKS.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.FLETCHING_TABLE) + "_from_chert");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.ITEM_FRAME)
			.pattern("XXX")
			.pattern("XYX")
			.pattern("XXX")
			.define('X', Items.STICK)
			.define('Y', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
			.unlockedBy("has_" + IcariaItems.AETERNAE_HIDE.get(), RecipeProvider.has(IcariaItems.AETERNAE_HIDE.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.ITEM_FRAME) + "_from_aeternae_hide");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LEAD, 2)
			.pattern("XX ")
			.pattern("XY ")
			.pattern("  X")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', Items.SLIME_BALL)
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy("has_" + Items.SLIME_BALL, RecipeProvider.has(Items.SLIME_BALL))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.LEAD) + "_from_arachne_string");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LEAD, 2)
			.pattern("XX ")
			.pattern("XY ")
			.pattern("  X")
			.define('X', Items.STRING)
			.define('Y', Ingredient.of(IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + Items.STRING, RecipeProvider.has(Items.STRING))
			.unlockedBy("has_" + IcariaItems.ENDER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.ENDER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.FIRE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.FIRE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.NATURE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.NATURE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.VOID_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.VOID_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.WATER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.LEAD) + "_from_jellyfish_jelly");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LEAD, 2)
			.pattern("XX ")
			.pattern("XY ")
			.pattern("  X")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', Ingredient.of(IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy("has_" + IcariaItems.ENDER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.ENDER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.FIRE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.FIRE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.NATURE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.NATURE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.VOID_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.VOID_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.WATER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.LEAD) + "_from_arachne_string_and_jellyfish_jelly");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LEATHER_HORSE_ARMOR)
			.pattern("X X")
			.pattern("XXX")
			.pattern("X X")
			.define('X', IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy("has_" + IcariaItems.AETERNAE_HIDE.get(), RecipeProvider.has(IcariaItems.AETERNAE_HIDE.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.LEATHER_HORSE_ARMOR) + "_from_aeternae_hide");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.LOOM)
			.pattern("XX ")
			.pattern("YY ")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.define('Y', Ingredient.of(Items.OAK_PLANKS, Items.SPRUCE_PLANKS, Items.BIRCH_PLANKS, Items.JUNGLE_PLANKS, Items.ACACIA_PLANKS, Items.DARK_OAK_PLANKS, Items.MANGROVE_PLANKS, Items.CRIMSON_PLANKS, Items.WARPED_PLANKS, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.FIR_PLANKS.get(), IcariaItems.LAUREL_PLANKS.get(), IcariaItems.OLIVE_PLANKS.get(), IcariaItems.PLANE_PLANKS.get(), IcariaItems.POPULUS_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy("has_" + Items.OAK_PLANKS, RecipeProvider.has(Items.OAK_PLANKS))
			.unlockedBy("has_" + Items.SPRUCE_PLANKS, RecipeProvider.has(Items.SPRUCE_PLANKS))
			.unlockedBy("has_" + Items.BIRCH_PLANKS, RecipeProvider.has(Items.BIRCH_PLANKS))
			.unlockedBy("has_" + Items.JUNGLE_PLANKS, RecipeProvider.has(Items.JUNGLE_PLANKS))
			.unlockedBy("has_" + Items.ACACIA_PLANKS, RecipeProvider.has(Items.ACACIA_PLANKS))
			.unlockedBy("has_" + Items.DARK_OAK_PLANKS, RecipeProvider.has(Items.DARK_OAK_PLANKS))
			.unlockedBy("has_" + Items.MANGROVE_PLANKS, RecipeProvider.has(Items.MANGROVE_PLANKS))
			.unlockedBy("has_" + Items.CRIMSON_PLANKS, RecipeProvider.has(Items.CRIMSON_PLANKS))
			.unlockedBy("has_" + Items.WARPED_PLANKS, RecipeProvider.has(Items.WARPED_PLANKS))
			.unlockedBy("has_" + IcariaItems.CYPRESS_PLANKS.get(), RecipeProvider.has(IcariaItems.CYPRESS_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.DROUGHTROOT_PLANKS.get(), RecipeProvider.has(IcariaItems.DROUGHTROOT_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.FIR_PLANKS.get(), RecipeProvider.has(IcariaItems.FIR_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.LAUREL_PLANKS.get(), RecipeProvider.has(IcariaItems.LAUREL_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.OLIVE_PLANKS.get(), RecipeProvider.has(IcariaItems.OLIVE_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.PLANE_PLANKS.get(), RecipeProvider.has(IcariaItems.PLANE_PLANKS.get()))
			.unlockedBy("has_" + IcariaItems.POPULUS_PLANKS.get(), RecipeProvider.has(IcariaItems.POPULUS_PLANKS.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.LOOM) + "_from_arachne_string");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.PAPER, 3)
			.pattern("XXX")
			.define('X', IcariaItems.VINE_REED.get())
			.unlockedBy("has_" + IcariaItems.VINE_REED.get(), RecipeProvider.has(IcariaItems.VINE_REED.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.PAPER) + "_from_vine_reed");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.REPEATER)
			.pattern("XYX")
			.pattern("ZZZ")
			.define('X', Items.REDSTONE_TORCH)
			.define('Y', Items.REDSTONE)
			.define('Z', IcariaItems.SMOOTH_RELICSTONE.get())
			.unlockedBy("has_" + Items.REDSTONE_TORCH, RecipeProvider.has(Items.REDSTONE_TORCH))
			.unlockedBy("has_" + Items.REDSTONE, RecipeProvider.has(Items.REDSTONE))
			.unlockedBy("has_" + IcariaItems.SMOOTH_RELICSTONE.get(), RecipeProvider.has(IcariaItems.SMOOTH_RELICSTONE.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.REPEATER) + "_from_relicstone");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.SCAFFOLDING)
			.pattern("XYX")
			.pattern("X X")
			.pattern("X X")
			.define('X', Items.BAMBOO)
			.define('Y', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_" + Items.BAMBOO, RecipeProvider.has(Items.BAMBOO))
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.SCAFFOLDING) + "_from_arachne_string");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICKY_PISTON)
			.pattern("X")
			.pattern("Y")
			.define('X', Ingredient.of(IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.define('Y', Items.PISTON)
			.unlockedBy("has_" + IcariaItems.ENDER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.ENDER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.FIRE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.FIRE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.NATURE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.NATURE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.VOID_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.VOID_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.WATER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + Items.PISTON, RecipeProvider.has(Items.PISTON))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.STICKY_PISTON) + "_from_jellyfish_jelly");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STONECUTTER)
			.pattern(" X ")
			.pattern("YYY")
			.define('X', Items.IRON_INGOT)
			.define('Y', IcariaItems.SMOOTH_RELICSTONE.get())
			.unlockedBy("has_" + Items.IRON_INGOT, RecipeProvider.has(Items.IRON_INGOT))
			.unlockedBy("has_" + IcariaItems.SMOOTH_RELICSTONE.get(), RecipeProvider.has(IcariaItems.SMOOTH_RELICSTONE.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.STONECUTTER) + "_from_relicstone");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.WHITE_WOOL)
			.pattern("XX")
			.pattern("XX")
			.define('X', IcariaItems.ARACHNE_STRING.get())
			.unlockedBy("has_" + IcariaItems.ARACHNE_STRING.get(), RecipeProvider.has(IcariaItems.ARACHNE_STRING.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.WHITE_WOOL) + "_from_arachne_string");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MOSSY_COBBLESTONE)
			.requires(Items.COBBLESTONE)
			.requires(Ingredient.of(Items.VINE, IcariaItems.BLOOMY_VINE.get(), IcariaItems.BRANCHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.DRY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.SWIRLY_VINE.get(), IcariaItems.THORNY_VINE.get()))
			.unlockedBy("has_" + Items.COBBLESTONE, RecipeProvider.has(Items.COBBLESTONE))
			.unlockedBy("has_" + Items.VINE, RecipeProvider.has(Items.VINE))
			.unlockedBy("has_" + IcariaItems.BLOOMY_VINE.get(), RecipeProvider.has((IcariaItems.BLOOMY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRANCHY_VINE.get(), RecipeProvider.has((IcariaItems.BRANCHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRUSHY_VINE.get(), RecipeProvider.has((IcariaItems.BRUSHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.DRY_VINE.get(), RecipeProvider.has((IcariaItems.DRY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.REEDY_VINE.get(), RecipeProvider.has((IcariaItems.REEDY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.SWIRLY_VINE.get(), RecipeProvider.has((IcariaItems.SWIRLY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.THORNY_VINE.get(), RecipeProvider.has((IcariaItems.THORNY_VINE.get())))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.MOSSY_COBBLESTONE));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.FLINT_AND_STEEL)
			.requires(IcariaItems.CHERT.get())
			.requires(Items.IRON_INGOT)
			.unlockedBy("has_" + IcariaItems.CHERT.get(), RecipeProvider.has(IcariaItems.CHERT.get()))
			.unlockedBy("has_" + Items.IRON_INGOT, RecipeProvider.has(Items.IRON_INGOT))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.FLINT_AND_STEEL) + "_from_chert");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGMA_CREAM)
			.requires(Ingredient.of(IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.requires(Items.BLAZE_POWDER)
			.unlockedBy("has_" + IcariaItems.ENDER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.ENDER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.FIRE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.FIRE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.NATURE_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.NATURE_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.VOID_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.VOID_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + IcariaItems.WATER_JELLYFISH_JELLY.get(), RecipeProvider.has(IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.unlockedBy("has_" + Items.BLAZE_POWDER, RecipeProvider.has(Items.BLAZE_POWDER))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.MAGMA_CREAM) + "_from_jellyfish_jelly");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MOSSY_STONE_BRICKS)
			.requires(Items.STONE_BRICKS)
			.requires(Ingredient.of(Items.VINE, IcariaItems.BLOOMY_VINE.get(), IcariaItems.BRANCHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.DRY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.SWIRLY_VINE.get(), IcariaItems.THORNY_VINE.get()))
			.unlockedBy("has_" + Items.STONE_BRICKS, RecipeProvider.has(Items.STONE_BRICKS))
			.unlockedBy("has_" + Items.VINE, RecipeProvider.has(Items.VINE))
			.unlockedBy("has_" + IcariaItems.BLOOMY_VINE.get(), RecipeProvider.has((IcariaItems.BLOOMY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRANCHY_VINE.get(), RecipeProvider.has((IcariaItems.BRANCHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.BRUSHY_VINE.get(), RecipeProvider.has((IcariaItems.BRUSHY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.DRY_VINE.get(), RecipeProvider.has((IcariaItems.DRY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.REEDY_VINE.get(), RecipeProvider.has((IcariaItems.REEDY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.SWIRLY_VINE.get(), RecipeProvider.has((IcariaItems.SWIRLY_VINE.get())))
			.unlockedBy("has_" + IcariaItems.THORNY_VINE.get(), RecipeProvider.has((IcariaItems.THORNY_VINE.get())))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.MOSSY_STONE_BRICKS));

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.SUGAR)
			.requires(IcariaItems.VINE_REED.get())
			.unlockedBy("has_" + IcariaItems.VINE_REED.get(), RecipeProvider.has(IcariaItems.VINE_REED.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(Items.SUGAR) + "_from_vine_reed");
	}

	public void firingRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult, float pExperience, int pTime) {
		FiringRecipeBuilder.firing(pResult, Ingredient.of(pResource), pExperience, pTime)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_firing");
	}

	public void grindingRecipe(Consumer<FinishedRecipe> pConsumer, Item pGear, Item pResource, Item pResult, float pExperience, int pTime, int pCount) {
		GrindingRecipeBuilder.grinding(pGear, Ingredient.of(pResource), pResult, pExperience, pTime, pCount)
			.unlockedBy("has_" + pGear, RecipeProvider.has(pGear))
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_grinding");
	}

	public void smeltingRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult, float pExperience, int pTime) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(pResource), RecipeCategory.MISC, pResult, pExperience, pTime)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_smelting");
	}

	public void smallCompressDecompressRecipes(Consumer<FinishedRecipe> pConsumer, Item pUncompressed, Item pCompressed) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pCompressed, 1)
			.pattern("XX")
			.pattern("XX")
			.define('X', pUncompressed)
			.unlockedBy("has_" + pUncompressed, RecipeProvider.has(pUncompressed))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pUncompressed) + "_small_compress");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pUncompressed, 4)
			.requires(pCompressed)
			.unlockedBy("has_" + pCompressed, RecipeProvider.has(pCompressed))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pCompressed) + "_small_decompress");
	}

	public void smallCompressRecipe(Consumer<FinishedRecipe> pConsumer, Item pUncompressed, Item pCompressed) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pCompressed, 1)
			.pattern("XX")
			.pattern("XX")
			.define('X', pUncompressed)
			.unlockedBy("has_" + pUncompressed, RecipeProvider.has(pUncompressed))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pUncompressed) + "_small_compress");
	}

	public void glassRecipes(Consumer<FinishedRecipe> pConsumer, Item pSand, Item pGlass, Item pPane, Item pPaneHorizontal) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pPane, 16)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', pGlass)
			.unlockedBy("has_" + pGlass, RecipeProvider.has(pGlass))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pPane));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pPaneHorizontal, 2)
			.pattern("XX")
			.define('X', pPane)
			.unlockedBy("has_" + pPane, RecipeProvider.has(pPane))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pPaneHorizontal));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(pSand), RecipeCategory.MISC, pGlass, 0.1F, 200)
			.unlockedBy("has_" + pSand, RecipeProvider.has(pSand))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pGlass) + "_from_smelting");
	}

	public void stoneRecipes(Consumer<FinishedRecipe> pConsumer, Item pCobbled, Item pStone, Item pBricks, Item pChiseled, IcariaStoneDecoItems pDeco) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pBricks, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', pStone)
			.unlockedBy("has_" + pStone, RecipeProvider.has(pStone))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pBricks));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pChiseled, 1)
			.pattern("X")
			.pattern("X")
			.define('X', pDeco.slab.get())
			.unlockedBy("has_" + pDeco.slab.get(), RecipeProvider.has(pDeco.slab.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pChiseled));

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(pCobbled), RecipeCategory.MISC, pStone, 0.1F, 200)
			.unlockedBy("has_" + pCobbled, RecipeProvider.has(pCobbled))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pStone) + "_from_smelting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(pStone), RecipeCategory.MISC, pBricks)
			.unlockedBy("has_" + pStone, RecipeProvider.has(pStone))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pBricks) + "_from_stonecutting");

		SingleItemRecipeBuilder.stonecutting(Ingredient.of(pStone, pBricks), RecipeCategory.MISC, pChiseled)
			.unlockedBy("has_" + pStone, RecipeProvider.has(pStone))
			.unlockedBy("has_" + pBricks, RecipeProvider.has(pBricks))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pChiseled) + "_from_stonecutting");
	}

	public void largeCompressDecompressRecipes(Consumer<FinishedRecipe> pConsumer, Item pUncompressed, Item pCompressed) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pCompressed, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', pUncompressed)
			.unlockedBy("has_" + pUncompressed, RecipeProvider.has(pUncompressed))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pUncompressed) + "_large_compress");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pUncompressed, 9)
			.requires(pCompressed)
			.unlockedBy("has_" + pCompressed, RecipeProvider.has(pCompressed))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pCompressed) + "_large_decompress");
	}

	public void blockIngotNuggetRecipes(Consumer<FinishedRecipe> pConsumer, Item pBlock, Item pIngot, Item pNugget) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pBlock, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', pIngot)
			.unlockedBy("has_" + pIngot, RecipeProvider.has(pIngot))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pIngot) + "_to_block");

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pIngot, 1)
			.pattern("XXX")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', pNugget)
			.unlockedBy("has_" + pNugget, RecipeProvider.has(pNugget))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pNugget) + "_to_ingot");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pIngot, 9)
			.requires(pBlock)
			.unlockedBy("has_" + pBlock, RecipeProvider.has(pBlock))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pBlock) + "_to_ingot");

		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pNugget, 9)
			.requires(pIngot)
			.unlockedBy("has_" + pIngot, RecipeProvider.has(pIngot))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pIngot) + "_to_nugget");
	}

	public void torchRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 2)
			.pattern("X")
			.pattern("Y")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void cakeRecipe(Consumer<FinishedRecipe> pConsumer, Item pFruit, Item pJelly, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult)
			.pattern("ABA")
			.pattern("CDC")
			.pattern("EEE")
			.define('A', pJelly)
			.define('B', pFruit)
			.define('C', Items.SUGAR)
			.define('D', Items.MILK_BUCKET)
			.define('E', IcariaItems.SPELT_FLOUR.get())
			.unlockedBy("has_" + pJelly, RecipeProvider.has(pJelly))
			.unlockedBy("has_" + pFruit, RecipeProvider.has(pFruit))
			.unlockedBy("has_" + Items.SUGAR, RecipeProvider.has(Items.SUGAR))
			.unlockedBy("has_" + Items.MILK_BUCKET, RecipeProvider.has(Items.MILK_BUCKET))
			.unlockedBy("has_" + IcariaItems.SPELT_FLOUR.get(), RecipeProvider.has(IcariaItems.SPELT_FLOUR.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void woodRecipes(Consumer<FinishedRecipe> pConsumer, Item pWood, Item pWoodStripped, Item pLog, Item pLogStripped) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pWood, 3)
			.pattern("XX")
			.pattern("XX")
			.define('X', pLog)
			.unlockedBy("has_" + pLog, RecipeProvider.has(pLog))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pWood));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pWoodStripped, 3)
			.pattern("XX")
			.pattern("XX")
			.define('X', pLogStripped)
			.unlockedBy("has_" + pLogStripped, RecipeProvider.has(pLogStripped))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pWoodStripped));
	}

	public void planksRecipe(Consumer<FinishedRecipe> pConsumer, Item pWood, Item pWoodStripped, Item pLog, Item pLogStripped, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 4)
			.pattern("XX")
			.pattern("XX")
			.define('X', Ingredient.of(pWood, pWoodStripped, pLog, pLogStripped))
			.unlockedBy("has_" + pWood, RecipeProvider.has(pWood))
			.unlockedBy("has_" + pWoodStripped, RecipeProvider.has(pWoodStripped))
			.unlockedBy("has_" + pLog, RecipeProvider.has(pLog))
			.unlockedBy("has_" + pLogStripped, RecipeProvider.has(pLogStripped))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void doorRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 3)
			.pattern("XX")
			.pattern("XX")
			.pattern("XX")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void trapdoorRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 2)
			.pattern("XXX")
			.pattern("XXX")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void ladderRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 6)
			.pattern("X X")
			.pattern("XXX")
			.pattern("X X")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void signRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 3)
			.pattern("XXX")
			.pattern("XXX")
			.pattern(" Y ")
			.define('X', pResource)
			.define('Y', Items.STICK)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.STICK, RecipeProvider.has(Items.STICK))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void hangingSignRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 6)
			.pattern("X X")
			.pattern("YYY")
			.pattern("YYY")
			.define('X', IcariaItems.VANADIUMSTEEL_CHAIN.get())
			.define('Y', pResource)
			.unlockedBy("has_" + IcariaItems.VANADIUMSTEEL_CHAIN.get(), RecipeProvider.has(IcariaItems.VANADIUMSTEEL_CHAIN.get()))
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void dyesFromFlowerRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
			.requires(pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_" + ForgeRegistries.ITEMS.getKey(pResource).getPath());
	}

	public void gemSmeltingRecipes(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		SimpleCookingRecipeBuilder.smelting((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, 0.7F, 200)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_smelting");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, 0.7F, 100)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_blasting");
	}

	public void ingotSmeltingRecipes(Consumer<FinishedRecipe> pConsumer, Item pOre, Item pRaw, Item pResult) {
		SimpleCookingRecipeBuilder.smelting((Ingredient.of(pOre, pRaw)), RecipeCategory.MISC, pResult, 0.7F, 200)
			.unlockedBy("has_" + pOre, RecipeProvider.has(pOre))
			.unlockedBy("has_" + pRaw, RecipeProvider.has(pRaw))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_smelting");

		SimpleCookingRecipeBuilder.blasting((Ingredient.of(pOre, pRaw)), RecipeCategory.MISC, pResult, 0.7F, 100)
			.unlockedBy("has_" + pOre, RecipeProvider.has(pOre))
			.unlockedBy("has_" + pRaw, RecipeProvider.has(pRaw))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_blasting");
	}

	public void toolRecipes(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pSword, Item pDagger, Item pShovel, Item pPickaxe, Item pAxe, Item pScythe, Item pBident) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pSword, 1)
			.pattern("X")
			.pattern("X")
			.pattern("Y")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pSword));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pDagger, 1)
			.pattern("X")
			.pattern("Y")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pDagger));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pShovel, 1)
			.pattern("X")
			.pattern("Y")
			.pattern("Y")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pShovel));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pPickaxe, 1)
			.pattern("XXX")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pPickaxe));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pAxe, 1)
			.pattern("XX ")
			.pattern("XY ")
			.pattern(" Y ")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pAxe));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pScythe, 1)
			.pattern(" XX")
			.pattern("X Y")
			.pattern("  Y")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pScythe));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pBident, 1)
			.pattern("X X")
			.pattern(" Y ")
			.pattern(" Y ")
			.define('X', pResource)
			.define('Y', Items.BONE)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + Items.BONE, RecipeProvider.has(Items.BONE))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pBident));
	}

	public void armorRecipes(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pHelmet, Item pChestplate, Item pLeggings, Item pBoots) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pHelmet, 1)
			.pattern("XXX")
			.pattern("X X")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pHelmet));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pChestplate, 1)
			.pattern("X X")
			.pattern("XXX")
			.pattern("XXX")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pChestplate));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pLeggings, 1)
			.pattern("XXX")
			.pattern("X X")
			.pattern("X X")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pLeggings));

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pBoots, 1)
			.pattern("X X")
			.pattern("X X")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pBoots));
	}

	public void vaseRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult, 1)
			.requires(pResource)
			.requires(IcariaItems.UNFIRED_STORAGE_VASE.get())
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.unlockedBy("has_" + IcariaItems.UNFIRED_STORAGE_VASE.get(), RecipeProvider.has(IcariaItems.UNFIRED_STORAGE_VASE.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void bowlFlaskTypeRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult, int pCount) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, pCount)
			.pattern("X X")
			.pattern(" X ")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void gearRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 1)
			.pattern(" X ")
			.pattern("X X")
			.pattern(" X ")
			.define('X', pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void foodCookingRecipes(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		SimpleCookingRecipeBuilder.campfireCooking((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, 0.35F, 600)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_campfire_cooking");

		SimpleCookingRecipeBuilder.smelting((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, 0.35F, 200)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_smelting");

		SimpleCookingRecipeBuilder.smoking((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, 0.35F, 100)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult) + "_from_smoking");
	}

	public void stewRecipe(Consumer<FinishedRecipe> pConsumer, Item pMeat, Item pVegetable, Item pResult) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pResult, 1)
			.pattern("AB")
			.pattern("CD")
			.define('A', pMeat)
			.define('B', pVegetable)
			.define('C', IcariaItems.HALITE_DUST.get())
			.define('D', IcariaItems.LOAM_BOWL.get())
			.unlockedBy("has_" + pMeat, RecipeProvider.has(pMeat))
			.unlockedBy("has_" + pVegetable, RecipeProvider.has(pVegetable))
			.unlockedBy("has_" + IcariaItems.HALITE_DUST.get(), RecipeProvider.has(IcariaItems.HALITE_DUST.get()))
			.unlockedBy("has_" + IcariaItems.LOAM_BOWL.get(), RecipeProvider.has(IcariaItems.LOAM_BOWL.get()))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}

	public void seedRecipe(Consumer<FinishedRecipe> pConsumer, Item pResource, Item pResult) {
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, pResult)
			.requires(pResource)
			.unlockedBy("has_" + pResource, RecipeProvider.has(pResource))
			.save(pConsumer, ForgeRegistries.ITEMS.getKey(pResult));
	}
}
