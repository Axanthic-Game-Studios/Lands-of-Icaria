package com.axanthic.blab.entity;

import javax.annotation.Nonnull;

import com.axanthic.blab.ModInformation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBident extends Render<EntityBident> {

	public static final ResourceLocation CHALKOS = new ResourceLocation(ModInformation.ID, "textures/items/metal_chalkos_tool_bident.png");
	public static final ResourceLocation KASSITEROS = new ResourceLocation(ModInformation.ID, "textures/items/metal_kassiteros_tool_bident.png");
	public static final ResourceLocation ORICHALCUM = new ResourceLocation(ModInformation.ID, "textures/items/metal_orichalcum_tool_bident.png");
	public static final ResourceLocation VANADIUMSTEEL = new ResourceLocation(ModInformation.ID, "textures/items/metal_vanadiumsteel_tool_bident.png");
	public static final ResourceLocation SIDEROS = new ResourceLocation(ModInformation.ID, "textures/items/metal_sideros_tool_bident.png");
	public static final ResourceLocation MOLYBDENUMSTEEL = new ResourceLocation(ModInformation.ID, "textures/items/metal_molybdenumsteel_tool_bident.png");

	public RenderBident(RenderManager renderManager) {
		super(renderManager);
	}
	
	@Override
    public void doRender(@Nonnull EntityBident bident, double x, double y, double z, float entityYaw, float partialTicks) {
		GlStateManager.pushMatrix();
        this.bindEntityTexture(bident);
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        TextureAtlasSprite textureatlassprite = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(bident.bident.getItem());
        GlStateManager.rotate(bident.prevRotationYaw + (bident.rotationYaw - bident.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(bident.prevRotationPitch + (bident.rotationPitch - bident.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        float f = textureatlassprite.getMinU();
        float f1 = textureatlassprite.getMaxU();
        float f2 = textureatlassprite.getMinV();
        float f3 = textureatlassprite.getMaxV();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        //GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        //GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * -this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(bident));
        }

        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        bufferbuilder.pos(-0.5D, -0.25D, 0.0D).tex((double)f, (double)f3).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.5D, -0.25D, 0.0D).tex((double)f1, (double)f3).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.5D, 0.75D, 0.0D).tex((double)f1, (double)f2).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(-0.5D, 0.75D, 0.0D).tex((double)f, (double)f2).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.draw();

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(bident, x, y, z, entityYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(@Nonnull EntityBident entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}
}
