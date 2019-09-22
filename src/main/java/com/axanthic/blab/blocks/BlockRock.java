package com.axanthic.blab.blocks;

import java.util.Random;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources;
import com.google.common.base.Predicate;

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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRock extends Block implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", StoneTypes.class);

	public BlockRock(final String name) {
		super(Material.ROCK);
		this.setCreativeTab(Blab.modTabBlocks);
		this.setHardness(1.5F);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public boolean isReplaceableOreGen(IBlockState state, IBlockAccess world, BlockPos pos, Predicate<IBlockState> target) {
		return target.apply(state);
	}

	@Override
	public String getNameForMeta(final int meta) {
		return StoneTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return StoneTypes.getNames();
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((StoneTypes) state.getValue(BlockRock.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockRock.TYPES, StoneTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockRock.TYPES});
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
	public Item getItemDropped(final IBlockState state, final Random rand, final int fortune) {
		if ((this.getMetaFromState(state) == 1) && this.getUnlocalizedName().equals("tile.rock")) {
			return Resources.resource;
		}
		return super.getItemDropped(state, rand, fortune);
	}

	@Override
	public int quantityDropped(final IBlockState state, final int fortune, final Random random) {
		if ((this.getMetaFromState(state) == 1) && this.getUnlocalizedName().equals("tile.rock")) {
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
	public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(final CreativeTabs itemIn, final NonNullList<ItemStack> items) {
		for (final StoneTypes stoneType : StoneTypes.values()) {
			items.add(new ItemStack(this, 1, stoneType.meta));
		}
	}

	@Override
	public MapColor getMapColor(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
		return ((StoneTypes) state.getValue(BlockRock.TYPES)).mapColor;
	}

	@Override
	public int getHarvestLevel(final IBlockState state) {
		return StoneTypes.byMetadata(this.getMetaFromState(state)).mineLevel;
	}

	@Override
	public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World worldIn, BlockPos pos) {
		if (!canHarvestBlock(worldIn, pos, player)) {
			return player.getDigSpeed(state, pos) / this.blockHardness / 100F;
		}
		return player.getDigSpeed(state, pos) / this.blockHardness / 30F;
	}

	@Override
	public boolean canHarvestBlock(final IBlockAccess world, final BlockPos pos, final EntityPlayer player) {
		final ItemStack stack = player.getHeldItemMainhand();
		final IBlockState state = world.getBlockState(pos);
		int toolLevel = stack.getItem().getHarvestLevel(stack, "pickaxe", player, state);
		if (stack.getItem().getRegistryName().getResourceDomain().equals(ModInformation.ID)) {
			toolLevel += 2;
		}
		return toolLevel >= StoneTypes.byMetadata(this.getMetaFromState(state)).mineLevel;
	}

	public enum StoneTypes implements IStringSerializable {
		YELLOWSTONE(0, "yellowstone", MapColor.DIRT, 2),
		SILKSTONE(1, "silkstone", MapColor.PINK_STAINED_HARDENED_CLAY, 3),
		SUNSTONE(2, "sunstone", MapColor.WOOD, 4),
		VOIDSHALE(3, "voidshale", MapColor.GRAY, 5),
		BAETYL(4, "baetyl", MapColor.STONE, 6),
		RELICSTONE(5, "relicstone", MapColor.WOOD, 0);

		private static final StoneTypes[] META_LOOKUP = new StoneTypes[StoneTypes.values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;
		private final int mineLevel;

		StoneTypes(final int metaIn, final String unlocalizedNameIn, final MapColor mapColorIn, final int mineLevelIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
			this.mineLevel = mineLevelIn;
		}

		public static StoneTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= StoneTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return StoneTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[StoneTypes.META_LOOKUP.length];
			for (int i = 0; i < StoneTypes.META_LOOKUP.length; i++) {
				names[i] = StoneTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final StoneTypes stoneType : StoneTypes.values()) {
				StoneTypes.META_LOOKUP[stoneType.meta] = stoneType;
			}
		}
	}
}
