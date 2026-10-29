package com.axanthic.icaria.client.helper;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.client.meta.ColorMetadataManager;
import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaValues;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.gui.Font;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ARGB;
import net.minecraft.util.RandomSource;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.level.block.entity.BlockEntity;

import org.joml.Matrix4f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaClientHelper {

	public static float getAngleBasedAlpha(LivingEntity pLivingEntity) {
		if (pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position()) >= IcariaValues.DUSK_INIT && pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position()) < IcariaValues.DUSK_EXIT) {
			return (pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position()) - IcariaValues.DUSK_INIT) / (IcariaValues.DUSK_EXIT - IcariaValues.DUSK_INIT);
		} else if (pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position()) >= IcariaValues.DUSK_INIT && pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position()) < IcariaValues.DAWN_INIT) {
			return 1.0F;
		} else if (pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position()) >= IcariaValues.DAWN_INIT && pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position()) < IcariaValues.DAWN_EXIT) {
			return (IcariaValues.DAWN_EXIT - pLivingEntity.level().environmentAttributes().getValue(EnvironmentAttributes.SUN_ANGLE, pLivingEntity.position())) / (IcariaValues.DAWN_EXIT - IcariaValues.DAWN_INIT);
		} else {
			return 0.0F;
		}
	}

	public static float getBlockBasedAlpha(LivingEntity pLivingEntity) {
		return (15.0F - pLivingEntity.level().getRawBrightness(pLivingEntity.blockPosition(), 15)) / 15.0F;
	}

	public static float getLocalBasedAlpha(LivingEntity pLivingEntity) {
		return (15.0F - pLivingEntity.level().getMaxLocalRawBrightness(pLivingEntity.blockPosition(), 0)) / 15.0F;
	}

	public static float getLightBasedAlpha(LivingEntity pLivingEntity) {
		return Math.max(IcariaClientHelper.getAngleBasedAlpha(pLivingEntity) * IcariaClientHelper.getBlockBasedAlpha(pLivingEntity), IcariaClientHelper.getLocalBasedAlpha(pLivingEntity));
	}

	public static int getColor(BlockEntity pBlockEntity) {
		return ColorMetadataManager.resolve(BuiltInRegistries.BLOCK.getKey(pBlockEntity.getBlockState().getBlock()).withPrefix("block" + "/"));
	}

	public static int getColor(LivingEntity pLivingEntity) {
		return ColorMetadataManager.resolve(BuiltInRegistries.ENTITY_TYPE.getKey(pLivingEntity.getType()).withPrefix("entity" + "/"));
	}

	public static int getColorAndAlpha(LivingEntity pLivingEntity) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : 1.0F, 1.0F, 1.0F, 1.0F);
	}

	public static int getColorAndAlpha(LivingEntity pLivingEntity, boolean pCondition) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : pCondition ? 1.0F : 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public static int getLightBasedColorAndAlpha(LivingEntity pLivingEntity) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : IcariaClientHelper.getLightBasedAlpha(pLivingEntity), 1.0F, 1.0F, 1.0F);
	}

	public static int getLightBasedColorAndAlpha(LivingEntity pLivingEntity, float pRed, float pGreen, float pBlue) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : IcariaClientHelper.getLightBasedAlpha(pLivingEntity), pRed, pGreen, pBlue);
	}

	public static void anim(AnimationDefinition pAnimationDefinition, AnimationState pAnimationState, float pAgeInTicks, ModelPart pModelPart) {
		pAnimationDefinition.bake(pModelPart).apply(pAnimationState, pAgeInTicks);
	}

	public static void renderLeftHand(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, LocalPlayer pLocalPlayer, int pOverlayCoords, float pScale, float pX, float pY, float pZ, float pXRot, float pYRot, float pZRot) {
		var avatarRenderState = Minecraft.getInstance().gameRenderer.gameRenderState().levelRenderState.playerRenderState.avatarRenderState;
		if (avatarRenderState != null) {
			pPoseStack.pushPose();
			pPoseStack.translate(pX, pY, pZ);
			pPoseStack.scale(pScale, pScale, pScale);
			pPoseStack.rotateDegrees(Axis.XP, pXRot);
			pPoseStack.rotateDegrees(Axis.YP, pYRot);
			pPoseStack.rotateDegrees(Axis.ZP, pZRot);
			Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(avatarRenderState).renderLeftHand(pPoseStack, pSubmitNodeCollector, pOverlayCoords, pLocalPlayer.getSkin().body().texturePath(), pLocalPlayer.isModelPartShown(PlayerModelPart.LEFT_SLEEVE));
			pPoseStack.popPose();
		}
	}

	public static void renderRightHand(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, LocalPlayer pLocalPlayer, int pOverlayCoords, float pScale, float pX, float pY, float pZ, float pXRot, float pYRot, float pZRot) {
		var avatarRenderState = Minecraft.getInstance().gameRenderer.gameRenderState().levelRenderState.playerRenderState.avatarRenderState;
		if (avatarRenderState != null) {
			pPoseStack.pushPose();
			pPoseStack.translate(pX, pY, pZ);
			pPoseStack.scale(pScale, pScale, pScale);
			pPoseStack.rotateDegrees(Axis.XP, pXRot);
			pPoseStack.rotateDegrees(Axis.YP, pYRot);
			pPoseStack.rotateDegrees(Axis.ZP, pZRot);
			Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(avatarRenderState).renderRightHand(pPoseStack, pSubmitNodeCollector, pOverlayCoords, pLocalPlayer.getSkin().body().texturePath(), pLocalPlayer.isModelPartShown(PlayerModelPart.RIGHT_SLEEVE));
			pPoseStack.popPose();
		}
	}

	public static void setPart(PoseStack pPoseStack, ModelPart pModelPart) {
		pPoseStack.translate(pModelPart.xRot * IcariaValues.DEG_2_RAD, pModelPart.yRot * IcariaValues.DEG_2_RAD, pModelPart.zRot * IcariaValues.DEG_2_RAD);
		pPoseStack.rotateDegrees(Axis.XP, pModelPart.xRot);
		pPoseStack.rotateDegrees(Axis.YP, pModelPart.yRot);
		pPoseStack.rotateDegrees(Axis.ZP, pModelPart.zRot);
		pPoseStack.translate(pModelPart.x / 16.0F, pModelPart.y / 16.0F, pModelPart.z / 16.0F);
	}

	public static void setPositionAndRotation(PoseStack pPoseStack, float pX, float pY, float pZ, float pXRot, float pYRot, float pZRot) {
		pPoseStack.translate(0.0F, 0.0F, 0.0F);
		pPoseStack.rotateDegrees(Axis.XP, pXRot);
		pPoseStack.rotateDegrees(Axis.YP, pYRot);
		pPoseStack.rotateDegrees(Axis.ZP, pZRot);
		pPoseStack.translate(pX, pY, pZ);
	}

	public static void setPositionAndSize(PoseStack pPoseStack, double pX, double pY, double pZ, float pScale) {
		pPoseStack.translate(pX, pY, pZ);
		pPoseStack.scale(pScale, pScale, pScale);
	}

	public static void setPositionAndSize(PoseStack pPoseStack, float pX, float pY, float pZ, float pScale) {
		pPoseStack.translate(pX, pY, pZ);
		pPoseStack.scale(pScale, pScale, pScale);
	}

	public static void setRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ) {
		pModelPart.xRot = pX;
		pModelPart.yRot = pY;
		pModelPart.zRot = pZ;
	}

	public static void submitItem(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, ItemStackRenderState pItemStackRenderState, Direction pDirection, int pLightCoords, float pXMin, float pXMax, float pY, float pZMin, float pZMax, float pXRot, float pYRot, float pZRot, float pXScale, float pYScale, float pZScale) {
		if (!pItemStackRenderState.isEmpty()) {
			pPoseStack.pushPose();
			IcariaClientHelper.translate(pPoseStack, pDirection, pXMin, pXMax, pY, pZMin, pZMax);
			pPoseStack.scale(pXScale, pYScale, pZScale);
			pPoseStack.rotateDegrees(Axis.XP, pXRot);
			pPoseStack.rotateDegrees(Axis.YP, pYRot);
			pPoseStack.rotateDegrees(Axis.ZP, pZRot);
			pItemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pLightCoords, OverlayTexture.NO_OVERLAY, 0);
			pPoseStack.popPose();
		}
	}

	public static void submitRays(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, int pColor) {
		var alpha = 0.1F;
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pColor, alpha);
	}

	public static void submitRays(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, LivingEntity pLivingEntity, int pColor) {
		var alpha = 0.1F * (pLivingEntity.isInvisible() ? 0.0F : IcariaClientHelper.getLightBasedAlpha(pLivingEntity));
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pColor, alpha);
	}

	public static void submitRays(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, int pColor, float pAlpha) {
		pSubmitNodeCollector.submitCustomGeometry(pPoseStack,
			IcariaRenderTypes.additive(),
			(pose, vertexConsumer) -> {
				var matrix4f = pose.pose();
				var randomSource = RandomSource.create(432L);
				var length = randomSource.nextFloat() * 2.0F + 2.0F;
				var width = randomSource.nextFloat() * 0.5F + 0.5F;
				var red = (pColor >> 16 & 255) / 255.0F;
				var green = (pColor >> 8 & 255) / 255.0F;
				var blue = (pColor & 255) / 255.0F;
				if (IcariaConfig.RENDER_DISTANCE_CLUSTER_RAYS.get() > 0) {
					for (var i = 0; i < 96; ++i) {
						pose.rotate(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F));
						IcariaClientHelper.vertexA(vertexConsumer, matrix4f, red, green, blue, pAlpha);
						IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
						IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
						pose.rotate(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F));
						IcariaClientHelper.vertexA(vertexConsumer, matrix4f, red, green, blue, pAlpha);
						IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
						IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
						pose.rotate(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F));
						IcariaClientHelper.vertexA(vertexConsumer, matrix4f, red, green, blue, pAlpha);
						IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
						IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
					}
				}
			}
		);
	}

	public static void submitSprite(VertexConsumer pVertexConsumer, TextureAtlasSprite pTextureAtlasSprite, Matrix4f pMatrix4f, Direction pDirection, int pLightCoords, int pOverlayCoords, float pUMin, float pUMax, float pVMin, float pVMax, float pXMin, float pXMax, float pZMin, float pZMax, float pY, float pRed, float pGreen, float pBlue, float pAlpha) {
		if (pDirection == Direction.NORTH) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pLightCoords, pOverlayCoords, pUMin, pUMax, pVMin, pVMax, pXMin, pXMax, pZMin, pZMax, pY, pRed, pGreen, pBlue, pAlpha);
		} else if (pDirection == Direction.EAST) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pLightCoords, pOverlayCoords, 1.0F - pVMax, 1.0F - pVMin, pUMin, pUMax, 1.0F - pZMax, 1.0F - pZMin, pXMin, pXMax, pY, pRed, pGreen, pBlue, pAlpha);
		} else if (pDirection == Direction.SOUTH) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pLightCoords, pOverlayCoords, 1.0F - pUMax, 1.0F - pUMin, 1.0F - pVMax, 1.0F - pVMin, 1.0F - pXMax, 1.0F - pXMin, 1.0F - pZMax, 1.0F - pZMin, pY, pRed, pGreen, pBlue, pAlpha);
		} else if (pDirection == Direction.WEST) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pLightCoords, pOverlayCoords, pVMin, pVMax, 1.0F - pUMax, 1.0F - pUMin, pZMin, pZMax, 1.0F - pXMax, 1.0F - pXMin, pY, pRed, pGreen, pBlue, pAlpha);
		}
	}

	public static void submitSprite(VertexConsumer pVertexConsumer, TextureAtlasSprite pTextureAtlasSprite, Matrix4f pMatrix4f, int pLightCoords, int pOverlayCoords, float pUMin, float pUMax, float pVMin, float pVMax, float pXMin, float pXMax, float pZMin, float pZMax, float pY, float pRed, float pGreen, float pBlue, float pAlpha) {
		pVertexConsumer.addVertex(pMatrix4f, pXMin, pY, pZMax).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(pTextureAtlasSprite.getU(pUMin), pTextureAtlasSprite.getV(pVMax));
		pVertexConsumer.addVertex(pMatrix4f, pXMax, pY, pZMax).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(pTextureAtlasSprite.getU(pUMax), pTextureAtlasSprite.getV(pVMax));
		pVertexConsumer.addVertex(pMatrix4f, pXMax, pY, pZMin).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(pTextureAtlasSprite.getU(pUMax), pTextureAtlasSprite.getV(pVMin));
		pVertexConsumer.addVertex(pMatrix4f, pXMin, pY, pZMin).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pLightCoords).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pOverlayCoords).setUv(pTextureAtlasSprite.getU(pUMin), pTextureAtlasSprite.getV(pVMin));
	}

	public static void submitString(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, Component pComponent, int pLightCoords, float pScale, float pX, float pY, float pXRot, float pYRot, float pZRot) {
		pPoseStack.pushPose();
		pPoseStack.scale(pScale, pScale, pScale);
		pPoseStack.rotateDegrees(Axis.XP, pXRot);
		pPoseStack.rotateDegrees(Axis.YP, pYRot);
		pPoseStack.rotateDegrees(Axis.ZP, pZRot);
		pSubmitNodeCollector.submitText(pPoseStack, pX - Minecraft.getInstance().font.width(pComponent) * 0.5F, pY, pComponent.getVisualOrderText(), false, Font.DisplayMode.POLYGON_OFFSET, pLightCoords, IcariaColors.TEXT, 0, 0);
		pPoseStack.popPose();
	}

	public static void translate(PoseStack pPoseStack, Direction pDirection, float pXMin, float pXMax, float pY, float pZMin, float pZMax) {
		if (pDirection == Direction.NORTH) {
			pPoseStack.translate(pXMax, pY, pZMin);
		} else if (pDirection == Direction.EAST) {
			pPoseStack.translate(pZMax, pY, pXMax);
		} else if (pDirection == Direction.SOUTH) {
			pPoseStack.translate(pXMin, pY, pZMax);
		} else if (pDirection == Direction.WEST) {
			pPoseStack.translate(pZMin, pY, pXMin);
		}
	}

	public static void vertexA(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pRed, float pGreen, float pBlue, float pAlpha) {
		pVertexConsumer.addVertex(pMatrix4f, 0.0F, 0.0F, 0.0F).setColor(pRed, pGreen, pBlue, pAlpha);
	}

	public static void vertexB(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
		pVertexConsumer.addVertex(pMatrix4f, pWidth * -IcariaValues.HALFSQRT3, pLength, pWidth * -0.5F).setColor(0.0F, 0.0F, 0.0F, 0.0F);
	}

	public static void vertexC(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
		pVertexConsumer.addVertex(pMatrix4f, pWidth * IcariaValues.HALFSQRT3, pLength, pWidth * -0.5F).setColor(0.0F, 0.0F, 0.0F, 0.0F);
	}

	public static void vertexD(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
		pVertexConsumer.addVertex(pMatrix4f, 0.0F, pLength, pWidth).setColor(0.0F, 0.0F, 0.0F, 0.0F);
	}
}
