package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("deprecation")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum IcariaArmorMaterials implements ArmorMaterial {
    LAUREL("laurel", 0, new int[]{0, 0, 0, 0}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(IcariaItems.LAUREL_LEAVES.get())),
    AETERNAE_HIDE("aeternae_hide", 11, new int[]{1, 2, 3, 1}, 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, () -> Ingredient.of(IcariaItems.AETERNAE_HIDE.get())),
    CHALKOS("chalkos", 11, new int[]{1, 3, 4, 1}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(IcariaItems.CHALKOS_INGOT.get())),
    KASSITEROS("kassiteros", 15, new int[]{2, 3, 5, 1}, 15, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> Ingredient.of(IcariaItems.KASSITEROS_INGOT.get())),
    ORICHALCUM("orichalcum", 24, new int[]{2, 4, 6, 2}, 19, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F, () -> Ingredient.of(IcariaItems.ORICHALCUM_INGOT.get())),
    VANADIUMSTEEL("vanadiumsteel", 27, new int[]{3, 5, 7, 3}, 11, SoundEvents.ARMOR_EQUIP_IRON, 1.5F, 0.0F, () -> Ingredient.of(IcariaItems.VANADIUMSTEEL_INGOT.get()));

    public final float toughness;
    public final float knockbackResistance;

    public final int durabilityMultiplier;
    public final int enchantmentValue;
    public final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    public final int[] slotProtections;

    public final LazyLoadedValue<Ingredient> repairIngredient;

    public final SoundEvent sound;

    public final String name;

    IcariaArmorMaterials(String pName, int pDurabilityMultiplier, int[] pSlotProtections, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.slotProtections = pSlotProtections;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue<>(pRepairIngredient);
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot pSlot) {
        return this.slotProtections[pSlot.getIndex()];
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public String getName() {
        return IcariaInfo.MODID + ":" + this.name;
    }
}
