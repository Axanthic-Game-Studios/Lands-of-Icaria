package com.axanthic.icaria.client.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("unused")

public class IcariaRenderTypes {
    // EMISSIVE
    public static final RenderType ARACHNE_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/arachne_emissive.png"));
    public static final RenderType ARACHNE_DRONE_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/arachne_drone_emissive.png"));
    public static final RenderType ARGAN_HOUND_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/argan_hound_emissive.png"));
    public static final RenderType CYPRESS_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/cypress_forest_hag_emissive.png"));
    public static final RenderType DROUGHTROOT_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/droughtroot_forest_hag_emissive.png"));
    public static final RenderType FIR_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/fir_forest_hag_emissive.png"));
    public static final RenderType LAUREL_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/laurel_forest_hag_emissive.png"));
    public static final RenderType OLIVE_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/olive_forest_hag_emissive.png"));
    public static final RenderType PLANE_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/plane_forest_hag_emissive.png"));
    public static final RenderType POPULUS_FOREST_HAG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/populus_forest_hag_emissive.png"));
    public static final RenderType ENDER_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/ender_jellyfish_emissive.png"));
    public static final RenderType FIRE_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/fire_jellyfish_emissive.png"));
    public static final RenderType NATURE_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/nature_jellyfish_emissive.png"));
    public static final RenderType VOID_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/void_jellyfish_emissive.png"));
    public static final RenderType WATER_JELLYFISH_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/water_jellyfish_emissive.png"));
    public static final RenderType MYRMEKE_QUEEN_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/myrmeke_queen_emissive.png"));
    public static final RenderType CAPTAIN_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/captain_revenant_emissive.png"));
    public static final RenderType CIVILIAN_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/civilian_revenant_emissive.png"));
    public static final RenderType CRAWLER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/crawler_revenant_emissive.png"));
    public static final RenderType OVERGROWN_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/overgrown_revenant_emissive.png"));
    public static final RenderType PYROMANCER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/pyromancer_revenant_emissive.png"));
    public static final RenderType NETHER_PYROMANCER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/nether_pyromancer_revenant_emissive.png"));
    public static final RenderType SOLDIER_REVENANT_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/soldier_revenant_emissive.png"));
    public static final RenderType CRYSTAL_SLUG_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/crystal_slug_emissive.png"));
    public static final RenderType FOREST_SNULL_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/forest_snull_emissive.png"));
    public static final RenderType SNULL_EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/snull_emissive.png"));
    public static final RenderType SNULL_EYES = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/snull_eyes.png"));
    public static final RenderType SNULL_SANS = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.ID, "textures/entity/snull_sans.png"));

    // TRANSLUCENT
    public static final RenderType HYLIASTER_TRANSLUCENT = RenderType.entityTranslucent(new ResourceLocation(IcariaInfo.ID, "textures/entity/hyliaster_translucent.png"));

    // ADDITIVE
    public static final RenderType ADDITIVE_LIGHTNING = RenderType.create("additive_lightning", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.builder().setShaderState(IcariaRenderStateShards.LIGHTNING_SHADER).setTransparencyState(IcariaRenderStateShards.ADDITIVE_LIGHTNING_TRANSPARENCY).createCompositeState(false));

    // SUBTRACTIVE
    public static final RenderType SUBTRACTIVE_LIGHTNING = RenderType.create("subtractive_lightning", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.builder().setShaderState(IcariaRenderStateShards.LIGHTNING_SHADER).setTransparencyState(IcariaRenderStateShards.SUBTRACTIVE_LIGHTNING_TRANSPARENCY).createCompositeState(false));
}