package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.block.GrinderBlock;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

public class GrinderBlockRenderer implements BlockEntityRenderer<GrinderBlockEntity> {
	public int rotationModifier = -16;

	public GrinderBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_GEARS.get();
	}

	@Override
	public void render(GrinderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (IcariaConfig.RENDER_GEARS.get()) {
			boolean grinding = pBlockEntity.getBlockState().getValue(GrinderBlock.GRINDING);
			int rotation = pBlockEntity.getBlockState().getValue(GrinderBlock.ROTATION);

			Direction direction = pBlockEntity.getBlockState().getValue(GrinderBlock.FACING);
			ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
			ItemStack mainGear = pBlockEntity.getGear();
			ItemStack sideGear = ItemStack.EMPTY;
			LocalPlayer localPlayer = Minecraft.getInstance().player;

			if (!mainGear.isEmpty()) {
				if (mainGear.is(IcariaItems.GEAR_YELLOWSTONE.get())) {
					sideGear = new ItemStack(IcariaItems.GEAR_YELLOWSTONE_SMALL.get());
				} else if (mainGear.is(IcariaItems.GEAR_LOAM.get())) {
					sideGear = new ItemStack(IcariaItems.GEAR_LOAM_SMALL.get());
				} else if (mainGear.is(IcariaItems.GEAR_VOIDSHALE.get())) {
					sideGear = new ItemStack(IcariaItems.GEAR_VOIDSHALE_SMALL.get());
				} else if (mainGear.is(IcariaItems.GEAR_VANADIUM.get())) {
					sideGear = new ItemStack(IcariaItems.GEAR_VANADIUM_SMALL.get());
				} else if (mainGear.is(IcariaItems.GEAR_DAEDALIAN.get())) {
					sideGear = new ItemStack(IcariaItems.GEAR_DAEDALIAN_SMALL.get());
				}

				pPoseStack.pushPose();
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
				pPoseStack.translate(-0.5F, 0.5F, 0.9F);
				pPoseStack.scale(0.625F, 0.625F, 1.0F);

				if (grinding) {
					pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation * rotationModifier));
				}

				itemRenderer.renderStatic(mainGear, ItemTransforms.TransformType.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, 1);
				pPoseStack.popPose();

				pPoseStack.pushPose();
				if (direction == Direction.NORTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(0.6575, 0.40625, 0.95F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(0.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				} else if (direction == Direction.EAST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
					pPoseStack.translate(-0.6575, 0.40625, 0.05F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				} else if (direction == Direction.SOUTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
					pPoseStack.translate(-0.3425F, 0.40625, -0.05F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(0.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				} else if (direction == Direction.WEST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
					pPoseStack.translate(0.3425F, 0.40625, -0.95F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				}

				if (grinding) {
					pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation * rotationModifier));
				}

				itemRenderer.renderStatic(sideGear, ItemTransforms.TransformType.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, 1);
				pPoseStack.popPose();

				pPoseStack.pushPose();
				if (direction == Direction.NORTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(0.3425F, 0.40625, 0.05F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				} else if (direction == Direction.EAST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
					pPoseStack.translate(-0.3425F, 0.40625, 0.95F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(0.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				} else if (direction == Direction.SOUTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
					pPoseStack.translate(-0.6575, 0.40625, -0.95F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				} else if (direction == Direction.WEST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
					pPoseStack.translate(0.6575, 0.40625, -0.05F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(0.0F));
					pPoseStack.scale(0.4375F, 0.4375F, 0.5F);
				}

				if (grinding) {
					pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation * rotationModifier));
				}

				itemRenderer.renderStatic(sideGear, ItemTransforms.TransformType.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, 1);
				pPoseStack.popPose();
			}
		}
	}
}
