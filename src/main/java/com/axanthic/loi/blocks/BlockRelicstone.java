package com.axanthic.loi.blocks;

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
import net.minecraft.world.World;

public class BlockRelicstone extends Block implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", BrickTypes.class);
	public static int metaCount = BrickTypes.values().length;

	public BlockRelicstone() {
		super(Material.ROCK, MapColor.WOOD);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(1.2F);
		this.setUnlocalizedName("relicstone");
		this.setRegistryName(ModInformation.ID, "relicstone");
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public String getNameForMeta(final int meta) {
		return BrickTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return BrickTypes.getNames();
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((BrickTypes) state.getValue(BlockRelicstone.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockRelicstone.TYPES, BrickTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockRelicstone.TYPES});
	}

	@Override
	public int damageDropped(final IBlockState state) {
		final int meta = this.getMetaFromState(state);
		if ((meta == 1) && this.getUnlocalizedName().equals("tile.rock")) {
			return 4;
		}
		return meta;
	}

	@Override
	public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(final CreativeTabs itemIn, final NonNullList<ItemStack> items) {
		for (final BrickTypes brickType : BrickTypes.values()) {
			items.add(new ItemStack(this, 1, brickType.meta));
		}
	}

	public enum BrickTypes implements IStringSerializable {
		SMOOTH(0, "smooth"),
		BRICKS_CRACKED(1, "bricks_cracked"),
		BRICKS_MOSSY(2, "bricks_mossy"),
		BRICKS_DRAFT(3, "bricks_draft"),
		TILES(4, "tiles"),
		TILES_CRACKED(5, "tiles_cracked"),
		TILES_MOSSY(6, "tiles_mossy"),
		TILES_DRAFT(7, "tiles_draft"),
		CHISELED(8, "chiseled");

		private static final BrickTypes[] META_LOOKUP = new BrickTypes[BrickTypes.values().length];
		private final int meta;
		private final String unlocalizedName;

		BrickTypes(final int metaIn, final String unlocalizedNameIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
		}

		public static BrickTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= BrickTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return BrickTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[BrickTypes.META_LOOKUP.length];
			for (int i = 0; i < BrickTypes.META_LOOKUP.length; i++) {
				names[i] = BrickTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final BrickTypes brickType : BrickTypes.values()) {
				BrickTypes.META_LOOKUP[brickType.meta] = brickType;
			}
		}
	}
}
