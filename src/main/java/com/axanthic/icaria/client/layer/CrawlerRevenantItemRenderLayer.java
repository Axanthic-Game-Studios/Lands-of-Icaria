package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.model.CrawlerRevenantModel;
import com.axanthic.icaria.client.state.CrawlerRevenantRenderState;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.HumanoidArm;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantItemRenderLayer extends RenderLayer<CrawlerRevenantRenderState, CrawlerRevenantModel> {
	public CrawlerRevenantItemRenderLayer(RenderLayerParent<CrawlerRevenantRenderState, CrawlerRevenantModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, CrawlerRevenantRenderState pRenderState, float yRot, float xRot) {
		pPoseStack.pushPose();
		this.getParentModel().translateToHand(pRenderState, HumanoidArm.RIGHT, pPoseStack);
		IcariaClientHelper.setPart(pPoseStack, this.getParentModel().armRightLower);
		IcariaClientHelper.setPositionAndRotation(pPoseStack, -0.090F, 0.045F, -0.040F, 260.0F, 180.0F, 0.0F);
		pRenderState.itemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pPackedLight, OverlayTexture.NO_OVERLAY, 0);
		pPoseStack.popPose();
	}
}
