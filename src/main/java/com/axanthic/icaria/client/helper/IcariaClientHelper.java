package com.axanthic.icaria.client.helper;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.registry.IcariaColors;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaValues;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import java.awt.*;
import java.io.IOException;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.imageio.ImageIO;

import net.minecraft.MethodsReturnNonnullByDefault;
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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.level.block.entity.BlockEntity;

import org.joml.Matrix4f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaClientHelper {

	public static float getAngleBasedAlpha(LivingEntity pLivingEntity, float pPartialTick) {
		if (pLivingEntity.level().getSunAngle(pPartialTick) >= IcariaValues.DUSK_INIT && pLivingEntity.level().getSunAngle(pPartialTick) < IcariaValues.DUSK_EXIT) {
			return (pLivingEntity.level().getSunAngle(pPartialTick) - IcariaValues.DUSK_INIT) / (IcariaValues.DUSK_EXIT - IcariaValues.DUSK_INIT);
		} else if (pLivingEntity.level().getSunAngle(pPartialTick) >= IcariaValues.DUSK_INIT && pLivingEntity.level().getSunAngle(pPartialTick) < IcariaValues.DAWN_INIT) {
			return 1.0F;
		} else if (pLivingEntity.level().getSunAngle(pPartialTick) >= IcariaValues.DAWN_INIT && pLivingEntity.level().getSunAngle(pPartialTick) < IcariaValues.DAWN_EXIT) {
			return (IcariaValues.DAWN_EXIT - pLivingEntity.level().getSunAngle(pPartialTick)) / (IcariaValues.DAWN_EXIT - IcariaValues.DAWN_INIT);
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

	public static float getLightBasedAlpha(LivingEntity pLivingEntity, float pPartialTick) {
		return Math.max(IcariaClientHelper.getAngleBasedAlpha(pLivingEntity, pPartialTick) * IcariaClientHelper.getBlockBasedAlpha(pLivingEntity), IcariaClientHelper.getLocalBasedAlpha(pLivingEntity));
	}

	public static float getRed(BlockEntity pBlockEntity) {
		return IcariaClientHelper.getImageBasedColor(pBlockEntity).getRed() / 255.0F;
	}

	public static float getRed(LivingEntity pLivingEntity) {
		return IcariaClientHelper.getImageBasedColor(pLivingEntity).getRed() / 255.0F;
	}

	public static float getGreen(BlockEntity pBlockEntity) {
		return IcariaClientHelper.getImageBasedColor(pBlockEntity).getGreen() / 255.0F;
	}

	public static float getGreen(LivingEntity pLivingEntity) {
		return IcariaClientHelper.getImageBasedColor(pLivingEntity).getGreen() / 255.0F;
	}

	public static float getBlue(BlockEntity pBlockEntity) {
		return IcariaClientHelper.getImageBasedColor(pBlockEntity).getBlue() / 255.0F;
	}

	public static float getBlue(LivingEntity pLivingEntity) {
		return IcariaClientHelper.getImageBasedColor(pLivingEntity).getBlue() / 255.0F;
	}

	public static int getColorAndAlpha(LivingEntity pLivingEntity) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : 1.0F, 1.0F, 1.0F, 1.0F);
	}

	public static int getColorAndAlpha(LivingEntity pLivingEntity, boolean pCondition) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : pCondition ? 1.0F : 0.0F, 1.0F, 1.0F, 1.0F);
	}

	public static int getColorAndAlpha(LivingEntity pLivingEntity, float pPartialTick) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick), 1.0F, 1.0F, 1.0F);
	}

	public static int getColorAndAlpha(LivingEntity pLivingEntity, float pPartialTick, float pRed, float pGreen, float pBlue) {
		return ARGB.colorFromFloat(pLivingEntity.isInvisible() ? 0.0F : IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick), pRed, pGreen, pBlue);
	}

	public static void anim(AnimationDefinition pAnimationDefinition, AnimationState pAnimationState, float pAgeInTicks, ModelPart pModelPart) {
		pAnimationDefinition.bake(pModelPart).apply(pAnimationState, pAgeInTicks);
	}

	public static void renderLeftHand(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, LocalPlayer pLocalPlayer, int pPackedLight, float pScale, float pX, float pY, float pZ, float pXRot, float pYRot, float pZRot) {
		pPoseStack.pushPose();
		pPoseStack.translate(pX, pY, pZ);
		pPoseStack.scale(pScale, pScale, pScale);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
		Minecraft.getInstance().getEntityRenderDispatcher().getPlayerRenderer(pLocalPlayer).renderLeftHand(pPoseStack, pSubmitNodeCollector, pPackedLight, pLocalPlayer.getSkin().body().texturePath(), pLocalPlayer.isModelPartShown(PlayerModelPart.LEFT_SLEEVE), pLocalPlayer);
		pPoseStack.popPose();
	}

	public static void renderRightHand(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, LocalPlayer pLocalPlayer, int pPackedLight, float pScale, float pX, float pY, float pZ, float pXRot, float pYRot, float pZRot) {
		pPoseStack.pushPose();
		pPoseStack.translate(pX, pY, pZ);
		pPoseStack.scale(pScale, pScale, pScale);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
		Minecraft.getInstance().getEntityRenderDispatcher().getPlayerRenderer(pLocalPlayer).renderRightHand(pPoseStack, pSubmitNodeCollector, pPackedLight, pLocalPlayer.getSkin().body().texturePath(), pLocalPlayer.isModelPartShown(PlayerModelPart.RIGHT_SLEEVE), pLocalPlayer);
		pPoseStack.popPose();
	}

	public static void setPart(PoseStack pPoseStack, ModelPart pModelPart) {
		pPoseStack.translate(pModelPart.xRot * IcariaValues.DEG_2_RAD, pModelPart.yRot * IcariaValues.DEG_2_RAD, pModelPart.zRot * IcariaValues.DEG_2_RAD);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pModelPart.xRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pModelPart.yRot));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(pModelPart.zRot));
		pPoseStack.translate(pModelPart.x / 16.0F, pModelPart.y / 16.0F, pModelPart.z / 16.0F);
	}

	public static void setPositionAndRotation(PoseStack pPoseStack, float pX, float pY, float pZ, float pXRot, float pYRot, float pZRot) {
		pPoseStack.translate(0.0F, 0.0F, 0.0F);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
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

	public static void submitItem(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, ItemStackRenderState pItemStackRenderState, Direction pDirection, int pPackedLight, float pXMin, float pXMax, float pY, float pZMin, float pZMax, float pXRot, float pYRot, float pZRot, float pXScale, float pYScale, float pZScale) {
		if (!pItemStackRenderState.isEmpty()) {
			pPoseStack.pushPose();
			IcariaClientHelper.translate(pPoseStack, pDirection, pXMin, pXMax, pY, pZMin, pZMax);
			pPoseStack.scale(pXScale, pYScale, pZScale);
			pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
			pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
			pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
			pItemStackRenderState.submit(pPoseStack, pSubmitNodeCollector, pPackedLight, OverlayTexture.NO_OVERLAY, 0);
			pPoseStack.popPose();
		}
	}

	public static void submitRays(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, float pRed, float pGreen, float pBlue) {
		var alpha = 0.1F;
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRed, pGreen, pBlue, alpha);
	}

	public static void submitRays(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, LivingEntity pLivingEntity, float pPartialTick, float pRed, float pGreen, float pBlue) {
		var alpha = 0.1F * (pLivingEntity.isInvisible() ? 0.0F : IcariaClientHelper.getLightBasedAlpha(pLivingEntity, pPartialTick));
		IcariaClientHelper.submitRays(pSubmitNodeCollector, pPoseStack, pRed, pGreen, pBlue, alpha);
	}

	public static void submitRays(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, float pRed, float pGreen, float pBlue, float pAlpha) {
		pSubmitNodeCollector.submitCustomGeometry(pPoseStack,
			IcariaRenderTypes.ADDITIVE,
			(pose, vertexConsumer) -> {
				var matrix4f = pose.pose();
				var randomSource = RandomSource.create(432L);
				var length = randomSource.nextFloat() * 2.0F + 2.0F;
				var width = randomSource.nextFloat() * 0.5F + 0.5F;
				if (IcariaConfig.RENDER_CRYSTAL_RAYS.get()) {
					for (var i = 0; i < 96; ++i) {
						pose.rotate(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F));
						IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, pAlpha);
						IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
						IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
						pose.rotate(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F));
						IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, pAlpha);
						IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
						IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
						pose.rotate(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F));
						IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, pAlpha);
						IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
						IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
					}
				}
			}
		);
	}

	public static void submitSprite(VertexConsumer pVertexConsumer, TextureAtlasSprite pTextureAtlasSprite, Matrix4f pMatrix4f, Direction pDirection, int pPackedLight, int pPackedOverlay, float pUMin, float pUMax, float pVMin, float pVMax, float pXMin, float pXMax, float pZMin, float pZMax, float pY, float pRed, float pGreen, float pBlue, float pAlpha) {
		if (pDirection == Direction.NORTH) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pPackedLight, pPackedOverlay, pUMin, pUMax, pVMin, pVMax, pXMin, pXMax, pZMin, pZMax, pY, pRed, pGreen, pBlue, pAlpha);
		} else if (pDirection == Direction.EAST) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pPackedLight, pPackedOverlay, 1.0F - pVMax, 1.0F - pVMin, pUMin, pUMax, 1.0F - pZMax, 1.0F - pZMin, pXMin, pXMax, pY, pRed, pGreen, pBlue, pAlpha);
		} else if (pDirection == Direction.SOUTH) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pPackedLight, pPackedOverlay, 1.0F - pUMax, 1.0F - pUMin, 1.0F - pVMax, 1.0F - pVMin, 1.0F - pXMax, 1.0F - pXMin, 1.0F - pZMax, 1.0F - pZMin, pY, pRed, pGreen, pBlue, pAlpha);
		} else if (pDirection == Direction.WEST) {
			IcariaClientHelper.submitSprite(pVertexConsumer, pTextureAtlasSprite, pMatrix4f, pPackedLight, pPackedOverlay, pVMin, pVMax, 1.0F - pUMax, 1.0F - pUMin, pZMin, pZMax, 1.0F - pXMax, 1.0F - pXMin, pY, pRed, pGreen, pBlue, pAlpha);
		}
	}

	public static void submitSprite(VertexConsumer pVertexConsumer, TextureAtlasSprite pTextureAtlasSprite, Matrix4f pMatrix4f, int pPackedLight, int pPackedOverlay, float pUMin, float pUMax, float pVMin, float pVMax, float pXMin, float pXMax, float pZMin, float pZMax, float pY, float pRed, float pGreen, float pBlue, float pAlpha) {
		pVertexConsumer.addVertex(pMatrix4f, pXMin, pY, pZMax).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(pTextureAtlasSprite.getU(pUMin), pTextureAtlasSprite.getV(pVMax));
		pVertexConsumer.addVertex(pMatrix4f, pXMax, pY, pZMax).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(pTextureAtlasSprite.getU(pUMax), pTextureAtlasSprite.getV(pVMax));
		pVertexConsumer.addVertex(pMatrix4f, pXMax, pY, pZMin).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(pTextureAtlasSprite.getU(pUMax), pTextureAtlasSprite.getV(pVMin));
		pVertexConsumer.addVertex(pMatrix4f, pXMin, pY, pZMin).setColor(pRed, pGreen, pBlue, pAlpha).setLight(pPackedLight).setNormal(1.0F, 1.0F, 1.0F).setOverlay(pPackedOverlay).setUv(pTextureAtlasSprite.getU(pUMin), pTextureAtlasSprite.getV(pVMin));
	}

	public static void submitString(SubmitNodeCollector pSubmitNodeCollector, PoseStack pPoseStack, Component pComponent, int pPackedLight, float pScale, float pX, float pY, float pXRot, float pYRot, float pZRot) {
		pPoseStack.pushPose();
		pPoseStack.scale(pScale, pScale, pScale);
		pPoseStack.mulPose(Axis.XP.rotationDegrees(pXRot));
		pPoseStack.mulPose(Axis.YP.rotationDegrees(pYRot));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(pZRot));
		pSubmitNodeCollector.submitText(pPoseStack, pX - Minecraft.getInstance().font.width(pComponent) * 0.5F, pY, pComponent.getVisualOrderText(), false, Font.DisplayMode.POLYGON_OFFSET, pPackedLight, IcariaColors.TEXT, 0, 0);
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

	public static Color getImageBasedColor(BlockEntity pBlockEntity) {
		var resourceLocation = ResourceLocation.parse(IcariaIdents.ID + ":" + "textures" + "/" + "block" + "/" + BuiltInRegistries.BLOCK.getKey(pBlockEntity.getBlockState().getBlock()).getPath() + "_" + "rays" + "." + "png");
		return IcariaClientHelper.getColor(resourceLocation);
	}

	public static Color getImageBasedColor(LivingEntity pLivingEntity) {
		var resourceLocation = ResourceLocation.parse(IcariaIdents.ID + ":" + "textures" + "/" + "entity" + "/" + BuiltInRegistries.ENTITY_TYPE.getKey(pLivingEntity.getType()).getPath() + "_" + "rays" + "." + "png");
		return IcariaClientHelper.getColor(resourceLocation);
	}

	public static Color getColor(ResourceLocation pResourceLocation) {
		var optional = Minecraft.getInstance().getResourceManager().getResource(pResourceLocation);
		if (optional.isPresent()) {
			try {
				return new Color(ImageIO.read(optional.get().open()).getRGB(0, 0));
			} catch (IOException pException) {
				throw new RuntimeException(pException);
			}
		} else {
			return new Color(0, 0, 0);
		}
	}
}
