package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.client.layer.FireJellyfishEmissiveLayer;
import com.axanthic.icaria.client.model.FireJellyfishModel;
import com.axanthic.icaria.common.entity.JellyfishEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireJellyfishRenderer extends MobRenderer<JellyfishEntity, FireJellyfishModel> {
    public float shdwMult = 0.25F;
    public float sizeMult = 0.25F;

    public FireJellyfishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new FireJellyfishModel(pContext.bakeLayer(IcariaLayerLocations.FIRE_JELLYFISH)), 1.0F);
        this.addLayer(new FireJellyfishEmissiveLayer(this));
    }

    @Override
    public float getBob(JellyfishEntity pLivingBase, float pPartialTicks) {
        return Mth.lerp(pPartialTicks, pLivingBase.oldTentacleAngle, pLivingBase.tentacleAngle);
    }

    @Override
    public void render(JellyfishEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? this.shdwMult * pEntity.getScaleFromSize() : this.shdwMult * 2.0F;
    }

    @Override
    public void scale(JellyfishEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = this.sizeMult * pLivingEntity.getScaleFromSize();
        pMatrixStack.scale(size, size, size);
    }

    @Override
    public void setupRotations(JellyfishEntity pEntityLiving, PoseStack pMatrixStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
        float yRotation = 180.0F - pRotationYaw;
        float xRotation = Mth.lerp(pPartialTicks, pEntityLiving.oldXBodyRot, pEntityLiving.xBodyRot);
        float zRotation = Mth.lerp(pPartialTicks, pEntityLiving.oldZBodyRot, pEntityLiving.zBodyRot);

        pMatrixStack.translate(0.0F, 0.125F * pEntityLiving.getScaleFromSize(), 0.0F);
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(yRotation));
        pMatrixStack.mulPose(Axis.XP.rotationDegrees(xRotation));
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(zRotation));
        pMatrixStack.translate(0.0F, -0.25F * pEntityLiving.getScaleFromSize(), 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(JellyfishEntity pEntity) {
        return IcariaResourceLocations.FIRE_JELLYFISH;
    }
}
