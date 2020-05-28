package com.axanthic.loi.entity;

import com.axanthic.loi.Resources;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityRevenantSoldier extends EntityRevenant {

	public EntityRevenantSoldier(World worldIn) {
		super(worldIn);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(6.0D);
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		int chance = this.rand.nextInt(10);
		if (chance == 0) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.kassiteros.bident));
		} else if (chance == 1) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.kassiteros.axe));
		} else if (chance == 2) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.kassiteros.dagger));
		} else {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.kassiteros.sword));
		}
	}
}