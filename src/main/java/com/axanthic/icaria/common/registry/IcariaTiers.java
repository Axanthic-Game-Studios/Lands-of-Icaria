package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.util.IcariaTier;
import com.axanthic.icaria.data.tags.IcariaBlockTags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;

import net.neoforged.neoforge.common.TierSortingRegistry;

import java.util.List;

public class IcariaTiers {
	public static final IcariaTier CHERT = new IcariaTier(0, 59, 2.0F, 0.0F, 15, IcariaBlockTags.NEEDS_CHERT_TOOL, () -> Ingredient.of(IcariaItems.CHERT.get()), Tiers.STONE);
	public static final IcariaTier CHALKOS = new IcariaTier(1, 174, 5.0F, 1.0F, 15, IcariaBlockTags.NEEDS_CHALKOS_TOOL, () -> Ingredient.of(IcariaItems.CHALKOS_INGOT.get()), Tiers.STONE);
	public static final IcariaTier KASSITEROS = new IcariaTier(1, 234, 5.0F, 1.5F, 15, IcariaBlockTags.NEEDS_KASSITEROS_TOOL, () -> Ingredient.of(IcariaItems.KASSITEROS_INGOT.get()), Tiers.IRON);
	public static final IcariaTier ORICHALCUM = new IcariaTier(2, 385, 6.0F, 2.0F, 19, IcariaBlockTags.NEEDS_ORICHALCUM_TOOL, () -> Ingredient.of(IcariaItems.ORICHALCUM_INGOT.get()), Tiers.IRON);
	public static final IcariaTier VANADIUMSTEEL = new IcariaTier(3, 424, 4.0F, 3.0F, 11, IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL, () -> Ingredient.of(IcariaItems.VANADIUMSTEEL_INGOT.get()), Tiers.DIAMOND);
	public static final IcariaTier SIDEROS = new IcariaTier(4, 528, 7.0F, 2.5F, 14, IcariaBlockTags.NEEDS_SIDEROS_TOOL, () -> Ingredient.of(IcariaItems.SIDEROS_INGOT.get()), Tiers.DIAMOND);
	public static final IcariaTier MOLYBDENUMSTEEL = new IcariaTier(5, 673, 7.5F, 2.0F, 12, IcariaBlockTags.NEEDS_MOLYBDENUMSTEEL_TOOL, () -> Ingredient.of(IcariaItems.MOLYBDENUMSTEEL_INGOT.get()), Tiers.NETHERITE);

	static {
		TierSortingRegistry.registerTier(IcariaTiers.CHERT, new ResourceLocation(IcariaInfo.ID + ":chert"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND, IcariaInfo.ID + ":chalkos"));
		TierSortingRegistry.registerTier(IcariaTiers.CHALKOS, new ResourceLocation(IcariaInfo.ID + ":chalkos"), List.of(Tiers.DIAMOND, IcariaTiers.CHERT), List.of(Tiers.NETHERITE, IcariaInfo.ID + ":kassiteros"));
		TierSortingRegistry.registerTier(IcariaTiers.KASSITEROS, new ResourceLocation(IcariaInfo.ID + ":kassiteros"), List.of(Tiers.DIAMOND, IcariaTiers.CHALKOS), List.of(Tiers.NETHERITE, IcariaInfo.ID + ":orichalcum"));
		TierSortingRegistry.registerTier(IcariaTiers.ORICHALCUM, new ResourceLocation(IcariaInfo.ID + ":orichalcum"), List.of(Tiers.NETHERITE, IcariaTiers.CHALKOS), List.of(IcariaInfo.ID + ":vanadiumsteel"));
		TierSortingRegistry.registerTier(IcariaTiers.VANADIUMSTEEL, new ResourceLocation(IcariaInfo.ID + ":vanadiumsteel"), List.of(IcariaTiers.ORICHALCUM), List.of(IcariaInfo.ID + ":sideros"));
		TierSortingRegistry.registerTier(IcariaTiers.SIDEROS, new ResourceLocation(IcariaInfo.ID + ":sideros"), List.of(IcariaTiers.VANADIUMSTEEL), List.of(IcariaInfo.ID + ":molybdenumsteel"));
		TierSortingRegistry.registerTier(IcariaTiers.MOLYBDENUMSTEEL, new ResourceLocation(IcariaInfo.ID + ":molybdenumsteel"), List.of(IcariaTiers.SIDEROS), List.of());
	}
}
