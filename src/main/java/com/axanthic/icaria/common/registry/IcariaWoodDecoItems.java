package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.item.FuelBlockItem;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaWoodDecoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaInfo.ID);

    public IcariaWoodDecoBlocks block;

    public static final List<IcariaWoodDecoItems> WOOD_DECO_ITEMS = new ArrayList<>();

    public RegistryObject<Item> item;
    public RegistryObject<Item> stairs;
    public RegistryObject<Item> slab;
    public RegistryObject<Item> fence;
    public RegistryObject<Item> gate;

    public IcariaWoodDecoItems(IcariaWoodDecoBlocks pBlock, RegistryObject<Item> pItem) {
        this.block = pBlock;
        this.item = pItem;
        this.stairs = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_stairs", () -> new BlockItem(pBlock.stairs.get(), new Item.Properties()));
        this.slab = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_slab", () -> new BlockItem(pBlock.slab.get(), new Item.Properties()));
        this.fence = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_fence", () -> new FuelBlockItem(pBlock.fence.get(), new Item.Properties(), 300));
        this.gate = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_fence_gate", () -> new FuelBlockItem(pBlock.gate.get(), new Item.Properties(), 300));
        IcariaWoodDecoItems.WOOD_DECO_ITEMS.add(this);
    }
}
