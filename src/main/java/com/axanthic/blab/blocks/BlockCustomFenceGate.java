package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCustomFenceGate extends BlockFenceGate implements IBlockMaterial{

	public String name;
	IBlockState modelState;

	public BlockCustomFenceGate(IBlockState modelState, String name) {
		super(BlockPlanks.EnumType.OAK);
		this.name = name;
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("gate");
		this.setHardness(modelState.getBlock().getBlockHardness(modelState, null, null));
		this.setResistance(modelState.getBlock().getExplosionResistance(null));
		this.setSoundType(modelState.getBlock().getSoundType());
		this.modelState = modelState;
		if (name.contains(".")) {
			this.setRegistryName(ModInformation.ID, "gate_" + name.substring(name.lastIndexOf(".") + 1));
		} else {
			this.setRegistryName(ModInformation.ID, "gate_" + name);
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Material getMaterial(IBlockState state) {
		return modelState.getBlock().getMaterial(modelState);
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return modelState.getBlock().getMapColor(modelState, worldIn, pos);
	}
}
