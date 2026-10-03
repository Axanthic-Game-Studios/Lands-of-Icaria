package com.axanthic.icaria.data.provider.tags;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaPaintingVariantIds;
import com.axanthic.icaria.common.tags.IcariaPaintingTags;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPaintingVariantTagsProvider extends PaintingVariantTagsProvider {
	public IcariaPaintingVariantTagsProvider(PackOutput pPackOutput, CompletableFuture<HolderLookup.Provider> pProvider, String pId) {
		super(pPackOutput, pProvider, pId);
	}

	@Override
	public void addTags(HolderLookup.Provider pProvider) {
		this.tag(IcariaPaintingTags.PAINTINGS)
			.add(IcariaPaintingVariantIds.BRIDGE)
			.add(IcariaPaintingVariantIds.CACTUS)
			.add(IcariaPaintingVariantIds.ENDER_JELLYFISH)
			.add(IcariaPaintingVariantIds.MOONS)
			.add(IcariaPaintingVariantIds.PERFECTION)
			.add(IcariaPaintingVariantIds.PORTAL)
			.add(IcariaPaintingVariantIds.PYRO)
			.add(IcariaPaintingVariantIds.WINDOW);

		this.tag(IcariaPaintingTags.BROWN_RUGS)
			.add(IcariaPaintingVariantIds.BROWN_RUG_1_X_2)
			.add(IcariaPaintingVariantIds.BROWN_RUG_1_X_3)
			.add(IcariaPaintingVariantIds.BROWN_RUG_1_X_4)
			.add(IcariaPaintingVariantIds.BROWN_RUG_2_X_2)
			.add(IcariaPaintingVariantIds.BROWN_RUG_2_X_3)
			.add(IcariaPaintingVariantIds.BROWN_RUG_2_X_4)
			.add(IcariaPaintingVariantIds.BROWN_RUG_3_X_3)
			.add(IcariaPaintingVariantIds.BROWN_RUG_3_X_4);

		this.tag(IcariaPaintingTags.GREEN_RUGS)
			.add(IcariaPaintingVariantIds.GREEN_RUG_1_X_2)
			.add(IcariaPaintingVariantIds.GREEN_RUG_1_X_3)
			.add(IcariaPaintingVariantIds.GREEN_RUG_1_X_4)
			.add(IcariaPaintingVariantIds.GREEN_RUG_2_X_2)
			.add(IcariaPaintingVariantIds.GREEN_RUG_2_X_3)
			.add(IcariaPaintingVariantIds.GREEN_RUG_2_X_4)
			.add(IcariaPaintingVariantIds.GREEN_RUG_3_X_3)
			.add(IcariaPaintingVariantIds.GREEN_RUG_3_X_4);

		this.tag(IcariaPaintingTags.RED_RUGS)
			.add(IcariaPaintingVariantIds.RED_RUG_1_X_2)
			.add(IcariaPaintingVariantIds.RED_RUG_1_X_3)
			.add(IcariaPaintingVariantIds.RED_RUG_1_X_4)
			.add(IcariaPaintingVariantIds.RED_RUG_2_X_2)
			.add(IcariaPaintingVariantIds.RED_RUG_2_X_3)
			.add(IcariaPaintingVariantIds.RED_RUG_2_X_4)
			.add(IcariaPaintingVariantIds.RED_RUG_3_X_3)
			.add(IcariaPaintingVariantIds.RED_RUG_3_X_4);
	}

	@Override
	public String getName() {
		return "Painting Variant Tags";
	}
}
