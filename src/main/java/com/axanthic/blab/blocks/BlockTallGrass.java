package com.axanthic.blab.blocks;

import java.util.Random;

import javax.annotation.Nullable;

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
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTallGrass extends BlockBush implements net.minecraftforge.common.IShearable, IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", GrassTypes.class);
	protected static final AxisAlignedBB LARGE_GRASS_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
	protected static final AxisAlignedBB MEDIUM_GRASS_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.625D, 0.8999999761581421D);
	protected static final AxisAlignedBB SMALL_GRASS_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 0.5D, 0.75D);

	public BlockTallGrass() {
		super(Material.VINE, MapColor.AIR);
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("tallgrass");
		this.setRegistryName(ModInformation.ID, "tallgrass");
		this.setSoundType(SoundType.PLANT);
	}

	@Override
	public String getNameForMeta(final int meta) {
		return GrassTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return GrassTypes.getNames();
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
		return ((GrassTypes) state.getValue(TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(TYPES, GrassTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPES});
	}

	@Override
	public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(final CreativeTabs itemIn, final NonNullList<ItemStack> items) {
		for (final GrassTypes grassType : GrassTypes.values()) {
			items.add(new ItemStack(this, 1, grassType.meta));
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (getMetaFromState(state) == 0)
			return SMALL_GRASS_AABB;
		if (getMetaFromState(state) == 1)
			return MEDIUM_GRASS_AABB;

		return LARGE_GRASS_AABB;
	}

	@Override
	public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
		return super.canBlockStay(worldIn, pos, state);
	}

	@Override
	public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
		return true;
	}

	@Override
	public boolean canSilkHarvest() {
		return true;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}

	@Override
	public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
		if (!worldIn.isRemote && stack.getItem() == Items.SHEARS) {
			player.addStat(StatList.getBlockStats(this));
			spawnAsEntity(worldIn, pos, new ItemStack(this, 1, 0));
		} else {
			super.harvestBlock(worldIn, player, pos, state, te, stack);
		}
	}

	@Override
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XYZ;
	}

	@Override public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return NonNullList.withSize(1, new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos))));
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		//if (RANDOM.nextInt(8) != 0)
		//	return;
		//ItemStack seed = net.minecraftforge.common.ForgeHooks.getGrassSeed(RANDOM, fortune);
		//if (!seed.isEmpty())
		//	drops.add(seed);
	}

	public enum GrassTypes implements IStringSerializable {
		SMALL(0, "small"),
		MEDIUM(1, "medium"),
		LARGE(2, "large"),
		FERN(3, "fern");

		private static final GrassTypes[] META_LOOKUP = new GrassTypes[GrassTypes.values().length];
		private final int meta;
		private final String unlocalizedName;

		GrassTypes(final int metaIn, final String unlocalizedNameIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
		}

		public static GrassTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= GrassTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return GrassTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[GrassTypes.META_LOOKUP.length];
			for (int i = 0; i < GrassTypes.META_LOOKUP.length; i++) {
				names[i] = GrassTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final GrassTypes grassType : GrassTypes.values()) {
				GrassTypes.META_LOOKUP[grassType.meta] = grassType;
			}
		}
	}
}
