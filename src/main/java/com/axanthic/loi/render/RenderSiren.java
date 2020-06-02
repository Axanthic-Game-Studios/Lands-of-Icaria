package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntitySiren;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSiren<T extends EntitySiren> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_siren.png");

	public RenderSiren(RenderManager manager) {
		super(manager, new ModelSiren(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(EntitySiren entity) {
		return TEXTURE;
	}
}