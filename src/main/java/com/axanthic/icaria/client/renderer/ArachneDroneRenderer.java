package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.ArachneDroneEmissiveLayer;
import com.axanthic.icaria.client.model.ArachneDroneModel;
import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneRenderer extends MobRenderer<ArachneDroneEntity, ArachneDroneModel> {
    public float shdwMult = 0.3F;
    public float sizeMult = 0.125F;

    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/arachne_drone.png");

    public ArachneDroneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArachneDroneModel(pContext.bakeLayer(ArachneDroneModel.LAYER_LOCATION)), 1.0F);
        this.addLayer(new ArachneDroneEmissiveLayer(this));
    }

    @Override
    public void render(ArachneDroneEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        this.shadowRadius = pEntity.isBaby() ? pEntity.getScaleFromSize() * this.shdwMult : 2.0F * this.shdwMult;
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public void scale(ArachneDroneEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = pLivingEntity.getScaleFromSize() * this.sizeMult;
        pMatrixStack.scale(size, size, size);
    }

    @Override
    public ResourceLocation getTextureLocation(ArachneDroneEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
