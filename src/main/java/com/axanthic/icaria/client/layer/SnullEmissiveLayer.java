package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.SnullModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.SnullRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import java.awt.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SnullEmissiveLayer extends RenderLayer<SnullRenderState, SnullModel> {
	public SnullEmissiveLayer(RenderLayerParent<SnullRenderState, SnullModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, SnullRenderState pRenderState, float pYRot, float pXRot) {
		var color = Color.getHSBColor(pRenderState.ageInTicks * 0.1F, 1.0F, 1.0F);
		this.getParentModel().renderToBuffer(pPoseStack, pMultiBufferSource.getBuffer(IcariaRenderTypes.SNULL_EMISSIVE), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.partialTick));
		if (pRenderState.customName != null && pRenderState.customName.getString().equalsIgnoreCase("Pro")) {
			this.getParentModel().renderToBuffer(pPoseStack, pMultiBufferSource.getBuffer(IcariaRenderTypes.SNULL_EYES), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.partialTick, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F));
		} else if (pRenderState.customName != null && pRenderState.customName.getString().equalsIgnoreCase("Sans")) {
			this.getParentModel().renderToBuffer(pPoseStack, pMultiBufferSource.getBuffer(IcariaRenderTypes.SNULL_SANS), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.partialTick));
		}
	}
}
