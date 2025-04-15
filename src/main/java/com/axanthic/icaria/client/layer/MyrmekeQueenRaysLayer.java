package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.client.state.MyrmekeQueenRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeQueenRaysLayer extends RenderLayer<MyrmekeQueenRenderState, MyrmekeQueenModel> {
	public MyrmekeQueenRaysLayer(RenderLayerParent<MyrmekeQueenRenderState, MyrmekeQueenModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, MyrmekeQueenRenderState pRenderState, float pYRot, float pXRot) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHead(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().head);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.010F, -1.265F, 0.185F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}
}
