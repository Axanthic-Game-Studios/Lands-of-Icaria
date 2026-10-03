package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaLootTableIds {
	public static final ResourceKey<LootTable> AMPHORA = IcariaLootTableIds.create("amphoras/amphora");
	public static final ResourceKey<LootTable> BARREL = IcariaLootTableIds.create("barrels/barrel");
	public static final ResourceKey<LootTable> CHEST = IcariaLootTableIds.create("chests/chest");
	public static final ResourceKey<LootTable> DECORATED_POT = IcariaLootTableIds.create("decorated_pots/decorated_pot");
	public static final ResourceKey<LootTable> RED_LOOT_VASE = IcariaLootTableIds.create("loot_vases/red_loot_vase");
	public static final ResourceKey<LootTable> LOST_LOOT_VASE = IcariaLootTableIds.create("loot_vases/lost_loot_vase");
	public static final ResourceKey<LootTable> CYAN_LOOT_VASE = IcariaLootTableIds.create("loot_vases/cyan_loot_vase");
	public static final ResourceKey<LootTable> OLIVE_LEAVES = IcariaLootTableIds.create("olive_leaves/olive_leaves");
	public static final ResourceKey<LootTable> RED_STORAGE_VASE = IcariaLootTableIds.create("storage_vases/red_storage_vase");
	public static final ResourceKey<LootTable> CYAN_STORAGE_VASE = IcariaLootTableIds.create("storage_vases/cyan_storage_vase");
	public static final ResourceKey<LootTable> STRAWBERRY_BUSH = IcariaLootTableIds.create("strawberry_bushes/strawberry_bush");
	public static final ResourceKey<LootTable> SUSPICIOUS_SAND = IcariaLootTableIds.create("suspicious_sands/suspicious_sand");
	public static final ResourceKey<LootTable> VASE = IcariaLootTableIds.create("vases/vase");
	public static final ResourceKey<LootTable> BLOOMY_VINE = IcariaLootTableIds.create("vines/bloomy_vine");
	public static final ResourceKey<LootTable> BRUSHY_VINE = IcariaLootTableIds.create("vines/brushy_vine");

	public static ResourceKey<LootTable> create(String pName) {
		return ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
