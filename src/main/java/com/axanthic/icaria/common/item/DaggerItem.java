package com.axanthic.icaria.common.item;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import net.neoforged.neoforge.common.SimpleTier;

import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DaggerItem extends SwordItem {
    public static final UUID BASE_ATTACK_RANGE_UUID = UUID.fromString("971104f5-17b7-48d9-b16c-1109f0536884");

    public DaggerItem(SimpleTier pTier, Properties pProperties) {
        super(pTier, pProperties);
    }

    public static ItemAttributeModifiers createAttributes(SimpleTier pTier, int pAttackDamage, float attackRange, float pAttackSpeed) {
        return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_UUID, "Tool modifier", pAttackDamage + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_UUID, "Tool modifier", pAttackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(DaggerItem.BASE_ATTACK_RANGE_UUID, "Weapon modifier", attackRange, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
    }
}
