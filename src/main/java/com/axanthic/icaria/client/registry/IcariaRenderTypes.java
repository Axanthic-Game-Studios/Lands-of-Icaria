package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRenderTypes {
	public static final RenderType ARACHNE_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.ARACHNE_EMISSIVE);
	public static final RenderType ARACHNE_DRONE_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.ARACHNE_DRONE_EMISSIVE);
	public static final RenderType ARGAN_HOUND_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.ARGAN_HOUND_EMISSIVE);
	public static final RenderType CYPRESS_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.CYPRESS_FOREST_HAG_EMISSIVE);
	public static final RenderType DROUGHTROOT_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.DROUGHTROOT_FOREST_HAG_EMISSIVE);
	public static final RenderType FIR_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.FIR_FOREST_HAG_EMISSIVE);
	public static final RenderType LAUREL_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.LAUREL_FOREST_HAG_EMISSIVE);
	public static final RenderType OLIVE_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.OLIVE_FOREST_HAG_EMISSIVE);
	public static final RenderType PLANE_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.PLANE_FOREST_HAG_EMISSIVE);
	public static final RenderType POPULUS_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.POPULUS_FOREST_HAG_EMISSIVE);
	public static final RenderType ENDER_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.ENDER_JELLYFISH_EMISSIVE);
	public static final RenderType FIRE_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.FIRE_JELLYFISH_EMISSIVE);
	public static final RenderType NATURE_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.NATURE_JELLYFISH_EMISSIVE);
	public static final RenderType VOID_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.VOID_JELLYFISH_EMISSIVE);
	public static final RenderType WATER_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.WATER_JELLYFISH_EMISSIVE);
	public static final RenderType MYRMEKE_DRONE_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.MYRMEKE_DRONE_EMISSIVE);
	public static final RenderType MYRMEKE_SOLDIER_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.MYRMEKE_SOLDIER_EMISSIVE);
	public static final RenderType MYRMEKE_QUEEN_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.MYRMEKE_QUEEN_EMISSIVE);
	public static final RenderType CAPTAIN_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.CAPTAIN_REVENANT_EMISSIVE);
	public static final RenderType CIVILIAN_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.CIVILIAN_REVENANT_EMISSIVE);
	public static final RenderType CRAWLER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.CRAWLER_REVENANT_EMISSIVE);
	public static final RenderType OVERGROWN_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.OVERGROWN_REVENANT_EMISSIVE);
	public static final RenderType PYROMANCER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.PYROMANCER_REVENANT_EMISSIVE);
	public static final RenderType NETHER_PYROMANCER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.NETHER_PYROMANCER_REVENANT_EMISSIVE);
	public static final RenderType SOLDIER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.SOLDIER_REVENANT_EMISSIVE);
	public static final RenderType SCORPION_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.SCORPION_EMISSIVE);
	public static final RenderType CRYSTAL_SLUG_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.CRYSTAL_SLUG_EMISSIVE);
	public static final RenderType FOREST_SNULL_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.FOREST_SNULL_EMISSIVE);
	public static final RenderType SNULL_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.SNULL_EMISSIVE);
	public static final RenderType SNULL_EYES = RenderType.entityTranslucentEmissive(IcariaResourceLocations.SNULL_EYES);
	public static final RenderType SNULL_SANS = RenderType.entityTranslucentEmissive(IcariaResourceLocations.SNULL_SANS);
	public static final RenderType SOLIFUGAE_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.SOLIFUGAE_EMISSIVE);
	public static final RenderType VINEGAROON_EMISSIVE = RenderType.entityTranslucentEmissive(IcariaResourceLocations.VINEGAROON_EMISSIVE);

	public static final RenderType HYLIASTER_TRANSLUCENT = RenderType.entityTranslucent(IcariaResourceLocations.HYLIASTER_TRANSLUCENT);

	public static final RenderType ADDITIVE = RenderType.create("additive", 1536, false, false, IcariaRenderPipelines.ADDITIVE, RenderType.CompositeState.builder()
		.setLayeringState(RenderStateShard.NO_LAYERING)
		.setLightmapState(RenderStateShard.NO_LIGHTMAP)
		.setLineState(RenderStateShard.DEFAULT_LINE)
		.setOutputState(RenderStateShard.MAIN_TARGET)
		.setOverlayState(RenderStateShard.NO_OVERLAY)
		.setTextureState(RenderStateShard.NO_TEXTURE)
		.setTexturingState(RenderStateShard.DEFAULT_TEXTURING)
		.createCompositeState(false)
	);

	public static final RenderType ADDITIVE_TEXTURED = RenderType.create("additive_textured", 1536, false, false, IcariaRenderPipelines.ADDITIVE_TEXTURED, RenderType.CompositeState.builder()
		.setLayeringState(RenderStateShard.NO_LAYERING)
		.setLightmapState(RenderStateShard.NO_LIGHTMAP)
		.setLineState(RenderStateShard.DEFAULT_LINE)
		.setOutputState(RenderStateShard.MAIN_TARGET)
		.setOverlayState(RenderStateShard.NO_OVERLAY)
		.setTextureState(RenderStateShard.BLOCK_SHEET)
		.setTexturingState(RenderStateShard.DEFAULT_TEXTURING)
		.createCompositeState(false)
	);
}
