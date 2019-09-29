package com.axanthic.loi.tileentity;

import com.axanthic.loi.Resources;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class TileEntitySpecialRendererGrinder extends TileEntitySpecialRenderer<TileEntityGrinder> {

	ItemStack gearLarge = new ItemStack(Resources.gear, 1, 0);
	ItemStack gearLargeActive = new ItemStack(Resources.gear, 1, 1);
	ItemStack gearSmall = new ItemStack(Resources.gear, 1, 2);
	ItemStack gearSmallActive = new ItemStack(Resources.gear, 1, 3);

	@Override
	public void render(TileEntityGrinder tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress, float alpha) {
		if (!(tileEntity instanceof TileEntityGrinder)) return;

		GlStateManager.pushMatrix();
		GlStateManager.translate((float) relativeX, (float) relativeY, (float) relativeZ);
		GlStateManager.translate(0.5F, 14.5F/16.0F, 0.25F);
		GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(2.0F, 2.0F, 2.0F);

		if (tileEntity.isGrinding())
			Minecraft.getMinecraft().getRenderItem().renderItem(gearLargeActive, ItemCameraTransforms.TransformType.GROUND);
		else
			Minecraft.getMinecraft().getRenderItem().renderItem(gearLarge, ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		GlStateManager.translate((float) relativeX, (float) relativeY, (float) relativeZ);
		EnumFacing facing = tileEntity.getWorld().getBlockState(tileEntity.getPos()).getValue(BlockHorizontal.FACING);
		if (facing.equals(EnumFacing.WEST) || facing.equals(EnumFacing.EAST)) {
			GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.translate(-1.0F, 0.0F, 0.0F);
		}
		GlStateManager.translate(3.0F/16.0F, 3.0F/16.0F, 0.5F/16.0F);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(2.0F, 2.0F, 2.0F);

		if (tileEntity.isGrinding())
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmallActive, ItemCameraTransforms.TransformType.GROUND);
		else
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmall, ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.translate(5.0F/32.0F, 0.0F, 15.0F/32.0F);

		if (tileEntity.isGrinding())
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmallActive, ItemCameraTransforms.TransformType.GROUND);
		else
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmall, ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

	@Override
	public boolean isGlobalRenderer(TileEntityGrinder tileEntity) {
		return false;
	}
}