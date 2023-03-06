package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.ForestSnullModel;
import com.axanthic.icaria.common.entity.SnullEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class ForestSnullEmissiveLayer extends RenderLayer<SnullEntity, ForestSnullModel> {
    public float duskInit = 12000.0F;
    public float duskExit = 13000.0F;
    public float dawnInit = 23000.0F;
    public float dawnExit = 24000.0F;

    public static final RenderType EMISSIVE = RenderType.entityTranslucentEmissive(new ResourceLocation(IcariaInfo.MODID, "textures/entity/forest_snull_emissive.png"));

    public ForestSnullEmissiveLayer(RenderLayerParent<SnullEntity, ForestSnullModel> pRenderer) {
        super(pRenderer);
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, SnullEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        this.getParentModel().renderToBuffer(pPoseStack, pBuffer.getBuffer(EMISSIVE), 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, lightBasedAlpha(pLivingEntity.level.getDayTime()));
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
}
