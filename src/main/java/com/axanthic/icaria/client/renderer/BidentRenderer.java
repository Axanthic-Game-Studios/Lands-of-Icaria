package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.BidentEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BidentRenderer extends EntityRenderer<BidentEntity> {
	public ItemRenderer itemRenderer;

	public BidentRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
		this.itemRenderer = pContext.getItemRenderer();
	}

	@Override
	public void render(BidentEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

		var bakedModel = this.itemRenderer.getModel(pEntity.getStack(), pEntity.level(), null, pEntity.getId());

		pMatrixStack.pushPose();
		pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
		pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) - 45.0F));
		pMatrixStack.translate(0.0D, 0.0D, 0.0D);

		this.itemRenderer.render(pEntity.getStack(), ItemDisplayContext.NONE, false, pMatrixStack, pBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, bakedModel);

		pMatrixStack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(BidentEntity pEntity) {
		return InventoryMenu.BLOCK_ATLAS;
	}
}
