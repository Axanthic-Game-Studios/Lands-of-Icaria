package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.common.block.entity.TroughBlockEntity;
import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TroughBlockRenderer implements BlockEntityRenderer<TroughBlockEntity> {
	public TroughBlockRenderer(BlockEntityRendererProvider.Context pContext) {

	}

	@Override
	public void render(TroughBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
		var state = pBlockEntity.getBlockState();

		var facing = state.getValue(BlockStateProperties.HORIZONTAL_FACING);

		if (state.getValue(IcariaBlockStateProperties.TROUGH) != Trough.NONE) {
			if (facing == Direction.NORTH) {
				this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.0F, 1.0F, 0.5F, 1.0F, 0.0F, 1.0F, 0.5F, 1.0F, pPackedLight, pPackedOverlay);
			} else if (facing == Direction.EAST) {
				this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.0F, 0.5F, 0.0F, 1.0F, 0.0F, 0.5F, 0.0F, 1.0F, pPackedLight, pPackedOverlay);
			} else if (facing == Direction.SOUTH) {
				this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.0F, 1.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.0F, 0.5F, pPackedLight, pPackedOverlay);
			} else if (facing == Direction.WEST) {
				this.renderQuad(pBlockEntity, pPoseStack, pBufferSource, 0.5F, 1.0F, 0.0F, 1.0F, 0.5F, 1.0F, 0.0F, 1.0F, pPackedLight, pPackedOverlay);
			}
		}
	}

	public void renderQuad(TroughBlockEntity pBlockEntity, PoseStack pPoseStack, MultiBufferSource pBufferSource, float pMinX, float pMaxX, float pMinZ, float pMaxZ, float pMinU, float pMaxU, float pMinV, float pMaxV, int pPackedLight, int pPackedOverlay) {
		if (pBlockEntity.getLevel() != null) {
			var consumer = pBufferSource.getBuffer(Sheets.translucentCullBlockSheet());
			var matrix4f = pPoseStack.last().pose();
			var minecraft = Minecraft.getInstance();
			var state = pBlockEntity.getBlockState();

			int waterColor = BiomeColors.getAverageWaterColor(pBlockEntity.getLevel(), pBlockEntity.getBlockPos());

			float height = state.getValue(IcariaBlockStateProperties.TROUGH_FILL) * 0.0625F / 3.0F + 0.0625F;

			float r;
			float g;
			float b;

			TextureAtlasSprite sprite;

			if (state.getValue(IcariaBlockStateProperties.TROUGH) == Trough.WATER) {
				r = (waterColor >> 16 & 255) / 255.0F;
				g = (waterColor >> 8 & 255) / 255.0F;
				b = (waterColor & 255) / 255.0F;
				sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.WATER);
			} else if (state.getValue(IcariaBlockStateProperties.TROUGH) == Trough.MEDITERRANEAN_WATER) {
				r = (waterColor >> 16 & 255) / 255.0F;
				g = (waterColor >> 8 & 255) / 255.0F;
				b = (waterColor & 255) / 255.0F;
				sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.MEDITERRANEAN_WATER);
			} else if (state.getValue(IcariaBlockStateProperties.TROUGH) == Trough.ONION) {
				r = 1.0F;
				g = 1.0F;
				b = 1.0F;
				sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.ONION);
			} else if (state.getValue(IcariaBlockStateProperties.TROUGH) == Trough.SPELT) {
				r = 1.0F;
				g = 1.0F;
				b = 1.0F;
				sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.SPELT);
			} else {
				r = 1.0F;
				g = 1.0F;
				b = 1.0F;
				sprite = minecraft.getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(IcariaResourceLocations.VINEBERRIES);
			}

			pPoseStack.pushPose();

			consumer.addVertex(matrix4f, pMinX, height, pMinZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(pMinU), sprite.getV(pMinV)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F);
			consumer.addVertex(matrix4f, pMinX, height, pMaxZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(pMinU), sprite.getV(pMaxV)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F);
			consumer.addVertex(matrix4f, pMaxX, height, pMaxZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(pMaxU), sprite.getV(pMaxV)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F);
			consumer.addVertex(matrix4f, pMaxX, height, pMinZ).setColor(r, g, b, 1.0F).setUv(sprite.getU(pMaxU), sprite.getV(pMinV)).setOverlay(pPackedOverlay).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F);

			pPoseStack.popPose();
		}
	}
}
