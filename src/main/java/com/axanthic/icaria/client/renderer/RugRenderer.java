package com.axanthic.icaria.client.renderer;

import com.axanthic.icaria.client.state.RugRenderState;
import com.axanthic.icaria.common.entity.RugEntity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.data.AtlasIds;

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
	public void submit(RugRenderState pRenderState, PoseStack pPoseStack, SubmitNodeCollector pSubmitNodeCollector, CameraRenderState pCameraRenderState) {
		super.submit(pRenderState, pPoseStack, pSubmitNodeCollector, pCameraRenderState);
		var textureAtlasSprite = Minecraft.getInstance().getAtlasManager().getAtlasOrThrow(AtlasIds.PAINTINGS).getSprite(pRenderState.paintingVariant.value().assetId());
		this.submit(pSubmitNodeCollector, pPoseStack, pRenderState, textureAtlasSprite, pRenderState.direction.getAxis().isHorizontal(), 0.0F, pRenderState.direction.toYRot(), 0.0F, pRenderState.lightCoords);
		this.submit(pSubmitNodeCollector, pPoseStack, pRenderState, textureAtlasSprite, pRenderState.direction.getAxis().isVertical(), 90.0F, pRenderState.placementDirection.toYRot(), 0.0F, pRenderState.lightCoords);
	}

	public void submit(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, RugRenderState pRenderState, TextureAtlasSprite pTextureAtlasSprite, boolean pAxis, float pXRot, float pYRot, float pZRot, int pPackedLight) {
		if (pAxis) {
			pPoseStack.pushPose();
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
			pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
			pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
			this.submit(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, pRenderState.paintingVariant.value().height(), pRenderState.paintingVariant.value().width(), pPackedLight);
			pPoseStack.popPose();
		}
	}

	public void submit(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, TextureAtlasSprite pTextureAtlasSprite, int pHeight, int pWidth, int pPackedLight) {
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

				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMin, -0.03125F, uMax, vMin, 0.0F, 0.0F, -1.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMin, -0.03125F, uMin, vMin, 0.0F, 0.0F, -1.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMax, -0.03125F, uMin, vMax, 0.0F, 0.0F, -1.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMax, -0.03125F, uMax, vMax, 0.0F, 0.0F, -1.0F, pPackedLight);

				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMax, 0.03125F, uMax, vMax, 0.0F, 0.0F, 1.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMax, 0.03125F, uMin, vMax, 0.0F, 0.0F, 1.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMin, 0.03125F, uMin, vMin, 0.0F, 0.0F, 1.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMin, 0.03125F, uMax, vMin, 0.0F, 0.0F, 1.0F, pPackedLight);

				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMax, -0.03125F, uMax, vMax, 0.0F, 1.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMax, -0.03125F, uMin, vMax, 0.0F, 1.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMax, 0.03125F, uMin, xMaxRim, 0.0F, 1.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMax, 0.03125F, uMax, xMaxRim, 0.0F, 1.0F, 0.0F, pPackedLight);

				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMin, 0.03125F, uMax, vMin, 0.0F, -1.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMin, 0.03125F, uMin, vMin, 0.0F, -1.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMin, -0.03125F, uMin, vMinRim, 0.0F, -1.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMin, -0.03125F, uMax, vMinRim, 0.0F, -1.0F, 0.0F, pPackedLight);

				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMax, 0.03125F, uMax, vMax, -1.0F, 0.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMin, 0.03125F, uMax, vMin, -1.0F, 0.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMin, -0.03125F, uMaxRim, vMin, -1.0F, 0.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMax, zMax, -0.03125F, uMaxRim, vMax, -1.0F, 0.0F, 0.0F, pPackedLight);

				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMax, -0.03125F, uMinRim, vMax, 1.0F, 0.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMin, -0.03125F, uMinRim, vMin, 1.0F, 0.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMin, 0.03125F, uMin, vMin, 1.0F, 0.0F, 0.0F, pPackedLight);
				this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, xMin, zMax, 0.03125F, uMin, vMax, 1.0F, 0.0F, 0.0F, pPackedLight);
			}
		}
	}

	public void submitVertex(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, TextureAtlasSprite pTextureAtlasSprite, float pX, float pY, float pZ, float pU, float pV, float pNormalX, float pNormalY, float pNormalZ, int pPackedLight) {
		this.submitVertex(pSubmitNodeCollector, pPoseStack, pTextureAtlasSprite, pX, pY, pZ, pTextureAtlasSprite.getU(pU), pTextureAtlasSprite.getV(pV), pNormalX, pNormalY, pNormalZ, 1.0F, 1.0F, 1.0F, 1.0F, pPackedLight, OverlayTexture.NO_OVERLAY);
	}

	public void submitVertex(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, TextureAtlasSprite pTextureAtlasSprite, float pX, float pY, float pZ, float pU, float pV, float pNormalX, float pNormalY, float pNormalZ, float pRed, float pGreen, float pBlue, float pAlpha, int pPackedLight, int pPackedOverlay) {
		pSubmitNodeCollector.submitCustomGeometry(pPoseStack, RenderTypes.entitySolidZOffsetForward(pTextureAtlasSprite.atlasLocation()), (pose, vertexConsumer) -> vertexConsumer.addVertex(pose, pX, pY, pZ).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pPackedLight).setNormal(pose, pNormalX, pNormalY, pNormalZ).setOverlay(pPackedOverlay).setUv(pU, pV));
	}

	@Override
	public RugRenderState createRenderState() {
		return new RugRenderState();
	}
}
