package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import net.neoforged.neoforge.common.SimpleTier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DaggerItem extends SwordItem {
    public DaggerItem(SimpleTier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    public static ItemAttributeModifiers createAttributes(SimpleTier pTier, int pAttackDamage, float attackRange, float pAttackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, pAttackDamage + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, pAttackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(IcariaResourceLocations.BASE_ATTACK_RANGE_ID, attackRange, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }
}
