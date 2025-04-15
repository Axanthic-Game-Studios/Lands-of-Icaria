package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.MyrmekeDroneModel;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.MyrmekeDroneRenderState;

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

public class MyrmekeDroneEmissiveLayer extends RenderLayer<MyrmekeDroneRenderState, MyrmekeDroneModel> {
	public MyrmekeDroneEmissiveLayer(RenderLayerParent<MyrmekeDroneRenderState, MyrmekeDroneModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, MyrmekeDroneRenderState pRenderState, float pYRot, float pXRot) {
		this.getParentModel().renderToBuffer(pPoseStack, pMultiBufferSource.getBuffer(IcariaRenderTypes.MYRMEKE_DRONE_EMISSIVE), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, IcariaClientHelper.getColorAndAlpha(pRenderState.livingEntity, pRenderState.partialTick));
	}
}
