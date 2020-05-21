package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityForestHagDroughtroot;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderForestHagDroughtroot extends RenderLiving<EntityForestHagDroughtroot> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_droughtroot.png");

	public RenderForestHagDroughtroot(RenderManager manager) {
		super(manager, new ModelForestHagDroughtroot(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityForestHagDroughtroot entity) {
		return TEXTURE;
	}
}