package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.recipe.builder.*;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaPotions;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import net.neoforged.neoforge.common.Tags;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeProvider extends RecipeProvider {
	public IcariaRecipeProvider(HolderLookup.Provider pProvider, RecipeOutput pPackOutput) {
		super(pProvider, pPackOutput);
	}

	@Override
	public void buildRecipes() {
		this.campfireCooking();
		this.smelting();
		this.smoking();
		this.stonecutting();
		this.entityConcocting();
		this.explosionConcocting();
		this.firing();
		this.forging();
		this.grinding();
		this.itemConcocting();
		this.potionConcocting();
		this.shaped3x3();
		this.shaped3x2();
		this.shaped3x1();
		this.shaped2x3();
		this.shaped2x2();
		this.shaped2x1();
		this.shaped1x2();
		this.adobe();
		this.axe();
		this.bathtub();
		this.bident();
		this.boots();
		this.bowl();
		this.cake();
		this.carpet();
		this.centerFilled();
		this.centerHollow();
		this.chestplate();
		this.dagger();
		this.fence();
		this.fenceGate();
		this.gear();
		this.hangingSign();
		this.harness();
		this.helmet();
		this.ladder();
		this.leggings();
		this.pickaxe();
		this.pillarHead();
		this.rug();
		this.scythe();
		this.shovel();
		this.sign();
		this.stairs();
		this.stool();
		this.sword();
		this.torch();
		this.trough();
		this.arrow();
		this.bundle();
		this.coarseMarl();
		this.comparator();
		this.crafter();
		this.fletchingTable();
		this.forge();
		this.greekFireGrenade();
		this.grindstone();
		this.kettle();
		this.repeater();
		this.saddle();
		this.stickyPiston();
		this.stonecutter();
		this.target();
		this.tnt();
		this.vanadiumsteelChain();
		this.shapeless();
		this.mossy();
		this.planks();
		this.stew();
		this.book();
		this.fireCharge();
		this.fruitSalad();
		this.magmaCream();
		this.mossyCobblestone();
		this.mossyStoneBricks();
		this.onionSoup();
		this.thogStew();
	}

	public void campfireCooking() {
		this.campfireCooking(0.35F, 600, IcariaItems.COOKED_AETERNAE_MEAT.get(), IcariaItems.RAW_AETERNAE_MEAT.get());
		this.campfireCooking(0.35F, 600, IcariaItems.COOKED_CAPELLA_MEAT.get(), IcariaItems.RAW_CAPELLA_MEAT.get());
		this.campfireCooking(0.35F, 600, IcariaItems.COOKED_CATOBLEPAS_MEAT.get(), IcariaItems.RAW_CATOBLEPAS_MEAT.get());
		this.campfireCooking(0.35F, 600, IcariaItems.COOKED_CERVER_MEAT.get(), IcariaItems.RAW_CERVER_MEAT.get());
		this.campfireCooking(0.35F, 600, IcariaItems.COOKED_CROCOTTA_MEAT.get(), IcariaItems.RAW_CROCOTTA_MEAT.get());
		this.campfireCooking(0.35F, 600, IcariaItems.COOKED_THOG_MEAT.get(), IcariaItems.RAW_THOG_MEAT.get());
	}

	public void smelting() {
		this.smelting(1.0F, 200, Items.GREEN_DYE, IcariaItems.CARDON_CACTUS.get());
		this.smelting(0.1F, 200, IcariaItems.YELLOWSTONE.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.smelting(0.1F, 200, IcariaItems.SILKSTONE.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.smelting(0.1F, 200, IcariaItems.SUNSTONE.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.smelting(0.1F, 200, IcariaItems.VOIDSHALE.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.smelting(0.1F, 200, IcariaItems.BAETYL.get(), IcariaItems.COBBLED_BAETYL.get());
		this.smelting(0.1F, 200, IcariaItems.SMOOTH_RELICSTONE.get(), IcariaItems.RELICSTONE.get());
		this.smelting(0.1F, 200, IcariaItems.CRACKED_RELICSTONE_BRICKS.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.smelting(0.1F, 200, IcariaItems.CRACKED_RELICSTONE_TILES.get(), IcariaItems.RELICSTONE_TILES.get());
		this.smelting(0.3F, 200, IcariaItems.SPELT_BREAD.get(), IcariaItems.SPELT_FLOUR.get());
		this.smelting(0.35F, 200, IcariaItems.COOKED_AETERNAE_MEAT.get(), IcariaItems.RAW_AETERNAE_MEAT.get());
		this.smelting(0.35F, 200, IcariaItems.COOKED_CAPELLA_MEAT.get(), IcariaItems.RAW_CAPELLA_MEAT.get());
		this.smelting(0.35F, 200, IcariaItems.COOKED_CATOBLEPAS_MEAT.get(), IcariaItems.RAW_CATOBLEPAS_MEAT.get());
		this.smelting(0.35F, 200, IcariaItems.COOKED_CERVER_MEAT.get(), IcariaItems.RAW_CERVER_MEAT.get());
		this.smelting(0.35F, 200, IcariaItems.COOKED_CROCOTTA_MEAT.get(), IcariaItems.RAW_CROCOTTA_MEAT.get());
		this.smelting(0.35F, 200, IcariaItems.COOKED_THOG_MEAT.get(), IcariaItems.RAW_THOG_MEAT.get());
	}

	public void smoking() {
		this.smoking(0.35F, 100, IcariaItems.COOKED_AETERNAE_MEAT.get(), IcariaItems.RAW_AETERNAE_MEAT.get());
		this.smoking(0.35F, 100, IcariaItems.COOKED_CAPELLA_MEAT.get(), IcariaItems.RAW_CAPELLA_MEAT.get());
		this.smoking(0.35F, 100, IcariaItems.COOKED_CATOBLEPAS_MEAT.get(), IcariaItems.RAW_CATOBLEPAS_MEAT.get());
		this.smoking(0.35F, 100, IcariaItems.COOKED_CERVER_MEAT.get(), IcariaItems.RAW_CERVER_MEAT.get());
		this.smoking(0.35F, 100, IcariaItems.COOKED_CROCOTTA_MEAT.get(), IcariaItems.RAW_CROCOTTA_MEAT.get());
		this.smoking(0.35F, 100, IcariaItems.COOKED_THOG_MEAT.get(), IcariaItems.RAW_THOG_MEAT.get());
	}

	public void stonecutting() {
		this.stonecutting(1, IcariaItems.MARL_ADOBE_STAIRS.get(), IcariaItems.MARL_ADOBE.get());
		this.stonecutting(2, IcariaItems.MARL_ADOBE_SLAB.get(), IcariaItems.MARL_ADOBE.get());
		this.stonecutting(1, IcariaItems.MARL_ADOBE_WALL.get(), IcariaItems.MARL_ADOBE.get());
		this.stonecutting(1, IcariaItems.LOAM_BRICK_STAIRS.get(), IcariaItems.LOAM_BRICKS.get());
		this.stonecutting(2, IcariaItems.LOAM_BRICK_SLAB.get(), IcariaItems.LOAM_BRICKS.get());
		this.stonecutting(1, IcariaItems.LOAM_BRICK_WALL.get(), IcariaItems.LOAM_BRICKS.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_ADOBE_STAIRS.get(), IcariaItems.DOLOMITE_ADOBE.get());
		this.stonecutting(2, IcariaItems.DOLOMITE_ADOBE_SLAB.get(), IcariaItems.DOLOMITE_ADOBE.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_ADOBE_WALL.get(), IcariaItems.DOLOMITE_ADOBE.get());
		this.stonecutting(1, IcariaItems.SMOOTH_DOLOMITE_STAIRS.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stonecutting(2, IcariaItems.SMOOTH_DOLOMITE_SLAB.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stonecutting(1, IcariaItems.SMOOTH_DOLOMITE_WALL.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_BRICKS.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stonecutting(1, IcariaItems.CHISELED_DOLOMITE.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_PILLAR.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_PILLAR.get(), IcariaItems.DOLOMITE_BRICKS.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_PILLAR_HEAD.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_PILLAR_HEAD.get(), IcariaItems.DOLOMITE_BRICKS.get());
		this.stonecutting(1, IcariaItems.DOLOMITE_PILLAR_HEAD.get(), IcariaItems.DOLOMITE_PILLAR.get());
		this.stonecutting(1, IcariaItems.GRAINITE_ADOBE_STAIRS.get(), IcariaItems.GRAINITE_ADOBE.get());
		this.stonecutting(2, IcariaItems.GRAINITE_ADOBE_SLAB.get(), IcariaItems.GRAINITE_ADOBE.get());
		this.stonecutting(1, IcariaItems.GRAINITE_ADOBE_WALL.get(), IcariaItems.GRAINITE_ADOBE.get());
		this.stonecutting(1, IcariaItems.GRAINITE_STAIRS.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(2, IcariaItems.GRAINITE_SLAB.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(1, IcariaItems.GRAINITE_WALL.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(1, IcariaItems.GRAINITE_BRICKS.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(1, IcariaItems.GRAINITE_BRICK_STAIRS.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(1, IcariaItems.GRAINITE_BRICK_STAIRS.get(), IcariaItems.GRAINITE_BRICKS.get());
		this.stonecutting(2, IcariaItems.GRAINITE_BRICK_SLAB.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(2, IcariaItems.GRAINITE_BRICK_SLAB.get(), IcariaItems.GRAINITE_BRICKS.get());
		this.stonecutting(1, IcariaItems.GRAINITE_BRICK_WALL.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(1, IcariaItems.GRAINITE_BRICK_WALL.get(), IcariaItems.GRAINITE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CHISELED_GRAINITE.get(), IcariaItems.GRAINITE.get());
		this.stonecutting(1, IcariaItems.CHISELED_GRAINITE.get(), IcariaItems.GRAINITE_BRICKS.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_ADOBE_STAIRS.get(), IcariaItems.YELLOWSTONE_ADOBE.get());
		this.stonecutting(2, IcariaItems.YELLOWSTONE_ADOBE_SLAB.get(), IcariaItems.YELLOWSTONE_ADOBE.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_ADOBE_WALL.get(), IcariaItems.YELLOWSTONE_ADOBE.get());
		this.stonecutting(1, IcariaItems.COBBLED_YELLOWSTONE_STAIRS.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.stonecutting(2, IcariaItems.COBBLED_YELLOWSTONE_SLAB.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.COBBLED_YELLOWSTONE_WALL.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_STAIRS.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(2, IcariaItems.YELLOWSTONE_SLAB.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_WALL.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_BRICKS.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_BRICK_STAIRS.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_BRICK_STAIRS.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
		this.stonecutting(2, IcariaItems.YELLOWSTONE_BRICK_SLAB.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(2, IcariaItems.YELLOWSTONE_BRICK_SLAB.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_BRICK_WALL.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.YELLOWSTONE_BRICK_WALL.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CHISELED_YELLOWSTONE.get(), IcariaItems.YELLOWSTONE.get());
		this.stonecutting(1, IcariaItems.CHISELED_YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_ADOBE_STAIRS.get(), IcariaItems.SILKSTONE_ADOBE.get());
		this.stonecutting(2, IcariaItems.SILKSTONE_ADOBE_SLAB.get(), IcariaItems.SILKSTONE_ADOBE.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_ADOBE_WALL.get(), IcariaItems.SILKSTONE_ADOBE.get());
		this.stonecutting(1, IcariaItems.COBBLED_SILKSTONE_STAIRS.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.stonecutting(2, IcariaItems.COBBLED_SILKSTONE_SLAB.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.stonecutting(1, IcariaItems.COBBLED_SILKSTONE_WALL.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_STAIRS.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(2, IcariaItems.SILKSTONE_SLAB.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_WALL.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_BRICKS.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_BRICK_STAIRS.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_BRICK_STAIRS.get(), IcariaItems.SILKSTONE_BRICKS.get());
		this.stonecutting(2, IcariaItems.SILKSTONE_BRICK_SLAB.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(2, IcariaItems.SILKSTONE_BRICK_SLAB.get(), IcariaItems.SILKSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_BRICK_WALL.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(1, IcariaItems.SILKSTONE_BRICK_WALL.get(), IcariaItems.SILKSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CHISELED_SILKSTONE.get(), IcariaItems.SILKSTONE.get());
		this.stonecutting(1, IcariaItems.CHISELED_SILKSTONE.get(), IcariaItems.SILKSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_ADOBE_STAIRS.get(), IcariaItems.SUNSTONE_ADOBE.get());
		this.stonecutting(2, IcariaItems.SUNSTONE_ADOBE_SLAB.get(), IcariaItems.SUNSTONE_ADOBE.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_ADOBE_WALL.get(), IcariaItems.SUNSTONE_ADOBE.get());
		this.stonecutting(1, IcariaItems.COBBLED_SUNSTONE_STAIRS.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.stonecutting(2, IcariaItems.COBBLED_SUNSTONE_SLAB.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.stonecutting(1, IcariaItems.COBBLED_SUNSTONE_WALL.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_STAIRS.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(2, IcariaItems.SUNSTONE_SLAB.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_WALL.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_BRICKS.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_BRICK_STAIRS.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_BRICK_STAIRS.get(), IcariaItems.SUNSTONE_BRICKS.get());
		this.stonecutting(2, IcariaItems.SUNSTONE_BRICK_SLAB.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(2, IcariaItems.SUNSTONE_BRICK_SLAB.get(), IcariaItems.SUNSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_BRICK_WALL.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(1, IcariaItems.SUNSTONE_BRICK_WALL.get(), IcariaItems.SUNSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CHISELED_SUNSTONE.get(), IcariaItems.SUNSTONE.get());
		this.stonecutting(1, IcariaItems.CHISELED_SUNSTONE.get(), IcariaItems.SUNSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_ADOBE_STAIRS.get(), IcariaItems.VOIDSHALE_ADOBE.get());
		this.stonecutting(2, IcariaItems.VOIDSHALE_ADOBE_SLAB.get(), IcariaItems.VOIDSHALE_ADOBE.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_ADOBE_WALL.get(), IcariaItems.VOIDSHALE_ADOBE.get());
		this.stonecutting(1, IcariaItems.COBBLED_VOIDSHALE_STAIRS.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.stonecutting(2, IcariaItems.COBBLED_VOIDSHALE_SLAB.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.COBBLED_VOIDSHALE_WALL.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_STAIRS.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(2, IcariaItems.VOIDSHALE_SLAB.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_WALL.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_BRICKS.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_BRICK_STAIRS.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_BRICK_STAIRS.get(), IcariaItems.VOIDSHALE_BRICKS.get());
		this.stonecutting(2, IcariaItems.VOIDSHALE_BRICK_SLAB.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(2, IcariaItems.VOIDSHALE_BRICK_SLAB.get(), IcariaItems.VOIDSHALE_BRICKS.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_BRICK_WALL.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.VOIDSHALE_BRICK_WALL.get(), IcariaItems.VOIDSHALE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CHISELED_VOIDSHALE.get(), IcariaItems.VOIDSHALE.get());
		this.stonecutting(1, IcariaItems.CHISELED_VOIDSHALE.get(), IcariaItems.VOIDSHALE_BRICKS.get());
		this.stonecutting(1, IcariaItems.BAETYL_ADOBE_STAIRS.get(), IcariaItems.BAETYL_ADOBE.get());
		this.stonecutting(2, IcariaItems.BAETYL_ADOBE_SLAB.get(), IcariaItems.BAETYL_ADOBE.get());
		this.stonecutting(1, IcariaItems.BAETYL_ADOBE_WALL.get(), IcariaItems.BAETYL_ADOBE.get());
		this.stonecutting(1, IcariaItems.COBBLED_BAETYL_STAIRS.get(), IcariaItems.COBBLED_BAETYL.get());
		this.stonecutting(2, IcariaItems.COBBLED_BAETYL_SLAB.get(), IcariaItems.COBBLED_BAETYL.get());
		this.stonecutting(1, IcariaItems.COBBLED_BAETYL_WALL.get(), IcariaItems.COBBLED_BAETYL.get());
		this.stonecutting(1, IcariaItems.BAETYL_STAIRS.get(), IcariaItems.BAETYL.get());
		this.stonecutting(2, IcariaItems.BAETYL_SLAB.get(), IcariaItems.BAETYL.get());
		this.stonecutting(1, IcariaItems.BAETYL_WALL.get(), IcariaItems.BAETYL.get());
		this.stonecutting(1, IcariaItems.BAETYL_BRICKS.get(), IcariaItems.BAETYL.get());
		this.stonecutting(1, IcariaItems.BAETYL_BRICK_STAIRS.get(), IcariaItems.BAETYL.get());
		this.stonecutting(1, IcariaItems.BAETYL_BRICK_STAIRS.get(), IcariaItems.BAETYL_BRICKS.get());
		this.stonecutting(2, IcariaItems.BAETYL_BRICK_SLAB.get(), IcariaItems.BAETYL.get());
		this.stonecutting(2, IcariaItems.BAETYL_BRICK_SLAB.get(), IcariaItems.BAETYL_BRICKS.get());
		this.stonecutting(1, IcariaItems.BAETYL_BRICK_WALL.get(), IcariaItems.BAETYL.get());
		this.stonecutting(1, IcariaItems.BAETYL_BRICK_WALL.get(), IcariaItems.BAETYL_BRICKS.get());
		this.stonecutting(1, IcariaItems.CHISELED_BAETYL.get(), IcariaItems.BAETYL.get());
		this.stonecutting(1, IcariaItems.CHISELED_BAETYL.get(), IcariaItems.BAETYL_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_STAIRS.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(2, IcariaItems.RELICSTONE_SLAB.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_WALL.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.SMOOTH_RELICSTONE_STAIRS.get(), IcariaItems.SMOOTH_RELICSTONE.get());
		this.stonecutting(2, IcariaItems.SMOOTH_RELICSTONE_SLAB.get(), IcariaItems.SMOOTH_RELICSTONE.get());
		this.stonecutting(1, IcariaItems.SMOOTH_RELICSTONE_WALL.get(), IcariaItems.SMOOTH_RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_BRICKS.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_BRICK_STAIRS.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_BRICK_STAIRS.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(2, IcariaItems.RELICSTONE_BRICK_SLAB.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(2, IcariaItems.RELICSTONE_BRICK_SLAB.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_BRICK_WALL.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_BRICK_WALL.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CRACKED_RELICSTONE_BRICK_STAIRS.get(), IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
		this.stonecutting(2, IcariaItems.CRACKED_RELICSTONE_BRICK_SLAB.get(), IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CRACKED_RELICSTONE_BRICK_WALL.get(), IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.MOSSY_RELICSTONE_BRICK_STAIRS.get(), IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
		this.stonecutting(2, IcariaItems.MOSSY_RELICSTONE_BRICK_SLAB.get(), IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.MOSSY_RELICSTONE_BRICK_WALL.get(), IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILES.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILES.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILE_STAIRS.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILE_STAIRS.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILE_STAIRS.get(), IcariaItems.RELICSTONE_TILES.get());
		this.stonecutting(2, IcariaItems.RELICSTONE_TILE_SLAB.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(2, IcariaItems.RELICSTONE_TILE_SLAB.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(2, IcariaItems.RELICSTONE_TILE_SLAB.get(), IcariaItems.RELICSTONE_TILES.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILE_WALL.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILE_WALL.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_TILE_WALL.get(), IcariaItems.RELICSTONE_TILES.get());
		this.stonecutting(1, IcariaItems.CRACKED_RELICSTONE_TILE_STAIRS.get(), IcariaItems.CRACKED_RELICSTONE_TILES.get());
		this.stonecutting(2, IcariaItems.CRACKED_RELICSTONE_TILE_SLAB.get(), IcariaItems.CRACKED_RELICSTONE_TILES.get());
		this.stonecutting(1, IcariaItems.CRACKED_RELICSTONE_TILE_WALL.get(), IcariaItems.CRACKED_RELICSTONE_TILES.get());
		this.stonecutting(1, IcariaItems.MOSSY_RELICSTONE_TILE_STAIRS.get(), IcariaItems.MOSSY_RELICSTONE_TILES.get());
		this.stonecutting(2, IcariaItems.MOSSY_RELICSTONE_TILE_SLAB.get(), IcariaItems.MOSSY_RELICSTONE_TILES.get());
		this.stonecutting(1, IcariaItems.MOSSY_RELICSTONE_TILE_WALL.get(), IcariaItems.MOSSY_RELICSTONE_TILES.get());
		this.stonecutting(1, IcariaItems.CHISELED_RELICSTONE.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.CHISELED_RELICSTONE.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_PILLAR.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_PILLAR.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_PILLAR_HEAD.get(), IcariaItems.RELICSTONE.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_PILLAR_HEAD.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stonecutting(1, IcariaItems.RELICSTONE_PILLAR_HEAD.get(), IcariaItems.RELICSTONE_PILLAR.get());
		this.stonecutting(1, IcariaItems.PLATOSHALE_STAIRS.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(2, IcariaItems.PLATOSHALE_SLAB.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(1, IcariaItems.PLATOSHALE_WALL.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(1, IcariaItems.PLATOSHALE_BRICKS.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(1, IcariaItems.PLATOSHALE_BRICK_STAIRS.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(1, IcariaItems.PLATOSHALE_BRICK_STAIRS.get(), IcariaItems.PLATOSHALE_BRICKS.get());
		this.stonecutting(2, IcariaItems.PLATOSHALE_BRICK_SLAB.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(2, IcariaItems.PLATOSHALE_BRICK_SLAB.get(), IcariaItems.PLATOSHALE_BRICKS.get());
		this.stonecutting(1, IcariaItems.PLATOSHALE_BRICK_WALL.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(1, IcariaItems.PLATOSHALE_BRICK_WALL.get(), IcariaItems.PLATOSHALE_BRICKS.get());
		this.stonecutting(1, IcariaItems.CHISELED_PLATOSHALE.get(), IcariaItems.PLATOSHALE.get());
		this.stonecutting(1, IcariaItems.CHISELED_PLATOSHALE.get(), IcariaItems.PLATOSHALE_BRICKS.get());
		this.stonecutting(1, IcariaItems.QUARTZ_WALL.get(), Items.QUARTZ_BLOCK);
		this.stonecutting(1, IcariaItems.QUARTZ_PILLAR_HEAD.get(), Items.QUARTZ_BLOCK);
		this.stonecutting(1, IcariaItems.QUARTZ_PILLAR_HEAD.get(), Items.QUARTZ_BRICKS);
		this.stonecutting(1, IcariaItems.QUARTZ_PILLAR_HEAD.get(), Items.QUARTZ_PILLAR);
	}

	public void entityConcocting() {
		this.entityConcocting(4204555, 200, IcariaEntityTypes.AETERNAE.get(), IcariaItems.ROWAN.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.WILTED_ELM.get());
		this.entityConcocting(3550760, 200, IcariaEntityTypes.ARACHNE.get(), IcariaItems.ARACHNE_VENOM_VIAL.get(), IcariaItems.HYLIASTRUM_VIAL.get(), IcariaItems.PSILOCYBOS.get());
		this.entityConcocting(3682088, 200, IcariaEntityTypes.ARACHNE_DRONE.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.BOLBOS.get(), IcariaItems.BOLBOS.get());
		this.entityConcocting(4006938, 200, IcariaEntityTypes.LAUREL_FOREST_HAG.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.ROWAN.get(), IcariaItems.ROWAN.get());
		this.entityConcocting(263942, 200, IcariaEntityTypes.HYLIASTER.get(), IcariaItems.HYLIASTRUM_VIAL.get(), IcariaItems.BONE_REMAINS.get(), IcariaItems.HYLIASTRUM_VIAL.get());
		this.entityConcocting(0, 200, IcariaEntityTypes.ENDER_JELLYFISH.get(), IcariaItems.BOLBOS.get(), IcariaItems.DATHULLA.get());
		this.entityConcocting(6573457, 200, IcariaEntityTypes.VOID_JELLYFISH.get(), IcariaItems.PSILOCYBOS.get(), IcariaItems.MONDANOS.get());
		this.entityConcocting(5249044, 200, IcariaEntityTypes.MYRMEKE_SOLDIER.get(), IcariaItems.MONDANOS.get(), IcariaItems.WILTED_ELM.get(), IcariaItems.ROWAN.get());
		this.entityConcocting(13609241, 200, IcariaEntityTypes.CAPTAIN_REVENANT.get(), IcariaItems.BONE_REMAINS.get(), IcariaItems.BONE_REMAINS.get(), IcariaItems.BONE_REMAINS.get());
		this.entityConcocting(2960665, 200, IcariaEntityTypes.CRAWLER_REVENANT.get(), IcariaItems.BOLBOS.get(), IcariaItems.DATHULLA.get(), IcariaItems.MONDANOS.get());
		this.entityConcocting(5906455, 200, IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), IcariaItems.BOLBOS.get(), IcariaItems.MONDANOS.get(), IcariaItems.WILTED_ELM.get());
		this.entityConcocting(7100247, 200, IcariaEntityTypes.SOLDIER_REVENANT.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.HYLIASTRUM_VIAL.get());
		this.entityConcocting(5323556, 200, IcariaEntityTypes.SCORPION.get(), IcariaItems.MOTH_AGARIC.get(), IcariaItems.MONDANOS.get(), IcariaItems.WILTED_ELM.get());
		this.entityConcocting(2364442, 200, IcariaEntityTypes.CRYSTAL_SLUG.get(), IcariaItems.MONDANOS.get(), IcariaItems.BOLBOS.get(), IcariaItems.ROWAN.get());
		this.entityConcocting(2691846, 200, IcariaEntityTypes.FOREST_SNULL.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.BONE_REMAINS.get());
		this.entityConcocting(3680281, 200, IcariaEntityTypes.VINEGAROON.get(), IcariaItems.MONDANOS.get(), IcariaItems.MONDANOS.get(), IcariaItems.PSILOCYBOS.get());
	}

	public void explosionConcocting() {
		this.explosionConcocting(3.0F, 5083986, 200, IcariaItems.BONE_REMAINS.get(), IcariaItems.MOTH_AGARIC.get());
		this.explosionConcocting(6.0F, 5083986, 200, IcariaItems.PSILOCYBOS.get(), IcariaItems.ROWAN.get(), IcariaItems.NAMDRAKE.get());
	}

	public void firing() {
		this.firing(0.1F, 1, 100, Items.BRICK, Items.CLAY_BALL);
		this.firing(0.2F, 1, 200, Items.GLASS, Items.RED_SAND);
		this.firing(0.2F, 1, 200, Items.GLASS, Items.SAND);
		this.firing(0.2F, 1, 200, Items.TERRACOTTA, Items.CLAY);
		this.firing(0.2F, 1, 200, IcariaItems.GRAINGLASS.get(), IcariaItems.GRAINEL.get());
		this.firing(0.2F, 1, 200, IcariaItems.SILKGLASS.get(), IcariaItems.SILKSAND.get());
		this.firing(0.2F, 1, 200, IcariaItems.STORAGE_VASE.get(), IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.WHITE_STORAGE_VASE.get(), IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.LIGHT_GRAY_STORAGE_VASE.get(), IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.GRAY_STORAGE_VASE.get(), IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.BLACK_STORAGE_VASE.get(), IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.BROWN_STORAGE_VASE.get(), IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.RED_STORAGE_VASE.get(), IcariaItems.RED_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.ORANGE_STORAGE_VASE.get(), IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.YELLOW_STORAGE_VASE.get(), IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.LIME_STORAGE_VASE.get(), IcariaItems.LIME_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.GREEN_STORAGE_VASE.get(), IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.CYAN_STORAGE_VASE.get(), IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.LIGHT_BLUE_STORAGE_VASE.get(), IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.BLUE_STORAGE_VASE.get(), IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.PURPLE_STORAGE_VASE.get(), IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.MAGENTA_STORAGE_VASE.get(), IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get());
		this.firing(0.2F, 1, 200, IcariaItems.PINK_STORAGE_VASE.get(), IcariaItems.PINK_UNFIRED_STORAGE_VASE.get());
		this.firing(0.1F, 1, 100, IcariaItems.LOAM_BRICK.get(), IcariaItems.LOAM_LUMP.get());
		this.firing(0.1F, 1, 100, IcariaItems.LOAM_GEAR.get(), IcariaItems.UNFIRED_LOAM_GEAR.get());
		this.firing(0.1F, 1, 100, IcariaItems.LOAM_BOWL.get(), IcariaItems.UNFIRED_LOAM_BOWL.get());
	}

	public void forging() {
		this.forging(0.1F, 1, 100, Items.COAL, Items.COAL_ORE);
		this.forging(0.1F, 1, 100, Items.COAL, Items.DEEPSLATE_COAL_ORE);
		this.forging(0.1F, 1, 100, Items.COPPER_INGOT, Items.COPPER_ORE);
		this.forging(0.1F, 1, 100, Items.COPPER_INGOT, Items.DEEPSLATE_COPPER_ORE);
		this.forging(0.1F, 1, 100, Items.COPPER_INGOT, Items.RAW_COPPER);
		this.forging(0.1F, 1, 100, Items.DIAMOND, Items.DEEPSLATE_DIAMOND_ORE);
		this.forging(0.1F, 1, 100, Items.DIAMOND, Items.DIAMOND_ORE);
		this.forging(0.1F, 1, 100, Items.EMERALD, Items.DEEPSLATE_EMERALD_ORE);
		this.forging(0.1F, 1, 100, Items.EMERALD, Items.EMERALD_ORE);
		this.forging(0.1F, 1, 100, Items.GOLD_INGOT, Items.DEEPSLATE_GOLD_ORE);
		this.forging(0.1F, 1, 100, Items.GOLD_INGOT, Items.GOLD_ORE);
		this.forging(0.1F, 1, 100, Items.GOLD_INGOT, Items.NETHER_GOLD_ORE);
		this.forging(0.1F, 1, 100, Items.GOLD_INGOT, Items.RAW_GOLD);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_AXE);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_BOOTS);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_CHESTPLATE);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_HELMET);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_HOE);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_HORSE_ARMOR);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_LEGGINGS);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_PICKAXE);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_SHOVEL);
		this.forging(0.1F, 1, 100, Items.GOLD_NUGGET, Items.GOLDEN_SWORD);
		this.forging(0.1F, 1, 100, Items.IRON_INGOT, Items.DEEPSLATE_IRON_ORE);
		this.forging(0.1F, 1, 100, Items.IRON_INGOT, Items.IRON_ORE);
		this.forging(0.1F, 1, 100, Items.IRON_INGOT, Items.RAW_IRON);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.CHAINMAIL_BOOTS);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.CHAINMAIL_CHESTPLATE);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.CHAINMAIL_HELMET);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.CHAINMAIL_LEGGINGS);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_AXE);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_BOOTS);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_CHESTPLATE);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_HELMET);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_HOE);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_HORSE_ARMOR);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_LEGGINGS);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_PICKAXE);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_SHOVEL);
		this.forging(0.1F, 1, 100, Items.IRON_NUGGET, Items.IRON_SWORD);
		this.forging(0.1F, 1, 100, Items.LAPIS_LAZULI, Items.DEEPSLATE_LAPIS_ORE);
		this.forging(0.1F, 1, 100, Items.LAPIS_LAZULI, Items.LAPIS_ORE);
		this.forging(0.1F, 1, 100, Items.QUARTZ, Items.NETHER_QUARTZ_ORE);
		this.forging(0.1F, 1, 100, Items.REDSTONE, Items.DEEPSLATE_REDSTONE_ORE);
		this.forging(0.1F, 1, 100, Items.REDSTONE, Items.REDSTONE_ORE);
		this.forging(0.1F, 1, 100, IcariaItems.LIGNITE.get(), IcariaItems.LIGNITE_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.DOLOMITE.get(), IcariaItems.DOLOMITE_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.SLIVER.get(), IcariaItems.SLIVER_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.ANTHRACITE.get(), IcariaItems.ANTHRACITE_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_AXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_BIDENT.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_BOOTS.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_CHESTPLATE.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_DAGGER.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_HELMET.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_LEGGINGS.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_PICKAXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_SCYTHE.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_SHOVEL.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_SWORD.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_AXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_BIDENT.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_BOOTS.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_CHESTPLATE.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_DAGGER.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_HELMET.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_LEGGINGS.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_PICKAXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_SCYTHE.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_SHOVEL.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_SWORD.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_AXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_BIDENT.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_BOOTS.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_CHESTPLATE.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_DAGGER.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_HELMET.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_LEGGINGS.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_PICKAXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_SCYTHE.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_SHOVEL.get());
		this.forging(0.1F, 1, 100, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_SWORD.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_AXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_BIDENT.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_BOOTS.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_CHESTPLATE.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_DAGGER.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_HELMET.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_LEGGINGS.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_PICKAXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_SCYTHE.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_SHOVEL.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_SWORD.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_AXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_BIDENT.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_DAGGER.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_PICKAXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_SCYTHE.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_SHOVEL.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_SWORD.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_AXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_DAGGER.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_SHOVEL.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_SWORD.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.CHALKOS_INGOT.get(), IcariaItems.RAW_CHALKOS.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.RAW_KASSITEROS.get());
		this.forging(0.3F, 2, 400, IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.CHALKOS_ORE.get(), IcariaItems.CHALKOS_ORE.get(), IcariaItems.KASSITEROS_ORE.get());
		this.forging(0.3F, 1, 200, IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.RAW_CHALKOS.get(), IcariaItems.RAW_CHALKOS.get(), IcariaItems.RAW_KASSITEROS.get());
		this.forging(0.3F, 2, 200, IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_INGOT.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.VANADIUM_INGOT.get(), IcariaItems.RAW_VANADIUM.get());
		this.forging(0.2F, 2, 300, IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.LIGNITE_ORE.get(), IcariaItems.KASSITEROS_ORE.get(), IcariaItems.VANADIUM_ORE.get());
		this.forging(0.2F, 1, 150, IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.LIGNITE.get(), IcariaItems.RAW_KASSITEROS.get(), IcariaItems.RAW_VANADIUM.get());
		this.forging(0.2F, 2, 150, IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.LIGNITE.get(), IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.VANADIUM_INGOT.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.SIDEROS_INGOT.get(), IcariaItems.RAW_SIDEROS.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.MOLYBDENUM_ORE.get());
		this.forging(0.1F, 1, 100, IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.RAW_MOLYBDENUM.get());
		this.forging(0.2F, 2, 300, IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.ANTHRACITE_ORE.get(), IcariaItems.MOLYBDENUM_ORE.get(), IcariaItems.SIDEROS_ORE.get());
		this.forging(0.2F, 1, 150, IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.ANTHRACITE.get(), IcariaItems.RAW_MOLYBDENUM.get(), IcariaItems.RAW_SIDEROS.get());
		this.forging(0.2F, 2, 150, IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.ANTHRACITE.get(), IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.SIDEROS_INGOT.get());
	}

	public void grinding() {
		this.grinding(0.1F, 4, 200, Items.AMETHYST_SHARD, Items.AMETHYST_BLOCK, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.BLACK_CONCRETE_POWDER, Items.BLACK_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLACK_DYE, Items.INK_SAC, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLACK_DYE, Items.WITHER_ROSE, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLACK_DYE, IcariaItems.VOIDLILY.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 4, 200, Items.BLAZE_POWDER, Items.BLAZE_ROD, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.BLUE_CONCRETE_POWDER, Items.BLUE_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLUE_DYE, Items.CORNFLOWER, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLUE_DYE, Items.LAPIS_LAZULI, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLUE_DYE, IcariaItems.BLUE_HYDRACINTH.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLUE_DYE, IcariaItems.BLUE_STORMCOTTON.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BLUE_DYE, IcariaItems.BLUE_GROUND_FLOWERS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.BONE_MEAL, Items.BONE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.2F, 6, 200, Items.BONE_MEAL, IcariaItems.MARL_BONES.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 12, 200, Items.BONE_MEAL, IcariaItems.SURFACE_BONES.get(), IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 12, 200, Items.BONE_MEAL, IcariaItems.BONE_REMAINS.get(), IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BONE_MEAL, IcariaItems.ROTTEN_BONES.get(), IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.BROWN_CONCRETE_POWDER, Items.BROWN_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.BROWN_DYE, Items.COCOA_BEANS, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.CLAY_BALL, Items.CLAY, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.COAL, Items.COAL_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.COAL, Items.DEEPSLATE_COAL_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.COBBLED_DEEPSLATE, Items.CRACKED_DEEPSLATE_BRICKS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.COBBLED_DEEPSLATE, Items.CRACKED_DEEPSLATE_TILES, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.COBBLED_DEEPSLATE, Items.DEEPSLATE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.COBBLESTONE, Items.CRACKED_STONE_BRICKS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.COBBLESTONE, Items.STONE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.CRACKED_DEEPSLATE_BRICKS, Items.DEEPSLATE_BRICKS, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.CRACKED_DEEPSLATE_TILES, Items.DEEPSLATE_TILES, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.CRACKED_NETHER_BRICKS, Items.NETHER_BRICKS, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.CRACKED_POLISHED_BLACKSTONE_BRICKS, Items.POLISHED_BLACKSTONE_BRICKS, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.CRACKED_STONE_BRICKS, Items.STONE_BRICKS, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.CYAN_CONCRETE_POWDER, Items.CYAN_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.CYAN_DYE, Items.PITCHER_PLANT, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.CYAN_DYE, IcariaItems.CYAN_GROUND_FLOWERS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.DIAMOND, Items.DEEPSLATE_DIAMOND_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.DIAMOND, Items.DIAMOND_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.EMERALD, Items.DEEPSLATE_EMERALD_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.EMERALD, Items.EMERALD_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.FLINT, Items.GRAVEL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 100, Items.GLOWSTONE_DUST, Items.GLOWSTONE, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.2F, 6, 200, Items.GOLD_NUGGET, Items.GILDED_BLACKSTONE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 6, 200, Items.GOLD_NUGGET, Items.NETHER_GOLD_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.GRAVEL, Items.COBBLESTONE, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.GRAY_DYE, Items.CLOSED_EYEBLOSSOM, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.GRAY_CONCRETE_POWDER, Items.GRAY_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.GREEN_CONCRETE_POWDER, Items.GREEN_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.GREEN_DYE, Items.CACTUS, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.GREEN_DYE, IcariaItems.CARDON_CACTUS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.HONEYCOMB, Items.HONEYCOMB_BLOCK, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 4, 200, Items.LAPIS_LAZULI, Items.DEEPSLATE_LAPIS_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 4, 200, Items.LAPIS_LAZULI, Items.LAPIS_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.LIGHT_BLUE_CONCRETE_POWDER, Items.LIGHT_BLUE_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.LIGHT_BLUE_DYE, Items.BLUE_ORCHID, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.LIGHT_BLUE_DYE, IcariaItems.CHARMONDER.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.LIGHT_GRAY_CONCRETE_POWDER, Items.LIGHT_GRAY_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.LIGHT_GRAY_DYE, Items.AZURE_BLUET, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.LIGHT_GRAY_DYE, Items.OXEYE_DAISY, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.LIGHT_GRAY_DYE, Items.WHITE_TULIP, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.LIME_CONCRETE_POWDER, Items.LIME_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.LIME_DYE, IcariaItems.SPEARDROPS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.MAGENTA_CONCRETE_POWDER, Items.MAGENTA_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.MAGENTA_DYE, Items.ALLIUM, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.MAGENTA_DYE, Items.LILAC, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.MAGMA_CREAM, Items.MAGMA_BLOCK, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 12, 200, Items.MELON_SEEDS, Items.MELON, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.ORANGE_CONCRETE_POWDER, Items.ORANGE_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.ORANGE_DYE, Items.OPEN_EYEBLOSSOM, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.ORANGE_DYE, Items.ORANGE_TULIP, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.ORANGE_DYE, Items.TORCHFLOWER, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.ORANGE_DYE, IcariaItems.SUNSPONGE.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.ORANGE_DYE, IcariaItems.ORANGE_BROMELIA.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.PINK_CONCRETE_POWDER, Items.PINK_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PINK_DYE, Items.CACTUS_FLOWER, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.PINK_DYE, Items.PEONY, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PINK_DYE, Items.PINK_PETALS, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PINK_DYE, Items.PINK_TULIP, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PINK_DYE, IcariaItems.BLINDWEED.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PINK_DYE, IcariaItems.PINK_STORMCOTTON.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PINK_DYE, IcariaItems.PINK_GROUND_FLOWERS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PINK_DYE, IcariaItems.PINK_BROMELIA.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.POPPED_CHORUS_FRUIT, Items.PURPUR_BLOCK, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.PRISMARINE_SHARD, Items.PRISMARINE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 12, 200, Items.PUMPKIN_SEEDS, Items.PUMPKIN, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.PURPLE_CONCRETE_POWDER, Items.PURPLE_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PURPLE_DYE, IcariaItems.PURPLE_HYDRACINTH.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PURPLE_DYE, IcariaItems.LIONFANGS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PURPLE_DYE, IcariaItems.PURPLE_STAGHORN.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PURPLE_DYE, IcariaItems.PURPLE_STORMCOTTON.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PURPLE_DYE, IcariaItems.PURPLE_GROUND_FLOWERS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.PURPLE_DYE, IcariaItems.PURPLE_BROMELIA.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 4, 200, Items.QUARTZ, Items.NETHER_QUARTZ_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.RAW_COPPER, Items.COPPER_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.RAW_COPPER, Items.DEEPSLATE_COPPER_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.RAW_GOLD, Items.DEEPSLATE_GOLD_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.RAW_GOLD, Items.GOLD_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.RAW_IRON, Items.DEEPSLATE_IRON_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, Items.RAW_IRON, Items.IRON_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.RED_CONCRETE_POWDER, Items.RED_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.RED_DYE, Items.BEETROOT, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.RED_DYE, Items.POPPY, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.RED_DYE, Items.RED_TULIP, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.RED_DYE, Items.ROSE_BUSH, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.RED_DYE, IcariaItems.FIREHILT.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.RED_DYE, IcariaItems.RED_GROUND_FLOWERS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.RED_SAND, Items.RED_SANDSTONE, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.2F, 4, 200, Items.REDSTONE, Items.DEEPSLATE_REDSTONE_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 4, 200, Items.REDSTONE, Items.REDSTONE_ORE, IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.BLACK_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.BLUE_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.BROWN_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.CYAN_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.GRAY_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.GREEN_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.LIGHT_BLUE_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.LIGHT_GRAY_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.LIME_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.MAGENTA_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.ORANGE_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.PINK_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.PURPLE_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.RED_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.SAND, Items.SANDSTONE, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.TINTED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.WHITE_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SAND, Items.YELLOW_STAINED_GLASS, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 100, Items.SNOWBALL, Items.ICE, IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.SNOWBALL, Items.SNOW_BLOCK, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.BLACK_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.BLUE_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.BROWN_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.CYAN_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.GRAY_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.GREEN_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.LIGHT_BLUE_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.LIGHT_GRAY_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.LIME_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.MAGENTA_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.ORANGE_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.PINK_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.PURPLE_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.RED_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.WHITE_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.STRING, Items.YELLOW_WOOL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 3, 200, Items.SUGAR, Items.SUGAR_CANE, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 3, 200, Items.SUGAR, IcariaItems.VINE_REED.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 12, 200, Items.WHEAT_SEEDS, Items.HAY_BLOCK, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.WHITE_CONCRETE_POWDER, Items.WHITE_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.WHITE_DYE, Items.BONE_MEAL, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.WHITE_DYE, Items.LILY_OF_THE_VALLEY, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.WHITE_DYE, IcariaItems.CHAMEOMILE.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.WHITE_DYE, IcariaItems.CLOVER.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.WHITE_DYE, IcariaItems.WHITE_GROUND_FLOWERS.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.WHITE_DYE, IcariaItems.WHITE_BROMELIA.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 200, Items.YELLOW_CONCRETE_POWDER, Items.YELLOW_CONCRETE, IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.YELLOW_DYE, Items.DANDELION, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, Items.YELLOW_DYE, Items.SUNFLOWER, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.YELLOW_DYE, Items.WILDFLOWERS, IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.YELLOW_DYE, IcariaItems.YELLOW_STAGHORN.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 2, 200, Items.YELLOW_DYE, IcariaItems.SUNKETTLE.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 1, 100, IcariaItems.GRAINEL.get(), IcariaItems.GRAINGLASS.get(), IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.GRAINEL.get(), IcariaItems.GRAINITE.get(), IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.COBBLED_YELLOWSTONE.get(), IcariaItems.YELLOWSTONE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 100, IcariaItems.SILKSAND.get(), IcariaItems.SILKGLASS.get(), IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.SILKSAND.get(), IcariaItems.COBBLED_SILKSTONE.get(), IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.COBBLED_SILKSTONE.get(), IcariaItems.SILKSTONE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.COBBLED_SUNSTONE.get(), IcariaItems.SUNSTONE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.COBBLED_VOIDSHALE.get(), IcariaItems.VOIDSHALE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.COBBLED_BAETYL.get(), IcariaItems.BAETYL.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.RELICSTONE.get(), IcariaItems.SMOOTH_RELICSTONE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.RELICSTONE.get(), IcariaItems.CRACKED_RELICSTONE_BRICKS.get(), IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.RELICSTONE.get(), IcariaItems.CRACKED_RELICSTONE_TILES.get(), IcariaItems.YELLOWSTONE_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.CRACKED_RELICSTONE_BRICKS.get(), IcariaItems.RELICSTONE_BRICKS.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.CRACKED_RELICSTONE_TILES.get(), IcariaItems.RELICSTONE_TILES.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 4, 200, IcariaItems.LOAM_LUMP.get(), IcariaItems.LOAM.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.CHERT.get(), IcariaItems.MARL_CHERT.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 4, 200, IcariaItems.CHERT.get(), IcariaItems.SURFACE_CHERT.get(), IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.CHERT.get(), IcariaItems.GRAINEL_CHERT.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 4, 200, IcariaItems.CALCITE_SHARD.get(), IcariaItems.CALCITE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 4, 200, IcariaItems.HALITE_SHARD.get(), IcariaItems.HALITE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 4, 200, IcariaItems.JASPER_SHARD.get(), IcariaItems.JASPER.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.1F, 4, 200, IcariaItems.ZIRCON_SHARD.get(), IcariaItems.ZIRCON.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 1, 200, IcariaItems.CALCITE_DUST.get(), IcariaItems.CALCITE_SHARD.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 1, 200, IcariaItems.HALITE_DUST.get(), IcariaItems.HALITE_SHARD.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.LIGNITE.get(), IcariaItems.MARL_LIGNITE.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.2F, 4, 200, IcariaItems.LIGNITE.get(), IcariaItems.SURFACE_LIGNITE.get(), IcariaItems.VOIDSHALE_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.LIGNITE.get(), IcariaItems.LIGNITE_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.RAW_CHALKOS.get(), IcariaItems.CHALKOS_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.RAW_KASSITEROS.get(), IcariaItems.KASSITEROS_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.DOLOMITE.get(), IcariaItems.DOLOMITE_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.RAW_VANADIUM.get(), IcariaItems.VANADIUM_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.SLIVER.get(), IcariaItems.SLIVER_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.RAW_SIDEROS.get(), IcariaItems.SIDEROS_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.ANTHRACITE.get(), IcariaItems.ANTHRACITE_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.2F, 2, 200, IcariaItems.RAW_MOLYBDENUM.get(), IcariaItems.MOLYBDENUM_ORE.get(), IcariaItems.VANADIUM_GEAR.get());
		this.grinding(0.4F, 6, 400, IcariaItems.BLURIDIUM_NUGGET.get(), IcariaItems.BLURRED_PLATOSHALE.get(), IcariaItems.DAEDALIAN_GEAR.get());
		this.grinding(0.4F, 6, 400, IcariaItems.BLURIDIUM_NUGGET.get(), IcariaItems.BLURRED_PLATOSHALE_BRICKS.get(), IcariaItems.DAEDALIAN_GEAR.get());
		this.grinding(0.1F, 1, 200, IcariaItems.SPELT_FLOUR.get(), IcariaItems.SPELT.get(), IcariaItems.LOAM_GEAR.get());
		this.grinding(0.1F, 12, 200, IcariaItems.SPELT_SEEDS.get(), IcariaItems.SPELT_BALE_BLOCK.get(), IcariaItems.LOAM_GEAR.get());
	}

	public void itemConcocting() {
		this.itemConcocting(1, 668733, 200, Items.ECHO_SHARD, IcariaItems.ROWAN.get(), IcariaItems.HYLIASTRUM_VIAL.get(), IcariaItems.NAMDRAKE.get());
		this.itemConcocting(1, 10711486, 200, Items.END_CRYSTAL, IcariaItems.ARACHNE_VENOM_VIAL.get(), IcariaItems.DATHULLA.get(), IcariaItems.HYLIASTRUM_VIAL.get());
		this.itemConcocting(1, 1467779, 200, Items.HEART_OF_THE_SEA, IcariaItems.PSILOCYBOS.get(), IcariaItems.DATHULLA.get(), IcariaItems.MONDANOS.get());
		this.itemConcocting(1, 4143419, 200, Items.NETHERITE_INGOT, IcariaItems.HYLIASTRUM_VIAL.get(), IcariaItems.BOLBOS.get(), IcariaItems.DATHULLA.get());
		this.itemConcocting(1, 3169872, 200, Items.SNIFFER_EGG, IcariaItems.PSILOCYBOS.get(), IcariaItems.MONDANOS.get(), IcariaItems.BOLBOS.get());
		this.itemConcocting(1, 12366506, 200, IcariaItems.BONE_REMAINS.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.DATHULLA.get());
		this.itemConcocting(1, 6627110, 200, IcariaItems.JASPER_SHARD.get(), IcariaItems.ARACHNE_VENOM_VIAL.get(), IcariaItems.BOLBOS.get());
		this.itemConcocting(1, 6919359, 200, IcariaItems.ANTI_GRAVITY_SPELL.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.BOLBOS.get(), IcariaItems.HYLIASTRUM_VIAL.get());
		this.itemConcocting(1, 6316160, 200, IcariaItems.FORTIFYING_SPELL.get(), IcariaItems.MOTH_AGARIC.get(), IcariaItems.WILTED_ELM.get(), IcariaItems.MONDANOS.get());
		this.itemConcocting(1, 16711680, 200, IcariaItems.HEALING_SPELL.get(), IcariaItems.BOLBOS.get(), IcariaItems.DATHULLA.get(), IcariaItems.WILTED_ELM.get());
		this.itemConcocting(1, 33023, 200, IcariaItems.BUBBLE_SPELL.get(), IcariaItems.MONDANOS.get(), IcariaItems.BOLBOS.get(), IcariaItems.PSILOCYBOS.get());
		this.itemConcocting(1, 14277081, 200, IcariaItems.FREEZING_SPELL.get(), IcariaItems.ROWAN.get(), IcariaItems.ROWAN.get(), IcariaItems.BONE_REMAINS.get());
		this.itemConcocting(1, 6307968, 200, IcariaItems.MAGIC_MISSILE_SPELL.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.BONE_REMAINS.get(), IcariaItems.MOTH_AGARIC.get());
	}

	public void potionConcocting() {
		this.potionConcocting(5.0F, 2400, 12779366, 200, Potions.NIGHT_VISION, IcariaItems.MONDANOS.get(), IcariaItems.MONDANOS.get(), IcariaItems.MONDANOS.get());
		this.potionConcocting(5.0F, 220, 8889187, 200, Potions.POISON, IcariaItems.ROWAN.get(), IcariaItems.ARACHNE_VENOM_VIAL.get());
		this.potionConcocting(5.0F, 440, 220, 200, Potions.REGENERATION, IcariaItems.BOLBOS.get(), IcariaItems.DATHULLA.get(), IcariaItems.PSILOCYBOS.get());
		this.potionConcocting(5.0F, 220, 9154528, 200, Potions.SLOWNESS, IcariaItems.NAMDRAKE.get(), IcariaItems.NAMDRAKE.get(), IcariaItems.NAMDRAKE.get());
		this.potionConcocting(5.0F, 220, 11101546, 200, Potions.STRONG_HARMING, IcariaItems.BOLBOS.get(), IcariaItems.BOLBOS.get(), IcariaItems.BOLBOS.get());
		this.potionConcocting(5.0F, 220, 2039587, 200, IcariaPotions.BLINDNESS, IcariaItems.ROWAN.get(), IcariaItems.ROWAN.get(), IcariaItems.ROWAN.get());
		this.potionConcocting(5.0F, 220, 5578058, 200, IcariaPotions.NAUSEA, IcariaItems.PSILOCYBOS.get(), IcariaItems.MOTH_AGARIC.get(), IcariaItems.PSILOCYBOS.get());
		this.potionConcocting(5.0F, 220, 7561558, 200, IcariaPotions.WITHER, IcariaItems.BONE_REMAINS.get(), IcariaItems.MOTH_AGARIC.get(), IcariaItems.ROWAN.get());
	}

	public void shaped3x3() {
		this.shaped3x3(1, IcariaItems.PACKED_ARISTONE.get(), IcariaItems.ARISTONE.get());
		this.shaped3x3(1, IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.ENDER_JELLYFISH_JELLY.get());
		this.shaped3x3(1, IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get());
		this.shaped3x3(1, IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get());
		this.shaped3x3(1, IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.VOID_JELLYFISH_JELLY.get());
		this.shaped3x3(1, IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get(), IcariaItems.WATER_JELLYFISH_JELLY.get());
		this.shaped3x3(1, IcariaItems.ARACHNE_STRING_BLOCK.get(), IcariaItems.ARACHNE_STRING.get());
		this.shaped3x3(1, IcariaItems.SPELT_BALE_BLOCK.get(), IcariaItems.SPELT.get());
		this.shaped3x3(1, IcariaItems.VINE_REED_BLOCK.get(), IcariaItems.VINE_REED.get());
		this.shaped3x3(1, IcariaItems.ROTTEN_BONES_BLOCK.get(), IcariaItems.ROTTEN_BONES.get());
		this.shaped3x3(1, IcariaItems.RAW_CHALKOS_BLOCK.get(), IcariaItems.RAW_CHALKOS.get());
		this.shaped3x3(1, IcariaItems.RAW_KASSITEROS_BLOCK.get(), IcariaItems.RAW_KASSITEROS.get());
		this.shaped3x3(1, IcariaItems.RAW_VANADIUM_BLOCK.get(), IcariaItems.RAW_VANADIUM.get());
		this.shaped3x3(1, IcariaItems.RAW_SIDEROS_BLOCK.get(), IcariaItems.RAW_SIDEROS.get());
		this.shaped3x3(1, IcariaItems.RAW_MOLYBDENUM_BLOCK.get(), IcariaItems.RAW_MOLYBDENUM.get());
		this.shaped3x3(1, IcariaItems.CALCITE_BLOCK.get(), IcariaItems.CALCITE_SHARD.get());
		this.shaped3x3(1, IcariaItems.HALITE_BLOCK.get(), IcariaItems.HALITE_SHARD.get());
		this.shaped3x3(1, IcariaItems.JASPER_BLOCK.get(), IcariaItems.JASPER_SHARD.get());
		this.shaped3x3(1, IcariaItems.ZIRCON_BLOCK.get(), IcariaItems.ZIRCON_SHARD.get());
		this.shaped3x3(1, IcariaItems.CHERT_BLOCK.get(), IcariaItems.CHERT.get());
		this.shaped3x3(1, IcariaItems.LIGNITE_BLOCK.get(), IcariaItems.LIGNITE.get());
		this.shaped3x3(1, IcariaItems.CHALKOS_BLOCK.get(), IcariaItems.CHALKOS_INGOT.get());
		this.shaped3x3(1, IcariaItems.KASSITEROS_BLOCK.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.shaped3x3(1, IcariaItems.ORICHALCUM_BLOCK.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.shaped3x3(1, IcariaItems.VANADIUM_BLOCK.get(), IcariaItems.VANADIUM_INGOT.get());
		this.shaped3x3(1, IcariaItems.SLIVER_BLOCK.get(), IcariaItems.SLIVER.get());
		this.shaped3x3(1, IcariaItems.VANADIUMSTEEL_BLOCK.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.shaped3x3(1, IcariaItems.SIDEROS_BLOCK.get(), IcariaItems.SIDEROS_INGOT.get());
		this.shaped3x3(1, IcariaItems.ANTHRACITE_BLOCK.get(), IcariaItems.ANTHRACITE.get());
		this.shaped3x3(1, IcariaItems.MOLYBDENUM_BLOCK.get(), IcariaItems.MOLYBDENUM_INGOT.get());
		this.shaped3x3(1, IcariaItems.MOLYBDENUMSTEEL_BLOCK.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.shaped3x3(1, IcariaItems.BLURIDIUM_BLOCK.get(), IcariaItems.BLURIDIUM_INGOT.get());
		this.shaped3x3(1, IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_NUGGET.get());
		this.shaped3x3(1, IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_NUGGET.get());
		this.shaped3x3(1, IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_NUGGET.get());
		this.shaped3x3(1, IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_NUGGET.get());
		this.shaped3x3(1, IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_NUGGET.get());
		this.shaped3x3(1, IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_NUGGET.get());
		this.shaped3x3(1, IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.MOLYBDENUM_NUGGET.get());
		this.shaped3x3(1, IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.MOLYBDENUMSTEEL_NUGGET.get());
		this.shaped3x3(1, IcariaItems.BLURIDIUM_INGOT.get(), IcariaItems.BLURIDIUM_NUGGET.get());
	}

	public void shaped3x2() {
		this.shaped3x2(6, IcariaItems.MARL_ADOBE_WALL.get(), IcariaItems.MARL_ADOBE.get());
		this.shaped3x2(6, IcariaItems.LOAM_BRICK_WALL.get(), IcariaItems.LOAM_BRICKS.get());
		this.shaped3x2(6, IcariaItems.DOLOMITE_ADOBE_WALL.get(), IcariaItems.DOLOMITE_ADOBE.get());
		this.shaped3x2(6, IcariaItems.SMOOTH_DOLOMITE_WALL.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.shaped3x2(16, IcariaItems.GRAINGLASS_PANE.get(), IcariaItems.GRAINGLASS.get());
		this.shaped3x2(6, IcariaItems.GRAINITE_ADOBE_WALL.get(), IcariaItems.GRAINITE_ADOBE.get());
		this.shaped3x2(6, IcariaItems.GRAINITE_WALL.get(), IcariaItems.GRAINITE.get());
		this.shaped3x2(6, IcariaItems.GRAINITE_BRICK_WALL.get(), IcariaItems.GRAINITE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.YELLOWSTONE_ADOBE_WALL.get(), IcariaItems.YELLOWSTONE_ADOBE.get());
		this.shaped3x2(6, IcariaItems.COBBLED_YELLOWSTONE_WALL.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.shaped3x2(6, IcariaItems.YELLOWSTONE_WALL.get(), IcariaItems.YELLOWSTONE.get());
		this.shaped3x2(6, IcariaItems.YELLOWSTONE_BRICK_WALL.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
		this.shaped3x2(16, IcariaItems.SILKGLASS_PANE.get(), IcariaItems.SILKGLASS.get());
		this.shaped3x2(6, IcariaItems.SILKSTONE_ADOBE_WALL.get(), IcariaItems.SILKSTONE_ADOBE.get());
		this.shaped3x2(6, IcariaItems.COBBLED_SILKSTONE_WALL.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.shaped3x2(6, IcariaItems.SILKSTONE_WALL.get(), IcariaItems.SILKSTONE.get());
		this.shaped3x2(6, IcariaItems.SILKSTONE_BRICK_WALL.get(), IcariaItems.SILKSTONE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.SUNSTONE_ADOBE_WALL.get(), IcariaItems.SUNSTONE_ADOBE.get());
		this.shaped3x2(6, IcariaItems.COBBLED_SUNSTONE_WALL.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.shaped3x2(6, IcariaItems.SUNSTONE_WALL.get(), IcariaItems.SUNSTONE.get());
		this.shaped3x2(6, IcariaItems.SUNSTONE_BRICK_WALL.get(), IcariaItems.SUNSTONE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.VOIDSHALE_ADOBE_WALL.get(), IcariaItems.VOIDSHALE_ADOBE.get());
		this.shaped3x2(6, IcariaItems.COBBLED_VOIDSHALE_WALL.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.shaped3x2(6, IcariaItems.VOIDSHALE_WALL.get(), IcariaItems.VOIDSHALE.get());
		this.shaped3x2(6, IcariaItems.VOIDSHALE_BRICK_WALL.get(), IcariaItems.VOIDSHALE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.BAETYL_ADOBE_WALL.get(), IcariaItems.BAETYL_ADOBE.get());
		this.shaped3x2(6, IcariaItems.COBBLED_BAETYL_WALL.get(), IcariaItems.COBBLED_BAETYL.get());
		this.shaped3x2(6, IcariaItems.BAETYL_WALL.get(), IcariaItems.BAETYL.get());
		this.shaped3x2(6, IcariaItems.BAETYL_BRICK_WALL.get(), IcariaItems.BAETYL_BRICKS.get());
		this.shaped3x2(6, IcariaItems.RELICSTONE_WALL.get(), IcariaItems.RELICSTONE.get());
		this.shaped3x2(6, IcariaItems.SMOOTH_RELICSTONE_WALL.get(), IcariaItems.SMOOTH_RELICSTONE.get());
		this.shaped3x2(6, IcariaItems.RELICSTONE_BRICK_WALL.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.CRACKED_RELICSTONE_BRICK_WALL.get(), IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.MOSSY_RELICSTONE_BRICK_WALL.get(), IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.RELICSTONE_TILE_WALL.get(), IcariaItems.RELICSTONE_TILES.get());
		this.shaped3x2(6, IcariaItems.CRACKED_RELICSTONE_TILE_WALL.get(), IcariaItems.CRACKED_RELICSTONE_TILES.get());
		this.shaped3x2(6, IcariaItems.MOSSY_RELICSTONE_TILE_WALL.get(), IcariaItems.MOSSY_RELICSTONE_TILES.get());
		this.shaped3x2(6, IcariaItems.PLATOSHALE_WALL.get(), IcariaItems.PLATOSHALE.get());
		this.shaped3x2(6, IcariaItems.PLATOSHALE_BRICK_WALL.get(), IcariaItems.PLATOSHALE_BRICKS.get());
		this.shaped3x2(6, IcariaItems.QUARTZ_WALL.get(), Items.QUARTZ_BLOCK);
		this.shaped3x2(16, IcariaItems.VANADIUMSTEEL_BARS.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.shaped3x2(2, IcariaItems.CYPRESS_TRAPDOOR.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.shaped3x2(2, IcariaItems.DROUGHTROOT_TRAPDOOR.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.shaped3x2(2, IcariaItems.FIR_TRAPDOOR.get(), IcariaItems.FIR_PLANKS.get());
		this.shaped3x2(2, IcariaItems.LAUREL_TRAPDOOR.get(), IcariaItems.LAUREL_PLANKS.get());
		this.shaped3x2(2, IcariaItems.OLIVE_TRAPDOOR.get(), IcariaItems.OLIVE_PLANKS.get());
		this.shaped3x2(2, IcariaItems.PLANE_TRAPDOOR.get(), IcariaItems.PLANE_PLANKS.get());
		this.shaped3x2(2, IcariaItems.POPULUS_TRAPDOOR.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void shaped3x1() {
		this.shaped3x1(3, Items.PAPER, IcariaItems.VINE_REED.get());
		this.shaped3x1(6, IcariaItems.MARL_ADOBE_SLAB.get(), IcariaItems.MARL_ADOBE.get());
		this.shaped3x1(6, IcariaItems.LOAM_BRICK_SLAB.get(), IcariaItems.LOAM_BRICKS.get());
		this.shaped3x1(6, IcariaItems.DOLOMITE_ADOBE_SLAB.get(), IcariaItems.DOLOMITE_ADOBE.get());
		this.shaped3x1(6, IcariaItems.SMOOTH_DOLOMITE_SLAB.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.shaped3x1(6, IcariaItems.GRAINITE_ADOBE_SLAB.get(), IcariaItems.GRAINITE_ADOBE.get());
		this.shaped3x1(6, IcariaItems.GRAINITE_SLAB.get(), IcariaItems.GRAINITE.get());
		this.shaped3x1(6, IcariaItems.GRAINITE_BRICK_SLAB.get(), IcariaItems.GRAINITE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.YELLOWSTONE_ADOBE_SLAB.get(), IcariaItems.YELLOWSTONE_ADOBE.get());
		this.shaped3x1(6, IcariaItems.COBBLED_YELLOWSTONE_SLAB.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.shaped3x1(6, IcariaItems.YELLOWSTONE_SLAB.get(), IcariaItems.YELLOWSTONE.get());
		this.shaped3x1(6, IcariaItems.YELLOWSTONE_BRICK_SLAB.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.SILKSTONE_ADOBE_SLAB.get(), IcariaItems.SILKSTONE_ADOBE.get());
		this.shaped3x1(6, IcariaItems.COBBLED_SILKSTONE_SLAB.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.shaped3x1(6, IcariaItems.SILKSTONE_SLAB.get(), IcariaItems.SILKSTONE.get());
		this.shaped3x1(6, IcariaItems.SILKSTONE_BRICK_SLAB.get(), IcariaItems.SILKSTONE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.SUNSTONE_ADOBE_SLAB.get(), IcariaItems.SUNSTONE_ADOBE.get());
		this.shaped3x1(6, IcariaItems.COBBLED_SUNSTONE_SLAB.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.shaped3x1(6, IcariaItems.SUNSTONE_SLAB.get(), IcariaItems.SUNSTONE.get());
		this.shaped3x1(6, IcariaItems.SUNSTONE_BRICK_SLAB.get(), IcariaItems.SUNSTONE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.VOIDSHALE_ADOBE_SLAB.get(), IcariaItems.VOIDSHALE_ADOBE.get());
		this.shaped3x1(6, IcariaItems.COBBLED_VOIDSHALE_SLAB.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.shaped3x1(6, IcariaItems.VOIDSHALE_SLAB.get(), IcariaItems.VOIDSHALE.get());
		this.shaped3x1(6, IcariaItems.VOIDSHALE_BRICK_SLAB.get(), IcariaItems.VOIDSHALE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.BAETYL_ADOBE_SLAB.get(), IcariaItems.BAETYL_ADOBE.get());
		this.shaped3x1(6, IcariaItems.COBBLED_BAETYL_SLAB.get(), IcariaItems.COBBLED_BAETYL.get());
		this.shaped3x1(6, IcariaItems.BAETYL_SLAB.get(), IcariaItems.BAETYL.get());
		this.shaped3x1(6, IcariaItems.BAETYL_BRICK_SLAB.get(), IcariaItems.BAETYL_BRICKS.get());
		this.shaped3x1(6, IcariaItems.RELICSTONE_SLAB.get(), IcariaItems.RELICSTONE.get());
		this.shaped3x1(6, IcariaItems.SMOOTH_RELICSTONE_SLAB.get(), IcariaItems.SMOOTH_RELICSTONE.get());
		this.shaped3x1(6, IcariaItems.RELICSTONE_BRICK_SLAB.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.CRACKED_RELICSTONE_BRICK_SLAB.get(), IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.MOSSY_RELICSTONE_BRICK_SLAB.get(), IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.RELICSTONE_TILE_SLAB.get(), IcariaItems.RELICSTONE_TILES.get());
		this.shaped3x1(6, IcariaItems.CRACKED_RELICSTONE_TILE_SLAB.get(), IcariaItems.CRACKED_RELICSTONE_TILES.get());
		this.shaped3x1(6, IcariaItems.MOSSY_RELICSTONE_TILE_SLAB.get(), IcariaItems.MOSSY_RELICSTONE_TILES.get());
		this.shaped3x1(6, IcariaItems.PLATOSHALE_SLAB.get(), IcariaItems.PLATOSHALE.get());
		this.shaped3x1(6, IcariaItems.PLATOSHALE_BRICK_SLAB.get(), IcariaItems.PLATOSHALE_BRICKS.get());
		this.shaped3x1(6, IcariaItems.CYPRESS_SLAB.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.shaped3x1(6, IcariaItems.DROUGHTROOT_SLAB.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.shaped3x1(6, IcariaItems.FIR_SLAB.get(), IcariaItems.FIR_PLANKS.get());
		this.shaped3x1(6, IcariaItems.LAUREL_SLAB.get(), IcariaItems.LAUREL_PLANKS.get());
		this.shaped3x1(6, IcariaItems.OLIVE_SLAB.get(), IcariaItems.OLIVE_PLANKS.get());
		this.shaped3x1(6, IcariaItems.PLANE_SLAB.get(), IcariaItems.PLANE_PLANKS.get());
		this.shaped3x1(6, IcariaItems.POPULUS_SLAB.get(), IcariaItems.POPULUS_PLANKS.get());
		this.shaped3x1(1, IcariaItems.CHEST_LABEL.get(), Items.PAPER);
		this.shaped3x1(1, IcariaItems.SPELT_BREAD.get(), IcariaItems.SPELT.get());
	}

	public void shaped2x3() {
		this.shaped2x3(3, IcariaItems.CYPRESS_DOOR.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.shaped2x3(3, IcariaItems.DROUGHTROOT_DOOR.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.shaped2x3(3, IcariaItems.FIR_DOOR.get(), IcariaItems.FIR_PLANKS.get());
		this.shaped2x3(3, IcariaItems.LAUREL_DOOR.get(), IcariaItems.LAUREL_PLANKS.get());
		this.shaped2x3(3, IcariaItems.OLIVE_DOOR.get(), IcariaItems.OLIVE_PLANKS.get());
		this.shaped2x3(3, IcariaItems.PLANE_DOOR.get(), IcariaItems.PLANE_PLANKS.get());
		this.shaped2x3(3, IcariaItems.POPULUS_DOOR.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void shaped2x2() {
		this.shaped2x2(1, Items.WHITE_WOOL, IcariaItems.ARACHNE_STRING.get());
		this.shaped2x2(1, IcariaItems.LOAM.get(), IcariaItems.LOAM_LUMP.get());
		this.shaped2x2(1, IcariaItems.LOAM_BRICKS.get(), IcariaItems.LOAM_BRICK.get());
		this.shaped2x2(1, IcariaItems.SMOOTH_DOLOMITE.get(), IcariaItems.DOLOMITE.get());
		this.shaped2x2(4, IcariaItems.DOLOMITE_BRICKS.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.shaped2x2(1, IcariaItems.GRAINITE.get(), IcariaItems.GRAINEL.get());
		this.shaped2x2(4, IcariaItems.GRAINITE_BRICKS.get(), IcariaItems.GRAINITE.get());
		this.shaped2x2(4, IcariaItems.YELLOWSTONE_BRICKS.get(), IcariaItems.YELLOWSTONE.get());
		this.shaped2x2(1, IcariaItems.SILKSTONE.get(), IcariaItems.SILKSAND.get());
		this.shaped2x2(4, IcariaItems.SILKSTONE_BRICKS.get(), IcariaItems.SILKSTONE.get());
		this.shaped2x2(4, IcariaItems.SUNSTONE_BRICKS.get(), IcariaItems.SUNSTONE.get());
		this.shaped2x2(4, IcariaItems.VOIDSHALE_BRICKS.get(), IcariaItems.VOIDSHALE.get());
		this.shaped2x2(4, IcariaItems.BAETYL_BRICKS.get(), IcariaItems.BAETYL.get());
		this.shaped2x2(4, IcariaItems.RELICSTONE_BRICKS.get(), IcariaItems.RELICSTONE.get());
		this.shaped2x2(4, IcariaItems.RELICSTONE_TILES.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.shaped2x2(4, IcariaItems.PLATOSHALE_BRICKS.get(), IcariaItems.PLATOSHALE.get());
		this.shaped2x2(1, IcariaItems.CALCITE.get(), IcariaItems.CALCITE_SHARD.get());
		this.shaped2x2(1, IcariaItems.HALITE.get(), IcariaItems.HALITE_SHARD.get());
		this.shaped2x2(1, IcariaItems.JASPER.get(), IcariaItems.JASPER_SHARD.get());
		this.shaped2x2(1, IcariaItems.ZIRCON.get(), IcariaItems.ZIRCON_SHARD.get());
		this.shaped2x2(3, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get());
		this.shaped2x2(3, IcariaItems.CYPRESS_WOOD.get(), IcariaItems.DEAD_CYPRESS_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get());
		this.shaped2x2(1, IcariaItems.CYPRESS_CRAFTING_TABLE.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.shaped2x2(3, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get());
		this.shaped2x2(3, IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.DEAD_DROUGHTROOT_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		this.shaped2x2(1, IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.shaped2x2(3, IcariaItems.FIR_WOOD.get(), IcariaItems.FIR_LOG.get());
		this.shaped2x2(3, IcariaItems.FIR_WOOD.get(), IcariaItems.DEAD_FIR_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.STRIPPED_DEAD_FIR_LOG.get());
		this.shaped2x2(1, IcariaItems.FIR_CRAFTING_TABLE.get(), IcariaItems.FIR_PLANKS.get());
		this.shaped2x2(3, IcariaItems.LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get());
		this.shaped2x2(3, IcariaItems.LAUREL_WOOD.get(), IcariaItems.DEAD_LAUREL_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get());
		this.shaped2x2(1, IcariaItems.LAUREL_CRAFTING_TABLE.get(), IcariaItems.LAUREL_PLANKS.get());
		this.shaped2x2(3, IcariaItems.OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get());
		this.shaped2x2(3, IcariaItems.OLIVE_WOOD.get(), IcariaItems.DEAD_OLIVE_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get());
		this.shaped2x2(1, IcariaItems.OLIVE_CRAFTING_TABLE.get(), IcariaItems.OLIVE_PLANKS.get());
		this.shaped2x2(3, IcariaItems.PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get());
		this.shaped2x2(3, IcariaItems.PLANE_WOOD.get(), IcariaItems.DEAD_PLANE_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.STRIPPED_DEAD_PLANE_LOG.get());
		this.shaped2x2(1, IcariaItems.PLANE_CRAFTING_TABLE.get(), IcariaItems.PLANE_PLANKS.get());
		this.shaped2x2(3, IcariaItems.POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get());
		this.shaped2x2(3, IcariaItems.POPULUS_WOOD.get(), IcariaItems.DEAD_POPULUS_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_LOG.get());
		this.shaped2x2(3, IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());
		this.shaped2x2(1, IcariaItems.POPULUS_CRAFTING_TABLE.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void shaped2x1() {
		this.shaped2x1(2, IcariaItems.HORIZONTAL_GRAINGLASS_PANE.get(), IcariaItems.GRAINGLASS_PANE.get());
		this.shaped2x1(2, IcariaItems.HORIZONTAL_SILKGLASS_PANE.get(), IcariaItems.SILKGLASS_PANE.get());
		this.shaped2x1(2, IcariaItems.HORIZONTAL_VANADIUMSTEEL_BARS.get(), IcariaItems.VANADIUMSTEEL_BARS.get());
		this.shaped2x1(1, IcariaItems.CYPRESS_PRESSURE_PLATE.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.shaped2x1(1, IcariaItems.DROUGHTROOT_PRESSURE_PLATE.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.shaped2x1(1, IcariaItems.FIR_PRESSURE_PLATE.get(), IcariaItems.FIR_PLANKS.get());
		this.shaped2x1(1, IcariaItems.LAUREL_PRESSURE_PLATE.get(), IcariaItems.LAUREL_PLANKS.get());
		this.shaped2x1(1, IcariaItems.OLIVE_PRESSURE_PLATE.get(), IcariaItems.OLIVE_PLANKS.get());
		this.shaped2x1(1, IcariaItems.PLANE_PRESSURE_PLATE.get(), IcariaItems.PLANE_PLANKS.get());
		this.shaped2x1(1, IcariaItems.POPULUS_PRESSURE_PLATE.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void shaped1x2() {
		this.shaped1x2(2, IcariaItems.DOLOMITE_PILLAR.get(), IcariaItems.DOLOMITE_BRICKS.get());
		this.shaped1x2(1, IcariaItems.CHISELED_DOLOMITE.get(), IcariaItems.SMOOTH_DOLOMITE_SLAB.get());
		this.shaped1x2(1, IcariaItems.CHISELED_GRAINITE.get(), IcariaItems.GRAINITE_BRICK_SLAB.get());
		this.shaped1x2(1, IcariaItems.CHISELED_YELLOWSTONE.get(), IcariaItems.YELLOWSTONE_BRICK_SLAB.get());
		this.shaped1x2(1, IcariaItems.CHISELED_SILKSTONE.get(), IcariaItems.SILKSTONE_BRICK_SLAB.get());
		this.shaped1x2(1, IcariaItems.CHISELED_SUNSTONE.get(), IcariaItems.SUNSTONE_BRICK_SLAB.get());
		this.shaped1x2(1, IcariaItems.CHISELED_VOIDSHALE.get(), IcariaItems.VOIDSHALE_BRICK_SLAB.get());
		this.shaped1x2(1, IcariaItems.CHISELED_BAETYL.get(), IcariaItems.BAETYL_BRICK_SLAB.get());
		this.shaped1x2(1, IcariaItems.CHISELED_RELICSTONE.get(), IcariaItems.RELICSTONE_BRICK_SLAB.get());
		this.shaped1x2(2, IcariaItems.RELICSTONE_PILLAR.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.shaped1x2(1, IcariaItems.CHISELED_PLATOSHALE.get(), IcariaItems.PLATOSHALE_BRICK_SLAB.get());
	}

	public void adobe() {
		this.adobe(4, IcariaItems.MARL_ADOBE.get(), IcariaItems.MARL.get());
		this.adobe(4, IcariaItems.DOLOMITE_ADOBE.get(), IcariaItems.DOLOMITE.get());
		this.adobe(4, IcariaItems.GRAINITE_ADOBE.get(), IcariaItems.GRAINITE.get());
		this.adobe(4, IcariaItems.YELLOWSTONE_ADOBE.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.adobe(4, IcariaItems.SILKSTONE_ADOBE.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.adobe(4, IcariaItems.SUNSTONE_ADOBE.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.adobe(4, IcariaItems.VOIDSHALE_ADOBE.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.adobe(4, IcariaItems.BAETYL_ADOBE.get(), IcariaItems.COBBLED_BAETYL.get());
	}

	public void axe() {
		this.axe(1, IcariaItems.CHERT_AXE.get(), IcariaItems.CHERT.get());
		this.axe(1, IcariaItems.CHALKOS_AXE.get(), IcariaItems.CHALKOS_INGOT.get());
		this.axe(1, IcariaItems.KASSITEROS_AXE.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.axe(1, IcariaItems.ORICHALCUM_AXE.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.axe(1, IcariaItems.VANADIUMSTEEL_AXE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.axe(1, IcariaItems.SIDEROS_AXE.get(), IcariaItems.SIDEROS_INGOT.get());
		this.axe(1, IcariaItems.MOLYBDENUMSTEEL_AXE.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
	}

	public void bathtub() {
		this.bathtub(1, IcariaItems.CYPRESS_BATHTUB.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.bathtub(1, IcariaItems.DROUGHTROOT_BATHTUB.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.bathtub(1, IcariaItems.FIR_BATHTUB.get(), IcariaItems.FIR_LOG.get(), IcariaItems.FIR_PLANKS.get());
		this.bathtub(1, IcariaItems.LAUREL_BATHTUB.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.LAUREL_PLANKS.get());
		this.bathtub(1, IcariaItems.OLIVE_BATHTUB.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.OLIVE_PLANKS.get());
		this.bathtub(1, IcariaItems.PLANE_BATHTUB.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.PLANE_PLANKS.get());
		this.bathtub(1, IcariaItems.POPULUS_BATHTUB.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void bident() {
		this.bident(1, IcariaItems.CHERT_BIDENT.get(), IcariaItems.CHERT.get());
		this.bident(1, IcariaItems.CHALKOS_BIDENT.get(), IcariaItems.CHALKOS_INGOT.get());
		this.bident(1, IcariaItems.KASSITEROS_BIDENT.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.bident(1, IcariaItems.ORICHALCUM_BIDENT.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.bident(1, IcariaItems.VANADIUMSTEEL_BIDENT.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.bident(1, IcariaItems.SIDEROS_BIDENT.get(), IcariaItems.SIDEROS_INGOT.get());
		this.bident(1, IcariaItems.MOLYBDENUMSTEEL_BIDENT.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
	}

	public void boots() {
		this.boots(1, IcariaItems.AETERNAE_HIDE_BOOTS.get(), IcariaItems.AETERNAE_HIDE.get());
		this.boots(1, IcariaItems.CHALKOS_BOOTS.get(), IcariaItems.CHALKOS_INGOT.get());
		this.boots(1, IcariaItems.KASSITEROS_BOOTS.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.boots(1, IcariaItems.ORICHALCUM_BOOTS.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.boots(1, IcariaItems.VANADIUMSTEEL_BOOTS.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
	}

	public void bowl() {
		this.bowl(3, IcariaItems.EMPTY_FLASK.get(), IcariaItems.SILKGLASS.get());
		this.bowl(3, IcariaItems.EMPTY_VIAL.get(), IcariaItems.GRAINGLASS.get());
		this.bowl(4, IcariaItems.UNFIRED_LOAM_BOWL.get(), IcariaItems.LOAM_LUMP.get());
	}

	public void cake() {
		this.cake(1, IcariaItems.LAUREL_CHERRY_CAKE.get(), IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.LAUREL_CHERRY.get());
		this.cake(1, IcariaItems.STRAWBERRY_CAKE.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.STRAWBERRIES.get());
		this.cake(1, IcariaItems.PHYSALIS_CAKE.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.PHYSALIS.get());
		this.cake(1, IcariaItems.VINE_BERRY_CAKE.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.VINEBERRIES.get());
		this.cake(1, IcariaItems.VINE_SPROUT_CAKE.get(), IcariaItems.WATER_JELLYFISH_JELLY.get(), IcariaItems.VINE_SPROUT.get());
	}

	public void carpet() {
		this.carpet(3, IcariaItems.ARACHNE_STRING_CARPET.get(), IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.WHITE_ARACHNE_STRING_CARPET.get(), IcariaItems.WHITE_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get(), IcariaItems.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.GRAY_ARACHNE_STRING_CARPET.get(), IcariaItems.GRAY_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.BLACK_ARACHNE_STRING_CARPET.get(), IcariaItems.BLACK_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.BROWN_ARACHNE_STRING_CARPET.get(), IcariaItems.BROWN_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.RED_ARACHNE_STRING_CARPET.get(), IcariaItems.RED_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get(), IcariaItems.ORANGE_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get(), IcariaItems.YELLOW_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.LIME_ARACHNE_STRING_CARPET.get(), IcariaItems.LIME_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.GREEN_ARACHNE_STRING_CARPET.get(), IcariaItems.GREEN_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.CYAN_ARACHNE_STRING_CARPET.get(), IcariaItems.CYAN_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get(), IcariaItems.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.BLUE_ARACHNE_STRING_CARPET.get(), IcariaItems.BLUE_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get(), IcariaItems.PURPLE_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get(), IcariaItems.MAGENTA_ARACHNE_STRING_BLOCK.get());
		this.carpet(3, IcariaItems.PINK_ARACHNE_STRING_CARPET.get(), IcariaItems.PINK_ARACHNE_STRING_BLOCK.get());
	}

	public void centerFilled() {
		this.centerFilled(1, Items.ITEM_FRAME, Items.STICK, IcariaItems.AETERNAE_HIDE.get());
		this.centerFilled(1, IcariaItems.GRINDER.get(), IcariaItems.SUNSTONE_BRICKS.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.centerFilled(1, IcariaItems.PAINTING.get(), Items.STICK, IcariaItems.ARACHNE_STRING_BLOCK.get());
	}

	public void centerHollow() {
		this.centerHollow(1, IcariaItems.CHEST.get(), IcariaItems.LAUREL_PLANKS.get());
		this.centerHollow(1, IcariaItems.UNFIRED_STORAGE_VASE.get(), IcariaItems.LOAM_LUMP.get());
		this.centerHollow(1, IcariaItems.KILN.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
	}

	public void chestplate() {
		this.chestplate(1, IcariaItems.AETERNAE_HIDE_CHESTPLATE.get(), IcariaItems.AETERNAE_HIDE.get());
		this.chestplate(1, IcariaItems.CHALKOS_CHESTPLATE.get(), IcariaItems.CHALKOS_INGOT.get());
		this.chestplate(1, IcariaItems.KASSITEROS_CHESTPLATE.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.chestplate(1, IcariaItems.ORICHALCUM_CHESTPLATE.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.chestplate(1, IcariaItems.VANADIUMSTEEL_CHESTPLATE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
	}

	public void dagger() {
		this.dagger(1, IcariaItems.CHERT_DAGGER.get(), IcariaItems.CHERT.get());
		this.dagger(1, IcariaItems.CHALKOS_DAGGER.get(), IcariaItems.CHALKOS_INGOT.get());
		this.dagger(1, IcariaItems.KASSITEROS_DAGGER.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.dagger(1, IcariaItems.ORICHALCUM_DAGGER.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.dagger(1, IcariaItems.VANADIUMSTEEL_DAGGER.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.dagger(1, IcariaItems.SIDEROS_DAGGER.get(), IcariaItems.SIDEROS_INGOT.get());
		this.dagger(1, IcariaItems.MOLYBDENUMSTEEL_DAGGER.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
	}

	public void fence() {
		this.fence(3, IcariaItems.CYPRESS_FENCE.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.fence(3, IcariaItems.DROUGHTROOT_FENCE.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.fence(3, IcariaItems.FIR_FENCE.get(), IcariaItems.FIR_PLANKS.get());
		this.fence(3, IcariaItems.LAUREL_FENCE.get(), IcariaItems.LAUREL_PLANKS.get());
		this.fence(3, IcariaItems.OLIVE_FENCE.get(), IcariaItems.OLIVE_PLANKS.get());
		this.fence(3, IcariaItems.PLANE_FENCE.get(), IcariaItems.PLANE_PLANKS.get());
		this.fence(3, IcariaItems.POPULUS_FENCE.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void fenceGate() {
		this.fenceGate(1, IcariaItems.CYPRESS_FENCE_GATE.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.fenceGate(1, IcariaItems.DROUGHTROOT_FENCE_GATE.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.fenceGate(1, IcariaItems.FIR_FENCE_GATE.get(), IcariaItems.FIR_PLANKS.get());
		this.fenceGate(1, IcariaItems.LAUREL_FENCE_GATE.get(), IcariaItems.LAUREL_PLANKS.get());
		this.fenceGate(1, IcariaItems.OLIVE_FENCE_GATE.get(), IcariaItems.OLIVE_PLANKS.get());
		this.fenceGate(1, IcariaItems.PLANE_FENCE_GATE.get(), IcariaItems.PLANE_PLANKS.get());
		this.fenceGate(1, IcariaItems.POPULUS_FENCE_GATE.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void gear() {
		this.gear(1, IcariaItems.YELLOWSTONE_GEAR.get(), IcariaItems.YELLOWSTONE.get());
		this.gear(1, IcariaItems.UNFIRED_LOAM_GEAR.get(), IcariaItems.LOAM_LUMP.get());
		this.gear(1, IcariaItems.VOIDSHALE_GEAR.get(), IcariaItems.VOIDSHALE.get());
		this.gear(1, IcariaItems.VANADIUM_GEAR.get(), IcariaItems.VANADIUM_INGOT.get());
	}

	public void hangingSign() {
		this.hangingSign(6, IcariaItems.CYPRESS_HANGING_SIGN.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get());
		this.hangingSign(6, IcariaItems.DROUGHTROOT_HANGING_SIGN.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get());
		this.hangingSign(6, IcariaItems.FIR_HANGING_SIGN.get(), IcariaItems.STRIPPED_FIR_LOG.get());
		this.hangingSign(6, IcariaItems.LAUREL_HANGING_SIGN.get(), IcariaItems.STRIPPED_LAUREL_LOG.get());
		this.hangingSign(6, IcariaItems.OLIVE_HANGING_SIGN.get(), IcariaItems.STRIPPED_OLIVE_LOG.get());
		this.hangingSign(6, IcariaItems.PLANE_HANGING_SIGN.get(), IcariaItems.STRIPPED_PLANE_LOG.get());
		this.hangingSign(6, IcariaItems.POPULUS_HANGING_SIGN.get(), IcariaItems.STRIPPED_POPULUS_LOG.get());
	}

	public void harness() {
		this.harness(1, Items.WHITE_HARNESS, Items.WHITE_WOOL);
		this.harness(1, Items.LIGHT_GRAY_HARNESS, Items.LIGHT_GRAY_WOOL);
		this.harness(1, Items.GRAY_HARNESS, Items.GRAY_WOOL);
		this.harness(1, Items.BLACK_HARNESS, Items.BLACK_WOOL);
		this.harness(1, Items.BROWN_HARNESS, Items.BROWN_WOOL);
		this.harness(1, Items.RED_HARNESS, Items.RED_WOOL);
		this.harness(1, Items.ORANGE_HARNESS, Items.ORANGE_WOOL);
		this.harness(1, Items.YELLOW_HARNESS, Items.YELLOW_WOOL);
		this.harness(1, Items.LIME_HARNESS, Items.LIME_WOOL);
		this.harness(1, Items.GREEN_HARNESS, Items.GREEN_WOOL);
		this.harness(1, Items.CYAN_HARNESS, Items.CYAN_WOOL);
		this.harness(1, Items.LIGHT_BLUE_HARNESS, Items.LIGHT_BLUE_WOOL);
		this.harness(1, Items.BLUE_HARNESS, Items.BLUE_WOOL);
		this.harness(1, Items.PURPLE_HARNESS, Items.PURPLE_WOOL);
		this.harness(1, Items.MAGENTA_HARNESS, Items.MAGENTA_WOOL);
		this.harness(1, Items.PINK_HARNESS, Items.PINK_WOOL);
	}

	public void helmet() {
		this.helmet(1, IcariaItems.AETERNAE_HIDE_HELMET.get(), IcariaItems.AETERNAE_HIDE.get());
		this.helmet(1, IcariaItems.CHALKOS_HELMET.get(), IcariaItems.CHALKOS_INGOT.get());
		this.helmet(1, IcariaItems.KASSITEROS_HELMET.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.helmet(1, IcariaItems.ORICHALCUM_HELMET.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.helmet(1, IcariaItems.VANADIUMSTEEL_HELMET.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
	}

	public void ladder() {
		this.ladder(6, IcariaItems.CYPRESS_LADDER.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.ladder(6, IcariaItems.DROUGHTROOT_LADDER.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.ladder(6, IcariaItems.FIR_LADDER.get(), IcariaItems.FIR_PLANKS.get());
		this.ladder(6, IcariaItems.LAUREL_LADDER.get(), IcariaItems.LAUREL_PLANKS.get());
		this.ladder(6, IcariaItems.OLIVE_LADDER.get(), IcariaItems.OLIVE_PLANKS.get());
		this.ladder(6, IcariaItems.PLANE_LADDER.get(), IcariaItems.PLANE_PLANKS.get());
		this.ladder(6, IcariaItems.POPULUS_LADDER.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void leggings() {
		this.leggings(1, IcariaItems.AETERNAE_HIDE_LEGGINGS.get(), IcariaItems.AETERNAE_HIDE.get());
		this.leggings(1, IcariaItems.CHALKOS_LEGGINGS.get(), IcariaItems.CHALKOS_INGOT.get());
		this.leggings(1, IcariaItems.KASSITEROS_LEGGINGS.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.leggings(1, IcariaItems.ORICHALCUM_LEGGINGS.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.leggings(1, IcariaItems.VANADIUMSTEEL_LEGGINGS.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
	}

	public void pickaxe() {
		this.pickaxe(1, IcariaItems.CHERT_PICKAXE.get(), IcariaItems.CHERT.get());
		this.pickaxe(1, IcariaItems.CHALKOS_PICKAXE.get(), IcariaItems.CHALKOS_INGOT.get());
		this.pickaxe(1, IcariaItems.KASSITEROS_PICKAXE.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.pickaxe(1, IcariaItems.ORICHALCUM_PICKAXE.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.pickaxe(1, IcariaItems.VANADIUMSTEEL_PICKAXE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.pickaxe(1, IcariaItems.SIDEROS_PICKAXE.get(), IcariaItems.SIDEROS_INGOT.get());
		this.pickaxe(1, IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
	}

	public void pillarHead() {
		this.pillarHead(2, IcariaItems.DOLOMITE_PILLAR_HEAD.get(), IcariaItems.DOLOMITE_BRICKS.get(), IcariaItems.DOLOMITE_PILLAR.get());
		this.pillarHead(2, IcariaItems.RELICSTONE_PILLAR_HEAD.get(), IcariaItems.RELICSTONE_BRICKS.get(), IcariaItems.RELICSTONE_PILLAR.get());
		this.pillarHead(2, IcariaItems.QUARTZ_PILLAR_HEAD.get(), Items.QUARTZ_BRICKS, Items.QUARTZ_PILLAR);
	}

	public void rug() {
		this.rug(1, IcariaItems.BROWN_RUG.get(), IcariaItems.BROWN_ARACHNE_STRING_CARPET.get());
		this.rug(1, IcariaItems.GREEN_RUG.get(), IcariaItems.GREEN_ARACHNE_STRING_CARPET.get());
		this.rug(1, IcariaItems.ORANGE_RUG.get(), IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get());
	}

	public void scythe() {
		this.scythe(1, IcariaItems.CHERT_SCYTHE.get(), IcariaItems.CHERT.get());
		this.scythe(1, IcariaItems.CHALKOS_SCYTHE.get(), IcariaItems.CHALKOS_INGOT.get());
		this.scythe(1, IcariaItems.KASSITEROS_SCYTHE.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.scythe(1, IcariaItems.ORICHALCUM_SCYTHE.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.scythe(1, IcariaItems.VANADIUMSTEEL_SCYTHE.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.scythe(1, IcariaItems.SIDEROS_SCYTHE.get(), IcariaItems.SIDEROS_INGOT.get());
		this.scythe(1, IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
	}

	public void shovel() {
		this.shovel(1, IcariaItems.CHERT_SHOVEL.get(), IcariaItems.CHERT.get());
		this.shovel(1, IcariaItems.CHALKOS_SHOVEL.get(), IcariaItems.CHALKOS_INGOT.get());
		this.shovel(1, IcariaItems.KASSITEROS_SHOVEL.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.shovel(1, IcariaItems.ORICHALCUM_SHOVEL.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.shovel(1, IcariaItems.VANADIUMSTEEL_SHOVEL.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.shovel(1, IcariaItems.SIDEROS_SHOVEL.get(), IcariaItems.SIDEROS_INGOT.get());
		this.shovel(1, IcariaItems.MOLYBDENUMSTEEL_SHOVEL.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
	}

	public void sign() {
		this.sign(3, IcariaItems.CYPRESS_SIGN.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.sign(3, IcariaItems.DROUGHTROOT_SIGN.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.sign(3, IcariaItems.FIR_SIGN.get(), IcariaItems.FIR_PLANKS.get());
		this.sign(3, IcariaItems.LAUREL_SIGN.get(), IcariaItems.LAUREL_PLANKS.get());
		this.sign(3, IcariaItems.OLIVE_SIGN.get(), IcariaItems.OLIVE_PLANKS.get());
		this.sign(3, IcariaItems.PLANE_SIGN.get(), IcariaItems.PLANE_PLANKS.get());
		this.sign(3, IcariaItems.POPULUS_SIGN.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void stairs() {
		this.stairs(4, IcariaItems.MARL_ADOBE_STAIRS.get(), IcariaItems.MARL_ADOBE.get());
		this.stairs(4, IcariaItems.LOAM_BRICK_STAIRS.get(), IcariaItems.LOAM_BRICKS.get());
		this.stairs(4, IcariaItems.DOLOMITE_ADOBE_STAIRS.get(), IcariaItems.DOLOMITE_ADOBE.get());
		this.stairs(4, IcariaItems.SMOOTH_DOLOMITE_STAIRS.get(), IcariaItems.SMOOTH_DOLOMITE.get());
		this.stairs(4, IcariaItems.GRAINITE_ADOBE_STAIRS.get(), IcariaItems.GRAINITE_ADOBE.get());
		this.stairs(4, IcariaItems.GRAINITE_STAIRS.get(), IcariaItems.GRAINITE.get());
		this.stairs(4, IcariaItems.GRAINITE_BRICK_STAIRS.get(), IcariaItems.GRAINITE_BRICKS.get());
		this.stairs(4, IcariaItems.YELLOWSTONE_ADOBE_STAIRS.get(), IcariaItems.YELLOWSTONE_ADOBE.get());
		this.stairs(4, IcariaItems.COBBLED_YELLOWSTONE_STAIRS.get(), IcariaItems.COBBLED_YELLOWSTONE.get());
		this.stairs(4, IcariaItems.YELLOWSTONE_STAIRS.get(), IcariaItems.YELLOWSTONE.get());
		this.stairs(4, IcariaItems.YELLOWSTONE_BRICK_STAIRS.get(), IcariaItems.YELLOWSTONE_BRICKS.get());
		this.stairs(4, IcariaItems.SILKSTONE_ADOBE_STAIRS.get(), IcariaItems.SILKSTONE_ADOBE.get());
		this.stairs(4, IcariaItems.COBBLED_SILKSTONE_STAIRS.get(), IcariaItems.COBBLED_SILKSTONE.get());
		this.stairs(4, IcariaItems.SILKSTONE_STAIRS.get(), IcariaItems.SILKSTONE.get());
		this.stairs(4, IcariaItems.SILKSTONE_BRICK_STAIRS.get(), IcariaItems.SILKSTONE_BRICKS.get());
		this.stairs(4, IcariaItems.SUNSTONE_ADOBE_STAIRS.get(), IcariaItems.SUNSTONE_ADOBE.get());
		this.stairs(4, IcariaItems.COBBLED_SUNSTONE_STAIRS.get(), IcariaItems.COBBLED_SUNSTONE.get());
		this.stairs(4, IcariaItems.SUNSTONE_STAIRS.get(), IcariaItems.SUNSTONE.get());
		this.stairs(4, IcariaItems.SUNSTONE_BRICK_STAIRS.get(), IcariaItems.SUNSTONE_BRICKS.get());
		this.stairs(4, IcariaItems.VOIDSHALE_ADOBE_STAIRS.get(), IcariaItems.VOIDSHALE_ADOBE.get());
		this.stairs(4, IcariaItems.COBBLED_VOIDSHALE_STAIRS.get(), IcariaItems.COBBLED_VOIDSHALE.get());
		this.stairs(4, IcariaItems.VOIDSHALE_STAIRS.get(), IcariaItems.VOIDSHALE.get());
		this.stairs(4, IcariaItems.VOIDSHALE_BRICK_STAIRS.get(), IcariaItems.VOIDSHALE_BRICKS.get());
		this.stairs(4, IcariaItems.BAETYL_ADOBE_STAIRS.get(), IcariaItems.BAETYL_ADOBE.get());
		this.stairs(4, IcariaItems.COBBLED_BAETYL_STAIRS.get(), IcariaItems.COBBLED_BAETYL.get());
		this.stairs(4, IcariaItems.BAETYL_STAIRS.get(), IcariaItems.BAETYL.get());
		this.stairs(4, IcariaItems.BAETYL_BRICK_STAIRS.get(), IcariaItems.BAETYL_BRICKS.get());
		this.stairs(4, IcariaItems.RELICSTONE_STAIRS.get(), IcariaItems.RELICSTONE.get());
		this.stairs(4, IcariaItems.SMOOTH_RELICSTONE_STAIRS.get(), IcariaItems.SMOOTH_RELICSTONE.get());
		this.stairs(4, IcariaItems.RELICSTONE_BRICK_STAIRS.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.stairs(4, IcariaItems.CRACKED_RELICSTONE_BRICK_STAIRS.get(), IcariaItems.CRACKED_RELICSTONE_BRICKS.get());
		this.stairs(4, IcariaItems.MOSSY_RELICSTONE_BRICK_STAIRS.get(), IcariaItems.MOSSY_RELICSTONE_BRICKS.get());
		this.stairs(4, IcariaItems.RELICSTONE_TILE_STAIRS.get(), IcariaItems.RELICSTONE_TILES.get());
		this.stairs(4, IcariaItems.CRACKED_RELICSTONE_TILE_STAIRS.get(), IcariaItems.CRACKED_RELICSTONE_TILES.get());
		this.stairs(4, IcariaItems.MOSSY_RELICSTONE_TILE_STAIRS.get(), IcariaItems.MOSSY_RELICSTONE_TILES.get());
		this.stairs(4, IcariaItems.PLATOSHALE_STAIRS.get(), IcariaItems.PLATOSHALE.get());
		this.stairs(4, IcariaItems.PLATOSHALE_BRICK_STAIRS.get(), IcariaItems.PLATOSHALE_BRICKS.get());
		this.stairs(4, IcariaItems.CYPRESS_STAIRS.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.stairs(4, IcariaItems.DROUGHTROOT_STAIRS.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.stairs(4, IcariaItems.FIR_STAIRS.get(), IcariaItems.FIR_PLANKS.get());
		this.stairs(4, IcariaItems.LAUREL_STAIRS.get(), IcariaItems.LAUREL_PLANKS.get());
		this.stairs(4, IcariaItems.OLIVE_STAIRS.get(), IcariaItems.OLIVE_PLANKS.get());
		this.stairs(4, IcariaItems.PLANE_STAIRS.get(), IcariaItems.PLANE_PLANKS.get());
		this.stairs(4, IcariaItems.POPULUS_STAIRS.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void stool() {
		this.stool(1, IcariaItems.CYPRESS_STOOL.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get());
		this.stool(1, IcariaItems.DROUGHTROOT_STOOL.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get());
		this.stool(1, IcariaItems.FIR_STOOL.get(), IcariaItems.STRIPPED_FIR_WOOD.get());
		this.stool(1, IcariaItems.LAUREL_STOOL.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get());
		this.stool(1, IcariaItems.OLIVE_STOOL.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get());
		this.stool(1, IcariaItems.PLANE_STOOL.get(), IcariaItems.STRIPPED_PLANE_WOOD.get());
		this.stool(1, IcariaItems.POPULUS_STOOL.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get());
	}

	public void sword() {
		this.sword(1, IcariaItems.CHERT_SWORD.get(), IcariaItems.CHERT.get());
		this.sword(1, IcariaItems.CHALKOS_SWORD.get(), IcariaItems.CHALKOS_INGOT.get());
		this.sword(1, IcariaItems.KASSITEROS_SWORD.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.sword(1, IcariaItems.ORICHALCUM_SWORD.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.sword(1, IcariaItems.VANADIUMSTEEL_SWORD.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.sword(1, IcariaItems.SIDEROS_SWORD.get(), IcariaItems.SIDEROS_INGOT.get());
		this.sword(1, IcariaItems.MOLYBDENUMSTEEL_SWORD.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
	}

	public void torch() {
		this.torch(4, IcariaItems.LIGNITE_TORCH.get(), IcariaItems.LIGNITE.get());
		this.torch(4, IcariaItems.ANTHRACITE_TORCH.get(), IcariaItems.ANTHRACITE.get());
	}

	public void trough() {
		this.trough(1, IcariaItems.CYPRESS_TROUGH.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.trough(1, IcariaItems.DROUGHTROOT_TROUGH.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.trough(1, IcariaItems.FIR_TROUGH.get(), IcariaItems.FIR_LOG.get(), IcariaItems.FIR_PLANKS.get());
		this.trough(1, IcariaItems.LAUREL_TROUGH.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.LAUREL_PLANKS.get());
		this.trough(1, IcariaItems.OLIVE_TROUGH.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.OLIVE_PLANKS.get());
		this.trough(1, IcariaItems.PLANE_TROUGH.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.PLANE_PLANKS.get());
		this.trough(1, IcariaItems.POPULUS_TROUGH.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.POPULUS_PLANKS.get());
	}

	public void shapeless() {
		this.shapeless(1, Items.BLACK_DYE, IcariaItems.VOIDLILY.get());
		this.shapeless(1, Items.BLUE_DYE, IcariaItems.BLUE_HYDRACINTH.get());
		this.shapeless(1, Items.BLUE_DYE, IcariaItems.BLUE_STORMCOTTON.get());
		this.shapeless(1, Items.BLUE_DYE, IcariaItems.BLUE_GROUND_FLOWERS.get());
		this.shapeless(1, Items.COPPER_INGOT, IcariaItems.CALCITE_DUST.get(), IcariaItems.CHALKOS_INGOT.get());
		this.shapeless(1, Items.CYAN_DYE, IcariaItems.CYAN_GROUND_FLOWERS.get());
		this.shapeless(3, Items.FIREWORK_ROCKET, Items.PAPER, IcariaItems.GREENPOWDER.get());
		this.shapeless(1, Items.FLINT_AND_STEEL, Items.IRON_INGOT, IcariaItems.CHERT.get());
		this.shapeless(1, Items.IRON_INGOT, IcariaItems.CALCITE_DUST.get(), IcariaItems.SIDEROS_INGOT.get());
		this.shapeless(1, Items.LIGHT_BLUE_DYE, IcariaItems.CHARMONDER.get());
		this.shapeless(1, Items.LIME_DYE, IcariaItems.SPEARDROPS.get());
		this.shapeless(1, Items.ORANGE_DYE, IcariaItems.SUNSPONGE.get());
		this.shapeless(1, Items.ORANGE_DYE, IcariaItems.ORANGE_BROMELIA.get());
		this.shapeless(1, Items.PACKED_MUD, Items.MUD, IcariaItems.SPELT.get());
		this.shapeless(1, Items.PINK_DYE, IcariaItems.BLINDWEED.get());
		this.shapeless(1, Items.PINK_DYE, IcariaItems.PINK_STORMCOTTON.get());
		this.shapeless(1, Items.PINK_DYE, IcariaItems.PINK_GROUND_FLOWERS.get());
		this.shapeless(1, Items.PINK_DYE, IcariaItems.PINK_BROMELIA.get());
		this.shapeless(1, Items.PURPLE_DYE, IcariaItems.PURPLE_HYDRACINTH.get());
		this.shapeless(1, Items.PURPLE_DYE, IcariaItems.LIONFANGS.get());
		this.shapeless(1, Items.PURPLE_DYE, IcariaItems.PURPLE_STAGHORN.get());
		this.shapeless(1, Items.PURPLE_DYE, IcariaItems.PURPLE_STORMCOTTON.get());
		this.shapeless(1, Items.PURPLE_DYE, IcariaItems.PURPLE_GROUND_FLOWERS.get());
		this.shapeless(1, Items.PURPLE_DYE, IcariaItems.PURPLE_BROMELIA.get());
		this.shapeless(1, Items.RED_DYE, IcariaItems.FIREHILT.get());
		this.shapeless(1, Items.RED_DYE, IcariaItems.RED_GROUND_FLOWERS.get());
		this.shapeless(1, Items.SUGAR, IcariaItems.VINE_REED.get());
		this.shapeless(1, Items.WHITE_DYE, IcariaItems.CHAMEOMILE.get());
		this.shapeless(1, Items.WHITE_DYE, IcariaItems.CLOVER.get());
		this.shapeless(1, Items.WHITE_DYE, IcariaItems.WHITE_GROUND_FLOWERS.get());
		this.shapeless(1, Items.WHITE_DYE, IcariaItems.WHITE_BROMELIA.get());
		this.shapeless(1, Items.YELLOW_DYE, IcariaItems.YELLOW_STAGHORN.get());
		this.shapeless(1, Items.YELLOW_DYE, IcariaItems.SUNKETTLE.get());
		this.shapeless(1, IcariaItems.TRAPPED_CHEST.get(), Items.TRIPWIRE_HOOK, IcariaItems.CHEST.get());
		this.shapeless(1, IcariaItems.CYPRESS_BUTTON.get(), IcariaItems.CYPRESS_PLANKS.get());
		this.shapeless(1, IcariaItems.DROUGHTROOT_BUTTON.get(), IcariaItems.DROUGHTROOT_PLANKS.get());
		this.shapeless(1, IcariaItems.FIR_BUTTON.get(), IcariaItems.FIR_PLANKS.get());
		this.shapeless(1, IcariaItems.LAUREL_BUTTON.get(), IcariaItems.LAUREL_PLANKS.get());
		this.shapeless(1, IcariaItems.OLIVE_BUTTON.get(), IcariaItems.OLIVE_PLANKS.get());
		this.shapeless(1, IcariaItems.PLANE_BUTTON.get(), IcariaItems.PLANE_PLANKS.get());
		this.shapeless(1, IcariaItems.POPULUS_BUTTON.get(), IcariaItems.POPULUS_PLANKS.get());
		this.shapeless(1, IcariaItems.WHITE_ARACHNE_STRING_BLOCK.get(), Items.WHITE_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.LIGHT_GRAY_ARACHNE_STRING_BLOCK.get(), Items.LIGHT_GRAY_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.GRAY_ARACHNE_STRING_BLOCK.get(), Items.GRAY_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.BLACK_ARACHNE_STRING_BLOCK.get(), Items.BLACK_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.BROWN_ARACHNE_STRING_BLOCK.get(), Items.BROWN_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.RED_ARACHNE_STRING_BLOCK.get(), Items.RED_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.ORANGE_ARACHNE_STRING_BLOCK.get(), Items.ORANGE_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.YELLOW_ARACHNE_STRING_BLOCK.get(), Items.YELLOW_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.LIME_ARACHNE_STRING_BLOCK.get(), Items.LIME_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.GREEN_ARACHNE_STRING_BLOCK.get(), Items.GREEN_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.CYAN_ARACHNE_STRING_BLOCK.get(), Items.CYAN_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.LIGHT_BLUE_ARACHNE_STRING_BLOCK.get(), Items.LIGHT_BLUE_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.BLUE_ARACHNE_STRING_BLOCK.get(), Items.BLUE_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.PURPLE_ARACHNE_STRING_BLOCK.get(), Items.PURPLE_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.MAGENTA_ARACHNE_STRING_BLOCK.get(), Items.MAGENTA_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.PINK_ARACHNE_STRING_BLOCK.get(), Items.PINK_DYE, IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(1, IcariaItems.WHITE_ARACHNE_STRING_CARPET.get(), Items.WHITE_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.LIGHT_GRAY_ARACHNE_STRING_CARPET.get(), Items.LIGHT_GRAY_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.GRAY_ARACHNE_STRING_CARPET.get(), Items.GRAY_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.BLACK_ARACHNE_STRING_CARPET.get(), Items.BLACK_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.BROWN_ARACHNE_STRING_CARPET.get(), Items.BROWN_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.RED_ARACHNE_STRING_CARPET.get(), Items.RED_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.ORANGE_ARACHNE_STRING_CARPET.get(), Items.ORANGE_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.YELLOW_ARACHNE_STRING_CARPET.get(), Items.YELLOW_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.LIME_ARACHNE_STRING_CARPET.get(), Items.LIME_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.GREEN_ARACHNE_STRING_CARPET.get(), Items.GREEN_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.CYAN_ARACHNE_STRING_CARPET.get(), Items.CYAN_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.LIGHT_BLUE_ARACHNE_STRING_CARPET.get(), Items.LIGHT_BLUE_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.BLUE_ARACHNE_STRING_CARPET.get(), Items.BLUE_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.PURPLE_ARACHNE_STRING_CARPET.get(), Items.PURPLE_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.MAGENTA_ARACHNE_STRING_CARPET.get(), Items.MAGENTA_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(1, IcariaItems.PINK_ARACHNE_STRING_CARPET.get(), Items.PINK_DYE, IcariaItems.ARACHNE_STRING_CARPET.get());
		this.shapeless(4, IcariaItems.LOAM_LUMP.get(), IcariaItems.LOAM.get());
		this.shapeless(9, IcariaItems.CHERT.get(), IcariaItems.CHERT_BLOCK.get());
		this.shapeless(9, IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.ENDER_JELLYFISH_JELLY_BLOCK.get());
		this.shapeless(9, IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY_BLOCK.get());
		this.shapeless(9, IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY_BLOCK.get());
		this.shapeless(9, IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY_BLOCK.get());
		this.shapeless(9, IcariaItems.WATER_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY_BLOCK.get());
		this.shapeless(9, IcariaItems.ARACHNE_STRING.get(), IcariaItems.ARACHNE_STRING_BLOCK.get());
		this.shapeless(9, IcariaItems.SPELT.get(), IcariaItems.SPELT_BALE_BLOCK.get());
		this.shapeless(9, IcariaItems.VINE_REED.get(), IcariaItems.VINE_REED_BLOCK.get());
		this.shapeless(9, IcariaItems.ROTTEN_BONES.get(), IcariaItems.ROTTEN_BONES_BLOCK.get());
		this.shapeless(1, IcariaItems.GREENPOWDER.get(), IcariaItems.CALCITE_DUST.get(), IcariaItems.HALITE_DUST.get(), IcariaItems.LIGNITE.get());
		this.shapeless(9, IcariaItems.CALCITE_SHARD.get(), IcariaItems.CALCITE_BLOCK.get());
		this.shapeless(9, IcariaItems.HALITE_SHARD.get(), IcariaItems.HALITE_BLOCK.get());
		this.shapeless(9, IcariaItems.JASPER_SHARD.get(), IcariaItems.JASPER_BLOCK.get());
		this.shapeless(9, IcariaItems.ZIRCON_SHARD.get(), IcariaItems.ZIRCON_BLOCK.get());
		this.shapeless(9, IcariaItems.LIGNITE.get(), IcariaItems.LIGNITE_BLOCK.get());
		this.shapeless(9, IcariaItems.RAW_CHALKOS.get(), IcariaItems.RAW_CHALKOS_BLOCK.get());
		this.shapeless(9, IcariaItems.RAW_KASSITEROS.get(), IcariaItems.RAW_KASSITEROS_BLOCK.get());
		this.shapeless(9, IcariaItems.RAW_VANADIUM.get(), IcariaItems.RAW_VANADIUM_BLOCK.get());
		this.shapeless(9, IcariaItems.SLIVER.get(), IcariaItems.SLIVER_BLOCK.get());
		this.shapeless(9, IcariaItems.RAW_SIDEROS.get(), IcariaItems.RAW_SIDEROS_BLOCK.get());
		this.shapeless(9, IcariaItems.ANTHRACITE.get(), IcariaItems.ANTHRACITE_BLOCK.get());
		this.shapeless(9, IcariaItems.RAW_MOLYBDENUM.get(), IcariaItems.RAW_MOLYBDENUM_BLOCK.get());
		this.shapeless(9, IcariaItems.CHALKOS_NUGGET.get(), IcariaItems.CHALKOS_INGOT.get());
		this.shapeless(9, IcariaItems.KASSITEROS_NUGGET.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.shapeless(9, IcariaItems.ORICHALCUM_NUGGET.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.shapeless(9, IcariaItems.VANADIUM_NUGGET.get(), IcariaItems.VANADIUM_INGOT.get());
		this.shapeless(9, IcariaItems.VANADIUMSTEEL_NUGGET.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.shapeless(9, IcariaItems.SIDEROS_NUGGET.get(), IcariaItems.SIDEROS_INGOT.get());
		this.shapeless(9, IcariaItems.MOLYBDENUM_NUGGET.get(), IcariaItems.MOLYBDENUM_INGOT.get());
		this.shapeless(9, IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.shapeless(9, IcariaItems.BLURIDIUM_NUGGET.get(), IcariaItems.BLURIDIUM_INGOT.get());
		this.shapeless(9, IcariaItems.CHALKOS_INGOT.get(), IcariaItems.CHALKOS_BLOCK.get());
		this.shapeless(9, IcariaItems.KASSITEROS_INGOT.get(), IcariaItems.KASSITEROS_BLOCK.get());
		this.shapeless(9, IcariaItems.ORICHALCUM_INGOT.get(), IcariaItems.ORICHALCUM_BLOCK.get());
		this.shapeless(9, IcariaItems.VANADIUM_INGOT.get(), IcariaItems.VANADIUM_BLOCK.get());
		this.shapeless(9, IcariaItems.VANADIUMSTEEL_INGOT.get(), IcariaItems.VANADIUMSTEEL_BLOCK.get());
		this.shapeless(9, IcariaItems.SIDEROS_INGOT.get(), IcariaItems.SIDEROS_BLOCK.get());
		this.shapeless(9, IcariaItems.MOLYBDENUM_INGOT.get(), IcariaItems.MOLYBDENUM_BLOCK.get());
		this.shapeless(9, IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), IcariaItems.MOLYBDENUMSTEEL_BLOCK.get());
		this.shapeless(9, IcariaItems.BLURIDIUM_INGOT.get(), IcariaItems.BLURIDIUM_BLOCK.get());
		this.shapeless(1, IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get(), Items.WHITE_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get(), Items.LIGHT_GRAY_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get(), Items.GRAY_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get(), Items.BLACK_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get(), Items.BROWN_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.RED_UNFIRED_STORAGE_VASE.get(), Items.RED_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get(), Items.ORANGE_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get(), Items.YELLOW_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.LIME_UNFIRED_STORAGE_VASE.get(), Items.LIME_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get(), Items.GREEN_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get(), Items.CYAN_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get(), Items.LIGHT_BLUE_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get(), Items.BLUE_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get(), Items.PURPLE_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get(), Items.MAGENTA_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.PINK_UNFIRED_STORAGE_VASE.get(), Items.PINK_DYE, IcariaItems.UNFIRED_STORAGE_VASE.get());
		this.shapeless(1, IcariaItems.ANTI_GRAVITY_FLASK.get(), IcariaItems.ANTI_GRAVITY_SPELL.get(), IcariaItems.EMPTY_FLASK.get());
		this.shapeless(1, IcariaItems.FORTIFYING_FLASK.get(), IcariaItems.FORTIFYING_SPELL.get(), IcariaItems.EMPTY_FLASK.get());
		this.shapeless(1, IcariaItems.HEALING_FLASK.get(), IcariaItems.HEALING_SPELL.get(), IcariaItems.EMPTY_FLASK.get());
		this.shapeless(1, IcariaItems.DAEDALIAN_GEAR.get(), IcariaItems.BLUE_GEARFRAGMENT.get(), IcariaItems.GREEN_GEARFRAGMENT.get(), IcariaItems.YELLOW_GEARFRAGMENT.get());
		this.shapeless(1, IcariaItems.STRAWBERRY_SEEDS.get(), IcariaItems.STRAWBERRIES.get());
		this.shapeless(1, IcariaItems.PHYSALIS_SEEDS.get(), IcariaItems.PHYSALIS.get());
	}

	public void mossy() {
		this.mossy(1, IcariaItems.MOSSY_RELICSTONE_BRICKS.get(), IcariaItems.RELICSTONE_BRICKS.get());
		this.mossy(1, IcariaItems.MOSSY_RELICSTONE_TILES.get(), IcariaItems.RELICSTONE_TILES.get());
	}

	public void planks() {
		this.planks(4, IcariaItems.CYPRESS_PLANKS.get(), IcariaItems.CYPRESS_WOOD.get(), IcariaItems.STRIPPED_CYPRESS_WOOD.get(), IcariaItems.CYPRESS_LOG.get(), IcariaItems.STRIPPED_CYPRESS_LOG.get(), IcariaItems.DEAD_CYPRESS_LOG.get(), IcariaItems.STRIPPED_DEAD_CYPRESS_LOG.get());
		this.planks(4, IcariaItems.DROUGHTROOT_PLANKS.get(), IcariaItems.DROUGHTROOT_WOOD.get(), IcariaItems.STRIPPED_DROUGHTROOT_WOOD.get(), IcariaItems.DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DROUGHTROOT_LOG.get(), IcariaItems.DEAD_DROUGHTROOT_LOG.get(), IcariaItems.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		this.planks(4, IcariaItems.FIR_PLANKS.get(), IcariaItems.FIR_WOOD.get(), IcariaItems.STRIPPED_FIR_WOOD.get(), IcariaItems.FIR_LOG.get(), IcariaItems.STRIPPED_FIR_LOG.get(), IcariaItems.DEAD_FIR_LOG.get(), IcariaItems.STRIPPED_DEAD_FIR_LOG.get());
		this.planks(4, IcariaItems.LAUREL_PLANKS.get(), IcariaItems.LAUREL_WOOD.get(), IcariaItems.STRIPPED_LAUREL_WOOD.get(), IcariaItems.LAUREL_LOG.get(), IcariaItems.STRIPPED_LAUREL_LOG.get(), IcariaItems.DEAD_LAUREL_LOG.get(), IcariaItems.STRIPPED_DEAD_LAUREL_LOG.get());
		this.planks(4, IcariaItems.OLIVE_PLANKS.get(), IcariaItems.OLIVE_WOOD.get(), IcariaItems.STRIPPED_OLIVE_WOOD.get(), IcariaItems.OLIVE_LOG.get(), IcariaItems.STRIPPED_OLIVE_LOG.get(), IcariaItems.DEAD_OLIVE_LOG.get(), IcariaItems.STRIPPED_DEAD_OLIVE_LOG.get());
		this.planks(4, IcariaItems.PLANE_PLANKS.get(), IcariaItems.PLANE_WOOD.get(), IcariaItems.STRIPPED_PLANE_WOOD.get(), IcariaItems.PLANE_LOG.get(), IcariaItems.STRIPPED_PLANE_LOG.get(), IcariaItems.DEAD_PLANE_LOG.get(), IcariaItems.STRIPPED_DEAD_PLANE_LOG.get());
		this.planks(4, IcariaItems.POPULUS_PLANKS.get(), IcariaItems.POPULUS_WOOD.get(), IcariaItems.STRIPPED_POPULUS_WOOD.get(), IcariaItems.POPULUS_LOG.get(), IcariaItems.STRIPPED_POPULUS_LOG.get(), IcariaItems.DEAD_POPULUS_LOG.get(), IcariaItems.STRIPPED_DEAD_POPULUS_LOG.get());
	}

	public void stew() {
		this.stew(1, IcariaItems.AETERNAE_STEW.get(), Items.BEETROOT, IcariaItems.RAW_AETERNAE_MEAT.get());
		this.stew(1, IcariaItems.CATOBLEPAS_STEW.get(), IcariaItems.ONION.get(), IcariaItems.RAW_CATOBLEPAS_MEAT.get());
		this.stew(1, IcariaItems.CERVER_STEW.get(), Items.CARROT, IcariaItems.RAW_CERVER_MEAT.get());
	}

	public void campfireCooking(float pExperience, int pTime, Item pResult, Item pResource) {
		SimpleCookingRecipeBuilder.campfireCooking((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, pExperience, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("campfire_cooking", pResult));
	}

	public void smelting(float pExperience, int pTime, Item pResult, Item pResource) {
		SimpleCookingRecipeBuilder.smelting((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, pExperience, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("smelting", pResult));
	}

	public void smoking(float pExperience, int pTime, Item pResult, Item pResource) {
		SimpleCookingRecipeBuilder.smoking((Ingredient.of(pResource)), RecipeCategory.MISC, pResult, pExperience, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("smoking", pResult));
	}

	public void stonecutting(int pAmount, Item pResult, Item pResource) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(pResource), RecipeCategory.MISC, pResult, pAmount)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("stonecutting", pResult, pResource));
	}

	public void entityConcocting(int pColour, int pTime, EntityType<?> pEntity, Item pResourceA, Item pResourceB, Item pResourceC) {
		EntityConcoctingRecipeBuilder.entityConcocting(RecipeCategory.MISC, BuiltInRegistries.ENTITY_TYPE.getKey(pEntity).toString(), Ingredient.of(pResourceA, pResourceB, pResourceC), pColour, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.unlockedBy(this.name(pResourceC), this.has(pResourceC))
			.save(this.output, this.key("entity_concocting", pEntity));
	}

	public void entityConcocting(int pColour, int pTime, EntityType<?> pEntity, Item pResourceA, Item pResourceB) {
		EntityConcoctingRecipeBuilder.entityConcocting(RecipeCategory.MISC, BuiltInRegistries.ENTITY_TYPE.getKey(pEntity).toString(), Ingredient.of(pResourceA, pResourceB), pColour, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.save(this.output, this.key("entity_concocting", pEntity));
	}

	public void entityConcocting(int pColour, int pTime, EntityType<?> pEntity, Item pResource) {
		EntityConcoctingRecipeBuilder.entityConcocting(RecipeCategory.MISC, BuiltInRegistries.ENTITY_TYPE.getKey(pEntity).toString(), Ingredient.of(pResource), pColour, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("entity_concocting", pEntity));
	}

	public void explosionConcocting(float pRadius, int pColour, int pTime, Item pResourceA, Item pResourceB, Item pResourceC) {
		ExplosionConcoctingRecipeBuilder.explosionConcocting(RecipeCategory.MISC, Ingredient.of(pResourceA, pResourceB, pResourceC), pRadius, pColour, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.unlockedBy(this.name(pResourceC), this.has(pResourceC))
			.save(this.output, this.key("explosion_concocting", "explosion", pResourceA, pResourceB, pResourceC));
	}

	public void explosionConcocting(float pRadius, int pColour, int pTime, Item pResourceA, Item pResourceB) {
		ExplosionConcoctingRecipeBuilder.explosionConcocting(RecipeCategory.MISC, Ingredient.of(pResourceA, pResourceB), pRadius, pColour, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.save(this.output, this.key("explosion_concocting", "explosion", pResourceA, pResourceB));
	}

	public void explosionConcocting(float pRadius, int pColour, int pTime, Item pResource) {
		ExplosionConcoctingRecipeBuilder.explosionConcocting(RecipeCategory.MISC, Ingredient.of(pResource), pRadius, pColour, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("explosion_concocting", "explosion", pResource));
	}

	public void firing(float pExperience, int pAmount, int pTime, Item pResult, Item pResource) {
		FiringRecipeBuilder.firing(RecipeCategory.MISC, pResult, Ingredient.of(pResource), pExperience, pAmount, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("firing", pResult, pResource));
	}

	public void forging(float pExperience, int pAmount, int pTime, Item pResult, Item pResourceA, Item pResourceB, Item pResourceC) {
		ForgingRecipeBuilder.forging(RecipeCategory.MISC, pResult, Ingredient.of(pResourceA, pResourceB, pResourceC), pExperience, pAmount, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.unlockedBy(this.name(pResourceC), this.has(pResourceC))
			.save(this.output, this.key("forging", pResult, pResourceA, pResourceB, pResourceC));
	}

	public void forging(float pExperience, int pAmount, int pTime, Item pResult, Item pResourceA, Item pResourceB) {
		ForgingRecipeBuilder.forging(RecipeCategory.MISC, pResult, Ingredient.of(pResourceA, pResourceB), pExperience, pAmount, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.save(this.output, this.key("forging", pResult, pResourceA, pResourceB));
	}

	public void forging(float pExperience, int pAmount, int pTime, Item pResult, Item pResource) {
		ForgingRecipeBuilder.forging(RecipeCategory.MISC, pResult, Ingredient.of(pResource), pExperience, pAmount, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("forging", pResult, pResource));
	}

	public void grinding(float pExperience, int pAmount, int pTime, Item pResult, Item pResource, Item pGear) {
		GrindingRecipeBuilder.grinding(RecipeCategory.MISC, pResult, Ingredient.of(pGear), Ingredient.of(pResource), pExperience, pAmount, pTime)
			.unlockedBy(this.name(pGear), this.has(pGear))
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("grinding", pResult, pResource));
	}

	public void itemConcocting(int pAmount, int pColour, int pTime, Item pResult, Item pResourceA, Item pResourceB, Item pResourceC) {
		ItemConcoctingRecipeBuilder.itemConcocting(RecipeCategory.MISC, pResult, Ingredient.of(pResourceA, pResourceB, pResourceC), pAmount, pColour, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.unlockedBy(this.name(pResourceC), this.has(pResourceC))
			.save(this.output, this.key("item_concocting", pResult));
	}

	public void itemConcocting(int pAmount, int pColour, int pTime, Item pResult, Item pResourceA, Item pResourceB) {
		ItemConcoctingRecipeBuilder.itemConcocting(RecipeCategory.MISC, pResult, Ingredient.of(pResourceA, pResourceB), pAmount, pColour, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.save(this.output, this.key("item_concocting", pResult));
	}

	public void itemConcocting(int pAmount, int pColour, int pTime, Item pResult, Item pResource) {
		ItemConcoctingRecipeBuilder.itemConcocting(RecipeCategory.MISC, pResult, Ingredient.of(pResource), pAmount, pColour, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("item_concocting", pResult));
	}

	public void potionConcocting(float pRadius, int pDuration, int pColour, int pTime, Holder<Potion> pPotion, Item pResourceA, Item pResourceB, Item pResourceC) {
		PotionConcoctingRecipeBuilder.potionConcocting(RecipeCategory.MISC, new PotionContents(pPotion), Ingredient.of(pResourceA, pResourceB, pResourceC), pRadius, pColour, pDuration, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.unlockedBy(this.name(pResourceC), this.has(pResourceC))
			.save(this.output, this.key("potion_concocting", pPotion));
	}

	public void potionConcocting(float pRadius, int pDuration, int pColour, int pTime, Holder<Potion> pPotion, Item pResourceA, Item pResourceB) {
		PotionConcoctingRecipeBuilder.potionConcocting(RecipeCategory.MISC, new PotionContents(pPotion), Ingredient.of(pResourceA, pResourceB), pRadius, pColour, pDuration, pTime)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.save(this.output, this.key("potion_concocting", pPotion));
	}

	public void potionConcocting(float pRadius, int pDuration, int pColour, int pTime, Holder<Potion> pPotion, Item pResource) {
		PotionConcoctingRecipeBuilder.potionConcocting(RecipeCategory.MISC, new PotionContents(pPotion), Ingredient.of(pResource), pRadius, pColour, pDuration, pTime)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key("potion_concocting", pPotion));
	}

	public void shaped3x3(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AAA")
			.pattern("AAA")
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped3x2(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AAA")
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped3x1(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped2x3(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AA")
			.pattern("AA")
			.pattern("AA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped2x2(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AA")
			.pattern("AA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped2x1(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped1x3(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A")
			.pattern("A")
			.pattern("A")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped1x2(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A")
			.pattern("A")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void shaped1x1(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void adobe(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', IcariaItems.SPELT.get())
			.define('C', IcariaItems.LOAM_LUMP.get())
			.pattern("BCB")
			.pattern("CAC")
			.pattern("BCB")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(IcariaItems.SPELT.get()), this.has(IcariaItems.SPELT.get()))
			.unlockedBy(this.name(IcariaItems.LOAM_LUMP.get()), this.has(IcariaItems.LOAM_LUMP.get()))
			.save(this.output, this.key(pResult));
	}

	public void axe(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern("AA ")
			.pattern("AB ")
			.pattern(" B ")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void bathtub(int pAmount, Item pResult, Item pLog, Item pPlanks) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pLog)
			.define('B', pPlanks)
			.pattern("B B")
			.pattern("B B")
			.pattern("AAA")
			.unlockedBy(this.name(pLog), this.has(pLog))
			.unlockedBy(this.name(pPlanks), this.has(pPlanks))
			.save(this.output, this.key(pResult));
	}

	public void bident(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern("A A")
			.pattern(" B ")
			.pattern(" B ")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void boots(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A A")
			.pattern("A A")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void bowl(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A A")
			.pattern(" A ")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void cake(int pAmount, Item pResult, Item pJelly, Item pFruit) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pJelly)
			.define('B', pFruit)
			.define('C', Items.MILK_BUCKET)
			.define('D', Items.SUGAR)
			.define('E', IcariaItems.SPELT_FLOUR.get())
			.pattern("ABA")
			.pattern("DCD")
			.pattern("EEE")
			.unlockedBy(this.name(pJelly), this.has(pJelly))
			.unlockedBy(this.name(pFruit), this.has(pFruit))
			.unlockedBy(this.name(Items.MILK_BUCKET), this.has(Items.MILK_BUCKET))
			.unlockedBy(this.name(Items.SUGAR), this.has(Items.SUGAR))
			.unlockedBy(this.name(IcariaItems.SPELT_FLOUR.get()), this.has(IcariaItems.SPELT_FLOUR.get()))
			.save(this.output, this.key(pResult));
	}

	public void carpet(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void centerFilled(int pAmount, Item pResult, Item pResource, Item pCenter) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', pCenter)
			.pattern("AAA")
			.pattern("ABA")
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(pCenter), this.has(pCenter))
			.save(this.output, this.key(pResult));
	}

	public void centerHollow(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AAA")
			.pattern("A A")
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void chestplate(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A A")
			.pattern("AAA")
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void dagger(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern("A")
			.pattern("B")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void fence(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.STICK)
			.pattern("ABA")
			.pattern("ABA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.STICK), this.has(Items.STICK))
			.save(this.output, this.key(pResult));
	}

	public void fenceGate(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.STICK)
			.pattern("BAB")
			.pattern("BAB")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.STICK), this.has(Items.STICK))
			.save(this.output, this.key(pResult));
	}

	public void gear(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern(" A ")
			.pattern("A A")
			.pattern(" A ")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void hangingSign(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', IcariaItems.VANADIUMSTEEL_CHAIN.get())
			.pattern("B B")
			.pattern("AAA")
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(IcariaItems.VANADIUMSTEEL_CHAIN.get()), this.has(IcariaItems.VANADIUMSTEEL_CHAIN.get()))
			.save(this.output, this.key(pResult));
	}

	public void harness(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', IcariaItems.AETERNAE_HIDE.get())
			.define('B', Items.GLASS)
			.define('C', pResource)
			.pattern("AAA")
			.pattern("BCB")
			.unlockedBy(this.name(IcariaItems.AETERNAE_HIDE.get()), this.has(IcariaItems.AETERNAE_HIDE.get()))
			.unlockedBy(this.name(Items.GLASS), this.has(Items.GLASS))
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void helmet(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AAA")
			.pattern("A A")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void ladder(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A A")
			.pattern("AAA")
			.pattern("A A")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void leggings(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("AAA")
			.pattern("A A")
			.pattern("A A")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void pickaxe(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern("AAA")
			.pattern(" B ")
			.pattern(" B ")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void pillarHead(int pAmount, Item pResult, Item pBricks, Item pPillar) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pBricks)
			.define('B', pPillar)
			.pattern("A")
			.pattern("B")
			.unlockedBy(this.name(pBricks), this.has(pBricks))
			.unlockedBy(this.name(pPillar), this.has(pPillar))
			.save(this.output, this.key(pResult));
	}

	public void rug(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', IcariaItems.ARACHNE_STRING.get())
			.define('B', pResource)
			.pattern("ABA")
			.pattern("BAB")
			.pattern("ABA")
			.unlockedBy(this.name(IcariaItems.ARACHNE_STRING.get()), this.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void scythe(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern(" AA")
			.pattern("A B")
			.pattern("  B")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void shovel(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern("A")
			.pattern("B")
			.pattern("B")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void sign(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.STICK)
			.pattern("AAA")
			.pattern("AAA")
			.pattern(" B ")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.STICK), this.has(Items.STICK))
			.save(this.output, this.key(pResult));
	}

	public void stairs(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.pattern("A  ")
			.pattern("AA ")
			.pattern("AAA")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void stool(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', IcariaItems.ARACHNE_STRING_BLOCK.get())
			.define('B', IcariaItems.ARACHNE_STRING_CARPET.get())
			.define('C', pResource)
			.pattern("ABA")
			.pattern(" C ")
			.pattern("C C")
			.unlockedBy(this.name(IcariaItems.ARACHNE_STRING_BLOCK.get()), this.has(IcariaItems.ARACHNE_STRING_BLOCK.get()))
			.unlockedBy(this.name(IcariaItems.ARACHNE_STRING_CARPET.get()), this.has(IcariaItems.ARACHNE_STRING_CARPET.get()))
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult));
	}

	public void sword(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern("A")
			.pattern("A")
			.pattern("B")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void torch(int pAmount, Item pResult, Item pResource) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pResource)
			.define('B', Items.BONE)
			.pattern("A")
			.pattern("B")
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.BONE), this.has(Items.BONE))
			.save(this.output, this.key(pResult));
	}

	public void trough(int pAmount, Item pResult, Item pLog, Item pPlanks) {
		this.shaped(RecipeCategory.MISC, pResult, pAmount)
			.define('A', pLog)
			.define('B', pPlanks)
			.pattern("B B")
			.pattern("AAA")
			.unlockedBy(this.name(pLog), this.has(pLog))
			.unlockedBy(this.name(pPlanks), this.has(pPlanks))
			.save(this.output, this.key(pResult));
	}

	public void arrow() {
		this.shaped(RecipeCategory.MISC, Items.ARROW, 4)
			.define('A', Items.FEATHER)
			.define('B', Items.STICK)
			.define('C', IcariaItems.CHERT.get())
			.pattern("C")
			.pattern("B")
			.pattern("A")
			.unlockedBy(this.name(Items.FEATHER), this.has(Items.FEATHER))
			.unlockedBy(this.name(Items.STICK), this.has(Items.STICK))
			.unlockedBy(this.name(IcariaItems.CHERT.get()), this.has(IcariaItems.CHERT.get()))
			.save(this.output, this.key(Items.ARROW));
	}

	public void bundle() {
		this.shaped(RecipeCategory.MISC, Items.BUNDLE, 1)
			.define('A', Tags.Items.STRINGS)
			.define('B', IcariaItems.AETERNAE_HIDE.get())
			.pattern("A")
			.pattern("B")
			.unlockedBy(this.name(Tags.Items.STRINGS), this.has(Tags.Items.STRINGS))
			.unlockedBy(this.name(IcariaItems.AETERNAE_HIDE.get()), this.has(IcariaItems.AETERNAE_HIDE.get()))
			.save(this.output, this.key(Items.BUNDLE));
	}

	public void coarseMarl() {
		this.shaped(RecipeCategory.MISC, IcariaItems.COARSE_MARL.get(), 4)
			.define('A', IcariaItems.MARL.get())
			.define('B', IcariaItems.GRAINEL.get())
			.pattern("BA")
			.pattern("AB")
			.unlockedBy(this.name(IcariaItems.MARL.get()), this.has(IcariaItems.MARL.get()))
			.unlockedBy(this.name(IcariaItems.GRAINEL.get()), this.has(IcariaItems.GRAINEL.get()))
			.save(this.output, this.key(IcariaItems.COARSE_MARL.get()));
	}

	public void comparator() {
		this.shaped(RecipeCategory.MISC, Items.COMPARATOR, 1)
			.define('A', Items.QUARTZ)
			.define('B', Items.REDSTONE_TORCH)
			.define('C', IcariaItems.SMOOTH_RELICSTONE.get())
			.pattern(" B ")
			.pattern("BAB")
			.pattern("CCC")
			.unlockedBy(this.name(Items.QUARTZ), this.has(Items.QUARTZ))
			.unlockedBy(this.name(Items.REDSTONE_TORCH), this.has(Items.REDSTONE_TORCH))
			.unlockedBy(this.name(IcariaItems.SMOOTH_RELICSTONE.get()), this.has(IcariaItems.SMOOTH_RELICSTONE.get()))
			.save(this.output, this.key(Items.COMPARATOR));
	}

	public void crafter() {
		this.shaped(RecipeCategory.MISC, Items.CRAFTER, 1)
			.define('A', Items.DROPPER)
			.define('B', Items.IRON_INGOT)
			.define('C', Items.REDSTONE)
			.define('D', Ingredient.of(IcariaItems.CYPRESS_CRAFTING_TABLE.get(), IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get(), IcariaItems.FIR_CRAFTING_TABLE.get(), IcariaItems.LAUREL_CRAFTING_TABLE.get(), IcariaItems.OLIVE_CRAFTING_TABLE.get(), IcariaItems.PLANE_CRAFTING_TABLE.get(), IcariaItems.POPULUS_CRAFTING_TABLE.get()))
			.pattern("BBB")
			.pattern("BDB")
			.pattern("CAC")
			.unlockedBy(this.name(Items.DROPPER), this.has(Items.DROPPER))
			.unlockedBy(this.name(Items.IRON_INGOT), this.has(Items.IRON_INGOT))
			.unlockedBy(this.name(Items.REDSTONE), this.has(Items.REDSTONE))
			.unlockedBy(this.name(IcariaItems.CYPRESS_CRAFTING_TABLE.get()), this.has(IcariaItems.CYPRESS_CRAFTING_TABLE.get()))
			.unlockedBy(this.name(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get()), this.has(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get()))
			.unlockedBy(this.name(IcariaItems.FIR_CRAFTING_TABLE.get()), this.has(IcariaItems.FIR_CRAFTING_TABLE.get()))
			.unlockedBy(this.name(IcariaItems.LAUREL_CRAFTING_TABLE.get()), this.has(IcariaItems.LAUREL_CRAFTING_TABLE.get()))
			.unlockedBy(this.name(IcariaItems.OLIVE_CRAFTING_TABLE.get()), this.has(IcariaItems.OLIVE_CRAFTING_TABLE.get()))
			.unlockedBy(this.name(IcariaItems.PLANE_CRAFTING_TABLE.get()), this.has(IcariaItems.PLANE_CRAFTING_TABLE.get()))
			.unlockedBy(this.name(IcariaItems.POPULUS_CRAFTING_TABLE.get()), this.has(IcariaItems.POPULUS_CRAFTING_TABLE.get()))
			.save(this.output, this.key(Items.CRAFTER));
	}

	public void fletchingTable() {
		this.shaped(RecipeCategory.MISC, Items.FLETCHING_TABLE, 1)
			.define('A', ItemTags.PLANKS)
			.define('B', IcariaItems.CHERT.get())
			.pattern("BB")
			.pattern("AA")
			.pattern("AA")
			.unlockedBy(this.name(ItemTags.PLANKS), this.has(ItemTags.PLANKS))
			.unlockedBy(this.name(IcariaItems.CHERT.get()), this.has(IcariaItems.CHERT.get()))
			.save(this.output, this.key(Items.FLETCHING_TABLE));
	}

	public void forge() {
		this.shaped(RecipeCategory.MISC, IcariaItems.FORGE.get(), 1)
			.define('A', IcariaItems.LOAM_BRICKS.get())
			.define('B', IcariaItems.GRAINITE_BRICKS.get())
			.pattern("BAB")
			.pattern("B B")
			.pattern("BAB")
			.unlockedBy(this.name(IcariaItems.LOAM_BRICKS.get()), this.has(IcariaItems.LOAM_BRICKS.get()))
			.unlockedBy(this.name(IcariaItems.GRAINITE_BRICKS.get()), this.has(IcariaItems.GRAINITE_BRICKS.get()))
			.save(this.output, this.key(IcariaItems.FORGE.get()));
	}

	public void greekFireGrenade() {
		this.shaped(RecipeCategory.MISC, IcariaItems.GREEK_FIRE_GRENADE.get(), 1)
			.define('A', IcariaItems.ARACHNE_STRING.get())
			.define('B', IcariaItems.GREENPOWDER.get())
			.define('C', IcariaItems.KASSITEROS_NUGGET.get())
			.pattern(" A ")
			.pattern("CCC")
			.pattern("BBB")
			.unlockedBy(this.name(IcariaItems.ARACHNE_STRING.get()), this.has(IcariaItems.ARACHNE_STRING.get()))
			.unlockedBy(this.name(IcariaItems.GREENPOWDER.get()), this.has(IcariaItems.GREENPOWDER.get()))
			.unlockedBy(this.name(IcariaItems.KASSITEROS_NUGGET.get()), this.has(IcariaItems.KASSITEROS_NUGGET.get()))
			.save(this.output, this.key(IcariaItems.GREEK_FIRE_GRENADE.get()));
	}

	public void grindstone() {
		this.shaped(RecipeCategory.MISC, Items.GRINDSTONE, 1)
			.define('A', Items.STICK)
			.define('B', ItemTags.PLANKS)
			.define('C', IcariaItems.SMOOTH_RELICSTONE_SLAB.get())
			.pattern("ACA")
			.pattern("B B")
			.unlockedBy(this.name(Items.STICK), this.has(Items.STICK))
			.unlockedBy(this.name(ItemTags.PLANKS), this.has(ItemTags.PLANKS))
			.unlockedBy(this.name(IcariaItems.SMOOTH_RELICSTONE_SLAB.get()), this.has(IcariaItems.SMOOTH_RELICSTONE_SLAB.get()))
			.save(this.output, this.key(Items.GRINDSTONE));
	}

	public void kettle() {
		this.shaped(RecipeCategory.MISC, IcariaItems.KETTLE.get(), 1)
			.define('A', IcariaItems.ORICHALCUM_INGOT.get())
			.define('B', IcariaItems.VANADIUMSTEEL_BLOCK.get())
			.pattern("A A")
			.pattern("B B")
			.pattern("ABA")
			.unlockedBy(this.name(IcariaItems.ORICHALCUM_INGOT.get()), this.has(IcariaItems.ORICHALCUM_INGOT.get()))
			.unlockedBy(this.name(IcariaItems.VANADIUMSTEEL_BLOCK.get()), this.has(IcariaItems.VANADIUMSTEEL_BLOCK.get()))
			.save(this.output, this.key(IcariaItems.KETTLE.get()));
	}

	public void repeater() {
		this.shaped(RecipeCategory.MISC, Items.REPEATER, 1)
			.define('A', Items.REDSTONE)
			.define('B', Items.REDSTONE_TORCH)
			.define('C', IcariaItems.SMOOTH_RELICSTONE.get())
			.pattern("BAB")
			.pattern("CCC")
			.unlockedBy(this.name(Items.REDSTONE), this.has(Items.REDSTONE))
			.unlockedBy(this.name(Items.REDSTONE_TORCH), this.has(Items.REDSTONE_TORCH))
			.unlockedBy(this.name(IcariaItems.SMOOTH_RELICSTONE.get()), this.has(IcariaItems.SMOOTH_RELICSTONE.get()))
			.save(this.output, this.key(Items.REPEATER));
	}

	public void saddle() {
		this.shaped(RecipeCategory.MISC, Items.SADDLE, 1)
			.define('A', IcariaItems.AETERNAE_HIDE.get())
			.define('B', Items.IRON_INGOT)
			.pattern(" A ")
			.pattern("ABA")
			.unlockedBy(this.name(IcariaItems.AETERNAE_HIDE.get()), this.has(IcariaItems.AETERNAE_HIDE.get()))
			.unlockedBy(this.name(Items.IRON_INGOT), this.has(Items.IRON_INGOT))
			.save(this.output, this.key(Items.SADDLE));
	}

	public void stickyPiston() {
		this.shaped(RecipeCategory.MISC, Items.STICKY_PISTON, 1)
			.define('A', Items.PISTON)
			.define('B', Ingredient.of(IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.pattern("B")
			.pattern("A")
			.unlockedBy(this.name(Items.PISTON), this.has(Items.PISTON))
			.unlockedBy(this.name(IcariaItems.ENDER_JELLYFISH_JELLY.get()), this.has(IcariaItems.ENDER_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.FIRE_JELLYFISH_JELLY.get()), this.has(IcariaItems.FIRE_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.NATURE_JELLYFISH_JELLY.get()), this.has(IcariaItems.NATURE_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.VOID_JELLYFISH_JELLY.get()), this.has(IcariaItems.VOID_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.WATER_JELLYFISH_JELLY.get()), this.has(IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.save(this.output, this.key(Items.STICKY_PISTON));
	}

	public void stonecutter() {
		this.shaped(RecipeCategory.MISC, Items.STONECUTTER, 1)
			.define('A', Items.IRON_INGOT)
			.define('B', IcariaItems.SMOOTH_RELICSTONE.get())
			.pattern(" A ")
			.pattern("BBB")
			.unlockedBy(this.name(Items.IRON_INGOT), this.has(Items.IRON_INGOT))
			.unlockedBy(this.name(IcariaItems.SMOOTH_RELICSTONE.get()), this.has(IcariaItems.SMOOTH_RELICSTONE.get()))
			.save(this.output, this.key(Items.STONECUTTER));
	}

	public void target() {
		this.shaped(RecipeCategory.MISC, Items.TARGET, 1)
			.define('A', Items.REDSTONE)
			.define('B', IcariaItems.SPELT_BALE_BLOCK.get())
			.pattern(" A ")
			.pattern("ABA")
			.pattern(" A ")
			.unlockedBy(this.name(Items.REDSTONE), this.has(Items.REDSTONE))
			.unlockedBy(this.name(IcariaItems.SPELT_BALE_BLOCK.get()), this.has(IcariaItems.SPELT_BALE_BLOCK.get()))
			.save(this.output, this.key(Items.TARGET));
	}

	public void tnt() {
		this.shaped(RecipeCategory.MISC, Items.TNT, 1)
			.define('A', Ingredient.of(Items.RED_SAND, Items.SAND))
			.define('B', IcariaItems.GREENPOWDER.get())
			.pattern("BAB")
			.pattern("ABA")
			.pattern("BAB")
			.unlockedBy(this.name(Items.RED_SAND), this.has(Items.RED_SAND))
			.unlockedBy(this.name(Items.SAND), this.has(Items.SAND))
			.unlockedBy(this.name(IcariaItems.GREENPOWDER.get()), this.has(IcariaItems.GREENPOWDER.get()))
			.save(this.output, this.key(Items.TNT));
	}

	public void vanadiumsteelChain() {
		this.shaped(RecipeCategory.MISC, IcariaItems.VANADIUMSTEEL_CHAIN.get(), 1)
			.define('A', IcariaItems.VANADIUMSTEEL_NUGGET.get())
			.define('B', IcariaItems.VANADIUMSTEEL_INGOT.get())
			.pattern("A")
			.pattern("B")
			.pattern("A")
			.unlockedBy(this.name(IcariaItems.VANADIUMSTEEL_NUGGET.get()), this.has(IcariaItems.VANADIUMSTEEL_NUGGET.get()))
			.unlockedBy(this.name(IcariaItems.VANADIUMSTEEL_INGOT.get()), this.has(IcariaItems.VANADIUMSTEEL_INGOT.get()))
			.save(this.output, this.key(IcariaItems.VANADIUMSTEEL_CHAIN.get()));
	}

	public void shapeless(int pAmount, Item pResult, Item pResourceA, Item pResourceB, Item pResourceC) {
		this.shapeless(RecipeCategory.MISC, pResult, pAmount)
			.requires(pResourceA)
			.requires(pResourceB)
			.requires(pResourceC)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.unlockedBy(this.name(pResourceC), this.has(pResourceC))
			.save(this.output, this.key(pResult, pResourceA, pResourceB, pResourceC));
	}

	public void shapeless(int pAmount, Item pResult, Item pResourceA, Item pResourceB) {
		this.shapeless(RecipeCategory.MISC, pResult, pAmount)
			.requires(pResourceA)
			.requires(pResourceB)
			.unlockedBy(this.name(pResourceA), this.has(pResourceA))
			.unlockedBy(this.name(pResourceB), this.has(pResourceB))
			.save(this.output, this.key(pResult, pResourceA, pResourceB));
	}

	public void shapeless(int pAmount, Item pResult, Item pResource) {
		this.shapeless(RecipeCategory.MISC, pResult, pAmount)
			.requires(pResource)
			.unlockedBy(this.name(pResource), this.has(pResource))
			.save(this.output, this.key(pResult, pResource));
	}

	public void mossy(int pAmount, Item pResult, Item pResource) {
		this.shapeless(RecipeCategory.MISC, pResult, pAmount)
			.requires(pResource)
			.requires(Ingredient.of(Items.MOSS_BLOCK, Items.VINE, IcariaItems.BLOOMY_VINE.get(), IcariaItems.BRANCHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.DRY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.SWIRLY_VINE.get(), IcariaItems.THORNY_VINE.get()))
			.unlockedBy(this.name(pResource), this.has(pResource))
			.unlockedBy(this.name(Items.MOSS_BLOCK), this.has(Items.MOSS_BLOCK))
			.unlockedBy(this.name(Items.VINE), this.has(Items.VINE))
			.unlockedBy(this.name(IcariaItems.BLOOMY_VINE.get()), this.has(IcariaItems.BLOOMY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.BRANCHY_VINE.get()), this.has(IcariaItems.BRANCHY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.BRUSHY_VINE.get()), this.has(IcariaItems.BRUSHY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.DRY_VINE.get()), this.has(IcariaItems.DRY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.REEDY_VINE.get()), this.has(IcariaItems.REEDY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.SWIRLY_VINE.get()), this.has(IcariaItems.SWIRLY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.THORNY_VINE.get()), this.has(IcariaItems.THORNY_VINE.get()))
			.save(this.output, this.key(pResult));
	}

	public void planks(int pAmount, Item pResult, Item pWood, Item pStrippedWood, Item pLog, Item pStrippedLog, Item pDeadLog, Item pStrippedDeadLog) {
		this.shapeless(RecipeCategory.MISC, pResult, pAmount)
			.requires(Ingredient.of(pWood, pStrippedWood, pLog, pStrippedLog, pDeadLog, pStrippedDeadLog))
			.unlockedBy(this.name(pWood), this.has(pWood))
			.unlockedBy(this.name(pStrippedWood), this.has(pStrippedWood))
			.unlockedBy(this.name(pLog), this.has(pLog))
			.unlockedBy(this.name(pStrippedLog), this.has(pStrippedLog))
			.unlockedBy(this.name(pDeadLog), this.has(pDeadLog))
			.unlockedBy(this.name(pStrippedDeadLog), this.has(pStrippedDeadLog))
			.save(this.output, this.key(pResult));
	}

	public void stew(int pAmount, Item pResult, Item pVegetable, Item pMeat) {
		this.shapeless(RecipeCategory.MISC, pResult, pAmount)
			.requires(pVegetable)
			.requires(pMeat)
			.requires(IcariaItems.HALITE_DUST.get())
			.requires(IcariaItems.LOAM_BOWL.get())
			.unlockedBy(this.name(pVegetable), this.has(pVegetable))
			.unlockedBy(this.name(pMeat), this.has(pMeat))
			.unlockedBy(this.name(IcariaItems.HALITE_DUST.get()), this.has(IcariaItems.HALITE_DUST.get()))
			.unlockedBy(this.name(IcariaItems.LOAM_BOWL.get()), this.has(IcariaItems.LOAM_BOWL.get()))
			.save(this.output, this.key(pResult));
	}

	public void book() {
		this.shapeless(RecipeCategory.MISC, Items.BOOK, 1)
			.requires(Items.PAPER, 3)
			.requires(IcariaItems.AETERNAE_HIDE.get())
			.unlockedBy(this.name(Items.PAPER), this.has(Items.PAPER))
			.unlockedBy(this.name(IcariaItems.AETERNAE_HIDE.get()), this.has(IcariaItems.AETERNAE_HIDE.get()))
			.save(this.output, this.key(Items.BOOK));
	}

	public void fireCharge() {
		this.shapeless(RecipeCategory.MISC, Items.FIRE_CHARGE, 3)
			.requires(Items.BLAZE_POWDER)
			.requires(Ingredient.of(Items.CHARCOAL, Items.COAL))
			.requires(IcariaItems.GREENPOWDER.get())
			.unlockedBy(this.name(Items.BLAZE_POWDER), this.has(Items.BLAZE_POWDER))
			.unlockedBy(this.name(Items.CHARCOAL), this.has(Items.CHARCOAL))
			.unlockedBy(this.name(Items.COAL), this.has(Items.COAL))
			.unlockedBy(this.name(IcariaItems.GREENPOWDER.get()), this.has(IcariaItems.GREENPOWDER.get()))
			.save(this.output, this.key(Items.FIRE_CHARGE));
	}

	public void fruitSalad() {
		this.shapeless(RecipeCategory.MISC, IcariaItems.FRUIT_SALAD.get(), 1)
			.requires(Items.SUGAR)
			.requires(IcariaItems.VINEBERRIES.get())
			.requires(IcariaItems.STRAWBERRIES.get())
			.requires(IcariaItems.PHYSALIS.get())
			.requires(IcariaItems.LAUREL_CHERRY.get())
			.requires(IcariaItems.LOAM_BOWL.get())
			.unlockedBy(this.name(Items.SUGAR), this.has(Items.SUGAR))
			.unlockedBy(this.name(IcariaItems.VINEBERRIES.get()), this.has(IcariaItems.VINEBERRIES.get()))
			.unlockedBy(this.name(IcariaItems.STRAWBERRIES.get()), this.has(IcariaItems.STRAWBERRIES.get()))
			.unlockedBy(this.name(IcariaItems.PHYSALIS.get()), this.has(IcariaItems.PHYSALIS.get()))
			.unlockedBy(this.name(IcariaItems.LAUREL_CHERRY.get()), this.has(IcariaItems.LAUREL_CHERRY.get()))
			.unlockedBy(this.name(IcariaItems.LOAM_BOWL.get()), this.has(IcariaItems.LOAM_BOWL.get()))
			.save(this.output, this.key(IcariaItems.FRUIT_SALAD.get()));
	}

	public void magmaCream() {
		this.shapeless(RecipeCategory.MISC, Items.MAGMA_CREAM, 1)
			.requires(Items.BLAZE_POWDER)
			.requires(Ingredient.of(IcariaItems.ENDER_JELLYFISH_JELLY.get(), IcariaItems.FIRE_JELLYFISH_JELLY.get(), IcariaItems.NATURE_JELLYFISH_JELLY.get(), IcariaItems.VOID_JELLYFISH_JELLY.get(), IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(Items.BLAZE_POWDER), this.has(Items.BLAZE_POWDER))
			.unlockedBy(this.name(IcariaItems.ENDER_JELLYFISH_JELLY.get()), this.has(IcariaItems.ENDER_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.FIRE_JELLYFISH_JELLY.get()), this.has(IcariaItems.FIRE_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.NATURE_JELLYFISH_JELLY.get()), this.has(IcariaItems.NATURE_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.VOID_JELLYFISH_JELLY.get()), this.has(IcariaItems.VOID_JELLYFISH_JELLY.get()))
			.unlockedBy(this.name(IcariaItems.WATER_JELLYFISH_JELLY.get()), this.has(IcariaItems.WATER_JELLYFISH_JELLY.get()))
			.save(this.output, this.key(Items.MAGMA_CREAM));
	}

	public void mossyCobblestone() {
		this.shapeless(RecipeCategory.MISC, Items.MOSSY_COBBLESTONE, 1)
			.requires(Items.COBBLESTONE)
			.requires(Ingredient.of(IcariaItems.BLOOMY_VINE.get(), IcariaItems.BRANCHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.DRY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.SWIRLY_VINE.get(), IcariaItems.THORNY_VINE.get()))
			.unlockedBy(this.name(Items.COBBLESTONE), this.has(Items.COBBLESTONE))
			.unlockedBy(this.name(IcariaItems.BLOOMY_VINE.get()), this.has(IcariaItems.BLOOMY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.BRANCHY_VINE.get()), this.has(IcariaItems.BRANCHY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.BRUSHY_VINE.get()), this.has(IcariaItems.BRUSHY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.DRY_VINE.get()), this.has(IcariaItems.DRY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.REEDY_VINE.get()), this.has(IcariaItems.REEDY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.SWIRLY_VINE.get()), this.has(IcariaItems.SWIRLY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.THORNY_VINE.get()), this.has(IcariaItems.THORNY_VINE.get()))
			.save(this.output, this.key(Items.MOSSY_COBBLESTONE));
	}

	public void mossyStoneBricks() {
		this.shapeless(RecipeCategory.MISC, Items.MOSSY_STONE_BRICKS, 1)
			.requires(Items.STONE_BRICKS)
			.requires(Ingredient.of(IcariaItems.BLOOMY_VINE.get(), IcariaItems.BRANCHY_VINE.get(), IcariaItems.BRUSHY_VINE.get(), IcariaItems.DRY_VINE.get(), IcariaItems.REEDY_VINE.get(), IcariaItems.SWIRLY_VINE.get(), IcariaItems.THORNY_VINE.get()))
			.unlockedBy(this.name(Items.STONE_BRICKS), this.has(Items.STONE_BRICKS))
			.unlockedBy(this.name(IcariaItems.BLOOMY_VINE.get()), this.has(IcariaItems.BLOOMY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.BRANCHY_VINE.get()), this.has(IcariaItems.BRANCHY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.BRUSHY_VINE.get()), this.has(IcariaItems.BRUSHY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.DRY_VINE.get()), this.has(IcariaItems.DRY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.REEDY_VINE.get()), this.has(IcariaItems.REEDY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.SWIRLY_VINE.get()), this.has(IcariaItems.SWIRLY_VINE.get()))
			.unlockedBy(this.name(IcariaItems.THORNY_VINE.get()), this.has(IcariaItems.THORNY_VINE.get()))
			.save(this.output, this.key(Items.MOSSY_STONE_BRICKS));
	}

	public void onionSoup() {
		this.shapeless(RecipeCategory.MISC, IcariaItems.ONION_SOUP.get(), 1)
			.requires(IcariaItems.HALITE_DUST.get())
			.requires(IcariaItems.ONION.get(), 3)
			.requires(IcariaItems.LOAM_BOWL.get())
			.unlockedBy(this.name(IcariaItems.HALITE_DUST.get()), this.has(IcariaItems.HALITE_DUST.get()))
			.unlockedBy(this.name(IcariaItems.ONION.get()), this.has(IcariaItems.ONION.get()))
			.unlockedBy(this.name(IcariaItems.LOAM_BOWL.get()), this.has(IcariaItems.LOAM_BOWL.get()))
			.save(this.output, this.key(IcariaItems.ONION_SOUP.get()));
	}

	public void thogStew() {
		this.shapeless(RecipeCategory.MISC, IcariaItems.THOG_STEW.get(), 1)
			.requires(Tags.Items.MUSHROOMS)
			.requires(IcariaItems.HALITE_DUST.get())
			.requires(IcariaItems.RAW_THOG_MEAT.get())
			.requires(IcariaItems.LOAM_BOWL.get())
			.unlockedBy(this.name(Tags.Items.MUSHROOMS), this.has(Tags.Items.MUSHROOMS))
			.unlockedBy(this.name(IcariaItems.HALITE_DUST.get()), this.has(IcariaItems.HALITE_DUST.get()))
			.unlockedBy(this.name(IcariaItems.RAW_THOG_MEAT.get()), this.has(IcariaItems.RAW_THOG_MEAT.get()))
			.unlockedBy(this.name(IcariaItems.LOAM_BOWL.get()), this.has(IcariaItems.LOAM_BOWL.get()))
			.save(this.output, this.key(IcariaItems.THOG_STEW.get()));
	}

	public ResourceKey<Recipe<?>> key(Item pResult, Item pResourceA, Item pResourceB, Item pResourceC) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceC).getPath()));
	}

	public ResourceKey<Recipe<?>> key(Item pResult, Item pResourceA, Item pResourceB) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath()));
	}

	public ResourceKey<Recipe<?>> key(Item pResult, Item pResource) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResource).getPath()));
	}

	public ResourceKey<Recipe<?>> key(Item pResult) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath()));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, EntityType<?> pResult, Item pResourceA, Item pResourceB, Item pResourceC) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ENTITY_TYPE.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceC).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, EntityType<?> pResult, Item pResourceA, Item pResourceB) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ENTITY_TYPE.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, EntityType<?> pResult, Item pResource) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ENTITY_TYPE.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResource).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, EntityType<?> pResult) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ENTITY_TYPE.getKey(pResult).getPath() + "_" + "from" + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, String pResult, Item pResourceA, Item pResourceB, Item pResourceC) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pResult + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceC).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, String pResult, Item pResourceA, Item pResourceB) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pResult + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, String pResult, Item pResource) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pResult + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResource).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, String pResult) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pResult + "_" + "from" + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Item pResult, Item pResourceA, Item pResourceB, Item pResourceC) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceC).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Item pResult, Item pResourceA, Item pResourceB) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Item pResult, Item pResource) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResource).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Item pResult) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Holder<Potion> pPotion, Item pResourceA, Item pResourceB, Item pResourceC) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.POTION.getKey(pPotion.value()).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceC).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Holder<Potion> pPotion, Item pResourceA, Item pResourceB) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.POTION.getKey(pPotion.value()).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResourceA).getPath() + "_" + BuiltInRegistries.ITEM.getKey(pResourceB).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Holder<Potion> pPotion, Item pResource) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.POTION.getKey(pPotion.value()).getPath() + "_" + "from" + "_" + BuiltInRegistries.ITEM.getKey(pResource).getPath() + "_" + pFrom));
	}

	public ResourceKey<Recipe<?>> key(String pFrom, Holder<Potion> pPotion) {
		return ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.POTION.getKey(pPotion.value()).getPath() + "_" + "from" + "_" + pFrom));
	}

	public String name(Item pItem) {
		return "has" + "_" + pItem;
	}

	public String name(TagKey<Item> pTagKey) {
		return "has" + "_" + pTagKey;
	}
}
