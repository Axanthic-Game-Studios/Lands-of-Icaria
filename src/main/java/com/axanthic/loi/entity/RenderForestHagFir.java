package com.axanthic.loi.entity;

import com.axanthic.loi.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderForestHagFir extends RenderLiving<EntityForestHagFir> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_fir.png");

	public RenderForestHagFir(RenderManager manager) {
		super(manager, new ModelForestHagFir(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityForestHagFir entity) {
		return TEXTURE;
	}
}