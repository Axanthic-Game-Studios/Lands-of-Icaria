package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.HyliasterModel;
import com.axanthic.icaria.common.entity.HyliasterEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class HyliasterOuterLayer extends RenderLayer<HyliasterEntity, HyliasterModel> {
    public final EntityModel<HyliasterEntity> model;

    public HyliasterOuterLayer(RenderLayerParent<HyliasterEntity, HyliasterModel> pRenderer, EntityModelSet pSet) {
        super(pRenderer);
        this.model = new HyliasterModel(pSet.bakeLayer(HyliasterModel.OUTER_LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, HyliasterEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTicks, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag = minecraft.shouldEntityAppearGlowing(pLivingEntity) && pLivingEntity.isInvisible();
        if (!pLivingEntity.isInvisible() || flag) {
            VertexConsumer vertexConsumer;
            if (flag) {
                vertexConsumer = pBufferSource.getBuffer(RenderType.outline(this.getTextureLocation(pLivingEntity)));
            } else {
                vertexConsumer = pBufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(pLivingEntity)));
            }

            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(pLivingEntity, pLimbSwing, pLimbSwingAmount, pPartialTicks);
            this.model.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
            this.model.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, LivingEntityRenderer.getOverlayCoords(pLivingEntity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
