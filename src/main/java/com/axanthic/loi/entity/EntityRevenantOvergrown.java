package com.axanthic.loi.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityRevenantOvergrown extends EntityRevenant {

	public EntityRevenantOvergrown(World worldIn) {
		super(worldIn);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {}
}