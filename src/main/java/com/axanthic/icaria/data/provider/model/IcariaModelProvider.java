package com.axanthic.icaria.data.provider.model;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaModelProvider extends ModelProvider {
	public IcariaModelProvider(PackOutput pPackOutput, String pId) {
		super(pPackOutput, pId);
	}

	@Override
	public void registerModels(BlockModelGenerators pBlockModelGenerators, ItemModelGenerators pItemModelGenerators) {
		IcariaBlockModelProvider.register(pBlockModelGenerators);
		IcariaBlockStateProvider.register(pBlockModelGenerators);
		IcariaItemModelProvider.register(pItemModelGenerators);
		IcariaItemStateProvider.register(pItemModelGenerators);
	}

	public static Identifier blockFile(Block pBlock, String pSuffix, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + IcariaModelProvider.blockName(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB) + "_" + pSuffix);
	}

	public static Identifier blockFile(Block pBlock, String pSuffix, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + IcariaModelProvider.blockName(pBlock).replace(pSource, pTarget) + "_" + pSuffix);
	}

	public static Identifier blockFile(Block pBlock, String pSuffix) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + IcariaModelProvider.blockName(pBlock) + "_" + pSuffix);
	}

	public static Identifier blockFile(Block pBlock, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + IcariaModelProvider.blockName(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public static Identifier blockFile(Block pBlock, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + IcariaModelProvider.blockName(pBlock).replace(pSource, pTarget));
	}

	public static Identifier blockFile(Block pBlock) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + IcariaModelProvider.blockName(pBlock));
	}

	public static Identifier blockFile(String pPrefix, Block pBlock, String pSuffix, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + pPrefix + "_" + IcariaModelProvider.blockName(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB) + "_" + pSuffix);
	}

	public static Identifier blockFile(String pPrefix, Block pBlock, String pSuffix, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + pPrefix + "_" + IcariaModelProvider.blockName(pBlock).replace(pSource, pTarget) + "_" + pSuffix);
	}

	public static Identifier blockFile(String pPrefix, Block pBlock, String pSuffix) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + pPrefix + "_" + IcariaModelProvider.blockName(pBlock) + "_" + pSuffix);
	}

	public static Identifier blockFile(String pPrefix, Block pBlock, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + pPrefix + "_" + IcariaModelProvider.blockName(pBlock).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public static Identifier blockFile(String pPrefix, Block pBlock, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + pPrefix + "_" + IcariaModelProvider.blockName(pBlock).replace(pSource, pTarget));
	}

	public static Identifier blockFile(String pPrefix, Block pBlock) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.blockId(pBlock), "block" + "/" + pPrefix + "_" + IcariaModelProvider.blockName(pBlock));
	}

	public static Identifier blockFile(String pId, String pFile, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(pId, "block" + "/" + pFile.replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public static Identifier blockFile(String pId, String pFile, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(pId, "block" + "/" + pFile.replace(pSource, pTarget));
	}

	public static Identifier blockFile(String pId, String pFile) {
		return Identifier.fromNamespaceAndPath(pId, "block" + "/" + pFile);
	}

	public static Identifier itemFile(Item pItem, String pSuffix, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + IcariaModelProvider.itemName(pItem).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB) + "_" + pSuffix);
	}

	public static Identifier itemFile(Item pItem, String pSuffix, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + IcariaModelProvider.itemName(pItem).replace(pSource, pTarget) + "_" + pSuffix);
	}

	public static Identifier itemFile(Item pItem, String pSuffix) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + IcariaModelProvider.itemName(pItem) + "_" + pSuffix);
	}

	public static Identifier itemFile(Item pItem, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + IcariaModelProvider.itemName(pItem).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public static Identifier itemFile(Item pItem, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + IcariaModelProvider.itemName(pItem).replace(pSource, pTarget));
	}

	public static Identifier itemFile(Item pItem) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + IcariaModelProvider.itemName(pItem));
	}

	public static Identifier itemFile(String pPrefix, Item pItem, String pSuffix, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + pPrefix + "_" + IcariaModelProvider.itemName(pItem).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB) + "_" + pSuffix);
	}

	public static Identifier itemFile(String pPrefix, Item pItem, String pSuffix, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + pPrefix + "_" + IcariaModelProvider.itemName(pItem).replace(pSource, pTarget) + "_" + pSuffix);
	}

	public static Identifier itemFile(String pPrefix, Item pItem, String pSuffix) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + pPrefix + "_" + IcariaModelProvider.itemName(pItem) + "_" + pSuffix);
	}

	public static Identifier itemFile(String pPrefix, Item pItem, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + pPrefix + "_" + IcariaModelProvider.itemName(pItem).replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public static Identifier itemFile(String pPrefix, Item pItem, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + pPrefix + "_" + IcariaModelProvider.itemName(pItem).replace(pSource, pTarget));
	}

	public static Identifier itemFile(String pPrefix, Item pItem) {
		return Identifier.fromNamespaceAndPath(IcariaModelProvider.itemId(pItem), "item" + "/" + pPrefix + "_" + IcariaModelProvider.itemName(pItem));
	}

	public static Identifier itemFile(String pId, String pFile, String pSourceA, String pTargetA, String pSourceB, String pTargetB) {
		return Identifier.fromNamespaceAndPath(pId, "item" + "/" + pFile.replace(pSourceA, pTargetA).replace(pSourceB, pTargetB));
	}

	public static Identifier itemFile(String pId, String pFile, String pSource, String pTarget) {
		return Identifier.fromNamespaceAndPath(pId, "item" + "/" + pFile.replace(pSource, pTarget));
	}

	public static Identifier itemFile(String pId, String pFile) {
		return Identifier.fromNamespaceAndPath(pId, "item" + "/" + pFile);
	}

	public static String blockId(Block pBlock) {
		return BuiltInRegistries.BLOCK.getKey(pBlock).getNamespace();
	}

	public static String blockName(Block pBlock) {
		return BuiltInRegistries.BLOCK.getKey(pBlock).getPath();
	}

	public static String itemId(Item pItem) {
		return BuiltInRegistries.ITEM.getKey(pItem).getNamespace();
	}

	public static String itemName(Item pItem) {
		return BuiltInRegistries.ITEM.getKey(pItem).getPath();
	}

	@Override
	public String getName() {
		return "Model Definitions";
	}
}
