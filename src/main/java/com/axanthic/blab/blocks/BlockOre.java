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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOre extends BlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", OreTypes.class);
	public static int metaCount = OreTypes.values().length;

	public BlockOre() {
		super(Material.ROCK);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		this.setUnlocalizedName("ore");
		this.setRegistryName("blab", "ore");
		this.setDefaultState(getStateFromMeta(0));
	}

	@Override
	public String getNameForMeta(int meta) {
		return OreTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return OreTypes.getNames();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((OreTypes) state.getValue(TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPES, OreTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPES});
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = getMetaFromState(state);
		if (meta == 0) {
			return 0;
		} else if (meta == 3) {
			return 1;
		} else if (meta == 8) {
			return 2;
		} else if (meta == 12) {
			return 3;
		}
		return meta;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (OreTypes stoneType : OreTypes.values()) {
			items.add(new ItemStack(this, 1, stoneType.meta));
		}
	}

	@Override
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((OreTypes) state.getValue(TYPES)).mapColor;
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return OreTypes.byMetadata(getMetaFromState(state)).mineLevel;
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		ItemStack stack = player.getHeldItemMainhand();
		IBlockState state = world.getBlockState(pos);
		int toolLevel = stack.getItem().getHarvestLevel(stack, "pickaxe", player, state);
		if (stack.getItem().getRegistryName().getResourceDomain().equals(ModInformation.ID)) {
			toolLevel += 2;
		}
		return toolLevel >= OreTypes.byMetadata(getMetaFromState(state)).mineLevel;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		int meta = getMetaFromState(state);
		if (meta == 0) {
			return MathHelper.getInt(rand, 0, 2);
		} else if (meta == 3 || meta == 12) {
			return MathHelper.getInt(rand, 2, 5);
		} else if (meta == 8) {
			return MathHelper.getInt(rand, 1, 3);
		}
		return 0;
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		int meta = getMetaFromState(state);
		if (meta == 0 || meta == 3 || meta == 12 || meta == 8) {
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0) {
				i = 0;
			}
			return this.quantityDropped(random) * (i + 1);
		} else {
			return this.quantityDropped(random);
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		int meta = getMetaFromState(state);
		if (meta == 0 || meta == 3 || meta == 12 || meta == 8) {
			return Resources.resource;
		}
		return super.getItemDropped(state, rand, fortune);
	}

	public enum OreTypes implements IStringSerializable {
		LIGNITE(0, "lignite", MapColor.DIRT, 2),
		CHALKOS(1, "chalkos", MapColor.DIRT, 2),
		KASSITEROS(2, "kassiteros", MapColor.PINK_STAINED_HARDENED_CLAY, 3),
		DOLOMITE(3, "dolomite", MapColor.PINK_STAINED_HARDENED_CLAY, 3),
		MOLIBOS(4, "molibos", MapColor.PINK_STAINED_HARDENED_CLAY, 3),
		VANADIUM(5, "vanadium", MapColor.WOOD, 4),
		SLIVER(6, "sliver", MapColor.WOOD, 4),
		SIDEROS(7, "sideros", MapColor.GRAY, 5),
		ANTHRACITE(8, "anthracite", MapColor.GRAY, 5),
		MOLYBDENUM(9, "molybdenum", MapColor.GRAY, 5),
		BLURIDIUM(10, "bluridium", MapColor.STONE, 6),
		YILASTER(11, "yilaster", MapColor.STONE, 6),
		ABYSSAL(12, "abyssal_essence", MapColor.STONE, 6);

		private static final OreTypes[] META_LOOKUP = new OreTypes[values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;
		private final int mineLevel;

		OreTypes(int metaIn, String unlocalizedNameIn, MapColor mapColorIn, int mineLevelIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
			this.mineLevel = mineLevelIn;
		}

		public static OreTypes byMetadata(int meta) {
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
			for (OreTypes stoneType : values()) {
				META_LOOKUP[stoneType.meta] = stoneType;
			}
		}
	}
}
