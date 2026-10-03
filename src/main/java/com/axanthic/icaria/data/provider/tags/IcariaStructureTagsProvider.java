package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaStructureIds;
import com.axanthic.icaria.common.tags.IcariaStructureTags;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStructureTagsProvider extends StructureTagsProvider {
	public IcariaStructureTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaStructureTags.FOREST_VILLAGES)
			.add(IcariaStructureIds.ERODED_FOREST_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructureIds.RUINED_FOREST_VILLAGE);

		this.tag(IcariaStructureTags.SCRUBLAND_VILLAGES)
			.add(IcariaStructureIds.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.RUINED_SCRUBLAND_VILLAGE);

		this.tag(IcariaStructureTags.STEPPE_VILLAGES)
			.add(IcariaStructureIds.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructureIds.RUINED_STEPPE_VILLAGE);

		this.tag(IcariaStructureTags.DESERT_VILLAGES)
			.add(IcariaStructureIds.ERODED_DESERT_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_DESERT_VILLAGE)
			.add(IcariaStructureIds.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.ERODED_VILLAGES)
			.add(IcariaStructureIds.ERODED_FOREST_VILLAGE)
			.add(IcariaStructureIds.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructureIds.ERODED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.PRISTINE_VILLAGES)
			.add(IcariaStructureIds.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.RUINED_VILLAGES)
			.add(IcariaStructureIds.RUINED_FOREST_VILLAGE)
			.add(IcariaStructureIds.RUINED_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.RUINED_STEPPE_VILLAGE)
			.add(IcariaStructureIds.RUINED_DESERT_VILLAGE);

		this.tag(IcariaStructureTags.VILLAGES)
			.add(IcariaStructureIds.ERODED_FOREST_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_FOREST_VILLAGE)
			.add(IcariaStructureIds.RUINED_FOREST_VILLAGE)
			.add(IcariaStructureIds.ERODED_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.RUINED_SCRUBLAND_VILLAGE)
			.add(IcariaStructureIds.ERODED_STEPPE_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_STEPPE_VILLAGE)
			.add(IcariaStructureIds.RUINED_STEPPE_VILLAGE)
			.add(IcariaStructureIds.ERODED_DESERT_VILLAGE)
			.add(IcariaStructureIds.PRISTINE_DESERT_VILLAGE)
			.add(IcariaStructureIds.RUINED_DESERT_VILLAGE);
	}

	@Override
	public String getName() {
		return "Structure Tags";
	}
}
