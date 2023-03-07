package com.axanthic.icaria.client.layer;

import com.axanthic.icaria.client.model.CrystalSlugModel;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.entity.SlugEntity;

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

public class CrystalSlugRaysLayer extends RenderLayer<SlugEntity, CrystalSlugModel> {
    public static final float HALF_SQRT_3 = Mth.sqrt(3.0F) / 2.0F;

    public float duskInit = 12000.0F;
    public float duskExit = 13000.0F;
    public float dawnInit = 23000.0F;
    public float dawnExit = 24000.0F;

    public float x;
    public float y;
    public float z;
    public float multX;
    public float multY;
    public float multZ;

    public CrystalSlugModel model;

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

    public CrystalSlugRaysLayer(RenderLayerParent<SlugEntity, CrystalSlugModel> pRenderer, EntityModelSet pSet, float pX, float pY, float pZ, float pMultX, float pMultY, float pMultZ) {
        super(pRenderer);
        this.model = new CrystalSlugModel(pSet.bakeLayer(CrystalSlugModel.RAYS_LAYER_LOCATION));
        this.x = pX;
        this.y = pY;
        this.z = pZ;
        this.multX = pMultX;
        this.multY = pMultY;
        this.multZ = pMultZ;
    }

    public float lightBasedAlpha(float pTime) {
        if (pTime >= duskInit && pTime < duskExit) {
            return ((pTime - duskInit) / (duskExit - duskInit));
        } else if (pTime >= duskExit && pTime < dawnInit) {
            return 1.0F;
        } else if (pTime >= dawnInit && pTime < dawnExit) {
            return ((dawnExit - pTime) / (dawnExit - dawnInit));
        } else {
            return 0.0F;
        }
    }

    @Override
    public void render(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, SlugEntity pLivingEntity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        pPoseStack.pushPose();
        if (IcariaConfig.RENDER_RAYS.get()) {
            Matrix4f matrix4f = pPoseStack.last().pose();
            RandomSource randomSource = RandomSource.create(432L);
            VertexConsumer vertexConsumer = pBuffer.getBuffer(ADDITIVE_LIGHTNING);

            float r = 1.0F;
            float g = 0.0F;
            float b = 0.1F;
            float alpha = (0.1F - Math.min(0.0F, 0.1F)) * this.lightBasedAlpha(pLivingEntity.level.getDayTime());
            float length = randomSource.nextFloat() * 2.0F + 1.25F;
            float width = randomSource.nextFloat() * 0.5F + 0.25F;

            pPoseStack.translate((Mth.sin(pLimbSwing * this.model.mult) * pLimbSwingAmount * this.multX) + this.x, (Mth.sin(pLimbSwing * this.model.mult) * pLimbSwingAmount * this.multY) + this.y, (Mth.sin(pLimbSwing * this.model.mult) * pLimbSwingAmount * this.multZ) + this.z);
            pPoseStack.scale(0.375F, 0.375F, 0.375F);

            for (int i = 0; i < 96; ++i) {
                pPoseStack.mulPose(Axis.XP.rotationDegrees(randomSource.nextFloat() * 360.0F));
                pPoseStack.mulPose(Axis.YP.rotationDegrees(randomSource.nextFloat() * 360.0F));
                pPoseStack.mulPose(Axis.ZP.rotationDegrees(randomSource.nextFloat() * 360.0F));

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

        pPoseStack.popPose();
    }

    public void vertexA(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pRed, float pGreen, float pBlue, float pAlpha) {
        pVertexConsumer.vertex(pMatrix4f, 0.0F, 0.0F, 0.0F).color(pRed, pGreen, pBlue, pAlpha).endVertex();
    }

    public void vertexB(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, -HALF_SQRT_3 * pWidth, pLength, -0.5F * pWidth).color(0.0F, 0.0F, 0.0F, 0.0F).endVertex();
    }

    public void vertexC(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, HALF_SQRT_3 * pWidth, pLength, -0.5F * pWidth).color(0.0F, 0.0F, 0.0F, 0.0F).endVertex();
    }

    public void vertexD(VertexConsumer pVertexConsumer, Matrix4f pMatrix4f, float pLength, float pWidth) {
        pVertexConsumer.vertex(pMatrix4f, 0.0F, pLength, pWidth).color(0.0F, 0.0F, 0.0F, 0.0F).endVertex();
    }
}
