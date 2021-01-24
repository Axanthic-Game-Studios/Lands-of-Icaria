package com.axanthic.loi.compatibility.jei;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.axanthic.loi.LOIConfig;
import com.axanthic.loi.Resources;
import com.axanthic.loi.gui.GuiCustomCrafting;
import com.axanthic.loi.gui.GuiInventoryForge;
import com.axanthic.loi.gui.GuiInventoryGrinder;
import com.axanthic.loi.gui.GuiInventoryKiln;
import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.ForgeRecipe;
import com.axanthic.loi.utils.GrinderFuel;
import com.axanthic.loi.utils.GrinderRecipe;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@JEIPlugin
public class IcariaPlugin implements IModPlugin {

	@Override
	public void register(IModRegistry registry) {
		if (!LOIConfig.compat.jei)
			return;

		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(Resources.renderAddon, 1, OreDictionary.WILDCARD_VALUE));
		registry.getJeiHelpers().getIngredientBlacklist().addIngredientToBlacklist(new ItemStack(Resources.saltedFood, 1, OreDictionary.WILDCARD_VALUE));

		List<IRecipeWrapper> saltRecipe = new ArrayList<IRecipeWrapper>();
		saltRecipe.add(new SaltRecipeWrapper());
		registry.addRecipes(saltRecipe, VanillaRecipeCategoryUid.CRAFTING);

		registry.handleRecipes(GrinderRecipe.class, GrinderRecipeWrapper::new, "landsoficaria.grinding");
		registry.handleRecipes(GrinderFuel.class, GrinderFuelWrapper::new, "landsoficaria.grindfuel");
		registry.handleRecipes(ForgeRecipe.class, ForgeRecipeWrapper::new, "landsoficaria.alloying");

		registry.addRecipeCatalyst(new ItemStack(Resources.kiln), VanillaRecipeCategoryUid.SMELTING, VanillaRecipeCategoryUid.FUEL);
		registry.addRecipeCatalyst(new ItemStack(Resources.forge), VanillaRecipeCategoryUid.SMELTING, VanillaRecipeCategoryUid.FUEL);

		//registry.addRecipeCatalyst(new ItemStack(Resources.plane.workbench), VanillaRecipeCategoryUid.CRAFTING);
		//registry.addRecipeCatalyst(new ItemStack(Resources.populus.workbench), VanillaRecipeCategoryUid.CRAFTING);
		//registry.addRecipeCatalyst(new ItemStack(Resources.cypress.workbench), VanillaRecipeCategoryUid.CRAFTING);
		//registry.addRecipeCatalyst(new ItemStack(Resources.fir.workbench), VanillaRecipeCategoryUid.CRAFTING);
		//registry.addRecipeCatalyst(new ItemStack(Resources.olive.workbench), VanillaRecipeCategoryUid.CRAFTING);
		registry.addRecipeCatalyst(new ItemStack(Resources.laurel.workbench), VanillaRecipeCategoryUid.CRAFTING);
		//registry.addRecipeCatalyst(new ItemStack(Resources.droughtroot.workbench), VanillaRecipeCategoryUid.CRAFTING);

		registry.addRecipeCatalyst(new ItemStack(Resources.grinder), "landsoficaria.grinding");
		registry.addRecipeCatalyst(new ItemStack(Resources.grinder), "landsoficaria.grindfuel");
		registry.addRecipeCatalyst(new ItemStack(Resources.forge), "landsoficaria.alloying");
		//registry.addRecipeCatalyst(new ItemStack(Resources.kettle), "landsoficaria.brewing");

		registry.addRecipes((Collection<GrinderRecipe>) CommonProxy.grinderRecipeRegistry.getValuesCollection(), "landsoficaria.grinding");
		registry.addRecipes((Collection<GrinderFuel>) CommonProxy.grinderFuelRegistry.getValuesCollection(), "landsoficaria.grindfuel");
		registry.addRecipes((Collection<ForgeRecipe>) CommonProxy.forgeRecipeRegistry.getValuesCollection(), "landsoficaria.alloying");

		registry.addRecipeClickArea(GuiCustomCrafting.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);
		registry.addRecipeClickArea(GuiInventoryKiln.class, 77, 34, 30, 17, VanillaRecipeCategoryUid.SMELTING);
		registry.addRecipeClickArea(GuiInventoryKiln.class, 56, 35, 16, 16, VanillaRecipeCategoryUid.FUEL);
		registry.addRecipeClickArea(GuiInventoryGrinder.class, 53, 16, 33, 18, "landsoficaria.grinding");
		registry.addRecipeClickArea(GuiInventoryGrinder.class, 116, 17, 21, 34, "landsoficaria.grindfuel");
		registry.addRecipeClickArea(GuiInventoryForge.class, 73, 34, 34, 21, "landsoficaria.alloying", VanillaRecipeCategoryUid.SMELTING);
		registry.addRecipeClickArea(GuiInventoryForge.class, 56, 35, 16, 16, VanillaRecipeCategoryUid.FUEL);
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		if (LOIConfig.compat.jei)
			registry.addRecipeCategories(
					new GrinderRecipeCategory(registry.getJeiHelpers().getGuiHelper()),
					new GrinderFuelCategory(registry.getJeiHelpers().getGuiHelper()),
					new ForgeAlloyingCategory(registry.getJeiHelpers().getGuiHelper())
					);
	}
}
