package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PotionConcoctingRecipe implements Recipe<RecipeInput> {
	public float radius;

	public int colour;
	public int duration;
	public int time;

	public Ingredient ingredient;

	public PotionContents potion;

	public PotionConcoctingRecipe(float pRadius, int pColour, int pDuration, int pTime, Ingredient pIngredient, PotionContents pPotion) {
		this.radius = pRadius;
		this.colour = pColour;
		this.duration = pDuration;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.potion = pPotion;
	}

	@Override
	public boolean matches(RecipeInput pRecipeInput, Level pLevel) {
		return this.ingredient().getValues().size() < 3 ? this.ingredient().getValues().size() < 2 ? this.matchesSingle(pRecipeInput) : this.matchesDouble(pRecipeInput) : this.matchesTriple(pRecipeInput);
	}

	public boolean matchesSingle(RecipeInput pRecipeInput) {
		return this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && pRecipeInput.getItem(1).isEmpty() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesDouble(RecipeInput pRecipeInput) {
		return this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && pRecipeInput.getItem(2).isEmpty();
	}

	public boolean matchesTriple(RecipeInput pRecipeInput) {
		return this.ingredient().getValues().get(0).value() == pRecipeInput.getItem(0).getItem() && this.ingredient().getValues().get(1).value() == pRecipeInput.getItem(1).getItem() && this.ingredient().getValues().get(2).value() == pRecipeInput.getItem(2).getItem();
	}

	public float radius() {
		return this.radius;
	}

	public int colour() {
		return this.colour;
	}

	public int duration() {
		return this.duration;
	}

	public int time() {
		return this.time;
	}

	public void performRecipe(BlockPos pBlockPos, Level pLevel) {
		var entity = EntityType.AREA_EFFECT_CLOUD.create(pLevel, EntitySpawnReason.TRIGGERED);
		if (entity != null) {
			entity.moveTo(pBlockPos.getX() + 0.5D, pBlockPos.getY(), pBlockPos.getZ() + 0.5D);
			entity.setDuration(this.duration());
			entity.setPotionContents(this.potion());
			entity.setRadius(this.radius());
			entity.setRadiusPerTick(entity.getRadius() / -entity.getDuration());
			entity.setWaitTime(0);
			pLevel.addFreshEntity(entity);
			pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
		}
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput, HolderLookup.Provider pProvider) {
		return ItemStack.EMPTY;
	}

	public ItemStack result() {
		return ItemStack.EMPTY;
	}

	@Override
	public PlacementInfo placementInfo() {
		return PlacementInfo.create(this.ingredient());
	}

	public PotionContents potion() {
		return this.potion;
	}

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.POTION_CONCOCTING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.POTION_CONCOCTING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.POTION_CONCOCTING.get();
	}
}
