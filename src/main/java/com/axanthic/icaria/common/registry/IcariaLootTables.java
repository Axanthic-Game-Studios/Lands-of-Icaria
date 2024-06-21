package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

@MethodsReturnNonnullByDefault

public class IcariaLootTables {
	public static final ResourceKey<LootTable> BARREL_LOOT = IcariaLootTables.registerKey("barrels/barrel");
	public static final ResourceKey<LootTable> CHEST_LOOT = IcariaLootTables.registerKey("chests/chest");
	public static final ResourceKey<LootTable> RED_LOOT_VASE_LOOT = IcariaLootTables.registerKey("loot_vases/red_loot_vase");
	public static final ResourceKey<LootTable> CYAN_LOOT_VASE_LOOT = IcariaLootTables.registerKey("loot_vases/cyan_loot_vase");
	public static final ResourceKey<LootTable> RED_STORAGE_VASE_LOOT = IcariaLootTables.registerKey("storage_vases/red_storage_vase");
	public static final ResourceKey<LootTable> CYAN_STORAGE_VASE_LOOT = IcariaLootTables.registerKey("storage_vases/cyan_storage_vase");

	public static ResourceKey<LootTable> registerKey(String pName) {
		return ResourceKey.create(Registries.LOOT_TABLE, new ResourceLocation(IcariaInfo.ID, pName));
	}
}
