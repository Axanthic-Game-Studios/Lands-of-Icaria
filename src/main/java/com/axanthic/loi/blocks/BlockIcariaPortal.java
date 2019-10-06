package com.axanthic.loi.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.worldgen.dimension.TeleporterLOI;

import java.util.Random;

public class BlockIcariaPortal extends BlockBreakable {

	public BlockIcariaPortal() {
		super(Material.PORTAL, false);
		this.setTickRandomly(true);
		this.setHardness(-1.0F);
		this.setSoundType(SoundType.GLASS);
		this.setLightLevel(0.35F);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setUnlocalizedName("icaria_portal");
		this.setRegistryName(ModInformation.ID, "icaria_portal");
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, @Nonnull IBlockAccess world, @Nonnull BlockPos pos) {
		return NULL_AABB;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos neighborPos) {
		
	}

	@Override
	public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
		if (!entity.isRiding() && !entity.isBeingRidden() && entity instanceof EntityPlayerMP && entity.timeUntilPortal <= 0) {
			EntityPlayerMP player = (EntityPlayerMP) entity;
			final int dimension = player.dimension == LandsOfIcaria.dimensionId ? DimensionType.OVERWORLD.getId() : LandsOfIcaria.dimensionId;
			changeDimension(world, (EntityPlayerMP) entity, dimension, new TeleporterLOI(player.mcServer.getWorld(dimension)));
		}
	}

	public static void changeDimension(World world, EntityPlayerMP player, int dimension, ITeleporter teleporter) {
		if (!world.isRemote) {
			player.changeDimension(dimension, teleporter);
			player.timeUntilPortal = 300;
			if (player.dimension == LandsOfIcaria.dimensionId) {
				BlockPos playerPos = new BlockPos(player);
				if (world.isAirBlock(playerPos) && world.getBlockState(playerPos).isSideSolid(world, playerPos, EnumFacing.UP)) {
					player.setSpawnChunk(playerPos, true, LandsOfIcaria.dimensionId);
				}
			}
		}
	}

	@Override
	@Nonnull
	public BlockFaceShape getBlockFaceShape(IBlockAccess world, IBlockState state, BlockPos pos, EnumFacing face) {
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public int quantityDropped(Random random) {
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	@Nonnull
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
}