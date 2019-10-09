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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHerb extends BlockBush implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", HerbTypes.class);
	protected static final AxisAlignedBB LARGE_GRASS_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public BlockHerb() {
		super(Material.PLANTS, MapColor.AIR);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setUnlocalizedName("herb");
		this.setRegistryName(ModInformation.ID, "herb");
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.PLANT);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return LARGE_GRASS_AABB;
	}

	@Override
	public Block.EnumOffsetType getOffsetType() {
		return Block.EnumOffsetType.XZ;
	}

	@Override
	public String getNameForMeta(final int meta) {
		return HerbTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return HerbTypes.getNames();
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
		return ((HerbTypes) state.getValue(BlockHerb.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockHerb.TYPES, HerbTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockHerb.TYPES});
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
		for (final HerbTypes herbType : HerbTypes.values()) {
			items.add(new ItemStack(this, 1, herbType.meta));
		}
	}

	public enum HerbTypes implements IStringSerializable {
		BELLADENA(0, "belladena"),
		BOLBOS(1, "bolbos"),
		DATHULLA(2, "dathulla"),
		MONDANOS(3, "mondanos"),
		MOTH_AGARIC(4, "moth_agaric"),
		NAMDRAKE(5, "namdrake"),
		PSILOCYBOS(6, "psilocybos"),
		ROWAN(7, "rowan"),
		WILTED_ELM(8, "wilted_elm");

		private static final HerbTypes[] META_LOOKUP = new HerbTypes[HerbTypes.values().length];
		private final int meta;
		private final String unlocalizedName;

		HerbTypes(final int metaIn, final String unlocalizedNameIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
		}

		public static HerbTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= HerbTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return HerbTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[HerbTypes.META_LOOKUP.length];
			for (int i = 0; i < HerbTypes.META_LOOKUP.length; i++) {
				names[i] = HerbTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final HerbTypes herbType : HerbTypes.values()) {
				HerbTypes.META_LOOKUP[herbType.meta] = herbType;
			}
		}
	}
}
