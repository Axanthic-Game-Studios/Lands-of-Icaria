package com.axanthic.icaria.integration;

import com.axanthic.icaria.common.recipe.FiringRecipe;
import com.axanthic.icaria.common.recipe.ForgingRecipe;
import com.axanthic.icaria.common.recipe.GrindingRecipe;
import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.integration.jei.category.FiringRecipeCategory;
import com.axanthic.icaria.integration.jei.category.ForgingRecipeCategory;
import com.axanthic.icaria.integration.jei.category.GrinderRecipeCategory;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

@JeiPlugin
public class JeiIntegration implements IModPlugin {
	public static final RecipeType<FiringRecipe> FIRING = RecipeType.create(IcariaIdents.ID, "firing", FiringRecipe.class);
	public static final RecipeType<ForgingRecipe> FORGING = RecipeType.create(IcariaIdents.ID, "forging", ForgingRecipe.class);
	public static final RecipeType<GrindingRecipe> GRINDING = RecipeType.create(IcariaIdents.ID, "grinding", GrindingRecipe.class);

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new FiringRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new ForgingRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
		registry.addRecipeCategories(new GrinderRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration pRegistration) {
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.CYPRESS_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.DROUGHTROOT_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.FIR_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.LAUREL_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.OLIVE_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.PLANE_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.POPULUS_CRAFTING_TABLE.get()), RecipeTypes.CRAFTING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.KILN.get()), JeiIntegration.FIRING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.FORGE.get()), JeiIntegration.FORGING);
		pRegistration.addRecipeCatalyst(new ItemStack(IcariaItems.GRINDER.get()), JeiIntegration.GRINDING);
	}

	@Override
	public void registerRecipes(IRecipeRegistration pRegistration) {
		ClientLevel clientLevel = Minecraft.getInstance().level;
		RecipeManager recipeManager = null;
		if (clientLevel != null) {
			recipeManager = clientLevel.getRecipeManager();
		}

		List<FiringRecipe> firingRecipes = List.of();
		List<ForgingRecipe> forgingRecipes = List.of();
		List<GrindingRecipe> grindingRecipes = List.of();
		if (recipeManager != null) {
			firingRecipes = recipeManager.getAllRecipesFor(IcariaRecipeTypes.FIRING.get()).stream().map(RecipeHolder::value).toList();
			forgingRecipes = recipeManager.getAllRecipesFor(IcariaRecipeTypes.FORGING.get()).stream().map(RecipeHolder::value).toList();
			grindingRecipes = recipeManager.getAllRecipesFor(IcariaRecipeTypes.GRINDING.get()).stream().map(RecipeHolder::value).toList();
		}

		pRegistration.addRecipes(JeiIntegration.FIRING, firingRecipes);
		pRegistration.addRecipes(JeiIntegration.FORGING, forgingRecipes);
		pRegistration.addRecipes(JeiIntegration.GRINDING, grindingRecipes);

		this.anvilRecipes(pRegistration, IcariaItems.CHERT_TOOLS.sword.get(), IcariaItems.CHERT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHERT_TOOLS.dagger.get(), IcariaItems.CHERT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHERT_TOOLS.shovel.get(), IcariaItems.CHERT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHERT_TOOLS.pickaxe.get(), IcariaItems.CHERT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHERT_TOOLS.axe.get(), IcariaItems.CHERT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHERT_TOOLS.scythe.get(), IcariaItems.CHERT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHERT_TOOLS.bident.get(), IcariaItems.CHERT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_TOOLS.sword.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_TOOLS.dagger.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_TOOLS.shovel.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_TOOLS.pickaxe.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_TOOLS.axe.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_TOOLS.scythe.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_TOOLS.bident.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_TOOLS.sword.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_TOOLS.dagger.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_TOOLS.shovel.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_TOOLS.pickaxe.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_TOOLS.axe.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_TOOLS.scythe.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_TOOLS.bident.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_TOOLS.sword.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_TOOLS.dagger.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_TOOLS.shovel.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_TOOLS.pickaxe.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_TOOLS.axe.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_TOOLS.scythe.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_TOOLS.bident.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_TOOLS.sword.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_TOOLS.axe.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_TOOLS.bident.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.SIDEROS_TOOLS.sword.get(), IcariaItems.SIDEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.SIDEROS_TOOLS.dagger.get(), IcariaItems.SIDEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.SIDEROS_TOOLS.shovel.get(), IcariaItems.SIDEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.SIDEROS_TOOLS.pickaxe.get(), IcariaItems.SIDEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.SIDEROS_TOOLS.axe.get(), IcariaItems.SIDEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.SIDEROS_TOOLS.scythe.get(), IcariaItems.SIDEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.SIDEROS_TOOLS.bident.get(), IcariaItems.SIDEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get(), IcariaItems.MOLYBDENUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get(), IcariaItems.AETERNAE_HIDE.get());
		this.anvilRecipes(pRegistration, IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get(), IcariaItems.AETERNAE_HIDE.get());
		this.anvilRecipes(pRegistration, IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get(), IcariaItems.AETERNAE_HIDE.get());
		this.anvilRecipes(pRegistration, IcariaItems.AETERNAE_HIDE_ARMOR.boots.get(), IcariaItems.AETERNAE_HIDE.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_ARMOR.helmet.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_ARMOR.chestplate.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_ARMOR.leggings.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.CHALKOS_ARMOR.boots.get(), IcariaItems.CHALKOS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_ARMOR.helmet.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_ARMOR.chestplate.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_ARMOR.leggings.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.KASSITEROS_ARMOR.boots.get(), IcariaItems.KASSITEROS_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_ARMOR.helmet.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_ARMOR.chestplate.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_ARMOR.leggings.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.ORICHALCUM_ARMOR.boots.get(), IcariaItems.ORICHALCUM_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.VANADIUMSTEEL_ARMOR.boots.get(), IcariaItems.VANADIUMSTEEL_INGOT.get());
		this.anvilRecipes(pRegistration, IcariaItems.TOTEM_OF_STUFFING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
		this.anvilRecipes(pRegistration, IcariaItems.TOTEM_OF_UNBLINDING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
		this.anvilRecipes(pRegistration, IcariaItems.TOTEM_OF_UNDROWNING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
		this.anvilRecipes(pRegistration, IcariaItems.TOTEM_OF_UNSHATTERING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
		this.anvilRecipes(pRegistration, IcariaItems.TOTEM_OF_UNSINKING.get(), IcariaItems.BLURIDIUM_NUGGET.get());
	}

	public void anvilRecipes(IRecipeRegistration pRegistration, Item pItemDamaged, Item pItemRepair) {
		var factory = pRegistration.getVanillaRecipeFactory();

		var damagedThreeQuarter = new ItemStack(pItemDamaged);
		var damagedHalf = new ItemStack(pItemDamaged);
		var damaged = new ItemStack(pItemDamaged);

		var repair = new ItemStack(pItemRepair);

		damagedThreeQuarter.setDamageValue(damagedThreeQuarter.getMaxDamage() / 4 * 3);
		damagedHalf.setDamageValue(damagedHalf.getMaxDamage() / 4 * 2);
		damaged.setDamageValue(damaged.getMaxDamage());

		pRegistration.addRecipes(RecipeTypes.ANVIL, List.of(factory.createAnvilRecipe(List.of(damagedThreeQuarter), List.of(damagedThreeQuarter), List.of(damagedHalf))));
		pRegistration.addRecipes(RecipeTypes.ANVIL, List.of(factory.createAnvilRecipe(List.of(damaged), List.of(repair), List.of(damagedThreeQuarter))));
	}

	@Override
	public ResourceLocation getPluginUid() {
		return IcariaResourceLocations.ICARIA;
	}
}
