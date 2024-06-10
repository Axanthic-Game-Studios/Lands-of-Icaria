package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.util.IcariaTier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

import net.neoforged.neoforge.common.NeoForgeMod;

import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class DaggerItem extends SwordItem {
    public float attackDamage;
    public float attackSpeed;
    public float entityReach;

    public Multimap<Attribute, AttributeModifier> multimap;

    public static final UUID BASE_ATTACK_RANGE_UUID = UUID.fromString("971104f5-17b7-48d9-b16c-1109f0536884");

    public DaggerItem(IcariaTier pTier, int pDamage, float pAttackSpeed, Properties pProperties) {
        super(pTier, pDamage, pAttackSpeed, pProperties);
        this.attackDamage = pDamage + pTier.attackDamageBonus;
        this.attackSpeed = pAttackSpeed;
        this.entityReach = NeoForgeMod.ENTITY_REACH.isBound() ? -2.0F : 0.0F;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.attackSpeed, AttributeModifier.Operation.ADDITION));
        builder.put(NeoForgeMod.ENTITY_REACH.value(), new AttributeModifier(DaggerItem.BASE_ATTACK_RANGE_UUID, "Weapon modifier", this.entityReach, AttributeModifier.Operation.ADDITION));
        this.multimap = builder.build();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pEquipmentSlot) {
        return pEquipmentSlot == EquipmentSlot.MAINHAND ? this.multimap : super.getDefaultAttributeModifiers(pEquipmentSlot);
    }
}
