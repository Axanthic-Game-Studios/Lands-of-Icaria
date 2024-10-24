package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.recipe.ConcoctingItemRecipe;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScrollItem extends Item {
	public ConcoctingItemRecipe recipe;

	public ScrollItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
		var recipe = pLevel.getRecipeManager().byKey(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(this).getPath().replace("scroll", "") + "spell_from_concocting"));
		if (recipe.isPresent() && recipe.get().value() instanceof ConcoctingItemRecipe itemRecipe) {
			this.setRecipe(itemRecipe);
		}
	}

	public void setRecipe(ConcoctingItemRecipe pRecipe) {
		this.recipe = pRecipe;
	}

	public ConcoctingItemRecipe getRecipe() {
		return this.recipe;
	}
}
