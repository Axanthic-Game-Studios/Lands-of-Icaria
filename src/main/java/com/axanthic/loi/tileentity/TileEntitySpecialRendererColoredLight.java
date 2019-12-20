package com.axanthic.loi.tileentity;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.math.Vec3d;

public class TileEntitySpecialRendererColoredLight extends TileEntitySpecialRenderer<TileEntityColoredLight> {

	private static final Tessellator tessellator = Tessellator.getInstance();
	private static final BufferBuilder bufferbuilder = tessellator.getBuffer();

	@Override
	public void setRendererDispatcher(TileEntityRendererDispatcher rendererDispatcherIn) {
		super.setRendererDispatcher(rendererDispatcherIn);
	}

	@Override
	public void render(TileEntityColoredLight tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress, float alpha) {
		Random random = new Random(tileEntity.getPos().toLong());
		Float div = 5.0F;
		Float r = tileEntity.r/div;
		Float g = tileEntity.g/div;
		Float b = tileEntity.b/div;

		RenderManager manager = Minecraft.getMinecraft().getRenderManager();
		Float dist = (float) tileEntity.getPos().distanceSq(manager.viewerPosX, manager.viewerPosY, manager.viewerPosZ);
		Float fade = Math.max((4036F-dist)/4036F, 0F);

		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		GlStateManager.depthMask(false);
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);

		int u = 15728864;
		int j = u % 65536;
		int k = u / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);

		GlStateManager.pushMatrix();

		/*float t = 0.0F;
		float t1 = 1.0F;
		float t2 = 0.0F;
		float t3 = 1.0F;*/

		GlStateManager.translate(relativeX + 0.5, relativeY + 0.5, relativeZ + 0.5);

		//player facing light
		/*this.bindTexture(new ResourceLocation(ModInformation.ID, "textures/effect/light.png"));
		GlStateManager.pushMatrix();
		GlStateManager.translate(tileEntity.offset.getFrontOffsetX() * -0.3, tileEntity.offset.getFrontOffsetY() * -0.3, tileEntity.offset.getFrontOffsetZ() * -0.3);
		GlStateManager.rotate(180.0F - Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate((float)(Minecraft.getMinecraft().getRenderManager().options.thirdPersonView == 2 ? -1 : 1) * -Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
		bufferbuilder.pos(-1.0D, -1.0D, 0.0D).tex((double)t1, (double)t2).normal(0.0F, 1.0F, 0.0F).endVertex();
		bufferbuilder.pos(1.0D, -1.0D, 0.0D).tex((double)t, (double)t2).normal(0.0F, 1.0F, 0.0F).endVertex();
		bufferbuilder.pos(1.0D, 1.0D, 0.0D).tex((double)t, (double)t3).normal(0.0F, 1.0F, 0.0F).endVertex();
		bufferbuilder.pos(-1.0D, 1.0D, 0.0D).tex((double)t1, (double)t3).normal(0.0F, 1.0F, 0.0F).endVertex();
		tessellator.draw();
		GlStateManager.popMatrix();*/

		//floor light
		/*this.bindTexture(new ResourceLocation(ModInformation.ID, "textures/effect/light.png"));
		GlStateManager.translate(tileEntity.offset.getFrontOffsetX() * -0.499, tileEntity.offset.getFrontOffsetY() * -0.499, tileEntity.offset.getFrontOffsetZ() * -0.499);
		GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(90.0F, tileEntity.offset.getFrontOffsetX(), tileEntity.offset.getFrontOffsetY(), tileEntity.offset.getFrontOffsetZ());
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
		bufferbuilder.pos(-1.0D, -1.0D, 0.0D).tex((double)t1, (double)t2).normal(0.0F, 1.0F, 0.0F).endVertex();
		bufferbuilder.pos(1.0D, -1.0D, 0.0D).tex((double)t, (double)t2).normal(0.0F, 1.0F, 0.0F).endVertex();
		bufferbuilder.pos(1.0D, 1.0D, 0.0D).tex((double)t, (double)t3).normal(0.0F, 1.0F, 0.0F).endVertex();
		bufferbuilder.pos(-1.0D, 1.0D, 0.0D).tex((double)t1, (double)t3).normal(0.0F, 1.0F, 0.0F).endVertex();
		tessellator.draw();*/

		//star shaped light
		GlStateManager.disableCull();
		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(7425);
		if (tileEntity.offset != null)
			GlStateManager.translate(tileEntity.offset.getFrontOffsetX() * -0.3, tileEntity.offset.getFrontOffsetY() * -0.3, tileEntity.offset.getFrontOffsetZ() * -0.3);

		Float rayWidth = 2.5F;
		Float rayLength = 0.8F;

		bufferbuilder.begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(0.0D, 0.0D, 0.0D).color(r, g, b, fade).endVertex();
		/*for (int i = 0; i < 25; ++i) {//scattered cones (but not really, the cones are all weirdly distorted because I did something wrong)
			float f2 = random.nextFloat() * rayLength + rayLength / 2 + 0.03F * 5.0F;
			float f3 = random.nextFloat() * rayWidth + rayWidth / 2 + 0.03F * 1.0F;

			Vec3d[] positions = new Vec3d[]{
					new Vec3d(-0.866D * (double)f3, (double)f2, (double)(-0.5F * f3)),
					new Vec3d(0.866D * (double)f3, (double)f2, (double)(-0.5F * f3)),
					new Vec3d(0.0D, (double)f2, (double)(1.0F * f3))
			};
			for (int p = 0; p < positions.length; ++p) {
				positions[p] = positions[p].rotatePitch(random.nextFloat() * 360.0F).rotateYaw(random.nextFloat() * 360.0F);
			}
			bufferbuilder.pos(0.0D, 0.0D, 0.0D).color(r, g, b, fade).endVertex();
			bufferbuilder.pos(positions[0].x, positions[0].y, positions[0].z).color(0, 0, 0, 0).endVertex();
			bufferbuilder.pos(positions[1].x, positions[1].y, positions[1].z).color(0, 0, 0, 0).endVertex();
			bufferbuilder.pos(positions[2].x, positions[2].y, positions[2].z).color(0, 0, 0, 0).endVertex();
			bufferbuilder.pos(positions[0].x, positions[0].y, positions[0].z).color(0, 0, 0, 0).endVertex();
		}*/
		for (int i = 0; i < 75; ++i) {//triangle spaghetti
			float f2 = random.nextFloat() * rayLength + rayLength / 2F + 0.15F;
			float f3 = random.nextFloat() * rayWidth + rayWidth / 2F + 0.03F;
			Vec3d position = new Vec3d(0.0D, (double)f2, (double)f3).rotatePitch(random.nextFloat() * 360.0F).rotateYaw(random.nextFloat() * 360.0F);
			bufferbuilder.pos(position.x, position.y, position.z).color(0, 0, 0, 0).endVertex();
		}
		tessellator.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.shadeModel(7424);
		GlStateManager.enableCull();

		GlStateManager.popMatrix();
		GlStateManager.depthMask(true);
		GlStateManager.enableLighting();
		GlStateManager.disableBlend();
	}

	@Override
	public boolean isGlobalRenderer(TileEntityColoredLight tileEntity) {
		return false;
	}
}