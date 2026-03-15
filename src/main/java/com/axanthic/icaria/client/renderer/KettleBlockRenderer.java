package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.KettleBlockEntity;
import com.axanthic.icaria.common.properties.Kettle;
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
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record KettleBlockRenderer(BlockEntityRendererProvider.Context context) implements BlockEntityRenderer<KettleBlockEntity> {

	@Override
	public int getViewDistance() {
		return IcariaConfig.RENDER_DISTANCE_KETTLE_ITEMS.get();
	}

	@Override
	public void render(KettleBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight, int pPackedOverlay, Vec3 pVec3) {
		var blockState = pBlockEntity.getBlockState();
		var level = pBlockEntity.getLevel();

		var direction = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
		var kettle = blockState.getValue(IcariaBlockStateProperties.KETTLE);

		var minecraft = Minecraft.getInstance();
		var vertexConsumer = pMultiBufferSource.getBuffer(Sheets.translucentItemSheet());

		if (level != null && kettle != Kettle.EMPTY) {
			var time = level.getGameTime();

			var angle = 25.0F;
			var range = 0.15F;
			var scale = 0.15F;
			var speed = 0.015F;

			var yLevel = 0.5625F;
			var yRange = 0.04375F;

			var colour = BiomeColors.getAverageWaterColor(level, pBlockEntity.getBlockPos());

			var sprite = this.getSprite(kettle, minecraft);

			var r = this.getColour(kettle, pBlockEntity, colour, 16);
			var g = this.getColour(kettle, pBlockEntity, colour, 8);
			var b = this.getColour(kettle, pBlockEntity, colour, 0);

			var y = this.getHeight(kettle, pBlockEntity);

			IcariaClientHelper.renderQuad(vertexConsumer, sprite, pPoseStack.last().pose(), direction, pPackedLight, pPackedOverlay, 0.25F, 0.75F, 0.25F, 0.75F, 0.25F, 0.75F, 0.09375F, 0.59375F, y, r, g, b, 1.0F);

			if (IcariaConfig.RENDER_KETTLE_ITEMS.get()) {
				IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getInputA(), direction, pBlockEntity, pPackedLight, 0.5F + Mth.cos(time * speed) * range, 0.5F - Mth.cos(time * speed) * range, yLevel + Mth.sin(time * speed) * yRange, 0.34375F - Mth.sin(time * speed) * range, 0.65625F + Mth.sin(time * speed) * range, Mth.sin(time * speed) * angle, time, Mth.cos(time * speed) * angle, scale, scale, scale);
				IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getInputB(), direction, pBlockEntity, pPackedLight, 0.5F + Mth.cos(time * speed + 7.5F) * range, 0.5F - Mth.cos(time * speed + 7.5F) * range, yLevel + Mth.sin(time * speed + 7.5F) * yRange, 0.34375F - Mth.sin(time * speed + 7.5F) * range, 0.65625F + Mth.sin(time * speed + 7.5F) * range, Mth.sin(time * speed + 45.0F) * angle, time + 45.0F, Mth.cos(time * speed + 45.0F) * angle, scale, scale, scale);
				IcariaClientHelper.renderItem(pPoseStack, pMultiBufferSource, pBlockEntity.getInputC(), direction, pBlockEntity, pPackedLight, 0.5F + Mth.cos(time * speed + 15.0F) * range, 0.5F - Mth.cos(time * speed + 15.0F) * range, yLevel + Mth.sin(time * speed + 15.0F) * yRange, 0.34375F - Mth.sin(time * speed + 15.0F) * range, 0.65625F + Mth.sin(time * speed + 15.0F) * range, Mth.sin(time * speed + 90.0F) * angle, time + 90.0F, Mth.cos(time * speed + 90.0F) * angle, scale, scale, scale);
			}
		}
	}

	public float getColour(Kettle pKettle, KettleBlockEntity pBlockEntity, int pColor, int pShift) {
		if (pKettle == Kettle.BREWING) {
			return Mth.lerp((float) pBlockEntity.progress / pBlockEntity.maxProgress, (pColor >> pShift & 255) / 255.0F, (pBlockEntity.color >> pShift & 255) / 255.0F);
		} else {
			return (pColor >> pShift & 255) / 255.0F;
		}
	}

	public float getHeight(Kettle pKettle, KettleBlockEntity pBlockEntity) {
		if (pKettle == Kettle.BREWING) {
			return 0.6875F + (float) pBlockEntity.progress / pBlockEntity.maxProgress * 0.0625F;
		} else {
			return 0.6875F;
		}
	}

	public TextureAtlasSprite getSprite(Kettle pKettle, Minecraft pMinecraft) {
		if (pKettle == Kettle.BREWING) {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.CONCOCTION_FAST);
		} else {
			return pMinecraft.getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.CONCOCTION_SLOW);
		}
	}
}
