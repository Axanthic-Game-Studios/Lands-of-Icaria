package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.helper.IcariaClientHelper;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.client.state.SpellRenderState;
import com.axanthic.icaria.common.entity.SpellEntity;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellRenderer extends EntityRenderer<SpellEntity, SpellRenderState> {
	public SpellRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
	}

	public float getX(float pLength, float pSpeed, float pTicks, float pWiggle) {
		return Mth.cos(pLength / 3.5F - pSpeed * pTicks / 2.0F) * pLength * pWiggle + Mth.cos(pLength / 2.0F - pSpeed * pTicks / 3.5F + 3.0F) * pLength * pWiggle + Mth.sin(pLength / 7.5F - pSpeed * pTicks / 6.0F + 2.0F) * pLength * pWiggle + Mth.sin(-pSpeed * pTicks / 5.0F + 2.0F) * pLength * pWiggle;
	}

	public float getY(float pLength, float pSpeed, float pTicks, float pWiggle) {
		return Mth.sin(pLength / 2.5F - pSpeed * pTicks / 3.0F) * pLength * pWiggle + Mth.sin(pLength / 3.0F - pSpeed * pTicks / 2.5F + 2.0F) * pLength * pWiggle + Mth.cos(pLength / 7.0F - pSpeed * pTicks / 6.5F + 3.0F) * pLength * pWiggle + Mth.cos(-pSpeed * pTicks / 4.0F + 3.0F) * pLength * pWiggle;
	}

	@Override
	public void extractRenderState(SpellEntity pEntity, SpellRenderState pRenderState, float pPartialTick) {
		super.extractRenderState(pEntity, pRenderState, pPartialTick);
		pRenderState.xRot = pEntity.getXRot();
		pRenderState.xRotOld = pEntity.xRotO;
		pRenderState.yRot = pEntity.getYRot();
		pRenderState.yRotOld = pEntity.yRotO;
		pRenderState.color = pEntity.getColor();
	}

	@Override
	public void render(SpellRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		pPoseStack.pushPose();

		var matrix4f = pPoseStack.last().pose();

		var vertexConsumer = pMultiBufferSource.getBuffer(IcariaRenderTypes.ADDITIVE_TRANSPARENT_TEXTURE);

		var color = pRenderState.color;

		var ticks = pRenderState.ageInTicks;

		var distance = 25.0F;
		var length = 50.0F;
		var speed = 1.5F;
		var wiggle = 0.0025F;

		var red = (color >> 16 & 255) / 255.0F;
		var green = (color >> 8 & 255) / 255.0F;
		var blue = (color & 255) / 255.0F;

		pPoseStack.translate(0.0D, 0.25D, 0.0D);

		pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pRenderState.partialTick, pRenderState.yRotOld, pRenderState.yRot) + 180.0F));
		pPoseStack.mulPose(Axis.XP.rotationDegrees(Mth.lerp(pRenderState.partialTick, pRenderState.xRotOld, pRenderState.xRot) + 90.0F));

		for (var f = 0.0F; f < length; f++) {
			var alpha = (length - f) / length;
			var width = (length - f) / length * 0.25F;

			var x = this.getX(f, speed, ticks, wiggle);
			var y = this.getY(f, speed, ticks, wiggle);

			var resolution = f / distance;

			var textureAtlasSprite = Minecraft.getInstance().getTextureAtlas(IcariaResourceLocations.BLOCK_ATLAS).apply(IcariaResourceLocations.SPELL);

			IcariaClientHelper.renderQuad(vertexConsumer, textureAtlasSprite, matrix4f, pPackedLight, 0, 0.0F, 1.0F, 0.0F, 1.0F, x - width, x + width, y - width, y + width, resolution, red, green, blue, alpha);
			IcariaClientHelper.renderQuad(vertexConsumer, textureAtlasSprite, matrix4f, pPackedLight, 0, 0.0F, 1.0F, 0.0F, 1.0F, x + width, x - width, y - width, y + width, resolution, red, green, blue, alpha);
		}

		pPoseStack.popPose();

		super.render(pRenderState, pPoseStack, pMultiBufferSource, pPackedLight);
	}

	@Override
	public SpellRenderState createRenderState() {
		return new SpellRenderState();
	}
}
