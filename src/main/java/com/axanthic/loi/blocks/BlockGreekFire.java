package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.block.BlockFire;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGreekFire extends BlockFire {

	public BlockGreekFire() {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setUnlocalizedName("greek_fire");
		this.setRegistryName(ModInformation.ID, "greek_fire");
		this.setLightLevel(1.0F);
	}

	@Override
	public boolean isBurning(IBlockAccess world, BlockPos pos) {
		return true;
	}
}
