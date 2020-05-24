package com.axanthic.loi.entity;

import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockGreekFire;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {
	
	public static int radius = 2;

	public EntityGrenade(World worldIn) {
		super(worldIn);
	}

	public EntityGrenade(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityGrenade(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	protected void onImpact(RayTraceResult result) {
		if (this.world.isRemote || (result.entityHit != null && result.entityHit.equals(thrower)))
			return;

		Explosion explosion = world.createExplosion(thrower, posX, posY, posZ, 1.0f, false);
		
		BlockPos thisPos = new BlockPos(this);

		for (BlockPos blockpos : BlockPos.getAllInBox(thisPos.add(-radius, -radius, -radius), thisPos.add(radius, radius, radius))) {
			if (world.getBlockState(blockpos).getMaterial() == Material.AIR && BlockGreekFire.canNeighborCatchFire(world, blockpos) && rand.nextInt(3) == 0) {
				world.setBlockState(blockpos, Resources.greekFire.getBlock().getDefaultState());
			}
		}
		this.setDead();
	}
}