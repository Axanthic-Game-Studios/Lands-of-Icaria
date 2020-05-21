package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityForestHagCypress;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderForestHagCypress extends RenderLiving<EntityForestHagCypress> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_cypress.png");

	public RenderForestHagCypress(RenderManager manager) {
		super(manager, new ModelForestHagCypress(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityForestHagCypress entity) {
		return TEXTURE;
	}
}