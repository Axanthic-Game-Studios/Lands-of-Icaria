package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.resources.Identifier;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaIdentifiers {
	public static final Identifier ICARIA = Identifier.fromNamespaceAndPath(IcariaIds.ID, "icaria");

	// ATTRIBUTE MODIFIER

	public static final Identifier BASE_ATTACK_RANGE_ID = Identifier.fromNamespaceAndPath(IcariaIds.ID, "base_attack_range");

	// BLOCK

	public static final Identifier POWDER_SNOW = Identifier.fromNamespaceAndPath(IcariaIds.MC, "block/powder_snow");
	public static final Identifier WATER = Identifier.fromNamespaceAndPath(IcariaIds.MC, "block/water_still");
	public static final Identifier CONCOCTION_FAST = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/kettle_concoction_fast");
	public static final Identifier CONCOCTION_SLOW = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/kettle_concoction_slow");
	public static final Identifier FLOWING_MEDITERRANEAN_WATER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/flowing_mediterranean_water");
	public static final Identifier MEDITERRANEAN_WATER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/mediterranean_water");
	public static final Identifier MEDITERRANEAN_WATER_OVERLAY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/mediterranean_water_overlay");
	public static final Identifier ONION = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/trough_onion");
	public static final Identifier SPELT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/spelt_block_top");
	public static final Identifier SUNSTONE_BRICKS = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/sunstone_bricks");
	public static final Identifier VINEBERRIES = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block/trough_vineberries");

	// CONTEXT KEY

	public static final Identifier BARREL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "barrel");
	public static final Identifier BARREL_BLOCK_MODEL_RENDER_STATE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "barrel_block_model_render_state");
	public static final Identifier LOOT_VASE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "loot_vase");
	public static final Identifier LOOT_VASE_BLOCK_MODEL_RENDER_STATE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "loot_vase_block_model_render_state");

	// EFFECT

	public static final Identifier FREEZING_EFFECT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "effect.freezing");

	// ENTITY

	public static final Identifier AETERNAE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/aeternae.png");
	public static final Identifier ARACHNE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/arachne.png");
	public static final Identifier ARACHNE_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/arachne_emissive.png");
	public static final Identifier ARACHNE_DRONE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/arachne_drone.png");
	public static final Identifier ARACHNE_DRONE_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/arachne_drone_emissive.png");
	public static final Identifier ARGAN_HOUND = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/argan_hound.png");
	public static final Identifier ARGAN_HOUND_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/argan_hound_emissive.png");
	public static final Identifier CAPELLA = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/capella.png");
	public static final Identifier CATOBLEPAS = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/catoblepas.png");
	public static final Identifier CERVER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/cerver.png");
	public static final Identifier CROCOTTA = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/crocotta.png");
	public static final Identifier FEESH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/feesh/blue_gray.png");
	public static final Identifier FICHE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/fiche/blue_red.png");
	public static final Identifier FISSHH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/fisshh/blue_brown.png");
	public static final Identifier FYSH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/fysh/blue.png");
	public static final Identifier CYPRESS_FOREST_HAG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/cypress_forest_hag.png");
	public static final Identifier CYPRESS_FOREST_HAG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/cypress_forest_hag_emissive.png");
	public static final Identifier DROUGHTROOT_FOREST_HAG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/droughtroot_forest_hag.png");
	public static final Identifier DROUGHTROOT_FOREST_HAG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/droughtroot_forest_hag_emissive.png");
	public static final Identifier FIR_FOREST_HAG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/fir_forest_hag.png");
	public static final Identifier FIR_FOREST_HAG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/fir_forest_hag_emissive.png");
	public static final Identifier LAUREL_FOREST_HAG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/laurel_forest_hag.png");
	public static final Identifier LAUREL_FOREST_HAG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/laurel_forest_hag_emissive.png");
	public static final Identifier OLIVE_FOREST_HAG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/olive_forest_hag.png");
	public static final Identifier OLIVE_FOREST_HAG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/olive_forest_hag_emissive.png");
	public static final Identifier PLANE_FOREST_HAG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/plane_forest_hag.png");
	public static final Identifier PLANE_FOREST_HAG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/plane_forest_hag_emissive.png");
	public static final Identifier POPULUS_FOREST_HAG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/populus_forest_hag.png");
	public static final Identifier POPULUS_FOREST_HAG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/populus_forest_hag_emissive.png");
	public static final Identifier HYLIASTER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/hyliaster.png");
	public static final Identifier HYLIASTER_TRANSLUCENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/hyliaster_translucent.png");
	public static final Identifier ENDER_JELLYFISH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/ender_jellyfish.png");
	public static final Identifier ENDER_JELLYFISH_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/ender_jellyfish_emissive.png");
	public static final Identifier FIRE_JELLYFISH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/fire_jellyfish.png");
	public static final Identifier FIRE_JELLYFISH_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/fire_jellyfish_emissive.png");
	public static final Identifier NATURE_JELLYFISH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/nature_jellyfish.png");
	public static final Identifier NATURE_JELLYFISH_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/nature_jellyfish_emissive.png");
	public static final Identifier VOID_JELLYFISH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/void_jellyfish.png");
	public static final Identifier VOID_JELLYFISH_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/void_jellyfish_emissive.png");
	public static final Identifier WATER_JELLYFISH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/water_jellyfish.png");
	public static final Identifier WATER_JELLYFISH_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/water_jellyfish_emissive.png");
	public static final Identifier MYRMEKE_DRONE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/myrmeke_drone.png");
	public static final Identifier MYRMEKE_DRONE_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/myrmeke_drone_emissive.png");
	public static final Identifier MYRMEKE_SOLDIER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/myrmeke_soldier.png");
	public static final Identifier MYRMEKE_SOLDIER_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/myrmeke_soldier_emissive.png");
	public static final Identifier MYRMEKE_QUEEN = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/myrmeke_queen.png");
	public static final Identifier MYRMEKE_QUEEN_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/myrmeke_queen_emissive.png");
	public static final Identifier CAPTAIN_REVENANT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/captain_revenant.png");
	public static final Identifier CAPTAIN_REVENANT_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/captain_revenant_emissive.png");
	public static final Identifier CIVILIAN_REVENANT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/civilian_revenant.png");
	public static final Identifier CIVILIAN_REVENANT_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/civilian_revenant_emissive.png");
	public static final Identifier CRAWLER_REVENANT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/crawler_revenant.png");
	public static final Identifier CRAWLER_REVENANT_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/crawler_revenant_emissive.png");
	public static final Identifier OVERGROWN_REVENANT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/overgrown_revenant.png");
	public static final Identifier OVERGROWN_REVENANT_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/overgrown_revenant_emissive.png");
	public static final Identifier PYROMANCER_REVENANT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/pyromancer_revenant.png");
	public static final Identifier PYROMANCER_REVENANT_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/pyromancer_revenant_emissive.png");
	public static final Identifier NETHER_PYROMANCER_REVENANT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/nether_pyromancer_revenant.png");
	public static final Identifier NETHER_PYROMANCER_REVENANT_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/nether_pyromancer_revenant_emissive.png");
	public static final Identifier SOLDIER_REVENANT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/soldier_revenant.png");
	public static final Identifier SOLDIER_REVENANT_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/soldier_revenant_emissive.png");
	public static final Identifier SCORPION = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/scorpion.png");
	public static final Identifier SCORPION_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/scorpion_emissive.png");
	public static final Identifier CLUSTER_SLUG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/cluster_slug.png");
	public static final Identifier CLUSTER_SLUG_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/cluster_slug_emissive.png");
	public static final Identifier FOREST_SNULL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/forest_snull.png");
	public static final Identifier FOREST_SNULL_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/forest_snull_emissive.png");
	public static final Identifier SNULL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/snull.png");
	public static final Identifier SNULL_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/snull_emissive.png");
	public static final Identifier SNULL_EYES = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/snull_eyes.png");
	public static final Identifier SNULL_SANS = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/snull_sans.png");
	public static final Identifier SOLIFUGAE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/solifugae.png");
	public static final Identifier SOLIFUGAE_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/solifugae_emissive.png");
	public static final Identifier THOG = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/thog.png");
	public static final Identifier VINEGAROON = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/vinegaroon.png");
	public static final Identifier VINEGAROON_EMISSIVE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/entity/vinegaroon_emissive.png");

	// EQUIPMENT

	public static final Identifier AETERNAE_HIDE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "aeternae_hide");
	public static final Identifier CHALKOS = Identifier.fromNamespaceAndPath(IcariaIds.ID, "chalkos");
	public static final Identifier KASSITEROS = Identifier.fromNamespaceAndPath(IcariaIds.ID, "kassiteros");
	public static final Identifier ORICHALCUM = Identifier.fromNamespaceAndPath(IcariaIds.ID, "orichalcum");
	public static final Identifier VANADIUMSTEEL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "vanadiumsteel");
	public static final Identifier LAUREL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "laurel");

	public static final Identifier ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "arachne_string_carpet");
	public static final Identifier WHITE_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "white_arachne_string_carpet");
	public static final Identifier LIGHT_GRAY_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "light_gray_arachne_string_carpet");
	public static final Identifier GRAY_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "gray_arachne_string_carpet");
	public static final Identifier BLACK_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "black_arachne_string_carpet");
	public static final Identifier BROWN_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "brown_arachne_string_carpet");
	public static final Identifier RED_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "red_arachne_string_carpet");
	public static final Identifier ORANGE_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "orange_arachne_string_carpet");
	public static final Identifier YELLOW_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "yellow_arachne_string_carpet");
	public static final Identifier LIME_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "lime_arachne_string_carpet");
	public static final Identifier GREEN_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "green_arachne_string_carpet");
	public static final Identifier CYAN_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "cyan_arachne_string_carpet");
	public static final Identifier LIGHT_BLUE_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "light_blue_arachne_string_carpet");
	public static final Identifier BLUE_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "blue_arachne_string_carpet");
	public static final Identifier PURPLE_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "purple_arachne_string_carpet");
	public static final Identifier MAGENTA_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "magenta_arachne_string_carpet");
	public static final Identifier PINK_ARACHNE_STRING_CARPET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "pink_arachne_string_carpet");

	// GUI

	public static final Identifier CHEST_LABEL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/chest_label.png");
	public static final Identifier FORGE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/forge.png");
	public static final Identifier FORGING_RECIPE_CATEGORY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/forging_recipe_category.png");
	public static final Identifier GRINDER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/grinder.png");
	public static final Identifier GRINDING_RECIPE_CATEGORY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/grinding_recipe_category.png");
	public static final Identifier KILN = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/kiln.png");
	public static final Identifier FIRING_RECIPE_CATEGORY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/firing_recipe_category.png");
	public static final Identifier STORAGE_VASE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/gui/storage_vase.png");

	// LAYER

	public static final Identifier AETERNAE_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "aeternae");
	public static final Identifier AETERNAE_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "aeternae_skull");
	public static final Identifier ARACHNE_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "arachne");
	public static final Identifier ARACHNE_DRONE_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "arachne_drone");
	public static final Identifier ARGAN_HOUND_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "argan_hound");
	public static final Identifier ARGAN_HOUND_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "argan_hound_skull");
	public static final Identifier CAPELLA_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "capella");
	public static final Identifier CAPELLA_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "capella_skull");
	public static final Identifier CATOBLEPAS_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "catoblepas");
	public static final Identifier CATOBLEPAS_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "catoblepas_skull");
	public static final Identifier CERVER_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "cerver");
	public static final Identifier CERVER_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "cerver_skull");
	public static final Identifier CROCOTTA_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "crocotta");
	public static final Identifier CROCOTTA_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "crocotta_skull");
	public static final Identifier CYPRESS_FOREST_HAG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "cypress_forest_hag");
	public static final Identifier CYPRESS_FOREST_HAG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "cypress_forest_hag_skull");
	public static final Identifier DROUGHTROOT_FOREST_HAG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "droughtroot_forest_hag");
	public static final Identifier DROUGHTROOT_FOREST_HAG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "droughtroot_forest_hag_skull");
	public static final Identifier FIR_FOREST_HAG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "fir_forest_hag");
	public static final Identifier FIR_FOREST_HAG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "fir_forest_hag_skull");
	public static final Identifier LAUREL_FOREST_HAG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "laurel_forest_hag");
	public static final Identifier LAUREL_FOREST_HAG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "laurel_forest_hag_skull");
	public static final Identifier OLIVE_FOREST_HAG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "olive_forest_hag");
	public static final Identifier OLIVE_FOREST_HAG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "olive_forest_hag_skull");
	public static final Identifier PLANE_FOREST_HAG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "plane_forest_hag");
	public static final Identifier PLANE_FOREST_HAG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "plane_forest_hag_skull");
	public static final Identifier POPULUS_FOREST_HAG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "populus_forest_hag");
	public static final Identifier POPULUS_FOREST_HAG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "populus_forest_hag_skull");
	public static final Identifier HYLIASTER_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "hyliaster");
	public static final Identifier ENDER_JELLYFISH_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "ender_jellyfish");
	public static final Identifier FIRE_JELLYFISH_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "fire_jellyfish");
	public static final Identifier NATURE_JELLYFISH_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "nature_jellyfish");
	public static final Identifier VOID_JELLYFISH_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "void_jellyfish");
	public static final Identifier WATER_JELLYFISH_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "water_jellyfish");
	public static final Identifier MYRMEKE_DRONE_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "myrmeke_drone");
	public static final Identifier MYRMEKE_SOLDIER_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "myrmeke_soldier");
	public static final Identifier MYRMEKE_QUEEN_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "myrmeke_queen");
	public static final Identifier ORICHALCUM_HELMET_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "orichalcum_helmet");
	public static final Identifier CAPTAIN_REVENANT_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "captain_revenant");
	public static final Identifier CIVILIAN_REVENANT_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "civilian_revenant");
	public static final Identifier CRAWLER_REVENANT_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "crawler_revenant");
	public static final Identifier OVERGROWN_REVENANT_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "overgrown_revenant");
	public static final Identifier PYROMANCER_REVENANT_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "pyromancer_revenant");
	public static final Identifier NETHER_PYROMANCER_REVENANT_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "nether_pyromancer_revenant");
	public static final Identifier SOLDIER_REVENANT_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "soldier_revenant");
	public static final Identifier REVENANT_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "revenant_skull");
	public static final Identifier SCORPION_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "scorpion");
	public static final Identifier CLUSTER_SLUG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "cluster_slug");
	public static final Identifier FOREST_SNULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "forest_snull");
	public static final Identifier SNULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "snull");
	public static final Identifier SOLIFUGAE_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "solifugae");
	public static final Identifier THOG_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "thog");
	public static final Identifier THOG_SKULL_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "thog_skull");
	public static final Identifier VINEGAROON_LAYER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "vinegaroon");

	// MISC

	public static final Identifier MEDITERRANEAN_WATER_UNDERWATER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/misc/mediterranean_water_underwater.png");
	public static final Identifier SPELL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "textures/misc/spell.png");

	// PACKET TYPE

	public static final Identifier BARREL_PAYLOAD_TYPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "barrel");
	public static final Identifier CHEST_LABEL_PAYLOAD_TYPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "chest_label");
	public static final Identifier GRINDER_PAYLOAD_TYPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "grinder");
	public static final Identifier LOOT_VASE_PAYLOAD_TYPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "loot_vase");
	public static final Identifier TOTEM_PAYLOAD_TYPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "totem");

	// PARTICLE

	public static final Identifier BUBBLE_PARTICLE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "bubble");
	public static final Identifier GENERIC_PARTICLE = Identifier.fromNamespaceAndPath(IcariaIds.MC, "generic");
	public static final Identifier STEAM_PARTICLE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "steam");

	// PIPELINE

	public static final Identifier ADDITIVE_RENDER_PIPELINE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "pipeline/additive");
	public static final Identifier ADDITIVE_TEXTURED_RENDER_PIPELINE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "pipeline/additive_textured");

	// RECIPE

	public static final Identifier AETERNAE_HIDE_BOOTS_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "aeternae_hide_boots");
	public static final Identifier AETERNAE_HIDE_CHESTPLATE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "aeternae_hide_chestplate");
	public static final Identifier AETERNAE_HIDE_HELMET_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "aeternae_hide_helmet");
	public static final Identifier AETERNAE_HIDE_LEGGINGS_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "aeternae_hide_leggings");
	public static final Identifier CHEST_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "chest");
	public static final Identifier CYPRESS_CRAFTING_TABLE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "cypress_crafting_table_from_cypress_planks");
	public static final Identifier DROUGHTROOT_CRAFTING_TABLE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "droughtroot_crafting_table_from_droughtroot_planks");
	public static final Identifier FIR_CRAFTING_TABLE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "fir_crafting_table_from_fir_planks");
	public static final Identifier LAUREL_CRAFTING_TABLE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "laurel_crafting_table_from_laurel_planks");
	public static final Identifier OLIVE_CRAFTING_TABLE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "olive_crafting_table_from_olive_planks");
	public static final Identifier PLANE_CRAFTING_TABLE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "plane_crafting_table_from_plane_planks");
	public static final Identifier POPULUS_CRAFTING_TABLE_RECIPE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "populus_crafting_table_from_populus_planks");

	// RENDERER

	public static final Identifier SCROLL_RENDERER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "scroll");

	// SHADER

	public static final Identifier ADDITIVE_SHADER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "additive");
	public static final Identifier ADDITIVE_TEXTURED_SHADER = Identifier.fromNamespaceAndPath(IcariaIds.ID, "additive_textured");

	// SOUND

	public static final Identifier BARREL_BREAK = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.barrel.break");
	public static final Identifier COOKIE_JAR_FILL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.cookie_jar.fill");
	public static final Identifier GRINDER_GRIND = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.grinder.grind");
	public static final Identifier KETTLE_CONCOCT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.kettle.concoct");
	public static final Identifier KETTLE_CONSUME = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.kettle.consume");
	public static final Identifier KETTLE_POP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.kettle.pop");
	public static final Identifier LIGNITE_RUBBLE_CRACKLE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.lignite_rubble.crackle");
	public static final Identifier POTTERY_BREAK = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.pottery.break");
	public static final Identifier ROTTEN_BONE_LADDER_BREAK = Identifier.fromNamespaceAndPath(IcariaIds.ID, "block.rotten_bone_ladder.break");
	public static final Identifier AETERNAE_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.aeternae.ambient");
	public static final Identifier AETERNAE_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.aeternae.death");
	public static final Identifier AETERNAE_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.aeternae.hurt");
	public static final Identifier AETERNAE_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.aeternae.step");
	public static final Identifier ARACHNE_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne.ambient");
	public static final Identifier ARACHNE_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne.death");
	public static final Identifier ARACHNE_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne.hurt");
	public static final Identifier ARACHNE_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne.step");
	public static final Identifier ARACHNE_DRONE_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne_drone.ambient");
	public static final Identifier ARACHNE_DRONE_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne_drone.death");
	public static final Identifier ARACHNE_DRONE_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne_drone.hurt");
	public static final Identifier ARACHNE_DRONE_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.arachne_drone.step");
	public static final Identifier ARGAN_HOUND_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.argan_hound.ambient");
	public static final Identifier ARGAN_HOUND_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.argan_hound.death");
	public static final Identifier ARGAN_HOUND_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.argan_hound.hurt");
	public static final Identifier ARGAN_HOUND_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.argan_hound.step");
	public static final Identifier CAPELLA_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.capella.ambient");
	public static final Identifier CAPELLA_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.capella.death");
	public static final Identifier CAPELLA_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.capella.hurt");
	public static final Identifier CAPELLA_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.capella.step");
	public static final Identifier CATOBLEPAS_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.catoblepas.ambient");
	public static final Identifier CATOBLEPAS_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.catoblepas.death");
	public static final Identifier CATOBLEPAS_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.catoblepas.hurt");
	public static final Identifier CATOBLEPAS_MILK = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.catoblepas.milk");
	public static final Identifier CATOBLEPAS_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.catoblepas.step");
	public static final Identifier CERVER_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.cerver.ambient");
	public static final Identifier CERVER_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.cerver.death");
	public static final Identifier CERVER_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.cerver.hurt");
	public static final Identifier CROCOTTA_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.crocotta.ambient");
	public static final Identifier CROCOTTA_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.crocotta.death");
	public static final Identifier CROCOTTA_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.crocotta.hurt");
	public static final Identifier CROCOTTA_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.crocotta.step");
	public static final Identifier FISH_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.fish.ambient");
	public static final Identifier FISH_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.fish.death");
	public static final Identifier FISH_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.fish.hurt");
	public static final Identifier FOREST_HAG_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.forest_hag.ambient");
	public static final Identifier FOREST_HAG_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.forest_hag.death");
	public static final Identifier FOREST_HAG_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.forest_hag.hurt");
	public static final Identifier FOREST_HAG_SCREAM = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.forest_hag.scream");
	public static final Identifier FOREST_HAG_TARGET = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.forest_hag.target");
	public static final Identifier HYLIASTER_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.hyliaster.death");
	public static final Identifier HYLIASTER_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.hyliaster.hurt");
	public static final Identifier HYLIASTER_SQUISH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.hyliaster.squish");
	public static final Identifier JELLYFISH_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.jellyfish.ambient");
	public static final Identifier JELLYFISH_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.jellyfish.death");
	public static final Identifier JELLYFISH_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.jellyfish.hurt");
	public static final Identifier MYRMEKE_DRONE_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_drone.ambient");
	public static final Identifier MYRMEKE_DRONE_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_drone.death");
	public static final Identifier MYRMEKE_DRONE_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_drone.hurt");
	public static final Identifier MYRMEKE_DRONE_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_drone.step");
	public static final Identifier MYRMEKE_SOLDIER_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_soldier.ambient");
	public static final Identifier MYRMEKE_SOLDIER_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_soldier.death");
	public static final Identifier MYRMEKE_SOLDIER_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_soldier.hurt");
	public static final Identifier MYRMEKE_SOLDIER_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_soldier.step");
	public static final Identifier MYRMEKE_QUEEN_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_queen.ambient");
	public static final Identifier MYRMEKE_QUEEN_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_queen.death");
	public static final Identifier MYRMEKE_QUEEN_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_queen.hurt");
	public static final Identifier MYRMEKE_QUEEN_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.myrmeke_queen.step");
	public static final Identifier PLAYER_SNIFF = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.player.sniff");
	public static final Identifier REVENANT_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.revenant.ambient");
	public static final Identifier REVENANT_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.revenant.death");
	public static final Identifier REVENANT_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.revenant.hurt");
	public static final Identifier REVENANT_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.revenant.step");
	public static final Identifier CAPTAIN_REVENANT_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.captain_revenant.death");
	public static final Identifier CAPTAIN_REVENANT_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.captain_revenant.hurt");
	public static final Identifier CAPTAIN_REVENANT_RALLY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.captain_revenant.rally");
	public static final Identifier CAPTAIN_REVENANT_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.captain_revenant.step");
	public static final Identifier NETHER_PYROMANCER_REVENANT_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.nether_pyromancer_revenant.ambient");
	public static final Identifier SOLDIER_REVENANT_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.soldier_revenant.death");
	public static final Identifier SOLDIER_REVENANT_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.soldier_revenant.hurt");
	public static final Identifier SOLDIER_REVENANT_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.soldier_revenant.step");
	public static final Identifier SCORPION_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.scorpion.ambient");
	public static final Identifier SCORPION_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.scorpion.death");
	public static final Identifier SCORPION_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.scorpion.hurt");
	public static final Identifier SCORPION_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.scorpion.step");
	public static final Identifier SLUG_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.slug.ambient");
	public static final Identifier SLUG_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.slug.death");
	public static final Identifier SLUG_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.slug.hurt");
	public static final Identifier SNULL_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.snull.ambient");
	public static final Identifier SNULL_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.snull.death");
	public static final Identifier SNULL_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.snull.hurt");
	public static final Identifier SOLIFUGAE_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.solifugae.ambient");
	public static final Identifier SOLIFUGAE_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.solifugae.death");
	public static final Identifier SOLIFUGAE_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.solifugae.hurt");
	public static final Identifier SOLIFUGAE_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.solifugae.step");
	public static final Identifier THOG_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.thog.ambient");
	public static final Identifier THOG_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.thog.death");
	public static final Identifier THOG_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.thog.hurt");
	public static final Identifier THOG_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.thog.step");
	public static final Identifier VINEGAROON_AMBIENT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.vinegaroon.ambient");
	public static final Identifier VINEGAROON_DEATH = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.vinegaroon.death");
	public static final Identifier VINEGAROON_HURT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.vinegaroon.hurt");
	public static final Identifier VINEGAROON_SHOOT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.vinegaroon.shoot");
	public static final Identifier VINEGAROON_STEP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "entity.vinegaroon.step");
	public static final Identifier AETERNAE_HIDE_ARMOR_EQUIP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.aeternae_hide_armor.equip");
	public static final Identifier CHALKOS_ARMOR_EQUIP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.chalkos_armor.equip");
	public static final Identifier KASSITEROS_ARMOR_EQUIP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.kassiteros_armor.equip");
	public static final Identifier ORICHALCUM_ARMOR_EQUIP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.orichalcum_armor.equip");
	public static final Identifier VANADIUMSTEEL_ARMOR_EQUIP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.vanadiumsteel.equip");
	public static final Identifier LAUREL_WREATH_EQUIP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.laurel_wreath.equip");
	public static final Identifier BIDENT_HIT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.bident.hit");
	public static final Identifier BIDENT_HIT_GROUND = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.bident.hit_ground");
	public static final Identifier BIDENT_THROW = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.bident.throw");
	public static final Identifier CALCITE_FERTILIZE = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.calcite.fertilize");
	public static final Identifier CAPELLA_HORN_FAIL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.capella_horn.fail");
	public static final Identifier CARPET_APPLY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.carpet.apply");
	public static final Identifier CARPET_CLEAR = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.carpet.clear");
	public static final Identifier CHEST_LABEL_APPLY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.chest_label.apply");
	public static final Identifier CHEST_LABEL_CLEAR = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.chest_label.clear");
	public static final Identifier GREEK_FIRE_GRENADE_THROW = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.greek_fire_grenade.throw");
	public static final Identifier OLIVES_POP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.olives.pop");
	public static final Identifier SPELL_SHOOT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.spell.shoot");
	public static final Identifier BUBBLE_SPELL_POP = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.bubble_spell.pop");
	public static final Identifier BUBBLE_SPELL_SHOOT = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.bubble_spell.shoot");
	public static final Identifier TROUGH_EMPTY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.trough.empty");
	public static final Identifier TROUGH_FILL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.trough.fill");
	public static final Identifier VIAL_EMPTY = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.vial.empty");
	public static final Identifier VIAL_FILL = Identifier.fromNamespaceAndPath(IcariaIds.ID, "item.vial.fill");
}
