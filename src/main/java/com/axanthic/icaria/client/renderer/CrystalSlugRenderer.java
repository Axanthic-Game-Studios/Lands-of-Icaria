package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.CrystalSlugEmissiveLayer;
import com.axanthic.icaria.client.layer.CrystalSlugRaysLayer;
import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.common.entity.SlugEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRenderer extends MobRenderer<SlugEntity, CrystalSlugModel> {
    public float shdwMult = 0.35F;
    public float sizeMult = 0.25F;

    public static final ResourceLocation RESOURCE_LOCATION = new ResourceLocation(IcariaInfo.MODID, "textures/entity/crystal_slug.png");

    public CrystalSlugRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrystalSlugModel(pContext.bakeLayer(CrystalSlugModel.BODY_LAYER_LOCATION)), 1.0F);
        this.addLayer(new CrystalSlugEmissiveLayer(this));
        this.addLayer(new CrystalSlugRaysLayer(this, pContext.getModelSet(), -0.125F, 1.225F, 0.800F, 0.000F, 0.000F, -0.600F));
        this.addLayer(new CrystalSlugRaysLayer(this, pContext.getModelSet(), 0.200F, 1.125F, -0.175F, 0.000F, 0.000F, 0.500F));
        this.addLayer(new CrystalSlugRaysLayer(this, pContext.getModelSet(), -0.100F, 1.025F, -0.875F, 0.000F, 0.050F, 0.750F));
    }

    @Override
    public void render(SlugEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
        this.shadowRadius = pEntity.isBaby() ? pEntity.getScaleFromSize() * this.shdwMult : 2.0F * this.shdwMult;
    }

    @Override
    public void scale(SlugEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        float size = pLivingEntity.getScaleFromSize() * this.sizeMult;
        pMatrixStack.scale(size, size, size);
        if (pLivingEntity.onClimbable()) {
            pMatrixStack.mulPose(Axis.XN.rotationDegrees(90.0F));
            pMatrixStack.translate(0.0F, 0.25F, 0.0F);
        }
    }

    @Override
    public ResourceLocation getTextureLocation(SlugEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
