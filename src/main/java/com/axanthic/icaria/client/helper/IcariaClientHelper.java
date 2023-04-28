package com.axanthic.icaria.client.helper;

import com.axanthic.icaria.client.registry.IcariaRenderTypes;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.util.IcariaMath;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;

import org.joml.Matrix4f;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaClientHelper {
    public static float getLightBasedAlpha(LivingEntity pLivingEntity) {
        if (pLivingEntity.level.getDayTime() >= IcariaInfo.DUSK_INIT && pLivingEntity.level.getDayTime() < IcariaInfo.DUSK_EXIT) {
            return (pLivingEntity.level.getDayTime() - IcariaInfo.DUSK_INIT) / (IcariaInfo.DUSK_EXIT - IcariaInfo.DUSK_INIT);
        } else if (pLivingEntity.level.getDayTime() >= IcariaInfo.DUSK_INIT && pLivingEntity.level.getDayTime() < IcariaInfo.DAWN_INIT) {
            return 1.0F;
        } else if (pLivingEntity.level.getDayTime() >= IcariaInfo.DAWN_INIT && pLivingEntity.level.getDayTime() < IcariaInfo.DAWN_EXIT) {
            return (IcariaInfo.DAWN_EXIT - pLivingEntity.level.getDayTime()) / (IcariaInfo.DAWN_EXIT - IcariaInfo.DAWN_INIT);
        } else {
            return 0.0F;
        }
    }

    public static void renderRays(PoseStack pPoseStack, MultiBufferSource pBuffer, LivingEntity pLivingEntity, float pRed, float pGreen, float pBlue) {
        if (IcariaConfig.RENDER_RAYS.get()) {
            Matrix4f matrix4f = pPoseStack.last().pose();
            RandomSource randomSource = RandomSource.create(432L);
            VertexConsumer vertexConsumer = pBuffer.getBuffer(IcariaRenderTypes.ADDITIVE_LIGHTNING);

            float alpha = (0.1F - Math.min(0.0F, 0.1F)) * (!pLivingEntity.isInvisible() ? IcariaClientHelper.getLightBasedAlpha(pLivingEntity) : 0.0F);
            float length = randomSource.nextFloat() * 2.0F + 1.25F;
            float width = randomSource.nextFloat() * 0.5F + 0.25F;

            for (int i = 0; i < 96; ++i) {
                pPoseStack.mulPose(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F));
                pPoseStack.mulPose(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F));

                IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, alpha);
                IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, alpha);
                IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, alpha);
                IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
            }
        }
    }

    public static void renderRays(PoseStack pPoseStack, MultiBufferSource pBuffer, float pRed, float pGreen, float pBlue) {
        if (IcariaConfig.RENDER_RAYS.get()) {
            Matrix4f matrix4f = pPoseStack.last().pose();
            RandomSource randomSource = RandomSource.create(432L);
            VertexConsumer vertexConsumer = pBuffer.getBuffer(IcariaRenderTypes.ADDITIVE_LIGHTNING);

            float alpha = (0.1F - Math.min(0.0F, 0.1F));
            float length = randomSource.nextFloat() * 2.0F + 1.25F;
            float width = randomSource.nextFloat() * 0.5F + 0.25F;

            for (int i = 0; i < 96; ++i) {
                pPoseStack.mulPose(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F));
                pPoseStack.mulPose(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F));

                IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, alpha);
                IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, alpha);
                IcariaClientHelper.vertexC(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexA(vertexConsumer, matrix4f, pRed, pGreen, pBlue, alpha);
                IcariaClientHelper.vertexD(vertexConsumer, matrix4f, length, width);
                IcariaClientHelper.vertexB(vertexConsumer, matrix4f, length, width);
            }
        }
    }

    public static void setItem(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, LivingEntity pLivingEntity) {
        Minecraft.getInstance().getItemRenderer().renderStatic(pLivingEntity, pLivingEntity.getMainHandItem(), ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, false, pPoseStack, pBuffer, pLivingEntity.level, pPackedLight, OverlayTexture.NO_OVERLAY, pLivingEntity.getId() + ItemDisplayContext.THIRD_PERSON_RIGHT_HAND.ordinal());
    }

    public static void setPart(PoseStack pPoseStack, ModelPart pModelPart) {
        pPoseStack.translate(pModelPart.xRot / (180.0F / Mth.PI), pModelPart.yRot / (180.0F / Mth.PI), pModelPart.zRot / (180.0F / Mth.PI));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(pModelPart.xRot));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pModelPart.yRot));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(pModelPart.zRot));
        pPoseStack.translate(pModelPart.x / 16.0F, pModelPart.y / 16.0F, pModelPart.z / 16.0F);
    }

    public static void setPositionAndRotation(PoseStack pPoseStack, float pX, float pY, float pZ, float pRotX, float pRotY, float pRotZ) {
        pPoseStack.translate(0.0F, 0.0F, 0.0F);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(pRotX));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(pRotY));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(pRotZ));
        pPoseStack.translate(pX, pY, pZ);
    }

    public static void setPositionAndSize(PoseStack pPoseStack, double pX, double pY, double pZ, float pSize) {
        pPoseStack.translate(pX, pY, pZ);
        pPoseStack.scale(pSize, pSize, pSize);
    }

    public static void setPositionAndSize(PoseStack pPoseStack, float pX, float pY, float pZ, float pSize) {
        pPoseStack.translate(pX, pY, pZ);
        pPoseStack.scale(pSize, pSize, pSize);
    }

    public static void setRotateAngles(ModelPart pModelPart, float pX, float pY, float pZ) {
        pModelPart.xRot = pX;
        pModelPart.yRot = pY;
        pModelPart.zRot = pZ;
    }

    public static void vertexA(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pRed, float pGreen, float pBlue, float pAlpha) {
        pVertexConsumer.vertex(pMatrix4f, 0.0F, 0.0F, 0.0F).color(pRed, pGreen, pBlue, pAlpha).endVertex();
    }

    public static void vertexB(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, -IcariaMath.HALFSQRT3 * pWidth, pLength, -0.5F * pWidth).color(0.0F, 0.0F, 0.0F, 0.0F).endVertex();
    }

    public static void vertexC(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, IcariaMath.HALFSQRT3 * pWidth, pLength, -0.5F * pWidth).color(0.0F, 0.0F, 0.0F, 0.0F).endVertex();
    }

    public static void vertexD(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, 0.0F, pLength, pWidth).color(0.0F, 0.0F, 0.0F, 0.0F).endVertex();
    }
}
