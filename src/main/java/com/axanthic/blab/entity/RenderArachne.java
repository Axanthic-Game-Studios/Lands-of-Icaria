package com.axanthic.blab.entity;

import com.axanthic.blab.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArachne<T extends EntityArachne> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_arachne.png");

	public RenderArachne(RenderManager manager) {
		super(manager, new ModelArachne(), 1.0F);
		this.addLayer(new LayerArachneEyes(this));
	}

	protected ResourceLocation getEntityTexture(EntityArachne entity) {
		return TEXTURE;
	}
}