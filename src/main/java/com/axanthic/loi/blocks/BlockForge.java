package com.axanthic.loi.blocks;

import java.util.Random;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.gui.GuiHandlerLOI;
import com.axanthic.loi.tileentity.TileEntityForge;
import com.axanthic.loi.tileentity.TileEntityForgeRedirector;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockForge extends BlockContainer {

	public static final AxisAlignedBB TOP_BACK_LEFT = new AxisAlignedBB(0.125, 0, 0.125, 1, 1, 1);
	public static final AxisAlignedBB TOP_BACK_RIGHT = new AxisAlignedBB(0, 0, 0.125, 0.875, 1, 1);
	public static final AxisAlignedBB TOP_FRONT_LEFT = new AxisAlignedBB(0.1875, 0.375, 0, 0.8125, 1, 0.8125);
	public static final AxisAlignedBB TOP_FRONT_RIGHT = new AxisAlignedBB(0, 0, 0, 0.75, 1, 0.375);
	public static final AxisAlignedBB BOTTOM_BACK_LEFT = new AxisAlignedBB(0.0625, 0, 0.0625, 1, 1, 1);
	public static final AxisAlignedBB BOTTOM_BACK_RIGHT = new AxisAlignedBB(0, 0, 0.0625, 0.9375, 1, 1);
	public static final AxisAlignedBB BOTTOM_FRONT_LEFT = new AxisAlignedBB(0.0625, 0, 0, 1, 0.875, 0.9375);
	public static final AxisAlignedBB BOTTOM_FRONT_RIGHT = new AxisAlignedBB(0, 0, 0, 0.9375, 0.875, 0.9375);
	public static final AxisAlignedBB[] TOP_BACK_LEFT_ARRAY = getRotatedAABBArray(TOP_BACK_LEFT);
	public static final AxisAlignedBB[] TOP_BACK_RIGHT_ARRAY = getRotatedAABBArray(TOP_BACK_RIGHT);
	public static final AxisAlignedBB[] TOP_FRONT_LEFT_ARRAY = getRotatedAABBArray(TOP_FRONT_LEFT);
	public static final AxisAlignedBB[] TOP_FRONT_RIGHT_ARRAY = getRotatedAABBArray(TOP_FRONT_RIGHT);
	public static final AxisAlignedBB[] BOTTOM_BACK_LEFT_ARRAY = getRotatedAABBArray(BOTTOM_BACK_LEFT);
	public static final AxisAlignedBB[] BOTTOM_BACK_RIGHT_ARRAY = getRotatedAABBArray(BOTTOM_BACK_RIGHT);
	public static final AxisAlignedBB[] BOTTOM_FRONT_LEFT_ARRAY = getRotatedAABBArray(BOTTOM_FRONT_LEFT);
	public static final AxisAlignedBB[] BOTTOM_FRONT_RIGHT_ARRAY = getRotatedAABBArray(BOTTOM_FRONT_RIGHT);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyEnum CORNER = PropertyEnum.create("corner", EnumCorner.class);
	public static final PropertyBool BURNING = PropertyBool.create("burning");

	public BlockForge() {
		super(Material.ROCK, MapColor.DIRT);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(1.3F);
		this.setUnlocalizedName("crafting_forge");
		this.setRegistryName(ModInformation.ID, "crafting_forge");
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, false).withProperty(CORNER, EnumCorner.BOTTOM_FRONT_LEFT));
		this.setSoundType(SoundType.STONE);
	}

	public static AxisAlignedBB[] getRotatedAABBArray(AxisAlignedBB box) {
		return new AxisAlignedBB[] {
				new AxisAlignedBB(1-box.maxX, box.minY, 1-box.maxZ, 1-box.minX, box.maxY, 1-box.minZ),
				new AxisAlignedBB(box.minZ, box.minY, 1-box.maxX, box.maxZ, box.maxY, 1-box.minX),
				box,
				new AxisAlignedBB(1-box.maxZ, box.minY, box.minX, 1-box.minZ, box.maxY, box.maxX)};
	}

	/*public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor){
		if (world.getTileEntity(pos) instanceof TileEntityForge) {
			((TileEntityForge) world.getTileEntity(pos)).setNeighbours(pos);
		}
	}*/

	public void setState(IBlockState state, World worldIn, BlockPos pos) {
		state = getActualState(state, worldIn, pos);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		worldIn.setBlockState(pos, state, 3);
		worldIn.setBlockState(pos, state, 3);
		if (tileentity != null) {
			tileentity.validate();
			worldIn.setTileEntity(pos, tileentity);
		}
		worldIn.setBlockState(pos.offset(facing), state.withProperty(CORNER, EnumCorner.BOTTOM_BACK_LEFT), 3);
		worldIn.setBlockState(pos.offset(facing).offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.BOTTOM_BACK_RIGHT), 3);
		worldIn.setBlockState(pos.offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.BOTTOM_FRONT_RIGHT), 3);
		worldIn.setBlockState(pos.offset(EnumFacing.UP), state.withProperty(CORNER, EnumCorner.TOP_FRONT_LEFT), 3);
		worldIn.setBlockState(pos.offset(EnumFacing.UP).offset(facing), state.withProperty(CORNER, EnumCorner.TOP_BACK_LEFT), 3);
		worldIn.setBlockState(pos.offset(EnumFacing.UP).offset(facing).offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.TOP_BACK_RIGHT), 3);
		worldIn.setBlockState(pos.offset(EnumFacing.UP).offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.TOP_FRONT_RIGHT), 3);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public int getLightValue(IBlockState state) {
		if (((Boolean) state.getValue(BURNING)))
			return 13;
		return 0;
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
		state = getActualState(state, source, pos);
		EnumCorner corner = (EnumCorner) state.getValue(CORNER);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		switch (corner) {
		case TOP_BACK_LEFT:
			return TOP_BACK_LEFT_ARRAY[facing.getHorizontalIndex()];
		case TOP_BACK_RIGHT:
			return TOP_BACK_RIGHT_ARRAY[facing.getHorizontalIndex()];
		case TOP_FRONT_LEFT:
			return TOP_FRONT_LEFT_ARRAY[facing.getHorizontalIndex()];
		case TOP_FRONT_RIGHT:
			return TOP_FRONT_RIGHT_ARRAY[facing.getHorizontalIndex()];
		case BOTTOM_BACK_LEFT:
			return BOTTOM_BACK_LEFT_ARRAY[facing.getHorizontalIndex()];
		case BOTTOM_BACK_RIGHT:
			return BOTTOM_BACK_RIGHT_ARRAY[facing.getHorizontalIndex()];
		case BOTTOM_FRONT_LEFT:
			return BOTTOM_FRONT_LEFT_ARRAY[facing.getHorizontalIndex()];
		case BOTTOM_FRONT_RIGHT:
			return BOTTOM_FRONT_RIGHT_ARRAY[facing.getHorizontalIndex()];
		}
		return BOTTOM_FRONT_RIGHT;
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.getBlockState(pos).getBlock() instanceof BlockForge)
			return;
		if (((EnumFacing) state.getValue(FACING)) == EnumFacing.NORTH)
			state = getActualState(state, worldIn, pos);

		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		TileEntity tileentity = worldIn.getTileEntity(pos);
		BlockPos pos2 = getTileLocation(pos, state);
		if (tileentity instanceof TileEntityForgeRedirector) {
			TileEntity tileentityOrigin = worldIn.getTileEntity(pos2);
			if (tileentityOrigin instanceof TileEntityForge) {
				InventoryHelper.dropInventoryItems(worldIn, pos, ((TileEntityForge) tileentityOrigin).forgeInventory);
				worldIn.destroyBlock(pos2, false);
			}
		} else if (tileentity instanceof TileEntityForge) {
			InventoryHelper.dropInventoryItems(worldIn, pos, ((TileEntityForge) tileentity).forgeInventory);
			worldIn.destroyBlock(pos.offset(facing), false);
			worldIn.destroyBlock(pos.offset(facing).offset(facing.rotateY()), false);
			worldIn.destroyBlock(pos.offset(facing.rotateY()), false);
			worldIn.destroyBlock(pos.offset(EnumFacing.UP), false);
			worldIn.destroyBlock(pos.offset(EnumFacing.UP).offset(facing), false);
			worldIn.destroyBlock(pos.offset(EnumFacing.UP).offset(facing).offset(facing.rotateY()), false);
			worldIn.destroyBlock(pos.offset(EnumFacing.UP).offset(facing.rotateY()), false);
		} else {
			worldIn.destroyBlock(pos2, false);
		}
		worldIn.updateComparatorOutputLevel(pos, this);

		super.breakBlock(worldIn, pos, state);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		if (stack.hasDisplayName()) {
			TileEntity tileentity = worldIn.getTileEntity(pos);
			if (tileentity instanceof TileEntityForge)
				((TileEntityForge)tileentity).setCustomInventoryName(stack.getDisplayName());
		}
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		worldIn.setBlockState(pos.offset(facing), state.withProperty(CORNER, EnumCorner.BOTTOM_BACK_LEFT));
		worldIn.setBlockState(pos.offset(facing).offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.BOTTOM_BACK_RIGHT));
		worldIn.setBlockState(pos.offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.BOTTOM_FRONT_RIGHT));
		pos = pos.offset(EnumFacing.UP);
		worldIn.setBlockState(pos, state.withProperty(CORNER, EnumCorner.TOP_FRONT_LEFT));
		worldIn.setBlockState(pos.offset(facing), state.withProperty(CORNER, EnumCorner.TOP_BACK_LEFT));
		worldIn.setBlockState(pos.offset(facing).offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.TOP_BACK_RIGHT));
		worldIn.setBlockState(pos.offset(facing.rotateY()), state.withProperty(CORNER, EnumCorner.TOP_FRONT_RIGHT));
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		stateIn = getActualState(stateIn, worldIn, pos);
		BlockPos pos2 = getTileLocation(pos, stateIn);
		if (((Boolean) stateIn.getValue(BURNING))) {
			if (rand.nextDouble() < 0.1D) {
				worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_FIRE_AMBIENT, SoundCategory.BLOCKS, 1.0F, 1.0F, false);
			}
			EnumFacing facing = (EnumFacing) stateIn.getValue(FACING);
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, (double) pos2.getX() + 0.5D + facing.getFrontOffsetX() / 2.0 + facing.rotateY().getFrontOffsetX() / 2.0 + rand.nextDouble() * 4.0D / 16.0D - 2.0D / 16.0D, (double) pos2.getY() + rand.nextDouble() * 2.0D / 16.0D + 30.0D / 16.0D, pos2.getZ() + 0.5D + facing.getFrontOffsetZ() / 2.0 + facing.rotateY().getFrontOffsetZ() / 2.0 + rand.nextDouble() * 4.0D / 16.0D - 2.0D / 16.0D, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing face, float hitX, float hitY, float hitZ) {
		if (worldIn.isRemote)
			return true;
		state = getActualState(state, worldIn, pos);
		pos = getTileLocation(pos, state);
		playerIn.openGui(LandsOfIcaria.instance, GuiHandlerLOI.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	public static BlockPos getTileLocation(BlockPos pos, IBlockState state) {
		EnumCorner corner = (EnumCorner) state.getValue(CORNER);
		EnumFacing facing = (EnumFacing) state.getValue(FACING);
		if (corner == EnumCorner.TOP_BACK_LEFT || corner == EnumCorner.TOP_BACK_RIGHT || corner == EnumCorner.TOP_FRONT_LEFT || corner == EnumCorner.TOP_FRONT_RIGHT)
			pos = pos.offset(EnumFacing.DOWN);
		if (corner == EnumCorner.BOTTOM_BACK_LEFT || corner == EnumCorner.BOTTOM_BACK_RIGHT || corner == EnumCorner.TOP_BACK_LEFT || corner == EnumCorner.TOP_BACK_RIGHT)
			pos = pos.offset(facing.getOpposite());
		if (corner == EnumCorner.BOTTOM_BACK_RIGHT || corner == EnumCorner.BOTTOM_FRONT_RIGHT || corner == EnumCorner.TOP_BACK_RIGHT || corner == EnumCorner.TOP_FRONT_RIGHT)
			pos = pos.offset(facing.rotateY().getOpposite());
		return pos;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		if (meta == 6 || meta == 14)
			return new TileEntityForge();
		return new TileEntityForgeRedirector();
	}

	@Override
	public boolean hasComparatorInputOverride(IBlockState state) {
		return true;
	}

	@Override
	public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
		return Container.calcRedstone(worldIn.getTileEntity(this.getTileLocation(pos, blockState)));
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		boolean burning = false;
		if (meta > 7) {
			burning = true;
			meta = meta - 8;
		}
		return this.getDefaultState().withProperty(CORNER, EnumCorner.fromIndex(meta)).withProperty(BURNING, burning);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		EnumFacing facing = EnumFacing.NORTH;
		EnumCorner cornerNorth = null;
		EnumCorner cornerEast = null;
		EnumCorner cornerSouth = null;
		EnumCorner cornerWest = null;
		if (worldIn.getBlockState(pos.north()).getProperties().containsKey(CORNER))
			cornerNorth = (EnumCorner) worldIn.getBlockState(pos.north()).getValue(CORNER);
		if (worldIn.getBlockState(pos.east()).getProperties().containsKey(CORNER))
			cornerEast = (EnumCorner) worldIn.getBlockState(pos.east()).getValue(CORNER);
		if (worldIn.getBlockState(pos.south()).getProperties().containsKey(CORNER))
			cornerSouth = (EnumCorner) worldIn.getBlockState(pos.south()).getValue(CORNER);
		if (worldIn.getBlockState(pos.west()).getProperties().containsKey(CORNER))
			cornerWest = (EnumCorner) worldIn.getBlockState(pos.west()).getValue(CORNER);
		EnumCorner corner = (EnumCorner) state.getValue(CORNER);
		switch (corner) {
		case TOP_BACK_LEFT:
			if(cornerSouth == EnumCorner.TOP_BACK_RIGHT && cornerWest == EnumCorner.TOP_FRONT_LEFT)
				facing = EnumFacing.EAST;
			if(cornerWest == EnumCorner.TOP_BACK_RIGHT && cornerNorth == EnumCorner.TOP_FRONT_LEFT)
				facing = EnumFacing.SOUTH;
			if(cornerNorth == EnumCorner.TOP_BACK_RIGHT && cornerEast == EnumCorner.TOP_FRONT_LEFT)
				facing = EnumFacing.WEST;
			break;
		case TOP_BACK_RIGHT:
			if(cornerNorth == EnumCorner.TOP_BACK_LEFT && cornerWest == EnumCorner.TOP_FRONT_RIGHT)
				facing = EnumFacing.EAST;
			if(cornerEast == EnumCorner.TOP_BACK_LEFT && cornerNorth == EnumCorner.TOP_FRONT_RIGHT)
				facing = EnumFacing.SOUTH;
			if(cornerSouth == EnumCorner.TOP_BACK_LEFT && cornerEast == EnumCorner.TOP_FRONT_RIGHT)
				facing = EnumFacing.WEST;
			break;
		case TOP_FRONT_LEFT:
			if(cornerEast == EnumCorner.TOP_BACK_LEFT && cornerSouth == EnumCorner.TOP_FRONT_RIGHT)
				facing = EnumFacing.EAST;
			if(cornerSouth == EnumCorner.TOP_BACK_LEFT && cornerWest == EnumCorner.TOP_FRONT_RIGHT)
				facing = EnumFacing.SOUTH;
			if(cornerWest == EnumCorner.TOP_BACK_LEFT && cornerNorth == EnumCorner.TOP_FRONT_RIGHT)
				facing = EnumFacing.WEST;
			break;
		case TOP_FRONT_RIGHT:
			if(cornerEast == EnumCorner.TOP_BACK_RIGHT && cornerNorth == EnumCorner.TOP_FRONT_LEFT)
				facing = EnumFacing.EAST;
			if(cornerSouth == EnumCorner.TOP_BACK_RIGHT && cornerEast == EnumCorner.TOP_FRONT_LEFT)
				facing = EnumFacing.SOUTH;
			if(cornerWest == EnumCorner.TOP_BACK_RIGHT && cornerSouth == EnumCorner.TOP_FRONT_LEFT)
				facing = EnumFacing.WEST;
			break;
		case BOTTOM_BACK_LEFT:
			if(cornerSouth == EnumCorner.BOTTOM_BACK_RIGHT && cornerWest == EnumCorner.BOTTOM_FRONT_LEFT)
				facing = EnumFacing.EAST;
			if(cornerWest == EnumCorner.BOTTOM_BACK_RIGHT && cornerNorth == EnumCorner.BOTTOM_FRONT_LEFT)
				facing = EnumFacing.SOUTH;
			if(cornerNorth == EnumCorner.BOTTOM_BACK_RIGHT && cornerEast == EnumCorner.BOTTOM_FRONT_LEFT)
				facing = EnumFacing.WEST;
			break;
		case BOTTOM_BACK_RIGHT:
			if(cornerNorth == EnumCorner.BOTTOM_BACK_LEFT && cornerWest == EnumCorner.BOTTOM_FRONT_RIGHT)
				facing = EnumFacing.EAST;
			if(cornerEast == EnumCorner.BOTTOM_BACK_LEFT && cornerNorth == EnumCorner.BOTTOM_FRONT_RIGHT)
				facing = EnumFacing.SOUTH;
			if(cornerSouth == EnumCorner.BOTTOM_BACK_LEFT && cornerEast == EnumCorner.BOTTOM_FRONT_RIGHT)
				facing = EnumFacing.WEST;
			break;
		case BOTTOM_FRONT_LEFT:
			if(cornerEast == EnumCorner.BOTTOM_BACK_LEFT && cornerSouth == EnumCorner.BOTTOM_FRONT_RIGHT)
				facing = EnumFacing.EAST;
			if(cornerSouth == EnumCorner.BOTTOM_BACK_LEFT && cornerWest == EnumCorner.BOTTOM_FRONT_RIGHT)
				facing = EnumFacing.SOUTH;
			if(cornerWest == EnumCorner.BOTTOM_BACK_LEFT && cornerNorth == EnumCorner.BOTTOM_FRONT_RIGHT)
				facing = EnumFacing.WEST;
			break;
		case BOTTOM_FRONT_RIGHT:
			if(cornerEast == EnumCorner.BOTTOM_BACK_RIGHT && cornerNorth == EnumCorner.BOTTOM_FRONT_LEFT)
				facing = EnumFacing.EAST;
			if(cornerSouth == EnumCorner.BOTTOM_BACK_RIGHT && cornerEast == EnumCorner.BOTTOM_FRONT_LEFT)
				facing = EnumFacing.SOUTH;
			if(cornerWest == EnumCorner.BOTTOM_BACK_RIGHT && cornerSouth == EnumCorner.BOTTOM_FRONT_LEFT)
				facing = EnumFacing.WEST;
			break;
		}
		return state.withProperty(FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		if (((Boolean)state.getValue(BURNING)))
			return ((EnumCorner)state.getValue(CORNER)).getIndex() + 8;
		return ((EnumCorner)state.getValue(CORNER)).getIndex();
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) {
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
		if (mirrorIn == Mirror.LEFT_RIGHT)
			return state.withProperty(CORNER, ((EnumCorner) state.getValue(CORNER)).getMirror(mirrorIn));
		if (mirrorIn == Mirror.FRONT_BACK)
			return this.withRotation(state.withProperty(CORNER, ((EnumCorner) state.getValue(CORNER)).getMirror(mirrorIn)), Rotation.CLOCKWISE_180);
		return state;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {CORNER, FACING, BURNING});
	}

	public enum EnumCorner implements IStringSerializable {//as viewed from the front
		TOP_BACK_LEFT(0),
		TOP_BACK_RIGHT(1),
		TOP_FRONT_LEFT(2),
		TOP_FRONT_RIGHT(3),
		BOTTOM_BACK_LEFT(4),
		BOTTOM_BACK_RIGHT(5),
		BOTTOM_FRONT_LEFT(6), //location of tile entity
		BOTTOM_FRONT_RIGHT(7);

		private static final EnumCorner[] META_LOOKUP = new EnumCorner[EnumCorner.values().length];
		private final int index;

		EnumCorner(final int indexIn) {
			this.index = indexIn;
		}

		public static EnumCorner fromIndex(int index) {
			if ((index < 0) || (index >= EnumCorner.META_LOOKUP.length)) {
				index = 0;
			}
			return EnumCorner.META_LOOKUP[index];
		}

		@Override
		public String getName() {
			return this.name().toLowerCase();
		}

		public int getIndex() {
			return this.index;
		}

		public EnumCorner getMirror(Mirror mirror) {
			if (mirror == Mirror.LEFT_RIGHT) {
				switch (this) {
				case TOP_BACK_LEFT: return TOP_BACK_RIGHT;
				case TOP_BACK_RIGHT: return TOP_BACK_LEFT;
				case TOP_FRONT_LEFT: return TOP_FRONT_RIGHT;
				case TOP_FRONT_RIGHT: return TOP_FRONT_LEFT;
				case BOTTOM_BACK_LEFT: return BOTTOM_BACK_RIGHT;
				case BOTTOM_BACK_RIGHT: return BOTTOM_BACK_LEFT;
				case BOTTOM_FRONT_LEFT: return BOTTOM_FRONT_RIGHT;
				case BOTTOM_FRONT_RIGHT: return BOTTOM_FRONT_LEFT;
				}
			} else if (mirror == Mirror.FRONT_BACK) {
				switch (this) {
				case TOP_BACK_LEFT: return TOP_FRONT_LEFT;
				case TOP_BACK_RIGHT: return TOP_FRONT_RIGHT;
				case TOP_FRONT_LEFT: return TOP_BACK_LEFT;
				case TOP_FRONT_RIGHT: return TOP_BACK_RIGHT;
				case BOTTOM_BACK_LEFT: return BOTTOM_FRONT_LEFT;
				case BOTTOM_BACK_RIGHT: return BOTTOM_FRONT_RIGHT;
				case BOTTOM_FRONT_LEFT: return BOTTOM_BACK_LEFT;
				case BOTTOM_FRONT_RIGHT: return BOTTOM_BACK_RIGHT;
				}
			}
			return this;
		}

		public boolean isBottom() {
			return this == BOTTOM_BACK_LEFT || this == BOTTOM_BACK_RIGHT || this == BOTTOM_FRONT_LEFT || this == BOTTOM_FRONT_RIGHT;
		}

		public boolean isRight() {
			return this == TOP_BACK_RIGHT || this == TOP_FRONT_RIGHT || this == BOTTOM_BACK_RIGHT || this == BOTTOM_FRONT_RIGHT;
		}

		public boolean isBack() {
			return this == TOP_BACK_LEFT || this == TOP_BACK_RIGHT || this == BOTTOM_BACK_LEFT || this == BOTTOM_BACK_RIGHT;
		}

		public static String[] getNames() {
			final String[] names = new String[EnumCorner.META_LOOKUP.length];
			for (int i = 0; i < EnumCorner.META_LOOKUP.length; i++) {
				names[i] = EnumCorner.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final EnumCorner corner : EnumCorner.values()) {
				EnumCorner.META_LOOKUP[corner.index] = corner;
			}
		}
	}
}
