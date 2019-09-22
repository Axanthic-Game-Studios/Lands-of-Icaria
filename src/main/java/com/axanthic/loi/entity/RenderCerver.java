package com.axanthic.loi.entity;

import com.axanthic.loi.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCerver<T extends EntityCerver> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_cerver.png");

	public RenderCerver(RenderManager manager) {
		super(manager, new ModelCerver(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(EntityCerver entity) {
		return TEXTURE;
	}
}