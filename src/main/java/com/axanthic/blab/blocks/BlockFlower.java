package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
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
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFlower extends BlockBush implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", FlowerTypes.class);

	public BlockFlower() {
		super(Material.PLANTS, MapColor.AIR);
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("flower");
		this.setRegistryName(ModInformation.ID, "flower");
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.PLANT);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return super.getBoundingBox(state, source, pos).offset(state.getOffset(source, pos));
	}

	@Override
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XZ;
	}

	@Override
	public String getNameForMeta(final int meta) {
		return FlowerTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return FlowerTypes.getNames();
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((FlowerTypes) state.getValue(BlockFlower.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockFlower.TYPES, FlowerTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockFlower.TYPES});
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
		for (final FlowerTypes flowerType : FlowerTypes.values()) {
			items.add(new ItemStack(this, 1, flowerType.meta));
		}
	}

	public enum FlowerTypes implements IStringSerializable {
		CHAMEOMILE(0, "chameomile"),
		CLOVER(1, "clover"),
		YELLOWSTAGHORN(2, "yellow_staghorn"),
		SPEARDROPS(3, "speardrops"),
		BLINDWEED(4, "blindweed"),
		PURPLEHYDRACINTH(5, "purple_hydracinth"),
		LIONFANGS(6, "lionfangs"),
		PURPLESTAGHORN(7, "purple_staghorn"),
		BLUEHYDRACINTH(8, "blue_hydracinth"),
		FIREHILT(9, "firehilt"),
		VOIDLILY(10, "voidlily");

		private static final FlowerTypes[] META_LOOKUP = new FlowerTypes[FlowerTypes.values().length];
		private final int meta;
		private final String unlocalizedName;

		FlowerTypes(final int metaIn, final String unlocalizedNameIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
		}

		public static FlowerTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= FlowerTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return FlowerTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[FlowerTypes.META_LOOKUP.length];
			for (int i = 0; i < FlowerTypes.META_LOOKUP.length; i++) {
				names[i] = FlowerTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final FlowerTypes flowerType : FlowerTypes.values()) {
				FlowerTypes.META_LOOKUP[flowerType.meta] = flowerType;
			}
		}
	}
}
