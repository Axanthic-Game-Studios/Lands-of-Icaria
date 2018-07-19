package com.axanthic.blab.gui;

import com.axanthic.blab.utils.TileEntityVase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerBlab implements IGuiHandler {
	private static final int GUIID_BLAB = 30;
	public static int getGuiID() {return GUIID_BLAB;}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityVase) {
			TileEntityVase tileEntityInventoryBasic = (TileEntityVase) tileEntity;
			return new ContainerVase(player.inventory, tileEntityInventoryBasic);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID != getGuiID()) {
			System.err.println("Invalid ID: expected " + getGuiID() + ", received " + ID);
		}

		BlockPos xyz = new BlockPos(x, y, z);
		TileEntity tileEntity = world.getTileEntity(xyz);
		if (tileEntity instanceof TileEntityVase) {
			TileEntityVase tileEntityInventoryBasic = (TileEntityVase) tileEntity;
			return new GuiInventoryVase(player.inventory, tileEntityInventoryBasic);
		}
		return null;
	}
}
