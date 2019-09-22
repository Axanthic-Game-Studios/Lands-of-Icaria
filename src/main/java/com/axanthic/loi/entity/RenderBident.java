package com.axanthic.loi.entity;

import javax.annotation.Nonnull;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBident extends Render<EntityBident> {

	public RenderBident(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(@Nonnull EntityBident bident, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
		GlStateManager.translate((float) x, (float) y, (float) z);
		GlStateManager.rotate((bident.prevRotationYaw + (bident.rotationYaw - bident.prevRotationYaw) * partialTicks) - 90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(-0.5F, 0.0F, 0.0F);
		GlStateManager.rotate((bident.prevRotationPitch + (bident.rotationPitch - bident.prevRotationPitch) * partialTicks) -45, 0.0F, 0.0F, 1.0F);
		GlStateManager.enableRescaleNormal();
		float f9 = (float) bident.arrowShake - partialTicks;

		if (f9 > 0.0F) {
			float f10 = -MathHelper.sin(f9 * 3.0F) * f9;
			GlStateManager.rotate(f10, 0.0F, 0.0F, 1.0F);
		}

		GlStateManager.scale(2.0F, 2.0F, 2.0F);

		if (this.renderOutlines) {
			GlStateManager.enableColorMaterial();
			GlStateManager.enableOutlineMode(this.getTeamColor(bident));
		}

		Minecraft.getMinecraft().getRenderItem().renderItem(bident.getArrowStack(), ItemCameraTransforms.TransformType.GROUND);

		if (this.renderOutlines) {
			GlStateManager.disableOutlineMode();
			GlStateManager.disableColorMaterial();
		}

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
		super.doRender(bident, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(@Nonnull EntityBident entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}
}
