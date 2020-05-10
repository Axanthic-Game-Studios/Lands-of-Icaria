package com.axanthic.loi.blocks;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

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
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
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
		this("");
	}
	
	public BlockFlower(String number) {
		super(Material.PLANTS, MapColor.AIR);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setUnlocalizedName("flower");
		this.setRegistryName(ModInformation.ID, "flower" + number);
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
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return 60;
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

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (getMetaFromState(state) == 2 || getMetaFromState(state) == 7)
			entityIn.attackEntityFrom(DamageSource.CACTUS, -1.0F);
	}

	public enum FlowerTypes implements IStringSerializable {
		CHAMEOMILE(0, "chameomile", 15),
		CLOVER(1, "clover", 15),
		YELLOWSTAGHORN(2, "yellow_staghorn", 11),
		SPEARDROPS(3, "speardrops", 10),
		BLINDWEED(4, "blindweed", 9),
		PURPLEHYDRACINTH(5, "purple_hydracinth", 13),
		LIONFANGS(6, "lionfangs", 5),
		PURPLESTAGHORN(7, "purple_staghorn", 13),
		BLUEHYDRACINTH(8, "blue_hydracinth", 4),
		FIREHILT(9, "firehilt", 1),
		VOIDLILY(10, "voidlily", 0),
		CHARMONDER(11, "charmonder", 12),
		BLUESTORMCOTTON(12, "blue_stormcotton", 4),
		PINKSTORMCOTTON(13, "pink_stormcotton", 13),
		PURPLESTORMCOTTON(14, "purple_stormcotton", 5),
		SUNSPONGE(15, "sunsponge", 14);

		private static final FlowerTypes[] META_LOOKUP = new FlowerTypes[FlowerTypes.values().length];
		private final int meta;
		private final String unlocalizedName;
		public final int color;

		FlowerTypes(final int metaIn, final String unlocalizedNameIn, int colorIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.color = colorIn;
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
