package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityRevenantOvergrown;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerRevenantCrystals<T extends EntityRevenantOvergrown> implements LayerRenderer<T> {
	private static final ResourceLocation CRYSTAL = new ResourceLocation(ModInformation.ID, "textures/entity/mob_revenant_overgrown_crystal.png");
	private final RenderRevenantOvergrown revenantRenderer;

	public LayerRevenantCrystals(RenderRevenantOvergrown revenantRendererIn) {
		this.revenantRenderer = revenantRendererIn;
	}

	public void doRenderLayer(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (entitylivingbaseIn.isInvisible())
			return;

		this.revenantRenderer.bindTexture(CRYSTAL);
		GlStateManager.depthMask(true);
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		GlStateManager.alphaFunc(516, 0.003921569F);
		int i = 15728864;
		int j = i % 65536;
		int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
		((ModelRevenantOvergrown) this.revenantRenderer.getMainModel()).renderPlain(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		((ModelRevenantOvergrown) this.revenantRenderer.getMainModel()).renderLights(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
		i = entitylivingbaseIn.getBrightnessForRender();
		j = i % 65536;
		k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
		this.revenantRenderer.setLightmap(entitylivingbaseIn);
		GlStateManager.disableBlend();
	}

	public boolean shouldCombineTextures() {
		return false;
	}
}