package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCustomDoor extends BlockDoor implements IBlockMaterial{

	public String name;
	public Block modelBlock;
	public IBlockState modelState;

	public BlockCustomDoor(IBlockState modelState, String name) {
		super(modelState.getBlock().getMaterial(modelState));
		this.name = name;
		this.modelBlock = modelState.getBlock();
		this.modelState = modelState;
		this.setCreativeTab(modelBlock.getCreativeTabToDisplayOn());
		this.setUnlocalizedName("door");
		this.setHardness(modelState.getBlock().getBlockHardness(modelState, null, null));
		this.setResistance(modelState.getBlock().getExplosionResistance(null));
		this.setSoundType(modelState.getBlock().getSoundType());
		if (modelState instanceof IBlockMaterial)
			this.setRegistryName(ModInformation.ID, "door_" + modelBlock.getRegistryName().getResourcePath() + "_" + ((IBlockMaterial) modelBlock).getName());
		else if (modelBlock instanceof IBlockMeta)
			this.setRegistryName(ModInformation.ID, "door_" + modelBlock.getRegistryName().getResourcePath() + "_" + ((IBlockMeta) modelBlock).getNameForMeta(modelBlock.getMetaFromState(modelState)));
		else
			this.setRegistryName(ModInformation.ID, "door_" + modelBlock.getRegistryName().getResourcePath());
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

	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(this);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : Item.getItemFromBlock(this);
	}
}
