package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.common.registry.IcariaContextKeys;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseRenderLayer extends RenderLayer<AvatarRenderState, PlayerModel> {
	public LootVaseRenderLayer(RenderLayerParent<AvatarRenderState, PlayerModel> pRenderLayerParent) {
		super(pRenderLayerParent);
	}

	@Override
	public void submit(PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, int pPackedLight, AvatarRenderState pRenderState, float pYRot, float pXRot) {
		if (pRenderState.getRenderDataOrThrow(IcariaContextKeys.LOOT_VASE)) {
			pPoseStack.pushPose();
			pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
			pPoseStack.translate(-0.5D, 0.5D, -0.5D);
			pSubmitNodeCollector.submitBlock(pPoseStack, pRenderState.getRenderDataOrThrow(IcariaContextKeys.LOOT_VASE_BLOCK_STATE), pPackedLight, OverlayTexture.NO_OVERLAY, pRenderState.outlineColor);
			pPoseStack.popPose();
		}
	}
}
