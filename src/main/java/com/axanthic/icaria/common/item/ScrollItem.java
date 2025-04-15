package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.recipe.ItemConcoctingRecipe;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ScrollItem extends Item {
	public ItemConcoctingRecipe recipe;

	public ScrollItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public void inventoryTick(ItemStack pItemStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
		if (pLevel instanceof ServerLevel serverLevel) {
			var optional = serverLevel.recipeAccess().byKey(ResourceKey.create(Registries.RECIPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, BuiltInRegistries.ITEM.getKey(this).getPath().replace("scroll", "") + "spell" + "_" + "from" + "_" + "item_concocting")));
			if (optional.isPresent() && optional.get().value() instanceof ItemConcoctingRecipe itemConcoctingRecipe) {
				this.setRecipe(itemConcoctingRecipe);
			}
		}
	}

	public void setRecipe(ItemConcoctingRecipe pRecipe) {
		this.recipe = pRecipe;
	}

	public ItemConcoctingRecipe getRecipe() {
		return this.recipe;
	}
}
