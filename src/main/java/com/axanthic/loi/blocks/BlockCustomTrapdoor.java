package com.axanthic.loi.blocks;

import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCustomTrapdoor extends BlockTrapDoor implements IBlockMaterial{

	public String name;
	public Block modelBlock;
	public IBlockState modelState;

	public BlockCustomTrapdoor(IBlockState modelState, String name) {
		super(modelState.getBlock().getMaterial(modelState));
		this.name = name;
		this.modelBlock = modelState.getBlock();
		this.modelState = modelState;
		this.setCreativeTab(modelBlock.getCreativeTabToDisplayOn());
		this.setUnlocalizedName("trapdoor");
		this.setHardness(modelState.getBlock().getBlockHardness(modelState, null, null));
		this.setResistance(modelState.getBlock().getExplosionResistance(null));
		this.setSoundType(modelState.getBlock().getSoundType());
		if (modelState instanceof IBlockMaterial)
			this.setRegistryName(ModInformation.ID, "trapdoor_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMaterial) modelBlock).getName());
		else if (modelBlock instanceof IBlockMeta)
			this.setRegistryName(ModInformation.ID, "trapdoor_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMeta) modelBlock).getNameForMeta(modelBlock.getMetaFromState(modelState)));
		else
			this.setRegistryName(ModInformation.ID, "trapdoor_" + modelState.getBlock().getRegistryName().getResourcePath());
	}

	@Override
	public String getName() {
		if (name == null)
			return new ItemStack(modelBlock, 1, modelBlock.getMetaFromState(modelState)).getDisplayName();
		return name;
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return modelBlock.getMapColor(modelState, worldIn, pos);
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
