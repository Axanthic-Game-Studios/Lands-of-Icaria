package com.axanthic.icaria.compat;

import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.recipe.ForgingRecipe;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.recipe.category.FiringRecipeCategory;
import com.axanthic.icaria.common.recipe.category.ForgingRecipeCategory;
import com.axanthic.icaria.common.recipe.category.GrindingRecipeCategory;
import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.data.provider.tags.IcariaItemTagsProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.List;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.common.Internal;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@JeiPlugin
public class JeiCompat implements IModPlugin {
	public static final Supplier<IRecipeHolderType<FiringRecipe>> FIRING = IRecipeHolderType.createDeferred(IcariaRecipeTypes.FIRING);
	public static final Supplier<IRecipeHolderType<ForgingRecipe>> FORGING = IRecipeHolderType.createDeferred(IcariaRecipeTypes.FORGING);
	public static final Supplier<IRecipeHolderType<GrindingRecipe>> GRINDING = IRecipeHolderType.createDeferred(IcariaRecipeTypes.GRINDING);

	@Override
	public void registerCategories(IRecipeCategoryRegistration pRegistration) {
		var guiHelper = pRegistration.getJeiHelpers().getGuiHelper();
		pRegistration.addRecipeCategories(new FiringRecipeCategory(Component.translatable("category" + "." + IcariaKeys.ID + "." + "firing"), guiHelper.createDrawableItemLike(IcariaItems.KILN.get()), guiHelper, JeiCompat.FIRING.get()));
		pRegistration.addRecipeCategories(new ForgingRecipeCategory(Component.translatable("category" + "." + IcariaKeys.ID + "." + "forging"), guiHelper.createDrawableItemLike(IcariaItems.FORGE.get()), guiHelper, JeiCompat.FORGING.get()));
		pRegistration.addRecipeCategories(new GrindingRecipeCategory(Component.translatable("category" + "." + IcariaKeys.ID + "." + "grinding"), guiHelper.createDrawableItemLike(IcariaItems.GRINDER.get()), guiHelper, JeiCompat.GRINDING.get()));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration pRegistration) {
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.CYPRESS_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.FIR_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.LAUREL_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.OLIVE_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.PLANE_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(RecipeTypes.CRAFTING, IcariaItems.POPULUS_CRAFTING_TABLE.get());
		pRegistration.addCraftingStation(JeiCompat.FIRING.get(), IcariaItems.KILN.get());
		pRegistration.addCraftingStation(JeiCompat.FORGING.get(), IcariaItems.FORGE.get());
		pRegistration.addCraftingStation(JeiCompat.GRINDING.get(), IcariaItems.GRINDER.get());
	}

	@Override
	public void registerRecipes(IRecipeRegistration pRegistration) {
		var recipeMap = Internal.getClientSyncedRecipes();

		var firingRecipes = recipeMap.byType(IcariaRecipeTypes.FIRING.get()).stream().toList();
		var forgingRecipes = recipeMap.byType(IcariaRecipeTypes.FORGING.get()).stream().toList();
		var grindingRecipes = recipeMap.byType(IcariaRecipeTypes.GRINDING.get()).stream().toList();

		pRegistration.addRecipes(IRecipeType.create(IcariaRecipeTypes.FIRING.get()), firingRecipes);
		pRegistration.addRecipes(IRecipeType.create(IcariaRecipeTypes.FORGING.get()), forgingRecipes);
		pRegistration.addRecipes(IRecipeType.create(IcariaRecipeTypes.GRINDING.get()), grindingRecipes);

		this.combining(pRegistration);
		this.repairing(pRegistration);
	}

	public void combining(IRecipeRegistration pRegistration) {
		this.combining(pRegistration, IcariaItems.CHERT_SWORD.get());
		this.combining(pRegistration, IcariaItems.CHERT_DAGGER.get());
		this.combining(pRegistration, IcariaItems.CHERT_SHOVEL.get());
		this.combining(pRegistration, IcariaItems.CHERT_PICKAXE.get());
		this.combining(pRegistration, IcariaItems.CHERT_AXE.get());
		this.combining(pRegistration, IcariaItems.CHERT_SCYTHE.get());
		this.combining(pRegistration, IcariaItems.CHERT_BIDENT.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_SWORD.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_DAGGER.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_SHOVEL.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_PICKAXE.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_AXE.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_SCYTHE.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_BIDENT.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_SWORD.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_DAGGER.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_SHOVEL.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_PICKAXE.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_AXE.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_SCYTHE.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_BIDENT.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_SWORD.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_DAGGER.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_SHOVEL.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_PICKAXE.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_AXE.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_SCYTHE.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_BIDENT.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_SWORD.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_DAGGER.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_SHOVEL.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_PICKAXE.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_AXE.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_SCYTHE.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_BIDENT.get());
		this.combining(pRegistration, IcariaItems.SIDEROS_SWORD.get());
		this.combining(pRegistration, IcariaItems.SIDEROS_DAGGER.get());
		this.combining(pRegistration, IcariaItems.SIDEROS_SHOVEL.get());
		this.combining(pRegistration, IcariaItems.SIDEROS_PICKAXE.get());
		this.combining(pRegistration, IcariaItems.SIDEROS_AXE.get());
		this.combining(pRegistration, IcariaItems.SIDEROS_SCYTHE.get());
		this.combining(pRegistration, IcariaItems.SIDEROS_BIDENT.get());
		this.combining(pRegistration, IcariaItems.MOLYBDENUMSTEEL_SWORD.get());
		this.combining(pRegistration, IcariaItems.MOLYBDENUMSTEEL_DAGGER.get());
		this.combining(pRegistration, IcariaItems.MOLYBDENUMSTEEL_SHOVEL.get());
		this.combining(pRegistration, IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get());
		this.combining(pRegistration, IcariaItems.MOLYBDENUMSTEEL_AXE.get());
		this.combining(pRegistration, IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get());
		this.combining(pRegistration, IcariaItems.MOLYBDENUMSTEEL_BIDENT.get());
		this.combining(pRegistration, IcariaItems.AETERNAE_HIDE_HELMET.get());
		this.combining(pRegistration, IcariaItems.AETERNAE_HIDE_CHESTPLATE.get());
		this.combining(pRegistration, IcariaItems.AETERNAE_HIDE_LEGGINGS.get());
		this.combining(pRegistration, IcariaItems.AETERNAE_HIDE_BOOTS.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_HELMET.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_CHESTPLATE.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_LEGGINGS.get());
		this.combining(pRegistration, IcariaItems.CHALKOS_BOOTS.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_HELMET.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_CHESTPLATE.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_LEGGINGS.get());
		this.combining(pRegistration, IcariaItems.KASSITEROS_BOOTS.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_HELMET.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_CHESTPLATE.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_LEGGINGS.get());
		this.combining(pRegistration, IcariaItems.ORICHALCUM_BOOTS.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_HELMET.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_CHESTPLATE.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_LEGGINGS.get());
		this.combining(pRegistration, IcariaItems.VANADIUMSTEEL_BOOTS.get());
		this.combining(pRegistration, IcariaItems.LAUREL_WREATH.get());
		this.combining(pRegistration, IcariaItems.TOTEM_OF_STUFFING.get());
		this.combining(pRegistration, IcariaItems.TOTEM_OF_UNBLINDING.get());
		this.combining(pRegistration, IcariaItems.TOTEM_OF_UNDROWNING.get());
		this.combining(pRegistration, IcariaItems.TOTEM_OF_UNDYING.get());
		this.combining(pRegistration, IcariaItems.TOTEM_OF_UNSHATTERING.get());
		this.combining(pRegistration, IcariaItems.TOTEM_OF_UNSINKING.get());
		this.combining(pRegistration, IcariaItems.YELLOWSTONE_GEAR.get());
		this.combining(pRegistration, IcariaItems.LOAM_GEAR.get());
		this.combining(pRegistration, IcariaItems.VOIDSHALE_GEAR.get());
		this.combining(pRegistration, IcariaItems.VANADIUM_GEAR.get());
		this.combining(pRegistration, IcariaItems.VINE_SPROUT.get());
	}

	public void repairing(IRecipeRegistration pRegistration) {
		this.repairing(pRegistration, IcariaItems.CHERT_SWORD.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
		this.repairing(pRegistration, IcariaItems.CHERT_DAGGER.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
		this.repairing(pRegistration, IcariaItems.CHERT_SHOVEL.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
		this.repairing(pRegistration, IcariaItems.CHERT_PICKAXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
		this.repairing(pRegistration, IcariaItems.CHERT_AXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
		this.repairing(pRegistration, IcariaItems.CHERT_SCYTHE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
		this.repairing(pRegistration, IcariaItems.CHERT_BIDENT.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHERT);
		this.repairing(pRegistration, IcariaItems.CHALKOS_SWORD.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
		this.repairing(pRegistration, IcariaItems.CHALKOS_DAGGER.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
		this.repairing(pRegistration, IcariaItems.CHALKOS_SHOVEL.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
		this.repairing(pRegistration, IcariaItems.CHALKOS_PICKAXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
		this.repairing(pRegistration, IcariaItems.CHALKOS_AXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
		this.repairing(pRegistration, IcariaItems.CHALKOS_SCYTHE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
		this.repairing(pRegistration, IcariaItems.CHALKOS_BIDENT.get(), IcariaItemTagsProvider.TOOL_MATERIALS_CHALKOS);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_SWORD.get(), IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_DAGGER.get(), IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_SHOVEL.get(), IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_PICKAXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_AXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_SCYTHE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_BIDENT.get(), IcariaItemTagsProvider.TOOL_MATERIALS_KASSITEROS);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_SWORD.get(), IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_DAGGER.get(), IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_SHOVEL.get(), IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_PICKAXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_AXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_SCYTHE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_BIDENT.get(), IcariaItemTagsProvider.TOOL_MATERIALS_ORICHALCUM);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_SWORD.get(), IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_DAGGER.get(), IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_SHOVEL.get(), IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_PICKAXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_AXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_SCYTHE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_BIDENT.get(), IcariaItemTagsProvider.TOOL_MATERIALS_VANADIUMSTEEL);
		this.repairing(pRegistration, IcariaItems.SIDEROS_SWORD.get(), IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
		this.repairing(pRegistration, IcariaItems.SIDEROS_DAGGER.get(), IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
		this.repairing(pRegistration, IcariaItems.SIDEROS_SHOVEL.get(), IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
		this.repairing(pRegistration, IcariaItems.SIDEROS_PICKAXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
		this.repairing(pRegistration, IcariaItems.SIDEROS_AXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
		this.repairing(pRegistration, IcariaItems.SIDEROS_SCYTHE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
		this.repairing(pRegistration, IcariaItems.SIDEROS_BIDENT.get(), IcariaItemTagsProvider.TOOL_MATERIALS_SIDEROS);
		this.repairing(pRegistration, IcariaItems.MOLYBDENUMSTEEL_SWORD.get(), IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
		this.repairing(pRegistration, IcariaItems.MOLYBDENUMSTEEL_DAGGER.get(), IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
		this.repairing(pRegistration, IcariaItems.MOLYBDENUMSTEEL_SHOVEL.get(), IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
		this.repairing(pRegistration, IcariaItems.MOLYBDENUMSTEEL_PICKAXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
		this.repairing(pRegistration, IcariaItems.MOLYBDENUMSTEEL_AXE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
		this.repairing(pRegistration, IcariaItems.MOLYBDENUMSTEEL_SCYTHE.get(), IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
		this.repairing(pRegistration, IcariaItems.MOLYBDENUMSTEEL_BIDENT.get(), IcariaItemTagsProvider.TOOL_MATERIALS_MOLYBDENUMSTEEL);
		this.repairing(pRegistration, IcariaItems.AETERNAE_HIDE_HELMET.get(), IcariaItemTagsProvider.REPAIRS_AETERNAE_HIDE_ARMOR);
		this.repairing(pRegistration, IcariaItems.AETERNAE_HIDE_CHESTPLATE.get(), IcariaItemTagsProvider.REPAIRS_AETERNAE_HIDE_ARMOR);
		this.repairing(pRegistration, IcariaItems.AETERNAE_HIDE_LEGGINGS.get(), IcariaItemTagsProvider.REPAIRS_AETERNAE_HIDE_ARMOR);
		this.repairing(pRegistration, IcariaItems.AETERNAE_HIDE_BOOTS.get(), IcariaItemTagsProvider.REPAIRS_AETERNAE_HIDE_ARMOR);
		this.repairing(pRegistration, IcariaItems.CHALKOS_HELMET.get(), IcariaItemTagsProvider.REPAIRS_CHALKOS_ARMOR);
		this.repairing(pRegistration, IcariaItems.CHALKOS_CHESTPLATE.get(), IcariaItemTagsProvider.REPAIRS_CHALKOS_ARMOR);
		this.repairing(pRegistration, IcariaItems.CHALKOS_LEGGINGS.get(), IcariaItemTagsProvider.REPAIRS_CHALKOS_ARMOR);
		this.repairing(pRegistration, IcariaItems.CHALKOS_BOOTS.get(), IcariaItemTagsProvider.REPAIRS_CHALKOS_ARMOR);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_HELMET.get(), IcariaItemTagsProvider.REPAIRS_KASSITEROS_ARMOR);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_CHESTPLATE.get(), IcariaItemTagsProvider.REPAIRS_KASSITEROS_ARMOR);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_LEGGINGS.get(), IcariaItemTagsProvider.REPAIRS_KASSITEROS_ARMOR);
		this.repairing(pRegistration, IcariaItems.KASSITEROS_BOOTS.get(), IcariaItemTagsProvider.REPAIRS_KASSITEROS_ARMOR);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_HELMET.get(), IcariaItemTagsProvider.REPAIRS_ORICHALCUM_ARMOR);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_CHESTPLATE.get(), IcariaItemTagsProvider.REPAIRS_ORICHALCUM_ARMOR);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_LEGGINGS.get(), IcariaItemTagsProvider.REPAIRS_ORICHALCUM_ARMOR);
		this.repairing(pRegistration, IcariaItems.ORICHALCUM_BOOTS.get(), IcariaItemTagsProvider.REPAIRS_ORICHALCUM_ARMOR);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_HELMET.get(), IcariaItemTagsProvider.REPAIRS_VANADIUMSTEEL_ARMOR);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_CHESTPLATE.get(), IcariaItemTagsProvider.REPAIRS_VANADIUMSTEEL_ARMOR);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_LEGGINGS.get(), IcariaItemTagsProvider.REPAIRS_VANADIUMSTEEL_ARMOR);
		this.repairing(pRegistration, IcariaItems.VANADIUMSTEEL_BOOTS.get(), IcariaItemTagsProvider.REPAIRS_VANADIUMSTEEL_ARMOR);
		this.repairing(pRegistration, IcariaItems.LAUREL_WREATH.get(), IcariaItemTagsProvider.REPAIRS_LAUREL_WREATH);
		this.repairing(pRegistration, IcariaItems.TOTEM_OF_STUFFING.get(), IcariaItemTagsProvider.REPAIRS_TOTEM);
		this.repairing(pRegistration, IcariaItems.TOTEM_OF_UNBLINDING.get(), IcariaItemTagsProvider.REPAIRS_TOTEM);
		this.repairing(pRegistration, IcariaItems.TOTEM_OF_UNDROWNING.get(), IcariaItemTagsProvider.REPAIRS_TOTEM);
		this.repairing(pRegistration, IcariaItems.TOTEM_OF_UNDYING.get(), IcariaItemTagsProvider.REPAIRS_TOTEM);
		this.repairing(pRegistration, IcariaItems.TOTEM_OF_UNSHATTERING.get(), IcariaItemTagsProvider.REPAIRS_TOTEM);
		this.repairing(pRegistration, IcariaItems.TOTEM_OF_UNSINKING.get(), IcariaItemTagsProvider.REPAIRS_TOTEM);
		this.repairing(pRegistration, IcariaItems.YELLOWSTONE_GEAR.get(), IcariaItemTagsProvider.REPAIRS_YELLOWSTONE_GEAR);
		this.repairing(pRegistration, IcariaItems.LOAM_GEAR.get(), IcariaItemTagsProvider.REPAIRS_LOAM_GEAR);
		this.repairing(pRegistration, IcariaItems.VOIDSHALE_GEAR.get(), IcariaItemTagsProvider.REPAIRS_VOIDSHALE_GEAR);
		this.repairing(pRegistration, IcariaItems.VANADIUM_GEAR.get(), IcariaItemTagsProvider.REPAIRS_VANADIUM_GEAR);
		this.repairing(pRegistration, IcariaItems.VINE_SPROUT.get(), IcariaItemTagsProvider.REPAIRS_VINE_SPROUT);
	}

	public void combining(IRecipeRegistration pRegistration, Item pItem) {
		var factory = pRegistration.getVanillaRecipeFactory();

		var damagedThreeQuarter = new ItemStack(pItem);
		var damagedHalf = new ItemStack(pItem);
		var damaged = new ItemStack(pItem);

		damagedThreeQuarter.setDamageValue(damagedThreeQuarter.getMaxDamage() / 4 * 3);
		damagedHalf.setDamageValue(damagedHalf.getMaxDamage() / 4 * 2);
		damaged.setDamageValue(damaged.getMaxDamage());

		pRegistration.addRecipes(RecipeTypes.ANVIL, List.of(factory.createAnvilRecipe(List.of(damagedThreeQuarter), List.of(damagedThreeQuarter), List.of(damagedHalf), this.name("anvil_combining", pItem))));
	}

	public void repairing(IRecipeRegistration pRegistration, Item pItem, TagKey<Item> pTagKey) {
		var factory = pRegistration.getVanillaRecipeFactory();

		var damagedThreeQuarter = new ItemStack(pItem);
		var damagedHalf = new ItemStack(pItem);
		var damaged = new ItemStack(pItem);

		damagedThreeQuarter.setDamageValue(damagedThreeQuarter.getMaxDamage() / 4 * 3);
		damagedHalf.setDamageValue(damagedHalf.getMaxDamage() / 4 * 2);
		damaged.setDamageValue(damaged.getMaxDamage());

		for (var holder : BuiltInRegistries.ITEM.getTagOrEmpty(pTagKey)) {
			var repair = new ItemStack(holder);
			pRegistration.addRecipes(RecipeTypes.ANVIL, List.of(factory.createAnvilRecipe(List.of(damaged), List.of(repair), List.of(damagedThreeQuarter), this.name("anvil_repairing", pItem))));
		}
	}

	@Override
	public Identifier getPluginUid() {
		return IcariaIdentifiers.ICARIA;
	}

	public Identifier name(String pFrom, Item pResult) {
		return Identifier.fromNamespaceAndPath(IcariaKeys.ID, BuiltInRegistries.ITEM.getKey(pResult).getPath() + "_" + "from" + "_" + pFrom);
	}
}
