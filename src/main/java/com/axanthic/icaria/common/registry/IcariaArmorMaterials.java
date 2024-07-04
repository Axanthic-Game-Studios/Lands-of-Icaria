package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArmorMaterials extends ArmorMaterials {
	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, IcariaIdents.ID);

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> LAUREL = IcariaArmorMaterials.ARMOR_MATERIALS.register("laurel", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 0);
		map.put(ArmorItem.Type.LEGGINGS, 0);
		map.put(ArmorItem.Type.CHESTPLATE, 0);
		map.put(ArmorItem.Type.HELMET, 0);
		map.put(ArmorItem.Type.BODY, 0);
	}), 15, SoundEvents.ARMOR_EQUIP_GENERIC, Ingredient::of, List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "laurel"))), 0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> AETERNAE_HIDE = IcariaArmorMaterials.ARMOR_MATERIALS.register("aeternae_hide", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 2);
		map.put(ArmorItem.Type.CHESTPLATE, 3);
		map.put(ArmorItem.Type.HELMET, 1);
		map.put(ArmorItem.Type.BODY, 3);
	}), 15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(IcariaItems.AETERNAE_HIDE.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "aeternae_hide"))), 0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> CHALKOS = IcariaArmorMaterials.ARMOR_MATERIALS.register("chalkos", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 1);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 4);
		map.put(ArmorItem.Type.HELMET, 1);
		map.put(ArmorItem.Type.BODY, 4);
	}), 15, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(IcariaItems.CHALKOS_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "chalkos"))), 0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> KASSITEROS = IcariaArmorMaterials.ARMOR_MATERIALS.register("kassiteros", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 3);
		map.put(ArmorItem.Type.CHESTPLATE, 5);
		map.put(ArmorItem.Type.HELMET, 1);
		map.put(ArmorItem.Type.BODY, 5);
	}), 15, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(IcariaItems.KASSITEROS_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "kassiteros"))), 0.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> ORICHALCUM = IcariaArmorMaterials.ARMOR_MATERIALS.register("orichalcum", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 2);
		map.put(ArmorItem.Type.LEGGINGS, 4);
		map.put(ArmorItem.Type.CHESTPLATE, 6);
		map.put(ArmorItem.Type.HELMET, 2);
		map.put(ArmorItem.Type.BODY, 6);
	}), 19, SoundEvents.ARMOR_EQUIP_GOLD, () -> Ingredient.of(IcariaItems.ORICHALCUM_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "orichalcum"))), 1.0F, 0.0F));

	public static final DeferredHolder<ArmorMaterial, ArmorMaterial> VANADIUMSTEEL = IcariaArmorMaterials.ARMOR_MATERIALS.register("vanadiumsteel", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 5);
		map.put(ArmorItem.Type.CHESTPLATE, 7);
		map.put(ArmorItem.Type.HELMET, 3);
		map.put(ArmorItem.Type.BODY, 7);
	}), 11, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(IcariaItems.VANADIUMSTEEL_INGOT.get()), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "vanadiumsteel"))), 1.5F, 0.0F));
}
