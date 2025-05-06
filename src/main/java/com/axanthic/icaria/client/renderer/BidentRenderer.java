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
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentRenderer extends EntityRenderer<BidentEntity, BidentRenderState> {
	public ItemModelResolver itemModelResolver;

	public BidentRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
		this.itemModelResolver = pContext.getItemModelResolver();
	}

	@Override
	public void extractRenderState(BidentEntity pEntity, BidentRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.xRot = pEntity.getXRot(pPartialTick);
		pRenderState.yRot = pEntity.getYRot(pPartialTick);
		pRenderState.itemStack = pEntity.getStack();
		pRenderState.itemStackRenderState = new ItemStackRenderState();
		this.itemModelResolver.updateForNonLiving(pRenderState.itemStackRenderState, pRenderState.itemStack, ItemDisplayContext.NONE, pEntity);
	}

	@Override
	public void render(BidentRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		pPoseStack.pushPose();
		pPoseStack.translate(0.0F, 0.25F, 0.0F);
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pRenderState.yRot - 90.0F));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(pRenderState.xRot - 45.0F));
		pRenderState.itemStackRenderState.render(pPoseStack, pMultiBufferSource, pPackedLight, OverlayTexture.NO_OVERLAY);
		pPoseStack.popPose();
		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
	}

	@Override
	public BidentRenderState createRenderState() {
		return new BidentRenderState();
	}
}
