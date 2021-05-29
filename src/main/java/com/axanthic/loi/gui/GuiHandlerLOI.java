package com.axanthic.loi.gui;

import com.axanthic.loi.blocks.BlockCustomWorkbench;
import com.axanthic.loi.tileentity.TileEntityForge;
import com.axanthic.loi.tileentity.TileEntityGrinder;
import com.axanthic.loi.tileentity.TileEntityKiln;
import com.axanthic.loi.tileentity.TileEntityVase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerLOI implements IGuiHandler {
	private static final int GUIID_LOI = 30;
	public static int getGuiID() {return GUIID_LOI;}

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
		if (tileEntity instanceof TileEntityKiln) {
			TileEntityKiln tileEntityInventoryBasic = (TileEntityKiln) tileEntity;
			return new ContainerKiln(player.inventory, tileEntityInventoryBasic);
		}
		if (tileEntity instanceof TileEntityGrinder) {
			TileEntityGrinder tileEntityInventoryBasic = (TileEntityGrinder) tileEntity;
			return new ContainerGrinder(player.inventory, tileEntityInventoryBasic);
		}
		if (tileEntity instanceof TileEntityForge) {
			TileEntityForge tileEntityInventoryBasic = (TileEntityForge) tileEntity;
			return new ContainerForge(player.inventory, tileEntityInventoryBasic.forgeInventory);
		}
		if (world.getBlockState(xyz).getBlock() instanceof BlockCustomWorkbench) {
			return new ContainerCustomWorkbench(player.inventory, world, xyz);
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
		if (tileEntity instanceof TileEntityKiln) {
			TileEntityKiln tileEntityInventoryBasic = (TileEntityKiln) tileEntity;
			return new GuiInventoryKiln(player.inventory, tileEntityInventoryBasic);
		}
		if (tileEntity instanceof TileEntityGrinder) {
			TileEntityGrinder tileEntityInventoryBasic = (TileEntityGrinder) tileEntity;
			return new GuiInventoryGrinder(player.inventory, tileEntityInventoryBasic);
		}
		if (tileEntity instanceof TileEntityForge) {
			TileEntityForge tileEntityInventoryBasic = (TileEntityForge) tileEntity;
			return new GuiInventoryForge(player.inventory, tileEntityInventoryBasic);
		}
		if (world.getBlockState(xyz).getBlock() instanceof BlockCustomWorkbench) {
			return new GuiCustomCrafting(player.inventory, world, xyz);
		}
		return null;
	}
}
