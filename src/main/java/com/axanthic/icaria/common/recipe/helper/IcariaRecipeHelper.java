package com.axanthic.icaria.common.recipe.helper;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaRecipeHelper {

	public static List<Ingredient> helper(Ingredient... ingredients) {
		var list = new ArrayList<Ingredient>();
		for (var ingredient : ingredients) {
			if (!ingredient.isEmpty()) {
				list.add(ingredient);
			}
		}

		return list;
	}
}
