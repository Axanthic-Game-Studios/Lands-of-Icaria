package com.axanthic.loi.entity;

import java.awt.Color;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class ModelLight extends ModelBase {

	RenderManager renderManager;

	public ModelLight(RenderManager manager) {
		this.renderManager = manager;
	}


	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		Random random = new Random(entityIn.getEntityId());

		random.nextInt(40);//this increases the randomness for some reason
		random.nextInt(40);
		random.nextInt(40);
		
		if (random.nextInt(100) == 0)
			random = new Random();//chaotic

		int num = random.nextInt(4);

		if (num == 0)
			this.renderStandard(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, random);
		else if (num == 1)
			this.renderWisp(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, random);
		else if (num == 2)
			this.renderStar(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, random);
		else if (num == 3)
			this.renderCube(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, random);
	}

	public void renderWisp(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Random random) {

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();

		GlStateManager.shadeModel(7425);

		GlStateManager.depthMask(false);

		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, 0.75F, 0.0F);

		int u = 15728864;
		int j = u % 65536;
		int k = u / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);




		//GlStateManager.pushMatrix();
		//GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		//GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * -this.renderManager.playerViewX, 0.0F, 0.0F, 1.0F);


		float resolution = random.nextFloat() * 0.5f;//0.5f;
		float length = random.nextFloat() * 120.0f;//70.0f;
		float width = random.nextFloat() * 0.4f;//0.2f;
		float fade = 1.0f;
		float speed = random.nextFloat() * 2.5f;//1.5f;

		boolean rainbow = random.nextBoolean() && random.nextBoolean() && random.nextBoolean();
		float rainbowSpeed = (random.nextFloat() - 0.5f) * 0.05F;

		//Color color0 = Color.getHSBColor(-ageInTicks * 0.02F, 1F, 1F);

		int r = 0;//color0.getRed();
		int g = 0;//color0.getGreen();
		int b = 0;//color0.getBlue();


		//Color color2 = Color.getHSBColor(ageInTicks * 0.1F + 0.1F, 1F, 1F);

		int ro = random.nextInt(256);//255;//color2.getRed();
		int go = random.nextInt(256);//255;//color2.getGreen();
		int bo = random.nextInt(256);//255;//color2.getBlue();


		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			if (rainbow) {
				Color color2 = Color.getHSBColor(-ageInTicks * rainbowSpeed + i * 0.02F - 0.2F, 1F, 1F * (length - i) / length);
				ro = color2.getRed();
				go = color2.getGreen();
				bo = color2.getBlue();
			}

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX, coreY + width, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		/*r = color0.getRed();
		g = color0.getGreen();
		b = color0.getBlue();*/

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			if (rainbow) {
				Color color2 = Color.getHSBColor(-ageInTicks * rainbowSpeed + i * 0.02F - 0.2F, 1F, 1F * (length - i) / length);
				ro = color2.getRed();
				go = color2.getGreen();
				bo = color2.getBlue();
			}

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX, coreY - width, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		/*r = color0.getRed();
		g = color0.getGreen();
		b = color0.getBlue();*/

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			if (rainbow) {
				Color color2 = Color.getHSBColor(-ageInTicks * rainbowSpeed + i * 0.02F - 0.2F, 1F, 1F * (length - i) / length);
				ro = color2.getRed();
				go = color2.getGreen();
				bo = color2.getBlue();
			}

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX + width, coreY, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		/*r = color0.getRed();
		g = color0.getGreen();
		b = color0.getBlue();*/

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			if (rainbow) {
				Color color2 = Color.getHSBColor(-ageInTicks * rainbowSpeed + i * 0.02F - 0.2F, 1F, 1F * (length - i) / length);
				ro = color2.getRed();
				go = color2.getGreen();
				bo = color2.getBlue();
			}

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX - width, coreY, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		/*

		ageInTicks += 20;
		r = 255 - r;
		g = 255 - g;
		b = 255 - b;

		ro = 255 - ro;
		go = 255 - go;
		bo = 255 - bo;


		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX, coreY + width, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX, coreY - width, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX + width, coreY, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX - width, coreY, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();


		/*
		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX + width / 1.5F, coreY + width / 1.5F, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX - width / 1.5F, coreY + width / 1.5F, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX - width / 1.5F, coreY - width / 1.5F, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks), getY(-fade, ageInTicks), getZ(-fade, ageInTicks)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks);
			float coreY = getY(i, ageInTicks);
			float coreZ = getZ(i, ageInTicks);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX + width / 1.5F, coreY - width / 1.5F, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks), getY(length - resolution + fade, ageInTicks), getZ(length - resolution + fade, ageInTicks)).color(r, g, b, 0).endVertex();
		tessellator.draw();
		//*/


		//GlStateManager.popMatrix();

		GlStateManager.popMatrix();
		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableTexture2D();
		GlStateManager.depthMask(true);
		GlStateManager.shadeModel(7424);
	}

	float getX(float i, float age, float speed) {
		return (float) Math.cos(i / 3.0F - speed * age / 2.0F) * i / 100.0F + (float) Math.cos(i / 2.0F - speed * age / 3.0F + 3) * i / 200.0F + (float) Math.sin(i / 7.0F - speed * age / 6.0F + 2) * i / 300.0F + (float) Math.sin(-speed * age / 5.0F + 2) * i / 200.0F;
	}

	float getY(float i, float age, float speed) {
		return (float) Math.sin(i / 2.0F - speed * age / 3.0F) * i / 100.0F + (float) Math.sin(i / 3.0F - speed * age / 2.0F + 2) * i / 200.0F + (float) Math.cos(i / 7.0F - speed * age / 6.0F + 3) * i / 300.0F + (float) Math.cos(-speed * age / 4.0F + 3) * i / 200.0F;
	}

	float getZ(float i, float age, float speed) {
		return i / 10.0F + (float) Math.cos(i / 4.0F - speed * age / 4.0F) * i / 50.0F;
	}

	public void renderStar(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Random random) {

		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);

		int ro = 255;
		int go = 255;
		int bo = 255;

		double size = random.nextFloat() * 2.0;
		double corner = random.nextFloat() * 0.5;

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		RenderHelper.disableStandardItemLighting();
		float f = ageInTicks / 1000.0F;//((float)0.5F + ageInTicks) / 200.0F;
		float f1 = 0.03F;

		/*if (f > 0.8F)
		{
			f1 = (f - 0.8F) / 0.2F;
		}*/

		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(7425);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);//regular glow
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.ONE);//brightness increase
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//black glow
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//inverted colors
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);//transparency
		GlStateManager.disableAlpha();
		//GlStateManager.enableCull();
		GlStateManager.depthMask(false);
		GlStateManager.disableLighting();
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, 0.75F, 0.0F);


		int u = 15728864;
		int j = u % 65536;
		int k = u / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);

		for (int i = 0; i < 1/*(f + f * f) / 2.0F * 60.0F*/; ++i) {
			//GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//black glow
			//ro = random.nextInt(256);
			//go = random.nextInt(256);
			//bo = random.nextInt(256);
			//r = random.nextInt(256);
			//g = random.nextInt(256);
			//b = random.nextInt(256);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F + f * 90.0F * ((float) random.nextInt(100)), 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F + f * 90.0F * ((float) random.nextInt(100)), 0.0F, 0.0F, 1.0F);
			//float f2 = random.nextFloat() * rayLength + rayLength / 2 + f1 * 5.0F;
			//float f3 = random.nextFloat() * rayWidth + rayWidth / 2 + f1 * 1.0F;

			bufferbuilder.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(0, 0, 0).color(ro, go, bo, 255).endVertex();
			bufferbuilder.pos(size, 0, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(corner, corner, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, size, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(-corner, corner, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(-size, 0, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(-corner, -corner, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, -size, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(corner, -corner, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(size, 0, 0).color(r, g, b, 0).endVertex();
			tessellator.draw();

			bufferbuilder.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(0, 0, 0).color(ro, go, bo, 255).endVertex();
			bufferbuilder.pos(0, size, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, corner, corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, 0, size).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, -corner, corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, -size, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, -corner, -corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, 0, -size).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, corner, -corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, size, 0).color(r, g, b, 0).endVertex();
			tessellator.draw();

			bufferbuilder.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(0, 0, 0).color(ro, go, bo, 255).endVertex();
			bufferbuilder.pos(size, 0, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(corner, 0, corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, 0, size).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(-corner, 0, corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(-size, 0, 0).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(-corner, 0, -corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0, 0, -size).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(corner, 0, -corner).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(size, 0, 0).color(r, g, b, 0).endVertex();
			tessellator.draw();
		}

		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		GlStateManager.enableLighting();
		//GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.shadeModel(7424);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableTexture2D();
		GlStateManager.enableAlpha();
		RenderHelper.enableStandardItemLighting();
	}

	public void renderStandard(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Random random) {

		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);

		int ro = 255;
		int go = 255;
		int bo = 255;

		int rayAmount = random.nextInt(70);

		boolean rainbow = random.nextBoolean() && random.nextBoolean() && random.nextBoolean();

		Float rayWidth = random.nextFloat() * 1.5f;
		Float rayLength = random.nextFloat() * 1.5f;

		//Float rayWidth = 8.0F;
		//Float rayLength = 2.0F;//soft rays

		//Float rayWidth = 2.0F;
		//Float rayLength = 8.0F;//sharp rays

		GlStateManager.depthMask(true);

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		RenderHelper.disableStandardItemLighting();
		float f = ageInTicks / 100000000.0F;//((float)0.5F + ageInTicks) / 200.0F;
		float f1 = 0.03F;

		/*if (f > 0.8F)
		{
			f1 = (f - 0.8F) / 0.2F;
		}*/

		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(7425);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);//regular glow
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.ONE);//brightness increase
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//black glow
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//inverted colors
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);//transparency
		GlStateManager.disableAlpha();
		//GlStateManager.enableCull();
		GlStateManager.depthMask(false);
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, 0.75F, 0.0F);

		for (int i = 0; i < rayAmount/*(f + f * f) / 2.0F * 60.0F*/; ++i) {
			//GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//black glow
			if (rainbow) {
				ro = random.nextInt(256);
				go = random.nextInt(256);
				bo = random.nextInt(256);
				r = random.nextInt(256);
				g = random.nextInt(256);
				b = random.nextInt(256);
			}
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F + f * 90.0F * random.nextInt(500000), 0.0F, 0.0F, 1.0F);
			float f2 = random.nextFloat() * rayLength + rayLength / 2 + f1 * 5.0F;
			float f3 = random.nextFloat() * rayWidth + rayWidth / 2 + f1 * 1.0F;
			bufferbuilder.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(0.0D, 0.0D, 0.0D).color(ro, go, bo, 255).endVertex();
			bufferbuilder.pos(-0.866D * (double)f3, (double)f2, (double)(-0.5F * f3)).color(r, g, b, 0).endVertex();

			if (rainbow) {
				r = random.nextInt(256);
				g = random.nextInt(256);
				b = random.nextInt(256);
			}
			bufferbuilder.pos(0.866D * (double)f3, (double)f2, (double)(-0.5F * f3)).color(r, g, b, 0).endVertex();

			if (rainbow) {
				r = random.nextInt(256);
				g = random.nextInt(256);
				b = random.nextInt(256);
			}
			bufferbuilder.pos(0.0D, (double)f2, (double)(1.0F * f3)).color(r, g, b, 0).endVertex();

			if (rainbow) {
				r = random.nextInt(256);
				g = random.nextInt(256);
				b = random.nextInt(256);
			}
			bufferbuilder.pos(-0.866D * (double)f3, (double)f2, (double)(-0.5F * f3)).color(r, g, b, 0).endVertex();
			tessellator.draw();

			//GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.ONE);//inverted colors
			float f4 = random.nextFloat() * rayLength / 2 + rayLength / 4 + f1 * 5.0F;
			float f5 = random.nextFloat() * rayWidth / 2 + rayWidth / 4 + f1 * 1.0F;
			bufferbuilder.begin(6, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(0.0D, 0.0D, 0.0D).color(255, 255, 255, 10).endVertex();
			bufferbuilder.pos(-0.866D * (double)f5, (double)f4, (double)(-0.5F * f5)).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0.866D * (double)f5, (double)f4, (double)(-0.5F * f5)).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(0.0D, (double)f4, (double)(1.0F * f5)).color(r, g, b, 0).endVertex();
			bufferbuilder.pos(-0.866D * (double)f5, (double)f4, (double)(-0.5F * f5)).color(r, g, b, 0).endVertex();
			tessellator.draw();
		}

		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		//GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.shadeModel(7424);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableTexture2D();
		GlStateManager.enableAlpha();
		RenderHelper.enableStandardItemLighting();
	}

	public void renderCube(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Random random) {

		int r = random.nextInt(150);
		int g = random.nextInt(150);
		int b = random.nextInt(150);
		int r0 = r;
		int g0 = g;
		int b0 = b;
		int r1 = r;
		int g1 = g;
		int b1 = b;
		int r2 = r;
		int g2 = g;
		int b2 = b;
		int r3 = r;
		int g3 = g;
		int b3 = b;
		int r4 = r;
		int g4 = g;
		int b4 = b;
		int r5 = r;
		int g5 = g;
		int b5 = b;
		int r6 = r;
		int g6 = g;
		int b6 = b;
		int r7 = r;
		int g7 = g;
		int b7 = b;

		boolean rainbow = random.nextBoolean() && random.nextBoolean();

		int cubeAmount = random.nextInt(15);

		GlStateManager.depthMask(true);

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		RenderHelper.disableStandardItemLighting();
		float f = ageInTicks / 100000000.0F;//((float)0.5F + ageInTicks) / 200.0F;
		float f1 = 0.03F;

		/*if (f > 0.8F)
		{
			f1 = (f - 0.8F) / 0.2F;
		}*/

		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(7425);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);//regular glow
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.DST_COLOR, GlStateManager.DestFactor.ONE);//brightness increase
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//black glow
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE_MINUS_DST_COLOR, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//inverted colors
		//GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);//transparency
		GlStateManager.disableAlpha();
		//GlStateManager.enableCull();
		GlStateManager.depthMask(false);
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, 0.75F, 0.0F);

		for (int i = 0; i < cubeAmount/*(f + f * f) / 2.0F * 60.0F*/; ++i) {
			//GlStateManager.blendFunc(GlStateManager.SourceFactor.ZERO, GlStateManager.DestFactor.ONE_MINUS_SRC_COLOR);//black glow
			//ro = random.nextInt(256);
			//go = random.nextInt(256);
			//bo = random.nextInt(256);
			if (rainbow) {
				r0 = random.nextInt(25);
				g0 = random.nextInt(25);
				b0 = random.nextInt(25);
				r1 = random.nextInt(25);
				g1 = random.nextInt(25);
				b1 = random.nextInt(25);
				r2 = random.nextInt(25);
				g2 = random.nextInt(25);
				b2 = random.nextInt(25);
				r3 = random.nextInt(25);
				g3 = random.nextInt(25);
				b3 = random.nextInt(25);
				r4 = random.nextInt(25);
				g4 = random.nextInt(25);
				b4 = random.nextInt(25);
				r5 = random.nextInt(25);
				g5 = random.nextInt(25);
				b5 = random.nextInt(25);
				r6 = random.nextInt(25);
				g6 = random.nextInt(25);
				b6 = random.nextInt(25);
				r7 = random.nextInt(25);
				g7 = random.nextInt(25);
				b7 = random.nextInt(25);
			}
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(random.nextFloat() * 360.0F + f * 90.0F * random.nextInt(1000000), 0.0F, 0.0F, 1.0F);

			double n = -0.5 - ((double) i) / 15.0;
			double p = 0.5 + ((double) i) / 15.0;

			bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(n, n, p).color(r0, g0, b0, 255).endVertex();
			bufferbuilder.pos(n, p, p).color(r1, g1, b1, 255).endVertex();
			bufferbuilder.pos(n, p, n).color(r2, g2, b2, 255).endVertex();
			bufferbuilder.pos(n, n, n).color(r3, g3, b3, 255).endVertex();

			bufferbuilder.pos(n, n, n).color(r3, g3, b3, 255).endVertex();
			bufferbuilder.pos(n, p, n).color(r2, g2, b2, 255).endVertex();
			bufferbuilder.pos(p, p, n).color(r4, g4, b4, 255).endVertex();
			bufferbuilder.pos(p, n, n).color(r5, g5, b5, 255).endVertex();

			bufferbuilder.pos(p, n, n).color(r5, g5, b5, 255).endVertex();
			bufferbuilder.pos(p, p, n).color(r4, g4, b4, 255).endVertex();
			bufferbuilder.pos(p, p, p).color(r6, g6, b6, 255).endVertex();
			bufferbuilder.pos(p, n, p).color(r7, g7, b7, 255).endVertex();

			bufferbuilder.pos(p, n, p).color(r7, g7, b7, 255).endVertex();
			bufferbuilder.pos(p, p, p).color(r6, g6, b6, 255).endVertex();
			bufferbuilder.pos(n, p, p).color(r1, g1, b1, 255).endVertex();
			bufferbuilder.pos(n, n, p).color(r0, g0, b0, 255).endVertex();

			bufferbuilder.pos(p, p, p).color(r6, g6, b6, 255).endVertex();
			bufferbuilder.pos(p, p, n).color(r4, g4, b4, 255).endVertex();
			bufferbuilder.pos(n, p, n).color(r2, g2, b2, 255).endVertex();
			bufferbuilder.pos(n, p, p).color(r1, g1, b1, 255).endVertex();

			bufferbuilder.pos(n, n, n).color(r3, g3, b3, 255).endVertex();
			bufferbuilder.pos(p, n, n).color(r5, g5, b5, 255).endVertex();
			bufferbuilder.pos(p, n, p).color(r7, g7, b7, 255).endVertex();
			bufferbuilder.pos(n, n, p).color(r0, g0, b0, 255).endVertex();
			tessellator.draw();
		}

		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		//GlStateManager.disableCull();
		GlStateManager.disableBlend();
		GlStateManager.shadeModel(7424);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableTexture2D();
		GlStateManager.enableAlpha();
		RenderHelper.enableStandardItemLighting();
	}
}