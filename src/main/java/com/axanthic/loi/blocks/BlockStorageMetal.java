package com.axanthic.loi.blocks;

import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

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
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStorageMetal extends Block implements IBlockMeta  {

	public static PropertyEnum TYPES = PropertyEnum.create("type", MetalTypes.class);

	public BlockStorageMetal() {
		super(Material.IRON);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(1.2F);
		this.setUnlocalizedName("block");
		this.setRegistryName(ModInformation.ID, "block_metal");
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.METAL);
	}

	@Override
	@Nullable
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public String getNameForMeta(final int meta) {
		return MetalTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return MetalTypes.getNames();
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((MetalTypes) state.getValue(TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(TYPES, MetalTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPES});
	}

	@Override
	public int damageDropped(final IBlockState state) {
		return this.getMetaFromState(state);
	}

	@Override
	public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(final CreativeTabs itemIn, final NonNullList<ItemStack> items) {
		for (final MetalTypes metalType : MetalTypes.values()) {
			items.add(new ItemStack(this, 1, metalType.meta));
		}
	}

	@Override
	public MapColor getMapColor(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
		return ((MetalTypes) state.getValue(TYPES)).mapColor;
	}

	public enum MetalTypes implements IStringSerializable {
		CHALKOS(0, "chalkos", MapColor.ADOBE),
		KASSITEROS(1, "kassiteros", MapColor.LIGHT_BLUE_STAINED_HARDENED_CLAY),
		MOLIBOS(2, "molibos", MapColor.CYAN_STAINED_HARDENED_CLAY),
		ORICHALCUM(3, "orichalcum", MapColor.ADOBE),
		SLIVER(4, "sliver", MapColor.SAND),
		VANADIUM(5, "vanadium", MapColor.YELLOW),
		VANADIUMSTEEL(6, "vanadiumsteel", MapColor.WOOD),
		SIDEROS(7, "sideros", MapColor.GRAY),
		MOLYBDENUM(8, "molybdenum", MapColor.SILVER),
		MOLYBDENUMSTEEL(9, "molybdenumsteel", MapColor.SILVER),
		BLURIDIUM(10, "bluridium", MapColor.LIGHT_BLUE);

		private static final MetalTypes[] META_LOOKUP = new MetalTypes[MetalTypes.values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;

		MetalTypes(final int metaIn, final String unlocalizedNameIn, final MapColor mapColorIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
		}

		public static MetalTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= MetalTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return MetalTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[MetalTypes.META_LOOKUP.length];
			for (int i = 0; i < MetalTypes.META_LOOKUP.length; i++) {
				names[i] = MetalTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final MetalTypes metalType : MetalTypes.values()) {
				MetalTypes.META_LOOKUP[metalType.meta] = metalType;
			}
		}
	}
}
