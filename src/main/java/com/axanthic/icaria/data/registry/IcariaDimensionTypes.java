package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaDimensionTypeIds;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;

import java.util.Optional;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TimelineTags;
import net.minecraft.util.ARGB;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.attribute.BedRule;
import net.minecraft.world.attribute.EnvironmentAttributeMap;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.clock.WorldClocks;
import net.minecraft.world.level.CardinalLighting;
import net.minecraft.world.level.dimension.DimensionType;

import net.neoforged.neoforge.common.world.NeoForgeEnvironmentAttributes;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaDimensionTypes {
	public static void bootstrap(BootstrapContext<DimensionType> pBootstrapContext) {
		pBootstrapContext.register(IcariaDimensionTypeIds.ICARIA, new DimensionType(false, true, false, false, 1.0D, -64, 384, 384, pBootstrapContext.lookup(Registries.BLOCK).getOrThrow(BlockTags.INFINIBURN_OVERWORLD), 0.0F, new DimensionType.MonsterSettings(UniformInt.of(0, 7), 0), DimensionType.Skybox.OVERWORLD, CardinalLighting.Type.DEFAULT, EnvironmentAttributeMap.builder().set(EnvironmentAttributes.AMBIENT_LIGHT_COLOR, ARGB.vector3fFromRGB24(0xFF0A0A0A)).set(EnvironmentAttributes.CLOUD_HEIGHT, 224.0F).set(EnvironmentAttributes.CLOUD_COLOR, ARGB.vector4fFromARGB32(0xCCFFFFFF)).set(EnvironmentAttributes.FOG_COLOR, ARGB.vector3fFromRGB24(0xFFDCCD72)).set(EnvironmentAttributes.SKY_COLOR, ARGB.vector3fFromRGB24(0xFF7EAAF4)).set(EnvironmentAttributes.BED_RULE, BedRule.DESTROY_ON_USE).set(NeoForgeEnvironmentAttributes.CUSTOM_SKYBOX, IcariaIdentifiers.ICARIA).set(EnvironmentAttributes.STRAW_BED_RULE, BedRule.DESTROY_ON_USE).build(), pBootstrapContext.lookup(Registries.TIMELINE).getOrThrow(TimelineTags.IN_OVERWORLD), Optional.of(pBootstrapContext.lookup(Registries.WORLD_CLOCK).getOrThrow(WorldClocks.OVERWORLD))));
	}
}
