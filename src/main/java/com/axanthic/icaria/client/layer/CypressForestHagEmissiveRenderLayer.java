package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CypressForestHagModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.CypressForestHagRenderState;

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

public class CypressForestHagEmissiveRenderLayer extends RenderLayer<CypressForestHagRenderState, CypressForestHagModel> {
	public CypressForestHagEmissiveRenderLayer(RenderLayerParent<CypressForestHagRenderState, CypressForestHagModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, CypressForestHagRenderState pRenderState, float pYRot, float pXRot) {
		pSubmitNodeCollector.submitModel(this.getParentModel(), pRenderState, pPoseStack, IcariaRenderTypes.CYPRESS_FOREST_HAG_EMISSIVE, LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.aggressive), null, pRenderState.outlineColor, null);
	}
}
