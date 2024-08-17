package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaStructures;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.structure.Structure;

import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureTags extends StructureTagsProvider {
	public static final TagKey<Structure> FOREST_VILLAGES = IcariaStructureTags.icariaTag("forest_villages");
	public static final TagKey<Structure> SCRUBLAND_VILLAGES = IcariaStructureTags.icariaTag("scrubland_villages");
	public static final TagKey<Structure> STEPPE_VILLAGES = IcariaStructureTags.icariaTag("steppe_villages");
	public static final TagKey<Structure> DESERT_VILLAGES = IcariaStructureTags.icariaTag("desert_villages");

	public static final TagKey<Structure> ERODED_VILLAGES = IcariaStructureTags.icariaTag("eroded_villages");
	public static final TagKey<Structure> PRISTINE_VILLAGES = IcariaStructureTags.icariaTag("pristine_villages");
	public static final TagKey<Structure> RUINED_VILLAGES = IcariaStructureTags.icariaTag("ruined_villages");

	public static final TagKey<Structure> VILLAGES = IcariaStructureTags.icariaTag("villages");

	public IcariaStructureTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaStructureTags.FOREST_VILLAGES)
			.add(IcariaStructures.ERODED_FOREST_VILLAGE)
			.add(IcariaStructures.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructures.RUINED_FOREST_VILLAGE);

		this.tag(IcariaStructureTags.SCRUBLAND_VILLAGES)
			.add(IcariaStructures.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.RUINED_SCRUBLAND_VILLAGE);

		this.tag(IcariaStructureTags.STEPPE_VILLAGES)
			.add(IcariaStructures.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructures.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructures.RUINED_STEPPE_VILLAGE);

		this.tag(IcariaStructureTags.DESERT_VILLAGES)
			.add(IcariaStructures.ERODED_DESERT_VILLAGE)
			.add(IcariaStructures.PRISTINE_DESERT_VILLAGE)
			.add(IcariaStructures.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.ERODED_VILLAGES)
			.add(IcariaStructures.ERODED_FOREST_VILLAGE)
			.add(IcariaStructures.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructures.ERODED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.PRISTINE_VILLAGES)
			.add(IcariaStructures.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructures.PRISTINE_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.RUINED_VILLAGES)
			.add(IcariaStructures.RUINED_FOREST_VILLAGE)
			.add(IcariaStructures.RUINED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.RUINED_STEPPE_VILLAGE)
			.add(IcariaStructures.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.VILLAGES)
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

	public static TagKey<Structure> bind(String pName) {
		return TagKey.create(Registries.STRUCTURE, ResourceLocation.parse(pName));
	}

	public static TagKey<Structure> cTag(String pName) {
		return IcariaStructureTags.bind(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<Structure> icariaTag(String pName) {
		return IcariaStructureTags.bind(IcariaIdents.ID + ":" + pName);
	}
}
