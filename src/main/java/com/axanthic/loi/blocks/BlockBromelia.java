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

public class BlockBromelia extends BlockBush implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", BromeliaTypes.class);
	
	public BlockBromelia() {
		super(Material.PLANTS, MapColor.AIR);
		this.setCreativeTab(LandsOfIcaria.modTabFlora);
		this.setUnlocalizedName("bromelia");
		this.setRegistryName(ModInformation.ID, "bromelia");
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
		return BromeliaTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return BromeliaTypes.getNames();
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
		return ((BromeliaTypes) state.getValue(BlockBromelia.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockBromelia.TYPES, BromeliaTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockBromelia.TYPES});
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
		for (final BromeliaTypes bromeliaType : BromeliaTypes.values()) {
			items.add(new ItemStack(this, 1, bromeliaType.meta));
		}
	}

	public enum BromeliaTypes implements IStringSerializable {
		ORANGE(0, "orange"),
		PINK(1, "pink"),
		PURPLE(2, "purple"),
		WHITE(3, "white");

		private static final BromeliaTypes[] META_LOOKUP = new BromeliaTypes[BromeliaTypes.values().length];
		private final int meta;
		private final String unlocalizedName;

		BromeliaTypes(final int metaIn, final String unlocalizedNameIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
		}

		public static BromeliaTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= BromeliaTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return BromeliaTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[BromeliaTypes.META_LOOKUP.length];
			for (int i = 0; i < BromeliaTypes.META_LOOKUP.length; i++) {
				names[i] = BromeliaTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final BromeliaTypes bromeliaType : BromeliaTypes.values()) {
				BromeliaTypes.META_LOOKUP[bromeliaType.meta] = bromeliaType;
			}
		}
	}
}
