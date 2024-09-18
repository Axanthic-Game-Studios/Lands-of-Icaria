package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaItems;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderBlockRenderer implements BlockEntityRenderer<GrinderBlockEntity> {
	public long prevTime;

	public GrinderBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS.get();
	}

	@Override
	public void render(GrinderBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		if (IcariaConfig.RENDER_GRINDER_GEARS.get()) {
			var state = pBlockEntity.getBlockState();

			var gear = pBlockEntity.getGear();

			var level = pBlockEntity.getLevel();

			var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

			var grinding = state.getValue(IcariaBlockStateProperties.GRINDER_GRINDING);

			var minecraft = Minecraft.getInstance();

			var renderer = Minecraft.getInstance().getItemRenderer();

			if (level != null) {
				long gameTime = level.getGameTime();

				float time = Mth.lerp(minecraft.getTimer().getGameTimeDeltaTicks(), this.prevTime, gameTime) * -16.0F;

				this.prevTime = gameTime;

				// STONE

				pPoseStack.pushPose();
				pPoseStack.translate(0.5F, 0.5F, 0.5F);
				pPoseStack.scale(2.0F, 2.0F, 2.0F);
				if (grinding) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(time));
				}

				renderer.renderStatic(new ItemStack(IcariaItems.GRINDER_STONE.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				pPoseStack.popPose();

				// SHAFT

				pPoseStack.pushPose();
				if (facing == Direction.NORTH) {
					pPoseStack.translate(-0.5F, 0.5F, 0.5F);
					pPoseStack.scale(2.0F, 2.0F, 2.0F);
				} else if (facing == Direction.EAST) {
					pPoseStack.translate(0.5, 0.5F, -0.5F);
					pPoseStack.scale(2.0F, 2.0F, 2.0F);
				} else if (facing == Direction.SOUTH) {
					pPoseStack.translate(1.5F, 0.5F, 0.5F);
					pPoseStack.scale(2.0F, 2.0F, 2.0F);
				} else if (facing == Direction.WEST) {
					pPoseStack.translate(0.5F, 0.5F, 1.5F);
					pPoseStack.scale(2.0F, 2.0F, 2.0F);
				}

				if (grinding) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(time));
				}

				renderer.renderStatic(new ItemStack(IcariaItems.GRINDER_SHAFT.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				pPoseStack.popPose();

				// LEFT CHAIN

				pPoseStack.pushPose();
				if (facing == Direction.NORTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(0.5F, 0.4050F, 0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				} else if (facing == Direction.EAST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
					pPoseStack.translate(0.5F, 0.4050F, -0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				} else if (facing == Direction.SOUTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
					pPoseStack.translate(-0.5F, 0.4050F, -0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				} else if (facing == Direction.WEST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
					pPoseStack.translate(-0.5F, 0.4050F, 0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				}

				if (grinding) {
					renderer.renderStatic(new ItemStack(IcariaItems.LEFT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				} else {
					renderer.renderStatic(new ItemStack(IcariaItems.STATIC_LEFT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				}

				pPoseStack.popPose();

				// RIGHT CHAIN

				pPoseStack.pushPose();
				if (facing == Direction.NORTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(-0.5F, 0.4050F, 0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				} else if (facing == Direction.EAST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
					pPoseStack.translate(-0.5F, 0.4050F, -0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				} else if (facing == Direction.SOUTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
					pPoseStack.translate(-1.5F, 0.4050F, -0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				} else if (facing == Direction.WEST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
					pPoseStack.translate(-1.5F, 0.4050F, 0.5F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
					pPoseStack.scale(1.0F, 1.0F, 1.0F);
				}

				if (grinding) {
					renderer.renderStatic(new ItemStack(IcariaItems.RIGHT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				} else {
					renderer.renderStatic(new ItemStack(IcariaItems.STATIC_RIGHT_GRINDER_CHAIN.get()), ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				}

				pPoseStack.popPose();

				// GEAR

				pPoseStack.pushPose();
				if (facing == Direction.NORTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(-0.5F, 0.3425F, 0.5F);
					pPoseStack.scale(0.625F, 1.0F, 0.625F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				} else if (facing == Direction.EAST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(0.5F, 0.3425F, -0.5F);
					pPoseStack.scale(0.625F, 1.0F, 0.625F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				} else if (facing == Direction.SOUTH) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(1.5F, 0.3425F, 0.5F);
					pPoseStack.scale(0.625F, 1.0F, 0.625F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				} else if (facing == Direction.WEST) {
					pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
					pPoseStack.translate(0.5F, 0.3425F, 1.5F);
					pPoseStack.scale(0.625F, 1.0F, 0.625F);
					pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				}

				if (grinding) {
					pPoseStack.mulPose(Axis.ZN.rotationDegrees(time));
				}

				if (!gear.isEmpty()) {
					renderer.renderStatic(gear, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
				}

				pPoseStack.popPose();
			}
		}
	}

	@Override
	public AABB getRenderBoundingBox(GrinderBlockEntity pBlockEntity) {
		return AABB.INFINITE;
	}
}
