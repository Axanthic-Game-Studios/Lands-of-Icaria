package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.EnderJellyfishEmissiveLayer;
import com.axanthic.icaria.client.model.EnderJellyfishModel;
import com.axanthic.icaria.common.entity.JellyfishEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

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

public class EnderJellyfishRenderer extends MobRenderer<JellyfishEntity, EnderJellyfishModel> {
    public float shdwMult = 0.2F;
    public float sizeMult = 0.25F;

    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/ender_jellyfish.png");

    public EnderJellyfishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new EnderJellyfishModel(pContext.bakeLayer(EnderJellyfishModel.LAYER_LOCATION)), 1.0F);
        this.addLayer(new EnderJellyfishEmissiveLayer(this));
    }

    @Override
    public float getBob(JellyfishEntity pLivingBase, float pPartialTicks) {
        return Mth.lerp(pPartialTicks, pLivingBase.oldTentacleAngle, pLivingBase.tentacleAngle);
    }

    @Override
    public void render(JellyfishEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? pEntity.getScaleFromSize() * this.shdwMult : 2.0F * this.shdwMult;
    }

    @Override
    public void scale(JellyfishEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = pLivingEntity.getScaleFromSize() * this.sizeMult;
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
        return RESOURCE_LOCATION;
    }
}
