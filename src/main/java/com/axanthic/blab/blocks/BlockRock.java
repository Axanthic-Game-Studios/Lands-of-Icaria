package com.axanthic.blab.blocks;

import java.util.Random;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRock extends BlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", StoneTypes.class);
	public static int metaCount = StoneTypes.values().length;

	public BlockRock(String name) {
		super(Material.ROCK);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
		this.setDefaultState(getStateFromMeta(0));
	}

	@Override
	public String getNameForMeta(int meta) {
		return StoneTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return StoneTypes.getNames();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((StoneTypes) state.getValue(TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPES, StoneTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPES});
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = getMetaFromState(state);
		if (meta == 1 && this.getUnlocalizedName().equals("tile.rock")) {
			return 4;
		}
		return meta;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		if (getMetaFromState(state) == 1 && this.getUnlocalizedName().equals("tile.rock")) {
			return Resources.resource;
		}
		return super.getItemDropped(state, rand, fortune);
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		if (getMetaFromState(state) == 1 && this.getUnlocalizedName().equals("tile.rock")) {
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0) {
				i = 0;
			}
			return Math.min(4, (random.nextInt(3) + 1) * (i + 1));
		} else {
			return this.quantityDropped(random);
		}
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (StoneTypes stoneType : StoneTypes.values()) {
			items.add(new ItemStack(this, 1, stoneType.meta));
		}
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((StoneTypes) state.getValue(TYPES)).mapColor;
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return StoneTypes.byMetadata(getMetaFromState(state)).mineLevel;
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		ItemStack stack = player.getHeldItemMainhand();
		IBlockState state = world.getBlockState(pos);
		int toolLevel = stack.getItem().getHarvestLevel(stack, "pickaxe", player, state);
		if (stack.getItem().getRegistryName().getResourceDomain().equals(ModInformation.ID)) {
			toolLevel += 2;
		}
		return toolLevel >= StoneTypes.byMetadata(getMetaFromState(state)).mineLevel;
	}

	public enum StoneTypes implements IStringSerializable {
		YELLOWSTONE(0, "yellowstone", MapColor.DIRT, 2),
		SILKSTONE(1, "silkstone", MapColor.PINK_STAINED_HARDENED_CLAY, 3),
		SUNSTONE(2, "sunstone", MapColor.WOOD, 4),
		VOIDSHALE(3, "voidshale", MapColor.GRAY, 5),
		BAETYL(4, "baetyl", MapColor.STONE, 6);

		private static final StoneTypes[] META_LOOKUP = new StoneTypes[values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;
		private final int mineLevel;

		StoneTypes(int metaIn, String unlocalizedNameIn, MapColor mapColorIn, int mineLevelIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
			this.mineLevel = mineLevelIn;
		}

		public static StoneTypes byMetadata(int meta) {
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
			for (StoneTypes stoneType : values()) {
				META_LOOKUP[stoneType.meta] = stoneType;
			}
		}
	}
}
