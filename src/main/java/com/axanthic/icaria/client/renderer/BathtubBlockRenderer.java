package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.entity.BathtubBlockEntity;
import com.axanthic.icaria.common.properties.Bathtub;
import com.axanthic.icaria.common.properties.Part;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record BathtubBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<BathtubBlockEntity> {

	@Override
	public void render(BathtubBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var blockState = pBlockEntity.getBlockState();
		var blockPos = pBlockEntity.getBlockPos();
		var level = pBlockEntity.getLevel();

		var bathtub = blockState.getValue(IcariaBlockStateProperties.BATHTUB);
		var bathtubFill = blockState.getValue(IcariaBlockStateProperties.BATHTUB_FILL);
		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var part = blockState.getValue(IcariaBlockStateProperties.PART);

		var minecraft = Minecraft.getInstance();
		var renderType = Sheets.translucentItemSheet();

		var vertexConsumer = pMultiBufferSource.getBuffer(renderType);

		if (level != null && bathtub != Bathtub.NONE) {
			var color = BiomeColors.getAverageWaterColor(level, blockPos);

			var sprite = this.getSprite(minecraft, bathtub);

			var r = this.getColor(bathtub, color, 16);
			var g = this.getColor(bathtub, color, 8);
			var b = this.getColor(bathtub, color, 0);

			var y = bathtubFill * 0.0625F + 0.0625F + 0.0005F;

			this.render(part, vertexConsumer, sprite, pPoseStack, direction, pPackedLight, pPackedOverlay, y, r, g, b);
		}
	}

	public void render(Part pPart, VertexConsumer pVertexConsumer, TextureAtlasSprite pTextureAtlasSprite, PoseStack pPoseStack, Direction pDirection, int pPackedLight, int pPackedOverlay, float pY, float pRed, float pGreen, float pBlue) {
		if (pPart == Part.HEAD) {
			IcariaClientHelper.renderQuad(pVertexConsumer, pTextureAtlasSprite, pPoseStack.last().pose(), pDirection, pPackedLight, pPackedOverlay, 0.125F, 0.875F, 0.0F, 0.875F, 0.125F, 0.875F, 0.0F, 0.875F, pY, pRed, pGreen, pBlue, 1.0F);
		} else {
			IcariaClientHelper.renderQuad(pVertexConsumer, pTextureAtlasSprite, pPoseStack.last().pose(), pDirection, pPackedLight, pPackedOverlay, 0.125F, 0.875F, 0.125F, 1.0F, 0.125F, 0.875F, 0.125F, 1.0F, pY, pRed, pGreen, pBlue, 1.0F);
		}
	}

	public float getColor(Bathtub pBathtub, int pColor, int pShift) {
		if (pBathtub == Bathtub.WATER || pBathtub == Bathtub.MEDITERRANEAN_WATER) {
			return (pColor >> pShift & 255) / 255.0F;
		} else {
			return 1.0F;
		}
	}

	public TextureAtlasSprite getSprite(Minecraft pMinecraft, Bathtub pBathtub) {
		if (pBathtub == Bathtub.POWDER_SNOW) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.POWDER_SNOW);
		} else if (pBathtub == Bathtub.WATER) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.WATER);
		} else {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.MEDITERRANEAN_WATER);
		}
	}
}
