package com.axanthic.icaria.common.entity;

import com.axanthic.icaria.common.registry.IcariaItems;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CivilianRevenantEntity extends RevenantEntity {
	public CivilianRevenantEntity(EntityType<? extends CivilianRevenantEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
		return false;
	}

	@Override
	public void populateDefaultEquipmentSlots(RandomSource pRandomSource, DifficultyInstance pDifficultyInstance) {
		this.populateDefaultEquipmentSlots();
	}

	public void populateDefaultEquipmentSlots() {
		if (this.getRandom().nextInt(3) == 0) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.CHALKOS_DAGGER.get()));
		} else {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.CHALKOS_SHOVEL.get()));
		}
	}

	public static AttributeSupplier.Builder registerAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 2.0D).add(Attributes.FOLLOW_RANGE, 32.0D).add(Attributes.MAX_HEALTH, 20.0D).add(Attributes.MOVEMENT_SPEED, 0.2D);
	}
}
