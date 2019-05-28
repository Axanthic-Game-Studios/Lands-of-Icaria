package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.gui.GuiHandlerBlab;
import com.axanthic.blab.utils.TileEntityGrinder;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGrinder extends BlockContainer {

	protected static final AxisAlignedBB GRINDER_AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.875D, 0.9375D);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool BURNING = PropertyBool.create("burning");
	private static boolean keepInventory = false;

	public BlockGrinder() {
		super(Material.ROCK, MapColor.WOOD);
		this.setCreativeTab(Blab.modTabBlocks);
		this.setHardness(1.3F);
		this.setUnlocalizedName("crafting_grinder");
		this.setRegistryName(ModInformation.ID, "crafting_grinder");
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, false));
		this.setSoundType(SoundType.STONE);
	}

	public static void setState(IBlockState state, World worldIn, BlockPos pos) {
		TileEntity tileentity = worldIn.getTileEntity(pos);
		keepInventory = true;
		worldIn.setBlockState(pos, state, 3);
		worldIn.setBlockState(pos, state, 3);
		keepInventory = false;

		if (tileentity != null) {
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return GRINDER_AABB;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (keepInventory)
			return;

		TileEntity tileentity = worldIn.getTileEntity(pos);

		if (tileentity instanceof IInventory) {
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory)tileentity);
			worldIn.updateComparatorOutputLevel(pos, this);
		}
		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote) {
			return true;
		} else {
			playerIn.openGui(Blab.instance, GuiHandlerBlab.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());;
			return true;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityGrinder();
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityGrinder)
				((TileEntityGrinder)tileentity).setCustomInventoryName(stack.getDisplayName());
		}
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(pos));
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		if (face.equals(EnumFacing.DOWN))
			return BlockFaceShape.CENTER;
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean burning = false;
		if (meta > 3) {
			burning = true;
			meta = meta - 4;
		}
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta);
		return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(BURNING, burning);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (((Boolean)state.getValue(BURNING)))
			return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex() + 4;
		return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {FACING, BURNING});
	}
}
