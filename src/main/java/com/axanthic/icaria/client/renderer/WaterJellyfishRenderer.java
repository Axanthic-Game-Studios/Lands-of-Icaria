package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.layer.WaterJellyfishEmissiveLayer;
import com.axanthic.icaria.client.model.WaterJellyfishModel;
import com.axanthic.icaria.client.registry.IcariaLayerLocations;
import com.axanthic.icaria.common.entity.JellyfishEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WaterJellyfishRenderer extends MobRenderer<JellyfishEntity, WaterJellyfishModel> {
	public WaterJellyfishRenderer(EntityRendererProvider.Context pContext) {
		super(pContext, new WaterJellyfishModel(pContext.bakeLayer(IcariaLayerLocations.WATER_JELLYFISH)), 1.0F);
		this.addLayer(new WaterJellyfishEmissiveLayer(this));
	}

	@Override
	public float getShadowRadius(JellyfishEntity pEntity) {
		return pEntity.getScaleForShadow();
	}

	@Override
	public float getBob(JellyfishEntity pLivingBase, float pPartialTicks) {
		return Mth.lerp(pPartialTicks, pLivingBase.oldTentacleAngle, pLivingBase.tentacleAngle);
	}

	@Override
	public void scale(JellyfishEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
		pMatrixStack.scale(pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender(), pLivingEntity.getScaleForRender());
	}

	@Override
	public void setupRotations(JellyfishEntity pEntityLiving, PoseStack pMatrixStack, float pAgeInTicks, float pRotationYaw, float pPartialTicks, float pScale) {
		float yRotation = 180.0F - pRotationYaw;
		float xRotation = Mth.lerp(pPartialTicks, pEntityLiving.oldXBodyRot, pEntityLiving.xBodyRot);
		float zRotation = Mth.lerp(pPartialTicks, pEntityLiving.oldZBodyRot, pEntityLiving.zBodyRot);

		pMatrixStack.translate(0.0F, pEntityLiving.getScaleForRender() * 0.5F, 0.0F);
		pMatrixStack.mulPose(Axis.YP.rotationDegrees(yRotation));
		pMatrixStack.mulPose(Axis.XP.rotationDegrees(xRotation));
		pMatrixStack.mulPose(Axis.YP.rotationDegrees(zRotation));
		pMatrixStack.translate(0.0F, pEntityLiving.getScaleForRender() * -1.0F, 0.0F);
	}

	@Override
	public ResourceLocation getTextureLocation(JellyfishEntity pEntity) {
		return IcariaResourceLocations.WATER_JELLYFISH;
	}
}
