package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaBlockItemIds;
import com.axanthic.icaria.common.ids.IcariaItemIds;
import com.axanthic.icaria.common.tags.IcariaBlockItemTags;
import com.axanthic.icaria.common.tags.IcariaItemTags;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BlockItemTagsProvider;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;

import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaItemTagsProvider extends ItemTagsProvider {
	public IcariaItemTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(ItemTags.AXES)
			.add(IcariaItemIds.CHERT_AXE)
			.add(IcariaItemIds.CHALKOS_AXE)
			.add(IcariaItemIds.KASSITEROS_AXE)
			.add(IcariaItemIds.ORICHALCUM_AXE)
			.add(IcariaItemIds.VANADIUMSTEEL_AXE)
			.add(IcariaItemIds.SIDEROS_AXE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_AXE);

		this.tag(ItemTags.BREAKS_DECORATED_POTS)
			.addTag(IcariaItemTags.TOOLS_BIDENT)
			.addTag(IcariaItemTags.TOOLS_DAGGER);

		this.tag(ItemTags.CAMEL_FOOD)
			.add(IcariaBlockItemIds.CARDON_CACTUS.item());

		this.tag(ItemTags.CAT_FOOD)
			.add(IcariaItemIds.RAW_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.RAW_BROWN_FEESH)
			.add(IcariaItemIds.RAW_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.RAW_PINK_RED_FEESH)
			.add(IcariaItemIds.RAW_PURPLE_FEESH)
			.add(IcariaItemIds.RAW_RED_FEESH)
			.add(IcariaItemIds.RAW_BLUE_RED_FICHE)
			.add(IcariaItemIds.RAW_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.RAW_GRAY_FICHE)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.RAW_RED_FICHE)
			.add(IcariaItemIds.RAW_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.RAW_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_RED_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.RAW_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.RAW_GRAY_FYSH)
			.add(IcariaItemIds.RAW_RAINBOW_FYSH)
			.add(IcariaItemIds.RAW_RED_FYSH)
			.add(IcariaItemIds.RAW_RED_YELLOW_FYSH);

		this.tag(ItemTags.CHEST_ARMOR)
			.add(IcariaItemIds.AETERNAE_HIDE_CHESTPLATE)
			.add(IcariaItemIds.CHALKOS_CHESTPLATE)
			.add(IcariaItemIds.KASSITEROS_CHESTPLATE)
			.add(IcariaItemIds.ORICHALCUM_CHESTPLATE)
			.add(IcariaItemIds.VANADIUMSTEEL_CHESTPLATE);

		this.tag(ItemTags.CHICKEN_FOOD)
			.add(IcariaBlockItemIds.PHYSALIS_SEEDS.item())
			.add(IcariaBlockItemIds.SPELT_SEEDS.item())
			.add(IcariaBlockItemIds.STRAWBERRY_SEEDS.item());

		this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES)
			.add(IcariaItemIds.CHERT_PICKAXE)
			.add(IcariaItemIds.CHALKOS_PICKAXE)
			.add(IcariaItemIds.KASSITEROS_PICKAXE)
			.add(IcariaItemIds.ORICHALCUM_PICKAXE)
			.add(IcariaItemIds.VANADIUMSTEEL_PICKAXE)
			.add(IcariaItemIds.SIDEROS_PICKAXE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_PICKAXE);

		this.tag(ItemTags.COALS)
			.add(IcariaItemIds.LIGNITE)
			.add(IcariaItemIds.ANTHRACITE);

		this.tag(ItemTags.COW_FOOD)
			.add(IcariaItemIds.SPELT);

		this.tag(ItemTags.DURABILITY_ENCHANTABLE)
			.addTag(IcariaItemTags.TOOLS_BIDENT)
			.addTag(IcariaItemTags.TOOLS_DAGGER)
			.add(IcariaItemIds.LAUREL_WREATH);

		this.tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
			.add(IcariaItemIds.LAUREL_WREATH);

		this.tag(ItemTags.FISHES)
			.add(IcariaItemIds.COOKED_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.RAW_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.COOKED_BROWN_FEESH)
			.add(IcariaItemIds.RAW_BROWN_FEESH)
			.add(IcariaItemIds.COOKED_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.RAW_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.COOKED_PINK_RED_FEESH)
			.add(IcariaItemIds.RAW_PINK_RED_FEESH)
			.add(IcariaItemIds.COOKED_PURPLE_FEESH)
			.add(IcariaItemIds.RAW_PURPLE_FEESH)
			.add(IcariaItemIds.COOKED_RED_FEESH)
			.add(IcariaItemIds.RAW_RED_FEESH)
			.add(IcariaItemIds.COOKED_BLUE_RED_FICHE)
			.add(IcariaItemIds.RAW_BLUE_RED_FICHE)
			.add(IcariaItemIds.COOKED_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.RAW_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.COOKED_GRAY_FICHE)
			.add(IcariaItemIds.RAW_GRAY_FICHE)
			.add(IcariaItemIds.COOKED_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.COOKED_RED_FICHE)
			.add(IcariaItemIds.RAW_RED_FICHE)
			.add(IcariaItemIds.COOKED_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.RAW_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.COOKED_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_RED_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_RED_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.COOKED_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BROWN_FISSHH)
			.add(IcariaItemIds.COOKED_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.COOKED_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_FYSH)
			.add(IcariaItemIds.COOKED_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.COOKED_GRAY_FYSH)
			.add(IcariaItemIds.RAW_GRAY_FYSH)
			.add(IcariaItemIds.COOKED_RAINBOW_FYSH)
			.add(IcariaItemIds.RAW_RAINBOW_FYSH)
			.add(IcariaItemIds.COOKED_RED_FYSH)
			.add(IcariaItemIds.RAW_RED_FYSH)
			.add(IcariaItemIds.COOKED_RED_YELLOW_FYSH)
			.add(IcariaItemIds.RAW_RED_YELLOW_FYSH);

		this.tag(ItemTags.FOOT_ARMOR)
			.add(IcariaItemIds.AETERNAE_HIDE_BOOTS)
			.add(IcariaItemIds.CHALKOS_BOOTS)
			.add(IcariaItemIds.KASSITEROS_BOOTS)
			.add(IcariaItemIds.ORICHALCUM_BOOTS)
			.add(IcariaItemIds.VANADIUMSTEEL_BOOTS);

		this.tag(ItemTags.FOX_FOOD)
			.add(IcariaItemIds.VINEBERRIES)
			.add(IcariaItemIds.STRAWBERRIES);

		this.tag(ItemTags.FREEZE_IMMUNE_WEARABLES)
			.add(IcariaItemIds.AETERNAE_HIDE_HELMET)
			.add(IcariaItemIds.AETERNAE_HIDE_CHESTPLATE)
			.add(IcariaItemIds.AETERNAE_HIDE_LEGGINGS)
			.add(IcariaItemIds.AETERNAE_HIDE_BOOTS);

		this.tag(ItemTags.FURNACE_MINECART_FUEL)
			.add(IcariaItemIds.LIGNITE)
			.add(IcariaItemIds.ANTHRACITE);

		this.tag(ItemTags.GOAT_FOOD)
			.add(IcariaItemIds.SPELT);

		this.tag(ItemTags.HEAD_ARMOR)
			.add(IcariaItemIds.AETERNAE_HIDE_HELMET)
			.add(IcariaItemIds.CHALKOS_HELMET)
			.add(IcariaItemIds.KASSITEROS_HELMET)
			.add(IcariaItemIds.ORICHALCUM_HELMET)
			.add(IcariaItemIds.VANADIUMSTEEL_HELMET);

		this.tag(ItemTags.HOES)
			.add(IcariaItemIds.CHERT_SCYTHE)
			.add(IcariaItemIds.CHALKOS_SCYTHE)
			.add(IcariaItemIds.KASSITEROS_SCYTHE)
			.add(IcariaItemIds.ORICHALCUM_SCYTHE)
			.add(IcariaItemIds.VANADIUMSTEEL_SCYTHE)
			.add(IcariaItemIds.SIDEROS_SCYTHE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SCYTHE);

		this.tag(ItemTags.HORSE_FOOD)
			.add(IcariaBlockItemIds.SPELT_BLOCK.item())
			.add(IcariaItemIds.SPELT);

		this.tag(ItemTags.LEG_ARMOR)
			.add(IcariaItemIds.AETERNAE_HIDE_LEGGINGS)
			.add(IcariaItemIds.CHALKOS_LEGGINGS)
			.add(IcariaItemIds.KASSITEROS_LEGGINGS)
			.add(IcariaItemIds.ORICHALCUM_LEGGINGS)
			.add(IcariaItemIds.VANADIUMSTEEL_LEGGINGS);

		this.tag(ItemTags.LLAMA_FOOD)
			.add(IcariaBlockItemIds.SPELT_BLOCK.item())
			.add(IcariaItemIds.SPELT);

		this.tag(ItemTags.LLAMA_TEMPT_ITEMS)
			.add(IcariaBlockItemIds.SPELT_BLOCK.item());

		this.tag(ItemTags.MEAT)
			.add(IcariaItemIds.RAW_AETERNAE_MEAT)
			.add(IcariaItemIds.COOKED_AETERNAE_MEAT)
			.add(IcariaItemIds.RAW_CAPELLA_MEAT)
			.add(IcariaItemIds.COOKED_CAPELLA_MEAT)
			.add(IcariaItemIds.RAW_CATOBLEPAS_MEAT)
			.add(IcariaItemIds.COOKED_CATOBLEPAS_MEAT)
			.add(IcariaItemIds.RAW_CERVER_MEAT)
			.add(IcariaItemIds.COOKED_CERVER_MEAT)
			.add(IcariaItemIds.RAW_CROCOTTA_MEAT)
			.add(IcariaItemIds.COOKED_CROCOTTA_MEAT)
			.add(IcariaItemIds.RAW_THOG_MEAT)
			.add(IcariaItemIds.COOKED_THOG_MEAT);

		this.tag(ItemTags.METAL_NUGGETS)
			.add(IcariaItemIds.CHALKOS_NUGGET)
			.add(IcariaItemIds.KASSITEROS_NUGGET)
			.add(IcariaItemIds.ORICHALCUM_NUGGET)
			.add(IcariaItemIds.VANADIUM_NUGGET)
			.add(IcariaItemIds.VANADIUMSTEEL_NUGGET)
			.add(IcariaItemIds.SIDEROS_NUGGET)
			.add(IcariaItemIds.MOLYBDENUM_NUGGET)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_NUGGET)
			.add(IcariaItemIds.BLURIDIUM_NUGGET);

		this.tag(ItemTags.OCELOT_FOOD)
			.add(IcariaItemIds.RAW_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.RAW_BROWN_FEESH)
			.add(IcariaItemIds.RAW_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.RAW_PINK_RED_FEESH)
			.add(IcariaItemIds.RAW_PURPLE_FEESH)
			.add(IcariaItemIds.RAW_RED_FEESH)
			.add(IcariaItemIds.RAW_BLUE_RED_FICHE)
			.add(IcariaItemIds.RAW_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.RAW_GRAY_FICHE)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.RAW_RED_FICHE)
			.add(IcariaItemIds.RAW_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.RAW_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_RED_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.RAW_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.RAW_GRAY_FYSH)
			.add(IcariaItemIds.RAW_RAINBOW_FYSH)
			.add(IcariaItemIds.RAW_RED_FYSH)
			.add(IcariaItemIds.RAW_RED_YELLOW_FYSH);

		this.tag(ItemTags.PANDA_EATS_FROM_GROUND)
			.add(IcariaBlockItemIds.LAUREL_CHERRY_CAKE.item())
			.add(IcariaBlockItemIds.STRAWBERRY_CAKE.item())
			.add(IcariaBlockItemIds.PHYSALIS_CAKE.item())
			.add(IcariaBlockItemIds.VINE_BERRY_CAKE.item())
			.add(IcariaBlockItemIds.VINE_SPROUT_CAKE.item());

		this.tag(ItemTags.PARROT_FOOD)
			.add(IcariaBlockItemIds.PHYSALIS_SEEDS.item())
			.add(IcariaBlockItemIds.SPELT_SEEDS.item())
			.add(IcariaBlockItemIds.STRAWBERRY_SEEDS.item());

		this.tag(ItemTags.PICKAXES)
			.add(IcariaItemIds.CHERT_PICKAXE)
			.add(IcariaItemIds.CHALKOS_PICKAXE)
			.add(IcariaItemIds.KASSITEROS_PICKAXE)
			.add(IcariaItemIds.ORICHALCUM_PICKAXE)
			.add(IcariaItemIds.VANADIUMSTEEL_PICKAXE)
			.add(IcariaItemIds.SIDEROS_PICKAXE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_PICKAXE);

		this.tag(ItemTags.PIG_FOOD)
			.add(IcariaItemIds.GARLIC)
			.add(IcariaBlockItemIds.ONION.item());

		this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
			.addTag(IcariaItemTags.TOOLS_DAGGER)
			.addTag(IcariaItemTags.TOOLS_SCYTHE);

		this.tag(ItemTags.SHEEP_FOOD)
			.add(IcariaItemIds.SPELT);

		this.tag(ItemTags.SHOVELS)
			.add(IcariaItemIds.CHERT_SHOVEL)
			.add(IcariaItemIds.CHALKOS_SHOVEL)
			.add(IcariaItemIds.KASSITEROS_SHOVEL)
			.add(IcariaItemIds.ORICHALCUM_SHOVEL)
			.add(IcariaItemIds.VANADIUMSTEEL_SHOVEL)
			.add(IcariaItemIds.SIDEROS_SHOVEL)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SHOVEL);

		this.tag(ItemTags.SKULLS)
			.add(IcariaBlockItemIds.AETERNAE_SKULL.item())
			.add(IcariaBlockItemIds.ARGAN_HOUND_SKULL.item())
			.add(IcariaBlockItemIds.CAPELLA_SKULL.item())
			.add(IcariaBlockItemIds.CATOBLEPAS_SKULL.item())
			.add(IcariaBlockItemIds.CERVER_SKULL.item())
			.add(IcariaBlockItemIds.CROCOTTA_SKULL.item())
			.add(IcariaBlockItemIds.CYPRESS_FOREST_HAG_SKULL.item())
			.add(IcariaBlockItemIds.DROUGHTROOT_FOREST_HAG_SKULL.item())
			.add(IcariaBlockItemIds.FIR_FOREST_HAG_SKULL.item())
			.add(IcariaBlockItemIds.LAUREL_FOREST_HAG_SKULL.item())
			.add(IcariaBlockItemIds.OLIVE_FOREST_HAG_SKULL.item())
			.add(IcariaBlockItemIds.PLANE_FOREST_HAG_SKULL.item())
			.add(IcariaBlockItemIds.POPULUS_FOREST_HAG_SKULL.item())
			.add(IcariaBlockItemIds.REVENANT_SKULL.item())
			.add(IcariaBlockItemIds.THOG_SKULL.item());

		this.tag(ItemTags.SPEARS)
			.add(IcariaItemIds.CHERT_SPEAR)
			.add(IcariaItemIds.CHALKOS_SPEAR)
			.add(IcariaItemIds.KASSITEROS_SPEAR)
			.add(IcariaItemIds.ORICHALCUM_SPEAR)
			.add(IcariaItemIds.VANADIUMSTEEL_SPEAR)
			.add(IcariaItemIds.SIDEROS_SPEAR)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SPEAR);

		this.tag(ItemTags.STONE_CRAFTING_MATERIALS)
			.add(IcariaBlockItemIds.GRAINITE.item())
			.add(IcariaBlockItemIds.COBBLED_YELLOWSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_SILKSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_SUNSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_VOIDSHALE.item())
			.add(IcariaBlockItemIds.COBBLED_BAETYL.item())
			.add(IcariaBlockItemIds.RELICSTONE.item())
			.add(IcariaBlockItemIds.PLATOSHALE.item());

		this.tag(ItemTags.STONE_TOOL_MATERIALS)
			.add(IcariaBlockItemIds.GRAINITE.item())
			.add(IcariaBlockItemIds.COBBLED_YELLOWSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_SILKSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_SUNSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_VOIDSHALE.item())
			.add(IcariaBlockItemIds.COBBLED_BAETYL.item())
			.add(IcariaBlockItemIds.RELICSTONE.item())
			.add(IcariaBlockItemIds.PLATOSHALE.item());

		this.tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_FLAT)
			.add(IcariaBlockItemIds.SPELT_BLOCK.item());

		this.tag(ItemTags.SULFUR_CUBE_ARCHETYPE_FAST_SLIDING)
			.add(IcariaBlockItemIds.PACKED_ARISTONE.item());

		this.tag(ItemTags.SULFUR_CUBE_ARCHETYPE_LIGHT)
			.addTag(IcariaBlockItemTags.TERRY_BLOCKS.item());

		this.tag(ItemTags.SULFUR_CUBE_ARCHETYPE_REGULAR)
			.add(IcariaBlockItemIds.GRASSY_MARL.item())
			.add(IcariaBlockItemIds.MARL.item())
			.add(IcariaBlockItemIds.COARSE_MARL.item())
			.add(IcariaBlockItemIds.DRY_LAKE_BED.item())
			.add(IcariaBlockItemIds.LOAM.item())
			.add(IcariaBlockItemIds.ROTTEN_BONES_BLOCK.item())
			.add(IcariaBlockItemIds.LIGNITE_BLOCK.item())
			.add(IcariaBlockItemIds.ANTHRACITE_BLOCK.item());

		this.tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_BOUNCY)
			.add(IcariaBlockItemIds.LOAM_BRICKS.item())
			.add(IcariaBlockItemIds.SMOOTH_DOLOMITE.item())
			.add(IcariaBlockItemIds.DOLOMITE_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_DOLOMITE.item())
			.add(IcariaBlockItemIds.DOLOMITE_PILLAR.item())
			.add(IcariaBlockItemIds.GRAINITE.item())
			.add(IcariaBlockItemIds.GRAINITE_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_GRAINITE.item())
			.add(IcariaBlockItemIds.COBBLED_YELLOWSTONE.item())
			.add(IcariaBlockItemIds.YELLOWSTONE.item())
			.add(IcariaBlockItemIds.YELLOWSTONE_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_YELLOWSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_SILKSTONE.item())
			.add(IcariaBlockItemIds.SILKSTONE.item())
			.add(IcariaBlockItemIds.SILKSTONE_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_SILKSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_SUNSTONE.item())
			.add(IcariaBlockItemIds.SUNSTONE.item())
			.add(IcariaBlockItemIds.SUNSTONE_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_SUNSTONE.item())
			.add(IcariaBlockItemIds.COBBLED_VOIDSHALE.item())
			.add(IcariaBlockItemIds.VOIDSHALE.item())
			.add(IcariaBlockItemIds.VOIDSHALE_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_VOIDSHALE.item())
			.add(IcariaBlockItemIds.COBBLED_BAETYL.item())
			.add(IcariaBlockItemIds.BAETYL.item())
			.add(IcariaBlockItemIds.BAETYL_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_BAETYL.item())
			.add(IcariaBlockItemIds.RELICSTONE.item())
			.add(IcariaBlockItemIds.SMOOTH_RELICSTONE.item())
			.add(IcariaBlockItemIds.RELICSTONE_BRICKS.item())
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_BRICKS.item())
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_BRICKS.item())
			.add(IcariaBlockItemIds.RELICSTONE_TILES.item())
			.add(IcariaBlockItemIds.CRACKED_RELICSTONE_TILES.item())
			.add(IcariaBlockItemIds.MOSSY_RELICSTONE_TILES.item())
			.add(IcariaBlockItemIds.CHISELED_RELICSTONE.item())
			.add(IcariaBlockItemIds.PLATOSHALE.item())
			.add(IcariaBlockItemIds.BLURRED_PLATOSHALE.item())
			.add(IcariaBlockItemIds.PLATOSHALE_BRICKS.item())
			.add(IcariaBlockItemIds.BLURRED_PLATOSHALE_BRICKS.item())
			.add(IcariaBlockItemIds.CHISELED_PLATOSHALE.item())
			.add(IcariaBlockItemIds.CALCITE_BLOCK.item())
			.add(IcariaBlockItemIds.HALITE_BLOCK.item())
			.add(IcariaBlockItemIds.JASPER_BLOCK.item())
			.add(IcariaBlockItemIds.ZIRCON_BLOCK.item());

		this.tag(ItemTags.SULFUR_CUBE_ARCHETYPE_SLOW_FLAT)
			.add(IcariaBlockItemIds.CHALKOS_ORE.item())
			.add(IcariaBlockItemIds.KASSITEROS_ORE.item())
			.add(IcariaBlockItemIds.VANADIUM_ORE.item())
			.add(IcariaBlockItemIds.SIDEROS_ORE.item())
			.add(IcariaBlockItemIds.MOLYBDENUM_ORE.item())
			.add(IcariaBlockItemIds.RAW_CHALKOS_BLOCK.item())
			.add(IcariaBlockItemIds.RAW_KASSITEROS_BLOCK.item())
			.add(IcariaBlockItemIds.RAW_VANADIUM_BLOCK.item())
			.add(IcariaBlockItemIds.RAW_SIDEROS_BLOCK.item())
			.add(IcariaBlockItemIds.RAW_MOLYBDENUM_BLOCK.item())
			.add(IcariaBlockItemIds.CHALKOS_BLOCK.item())
			.add(IcariaBlockItemIds.KASSITEROS_BLOCK.item())
			.add(IcariaBlockItemIds.ORICHALCUM_BLOCK.item())
			.add(IcariaBlockItemIds.VANADIUM_BLOCK.item())
			.add(IcariaBlockItemIds.VANADIUMSTEEL_BLOCK.item())
			.add(IcariaBlockItemIds.SIDEROS_BLOCK.item())
			.add(IcariaBlockItemIds.MOLYBDENUM_BLOCK.item())
			.add(IcariaBlockItemIds.MOLYBDENUMSTEEL_BLOCK.item());

		this.tag(ItemTags.SWORDS)
			.add(IcariaItemIds.CHERT_SWORD)
			.add(IcariaItemIds.CHALKOS_SWORD)
			.add(IcariaItemIds.KASSITEROS_SWORD)
			.add(IcariaItemIds.ORICHALCUM_SWORD)
			.add(IcariaItemIds.VANADIUMSTEEL_SWORD)
			.add(IcariaItemIds.SIDEROS_SWORD)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SWORD);

		this.tag(ItemTags.VANISHING_ENCHANTABLE)
			.add(IcariaItemIds.LAUREL_WREATH);

		this.tag(ItemTags.VILLAGER_PICKS_UP)
			.add(IcariaItemIds.SPELT)
			.add(IcariaItemIds.STRAWBERRIES)
			.add(IcariaItemIds.PHYSALIS)
			.add(IcariaItemIds.GARLIC);

		this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
			.add(IcariaBlockItemIds.ONION.item())
			.add(IcariaBlockItemIds.PHYSALIS_SEEDS.item())
			.add(IcariaBlockItemIds.SPELT_SEEDS.item())
			.add(IcariaBlockItemIds.STRAWBERRY_SEEDS.item());

		this.tag(ItemTags.WOLF_FOOD)
			.add(IcariaItemIds.COOKED_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.RAW_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.COOKED_BROWN_FEESH)
			.add(IcariaItemIds.RAW_BROWN_FEESH)
			.add(IcariaItemIds.COOKED_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.RAW_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.COOKED_PINK_RED_FEESH)
			.add(IcariaItemIds.RAW_PINK_RED_FEESH)
			.add(IcariaItemIds.COOKED_PURPLE_FEESH)
			.add(IcariaItemIds.RAW_PURPLE_FEESH)
			.add(IcariaItemIds.COOKED_RED_FEESH)
			.add(IcariaItemIds.RAW_RED_FEESH)
			.add(IcariaItemIds.COOKED_BLUE_RED_FICHE)
			.add(IcariaItemIds.RAW_BLUE_RED_FICHE)
			.add(IcariaItemIds.COOKED_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.RAW_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.COOKED_GRAY_FICHE)
			.add(IcariaItemIds.RAW_GRAY_FICHE)
			.add(IcariaItemIds.COOKED_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.COOKED_RED_FICHE)
			.add(IcariaItemIds.RAW_RED_FICHE)
			.add(IcariaItemIds.COOKED_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.RAW_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.COOKED_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_RED_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_RED_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.COOKED_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BROWN_FISSHH)
			.add(IcariaItemIds.COOKED_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.COOKED_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_FYSH)
			.add(IcariaItemIds.COOKED_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.COOKED_GRAY_FYSH)
			.add(IcariaItemIds.RAW_GRAY_FYSH)
			.add(IcariaItemIds.COOKED_RAINBOW_FYSH)
			.add(IcariaItemIds.RAW_RAINBOW_FYSH)
			.add(IcariaItemIds.COOKED_RED_FYSH)
			.add(IcariaItemIds.RAW_RED_FYSH)
			.add(IcariaItemIds.COOKED_RED_YELLOW_FYSH)
			.add(IcariaItemIds.RAW_RED_YELLOW_FYSH)
			.add(IcariaItemIds.AETERNAE_STEW)
			.add(IcariaItemIds.CATOBLEPAS_STEW)
			.add(IcariaItemIds.CERVER_STEW)
			.add(IcariaItemIds.THOG_STEW);

		this.tag(Tags.Items.BRICKS)
			.addTag(IcariaItemTags.BRICKS_LOAM);

		this.tag(Tags.Items.BUCKETS)
			.addTag(IcariaItemTags.BUCKETS_MEDITERRANEAN_WATER);

		this.tag(Tags.Items.CROPS)
			.addTag(IcariaItemTags.CROPS_ONION)
			.addTag(IcariaItemTags.CROPS_PHYSALIS)
			.addTag(IcariaItemTags.CROPS_SPELT)
			.addTag(IcariaItemTags.CROPS_STRAWBERRIES);

		this.tag(Tags.Items.DRINKS_MAGIC)
			.add(IcariaItemIds.ANTI_GRAVITY_FLASK)
			.add(IcariaItemIds.FORTIFYING_FLASK)
			.add(IcariaItemIds.HEALING_FLASK);

		this.tag(Tags.Items.DUSTS)
			.addTag(IcariaItemTags.DUSTS_CALCITE)
			.addTag(IcariaItemTags.DUSTS_HALITE);

		this.tag(Tags.Items.ENCHANTING_FUELS)
			.addTag(IcariaItemTags.GEMS_ZIRCON);

		this.tag(Tags.Items.FERTILIZERS)
			.addTag(IcariaItemTags.DUSTS_CALCITE);

		this.tag(Tags.Items.FOODS_BERRY)
			.add(IcariaItemIds.VINEBERRIES)
			.add(IcariaItemIds.STRAWBERRIES);

		this.tag(Tags.Items.FOODS_BREAD)
			.add(IcariaItemIds.SPELT_BREAD);

		this.tag(Tags.Items.FOODS_COOKED_FISH)
			.add(IcariaItemIds.COOKED_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.COOKED_BROWN_FEESH)
			.add(IcariaItemIds.COOKED_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.COOKED_PINK_RED_FEESH)
			.add(IcariaItemIds.COOKED_PURPLE_FEESH)
			.add(IcariaItemIds.COOKED_RED_FEESH)
			.add(IcariaItemIds.COOKED_BLUE_RED_FICHE)
			.add(IcariaItemIds.COOKED_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.COOKED_GRAY_FICHE)
			.add(IcariaItemIds.COOKED_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.COOKED_RED_FICHE)
			.add(IcariaItemIds.COOKED_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.COOKED_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_RED_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.COOKED_BROWN_FISSHH)
			.add(IcariaItemIds.COOKED_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.COOKED_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.COOKED_BLUE_FYSH)
			.add(IcariaItemIds.COOKED_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.COOKED_GRAY_FYSH)
			.add(IcariaItemIds.COOKED_RAINBOW_FYSH)
			.add(IcariaItemIds.COOKED_RED_FYSH)
			.add(IcariaItemIds.COOKED_RED_YELLOW_FYSH);

		this.tag(Tags.Items.FOODS_COOKED_MEAT)
			.add(IcariaItemIds.COOKED_AETERNAE_MEAT)
			.add(IcariaItemIds.COOKED_CAPELLA_MEAT)
			.add(IcariaItemIds.COOKED_CATOBLEPAS_MEAT)
			.add(IcariaItemIds.COOKED_CERVER_MEAT)
			.add(IcariaItemIds.COOKED_CROCOTTA_MEAT)
			.add(IcariaItemIds.COOKED_THOG_MEAT);

		this.tag(Tags.Items.FOODS_EDIBLE_WHEN_PLACED)
			.add(IcariaBlockItemIds.LAUREL_CHERRY_CAKE.item())
			.add(IcariaBlockItemIds.STRAWBERRY_CAKE.item())
			.add(IcariaBlockItemIds.PHYSALIS_CAKE.item())
			.add(IcariaBlockItemIds.VINE_BERRY_CAKE.item())
			.add(IcariaBlockItemIds.VINE_SPROUT_CAKE.item());

		this.tag(Tags.Items.FOODS_FOOD_POISONING)
			.add(IcariaItemIds.RAW_AETERNAE_MEAT)
			.add(IcariaItemIds.RAW_CAPELLA_MEAT)
			.add(IcariaItemIds.RAW_CATOBLEPAS_MEAT)
			.add(IcariaItemIds.RAW_CERVER_MEAT)
			.add(IcariaItemIds.RAW_CROCOTTA_MEAT)
			.add(IcariaItemIds.RAW_THOG_MEAT)
			.add(IcariaItemIds.RAW_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.RAW_BROWN_FEESH)
			.add(IcariaItemIds.RAW_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.RAW_PINK_RED_FEESH)
			.add(IcariaItemIds.RAW_PURPLE_FEESH)
			.add(IcariaItemIds.RAW_RED_FEESH)
			.add(IcariaItemIds.RAW_BLUE_RED_FICHE)
			.add(IcariaItemIds.RAW_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.RAW_GRAY_FICHE)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.RAW_RED_FICHE)
			.add(IcariaItemIds.RAW_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.RAW_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_RED_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.RAW_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.RAW_GRAY_FYSH)
			.add(IcariaItemIds.RAW_RAINBOW_FYSH)
			.add(IcariaItemIds.RAW_RED_FYSH)
			.add(IcariaItemIds.RAW_RED_YELLOW_FYSH)
			.add(IcariaItemIds.FERMENTED_FISH)
			.add(IcariaItemIds.SNULL_CREAM)
			.add(IcariaItemIds.FERMENTED_SNULL_CREAM);

		this.tag(Tags.Items.FOODS_FRUIT)
			.add(IcariaItemIds.PHYSALIS)
			.add(IcariaItemIds.LAUREL_CHERRY);

		this.tag(Tags.Items.FOODS_RAW_FISH)
			.add(IcariaItemIds.RAW_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.RAW_BROWN_FEESH)
			.add(IcariaItemIds.RAW_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.RAW_PINK_RED_FEESH)
			.add(IcariaItemIds.RAW_PURPLE_FEESH)
			.add(IcariaItemIds.RAW_RED_FEESH)
			.add(IcariaItemIds.RAW_BLUE_RED_FICHE)
			.add(IcariaItemIds.RAW_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.RAW_GRAY_FICHE)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.RAW_RED_FICHE)
			.add(IcariaItemIds.RAW_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.RAW_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_RED_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.RAW_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.RAW_GRAY_FYSH)
			.add(IcariaItemIds.RAW_RAINBOW_FYSH)
			.add(IcariaItemIds.RAW_RED_FYSH)
			.add(IcariaItemIds.RAW_RED_YELLOW_FYSH);

		this.tag(Tags.Items.FOODS_RAW_MEAT)
			.add(IcariaItemIds.RAW_AETERNAE_MEAT)
			.add(IcariaItemIds.RAW_CAPELLA_MEAT)
			.add(IcariaItemIds.RAW_CATOBLEPAS_MEAT)
			.add(IcariaItemIds.RAW_CERVER_MEAT)
			.add(IcariaItemIds.RAW_CROCOTTA_MEAT)
			.add(IcariaItemIds.RAW_THOG_MEAT);

		this.tag(Tags.Items.FOODS_SOUP)
			.add(IcariaItemIds.ONION_SOUP)
			.add(IcariaItemIds.AETERNAE_STEW)
			.add(IcariaItemIds.CATOBLEPAS_STEW)
			.add(IcariaItemIds.CERVER_STEW)
			.add(IcariaItemIds.THOG_STEW);

		this.tag(Tags.Items.FOODS_VEGETABLE)
			.add(IcariaItemIds.BLACK_OLIVES)
			.add(IcariaItemIds.GREEN_OLIVES)
			.add(IcariaItemIds.GARLIC)
			.add(IcariaBlockItemIds.ONION.item());

		this.tag(Tags.Items.GEMS)
			.addTag(IcariaItemTags.GEMS_ANTHRACITE)
			.addTag(IcariaItemTags.GEMS_CALCITE)
			.addTag(IcariaItemTags.GEMS_CHERT)
			.addTag(IcariaItemTags.GEMS_DOLOMITE)
			.addTag(IcariaItemTags.GEMS_HALITE)
			.addTag(IcariaItemTags.GEMS_JASPER)
			.addTag(IcariaItemTags.GEMS_LIGNITE)
			.addTag(IcariaItemTags.GEMS_SLIVER)
			.addTag(IcariaItemTags.GEMS_ZIRCON);

		this.tag(Tags.Items.INGOTS)
			.addTag(IcariaItemTags.INGOTS_BLURIDIUM)
			.addTag(IcariaItemTags.INGOTS_CHALKOS)
			.addTag(IcariaItemTags.INGOTS_KASSITEROS)
			.addTag(IcariaItemTags.INGOTS_MOLYBDENUM)
			.addTag(IcariaItemTags.INGOTS_MOLYBDENUMSTEEL)
			.addTag(IcariaItemTags.INGOTS_ORICHALCUM)
			.addTag(IcariaItemTags.INGOTS_SIDEROS)
			.addTag(IcariaItemTags.INGOTS_VANADIUM)
			.addTag(IcariaItemTags.INGOTS_VANADIUMSTEEL);

		this.tag(Tags.Items.LEATHERS)
			.add(IcariaItemIds.AETERNAE_HIDE);

		this.tag(Tags.Items.MELEE_WEAPON_TOOLS)
			.add(IcariaItemIds.CHERT_SWORD)
			.add(IcariaItemIds.CHERT_DAGGER)
			.add(IcariaItemIds.CHERT_AXE)
			.add(IcariaItemIds.CHERT_SCYTHE)
			.add(IcariaItemIds.CHERT_BIDENT)
			.add(IcariaItemIds.CHERT_SPEAR)
			.add(IcariaItemIds.CHALKOS_SWORD)
			.add(IcariaItemIds.CHALKOS_DAGGER)
			.add(IcariaItemIds.CHALKOS_AXE)
			.add(IcariaItemIds.CHALKOS_SCYTHE)
			.add(IcariaItemIds.CHALKOS_BIDENT)
			.add(IcariaItemIds.CHALKOS_SPEAR)
			.add(IcariaItemIds.KASSITEROS_SWORD)
			.add(IcariaItemIds.KASSITEROS_DAGGER)
			.add(IcariaItemIds.KASSITEROS_AXE)
			.add(IcariaItemIds.KASSITEROS_SCYTHE)
			.add(IcariaItemIds.KASSITEROS_BIDENT)
			.add(IcariaItemIds.KASSITEROS_SPEAR)
			.add(IcariaItemIds.ORICHALCUM_SWORD)
			.add(IcariaItemIds.ORICHALCUM_DAGGER)
			.add(IcariaItemIds.ORICHALCUM_AXE)
			.add(IcariaItemIds.ORICHALCUM_SCYTHE)
			.add(IcariaItemIds.ORICHALCUM_BIDENT)
			.add(IcariaItemIds.ORICHALCUM_SPEAR)
			.add(IcariaItemIds.VANADIUMSTEEL_SWORD)
			.add(IcariaItemIds.VANADIUMSTEEL_DAGGER)
			.add(IcariaItemIds.VANADIUMSTEEL_AXE)
			.add(IcariaItemIds.VANADIUMSTEEL_SCYTHE)
			.add(IcariaItemIds.VANADIUMSTEEL_BIDENT)
			.add(IcariaItemIds.VANADIUMSTEEL_SPEAR)
			.add(IcariaItemIds.SIDEROS_SWORD)
			.add(IcariaItemIds.SIDEROS_DAGGER)
			.add(IcariaItemIds.SIDEROS_AXE)
			.add(IcariaItemIds.SIDEROS_SCYTHE)
			.add(IcariaItemIds.SIDEROS_BIDENT)
			.add(IcariaItemIds.SIDEROS_SPEAR)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SWORD)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_DAGGER)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_AXE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SCYTHE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_BIDENT)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SPEAR);

		this.tag(Tags.Items.MINING_TOOL_TOOLS)
			.add(IcariaItemIds.CHERT_PICKAXE)
			.add(IcariaItemIds.CHALKOS_PICKAXE)
			.add(IcariaItemIds.KASSITEROS_PICKAXE)
			.add(IcariaItemIds.ORICHALCUM_PICKAXE)
			.add(IcariaItemIds.VANADIUMSTEEL_PICKAXE)
			.add(IcariaItemIds.SIDEROS_PICKAXE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_PICKAXE);

		this.tag(Tags.Items.MUSHROOMS)
			.add(IcariaBlockItemIds.GREEN_GROUND_SHROOMS.item())
			.add(IcariaBlockItemIds.BROWN_GROUND_SHROOMS.item())
			.add(IcariaBlockItemIds.LARGE_BROWN_GROUND_SHROOMS.item())
			.add(IcariaBlockItemIds.TINDER_FUNGUS_TREE_SHROOMS.item())
			.add(IcariaBlockItemIds.TURKEY_TAIL_TREE_SHROOMS.item())
			.add(IcariaBlockItemIds.UNNAMED_TREE_SHROOMS.item());

		this.tag(Tags.Items.NUGGETS)
			.addTag(IcariaItemTags.NUGGETS_BLURIDIUM)
			.addTag(IcariaItemTags.NUGGETS_CHALKOS)
			.addTag(IcariaItemTags.NUGGETS_KASSITEROS)
			.addTag(IcariaItemTags.NUGGETS_MOLYBDENUM)
			.addTag(IcariaItemTags.NUGGETS_MOLYBDENUMSTEEL)
			.addTag(IcariaItemTags.NUGGETS_ORICHALCUM)
			.addTag(IcariaItemTags.NUGGETS_SIDEROS)
			.addTag(IcariaItemTags.NUGGETS_VANADIUM)
			.addTag(IcariaItemTags.NUGGETS_VANADIUMSTEEL);

		this.tag(Tags.Items.RANGED_WEAPON_TOOLS)
			.add(IcariaItemIds.CHERT_BIDENT)
			.add(IcariaItemIds.CHALKOS_BIDENT)
			.add(IcariaItemIds.KASSITEROS_BIDENT)
			.add(IcariaItemIds.ORICHALCUM_BIDENT)
			.add(IcariaItemIds.VANADIUMSTEEL_BIDENT)
			.add(IcariaItemIds.SIDEROS_BIDENT)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_BIDENT);

		this.tag(Tags.Items.RAW_MATERIALS)
			.addTag(IcariaItemTags.RAW_MATERIALS_CHALKOS)
			.addTag(IcariaItemTags.RAW_MATERIALS_KASSITEROS)
			.addTag(IcariaItemTags.RAW_MATERIALS_MOLYBDENUM)
			.addTag(IcariaItemTags.RAW_MATERIALS_SIDEROS)
			.addTag(IcariaItemTags.RAW_MATERIALS_VANADIUM);

		this.tag(Tags.Items.SEEDS)
			.addTag(IcariaItemTags.SEEDS_ONION)
			.addTag(IcariaItemTags.SEEDS_PHYSALIS)
			.addTag(IcariaItemTags.SEEDS_SPELT)
			.addTag(IcariaItemTags.SEEDS_STRAWBERRY);

		this.tag(Tags.Items.STRINGS)
			.add(IcariaItemIds.ARACHNE_STRING);

		this.tag(IcariaItemTags.BRICKS_LOAM)
			.add(IcariaItemIds.LOAM_BRICK);

		this.tag(IcariaItemTags.BUCKETS_MEDITERRANEAN_WATER)
			.add(IcariaItemIds.MEDITERRANEAN_WATER_BUCKET);

		this.tag(IcariaItemTags.CROPS_ONION)
			.add(IcariaBlockItemIds.ONION.item());

		this.tag(IcariaItemTags.CROPS_PHYSALIS)
			.add(IcariaItemIds.PHYSALIS);

		this.tag(IcariaItemTags.CROPS_SPELT)
			.add(IcariaItemIds.SPELT);

		this.tag(IcariaItemTags.CROPS_STRAWBERRIES)
			.add(IcariaItemIds.STRAWBERRIES);

		this.tag(IcariaItemTags.DUSTS_CALCITE)
			.add(IcariaItemIds.CALCITE_DUST);

		this.tag(IcariaItemTags.DUSTS_HALITE)
			.add(IcariaItemIds.HALITE_DUST);

		this.tag(IcariaItemTags.FIREPLACE_ITEMS)
			.add(BlockItemIds.KELP.item())
			.add(BlockItemIds.POTATO_CROP.item())
			.add(ItemIds.BEEF)
			.add(ItemIds.CHICKEN)
			.add(ItemIds.COD)
			.add(ItemIds.MUTTON)
			.add(ItemIds.PORKCHOP)
			.add(ItemIds.RABBIT)
			.add(ItemIds.SALMON)
			.add(IcariaItemIds.RAW_AETERNAE_MEAT)
			.add(IcariaItemIds.RAW_CAPELLA_MEAT)
			.add(IcariaItemIds.RAW_CATOBLEPAS_MEAT)
			.add(IcariaItemIds.RAW_CERVER_MEAT)
			.add(IcariaItemIds.RAW_CROCOTTA_MEAT)
			.add(IcariaItemIds.RAW_THOG_MEAT)
			.add(IcariaItemIds.RAW_BLUE_GRAY_FEESH)
			.add(IcariaItemIds.RAW_BROWN_FEESH)
			.add(IcariaItemIds.RAW_BROWN_ORANGE_FEESH)
			.add(IcariaItemIds.RAW_PINK_RED_FEESH)
			.add(IcariaItemIds.RAW_PURPLE_FEESH)
			.add(IcariaItemIds.RAW_RED_FEESH)
			.add(IcariaItemIds.RAW_BLUE_RED_FICHE)
			.add(IcariaItemIds.RAW_BROWN_CYAN_FICHE)
			.add(IcariaItemIds.RAW_GRAY_FICHE)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FICHE)
			.add(IcariaItemIds.RAW_RED_FICHE)
			.add(IcariaItemIds.RAW_WHITE_YELLOW_FICHE)
			.add(IcariaItemIds.RAW_BLUE_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_RED_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BROWN_FISSHH)
			.add(IcariaItemIds.RAW_GREEN_MAGENTA_FISSHH)
			.add(IcariaItemIds.RAW_PURPLE_YELLOW_FISSHH)
			.add(IcariaItemIds.RAW_BLUE_FYSH)
			.add(IcariaItemIds.RAW_BLUE_PURPLE_FYSH)
			.add(IcariaItemIds.RAW_GRAY_FYSH)
			.add(IcariaItemIds.RAW_RAINBOW_FYSH)
			.add(IcariaItemIds.RAW_RED_FYSH)
			.add(IcariaItemIds.RAW_RED_YELLOW_FYSH);

		this.tag(IcariaItemTags.GEMS_ANTHRACITE)
			.add(IcariaItemIds.ANTHRACITE);

		this.tag(IcariaItemTags.GEMS_CALCITE)
			.add(IcariaItemIds.CALCITE_SHARD);

		this.tag(IcariaItemTags.GEMS_CHERT)
			.add(IcariaItemIds.CHERT);

		this.tag(IcariaItemTags.GEMS_DOLOMITE)
			.add(IcariaItemIds.DOLOMITE);

		this.tag(IcariaItemTags.GEMS_HALITE)
			.add(IcariaItemIds.HALITE_SHARD);

		this.tag(IcariaItemTags.GEMS_JASPER)
			.add(IcariaItemIds.JASPER_SHARD);

		this.tag(IcariaItemTags.GEMS_LIGNITE)
			.add(IcariaItemIds.LIGNITE);

		this.tag(IcariaItemTags.GEMS_SLIVER)
			.add(IcariaItemIds.SLIVER);

		this.tag(IcariaItemTags.GEMS_ZIRCON)
			.add(IcariaItemIds.ZIRCON_SHARD);

		this.tag(IcariaItemTags.GRINDER_GEARS)
			.add(IcariaItemIds.YELLOWSTONE_GEAR)
			.add(IcariaItemIds.LOAM_GEAR)
			.add(IcariaItemIds.VOIDSHALE_GEAR)
			.add(IcariaItemIds.VANADIUM_GEAR)
			.add(IcariaItemIds.DAEDALIAN_GEAR);

		this.tag(IcariaItemTags.INGOTS_BLURIDIUM)
			.add(IcariaItemIds.BLURIDIUM_INGOT);

		this.tag(IcariaItemTags.INGOTS_CHALKOS)
			.add(IcariaItemIds.CHALKOS_INGOT);

		this.tag(IcariaItemTags.INGOTS_KASSITEROS)
			.add(IcariaItemIds.KASSITEROS_INGOT);

		this.tag(IcariaItemTags.INGOTS_MOLYBDENUM)
			.add(IcariaItemIds.MOLYBDENUM_INGOT);

		this.tag(IcariaItemTags.INGOTS_MOLYBDENUMSTEEL)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_INGOT);

		this.tag(IcariaItemTags.INGOTS_ORICHALCUM)
			.add(IcariaItemIds.ORICHALCUM_INGOT);

		this.tag(IcariaItemTags.INGOTS_SIDEROS)
			.add(IcariaItemIds.SIDEROS_INGOT);

		this.tag(IcariaItemTags.INGOTS_VANADIUM)
			.add(IcariaItemIds.VANADIUM_INGOT);

		this.tag(IcariaItemTags.INGOTS_VANADIUMSTEEL)
			.add(IcariaItemIds.VANADIUMSTEEL_INGOT);

		this.tag(IcariaItemTags.KETTLE_ITEMS)
			.add(IcariaBlockItemIds.BOLBOS.item())
			.add(IcariaBlockItemIds.DATHULLA.item())
			.add(IcariaBlockItemIds.MONDANOS.item())
			.add(IcariaBlockItemIds.MOTH_AGARIC.item())
			.add(IcariaBlockItemIds.NAMDRAKE.item())
			.add(IcariaBlockItemIds.PSILOCYBOS.item())
			.add(IcariaBlockItemIds.ROWAN.item())
			.add(IcariaBlockItemIds.WILTED_ELM.item())
			.add(IcariaItemIds.BONE_REMAINS)
			.add(IcariaItemIds.ARACHNE_VENOM_VIAL)
			.add(IcariaItemIds.HYLIASTRUM_VIAL);

		this.tag(IcariaItemTags.NUGGETS_BLURIDIUM)
			.add(IcariaItemIds.BLURIDIUM_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_CHALKOS)
			.add(IcariaItemIds.CHALKOS_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_KASSITEROS)
			.add(IcariaItemIds.KASSITEROS_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_ORICHALCUM)
			.add(IcariaItemIds.ORICHALCUM_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_MOLYBDENUM)
			.add(IcariaItemIds.MOLYBDENUM_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_MOLYBDENUMSTEEL)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_SIDEROS)
			.add(IcariaItemIds.SIDEROS_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_VANADIUM)
			.add(IcariaItemIds.VANADIUM_NUGGET);

		this.tag(IcariaItemTags.NUGGETS_VANADIUMSTEEL)
			.add(IcariaItemIds.VANADIUMSTEEL_NUGGET);

		this.tag(IcariaItemTags.RAW_MATERIALS_CHALKOS)
			.add(IcariaItemIds.RAW_CHALKOS);

		this.tag(IcariaItemTags.RAW_MATERIALS_KASSITEROS)
			.add(IcariaItemIds.RAW_KASSITEROS);

		this.tag(IcariaItemTags.RAW_MATERIALS_MOLYBDENUM)
			.add(IcariaItemIds.RAW_MOLYBDENUM);

		this.tag(IcariaItemTags.RAW_MATERIALS_SIDEROS)
			.add(IcariaItemIds.RAW_SIDEROS);

		this.tag(IcariaItemTags.RAW_MATERIALS_VANADIUM)
			.add(IcariaItemIds.RAW_VANADIUM);

		this.tag(IcariaItemTags.REPAIRS_AETERNAE_HIDE_ARMOR)
			.add(IcariaItemIds.AETERNAE_HIDE);

		this.tag(IcariaItemTags.REPAIRS_CHALKOS_ARMOR)
			.add(IcariaItemIds.CHALKOS_INGOT);

		this.tag(IcariaItemTags.REPAIRS_KASSITEROS_ARMOR)
			.add(IcariaItemIds.KASSITEROS_INGOT);

		this.tag(IcariaItemTags.REPAIRS_LAUREL_WREATH);

		this.tag(IcariaItemTags.REPAIRS_LOAM_GEAR)
			.add(IcariaItemIds.LOAM_BRICK);

		this.tag(IcariaItemTags.REPAIRS_ORICHALCUM_ARMOR)
			.add(IcariaItemIds.ORICHALCUM_INGOT);

		this.tag(IcariaItemTags.REPAIRS_TOTEM)
			.add(IcariaItemIds.BLURIDIUM_NUGGET);

		this.tag(IcariaItemTags.REPAIRS_VANADIUM_GEAR)
			.add(IcariaItemIds.VANADIUM_INGOT);

		this.tag(IcariaItemTags.REPAIRS_VANADIUMSTEEL_ARMOR)
			.add(IcariaItemIds.VANADIUMSTEEL_INGOT);

		this.tag(IcariaItemTags.REPAIRS_VINE_SPROUT);

		this.tag(IcariaItemTags.REPAIRS_VOIDSHALE_GEAR)
			.add(IcariaBlockItemIds.VOIDSHALE.item());

		this.tag(IcariaItemTags.REPAIRS_YELLOWSTONE_GEAR)
			.add(IcariaBlockItemIds.YELLOWSTONE.item());

		this.tag(IcariaItemTags.SEEDS_ONION)
			.add(IcariaBlockItemIds.ONION.item());

		this.tag(IcariaItemTags.SEEDS_PHYSALIS)
			.add(IcariaBlockItemIds.PHYSALIS_SEEDS.item());

		this.tag(IcariaItemTags.SEEDS_SPELT)
			.add(IcariaBlockItemIds.SPELT_SEEDS.item());

		this.tag(IcariaItemTags.SEEDS_STRAWBERRY)
			.add(IcariaBlockItemIds.STRAWBERRY_SEEDS.item());

		this.tag(IcariaItemTags.TOOL_MATERIALS_CHALKOS)
			.add(IcariaItemIds.CHALKOS_INGOT);

		this.tag(IcariaItemTags.TOOL_MATERIALS_CHERT)
			.add(IcariaItemIds.CHERT);

		this.tag(IcariaItemTags.TOOL_MATERIALS_KASSITEROS)
			.add(IcariaItemIds.KASSITEROS_INGOT);

		this.tag(IcariaItemTags.TOOL_MATERIALS_MOLYBDENUMSTEEL)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_INGOT);

		this.tag(IcariaItemTags.TOOL_MATERIALS_ORICHALCUM)
			.add(IcariaItemIds.ORICHALCUM_INGOT);

		this.tag(IcariaItemTags.TOOL_MATERIALS_SIDEROS)
			.add(IcariaItemIds.SIDEROS_INGOT);

		this.tag(IcariaItemTags.TOOL_MATERIALS_VANADIUMSTEEL)
			.add(IcariaItemIds.VANADIUMSTEEL_INGOT);

		this.tag(IcariaItemTags.TOOLS_BIDENT)
			.add(IcariaItemIds.CHERT_BIDENT)
			.add(IcariaItemIds.CHALKOS_BIDENT)
			.add(IcariaItemIds.KASSITEROS_BIDENT)
			.add(IcariaItemIds.ORICHALCUM_BIDENT)
			.add(IcariaItemIds.VANADIUMSTEEL_BIDENT)
			.add(IcariaItemIds.SIDEROS_BIDENT)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_BIDENT);

		this.tag(IcariaItemTags.TOOLS_DAGGER)
			.add(IcariaItemIds.CHERT_DAGGER)
			.add(IcariaItemIds.CHALKOS_DAGGER)
			.add(IcariaItemIds.KASSITEROS_DAGGER)
			.add(IcariaItemIds.ORICHALCUM_DAGGER)
			.add(IcariaItemIds.VANADIUMSTEEL_DAGGER)
			.add(IcariaItemIds.SIDEROS_DAGGER)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_DAGGER);

		this.tag(IcariaItemTags.TOOLS_SCYTHE)
			.add(IcariaItemIds.CHERT_SCYTHE)
			.add(IcariaItemIds.CHALKOS_SCYTHE)
			.add(IcariaItemIds.KASSITEROS_SCYTHE)
			.add(IcariaItemIds.ORICHALCUM_SCYTHE)
			.add(IcariaItemIds.VANADIUMSTEEL_SCYTHE)
			.add(IcariaItemIds.SIDEROS_SCYTHE)
			.add(IcariaItemIds.MOLYBDENUMSTEEL_SCYTHE);

		this.tag(IcariaItemTags.UNFIRED_STORAGE_VASES)
			.add(IcariaItemIds.UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.WHITE_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.LIGHT_GRAY_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.GRAY_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.BLACK_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.BROWN_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.RED_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.ORANGE_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.YELLOW_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.LIME_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.GREEN_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.CYAN_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.LIGHT_BLUE_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.BLUE_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.PURPLE_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.MAGENTA_UNFIRED_STORAGE_VASE)
			.add(IcariaItemIds.PINK_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.BARS)
			.addTag(IcariaBlockItemTags.BARS_VANADIUMSTEEL.item());

		this.tag(Tags.Items.BUDDING_BLOCKS)
			.add(IcariaBlockItemIds.BUDDING_CALCITE.item())
			.add(IcariaBlockItemIds.BUDDING_HALITE.item())
			.add(IcariaBlockItemIds.BUDDING_JASPER.item())
			.add(IcariaBlockItemIds.BUDDING_ZIRCON.item());

		this.tag(Tags.Items.CHAINS)
			.add(IcariaBlockItemIds.VANADIUMSTEEL_CHAIN.item());

		this.tag(Tags.Items.CHESTS_TRAPPED)
			.add(IcariaBlockItemIds.TRAPPED_CHEST.item());

		this.tag(Tags.Items.CHESTS_WOODEN)
			.add(IcariaBlockItemIds.CHEST.item())
			.add(IcariaBlockItemIds.TRAPPED_CHEST.item());

		this.tag(Tags.Items.CLUSTERS)
			.add(IcariaBlockItemIds.CALCITE_CLUSTER.item())
			.add(IcariaBlockItemIds.HALITE_CLUSTER.item())
			.add(IcariaBlockItemIds.JASPER_CLUSTER.item())
			.add(IcariaBlockItemIds.ZIRCON_CLUSTER.item());

		this.tag(Tags.Items.COBBLESTONES)
			.addTag(IcariaBlockItemTags.COBBLESTONES_BAETYL.item())
			.addTag(IcariaBlockItemTags.COBBLESTONES_SILKSTONE.item())
			.addTag(IcariaBlockItemTags.COBBLESTONES_SUNSTONE.item())
			.addTag(IcariaBlockItemTags.COBBLESTONES_VOIDSHALE.item())
			.addTag(IcariaBlockItemTags.COBBLESTONES_YELLOWSTONE.item());

		this.tag(Tags.Items.DYED_BLACK)
			.add(IcariaBlockItemIds.BLACK_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.BLACK_TERRY_MAT.item())
			.add(IcariaBlockItemIds.BLACK_STORAGE_VASE.item())
			.add(IcariaItemIds.BLACK_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_BLUE)
			.add(IcariaBlockItemIds.BLUE_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.BLUE_TERRY_MAT.item())
			.add(IcariaBlockItemIds.BLUE_STORAGE_VASE.item())
			.add(IcariaItemIds.BLUE_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_BROWN)
			.add(IcariaBlockItemIds.BROWN_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.BROWN_TERRY_MAT.item())
			.add(IcariaBlockItemIds.BROWN_STORAGE_VASE.item())
			.add(IcariaItemIds.BROWN_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_CYAN)
			.add(IcariaBlockItemIds.CYAN_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.CYAN_TERRY_MAT.item())
			.add(IcariaBlockItemIds.CYAN_STORAGE_VASE.item())
			.add(IcariaItemIds.CYAN_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_GRAY)
			.add(IcariaBlockItemIds.GRAY_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.GRAY_TERRY_MAT.item())
			.add(IcariaBlockItemIds.GRAY_STORAGE_VASE.item())
			.add(IcariaItemIds.GRAY_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_GREEN)
			.add(IcariaBlockItemIds.GREEN_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.GREEN_TERRY_MAT.item())
			.add(IcariaBlockItemIds.GREEN_STORAGE_VASE.item())
			.add(IcariaItemIds.GREEN_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_LIGHT_BLUE)
			.add(IcariaBlockItemIds.LIGHT_BLUE_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.LIGHT_BLUE_TERRY_MAT.item())
			.add(IcariaBlockItemIds.LIGHT_BLUE_STORAGE_VASE.item())
			.add(IcariaItemIds.LIGHT_BLUE_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_LIGHT_GRAY)
			.add(IcariaBlockItemIds.LIGHT_GRAY_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.LIGHT_GRAY_TERRY_MAT.item())
			.add(IcariaBlockItemIds.LIGHT_GRAY_STORAGE_VASE.item())
			.add(IcariaItemIds.LIGHT_GRAY_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_LIME)
			.add(IcariaBlockItemIds.LIME_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.LIME_TERRY_MAT.item())
			.add(IcariaBlockItemIds.LIME_STORAGE_VASE.item())
			.add(IcariaItemIds.LIME_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_MAGENTA)
			.add(IcariaBlockItemIds.MAGENTA_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.MAGENTA_TERRY_MAT.item())
			.add(IcariaBlockItemIds.MAGENTA_STORAGE_VASE.item())
			.add(IcariaItemIds.MAGENTA_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_ORANGE)
			.add(IcariaBlockItemIds.ORANGE_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.ORANGE_TERRY_MAT.item())
			.add(IcariaBlockItemIds.ORANGE_STORAGE_VASE.item())
			.add(IcariaItemIds.ORANGE_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_PINK)
			.add(IcariaBlockItemIds.PINK_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.PINK_TERRY_MAT.item())
			.add(IcariaBlockItemIds.PINK_STORAGE_VASE.item())
			.add(IcariaItemIds.PINK_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_PURPLE)
			.add(IcariaBlockItemIds.PURPLE_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.PURPLE_TERRY_MAT.item())
			.add(IcariaBlockItemIds.PURPLE_STORAGE_VASE.item())
			.add(IcariaItemIds.PURPLE_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_RED)
			.add(IcariaBlockItemIds.RED_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.RED_TERRY_MAT.item())
			.add(IcariaBlockItemIds.RED_STORAGE_VASE.item())
			.add(IcariaItemIds.RED_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_WHITE)
			.add(IcariaBlockItemIds.WHITE_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.WHITE_TERRY_MAT.item())
			.add(IcariaBlockItemIds.WHITE_STORAGE_VASE.item())
			.add(IcariaItemIds.WHITE_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.DYED_YELLOW)
			.add(IcariaBlockItemIds.YELLOW_TERRY_BLOCK.item())
			.add(IcariaBlockItemIds.YELLOW_TERRY_MAT.item())
			.add(IcariaBlockItemIds.YELLOW_STORAGE_VASE.item())
			.add(IcariaItemIds.YELLOW_UNFIRED_STORAGE_VASE);

		this.tag(Tags.Items.FENCE_GATES_WOODEN)
			.add(IcariaBlockItemIds.CYPRESS_FENCE_GATE.item())
			.add(IcariaBlockItemIds.DROUGHTROOT_FENCE_GATE.item())
			.add(IcariaBlockItemIds.FIR_FENCE_GATE.item())
			.add(IcariaBlockItemIds.LAUREL_FENCE_GATE.item())
			.add(IcariaBlockItemIds.OLIVE_FENCE_GATE.item())
			.add(IcariaBlockItemIds.PLANE_FENCE_GATE.item())
			.add(IcariaBlockItemIds.POPULUS_FENCE_GATE.item());

		this.tag(Tags.Items.FENCES_WOODEN)
			.add(IcariaBlockItemIds.CYPRESS_FENCE.item())
			.add(IcariaBlockItemIds.DROUGHTROOT_FENCE.item())
			.add(IcariaBlockItemIds.FIR_FENCE.item())
			.add(IcariaBlockItemIds.LAUREL_FENCE.item())
			.add(IcariaBlockItemIds.OLIVE_FENCE.item())
			.add(IcariaBlockItemIds.PLANE_FENCE.item())
			.add(IcariaBlockItemIds.POPULUS_FENCE.item());

		this.tag(Tags.Items.FLOWERS_SMALL)
			.add(IcariaBlockItemIds.BLINDWEED.item())
			.add(IcariaBlockItemIds.CHAMEOMILE.item())
			.add(IcariaBlockItemIds.CHARMONDER.item())
			.add(IcariaBlockItemIds.CLOVER.item())
			.add(IcariaBlockItemIds.FIREHILT.item())
			.add(IcariaBlockItemIds.BLUE_HYDRACINTH.item())
			.add(IcariaBlockItemIds.PURPLE_HYDRACINTH.item())
			.add(IcariaBlockItemIds.LIONFANGS.item())
			.add(IcariaBlockItemIds.SPEARDROPS.item())
			.add(IcariaBlockItemIds.PURPLE_STAGHORN.item())
			.add(IcariaBlockItemIds.YELLOW_STAGHORN.item())
			.add(IcariaBlockItemIds.BLUE_STORMCOTTON.item())
			.add(IcariaBlockItemIds.PINK_STORMCOTTON.item())
			.add(IcariaBlockItemIds.PURPLE_STORMCOTTON.item())
			.add(IcariaBlockItemIds.SUNKETTLE.item())
			.add(IcariaBlockItemIds.SUNSPONGE.item())
			.add(IcariaBlockItemIds.VOIDLILY.item());

		this.tag(Tags.Items.GLASS_BLOCKS)
			.add(IcariaBlockItemIds.CALCITE_GLASS.item())
			.add(IcariaBlockItemIds.HALITE_GLASS.item())
			.add(IcariaBlockItemIds.JASPER_GLASS.item())
			.add(IcariaBlockItemIds.ZIRCON_GLASS.item());

		this.tag(Tags.Items.GLASS_BLOCKS_CHEAP)
			.add(IcariaBlockItemIds.GRAINGLASS.item())
			.add(IcariaBlockItemIds.SILKGLASS.item());

		this.tag(Tags.Items.GLASS_PANES)
			.add(IcariaBlockItemIds.GRAINGLASS_PANE.item())
			.add(IcariaBlockItemIds.HORIZONTAL_GRAINGLASS_PANE.item())
			.add(IcariaBlockItemIds.SILKGLASS_PANE.item())
			.add(IcariaBlockItemIds.HORIZONTAL_SILKGLASS_PANE.item());

		this.tag(Tags.Items.NATURAL_LOGS)
			.add(IcariaBlockItemIds.CYPRESS_LOG.item())
			.add(IcariaBlockItemIds.DEAD_CYPRESS_LOG.item())
			.add(IcariaBlockItemIds.DROUGHTROOT_LOG.item())
			.add(IcariaBlockItemIds.DEAD_DROUGHTROOT_LOG.item())
			.add(IcariaBlockItemIds.FIR_LOG.item())
			.add(IcariaBlockItemIds.DEAD_FIR_LOG.item())
			.add(IcariaBlockItemIds.LAUREL_LOG.item())
			.add(IcariaBlockItemIds.DEAD_LAUREL_LOG.item())
			.add(IcariaBlockItemIds.OLIVE_LOG.item())
			.add(IcariaBlockItemIds.DEAD_OLIVE_LOG.item())
			.add(IcariaBlockItemIds.PLANE_LOG.item())
			.add(IcariaBlockItemIds.DEAD_PLANE_LOG.item())
			.add(IcariaBlockItemIds.POPULUS_LOG.item())
			.add(IcariaBlockItemIds.DEAD_POPULUS_LOG.item());

		this.tag(Tags.Items.NATURAL_WOODS)
			.add(IcariaBlockItemIds.CYPRESS_WOOD.item())
			.add(IcariaBlockItemIds.DROUGHTROOT_WOOD.item())
			.add(IcariaBlockItemIds.FIR_WOOD.item())
			.add(IcariaBlockItemIds.LAUREL_WOOD.item())
			.add(IcariaBlockItemIds.OLIVE_WOOD.item())
			.add(IcariaBlockItemIds.PLANE_WOOD.item())
			.add(IcariaBlockItemIds.POPULUS_WOOD.item());

		this.tag(Tags.Items.ORE_RATES_SINGULAR)
			.add(IcariaBlockItemIds.MARL_BONES.item())
			.add(IcariaBlockItemIds.MARL_CHERT_ORE.item())
			.add(IcariaBlockItemIds.MARL_LIGNITE_ORE.item())
			.add(IcariaBlockItemIds.CHERT_ORE.item())
			.add(IcariaBlockItemIds.LIGNITE_ORE.item())
			.add(IcariaBlockItemIds.CHALKOS_ORE.item())
			.add(IcariaBlockItemIds.KASSITEROS_ORE.item())
			.add(IcariaBlockItemIds.DOLOMITE_ORE.item())
			.add(IcariaBlockItemIds.VANADIUM_ORE.item())
			.add(IcariaBlockItemIds.SLIVER_ORE.item())
			.add(IcariaBlockItemIds.SIDEROS_ORE.item())
			.add(IcariaBlockItemIds.ANTHRACITE_ORE.item())
			.add(IcariaBlockItemIds.MOLYBDENUM_ORE.item());

		this.tag(Tags.Items.ORES)
			.addTag(IcariaBlockItemTags.ORES_ANTHRACITE.item())
			.addTag(IcariaBlockItemTags.ORES_BONE.item())
			.addTag(IcariaBlockItemTags.ORES_CHALKOS.item())
			.addTag(IcariaBlockItemTags.ORES_CHERT.item())
			.addTag(IcariaBlockItemTags.ORES_DOLOMITE.item())
			.addTag(IcariaBlockItemTags.ORES_HYLIASTRUM.item())
			.addTag(IcariaBlockItemTags.ORES_KASSITEROS.item())
			.addTag(IcariaBlockItemTags.ORES_LIGNITE.item())
			.addTag(IcariaBlockItemTags.ORES_MOLYBDENUM.item())
			.addTag(IcariaBlockItemTags.ORES_SIDEROS.item())
			.addTag(IcariaBlockItemTags.ORES_SLIVER.item())
			.addTag(IcariaBlockItemTags.ORES_VANADIUM.item());

		this.tag(Tags.Items.PLAYER_WORKSTATIONS_CRAFTING_TABLES)
			.add(IcariaBlockItemIds.CYPRESS_CRAFTING_TABLE.item())
			.add(IcariaBlockItemIds.DROUGHTROOT_CRAFTING_TABLE.item())
			.add(IcariaBlockItemIds.FIR_CRAFTING_TABLE.item())
			.add(IcariaBlockItemIds.LAUREL_CRAFTING_TABLE.item())
			.add(IcariaBlockItemIds.OLIVE_CRAFTING_TABLE.item())
			.add(IcariaBlockItemIds.PLANE_CRAFTING_TABLE.item())
			.add(IcariaBlockItemIds.POPULUS_CRAFTING_TABLE.item());

		this.tag(Tags.Items.SANDS)
			.add(IcariaBlockItemIds.GRAINEL.item())
			.add(IcariaBlockItemIds.SILKSAND.item());

		this.tag(Tags.Items.STONES)
			.add(IcariaBlockItemIds.GRAINITE.item())
			.add(IcariaBlockItemIds.YELLOWSTONE.item())
			.add(IcariaBlockItemIds.SILKSTONE.item())
			.add(IcariaBlockItemIds.SUNSTONE.item())
			.add(IcariaBlockItemIds.VOIDSHALE.item())
			.add(IcariaBlockItemIds.BAETYL.item());

		this.tag(Tags.Items.STORAGE_BLOCKS)
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_ANTHRACITE.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_ARACHNE_STRING.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_ARISTONE.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_BLURIDIUM.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_CHALKOS.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_CHERT.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_ENDER_JELLYFISH_JELLY.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_FIRE_JELLYFISH_JELLY.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_KASSITEROS.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_LIGNITE.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_MOLYBDENUM.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_MOLYBDENUMSTEEL.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_NATURE_JELLYFISH_JELLY.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_ORICHALCUM.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_CHALKOS.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_KASSITEROS.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_MOLYBDENUM.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_SIDEROS.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_RAW_VANADIUM.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_ROTTEN_BONES.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_SIDEROS.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_SLIVER.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_SPELT.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_VANADIUM.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_VANADIUMSTEEL.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_VINE_REED.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_VOID_JELLYFISH_JELLY.item())
			.addTag(IcariaBlockItemTags.STORAGE_BLOCKS_WATER_JELLYFISH_JELLY.item());

		this.tag(Tags.Items.STRIPPED_LOGS)
			.add(IcariaBlockItemIds.STRIPPED_CYPRESS_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DEAD_CYPRESS_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DROUGHTROOT_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DEAD_DROUGHTROOT_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_FIR_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DEAD_FIR_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_LAUREL_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DEAD_LAUREL_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_OLIVE_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DEAD_OLIVE_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_PLANE_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DEAD_PLANE_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_POPULUS_LOG.item())
			.add(IcariaBlockItemIds.STRIPPED_DEAD_POPULUS_LOG.item());

		this.tag(Tags.Items.STRIPPED_WOODS)
			.add(IcariaBlockItemIds.STRIPPED_CYPRESS_WOOD.item())
			.add(IcariaBlockItemIds.STRIPPED_DROUGHTROOT_WOOD.item())
			.add(IcariaBlockItemIds.STRIPPED_FIR_WOOD.item())
			.add(IcariaBlockItemIds.STRIPPED_LAUREL_WOOD.item())
			.add(IcariaBlockItemIds.STRIPPED_OLIVE_WOOD.item())
			.add(IcariaBlockItemIds.STRIPPED_PLANE_WOOD.item())
			.add(IcariaBlockItemIds.STRIPPED_POPULUS_WOOD.item());

		new IcariaBlockItemTagsProvider(blockItemTagId -> BlockItemTagsProvider.wrapForItems(this.tag(blockItemTagId.item()))).run();
	}

	@Override
	public String getName() {
		return "Item Tags";
	}
}
