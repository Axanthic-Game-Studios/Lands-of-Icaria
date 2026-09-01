package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CivilianRevenantModel;
import com.axanthic.icaria.client.state.CivilianRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CivilianRevenantItemRenderLayer extends RenderLayer<CivilianRevenantRenderState, CivilianRevenantModel> {
	public CivilianRevenantItemRenderLayer(RenderLayerParent<CivilianRevenantRenderState, CivilianRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, CivilianRevenantRenderState pRenderState, float yRot, float xRot) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(pRenderState, HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, 0.050F, 0.030F, 0.060F, 260.0F, 180.0F, 0.0F);
		pRenderState.itemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pPackedLight, OverlayTexture.NO_OVERLAY, 0);
		pPoseStack.popPose();
	}
}
