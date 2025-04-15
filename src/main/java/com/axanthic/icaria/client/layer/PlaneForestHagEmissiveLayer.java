package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.PlaneForestHagModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.PlaneForestHagRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PlaneForestHagEmissiveLayer extends RenderLayer<PlaneForestHagRenderState, PlaneForestHagModel> {
	public PlaneForestHagEmissiveLayer(RenderLayerParent<PlaneForestHagRenderState, PlaneForestHagModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, PlaneForestHagRenderState pRenderState, float pYRot, float pXRot) {
		this.getParentModel().renderToBuffer(pPoseStack, pMultiBufferSource.getBuffer(IcariaRenderTypes.PLANE_FOREST_HAG_EMISSIVE), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.aggressive));
	}
}
