package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.entity.TroughBlockEntity;
import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record TroughBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<TroughBlockEntity> {

	@Override
	public void render(TroughBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var blockState = pBlockEntity.getBlockState();
		var blockPos = pBlockEntity.getBlockPos();
		var level = pBlockEntity.getLevel();

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var trough = blockState.getValue(IcariaBlockStateProperties.TROUGH);
		var troughFill = blockState.getValue(IcariaBlockStateProperties.TROUGH_FILL);

		var minecraft = Minecraft.getInstance();
		var renderType = Sheets.translucentItemSheet();

		var vertexConsumer = pMultiBufferSource.getBuffer(renderType);

		if (level != null && trough != Trough.NONE) {
			var color = BiomeColors.getAverageWaterColor(level, blockPos);

			var sprite = this.getSprite(trough, minecraft);

			var r = this.getColor(trough, color, 16);
			var g = this.getColor(trough, color, 8);
			var b = this.getColor(trough, color, 0);

			var y = troughFill / 3.0F * 0.0625F + 0.0625F;

			IcariaClientHelper.renderQuad(vertexConsumer, sprite, pPoseStack.last().pose(), direction, pPackedLight, pPackedOverlay, 0.0F, 1.0F, 0.5F, 1.0F, 0.0F, 1.0F, 0.5F, 1.0F, y, r, g, b, 1.0F);
		}
	}

	public float getColor(Trough pTrough, int pColor, int pShift) {
		if (pTrough == Trough.WATER || pTrough == Trough.MEDITERRANEAN_WATER) {
			return (pColor >> pShift & 255) / 255.0F;
		} else {
			return 1.0F;
		}
	}

	public TextureAtlasSprite getSprite(Trough pTrough, Minecraft pMinecraft) {
		if (pTrough == Trough.POWDER_SNOW) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.POWDER_SNOW);
		} else if (pTrough == Trough.WATER) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.WATER);
		} else if (pTrough == Trough.MEDITERRANEAN_WATER) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.MEDITERRANEAN_WATER);
		} else if (pTrough == Trough.ONION) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.ONION);
		} else if (pTrough == Trough.SPELT) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.SPELT);
		} else {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.VINEBERRIES);
		}
	}
}
