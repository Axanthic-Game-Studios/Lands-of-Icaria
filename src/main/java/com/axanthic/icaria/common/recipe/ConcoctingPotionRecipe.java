package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingPotionRecipe implements Recipe<SimpleContainer> {
    public float potionRadius;

    public int burnTime;
    public int color;
    public int potionDuration;

    public List<Ingredient> ingredients;

    public PotionContents potion;

    public ConcoctingPotionRecipe(float pPotionRadius, int pBurnTime, int pColor, int pPotionDuration, List<Ingredient> pIngredients, PotionContents pPotion) {
        this.potionRadius = pPotionRadius;
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.potionDuration = pPotionDuration;
        this.ingredients = pIngredients;
        this.potion = pPotion;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return this.matches(pContainer) && !pLevel.isClientSide();
    }

    public boolean matches(SimpleContainer pContainer) {
        return this.ingredients.size() < 3 ? this.ingredients.size() < 2 ? this.matchesSingle(pContainer) : this.matchesDouble(pContainer) : this.matchesTriple(pContainer);
    }

    public boolean matchesSingle(SimpleContainer pContainer) {
        return this.ingredients.get(0).test(pContainer.getItem(0)) && pContainer.getItem(1).isEmpty() && pContainer.getItem(2).isEmpty();
    }

    public boolean matchesDouble(SimpleContainer pContainer) {
        return this.ingredients.get(0).test(pContainer.getItem(0)) && this.ingredients.get(1).test(pContainer.getItem(1)) && pContainer.getItem(2).isEmpty();
    }

    public boolean matchesTriple(SimpleContainer pContainer) {
        return this.ingredients.get(0).test(pContainer.getItem(0)) && this.ingredients.get(1).test(pContainer.getItem(1)) && this.ingredients.get(2).test(pContainer.getItem(2));
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    public int getColor() {
        return this.color;
    }

    public void performRecipe(Level pLevel, BlockPos pPos) {
        var entity = EntityType.AREA_EFFECT_CLOUD.create(pLevel);
        if (entity != null) {
            entity.moveTo(pPos.getX() + 0.5D, pPos.getY(), pPos.getZ() + 0.5D);
            entity.setDuration(this.potionDuration);
            entity.setPotionContents(this.potion);
            entity.setRadius(this.potionRadius);
            entity.setRadiusPerTick(entity.getRadius() / -entity.getDuration());
            entity.setWaitTime(0);
            pLevel.addFreshEntity(entity);
            pLevel.playSound(null, pPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS);
        }
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, HolderLookup.Provider pProvider) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pProvider) {
        return ItemStack.EMPTY;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        var list = NonNullList.<Ingredient>create();
        list.addAll(this.ingredients);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return IcariaRecipeSerializers.CONCOCTING_POTION.get();
    }

    @Override
    public RecipeType<?> getType() {
        return IcariaRecipeTypes.CONCOCTING_POTION.get();
    }
}
