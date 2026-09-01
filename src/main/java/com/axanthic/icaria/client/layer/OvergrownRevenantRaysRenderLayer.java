package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.OvergrownRevenantModel;
import com.axanthic.icaria.client.state.OvergrownRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OvergrownRevenantRaysRenderLayer extends RenderLayer<OvergrownRevenantRenderState, OvergrownRevenantModel> {
	public OvergrownRevenantRaysRenderLayer(RenderLayerParent<OvergrownRevenantRenderState, OvergrownRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, OvergrownRevenantRenderState pRenderState, float pYRot, float pXRot) {
		this.biceps(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.foot(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.head(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.pelvis(pPoseStack, pRenderState, pSubmitNodeCollector);
		this.shoulder(pPoseStack, pRenderState, pSubmitNodeCollector);
	}

	public void biceps(PoseStack pPoseStack, OvergrownRevenantRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToBiceps(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armLeftUpper);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.350F, 0.150F, -0.075F, 0.250F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void foot(PoseStack pPoseStack, OvergrownRevenantRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToFoot(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().legLeft);
		IcariaClientHelper.setPositionAndSize(pPoseStack, 0.0F, -0.150F, 0.0F, 0.250F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void head(PoseStack pPoseStack, OvergrownRevenantRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHead(pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().headMain);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.075F, 0.150F, -0.225F, 0.375F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void pelvis(PoseStack pPoseStack, OvergrownRevenantRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToPelvis(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.200F, -0.025F, 0.100F, 0.250F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}

	public void shoulder(PoseStack pPoseStack, OvergrownRevenantRenderState pRenderState, SubmitNodeCollector pSubmitNodeCollector) {
		pPoseStack.pushPose();
		this.getParentModel().translateToShoulder(pPoseStack);
		IcariaClientHelper.setPositionAndSize(pPoseStack, -0.300F, -0.050F, 0.075F, 0.250F);
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRenderState.livingEntity, pRenderState.red, pRenderState.green, pRenderState.blue);
		pPoseStack.popPose();
	}
}
