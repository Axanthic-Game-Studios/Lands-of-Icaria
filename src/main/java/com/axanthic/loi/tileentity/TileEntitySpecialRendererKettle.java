package com.axanthic.loi.tileentity;

import java.util.List;

import com.axanthic.loi.Resources;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class TileEntitySpecialRendererKettle extends TileEntitySpecialRenderer<TileEntityKettle> {

	ItemStack concoction = new ItemStack(Resources.renderAddon, 1, 4);
	private static final Tessellator tessellator = Tessellator.getInstance();
	private static final BufferBuilder bufferbuilder = tessellator.getBuffer();
	IBakedModel concoctionModel = net.minecraftforge.client.ForgeHooksClient.handleCameraTransforms(Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getItemModel(concoction), ItemCameraTransforms.TransformType.GUI, false);

	@Override
	public void render(TileEntityKettle tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress, float alpha) {
		if (tileEntity.getFluidLevel() == 0)
			return;

		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		GlStateManager.pushMatrix();
		GlStateManager.translate(relativeX, relativeY + (4.0F + tileEntity.getFluidLevel() * 8.5F / 1000F) / 16.0F - 0.5, relativeZ + 1.0);
		GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
		renderModel(concoctionModel, tileEntity.getColor(), concoction);
		GlStateManager.popMatrix();

	}

	@Override
	public boolean isGlobalRenderer(TileEntityKettle tileEntity) {
		return false;
	}

	//mostly copied from RenderItem
	public void renderModel(IBakedModel model, int color, ItemStack stack) {
		/*if (net.minecraftforge.common.ForgeModContainer.allowEmissiveItems) {
            net.minecraftforge.client.ForgeHooksClient.renderLitItem(Minecraft.getMinecraft().getRenderItem(), model, color, stack);
            return;
        }*/
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.ITEM);

		for (EnumFacing enumfacing : EnumFacing.values()) {
			this.renderQuads(bufferbuilder, model.getQuads((IBlockState)null, enumfacing, 0L), color, stack);
		}

		this.renderQuads(bufferbuilder, model.getQuads((IBlockState)null, (EnumFacing)null, 0L), color, stack);
		tessellator.draw();
	}

	//mostly copied from RenderItem
	public void renderQuads(BufferBuilder renderer, List<BakedQuad> quads, int color, ItemStack stack) {
		int i = 0;

		for (int j = quads.size(); i < j; ++i) {
			BakedQuad bakedquad = quads.get(i);
			int k = color;

			if (EntityRenderer.anaglyphEnable) {
				k = TextureUtil.anaglyphColor(k);
			}

			k = k | -16777216;

			net.minecraftforge.client.model.pipeline.LightUtil.renderQuadColor(renderer, bakedquad, k);
		}
	}
}