package com.axanthic.blab.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.blab.Blab;
import com.axanthic.blab.blocks.BlockStone.StoneTypes;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockMeta extends Block {

	public BlockMeta(Material material) {
		super(material);
	}
	
	public String getNameForMeta(int meta) {
		return "";
	}
}
