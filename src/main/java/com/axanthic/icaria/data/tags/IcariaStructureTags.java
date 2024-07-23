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
	public static final TagKey<Structure> FOREST_VILLAGE = IcariaStructureTags.icariaTag("forest_village");
	public static final TagKey<Structure> SCRUBLAND_VILLAGE = IcariaStructureTags.icariaTag("scrubland_village");
	public static final TagKey<Structure> STEPPE_VILLAGE = IcariaStructureTags.icariaTag("steppe_village");
	public static final TagKey<Structure> DESERT_VILLAGE = IcariaStructureTags.icariaTag("desert_village");

	public static final TagKey<Structure> ERODED_VILLAGE = IcariaStructureTags.icariaTag("eroded_village");
	public static final TagKey<Structure> PRISTINE_VILLAGE = IcariaStructureTags.icariaTag("pristine_village");
	public static final TagKey<Structure> RUINED_VILLAGE = IcariaStructureTags.icariaTag("ruined_village");

	public static final TagKey<Structure> VILLAGE = IcariaStructureTags.icariaTag("village");

	public IcariaStructureTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider, pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaStructureTags.FOREST_VILLAGE)
			.add(IcariaStructures.ERODED_FOREST_VILLAGE)
			.add(IcariaStructures.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructures.RUINED_FOREST_VILLAGE);

		this.tag(IcariaStructureTags.SCRUBLAND_VILLAGE)
			.add(IcariaStructures.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.RUINED_SCRUBLAND_VILLAGE);

		this.tag(IcariaStructureTags.STEPPE_VILLAGE)
			.add(IcariaStructures.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructures.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructures.RUINED_STEPPE_VILLAGE);

		this.tag(IcariaStructureTags.DESERT_VILLAGE)
			.add(IcariaStructures.ERODED_DESERT_VILLAGE)
			.add(IcariaStructures.PRISTINE_DESERT_VILLAGE)
			.add(IcariaStructures.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.ERODED_VILLAGE)
			.add(IcariaStructures.ERODED_FOREST_VILLAGE)
			.add(IcariaStructures.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructures.ERODED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.PRISTINE_VILLAGE)
			.add(IcariaStructures.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructures.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructures.PRISTINE_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.RUINED_VILLAGE)
			.add(IcariaStructures.RUINED_FOREST_VILLAGE)
			.add(IcariaStructures.RUINED_SCRUBLAND_VILLAGE)
			.add(IcariaStructures.RUINED_STEPPE_VILLAGE)
			.add(IcariaStructures.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.VILLAGE)
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
