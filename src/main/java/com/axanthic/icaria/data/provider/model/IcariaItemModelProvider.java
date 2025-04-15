package com.axanthic.icaria.data.provider.model;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;

import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.SeparateTransformsModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemModelProvider extends ItemModelProvider {
	public IcariaItemModelProvider(PackOutput pPackOutput, String pId, ExistingFileHelper pExistingFileHelper) {
		super(pPackOutput, pId, pExistingFileHelper);
	}

	@Override
	public void registerModels() {
		this.bident();
		this.chest();
		this.generated();
		this.handheld();
		this.horn();
		this.parent();
		this.scroll();
		this.skull();
		this.spawnEgg();
	}

	public void bident() {
		this.bident(IcariaItems.CHERT_BIDENT.get());
		this.bident(IcariaItems.CHALKOS_BIDENT.get());
		this.bident(IcariaItems.KASSITEROS_BIDENT.get());
		this.bident(IcariaItems.ORICHALCUM_BIDENT.get());
		this.bident(IcariaItems.VANADIUMSTEEL_BIDENT.get());
		this.bident(IcariaItems.SIDEROS_BIDENT.get());
		this.bident(IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());
	}

	public void chest() {
		this.chest(IcariaItems.CHEST.get());
		this.chest(IcariaItems.TRAPPED_CHEST.get());
	}

	public void generated() {
		this.generated(IcariaItems.VANADIUMSTEEL_CHAIN.get());
		this.generated(IcariaItems.LIGNITE_TORCH.get());
		this.generated(IcariaItems.ANTHRACITE_TORCH.get());
		this.generated(IcariaItems.LAUREL_CHERRY_CAKE.get());
		this.generated(IcariaItems.STRAWBERRY_CAKE.get());
		this.generated(IcariaItems.PHYSALIS_CAKE.get());
		this.generated(IcariaItems.VINE_BERRY_CAKE.get());
		this.generated(IcariaItems.VINE_SPROUT_CAKE.get());
		this.generated(IcariaItems.CYPRESS_SAPLING.get());
		this.generated(IcariaItems.CYPRESS_DOOR.get());
		this.generated(IcariaItems.CYPRESS_LADDER.get());
		this.generated(IcariaItems.CYPRESS_SIGN.get());
		this.generated(IcariaItems.CYPRESS_HANGING_SIGN.get());
		this.generated(IcariaItems.DROUGHTROOT_SAPLING.get());
		this.generated(IcariaItems.DROUGHTROOT_DOOR.get());
		this.generated(IcariaItems.DROUGHTROOT_LADDER.get());
		this.generated(IcariaItems.DROUGHTROOT_SIGN.get());
		this.generated(IcariaItems.DROUGHTROOT_HANGING_SIGN.get());
		this.generated(IcariaItems.FIR_SAPLING.get());
		this.generated(IcariaItems.FIR_DOOR.get());
		this.generated(IcariaItems.FIR_LADDER.get());
		this.generated(IcariaItems.FIR_SIGN.get());
		this.generated(IcariaItems.FIR_HANGING_SIGN.get());
		this.generated(IcariaItems.LAUREL_SAPLING.get());
		this.generated(IcariaItems.LAUREL_DOOR.get());
		this.generated(IcariaItems.LAUREL_LADDER.get());
		this.generated(IcariaItems.LAUREL_SIGN.get());
		this.generated(IcariaItems.LAUREL_HANGING_SIGN.get());
		this.generated(IcariaItems.OLIVE_SAPLING.get());
		this.generated(IcariaItems.OLIVE_DOOR.get());
		this.generated(IcariaItems.OLIVE_LADDER.get());
		this.generated(IcariaItems.OLIVE_SIGN.get());
		this.generated(IcariaItems.OLIVE_HANGING_SIGN.get());
		this.generated(IcariaItems.PLANE_SAPLING.get());
		this.generated(IcariaItems.PLANE_DOOR.get());
		this.generated(IcariaItems.PLANE_LADDER.get());
		this.generated(IcariaItems.PLANE_SIGN.get());
		this.generated(IcariaItems.PLANE_HANGING_SIGN.get());
		this.generated(IcariaItems.POPULUS_SAPLING.get());
		this.generated(IcariaItems.POPULUS_DOOR.get());
		this.generated(IcariaItems.POPULUS_LADDER.get());
		this.generated(IcariaItems.POPULUS_SIGN.get());
		this.generated(IcariaItems.POPULUS_HANGING_SIGN.get());
		this.generated(IcariaItems.BLOOMY_VINE.get());
		this.generated(IcariaItems.BRANCHY_VINE.get());
		this.generated(IcariaItems.BRUSHY_VINE.get());
		this.generated(IcariaItems.DRY_VINE.get());
		this.generated(IcariaItems.REEDY_VINE.get());
		this.generated(IcariaItems.SWIRLY_VINE.get());
		this.generated(IcariaItems.THORNY_VINE.get());
		this.generated(IcariaItems.FERN.get());
		this.generated(IcariaItems.SMALL_GRASS.get());
		this.generated(IcariaItems.MEDIUM_GRASS.get());
		this.generated(IcariaItems.LARGE_GRASS.get());
		this.generated(IcariaItems.SMALL_MIXED_GRAIN.get());
		this.generated(IcariaItems.MEDIUM_MIXED_GRAIN.get());
		this.generated(IcariaItems.MEDIUM_BROWN_GRAIN.get());
		this.generated(IcariaItems.MEDIUM_WHITE_GRAIN.get());
		this.generated(IcariaItems.MEDIUM_YELLOW_GRAIN.get());
		this.generated(IcariaItems.LARGE_BROWN_GRAIN.get());
		this.generated(IcariaItems.BLINDWEED.get());
		this.generated(IcariaItems.CHAMEOMILE.get());
		this.generated(IcariaItems.CHARMONDER.get());
		this.generated(IcariaItems.CLOVER.get());
		this.generated(IcariaItems.FIREHILT.get());
		this.generated(IcariaItems.BLUE_HYDRACINTH.get());
		this.generated(IcariaItems.PURPLE_HYDRACINTH.get());
		this.generated(IcariaItems.LIONFANGS.get());
		this.generated(IcariaItems.SPEARDROPS.get());
		this.generated(IcariaItems.PURPLE_STAGHORN.get());
		this.generated(IcariaItems.YELLOW_STAGHORN.get());
		this.generated(IcariaItems.BLUE_STORMCOTTON.get());
		this.generated(IcariaItems.PINK_STORMCOTTON.get());
		this.generated(IcariaItems.PURPLE_STORMCOTTON.get());
		this.generated(IcariaItems.SUNKETTLE.get());
		this.generated(IcariaItems.SUNSPONGE.get());
		this.generated(IcariaItems.VOIDLILY.get());
		this.generated(IcariaItems.BOLBOS.get());
		this.generated(IcariaItems.DATHULLA.get());
		this.generated(IcariaItems.MONDANOS.get());
		this.generated(IcariaItems.MOTH_AGARIC.get());
		this.generated(IcariaItems.NAMDRAKE.get());
		this.generated(IcariaItems.PSILOCYBOS.get());
		this.generated(IcariaItems.ROWAN.get());
		this.generated(IcariaItems.WILTED_ELM.get());
		this.generated(IcariaItems.STRAWBERRY_BUSH.get());
		this.generated(IcariaItems.PAINTING.get());
		this.generated(IcariaItems.BONE_REMAINS.get());
		this.generated(IcariaItems.LOAM_LUMP.get());
		this.generated(IcariaItems.LOAM_BRICK.get());
		this.generated(IcariaItems.CHERT.get());
		this.generated(IcariaItems.ENDER_JELLYFISH_JELLY.get());
		this.generated(IcariaItems.FIRE_JELLYFISH_JELLY.get());
		this.generated(IcariaItems.NATURE_JELLYFISH_JELLY.get());
		this.generated(IcariaItems.VOID_JELLYFISH_JELLY.get());
		this.generated(IcariaItems.WATER_JELLYFISH_JELLY.get());
		this.generated(IcariaItems.ARACHNE_STRING.get());
		this.generated(IcariaItems.SPELT.get());
		this.generated(IcariaItems.VINE_REED.get());
		this.generated(IcariaItems.ROTTEN_BONES.get());
		this.generated(IcariaItems.GREENPOWDER.get());
		this.generated(IcariaItems.CALCITE_SHARD.get());
		this.generated(IcariaItems.HALITE_SHARD.get());
		this.generated(IcariaItems.JASPER_SHARD.get());
		this.generated(IcariaItems.ZIRCON_SHARD.get());
		this.generated(IcariaItems.CALCITE_DUST.get());
		this.generated(IcariaItems.HALITE_DUST.get());
		this.generated(IcariaItems.LIGNITE.get());
		this.generated(IcariaItems.RAW_CHALKOS.get());
		this.generated(IcariaItems.RAW_KASSITEROS.get());
		this.generated(IcariaItems.DOLOMITE.get());
		this.generated(IcariaItems.RAW_VANADIUM.get());
		this.generated(IcariaItems.SLIVER.get());
		this.generated(IcariaItems.RAW_SIDEROS.get());
		this.generated(IcariaItems.ANTHRACITE.get());
		this.generated(IcariaItems.RAW_MOLYBDENUM.get());
		this.generated(IcariaItems.CHALKOS_NUGGET.get());
		this.generated(IcariaItems.KASSITEROS_NUGGET.get());
		this.generated(IcariaItems.ORICHALCUM_NUGGET.get());
		this.generated(IcariaItems.VANADIUM_NUGGET.get());
		this.generated(IcariaItems.VANADIUMSTEEL_NUGGET.get());
		this.generated(IcariaItems.SIDEROS_NUGGET.get());
		this.generated(IcariaItems.MOLYBDENUM_NUGGET.get());
		this.generated(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		this.generated(IcariaItems.BLURIDIUM_NUGGET.get());
		this.generated(IcariaItems.CHALKOS_INGOT.get());
		this.generated(IcariaItems.KASSITEROS_INGOT.get());
		this.generated(IcariaItems.ORICHALCUM_INGOT.get());
		this.generated(IcariaItems.VANADIUM_INGOT.get());
		this.generated(IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.generated(IcariaItems.SIDEROS_INGOT.get());
		this.generated(IcariaItems.MOLYBDENUM_INGOT.get());
		this.generated(IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.generated(IcariaItems.BLURIDIUM_INGOT.get());
		this.generated(IcariaItems.AETERNAE_HIDE_HELMET.get());
		this.generated(IcariaItems.AETERNAE_HIDE_CHESTPLATE.get());
		this.generated(IcariaItems.AETERNAE_HIDE_LEGGINGS.get());
		this.generated(IcariaItems.AETERNAE_HIDE_BOOTS.get());
		this.generated(IcariaItems.CHALKOS_HELMET.get());
		this.generated(IcariaItems.CHALKOS_CHESTPLATE.get());
		this.generated(IcariaItems.CHALKOS_LEGGINGS.get());
		this.generated(IcariaItems.CHALKOS_BOOTS.get());
		this.generated(IcariaItems.KASSITEROS_HELMET.get());
		this.generated(IcariaItems.KASSITEROS_CHESTPLATE.get());
		this.generated(IcariaItems.KASSITEROS_LEGGINGS.get());
		this.generated(IcariaItems.KASSITEROS_BOOTS.get());
		this.generated(IcariaItems.ORICHALCUM_HELMET.get());
		this.generated(IcariaItems.ORICHALCUM_CHESTPLATE.get());
		this.generated(IcariaItems.ORICHALCUM_LEGGINGS.get());
		this.generated(IcariaItems.ORICHALCUM_BOOTS.get());
		this.generated(IcariaItems.VANADIUMSTEEL_HELMET.get());
		this.generated(IcariaItems.VANADIUMSTEEL_CHESTPLATE.get());
		this.generated(IcariaItems.VANADIUMSTEEL_LEGGINGS.get());
		this.generated(IcariaItems.VANADIUMSTEEL_BOOTS.get());
		this.generated(IcariaItems.LAUREL_WREATH.get());
		this.generated(IcariaItems.GREEK_FIRE_GRENADE.get());
		this.generated(IcariaItems.TOTEM_OF_STUFFING.get());
		this.generated(IcariaItems.TOTEM_OF_UNBLINDING.get());
		this.generated(IcariaItems.TOTEM_OF_UNDROWNING.get());
		this.generated(IcariaItems.TOTEM_OF_UNDYING.get());
		this.generated(IcariaItems.TOTEM_OF_UNSHATTERING.get());
		this.generated(IcariaItems.TOTEM_OF_UNSINKING.get());
		this.generated(IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.RED_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.LIME_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());
		this.generated(IcariaItems.ANTI_GRAVITY_SPELL.get());
		this.generated(IcariaItems.FORTIFYING_SPELL.get());
		this.generated(IcariaItems.HEALING_SPELL.get());
		this.generated(IcariaItems.BUBBLE_SPELL.get());
		this.generated(IcariaItems.FREEZING_SPELL.get());
		this.generated(IcariaItems.MAGIC_MISSILE_SPELL.get());
		this.generated(IcariaItems.EMPTY_FLASK.get());
		this.generated(IcariaItems.ANTI_GRAVITY_FLASK.get());
		this.generated(IcariaItems.FORTIFYING_FLASK.get());
		this.generated(IcariaItems.HEALING_FLASK.get());
		this.generated(IcariaItems.EMPTY_VIAL.get());
		this.generated(IcariaItems.ARACHNE_VENOM_VIAL.get());
		this.generated(IcariaItems.HYLIASTRUM_VIAL.get());
		this.generated(IcariaItems.CHEST_LABEL.get());
		this.generated(IcariaItems.YELLOWSTONE_GEAR.get());
		this.generated(IcariaItems.UNFIRED_LOAM_GEAR.get());
		this.generated(IcariaItems.LOAM_GEAR.get());
		this.generated(IcariaItems.VOIDSHALE_GEAR.get());
		this.generated(IcariaItems.VANADIUM_GEAR.get());
		this.generated(IcariaItems.BLUE_GEARFRAGMENT.get());
		this.generated(IcariaItems.GREEN_GEARFRAGMENT.get());
		this.generated(IcariaItems.YELLOW_GEARFRAGMENT.get());
		this.generated(IcariaItems.DAEDALIAN_GEAR.get());
		this.generated(IcariaItems.AETERNAE_HIDE.get());
		this.generated(IcariaItems.SPELT_FLOUR.get());
		this.generated(IcariaItems.SPELT_BREAD.get());
		this.generated(IcariaItems.VINE_SPROUT.get());
		this.generated(IcariaItems.VINEBERRIES.get());
		this.generated(IcariaItems.STRAWBERRIES.get());
		this.generated(IcariaItems.PHYSALIS.get());
		this.generated(IcariaItems.LAUREL_CHERRY.get());
		this.generated(IcariaItems.BLACK_OLIVES.get());
		this.generated(IcariaItems.GREEN_OLIVES.get());
		this.generated(IcariaItems.GARLIC.get());
		this.generated(IcariaItems.ONION.get());
		this.generated(IcariaItems.RAW_AETERNAE_MEAT.get());
		this.generated(IcariaItems.COOKED_AETERNAE_MEAT.get());
		this.generated(IcariaItems.RAW_CAPELLA_MEAT.get());
		this.generated(IcariaItems.COOKED_CAPELLA_MEAT.get());
		this.generated(IcariaItems.RAW_CATOBLEPAS_MEAT.get());
		this.generated(IcariaItems.COOKED_CATOBLEPAS_MEAT.get());
		this.generated(IcariaItems.RAW_CERVER_MEAT.get());
		this.generated(IcariaItems.COOKED_CERVER_MEAT.get());
		this.generated(IcariaItems.RAW_CROCOTTA_MEAT.get());
		this.generated(IcariaItems.COOKED_CROCOTTA_MEAT.get());
		this.generated(IcariaItems.RAW_SOW_MEAT.get());
		this.generated(IcariaItems.COOKED_SOW_MEAT.get());
		this.generated(IcariaItems.MYRMEKE_SCALES.get());
		this.generated(IcariaItems.SLUG_SCALES.get());
		this.generated(IcariaItems.SNULL_CREAM.get());
		this.generated(IcariaItems.VINEGAR.get());
		this.generated(IcariaItems.UNFIRED_LOAM_BOWL.get());
		this.generated(IcariaItems.LOAM_BOWL.get());
		this.generated(IcariaItems.FRUIT_SALAD.get());
		this.generated(IcariaItems.ONION_SOUP.get());
		this.generated(IcariaItems.AETERNAE_STEW.get());
		this.generated(IcariaItems.CATOBLEPAS_STEW.get());
		this.generated(IcariaItems.CERVER_STEW.get());
		this.generated(IcariaItems.SOW_STEW.get());
		this.generated(IcariaItems.SPELT_SEEDS.get());
		this.generated(IcariaItems.STRAWBERRY_SEEDS.get());
		this.generated(IcariaItems.PHYSALIS_SEEDS.get());
		this.generated(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get());
		this.generated(IcariaItems.LEFT_GRINDER_CHAIN.get());
		this.generated(IcariaItems.STATIC_LEFT_GRINDER_CHAIN.get());
		this.generated(IcariaItems.RIGHT_GRINDER_CHAIN.get());
		this.generated(IcariaItems.STATIC_RIGHT_GRINDER_CHAIN.get());
	}

	public void handheld() {
		this.handheld(IcariaItems.CHERT_SWORD.get());
		this.handheld(IcariaItems.CHERT_DAGGER.get());
		this.handheld(IcariaItems.CHERT_SHOVEL.get());
		this.handheld(IcariaItems.CHERT_PICKAXE.get());
		this.handheld(IcariaItems.CHERT_AXE.get());
		this.handheld(IcariaItems.CHERT_SCYTHE.get());
		this.handheld(IcariaItems.CHALKOS_SWORD.get());
		this.handheld(IcariaItems.CHALKOS_DAGGER.get());
		this.handheld(IcariaItems.CHALKOS_SHOVEL.get());
		this.handheld(IcariaItems.CHALKOS_PICKAXE.get());
		this.handheld(IcariaItems.CHALKOS_AXE.get());
		this.handheld(IcariaItems.CHALKOS_SCYTHE.get());
		this.handheld(IcariaItems.KASSITEROS_SWORD.get());
		this.handheld(IcariaItems.KASSITEROS_DAGGER.get());
		this.handheld(IcariaItems.KASSITEROS_SHOVEL.get());
		this.handheld(IcariaItems.KASSITEROS_PICKAXE.get());
		this.handheld(IcariaItems.KASSITEROS_AXE.get());
		this.handheld(IcariaItems.KASSITEROS_SCYTHE.get());
		this.handheld(IcariaItems.ORICHALCUM_SWORD.get());
		this.handheld(IcariaItems.ORICHALCUM_DAGGER.get());
		this.handheld(IcariaItems.ORICHALCUM_SHOVEL.get());
		this.handheld(IcariaItems.ORICHALCUM_PICKAXE.get());
		this.handheld(IcariaItems.ORICHALCUM_AXE.get());
		this.handheld(IcariaItems.ORICHALCUM_SCYTHE.get());
		this.handheld(IcariaItems.VANADIUMSTEEL_SWORD.get());
		this.handheld(IcariaItems.VANADIUMSTEEL_DAGGER.get());
		this.handheld(IcariaItems.VANADIUMSTEEL_SHOVEL.get());
		this.handheld(IcariaItems.VANADIUMSTEEL_PICKAXE.get());
		this.handheld(IcariaItems.VANADIUMSTEEL_AXE.get());
		this.handheld(IcariaItems.VANADIUMSTEEL_SCYTHE.get());
		this.handheld(IcariaItems.SIDEROS_SWORD.get());
		this.handheld(IcariaItems.SIDEROS_DAGGER.get());
		this.handheld(IcariaItems.SIDEROS_SHOVEL.get());
		this.handheld(IcariaItems.SIDEROS_PICKAXE.get());
		this.handheld(IcariaItems.SIDEROS_AXE.get());
		this.handheld(IcariaItems.SIDEROS_SCYTHE.get());
		this.handheld(IcariaItems.MOLYBDENUMSTEEL_SWORD.get());
		this.handheld(IcariaItems.MOLYBDENUMSTEEL_DAGGER.get());
		this.handheld(IcariaItems.MOLYBDENUMSTEEL_SHOVEL.get());
		this.handheld(IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());
		this.handheld(IcariaItems.MOLYBDENUMSTEEL_AXE.get());
		this.handheld(IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get());
	}

	public void horn() {
		this.horn(IcariaItems.CAPELLA_HORN.get());
	}

	public void parent() {
		this.parent(IcariaItems.GRASSY_MARL.get());
		this.parent(IcariaItems.MARL.get());
		this.parent(IcariaItems.MARL_CHERT.get());
		this.parent(IcariaItems.SURFACE_CHERT.get());
		this.parent(IcariaItems.MARL_BONES.get());
		this.parent(IcariaItems.SURFACE_BONES.get());
		this.parent(IcariaItems.MARL_LIGNITE.get());
		this.parent(IcariaItems.SURFACE_LIGNITE.get(), "3");
		this.parent(IcariaItems.COARSE_MARL.get());
		this.parent(IcariaItems.DRY_LAKE_BED.get());
		this.parent(IcariaItems.FARMLAND.get(), "dry");
		this.parent(IcariaItems.FERTILIZED_FARMLAND.get());
		this.parent(IcariaItems.MARL_ADOBE.get());
		this.parent(IcariaItems.MARL_ADOBE_STAIRS.get());
		this.parent(IcariaItems.MARL_ADOBE_SLAB.get());
		this.parent(IcariaItems.MARL_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.LOAM.get());
		this.parent(IcariaItems.LOAM_BRICKS.get());
		this.parent(IcariaItems.LOAM_BRICK_STAIRS.get());
		this.parent(IcariaItems.LOAM_BRICK_SLAB.get());
		this.parent(IcariaItems.LOAM_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.DOLOMITE_ADOBE.get());
		this.parent(IcariaItems.DOLOMITE_ADOBE_STAIRS.get());
		this.parent(IcariaItems.DOLOMITE_ADOBE_SLAB.get());
		this.parent(IcariaItems.DOLOMITE_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.SMOOTH_DOLOMITE.get());
		this.parent(IcariaItems.SMOOTH_DOLOMITE_STAIRS.get());
		this.parent(IcariaItems.SMOOTH_DOLOMITE_SLAB.get());
		this.parent(IcariaItems.SMOOTH_DOLOMITE_WALL.get(), "inventory");
		this.parent(IcariaItems.DOLOMITE_BRICKS.get());
		this.parent(IcariaItems.CHISELED_DOLOMITE.get());
		this.parent(IcariaItems.DOLOMITE_PILLAR.get());
		this.parent(IcariaItems.DOLOMITE_PILLAR_HEAD.get());
		this.parent(IcariaItems.GRAINEL.get());
		this.parent(IcariaItems.GRAINEL_CHERT.get());
		this.parent(IcariaItems.GRAINGLASS.get());
		this.parent(IcariaItems.GRAINGLASS_PANE.get(), "inventory");
		this.parent(IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get());
		this.parent(IcariaItems.GRAINITE_ADOBE.get());
		this.parent(IcariaItems.GRAINITE_ADOBE_STAIRS.get());
		this.parent(IcariaItems.GRAINITE_ADOBE_SLAB.get());
		this.parent(IcariaItems.GRAINITE_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.GRAINITE.get());
		this.parent(IcariaItems.GRAINITE_STAIRS.get());
		this.parent(IcariaItems.GRAINITE_SLAB.get());
		this.parent(IcariaItems.GRAINITE_WALL.get(), "inventory");
		this.parent(IcariaItems.GRAINITE_BRICKS.get());
		this.parent(IcariaItems.GRAINITE_BRICK_STAIRS.get());
		this.parent(IcariaItems.GRAINITE_BRICK_SLAB.get());
		this.parent(IcariaItems.GRAINITE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.CHISELED_GRAINITE.get());
		this.parent(IcariaItems.GRAINITE_RUBBLE.get(), "3");
		this.parent(IcariaItems.YELLOWSTONE_ADOBE.get());
		this.parent(IcariaItems.YELLOWSTONE_ADOBE_STAIRS.get());
		this.parent(IcariaItems.YELLOWSTONE_ADOBE_SLAB.get());
		this.parent(IcariaItems.YELLOWSTONE_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.COBBLED_YELLOWSTONE.get());
		this.parent(IcariaItems.COBBLED_YELLOWSTONE_STAIRS.get());
		this.parent(IcariaItems.COBBLED_YELLOWSTONE_SLAB.get());
		this.parent(IcariaItems.COBBLED_YELLOWSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.YELLOWSTONE.get());
		this.parent(IcariaItems.YELLOWSTONE_STAIRS.get());
		this.parent(IcariaItems.YELLOWSTONE_SLAB.get());
		this.parent(IcariaItems.YELLOWSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.YELLOWSTONE_BRICKS.get());
		this.parent(IcariaItems.YELLOWSTONE_BRICK_STAIRS.get());
		this.parent(IcariaItems.YELLOWSTONE_BRICK_SLAB.get());
		this.parent(IcariaItems.YELLOWSTONE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.CHISELED_YELLOWSTONE.get());
		this.parent(IcariaItems.YELLOWSTONE_RUBBLE.get(), "3");
		this.parent(IcariaItems.SILKSAND.get());
		this.parent(IcariaItems.SILKGLASS.get());
		this.parent(IcariaItems.SILKGLASS_PANE.get(), "inventory");
		this.parent(IcariaItems.HORIZONTAL_SILKGLASS_PANE.get());
		this.parent(IcariaItems.SILKSTONE_ADOBE.get());
		this.parent(IcariaItems.SILKSTONE_ADOBE_STAIRS.get());
		this.parent(IcariaItems.SILKSTONE_ADOBE_SLAB.get());
		this.parent(IcariaItems.SILKSTONE_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.COBBLED_SILKSTONE.get());
		this.parent(IcariaItems.COBBLED_SILKSTONE_STAIRS.get());
		this.parent(IcariaItems.COBBLED_SILKSTONE_SLAB.get());
		this.parent(IcariaItems.COBBLED_SILKSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.SILKSTONE.get());
		this.parent(IcariaItems.SILKSTONE_STAIRS.get());
		this.parent(IcariaItems.SILKSTONE_SLAB.get());
		this.parent(IcariaItems.SILKSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.SILKSTONE_BRICKS.get());
		this.parent(IcariaItems.SILKSTONE_BRICK_STAIRS.get());
		this.parent(IcariaItems.SILKSTONE_BRICK_SLAB.get());
		this.parent(IcariaItems.SILKSTONE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.CHISELED_SILKSTONE.get());
		this.parent(IcariaItems.SILKSTONE_RUBBLE.get(), "3");
		this.parent(IcariaItems.SUNSTONE_ADOBE.get());
		this.parent(IcariaItems.SUNSTONE_ADOBE_STAIRS.get());
		this.parent(IcariaItems.SUNSTONE_ADOBE_SLAB.get());
		this.parent(IcariaItems.SUNSTONE_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.COBBLED_SUNSTONE.get());
		this.parent(IcariaItems.COBBLED_SUNSTONE_STAIRS.get());
		this.parent(IcariaItems.COBBLED_SUNSTONE_SLAB.get());
		this.parent(IcariaItems.COBBLED_SUNSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.SUNSTONE.get());
		this.parent(IcariaItems.SUNSTONE_STAIRS.get());
		this.parent(IcariaItems.SUNSTONE_SLAB.get());
		this.parent(IcariaItems.SUNSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.SUNSTONE_BRICKS.get());
		this.parent(IcariaItems.SUNSTONE_BRICK_STAIRS.get());
		this.parent(IcariaItems.SUNSTONE_BRICK_SLAB.get());
		this.parent(IcariaItems.SUNSTONE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.CHISELED_SUNSTONE.get());
		this.parent(IcariaItems.SUNSTONE_RUBBLE.get(), "3");
		this.parent(IcariaItems.VOIDSHALE_ADOBE.get());
		this.parent(IcariaItems.VOIDSHALE_ADOBE_STAIRS.get());
		this.parent(IcariaItems.VOIDSHALE_ADOBE_SLAB.get());
		this.parent(IcariaItems.VOIDSHALE_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.COBBLED_VOIDSHALE.get());
		this.parent(IcariaItems.COBBLED_VOIDSHALE_STAIRS.get());
		this.parent(IcariaItems.COBBLED_VOIDSHALE_SLAB.get());
		this.parent(IcariaItems.COBBLED_VOIDSHALE_WALL.get(), "inventory");
		this.parent(IcariaItems.VOIDSHALE.get());
		this.parent(IcariaItems.VOIDSHALE_STAIRS.get());
		this.parent(IcariaItems.VOIDSHALE_SLAB.get());
		this.parent(IcariaItems.VOIDSHALE_WALL.get(), "inventory");
		this.parent(IcariaItems.VOIDSHALE_BRICKS.get());
		this.parent(IcariaItems.VOIDSHALE_BRICK_STAIRS.get());
		this.parent(IcariaItems.VOIDSHALE_BRICK_SLAB.get());
		this.parent(IcariaItems.VOIDSHALE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.CHISELED_VOIDSHALE.get());
		this.parent(IcariaItems.VOIDSHALE_RUBBLE.get(), "3");
		this.parent(IcariaItems.BAETYL_ADOBE.get());
		this.parent(IcariaItems.BAETYL_ADOBE_STAIRS.get());
		this.parent(IcariaItems.BAETYL_ADOBE_SLAB.get());
		this.parent(IcariaItems.BAETYL_ADOBE_WALL.get(), "inventory");
		this.parent(IcariaItems.COBBLED_BAETYL.get());
		this.parent(IcariaItems.COBBLED_BAETYL_STAIRS.get());
		this.parent(IcariaItems.COBBLED_BAETYL_SLAB.get());
		this.parent(IcariaItems.COBBLED_BAETYL_WALL.get(), "inventory");
		this.parent(IcariaItems.BAETYL.get());
		this.parent(IcariaItems.BAETYL_STAIRS.get());
		this.parent(IcariaItems.BAETYL_SLAB.get());
		this.parent(IcariaItems.BAETYL_WALL.get(), "inventory");
		this.parent(IcariaItems.BAETYL_BRICKS.get());
		this.parent(IcariaItems.BAETYL_BRICK_STAIRS.get());
		this.parent(IcariaItems.BAETYL_BRICK_SLAB.get());
		this.parent(IcariaItems.BAETYL_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.CHISELED_BAETYL.get());
		this.parent(IcariaItems.BAETYL_RUBBLE.get(), "3");
		this.parent(IcariaItems.RELICSTONE.get());
		this.parent(IcariaItems.RELICSTONE_STAIRS.get());
		this.parent(IcariaItems.RELICSTONE_SLAB.get());
		this.parent(IcariaItems.RELICSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.SMOOTH_RELICSTONE.get());
		this.parent(IcariaItems.SMOOTH_RELICSTONE_STAIRS.get());
		this.parent(IcariaItems.SMOOTH_RELICSTONE_SLAB.get());
		this.parent(IcariaItems.SMOOTH_RELICSTONE_WALL.get(), "inventory");
		this.parent(IcariaItems.RELICSTONE_BRICKS.get());
		this.parent(IcariaItems.RELICSTONE_BRICK_STAIRS.get());
		this.parent(IcariaItems.RELICSTONE_BRICK_SLAB.get());
		this.parent(IcariaItems.RELICSTONE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
		this.parent(IcariaItems.CRACKED_RELICSTONE_BRICK_STAIRS.get());
		this.parent(IcariaItems.CRACKED_RELICSTONE_BRICK_SLAB.get());
		this.parent(IcariaItems.CRACKED_RELICSTONE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
		this.parent(IcariaItems.MOSSY_RELICSTONE_BRICK_STAIRS.get());
		this.parent(IcariaItems.MOSSY_RELICSTONE_BRICK_SLAB.get());
		this.parent(IcariaItems.MOSSY_RELICSTONE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.RELICSTONE_TILES.get());
		this.parent(IcariaItems.RELICSTONE_TILE_STAIRS.get());
		this.parent(IcariaItems.RELICSTONE_TILE_SLAB.get());
		this.parent(IcariaItems.RELICSTONE_TILE_WALL.get(), "inventory");
		this.parent(IcariaItems.CRACKED_RELICSTONE_TILES.get());
		this.parent(IcariaItems.CRACKED_RELICSTONE_TILE_STAIRS.get());
		this.parent(IcariaItems.CRACKED_RELICSTONE_TILE_SLAB.get());
		this.parent(IcariaItems.CRACKED_RELICSTONE_TILE_WALL.get(), "inventory");
		this.parent(IcariaItems.MOSSY_RELICSTONE_TILES.get());
		this.parent(IcariaItems.MOSSY_RELICSTONE_TILE_STAIRS.get());
		this.parent(IcariaItems.MOSSY_RELICSTONE_TILE_SLAB.get());
		this.parent(IcariaItems.MOSSY_RELICSTONE_TILE_WALL.get(), "inventory");
		this.parent(IcariaItems.CHISELED_RELICSTONE.get());
		this.parent(IcariaItems.RELICSTONE_PILLAR.get());
		this.parent(IcariaItems.RELICSTONE_PILLAR_HEAD.get());
		this.parent(IcariaItems.RELICSTONE_RUBBLE.get(), "3");
		this.parent(IcariaItems.PLATOSHALE.get());
		this.parent(IcariaItems.PLATOSHALE_STAIRS.get());
		this.parent(IcariaItems.PLATOSHALE_SLAB.get());
		this.parent(IcariaItems.PLATOSHALE_WALL.get(), "inventory");
		this.parent(IcariaItems.BLURRED_PLATOSHALE.get());
		this.parent(IcariaItems.PLATOSHALE_BRICKS.get());
		this.parent(IcariaItems.PLATOSHALE_BRICK_STAIRS.get());
		this.parent(IcariaItems.PLATOSHALE_BRICK_SLAB.get());
		this.parent(IcariaItems.PLATOSHALE_BRICK_WALL.get(), "inventory");
		this.parent(IcariaItems.BLURRED_PLATOSHALE_BRICKS.get());
		this.parent(IcariaItems.CHISELED_PLATOSHALE.get());
		this.parent(IcariaItems.QUARTZ_WALL.get(), "inventory");
		this.parent(IcariaItems.QUARTZ_PILLAR_HEAD.get());
		this.parent(IcariaItems.LIGNITE_ORE.get());
		this.parent(IcariaItems.CHALKOS_ORE.get());
		this.parent(IcariaItems.KASSITEROS_ORE.get());
		this.parent(IcariaItems.DOLOMITE_ORE.get());
		this.parent(IcariaItems.VANADIUM_ORE.get());
		this.parent(IcariaItems.SLIVER_ORE.get());
		this.parent(IcariaItems.SIDEROS_ORE.get());
		this.parent(IcariaItems.ANTHRACITE_ORE.get());
		this.parent(IcariaItems.MOLYBDENUM_ORE.get());
		this.parent(IcariaItems.HYLIASTRUM_ORE.get());
		this.parent(IcariaItems.CALCITE.get());
		this.parent(IcariaItems.BUDDING_CALCITE.get());
		this.parent(IcariaItems.HALITE.get());
		this.parent(IcariaItems.BUDDING_HALITE.get());
		this.parent(IcariaItems.JASPER.get());
		this.parent(IcariaItems.BUDDING_JASPER.get());
		this.parent(IcariaItems.ZIRCON.get());
		this.parent(IcariaItems.BUDDING_ZIRCON.get());
		this.parent(IcariaItems.CALCITE_CRYSTAL.get());
		this.parent(IcariaItems.HALITE_CRYSTAL.get());
		this.parent(IcariaItems.JASPER_CRYSTAL.get());
		this.parent(IcariaItems.ZIRCON_CRYSTAL.get());
		this.parent(IcariaItems.ARISTONE.get());
		this.parent(IcariaItems.PACKED_ARISTONE.get());
		this.parent(IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.parent(IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.parent(IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.parent(IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.parent(IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.parent(IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.parent(IcariaItems.SPELT_BALE_BLOCK.get());
		this.parent(IcariaItems.VINE_REED_BLOCK.get());
		this.parent(IcariaItems.ROTTEN_BONES_BLOCK.get());
		this.parent(IcariaItems.RAW_CHALKOS_BLOCK.get());
		this.parent(IcariaItems.RAW_KASSITEROS_BLOCK.get());
		this.parent(IcariaItems.RAW_VANADIUM_BLOCK.get());
		this.parent(IcariaItems.RAW_SIDEROS_BLOCK.get());
		this.parent(IcariaItems.RAW_MOLYBDENUM_BLOCK.get());
		this.parent(IcariaItems.CALCITE_BLOCK.get());
		this.parent(IcariaItems.HALITE_BLOCK.get());
		this.parent(IcariaItems.JASPER_BLOCK.get());
		this.parent(IcariaItems.ZIRCON_BLOCK.get());
		this.parent(IcariaItems.CHERT_BLOCK.get());
		this.parent(IcariaItems.LIGNITE_BLOCK.get());
		this.parent(IcariaItems.CHALKOS_BLOCK.get());
		this.parent(IcariaItems.KASSITEROS_BLOCK.get());
		this.parent(IcariaItems.ORICHALCUM_BLOCK.get());
		this.parent(IcariaItems.VANADIUM_BLOCK.get());
		this.parent(IcariaItems.SLIVER_BLOCK.get());
		this.parent(IcariaItems.VANADIUMSTEEL_BLOCK.get());
		this.parent(IcariaItems.SIDEROS_BLOCK.get());
		this.parent(IcariaItems.ANTHRACITE_BLOCK.get());
		this.parent(IcariaItems.MOLYBDENUM_BLOCK.get());
		this.parent(IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());
		this.parent(IcariaItems.BLURIDIUM_BLOCK.get());
		this.parent(IcariaItems.VANADIUMSTEEL_BARS.get(), "inventory");
		this.parent(IcariaItems.HORIZONTAL_VANADIUMSTEEL_BARS.get());
		this.parent(IcariaItems.KETTLE.get(), "inventory");
		this.parent(IcariaItems.GRINDER.get(), "inventory");
		this.parent(IcariaItems.KILN.get(), "inventory");
		this.parent(IcariaItems.FORGE.get(), "inventory");
		this.parent(IcariaItems.STORAGE_VASE.get());
		this.parent(IcariaItems.WHITE_STORAGE_VASE.get());
		this.parent(IcariaItems.LIGHT_GRAY_STORAGE_VASE.get());
		this.parent(IcariaItems.GRAY_STORAGE_VASE.get());
		this.parent(IcariaItems.BLACK_STORAGE_VASE.get());
		this.parent(IcariaItems.BROWN_STORAGE_VASE.get());
		this.parent(IcariaItems.RED_STORAGE_VASE.get());
		this.parent(IcariaItems.ORANGE_STORAGE_VASE.get());
		this.parent(IcariaItems.YELLOW_STORAGE_VASE.get());
		this.parent(IcariaItems.LIME_STORAGE_VASE.get());
		this.parent(IcariaItems.GREEN_STORAGE_VASE.get());
		this.parent(IcariaItems.CYAN_STORAGE_VASE.get());
		this.parent(IcariaItems.LIGHT_BLUE_STORAGE_VASE.get());
		this.parent(IcariaItems.BLUE_STORAGE_VASE.get());
		this.parent(IcariaItems.PURPLE_STORAGE_VASE.get());
		this.parent(IcariaItems.MAGENTA_STORAGE_VASE.get());
		this.parent(IcariaItems.PINK_STORAGE_VASE.get());
		this.parent(IcariaItems.RED_LOOT_VASE.get(), "2");
		this.parent(IcariaItems.LOST_LOOT_VASE.get(), "2");
		this.parent(IcariaItems.CYAN_LOOT_VASE.get(), "2");
		this.parent(IcariaItems.ARACHNE_SPAWNER.get());
		this.parent(IcariaItems.REVENANT_SPAWNER.get());
		this.parent(IcariaItems.CYPRESS_LEAVES.get());
		this.parent(IcariaItems.FALLEN_CYPRESS_LEAVES.get(), "1");
		this.parent(IcariaItems.CYPRESS_TWIGS.get(), "3");
		this.parent(IcariaItems.CYPRESS_WOOD.get());
		this.parent(IcariaItems.STRIPPED_CYPRESS_WOOD.get());
		this.parent(IcariaItems.CYPRESS_LOG.get());
		this.parent(IcariaItems.STRIPPED_CYPRESS_LOG.get());
		this.parent(IcariaItems.DEAD_CYPRESS_LOG.get(), "0");
		this.parent(IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get(), "0");
		this.parent(IcariaItems.CYPRESS_PLANKS.get());
		this.parent(IcariaItems.CYPRESS_STAIRS.get());
		this.parent(IcariaItems.CYPRESS_SLAB.get());
		this.parent(IcariaItems.CYPRESS_FENCE.get(), "inventory");
		this.parent(IcariaItems.CYPRESS_FENCE_GATE.get());
		this.parent(IcariaItems.SIMPLE_CYPRESS_RACK.get());
		this.parent(IcariaItems.CYPRESS_RACK.get());
		this.parent(IcariaItems.CYPRESS_BARREL.get());
		this.parent(IcariaItems.LOADED_CYPRESS_BARREL.get());
		this.parent(IcariaItems.TAPPED_CYPRESS_BARREL.get());
		this.parent(IcariaItems.TRIPLE_CYPRESS_BARREL_RACK.get(), "inventory");
		this.parent(IcariaItems.CYPRESS_TROUGH.get());
		this.parent(IcariaItems.CYPRESS_CRAFTING_TABLE.get());
		this.parent(IcariaItems.CYPRESS_TRAPDOOR.get(), "bottom");
		this.parent(IcariaItems.CYPRESS_PRESSURE_PLATE.get());
		this.parent(IcariaItems.CYPRESS_BUTTON.get(), "inventory");
		this.parent(IcariaItems.DROUGHTROOT_LEAVES.get());
		this.parent(IcariaItems.FALLEN_DROUGHTROOT_LEAVES.get(), "1");
		this.parent(IcariaItems.DROUGHTROOT_TWIGS.get(), "3");
		this.parent(IcariaItems.DROUGHTROOT_WOOD.get());
		this.parent(IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get());
		this.parent(IcariaItems.DROUGHTROOT_LOG.get());
		this.parent(IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
		this.parent(IcariaItems.DEAD_DROUGHTROOT_LOG.get(), "0");
		this.parent(IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), "0");
		this.parent(IcariaItems.DROUGHTROOT_PLANKS.get());
		this.parent(IcariaItems.DROUGHTROOT_STAIRS.get());
		this.parent(IcariaItems.DROUGHTROOT_SLAB.get());
		this.parent(IcariaItems.DROUGHTROOT_FENCE.get(), "inventory");
		this.parent(IcariaItems.DROUGHTROOT_FENCE_GATE.get());
		this.parent(IcariaItems.SIMPLE_DROUGHTROOT_RACK.get());
		this.parent(IcariaItems.DROUGHTROOT_RACK.get());
		this.parent(IcariaItems.DROUGHTROOT_BARREL.get());
		this.parent(IcariaItems.LOADED_DROUGHTROOT_BARREL.get());
		this.parent(IcariaItems.TAPPED_DROUGHTROOT_BARREL.get());
		this.parent(IcariaItems.TRIPLE_DROUGHTROOT_BARREL_RACK.get(), "inventory");
		this.parent(IcariaItems.DROUGHTROOT_TROUGH.get());
		this.parent(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get());
		this.parent(IcariaItems.DROUGHTROOT_TRAPDOOR.get(), "bottom");
		this.parent(IcariaItems.DROUGHTROOT_PRESSURE_PLATE.get());
		this.parent(IcariaItems.DROUGHTROOT_BUTTON.get(), "inventory");
		this.parent(IcariaItems.FIR_LEAVES.get());
		this.parent(IcariaItems.FALLEN_FIR_LEAVES.get(), "1");
		this.parent(IcariaItems.FIR_TWIGS.get(), "3");
		this.parent(IcariaItems.FIR_WOOD.get());
		this.parent(IcariaItems.STRIPPED_FIR_WOOD.get());
		this.parent(IcariaItems.FIR_LOG.get());
		this.parent(IcariaItems.STRIPPED_FIR_LOG.get());
		this.parent(IcariaItems.DEAD_FIR_LOG.get(), "0");
		this.parent(IcariaItems.STRIPPED_DEAD_FIR_LOG.get(), "0");
		this.parent(IcariaItems.FIR_PLANKS.get());
		this.parent(IcariaItems.FIR_STAIRS.get());
		this.parent(IcariaItems.FIR_SLAB.get());
		this.parent(IcariaItems.FIR_FENCE.get(), "inventory");
		this.parent(IcariaItems.FIR_FENCE_GATE.get());
		this.parent(IcariaItems.SIMPLE_FIR_RACK.get());
		this.parent(IcariaItems.FIR_RACK.get());
		this.parent(IcariaItems.FIR_BARREL.get());
		this.parent(IcariaItems.LOADED_FIR_BARREL.get());
		this.parent(IcariaItems.TAPPED_FIR_BARREL.get());
		this.parent(IcariaItems.TRIPLE_FIR_BARREL_RACK.get(), "inventory");
		this.parent(IcariaItems.FIR_TROUGH.get());
		this.parent(IcariaItems.FIR_CRAFTING_TABLE.get());
		this.parent(IcariaItems.FIR_TRAPDOOR.get(), "bottom");
		this.parent(IcariaItems.FIR_PRESSURE_PLATE.get());
		this.parent(IcariaItems.FIR_BUTTON.get(), "inventory");
		this.parent(IcariaItems.LAUREL_LEAVES.get());
		this.parent(IcariaItems.FALLEN_LAUREL_LEAVES.get(), "1");
		this.parent(IcariaItems.LAUREL_TWIGS.get(), "3");
		this.parent(IcariaItems.LAUREL_WOOD.get());
		this.parent(IcariaItems.STRIPPED_LAUREL_WOOD.get());
		this.parent(IcariaItems.LAUREL_LOG.get());
		this.parent(IcariaItems.STRIPPED_LAUREL_LOG.get());
		this.parent(IcariaItems.DEAD_LAUREL_LOG.get(), "0");
		this.parent(IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get(), "0");
		this.parent(IcariaItems.LAUREL_PLANKS.get());
		this.parent(IcariaItems.LAUREL_STAIRS.get());
		this.parent(IcariaItems.LAUREL_SLAB.get());
		this.parent(IcariaItems.LAUREL_FENCE.get(), "inventory");
		this.parent(IcariaItems.LAUREL_FENCE_GATE.get());
		this.parent(IcariaItems.SIMPLE_LAUREL_RACK.get());
		this.parent(IcariaItems.LAUREL_RACK.get());
		this.parent(IcariaItems.LAUREL_BARREL.get());
		this.parent(IcariaItems.LOADED_LAUREL_BARREL.get());
		this.parent(IcariaItems.TAPPED_LAUREL_BARREL.get());
		this.parent(IcariaItems.TRIPLE_LAUREL_BARREL_RACK.get(), "inventory");
		this.parent(IcariaItems.LAUREL_TROUGH.get());
		this.parent(IcariaItems.LAUREL_CRAFTING_TABLE.get());
		this.parent(IcariaItems.LAUREL_TRAPDOOR.get(), "bottom");
		this.parent(IcariaItems.LAUREL_PRESSURE_PLATE.get());
		this.parent(IcariaItems.LAUREL_BUTTON.get(), "inventory");
		this.parent(IcariaItems.OLIVE_LEAVES.get());
		this.parent(IcariaItems.FALLEN_OLIVE_LEAVES.get(), "1");
		this.parent(IcariaItems.OLIVE_TWIGS.get(), "3");
		this.parent(IcariaItems.OLIVE_WOOD.get());
		this.parent(IcariaItems.STRIPPED_OLIVE_WOOD.get());
		this.parent(IcariaItems.OLIVE_LOG.get());
		this.parent(IcariaItems.STRIPPED_OLIVE_LOG.get());
		this.parent(IcariaItems.DEAD_OLIVE_LOG.get(), "0");
		this.parent(IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get(), "0");
		this.parent(IcariaItems.OLIVE_PLANKS.get());
		this.parent(IcariaItems.OLIVE_STAIRS.get());
		this.parent(IcariaItems.OLIVE_SLAB.get());
		this.parent(IcariaItems.OLIVE_FENCE.get(), "inventory");
		this.parent(IcariaItems.OLIVE_FENCE_GATE.get());
		this.parent(IcariaItems.SIMPLE_OLIVE_RACK.get());
		this.parent(IcariaItems.OLIVE_RACK.get());
		this.parent(IcariaItems.OLIVE_BARREL.get());
		this.parent(IcariaItems.LOADED_OLIVE_BARREL.get());
		this.parent(IcariaItems.TAPPED_OLIVE_BARREL.get());
		this.parent(IcariaItems.TRIPLE_OLIVE_BARREL_RACK.get(), "inventory");
		this.parent(IcariaItems.OLIVE_TROUGH.get());
		this.parent(IcariaItems.OLIVE_CRAFTING_TABLE.get());
		this.parent(IcariaItems.OLIVE_TRAPDOOR.get(), "bottom");
		this.parent(IcariaItems.OLIVE_PRESSURE_PLATE.get());
		this.parent(IcariaItems.OLIVE_BUTTON.get(), "inventory");
		this.parent(IcariaItems.PLANE_LEAVES.get());
		this.parent(IcariaItems.FALLEN_PLANE_LEAVES.get(), "1");
		this.parent(IcariaItems.PLANE_TWIGS.get(), "3");
		this.parent(IcariaItems.PLANE_WOOD.get());
		this.parent(IcariaItems.STRIPPED_PLANE_WOOD.get());
		this.parent(IcariaItems.PLANE_LOG.get());
		this.parent(IcariaItems.STRIPPED_PLANE_LOG.get());
		this.parent(IcariaItems.DEAD_PLANE_LOG.get(), "0");
		this.parent(IcariaItems.STRIPPED_DEAD_PLANE_LOG.get(), "0");
		this.parent(IcariaItems.PLANE_PLANKS.get());
		this.parent(IcariaItems.PLANE_STAIRS.get());
		this.parent(IcariaItems.PLANE_SLAB.get());
		this.parent(IcariaItems.PLANE_FENCE.get(), "inventory");
		this.parent(IcariaItems.PLANE_FENCE_GATE.get());
		this.parent(IcariaItems.SIMPLE_PLANE_RACK.get());
		this.parent(IcariaItems.PLANE_RACK.get());
		this.parent(IcariaItems.PLANE_BARREL.get());
		this.parent(IcariaItems.LOADED_PLANE_BARREL.get());
		this.parent(IcariaItems.TAPPED_PLANE_BARREL.get());
		this.parent(IcariaItems.TRIPLE_PLANE_BARREL_RACK.get(), "inventory");
		this.parent(IcariaItems.PLANE_TROUGH.get());
		this.parent(IcariaItems.PLANE_CRAFTING_TABLE.get());
		this.parent(IcariaItems.PLANE_TRAPDOOR.get(), "bottom");
		this.parent(IcariaItems.PLANE_PRESSURE_PLATE.get());
		this.parent(IcariaItems.PLANE_BUTTON.get(), "inventory");
		this.parent(IcariaItems.POPULUS_LEAVES.get());
		this.parent(IcariaItems.FALLEN_POPULUS_LEAVES.get(), "1");
		this.parent(IcariaItems.POPULUS_TWIGS.get(), "3");
		this.parent(IcariaItems.POPULUS_WOOD.get());
		this.parent(IcariaItems.STRIPPED_POPULUS_WOOD.get());
		this.parent(IcariaItems.POPULUS_LOG.get());
		this.parent(IcariaItems.STRIPPED_POPULUS_LOG.get());
		this.parent(IcariaItems.DEAD_POPULUS_LOG.get(), "0");
		this.parent(IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get(), "0");
		this.parent(IcariaItems.POPULUS_PLANKS.get());
		this.parent(IcariaItems.POPULUS_STAIRS.get());
		this.parent(IcariaItems.POPULUS_SLAB.get());
		this.parent(IcariaItems.POPULUS_FENCE.get(), "inventory");
		this.parent(IcariaItems.POPULUS_FENCE_GATE.get());
		this.parent(IcariaItems.SIMPLE_POPULUS_RACK.get());
		this.parent(IcariaItems.POPULUS_RACK.get());
		this.parent(IcariaItems.POPULUS_BARREL.get());
		this.parent(IcariaItems.LOADED_POPULUS_BARREL.get());
		this.parent(IcariaItems.TAPPED_POPULUS_BARREL.get());
		this.parent(IcariaItems.TRIPLE_POPULUS_BARREL_RACK.get(), "inventory");
		this.parent(IcariaItems.POPULUS_TROUGH.get());
		this.parent(IcariaItems.POPULUS_CRAFTING_TABLE.get());
		this.parent(IcariaItems.POPULUS_TRAPDOOR.get(), "bottom");
		this.parent(IcariaItems.POPULUS_PRESSURE_PLATE.get());
		this.parent(IcariaItems.POPULUS_BUTTON.get(), "inventory");
		this.parent(IcariaItems.BLUE_GROUND_FLOWERS.get(), "0");
		this.parent(IcariaItems.CYAN_GROUND_FLOWERS.get(), "0");
		this.parent(IcariaItems.PINK_GROUND_FLOWERS.get(), "0");
		this.parent(IcariaItems.PURPLE_GROUND_FLOWERS.get(), "0");
		this.parent(IcariaItems.RED_GROUND_FLOWERS.get(), "0");
		this.parent(IcariaItems.WHITE_GROUND_FLOWERS.get(), "0");
		this.parent(IcariaItems.FOREST_MOSS.get(), "1");
		this.parent(IcariaItems.SCRUBLAND_MOSS.get(), "1");
		this.parent(IcariaItems.STEPPE_MOSS.get(), "1");
		this.parent(IcariaItems.PALM_FERN.get());
		this.parent(IcariaItems.WHITE_BROMELIA.get());
		this.parent(IcariaItems.ORANGE_BROMELIA.get());
		this.parent(IcariaItems.PINK_BROMELIA.get());
		this.parent(IcariaItems.PURPLE_BROMELIA.get());
		this.parent(IcariaItems.GREEN_GROUND_SHROOMS.get(), "0");
		this.parent(IcariaItems.BROWN_GROUND_SHROOMS.get(), "0");
		this.parent(IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get(), "0");
		this.parent(IcariaItems.TINDER_FUNGUS_TREE_SHROOMS.get(), "0");
		this.parent(IcariaItems.TURKEY_TAIL_TREE_SHROOMS.get(), "0");
		this.parent(IcariaItems.UNNAMED_TREE_SHROOMS.get(), "0");
		this.parent(IcariaItems.CARDON_CACTUS.get(), "inventory");
		this.parent(IcariaItems.GRINDER_SHAFT.get());
		this.parent(IcariaItems.GRINDER_STONE.get());
	}

	public void scroll() {
		this.scroll(IcariaItems.ANTI_GRAVITY_SCROLL.get());
		this.scroll(IcariaItems.FORTIFYING_SCROLL.get());
		this.scroll(IcariaItems.HEALING_SCROLL.get());
		this.scroll(IcariaItems.BUBBLE_SCROLL.get());
		this.scroll(IcariaItems.FREEZING_SCROLL.get());
		this.scroll(IcariaItems.MAGIC_MISSILE_SCROLL.get());
	}

	public void skull() {
		this.skull(IcariaItems.AETERNAE_SKULL.get());
		this.skull(IcariaItems.ARGAN_HOUND_SKULL.get());
		this.skull(IcariaItems.CAPELLA_SKULL.get());
		this.skull(IcariaItems.CATOBLEPAS_SKULL.get());
		this.skull(IcariaItems.CERVER_SKULL.get());
		this.skull(IcariaItems.CROCOTTA_SKULL.get());
		this.skull(IcariaItems.CYPRESS_FOREST_HAG_SKULL.get());
		this.skull(IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get());
		this.skull(IcariaItems.FIR_FOREST_HAG_SKULL.get());
		this.skull(IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
		this.skull(IcariaItems.OLIVE_FOREST_HAG_SKULL.get());
		this.skull(IcariaItems.PLANE_FOREST_HAG_SKULL.get());
		this.skull(IcariaItems.POPULUS_FOREST_HAG_SKULL.get());
		this.skull(IcariaItems.REVENANT_SKULL.get());
		this.skull(IcariaItems.SOW_SKULL.get());
	}

	public void spawnEgg() {
		this.spawnEgg(IcariaItems.AETERNAE_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.ARACHNE_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.ARACHNE_DRONE_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.ARGAN_HOUND_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CAPELLA_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CATOBLEPAS_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CERVER_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CROCOTTA_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CYPRESS_FOREST_HAG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.DROUGHTROOT_FOREST_HAG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.FIR_FOREST_HAG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.LAUREL_FOREST_HAG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.OLIVE_FOREST_HAG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.PLANE_FOREST_HAG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.POPULUS_FOREST_HAG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.HYLIASTER_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.ENDER_JELLYFISH_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.FIRE_JELLYFISH_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.NATURE_JELLYFISH_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.VOID_JELLYFISH_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.WATER_JELLYFISH_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.MYRMEKE_DRONE_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.MYRMEKE_SOLDIER_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.MYRMEKE_QUEEN_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CAPTAIN_REVENANT_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CIVILIAN_REVENANT_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CRAWLER_REVENANT_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.OVERGROWN_REVENANT_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.PYROMANCER_REVENANT_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.NETHER_PYROMANCER_REVENANT_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.SOLDIER_REVENANT_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.SCORPION_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.CRYSTAL_SLUG_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.FOREST_SNULL_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.SNULL_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.SOLIFUGAE_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.SOW_SPAWN_EGG.get());
		this.spawnEgg(IcariaItems.VINEGAROON_SPAWN_EGG.get());
	}

	public void bident(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.MC, "handheld"))
			.texture("layer0", this.itemFile(pItem))
			.override()
			.predicate(IcariaResourceLocations.THROWING, 1.0F)
			.model(this.withExistingParent(this.name(pItem, "throwing"), this.itemFile(IcariaIdents.MC, "generated"))
				.texture("layer0", this.itemFile(pItem))
				.transforms()
				.transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(-50.0F, 90.0F, -25.0F).translation(9.13F, 3.2F, -6.13F).scale(0.68F).end()
				.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(-50.0F, -90.0F, 25.0F).translation(9.13F, 3.2F, -6.13F).scale(0.68F).end()
				.transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(195.0F, 90.0F, -55.0F).translation(0.0F, -4.0F, 2.0F).scale(0.85F).end()
				.transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(195.0F, -90.0F, 55.0F).translation(0.0F, -4.0F, 2.0F).scale(0.85F).end()
				.end()
			);
	}

	public void chest(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.MC, "chest"));
	}

	public void generated(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.MC, "generated"))
			.texture("layer0", this.itemFile(pItem));
	}

	public void handheld(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.MC, "handheld"))
			.texture("layer0", this.itemFile(pItem));
	}

	public void horn(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.MC, "generated"))
			.texture("layer0", this.itemFile(pItem))
			.transforms()
			.transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 90.0F, -25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
			.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, -90.0F, 25.0F).translation(1.13F, 3.2F, 1.13F).scale(0.68F).end()
			.transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0F, 0.0F, 0.0F).translation(0.0F, 3.0F, 1.0F).scale(0.55F).end()
			.transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0F, 180.0F, 0.0F).translation(0.0F, 3.0F, 1.0F).scale(0.55F).end()
			.end()
			.override()
			.predicate(IcariaResourceLocations.TOOTING, 1.0F)
			.model(this.withExistingParent(this.name(pItem, "tooting"), this.itemFile(IcariaIdents.MC, "generated"))
				.texture("layer0", this.itemFile(pItem))
				.transforms()
				.transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND).rotation(0.0F, 115.0F, 5.0F).translation(0.0F, -2.5F, -7.5F).end()
				.transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND).rotation(0.0F, -55.0F, -5.0F).translation(-1.0F, -2.5F, -7.5F).end()
				.transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND).rotation(0.0F, 55.0F, 0.0F).translation(-1.0F, 2.0F, 2.0F).scale(0.5F).end()
				.transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND).rotation(0.0F, -125.0F, 0.0F).translation(-1.0F, 2.0F, 2.0F).scale(0.5F).end()
				.end()
			);
	}

	public void parent(Item pItem, String pSuffix) {
		this.withExistingParent(this.name(pItem), this.file(pItem, pSuffix));
	}

	public void parent(Item pItem) {
		this.withExistingParent(this.name(pItem), this.file(pItem));
	}

	public void scroll(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.NF, "default"))
			.customLoader(SeparateTransformsModelBuilder::begin)
			.base(this.nested().parent(this.getExistingFile(this.itemFile(IcariaIdents.MC, "generated"))).texture("layer0", this.itemFile(pItem)))
			.perspective(ItemDisplayContext.FIRST_PERSON_LEFT_HAND, this.nested().parent(this.getBuiltin("entity")))
			.perspective(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND, this.nested().parent(this.getBuiltin("entity")))
			.end();
	}

	public void skull(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.MC, "template_skull"));
	}

	public void spawnEgg(Item pItem) {
		this.withExistingParent(this.name(pItem), this.itemFile(IcariaIdents.MC, "template_spawn_egg"));
	}

	public ModelFile.UncheckedModelFile getBuiltin(String pPath) {
		return new ModelFile.UncheckedModelFile(ResourceLocation.fromNamespaceAndPath(IcariaIdents.MC, "builtin" + "/" + pPath));
	}

	public ResourceLocation file(Item pItem, String pSuffix) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.BLOCK_FOLDER + "/" + this.name(pItem) + "_" + pSuffix);
	}

	public ResourceLocation file(Item pItem) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.BLOCK_FOLDER + "/" + this.name(pItem));
	}

	public ResourceLocation file(String pPrefix, Item pItem, String pSuffix) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pItem) + "_" + pSuffix);
	}

	public ResourceLocation file(String pPrefix, Item pItem) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.BLOCK_FOLDER + "/" + pPrefix + "_" + this.name(pItem));
	}

	public ResourceLocation file(String pId, String pFile) {
		return ResourceLocation.fromNamespaceAndPath(pId, ModelProvider.BLOCK_FOLDER + "/" + pFile);
	}

	public ResourceLocation itemFile(Item pItem, String pSuffix) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.ITEM_FOLDER + "/" + this.name(pItem) + "_" + pSuffix);
	}

	public ResourceLocation itemFile(Item pItem) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.ITEM_FOLDER + "/" + this.name(pItem));
	}

	public ResourceLocation itemFile(String pPrefix, Item pItem, String pSuffix) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.ITEM_FOLDER + "/" + pPrefix + "_" + this.name(pItem) + "_" + pSuffix);
	}

	public ResourceLocation itemFile(String pPrefix, Item pItem) {
		return ResourceLocation.fromNamespaceAndPath(this.id(pItem), ModelProvider.ITEM_FOLDER + "/" + pPrefix + "_" + this.name(pItem));
	}

	public ResourceLocation itemFile(String pId, String pFile) {
		return ResourceLocation.fromNamespaceAndPath(pId, ModelProvider.ITEM_FOLDER + "/" + pFile);
	}

	public String id(Item pItem) {
		return BuiltInRegistries.ITEM.getKey(pItem).getNamespace();
	}

	public String name(Item pItem, String pSuffix) {
		return BuiltInRegistries.ITEM.getKey(pItem).getPath() + "_" + pSuffix;
	}

	public String name(Item pItem) {
		return BuiltInRegistries.ITEM.getKey(pItem).getPath();
	}

	public String name(String pPrefix, Item pItem, String pSuffix) {
		return pPrefix + "_" + BuiltInRegistries.ITEM.getKey(pItem).getPath() + "_" + pSuffix;
	}

	public String name(String pPrefix, Item pItem) {
		return pPrefix + "_" + BuiltInRegistries.ITEM.getKey(pItem).getPath();
	}
}
