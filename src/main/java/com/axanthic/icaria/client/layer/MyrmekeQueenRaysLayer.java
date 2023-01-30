package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.MyrmekeQueenModel;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.MyrmekeQueenEntity;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;

import org.joml.Matrix4f;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")
@ParametersAreNonnullByDefault

public class MyrmekeQueenRaysLayer extends RenderLayer<MyrmekeQueenEntity, MyrmekeQueenModel> {
    public static final float HALF_SQRT_3 = Mth.sqrt(3.0F) / 2.0F;

    public MyrmekeQueenModel model;

    public static final RenderStateShard.ShaderStateShard LIGHTNING_SHADER = new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeLightningShader);

    public static final RenderStateShard.TransparencyStateShard ADDITIVE_LIGHTNING_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("additive_lightning_transparency", () -> {
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
    }, () -> {
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public static final RenderStateShard.TransparencyStateShard SUBTRACTIVE_LIGHTNING_TRANSPARENCY = new RenderStateShard.TransparencyStateShard("subtractive_lightning_transparency", () -> {
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.SRC_COLOR, GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE);
    }, () -> {
        RenderSystem.depthMask(true);
        RenderSystem.disableBlend();
        RenderSystem.defaultBlendFunc();
    });

    public static final RenderType ADDITIVE_LIGHTNING = RenderType.create("additive_lightning", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.builder().setShaderState(LIGHTNING_SHADER).setTransparencyState(ADDITIVE_LIGHTNING_TRANSPARENCY).createCompositeState(false));
    public static final RenderType SUBTRACTIVE_LIGHTNING = RenderType.create("subtractive_lightning", DefaultVertexFormat.POSITION_COLOR, VertexFormat.Mode.QUADS, 256, false, true, RenderType.CompositeState.builder().setShaderState(LIGHTNING_SHADER).setTransparencyState(SUBTRACTIVE_LIGHTNING_TRANSPARENCY).createCompositeState(false));

    public MyrmekeQueenRaysLayer(RenderLayerParent<MyrmekeQueenEntity, MyrmekeQueenModel> pRenderer, EntityModelSet pSet) {
        super(pRenderer);
        this.model = new MyrmekeQueenModel(pSet.bakeLayer(MyrmekeQueenModel.RAYS_LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, MyrmekeQueenEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (IcariaConfig.RENDER_RAYS.get()) {
            float random = RandomSource.create(432L).nextFloat();
            float length = random * 2.0F + 1.25F;
            float width = random * 0.5F + 0.25F;

            int alpha = (int) (16.0F * (1.0F - Math.min(0.0F, 1.0F)));
            int r = 255;
            int g = 0;
            int b = 0;

            Matrix4f matrix4f = pPoseStack.last().pose();
            VertexConsumer vertexConsumer = pBuffer.getBuffer(ADDITIVE_LIGHTNING);

            pPoseStack.translate(0.0F, 1.225F, -0.365F);
            pPoseStack.mulPose(Axis.XP.rotationDegrees(pHeadPitch));
            pPoseStack.mulPose(Axis.YP.rotationDegrees(pNetHeadYaw));
            pPoseStack.translate(0.0F, -0.035F, -0.215F);
            pPoseStack.scale(0.5F, 0.5F, 0.5F);

            for (int i = 0; i < 96; ++i) {
                pPoseStack.mulPose(Axis.XP.rotationDegrees(random * 360.0F));
                pPoseStack.mulPose(Axis.YP.rotationDegrees(random * 360.0F));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(random * 360.0F));

                this.vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
                this.vertexB(vertexConsumer, matrix4f, length, width);
                this.vertexC(vertexConsumer, matrix4f, length, width);
                this.vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
                this.vertexC(vertexConsumer, matrix4f, length, width);
                this.vertexD(vertexConsumer, matrix4f, length, width);
                this.vertexA(vertexConsumer, matrix4f, r, g, b, alpha);
                this.vertexD(vertexConsumer, matrix4f, length, width);
                this.vertexB(vertexConsumer, matrix4f, length, width);
            }
        }
    }

    public void vertexA(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, int pRed, int pGreen, int pBlue, int pAlpha) {
        pVertexConsumer.vertex(pMatrix4f, 0.0F, 0.0F, 0.0F).color(pRed, pGreen, pBlue, pAlpha).endVertex();
    }

    public void vertexB(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, -HALF_SQRT_3 * pWidth, pLength, -0.5F * pWidth).color(255, 255, 255, 0).endVertex();
    }

    public void vertexC(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, HALF_SQRT_3 * pWidth, pLength, -0.5F * pWidth).color(255, 255, 255, 0).endVertex();
    }

    public void vertexD(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, 0.0F, pLength, pWidth).color(255, 255, 255, 0).endVertex();
    }
}
