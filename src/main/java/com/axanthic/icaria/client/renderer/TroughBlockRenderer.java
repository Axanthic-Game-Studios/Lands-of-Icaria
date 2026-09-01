package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.ThroughBlockRenderState;
import com.axanthic.icaria.common.entity.TroughBlockEntity;
import com.axanthic.icaria.common.properties.Trough;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

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

public record TroughBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<TroughBlockEntity, ThroughBlockRenderState> {

	@Override
	public void extractRenderState(TroughBlockEntity pBlockEntity, ThroughBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.blockPos = pBlockEntity.getBlockPos();
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.level = pBlockEntity.getLevel();
	}

	@Override
	public void submit(ThroughBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var blockPos = pRenderState.blockPos;
		var blockState = pRenderState.blockState;
		var level = pRenderState.level;

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var trough = blockState.getValue(IcariaBlockStateProperties.TROUGH);
		var troughFill = blockState.getValue(IcariaBlockStateProperties.TROUGH_FILL);

		var textureAtlas = Minecraft.getInstance().getAtlasManager().getAtlasOrThrow(AtlasIds.BLOCKS);

		if (level != null && trough != Trough.NONE) {
			var color = BiomeColors.getAverageWaterColor(level, blockPos);

			var sprite = this.getSprite(trough, textureAtlas);

			var r = this.getColor(trough, color, 16);
			var g = this.getColor(trough, color, 8);
			var b = this.getColor(trough, color, 0);

			var y = troughFill / 3.0F * 0.0625F + 0.0625F;

			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, Sheets.translucentItemSheet(), (pose, vertexConsumer) -> IcariaClientHelper.submitSprite(vertexConsumer, sprite, pose.pose(), direction, pRenderState.lightCoords, 0, 0.0F, 1.0F, 0.5F, 1.0F, 0.0F, 1.0F, 0.5F, 1.0F, y, r, g, b, 1.0F));
		}
	}

	public float getColor(Trough pTrough, int pColor, int pShift) {
		if (pTrough == Trough.WATER || pTrough == Trough.MEDITERRANEAN_WATER) {
			return (pColor >> pShift & 255) / 255.0F;
		} else {
			return 1.0F;
		}
	}

	public TextureAtlasSprite getSprite(Trough pTrough, TextureAtlas pTextureAtlas) {
		if (pTrough == Trough.POWDER_SNOW) {
			return pTextureAtlas.getSprite(IcariaIdentifiers.POWDER_SNOW);
		} else if (pTrough == Trough.WATER) {
			return pTextureAtlas.getSprite(IcariaIdentifiers.WATER);
		} else if (pTrough == Trough.MEDITERRANEAN_WATER) {
			return pTextureAtlas.getSprite(IcariaIdentifiers.MEDITERRANEAN_WATER);
		} else if (pTrough == Trough.ONION) {
			return pTextureAtlas.getSprite(IcariaIdentifiers.ONION);
		} else if (pTrough == Trough.SPELT) {
			return pTextureAtlas.getSprite(IcariaIdentifiers.SPELT);
		} else {
			return pTextureAtlas.getSprite(IcariaIdentifiers.VINEBERRIES);
		}
	}

	@Override
	public ThroughBlockRenderState createRenderState() {
		return new ThroughBlockRenderState();
	}
}
