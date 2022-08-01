package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class IcariaSkyRenderer extends IRenderHandler {

	private static final ResourceLocation MOON_PHASES_TEXTURES = new ResourceLocation("textures/environment/moon_phases.png");
	private static final ResourceLocation SUN_TEXTURES = new ResourceLocation("textures/environment/sun.png");
	private static final ResourceLocation EXTRA_MOON_TEXTURES = new ResourceLocation(ModInformation.ID, "textures/environment/moon.png");
	public static float fade = 60.0F;

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc) {
		GlStateManager.disableTexture2D();
		Vec3d vec3d = getSkyColorBody(mc.getRenderViewEntity(), world, partialTicks);
		float f = (float)vec3d.x;
		float f1 = (float)vec3d.y;
		float f2 = (float)vec3d.z;

		VertexBuffer skyVBO = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, "skyVBO", "field_175012_t");
		VertexBuffer sky2VBO = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, "sky2VBO", "field_175011_u");
		VertexBuffer starVBO = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, "starVBO", "field_175013_s");
		int glSkyList = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, "glSkyList", "field_72771_w");
		int glSkyList2 = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, "glSkyList2", "field_72781_x");
		int starGLCallList = ReflectionHelper.getPrivateValue(RenderGlobal.class, mc.renderGlobal, "starGLCallList", "field_72772_v");
		/*if (pass != 2)
		{
			float f3 = (f * 30.0F + f1 * 59.0F + f2 * 11.0F) / 100.0F;
			float f4 = (f * 30.0F + f1 * 70.0F) / 100.0F;
			float f5 = (f * 30.0F + f2 * 70.0F) / 100.0F;
			f = f3;
			f1 = f4;
			f2 = f5;
		}*/

		GlStateManager.color(f, f1, f2);
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		GlStateManager.depthMask(false);
		GlStateManager.enableFog();
		GlStateManager.color(f, f1, f2);

		if (OpenGlHelper.useVbo()) {
			skyVBO.bindBuffer();
			GlStateManager.glEnableClientState(32884);
			GlStateManager.glVertexPointer(3, 5126, 12, 0);
			skyVBO.drawArrays(7);
			skyVBO.unbindBuffer();
			GlStateManager.glDisableClientState(32884);
		} else {
			GlStateManager.callList(glSkyList);
		}

		GlStateManager.disableFog();
		GlStateManager.disableAlpha();
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderHelper.disableStandardItemLighting();
		float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);

		if (afloat != null) {
			GlStateManager.disableTexture2D();
			GlStateManager.shadeModel(7425);
			GlStateManager.pushMatrix();
			GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(MathHelper.sin(world.getCelestialAngleRadians(partialTicks)) < 0.0F ? 180.0F : 0.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
			float f6 = afloat[0];
			float f7 = afloat[1];
			float f8 = afloat[2];

			/*if (pass != 2) {
				float f9 = (f6 * 30.0F + f7 * 59.0F + f8 * 11.0F) / 100.0F;
				float f10 = (f6 * 30.0F + f7 * 70.0F) / 100.0F;
				float f11 = (f6 * 30.0F + f8 * 70.0F) / 100.0F;
				f6 = f9;
				f7 = f10;
				f8 = f11;
			}*/

			bufferbuilder.begin(6, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(0.0D, 100.0D, 0.0D).color(f6, f7, f8, afloat[3]).endVertex();
			int l1 = 16;

			for (int j2 = 0; j2 <= 16; ++j2) {
				float f21 = (float)j2 * ((float)Math.PI * 2F) / 16.0F;
				float f12 = MathHelper.sin(f21);
				float f13 = MathHelper.cos(f21);
				bufferbuilder.pos((double)(f12 * 120.0F), (double)(f13 * 120.0F), (double)(-f13 * 40.0F * afloat[3])).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
			}

			tessellator.draw();
			GlStateManager.popMatrix();
			GlStateManager.shadeModel(7424);
		}

		GlStateManager.enableTexture2D();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.pushMatrix();
		float f16 = 1.0F - world.getRainStrength(partialTicks);
		GlStateManager.color(1.0F, 1.0F, 1.0F, f16);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);

		//extra moon
		GlStateManager.pushMatrix();
		GlStateManager.rotate(45.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F * 2 + 45, 1.0F, 0.0F, 0.0F);
		float f17 = 20.0F;
		mc.renderEngine.bindTexture(EXTRA_MOON_TEXTURES);
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos((double)(-f17), -100.0D, (double)f17).tex(0.0D, 0.0D).endVertex();
		bufferbuilder.pos((double)f17, -100.0D, (double)f17).tex(1.0D, 0.0D).endVertex();
		bufferbuilder.pos((double)f17, -100.0D, (double)(-f17)).tex(1.0D, 1.0D).endVertex();
		bufferbuilder.pos((double)(-f17), -100.0D, (double)(-f17)).tex(0.0D, 1.0D).endVertex();
		tessellator.draw();
		GlStateManager.popMatrix();

		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);

		f17 = 30.0F;
		mc.renderEngine.bindTexture(SUN_TEXTURES);
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos((double)(-f17), 100.0D, (double)(-f17)).tex(0.0D, 0.0D).endVertex();
		bufferbuilder.pos((double)f17, 100.0D, (double)(-f17)).tex(1.0D, 0.0D).endVertex();
		bufferbuilder.pos((double)f17, 100.0D, (double)f17).tex(1.0D, 1.0D).endVertex();
		bufferbuilder.pos((double)(-f17), 100.0D, (double)f17).tex(0.0D, 1.0D).endVertex();
		tessellator.draw();

		f17 = 20.0F;
		mc.renderEngine.bindTexture(MOON_PHASES_TEXTURES);
		int k1 = world.getMoonPhase();
		int i2 = k1 % 4;
		int k2 = k1 / 4 % 2;
		float f22 = (float)(i2 + 0) / 4.0F;
		float f23 = (float)(k2 + 0) / 2.0F;
		float f24 = (float)(i2 + 1) / 4.0F;
		float f14 = (float)(k2 + 1) / 2.0F;
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos((double)(-f17), -100.0D, (double)f17).tex((double)f24, (double)f14).endVertex();
		bufferbuilder.pos((double)f17, -100.0D, (double)f17).tex((double)f22, (double)f14).endVertex();
		bufferbuilder.pos((double)f17, -100.0D, (double)(-f17)).tex((double)f22, (double)f23).endVertex();
		bufferbuilder.pos((double)(-f17), -100.0D, (double)(-f17)).tex((double)f24, (double)f23).endVertex();
		tessellator.draw();

		GlStateManager.disableTexture2D();
		float f15 = world.getStarBrightness(partialTicks) * f16;

		if (f15 > 0.0F) {
			GlStateManager.color(f15, f15, f15, f15);

			if (OpenGlHelper.useVbo()) {
				starVBO.bindBuffer();
				GlStateManager.glEnableClientState(32884);
				GlStateManager.glVertexPointer(3, 5126, 12, 0);
				starVBO.drawArrays(7);
				starVBO.unbindBuffer();
				GlStateManager.glDisableClientState(32884);
			} else {
				GlStateManager.callList(starGLCallList);
			}
		}

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableFog();
		GlStateManager.popMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F);
		double d3 = mc.player.getPositionEyes(partialTicks).y - world.getHorizon();

		/*if (d3 < 0.0D) {
			//float voidOpacity = (float) Math.max(0, (fade + d3) / fade);

			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 12.0F, 0.0F);

			if (OpenGlHelper.useVbo()) {
				sky2VBO.bindBuffer();
				GlStateManager.glEnableClientState(32884);
				GlStateManager.glVertexPointer(3, 5126, 12, 0);
				sky2VBO.drawArrays(7);
				sky2VBO.unbindBuffer();
				GlStateManager.glDisableClientState(32884);
			} else {
				GlStateManager.callList(glSkyList2);
			}

			GlStateManager.popMatrix();
			float f18 = 1.0F;
			float f19 = -((float)(d3 + 85.0D + fade));
			float f20 = -1.0F;
			bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
			bufferbuilder.pos(-1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, (double)f19, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, (double)f19, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(-1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, -1.0D, 1.0D).color(0, 0, 0, 255).endVertex();
			bufferbuilder.pos(1.0D, -1.0D, -1.0D).color(0, 0, 0, 255).endVertex();
			tessellator.draw();
		}*/

		if (world.provider.isSkyColored()) {
			GlStateManager.color(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F);
		} else {
			GlStateManager.color(f, f1, f2);
		}

		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -((float)(d3 - 16.0D)), 0.0F);
		GlStateManager.callList(glSkyList2);
		GlStateManager.popMatrix();
		GlStateManager.enableTexture2D();
		GlStateManager.depthMask(true);
	}

	public Vec3d getSkyColorBody(Entity entityIn, WorldClient world, float partialTicks) {
		float f = world.getCelestialAngle(partialTicks);
		float f1 = MathHelper.cos(f * ((float)Math.PI * 2F)) * 2.0F + 0.5F;
		f1 = MathHelper.clamp(f1, 0.0F, 1.0F);
		int i = MathHelper.floor(entityIn.posX);
		int j = MathHelper.floor(entityIn.posY);
		int k = MathHelper.floor(entityIn.posZ);
		BlockPos blockpos = new BlockPos(i, j, k);
		int l = net.minecraftforge.client.ForgeHooksClient.getSkyBlendColour(world, blockpos);
		float f3 = (float)(l >> 16 & 255) / 255.0F;
		float f4 = (float)(l >> 8 & 255) / 255.0F;
		float f5 = (float)(l & 255) / 255.0F;
		f3 = f3 * f1;
		f4 = f4 * f1;
		f5 = f5 * f1;

		float f10 = world.getThunderStrength(partialTicks);

		if (f10 > 0.0F) {
			float f11 = (f3 * 0.3F + f4 * 0.59F + f5 * 0.11F) * 0.2F;
			float f9 = 1.0F - f10 * 0.75F;
			f3 = f3 * f9 + f11 * (1.0F - f9);
			f4 = f4 * f9 + f11 * (1.0F - f9);
			f5 = f5 * f9 + f11 * (1.0F - f9);
		}

		if (world.getLastLightningBolt() > 0) {
			float f12 = (float)world.getLastLightningBolt() - partialTicks;

			if (f12 > 1.0F) {
				f12 = 1.0F;
			}
			f12 = f12 * 0.45F;
			f3 = f3 * (1.0F - f12) + 0.8F * f12;
			f4 = f4 * (1.0F - f12) + 0.8F * f12;
			f5 = f5 * (1.0F - f12) + 1.0F * f12;
		}

		float d3 = (float) (entityIn.getPositionEyes(partialTicks).y - world.getHorizon());
		if (d3 < 0.0D) {
			f3 = f3 * (Math.max(0, (fade + d3) / fade) * 0.6F + 0.4F);
			f4 = f4 * (Math.max(0, (fade + d3) / fade) * 0.6F + 0.4F);
			f5 = f5 * (Math.max(0, (fade + d3) / fade) * 0.6F + 0.4F);
		}

		return new Vec3d((double)f3, (double)f4, (double)f5);
	}
}
