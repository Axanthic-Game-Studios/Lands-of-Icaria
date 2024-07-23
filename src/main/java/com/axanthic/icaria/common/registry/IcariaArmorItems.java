package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaArmorItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaIdents.ID);

	public static final List<IcariaArmorItems> ARMOR_ITEMS = new ArrayList<>();

	public Supplier<Item> helmet;
	public Supplier<Item> chestplate;
	public Supplier<Item> leggings;
	public Supplier<Item> boots;

	public IcariaArmorItems(String pName, DeferredHolder<ArmorMaterial, ArmorMaterial> pMaterial, int pDurability) {
		this.helmet = IcariaArmorItems.ITEMS.register(pName + "_helmet", () -> new ArmorItem(pMaterial, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(pDurability))));
		this.chestplate = IcariaArmorItems.ITEMS.register(pName + "_chestplate", () -> new ArmorItem(pMaterial, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(pDurability))));
		this.leggings = IcariaArmorItems.ITEMS.register(pName + "_leggings", () -> new ArmorItem(pMaterial, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(pDurability))));
		this.boots = IcariaArmorItems.ITEMS.register(pName + "_boots", () -> new ArmorItem(pMaterial, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(pDurability))));
		IcariaArmorItems.ARMOR_ITEMS.add(this);
	}
}
