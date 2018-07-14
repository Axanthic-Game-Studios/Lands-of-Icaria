package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
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

public class BlockGrainelStone extends Block implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", GrainiteTypes.class);
	public static int metaCount = GrainiteTypes.values().length;

	public BlockGrainelStone() {
		super(Material.ROCK, MapColor.WOOD);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(1.2F);
		this.setUnlocalizedName("grainite");
		this.setRegistryName(ModInformation.ID, "grainite");
		this.setDefaultState(this.getStateFromMeta(0));
		this.setSoundType(SoundType.STONE);
	}

	@Override
	public String getNameForMeta(final int meta) {
		return GrainiteTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return GrainiteTypes.getNames();
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((GrainiteTypes) state.getValue(BlockGrainelStone.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockGrainelStone.TYPES, GrainiteTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockGrainelStone.TYPES});
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
		for (final GrainiteTypes brickType : GrainiteTypes.values()) {
			items.add(new ItemStack(this, 1, brickType.meta));
		}
	}

	public enum GrainiteTypes implements IStringSerializable {
		COBBLE(0, "cobble"),
		BRICKS(1, "bricks"),
		BRICKS_CHISELED(2, "bricks_chiseled");

		private static final GrainiteTypes[] META_LOOKUP = new GrainiteTypes[GrainiteTypes.values().length];
		private final int meta;
		private final String unlocalizedName;

		GrainiteTypes(final int metaIn, final String unlocalizedNameIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
		}

		public static GrainiteTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= GrainiteTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return GrainiteTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[GrainiteTypes.META_LOOKUP.length];
			for (int i = 0; i < GrainiteTypes.META_LOOKUP.length; i++) {
				names[i] = GrainiteTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final GrainiteTypes brickType : GrainiteTypes.values()) {
				GrainiteTypes.META_LOOKUP[brickType.meta] = brickType;
			}
		}
	}
}
