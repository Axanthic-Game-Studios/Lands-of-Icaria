package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.state.KettleBlockRenderState;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.KettleBlockEntity;
import com.axanthic.icaria.common.properties.Kettle;
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
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.data.AtlasIds;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record KettleBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<KettleBlockEntity, KettleBlockRenderState> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_KETTLE_ITEMS.get();
	}

	@Override
	public void extractRenderState(KettleBlockEntity pBlockEntity, KettleBlockRenderState pRenderState, float pPartialTick, Vec3 pVec3, @Nullable ModelFeatureRenderer.CrumblingOverlay pCrumblingOverlay) {
		BlockEntityRenderer.super.extractRenderState(pBlockEntity, pRenderState, pPartialTick, pVec3, pCrumblingOverlay);
		pRenderState.color = pBlockEntity.color;
		pRenderState.maxProgress = pBlockEntity.maxProgress;
		pRenderState.progress = pBlockEntity.progress;
		pRenderState.blockPos = pBlockEntity.getBlockPos();
		pRenderState.blockState = pBlockEntity.getBlockState();
		pRenderState.intakeA = new ItemStackRenderState();
		pRenderState.intakeB = new ItemStackRenderState();
		pRenderState.intakeC = new ItemStackRenderState();
		pRenderState.level = pBlockEntity.getLevel();
		this.context().itemModelResolver().updateForTopItem(pRenderState.intakeA, pBlockEntity.getIntakeA(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.intakeB, pBlockEntity.getIntakeB(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
		this.context().itemModelResolver().updateForTopItem(pRenderState.intakeC, pBlockEntity.getIntakeC(), ItemDisplayContext.FIXED, pBlockEntity.getLevel(), null, 0);
	}

	@Override
	public void submit(KettleBlockRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		var blockPos = pRenderState.blockPos;
		var blockState = pRenderState.blockState;
		var level = pRenderState.level;

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var doubleBlockHalf = blockState.getValue(BlockStateProperties.DOUBLE_BLOCK_HALF);
		var kettle = blockState.getValue(IcariaBlockStateProperties.KETTLE);

		var textureAtlas = Minecraft.getInstance().getAtlasManager().getAtlasOrThrow(AtlasIds.BLOCKS);

		if (level != null && doubleBlockHalf == DoubleBlockHalf.LOWER && kettle != Kettle.EMPTY) {
			var time = level.getGameTime();

			var angle = 25.0F;
			var range = 0.15F;
			var scale = 0.15F;
			var speed = 0.015F;

			var yLevel = 0.5625F;
			var yRange = 0.04375F;

			var colour = BiomeColors.getAverageWaterColor(level, blockPos);

			var r = this.getColour(kettle, pRenderState, colour, 16);
			var g = this.getColour(kettle, pRenderState, colour, 8);
			var b = this.getColour(kettle, pRenderState, colour, 0);

			var y = this.getHeight(kettle, pRenderState);

			var sprite = this.getSprite(kettle, textureAtlas);

			pSubmitNodeCollector.submitCustomGeometry(pPoseStack, Sheets.translucentItemSheet(), (pose, vertexConsumer) -> IcariaClientHelper.submitSprite(vertexConsumer, sprite, pose.pose(), direction, pRenderState.lightCoords, 0, 0.25F, 0.75F, 0.25F, 0.75F, 0.25F, 0.75F, 0.125F, 0.625F, y, r, g, b, 1.0F));

			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.intakeA, direction, pRenderState.lightCoords, 0.5F + Mth.cos(time * speed) * range, 0.5F - Mth.cos(time * speed) * range, yLevel + Mth.sin(time * speed) * yRange, 0.34375F - Mth.sin(time * speed) * range, 0.65625F + Mth.sin(time * speed) * range, Mth.sin(time * speed) * angle, time, Mth.cos(time * speed) * angle, scale, scale, scale);
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.intakeB, direction, pRenderState.lightCoords, 0.5F + Mth.cos(time * speed + 7.5F) * range, 0.5F - Mth.cos(time * speed + 7.5F) * range, yLevel + Mth.sin(time * speed + 7.5F) * yRange, 0.34375F - Mth.sin(time * speed + 7.5F) * range, 0.65625F + Mth.sin(time * speed + 7.5F) * range, Mth.sin(time * speed + 45.0F) * angle, time + 45.0F, Mth.cos(time * speed + 45.0F) * angle, scale, scale, scale);
			IcariaClientHelper.submitItem(pSubmitNodeCollector, pPoseStack, pRenderState.intakeC, direction, pRenderState.lightCoords, 0.5F + Mth.cos(time * speed + 15.0F) * range, 0.5F - Mth.cos(time * speed + 15.0F) * range, yLevel + Mth.sin(time * speed + 15.0F) * yRange, 0.34375F - Mth.sin(time * speed + 15.0F) * range, 0.65625F + Mth.sin(time * speed + 15.0F) * range, Mth.sin(time * speed + 90.0F) * angle, time + 90.0F, Mth.cos(time * speed + 90.0F) * angle, scale, scale, scale);
		}
	}

	public float getColour(Kettle pKettle, KettleBlockRenderState pRenderState, int pColor, int pShift) {
		if (pKettle == Kettle.BREWING) {
			return Mth.lerp((float) pRenderState.progress / pRenderState.maxProgress, (pColor >> pShift & 255) / 255.0F, (pRenderState.color >> pShift & 255) / 255.0F);
		} else {
			return (pColor >> pShift & 255) / 255.0F;
		}
	}

	public float getHeight(Kettle pKettle, KettleBlockRenderState pRenderState) {
		if (pKettle == Kettle.BREWING) {
			return 0.6875F + (float) pRenderState.progress / pRenderState.maxProgress * 0.0625F;
		} else {
			return 0.6875F;
		}
	}

	public TextureAtlasSprite getSprite(Kettle pKettle, TextureAtlas pTextureAtlas) {
		if (pKettle == Kettle.BREWING) {
			return pTextureAtlas.getSprite(IcariaResourceLocations.CONCOCTION_FAST);
		} else {
			return pTextureAtlas.getSprite(IcariaResourceLocations.CONCOCTION_SLOW);
		}
	}

	@Override
	public KettleBlockRenderState createRenderState() {
		return new KettleBlockRenderState();
	}
}
