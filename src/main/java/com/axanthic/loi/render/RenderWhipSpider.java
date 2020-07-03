package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityWhipSpider;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;

public class RenderWhipSpider extends RenderLiving<EntityWhipSpider> {

	private ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_scorpion.png");
	public static final Factory FACTORY = new Factory();

	public RenderWhipSpider(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelScorpion(), 2.8F);
	}

	@Override
	@Nonnull
	public ResourceLocation getEntityTexture(@Nonnull EntityWhipSpider entity) {
		return TEXTURE;
	}

	// Scorpion is 6.3 cm
	@Override
	public void doRender(EntityWhipSpider entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	protected void preRenderCallback(EntityWhipSpider entitylivingbaseIn, float partialTickTime) {
		if (entitylivingbaseIn.isBesideClimbableBlock() && !entitylivingbaseIn.IsJumpingUp()) {
			GL11.glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
			GlStateManager.translate(0, 0.7, 0);
		}
		GlStateManager.translate(0, -0.05, 0);
	}
	
    protected float getDeathMaxRotation(EntityWhipSpider entityLivingBaseIn)
    {
        return 180.0F;
    }

	public static class Factory implements IRenderFactory<EntityWhipSpider> {

		@Override
		public Render<? super EntityWhipSpider> createRenderFor(RenderManager manager) {
			return new RenderWhipSpider(manager);
		}

	}

}