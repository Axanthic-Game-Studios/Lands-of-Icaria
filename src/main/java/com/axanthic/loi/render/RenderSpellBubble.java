package com.axanthic.loi.render;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.axanthic.loi.entity.EntitySpellBubble;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpellBubble extends Render<EntitySpellBubble> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("null");

	public RenderSpellBubble(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	double n = -0.25;
	double p = 0.25;
	int brightness = 35;

	public void doRender(EntitySpellBubble entity, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float)x, (float)y + 0.25F, (float)z);
		GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * partialTicks - 180.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks, 1.0F, 0.0F, 0.0F);
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		GlStateManager.enableRescaleNormal();

		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(entity));
		}

		GlStateManager.disableCull();
		GlStateManager.shadeModel(7425);
		GlStateManager.depthMask(false);
		GlStateManager.disableAlpha();
		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE);//regular glow

		Random random = new Random(entity.getEntityId());

		float ageInTicks = entity.ticksExisted + partialTicks + random.nextInt(100);

		int r = random.nextInt(brightness);
		int g = random.nextInt(brightness);
		int b = random.nextInt(brightness);
		int r0 = random.nextInt(brightness);
		int g0 = random.nextInt(brightness);
		int b0 = random.nextInt(brightness);
		int r1 = random.nextInt(brightness);
		int g1 = random.nextInt(brightness);
		int b1 = random.nextInt(brightness);
		int r2 = random.nextInt(brightness);
		int g2 = random.nextInt(brightness);
		int b2 = random.nextInt(brightness);
		int r3 = random.nextInt(brightness);
		int g3 = random.nextInt(brightness);
		int b3 = random.nextInt(brightness);
		int r4 = random.nextInt(brightness);
		int g4 = random.nextInt(brightness);
		int b4 = random.nextInt(brightness);
		int r5 = random.nextInt(brightness);
		int g5 = random.nextInt(brightness);
		int b5 = random.nextInt(brightness);
		int r6 = random.nextInt(brightness);
		int g6 = random.nextInt(brightness);
		int b6 = random.nextInt(brightness);
		int r7 = random.nextInt(brightness);
		int g7 = random.nextInt(brightness);
		int b7 = random.nextInt(brightness);

		GlStateManager.rotate(random.nextFloat() * 360.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(random.nextFloat() * 360.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(random.nextFloat() * 360.0F + ageInTicks * 0.0000009F * random.nextInt(1000000), 0.0F, 0.0F, 1.0F);

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

		GlStateManager.disableBlend();
		GlStateManager.enableLighting();
		GlStateManager.enableAlpha();
		GlStateManager.enableTexture2D();
		GlStateManager.depthMask(true);
		GlStateManager.shadeModel(7424);
		GlStateManager.enableCull();

		if (this.renderOutlines) {
			GlStateManager.disableOutlineMode();
			GlStateManager.disableColorMaterial();
		}
		GlStateManager.popMatrix();
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	protected ResourceLocation getEntityTexture(EntitySpellBubble entity) {
		return TEXTURE;
	}
}