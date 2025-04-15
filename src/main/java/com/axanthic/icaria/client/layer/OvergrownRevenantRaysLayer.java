package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.OvergrownRevenantModel;
import com.axanthic.icaria.client.state.OvergrownRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OvergrownRevenantRaysLayer extends RenderLayer<OvergrownRevenantRenderState, OvergrownRevenantModel> {
	public OvergrownRevenantRaysLayer(RenderLayerParent<OvergrownRevenantRenderState, OvergrownRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void render(PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, OvergrownRevenantRenderState pRenderState, float pYRot, float pXRot) {
		this.biceps(pRenderState, pPoseStack, pMultiBufferSource);
		this.foot(pRenderState, pPoseStack, pMultiBufferSource);
		this.head(pRenderState, pPoseStack, pMultiBufferSource);
		this.pelvis(pRenderState, pPoseStack, pMultiBufferSource);
		this.shoulder(pRenderState, pPoseStack, pMultiBufferSource);
	}

	public void biceps(OvergrownRevenantRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToBiceps(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armLeftUpper);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.350F, 0.150F, -0.075F, 0.250F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void foot(OvergrownRevenantRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToFoot(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().legLeft);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.0F, -0.150F, 0.0F, 0.250F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void head(OvergrownRevenantRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHead(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().headMain);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.075F, 0.150F, -0.225F, 0.375F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void pelvis(OvergrownRevenantRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToPelvis(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.200F, -0.025F, 0.100F, 0.250F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void shoulder(OvergrownRevenantRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource) {
		pPoseStack.pushPose();
		this.getParentModel().translateToShoulder(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.300F, -0.050F, 0.075F, 0.250F);
		IcariaClientHelper.renderRays(pPoseStack, pMultiBufferSource, pRenderState.livingEntity, pRenderState.partialTick, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}
}
