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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockRockAdobe extends Block implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", StoneTypes.class);

	public BlockRockAdobe(final String name) {
		super(Material.ROCK);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(1.5F);
		this.setUnlocalizedName(name);
		this.setRegistryName(ModInformation.ID, name);
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.STONE);
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
		return ((StoneTypes) state.getValue(BlockRockAdobe.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockRockAdobe.TYPES, StoneTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockRockAdobe.TYPES});
	}

	@Override
	public int damageDropped(final IBlockState state) {
		final int meta = this.getMetaFromState(state);
		if ((meta == 1) && this.getUnlocalizedName().equals("tile.adobe")) {
			return 0;
		}
		return meta;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		if(this.getMetaFromState(state) == 0)
		{
			drops.add(new ItemStack(this, 1, 0));
		}

		if(this.getMetaFromState(state) == 1)
		{
			drops.add(new ItemStack(this, 1, 1));
		}

		if(this.getMetaFromState(state) == 2)
		{
			drops.add(new ItemStack(this, 1, 2));
		}

		if(this.getMetaFromState(state) == 3)
		{
			drops.add(new ItemStack(this, 1, 3));
		}

		if(this.getMetaFromState(state) == 4)
		{
			drops.add(new ItemStack(this, 1, 4));
		}

		if(this.getMetaFromState(state) == 5)
		{
			drops.add(new ItemStack(this, 1, 5));
		}

		if(this.getMetaFromState(state) == 6)
		{
			drops.add(new ItemStack(this, 1, 6));
		}

		if(this.getMetaFromState(state) == 7)
		{
			drops.add(new ItemStack(this, 1, 7));
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
		return ((StoneTypes) state.getValue(BlockRockAdobe.TYPES)).mapColor;
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
		YELLOWSTONE(0, "yellowstone", MapColor.DIRT, 1),
		SILKSTONE(1, "silkstone", MapColor.PINK_STAINED_HARDENED_CLAY, 1),
		SUNSTONE(2, "sunstone", MapColor.WOOD, 1),
		VOIDSHALE(3, "voidshale", MapColor.GRAY, 1),
		BAETYL(4, "baetyl", MapColor.STONE, 1),
		GRAINEL(5, "grainel", MapColor.WOOD, 1),
		MARL(6, "marl", MapColor.BROWN, 1),
		DOLOMITE(7, "dolomite", MapColor.WHITE_STAINED_HARDENED_CLAY, 1);

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
