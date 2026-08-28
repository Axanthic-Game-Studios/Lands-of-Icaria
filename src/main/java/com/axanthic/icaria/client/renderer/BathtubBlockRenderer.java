package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.BathtubBlockRenderState;
import com.axanthic.icaria.common.entity.BathtubBlockEntity;
import com.axanthic.icaria.common.properties.Fill;
import com.axanthic.icaria.common.properties.Part;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.data.AtlasIds;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

import org.joml.Matrix4f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record BathtubBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<BathtubBlockEntity, BathtubBlockRenderState> {

	@Override
	public void extractRenderState(BathtubBlockEntity pBlockEntity, BathtubBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.blockPos = pBlockEntity.getBlockPos();
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.level = pBlockEntity.getLevel();
	}

	@Override
	public void submit(BathtubBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var blockPos = pRenderState.blockPos;
		var blockState = pRenderState.blockState;
		var level = pRenderState.level;

		var bathtubFill = blockState.getValue(IcariaBlockStateProperties.BATHTUB_FILL);
		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var fill = blockState.getValue(IcariaBlockStateProperties.FILL);
		var part = blockState.getValue(IcariaBlockStateProperties.PART);

		var textureAtlas = Minecraft.getInstance().getAtlasManager().getAtlasOrThrow(AtlasIds.BLOCKS);

		if (level != null && fill != Fill.NONE) {
			var color = BiomeColors.getAverageWaterColor(level, blockPos);

			var sprite = this.getSprite(fill, textureAtlas);

			var r = this.getColor(fill, color, 16);
			var g = this.getColor(fill, color, 8);
			var b = this.getColor(fill, color, 0);

			var y = bathtubFill * 0.0625F + 0.0625F + 0.0005F;

			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, Sheets.translucentItemSheet(), (pose, vertexConsumer) -> this.submit(part, vertexConsumer, sprite, pose.pose(), direction, pRenderState.lightCoords, OverlayTexture.NO_OVERLAY, y, r, g, b));
		}
	}

	public void submit(Part pPart, VertexConsumer pVertexConsumer, TextureAtlasSprite pTextureAtlasSprite, Matrix4f pMatrix4f, Direction pDirection, int pPackedLight, int pPackedOverlay, float pY, float pRed, float pGreen, float pBlue) {
		if (pPart == Part.HEAD) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pDirection, pPackedLight, pPackedOverlay, 0.125F, 0.875F, 0.0F, 0.875F, 0.125F, 0.875F, 0.0F, 0.875F, pY, pRed, pGreen, pBlue, 1.0F);
		} else {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pDirection, pPackedLight, pPackedOverlay, 0.125F, 0.875F, 0.125F, 1.0F, 0.125F, 0.875F, 0.125F, 1.0F, pY, pRed, pGreen, pBlue, 1.0F);
		}
	}

	public float getColor(Fill pFill, int pColor, int pShift) {
		if (pFill == Fill.WATER || pFill == Fill.MEDITERRANEAN_WATER) {
			return (pColor >> pShift & 255) / 255.0F;
		} else {
			return 1.0F;
		}
	}

	public TextureAtlasSprite getSprite(Fill pFill, TextureAtlas pTextureAtlas) {
		if (pFill == Fill.POWDER_SNOW) {
			return pTextureAtlas.getSprite(IcariaResourceLocations.POWDER_SNOW);
		} else if (pFill == Fill.WATER) {
			return pTextureAtlas.getSprite(IcariaResourceLocations.WATER);
		} else {
			return pTextureAtlas.getSprite(IcariaResourceLocations.MEDITERRANEAN_WATER);
		}
	}

	@Override
	public BathtubBlockRenderState createRenderState() {
		return new BathtubBlockRenderState();
	}
}
