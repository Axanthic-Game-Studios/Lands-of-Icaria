package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityArachneDrone;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerArachneDroneEyes<T extends EntityArachneDrone> implements LayerRenderer<T> {
	private static final ResourceLocation DRONE_EYES = new ResourceLocation(ModInformation.ID, "textures/entity/mob_arachne_drone_eyes.png");
	private final RenderArachneDrone<T> droneRenderer;

	public LayerArachneDroneEyes(RenderArachneDrone<T> spiderRendererIn) {
		this.droneRenderer = spiderRendererIn;
	}

	public void doRenderLayer(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.droneRenderer.bindTexture(DRONE_EYES);
		GlStateManager.enableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
		if (entitylivingbaseIn.isInvisible()) {
			GlStateManager.depthMask(false);
		} else {
			GlStateManager.depthMask(true);
		}
		int i = 61680;
		int j = i % 65536;
		int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
		this.droneRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
		i = entitylivingbaseIn.getBrightnessForRender();
		j = i % 65536;
		k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
		this.droneRenderer.setLightmap(entitylivingbaseIn);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
	}

	public boolean shouldCombineTextures() {
		return false;
	}
}