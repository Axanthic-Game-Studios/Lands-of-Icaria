package com.axanthic.blab.blocks;

import javax.annotation.Nullable;

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
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockStorageGem extends Block implements IBlockMeta  {

	public static PropertyEnum TYPES = PropertyEnum.create("type", GemTypes.class);

	public BlockStorageGem() {
		super(Material.IRON);
		this.setCreativeTab(Blab.modTabBlocks);
		this.setHardness(1.2F);
		this.setUnlocalizedName("block");
		this.setRegistryName(ModInformation.ID, "block_gem");
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.GLASS);
	}

	@Override
	@Nullable
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		return blockAccess.getBlockState(pos.offset(side)).equals(blockState) ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}

	@Override
	public String getNameForMeta(final int meta) {
		return GemTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return GemTypes.getNames();
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((GemTypes) state.getValue(TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(TYPES, GemTypes.byMetadata(meta));
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
		for (final GemTypes gemType : GemTypes.values()) {
			items.add(new ItemStack(this, 1, gemType.meta));
		}
	}

	@Override
	public MapColor getMapColor(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
		return ((GemTypes) state.getValue(TYPES)).mapColor;
	}

	public enum GemTypes implements IStringSerializable {
		CALCITE(0, "calcite", MapColor.QUARTZ),
		JASPER(1, "jasper", MapColor.RED_STAINED_HARDENED_CLAY),
		ZIRCON(2, "zircon", MapColor.LAPIS);

		private static final GemTypes[] META_LOOKUP = new GemTypes[GemTypes.values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;

		GemTypes(final int metaIn, final String unlocalizedNameIn, final MapColor mapColorIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
		}

		public static GemTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= GemTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return GemTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[GemTypes.META_LOOKUP.length];
			for (int i = 0; i < GemTypes.META_LOOKUP.length; i++) {
				names[i] = GemTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final GemTypes gemType : GemTypes.values()) {
				GemTypes.META_LOOKUP[gemType.meta] = gemType;
			}
		}
	}
}
