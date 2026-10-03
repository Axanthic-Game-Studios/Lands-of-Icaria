package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaContextKeys;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BarrelRenderLayer extends RenderLayer<AvatarRenderState, PlayerModel> {
	public BarrelRenderLayer(RenderLayerParent<AvatarRenderState, PlayerModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pLightCoords, AvatarRenderState pRenderState, float pYRot, float pXRot) {
		if (pRenderState.getRenderDataOrThrow(IcariaContextKeys.BARREL)) {
			pPoseStack.pushPose();
			pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
			pPoseStack.translate(-0.5D, 0.5D, -0.5D);
			pRenderState.getRenderDataOrThrow(IcariaContextKeys.BARREL_BLOCK_MODEL_RENDER_STATE).submit(pPoseStack, pSubmitNodeCollector, pRenderState.lightCoords, OverlayTexture.NO_OVERLAY, pRenderState.outlineColor);
			pPoseStack.popPose();
		}
	}
}
