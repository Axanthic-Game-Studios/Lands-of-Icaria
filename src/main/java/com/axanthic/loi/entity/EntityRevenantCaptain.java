package com.axanthic.loi.entity;

import com.axanthic.loi.Resources;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityRevenantCaptain extends EntityRevenant {

	public EntityRevenantCaptain(World worldIn) {
		super(worldIn);
	}

	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Resources.orichalcum.sword));
	}
}