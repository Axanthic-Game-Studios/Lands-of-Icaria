package com.axanthic.landsoficaria.common.items;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.LandsOfIcariaTabs;

import net.minecraft.world.item.Item;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class IcariaItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LandsOfIcariaInfo.MODID);

    public static final RegistryObject<Item> EXAMPLE = register("example", () -> new Item(new Item.Properties().tab(LandsOfIcariaTabs.creativeItems)));

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
