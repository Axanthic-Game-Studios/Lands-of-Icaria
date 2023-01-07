package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.GreekFireGrenadeEntity;

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

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GreekFireGrenadeRenderer extends EntityRenderer<GreekFireGrenadeEntity> {
    public ItemRenderer renderer;

    public GreekFireGrenadeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.renderer = pContext.getItemRenderer();
    }

    @Override
    public void render(GreekFireGrenadeEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);

        BakedModel bakedModel = this.renderer.getModel(pEntity.getItem(), pEntity.level, null, pEntity.getId());

        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) - 45.0F));
        pMatrixStack.translate(-0.15, -0.15, 0);

        this.renderer.render(pEntity.getItem(), ItemTransforms.TransformType.NONE, false, pMatrixStack, pBuffer, pPackedLight, OverlayTexture.NO_OVERLAY, bakedModel);

        pMatrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(GreekFireGrenadeEntity pEntity) {
        return InventoryMenu.BLOCK_ATLAS;
    }
}
