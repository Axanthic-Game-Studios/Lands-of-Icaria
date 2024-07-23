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
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSpecialEffects extends DimensionSpecialEffects {
	public VertexBuffer sky;
	public VertexBuffer stars;

	public IcariaSpecialEffects() {
		super(192, false, SkyType.NORMAL, false, false);
		this.createSky();
		this.createStars();
	}

	public boolean doesFogEffectBlockSky(Camera pCamera) {
		return pCamera.getFluidInCamera() == FogType.LAVA || pCamera.getFluidInCamera() == FogType.POWDER_SNOW;
	}

	public boolean doesMobEffectBlockSky(Camera pCamera) {
		return pCamera.getEntity() instanceof LivingEntity livingEntity && (livingEntity.hasEffect(MobEffects.BLINDNESS) || livingEntity.hasEffect(MobEffects.DARKNESS));
	}

	@Override
	public boolean isFoggyAt(int pX, int pY) {
		return false;
	}

	@Override
	public boolean renderSky(ClientLevel pLevel, int pTicks, float pPartialTick, Matrix4f modelViewMatrix, Camera pCamera, Matrix4f pProjectionMatrix, boolean pIsFoggy, Runnable pSetupFog) {
		pSetupFog.run();
		if (pIsFoggy || this.doesFogEffectBlockSky(pCamera) || this.doesMobEffectBlockSky(pCamera)) {
			return false;
		} else {
			var poseStack = new PoseStack();

			var tesselator = Tesselator.getInstance();
			var positionShader = GameRenderer.getPositionShader();
			var shader = RenderSystem.getShader();
			var vec3 = pLevel.getSkyColor(Minecraft.getInstance().gameRenderer.getMainCamera().getPosition(), pPartialTick);

			int moonPhase = pLevel.getMoonPhase();
			int i = moonPhase % 4;
			int j = moonPhase / 4 % 2;

			float u0 = (i + 1) / 4.0F;
			float u1 = i / 4.0F;
			float v0 = (j + 1) / 2.0F;
			float v1 = j / 2.0F;

			float starBrightness = pLevel.getStarBrightness(pPartialTick);

			float[] sunriseColor = pLevel.effects().getSunriseColor(pLevel.getTimeOfDay(pPartialTick), pPartialTick);

			FogRenderer.levelFogColor();

			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShaderColor((float) vec3.x, (float) vec3.y, (float) vec3.z, 1.0F);

			poseStack.mulPose(modelViewMatrix);

			if (shader != null) {
				this.sky.bind();
				this.sky.drawWithShader(poseStack.last().pose(), pProjectionMatrix, shader);
			}

			VertexBuffer.unbind();

			if (sunriseColor != null) {
				RenderSystem.setShader(GameRenderer::getPositionColorShader);
				RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

				poseStack.pushPose();
				poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
				poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.sin(pLevel.getSunAngle(pPartialTick)) < 0.0F ? 180.0F : 0.0F));
				poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));

				float red = sunriseColor[0];
				float green = sunriseColor[1];
				float blue = sunriseColor[2];
				float alpha = sunriseColor[3];

				var bufferBuilder = tesselator.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
				var matrix4f = poseStack.last().pose();

				bufferBuilder.addVertex(matrix4f, 0.0F, 100.0F, 0.0F).setColor(red, green, blue, alpha);

				for (int k = 0; k <= 16; ++k) {
					float f = k * (Mth.PI * 2.0F) / 16.0F;
					float sin = Mth.sin(f);
					float cos = Mth.cos(f);

					bufferBuilder.addVertex(matrix4f, sin * 120.0F, cos * 120.0F, -cos * 40.0F * alpha).setColor(red, green, blue, 0.0F);
				}

				BufferUploader.drawWithShader(bufferBuilder.buildOrThrow());

				poseStack.popPose();
			}

			poseStack.pushPose();
			poseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));

			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.setShader(GameRenderer::getPositionTexShader);

			poseStack.pushPose();
			poseStack.mulPose(Axis.ZP.rotationDegrees(45.0F));
			poseStack.mulPose(Axis.XP.rotationDegrees(pLevel.getTimeOfDay(pPartialTick) * 360.0F * 2.0F + 45.0F));

			var moonAddition = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
			var mainMatrix4f = poseStack.last().pose();

			RenderSystem.setShaderTexture(0, IcariaResourceLocations.MOON);

			moonAddition.addVertex(mainMatrix4f, -20.0F, -100.0F, 20.0F).setUv(0.0F, 0.0F);
			moonAddition.addVertex(mainMatrix4f, 20.0F, -100.0F, 20.0F).setUv(0.25F, 0.0F);
			moonAddition.addVertex(mainMatrix4f, 20.0F, -100.0F, -20.0F).setUv(0.25F, 0.5F);
			moonAddition.addVertex(mainMatrix4f, -20.0F, -100.0F, -20.0F).setUv(0.0F, 0.5F);

			BufferUploader.drawWithShader(moonAddition.buildOrThrow());

			poseStack.popPose();
			poseStack.mulPose(Axis.XP.rotationDegrees(pLevel.getTimeOfDay(pPartialTick) * 360.0F));

			var moonOriginal = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
			var xtraMatrix4f = poseStack.last().pose();

			RenderSystem.setShaderTexture(0, IcariaResourceLocations.MOON);

			moonOriginal.addVertex(xtraMatrix4f, -20.0F, -100.0F, 20.0F).setUv(u0, v0);
			moonOriginal.addVertex(xtraMatrix4f, 20.0F, -100.0F, 20.0F).setUv(u1, v0);
			moonOriginal.addVertex(xtraMatrix4f, 20.0F, -100.0F, -20.0F).setUv(u1, v1);
			moonOriginal.addVertex(xtraMatrix4f, -20.0F, -100.0F, -20.0F).setUv(u0, v1);

			BufferUploader.drawWithShader(moonOriginal.buildOrThrow());

			var bufferBuilder = tesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);

			RenderSystem.setShaderTexture(0, IcariaResourceLocations.SUN);

			bufferBuilder.addVertex(xtraMatrix4f, -30.0F, 100.0F, -30.0F).setUv(0.0F, 0.0F);
			bufferBuilder.addVertex(xtraMatrix4f, 30.0F, 100.0F, -30.0F).setUv(1.0F, 0.0F);
			bufferBuilder.addVertex(xtraMatrix4f, 30.0F, 100.0F, 30.0F).setUv(1.0F, 1.0F);
			bufferBuilder.addVertex(xtraMatrix4f, -30.0F, 100.0F, 30.0F).setUv(0.0F, 1.0F);

			BufferUploader.drawWithShader(bufferBuilder.buildOrThrow());

			if (starBrightness > 0.0F) {
				FogRenderer.setupNoFog();

				RenderSystem.setShaderColor(starBrightness, starBrightness, starBrightness, starBrightness);

				if (positionShader != null) {
					this.stars.bind();
					this.stars.drawWithShader(poseStack.last().pose(), pProjectionMatrix, positionShader);
				}

				VertexBuffer.unbind();

				pSetupFog.run();
			}

			RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.depthMask(true);

			poseStack.popPose();

			return true;
		}
	}

	public void createSky() {
		RenderSystem.setShader(GameRenderer::getPositionShader);

		if (this.sky != null) {
			this.sky.close();
		}

		this.sky = new VertexBuffer(VertexBuffer.Usage.STATIC);
		this.sky.bind();
		this.sky.upload(this.drawSky(Tesselator.getInstance()));

		VertexBuffer.unbind();
	}

	public void createStars() {
		RenderSystem.setShader(GameRenderer::getPositionShader);

		if (this.stars != null) {
			this.stars.close();
		}

		this.stars = new VertexBuffer(VertexBuffer.Usage.STATIC);
		this.stars.bind();
		this.stars.upload(this.drawStars(Tesselator.getInstance()));

		VertexBuffer.unbind();
	}

	public MeshData drawSky(Tesselator pTesselator) {
		var bufferBuilder = pTesselator.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
		bufferBuilder.addVertex(0.0F, 16.0F, 0.0F);

		for (int i = -180; i <= 180; i += 45) {
			bufferBuilder.addVertex((Math.signum(16.0F) * 512.0F) * Mth.cos((float) i * (float) (Math.PI / 180.0)), 16.0F, 512.0F * Mth.sin((float) i * (float) (Math.PI / 180.0)));
		}

		return bufferBuilder.buildOrThrow();
	}

	public MeshData drawStars(Tesselator pTesselator) {
		var bufferBuilder = pTesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
		var randomSource = RandomSource.create(10842L);

		for (int count = 0; count < 1500; count++) {
			float f = randomSource.nextFloat() * 2.0F - 1.0F;
			float g = randomSource.nextFloat() * 2.0F - 1.0F;
			float h = randomSource.nextFloat() * 2.0F - 1.0F;
			float i = randomSource.nextFloat() * 0.1F + 0.1F;
			float j = Mth.lengthSquared(f, g, h);
			if (j > 0.01F && j < 1.0F) {
				float k = randomSource.nextFloat() * Mth.PI * 2.0F;
				var vector3f = new Vector3f(f, g, h).normalize(100.0F);
				var quaternionf = new Quaternionf().rotateTo(new Vector3f(0.0F, 0.0F, -1.0F), vector3f).rotateZ(k);
				bufferBuilder.addVertex(vector3f.add(new Vector3f(i, -i, 0.0F).rotate(quaternionf)));
				bufferBuilder.addVertex(vector3f.add(new Vector3f(i, i, 0.0F).rotate(quaternionf)));
				bufferBuilder.addVertex(vector3f.add(new Vector3f(-i, i, 0.0F).rotate(quaternionf)));
				bufferBuilder.addVertex(vector3f.add(new Vector3f(-i, -i, 0.0F).rotate(quaternionf)));
			}
		}

		return bufferBuilder.buildOrThrow();
	}

	@Override
	public Vec3 getBrightnessDependentFogColor(Vec3 pFogColor, float pBrightness) {
		return pFogColor.multiply(pBrightness * 0.94F + 0.06F, pBrightness * 0.94F + 0.06F, pBrightness * 0.91F + 0.09F);
	}
}
