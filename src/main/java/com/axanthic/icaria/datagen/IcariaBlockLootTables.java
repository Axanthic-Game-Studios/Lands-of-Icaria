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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
import java.util.stream.Collectors;

@MethodsReturnNonnullByDefault

public class IcariaBlockLootTables extends BlockLoot {
	public static final LootItemCondition.Builder HAS_SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, Ints.atLeast(1))));
	public static final float[] SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

	@Override
	protected Iterable<Block> getKnownBlocks() {
		return ForgeRegistries.BLOCKS.getValues().stream().filter((block) -> IcariaInfo.MODID.equals(Objects.requireNonNull(block.getRegistryName()).getNamespace())).collect(Collectors.toList());
	}

	@Override
	protected void addTables() {
		for (RegistryObject<? extends Block> basicBlock : IcariaBlocks.BASIC_BLOCKS) {
			dropSelf(basicBlock.get());
		}

		for (StoneDecoItemBlocks deco : IcariaItems.STONE_BLOCKS) {
			if (deco.SLAB != null) {
				add(Objects.requireNonNull(deco.block.SLAB).get(), BlockLoot::createSlabItemTable);
			}
			if (deco.STAIRS != null) {
				dropSelf(Objects.requireNonNull(deco.block.STAIRS).get());
			}
			if (deco.WALL != null) {
				dropSelf(Objects.requireNonNull(deco.block.WALL).get());
			}
		}

		for (WoodDecoItemBlocks deco : IcariaItems.WOOD_BLOCKS) {
			if (deco.SLAB != null) {
				add(Objects.requireNonNull(deco.block.SLAB).get(), BlockLoot::createSlabItemTable);
			}
			if (deco.STAIRS != null) {
				dropSelf(Objects.requireNonNull(deco.block.STAIRS).get());
			}
			if (deco.FENCE != null) {
				dropSelf(Objects.requireNonNull(deco.block.FENCE).get());
			}
			if (deco.GATE != null) {
				dropSelf(Objects.requireNonNull(deco.block.GATE).get());
			}
		}

		requireSilkTouch(IcariaBlocks.MARL_GRASS.get(), IcariaItems.MARL.get());
		this.add(IcariaBlocks.MARL_CHERT.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.CHERT.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.MARL_ROTTEN_BONES.get(), (blockDrop) -> LootTable.lootTable().withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(blockDrop).when(HAS_SILK_TOUCH)
			.otherwise(applyExplosionDecay(Items.BONE, LootItem.lootTableItem(Items.BONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(25)
			.append(applyExplosionDecay(IcariaItems.ROTTEN_BONES.get(), LootItem.lootTableItem(IcariaItems.ROTTEN_BONES.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(25))
			.append(applyExplosionDecay(IcariaItems.REMAINS.get(), LootItem.lootTableItem(IcariaItems.REMAINS.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F)))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)).setWeight(1))))));
		this.add(IcariaBlocks.MARL_LIGNITE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.LIGNITE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		dropOther(IcariaBlocks.FARMLAND.get(), IcariaItems.MARL.get());
		dropOther(IcariaBlocks.FARMLAND_FERTILIZED.get(), IcariaItems.MARL.get());
		this.add(IcariaBlocks.LOAM.get(), (blockDrop) -> createSingleItemTableWithSilkTouch(blockDrop, IcariaItems.LOAM_LUMP.get(), ConstantValue.exactly(4.0F)));
		dropSelf(IcariaBlocks.DOLOMITE_PILLAR.get());
		dropSelf(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get());
		this.add(IcariaBlocks.GRAINEL_CHERT.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.CHERT.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		dropWhenSilkTouch(IcariaBlocks.GRAINGLASS.get());
		dropWhenSilkTouch(IcariaBlocks.GRAINGLASS_PANE.get());
		dropWhenSilkTouch(IcariaBlocks.GRAINGLASS_PANE_HORIZONTAL.get());
		requireSilkTouch(IcariaBlocks.YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_COBBLE.get());
		dropWhenSilkTouch(IcariaBlocks.SILKGLASS.get());
		dropWhenSilkTouch(IcariaBlocks.SILKGLASS_PANE.get());
		dropWhenSilkTouch(IcariaBlocks.SILKGLASS_PANE_HORIZONTAL.get());
		requireSilkTouch(IcariaBlocks.SILKSTONE.get(), IcariaItems.SILKSTONE_COBBLE.get());
		requireSilkTouch(IcariaBlocks.SUNSTONE.get(), IcariaItems.SUNSTONE_COBBLE.get());
		requireSilkTouch(IcariaBlocks.VOIDSHALE.get(), IcariaItems.VOIDSHALE_COBBLE.get());
		requireSilkTouch(IcariaBlocks.BAETYL.get(), IcariaItems.BAETYL_COBBLE.get());
		requireSilkTouch(IcariaBlocks.RELICSTONE_SMOOTH.get(), IcariaItems.RELICSTONE.get());
		dropSelf(IcariaBlocks.RELICSTONE_PILLAR.get());
		dropSelf(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get());
		this.add(IcariaBlocks.LIGNITE_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.LIGNITE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.CHALKOS_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.CHALKOS_RAW.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.KASSITEROS_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.KASSITEROS_RAW.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.DOLOMITE_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.DOLOMITE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.VANADIUM_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.VANADIUM_RAW.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.SLIVER_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.SLIVER.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.SIDEROS_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.SIDEROS_RAW.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.ANTHRACITE_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.ANTHRACITE.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.MOLYBDENUM_ORE.get(), (blockDrop) -> createSilkTouchDispatchTable(blockDrop, applyExplosionDecay(blockDrop, LootItem.lootTableItem(IcariaItems.MOLYBDENUM_RAW.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		dropWhenSilkTouch(IcariaBlocks.HYLIASTRUM_ORE.get());
		dropSelf(IcariaBlocks.QUARTZ_PILLAR_HEAD.get());
		dropSelf(IcariaBlocks.SPELT_BALE_BLOCK.get());
		dropSelf(IcariaBlocks.CYPRESS_SAPLING.get());
		dropPottedContents(IcariaBlocks.POTTED_CYPRESS_SAPLING.get());
		this.add(IcariaBlocks.CYPRESS_LEAVES.get(), (pBlock) -> createLeavesDrops(pBlock, IcariaBlocks.CYPRESS_SAPLING.get(), SAPLING_CHANCES));
		dropSelf(IcariaBlocks.CYPRESS_WOOD.get());
		dropSelf(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		dropSelf(IcariaBlocks.CYPRESS_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		dropSelf(IcariaBlocks.DEAD_CYPRESS_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		dropSelf(IcariaBlocks.DROUGHTROOT_SAPLING.get());
		dropPottedContents(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get());
		this.add(IcariaBlocks.DROUGHTROOT_LEAVES.get(), (pBlock) -> createLeavesDrops(pBlock, IcariaBlocks.DROUGHTROOT_SAPLING.get(), SAPLING_CHANCES));
		dropSelf(IcariaBlocks.DROUGHTROOT_WOOD.get());
		dropSelf(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		dropSelf(IcariaBlocks.DROUGHTROOT_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		dropSelf(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		dropSelf(IcariaBlocks.FIR_SAPLING.get());
		dropPottedContents(IcariaBlocks.POTTED_FIR_SAPLING.get());
		this.add(IcariaBlocks.FIR_LEAVES.get(), (pBlock) -> createLeavesDrops(pBlock, IcariaBlocks.FIR_SAPLING.get(), SAPLING_CHANCES));
		dropSelf(IcariaBlocks.FIR_WOOD.get());
		dropSelf(IcariaBlocks.STRIPPED_FIR_WOOD.get());
		dropSelf(IcariaBlocks.FIR_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_FIR_LOG.get());
		dropSelf(IcariaBlocks.DEAD_FIR_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		dropSelf(IcariaBlocks.LAUREL_SAPLING.get());
		dropPottedContents(IcariaBlocks.POTTED_LAUREL_SAPLING.get());
		this.add(IcariaBlocks.LAUREL_LEAVES.get(), (pBlock) -> createLeavesDrops(pBlock, IcariaBlocks.LAUREL_SAPLING.get(), SAPLING_CHANCES));
		dropSelf(IcariaBlocks.LAUREL_WOOD.get());
		dropSelf(IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		dropSelf(IcariaBlocks.LAUREL_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		dropSelf(IcariaBlocks.DEAD_LAUREL_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		dropSelf(IcariaBlocks.OLIVE_SAPLING.get());
		dropPottedContents(IcariaBlocks.POTTED_OLIVE_SAPLING.get());
		this.add(IcariaBlocks.OLIVE_LEAVES.get(), (pBlock) -> createLeavesDrops(pBlock, IcariaBlocks.OLIVE_SAPLING.get(), SAPLING_CHANCES));
		this.add(IcariaBlocks.OLIVE_LEAVES_BLACK.get(), (pBlock) -> createSilkTouchOrShearsDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(IcariaItems.OLIVES_BLACK.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		this.add(IcariaBlocks.OLIVE_LEAVES_GREEN.get(), (pBlock) -> createSilkTouchOrShearsDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(IcariaItems.OLIVES_GREEN.get()).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
		dropSelf(IcariaBlocks.OLIVE_WOOD.get());
		dropSelf(IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		dropSelf(IcariaBlocks.OLIVE_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		dropSelf(IcariaBlocks.DEAD_OLIVE_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		dropSelf(IcariaBlocks.PLANE_SAPLING.get());
		dropPottedContents(IcariaBlocks.POTTED_PLANE_SAPLING.get());
		this.add(IcariaBlocks.PLANE_LEAVES.get(), (pBlock) -> createLeavesDrops(pBlock, IcariaBlocks.PLANE_SAPLING.get(), SAPLING_CHANCES));
		dropSelf(IcariaBlocks.PLANE_WOOD.get());
		dropSelf(IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		dropSelf(IcariaBlocks.PLANE_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_PLANE_LOG.get());
		dropSelf(IcariaBlocks.DEAD_PLANE_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		dropSelf(IcariaBlocks.POPULUS_SAPLING.get());
		dropPottedContents(IcariaBlocks.POTTED_POPULUS_SAPLING.get());
		this.add(IcariaBlocks.POPULUS_LEAVES.get(), (pBlock) -> createLeavesDrops(pBlock, IcariaBlocks.POPULUS_SAPLING.get(), SAPLING_CHANCES));
		dropSelf(IcariaBlocks.POPULUS_WOOD.get());
		dropSelf(IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		dropSelf(IcariaBlocks.POPULUS_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		dropSelf(IcariaBlocks.DEAD_POPULUS_LOG.get());
		dropSelf(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());
		dropSelf(IcariaBlocks.LIGNITE_TORCH.get());
		dropOther(IcariaBlocks.LIGNITE_WALL_TORCH.get(), IcariaItems.LIGNITE_TORCH.get());
		dropSelf(IcariaBlocks.ANTHRACITE_TORCH.get());
		dropOther(IcariaBlocks.ANTHRACITE_WALL_TORCH.get(), IcariaItems.ANTHRACITE_TORCH.get());
		dropLayers(IcariaBlocks.MOSS_0.get());
		dropLayers(IcariaBlocks.MOSS_1.get());
		dropLayers(IcariaBlocks.MOSS_2.get());
	}

	public void requireSilkTouch(Block block, Item item) {
		add(block, (blockDrop) -> createSingleItemTableWithSilkTouch(blockDrop, item));
	}

	public void dropLayers(Block block) { //like onions
		this.add(block, (blockDrop) -> LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)).add(AlternativesEntry.alternatives(
			LootItem.lootTableItem(blockDrop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(blockDrop).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 1))),
			LootItem.lootTableItem(blockDrop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(blockDrop).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 2))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0F))),
			LootItem.lootTableItem(blockDrop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(blockDrop).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 3))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(3.0F))),
			LootItem.lootTableItem(blockDrop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(blockDrop).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 4))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0F))),
			LootItem.lootTableItem(blockDrop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(blockDrop).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 5))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(5.0F))),
			LootItem.lootTableItem(blockDrop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(blockDrop).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 6))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(6.0F))),
			LootItem.lootTableItem(blockDrop).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(blockDrop).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SnowLayerBlock.LAYERS, 7))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(7.0F))),
			LootItem.lootTableItem(blockDrop).apply(SetItemCountFunction.setCount(ConstantValue.exactly(8.0F)))))));
	}
}
