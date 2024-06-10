package com.axanthic.icaria.data.tags;

import com.axanthic.icaria.common.registry.IcariaStructures;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.util.IcariaRegistrySetBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
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

	public IcariaStructureTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, IcariaRegistrySetBuilder pBuilder, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pProvider.thenApply(provider -> IcariaStructureTags.append(provider, pBuilder)), pId, pHelper);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaStructureTags.FOREST_VILLAGE)
			.add(IcariaStructures.FOREST_ERODED)
			.add(IcariaStructures.FOREST_PRISTINE)
			.add(IcariaStructures.FOREST_RUINED);

		this.tag(IcariaStructureTags.SCRUBLAND_VILLAGE)
			.add(IcariaStructures.SCRUBLAND_ERODED)
			.add(IcariaStructures.SCRUBLAND_PRISTINE)
			.add(IcariaStructures.SCRUBLAND_RUINED);

		this.tag(IcariaStructureTags.STEPPE_VILLAGE)
			.add(IcariaStructures.STEPPE_ERODED)
			.add(IcariaStructures.STEPPE_PRISTINE)
			.add(IcariaStructures.STEPPE_RUINED);

		this.tag(IcariaStructureTags.DESERT_VILLAGE)
			.add(IcariaStructures.DESERT_ERODED)
			.add(IcariaStructures.DESERT_PRISTINE)
			.add(IcariaStructures.DESERT_RUINED);

		this.tag(IcariaStructureTags.ERODED_VILLAGE)
			.add(IcariaStructures.FOREST_ERODED)
			.add(IcariaStructures.SCRUBLAND_ERODED)
			.add(IcariaStructures.STEPPE_ERODED)
			.add(IcariaStructures.DESERT_ERODED);

		this.tag(IcariaStructureTags.PRISTINE_VILLAGE)
			.add(IcariaStructures.FOREST_PRISTINE)
			.add(IcariaStructures.SCRUBLAND_PRISTINE)
			.add(IcariaStructures.STEPPE_PRISTINE)
			.add(IcariaStructures.DESERT_PRISTINE);

		this.tag(IcariaStructureTags.RUINED_VILLAGE)
			.add(IcariaStructures.FOREST_RUINED)
			.add(IcariaStructures.SCRUBLAND_RUINED)
			.add(IcariaStructures.STEPPE_RUINED)
			.add(IcariaStructures.DESERT_RUINED);

		this.tag(IcariaStructureTags.VILLAGE)
			.add(IcariaStructures.FOREST_ERODED)
			.add(IcariaStructures.FOREST_PRISTINE)
			.add(IcariaStructures.FOREST_RUINED)
			.add(IcariaStructures.SCRUBLAND_ERODED)
			.add(IcariaStructures.SCRUBLAND_PRISTINE)
			.add(IcariaStructures.SCRUBLAND_RUINED)
			.add(IcariaStructures.STEPPE_ERODED)
			.add(IcariaStructures.STEPPE_PRISTINE)
			.add(IcariaStructures.STEPPE_RUINED)
			.add(IcariaStructures.DESERT_ERODED)
			.add(IcariaStructures.DESERT_PRISTINE)
			.add(IcariaStructures.DESERT_RUINED);
	}

	public static HolderLookup.Provider append(HolderLookup.Provider pProvider, RegistrySetBuilder pBuilder) {
		return pBuilder.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), pProvider);
	}

	public static TagKey<Structure> bind(String pName) {
		return TagKey.create(Registries.STRUCTURE, new ResourceLocation(pName));
	}

	public static TagKey<Structure> forgeTag(String pName) {
		return IcariaStructureTags.bind(IcariaInfo.FORGE + ":" + pName);
	}

	public static TagKey<Structure> icariaTag(String pName) {
		return IcariaStructureTags.bind(IcariaInfo.ID + ":" + pName);
	}
}
