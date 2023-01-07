package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.ArachneDroneModel;
import com.axanthic.icaria.common.entity.ArachneDroneEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneEmissiveLayer extends RenderLayer<ArachneDroneEntity, ArachneDroneModel> {
    public static final RenderType EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.MODID, "textures/entity/arachne_drone_emissive.png"));

    public ArachneDroneEmissiveLayer(RenderLayerParent<ArachneDroneEntity, ArachneDroneModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, ArachneDroneEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(EMISSIVE), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
    }
}
