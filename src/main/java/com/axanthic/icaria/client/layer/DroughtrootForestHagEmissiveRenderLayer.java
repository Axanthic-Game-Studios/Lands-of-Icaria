package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.DroughtrootForestHagModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.DroughtrootForestHagRenderState;

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

public class DroughtrootForestHagEmissiveRenderLayer extends RenderLayer<DroughtrootForestHagRenderState, DroughtrootForestHagModel> {
	public DroughtrootForestHagEmissiveRenderLayer(RenderLayerParent<DroughtrootForestHagRenderState, DroughtrootForestHagModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, DroughtrootForestHagRenderState pRenderState, float pYRot, float pXRot) {
		pSubmitNodeCollector.submitModel(this.getParentModel(), pRenderState, pPoseStack, IcariaRenderTypes.DROUGHTROOT_FOREST_HAG_EMISSIVE, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.aggressive), null, pRenderState.outlineColor, null);
	}
}
