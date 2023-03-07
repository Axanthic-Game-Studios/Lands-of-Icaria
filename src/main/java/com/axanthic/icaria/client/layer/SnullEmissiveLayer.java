package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.SnullModel;
import com.axanthic.icaria.common.entity.SnullEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import java.awt.*;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class SnullEmissiveLayer extends RenderLayer<SnullEntity, SnullModel> {
    public float duskInit = 12000.0F;
    public float duskExit = 13000.0F;
    public float dawnInit = 23000.0F;
    public float dawnExit = 24000.0F;

    public static final RenderType EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.MODID, "textures/entity/snull_emissive.png"));
    public static final RenderType EYES = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.MODID, "textures/entity/snull_eyes.png"));
    public static final RenderType SANS = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.MODID, "textures/entity/snull_sans.png"));

    public SnullEmissiveLayer(RenderLayerParent<SnullEntity, SnullModel> pRenderer) {
        super(pRenderer);
    }

    public float lightBasedAlpha(float pTime) {
        if (pTime >= duskInit && pTime < duskExit) {
            return ((pTime - duskInit) / (duskExit - duskInit));
        } else if (pTime >= duskExit && pTime < dawnInit) {
            return 1.0F;
        } else if (pTime >= dawnInit && pTime < dawnExit) {
            return ((dawnExit - pTime) / (dawnExit - dawnInit));
        } else {
            return 0.0F;
        }
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, SnullEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (pLivingEntity.getCustomName() != null && pLivingEntity.getCustomName().getString().equals("Pro")) {
            this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(EMISSIVE), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, lightBasedAlpha(pLivingEntity.level.getDayTime()));
            Color color = Color.getHSBColor(pAgeInTicks * 0.1F, 1.0F, 1.0F);
            this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(EYES), 15728640, OverlayTexture.NO_OVERLAY, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, lightBasedAlpha(pLivingEntity.level.getDayTime()));
        } else if (pLivingEntity.getCustomName() != null && pLivingEntity.getCustomName().getString().equals("Sans")) {
            this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(SANS), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, lightBasedAlpha(pLivingEntity.level.getDayTime()));
        } else {
            this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(EMISSIVE), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, lightBasedAlpha(pLivingEntity.level.getDayTime()));
        }
    }
}
