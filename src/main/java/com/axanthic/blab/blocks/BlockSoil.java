package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSoil extends BlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", SoilTypes.class);
	public static int metaCount = SoilTypes.values().length;

	public BlockSoil() {
		super(Material.GROUND);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		this.setUnlocalizedName("soil");
		this.setRegistryName(ModInformation.ID, "soil");
		this.setDefaultState(getStateFromMeta(0));
	}

	@Override
	public String getNameForMeta(int meta) {
		return SoilTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return SoilTypes.getNames();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((SoilTypes) state.getValue(TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPES, SoilTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPES});
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (SoilTypes soilType : SoilTypes.values()) {
			items.add(new ItemStack(this, 1, soilType.meta));
		}
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((SoilTypes) state.getValue(TYPES)).mapColor;
	}

	public enum SoilTypes implements IStringSerializable {
		MARL(0, "marl", MapColor.DIRT),
		MARLCOURSE(1, "course_marl", MapColor.DIRT),
		LOAM(2, "loam", MapColor.DIRT);

		private static final SoilTypes[] META_LOOKUP = new SoilTypes[values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;

		SoilTypes(int metaIn, String unlocalizedNameIn, MapColor mapColorIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
		}

		public static SoilTypes byMetadata(int meta) {
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
			for (SoilTypes soilType : values()) {
				META_LOOKUP[soilType.meta] = soilType;
			}
		}
	}
}
