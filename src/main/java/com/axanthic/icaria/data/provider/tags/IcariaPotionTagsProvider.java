package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaPotionIds;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PotionTagsProvider;
import net.minecraft.tags.PotionTags;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPotionTagsProvider extends PotionTagsProvider {
	public IcariaPotionTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider) {
		super(pPackOutput, pProvider);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(PotionTags.TRADEABLE)
			.add(IcariaPotionIds.BLINDNESS)
			.add(IcariaPotionIds.NAUSEA)
			.add(IcariaPotionIds.WITHER);
	}

	@Override
	public String getName() {
		return "Potion Tags";
	}
}
