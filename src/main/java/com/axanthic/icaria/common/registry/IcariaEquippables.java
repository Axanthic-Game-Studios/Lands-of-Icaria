package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.properties.Carpet;
import com.axanthic.icaria.data.registry.IcariaEquipmentAssets;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.equipment.Equippable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEquippables {

	public static Equippable carpet(Carpet pCarpet) {
		return Equippable.builder(EquipmentSlot.BODY).setCanBeSheared(true).setAllowedEntities(EntityType.LLAMA, EntityType.TRADER_LLAMA).setAsset(IcariaEquipmentAssets.CARPET.get(pCarpet)).setEquipSound(SoundEvents.LLAMA_SWAG).setShearingSound(SoundEvents.LLAMA_CARPET_UNEQUIP).build();
	}
}
