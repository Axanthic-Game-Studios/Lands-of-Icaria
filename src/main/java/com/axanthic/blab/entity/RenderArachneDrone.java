package com.axanthic.blab.entity;

import com.axanthic.blab.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArachneDrone<T extends EntityArachneDrone> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_arachne_drone.png");

	public RenderArachneDrone(RenderManager manager) {
		super(manager, new ModelArachneDrone(), 0.5F);
		this.addLayer(new LayerArachneDroneEyes(this));
	}

	protected ResourceLocation getEntityTexture(EntityArachneDrone entity) {
		return TEXTURE;
	}
}