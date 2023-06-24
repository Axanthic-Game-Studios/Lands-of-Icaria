package com.axanthic.icaria.client.proxy;

import com.axanthic.icaria.client.registry.IcariaResourceLocations;

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
    public VertexBuffer darkBuffer;
    public VertexBuffer skyBuffer;
    public VertexBuffer starBuffer;

    public IcariaSpecialEffects() {
        super(192, false, DimensionSpecialEffects.SkyType.NORMAL, false, false);
        this.createDarkSky();
        this.createLightSky();
        this.createStars();
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


                    var vec3 = pLevel.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), pPartialTick);

                    float x = (float) vec3.x;
                    float y = (float) vec3.y;
                    float z = (float) vec3.z;

                    FogRenderer.levelFogColor();
                    var bufferBuilder = Tesselator.getInstance().getBuilder();
                    RenderSystem.depthMask(false);
                    RenderSystem.setShaderColor(x, y, z, 1.0F);
                    var shaderInstance = RenderSystem.getShader();

                    this.skyBuffer.bind();
                    this.skyBuffer.drawWithShader(pPoseStack.last().pose(), pProjectionMatrix, shaderInstance);

                    VertexBuffer.unbind();
                    RenderSystem.enableBlend();

                    float[] sunriseColor = pLevel.effects().getSunriseColor(pLevel.getTimeOfDay(pPartialTick), pPartialTick);

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

                        var matrix4f = pPoseStack.last().pose();





                        bufferBuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
                        bufferBuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(red, green, blue, sunriseColor[3]).endVertex();

                        for (int i = 0; i <= 16; ++i) {
                            float f = i * (Mth.PI * 2F) / 16.0F;
                            float sin = Mth.sin(f);
                            float cos = Mth.cos(f);

                            bufferBuilder.vertex(matrix4f, sin * 120.0F, cos * 120.0F, -cos * 40.0F * sunriseColor[3]).color(sunriseColor[0], sunriseColor[1], sunriseColor[2], 0.0F).endVertex();
                        }

                        BufferUploader.drawWithShader(bufferBuilder.end());

                        pPoseStack.popPose();
                    }

                    RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

                    pPoseStack.pushPose();

                    var matrix4f = pPoseStack.last().pose();

                    float rainLevel = 1.0F - pLevel.getRainLevel(pPartialTick);

                    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, rainLevel);

                    pPoseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));

                    //EXTRA MOON
                    pPoseStack.pushPose();
                    var extraMatrix4f = pPoseStack.last().pose();

                    int moonPhase = pLevel.getMoonPhase();
                    int i = moonPhase % 4;
                    int j = moonPhase / 4 % 2;

                    float u1 = (i + 0) / 4.0F;
                    float v1 = (j + 0) / 2.0F;
                    float u0 = (i + 1) / 4.0F;
                    float v0 = (j + 1) / 2.0F;

                    RenderSystem.setShader(GameRenderer::getPositionTexShader);
                    RenderSystem.setShaderTexture(0, IcariaResourceLocations.MOON);


                    pPoseStack.mulPose(Axis.ZP.rotationDegrees(45));
                    pPoseStack.mulPose(Axis.XP.rotationDegrees(pLevel.getTimeOfDay(pPartialTick) * 360.0F * 2 + 45));

                    bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                    bufferBuilder.vertex(extraMatrix4f, -20.0F, -100.0F, 20.0F).uv(0.0F, 0.0F).endVertex();
                    bufferBuilder.vertex(extraMatrix4f, 20.0F, -100.0F, 20.0F).uv(0.25F, 0.0F).endVertex();
                    bufferBuilder.vertex(extraMatrix4f, 20.0F, -100.0F, -20.0F).uv(0.25F, 0.5F).endVertex();
                    bufferBuilder.vertex(extraMatrix4f, -20.0F, -100.0F, -20.0F).uv(0.0F, 0.5F).endVertex();

                    BufferUploader.drawWithShader(bufferBuilder.end());

                    pPoseStack.popPose();

                    pPoseStack.mulPose(Axis.XP.rotationDegrees(pLevel.getTimeOfDay(pPartialTick) * 360.0F));

                    //MAIN MOON
                    RenderSystem.setShaderTexture(0, IcariaResourceLocations.MOON);

                    bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                    bufferBuilder.vertex(matrix4f, -20.0F, -100.0F, 20.0F).uv(u0, v0).endVertex();
                    bufferBuilder.vertex(matrix4f, 20.0F, -100.0F, 20.0F).uv(u1, v0).endVertex();
                    bufferBuilder.vertex(matrix4f, 20.0F, -100.0F, -20.0F).uv(u1, v1).endVertex();
                    bufferBuilder.vertex(matrix4f, -20.0F, -100.0F, -20.0F).uv(u0, v1).endVertex();

                    BufferUploader.drawWithShader(bufferBuilder.end());

                    //SUN
                    RenderSystem.setShaderTexture(0, IcariaResourceLocations.SUN);

                    bufferBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                    bufferBuilder.vertex(matrix4f, -30.0F, 100.0F, -30.0F).uv(0.0F, 0.0F).endVertex();
                    bufferBuilder.vertex(matrix4f, 30.0F, 100.0F, -30.0F).uv(1.0F, 0.0F).endVertex();
                    bufferBuilder.vertex(matrix4f, 30.0F, 100.0F, 30.0F).uv(1.0F, 1.0F).endVertex();
                    bufferBuilder.vertex(matrix4f, -30.0F, 100.0F, 30.0F).uv(0.0F, 1.0F).endVertex();

                    BufferUploader.drawWithShader(bufferBuilder.end());

                    // STARS
                    float starBrightness = pLevel.getStarBrightness(pPartialTick) * rainLevel;

                    if (starBrightness > 0.0F) {
                        RenderSystem.setShaderColor(starBrightness, starBrightness, starBrightness, starBrightness);
                        FogRenderer.setupNoFog();

                        this.starBuffer.bind();
                        this.starBuffer.drawWithShader(pPoseStack.last().pose(), pProjectionMatrix, GameRenderer.getPositionShader());

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
                        this.darkBuffer.bind();
                        this.darkBuffer.drawWithShader(pPoseStack.last().pose(), pProjectionMatrix, shaderInstance);
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
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        if (this.darkBuffer != null) {
            this.darkBuffer.close();
        }

        this.darkBuffer = new VertexBuffer();
        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = this.buildSkyDisc(bufferbuilder, -16.0F);
        this.darkBuffer.bind();
        this.darkBuffer.upload(bufferbuilder$renderedbuffer);
        VertexBuffer.unbind();
    }

    public void createLightSky() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        if (this.skyBuffer != null) {
            this.skyBuffer.close();
        }

        this.skyBuffer = new VertexBuffer();
        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = this.buildSkyDisc(bufferbuilder, 16.0F);
        this.skyBuffer.bind();
        this.skyBuffer.upload(bufferbuilder$renderedbuffer);
        VertexBuffer.unbind();
    }

    public void createStars() {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        RenderSystem.setShader(GameRenderer::getPositionShader);
        if (this.starBuffer != null) {
            this.starBuffer.close();
        }

        this.starBuffer = new VertexBuffer();
        BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = this.drawStars(bufferbuilder);
        this.starBuffer.bind();
        this.starBuffer.upload(bufferbuilder$renderedbuffer);
        VertexBuffer.unbind();
    }

    public BufferBuilder.RenderedBuffer buildSkyDisc(BufferBuilder pBuilder, float pY) {
        float f = Math.signum(pY) * 512.0F;
        RenderSystem.setShader(GameRenderer::getPositionShader);
        pBuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
        pBuilder.vertex(0.0D, pY, 0.0D).endVertex();

        for(int i = -180; i <= 180; i += 45) {
            pBuilder.vertex(f * Mth.cos((float)i * ((float)Math.PI / 180F)), pY, 512.0F * Mth.sin((float)i * ((float)Math.PI / 180F))).endVertex();
        }

        return pBuilder.end();
    }

    public BufferBuilder.RenderedBuffer drawStars(BufferBuilder pBuilder) {
        RandomSource randomsource = RandomSource.create(10842L);
        pBuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);

        for(int i = 0; i < 1500; ++i) {
            double d0 = randomsource.nextFloat() * 2.0F - 1.0F;
            double d1 = randomsource.nextFloat() * 2.0F - 1.0F;
            double d2 = randomsource.nextFloat() * 2.0F - 1.0F;
            double d3 = 0.15F + randomsource.nextFloat() * 0.1F;
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
                double d14 = randomsource.nextDouble() * Math.PI * 2.0D;
                double d15 = Math.sin(d14);
                double d16 = Math.cos(d14);

                for(int j = 0; j < 4; ++j) {
                    double d18 = (double)((j & 2) - 1) * d3;
                    double d19 = (double)((j + 1 & 2) - 1) * d3;
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
    public Vec3 getBrightnessDependentFogColor(Vec3 p_108908_, float p_108909_) {
        return p_108908_.multiply(p_108909_ * 0.94F + 0.06F, p_108909_ * 0.94F + 0.06F, p_108909_ * 0.91F + 0.09F);
    }
}
