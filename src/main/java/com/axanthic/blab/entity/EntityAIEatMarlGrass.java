package com.axanthic.blab.entity;

import com.axanthic.blab.Resources;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIEatMarlGrass extends EntityAIBase {

	private final EntityLiving grassEaterEntity;
	private final World entityWorld;
	int eatingGrassTimer;

	public EntityAIEatMarlGrass(EntityLiving grassEaterEntityIn) {
		super();
		this.grassEaterEntity = grassEaterEntityIn;
		this.entityWorld = grassEaterEntityIn.world;
	}

	public boolean shouldExecute() {
		if (this.grassEaterEntity.getRNG().nextInt(this.grassEaterEntity.isChild() ? 50 : 1000) != 0)
			return false;
		BlockPos blockpos = new BlockPos(this.grassEaterEntity.posX, this.grassEaterEntity.posY, this.grassEaterEntity.posZ);

		return this.entityWorld.getBlockState(blockpos.down()).getBlock() == Resources.grass.getBlock() || this.entityWorld.getBlockState(blockpos.down()).getBlock() == Resources.tallGrass.getBlock();
	}

	public void startExecuting() {
		this.eatingGrassTimer = 40;
		this.entityWorld.setEntityState(this.grassEaterEntity, (byte)10);
		this.grassEaterEntity.getNavigator().clearPath();
	}

	public void resetTask() {
		this.eatingGrassTimer = 0;
	}

	public boolean shouldContinueExecuting() {
		return this.eatingGrassTimer > 0;
	}

	public int getEatingGrassTimer() {
		return this.eatingGrassTimer;
	}

	public void updateTask() {
		this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);

		if (this.eatingGrassTimer == 4) {
			BlockPos blockpos = new BlockPos(this.grassEaterEntity.posX, this.grassEaterEntity.posY, this.grassEaterEntity.posZ);

			if (this.entityWorld.getBlockState(blockpos).getBlock() == Resources.tallGrass.getBlock()) {
				if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.grassEaterEntity)) {
					this.entityWorld.destroyBlock(blockpos, false);
				}

				this.grassEaterEntity.eatGrassBonus();
			} else {
				BlockPos blockpos1 = blockpos.down();

				if (this.entityWorld.getBlockState(blockpos1).getBlock() == Resources.grass.getBlock()) {
					if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.entityWorld, this.grassEaterEntity)) {
						this.entityWorld.playEvent(2001, blockpos1, Block.getIdFromBlock(Resources.grass.getBlock()));
						this.entityWorld.setBlockState(blockpos1, Resources.soil.getBlock().getDefaultState(), 2);
					}
					this.grassEaterEntity.eatGrassBonus();
				}
			}
		}
	}
}
