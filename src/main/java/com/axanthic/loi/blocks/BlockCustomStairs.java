package com.axanthic.loi.blocks;

import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCustomStairs extends BlockStairs implements IBlockMaterial{

	public String name;
	public Block modelBlock;
	public IBlockState modelState;

	public BlockCustomStairs(IBlockState modelState, String name) {// + "_" + modelState.getProperties().
		super(modelState);
		this.name = name;
		this.modelBlock = modelState.getBlock();
		this.modelState = modelState;
		this.setCreativeTab(modelBlock.getCreativeTabToDisplayOn());
		this.setUnlocalizedName("stairs");
		if (modelBlock instanceof IBlockMaterial)
			this.setRegistryName(ModInformation.ID, "stairs_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMaterial) modelBlock).getName());
		else if (modelBlock instanceof IBlockMeta)
			this.setRegistryName(ModInformation.ID, "stairs_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMeta) modelBlock).getNameForMeta(modelBlock.getMetaFromState(modelState)));
		else
			this.setRegistryName(ModInformation.ID, "stairs_" + modelState.getBlock().getRegistryName().getResourcePath());
        this.useNeighborBrightness = true;
	}

	@Override
	public String getName() {
		if (name == null)
			return new ItemStack(modelBlock, 1, modelBlock.getMetaFromState(modelState)).getDisplayName();
		return name;
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFlammability(world, pos, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFireSpreadSpeed(world, pos, face);
	}

	@Override
	public boolean isTopSolid(IBlockState state) {
		return true;
	}
}
