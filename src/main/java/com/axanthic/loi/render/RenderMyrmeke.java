package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityMyrmeke;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMyrmeke<T extends EntityMyrmeke> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_myrmeke.png");

	public RenderMyrmeke(RenderManager manager) {
		super(manager, new ModelMyrmeke(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(EntityMyrmeke entity) {
		return TEXTURE;
	}
}