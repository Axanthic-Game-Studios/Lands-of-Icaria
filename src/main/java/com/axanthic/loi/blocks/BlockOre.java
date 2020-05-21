package com.axanthic.loi.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemResources;

import net.minecraft.block.Block;
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
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOre extends Block implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", OreTypes.class);
	public static int metaCount = OreTypes.values().length;

	public BlockOre() {
		super(Material.ROCK);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(1.7F);
		this.setUnlocalizedName("ore");
		this.setRegistryName(ModInformation.ID, "ore");
		this.setDefaultState(getStateFromMeta(0));
	}
	
	@Override
	public SoundType getSoundType(IBlockState state, World world, BlockPos pos, @Nullable Entity entity) {
		switch (OreTypes.byMetadata(getMetaFromState(state))) {
			case ROTTEN_BONES: return SoundType.GROUND;
			default: return SoundType.STONE;
		}
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
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : RANDOM;

		switch(OreTypes.byMetadata(getMetaFromState(state))) {
		
			case ROTTEN_BONES:
				ItemStack rottenBonesStack = new ItemStack(Resources.resource, 1 + rand.nextInt(3), ItemResources.ResourceType.ROTTEN_BONES.toMeta());
				ItemStack boneStack = new ItemStack(Items.BONE, 1);
				ItemStack boneMealStack = new ItemStack(Items.DYE, 1 + rand.nextInt(3), EnumDyeColor.WHITE.getDyeDamage());
				ItemStack revenantFemurStack = new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REVENANT_FEMUR.toMeta());
				for (int i = 0; i < 2; i++) {
					double roll = rand.nextDouble() * 1.4D;
					if (roll <= 0.9D) {
						if (!drops.contains(rottenBonesStack)) drops.add(rottenBonesStack);
					} else if (roll <= 1.1D) {
						if (!drops.contains(boneStack)) drops.add(boneStack);
					} else if (roll <= 1.3D) {
						if (!drops.contains(boneMealStack)) drops.add(boneMealStack);
					} else {
						if (!drops.contains(revenantFemurStack)) drops.add(revenantFemurStack);
					}
				}
				break;
		
			default:
				int count = quantityDropped(state, fortune, rand);
				for (int i = 0; i < count; i++) {
					Item item = this.getItemDropped(state, rand, fortune);
					if (item != Items.AIR) {
						drops.add(new ItemStack(item, 1, this.damageDropped(state)));
					}
				}

		}
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = getMetaFromState(state);
		switch (OreTypes.byMetadata(meta)) {
			case LIGNITE: return ItemResources.ResourceType.LIGNITE.toMeta();
			case DOLOMITE: return ItemResources.ResourceType.DOLOMITE.toMeta();
			case ANTHRACITE: return ItemResources.ResourceType.ANTHRACITE.toMeta();
			case ABYSSAL: return ItemResources.ResourceType.ABYSSAL_ESSENCE.toMeta();
			default: return meta;
		}
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
	public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World worldIn, BlockPos pos) {
		if (!canHarvestBlock(worldIn, pos, player)) {
			return player.getDigSpeed(state, pos) / this.blockHardness / 100F;
		}
		return player.getDigSpeed(state, pos) / this.blockHardness / 30F;
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player) {
		ItemStack stack = player.getHeldItemMainhand();
		IBlockState state = world.getBlockState(pos);
		int toolLevel;
		switch (OreTypes.byMetadata(getMetaFromState(state))) {
			case ROTTEN_BONES:
				toolLevel = stack.getItem().getHarvestLevel(stack, "shovel", player, state);
				break;
			default: toolLevel = stack.getItem().getHarvestLevel(stack, "pickaxe", player, state);
		}
		if (stack.getItem().getRegistryName().getResourceDomain().equals(ModInformation.ID)) {
			toolLevel += 2;
		}
		return toolLevel >= OreTypes.byMetadata(getMetaFromState(state)).mineLevel;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		switch (OreTypes.byMetadata(getMetaFromState(state))) {
			case LIGNITE: return MathHelper.getInt(rand, 0, 2);
			case ANTHRACITE: return MathHelper.getInt(rand, 1, 3);
			case DOLOMITE:
			case ABYSSAL: return MathHelper.getInt(rand, 2, 5);
			default: return 0;
		}
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		switch (OreTypes.byMetadata(getMetaFromState(state))) {
			case LIGNITE:
			case DOLOMITE:
			case ANTHRACITE:
			case ABYSSAL:
				int i = random.nextInt(fortune + 2) - 1;
				if (i < 0) {
					i = 0;
				}
				return this.quantityDropped(random) * (i + 1);
			default: return this.quantityDropped(random);
		}
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		switch (OreTypes.byMetadata(getMetaFromState(state))) {
			case LIGNITE:
			case DOLOMITE:
			case ANTHRACITE:
			case ABYSSAL: return Resources.resource;
			default: return super.getItemDropped(state, rand, fortune);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
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
		HYLIASTRUM(11, "hyliastrum", MapColor.STONE, 6),
		ABYSSAL(12, "abyssal_essence", MapColor.STONE, 6),
		ROTTEN_BONES(13, "rotten_bones", MapColor.DIRT, 2);

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
		
		public int getMeta() {
			return meta;
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
