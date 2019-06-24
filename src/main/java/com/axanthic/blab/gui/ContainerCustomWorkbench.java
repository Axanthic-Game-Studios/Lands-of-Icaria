package com.axanthic.blab.gui;

import net.minecraft.block.BlockWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerCustomWorkbench extends ContainerWorkbench {

	private final World world;
	private final BlockPos pos;
	private final EntityPlayer player;

	public ContainerCustomWorkbench(InventoryPlayer playerInventory, World worldIn, BlockPos posIn) {
		super(playerInventory, worldIn, posIn);
		this.world = worldIn;
		this.pos = posIn;
		this.player = playerInventory.player;
	}

	public boolean canInteractWith(EntityPlayer playerIn) {
		if (!(this.world.getBlockState(this.pos).getBlock() instanceof BlockWorkbench)) {
			return false;
		} else {
			return playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
		}
	}
}