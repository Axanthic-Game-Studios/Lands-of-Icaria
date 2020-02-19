package com.axanthic.loi.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLight extends RenderLiving<EntityLight> {

	private static final ResourceLocation TEXTURE = new ResourceLocation("null");

	public RenderLight(RenderManager manager) {
		super(manager, new ModelLight(manager), 0.0F);
	}

	protected ResourceLocation getEntityTexture(EntityLight entity) {
		return TEXTURE;
	}
}