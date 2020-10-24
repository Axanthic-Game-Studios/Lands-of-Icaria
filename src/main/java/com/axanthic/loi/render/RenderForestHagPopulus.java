package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityForestHagPopulus;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderForestHagPopulus extends RenderLiving<EntityForestHagPopulus> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_foresthag_populus.png");

	public RenderForestHagPopulus(RenderManager manager) {
		super(manager, new ModelForestHagPopulus(), 0.7F);
	}

	protected ResourceLocation getEntityTexture(EntityForestHagPopulus entity) {
		return TEXTURE;
	}
}