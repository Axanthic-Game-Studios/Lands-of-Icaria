package com.axanthic.loi.render;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import com.axanthic.loi.entity.EntitySpellWisp;

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
public class RenderSpellWisp extends Render<EntitySpellWisp> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("null");

	public RenderSpellWisp(RenderManager renderManagerIn) {
		super(renderManagerIn);
	}

	public void doRender(EntitySpellWisp entity, double x, double y, double z, float entityYaw, float partialTicks) {
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

		float resolution = 1.0f;
		float length = 40.0f;
		float width = 0.2f;
		float fade = 1.0f;
		float speed = 1.5f;

		int r = 0;
		int g = 0;
		int b = 0;

		Color color2 = new Color(entity.spell.getColor());

		int ro = color2.getRed();
		int go = color2.getGreen();
		int bo = color2.getBlue();

		float ageInTicks = entity.ticksExisted + partialTicks;

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX, coreY + width, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX, coreY - width, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX + width, coreY, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		tessellator.draw();

		bufferbuilder.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);
		bufferbuilder.pos(getX(-fade, ageInTicks, speed), getY(-fade, ageInTicks, speed), getZ(-fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
		for (float i = 0.0F; i < length; i += resolution) {
			float coreX = getX(i, ageInTicks, speed);
			float coreY = getY(i, ageInTicks, speed);
			float coreZ = getZ(i, ageInTicks, speed);

			bufferbuilder.pos(coreX, coreY, coreZ).color(ro, go, bo, (int)(255 * (length - i) / length)).endVertex();
			bufferbuilder.pos(coreX - width, coreY, coreZ).color(r, g, b, 0).endVertex();
		}
		bufferbuilder.pos(getX(length - resolution + fade, ageInTicks, speed), getY(length - resolution + fade, ageInTicks, speed), getZ(length - resolution + fade, ageInTicks, speed)).color(r, g, b, 0).endVertex();
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

	protected ResourceLocation getEntityTexture(EntitySpellWisp entity) {
		return TEXTURE;
	}

	float getX(float i, float age, float speed) {
		return (float) Math.cos(i / 3.5F - speed * age / 2.0F) * i / 100.0F + (float) Math.cos(i / 2.0F - speed * age / 3.5F + 3) * i / 200.0F + (float) Math.sin(i / 7.5F - speed * age / 6.0F + 2) * i / 300.0F + (float) Math.sin(-speed * age / 5.0F + 2) * i / 300.0F;
	}

	float getY(float i, float age, float speed) {
		return (float) Math.sin(i / 2.5F - speed * age / 3.0F) * i / 100.0F + (float) Math.sin(i / 3.0F - speed * age / 2.5F + 2) * i / 200.0F + (float) Math.cos(i / 7.0F - speed * age / 6.5F + 3) * i / 300.0F + (float) Math.cos(-speed * age / 4.0F + 3) * i / 300.0F;
	}

	float getZ(float i, float age, float speed) {
		return i / 10.0F + (float) Math.cos(i / 4.0F - speed * age / 4.0F) * (float) Math.sin(i / 5.0F - speed * age / 2.0F) * i / 150.0F - (float) Math.sin(i / 6.0F - speed * age / 3.0F) * i / 100.0F;
	}
}