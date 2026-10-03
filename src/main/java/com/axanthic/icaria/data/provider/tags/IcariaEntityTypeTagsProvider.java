package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaEntityTypeIds;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;

import net.neoforged.neoforge.common.Tags;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEntityTypeTagsProvider extends EntityTypeTagsProvider {
	public IcariaEntityTypeTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(EntityTypeTags.ARTHROPOD)
			.add(IcariaEntityTypeIds.ARACHNE)
			.add(IcariaEntityTypeIds.ARACHNE_DRONE)
			.add(IcariaEntityTypeIds.MYRMEKE_DRONE)
			.add(IcariaEntityTypeIds.MYRMEKE_SOLDIER)
			.add(IcariaEntityTypeIds.MYRMEKE_QUEEN)
			.add(IcariaEntityTypeIds.SCORPION)
			.add(IcariaEntityTypeIds.SOLIFUGAE)
			.add(IcariaEntityTypeIds.VINEGAR);

		this.tag(EntityTypeTags.FALL_DAMAGE_IMMUNE)
			.add(IcariaEntityTypeIds.FEESH)
			.add(IcariaEntityTypeIds.FICHE)
			.add(IcariaEntityTypeIds.FISSHH)
			.add(IcariaEntityTypeIds.FYSH)
			.add(IcariaEntityTypeIds.ENDER_JELLYFISH)
			.add(IcariaEntityTypeIds.FIRE_JELLYFISH)
			.add(IcariaEntityTypeIds.NATURE_JELLYFISH)
			.add(IcariaEntityTypeIds.VOID_JELLYFISH)
			.add(IcariaEntityTypeIds.WATER_JELLYFISH);

		this.tag(EntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS)
			.add(IcariaEntityTypeIds.AETERNAE)
			.add(IcariaEntityTypeIds.CAPELLA)
			.add(IcariaEntityTypeIds.CATOBLEPAS)
			.add(IcariaEntityTypeIds.CLUSTER_SLUG)
			.add(IcariaEntityTypeIds.FOREST_SNULL)
			.add(IcariaEntityTypeIds.SNULL)
			.add(IcariaEntityTypeIds.THOG);

		this.tag(EntityTypeTags.FROG_FOOD)
			.add(IcariaEntityTypeIds.HYLIASTER);

		this.tag(EntityTypeTags.IMPACT_PROJECTILES)
			.add(IcariaEntityTypeIds.BIDENT);

		this.tag(EntityTypeTags.UNDEAD)
			.add(IcariaEntityTypeIds.CAPTAIN_REVENANT)
			.add(IcariaEntityTypeIds.CIVILIAN_REVENANT)
			.add(IcariaEntityTypeIds.CRAWLER_REVENANT)
			.add(IcariaEntityTypeIds.OVERGROWN_REVENANT)
			.add(IcariaEntityTypeIds.PYROMANCER_REVENANT)
			.add(IcariaEntityTypeIds.NETHER_PYROMANCER_REVENANT)
			.add(IcariaEntityTypeIds.SOLDIER_REVENANT);

		this.tag(Tags.EntityTypes.BOSSES)
			.add(IcariaEntityTypeIds.ARACHNE)
			.add(IcariaEntityTypeIds.CAPTAIN_REVENANT);
	}

	@Override
	public String getName() {
		return "Entity Type Tags";
	}
}
