package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.material.rule.MaterialRule;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMaterialRuleIds {
	public static final ResourceKey<MaterialRule> ICARIA = IcariaMaterialRuleIds.create("icaria");

	public static ResourceKey<MaterialRule> create(String pName) {
		return ResourceKey.create(Registries.MATERIAL_RULE, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
