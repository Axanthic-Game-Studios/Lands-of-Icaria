package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.data.registry.IcariaStructures;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureTagsProvider extends StructureTagsProvider {
	public static final TagKey<Structure> FOREST_VILLAGES = IcariaStructureTagsProvider.icariaKey("forest_villages");
	public static final TagKey<Structure> SCRUBLAND_VILLAGES = IcariaStructureTagsProvider.icariaKey("scrubland_villages");
	public static final TagKey<Structure> STEPPE_VILLAGES = IcariaStructureTagsProvider.icariaKey("steppe_villages");
	public static final TagKey<Structure> DESERT_VILLAGES = IcariaStructureTagsProvider.icariaKey("desert_villages");

	public static final TagKey<Structure> ERODED_VILLAGES = IcariaStructureTagsProvider.icariaKey("eroded_villages");
	public static final TagKey<Structure> PRISTINE_VILLAGES = IcariaStructureTagsProvider.icariaKey("pristine_villages");
	public static final TagKey<Structure> RUINED_VILLAGES = IcariaStructureTagsProvider.icariaKey("ruined_villages");

	public static final TagKey<Structure> VILLAGES = IcariaStructureTagsProvider.icariaKey("villages");

	public IcariaStructureTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaStructureTagsProvider.FOREST_VILLAGES)
			.add(IcariaStructures.ERODED_FOREST_VILLAGE)
			.add(IcariaStructures.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructures.RUINED_FOREST_VILLAGE);

		this.tag(IcariaStructureTagsProvider.SCRUBLAND_VILLAGES)
			.add(IcariaStructures.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.RUINED_SCRUBLAND_VILLAGE);

		this.tag(IcariaStructureTagsProvider.STEPPE_VILLAGES)
			.add(IcariaStructures.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructures.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructures.RUINED_STEPPE_VILLAGE);

		this.tag(IcariaStructureTagsProvider.DESERT_VILLAGES)
			.add(IcariaStructures.ERODED_DESERT_VILLAGE)
			.add(IcariaStructures.PRISTINE_DESERT_VILLAGE)
			.add(IcariaStructures.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTagsProvider.ERODED_VILLAGES)
			.add(IcariaStructures.ERODED_FOREST_VILLAGE)
			.add(IcariaStructures.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructures.ERODED_DESERT_VILLAGE);

		this.tag(IcariaStructureTagsProvider.PRISTINE_VILLAGES)
			.add(IcariaStructures.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructures.PRISTINE_DESERT_VILLAGE);

		this.tag(IcariaStructureTagsProvider.RUINED_VILLAGES)
			.add(IcariaStructures.RUINED_FOREST_VILLAGE)
			.add(IcariaStructures.RUINED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.RUINED_STEPPE_VILLAGE)
			.add(IcariaStructures.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTagsProvider.VILLAGES)
			.add(IcariaStructures.ERODED_FOREST_VILLAGE)
			.add(IcariaStructures.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructures.RUINED_FOREST_VILLAGE)
			.add(IcariaStructures.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.RUINED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructures.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructures.RUINED_STEPPE_VILLAGE)
			.add(IcariaStructures.ERODED_DESERT_VILLAGE)
			.add(IcariaStructures.PRISTINE_DESERT_VILLAGE)
			.add(IcariaStructures.RUINED_DESERT_VILLAGE);
	}

	@Override
	public String getName() {
		return "Structure Tags";
	}

	public static TagKey<Structure> cKey(String pName) {
		return IcariaStructureTagsProvider.createKey(IcariaKeys.C + ":" + pName);
	}

	public static TagKey<Structure> icariaKey(String pName) {
		return IcariaStructureTagsProvider.createKey(IcariaKeys.ID + ":" + pName);
	}

	public static TagKey<Structure> createKey(String pName) {
		return TagKey.create(Registries.STRUCTURE, Identifier.parse(pName));
	}
}
