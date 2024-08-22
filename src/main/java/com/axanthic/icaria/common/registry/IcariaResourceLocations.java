package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaResourceLocations {
	public static final ResourceLocation ICARIA = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "icaria");
	public static final ResourceLocation THROWING = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "throwing");

	// ADVANCEMENT

	public static final ResourceLocation BACKGROUND = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/block/sunstone_bricks.png");

	// ATTRIBUTE MODIFIER

	public static final ResourceLocation BASE_ATTACK_RANGE_ID = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "base_attack_range");

	// BLOCK

	public static final ResourceLocation CONCOCTION_FAST = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block/kettle_concoction_fast");
	public static final ResourceLocation CONCOCTION_SLOW = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block/kettle_concoction_slow");
	public static final ResourceLocation FLOWING_MEDITERRANEAN_WATER_TEXTURE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block/flowing_mediterranean_water");
	public static final ResourceLocation MEDITERRANEAN_WATER_TEXTURE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block/mediterranean_water");

	// EFFECT

	public static final ResourceLocation FREEZING = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "effect.freezing");

	// ENTITY

	public static final ResourceLocation AETERNAE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/aeternae.png");
	public static final ResourceLocation ARACHNE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/arachne.png");
	public static final ResourceLocation ARACHNE_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/arachne_emissive.png");
	public static final ResourceLocation ARACHNE_DRONE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/arachne_drone.png");
	public static final ResourceLocation ARACHNE_DRONE_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/arachne_drone_emissive.png");
	public static final ResourceLocation ARGAN_HOUND = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/argan_hound.png");
	public static final ResourceLocation ARGAN_HOUND_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/argan_hound_emissive.png");
	public static final ResourceLocation CAPELLA = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/capella.png");
	public static final ResourceLocation CATOBLEPAS = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/catoblepas.png");
	public static final ResourceLocation CERVER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/cerver.png");
	public static final ResourceLocation CROCOTTA = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/crocotta.png");
	public static final ResourceLocation CYPRESS_FOREST_HAG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/cypress_forest_hag.png");
	public static final ResourceLocation CYPRESS_FOREST_HAG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/cypress_forest_hag_emissive.png");
	public static final ResourceLocation DROUGHTROOT_FOREST_HAG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/droughtroot_forest_hag.png");
	public static final ResourceLocation DROUGHTROOT_FOREST_HAG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/droughtroot_forest_hag_emissive.png");
	public static final ResourceLocation FIR_FOREST_HAG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/fir_forest_hag.png");
	public static final ResourceLocation FIR_FOREST_HAG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/fir_forest_hag_emissive.png");
	public static final ResourceLocation LAUREL_FOREST_HAG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/laurel_forest_hag.png");
	public static final ResourceLocation LAUREL_FOREST_HAG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/laurel_forest_hag_emissive.png");
	public static final ResourceLocation OLIVE_FOREST_HAG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/olive_forest_hag.png");
	public static final ResourceLocation OLIVE_FOREST_HAG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/olive_forest_hag_emissive.png");
	public static final ResourceLocation PLANE_FOREST_HAG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/plane_forest_hag.png");
	public static final ResourceLocation PLANE_FOREST_HAG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/plane_forest_hag_emissive.png");
	public static final ResourceLocation POPULUS_FOREST_HAG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/populus_forest_hag.png");
	public static final ResourceLocation POPULUS_FOREST_HAG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/populus_forest_hag_emissive.png");
	public static final ResourceLocation HYLIASTER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/hyliaster.png");
	public static final ResourceLocation HYLIASTER_TRANSLUCENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/hyliaster_translucent.png");
	public static final ResourceLocation ENDER_JELLYFISH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/ender_jellyfish.png");
	public static final ResourceLocation ENDER_JELLYFISH_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/ender_jellyfish_emissive.png");
	public static final ResourceLocation FIRE_JELLYFISH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/fire_jellyfish.png");
	public static final ResourceLocation FIRE_JELLYFISH_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/fire_jellyfish_emissive.png");
	public static final ResourceLocation NATURE_JELLYFISH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/nature_jellyfish.png");
	public static final ResourceLocation NATURE_JELLYFISH_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/nature_jellyfish_emissive.png");
	public static final ResourceLocation VOID_JELLYFISH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/void_jellyfish.png");
	public static final ResourceLocation VOID_JELLYFISH_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/void_jellyfish_emissive.png");
	public static final ResourceLocation WATER_JELLYFISH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/water_jellyfish.png");
	public static final ResourceLocation WATER_JELLYFISH_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/water_jellyfish_emissive.png");
	public static final ResourceLocation MYRMEKE_DRONE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/myrmeke_drone.png");
	public static final ResourceLocation MYRMEKE_DRONE_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/myrmeke_drone_emissive.png");
	public static final ResourceLocation MYRMEKE_SOLDIER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/myrmeke_soldier.png");
	public static final ResourceLocation MYRMEKE_SOLDIER_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/myrmeke_soldier_emissive.png");
	public static final ResourceLocation MYRMEKE_QUEEN = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/myrmeke_queen.png");
	public static final ResourceLocation MYRMEKE_QUEEN_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/myrmeke_queen_emissive.png");
	public static final ResourceLocation CAPTAIN_REVENANT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/captain_revenant.png");
	public static final ResourceLocation CAPTAIN_REVENANT_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/captain_revenant_emissive.png");
	public static final ResourceLocation CIVILIAN_REVENANT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/civilian_revenant.png");
	public static final ResourceLocation CIVILIAN_REVENANT_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/civilian_revenant_emissive.png");
	public static final ResourceLocation CRAWLER_REVENANT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/crawler_revenant.png");
	public static final ResourceLocation CRAWLER_REVENANT_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/crawler_revenant_emissive.png");
	public static final ResourceLocation OVERGROWN_REVENANT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/overgrown_revenant.png");
	public static final ResourceLocation OVERGROWN_REVENANT_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/overgrown_revenant_emissive.png");
	public static final ResourceLocation PYROMANCER_REVENANT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/pyromancer_revenant.png");
	public static final ResourceLocation PYROMANCER_REVENANT_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/pyromancer_revenant_emissive.png");
	public static final ResourceLocation NETHER_PYROMANCER_REVENANT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/nether_pyromancer_revenant.png");
	public static final ResourceLocation NETHER_PYROMANCER_REVENANT_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/nether_pyromancer_revenant_emissive.png");
	public static final ResourceLocation SOLDIER_REVENANT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/soldier_revenant.png");
	public static final ResourceLocation SOLDIER_REVENANT_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/soldier_revenant_emissive.png");
	public static final ResourceLocation SCORPION = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/scorpion.png");
	public static final ResourceLocation SCORPION_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/scorpion_emissive.png");
	public static final ResourceLocation CRYSTAL_SLUG = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/crystal_slug.png");
	public static final ResourceLocation CRYSTAL_SLUG_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/crystal_slug_emissive.png");
	public static final ResourceLocation FOREST_SNULL = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/forest_snull.png");
	public static final ResourceLocation FOREST_SNULL_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/forest_snull_emissive.png");
	public static final ResourceLocation SNULL = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/snull.png");
	public static final ResourceLocation SNULL_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/snull_emissive.png");
	public static final ResourceLocation SNULL_EYES = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/snull_eyes.png");
	public static final ResourceLocation SNULL_SANS = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/snull_sans.png");
	public static final ResourceLocation SOLIFUGAE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/solifugae.png");
	public static final ResourceLocation SOLIFUGAE_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/solifugae_emissive.png");
	public static final ResourceLocation SOW = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/sow.png");
	public static final ResourceLocation VINEGAROON = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/vinegaroon.png");
	public static final ResourceLocation VINEGAROON_EMISSIVE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/vinegaroon_emissive.png");

	// ENVIRONMENT

	public static final ResourceLocation MOON = ResourceLocation.fromNamespaceAndPath(IcariaIdents.MC, "textures/environment/moon_phases.png");
	public static final ResourceLocation SUN = ResourceLocation.fromNamespaceAndPath(IcariaIdents.MC, "textures/environment/sun.png");

	// GUI

	public static final ResourceLocation CHEST_LABEL = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/chest_label.png");
	public static final ResourceLocation FORGE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/forge.png");
	public static final ResourceLocation FORGE_CATEGORY = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/jei/forge.png");
	public static final ResourceLocation GRINDER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/grinder.png");
	public static final ResourceLocation GRINDER_CATEGORY = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/jei/grinder.png");
	public static final ResourceLocation KILN = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/kiln.png");
	public static final ResourceLocation KILN_CATEGORY = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/jei/kiln.png");
	public static final ResourceLocation STORAGE_VASE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/gui/storage_vase.png");

	// ITEM

	public static final ResourceLocation SCROLL = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item/scroll");

	// LAYER

	public static final ResourceLocation AETERNAE_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "aeternae");
	public static final ResourceLocation AETERNAE_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "aeternae_skull");
	public static final ResourceLocation ARACHNE_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "arachne");
	public static final ResourceLocation ARACHNE_DRONE_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "arachne_drone");
	public static final ResourceLocation ARGAN_HOUND_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "argan_hound");
	public static final ResourceLocation ARGAN_HOUND_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "argan_hound_skull");
	public static final ResourceLocation CAPELLA_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "capella");
	public static final ResourceLocation CAPELLA_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "capella_skull");
	public static final ResourceLocation CATOBLEPAS_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "catoblepas");
	public static final ResourceLocation CATOBLEPAS_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "catoblepas_skull");
	public static final ResourceLocation CERVER_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "cerver");
	public static final ResourceLocation CERVER_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "cerver_skull");
	public static final ResourceLocation CROCOTTA_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "crocotta");
	public static final ResourceLocation CROCOTTA_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "crocotta_skull");
	public static final ResourceLocation CYPRESS_FOREST_HAG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "cypress_forest_hag");
	public static final ResourceLocation CYPRESS_FOREST_HAG_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "cypress_forest_hag_skull");
	public static final ResourceLocation DROUGHTROOT_FOREST_HAG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "droughtroot_forest_hag");
	public static final ResourceLocation DROUGHTROOT_FOREST_HAG_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "droughtroot_forest_hag_skull");
	public static final ResourceLocation FIR_FOREST_HAG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "fir_forest_hag");
	public static final ResourceLocation FIR_FOREST_HAG_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "fir_forest_hag_skull");
	public static final ResourceLocation LAUREL_FOREST_HAG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "laurel_forest_hag");
	public static final ResourceLocation LAUREL_FOREST_HAG_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "laurel_forest_hag_skull");
	public static final ResourceLocation OLIVE_FOREST_HAG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "olive_forest_hag");
	public static final ResourceLocation OLIVE_FOREST_HAG_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "olive_forest_hag_skull");
	public static final ResourceLocation PLANE_FOREST_HAG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "plane_forest_hag");
	public static final ResourceLocation PLANE_FOREST_HAG_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "plane_forest_hag_skull");
	public static final ResourceLocation POPULUS_FOREST_HAG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "populus_forest_hag");
	public static final ResourceLocation POPULUS_FOREST_HAG_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "populus_forest_hag_skull");
	public static final ResourceLocation HYLIASTER_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "hyliaster");
	public static final ResourceLocation ENDER_JELLYFISH_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "ender_jellyfish");
	public static final ResourceLocation FIRE_JELLYFISH_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "fire_jellyfish");
	public static final ResourceLocation NATURE_JELLYFISH_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "nature_jellyfish");
	public static final ResourceLocation VOID_JELLYFISH_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "void_jellyfish");
	public static final ResourceLocation WATER_JELLYFISH_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "water_jellyfish");
	public static final ResourceLocation MYRMEKE_DRONE_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "myrmeke_drone");
	public static final ResourceLocation MYRMEKE_SOLDIER_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "myrmeke_soldier");
	public static final ResourceLocation MYRMEKE_QUEEN_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "myrmeke_queen");
	public static final ResourceLocation ORICHALCUM_HELMET_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "orichalcum_helmet");
	public static final ResourceLocation CAPTAIN_REVENANT_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "captain_revenant");
	public static final ResourceLocation CIVILIAN_REVENANT_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "civilian_revenant");
	public static final ResourceLocation CRAWLER_REVENANT_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "crawler_revenant");
	public static final ResourceLocation OVERGROWN_REVENANT_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "overgrown_revenant");
	public static final ResourceLocation PYROMANCER_REVENANT_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "pyromancer_revenant");
	public static final ResourceLocation NETHER_PYROMANCER_REVENANT_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "nether_pyromancer_revenant");
	public static final ResourceLocation SOLDIER_REVENANT_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "soldier_revenant");
	public static final ResourceLocation REVENANT_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "revenant_skull");
	public static final ResourceLocation SCORPION_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "scorpion");
	public static final ResourceLocation CRYSTAL_SLUG_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "crystal_slug");
	public static final ResourceLocation FOREST_SNULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "forest_snull");
	public static final ResourceLocation SNULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "snull");
	public static final ResourceLocation SOLIFUGAE_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "solifugae");
	public static final ResourceLocation SOW_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "sow");
	public static final ResourceLocation SOW_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "sow_skull");
	public static final ResourceLocation VINEGAROON_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "vinegaroon");

	// SOUND

	public static final ResourceLocation BARREL_BREAK = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block.barrel.break");
	public static final ResourceLocation GRINDER_GRIND = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block.grinder.grind");
	public static final ResourceLocation KETTLE_CONCOCT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block.kettle.concoct");
	public static final ResourceLocation KETTLE_CONSUME = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block.kettle.consume");
	public static final ResourceLocation KETTLE_POP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block.kettle.pop");
	public static final ResourceLocation VASE_BREAK = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block.vase.break");
	public static final ResourceLocation AETERNAE_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.aeternae.ambient");
	public static final ResourceLocation AETERNAE_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.aeternae.death");
	public static final ResourceLocation AETERNAE_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.aeternae.hurt");
	public static final ResourceLocation AETERNAE_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.aeternae.step");
	public static final ResourceLocation ARACHNE_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne.ambient");
	public static final ResourceLocation ARACHNE_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne.death");
	public static final ResourceLocation ARACHNE_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne.hurt");
	public static final ResourceLocation ARACHNE_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne.step");
	public static final ResourceLocation ARACHNE_DRONE_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne_drone.ambient");
	public static final ResourceLocation ARACHNE_DRONE_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne_drone.death");
	public static final ResourceLocation ARACHNE_DRONE_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne_drone.hurt");
	public static final ResourceLocation ARACHNE_DRONE_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.arachne_drone.step");
	public static final ResourceLocation ARGAN_HOUND_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.argan_hound.ambient");
	public static final ResourceLocation ARGAN_HOUND_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.argan_hound.death");
	public static final ResourceLocation ARGAN_HOUND_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.argan_hound.hurt");
	public static final ResourceLocation ARGAN_HOUND_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.argan_hound.step");
	public static final ResourceLocation CAPELLA_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.capella.ambient");
	public static final ResourceLocation CAPELLA_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.capella.death");
	public static final ResourceLocation CAPELLA_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.capella.hurt");
	public static final ResourceLocation CAPELLA_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.capella.step");
	public static final ResourceLocation CATOBLEPAS_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.catoblepas.ambient");
	public static final ResourceLocation CATOBLEPAS_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.catoblepas.death");
	public static final ResourceLocation CATOBLEPAS_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.catoblepas.hurt");
	public static final ResourceLocation CATOBLEPAS_MILK = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.catoblepas.milk");
	public static final ResourceLocation CATOBLEPAS_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.catoblepas.step");
	public static final ResourceLocation CERVER_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.cerver.ambient");
	public static final ResourceLocation CERVER_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.cerver.death");
	public static final ResourceLocation CERVER_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.cerver.hurt");
	public static final ResourceLocation CROCOTTA_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.crocotta.ambient");
	public static final ResourceLocation CROCOTTA_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.crocotta.death");
	public static final ResourceLocation CROCOTTA_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.crocotta.hurt");
	public static final ResourceLocation CROCOTTA_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.crocotta.step");
	public static final ResourceLocation FOREST_HAG_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.forest_hag.ambient");
	public static final ResourceLocation FOREST_HAG_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.forest_hag.death");
	public static final ResourceLocation FOREST_HAG_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.forest_hag.hurt");
	public static final ResourceLocation FOREST_HAG_SCREAM = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.forest_hag.scream");
	public static final ResourceLocation FOREST_HAG_TARGET = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.forest_hag.target");
	public static final ResourceLocation HYLIASTER_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.hyliaster.death");
	public static final ResourceLocation HYLIASTER_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.hyliaster.hurt");
	public static final ResourceLocation HYLIASTER_SQUISH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.hyliaster.squish");
	public static final ResourceLocation JELLYFISH_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.jellyfish.ambient");
	public static final ResourceLocation JELLYFISH_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.jellyfish.death");
	public static final ResourceLocation JELLYFISH_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.jellyfish.hurt");
	public static final ResourceLocation MYRMEKE_DRONE_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_drone.ambient");
	public static final ResourceLocation MYRMEKE_DRONE_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_drone.death");
	public static final ResourceLocation MYRMEKE_DRONE_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_drone.hurt");
	public static final ResourceLocation MYRMEKE_DRONE_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_drone.step");
	public static final ResourceLocation MYRMEKE_SOLDIER_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_soldier.ambient");
	public static final ResourceLocation MYRMEKE_SOLDIER_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_soldier.death");
	public static final ResourceLocation MYRMEKE_SOLDIER_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_soldier.hurt");
	public static final ResourceLocation MYRMEKE_SOLDIER_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_soldier.step");
	public static final ResourceLocation MYRMEKE_QUEEN_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_queen.ambient");
	public static final ResourceLocation MYRMEKE_QUEEN_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_queen.death");
	public static final ResourceLocation MYRMEKE_QUEEN_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_queen.hurt");
	public static final ResourceLocation MYRMEKE_QUEEN_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.myrmeke_queen.step");
	public static final ResourceLocation REVENANT_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.revenant.ambient");
	public static final ResourceLocation REVENANT_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.revenant.death");
	public static final ResourceLocation REVENANT_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.revenant.hurt");
	public static final ResourceLocation REVENANT_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.revenant.step");
	public static final ResourceLocation CAPTAIN_REVENANT_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.death");
	public static final ResourceLocation CAPTAIN_REVENANT_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.hurt");
	public static final ResourceLocation CAPTAIN_REVENANT_RALLY = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.rally");
	public static final ResourceLocation CAPTAIN_REVENANT_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.step");
	public static final ResourceLocation NETHER_PYROMANCER_REVENANT_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.nether_pyromancer_revenant.ambient");
	public static final ResourceLocation SOLDIER_REVENANT_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.soldier_revenant.death");
	public static final ResourceLocation SOLDIER_REVENANT_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.soldier_revenant.hurt");
	public static final ResourceLocation SOLDIER_REVENANT_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.soldier_revenant.step");
	public static final ResourceLocation SCORPION_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.scorpion.ambient");
	public static final ResourceLocation SCORPION_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.scorpion.death");
	public static final ResourceLocation SCORPION_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.scorpion.hurt");
	public static final ResourceLocation SCORPION_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.scorpion.step");
	public static final ResourceLocation SLUG_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.slug.ambient");
	public static final ResourceLocation SLUG_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.slug.death");
	public static final ResourceLocation SLUG_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.slug.hurt");
	public static final ResourceLocation SNULL_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.snull.ambient");
	public static final ResourceLocation SNULL_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.snull.death");
	public static final ResourceLocation SNULL_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.snull.hurt");
	public static final ResourceLocation SOLIFUGAE_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.solifugae.ambient");
	public static final ResourceLocation SOLIFUGAE_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.solifugae.death");
	public static final ResourceLocation SOLIFUGAE_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.solifugae.hurt");
	public static final ResourceLocation SOLIFUGAE_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.solifugae.step");
	public static final ResourceLocation SOW_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.sow.ambient");
	public static final ResourceLocation SOW_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.sow.death");
	public static final ResourceLocation SOW_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.sow.hurt");
	public static final ResourceLocation SOW_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.sow.step");
	public static final ResourceLocation VINEGAROON_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.vinegaroon.ambient");
	public static final ResourceLocation VINEGAROON_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.vinegaroon.death");
	public static final ResourceLocation VINEGAROON_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.vinegaroon.hurt");
	public static final ResourceLocation VINEGAROON_SHOOT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.vinegaroon.shoot");
	public static final ResourceLocation VINEGAROON_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.vinegaroon.step");
	public static final ResourceLocation LAUREL_WREATH_EQUIP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.laurel_wreath.equip");
	public static final ResourceLocation AETERNAE_HIDE_ARMOR_EQUIP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.aeternae_hide_armor.equip");
	public static final ResourceLocation CHALKOS_ARMOR_EQUIP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.chalkos_armor.equip");
	public static final ResourceLocation KASSITEROS_ARMOR_EQUIP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.kassiteros_armor.equip");
	public static final ResourceLocation ORICHALCUM_ARMOR_EQUIP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.orichalcum_armor.equip");
	public static final ResourceLocation VANADIUMSTEEL_ARMOR_EQUIP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.vanadiumsteel.equip");
	public static final ResourceLocation BIDENT_HIT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.bident.hit");
	public static final ResourceLocation BIDENT_HIT_GROUND = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.bident.hit_ground");
	public static final ResourceLocation BIDENT_THROW = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.bident.throw");
	public static final ResourceLocation CALCITE_FERTILIZE = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.calcite.fertilize");
	public static final ResourceLocation CHEST_LABEL_APPLY = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.chest_label.apply");
	public static final ResourceLocation CHEST_LABEL_CLEAR = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.chest_label.clear");
	public static final ResourceLocation GREEK_FIRE_GRENADE_THROW = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.greek_fire_grenade.throw");
	public static final ResourceLocation OLIVES_POP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.olives.pop");
	public static final ResourceLocation SPELL_SHOOT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.spell.shoot");
	public static final ResourceLocation BUBBLE_SPELL_POP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.bubble_spell.pop");
	public static final ResourceLocation BUBBLE_SPELL_SHOOT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.bubble_spell.shoot");
	public static final ResourceLocation VIAL_EMPTY = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.vial.empty");
	public static final ResourceLocation VIAL_FILL = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "item.vial.fill");
}
