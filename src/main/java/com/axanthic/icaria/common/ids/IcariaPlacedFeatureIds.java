package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPlacedFeatureIds {
	public static final ResourceKey<PlacedFeature> MARL_CHERT = IcariaPlacedFeatureIds.create("marl_chert");
	public static final ResourceKey<PlacedFeature> MARL_BONES = IcariaPlacedFeatureIds.create("marl_bones");
	public static final ResourceKey<PlacedFeature> MARL_LIGNITE = IcariaPlacedFeatureIds.create("marl_lignite");
	public static final ResourceKey<PlacedFeature> GRAINEL_CHERT = IcariaPlacedFeatureIds.create("grainel_chert");

	public static final ResourceKey<PlacedFeature> GRAINITE_SPIKE = IcariaPlacedFeatureIds.create("grainite_spike");

	public static final ResourceKey<PlacedFeature> YELLOWSTONE_BOULDER = IcariaPlacedFeatureIds.create("yellowstone_boulder");

	public static final ResourceKey<PlacedFeature> GRAINITE_RUBBLE = IcariaPlacedFeatureIds.create("grainite_rubble");
	public static final ResourceKey<PlacedFeature> YELLOWSTONE_RUBBLE = IcariaPlacedFeatureIds.create("yellowstone_rubble");
	public static final ResourceKey<PlacedFeature> SILKSTONE_RUBBLE = IcariaPlacedFeatureIds.create("silkstone_rubble");
	public static final ResourceKey<PlacedFeature> SUNSTONE_RUBBLE = IcariaPlacedFeatureIds.create("sunstone_rubble");
	public static final ResourceKey<PlacedFeature> VOIDSHALE_RUBBLE = IcariaPlacedFeatureIds.create("voidshale_rubble");
	public static final ResourceKey<PlacedFeature> BAETYL_RUBBLE = IcariaPlacedFeatureIds.create("baetyl_rubble");
	public static final ResourceKey<PlacedFeature> RELICSTONE_RUBBLE = IcariaPlacedFeatureIds.create("relicstone_rubble");

	public static final ResourceKey<PlacedFeature> FALLEN_RELICSTONE_PILLAR = IcariaPlacedFeatureIds.create("fallen_relicstone_pillar");
	public static final ResourceKey<PlacedFeature> RELICSTONE_PILLAR = IcariaPlacedFeatureIds.create("relicstone_pillar");

	public static final ResourceKey<PlacedFeature> LIGNITE_ORE = IcariaPlacedFeatureIds.create("lignite_ore");
	public static final ResourceKey<PlacedFeature> CHALKOS_ORE = IcariaPlacedFeatureIds.create("chalkos_ore");
	public static final ResourceKey<PlacedFeature> KASSITEROS_ORE = IcariaPlacedFeatureIds.create("kassiteros_ore");
	public static final ResourceKey<PlacedFeature> DOLOMITE_ORE = IcariaPlacedFeatureIds.create("dolomite_ore");
	public static final ResourceKey<PlacedFeature> VANADIUM_ORE = IcariaPlacedFeatureIds.create("vanadium_ore");
	public static final ResourceKey<PlacedFeature> SLIVER_ORE = IcariaPlacedFeatureIds.create("sliver_ore");
	public static final ResourceKey<PlacedFeature> SIDEROS_ORE = IcariaPlacedFeatureIds.create("sideros_ore");
	public static final ResourceKey<PlacedFeature> ANTHRACITE_ORE = IcariaPlacedFeatureIds.create("anthracite_ore");
	public static final ResourceKey<PlacedFeature> MOLYBDENUM_ORE = IcariaPlacedFeatureIds.create("molybdenum_ore");
	public static final ResourceKey<PlacedFeature> HYLIASTRUM_ORE = IcariaPlacedFeatureIds.create("hyliastrum_ore");

	public static final ResourceKey<PlacedFeature> CALCITE_CLUSTER = IcariaPlacedFeatureIds.create("calcite_cluster");
	public static final ResourceKey<PlacedFeature> HALITE_CLUSTER = IcariaPlacedFeatureIds.create("halite_cluster");
	public static final ResourceKey<PlacedFeature> JASPER_CLUSTER = IcariaPlacedFeatureIds.create("jasper_cluster");
	public static final ResourceKey<PlacedFeature> ZIRCON_CLUSTER = IcariaPlacedFeatureIds.create("zircon_cluster");

	public static final ResourceKey<PlacedFeature> CYPRESS_TREE = IcariaPlacedFeatureIds.create("cypress_tree");
	public static final ResourceKey<PlacedFeature> DROUGHTROOT_TREE = IcariaPlacedFeatureIds.create("droughtroot_tree");
	public static final ResourceKey<PlacedFeature> FIR_TREE = IcariaPlacedFeatureIds.create("fir_tree");
	public static final ResourceKey<PlacedFeature> LAUREL_TREE = IcariaPlacedFeatureIds.create("laurel_tree");
	public static final ResourceKey<PlacedFeature> OLIVE_TREE = IcariaPlacedFeatureIds.create("olive_tree");
	public static final ResourceKey<PlacedFeature> PLANE_TREE = IcariaPlacedFeatureIds.create("plane_tree");
	public static final ResourceKey<PlacedFeature> POPULUS_TREE = IcariaPlacedFeatureIds.create("populus_tree");

	public static final ResourceKey<PlacedFeature> LUSH_CYPRESS_TREE = IcariaPlacedFeatureIds.create("lush_cypress_tree");
	public static final ResourceKey<PlacedFeature> LUSH_DROUGHTROOT_TREE = IcariaPlacedFeatureIds.create("lush_droughtroot_tree");
	public static final ResourceKey<PlacedFeature> LUSH_FIR_TREE = IcariaPlacedFeatureIds.create("lush_fir_tree");
	public static final ResourceKey<PlacedFeature> LUSH_LAUREL_TREE = IcariaPlacedFeatureIds.create("lush_laurel_tree");
	public static final ResourceKey<PlacedFeature> LUSH_OLIVE_TREE = IcariaPlacedFeatureIds.create("lush_olive_tree");
	public static final ResourceKey<PlacedFeature> LUSH_PLANE_TREE = IcariaPlacedFeatureIds.create("lush_plane_tree");
	public static final ResourceKey<PlacedFeature> LUSH_POPULUS_TREE = IcariaPlacedFeatureIds.create("lush_populus_tree");

	public static final ResourceKey<PlacedFeature> DEAD_CYPRESS_TREE = IcariaPlacedFeatureIds.create("dead_cypress_tree");
	public static final ResourceKey<PlacedFeature> DEAD_DROUGHTROOT_TREE = IcariaPlacedFeatureIds.create("dead_droughtroot_tree");
	public static final ResourceKey<PlacedFeature> DEAD_FIR_TREE = IcariaPlacedFeatureIds.create("dead_fir_tree");
	public static final ResourceKey<PlacedFeature> DEAD_LAUREL_TREE = IcariaPlacedFeatureIds.create("dead_laurel_tree");
	public static final ResourceKey<PlacedFeature> DEAD_OLIVE_TREE = IcariaPlacedFeatureIds.create("dead_olive_tree");
	public static final ResourceKey<PlacedFeature> DEAD_PLANE_TREE = IcariaPlacedFeatureIds.create("dead_plane_tree");
	public static final ResourceKey<PlacedFeature> DEAD_POPULUS_TREE = IcariaPlacedFeatureIds.create("dead_populus_tree");

	public static final ResourceKey<PlacedFeature> FALLEN_CYPRESS_TREE = IcariaPlacedFeatureIds.create("fallen_cypress_tree");
	public static final ResourceKey<PlacedFeature> FALLEN_DROUGHTROOT_TREE = IcariaPlacedFeatureIds.create("fallen_droughtroot_tree");
	public static final ResourceKey<PlacedFeature> FALLEN_FIR_TREE = IcariaPlacedFeatureIds.create("fallen_fir_tree");
	public static final ResourceKey<PlacedFeature> FALLEN_LAUREL_TREE = IcariaPlacedFeatureIds.create("fallen_laurel_tree");
	public static final ResourceKey<PlacedFeature> FALLEN_OLIVE_TREE = IcariaPlacedFeatureIds.create("fallen_olive_tree");
	public static final ResourceKey<PlacedFeature> FALLEN_PLANE_TREE = IcariaPlacedFeatureIds.create("fallen_plane_tree");
	public static final ResourceKey<PlacedFeature> FALLEN_POPULUS_TREE = IcariaPlacedFeatureIds.create("fallen_populus_tree");

	public static final ResourceKey<PlacedFeature> SMALL_CYPRESS_TREE = IcariaPlacedFeatureIds.create("small_cypress_tree");
	public static final ResourceKey<PlacedFeature> SMALL_DROUGHTROOT_TREE = IcariaPlacedFeatureIds.create("small_droughtroot_tree");
	public static final ResourceKey<PlacedFeature> SMALL_FIR_TREE = IcariaPlacedFeatureIds.create("small_fir_tree");
	public static final ResourceKey<PlacedFeature> SMALL_LAUREL_TREE = IcariaPlacedFeatureIds.create("small_laurel_tree");
	public static final ResourceKey<PlacedFeature> SMALL_OLIVE_TREE = IcariaPlacedFeatureIds.create("small_olive_tree");
	public static final ResourceKey<PlacedFeature> SMALL_PLANE_TREE = IcariaPlacedFeatureIds.create("small_plane_tree");
	public static final ResourceKey<PlacedFeature> SMALL_POPULUS_TREE = IcariaPlacedFeatureIds.create("small_populus_tree");

	public static final ResourceKey<PlacedFeature> BLOOMY_VINE = IcariaPlacedFeatureIds.create("bloomy_vine");
	public static final ResourceKey<PlacedFeature> BRANCHY_VINE = IcariaPlacedFeatureIds.create("branchy_vine");
	public static final ResourceKey<PlacedFeature> BRUSHY_VINE = IcariaPlacedFeatureIds.create("brushy_vine");
	public static final ResourceKey<PlacedFeature> DRY_VINE = IcariaPlacedFeatureIds.create("dry_vine");
	public static final ResourceKey<PlacedFeature> REEDY_VINE = IcariaPlacedFeatureIds.create("reedy_vine");
	public static final ResourceKey<PlacedFeature> SWIRLY_VINE = IcariaPlacedFeatureIds.create("swirly_vine");
	public static final ResourceKey<PlacedFeature> THORNY_VINE = IcariaPlacedFeatureIds.create("thorny_vine");

	public static final ResourceKey<PlacedFeature> DENSE_GRASS = IcariaPlacedFeatureIds.create("dense_grass");
	public static final ResourceKey<PlacedFeature> DENSE_GRAIN = IcariaPlacedFeatureIds.create("dense_grain");

	public static final ResourceKey<PlacedFeature> SPARSE_GRASS = IcariaPlacedFeatureIds.create("sparse_grass");
	public static final ResourceKey<PlacedFeature> SPARSE_GRAIN = IcariaPlacedFeatureIds.create("sparse_grain");

	public static final ResourceKey<PlacedFeature> CALCITE_DUST = IcariaPlacedFeatureIds.create("calcite_dust");

	public static final ResourceKey<PlacedFeature> BLINDWEED = IcariaPlacedFeatureIds.create("blindweed");
	public static final ResourceKey<PlacedFeature> CHAMEOMILE = IcariaPlacedFeatureIds.create("chameomile");
	public static final ResourceKey<PlacedFeature> CHARMONDER = IcariaPlacedFeatureIds.create("charmonder");
	public static final ResourceKey<PlacedFeature> CLOVER = IcariaPlacedFeatureIds.create("clover");
	public static final ResourceKey<PlacedFeature> FIREHILT = IcariaPlacedFeatureIds.create("firehilt");
	public static final ResourceKey<PlacedFeature> BLUE_HYDRACINTH = IcariaPlacedFeatureIds.create("blue_hydracinth");
	public static final ResourceKey<PlacedFeature> PURPLE_HYDRACINTH = IcariaPlacedFeatureIds.create("purple_hydracinth");
	public static final ResourceKey<PlacedFeature> LIONFANGS = IcariaPlacedFeatureIds.create("lionfangs");
	public static final ResourceKey<PlacedFeature> SPEARDROPS = IcariaPlacedFeatureIds.create("speardrops");
	public static final ResourceKey<PlacedFeature> PURPLE_STAGHORN = IcariaPlacedFeatureIds.create("purple_staghorn");
	public static final ResourceKey<PlacedFeature> YELLOW_STAGHORN = IcariaPlacedFeatureIds.create("yellow_staghorn");
	public static final ResourceKey<PlacedFeature> BLUE_STORMCOTTON = IcariaPlacedFeatureIds.create("blue_stormcotton");
	public static final ResourceKey<PlacedFeature> PINK_STORMCOTTON = IcariaPlacedFeatureIds.create("pink_stormcotton");
	public static final ResourceKey<PlacedFeature> PURPLE_STORMCOTTON = IcariaPlacedFeatureIds.create("purple_stormcotton");
	public static final ResourceKey<PlacedFeature> SUNKETTLE = IcariaPlacedFeatureIds.create("sunkettle");
	public static final ResourceKey<PlacedFeature> SUNSPONGE = IcariaPlacedFeatureIds.create("sunsponge");
	public static final ResourceKey<PlacedFeature> VOIDLILY = IcariaPlacedFeatureIds.create("voidlily");

	public static final ResourceKey<PlacedFeature> BOLBOS = IcariaPlacedFeatureIds.create("bolbos");
	public static final ResourceKey<PlacedFeature> DATHULLA = IcariaPlacedFeatureIds.create("dathulla");
	public static final ResourceKey<PlacedFeature> MONDANOS = IcariaPlacedFeatureIds.create("mondanos");
	public static final ResourceKey<PlacedFeature> MOTH_AGARIC = IcariaPlacedFeatureIds.create("moth_agaric");
	public static final ResourceKey<PlacedFeature> NAMDRAKE = IcariaPlacedFeatureIds.create("namdrake");
	public static final ResourceKey<PlacedFeature> PSILOCYBOS = IcariaPlacedFeatureIds.create("psilocybos");
	public static final ResourceKey<PlacedFeature> ROWAN = IcariaPlacedFeatureIds.create("rowan");
	public static final ResourceKey<PlacedFeature> WILTED_ELM = IcariaPlacedFeatureIds.create("wilted_elm");

	public static final ResourceKey<PlacedFeature> BLUE_GROUND_FLOWERS = IcariaPlacedFeatureIds.create("blue_ground_flowers");
	public static final ResourceKey<PlacedFeature> CYAN_GROUND_FLOWERS = IcariaPlacedFeatureIds.create("cyan_ground_flowers");
	public static final ResourceKey<PlacedFeature> PINK_GROUND_FLOWERS = IcariaPlacedFeatureIds.create("pink_ground_flowers");
	public static final ResourceKey<PlacedFeature> PURPLE_GROUND_FLOWERS = IcariaPlacedFeatureIds.create("purple_ground_flowers");
	public static final ResourceKey<PlacedFeature> RED_GROUND_FLOWERS = IcariaPlacedFeatureIds.create("red_ground_flowers");
	public static final ResourceKey<PlacedFeature> WHITE_GROUND_FLOWERS = IcariaPlacedFeatureIds.create("white_ground_flowers");

	public static final ResourceKey<PlacedFeature> PALM_FERN = IcariaPlacedFeatureIds.create("palm_fern");

	public static final ResourceKey<PlacedFeature> WHITE_BROMELIA = IcariaPlacedFeatureIds.create("white_bromelia");
	public static final ResourceKey<PlacedFeature> ORANGE_BROMELIA = IcariaPlacedFeatureIds.create("orange_bromelia");
	public static final ResourceKey<PlacedFeature> PINK_BROMELIA = IcariaPlacedFeatureIds.create("pink_bromelia");
	public static final ResourceKey<PlacedFeature> PURPLE_BROMELIA = IcariaPlacedFeatureIds.create("purple_bromelia");

	public static final ResourceKey<PlacedFeature> GREEN_GROUND_SHROOMS = IcariaPlacedFeatureIds.create("green_ground_shrooms");
	public static final ResourceKey<PlacedFeature> BROWN_GROUND_SHROOMS = IcariaPlacedFeatureIds.create("brown_ground_shrooms");
	public static final ResourceKey<PlacedFeature> LARGE_BROWN_GROUND_SHROOMS = IcariaPlacedFeatureIds.create("large_brown_ground_shrooms");

	public static final ResourceKey<PlacedFeature> CARDON_CACTUS = IcariaPlacedFeatureIds.create("cardon_cactus");

	public static final ResourceKey<PlacedFeature> STRAWBERRY_BUSH = IcariaPlacedFeatureIds.create("strawberry_bush");

	public static final ResourceKey<PlacedFeature> DRY_LAKE = IcariaPlacedFeatureIds.create("dry_lake");
	public static final ResourceKey<PlacedFeature> MEDITERRANEAN_WATER_LAKE = IcariaPlacedFeatureIds.create("mediterranean_water_lake");

	public static final ResourceKey<PlacedFeature> RUIN = IcariaPlacedFeatureIds.create("ruin");
	public static final ResourceKey<PlacedFeature> VILLAGE = IcariaPlacedFeatureIds.create("village");

	public static ResourceKey<PlacedFeature> create(String pName) {
		return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
