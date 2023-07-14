package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaArmorMaterials;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaArmorItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaInfo.ID);

    public static final List<IcariaArmorItems> ARMOR_ITEMS = new ArrayList<>();

    public RegistryObject<Item> helmet;
    public RegistryObject<Item> chestplate;
    public RegistryObject<Item> leggings;
    public RegistryObject<Item> boots;

    public IcariaArmorItems(IcariaArmorMaterials pMaterial) {
        var name = pMaterial.name;

        this.helmet = IcariaArmorItems.ITEMS.register(name + "_helmet", () -> new ArmorItem(pMaterial, ArmorItem.Type.HELMET, (new Item.Properties())));
        this.chestplate = IcariaArmorItems.ITEMS.register(name + "_chestplate", () -> new ArmorItem(pMaterial, ArmorItem.Type.CHESTPLATE, (new Item.Properties())));
        this.leggings = IcariaArmorItems.ITEMS.register(name + "_leggings", () -> new ArmorItem(pMaterial, ArmorItem.Type.LEGGINGS, (new Item.Properties())));
        this.boots = IcariaArmorItems.ITEMS.register(name + "_boots", () -> new ArmorItem(pMaterial, ArmorItem.Type.BOOTS, (new Item.Properties())));

        IcariaArmorItems.ARMOR_ITEMS.add(this);
    }
}
