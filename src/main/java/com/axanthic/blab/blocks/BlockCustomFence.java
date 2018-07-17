package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCustomFence extends BlockFence implements IBlockMaterial{

	public String name;
	public Block modelBlock;
	public IBlockState modelState;

	public BlockCustomFence(IBlockState modelState, String name) {
		super(modelState.getBlock().getMaterial(modelState), modelState.getBlock().getMapColor(modelState, null, null));
		this.name = name;
		this.modelBlock = modelState.getBlock();
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("fence");
		this.setHardness(modelState.getBlock().getBlockHardness(modelState, null, null));
		this.setResistance(modelState.getBlock().getExplosionResistance(null));
		this.setSoundType(modelState.getBlock().getSoundType());
		if (modelBlock instanceof IBlockMaterial)
			this.setRegistryName(ModInformation.ID, "fence_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMaterial) modelBlock).getName());
		else if (modelBlock instanceof IBlockMeta)
			this.setRegistryName(ModInformation.ID, "fence_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMeta) modelBlock).getNameForMeta(modelBlock.getMetaFromState(modelState)));
		else
			this.setRegistryName(ModInformation.ID, "fence_" + modelState.getBlock().getRegistryName().getResourcePath());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Material getMaterial(IBlockState state) {
		return modelBlock.getMaterial(modelState);
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFlammability(world, pos, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFireSpreadSpeed(world, pos, face);
	}
}
