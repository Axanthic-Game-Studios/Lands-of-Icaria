package com.axanthic.icaria.datagen;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaItems.StoneDecoItemBlocks;
import com.axanthic.icaria.common.registry.IcariaItems.WoodDecoItemBlocks;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds.Ints;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootContext.EntityTarget;
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
import java.util.stream.Collectors;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unchecked")
@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockLootTables extends BlockLoot {
	public static final float[] SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
	public static final LootItemCondition.Builder HAS_SHEARS = MatchTool.toolMatches(ItemPredicate.Builder.item().of(Items.SHEARS));
	public static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, Ints.atLeast(1))));
	public static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
	public static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

	@Override
	public void addTables() {

		dropWithSilk(IcariaBlocks.MARL_GRASS.get(), IcariaItems.MARL.get(), 1.0F, 1.0F);
		dropWithSilk(IcariaBlocks.LOAM.get(), IcariaItems.LOAM_LUMP.get(), 4.0F, 4.0F);
		dropWithSilk(IcariaBlocks.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_COBBLE.get(), 1.0F, 1.0F);
		dropWithSilk(IcariaBlocks.SILKSTONE.get(), IcariaItems.SILKSTONE_COBBLE.get(), 1.0F, 1.0F);
		dropWithSilk(IcariaBlocks.SUNSTONE.get(), IcariaItems.SUNSTONE_COBBLE.get(), 1.0F, 1.0F);
		dropWithSilk(IcariaBlocks.VOIDSHALE.get(), IcariaItems.VOIDSHALE_COBBLE.get(), 1.0F, 1.0F);
		dropWithSilk(IcariaBlocks.BAETYL.get(), IcariaItems.BAETYL_COBBLE.get(), 1.0F, 1.0F);
		dropWithSilk(IcariaBlocks.RELICSTONE_SMOOTH.get(), IcariaItems.RELICSTONE.get(), 1.0F, 1.0F);
		dropWithSilk(IcariaBlocks.CYPRESS_TWIGS.get(), Items.STICK, 0.0F, 4.0F);
		dropWithSilk(IcariaBlocks.DROUGHTROOT_TWIGS.get(), Items.STICK, 0.0F, 4.0F);
		dropWithSilk(IcariaBlocks.FIR_TWIGS.get(), Items.STICK, 0.0F, 4.0F);
		dropWithSilk(IcariaBlocks.LAUREL_TWIGS.get(), Items.STICK, 0.0F, 4.0F);
		dropWithSilk(IcariaBlocks.OLIVE_TWIGS.get(), Items.STICK, 0.0F, 4.0F);
		dropWithSilk(IcariaBlocks.PLANE_TWIGS.get(), Items.STICK, 0.0F, 4.0F);
		dropWithSilk(IcariaBlocks.POPULUS_TWIGS.get(), Items.STICK, 0.0F, 4.0F);

		dropOres(IcariaBlocks.MARL_CHERT.get(), IcariaItems.CHERT.get());
		dropOres(IcariaBlocks.MARL_LIGNITE.get(), IcariaItems.LIGNITE.get());
		dropOres(IcariaBlocks.GRAINEL_CHERT.get(), IcariaItems.CHERT.get());
		dropOres(IcariaBlocks.LIGNITE_ORE.get(), IcariaItems.LIGNITE.get());
		dropOres(IcariaBlocks.CHALKOS_ORE.get(), IcariaItems.CHALKOS_RAW.get());
		dropOres(IcariaBlocks.KASSITEROS_ORE.get(), IcariaItems.KASSITEROS_RAW.get());
		dropOres(IcariaBlocks.DOLOMITE_ORE.get(), IcariaItems.DOLOMITE.get());
		dropOres(IcariaBlocks.VANADIUM_ORE.get(), IcariaItems.VANADIUM_RAW.get());
		dropOres(IcariaBlocks.SLIVER_ORE.get(), IcariaItems.SLIVER.get());
		dropOres(IcariaBlocks.SIDEROS_ORE.get(), IcariaItems.SIDEROS_RAW.get());
		dropOres(IcariaBlocks.ANTHRACITE_ORE.get(), IcariaItems.ANTHRACITE.get());
		dropOres(IcariaBlocks.MOLYBDENUM_ORE.get(), IcariaItems.MOLYBDENUM_RAW.get());

		dropBone(IcariaBlocks.MARL_ROTTEN_BONES.get(), Items.BONE, IcariaItems.ROTTEN_BONES.get(), IcariaItems.REMAINS.get());

		dropElse(IcariaBlocks.FARMLAND.get(), IcariaItems.MARL.get());
		dropElse(IcariaBlocks.FARMLAND_FERTILIZED.get(), IcariaItems.MARL.get());
		dropElse(IcariaBlocks.LIGNITE_WALL_TORCH.get(), IcariaItems.LIGNITE_TORCH.get());
		dropElse(IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), IcariaItems.ANTHRACITE_TORCH.get());
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_CANDLE.get(), Items.CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_WHITE_CANDLE.get(), Items.WHITE_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_ORANGE_CANDLE.get(), Items.ORANGE_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_MAGENTA_CANDLE.get(), Items.MAGENTA_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_LIGHT_BLUE_CANDLE.get(), Items.LIGHT_BLUE_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_YELLOW_CANDLE.get(), Items.YELLOW_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_LIME_CANDLE.get(), Items.LIME_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_PINK_CANDLE.get(), Items.PINK_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_GRAY_CANDLE.get(), Items.GRAY_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_LIGHT_GRAY_CANDLE.get(), Items.LIGHT_GRAY_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_CYAN_CANDLE.get(), Items.CYAN_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_PURPLE_CANDLE.get(), Items.PURPLE_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_BLUE_CANDLE.get(), Items.BLUE_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_BROWN_CANDLE.get(), Items.BROWN_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_GREEN_CANDLE.get(), Items.GREEN_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_RED_CANDLE.get(), Items.RED_CANDLE);
		dropElse(IcariaBlocks.STRAWBERRY_CAKE_BLACK_CANDLE.get(), Items.BLACK_CANDLE);

		dropWhenSilk(IcariaBlocks.GRAINGLASS.get());
		dropWhenSilk(IcariaBlocks.GRAINGLASS_PANE.get());
		dropWhenSilk(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get());
		dropWhenSilk(IcariaBlocks.SILKGLASS.get());
		dropWhenSilk(IcariaBlocks.SILKGLASS_PANE.get());
		dropWhenSilk(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());
		dropWhenSilk(IcariaBlocks.HYLIASTRUM_ORE.get());
		dropWhenSilk(IcariaBlocks.GRAINITE_RUBBLE.get());
		dropWhenSilk(IcariaBlocks.YELLOWSTONE_RUBBLE.get());
		dropWhenSilk(IcariaBlocks.SILKSTONE_RUBBLE.get());
		dropWhenSilk(IcariaBlocks.SUNSTONE_RUBBLE.get());
		dropWhenSilk(IcariaBlocks.VOIDSHALE_RUBBLE.get());
		dropWhenSilk(IcariaBlocks.BAETYL_RUBBLE.get());
		dropWhenSilk(IcariaBlocks.RELICSTONE_RUBBLE.get());

		dropThis(IcariaBlocks.RELICSTONE_PILLAR.get());
		dropThis(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get());
		dropThis(IcariaBlocks.DOLOMITE_PILLAR.get());
		dropThis(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());
		dropThis(IcariaBlocks.QUARTZ_PILLAR_HEAD.get());
		dropThis(IcariaBlocks.SPELT_BALE_BLOCK.get());
		dropThis(IcariaBlocks.CYPRESS_SAPLING.get());
		dropThis(IcariaBlocks.CYPRESS_WOOD.get());
		dropThis(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		dropThis(IcariaBlocks.CYPRESS_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		dropThis(IcariaBlocks.DEAD_CYPRESS_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		dropThis(IcariaBlocks.CYPRESS_TRAPDOOR.get());
		dropThis(IcariaBlocks.CYPRESS_LADDER.get());
		dropThis(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		dropThis(IcariaBlocks.DROUGHTROOT_WOOD.get());
		dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		dropThis(IcariaBlocks.DROUGHTROOT_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		dropThis(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		dropThis(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get());
		dropThis(IcariaBlocks.DROUGHTROOT_LADDER.get());
		dropThis(IcariaBlocks.FIR_SAPLING.get());
		dropThis(IcariaBlocks.FIR_WOOD.get());
		dropThis(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		dropThis(IcariaBlocks.FIR_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_FIR_LOG.get());
		dropThis(IcariaBlocks.DEAD_FIR_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		dropThis(IcariaBlocks.FIR_TRAPDOOR.get());
		dropThis(IcariaBlocks.FIR_LADDER.get());
		dropThis(IcariaBlocks.LAUREL_SAPLING.get());
		dropThis(IcariaBlocks.LAUREL_WOOD.get());
		dropThis(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		dropThis(IcariaBlocks.LAUREL_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		dropThis(IcariaBlocks.DEAD_LAUREL_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		dropThis(IcariaBlocks.LAUREL_TRAPDOOR.get());
		dropThis(IcariaBlocks.LAUREL_LADDER.get());
		dropThis(IcariaBlocks.OLIVE_SAPLING.get());
		dropThis(IcariaBlocks.OLIVE_WOOD.get());
		dropThis(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		dropThis(IcariaBlocks.OLIVE_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		dropThis(IcariaBlocks.DEAD_OLIVE_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		dropThis(IcariaBlocks.OLIVE_TRAPDOOR.get());
		dropThis(IcariaBlocks.OLIVE_LADDER.get());
		dropThis(IcariaBlocks.PLANE_SAPLING.get());
		dropThis(IcariaBlocks.PLANE_WOOD.get());
		dropThis(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		dropThis(IcariaBlocks.PLANE_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		dropThis(IcariaBlocks.DEAD_PLANE_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		dropThis(IcariaBlocks.PLANE_TRAPDOOR.get());
		dropThis(IcariaBlocks.PLANE_LADDER.get());
		dropThis(IcariaBlocks.POPULUS_SAPLING.get());
		dropThis(IcariaBlocks.POPULUS_WOOD.get());
		dropThis(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		dropThis(IcariaBlocks.POPULUS_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		dropThis(IcariaBlocks.DEAD_POPULUS_LOG.get());
		dropThis(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());
		dropThis(IcariaBlocks.POPULUS_TRAPDOOR.get());
		dropThis(IcariaBlocks.POPULUS_LADDER.get());
		dropThis(IcariaBlocks.LIGNITE_TORCH.get());
		dropThis(IcariaBlocks.ANTHRACITE_TORCH.get());

		dropPots(IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		dropPots(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		dropPots(IcariaBlocks.POTTED_FIR_SAPLING.get());
		dropPots(IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		dropPots(IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		dropPots(IcariaBlocks.POTTED_PLANE_SAPLING.get());
		dropPots(IcariaBlocks.POTTED_POPULUS_SAPLING.get());

		dropLeaves(IcariaBlocks.CYPRESS_LEAVES.get(), IcariaBlocks.CYPRESS_SAPLING.get());
		dropLeaves(IcariaBlocks.DROUGHTROOT_LEAVES.get(), IcariaBlocks.DROUGHTROOT_SAPLING.get());
		dropLeaves(IcariaBlocks.FIR_LEAVES.get(), IcariaBlocks.FIR_SAPLING.get());
		dropLeaves(IcariaBlocks.OLIVE_LEAVES.get(), IcariaBlocks.OLIVE_SAPLING.get());
		dropLeaves(IcariaBlocks.PLANE_LEAVES.get(), IcariaBlocks.PLANE_SAPLING.get());
		dropLeaves(IcariaBlocks.POPULUS_LEAVES.get(), IcariaBlocks.POPULUS_SAPLING.get());

		dropLaurelsLeaves(IcariaBlocks.LAUREL_LEAVES.get(), IcariaBlocks.LAUREL_SAPLING.get());

		dropOlivesLeaves(IcariaBlocks.OLIVE_LEAVES_BLACK.get(), IcariaItems.OLIVES_BLACK.get());
		dropOlivesLeaves(IcariaBlocks.OLIVE_LEAVES_GREEN.get(), IcariaItems.OLIVES_GREEN.get());

		dropLayers(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get());
		dropLayers(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get());
		dropLayers(IcariaBlocks.FALLEN_FIR_LEAVES.get());
		dropLayers(IcariaBlocks.FALLEN_LAUREL_LEAVES.get());
		dropLayers(IcariaBlocks.FALLEN_OLIVE_LEAVES.get());
		dropLayers(IcariaBlocks.FALLEN_PLANE_LEAVES.get());
		dropLayers(IcariaBlocks.FALLEN_POPULUS_LEAVES.get());
		dropLayers(IcariaBlocks.MOSS_0.get());
		dropLayers(IcariaBlocks.MOSS_1.get());
		dropLayers(IcariaBlocks.MOSS_2.get());

		dropDoor(IcariaBlocks.CYPRESS_DOOR.get());
		dropDoor(IcariaBlocks.DROUGHTROOT_DOOR.get());
		dropDoor(IcariaBlocks.FIR_DOOR.get());
		dropDoor(IcariaBlocks.LAUREL_DOOR.get());
		dropDoor(IcariaBlocks.OLIVE_DOOR.get());
		dropDoor(IcariaBlocks.PLANE_DOOR.get());
		dropDoor(IcariaBlocks.POPULUS_DOOR.get());

		dropNone(IcariaBlocks.STRAWBERRY_CAKE.get());

		for (RegistryObject<? extends Block> registryObject : IcariaBlocks.BASIC_BLOCKS) {
			dropThis(registryObject.get());
		}

		for (StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
			if (deco.SLAB != null) {
				add(Objects.requireNonNull(deco.block.SLAB).get(), BlockLoot::createSlabItemTable);
			}
			if (deco.STAIRS != null) {
				dropThis(Objects.requireNonNull(deco.block.STAIRS).get());
			}
			if (deco.WALL != null) {
				dropThis(Objects.requireNonNull(deco.block.WALL).get());
			}
		}

		for (WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			if (deco.SLAB != null) {
				add(Objects.requireNonNull(deco.block.SLAB).get(), BlockLoot::createSlabItemTable);
			}
			if (deco.STAIRS != null) {
				dropThis(Objects.requireNonNull(deco.block.STAIRS).get());
			}
			if (deco.FENCE != null) {
				dropThis(Objects.requireNonNull(deco.block.FENCE).get());
			}
			if (deco.GATE != null) {
				dropThis(Objects.requireNonNull(deco.block.GATE).get());
			}
		}
	}

	public void dropWithSilk(Block pBlock, Item pItem, float pMin, float pMax) {
		add(pBlock, createSingleItemTableWithSilkTouch(pBlock, pItem, UniformGenerator.between(pMin, pMax)));
	}

	public void dropBone(Block pBlock, Item pItemOne, Item pItemTwo, Item pItemThree) {
		add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(pBlock).when(HAS_SILK_TOUCH).otherwise(applyExplosionDecay(pItemOne, LootItem.lootTableItem(pItemOne).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(25).append(applyExplosionDecay(pItemTwo, LootItem.lootTableItem(pItemTwo).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(25)).append(applyExplosionDecay(pItemThree, LootItem.lootTableItem(pItemThree).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(1))))));
	}

	public void dropElse(Block pBlock, ItemLike pItem) {
		add(pBlock, createSingleItemTable(pItem));
	}

	public void dropWhenSilk(Block pBlock) {
		add(pBlock, createSilkTouchOnlyTable(pBlock));
	}

	public void dropOres(Block pBlock, Item pItem) {
		add(pBlock, createOreDrop(pBlock, pItem));
	}

	public void dropThis(Block pBlock) {
		add(pBlock, createSingleItemTable(pBlock));
	}

	public void dropPots(Block pBlock) {
		add(pBlock, createPotFlowerItemTable(((FlowerPotBlock)pBlock).getContent()));
	}

	public void dropLeaves(Block pLeavesBlock, Block pSaplingBlock) {
		add(pLeavesBlock, createLeavesDrops(pLeavesBlock, pSaplingBlock, SAPLING_CHANCES));
	}

	public void dropLaurelsLeaves(Block pLeavesBlock, Block pSaplingBlock) {
		add(pLeavesBlock, createLaurelLeavesDrops(pLeavesBlock, pSaplingBlock, SAPLING_CHANCES));
	}

	public void dropOlivesLeaves(Block pBlock, Item pItem) {
		add(pBlock, createSilkTouchOrShearsDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
	}

	public void dropLayers(Block pBlock) {
		add(pBlock, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemEntityPropertyCondition.entityPresent(EntityTarget.THIS)).add(AlternativesEntry.alternatives(LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))), LootItem.lootTableItem(pBlock).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0F))), LootItem.lootTableItem(pBlock).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0F)))))));
	}

	public void dropDoor(Block pBlock) {
		add(pBlock, createSinglePropConditionTable(pBlock, DoorBlock.HALF, DoubleBlockHalf.LOWER));
	}

	public void dropNone(Block pBlock) {
		add(pBlock, noDrop());
	}

	public static LootTable.Builder createLaurelLeavesDrops(Block pLeavesBlock, Block pSaplingBlock, float... pChances) {
		return createLeavesDrops(pLeavesBlock, pSaplingBlock, pChances).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH).add(applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(IcariaItems.LAUREL_CHERRY.get())).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
	}

	@Override
	public Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream().filter((block) -> IcariaInfo.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace())).collect(Collectors.toList());
	}
}
