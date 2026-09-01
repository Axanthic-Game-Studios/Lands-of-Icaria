package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.rendertype.RenderSetup;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRenderTypes {
	public static final RenderType ARACHNE_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.ARACHNE_EMISSIVE);
	public static final RenderType ARACHNE_DRONE_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.ARACHNE_DRONE_EMISSIVE);
	public static final RenderType ARGAN_HOUND_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.ARGAN_HOUND_EMISSIVE);
	public static final RenderType CYPRESS_FOREST_HAG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.CYPRESS_FOREST_HAG_EMISSIVE);
	public static final RenderType DROUGHTROOT_FOREST_HAG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.DROUGHTROOT_FOREST_HAG_EMISSIVE);
	public static final RenderType FIR_FOREST_HAG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.FIR_FOREST_HAG_EMISSIVE);
	public static final RenderType LAUREL_FOREST_HAG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.LAUREL_FOREST_HAG_EMISSIVE);
	public static final RenderType OLIVE_FOREST_HAG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.OLIVE_FOREST_HAG_EMISSIVE);
	public static final RenderType PLANE_FOREST_HAG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.PLANE_FOREST_HAG_EMISSIVE);
	public static final RenderType POPULUS_FOREST_HAG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.POPULUS_FOREST_HAG_EMISSIVE);
	public static final RenderType HYLIASTER_TRANSLUCENT = RenderTypes.entityTranslucent(IcariaIdentifiers.HYLIASTER_TRANSLUCENT);
	public static final RenderType ENDER_JELLYFISH_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.ENDER_JELLYFISH_EMISSIVE);
	public static final RenderType FIRE_JELLYFISH_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.FIRE_JELLYFISH_EMISSIVE);
	public static final RenderType NATURE_JELLYFISH_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.NATURE_JELLYFISH_EMISSIVE);
	public static final RenderType VOID_JELLYFISH_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.VOID_JELLYFISH_EMISSIVE);
	public static final RenderType WATER_JELLYFISH_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.WATER_JELLYFISH_EMISSIVE);
	public static final RenderType MYRMEKE_DRONE_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.MYRMEKE_DRONE_EMISSIVE);
	public static final RenderType MYRMEKE_SOLDIER_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.MYRMEKE_SOLDIER_EMISSIVE);
	public static final RenderType MYRMEKE_QUEEN_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.MYRMEKE_QUEEN_EMISSIVE);
	public static final RenderType CAPTAIN_REVENANT_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.CAPTAIN_REVENANT_EMISSIVE);
	public static final RenderType CIVILIAN_REVENANT_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.CIVILIAN_REVENANT_EMISSIVE);
	public static final RenderType CRAWLER_REVENANT_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.CRAWLER_REVENANT_EMISSIVE);
	public static final RenderType OVERGROWN_REVENANT_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.OVERGROWN_REVENANT_EMISSIVE);
	public static final RenderType PYROMANCER_REVENANT_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.PYROMANCER_REVENANT_EMISSIVE);
	public static final RenderType NETHER_PYROMANCER_REVENANT_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.NETHER_PYROMANCER_REVENANT_EMISSIVE);
	public static final RenderType SOLDIER_REVENANT_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.SOLDIER_REVENANT_EMISSIVE);
	public static final RenderType SCORPION_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.SCORPION_EMISSIVE);
	public static final RenderType CRYSTAL_SLUG_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.CRYSTAL_SLUG_EMISSIVE);
	public static final RenderType FOREST_SNULL_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.FOREST_SNULL_EMISSIVE);
	public static final RenderType SNULL_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.SNULL_EMISSIVE);
	public static final RenderType SNULL_EYES = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.SNULL_EYES);
	public static final RenderType SNULL_SANS = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.SNULL_SANS);
	public static final RenderType SOLIFUGAE_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.SOLIFUGAE_EMISSIVE);
	public static final RenderType VINEGAROON_EMISSIVE = RenderTypes.entityTranslucentEmissive(IcariaIdentifiers.VINEGAROON_EMISSIVE);

	public static final RenderType ADDITIVE = RenderType.create("additive", RenderSetup.builder(IcariaRenderPipelines.ADDITIVE).createRenderSetup());
	public static final RenderType ADDITIVE_TEXTURED = RenderType.create("additive_textured", RenderSetup.builder(IcariaRenderPipelines.ADDITIVE_TEXTURED).withTexture("Texture", IcariaIdentifiers.SPELL).createRenderSetup());
}
