package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CivilianRevenantModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.CivilianRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.LightCoordsUtil;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CivilianRevenantEmissiveRenderLayer extends RenderLayer<CivilianRevenantRenderState, CivilianRevenantModel> {
	public CivilianRevenantEmissiveRenderLayer(RenderLayerParent<CivilianRevenantRenderState, CivilianRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, CivilianRevenantRenderState pRenderState, float pYRot, float pXRot) {
		pSubmitNodeCollector.submitModel(this.getParentModel(), pRenderState, pPoseStack, IcariaRenderTypes.CIVILIAN_REVENANT_EMISSIVE, LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getLightBasedColorAndAlpha(pRenderState.livingEntity), null, pRenderState.outlineColor, null);
	}
}
