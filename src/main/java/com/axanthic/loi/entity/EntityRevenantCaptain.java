package com.axanthic.loi.entity;

import com.axanthic.loi.Resources;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityRevenantCaptain extends EntityRevenant {

	public EntityRevenantCaptain(World worldIn) {
		super(worldIn);
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
	}

	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		if (this.rand.nextInt(6) == 0) {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.orichalcum.bident));
		} else {
			this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.orichalcum.sword));
		}
		this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Resources.orichalcumArmor.helmet));
		this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Resources.orichalcumArmor.chestplate));
	}
}