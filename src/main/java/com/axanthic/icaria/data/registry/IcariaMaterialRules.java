package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaBiomeIds;
import com.axanthic.icaria.common.ids.IcariaMaterialRuleIds;
import com.axanthic.icaria.common.registry.IcariaBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.material.MaterialRules;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMaterialRules {
	public static void bootstrap(BootstrapContext<MaterialRule> pBootstrapContext) {
		pBootstrapContext.register(IcariaMaterialRuleIds.ICARIA, IcariaMaterialRules.materialRule(pBootstrapContext));
	}

	public static MaterialRule materialRule(BootstrapContext<MaterialRule> pBootstrapContext) {
		var biomes = pBootstrapContext.lookup(Registries.BIOME);
		var materialRuleA = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, IcariaBiomeIds.FOREST, IcariaBiomeIds.LUSH_FOREST, IcariaBiomeIds.LOST_FOREST, IcariaBiomeIds.DEEP_FOREST), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, 0.5D, 2.0D), MaterialRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -2.0D, 0.5D), MaterialRules.state(IcariaBlocks.GRASSY_MARL.get().defaultBlockState())))));
		var materialRuleB = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, IcariaBiomeIds.FOREST, IcariaBiomeIds.LUSH_FOREST, IcariaBiomeIds.LOST_FOREST, IcariaBiomeIds.DEEP_FOREST), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, 0.5D, 2.0D), MaterialRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -2.0D, 0.5D), MaterialRules.state(IcariaBlocks.MARL.get().defaultBlockState())))));
		var materialRuleC = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, IcariaBiomeIds.SCRUBLAND, IcariaBiomeIds.LUSH_SCRUBLAND, IcariaBiomeIds.LOST_SCRUBLAND, IcariaBiomeIds.DEEP_SCRUBLAND, IcariaBiomeIds.STEPPE, IcariaBiomeIds.LUSH_STEPPE, IcariaBiomeIds.LOST_STEPPE, IcariaBiomeIds.DEEP_STEPPE), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, 0.2D, 2.0D), MaterialRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -0.2D, 0.2D), MaterialRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -2.0D, -0.2D), MaterialRules.state(IcariaBlocks.GRASSY_MARL.get().defaultBlockState())))));
		var materialRuleD = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, IcariaBiomeIds.SCRUBLAND, IcariaBiomeIds.LUSH_SCRUBLAND, IcariaBiomeIds.LOST_SCRUBLAND, IcariaBiomeIds.DEEP_SCRUBLAND, IcariaBiomeIds.STEPPE, IcariaBiomeIds.LUSH_STEPPE, IcariaBiomeIds.LOST_STEPPE, IcariaBiomeIds.DEEP_STEPPE), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, 0.2D, 2.0D), MaterialRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -0.2D, 0.2D), MaterialRules.state(IcariaBlocks.COARSE_MARL.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -2.0D, -0.2D), MaterialRules.state(IcariaBlocks.MARL.get().defaultBlockState())))));
		var materialRuleE = MaterialRules.ifTrue(MaterialRules.stoneDepthCheck(8, false, 0, CaveSurface.FLOOR), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, IcariaBiomeIds.DESERT, IcariaBiomeIds.LUSH_DESERT, IcariaBiomeIds.LOST_DESERT, IcariaBiomeIds.DEEP_DESERT), MaterialRules.sequence(MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, 0.2D, 2.0D), MaterialRules.state(IcariaBlocks.LOAM.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -0.2D, 0.2D), MaterialRules.state(IcariaBlocks.SILKSAND.get().defaultBlockState())), MaterialRules.ifTrue(MaterialRules.noiseCondition2d(Noises.SURFACE, -2.0D, -0.2D), MaterialRules.state(IcariaBlocks.GRAINEL.get().defaultBlockState())))));
		var materialRuleF = MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(0), 0), MaterialRules.ifTrue(MaterialRules.isBiome(biomes, IcariaBiomeIds.VOID), MaterialRules.state(Blocks.AIR.defaultBlockState())));
		var materialRuleG = MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(64), 2), MaterialRules.state(IcariaBlocks.YELLOWSTONE.get().defaultBlockState()));
		var materialRuleH = MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(48), 2), MaterialRules.state(IcariaBlocks.SILKSTONE.get().defaultBlockState()));
		var materialRuleI = MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(32), 2), MaterialRules.state(IcariaBlocks.SUNSTONE.get().defaultBlockState()));
		var materialRuleJ = MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(16), 2), MaterialRules.state(IcariaBlocks.VOIDSHALE.get().defaultBlockState()));
		var materialRuleK = MaterialRules.ifTrue(MaterialRules.yBlockCheck(VerticalAnchor.absolute(0), 0), MaterialRules.state(IcariaBlocks.BAETYL.get().defaultBlockState()));
		return MaterialRules.sequence(materialRuleA, materialRuleB, materialRuleC, materialRuleD, materialRuleE, materialRuleF, materialRuleG, materialRuleH, materialRuleI, materialRuleJ, materialRuleK);
	}
}
