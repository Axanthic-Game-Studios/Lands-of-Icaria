package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingEntityRecipe implements Recipe<SimpleContainer> {
    public int burnTime;
    public int color;

    public NonNullList<Ingredient> ingredients;

    public ResourceLocation id;

    public String entity;

    public ConcoctingEntityRecipe(int pBurnTime, int pColor, NonNullList<Ingredient> pIngredients, ResourceLocation pId, String pEntity) {
        this.burnTime = pBurnTime;
        this.color = pColor;
        this.ingredients = pIngredients;
        this.id = pId;
        this.entity = pEntity;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return !pLevel.isClientSide() && this.ingredients.get(0).test(pContainer.getItem(0)) && this.ingredients.get(1).test(pContainer.getItem(1)) && this.ingredients.get(2).test(pContainer.getItem(2));
    }

    public int getBurnTime() {
        return this.burnTime;
    }

    public int getColor() {
        return this.color;
    }

    public void performRecipe(Level pLevel, BlockPos pPos) {
        var optional = EntityType.byString(this.entity);
        if (optional.isPresent()) {
            var entity = optional.get().create(pLevel);
            if (entity != null) {
                var state = pLevel.getBlockState(pPos);
                if (state.getBlock() instanceof KettleBlock kettleBlock) {
                    var blockPos = pPos.offset(pLevel.getRandom().nextInt(8) - 4, 0, pLevel.getRandom().nextInt(8) - 4);
                    if (this.entity.equals(IcariaEntityTypes.CRAWLER_REVENANT.getId().toString()) || this.entity.equals(IcariaEntityTypes.MYRMEKE_SOLDIER.getId().toString())) {
                        entity.moveTo(blockPos, 0.0F, 0.0F);
                        pLevel.addFreshEntity(entity);
                    } else {
                        entity.moveTo(pPos.getX() + kettleBlock.getX(state), pPos.getY() + 0.75D, pPos.getZ() + kettleBlock.getZ(state));
                        pLevel.playSound(null, pPos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS);
                        pLevel.addFreshEntity(entity);
                    }
                }
            }
        }
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return ItemStack.EMPTY;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return IcariaRecipeSerializers.CONCOCTING_ENTITY.get();
    }

    @Override
    public RecipeType<?> getType() {
        return IcariaRecipeTypes.CONCOCTING_ENTITY.get();
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }
}
