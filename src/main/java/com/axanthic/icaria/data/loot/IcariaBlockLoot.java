package com.axanthic.icaria.data.loot;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@MethodsReturnNonnullByDefault

public class IcariaBlockLoot extends BlockLootSubProvider {
	public static final float[] SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

	public static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
	public static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));
	public static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
	public static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

	public IcariaBlockLoot() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	public void generate() {
		this.dropWithSilk(IcariaBlocks.MARL_GRASS.get(), IcariaItems.MARL.get(), 1.0F, 1.0F);
		this.dropWithSilk(IcariaBlocks.SURFACE_CHERT.get(), IcariaItems.CHERT.get(), 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.SURFACE_BONES.get(), Items.BONE, 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.LOAM.get(), IcariaItems.LOAM_LUMP.get(), 4.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_COBBLE.get(), 1.0F, 1.0F);
		this.dropWithSilk(IcariaBlocks.SILKSTONE.get(), IcariaItems.SILKSTONE_COBBLE.get(), 1.0F, 1.0F);
		this.dropWithSilk(IcariaBlocks.SUNSTONE.get(), IcariaItems.SUNSTONE_COBBLE.get(), 1.0F, 1.0F);
		this.dropWithSilk(IcariaBlocks.VOIDSHALE.get(), IcariaItems.VOIDSHALE_COBBLE.get(), 1.0F, 1.0F);
		this.dropWithSilk(IcariaBlocks.BAETYL.get(), IcariaItems.BAETYL_COBBLE.get(), 1.0F, 1.0F);
		this.dropWithSilk(IcariaBlocks.RELICSTONE_SMOOTH.get(), IcariaItems.RELICSTONE.get(), 1.0F, 1.0F);
		this.dropWithSilk(IcariaBlocks.CYPRESS_TWIGS.get(), Items.STICK, 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.DROUGHTROOT_TWIGS.get(), Items.STICK, 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.FIR_TWIGS.get(), Items.STICK, 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.LAUREL_TWIGS.get(), Items.STICK, 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.OLIVE_TWIGS.get(), Items.STICK, 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.PLANE_TWIGS.get(), Items.STICK, 1.0F, 4.0F);
		this.dropWithSilk(IcariaBlocks.POPULUS_TWIGS.get(), Items.STICK, 1.0F, 4.0F);

		this.dropOres(IcariaBlocks.MARL_CHERT.get(), IcariaItems.CHERT.get());
		this.dropOres(IcariaBlocks.MARL_LIGNITE.get(), IcariaItems.LIGNITE.get());
		this.dropOres(IcariaBlocks.GRAINEL_CHERT.get(), IcariaItems.CHERT.get());
		this.dropOres(IcariaBlocks.LIGNITE_ORE.get(), IcariaItems.LIGNITE.get());
		this.dropOres(IcariaBlocks.CHALKOS_ORE.get(), IcariaItems.CHALKOS_RAW.get());
		this.dropOres(IcariaBlocks.KASSITEROS_ORE.get(), IcariaItems.KASSITEROS_RAW.get());
		this.dropOres(IcariaBlocks.DOLOMITE_ORE.get(), IcariaItems.DOLOMITE.get());
		this.dropOres(IcariaBlocks.VANADIUM_ORE.get(), IcariaItems.VANADIUM_RAW.get());
		this.dropOres(IcariaBlocks.SLIVER_ORE.get(), IcariaItems.SLIVER.get());
		this.dropOres(IcariaBlocks.SIDEROS_ORE.get(), IcariaItems.SIDEROS_RAW.get());
		this.dropOres(IcariaBlocks.ANTHRACITE_ORE.get(), IcariaItems.ANTHRACITE.get());
		this.dropOres(IcariaBlocks.MOLYBDENUM_ORE.get(), IcariaItems.MOLYBDENUM_RAW.get());

		this.dropBone(IcariaBlocks.MARL_BONES.get(), Items.BONE, IcariaItems.ROTTEN_BONES.get(), IcariaItems.BONE_REMAINS.get());

		this.dropElse(IcariaBlocks.FARMLAND.get(), IcariaItems.MARL.get());
		this.dropElse(IcariaBlocks.FARMLAND_FERTILIZED.get(), IcariaItems.MARL.get());
		this.dropElse(IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaItems.CALCITE.get());
		this.dropElse(IcariaBlocks.HALITE_CRYSTAL.get(), IcariaItems.HALITE.get());
		this.dropElse(IcariaBlocks.JASPER_CRYSTAL.get(), IcariaItems.JASPER.get());
		this.dropElse(IcariaBlocks.ZIRCON_CRYSTAL.get(), IcariaItems.ZIRCON.get());
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
		this.dropElse(IcariaBlocks.SOW_WALL_SKULL.get(), IcariaItems.SOW_SKULL.get());
		this.dropElse(IcariaBlocks.DIM_WALL_TORCH.get(), IcariaItems.DIM_TORCH.get());
		this.dropElse(IcariaBlocks.LIGNITE_WALL_TORCH.get(), IcariaItems.LIGNITE_TORCH.get());
		this.dropElse(IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), IcariaItems.ANTHRACITE_TORCH.get());
		this.dropElse(IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaItems.CYPRESS_SIGN.get());
		this.dropElse(IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaItems.DROUGHTROOT_SIGN.get());
		this.dropElse(IcariaBlocks.FIR_WALL_SIGN.get(), IcariaItems.FIR_SIGN.get());
		this.dropElse(IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaItems.LAUREL_SIGN.get());
		this.dropElse(IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaItems.OLIVE_SIGN.get());
		this.dropElse(IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaItems.PLANE_SIGN.get());
		this.dropElse(IcariaBlocks.POPULUS_WALL_SIGN.get(), IcariaItems.POPULUS_SIGN.get());

		this.dropWhenSilk(IcariaBlocks.GRAINGLASS.get());
		this.dropWhenSilk(IcariaBlocks.GRAINGLASS_PANE.get());
		this.dropWhenSilk(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get());
		this.dropWhenSilk(IcariaBlocks.SILKGLASS.get());
		this.dropWhenSilk(IcariaBlocks.SILKGLASS_PANE.get());
		this.dropWhenSilk(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());
		this.dropWhenSilk(IcariaBlocks.HYLIASTRUM_ORE.get());
		this.dropWhenSilk(IcariaBlocks.GRAINITE_RUBBLE.get());
		this.dropWhenSilk(IcariaBlocks.YELLOWSTONE_RUBBLE.get());
		this.dropWhenSilk(IcariaBlocks.SILKSTONE_RUBBLE.get());
		this.dropWhenSilk(IcariaBlocks.SUNSTONE_RUBBLE.get());
		this.dropWhenSilk(IcariaBlocks.VOIDSHALE_RUBBLE.get());
		this.dropWhenSilk(IcariaBlocks.BAETYL_RUBBLE.get());
		this.dropWhenSilk(IcariaBlocks.RELICSTONE_RUBBLE.get());

		this.dropThis(IcariaBlocks.RELICSTONE_PILLAR.get());
		this.dropThis(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.DOLOMITE_PILLAR.get());
		this.dropThis(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.QUARTZ_PILLAR_HEAD.get());
		this.dropThis(IcariaBlocks.CALCITE_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.BUDDING_CALCITE_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.HALITE_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.BUDDING_HALITE_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.JASPER_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.BUDDING_JASPER_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.ZIRCON_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.BUDDING_ZIRCON_GEODE_BLOCK.get());
		this.dropThis(IcariaBlocks.SPELT_BALE_BLOCK.get());
		this.dropThis(IcariaBlocks.VANADIUMSTEEL_BARS.get());
		this.dropThis(IcariaBlocks.VANADIUMSTEEL_BARS_HORIZONTAL.get());
		this.dropThis(IcariaBlocks.GRINDER.get());
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
		this.dropThis(IcariaBlocks.SOW_SKULL.get());
		this.dropThis(IcariaBlocks.DIM_TORCH.get());
		this.dropThis(IcariaBlocks.LIGNITE_TORCH.get());
		this.dropThis(IcariaBlocks.ANTHRACITE_TORCH.get());
		this.dropThis(IcariaBlocks.CYPRESS_SAPLING.get());
		this.dropThis(IcariaBlocks.CYPRESS_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		this.dropThis(IcariaBlocks.CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		this.dropThis(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.CYPRESS_LADDER.get());
		this.dropThis(IcariaBlocks.CYPRESS_SIGN.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_LADDER.get());
		this.dropThis(IcariaBlocks.DROUGHTROOT_SIGN.get());
		this.dropThis(IcariaBlocks.FIR_SAPLING.get());
		this.dropThis(IcariaBlocks.FIR_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		this.dropThis(IcariaBlocks.FIR_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_FIR_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_FIR_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		this.dropThis(IcariaBlocks.FIR_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.FIR_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.FIR_LADDER.get());
		this.dropThis(IcariaBlocks.FIR_SIGN.get());
		this.dropThis(IcariaBlocks.LAUREL_SAPLING.get());
		this.dropThis(IcariaBlocks.LAUREL_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		this.dropThis(IcariaBlocks.LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		this.dropThis(IcariaBlocks.LAUREL_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.LAUREL_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.LAUREL_LADDER.get());
		this.dropThis(IcariaBlocks.LAUREL_SIGN.get());
		this.dropThis(IcariaBlocks.OLIVE_SAPLING.get());
		this.dropThis(IcariaBlocks.OLIVE_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		this.dropThis(IcariaBlocks.OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		this.dropThis(IcariaBlocks.OLIVE_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.OLIVE_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.OLIVE_LADDER.get());
		this.dropThis(IcariaBlocks.OLIVE_SIGN.get());
		this.dropThis(IcariaBlocks.PLANE_SAPLING.get());
		this.dropThis(IcariaBlocks.PLANE_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		this.dropThis(IcariaBlocks.PLANE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		this.dropThis(IcariaBlocks.PLANE_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.PLANE_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.PLANE_LADDER.get());
		this.dropThis(IcariaBlocks.PLANE_SIGN.get());
		this.dropThis(IcariaBlocks.POPULUS_SAPLING.get());
		this.dropThis(IcariaBlocks.POPULUS_WOOD.get());
		this.dropThis(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		this.dropThis(IcariaBlocks.POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.DEAD_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());
		this.dropThis(IcariaBlocks.POPULUS_CRAFTING_TABLE.get());
		this.dropThis(IcariaBlocks.POPULUS_TRAPDOOR.get());
		this.dropThis(IcariaBlocks.POPULUS_LADDER.get());
		this.dropThis(IcariaBlocks.POPULUS_SIGN.get());
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

		this.dropBlurredPlatoshale(IcariaBlocks.PLATOSHALE_BLURRED.get(), IcariaItems.BLURIDIUM_NUGGET.get());
		this.dropBlurredPlatoshale(IcariaBlocks.PLATOSHALE_BRICKS_BLURRED.get(), IcariaItems.BLURIDIUM_NUGGET.get());

		this.dropPots(IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_FIR_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_PLANE_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_POPULUS_SAPLING.get());
		this.dropPots(IcariaBlocks.POTTED_FERN.get());
		this.dropPots(IcariaBlocks.POTTED_BLINDWEED.get());
		this.dropPots(IcariaBlocks.POTTED_CHAMEOMILE.get());
		this.dropPots(IcariaBlocks.POTTED_CHARMONDER.get());
		this.dropPots(IcariaBlocks.POTTED_CLOVER.get());
		this.dropPots(IcariaBlocks.POTTED_FIREHILT.get());
		this.dropPots(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get());
		this.dropPots(IcariaBlocks.POTTED_LIONFANGS.get());
		this.dropPots(IcariaBlocks.POTTED_SPEARDROPS.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_STAGHORN.get());
		this.dropPots(IcariaBlocks.POTTED_YELLOW_STAGHORN.get());
		this.dropPots(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get());
		this.dropPots(IcariaBlocks.POTTED_PINK_STORMCOTTON.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get());
		this.dropPots(IcariaBlocks.POTTED_SUNKETTLE.get());
		this.dropPots(IcariaBlocks.POTTED_SUNSPONGE.get());
		this.dropPots(IcariaBlocks.POTTED_VOIDLILY.get());
		this.dropPots(IcariaBlocks.POTTED_PALM_FERN.get());
		this.dropPots(IcariaBlocks.POTTED_WHITE_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_ORANGE_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_PINK_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_PURPLE_BROMELIA.get());
		this.dropPots(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get());
		this.dropPots(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get());
		this.dropPots(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get());
		this.dropPots(IcariaBlocks.POTTED_CARDON_CACTUS.get());

		this.dropLeaves(IcariaBlocks.CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_SAPLING.get());
		this.dropLeaves(IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_SAPLING.get());
		this.dropLeaves(IcariaBlocks.FIR_LEAVES.get(), IcariaBlocks.FIR_SAPLING.get());
		this.dropLeaves(IcariaBlocks.OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_SAPLING.get());
		this.dropLeaves(IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_SAPLING.get());
		this.dropLeaves(IcariaBlocks.POPULUS_LEAVES.get(), IcariaBlocks.POPULUS_SAPLING.get());

		this.dropLaurelsLeaves(IcariaBlocks.LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_SAPLING.get());

		this.dropOlivesLeaves(IcariaBlocks.OLIVE_LEAVES_BLACK.get(), IcariaItems.OLIVES_BLACK.get());
		this.dropOlivesLeaves(IcariaBlocks.OLIVE_LEAVES_GREEN.get(), IcariaItems.OLIVES_GREEN.get());

		this.dropLayers(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		this.dropLayers(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		this.dropLayers(IcariaBlocks.MOSS_0.get());
		this.dropLayers(IcariaBlocks.MOSS_1.get());
		this.dropLayers(IcariaBlocks.MOSS_2.get());

		this.dropDoor(IcariaBlocks.CYPRESS_DOOR.get());
		this.dropDoor(IcariaBlocks.DROUGHTROOT_DOOR.get());
		this.dropDoor(IcariaBlocks.FIR_DOOR.get());
		this.dropDoor(IcariaBlocks.LAUREL_DOOR.get());
		this.dropDoor(IcariaBlocks.OLIVE_DOOR.get());
		this.dropDoor(IcariaBlocks.PLANE_DOOR.get());
		this.dropDoor(IcariaBlocks.POPULUS_DOOR.get());

		this.dropVine(IcariaBlocks.RIPE_BLOOMY_VINE.get(), IcariaItems.BLOOMY_VINE.get());
		this.dropVine(IcariaBlocks.BLOOMING_BLOOMY_VINE.get(), IcariaItems.BLOOMY_VINE.get());
		this.dropVine(IcariaBlocks.BLOOMY_VINE.get(), IcariaItems.BLOOMY_VINE.get());
		this.dropVine(IcariaBlocks.BRANCHY_VINE.get(), IcariaItems.BRANCHY_VINE.get());
		this.dropVine(IcariaBlocks.RIPE_BRUSHY_VINE.get(), IcariaItems.BRUSHY_VINE.get());
		this.dropVine(IcariaBlocks.BRUSHY_VINE.get(), IcariaItems.BRUSHY_VINE.get());
		this.dropVine(IcariaBlocks.DRY_VINE.get(), IcariaItems.DRY_VINE.get());
		this.dropVine(IcariaBlocks.SWIRLY_VINE.get(), IcariaItems.SWIRLY_VINE.get());
		this.dropVine(IcariaBlocks.THORNY_VINE.get(), IcariaItems.THORNY_VINE.get());

		this.dropVineReed(IcariaBlocks.REEDY_VINE.get(), IcariaItems.VINE_REED.get());

		this.dropSeed(IcariaBlocks.FERN.get());
		this.dropSeed(IcariaBlocks.SMALL_GRASS.get());
		this.dropSeed(IcariaBlocks.MEDIUM_GRASS.get());
		this.dropSeed(IcariaBlocks.LARGE_GRASS.get());
		this.dropSeed(IcariaBlocks.GRAIN_0.get());
		this.dropSeed(IcariaBlocks.GRAIN_1.get());
		this.dropSeed(IcariaBlocks.GRAIN_2.get());
		this.dropSeed(IcariaBlocks.GRAIN_3.get());
		this.dropSeed(IcariaBlocks.GRAIN_4.get());
		this.dropSeed(IcariaBlocks.GRAIN_5.get());

		this.dropPlants(IcariaBlocks.BLUE_GROUND_FLOWERS.get());
		this.dropPlants(IcariaBlocks.CYAN_GROUND_FLOWERS.get());
		this.dropPlants(IcariaBlocks.PINK_GROUND_FLOWERS.get());
		this.dropPlants(IcariaBlocks.PURPLE_GROUND_FLOWERS.get());
		this.dropPlants(IcariaBlocks.RED_GROUND_FLOWERS.get());
		this.dropPlants(IcariaBlocks.WHITE_GROUND_FLOWERS.get());
		this.dropPlants(IcariaBlocks.PALM_FERN.get());

		this.dropBush(IcariaBlocks.STRAWBERRY_BUSH.get(), IcariaItems.STRAWBERRIES.get(), 2.0F, 5.0F);

		this.dropNone(IcariaBlocks.DEAD_BLOOMY_VINE.get());
		this.dropNone(IcariaBlocks.GROWING_BLOOMY_VINE.get());
		this.dropNone(IcariaBlocks.DEAD_BRANCHY_VINE.get());
		this.dropNone(IcariaBlocks.GROWING_BRANCHY_VINE.get());
		this.dropNone(IcariaBlocks.DEAD_BRUSHY_VINE.get());
		this.dropNone(IcariaBlocks.GROWING_BRUSHY_VINE.get());
		this.dropNone(IcariaBlocks.DEAD_DRY_VINE.get());
		this.dropNone(IcariaBlocks.GROWING_DRY_VINE.get());
		this.dropNone(IcariaBlocks.DEAD_REEDY_VINE.get());
		this.dropNone(IcariaBlocks.GROWING_REEDY_VINE.get());
		this.dropNone(IcariaBlocks.DEAD_SWIRLY_VINE.get());
		this.dropNone(IcariaBlocks.GROWING_SWIRLY_VINE.get());
		this.dropNone(IcariaBlocks.DEAD_THORNY_VINE.get());
		this.dropNone(IcariaBlocks.GROWING_THORNY_VINE.get());
		this.dropNone(IcariaBlocks.LAUREL_CHERRY_CAKE.get());
		this.dropNone(IcariaBlocks.STRAWBERRY_CAKE.get());
		this.dropNone(IcariaBlocks.PHYSALIS_CAKE.get());
		this.dropNone(IcariaBlocks.VINE_BERRY_CAKE.get());
		this.dropNone(IcariaBlocks.VINE_SPROUT_CAKE.get());
		this.dropNone(IcariaBlocks.GREEK_FIRE.get());
		this.dropNone(IcariaBlocks.ICARIA_PORTAL.get());

		this.dropCrop(IcariaBlocks.SPELT_CROP.get(), IcariaItems.SPELT.get(), IcariaItems.SPELT_SEEDS.get());
		this.dropCrop(IcariaBlocks.STRAWBERRY_CROP.get(), IcariaItems.STRAWBERRIES.get(), IcariaItems.STRAWBERRY_SEEDS.get());
		this.dropCrop(IcariaBlocks.PHYSALIS_CROP.get(), IcariaItems.PHYSALIS.get(), IcariaItems.PHYSALIS_SEEDS.get());

		this.dropGarlicOnions(IcariaBlocks.ONION_CROP.get(), IcariaItems.ONION.get(), IcariaItems.ONION.get(), IcariaItems.GARLIC.get());

		for (RegistryObject<? extends Block> basicBlocks : IcariaBlocks.BASIC_BLOCKS) {
			this.dropThis(basicBlocks.get());
		}

		for (IcariaItems.StoneDecoItemBlocks deco : IcariaItems.STONE_DECO) {
			this.add(deco.block.slab.get(), this::createSlabItemTable);
			this.dropThis(deco.block.stairs.get());
			this.dropThis(deco.block.wall.get());
		}

		for (IcariaItems.WoodDecoItemBlocks deco : IcariaItems.WOOD_DECO) {
			this.add(deco.block.slab.get(), this::createSlabItemTable);
			this.dropThis(deco.block.stairs.get());
			this.dropThis(deco.block.fence.get());
			this.dropThis(deco.block.gate.get());
		}
	}

	public void dropWithSilk(Block pBlock, Item pItem, float pMin, float pMax) {
		this.add(pBlock, createSingleItemTableWithSilkTouch(pBlock, pItem, UniformGenerator.between(pMin, pMax)));
	}

	public void dropBone(Block pBlock, Item pBoneItem, Item pRottenBoneItem, Item pRemainItem) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pBlock).when(HAS_SILK_TOUCH).otherwise(applyExplosionDecay(pBoneItem, LootItem.lootTableItem(pBoneItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(25).append(applyExplosionDecay(pRottenBoneItem, LootItem.lootTableItem(pRottenBoneItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(25)).append(applyExplosionDecay(pRemainItem, LootItem.lootTableItem(pRemainItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(1))))));
	}

	public void dropElse(Block pBlock, Item pItem) {
		this.add(pBlock, createSingleItemTable(pItem));
	}

	public void dropWhenSilk(Block pBlock) {
		this.add(pBlock, createSilkTouchOnlyTable(pBlock));
	}

	public void dropOres(Block pBlock, Item pItem) {
		this.add(pBlock, createOreDrop(pBlock, pItem));
	}

	public void dropThis(Block pBlock) {
		this.add(pBlock, createSingleItemTable(pBlock));
	}

	public void dropBlurredPlatoshale(Block pBlock, Item pItem) {
		this.add(pBlock, createBlurredPlatoshaleDrops(pBlock, pItem));
	}

	public void dropPots(Block pBlock) {
		this.add(pBlock, createPotFlowerItemTable(((FlowerPotBlock)pBlock).getContent()));
	}

	public void dropLeaves(Block pLeavesBlock, Block pSaplingBlock) {
		this.add(pLeavesBlock, createLeavesDrops(pLeavesBlock, pSaplingBlock, SAPLING_CHANCES));
	}

	public void dropLaurelsLeaves(Block pLeavesBlock, Block pSaplingBlock) {
		this.add(pLeavesBlock, createLaurelLeavesDrop(pLeavesBlock, pSaplingBlock, SAPLING_CHANCES));
	}

	public void dropOlivesLeaves(Block pBlock, Item pItem) {
		this.add(pBlock, createSilkTouchOrShearsDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
	}

	public void dropLayers(Block pBlock) {
		this.add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)).add(AlternativesEntry.alternatives(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0F))), LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0F)))))));
	}

	public void dropDoor(Block pBlock) {
		this.add(pBlock, createSinglePropConditionTable(pBlock, DoorBlock.HALF, DoubleBlockHalf.LOWER));
	}

	public void dropVine(Block pBlock, Item pItem) {
		this.add(pBlock, createVineDrop(pItem));
	}

	public void dropVineReed(Block pBlock, Item pItem) {
		this.add(pBlock, createSilkTouchOrShearsDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
	}

	public void dropSeed(Block pBlock) {
		this.add(pBlock, createSeedDrop(pBlock));
	}

	public void dropPlants(Block pBlock) {
		this.add(pBlock, createPlantsDrop(pBlock));
	}

	public void dropBush(Block pBlock, Item pItem, float pMin, float pMax) {
		this.add(pBlock, createSingleItemTable(pItem, UniformGenerator.between(pMin, pMax)).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)));
	}

	public void dropNone(Block pBlock) {
		this.add(pBlock, noDrop());
	}

	public void dropCrop(Block pBlock, Item pCropItem, Item pSeedItem) {
		this.add(pBlock, createCropDrops(pBlock, pCropItem, pSeedItem, LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
	}

	public void dropGarlicOnions(Block pCropBlock, Item pCropItem, Item pSeedItem, Item pGarlicItem) {
		this.add(pCropBlock, createGarlicOnionsDrop(pCropBlock, pCropItem, pSeedItem, pGarlicItem, LootItemBlockStatePropertyCondition.hasBlockStateProperties(pCropBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, 7))));
	}

	public LootTable.Builder createBlurredPlatoshaleDrops(Block pBlurredPlatoshaleBlock, Item pBluridiumNuggetItem) {
		return createSilkTouchDispatchTable(pBlurredPlatoshaleBlock, applyExplosionCondition(pBlurredPlatoshaleBlock, LootItem.lootTableItem(pBluridiumNuggetItem).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.1F, 0.14285715F, 0.25F, 1.0F)).otherwise(LootItem.lootTableItem(pBlurredPlatoshaleBlock))));
	}

	public LootTable.Builder createLaurelLeavesDrop(Block pLeavesBlock, Block pSaplingBlock, float... pChances) {
		return createLeavesDrops(pLeavesBlock, pSaplingBlock, pChances).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(IcariaItems.LAUREL_CHERRY.get())).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
	}

	public LootTable.Builder createVineDrop(Item pItem) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_SHEARS).add(LootItem.lootTableItem(pItem)));
	}

	public LootTable.Builder createSeedDrop(Block pBlock) {
		return createShearsDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(IcariaItems.SPELT_SEEDS.get()).when(LootItemRandomChanceCondition.randomChance(0.125F)).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))).otherwise(applyExplosionDecay(pBlock, LootItem.lootTableItem(IcariaItems.STRAWBERRY_SEEDS.get()).when(LootItemRandomChanceCondition.randomChance(0.125F)).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2)))).otherwise(applyExplosionDecay(pBlock, LootItem.lootTableItem(IcariaItems.PHYSALIS_SEEDS.get()).when(LootItemRandomChanceCondition.randomChance(0.125F)).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2)))));
	}

	public LootTable.Builder createPlantsDrop(Block pBlock) {
		return LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_SHEARS_OR_SILK_TOUCH).add(LootItem.lootTableItem(pBlock)));
	}

	public LootTable.Builder createGarlicOnionsDrop(Block pCropBlock, Item pCropItem, Item pSeedItem, Item pGarlicItem, LootItemCondition.Builder pBuilder) {
		return applyExplosionDecay(pCropBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pCropItem).when(pBuilder).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))).setWeight(10).otherwise(LootItem.lootTableItem(pSeedItem)).append(LootItem.lootTableItem(pGarlicItem).when(pBuilder).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).setWeight(1)))));
	}

	@Override
	public Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream().filter((pBlock) -> IcariaInfo.MODID.equals(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(pBlock)).getNamespace())).collect(Collectors.toList());
	}
}
