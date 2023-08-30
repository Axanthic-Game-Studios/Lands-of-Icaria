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
		// NOOP
	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS.get();
	}

	@Override
	public void render(GrinderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (IcariaConfig.RENDER_GRINDER_GEARS.get()) {
			boolean grinding = pBlockEntity.getBlockState().getValue(IcariaBlockStateProperties.GRINDING);

			int rotation = pBlockEntity.getBlockState().getValue(IcariaBlockStateProperties.GRINDER_ROTATION) * rotationModifier;

			var direction = pBlockEntity.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
			var itemRenderer = Minecraft.getInstance().getItemRenderer();
			var level = pBlockEntity.getLevel();
			var mainGear = pBlockEntity.getGear();
			var sideGear = ItemStack.EMPTY;

			if (!mainGear.isEmpty()) {
				if (mainGear.is(IcariaItems.YELLOWSTONE_GEAR.get())) {
					sideGear = new ItemStack(IcariaItems.SMALL_YELLOWSTONE_GEAR.get());
				} else if (mainGear.is(IcariaItems.LOAM_GEAR.get())) {
					sideGear = new ItemStack(IcariaItems.SMALL_LOAM_GEAR.get());
				} else if (mainGear.is(IcariaItems.VOIDSHALE_GEAR.get())) {
					sideGear = new ItemStack(IcariaItems.SMALL_VOIDSHALE_GEAR.get());
				} else if (mainGear.is(IcariaItems.VANADIUM_GEAR.get())) {
					sideGear = new ItemStack(IcariaItems.SMALL_VANADIUM_GEAR.get());
				} else if (mainGear.is(IcariaItems.DAEDALIAN_GEAR.get())) {
					sideGear = new ItemStack(IcariaItems.SMALL_DAEDALIAN_GEAR.get());
				}

				pPoseStack.pushPose();
				pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
				pPoseStack.translate(-0.5F, 0.5F, 0.9F);
				pPoseStack.scale(0.625F, 0.625F, 1.0F);

				if (grinding) {
					pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				}

				itemRenderer.renderStatic(mainGear, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
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
					pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				}

				itemRenderer.renderStatic(sideGear, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
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
					pPoseStack.mulPose(Axis.ZP.rotationDegrees(rotation));
				}

				itemRenderer.renderStatic(sideGear, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				pPoseStack.popPose();
			}
		}
	}
}
