package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityArganHound;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderArganHound<T extends EntityArganHound> extends RenderLiving<T> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_argan_hound.png");

	public RenderArganHound(RenderManager manager) {
		super(manager, new ModelArganHound(), 0.5F);
	}

	protected ResourceLocation getEntityTexture(EntityArganHound entity) {
		return TEXTURE;
	}
}