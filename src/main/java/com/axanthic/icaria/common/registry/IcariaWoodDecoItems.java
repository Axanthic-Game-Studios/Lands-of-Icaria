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

public class IcariaWoodDecoItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, IcariaIdents.ID);

	public IcariaWoodDecoBlocks block;

	public static final List<IcariaWoodDecoItems> WOOD_DECO_ITEMS = new ArrayList<>();

	public Supplier<Item> item;
	public Supplier<Item> stairs;
	public Supplier<Item> slab;
	public Supplier<Item> fence;
	public Supplier<Item> gate;

	public IcariaWoodDecoItems(IcariaWoodDecoBlocks pBlock, Supplier<Item> pItem) {
		this.block = pBlock;
		this.item = pItem;
		this.stairs = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_stairs", () -> new BlockItem(pBlock.stairs.get(), new Item.Properties()));
		this.slab = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_slab", () -> new BlockItem(pBlock.slab.get(), new Item.Properties()));
		this.fence = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_fence", () -> new BlockItem(pBlock.fence.get(), new Item.Properties()));
		this.gate = IcariaWoodDecoItems.ITEMS.register(pBlock.name + "_fence_gate", () -> new BlockItem(pBlock.gate.get(), new Item.Properties()));
		IcariaWoodDecoItems.WOOD_DECO_ITEMS.add(this);
	}
}
