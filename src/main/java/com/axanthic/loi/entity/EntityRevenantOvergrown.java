package com.axanthic.loi.entity;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
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

	@Nullable
	protected ResourceLocation getLootTable() {
		return Resources.LOOT_REVENANT_OVERGROWN;
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {}
}