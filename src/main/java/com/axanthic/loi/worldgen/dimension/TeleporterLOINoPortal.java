package com.axanthic.loi.worldgen.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

public class TeleporterLOINoPortal implements ITeleporter {

	@Override
	public void placeEntity(World world, Entity entity, float yaw) {
		BlockPos spawn = findPosition(world, entity.world.getSpawnPoint());
		entity.world.setSpawnPoint(spawn);
		entity.moveToBlockPosAndAngles(spawn.up(), yaw, entity.rotationPitch);
	}

	public static BlockPos findPosition(World world, BlockPos position) {
		position = new BlockPos(position.getX(), 100, position.getZ());
		BlockPos bestPos = null;
		double distance = -1.0D;
		boolean closeEnough = false;
		for (int offsetX = -125; offsetX <= 125; ++offsetX) {
			BlockPos positionCache;
			for (int offsetZ = -125; offsetZ <= 125; ++offsetZ) {
				for (BlockPos currentPos = position.add(offsetX, world.getActualHeight() - 1 - position.getY(), offsetZ); currentPos.getY() >= 0; currentPos = positionCache) {
					positionCache = currentPos.down();
					if (!world.isSideSolid(currentPos, EnumFacing.UP, false))
						continue;

					final double distanceToEntity = currentPos.distanceSq(position);
					if (distance < 0.0D || distanceToEntity < distance) {
						distance = distanceToEntity;
						bestPos = currentPos;
						if (distanceToEntity < 20.0D) {
							closeEnough = true;
							break;
						}
					}
				}
				if (closeEnough)
					break;
			}
			if (closeEnough)
				break;
		}
		if (bestPos == null)
			bestPos = position;

		bestPos = new BlockPos(bestPos.getX(), world.getActualHeight(), bestPos.getZ());
		while (!world.isSideSolid(bestPos, EnumFacing.UP, false)) {
			bestPos = bestPos.down();
		}
		return bestPos;
	}
}