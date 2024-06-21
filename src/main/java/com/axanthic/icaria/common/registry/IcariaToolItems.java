package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.item.BidentItem;
import com.axanthic.icaria.common.item.DaggerItem;
import com.axanthic.icaria.common.item.ScytheItem;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;

import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class IcariaToolItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaInfo.ID);

    public static final List<IcariaToolItems> TOOL_ITEMS = new ArrayList<>();

    public SimpleTier tier;

    public Supplier<Item> sword;
    public Supplier<Item> dagger;
    public Supplier<Item> shovel;
    public Supplier<Item> pickaxe;
    public Supplier<Item> axe;
    public Supplier<Item> scythe;
    public Supplier<Item> bident;

    public IcariaToolItems(String pName, SimpleTier pTier) {
        this.tier = pTier;
        this.sword = IcariaToolItems.ITEMS.register(pName + "_sword", () -> new SwordItem(pTier, new Item.Properties().attributes(SwordItem.createAttributes(pTier, 3, -2.4F))));
        this.dagger = IcariaToolItems.ITEMS.register(pName + "_dagger", () -> new DaggerItem(pTier, new Item.Properties().attributes(DaggerItem.createAttributes(pTier, 2, -2.0F, -1.0F))));
        this.shovel = IcariaToolItems.ITEMS.register(pName + "_shovel", () -> new ShovelItem(pTier, new Item.Properties().attributes(ShovelItem.createAttributes(pTier, 1.5F, -3.0F))));
        this.pickaxe = IcariaToolItems.ITEMS.register(pName + "_pickaxe", () -> new PickaxeItem(pTier, new Item.Properties().attributes(PickaxeItem.createAttributes(pTier, 1.0F, -2.8F))));
        this.axe = IcariaToolItems.ITEMS.register(pName + "_axe", () -> new AxeItem(pTier, new Item.Properties().attributes(AxeItem.createAttributes(pTier, 6.0F, -3.0F))));
        this.scythe = IcariaToolItems.ITEMS.register(pName + "_scythe", () -> new ScytheItem(pTier, new Item.Properties().attributes(ScytheItem.createAttributes(pTier, 4.0F, -2.8F))));
        this.bident = IcariaToolItems.ITEMS.register(pName + "_bident", () -> new BidentItem(pTier, new Item.Properties().attributes(BidentItem.createAttributes(pTier, 3.5F, -2.5F)).component(DataComponents.TOOL, BidentItem.createToolProperties())));
        IcariaToolItems.TOOL_ITEMS.add(this);
    }
}
