package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

public class GrinderBlockRenderer implements BlockEntityRenderer<GrinderBlockEntity> {
	public int rotationModifier = -16;

	public GrinderBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS.get();
	}

	@Override
	public void render(GrinderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (IcariaConfig.RENDER_GRINDER_GEARS.get()) {
			boolean grinding = pBlockEntity.getBlockState().getValue(IcariaBlockStateProperties.GRINDER_GRINDING);

			int rotation = pBlockEntity.getBlockState().getValue(IcariaBlockStateProperties.GRINDER_ROTATION) * rotationModifier;

			var direction = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
			var itemRenderer = Minecraft.getInstance().getItemRenderer();
			var level = pBlockEntity.getLevel();
			var mainGear = pBlockEntity.getGear();

			// STONE

			pPoseStack.pushPose();
			pPoseStack.translate(0.5, 0.5F, 0.5F);
			pPoseStack.scale(2.0F, 2.0F, 2.0F);
			if (grinding) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(rotation));
			}

			itemRenderer.renderStatic(new ItemStack(IcariaItems.GRINDER_STONE.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
			pPoseStack.popPose();

			// SHAFT

			pPoseStack.pushPose();
			if (direction == Direction.NORTH) {
				pPoseStack.translate(-0.5, 0.5F, 0.5F);
				pPoseStack.scale(2.0F, 2.0F, 2.0F);
			} else if (direction == Direction.EAST) {
				pPoseStack.translate(0.5, 0.5F, -0.5F);
				pPoseStack.scale(2.0F, 2.0F, 2.0F);
			} else if (direction == Direction.SOUTH) {
				pPoseStack.translate(1.5, 0.5F, 0.5F);
				pPoseStack.scale(2.0F, 2.0F, 2.0F);
			} else if (direction == Direction.WEST) {
				pPoseStack.translate(0.5, 0.5F, 1.5F);
				pPoseStack.scale(2.0F, 2.0F, 2.0F);
			}

			if (grinding) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(rotation));
			}

			itemRenderer.renderStatic(new ItemStack(IcariaItems.GRINDER_SHAFT.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
			pPoseStack.popPose();

			// LEFT CHAIN

			pPoseStack.pushPose();
			if (direction == Direction.NORTH) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
				pPoseStack.translate(0.5, 0.4050F, 0.5F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			} else if (direction == Direction.EAST) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
				pPoseStack.translate(0.5F, 0.4050F, -0.5F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			} else if (direction == Direction.SOUTH) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
				pPoseStack.translate(-0.5, 0.4050F, -0.5F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			} else if (direction == Direction.WEST) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
				pPoseStack.translate(-0.5F, 0.4050F, 0.5);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			}

			if (grinding) {
				itemRenderer.renderStatic(new ItemStack(IcariaItems.LEFT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
			} else {
				itemRenderer.renderStatic(new ItemStack(IcariaItems.STATIC_LEFT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
			}

			pPoseStack.popPose();

			// RIGHT CHAIN

			pPoseStack.pushPose();
			if (direction == Direction.NORTH) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
				pPoseStack.translate(-0.5, 0.4050F, 0.5F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			} else if (direction == Direction.EAST) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
				pPoseStack.translate(-0.5F, 0.4050F, -0.5F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			} else if (direction == Direction.SOUTH) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
				pPoseStack.translate(-1.5, 0.4050F, -0.5F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			} else if (direction == Direction.WEST) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
				pPoseStack.translate(-1.5F, 0.4050F, 0.5);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.scale(1.0F, 1.0F, 1.0F);
			}

			if (grinding) {
				itemRenderer.renderStatic(new ItemStack(IcariaItems.RIGHT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
			} else {
				itemRenderer.renderStatic(new ItemStack(IcariaItems.STATIC_RIGHT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
			}

			pPoseStack.popPose();

			// GEAR

			pPoseStack.pushPose();
			if (direction == Direction.NORTH) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
				pPoseStack.translate(-0.5, 0.3425F, 0.5F);
				pPoseStack.scale(0.625F, 1.0F, 0.625F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			} else if (direction == Direction.EAST) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
				pPoseStack.translate(0.5, 0.3425F, -0.5F);
				pPoseStack.scale(0.625F, 1.0F, 0.625F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			} else if (direction == Direction.SOUTH) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
				pPoseStack.translate(1.5, 0.3425F, 0.5F);
				pPoseStack.scale(0.625F, 1.0F, 0.625F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			} else if (direction == Direction.WEST) {
				pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
				pPoseStack.translate(0.5, 0.3425F, 1.5F);
				pPoseStack.scale(0.625F, 1.0F, 0.625F);
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
			}

			if (grinding) {
				pPoseStack.mulPose(Axis.ZN.rotationDegrees(rotation));
			}

			if (!mainGear.isEmpty()) {
				itemRenderer.renderStatic(mainGear, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
			}

			pPoseStack.popPose();
		}
	}
}
