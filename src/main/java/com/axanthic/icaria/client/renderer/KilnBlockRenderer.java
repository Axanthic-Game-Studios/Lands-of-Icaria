package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.block.entity.KilnBlockEntity;
import com.axanthic.icaria.common.config.IcariaConfig;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class KilnBlockRenderer implements BlockEntityRenderer<KilnBlockEntity> {
	public KilnBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_KILN_ITEMS.get();
	}

	@Override
	public void render(KilnBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (IcariaConfig.RENDER_KILN_ITEMS.get()) {
			float rotation = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + 180.0F;

			var fuel = pBlockEntity.getFuel();
			var input = pBlockEntity.getInput();
			var itemRenderer = Minecraft.getInstance().getItemRenderer();
			var level = pBlockEntity.getLevel();

			if (!fuel.isEmpty()) {
				pPoseStack.pushPose();
				pPoseStack.translate(0.5F, 0.2F, 0.5F);
				pPoseStack.scale(0.25F, 0.25F, 0.25F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				itemRenderer.renderStatic(fuel, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				pPoseStack.popPose();
			}

			if (!input.isEmpty()) {
				pPoseStack.pushPose();
				pPoseStack.translate(0.5F, 0.635F, 0.5F);
				pPoseStack.scale(0.25F, 0.25F, 0.25F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				itemRenderer.renderStatic(input, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				pPoseStack.popPose();
			}
		}
	}
}
