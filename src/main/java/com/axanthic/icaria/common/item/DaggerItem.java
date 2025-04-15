package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DaggerItem extends SwordItem {
	public DaggerItem(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackRange, float pAttackSpeed, Properties pProperties) {
		super(pProperties.component(DataComponents.ATTRIBUTE_MODIFIERS, DaggerItem.createAttributes(pToolMaterial, pAttackDamage, pAttackRange, pAttackSpeed)).component(DataComponents.TOOL, DaggerItem.createToolProperties()).durability(pToolMaterial.durability()).enchantable(pToolMaterial.enchantmentValue()).repairable(pToolMaterial.repairItems()));
	}

	public static ItemAttributeModifiers createAttributes(ToolMaterial pToolMaterial, float pAttackDamage, float pAttackRange, float pAttackSpeed) {
		return ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, pToolMaterial.attackDamageBonus() + pAttackDamage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, pAttackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(IcariaResourceLocations.BASE_ATTACK_RANGE_ID, pAttackRange, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build();
	}

	public static Tool createToolProperties() {
		return new Tool(List.of(), 1.0F, 2);
	}
}
