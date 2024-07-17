package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.properties.Olives;
import com.axanthic.icaria.common.properties.Ripe;
import com.axanthic.icaria.common.properties.Vine;
import com.axanthic.icaria.common.registry.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockLoot extends BlockLootSubProvider {
	public static final float[] CHERRY_CHANCES = new float[]{0.05F, 0.006666666666F, 0.008333333333F, 0.01F};
	public static final float[] GARLIC_CHANCES = new float[]{0.05F, 0.006666666666F, 0.008333333333F, 0.01F};
	public static final float[] SAPLING_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] SEED_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};
	public static final float[] STICK_CHANCES = new float[]{0.05F, 0.06666666666F, 0.08333333333F, 0.1F};

	public IcariaBlockLoot(HolderLookup.Provider pProvider) {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pProvider);
	}

	@Override
	public void generate() {
		for (var blocks : IcariaBlocks.SIMPLE_BLOCKS) {
			this.dropThis(blocks.get());
		}

		this.dropElseWithSilk(IcariaBlocks.GRASSY_MARL.get(), IcariaItems.MARL.get(), 1.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.MARL_CHERT.get(), IcariaItems.CHERT.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.SURFACE_CHERT.get(), IcariaItems.CHERT.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.MARL_BONES.get(), Items.BONE, IcariaItems.ROTTEN_BONES.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.SURFACE_BONES.get(), IcariaItems.BONE_REMAINS.get(), Items.BONE, 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.MARL_LIGNITE.get(), IcariaItems.LIGNITE.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.SURFACE_LIGNITE.get(), IcariaItems.LIGNITE.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.LOAM.get(), IcariaItems.LOAM_LUMP.get(), 4.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.GRAINEL_CHERT.get(), IcariaItems.CHERT.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.YELLOWSTONE.get(), IcariaItems.COBBLED_YELLOWSTONE.get(), 1.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.SILKSTONE.get(), IcariaItems.COBBLED_SILKSTONE.get(), 1.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.SUNSTONE.get(), IcariaItems.COBBLED_SUNSTONE.get(), 1.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.VOIDSHALE.get(), IcariaItems.COBBLED_VOIDSHALE.get(), 1.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.BAETYL.get(), IcariaItems.COBBLED_BAETYL.get(), 1.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.SMOOTH_RELICSTONE.get(), IcariaItems.RELICSTONE.get(), 1.0F, 0);
		this.dropElseWithSilk(IcariaBlocks.BLURRED_PLATOSHALE.get(), IcariaItems.BLURIDIUM_NUGGET.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get(), IcariaItems.BLURIDIUM_NUGGET.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.LIGNITE_ORE.get(), IcariaItems.LIGNITE.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.CHALKOS_ORE.get(), IcariaItems.RAW_CHALKOS.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.KASSITEROS_ORE.get(), IcariaItems.RAW_KASSITEROS.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.DOLOMITE_ORE.get(), IcariaItems.DOLOMITE.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.VANADIUM_ORE.get(), IcariaItems.RAW_VANADIUM.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.SLIVER_ORE.get(), IcariaItems.SLIVER.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.SIDEROS_ORE.get(), IcariaItems.RAW_SIDEROS.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.ANTHRACITE_ORE.get(), IcariaItems.ANTHRACITE.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.MOLYBDENUM_ORE.get(), IcariaItems.RAW_MOLYBDENUM.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaItems.CALCITE_SHARD.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.HALITE_CRYSTAL.get(), IcariaItems.HALITE_SHARD.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.JASPER_CRYSTAL.get(), IcariaItems.JASPER_SHARD.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.ZIRCON_CRYSTAL.get(), IcariaItems.ZIRCON_SHARD.get(), 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.CYPRESS_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.DROUGHTROOT_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.FIR_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.LAUREL_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.OLIVE_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.PLANE_TWIGS.get(), Items.STICK, 1.0F, 2);
		this.dropElseWithSilk(IcariaBlocks.POPULUS_TWIGS.get(), Items.STICK, 1.0F, 2);

		this.dropElse(IcariaBlocks.FARMLAND.get(), IcariaItems.MARL.get());
		this.dropElse(IcariaBlocks.FERTILIZED_FARMLAND.get(), IcariaItems.MARL.get());
		this.dropElse(IcariaBlocks.AETERNAE_WALL_SKULL.get(), IcariaItems.AETERNAE_SKULL.get());
		this.dropElse(IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), IcariaItems.ARGAN_HOUND_SKULL.get());
		this.dropElse(IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), IcariaItems.CATOBLEPAS_SKULL.get());
		this.dropElse(IcariaBlocks.CERVER_WALL_SKULL.get(), IcariaItems.CERVER_SKULL.get());
		this.dropElse(IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get(), IcariaItems.CYPRESS_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get(), IcariaItems.DROUGHTROOT_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get(), IcariaItems.FIR_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get(), IcariaItems.LAUREL_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get(), IcariaItems.OLIVE_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get(), IcariaItems.PLANE_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get(), IcariaItems.POPULUS_FOREST_HAG_SKULL.get());
		this.dropElse(IcariaBlocks.REVENANT_WALL_SKULL.get(), IcariaItems.REVENANT_SKULL.get());
		this.dropElse(IcariaBlocks.SOW_WALL_SKULL.get(), IcariaItems.SOW_SKULL.get());
		this.dropElse(IcariaBlocks.LIGNITE_WALL_TORCH.get(), IcariaItems.LIGNITE_TORCH.get());
		this.dropElse(IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), IcariaItems.ANTHRACITE_TORCH.get());
		this.dropElse(IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaItems.CYPRESS_SIGN.get());
		this.dropElse(IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), IcariaItems.CYPRESS_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaItems.DROUGHTROOT_SIGN.get());
		this.dropElse(IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), IcariaItems.DROUGHTROOT_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.FIR_WALL_SIGN.get(), IcariaItems.FIR_SIGN.get());
		this.dropElse(IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), IcariaItems.FIR_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaItems.LAUREL_SIGN.get());
		this.dropElse(IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), IcariaItems.LAUREL_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaItems.OLIVE_SIGN.get());
		this.dropElse(IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), IcariaItems.OLIVE_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaItems.PLANE_SIGN.get());
		this.dropElse(IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), IcariaItems.PLANE_HANGING_SIGN.get());
		this.dropElse(IcariaBlocks.POPULUS_WALL_SIGN.get(), IcariaItems.POPULUS_SIGN.get());
		this.dropElse(IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get(), IcariaItems.POPULUS_HANGING_SIGN.get());

		this.dropThis(IcariaBlocks.DOLOMITE_PILLAR.get());
		this.dropThis(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.RELICSTONE_PILLAR.get());
		this.dropThis(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.QUARTZ_WALL.get());
		this.dropThis(IcariaBlocks.QUARTZ_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.CALCITE.get());
		this.dropThis(IcariaBlocks.BUDDING_CALCITE.get());
		this.dropThis(IcariaBlocks.HALITE.get());
		this.dropThis(IcariaBlocks.BUDDING_HALITE.get());
		this.dropThis(IcariaBlocks.JASPER.get());
		this.dropThis(IcariaBlocks.BUDDING_JASPER.get());
		this.dropThis(IcariaBlocks.ZIRCON.get());
		this.dropThis(IcariaBlocks.BUDDING_ZIRCON.get());
		this.dropThis(IcariaBlocks.SPELT_BALE_BLOCK.get());
		this.dropThis(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		this.dropThis(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get());
		this.dropThis(IcariaBlocks.VANADIUMSTEEL_CHAIN.get());
		this.dropThis(IcariaBlocks.CHEST.get());
		this.dropThis(IcariaBlocks.TRAPPED_CHEST.get());
		this.dropThis(IcariaBlocks.STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.WHITE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.GRAY_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.BLACK_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.BROWN_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.RED_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.ORANGE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.YELLOW_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.LIME_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.GREEN_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.CYAN_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.BLUE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.PURPLE_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.MAGENTA_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.PINK_STORAGE_VASE.get());
		this.dropThis(IcariaBlocks.AETERNAE_SKULL.get());
		this.dropThis(IcariaBlocks.ARGAN_HOUND_SKULL.get());
		this.dropThis(IcariaBlocks.CATOBLEPAS_SKULL.get());
		this.dropThis(IcariaBlocks.CERVER_SKULL.get());
		this.dropThis(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.FIR_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get());
		this.dropThis(IcariaBlocks.REVENANT_SKULL.get());
		this.dropThis(IcariaBlocks.SOW_SKULL.get());
		this.dropThis(IcariaBlocks.LIGNITE_TORCH.get());
		this.dropThis(IcariaBlocks.ANTHRACITE_TORCH.get());
		this.dropThis(IcariaBlocks.CYPRESS_SAPLING.get());
		this.dropThis(IcariaBlocks.CYPRESS_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		this.dropThis(IcariaBlocks.CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.CYPRESS_TROUGH.get());
		this.dropThis(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.CYPRESS_LADDER.get());
		this.dropThis(IcariaBlocks.CYPRESS_SIGN.get());
		this.dropThis(IcariaBlocks.CYPRESS_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_TROUGH.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_LADDER.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SIGN.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.FIR_SAPLING.get());
		this.dropThis(IcariaBlocks.FIR_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		this.dropThis(IcariaBlocks.FIR_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_FIR_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		this.dropThis(IcariaBlocks.FIR_TROUGH.get());
		this.dropThis(IcariaBlocks.FIR_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.FIR_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.FIR_LADDER.get());
		this.dropThis(IcariaBlocks.FIR_SIGN.get());
		this.dropThis(IcariaBlocks.FIR_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.LAUREL_SAPLING.get());
		this.dropThis(IcariaBlocks.LAUREL_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		this.dropThis(IcariaBlocks.LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.LAUREL_TROUGH.get());
		this.dropThis(IcariaBlocks.LAUREL_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.LAUREL_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.LAUREL_LADDER.get());
		this.dropThis(IcariaBlocks.LAUREL_SIGN.get());
		this.dropThis(IcariaBlocks.LAUREL_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.OLIVE_SAPLING.get());
		this.dropThis(IcariaBlocks.OLIVE_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		this.dropThis(IcariaBlocks.OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.OLIVE_TROUGH.get());
		this.dropThis(IcariaBlocks.OLIVE_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.OLIVE_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.OLIVE_LADDER.get());
		this.dropThis(IcariaBlocks.OLIVE_SIGN.get());
		this.dropThis(IcariaBlocks.OLIVE_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.PLANE_SAPLING.get());
		this.dropThis(IcariaBlocks.PLANE_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		this.dropThis(IcariaBlocks.PLANE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.PLANE_TROUGH.get());
		this.dropThis(IcariaBlocks.PLANE_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.PLANE_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.PLANE_LADDER.get());
		this.dropThis(IcariaBlocks.PLANE_SIGN.get());
		this.dropThis(IcariaBlocks.PLANE_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.POPULUS_SAPLING.get());
		this.dropThis(IcariaBlocks.POPULUS_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		this.dropThis(IcariaBlocks.POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.POPULUS_TROUGH.get());
		this.dropThis(IcariaBlocks.POPULUS_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.POPULUS_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.POPULUS_LADDER.get());
		this.dropThis(IcariaBlocks.POPULUS_SIGN.get());
		this.dropThis(IcariaBlocks.POPULUS_HANGING_SIGN.get());
		this.dropThis(IcariaBlocks.BLINDWEED.get());
		this.dropThis(IcariaBlocks.CHAMEOMILE.get());
		this.dropThis(IcariaBlocks.CHARMONDER.get());
		this.dropThis(IcariaBlocks.CLOVER.get());
		this.dropThis(IcariaBlocks.FIREHILT.get());
		this.dropThis(IcariaBlocks.BLUE_HYDRACINTH.get());
		this.dropThis(IcariaBlocks.PURPLE_HYDRACINTH.get());
		this.dropThis(IcariaBlocks.LIONFANGS.get());
		this.dropThis(IcariaBlocks.SPEARDROPS.get());
		this.dropThis(IcariaBlocks.PURPLE_STAGHORN.get());
		this.dropThis(IcariaBlocks.YELLOW_STAGHORN.get());
		this.dropThis(IcariaBlocks.BLUE_STORMCOTTON.get());
		this.dropThis(IcariaBlocks.PINK_STORMCOTTON.get());
		this.dropThis(IcariaBlocks.PURPLE_STORMCOTTON.get());
		this.dropThis(IcariaBlocks.SUNKETTLE.get());
		this.dropThis(IcariaBlocks.SUNSPONGE.get());
		this.dropThis(IcariaBlocks.VOIDLILY.get());
		this.dropThis(IcariaBlocks.BOLBOS.get());
		this.dropThis(IcariaBlocks.DATHULLA.get());
		this.dropThis(IcariaBlocks.MONDANOS.get());
		this.dropThis(IcariaBlocks.MOTH_AGARIC.get());
		this.dropThis(IcariaBlocks.NAMDRAKE.get());
		this.dropThis(IcariaBlocks.PSILOCYBOS.get());
		this.dropThis(IcariaBlocks.ROWAN.get());
		this.dropThis(IcariaBlocks.WILTED_ELM.get());
		this.dropThis(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		this.dropThis(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		this.dropThis(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		this.dropThis(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		this.dropThis(IcariaBlocks.RED_GROUND_FLOWERS.get());
		this.dropThis(IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		this.dropThis(IcariaBlocks.PALM_FERN.get());
		this.dropThis(IcariaBlocks.WHITE_BROMELIA.get());
		this.dropThis(IcariaBlocks.ORANGE_BROMELIA.get());
		this.dropThis(IcariaBlocks.PINK_BROMELIA.get());
		this.dropThis(IcariaBlocks.PURPLE_BROMELIA.get());
		this.dropThis(IcariaBlocks.GREEN_GROUND_SHROOMS.get());
		this.dropThis(IcariaBlocks.BROWN_GROUND_SHROOMS.get());
		this.dropThis(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get());
		this.dropThis(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get());
		this.dropThis(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get());
		this.dropThis(IcariaBlocks.UNNAMED_TREE_SHROOMS.get());
		this.dropThis(IcariaBlocks.CARDON_CACTUS.get());

		this.dropOnlyWithSilk(IcariaBlocks.GRAINGLASS.get());
		this.dropOnlyWithSilk(IcariaBlocks.GRAINGLASS_PANE.get());
		this.dropOnlyWithSilk(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get());
		this.dropOnlyWithSilk(IcariaBlocks.GRAINITE_RUBBLE.get());
		this.dropOnlyWithSilk(IcariaBlocks.YELLOWSTONE_RUBBLE.get());
		this.dropOnlyWithSilk(IcariaBlocks.SILKGLASS.get());
		this.dropOnlyWithSilk(IcariaBlocks.SILKGLASS_PANE.get());
		this.dropOnlyWithSilk(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get());
		this.dropOnlyWithSilk(IcariaBlocks.SILKSTONE_RUBBLE.get());
		this.dropOnlyWithSilk(IcariaBlocks.SUNSTONE_RUBBLE.get());
		this.dropOnlyWithSilk(IcariaBlocks.VOIDSHALE_RUBBLE.get());
		this.dropOnlyWithSilk(IcariaBlocks.BAETYL_RUBBLE.get());
		this.dropOnlyWithSilk(IcariaBlocks.RELICSTONE_RUBBLE.get());
		this.dropOnlyWithSilk(IcariaBlocks.HYLIASTRUM_ORE.get());
		this.dropOnlyWithSilk(IcariaBlocks.ARISTONE.get());
		this.dropOnlyWithSilk(IcariaBlocks.PACKED_ARISTONE.get());

		this.dropNone(IcariaBlocks.KETTLE.get());
		this.dropNone(IcariaBlocks.GRINDER.get());
		this.dropNone(IcariaBlocks.KILN.get());
		this.dropNone(IcariaBlocks.FORGE.get());
		this.dropNone(IcariaBlocks.RED_LOOT_VASE.get());
		this.dropNone(IcariaBlocks.CYAN_LOOT_VASE.get());
		this.dropNone(IcariaBlocks.ARACHNE_SPAWNER.get());
		this.dropNone(IcariaBlocks.REVENANT_SPAWNER.get());
		this.dropNone(IcariaBlocks.LAUREL_CHERRY_CAKE.get());
		this.dropNone(IcariaBlocks.STRAWBERRY_CAKE.get());
		this.dropNone(IcariaBlocks.PHYSALIS_CAKE.get());
		this.dropNone(IcariaBlocks.VINE_BERRY_CAKE.get());
		this.dropNone(IcariaBlocks.VINE_SPROUT_CAKE.get());
		this.dropNone(IcariaBlocks.SIMPLE_CYPRESS_RACK.get());
		this.dropNone(IcariaBlocks.CYPRESS_RACK.get());
		this.dropNone(IcariaBlocks.CYPRESS_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_CYPRESS_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_CYPRESS_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_CYPRESS_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_DROUGHTROOT_RACK.get());
		this.dropNone(IcariaBlocks.DROUGHTROOT_RACK.get());
		this.dropNone(IcariaBlocks.DROUGHTROOT_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_DROUGHTROOT_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_DROUGHTROOT_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_DROUGHTROOT_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_FIR_RACK.get());
		this.dropNone(IcariaBlocks.FIR_RACK.get());
		this.dropNone(IcariaBlocks.FIR_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_FIR_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_FIR_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_FIR_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_LAUREL_RACK.get());
		this.dropNone(IcariaBlocks.LAUREL_RACK.get());
		this.dropNone(IcariaBlocks.LAUREL_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_LAUREL_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_LAUREL_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_LAUREL_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_OLIVE_RACK.get());
		this.dropNone(IcariaBlocks.OLIVE_RACK.get());
		this.dropNone(IcariaBlocks.OLIVE_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_OLIVE_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_OLIVE_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_OLIVE_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_PLANE_RACK.get());
		this.dropNone(IcariaBlocks.PLANE_RACK.get());
		this.dropNone(IcariaBlocks.PLANE_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_PLANE_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_PLANE_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_PLANE_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.SIMPLE_POPULUS_RACK.get());
		this.dropNone(IcariaBlocks.POPULUS_RACK.get());
		this.dropNone(IcariaBlocks.POPULUS_BARREL.get());
		this.dropNone(IcariaBlocks.LOADED_POPULUS_BARREL.get());
		this.dropNone(IcariaBlocks.TAPPED_POPULUS_BARREL.get());
		this.dropNone(IcariaBlocks.TRIPLE_POPULUS_BARREL_RACK.get());
		this.dropNone(IcariaBlocks.MEDITERRANEAN_WATER.get());
		this.dropNone(IcariaBlocks.GREEK_FIRE.get());
		this.dropNone(IcariaBlocks.ICARIA_PORTAL.get());
		this.dropNone(IcariaBlocks.GRINDER_SHAFT.get());
		this.dropNone(IcariaBlocks.GRINDER_STONE.get());

		this.dropPots(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), IcariaItems.CYPRESS_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), IcariaItems.DROUGHTROOT_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_FIR_SAPLING.get(), IcariaItems.FIR_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), IcariaItems.LAUREL_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), IcariaItems.OLIVE_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_PLANE_SAPLING.get(), IcariaItems.PLANE_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), IcariaItems.POPULUS_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_FERN.get(), IcariaItems.FERN.get());
		this.dropPots(IcariaBlocks.POTTED_BLINDWEED.get(), IcariaItems.BLINDWEED.get());
		this.dropPots(IcariaBlocks.POTTED_CHAMEOMILE.get(), IcariaItems.CHAMEOMILE.get());
		this.dropPots(IcariaBlocks.POTTED_CHARMONDER.get(), IcariaItems.CHARMONDER.get());
		this.dropPots(IcariaBlocks.POTTED_CLOVER.get(), IcariaItems.CLOVER.get());
		this.dropPots(IcariaBlocks.POTTED_FIREHILT.get(), IcariaItems.FIREHILT.get());
		this.dropPots(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), IcariaItems.BLUE_HYDRACINTH.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), IcariaItems.PURPLE_HYDRACINTH.get());
		this.dropPots(IcariaBlocks.POTTED_LIONFANGS.get(), IcariaItems.LIONFANGS.get());
		this.dropPots(IcariaBlocks.POTTED_SPEARDROPS.get(), IcariaItems.SPEARDROPS.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), IcariaItems.PURPLE_STAGHORN.get());
		this.dropPots(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), IcariaItems.YELLOW_STAGHORN.get());
		this.dropPots(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), IcariaItems.BLUE_STORMCOTTON.get());
		this.dropPots(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), IcariaItems.PINK_STORMCOTTON.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), IcariaItems.PURPLE_STORMCOTTON.get());
		this.dropPots(IcariaBlocks.POTTED_SUNKETTLE.get(), IcariaItems.SUNKETTLE.get());
		this.dropPots(IcariaBlocks.POTTED_SUNSPONGE.get(), IcariaItems.SUNSPONGE.get());
		this.dropPots(IcariaBlocks.POTTED_VOIDLILY.get(), IcariaItems.VOIDLILY.get());
		this.dropPots(IcariaBlocks.POTTED_PALM_FERN.get(), IcariaItems.PALM_FERN.get());
		this.dropPots(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), IcariaItems.WHITE_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), IcariaItems.ORANGE_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_PINK_BROMELIA.get(), IcariaItems.PINK_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), IcariaItems.PURPLE_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get(), IcariaItems.GREEN_GROUND_SHROOMS.get());
		this.dropPots(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get(), IcariaItems.BROWN_GROUND_SHROOMS.get());
		this.dropPots(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get(), IcariaItems.LARGE_BROWN_GROUND_SHROOMS.get());
		this.dropPots(IcariaBlocks.POTTED_CARDON_CACTUS.get(), IcariaItems.CARDON_CACTUS.get());

		this.dropLeaves(IcariaBlocks.CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_SAPLING.get());
		this.dropLeaves(IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.dropLeaves(IcariaBlocks.FIR_LEAVES.get(), IcariaBlocks.FIR_SAPLING.get());
		this.dropLeaves(IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_SAPLING.get());
		this.dropLeaves(IcariaBlocks.POPULUS_LEAVES.get(), IcariaBlocks.POPULUS_SAPLING.get());

		this.dropLayers(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		this.dropLayers(IcariaBlocks.FOREST_MOSS.get());
		this.dropLayers(IcariaBlocks.SCRUBLAND_MOSS.get());
		this.dropLayers(IcariaBlocks.STEPPE_MOSS.get());

		this.dropDoor(IcariaBlocks.CYPRESS_DOOR.get());
		this.dropDoor(IcariaBlocks.DROUGHTROOT_DOOR.get());
		this.dropDoor(IcariaBlocks.FIR_DOOR.get());
		this.dropDoor(IcariaBlocks.LAUREL_DOOR.get());
		this.dropDoor(IcariaBlocks.OLIVE_DOOR.get());
		this.dropDoor(IcariaBlocks.PLANE_DOOR.get());
		this.dropDoor(IcariaBlocks.POPULUS_DOOR.get());

		this.dropLaurelLeaves(IcariaBlocks.LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_SAPLING.get());

		this.dropOlivesLeaves(IcariaBlocks.OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_SAPLING.get());

		this.dropRipeVineWithLoot(IcariaBlocks.BLOOMY_VINE.get(), IcariaItems.BLOOMY_VINE.get(), IcariaItems.VINEBERRIES.get());
		this.dropRipeVineWithLoot(IcariaBlocks.BRUSHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.VINE_SPROUT.get());

		this.dropVine(IcariaBlocks.BRANCHY_VINE.get(), IcariaItems.BRANCHY_VINE.get());
		this.dropVine(IcariaBlocks.DRY_VINE.get(), IcariaItems.DRY_VINE.get());
		this.dropVine(IcariaBlocks.SWIRLY_VINE.get(), IcariaItems.SWIRLY_VINE.get());
		this.dropVine(IcariaBlocks.THORNY_VINE.get(), IcariaItems.THORNY_VINE.get());

		this.dropVineWithLoot(IcariaBlocks.REEDY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.VINE_REED.get());

		this.dropSeed(IcariaBlocks.FERN.get());
		this.dropSeed(IcariaBlocks.SMALL_GRASS.get());
		this.dropSeed(IcariaBlocks.MEDIUM_GRASS.get());
		this.dropSeed(IcariaBlocks.LARGE_GRASS.get());
		this.dropSeed(IcariaBlocks.SMALL_MIXED_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_MIXED_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_BROWN_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_WHITE_GRAIN.get());
		this.dropSeed(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get());
		this.dropSeed(IcariaBlocks.LARGE_BROWN_GRAIN.get());

		this.dropBushWithLoot(IcariaBlocks.STRAWBERRY_BUSH.get(), IcariaItems.STRAWBERRIES.get());

		this.dropCrop(IcariaBlocks.SPELT_CROP.get(), IcariaItems.SPELT.get(), IcariaItems.SPELT_SEEDS.get());
		this.dropCrop(IcariaBlocks.STRAWBERRY_CROP.get(), IcariaItems.STRAWBERRIES.get(), IcariaItems.STRAWBERRY_SEEDS.get());
		this.dropCrop(IcariaBlocks.PHYSALIS_CROP.get(), IcariaItems.PHYSALIS.get(), IcariaItems.PHYSALIS_SEEDS.get());

		this.dropOnions(IcariaBlocks.ONION_CROP.get(), IcariaItems.ONION.get(), IcariaItems.ONION.get());

		for (var items : IcariaStoneDecoItems.STONE_DECO_ITEMS) {
			this.dropSlab(items.block.slab.get());
			this.dropThis(items.block.stairs.get());
			this.dropThis(items.block.wall.get());
		}

		for (var items : IcariaWoodDecoItems.WOOD_DECO_ITEMS) {
			this.dropSlab(items.block.slab.get());
			this.dropThis(items.block.stairs.get());
			this.dropThis(items.block.fence.get());
			this.dropThis(items.block.gate.get());
		}
	}

	public void dropThis(Block pBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock))));
	}

	public void dropElseWithSilk(Block pBlock, Item pItem, float pValue, int pBonus) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.silk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(this.noSilk()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(pValue))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), pBonus)))));
	}

	public void dropElseWithSilk(Block pBlock, Item pRemains, Item pBone, float pValue, int pBonus) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.silk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pRemains).when(this.noSilk()).when(LootItemRandomChanceCondition.randomChance(0.1F)).apply(SetItemCountFunction.setCount(ConstantValue.exactly(pValue))).otherwise(LootItem.lootTableItem(pBone).when(this.noSilk()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(pValue))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), pBonus))))));
	}

	public void dropElse(Block pBlock, Item pItem) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem))));
	}

	public void dropOnlyWithSilk(Block pBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.silk()))));
	}

	public void dropNone(Block pBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable());
	}

	public void dropPots(Block pBlock, Item pItem) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Blocks.FLOWER_POT))));
	}

	public void dropLeaves(Block pLeavesBlock, Block pSaplingBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pLeavesBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pLeavesBlock).when(this.shearsOrSilk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSaplingBlock).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.SAPLING_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.STICK).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.STICK_CHANCES)))));
	}

	public void dropLayers(Block pBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(AlternativesEntry.alternatives(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 1))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 2))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 3))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 4))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 5))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 6))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.LAYERS, 7))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0F))), LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0F)))))));
	}

	public void dropDoor(Block pBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER))))));
	}

	public void dropLaurelLeaves(Block pLeavesBlock, Block pSaplingBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pLeavesBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pLeavesBlock).when(this.shearsOrSilk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSaplingBlock).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.SAPLING_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.STICK).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.STICK_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.LAUREL_CHERRY.get()).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.CHERRY_CHANCES)))));
	}

	public void dropOlivesLeaves(Block pLeavesBlock, Block pSaplingBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pLeavesBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pLeavesBlock).when(this.shearsOrSilk()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSaplingBlock).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.SAPLING_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(Items.STICK).when(this.noShearsOrSilk()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.STICK_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.GREEN_OLIVES.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pLeavesBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.GREEN))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.BLACK_OLIVES.get())).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pLeavesBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.OLIVES, Olives.BLACK))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2))));
	}

	public void dropRipeVineWithLoot(Block pBlock, Item pItem, Item pLoot) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.BLOOMING))).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.RIPE))).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pLoot).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.RIPE))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))));
	}

	public void dropVine(Block pBlock, Item pItem) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))).when(this.shears()))));
	}

	public void dropVineWithLoot(Block pBlock, Item pItem, Item pLoot) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))).when(this.shears())).add(LootItem.lootTableItem(pLoot).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.NONE))).when(this.noShears()).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))).when(this.shears())).add(LootItem.lootTableItem(pLoot).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.VINE, Vine.VINE))).when(this.noShears()).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))));
	}

	public void dropSeed(Block pBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.SPELT_SEEDS.get()).when(this.noShears()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.SEED_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.STRAWBERRY_SEEDS.get()).when(this.noShears()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.SEED_CHANCES)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.PHYSALIS_SEEDS.get()).when(this.noShears()).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.SEED_CHANCES)))));
	}

	public void dropBushWithLoot(Block pBlock, Item pLootItem) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(this.shears()))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pLootItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IcariaBlockStateProperties.RIPE, Ripe.RIPE))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))));
	}

	public void dropCrop(Block pBlock, Item pCropItem, Item pSeedItem) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeedItem))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeedItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pCropItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))));
	}

	public void dropOnions(Block pBlock, Item pCropItem, Item pSeedItem) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeedItem))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pSeedItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pCropItem).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))).apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2)))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(IcariaItems.GARLIC.get()).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.AGE_7, 7))).when(BonusLevelTableCondition.bonusLevelFlatChance(registryLookup.getOrThrow(Enchantments.FORTUNE), IcariaBlockLoot.GARLIC_CHANCES)))));
	}

	public void dropSlab(Block pBlock) {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.SLAB_TYPE, SlabType.BOTTOM))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.SLAB_TYPE, SlabType.TOP))))).withPool(LootPool.lootPool().add(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.SLAB_TYPE, SlabType.DOUBLE)))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F)))));
	}

	@Override
	public Iterable<Block> getKnownBlocks() {
		return BuiltInRegistries.BLOCK.stream().filter((pBlock) -> IcariaIdents.ID.equals(BuiltInRegistries.BLOCK.getKey(pBlock).getNamespace())).collect(Collectors.toList());
	}

	public LootItemCondition.Builder noShears() {
		return this.shears().invert();
	}

	public LootItemCondition.Builder noShearsOrSilk() {
		return this.shearsOrSilk().invert();
	}

	public LootItemCondition.Builder noSilk() {
		return this.silk().invert();
	}

	public LootItemCondition.Builder shears() {
		return MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
	}

	public LootItemCondition.Builder shearsOrSilk() {
		return this.shears().or(this.silk());
	}

	public LootItemCondition.Builder silk() {
		var registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		var enchantmentPredicate = new EnchantmentPredicate(registryLookup.getOrThrow(Enchantments.SILK_TOUCH), MinMaxBounds.Ints.atLeast(1));
		return MatchTool.toolMatches(ItemPredicate.Builder.item().withSubPredicate(ItemSubPredicates.ENCHANTMENTS, ItemEnchantmentsPredicate.enchantments(List.of(enchantmentPredicate))));
	}
}
