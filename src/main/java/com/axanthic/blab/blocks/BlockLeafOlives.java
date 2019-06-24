package com.axanthic.blab.blocks;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLeafOlives extends BlockLeaf implements IBlockMeta {

	public static PropertyEnum<OliveTypes> TYPES = PropertyEnum.create("type", OliveTypes.class);

	public BlockLeafOlives(BlockPlanks.WoodTypes type) {
		super(type, "olive_leaf");
		this.setRegistryName(ModInformation.ID, "leaf_olive_fruit");
		this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)).withProperty(TYPES, OliveTypes.GREEN));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.food;
	}

	public int damageDropped(IBlockState state) {
		if (((OliveTypes) state.getValue(TYPES)).meta == 1)
			return 1;
		return 0;
	}

	@Override
	public int quantityDropped(Random random) {
		return 1 + random.nextInt(3);
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (fortune > 0) {
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
	public void getDrops(net.minecraft.util.NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();

		ItemStack drop = new ItemStack(getItemDropped(state, rand, fortune), this.quantityDroppedWithBonus(fortune, rand), damageDropped(state));
		if (!drop.isEmpty())
			drops.add(drop);

		this.captureDrops(true);
		drops.addAll(this.captureDrops(false));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (OliveTypes type : OliveTypes.META_LOOKUP)
			items.add(new ItemStack(this, 1, type.meta));
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		return Arrays.asList(new ItemStack(this, 1, world.getBlockState(pos).getValue(TYPES).meta));
	}

	@Override
	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(this, 1, this.getMetaFromState(state));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0)).withProperty(TYPES, OliveTypes.byMetadata((meta & 3) % 4));
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getStateFromMeta(meta).withProperty(DECAYABLE, false).withProperty(CHECK_DECAY, false);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0 | ((OliveTypes) state.getValue(TYPES)).meta;

		if (!((Boolean)state.getValue(DECAYABLE)).booleanValue()) {
			i |= 4;
		}
		if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue()) {
			i |= 8;
		}
		return i;
	}

	@Override
	public String getName() {
		return "material." + type.getName() + ".name";
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE, TYPES});
	}

	@Override
	public String getNameForMeta(int meta) {
		return OliveTypes.byMetadata(meta).unlocalizedName;
	}

	@Override
	public String[] getNames() {
		return OliveTypes.getNames();
	}

	public enum OliveTypes implements IStringSerializable {
		GREEN(0, "green"),
		BLACK(1, "black");

		public static final OliveTypes[] META_LOOKUP = new OliveTypes[values().length];
		public final int meta;
		public final String unlocalizedName;

		OliveTypes(int metaIn, String unlocalizedNameIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
		}

		public static OliveTypes byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.unlocalizedName;
		}

		public static String[] getNames() {
			final String[] names = new String[META_LOOKUP.length];
			for (int i = 0; i < META_LOOKUP.length; i++) {
				names[i] = META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (OliveTypes oliveType : values()) {
				META_LOOKUP[oliveType.meta] = oliveType;
			}
		}
	}
}
