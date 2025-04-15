package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.state.BidentRenderState;
import com.axanthic.icaria.common.entity.BidentEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentRenderer extends EntityRenderer<BidentEntity, BidentRenderState> {
	public ItemRenderer itemRenderer;

	public BidentRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
		this.itemRenderer = pContext.getItemRenderer();
	}

	@Override
	public void extractRenderState(BidentEntity pEntity, BidentRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.xRot = pEntity.getXRot(pPartialTick);
		pRenderState.yRot = pEntity.getYRot(pPartialTick);
		pRenderState.bakedModel = this.itemRenderer.getModel(pEntity.getStack(), pEntity.level(), null, pEntity.getId());
		pRenderState.itemStack = pEntity.getStack();
	}

	@Override
	public void render(BidentRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		pPoseStack.pushPose();
		pPoseStack.translate(0.0F, 0.25F, 0.0F);
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pRenderState.yRot - 90.0F));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(pRenderState.xRot - 45.0F));
		this.itemRenderer.render(pRenderState.itemStack, ItemDisplayContext.NONE, false, pPoseStack, pMultiBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY, pRenderState.bakedModel);
		pPoseStack.popPose();
		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
	}

	@Override
	public BidentRenderState createRenderState() {
		return new BidentRenderState();
	}
}
