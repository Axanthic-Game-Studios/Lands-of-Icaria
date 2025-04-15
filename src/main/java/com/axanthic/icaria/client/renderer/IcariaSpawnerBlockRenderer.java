package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.entity.IcariaSpawnerBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.util.Mth;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSpawnerBlockRenderer implements BlockEntityRenderer<IcariaSpawnerBlockEntity> {
	public EntityRenderDispatcher entityRenderDispatcher;

	public IcariaSpawnerBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		this.entityRenderDispatcher = pContext.getEntityRenderer();
	}

	@Override
	public void render(IcariaSpawnerBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay) {
		var baseSpawner = pBlockEntity.getSpawner();
		var level = pBlockEntity.getLevel();
		if (level != null) {
			var entity = baseSpawner.getOrCreateDisplayEntity(level, pBlockEntity.getBlockPos());
			if (entity != null) {
				var scale = 0.4F / Math.max(entity.getBbHeight(), entity.getBbWidth());
				pPoseStack.pushPose();
				pPoseStack.translate(0.5F, 0.5F - entity.getBbHeight() * scale * 0.5F, 0.5F);
				pPoseStack.scale(scale, scale, scale);
				pPoseStack.mulPose(Axis.YP.rotationDegrees((float) Mth.lerp(pPartialTick, baseSpawner.getoSpin(), baseSpawner.getSpin()) * 10.0F));
				pPoseStack.mulPose(Axis.XP.rotationDegrees(30.0F));
				this.entityRenderDispatcher.render(entity, 0.0D, 0.0D, 0.0D, pPartialTick, pPoseStack, pMultiBufferSource, pPackedLight);
				pPoseStack.popPose();
			}
		}
	}
}
