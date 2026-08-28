package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.PyromancerRevenantModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.PyromancerRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PyromancerRevenantEmissiveRenderLayer extends RenderLayer<PyromancerRevenantRenderState, PyromancerRevenantModel> {
	public PyromancerRevenantEmissiveRenderLayer(RenderLayerParent<PyromancerRevenantRenderState, PyromancerRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, PyromancerRevenantRenderState pRenderState, float pYRot, float pXRot) {
		pSubmitNodeCollector.submitModel(this.getParentModel(), pRenderState, pPoseStack, IcariaRenderTypes.PYROMANCER_REVENANT_EMISSIVE, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.partialTick), null, pRenderState.outlineColor, null);
	}
}
