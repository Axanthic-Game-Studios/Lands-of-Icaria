package com.axanthic.icaria.client.effects;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.registry.IcariaValues;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.phys.Vec3;

import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Vector3f;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensionSpecialEffects extends DimensionSpecialEffects {
	public VertexBuffer sky = VertexBuffer.uploadStatic(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION, this::buildSky);
	public VertexBuffer stars = VertexBuffer.uploadStatic(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION, this::buildStars);

	public IcariaDimensionSpecialEffects() {
		super(192, false, SkyType.OVERWORLD, false, false);
	}

	@Override
	public boolean isFoggyAt(int pX, int pY) {
		return false;
	}

	@Override
	public boolean isSunriseOrSunset(float pTimeOfDay) {
		var f = Mth.cos(pTimeOfDay * Mth.PI * 2.0F);
		return f >= -0.4F && f <= 0.4F;
	}

	@Override
	public boolean renderSky(ClientLevel pClientLevel, int pTicks, float pPartialTick, Matrix4f pMatrix4fModel, Camera pCamera, Matrix4f pMatrix4fProjection, Runnable pRunnable) {
		RenderStateShard.MAIN_TARGET.setupRenderState();

		pRunnable.run();

		var poseStack = new PoseStack();

		var buffer = Minecraft.getInstance().renderBuffers().bufferSource();

		var starBrightness = pClientLevel.getStarBrightness(pPartialTick);
		var sunAngle = pClientLevel.getSunAngle(pPartialTick);
		var timeOfDay = pClientLevel.getTimeOfDay(pPartialTick);

		var moonPhase = pClientLevel.getMoonPhase();
		var skyColor = pClientLevel.getSkyColor(pCamera.getPosition(), pPartialTick);
		var sunriseOrSunsetColor = pClientLevel.effects().getSunriseOrSunsetColor(timeOfDay);

		this.renderSky(ARGB.redFloat(skyColor), ARGB.greenFloat(skyColor), ARGB.blueFloat(skyColor));
		this.renderSunriseAndSunset(pClientLevel, buffer, poseStack, sunAngle, timeOfDay, sunriseOrSunsetColor);
		this.renderCelestialBodies(buffer, poseStack, starBrightness, timeOfDay, moonPhase);

		buffer.endBatch();

		return true;
	}

	@Override
	public int getSunriseOrSunsetColor(float pTimeOfDay) {
		var f = Mth.cos(pTimeOfDay * Mth.PI * 2.0F) / 0.8F + 0.5F;
		return ARGB.colorFromFloat(Mth.square(1.0F - (1.0F - Mth.sin(f * Mth.PI))), f * 0.3F + 0.7F, f * 0.7F + 0.1F, 0.1F);
	}

	public void buildSky(VertexConsumer pVertexConsumer) {
		pVertexConsumer.addVertex(0.0F, 16.0F, 0.0F);
		for (var i = -180; i <= 180; i += 45) {
			var x = Mth.cos(IcariaValues.DEG_2_RAD * i) * Math.signum(16.0F) * 512.0F;
			var z = Mth.sin(IcariaValues.DEG_2_RAD * i) * 512.0F;
			pVertexConsumer.addVertex(x, 16.0F, z);
		}
	}

	public void buildStars(VertexConsumer pVertexConsumer) {
		var randomSource = RandomSource.create(10842L);
		for (var count = 0; count < 1500; count++) {
			var f = randomSource.nextFloat() * 0.1F + 0.15F;
			var g = randomSource.nextFloat() * 2.0F - 1.0F;
			var h = randomSource.nextFloat() * 2.0F - 1.0F;
			var i = randomSource.nextFloat() * 2.0F - 1.0F;
			var j = randomSource.nextFloat() * 2.0F * Mth.PI;
			var k = Mth.lengthSquared(g, h, i);
			if (k > 0.01F && k < 1.0F) {
				var vector3f = new Vector3f(g, h, i).normalize(100.0F);
				var matrix3f = new Matrix3f().rotateTowards(new Vector3f(vector3f).negate(), new Vector3f(0.0F, 1.0F, 0.0F)).rotateZ(-j);
				pVertexConsumer.addVertex(new Vector3f(f, -f, 0.0F).mul(matrix3f).add(vector3f));
				pVertexConsumer.addVertex(new Vector3f(f, f, 0.0F).mul(matrix3f).add(vector3f));
				pVertexConsumer.addVertex(new Vector3f(-f, f, 0.0F).mul(matrix3f).add(vector3f));
				pVertexConsumer.addVertex(new Vector3f(-f, -f, 0.0F).mul(matrix3f).add(vector3f));
			}
		}
	}

	public void renderCelestialBodies(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, float pStarBrightness, float pTimeOfDay, int pMoonPhase) {
		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(360.0F * pTimeOfDay));

		this.renderSun(pMultiBufferSource, pPoseStack);
		this.renderMoon(pMultiBufferSource, pPoseStack, pMoonPhase);
		this.renderStars(pPoseStack, pStarBrightness);

		pPoseStack.popPose();
		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.XN.rotationDegrees(45.0F));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(45.0F + 720.0F * pTimeOfDay));

		this.renderMoon(pMultiBufferSource, pPoseStack, pMoonPhase);

		pPoseStack.popPose();
	}

	public void renderMoon(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, int pMoonPhase) {
		var i = pMoonPhase % 4;
		var j = pMoonPhase / 4 % 2;

		var u = (i + 1) / 4.0F;
		var v = i / 4.0F;
		var x = (j + 1) / 2.0F;
		var y = j / 2.0F;

		var matrix4f = pPoseStack.last().pose();
		var vertexConsumer = pMultiBufferSource.getBuffer(RenderType.celestial(IcariaResourceLocations.MOON));

		vertexConsumer.addVertex(matrix4f, -20.0F, -100.0F, 20.0F).setUv(u, x).setColor(1.0F, 1.0F, 1.0F, 1.0F);
		vertexConsumer.addVertex(matrix4f, 20.0F, -100.0F, 20.0F).setUv(v, x).setColor(1.0F, 1.0F, 1.0F, 1.0F);
		vertexConsumer.addVertex(matrix4f, 20.0F, -100.0F, -20.0F).setUv(v, y).setColor(1.0F, 1.0F, 1.0F, 1.0F);
		vertexConsumer.addVertex(matrix4f, -20.0F, -100.0F, -20.0F).setUv(u, y).setColor(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public void renderSky(float pRed, float pGreen, float pBlue) {
		RenderSystem.setShaderColor(pRed, pGreen, pBlue, 1.0F);

		this.sky.drawWithRenderType(RenderType.sky());

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public void renderStars(PoseStack pPoseStack, float pStarBrightness) {
		var matrix4f = pPoseStack.last().pose();
		var matrix4fStack = RenderSystem.getModelViewStack();

		matrix4fStack.pushMatrix();
		matrix4fStack.mul(matrix4f);

		RenderSystem.setShaderColor(pStarBrightness, pStarBrightness, pStarBrightness, pStarBrightness);

		this.stars.drawWithRenderType(RenderType.stars());

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

		matrix4fStack.popMatrix();
	}

	public void renderSun(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack) {
		var matrix4f = pPoseStack.last().pose();
		var vertexConsumer = pMultiBufferSource.getBuffer(RenderType.celestial(IcariaResourceLocations.SUN));

		vertexConsumer.addVertex(matrix4f, -30.0F, 100.0F, -30.0F).setUv(0.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F);
		vertexConsumer.addVertex(matrix4f, 30.0F, 100.0F, -30.0F).setUv(1.0F, 0.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F);
		vertexConsumer.addVertex(matrix4f, 30.0F, 100.0F, 30.0F).setUv(1.0F, 1.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F);
		vertexConsumer.addVertex(matrix4f, -30.0F, 100.0F, 30.0F).setUv(0.0F, 1.0F).setColor(1.0F, 1.0F, 1.0F, 1.0F);
	}

	public void renderSunriseAndSunset(ClientLevel pClientLevel, MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, float pSunAngle, float pTimeOfDay, int pSunriseOrSunsetColor) {
		if (pClientLevel.effects().isSunriseOrSunset(pTimeOfDay)) {
			this.renderSunriseAndSunset(pMultiBufferSource, pPoseStack, pSunAngle, pSunriseOrSunsetColor);
		}
	}

	public void renderSunriseAndSunset(MultiBufferSource pMultiBufferSource, PoseStack pPoseStack, float pSunAngle, int pSunriseOrSunsetColor) {
		var f = Mth.sin(pSunAngle) >= 0.0F ? 0.0F : 180.0F;
		var vertexConsumer = pMultiBufferSource.getBuffer(RenderType.sunriseSunset());

		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(90.0F + f));

		this.renderSunriseAndSunset(pPoseStack.last().pose(), vertexConsumer, pSunriseOrSunsetColor);

		pPoseStack.popPose();
	}

	public void renderSunriseAndSunset(Matrix4f pMatrix4f, VertexConsumer pVertexConsumer, int pSunriseOrSunsetColor) {
		pVertexConsumer.addVertex(pMatrix4f, 0.0F, 100.0F, 0.0F).setColor(pSunriseOrSunsetColor);
		for (var i = 0; i <= 16; i++) {
			var f = i * Mth.PI / 8.0F;
			var g = Mth.sin(f);
			var h = Mth.cos(f);
			pVertexConsumer.addVertex(pMatrix4f, g * 120.0F, h * 120.0F, -ARGB.alphaFloat(pSunriseOrSunsetColor) * h * 40.0F).setColor(ARGB.transparent(pSunriseOrSunsetColor));
		}
	}

	@Override
	public Vec3 getBrightnessDependentFogColor(Vec3 pVec3, float pBrightness) {
		return pVec3.multiply(pBrightness * 0.94F + 0.06F, pBrightness * 0.94F + 0.06F, pBrightness * 0.91F + 0.09F);
	}
}
