package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStoneDecoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaIdents.ID);

    public IcariaStoneDecoBlocks block;

    public static final List<IcariaStoneDecoItems> STONE_DECO_ITEMS = new ArrayList<>();

    public Supplier<Item> item;
    public Supplier<Item> stairs;
    public Supplier<Item> slab;
    public Supplier<Item> wall;

    public IcariaStoneDecoItems(IcariaStoneDecoBlocks pBlock, Supplier<Item> pItem) {
        this.block = pBlock;
        this.item = pItem;
        this.stairs = IcariaStoneDecoItems.ITEMS.register(pBlock.name + "_stairs", () -> new BlockItem(pBlock.stairs.get(), new Item.Properties()));
        this.slab = IcariaStoneDecoItems.ITEMS.register(pBlock.name + "_slab", () -> new BlockItem(pBlock.slab.get(), new Item.Properties()));
        this.wall = IcariaStoneDecoItems.ITEMS.register(pBlock.name + "_wall", () -> new BlockItem(pBlock.wall.get(), new Item.Properties()));
        IcariaStoneDecoItems.STONE_DECO_ITEMS.add(this);
    }
}
