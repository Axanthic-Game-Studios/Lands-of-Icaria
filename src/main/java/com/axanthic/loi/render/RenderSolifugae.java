package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntitySolifugae;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

import javax.annotation.Nonnull;

public class RenderSolifugae extends RenderLiving<EntitySolifugae> {

	private ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_solifugae.png");
	public static final Factory FACTORY = new Factory();

	public RenderSolifugae(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelSolifugae(), 0.8F);
		this.addLayer(new LayerSolifugaeGlow(this));
	}

	@Override
	@Nonnull
	public ResourceLocation getEntityTexture(@Nonnull EntitySolifugae entity) {
		return TEXTURE;
	}

	//Solifugae is 5.2 cm
	@Override
	public void doRender(EntitySolifugae entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	
	protected void preRenderCallback(EntitySolifugae entitylivingbaseIn, float partialTickTime) {
		if (entitylivingbaseIn.isBesideClimbableBlock() && !entitylivingbaseIn.IsJumpingUp()) {
			GL11.glRotatef(90.0f, -1.0f, 0.0f, 0.0f);
			GlStateManager.translate(0, 0.65, 0);
		}
		GlStateManager.scale(0.6, 0.6, 0.6);
		GlStateManager.translate(0, -0.15, 0);
	}
	
    protected float getDeathMaxRotation(EntitySolifugae entityLivingBaseIn)
    {
        return 180.0F;
    }

	public static class Factory implements IRenderFactory<EntitySolifugae> {

		@Override
		public Render<? super EntitySolifugae> createRenderFor(RenderManager manager) {
			return new RenderSolifugae(manager);
		}

	}

}