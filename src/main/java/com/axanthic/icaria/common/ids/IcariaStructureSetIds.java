package com.axanthic.icaria.common.ids;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructureSet;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureSetIds {
	public static final ResourceKey<StructureSet> PORTAL = IcariaStructureSetIds.create("portal");
	public static final ResourceKey<StructureSet> RUIN = IcariaStructureSetIds.create("ruin");
	public static final ResourceKey<StructureSet> TEMPLE = IcariaStructureSetIds.create("temple");
	public static final ResourceKey<StructureSet> VILLAGES = IcariaStructureSetIds.create("villages");

	public static ResourceKey<StructureSet> create(String pName) {
		return ResourceKey.create(Registries.STRUCTURE_SET, Identifier.fromNamespaceAndPath(IcariaIds.ID, pName));
	}
}
