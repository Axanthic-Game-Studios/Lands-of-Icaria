package com.axanthic.icaria.client.effects;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;

import org.joml.Matrix4f;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSpecialEffects extends DimensionSpecialEffects {
    public VertexBuffer darkSky;
    public VertexBuffer lightSky;
    public VertexBuffer starrySky;

    public IcariaSpecialEffects() {
        super(192, false, DimensionSpecialEffects.SkyType.NORMAL, false, false);
        this.createDarkSky();
        this.createLightSky();
        this.createStarrySky();
    }

    public boolean doesMobEffectBlockSky(Camera pCamera) {
        if (pCamera.getEntity() instanceof LivingEntity livingEntity) {
            return livingEntity.hasEffect(MobEffects.BLINDNESS) || livingEntity.hasEffect(MobEffects.DARKNESS);
        } else {
            return false;
        }
    }

    @Override
    public boolean isFoggyAt(int pX, int pY) {
        return false;
    }

    @Override
    public boolean renderSky(ClientLevel pLevel, int pTicks, float pPartialTick, PoseStack pPoseStack, Camera pCamera, Matrix4f pProjectionMatrix, boolean pIsFoggy, Runnable pSetupFog) {
        pSetupFog.run();
        if (!pIsFoggy) {
            var fogType = pCamera.getFluidInCamera();
            if (fogType != FogType.POWDER_SNOW && fogType != FogType.LAVA && !this.doesMobEffectBlockSky(pCamera)) {
                var minecraft = Minecraft.getInstance();
                if (minecraft.level.effects().skyType() == DimensionSpecialEffects.SkyType.NORMAL) {
                    var bufferBuilder = Tesselator.getInstance().getBuilder();
                    var shaderInstance = RenderSystem.getShader();
                    var vec3 = pLevel.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), pPartialTick);

                    float[] sunriseColor = pLevel.effects().getSunriseColor(pLevel.getTimeOfDay(pPartialTick), pPartialTick);

                    FogRenderer.levelFogColor();

                    RenderSystem.depthMask(false);
                    RenderSystem.enableBlend();
                    RenderSystem.setShaderColor((float) vec3.x, (float) vec3.y, (float) vec3.z, 1.0F);

                    this.lightSky.bind();
                    this.lightSky.drawWithShader(pPoseStack.last().pose(), pProjectionMatrix, shaderInstance);

                    VertexBuffer.unbind();

                    if (sunriseColor != null) {
                        RenderSystem.setShader(GameRenderer::getPositionColorShader);
                        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

                        pPoseStack.pushPose();
                        pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
                        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.sin(pLevel.getSunAngle(pPartialTick)) < 0.0F ? 180.0F : 0.0F));
                        pPoseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));

                        float red = sunriseColor[0];
                        float green = sunriseColor[1];
                        float blue = sunriseColor[2];
                        float alpha = sunriseColor[3];

                        var matrix4f = pPoseStack.last().pose();

                        bufferBuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
                        bufferBuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(red, green, blue, alpha).endVertex();

                        for (int i = 0; i <= 16; ++i) {
                            float f = i * (Mth.PI * 2.0F) / 16.0F;
                            float sin = Mth.sin(f);
                            float cos = Mth.cos(f);

                            bufferBuilder.vertex(matrix4f, sin * 120.0F, cos * 120.0F, -cos * 40.0F * alpha).color(red, green, blue, 0.0F).endVertex();
                        }

                        BufferUploader.drawWithShader(bufferBuilder.end());

                        pPoseStack.popPose();
                    }

                    pPoseStack.pushPose();
                    pPoseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));

                    int moonPhase = pLevel.getMoonPhase();
                    int i = moonPhase % 4;
                    int j = moonPhase / 4 % 2;

                    float u1 = (i + 0) / 4.0F;
                    float v1 = (j + 0) / 2.0F;
                    float u0 = (i + 1) / 4.0F;
                    float v0 = (j + 1) / 2.0F;
                    float rainLevel = 1.0F - pLevel.getRainLevel(pPartialTick);

                    var matrix4f = pPoseStack.last().pose();

                    RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, rainLevel);
                    RenderSystem.setShader(GameRenderer::getPositionTexShader);

                    pPoseStack.pushPose();
                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(45.0F));
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(pLevel.getTimeOfDay(pPartialTick) * 360.0F * 2.0F + 45.0F));

                    var extraMatrix4f = pPoseStack.last().pose();

                    RenderSystem.setShaderTexture(0, IcariaResourceLocations.MOON);

                    bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                    bufferBuilder.vertex(extraMatrix4f, -20.0F, -100.0F, 20.0F).uv(0.0F, 0.0F).endVertex();
                    bufferBuilder.vertex(extraMatrix4f, 20.0F, -100.0F, 20.0F).uv(0.25F, 0.0F).endVertex();
                    bufferBuilder.vertex(extraMatrix4f, 20.0F, -100.0F, -20.0F).uv(0.25F, 0.5F).endVertex();
                    bufferBuilder.vertex(extraMatrix4f, -20.0F, -100.0F, -20.0F).uv(0.0F, 0.5F).endVertex();

                    BufferUploader.drawWithShader(bufferBuilder.end());

                    pPoseStack.popPose();
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(pLevel.getTimeOfDay(pPartialTick) * 360.0F));

                    RenderSystem.setShaderTexture(0, IcariaResourceLocations.MOON);

                    bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                    bufferBuilder.vertex(matrix4f, -20.0F, -100.0F, 20.0F).uv(u0, v0).endVertex();
                    bufferBuilder.vertex(matrix4f, 20.0F, -100.0F, 20.0F).uv(u1, v0).endVertex();
                    bufferBuilder.vertex(matrix4f, 20.0F, -100.0F, -20.0F).uv(u1, v1).endVertex();
                    bufferBuilder.vertex(matrix4f, -20.0F, -100.0F, -20.0F).uv(u0, v1).endVertex();

                    BufferUploader.drawWithShader(bufferBuilder.end());

                    RenderSystem.setShaderTexture(0, IcariaResourceLocations.SUN);

                    bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                    bufferBuilder.vertex(matrix4f, -30.0F, 100.0F, -30.0F).uv(0.0F, 0.0F).endVertex();
                    bufferBuilder.vertex(matrix4f, 30.0F, 100.0F, -30.0F).uv(1.0F, 0.0F).endVertex();
                    bufferBuilder.vertex(matrix4f, 30.0F, 100.0F, 30.0F).uv(1.0F, 1.0F).endVertex();
                    bufferBuilder.vertex(matrix4f, -30.0F, 100.0F, 30.0F).uv(0.0F, 1.0F).endVertex();

                    BufferUploader.drawWithShader(bufferBuilder.end());

                    float starBrightness = pLevel.getStarBrightness(pPartialTick) * rainLevel;

                    if (starBrightness > 0.0F) {
                        FogRenderer.setupNoFog();

                        RenderSystem.setShaderColor(starBrightness, starBrightness, starBrightness, starBrightness);

                        this.starrySky.bind();
                        this.starrySky.drawWithShader(pPoseStack.last().pose(), pProjectionMatrix, GameRenderer.getPositionShader());

                        VertexBuffer.unbind();

                        pSetupFog.run();
                    }

                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    RenderSystem.disableBlend();
                    RenderSystem.defaultBlendFunc();

                    pPoseStack.popPose();

                    RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);

                    if (minecraft.player.getEyePosition(pPartialTick).y - pLevel.getLevelData().getHorizonHeight(pLevel) < 0.0D) {
                        pPoseStack.pushPose();
                        pPoseStack.translate(0.0F, 12.0F, 0.0F);

                        this.darkSky.bind();
                        this.darkSky.drawWithShader(pPoseStack.last().pose(), pProjectionMatrix, shaderInstance);

                        VertexBuffer.unbind();

                        pPoseStack.popPose();
                    }

                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                    RenderSystem.depthMask(true);
                }
            }
        }

        return true;
    }

    public void createDarkSky() {
        if (this.darkSky != null) {
            this.darkSky.close();
        }

        this.darkSky = new VertexBuffer(VertexBuffer.Usage.STATIC);
        this.darkSky.bind();
        this.darkSky.upload(this.buildSkyDisc(Tesselator.getInstance().getBuilder(), -16.0F));

        VertexBuffer.unbind();
    }

    public void createLightSky() {
        if (this.lightSky != null) {
            this.lightSky.close();
        }

        this.lightSky = new VertexBuffer(VertexBuffer.Usage.STATIC);
        this.lightSky.bind();
        this.lightSky.upload(this.buildSkyDisc(Tesselator.getInstance().getBuilder(), 16.0F));

        VertexBuffer.unbind();
    }

    public void createStarrySky() {
        RenderSystem.setShader(GameRenderer::getPositionShader);

        if (this.starrySky != null) {
            this.starrySky.close();
        }

        this.starrySky = new VertexBuffer(VertexBuffer.Usage.STATIC);
        this.starrySky.bind();
        this.starrySky.upload(this.drawStars(Tesselator.getInstance().getBuilder()));

        VertexBuffer.unbind();
    }

    public BufferBuilder.RenderedBuffer buildSkyDisc(BufferBuilder pBuilder, float pY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);

        pBuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
        pBuilder.vertex(0.0D, pY, 0.0D).endVertex();

        for (int i = -180; i <= 180; i += 45) {
            pBuilder.vertex(Math.signum(pY) * Mth.cos(i * (Mth.PI / 180.0F)) * 512.0F, pY, Mth.sin(i * (Mth.PI / 180.0F)) * 512.0F).endVertex();
        }

        return pBuilder.end();
    }

    public BufferBuilder.RenderedBuffer drawStars(BufferBuilder pBuilder) {
        var randomSource = RandomSource.create(10842L);

        pBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);

        for (int i = 0; i < 1500; ++i) {
            double d0 = randomSource.nextFloat() * 2.0F - 1.0F;
            double d1 = randomSource.nextFloat() * 2.0F - 1.0F;
            double d2 = randomSource.nextFloat() * 2.0F - 1.0F;
            double d3 = 0.15F + randomSource.nextFloat() * 0.1F;
            double d4 = d0 * d0 + d1 * d1 + d2 * d2;

            if (d4 < 1.0D && d4 > 0.01D) {
                d4 = 1.0D / Math.sqrt(d4);
                d0 *= d4;
                d1 *= d4;
                d2 *= d4;

                double d5 = d0 * 100.0D;
                double d6 = d1 * 100.0D;
                double d7 = d2 * 100.0D;
                double d8 = Math.atan2(d0, d2);
                double d9 = Math.sin(d8);
                double d10 = Math.cos(d8);
                double d11 = Math.atan2(Math.sqrt(d0 * d0 + d2 * d2), d1);
                double d12 = Math.sin(d11);
                double d13 = Math.cos(d11);
                double d14 = randomSource.nextDouble() * Mth.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for (int j = 0; j < 4; ++j) {
                    double d18 = ((j & 2) - 1) * d3;
                    double d19 = ((j + 1 & 2) - 1) * d3;
                    double d21 = d18 * d16 - d19 * d15;
                    double d22 = d19 * d16 + d18 * d15;
                    double d23 = d21 * d12 + 0.0D * d13;
                    double d24 = 0.0D * d12 - d21 * d13;
                    double d25 = d24 * d9 - d22 * d10;
                    double d26 = d22 * d9 + d24 * d10;

                    pBuilder.vertex(d5 + d25, d6 + d23, d7 + d26).endVertex();
                }
            }
        }

        return pBuilder.end();
    }

    @Override
    public Vec3 getBrightnessDependentFogColor(Vec3 pFogColor, float pBrightness) {
        return pFogColor.multiply(pBrightness * 0.94F + 0.06F, pBrightness * 0.94F + 0.06F, pBrightness * 0.91F + 0.09F);
    }
}
