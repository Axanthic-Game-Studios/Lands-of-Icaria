package com.axanthic.loi.entity;

import com.axanthic.loi.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCatoblepas extends RenderLiving<EntityCatoblepas> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_catoblepas.png");

	public RenderCatoblepas(RenderManager manager) {
		super(manager, new ModelCatoblepas(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityCatoblepas entity) {
		return TEXTURE;
	}
}