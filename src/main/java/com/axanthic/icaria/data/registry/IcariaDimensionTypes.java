package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.registry.IcariaKeys;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TimelineTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.level.dimension.DimensionType;

import net.neoforged.neoforge.common.world.NeoForgeEnvironmentAttributes;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensionTypes {
	public static final ResourceKey<DimensionType> ICARIA = IcariaDimensionTypes.createKey("icaria");

	public static void bootstrap(BootstrapContext<DimensionType> pBootstrapContext) {
		pBootstrapContext.register(IcariaDimensionTypes.ICARIA, new DimensionType(false, true, false, 1.0D, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, 0.0F, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.OVERWORLD, DimensionType.CardinalLightType.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.CLOUD_HEIGHT, 224.0F).set(EnvironmentAttributes.CLOUD_COLOR, 0xCCFFFFFF).set(EnvironmentAttributes.FOG_COLOR, 0xFFDCCD72).set(EnvironmentAttributes.SKY_COLOR, 0xFF7EAAF4).set(EnvironmentAttributes.BED_RULE, BedRule.EXPLODES).set(NeoForgeEnvironmentAttributes.CUSTOM_SKYBOX, IcariaIdentifiers.ICARIA).build(), pBootstrapContext.lookup(Registries.TIMELINE).getOrThrow(TimelineTags.IN_OVERWORLD)));
	}

	public static ResourceKey<DimensionType> createKey(String pName) {
		return ResourceKey.create(Registries.DIMENSION_TYPE, Identifier.fromNamespaceAndPath(IcariaKeys.ID, pName));
	}
}
