package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaPotions;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.concurrent.CompletableFuture;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PotionTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.PotionTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.alchemy.Potion;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPotionTagsProvider extends PotionTagsProvider {
	public IcariaPotionTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
		super(pPackOutput, pProvider);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(PotionTags.TRADEABLE)
			.add(pProvider.getOrThrow(IcariaPotions.BLINDNESS.getKey()))
			.add(pProvider.getOrThrow(IcariaPotions.NAUSEA.getKey()))
			.add(pProvider.getOrThrow(IcariaPotions.WITHER.getKey()));
	}

	@Override
	public String getName() {
		return "Potion Tags";
	}

	public static TagKey<Potion> cKey(String pName) {
		return IcariaPotionTagsProvider.createKey(IcariaKeys.C + ":" + pName);
	}

	public static TagKey<Potion> icariaKey(String pName) {
		return IcariaPotionTagsProvider.createKey(IcariaKeys.ID + ":" + pName);
	}

	public static TagKey<Potion> createKey(String pName) {
		return TagKey.create(Registries.POTION, Identifier.parse(pName));
	}
}
