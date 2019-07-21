package com.axanthic.blab.entity;

import com.axanthic.blab.ModInformation;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderJellyfish<T extends EntityJellyfish> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_jellyfish.png");

	public RenderJellyfish(RenderManager manager) {
		super(manager, new ModelJellyfish(), 0.4F);
		this.addLayer(new LayerJellyfishGlow(this));
	}

	protected ResourceLocation getEntityTexture(EntityJellyfish entity) {
		return TEXTURE;
	}

    protected void applyRotations(EntityJellyfish entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
    {
        float f = entityLiving.prevJellyfishPitch + (entityLiving.jellyfishPitch - entityLiving.prevJellyfishPitch) * partialTicks;
        float f1 = entityLiving.prevJellyfishYaw + (entityLiving.jellyfishYaw - entityLiving.prevJellyfishYaw) * partialTicks;
        GlStateManager.translate(0.0F, 0.5F, 0.0F);
        GlStateManager.rotate(180.0F - rotationYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(f, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(f1, 0.0F, 1.0F, 0.0F);
        GlStateManager.translate(0.0F, -1.2F, 0.0F);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityJellyfish livingBase, float partialTicks)
    {
        return livingBase.lastTentacleAngle + (livingBase.tentacleAngle - livingBase.lastTentacleAngle) * partialTicks;
    }
}