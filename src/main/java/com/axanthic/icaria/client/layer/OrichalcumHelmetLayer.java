package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.OrichalcumHelmetModel;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

public class OrichalcumHelmetLayer {
    public static ModelLayerLocation ORICHALCUM_HELMET = new ModelLayerLocation(new ResourceLocation(IcariaInfo.MODID + "orichalcum_helmet"), "main");

    public static void onEntityRenderers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ORICHALCUM_HELMET, () -> OrichalcumHelmetModel.createHelmetLayer(CubeDeformation.NONE));
    }

    public static void register(FMLClientSetupEvent event) {

    }
}
