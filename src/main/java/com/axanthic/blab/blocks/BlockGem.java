package com.axanthic.blab.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ConfigHandler;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources;
import com.axanthic.blab.proxy.CommonProxy;
import com.axanthic.blab.utils.TileEntityColoredLight;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGem extends BlockSixDirectional implements ITileEntityProvider {

	private String unlocalizedName;
	public static final AxisAlignedBB GEM_AABB = new AxisAlignedBB(0.49D, 0.51D, 0.49D, 0.51D, 0.49D, 0.51D);
	public static final AxisAlignedBB NOTHING_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

	public BlockGem(String name) {
		super(Material.GLASS, MapColor.AIR);
		this.setCreativeTab(Blab.modTabBlocks);
		this.setHardness(1.2F);
		this.fullBlock = false;
		this.setLightOpacity(0);
		this.translucent = true;
		this.setUnlocalizedName(name);
		unlocalizedName = name;
		if (!ConfigHandler.albedo)
			this.setLightLevel(1.0F);
		this.setRegistryName(ModInformation.ID, name);
		this.setSoundType(SoundType.GLASS);
		this.hasTileEntity = ConfigHandler.albedo;
	}

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return ConfigHandler.albedo;
	}

	@Nullable
	public TileEntity createTileEntity(World world, IBlockState state) {
		if (unlocalizedName.equals("calcite"))
			return new TileEntityColoredLight(1.0F, 0.714F, 0.557F);
		if (unlocalizedName.equals("jasper"))
			return new TileEntityColoredLight(1.0F, 0.318F, 0.396F);
		if (unlocalizedName.equals("zircon"))
			return new TileEntityColoredLight(0.361F, 0.467F, 1.0F);
		return new TileEntityColoredLight();
	}

	@Override
	public String getUnlocalizedName() {
		return "material." + unlocalizedName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	@Nullable
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return GEM_AABB;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return NOTHING_AABB;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Resources.resource;
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (unlocalizedName.equals("jasper")) {
			return 6;
		} else if (unlocalizedName.equals("zircon")) {
			return 7;
		} else {
			return 5;
		}
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
		for (EnumFacing enumfacing : FACING.getAllowedValues()) {
			if (this.canPlaceAt(worldIn, pos, enumfacing)) {
				return true;
			}
		}
		return false;
	}

	public boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing) {
		BlockPos blockpos = pos.offset(facing.getOpposite());
		IBlockState iblockstate = worldIn.getBlockState(blockpos);
		Block block = iblockstate.getBlock();
		BlockFaceShape blockfaceshape = iblockstate.getBlockFaceShape(worldIn, blockpos, facing);

		return !isExceptBlockForAttachWithPiston(block) && blockfaceshape == BlockFaceShape.SOLID;
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		this.checkForDrop(worldIn, pos, state);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		this.checkForDrop(worldIn, pos, state);
	}

	public boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state) {
		if (state.getBlock() == this && this.canPlaceAt(worldIn, pos, (EnumFacing)state.getValue(FACING))) {
			return true;
		}
		if (worldIn.getBlockState(pos).getBlock() == this) {
			worldIn.destroyBlock(pos, true);
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return this.createTileEntity(worldIn, null);
	}
}
