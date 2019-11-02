package com.axanthic.loi.blocks;

import com.axanthic.loi.Resources;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidUpwards extends BlockFluidCustom {

	public BlockFluidUpwards(Fluid fluid, Material material) {
		super(fluid, material);
	}

	public BlockFluidUpwards(Fluid fluid, Material material, MapColor mapColor) {
		super(fluid, material, mapColor);
	}

	@Override
	protected void flowIntoBlock(World world, BlockPos pos, int meta) {
		if (meta < 0) return;
		if (displaceIfPossible(world, pos)) {
			if (world.canSeeSky(pos))
				world.setBlockState(pos, Resources.aristone.getBlock().getDefaultState());
			else
				world.setBlockState(pos, this.getDefaultState().withProperty(LEVEL, meta));
		}
	}
}
