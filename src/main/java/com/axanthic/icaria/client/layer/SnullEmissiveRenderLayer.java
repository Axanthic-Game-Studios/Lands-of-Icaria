package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.SnullModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.SnullRenderState;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.awt.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SnullEmissiveRenderLayer extends RenderLayer<SnullRenderState, SnullModel> {
	public SnullEmissiveRenderLayer(RenderLayerParent<SnullRenderState, SnullModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, SnullRenderState pRenderState, float yRot, float xRot) {
		var color = Color.getHSBColor(pRenderState.ageInTicks * 0.1F, 1.0F, 1.0F);
		nodeCollector.submitModel(this.getParentModel(), pRenderState, poseStack, IcariaRenderTypes.SNULL_EMISSIVE, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getLightBasedColorAndAlpha(pRenderState.livingEntity), null, pRenderState.outlineColor, null);
		if (pRenderState.livingEntity.getCustomName() != null && pRenderState.livingEntity.getCustomName().getString().equalsIgnoreCase("Pro")) {
			nodeCollector.submitModel(this.getParentModel(), pRenderState, poseStack, IcariaRenderTypes.SNULL_EYES, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getLightBasedColorAndAlpha(pRenderState.livingEntity, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F), null, pRenderState.outlineColor, null);
		} else if (pRenderState.livingEntity.getCustomName() != null && pRenderState.livingEntity.getCustomName().getString().equalsIgnoreCase("Sans")) {
			nodeCollector.submitModel(this.getParentModel(), pRenderState, poseStack, IcariaRenderTypes.SNULL_SANS, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getLightBasedColorAndAlpha(pRenderState.livingEntity), null, pRenderState.outlineColor, null);
		}
	}
}
