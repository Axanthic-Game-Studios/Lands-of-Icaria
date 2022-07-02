package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.BidentEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@OnlyIn(Dist.CLIENT)
public class BidentRenderer extends EntityRenderer<BidentEntity> {
	public ItemRenderer itemRenderer;

	public BidentRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
		this.itemRenderer = pContext.getItemRenderer();
	}

	@Override
	public void render(BidentEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
		pMatrixStack.pushPose();
		pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
		pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) - 45.0F));
		pMatrixStack.translate(-0.15, -0.15, 0);
		BakedModel model = this.itemRenderer.getModel(pEntity.getContainedItem(), pEntity.level, null, pEntity.getId());
		this.itemRenderer.render(pEntity.getContainedItem(), ItemTransforms.TransformType.NONE, false, pMatrixStack, pBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, model);
		pMatrixStack.popPose();
		super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
	}

	@Override
	public ResourceLocation getTextureLocation(BidentEntity pEntity) {
		return InventoryMenu.BLOCK_ATLAS;
	}
}
