package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.state.RugRenderState;
import com.axanthic.icaria.common.entity.RugEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RugRenderer extends EntityRenderer<RugEntity, RugRenderState> {
	public RugRenderer(EntityRendererProvider.Context pContext) {
		super(pContext);
	}

	@Override
	public void extractRenderState(RugEntity pRugEntity, RugRenderState pRugRenderState, float pPartialTick) {
		super.extractRenderState(pRugEntity, pRugRenderState, pPartialTick);
		pRugRenderState.direction = pRugEntity.getDirection();
		pRugRenderState.placementDirection = pRugEntity.getPlacementDirection();
		pRugRenderState.paintingVariant = pRugEntity.getPaintingVariant();
	}

	@Override
	public void render(RugRenderState pRenderState, PoseStack pPoseStack, MultiBufferSource pMultiBufferSource, int pPackedLight) {
		var textureAtlasSprite = Minecraft.getInstance().getPaintingTextures().get(pRenderState.paintingVariant.value());
		var resourceLocation = textureAtlasSprite.atlasLocation();
		var renderType = RenderType.entitySolidZOffsetForward(resourceLocation);
		var vertexConsumer = pMultiBufferSource.getBuffer(renderType);
		this.renderHorizontal(pPoseStack, pRenderState, textureAtlasSprite, vertexConsumer, 0.0F, pRenderState.direction.toYRot(), 0.0F, pPackedLight);
		this.renderVertical(pPoseStack, pRenderState, textureAtlasSprite, vertexConsumer, 90.0F, pRenderState.placementDirection.toYRot(), 0.0F, pPackedLight);
	}

	public void renderHorizontal(PoseStack pPoseStack, RugRenderState pRenderState, TextureAtlasSprite pTextureAtlasSprite, VertexConsumer pVertexConsumer, float pXRot, float pYRot, float pZRot, int pPackedLight) {
		if (pRenderState.direction.getAxis().isHorizontal()) {
			pPoseStack.pushPose();
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
			pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
			pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
			this.render(pPoseStack, pTextureAtlasSprite, pVertexConsumer, pRenderState.paintingVariant.value().height(), pRenderState.paintingVariant.value().width(), pPackedLight);
			pPoseStack.popPose();
		}
	}

	public void renderVertical(PoseStack pPoseStack, RugRenderState pRenderState, TextureAtlasSprite pTextureAtlasSprite, VertexConsumer pVertexConsumer, float pXRot, float pYRot, float pZRot, int pPackedLight) {
		if (pRenderState.direction.getAxis().isVertical()) {
			pPoseStack.pushPose();
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
			pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
			pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
			this.render(pPoseStack, pTextureAtlasSprite, pVertexConsumer, pRenderState.paintingVariant.value().height(), pRenderState.paintingVariant.value().width(), pPackedLight);
			pPoseStack.popPose();
		}
	}

	public void render(PoseStack pPoseStack, TextureAtlasSprite pTextureAtlasSprite, VertexConsumer pVertexConsumer, int pHeight, int pWidth, int pPackedLight) {
		for (var width = 0; width < pWidth; width++) {
			for (var height = 0; height < pHeight; height++) {
				var f = 0.5F * -pWidth;
				var g = 0.5F * -pHeight;

				var h = 1.0F / pWidth;
				var i = 1.0F / pHeight;

				var j = width + 1;
				var k = height + 1;

				var xMin = f + width;
				var xMax = f + j;
				var zMin = g + height;
				var zMax = g + k;

				var uMin = h * (pWidth - width);
				var uMax = h * (pWidth - j);
				var vMin = i * (pHeight - height);
				var vMax = i * (pHeight - k);

				var uMinRim = h * (pWidth - width - 0.0625F);
				var uMaxRim = h * (pWidth - j + 0.0625F);
				var vMinRim = i * (pHeight - height - 0.0625F);
				var xMaxRim = i * (pHeight - k + 0.0625F);

				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMin, -0.03125F, uMax, vMin, 0.0F, 0.0F, -1.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMin, -0.03125F, uMin, vMin, 0.0F, 0.0F, -1.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMax, -0.03125F, uMin, vMax, 0.0F, 0.0F, -1.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMax, -0.03125F, uMax, vMax, 0.0F, 0.0F, -1.0F, pPackedLight);

				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMax, 0.03125F, uMax, vMax, 0.0F, 0.0F, 1.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMax, 0.03125F, uMin, vMax, 0.0F, 0.0F, 1.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMin, 0.03125F, uMin, vMin, 0.0F, 0.0F, 1.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMin, 0.03125F, uMax, vMin, 0.0F, 0.0F, 1.0F, pPackedLight);

				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMax, -0.03125F, uMax, vMax, 0.0F, 1.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMax, -0.03125F, uMin, vMax, 0.0F, 1.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMax, 0.03125F, uMin, xMaxRim, 0.0F, 1.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMax, 0.03125F, uMax, xMaxRim, 0.0F, 1.0F, 0.0F, pPackedLight);

				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMin, 0.03125F, uMax, vMin, 0.0F, -1.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMin, 0.03125F, uMin, vMin, 0.0F, -1.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMin, -0.03125F, uMin, vMinRim, 0.0F, -1.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMin, -0.03125F, uMax, vMinRim, 0.0F, -1.0F, 0.0F, pPackedLight);

				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMax, 0.03125F, uMax, vMax, -1.0F, 0.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMin, 0.03125F, uMax, vMin, -1.0F, 0.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMin, -0.03125F, uMaxRim, vMin, -1.0F, 0.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMax, zMax, -0.03125F, uMaxRim, vMax, -1.0F, 0.0F, 0.0F, pPackedLight);

				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMax, -0.03125F, uMinRim, vMax, 1.0F, 0.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMin, -0.03125F, uMinRim, vMin, 1.0F, 0.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMin, 0.03125F, uMin, vMin, 1.0F, 0.0F, 0.0F, pPackedLight);
				this.renderVertex(pPoseStack, pTextureAtlasSprite, pVertexConsumer, xMin, zMax, 0.03125F, uMin, vMax, 1.0F, 0.0F, 0.0F, pPackedLight);
			}
		}
	}

	public void renderVertex(PoseStack pPoseStack, TextureAtlasSprite pTextureAtlasSprite, VertexConsumer pVertexConsumer, float pX, float pY, float pZ, float pU, float pV, float pNormalX, float pNormalY, float pNormalZ, int pPackedLight) {
		this.renderVertex(pPoseStack, pVertexConsumer, pX, pY, pZ, pTextureAtlasSprite.getU(pU), pTextureAtlasSprite.getV(pV), pNormalX, pNormalY, pNormalZ, 1.0F, 1.0F, 1.0F, 1.0F, pPackedLight, OverlayTexture.NO_OVERLAY);
	}

	public void renderVertex(PoseStack pPoseStack, VertexConsumer pVertexConsumer, float pX, float pY, float pZ, float pU, float pV, float pNormalX, float pNormalY, float pNormalZ, float pRed, float pGreen, float pBlue, float pAlpha, int pPackedLight, int pPackedOverlay) {
		pVertexConsumer.addVertex(pPoseStack.last(), pX, pY, pZ).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pPackedLight).setNormal(pPoseStack.last(), pNormalX, pNormalY, pNormalZ).setOverlay(pPackedOverlay).setUv(pU, pV);
	}

	@Override
	public RugRenderState createRenderState() {
		return new RugRenderState();
	}
}
