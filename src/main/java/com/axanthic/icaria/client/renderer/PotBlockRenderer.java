package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.PotBlockRenderState;
import com.axanthic.icaria.common.entity.PotBlockEntity;
import com.axanthic.icaria.common.properties.Fill;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;

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
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.data.AtlasIds;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record PotBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<PotBlockEntity, PotBlockRenderState> {

	@Override
	public void extractRenderState(PotBlockEntity pBlockEntity, PotBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.blockPos = pBlockEntity.getBlockPos();
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.level = pBlockEntity.getLevel();
	}

	@Override
	public void submit(PotBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var blockPos = pRenderState.blockPos;
		var blockState = pRenderState.blockState;
		var level = pRenderState.level;

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var fill = blockState.getValue(IcariaBlockStateProperties.FILL);
		var potFill = blockState.getValue(IcariaBlockStateProperties.POT_FILL);

		var textureAtlas = Minecraft.getInstance().getAtlasManager().getAtlasOrThrow(AtlasIds.BLOCKS);

		if (level != null && fill != Fill.NONE) {
			var color = BiomeColors.getAverageWaterColor(level, blockPos);

			var sprite = this.getSprite(fill, textureAtlas);

			var r = this.getColor(fill, color, 16);
			var g = this.getColor(fill, color, 8);
			var b = this.getColor(fill, color, 0);

			var y = potFill * 0.0625F + 0.0625F;

			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, Sheets.translucentItemSheet(), (pose, vertexConsumer) -> IcariaClientHelper.submitSprite(vertexConsumer, sprite, pose.pose(), direction, pRenderState.lightCoords, 0, 0.3125F, 0.6875F, 0.3125F, 0.6875F, 0.3125F, 0.6875F, 0.3125F, 0.6875F, y, r, g, b, 1.0F));
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
	public PotBlockRenderState createRenderState() {
		return new PotBlockRenderState();
	}
}
