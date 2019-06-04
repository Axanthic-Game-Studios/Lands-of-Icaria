package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlanks extends Block implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", WoodTypes.class);
	public static int metaCount = WoodTypes.values().length;

	public BlockPlanks() {
		super(Material.WOOD);
		this.setCreativeTab(Blab.modTabFlora);
		this.setHardness(1.2F);
		this.setUnlocalizedName("planks");
		this.setRegistryName(ModInformation.ID, "planks");
		this.setDefaultState(getStateFromMeta(0));
		this.setSoundType(SoundType.WOOD);
	}

	@Override
	public String getNameForMeta(int meta) {
		return WoodTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return WoodTypes.getNames();
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 20;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 5;
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((WoodTypes) state.getValue(TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPES, WoodTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPES});
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (WoodTypes woodType : WoodTypes.values()) {
			items.add(new ItemStack(this, 1, woodType.meta));
		}
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((WoodTypes) state.getValue(TYPES)).mapColor;
	}

	public enum WoodTypes implements IStringSerializable {
		PLANE(0, "plane", MapColor.DIRT, MapColor.STONE, MapColor.GRASS, 10),
		POPULUS(1, "populus", MapColor.SAND, MapColor.QUARTZ, MapColor.LIME_STAINED_HARDENED_CLAY, 20),
		CYPRESS(2, "cypress", MapColor.BROWN, MapColor.STONE, MapColor.GREEN_STAINED_HARDENED_CLAY, 20),
		FIR(3, "fir", MapColor.WHITE_STAINED_HARDENED_CLAY, MapColor.BROWN_STAINED_HARDENED_CLAY, MapColor.GREEN, 20),
		OLIVE(4, "olive", MapColor.ADOBE, MapColor.STONE, MapColor.YELLOW, 30),
		LAUREL(5, "laurel", MapColor.BROWN, MapColor.OBSIDIAN, MapColor.GREEN_STAINED_HARDENED_CLAY, 20),
		DROUGHTROOT(6, "droughtroot", MapColor.GRAY, MapColor.OBSIDIAN, MapColor.GREEN_STAINED_HARDENED_CLAY, 10);

		public static final WoodTypes[] META_LOOKUP = new WoodTypes[values().length];
		public final int meta;
		public final String unlocalizedName;
		public final MapColor mapColor;
		public final MapColor logColor;
		public final MapColor leafColor;
		public final int saplingChance;

		WoodTypes(int metaIn, String unlocalizedNameIn, MapColor mapColorIn, MapColor logColorIn, MapColor leafColorIn, int saplingChance) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
			this.logColor = logColorIn;
			this.leafColor = leafColorIn;
			this.saplingChance = saplingChance;
		}

		public static WoodTypes byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.unlocalizedName;
		}

		public static String[] getNames() {
			String[] names = new String[META_LOOKUP.length];
			for (int i = 0; i < META_LOOKUP.length; i++) {
				names[i] = META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (WoodTypes woodType : values()) {
				META_LOOKUP[woodType.meta] = woodType;
			}
		}
	}
}
