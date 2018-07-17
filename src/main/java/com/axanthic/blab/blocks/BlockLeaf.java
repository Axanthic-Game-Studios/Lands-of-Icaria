package com.axanthic.blab.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLeaf extends BlockLeaves implements IBlockMaterial {

	public BlockPlanks.WoodTypes type;
	public Item sapling;

	public BlockLeaf(BlockPlanks.WoodTypes type, Item sapling) {
		super();
		this.setCreativeTab(Blab.modTab);
		this.type = type;
		this.sapling = sapling;
		this.setUnlocalizedName("leaf");
		this.setRegistryName(ModInformation.ID, "leaf_" + type.unlocalizedName);
		this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		this.setSoundType(SoundType.PLANT);
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return type.leafColor;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return sapling;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return Arrays.asList(new ItemStack(this, 1, 0));
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(this, 1, 0);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
	}

	@Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(DECAYABLE, false).withProperty(CHECK_DECAY, false);
    }

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0 | 0;

		if (!((Boolean)state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		return i;
	}

	@Override
	public EnumType getWoodType(int meta) {
		return EnumType.OAK;
	}

	@Override
	public String getName() {
		return "material." + type.getName() + ".name";
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 30;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return !Minecraft.getMinecraft().gameSettings.fancyGraphics;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return Minecraft.getMinecraft().gameSettings.fancyGraphics ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return !Minecraft.getMinecraft().gameSettings.fancyGraphics && blockAccess.getBlockState(pos.offset(side)).getBlock() == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
}
