package com.axanthic.loi.utils;

import com.axanthic.loi.blocks.BlockGrinder;
import com.axanthic.loi.blocks.BlockMobHead;
import com.axanthic.loi.items.ItemBlockMobHead;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererGrinder;
import com.axanthic.loi.tileentity.TileEntitySpecialRendererMobHead;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LOIItemStackRenderer extends TileEntityItemStackRenderer {

    public static LOIItemStackRenderer LOIInstance;

	public void renderByItem(ItemStack stack, float partialTicks) {
		Item item = stack.getItem();

		if (item instanceof ItemBlockMobHead) {
			if (TileEntitySpecialRendererMobHead.instance != null) {
				GlStateManager.pushMatrix();
				GlStateManager.disableCull();
				TileEntitySpecialRendererMobHead.instance.renderSkull(0.0F, 0.0F, 0.0F, EnumFacing.UP, 180.0F, ((BlockMobHead) ((ItemBlock) item).getBlock()).name, -1);
				GlStateManager.enableCull();
				GlStateManager.popMatrix();
			}
		}

		if (item instanceof ItemBlock && ((ItemBlock) item).getBlock() instanceof BlockGrinder) {
			if (TileEntitySpecialRendererGrinder.instance != null) {
				GlStateManager.pushMatrix();
				GlStateManager.disableCull();
				TileEntitySpecialRendererGrinder.instance.renderInventory();
				GlStateManager.enableCull();
				GlStateManager.popMatrix();
			}
		}
	}
}
