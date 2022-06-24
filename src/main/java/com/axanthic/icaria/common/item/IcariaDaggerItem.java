package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.util.IcariaTier;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;

import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.jarjar.util.Lazy;

import java.util.UUID;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDaggerItem extends SwordItem {
    public float damage;
    public float speed;

    public Multimap<Attribute, AttributeModifier> defaultModifiers;
    public UUID BASE_ATTACK_RANGE_UUID = UUID.fromString("971104f5-17b7-48d9-b16c-1109f0536884");

    public final Lazy<Multimap<Attribute, AttributeModifier>> LAZY = Lazy.of(() -> {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", this.damage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", this.speed, AttributeModifier.Operation.ADDITION));
        if (ForgeMod.ATTACK_RANGE.isPresent()) {
            builder.put(ForgeMod.ATTACK_RANGE.get(), new AttributeModifier(BASE_ATTACK_RANGE_UUID, "Weapon modifier", -2, AttributeModifier.Operation.ADDITION));
        }

        return builder.build();
    });

    public IcariaDaggerItem(IcariaTier pTier, int pDamage, float pAttackSpeed, Properties pProperties) {
        super(pTier, pDamage, pAttackSpeed, pProperties);
        this.damage = pDamage + pTier.attackDamageBonus;
        this.speed = pAttackSpeed;
        defaultModifiers = LAZY.get();
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot pSlot) {
        return pSlot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(pSlot);
    }
}
