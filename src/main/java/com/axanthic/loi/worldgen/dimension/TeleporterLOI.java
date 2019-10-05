package com.axanthic.loi.worldgen.dimension;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

public class TeleporterLOI extends Teleporter {

	public TeleporterLOI(WorldServer worldServer) {
		super(worldServer);
	}

	@Override
	public void placeInPortal(@Nonnull Entity entity, float rotationYaw) {
		if (!this.placeInExistingPortal(entity, rotationYaw)) {
			this.makePortal(entity);
			this.placeInExistingPortal(entity, rotationYaw);
		}
	}

	@Override
	public boolean placeInExistingPortal(Entity entity, float rotationYaw) {
		final long chunkId = ChunkPos.asLong(MathHelper.floor(entity.posX), MathHelper.floor(entity.posZ));

		double distance = -1.0D;
		boolean doesPortalExist = true;
		BlockPos location = BlockPos.ORIGIN;

		if (this.destinationCoordinateCache.containsKey(chunkId)) {
			final PortalPosition portalPosition = this.destinationCoordinateCache.get(chunkId);
			distance = 0.0D;
			location = portalPosition;
			portalPosition.lastUpdateTime = this.world.getTotalWorldTime();
			doesPortalExist = false;
		} else {
			final BlockPos entityPos = new BlockPos(entity);
			for (int offsetX = -128; offsetX <= 128; ++offsetX) {
				BlockPos positionCache;

				for (int offsetZ = -128; offsetZ <= 128; ++offsetZ) {

					for (BlockPos currentPos = entityPos.add(offsetX, this.world.getActualHeight() - 1 - entityPos.getY(), offsetZ); currentPos.getY() >= 0; currentPos = positionCache) {
						positionCache = currentPos.down();
						if (this.world.getBlockState(currentPos).getBlock() == Resources.portal.getBlock()) {
							while (this.world.getBlockState(positionCache = currentPos.down()).getBlock() == Resources.portal.getBlock()) {
								currentPos = positionCache;
							}
							final double distanceToEntity = currentPos.distanceSq(entityPos);

							if (distance < 0.0D || distanceToEntity < distance) {
								distance = distanceToEntity;
								location = currentPos;
							}
						}
					}
				}
			}
		}

		if (distance >= 0.0D) {
			if (doesPortalExist) {
				this.destinationCoordinateCache.put(chunkId, new PortalPosition(location, this.world.getTotalWorldTime()));
			}

			double tpX = location.getX() + 0.5D;
			double tpY = location.getY() + 0.5D;
			double tpZ = location.getZ() + 0.5D;
			EnumFacing direction = null;

			if (this.world.getBlockState(location.west()).getBlock() == Resources.portal.getBlock()) {
				direction = EnumFacing.NORTH;
			}

			if (this.world.getBlockState(location.east()).getBlock() == Resources.portal.getBlock()) {
				direction = EnumFacing.SOUTH;
			}

			if (this.world.getBlockState(location.north()).getBlock() == Resources.portal.getBlock()) {
				direction = EnumFacing.EAST;
			}

			if (this.world.getBlockState(location.south()).getBlock() == Resources.portal.getBlock()) {
				direction = EnumFacing.WEST;
			}

			final EnumFacing enumfacing1 = EnumFacing.getHorizontal(MathHelper.floor(entity.rotationYaw * 4.0F / 360.0F + 0.5D) & 3);

			if (direction != null) {
				EnumFacing enumfacing2 = direction.rotateYCCW();
				final BlockPos blockpos2 = location.offset(direction);
				boolean flag2 = this.isInsideBlock(blockpos2);
				boolean flag3 = this.isInsideBlock(blockpos2.offset(enumfacing2));

				if (flag3 && flag2) {
					location = location.offset(enumfacing2);
					direction = direction.getOpposite();
					enumfacing2 = enumfacing2.getOpposite();
					final BlockPos blockpos3 = location.offset(direction);
					flag2 = this.isInsideBlock(blockpos3);
					flag3 = this.isInsideBlock(blockpos3.offset(enumfacing2));
				}

				float f6 = 0.5F;
				float f1 = 0.5F;

				if (!flag3 && flag2) {
					f6 = 1.0F;
				} else if (flag3 && !flag2) {
					f6 = 0.0F;
				} else if (flag3) {
					f1 = 0.0F;
				}

				tpX = location.getX() + 0.5D;
				tpY = location.getY() + 0.5D;
				tpZ = location.getZ() + 0.5D;
				tpX += enumfacing2.getFrontOffsetX() * f6 + direction.getFrontOffsetX() * f1;
				tpZ += enumfacing2.getFrontOffsetY() * f6 + direction.getFrontOffsetY() * f1;
				float f2 = 0.0F;
				float f3 = 0.0F;
				float f4 = 0.0F;
				float f5 = 0.0F;

				if (direction == enumfacing1) {
					f2 = 1.0F;
					f3 = 1.0F;
				} else if (direction == enumfacing1.getOpposite()) {
					f2 = -1.0F;
					f3 = -1.0F;
				} else if (direction == enumfacing1.rotateY()) {
					f4 = 1.0F;
					f5 = -1.0F;
				} else {
					f4 = -1.0F;
					f5 = 1.0F;
				}

				final double d2 = entity.motionX;
				final double d3 = entity.motionZ;
				entity.motionX = d2 * f2 + d3 * f5;
				entity.motionZ = d2 * f4 + d3 * f3;
				entity.rotationYaw = rotationYaw - enumfacing1.getHorizontalIndex() * 90 + direction.getHorizontalIndex() * 90;
			} else {
				entity.motionX = entity.motionY = entity.motionZ = 0.0D;
			}
			entity.setLocationAndAngles(tpX, tpY, tpZ, entity.rotationYaw, entity.rotationPitch);
			return true;
		} else {
			return false;
		}
	}

	private boolean isInsideBlock(BlockPos position) {
		return !this.world.isAirBlock(position) || !this.world.isAirBlock(position.up());
	}

	@Override
	public boolean makePortal(Entity entity) {
		return createPortal(this.world, new BlockPos(MathHelper.floor(entity.posX), MathHelper.floor(entity.posY), MathHelper.floor(entity.posZ)), entity);
	}

	public static boolean createPortal(World world, BlockPos pos, @Nullable Entity entity) {
		IBlockState portalState = Resources.portal.getBlock().getDefaultState();
		IBlockState vaseState = Resources.grainelStone.getBlock().getStateFromMeta(1);

		while (pos.getY() > 1 && world.isAirBlock(pos)) {
			pos = pos.down();
		}

		while (!world.isAirBlock(pos.up()) && (world.getBlockState(pos).getBlock() != Resources.grass.getBlock() || world.getBlockState(pos).getBlock() != Blocks.GRASS)) {
			pos = pos.up();
		}

		for (BlockPos.MutableBlockPos basePos : BlockPos.MutableBlockPos.getAllInBoxMutable(pos.add(-1, 0, -1), pos.add(1, 2, 1))) {
			world.setBlockState(basePos, vaseState, 2);
		}

		world.setBlockState(pos.up(2), portalState, 2);

		world.setBlockState(pos.up(3), Blocks.AIR.getDefaultState(), 2);
		world.setBlockState(pos.up(4), Blocks.AIR.getDefaultState(), 2);

		return true;
	}
}