package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.HyliasterModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.HyliasterRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterTranslucentLayer extends RenderLayer<HyliasterRenderState, HyliasterModel> {
	public HyliasterTranslucentLayer(RenderLayerParent<HyliasterRenderState, HyliasterModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, HyliasterRenderState pRenderState, float pYRot, float pXRot) {
		this.getParentModel().renderToBuffer(pPoseStack, pMultiBufferSource.getBuffer(IcariaRenderTypes.HYLIASTER_TRANSLUCENT), pPackedLight, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity));
	}
}
