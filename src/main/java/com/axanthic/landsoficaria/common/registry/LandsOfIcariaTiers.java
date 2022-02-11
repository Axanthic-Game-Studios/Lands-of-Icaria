package com.axanthic.landsoficaria.common.registry;

import java.util.List;

import com.axanthic.landsoficaria.LandsOfIcariaInfo;
import com.axanthic.landsoficaria.datagen.IcariaBlockTags;
import com.axanthic.landsoficaria.util.IcariaTier;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.TierSortingRegistry;

public class LandsOfIcariaTiers {

	public static final IcariaTier CHERT = new IcariaTier(0, 59, 2.0F, 0.0F, 15, IcariaBlockTags.NEEDS_CHERT_TOOL, () -> Ingredient.of(Items.BEDROCK), Tiers.STONE);
	public static final IcariaTier CHALKOS = new IcariaTier(1, 174, 5.0F, 1.0F, 15, IcariaBlockTags.NEEDS_CHALKOS_TOOL, () -> Ingredient.of(Items.BEDROCK), Tiers.STONE);
	public static final IcariaTier KASSITEROS = new IcariaTier(1, 234, 5.0F, 1.5F, 15, IcariaBlockTags.NEEDS_KASSITEROS_TOOL, () -> Ingredient.of(Items.BEDROCK), Tiers.IRON);
	public static final IcariaTier ORICHALCUM = new IcariaTier(2, 385, 6.0F, 2.0F, 19, IcariaBlockTags.NEEDS_ORICHALCUM_TOOL, () -> Ingredient.of(Items.BEDROCK), Tiers.IRON);
	public static final IcariaTier VANADIUMSTEEL = new IcariaTier(3, 424, 4.0F, 3.0F, 11, IcariaBlockTags.NEEDS_VANADIUMSTEEL_TOOL, () -> Ingredient.of(Items.BEDROCK), Tiers.DIAMOND);
	public static final IcariaTier SIDEROS = new IcariaTier(4, 528, 7.0F, 2.5F, 14, IcariaBlockTags.NEEDS_SIDEROS_TOOL, () -> Ingredient.of(Items.BEDROCK), Tiers.DIAMOND);
	public static final IcariaTier MOLYBDENUMSTEEL = new IcariaTier(5, 673, 7.5F, 2.0F, 12, IcariaBlockTags.NEEDS_MOLYBDENUMSTEEL_TOOL, () -> Ingredient.of(Items.BEDROCK), Tiers.NETHERITE);

	static {
		TierSortingRegistry.registerTier(CHERT,
				new ResourceLocation(LandsOfIcariaInfo.MODID + ":chert"),
				List.of(Tiers.IRON), List.of(Tiers.DIAMOND, LandsOfIcariaInfo.MODID + ":chalkos"));
		TierSortingRegistry.registerTier(CHALKOS,
				new ResourceLocation(LandsOfIcariaInfo.MODID + ":chalkos"),
				List.of(Tiers.DIAMOND, CHERT), List.of(Tiers.NETHERITE, LandsOfIcariaInfo.MODID + ":kassiteros"));
		TierSortingRegistry.registerTier(KASSITEROS,
				new ResourceLocation(LandsOfIcariaInfo.MODID + ":kassiteros"),
				List.of(Tiers.DIAMOND, CHALKOS), List.of(Tiers.NETHERITE, LandsOfIcariaInfo.MODID + ":orichalcum"));
		TierSortingRegistry.registerTier(ORICHALCUM,
				new ResourceLocation(LandsOfIcariaInfo.MODID + ":orichalcum"),
				List.of(Tiers.NETHERITE, CHALKOS), List.of(LandsOfIcariaInfo.MODID + ":vanadiumsteel"));
		TierSortingRegistry.registerTier(VANADIUMSTEEL,
				new ResourceLocation(LandsOfIcariaInfo.MODID + ":vanadiumsteel"),
				List.of(ORICHALCUM), List.of(LandsOfIcariaInfo.MODID + ":sideros"));
		TierSortingRegistry.registerTier(SIDEROS,
				new ResourceLocation(LandsOfIcariaInfo.MODID + ":sideros"),
				List.of(VANADIUMSTEEL), List.of(LandsOfIcariaInfo.MODID + ":molybdenumsteel"));
		TierSortingRegistry.registerTier(MOLYBDENUMSTEEL,
				new ResourceLocation(LandsOfIcariaInfo.MODID + ":molybdenumsteel"),
				List.of(SIDEROS), List.of());
	}
}
