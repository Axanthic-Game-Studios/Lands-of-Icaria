package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.ArganHoundModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.ArganHoundRenderState;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.LightCoordsUtil;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArganHoundEmissiveRenderLayer extends RenderLayer<ArganHoundRenderState, ArganHoundModel> {
	public ArganHoundEmissiveRenderLayer(RenderLayerParent<ArganHoundRenderState, ArganHoundModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, ArganHoundRenderState pRenderState, float pYRot, float pXRot) {
		pSubmitNodeCollector.submitModel(this.getParentModel(), pRenderState, pPoseStack, IcariaRenderTypes.ARGAN_HOUND_EMISSIVE, LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity), null, pRenderState.outlineColor, null);
	}
}
