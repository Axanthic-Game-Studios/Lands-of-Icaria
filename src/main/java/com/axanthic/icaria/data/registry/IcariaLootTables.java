package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLootTables {
	public static final ResourceKey<LootTable> AMPHORA = IcariaLootTables.createKey("amphoras/amphora");
	public static final ResourceKey<LootTable> BARREL = IcariaLootTables.createKey("barrels/barrel");
	public static final ResourceKey<LootTable> CHEST = IcariaLootTables.createKey("chests/chest");
	public static final ResourceKey<LootTable> DECORATED_POT = IcariaLootTables.createKey("decorated_pots/decorated_pot");
	public static final ResourceKey<LootTable> RED_LOOT_VASE = IcariaLootTables.createKey("loot_vases/red_loot_vase");
	public static final ResourceKey<LootTable> LOST_LOOT_VASE = IcariaLootTables.createKey("loot_vases/lost_loot_vase");
	public static final ResourceKey<LootTable> CYAN_LOOT_VASE = IcariaLootTables.createKey("loot_vases/cyan_loot_vase");
	public static final ResourceKey<LootTable> RED_STORAGE_VASE = IcariaLootTables.createKey("storage_vases/red_storage_vase");
	public static final ResourceKey<LootTable> CYAN_STORAGE_VASE = IcariaLootTables.createKey("storage_vases/cyan_storage_vase");
	public static final ResourceKey<LootTable> SUSPICIOUS_SAND = IcariaLootTables.createKey("suspicious_sands/suspicious_sand");
	public static final ResourceKey<LootTable> VASE = IcariaLootTables.createKey("vases/vase");

	public static ResourceKey<LootTable> createKey(String pName) {
		return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
