package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCustomSlab extends BlockSlab implements IBlockMaterial{

	public static final PropertyBool DOUBLE = PropertyBool.create("double");;
	public String name;
	public Block modelBlock;
	public IBlockState modelState;

	public BlockCustomSlab(IBlockState modelState, String name) {
		super(modelState.getBlock().getMaterial(modelState), modelState.getBlock().getMapColor(modelState, null, null));
		this.name = name;
		this.modelBlock = modelState.getBlock();
		this.modelState = modelState;
        this.setLightOpacity(0);
		this.setCreativeTab(modelBlock.getCreativeTabToDisplayOn());
		this.setUnlocalizedName("slab");
		this.setHardness(modelState.getBlock().getBlockHardness(modelState, null, null));
		this.setResistance(modelState.getBlock().getExplosionResistance(null));
		this.setSoundType(modelState.getBlock().getSoundType());
		this.setDefaultState(this.blockState.getBaseState().withProperty(HALF, EnumBlockHalf.BOTTOM).withProperty(DOUBLE, false));
		if (modelBlock instanceof IBlockMaterial)
			this.setRegistryName(ModInformation.ID, "slab_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMaterial) modelBlock).getName());
		else if (modelBlock instanceof IBlockMeta)
			this.setRegistryName(ModInformation.ID, "slab_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMeta) modelBlock).getNameForMeta(modelBlock.getMetaFromState(modelState)));
		else
			this.setRegistryName(ModInformation.ID, "slab_" + modelState.getBlock().getRegistryName().getResourcePath());
	}

	@Override
	public String getName() {
		if (name == null)
			return new ItemStack(modelBlock, 1, modelBlock.getMetaFromState(modelState)).getDisplayName();
		return name;
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFlammability(world, pos, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFireSpreadSpeed(world, pos, face);
	}

	@Override
	protected boolean canSilkHarvest() {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if (state.getValue(DOUBLE))
			return FULL_BLOCK_AABB;
		else
			return state.getValue(HALF) == EnumBlockHalf.TOP ? AABB_TOP_HALF : AABB_BOTTOM_HALF;
	}

	@Override
	public boolean isTopSolid(IBlockState state) {
		return state.getValue(DOUBLE) || state.getValue(HALF) == EnumBlockHalf.TOP;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		if (state.getValue(DOUBLE))
			return BlockFaceShape.SOLID;
		else if (face == EnumFacing.UP && state.getValue(HALF) == EnumBlockHalf.TOP)
			return BlockFaceShape.SOLID;
		else
			return face == EnumFacing.DOWN && state.getValue(HALF) == EnumBlockHalf.BOTTOM ? BlockFaceShape.SOLID : BlockFaceShape.UNDEFINED;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return state.getValue(DOUBLE);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return state.getValue(DOUBLE);
	}

	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
		if (net.minecraftforge.common.ForgeModContainer.disableStairSlabCulling)
			return super.doesSideBlockRendering(state, world, pos, face);

		if (isOpaqueCube(state))
			return true;

		EnumBlockHalf side = state.getValue(HALF);
		return (side == EnumBlockHalf.TOP && face == EnumFacing.UP) || (side == EnumBlockHalf.BOTTOM && face == EnumFacing.DOWN);
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		IBlockState iblockstate = super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(DOUBLE, false);

		return facing != EnumFacing.DOWN && (facing == EnumFacing.UP || (double)hitY <= 0.5D) ? iblockstate.withProperty(HALF, EnumBlockHalf.BOTTOM) : iblockstate.withProperty(HALF, EnumBlockHalf.TOP);
	}

	@Override
	public int quantityDropped(IBlockState state, int fortune, Random random) {
		return state.getValue(DOUBLE) ? 2 : 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
		if ((Boolean) blockState.getValue(DOUBLE))
			return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
		else if (side != EnumFacing.UP && side != EnumFacing.DOWN && !super.shouldSideBeRendered(blockState, blockAccess, pos, side))
			return false;
		return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		IBlockState iblockstate = this.getDefaultState().withProperty(DOUBLE, false);

		if (meta == 2)
			return iblockstate.withProperty(DOUBLE, true).withProperty(HALF, EnumBlockHalf.TOP);
		else if (meta == 1)
			return iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);

		return iblockstate.withProperty(HALF, EnumBlockHalf.TOP);
	}

	@Override
	public int getMetaFromState(IBlockState state){

		if (state.getValue(DOUBLE))
			return 2;
		else if (state.getValue(HALF) == BlockSlab.EnumBlockHalf.BOTTOM)
			return 1;

		return 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {HALF, DOUBLE});
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}

	@Override
	public boolean isDouble() {
		return false;
	}

	@Override
	public IProperty<?> getVariantProperty() {
		return null;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return null;
	}
}
