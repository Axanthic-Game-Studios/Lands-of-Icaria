package com.axanthic.icaria.common.registry;

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

public class IcariaStoneDecoItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaInfo.ID);

    public IcariaStoneDecoBlocks block;

    public static final List<IcariaStoneDecoItems> STONE_DECO_ITEMS = new ArrayList<>();

    public RegistryObject<Item> item;
    public RegistryObject<Item> stairs;
    public RegistryObject<Item> slab;
    public RegistryObject<Item> wall;

    public IcariaStoneDecoItems(IcariaStoneDecoBlocks pBlock, RegistryObject<Item> pItem) {
        this.block = pBlock;
        this.item = pItem;
        this.stairs = IcariaStoneDecoItems.ITEMS.register(pBlock.name + "_stairs", () -> new BlockItem(pBlock.stairs.get(), new Item.Properties()));
        this.slab = IcariaStoneDecoItems.ITEMS.register(pBlock.name + "_slab", () -> new BlockItem(pBlock.slab.get(), new Item.Properties()));
        this.wall = IcariaStoneDecoItems.ITEMS.register(pBlock.name + "_wall", () -> new BlockItem(pBlock.wall.get(), new Item.Properties()));
        IcariaStoneDecoItems.STONE_DECO_ITEMS.add(this);
    }
}
