package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.entity.PotBlockEntity;
import com.axanthic.icaria.common.properties.Fill;
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

public record PotBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<PotBlockEntity> {

	@Override
	public void render(PotBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var blockState = pBlockEntity.getBlockState();
		var blockPos = pBlockEntity.getBlockPos();
		var level = pBlockEntity.getLevel();

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var fill = blockState.getValue(IcariaBlockStateProperties.FILL);
		var potFill = blockState.getValue(IcariaBlockStateProperties.POT_FILL);

		var minecraft = Minecraft.getInstance();
		var renderType = Sheets.translucentItemSheet();

		var vertexConsumer = pMultiBufferSource.getBuffer(renderType);

		if (level != null && fill != Fill.NONE) {
			var color = BiomeColors.getAverageWaterColor(level, blockPos);

			var sprite = this.getSprite(fill, minecraft);

			var r = this.getColor(fill, color, 16);
			var g = this.getColor(fill, color, 8);
			var b = this.getColor(fill, color, 0);

			var y = potFill * 0.0625F + 0.0625F;

			IcariaClientHelper.renderQuad(vertexConsumer, sprite, pPoseStack.last().pose(), direction, pPackedLight, pPackedOverlay, 0.3125F, 0.6875F, 0.3125F, 0.6875F, 0.3125F, 0.6875F, 0.3125F, 0.6875F, y, r, g, b, 1.0F);
		}
	}

	public float getColor(Fill pFill, int pColor, int pShift) {
		if (pFill == Fill.WATER || pFill == Fill.MEDITERRANEAN_WATER) {
			return (pColor >> pShift & 255) / 255.0F;
		} else {
			return 1.0F;
		}
	}

	public TextureAtlasSprite getSprite(Fill pFill, Minecraft pMinecraft) {
		if (pFill == Fill.POWDER_SNOW) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.POWDER_SNOW);
		} else if (pFill == Fill.WATER) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.WATER);
		} else {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.MEDITERRANEAN_WATER);
		}
	}
}
