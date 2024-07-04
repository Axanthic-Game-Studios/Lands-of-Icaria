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
    public static final ResourceLocation CATOBLEPAS = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/catoblepas.png");
    public static final ResourceLocation CERVER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "textures/entity/cerver.png");
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
    public static final ResourceLocation CATOBLEPAS_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "catoblepas");
    public static final ResourceLocation CATOBLEPAS_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "catoblepas_skull");
    public static final ResourceLocation CERVER_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "cerver");
    public static final ResourceLocation CERVER_SKULL_LAYER = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "cerver_skull");
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
    public static final ResourceLocation CAPTAIN_REVENANT_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.death");
    public static final ResourceLocation CAPTAIN_REVENANT_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.hurt");
    public static final ResourceLocation CAPTAIN_REVENANT_RALLY = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.rally");
    public static final ResourceLocation CAPTAIN_REVENANT_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.captain_revenant.step");
    public static final ResourceLocation PYROMANCER_REVENANT_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.pyromancer_revenant.ambient");
    public static final ResourceLocation SOLDIER_REVENANT_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.soldier_revenant.death");
    public static final ResourceLocation SOLDIER_REVENANT_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.soldier_revenant.hurt");
    public static final ResourceLocation SOLDIER_REVENANT_STEP = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.soldier_revenant.step");
    public static final ResourceLocation REVENANT_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.revenant.ambient");
    public static final ResourceLocation REVENANT_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.revenant.death");
    public static final ResourceLocation REVENANT_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.revenant.hurt");
    public static final ResourceLocation SCORPION_AMBIENT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.scorpion.ambient");
    public static final ResourceLocation SCORPION_DEATH = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.scorpion.death");
    public static final ResourceLocation SCORPION_HURT = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "entity.scorpion.hurt");
    public static final ResourceLocation VASE_BREAK = ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "block.vase.break");
}
