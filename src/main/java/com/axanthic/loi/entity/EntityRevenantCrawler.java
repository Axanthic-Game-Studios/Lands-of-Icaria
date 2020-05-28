package com.axanthic.loi.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityRevenantCrawler extends EntityRevenant {

	public EntityRevenantCrawler(World worldIn) {
		super(worldIn);
		this.setSize(0.95F, 0.75F);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.16D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {}

	public float getEyeHeight() {
		float f = 0.5F;

		if (this.isChild()) {
			f = (float) ((double) f - 0.81D);
		}

		return f;
	}
}