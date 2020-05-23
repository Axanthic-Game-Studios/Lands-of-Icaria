package com.axanthic.loi.blocks;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFlower2 extends BlockFlower implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", FlowerTypes2.class);

	public BlockFlower2() {
		super("_2");
	}

	@Override
	public String getNameForMeta(final int meta) {
		return FlowerTypes2.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return FlowerTypes2.getNames();
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((FlowerTypes2) state.getValue(BlockFlower2.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockFlower2.TYPES, FlowerTypes2.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockFlower2.TYPES});
	}

	@Override
	public void getSubBlocks(final CreativeTabs itemIn, final NonNullList<ItemStack> items) {
		for (final FlowerTypes2 flowerType : FlowerTypes2.values()) {
			items.add(new ItemStack(this, 1, flowerType.meta));
		}
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {

	}

	@Override
	public net.minecraft.pathfinding.PathNodeType getAiPathNodeType(IBlockState state, IBlockAccess world, BlockPos pos) {
		return null;
	}

	public enum FlowerTypes2 implements IStringSerializable {
		SUNKETTLE(0, "sunkettle", 11);

		private static final FlowerTypes2[] META_LOOKUP = new FlowerTypes2[FlowerTypes2.values().length];
		private final int meta;
		private final String unlocalizedName;
		public final int color;

		FlowerTypes2(final int metaIn, final String unlocalizedNameIn, int colorIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.color = colorIn;
		}

		public static FlowerTypes2 byMetadata(int meta) {
			if ((meta < 0) || (meta >= FlowerTypes2.META_LOOKUP.length)) {
				meta = 0;
			}

			return FlowerTypes2.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[FlowerTypes2.META_LOOKUP.length];
			for (int i = 0; i < FlowerTypes2.META_LOOKUP.length; i++) {
				names[i] = FlowerTypes2.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final FlowerTypes2 flowerType : FlowerTypes2.values()) {
				FlowerTypes2.META_LOOKUP[flowerType.meta] = flowerType;
			}
		}
	}
}
