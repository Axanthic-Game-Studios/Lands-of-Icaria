package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityScorpion;
import com.axanthic.loi.entity.EntitySnull;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderSnull<T extends EntitySnull> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_snull.png");
	private static final float baseShadowSize = 0.14F;

	public RenderSnull(RenderManager manager) {
		super(manager, new ModelSnull(), baseShadowSize);
		this.addLayer(new LayerSnullGlow(this));
	}

	public void doRender(EntitySnull entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		this.shadowSize = baseShadowSize * entity.getSnullSize();
		super.doRender((T) entity, x, y, z, entityYaw, partialTicks);
	}

	protected void preRenderCallback(EntitySnull entitylivingbaseIn, float partialTickTime)
	{
		float initialsize = 0.25F;
		GlStateManager.scale(initialsize, initialsize, initialsize);
		float size = entitylivingbaseIn.getSnullSize();
		GlStateManager.scale(size, size, size);

		if (entitylivingbaseIn.isBesideClimbableBlock() && !entitylivingbaseIn.IsJumpingUp()) {
			GL11.glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
			GlStateManager.translate(0, 0.4, 0);
		}
	}

	protected ResourceLocation getEntityTexture(EntitySnull entity) {
		return TEXTURE;
	}

	protected float getDeathMaxRotation(EntityScorpion entityLivingBaseIn)
	{
		return 90.0F;
	}
}