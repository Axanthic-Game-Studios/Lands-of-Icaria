package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaIdents;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEntityTypeTagsProvider extends EntityTypeTagsProvider {
	public IcariaEntityTypeTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(EntityTypeTags.ARTHROPOD)
			.add(IcariaEntityTypes.ARACHNE.get())
			.add(IcariaEntityTypes.ARACHNE_DRONE.get())
			.add(IcariaEntityTypes.MYRMEKE_DRONE.get())
			.add(IcariaEntityTypes.MYRMEKE_SOLDIER.get())
			.add(IcariaEntityTypes.MYRMEKE_QUEEN.get())
			.add(IcariaEntityTypes.SCORPION.get())
			.add(IcariaEntityTypes.SOLIFUGAE.get())
			.add(IcariaEntityTypes.VINEGAR.get());

		this.tag(EntityTypeTags.FOLLOWABLE_FRIENDLY_MOBS)
			.add(IcariaEntityTypes.AETERNAE.get())
			.add(IcariaEntityTypes.CAPELLA.get())
			.add(IcariaEntityTypes.CATOBLEPAS.get())
			.add(IcariaEntityTypes.CRYSTAL_SLUG.get())
			.add(IcariaEntityTypes.FOREST_SNULL.get())
			.add(IcariaEntityTypes.SNULL.get())
			.add(IcariaEntityTypes.THOG.get());

		this.tag(EntityTypeTags.FROG_FOOD)
			.add(IcariaEntityTypes.HYLIASTER.get());

		this.tag(EntityTypeTags.IMPACT_PROJECTILES)
			.add(IcariaEntityTypes.BIDENT.get());

		this.tag(EntityTypeTags.UNDEAD)
			.add(IcariaEntityTypes.CAPTAIN_REVENANT.get())
			.add(IcariaEntityTypes.CIVILIAN_REVENANT.get())
			.add(IcariaEntityTypes.CRAWLER_REVENANT.get())
			.add(IcariaEntityTypes.OVERGROWN_REVENANT.get())
			.add(IcariaEntityTypes.PYROMANCER_REVENANT.get())
			.add(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get())
			.add(IcariaEntityTypes.SOLDIER_REVENANT.get());
	}

	@Override
	public String getName() {
		return "Entity Type Tags";
	}

	public static TagKey<EntityType<?>> cKey(String pName) {
		return IcariaEntityTypeTagsProvider.createKey(IcariaIdents.C + ":" + pName);
	}

	public static TagKey<EntityType<?>> icariaKey(String pName) {
		return IcariaEntityTypeTagsProvider.createKey(IcariaIdents.ID + ":" + pName);
	}

	public static TagKey<EntityType<?>> createKey(String pName) {
		return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse(pName));
	}
}
