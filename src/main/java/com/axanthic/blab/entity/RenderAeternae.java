package com.axanthic.blab.entity;

import com.axanthic.blab.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAeternae extends RenderLiving<EntityAeternae> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_aeternae.png");

	public RenderAeternae(RenderManager manager) {
		super(manager, new ModelAeternae(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityAeternae entity) {
		return TEXTURE;
	}
}