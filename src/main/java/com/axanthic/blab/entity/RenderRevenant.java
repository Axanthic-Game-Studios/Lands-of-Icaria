package com.axanthic.blab.entity;

import com.axanthic.blab.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRevenant extends RenderLiving<EntityRevenant> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/revenant.png");

	public RenderRevenant(RenderManager manager) {
		super(manager, new ModelRevenant(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityRevenant entity) {
		return TEXTURE;
	}
}