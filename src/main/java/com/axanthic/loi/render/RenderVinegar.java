package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityVinegar;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderVinegar extends Render<EntityVinegar> {

	public static ResourceLocation TEXTURE = new ResourceLocation(
			ModInformation.ID, "textures/entity/projectile_vinegar.png");
	public static final Factory FACTORY = new Factory();

	public RenderVinegar(final RenderManager renderManager) {
		super(renderManager);
	}

	public void doRender(EntityVinegar entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (!this.renderOutlines) {
			GlStateManager.pushMatrix();
			GlStateManager.translate((float) x, (float) y, (float) z);
			this.bindEntityTexture(entity);
			RenderHelper.enableStandardItemLighting();
			GlStateManager.translate(0.0F, -0.1F, 0.0F);
			GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate((float) (this.renderManager.options.thirdPersonView == 2 ? -1 : 1)
					* -this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
			GlStateManager.scale(0.7F, 0.7F, 0.7F);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder vertexbuffer = tessellator.getBuffer();
			vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
			vertexbuffer.pos(-0.5D, -0.25D, 0.0D).tex((double) 0, (double) 1).color(255, 255, 255, 255)
					.normal(0.0F, 1.0F, 0.0F).endVertex();
			vertexbuffer.pos(0.5D, -0.25D, 0.0D).tex((double) 1, (double) 1).color(255, 255, 255, 255)
					.normal(0.0F, 1.0F, 0.0F).endVertex();
			vertexbuffer.pos(0.5D, 0.75D, 0.0D).tex((double) 1, (double) 0).color(255, 255, 255, 255).normal(0.0F, 1.0F, 0.0F)
					.endVertex();
			vertexbuffer.pos(-0.5D, 0.75D, 0.0D).tex((double) 0, (double) 0).color(255, 255, 255, 255)
					.normal(0.0F, 1.0F, 0.0F).endVertex();
			tessellator.draw();
			GlStateManager.disableBlend();
			GlStateManager.disableRescaleNormal();
			GlStateManager.popMatrix();
			super.doRender(entity, x, y, z, entityYaw, partialTicks);
		}
	}

	protected ResourceLocation getEntityTexture(EntityVinegar entity) {
		return TEXTURE;
	}

	public static class Factory implements IRenderFactory<EntityVinegar> {

		@Override
		public Render<? super EntityVinegar> createRenderFor(RenderManager manager) {
			return new RenderVinegar(manager);
		}

	}
}