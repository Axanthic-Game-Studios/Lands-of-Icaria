package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCustomFenceGate extends BlockFenceGate implements IBlockMaterial{

	public String name;
	public Block modelBlock;
	public IBlockState modelState;

	public BlockCustomFenceGate(IBlockState modelState, String name) {
		super(BlockPlanks.EnumType.OAK);
		this.name = name;
		this.modelBlock = modelState.getBlock();
		this.modelState = modelState;
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("gate");
		this.setHardness(modelState.getBlock().getBlockHardness(modelState, null, null));
		this.setResistance(modelState.getBlock().getExplosionResistance(null));
		this.setSoundType(modelState.getBlock().getSoundType());
		if (modelState instanceof IBlockMaterial)
			this.setRegistryName(ModInformation.ID, "gate_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMaterial) modelBlock).getName());
		else if (modelBlock instanceof IBlockMeta)
			this.setRegistryName(ModInformation.ID, "gate_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMeta) modelBlock).getNameForMeta(modelBlock.getMetaFromState(modelState)));
		else
			this.setRegistryName(ModInformation.ID, "gate_" + modelState.getBlock().getRegistryName().getResourcePath());
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
