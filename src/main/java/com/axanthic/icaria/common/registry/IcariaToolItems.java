package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.item.*;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.util.IcariaTier;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;

import net.neoforged.neoforge.common.TierSortingRegistry;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class IcariaToolItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaInfo.ID);

    public IcariaTier tier;

    public static final List<IcariaToolItems> TOOL_ITEMS = new ArrayList<>();

    public Supplier<Item> sword;
    public Supplier<Item> dagger;
    public Supplier<Item> shovel;
    public Supplier<Item> pickaxe;
    public Supplier<Item> axe;
    public Supplier<Item> scythe;
    public Supplier<Item> bident;

    public IcariaToolItems(IcariaTier pTier) {
        var name = TierSortingRegistry.getName(pTier).getPath();

        this.tier = pTier;
        this.sword = IcariaToolItems.ITEMS.register(name + "_sword", () -> new SwordItem(pTier, 3, -2.4F, new Item.Properties()));
        this.dagger = IcariaToolItems.ITEMS.register(name + "_dagger", () -> new DaggerItem(pTier, 2, -1.0F, new Item.Properties()));
        this.shovel = IcariaToolItems.ITEMS.register(name + "_shovel", () -> new IcariaShovelItem(pTier, 1.5F, -3.0F, new Item.Properties()));
        this.pickaxe = IcariaToolItems.ITEMS.register(name + "_pickaxe", () -> new IcariaPickaxeItem(pTier, 1, -2.8F, new Item.Properties()));
        this.axe = IcariaToolItems.ITEMS.register(name + "_axe", () -> new IcariaAxeItem(pTier, 6, -3.0F, new Item.Properties()));
        this.scythe = IcariaToolItems.ITEMS.register(name + "_scythe", () -> new ScytheItem(pTier, 4, -2.8F, new Item.Properties()));
        this.bident = IcariaToolItems.ITEMS.register(name + "_bident", () -> new BidentItem(pTier, new Item.Properties()));

        IcariaToolItems.TOOL_ITEMS.add(this);
    }
}
