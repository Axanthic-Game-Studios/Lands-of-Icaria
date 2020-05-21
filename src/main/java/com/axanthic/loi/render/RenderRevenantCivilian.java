package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityRevenant;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRevenantCivilian extends RenderLiving<EntityRevenant> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_revenant_civilian.png");

	public RenderRevenantCivilian(RenderManager manager) {
		super(manager, new ModelRevenantCivilian(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityRevenant entity) {
		return TEXTURE;
	}
}