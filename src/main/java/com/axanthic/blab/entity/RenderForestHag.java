package com.axanthic.blab.entity;

import com.axanthic.blab.ModInformation;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderForestHag extends RenderLiving<EntityForestHag> {

	private static final ResourceLocation TEXTURE_PLANE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_plane.png");
	private static final ResourceLocation TEXTURE_POPULUS = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_populus.png");
	private static final ResourceLocation TEXTURE_CYPRESS = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_cypress.png");
	private static final ResourceLocation TEXTURE_FIR = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_fir.png");
	private static final ResourceLocation TEXTURE_OLIVE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_olive.png");
	private static final ResourceLocation TEXTURE_LAUREL = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_laurel.png");
	private static final ResourceLocation TEXTURE_DROUGHTROOT = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_droughtroot.png");

	public RenderForestHag(RenderManager manager) {
		super(manager, new ModelForestHag(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityForestHag entity) {
		if (entity.getType() == 0)
			return TEXTURE_PLANE;
		if (entity.getType() == 1)
			return TEXTURE_POPULUS;
		if (entity.getType() == 2)
			return TEXTURE_CYPRESS;
		if (entity.getType() == 3)
			return TEXTURE_FIR;
		if (entity.getType() == 4)
			return TEXTURE_OLIVE;
		if (entity.getType() == 5)
			return TEXTURE_LAUREL;
		if (entity.getType() == 6)
			return TEXTURE_DROUGHTROOT;
		return TEXTURE_PLANE;
	}
}