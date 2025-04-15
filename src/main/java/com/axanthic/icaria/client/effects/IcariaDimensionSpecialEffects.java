package com.axanthic.icaria.client.effects;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.registry.IcariaValues;

import com.mojang.blaze3d.buffers.BufferUsage;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.CoreShaders;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogParameters;
import net.minecraft.client.renderer.RenderStateShard;
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
	public VertexBuffer sky = this.createSky();
	public VertexBuffer stars = this.createStars();

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
		pRunnable.run();

		RenderStateShard.MAIN_TARGET.setupRenderState();

		var poseStack = new PoseStack();

		var tesselator = Tesselator.getInstance();

		var starBrightness = pClientLevel.getStarBrightness(pPartialTick);
		var sunAngle = pClientLevel.getSunAngle(pPartialTick);
		var timeOfDay = pClientLevel.getTimeOfDay(pPartialTick);

		var moonPhase = pClientLevel.getMoonPhase();
		var skyColor = pClientLevel.getSkyColor(pCamera.getPosition(), pPartialTick);
		var sunriseOrSunsetColor = pClientLevel.effects().getSunriseOrSunsetColor(timeOfDay);

		var red = ARGB.red(skyColor);
		var green = ARGB.green(skyColor);
		var blue = ARGB.blue(skyColor);

		this.renderSky(ARGB.from8BitChannel(red), ARGB.from8BitChannel(green), ARGB.from8BitChannel(blue));
		this.renderSunriseAndSunset(pClientLevel, poseStack, tesselator, sunAngle, timeOfDay, sunriseOrSunsetColor);
		this.renderCelestialBodies(poseStack, pRunnable, tesselator, starBrightness, timeOfDay, moonPhase);

		return true;
	}

	@Override
	public int getSunriseOrSunsetColor(float pTimeOfDay) {
		var f = Mth.cos(pTimeOfDay * Mth.PI * 2.0F) / 0.8F + 0.5F;
		return ARGB.colorFromFloat(Mth.square(1.0F - (1.0F - Mth.sin(f * Mth.PI))), f * 0.3F + 0.7F, f * 0.7F + 0.1F, 0.1F);
	}

	public void buildSky(BufferBuilder pBufferBuilder) {
		pBufferBuilder.addVertex(0.0F, 16.0F, 0.0F);
		for (var i = -180; i <= 180; i += 45) {
			var x = Mth.cos(IcariaValues.DEG_2_RAD * i) * Math.signum(16.0F) * 512.0F;
			var z = Mth.sin(IcariaValues.DEG_2_RAD * i) * 512.0F;
			pBufferBuilder.addVertex(x, 16.0F, z);
		}
	}

	public void buildStars(BufferBuilder pBufferBuilder) {
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
				pBufferBuilder.addVertex(new Vector3f(f, -f, 0.0F).mul(matrix3f).add(vector3f));
				pBufferBuilder.addVertex(new Vector3f(f, f, 0.0F).mul(matrix3f).add(vector3f));
				pBufferBuilder.addVertex(new Vector3f(-f, f, 0.0F).mul(matrix3f).add(vector3f));
				pBufferBuilder.addVertex(new Vector3f(-f, -f, 0.0F).mul(matrix3f).add(vector3f));
			}
		}
	}

	public void renderCelestialBodies(PoseStack pPoseStack, Runnable pRunnable, Tesselator pTesselator, float pStarBrightness, float pTimeOfDay, int pMoonPhase) {
		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(360.0F * pTimeOfDay));

		this.renderSun(pPoseStack, pTesselator);
		this.renderMoon(pPoseStack, pTesselator, pMoonPhase);
		this.renderStars(pPoseStack, pRunnable, pStarBrightness);

		pPoseStack.popPose();
		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.XN.rotationDegrees(45.0F));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(45.0F + 720.0F * pTimeOfDay));

		this.renderMoon(pPoseStack, pTesselator, pMoonPhase);

		pPoseStack.popPose();
	}

	public void renderMoon(PoseStack pPoseStack, Tesselator pTesselator, int pMoonPhase) {
		var i = pMoonPhase % 4;
		var j = pMoonPhase / 4 % 2;

		var u = (i + 1) / 4.0F;
		var v = i / 4.0F;
		var x = (j + 1) / 2.0F;
		var y = j / 2.0F;

		var bufferBuilder = pTesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		var matrix4f = pPoseStack.last().pose();

		RenderSystem.depthMask(false);
		RenderSystem.overlayBlendFunc();
		RenderSystem.setShader(CoreShaders.POSITION_TEX);
		RenderSystem.setShaderTexture(0, IcariaResourceLocations.MOON);
		RenderSystem.enableBlend();

		bufferBuilder.addVertex(matrix4f, -20.0F, -100.0F, 20.0F).setUv(u, x);
		bufferBuilder.addVertex(matrix4f, 20.0F, -100.0F, 20.0F).setUv(v, x);
		bufferBuilder.addVertex(matrix4f, 20.0F, -100.0F, -20.0F).setUv(v, y);
		bufferBuilder.addVertex(matrix4f, -20.0F, -100.0F, -20.0F).setUv(u, y);

		BufferUploader.drawWithShader(bufferBuilder.buildOrThrow());

		RenderSystem.disableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.depthMask(true);
	}

	public void renderSky(float pRed, float pGreen, float pBlue) {
		RenderSystem.depthMask(false);
		RenderSystem.setShader(CoreShaders.POSITION);
		RenderSystem.setShaderColor(pRed, pGreen, pBlue, 1.0F);

		this.sky.bind();
		this.sky.drawWithShader(RenderSystem.getModelViewMatrix(), RenderSystem.getProjectionMatrix(), RenderSystem.getShader());

		VertexBuffer.unbind();

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.depthMask(true);
	}

	public void renderStars(PoseStack pPoseStack, Runnable pRunnable, float pStarBrightness) {
		var matrix4fStack = RenderSystem.getModelViewStack();

		matrix4fStack.pushMatrix();
		matrix4fStack.mul(pPoseStack.last().pose());

		RenderSystem.depthMask(false);
		RenderSystem.overlayBlendFunc();
		RenderSystem.setShader(CoreShaders.POSITION);
		RenderSystem.setShaderColor(pStarBrightness, pStarBrightness, pStarBrightness, pStarBrightness);
		RenderSystem.enableBlend();
		RenderSystem.setShaderFog(FogParameters.NO_FOG);

		this.stars.bind();
		this.stars.drawWithShader(matrix4fStack, RenderSystem.getProjectionMatrix(), RenderSystem.getShader());

		VertexBuffer.unbind();

		pRunnable.run();

		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		RenderSystem.disableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.depthMask(true);

		matrix4fStack.popMatrix();
	}

	public void renderSun(PoseStack pPoseStack, Tesselator pTesselator) {
		var bufferBuilder = pTesselator.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
		var matrix4f = pPoseStack.last().pose();

		RenderSystem.depthMask(false);
		RenderSystem.overlayBlendFunc();
		RenderSystem.setShader(CoreShaders.POSITION_TEX);
		RenderSystem.setShaderTexture(0, IcariaResourceLocations.SUN);
		RenderSystem.enableBlend();

		bufferBuilder.addVertex(matrix4f, -30.0F, 100.0F, -30.0F).setUv(0.0F, 0.0F);
		bufferBuilder.addVertex(matrix4f, 30.0F, 100.0F, -30.0F).setUv(1.0F, 0.0F);
		bufferBuilder.addVertex(matrix4f, 30.0F, 100.0F, 30.0F).setUv(1.0F, 1.0F);
		bufferBuilder.addVertex(matrix4f, -30.0F, 100.0F, 30.0F).setUv(0.0F, 1.0F);

		BufferUploader.drawWithShader(bufferBuilder.buildOrThrow());

		RenderSystem.disableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.depthMask(true);
	}

	public void renderSunriseAndSunset(ClientLevel pClientLevel, PoseStack pPoseStack, Tesselator pTesselator, float pSunAngle, float pTimeOfDay, int pSunriseOrSunsetColor) {
		if (pClientLevel.effects().isSunriseOrSunset(pTimeOfDay)) {
			this.renderSunriseAndSunset(pPoseStack, pTesselator, pSunAngle, pSunriseOrSunsetColor);
		}
	}

	public void renderSunriseAndSunset(PoseStack pPoseStack, Tesselator pTesselator, float pSunAngle, int pSunriseOrSunsetColor) {
		var f = Mth.sin(pSunAngle) >= 0.0F ? 0.0F : 180.0F;

		var bufferBuilder = pTesselator.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);

		RenderSystem.setShader(CoreShaders.POSITION_COLOR);
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();

		pPoseStack.pushPose();
		pPoseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
		pPoseStack.mulPose(Axis.ZP.rotationDegrees(90.0F + f));

		this.renderSunriseAndSunset(bufferBuilder, pPoseStack, pSunriseOrSunsetColor);

		BufferUploader.drawWithShader(bufferBuilder.buildOrThrow());

		pPoseStack.popPose();

		RenderSystem.disableBlend();
		RenderSystem.depthMask(true);
	}

	public void renderSunriseAndSunset(BufferBuilder pBufferBuilder, PoseStack pPoseStack, int pSunriseOrSunsetColor) {
		var alpha = ARGB.alpha(pSunriseOrSunsetColor);
		var matrix4f = pPoseStack.last().pose();
		pBufferBuilder.addVertex(matrix4f, 0.0F, 100.0F, 0.0F).setColor(pSunriseOrSunsetColor);
		for (var i = 0; i <= 16; i++) {
			var f = i * Mth.PI / 8.0F;
			var g = Mth.sin(f);
			var h = Mth.cos(f);
			pBufferBuilder.addVertex(matrix4f, g * 120.0F, h * 120.0F, -ARGB.from8BitChannel(alpha) * h * 40.0F).setColor(ARGB.transparent(pSunriseOrSunsetColor));
		}
	}

	public MeshData buildSky() {
		var bufferBuilder = Tesselator.getInstance().begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION);
		this.buildSky(bufferBuilder);
		return bufferBuilder.buildOrThrow();
	}

	public MeshData buildStars() {
		var bufferBuilder = Tesselator.getInstance().begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION);
		this.buildStars(bufferBuilder);
		return bufferBuilder.buildOrThrow();
	}

	@Override
	public Vec3 getBrightnessDependentFogColor(Vec3 pVec3, float pBrightness) {
		return pVec3.multiply(pBrightness * 0.94F + 0.06F, pBrightness * 0.94F + 0.06F, pBrightness * 0.91F + 0.09F);
	}

	public VertexBuffer createSky() {
		var vertexBuffer = new VertexBuffer(BufferUsage.STATIC_WRITE);
		vertexBuffer.bind();
		vertexBuffer.upload(this.buildSky());
		VertexBuffer.unbind();
		return vertexBuffer;
	}

	public VertexBuffer createStars() {
		var vertexBuffer = new VertexBuffer(BufferUsage.STATIC_WRITE);
		vertexBuffer.bind();
		vertexBuffer.upload(this.buildStars());
		VertexBuffer.unbind();
		return vertexBuffer;
	}
}
