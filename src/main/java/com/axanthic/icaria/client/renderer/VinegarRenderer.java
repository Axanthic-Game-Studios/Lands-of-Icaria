package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.VinegarEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class VinegarRenderer extends EntityRenderer<VinegarEntity> {
    public ItemRenderer itemRenderer;

    public VinegarRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.itemRenderer = pContext.getItemRenderer();
    }

    @Override
    public void render(VinegarEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        BakedModel bakedModel = this.itemRenderer.getModel(pEntity.getItem(), pEntity.level, null, pEntity.getId());

        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot())));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot())));
        pMatrixStack.translate(0.0, 0.25, 0);

        this.itemRenderer.render(pEntity.getItem(), ItemDisplayContext.NONE, false, pMatrixStack, pBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, bakedModel);

        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(VinegarEntity pEntity) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
