package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.ForgeBlockEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

public class ForgeBlockRenderer implements BlockEntityRenderer<ForgeBlockEntity> {
	public ForgeBlockRenderer(BlockEntityRendererProvider.Context pContext) {
		// NOOP
	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_FORGE_ITEMS.get();
	}

	@Override
	public void render(ForgeBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (IcariaConfig.RENDER_FORGE_ITEMS.get()) {
			var facing = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
			var fuel = pBlockEntity.getFuel();
			var outputA = pBlockEntity.getOutputA();
			var outputB = pBlockEntity.getOutputB();

			float rotation = facing.toYRot() + 180.0F;

			if (!fuel.isEmpty()) {
				pPoseStack.pushPose();
				if (facing == Direction.NORTH) {
					pPoseStack.translate(0.0F, 0.15F, 0.5F);
				} else if (facing == Direction.EAST) {
					pPoseStack.translate(0.5F, 0.15F, 0.0F);
				} else if (facing == Direction.SOUTH) {
					pPoseStack.translate(1.0F, 0.15F, 0.5F);
				} else if (facing == Direction.WEST) {
					pPoseStack.translate(0.5F, 0.15F, 1.0F);
				}

				pPoseStack.scale(0.5F, 0.5F, 0.5F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				Minecraft.getInstance().getItemRenderer().renderStatic(fuel, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
				pPoseStack.popPose();
			}

			if (!outputA.isEmpty()) {
				pPoseStack.pushPose();
				if (facing == Direction.NORTH) {
					pPoseStack.translate(0.5125F, 1.2F, 0.3875);
				} else if (facing == Direction.EAST) {
					pPoseStack.translate(0.6125, 1.2F, 0.5125F);
				} else if (facing == Direction.SOUTH) {
					pPoseStack.translate(0.4875, 1.2F, 0.6125);
				} else if (facing == Direction.WEST) {
					pPoseStack.translate(0.3875, 1.2F, 0.4875);
				}

				pPoseStack.scale(0.375F, 0.375F, 0.375F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				Minecraft.getInstance().getItemRenderer().renderStatic(outputA, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
				pPoseStack.popPose();
			}

			if (!outputB.isEmpty()) {
				pPoseStack.pushPose();
				if (facing == Direction.NORTH) {
					pPoseStack.translate(0.0, 0.9F, 0.3875);
				} else if (facing == Direction.EAST) {
					pPoseStack.translate(0.6125, 0.9F, 0.0);
				} else if (facing == Direction.SOUTH) {
					pPoseStack.translate(1.0, 0.9F, 0.6125);
				} else if (facing == Direction.WEST) {
					pPoseStack.translate(0.3875, 0.9F, 1.0);
				}

				pPoseStack.scale(0.375F, 0.375F, 0.375F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				Minecraft.getInstance().getItemRenderer().renderStatic(outputB, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, pBlockEntity.getLevel(), 1);
				pPoseStack.popPose();
			}
		}
	}
}
