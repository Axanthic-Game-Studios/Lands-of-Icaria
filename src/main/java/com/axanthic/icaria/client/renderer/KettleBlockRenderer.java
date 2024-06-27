package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.KettleBlockEntity;
import com.axanthic.icaria.common.properties.Kettle;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

public class KettleBlockRenderer implements BlockEntityRenderer<KettleBlockEntity> {
	public long prevTime;

	public KettleBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_KETTLE_ITEMS.get();
	}

	@Override
	public void render(KettleBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		var state = pBlockEntity.getBlockState();

		var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

		var ingA = pBlockEntity.getIngA();
		var ingB = pBlockEntity.getIngB();
		var ingC = pBlockEntity.getIngC();

		var level = pBlockEntity.getLevel();

		var minecraft = Minecraft.getInstance();

		var itemRenderer = minecraft.getItemRenderer();

		if (level != null) {
			long gameTime = level.getGameTime();

			float time = Mth.lerp(minecraft.getTimer().getGameTimeDeltaTicks(), this.prevTime, gameTime) * -2.0F;

			float radius = 0.15F;
			float scale = 0.125F;
			float speed = 0.025F;

			float yLevel = 0.550F;
			float yRange = 0.025F;
			float ySpeed = 0.025F;

			this.prevTime = gameTime;

			if (state.getBlock() instanceof KettleBlock kettleBlock) {
				double x = kettleBlock.getX(state);
				double z = kettleBlock.getZ(state);

				if (state.getValue(IcariaBlockStateProperties.KETTLE) != Kettle.EMPTY) {
					if (facing == Direction.NORTH) {
						this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.25F, 0.75F, 0.09375F, 0.59375F, pPackedLight, pPackedOverlay);
					} else if (facing == Direction.EAST) {
						this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.40625F, 0.90625F, 0.25F, 0.75F, pPackedLight, pPackedOverlay);
					} else if (facing == Direction.SOUTH) {
						this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.25F, 0.75F, 0.40625F, 0.90625F, pPackedLight, pPackedOverlay);
					} else if (facing == Direction.WEST) {
						this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.09375F, 0.59375F, 0.25F, 0.75F, pPackedLight, pPackedOverlay);
					}

					if (IcariaConfig.RENDER_KETTLE_ITEMS.get()) {
						if (!ingA.isEmpty()) {
							pPoseStack.pushPose();
							pPoseStack.translate(Mth.sin(time * speed) * radius + x, Mth.sin(time * ySpeed) * yRange + yLevel, Mth.cos(time * speed) * radius + z);
							pPoseStack.scale(scale, scale, scale);
							pPoseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(time * 0.05F) * 8.0F));
							pPoseStack.mulPose(Axis.YP.rotationDegrees(time));
							pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.cos(time * 0.05F) * 8.0F));
							itemRenderer.renderStatic(ingA, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
							pPoseStack.popPose();
						}

						if (!ingB.isEmpty()) {
							pPoseStack.pushPose();
							pPoseStack.translate(Mth.sin(time * speed + 7.5F) * radius + x, Mth.sin(time * ySpeed + 7.5F) * yRange + yLevel, Mth.cos(time * speed + 7.5F) * radius + z);
							pPoseStack.scale(scale, scale, scale);
							pPoseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(time * 0.05F + 45.0F) * 8.0F));
							pPoseStack.mulPose(Axis.YP.rotationDegrees(time + 45.0F));
							pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.cos(time * 0.05F + 45.0F) * 8.0F));
							itemRenderer.renderStatic(ingB, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
							pPoseStack.popPose();
						}

						if (!ingC.isEmpty()) {
							pPoseStack.pushPose();
							pPoseStack.translate(Mth.sin(time * speed + 15.0F) * radius + x, Mth.sin(time * ySpeed + 15.0F) * yRange + yLevel, Mth.cos(time * speed + 15.0F) * radius + z);
							pPoseStack.scale(scale, scale, scale);
							pPoseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(time * 0.05F + 90.0F) * 8.0F));
							pPoseStack.mulPose(Axis.YP.rotationDegrees(time + 90.0F));
							pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.cos(time * 0.05F + 90.0F) * 8.0F));
							itemRenderer.renderStatic(ingC, ItemDisplayContext.FIXED, pPackedLight, pPackedOverlay, pPoseStack, pBufferSource, level, 1);
							pPoseStack.popPose();
						}
					}
				}
			}
		}
	}

	public void renderQuad(KettleBlockEntity pBlockEntity, PoseStack pPoseStack, MultiBufferSource pBufferSource, float pMinX, float pMaxX, float pMinZ, float pMaxZ, int pPackedLight, int pPackedOverlay) {
		if (pBlockEntity.getLevel() != null) {
			float height;
			float r;
			float g;
			float b;

			int endColor = pBlockEntity.color;
			int startColor = BiomeColors.getAverageWaterColor(pBlockEntity.getLevel(), pBlockEntity.getBlockPos());

			var consumer = pBufferSource.getBuffer(Sheets.translucentCullBlockSheet());
			var matrix4f = pPoseStack.last().pose();
			var minecraft = Minecraft.getInstance();
			var state = pBlockEntity.getBlockState();

			TextureAtlasSprite sprite;

			if (state.getValue(IcariaBlockStateProperties.KETTLE) == Kettle.BREWING) {
				height = 0.6875F + (float) pBlockEntity.progress / pBlockEntity.maxProgress * 0.09375F;
				r = Mth.lerp((float) pBlockEntity.progress / pBlockEntity.maxProgress, (startColor >> 16 & 255) / 255.0F, (endColor >> 16 & 255) / 255.0F);
				g = Mth.lerp((float) pBlockEntity.progress / pBlockEntity.maxProgress, (startColor >> 8 & 255) / 255.0F, (endColor >> 8 & 255) / 255.0F);
				b = Mth.lerp((float) pBlockEntity.progress / pBlockEntity.maxProgress, (startColor & 255) / 255.0F, (endColor & 255) / 255.0F);
				sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.CONCOCTION_FAST);
			} else {
				height = 0.6875F;
				r = (startColor >> 16 & 255) / 255.0F;
				g = (startColor >> 8 & 255) / 255.0F;
				b = (startColor & 255) / 255.0F;
				sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.CONCOCTION_SLOW);
			}

			pPoseStack.pushPose();

			consumer.addVertex(matrix4f, pMinX, height, pMinZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(0.25F), sprite.getV(0.25F)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);
			consumer.addVertex(matrix4f, pMinX, height, pMaxZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(0.75F), sprite.getV(0.25F)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);
			consumer.addVertex(matrix4f, pMaxX, height, pMaxZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(0.75F), sprite.getV(0.75F)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);
			consumer.addVertex(matrix4f, pMaxX, height, pMinZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(0.25F), sprite.getV(0.75F)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(0.0F, 0.0F, 1.0F);

			pPoseStack.popPose();
		}
	}
}
