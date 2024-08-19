package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.registry.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ConcoctingEntityRecipe implements Recipe<RecipeInput> {
	public int burnTime;
	public int color;

	public List<Ingredient> ingredients;

	public String entity;

	public ConcoctingEntityRecipe(int pBurnTime, int pColor, List<Ingredient> pIngredients, String pEntity) {
		this.burnTime = pBurnTime;
		this.color = pColor;
		this.ingredients = pIngredients;
		this.entity = pEntity;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public boolean matches(RecipeInput pInput, Level pLevel) {
		return this.matches(pInput) && !pLevel.isClientSide();
	}

	public boolean matches(RecipeInput pInput) {
		return this.ingredients.size() < 3 ? this.ingredients.size() < 2 ? this.matchesSingle(pInput) : this.matchesDouble(pInput) : this.matchesTriple(pInput);
	}

	public boolean matchesSingle(RecipeInput pInput) {
		return this.ingredients.get(0).test(pInput.getItem(0)) && pInput.getItem(1).isEmpty() && pInput.getItem(2).isEmpty();
	}

	public boolean matchesDouble(RecipeInput pInput) {
		return this.ingredients.get(0).test(pInput.getItem(0)) && this.ingredients.get(1).test(pInput.getItem(1)) && pInput.getItem(2).isEmpty();
	}

	public boolean matchesTriple(RecipeInput pInput) {
		return this.ingredients.get(0).test(pInput.getItem(0)) && this.ingredients.get(1).test(pInput.getItem(1)) && this.ingredients.get(2).test(pInput.getItem(2));
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
			if (entity instanceof LivingEntity livingEntity) {
				var state = pLevel.getBlockState(pPos);
				if (state.getBlock() instanceof KettleBlock kettleBlock) {
					var blockPos = pPos.offset(pLevel.getRandom().nextInt(8) - 4, 0, pLevel.getRandom().nextInt(8) - 4);
					if (this.entity.equals(BuiltInRegistries.ENTITY_TYPE.getKey(IcariaEntityTypes.CAPTAIN_REVENANT.get()).toString())) {
						livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.ORICHALCUM_TOOLS.sword.get()));
						livingEntity.moveTo(pPos.getX() + kettleBlock.getX(state), pPos.getY() + 0.75D, pPos.getZ() + kettleBlock.getZ(state));
						pLevel.playSound(null, pPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
						pLevel.addFreshEntity(livingEntity);
					} else if (this.entity.equals(BuiltInRegistries.ENTITY_TYPE.getKey(IcariaEntityTypes.CRAWLER_REVENANT.get()).toString()) || this.entity.equals(BuiltInRegistries.ENTITY_TYPE.getKey(IcariaEntityTypes.MYRMEKE_SOLDIER.get()).toString())) {
						livingEntity.moveTo(blockPos, 0.0F, 0.0F);
						pLevel.addFreshEntity(livingEntity);
					} else if (this.entity.equals(BuiltInRegistries.ENTITY_TYPE.getKey(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get()).toString())) {
						livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.GREEK_FIRE_GRENADE.get()));
						livingEntity.moveTo(pPos.getX() + kettleBlock.getX(state), pPos.getY() + 0.75D, pPos.getZ() + kettleBlock.getZ(state));
						pLevel.playSound(null, pPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
						pLevel.addFreshEntity(livingEntity);
					} else if (this.entity.equals(BuiltInRegistries.ENTITY_TYPE.getKey(IcariaEntityTypes.SOLDIER_REVENANT.get()).toString())) {
						livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(IcariaItems.KASSITEROS_TOOLS.sword.get()));
						livingEntity.moveTo(pPos.getX() + kettleBlock.getX(state), pPos.getY() + 0.75D, pPos.getZ() + kettleBlock.getZ(state));
						pLevel.playSound(null, pPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
						pLevel.addFreshEntity(livingEntity);
					} else {
						livingEntity.moveTo(pPos.getX() + kettleBlock.getX(state), pPos.getY() + 0.75D, pPos.getZ() + kettleBlock.getZ(state));
						pLevel.playSound(null, pPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
						pLevel.addFreshEntity(livingEntity);
					}
				}
			}
		}
	}

	@Override
	public ItemStack assemble(RecipeInput pInput, HolderLookup.Provider pProvider) {
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
		return IcariaRecipeSerializers.CONCOCTING_ENTITY.get();
	}

	@Override
	public RecipeType<?> getType() {
		return IcariaRecipeTypes.CONCOCTING_ENTITY.get();
	}
}
