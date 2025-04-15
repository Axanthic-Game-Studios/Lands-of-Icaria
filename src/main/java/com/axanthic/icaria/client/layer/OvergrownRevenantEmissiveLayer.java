package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.OvergrownRevenantModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.OvergrownRevenantRenderState;

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

public class OvergrownRevenantEmissiveLayer extends RenderLayer<OvergrownRevenantRenderState, OvergrownRevenantModel> {
	public OvergrownRevenantEmissiveLayer(RenderLayerParent<OvergrownRevenantRenderState, OvergrownRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, OvergrownRevenantRenderState pRenderState, float pYRot, float pXRot) {
		this.getParentModel().renderToBuffer(pPoseStack, pMultiBufferSource.getBuffer(IcariaRenderTypes.OVERGROWN_REVENANT_EMISSIVE), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.partialTick));
	}
}
