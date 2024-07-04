package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLootTables {
	public static final ResourceKey<LootTable> BARREL_LOOT = IcariaLootTables.createKey("barrels/barrel");
	public static final ResourceKey<LootTable> CHEST_LOOT = IcariaLootTables.createKey("chests/chest");
	public static final ResourceKey<LootTable> RED_LOOT_VASE_LOOT = IcariaLootTables.createKey("loot_vases/red_loot_vase");
	public static final ResourceKey<LootTable> CYAN_LOOT_VASE_LOOT = IcariaLootTables.createKey("loot_vases/cyan_loot_vase");
	public static final ResourceKey<LootTable> RED_STORAGE_VASE_LOOT = IcariaLootTables.createKey("storage_vases/red_storage_vase");
	public static final ResourceKey<LootTable> CYAN_STORAGE_VASE_LOOT = IcariaLootTables.createKey("storage_vases/cyan_storage_vase");

	public static ResourceKey<LootTable> createKey(String pName) {
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
