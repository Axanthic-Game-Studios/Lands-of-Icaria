package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityVinegaroon;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;

public class RenderVinegaroon extends RenderLiving<EntityVinegaroon> {

	private ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_vinegaroon.png");
	public static final Factory FACTORY = new Factory();

	public RenderVinegaroon(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelVinegaroon(), 1.2F);
		this.addLayer(new LayerVinegaroonGlow(this));
	}

	@Override
	@Nonnull
	public ResourceLocation getEntityTexture(@Nonnull EntityVinegaroon entity) {
		return TEXTURE;
	}

	//Vinegaroon is 3 cm
	@Override
	public void doRender(EntityVinegaroon entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	
	protected void preRenderCallback(EntityVinegaroon entitylivingbaseIn, float partialTickTime) {
		if (entitylivingbaseIn.isBesideClimbableBlock() && !entitylivingbaseIn.IsJumpingUp()) {
			GL11.glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
			GlStateManager.translate(0, 0.95, 0);
		}
		GlStateManager.scale(1.1, 1.1, 1.1);
		GlStateManager.translate(0, -0.05, 0);
	}
	
    protected float getDeathMaxRotation(EntityVinegaroon entityLivingBaseIn)
    {
        return 180.0F;
    }

	public static class Factory implements IRenderFactory<EntityVinegaroon> {

		@Override
		public Render<? super EntityVinegaroon> createRenderFor(RenderManager manager) {
			return new RenderVinegaroon(manager);
		}

	}

}