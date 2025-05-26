package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.entity.*;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class EntityConcoctingRecipe implements Recipe<RecipeInput> {
	public int colour;
	public int time;

	public Ingredient ingredient;

	public String entity;

	public EntityConcoctingRecipe(int pColour, int pTime, Ingredient pIngredient, String pEntity) {
		this.colour = pColour;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.entity = pEntity;
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

	public int colour() {
		return this.colour;
	}

	public int time() {
		return this.time;
	}

	public void performRecipe(BlockPos pBlockPos, Level pLevel) {
		var optional = EntityType.byString(this.entity());
		if (optional.isPresent()) {
			var entity = optional.get().create(pLevel, EntitySpawnReason.TRIGGERED);
			if (entity instanceof LivingEntity livingEntity) {
				var state = pLevel.getBlockState(pBlockPos);
				if (state.getBlock() instanceof KettleBlock kettleBlock) {
					var blockPos = pBlockPos.offset(pLevel.getRandom().nextInt(8) - 4, 0, pLevel.getRandom().nextInt(8) - 4);
					if (livingEntity instanceof ArachneDroneEntity arachneDroneEntity) {
						arachneDroneEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						arachneDroneEntity.setSize(1);
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					} else if (livingEntity instanceof HyliasterEntity hyliasterEntity) {
						hyliasterEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						hyliasterEntity.setSize(1);
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					} else if (livingEntity instanceof MyrmekeSoldierEntity myrmekeSoldierEntity) {
						myrmekeSoldierEntity.moveTo(blockPos, 0.0F, 0.0F);
						pLevel.addFreshEntity(livingEntity);
					} else if (livingEntity instanceof CaptainRevenantEntity captainRevenantEntity) {
						captainRevenantEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						captainRevenantEntity.populateDefaultEquipmentSlots();
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					} else if (livingEntity instanceof CrawlerRevenantEntity crawlerRevenantEntity) {
						crawlerRevenantEntity.moveTo(blockPos, 0.0F, 0.0F);
						pLevel.addFreshEntity(livingEntity);
					} else if (livingEntity instanceof NetherPyromancerRevenantEntity netherPyromancerRevenantEntity) {
						netherPyromancerRevenantEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						netherPyromancerRevenantEntity.populateDefaultEquipmentSlots();
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					} else if (livingEntity instanceof SoldierRevenantEntity soldierRevenantEntity) {
						soldierRevenantEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						soldierRevenantEntity.populateDefaultEquipmentSlots();
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					} else if (livingEntity instanceof SizedFlyingMobEntity sizedFlyingMobEntity) {
						sizedFlyingMobEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						sizedFlyingMobEntity.setSize(1);
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					} else if (livingEntity instanceof SizedPathfinderMobEntity sizedPathfinderMobEntity) {
						sizedPathfinderMobEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						sizedPathfinderMobEntity.setSize(1);
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					} else {
						livingEntity.moveTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
						pLevel.addFreshEntity(livingEntity);
						pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
					}
				}
			}
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

	@Override
	public RecipeBookCategory recipeBookCategory() {
		return IcariaRecipeBookCategories.ENTITY_CONCOCTING.get();
	}

	@Override
	public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
		return IcariaRecipeSerializers.ENTITY_CONCOCTING.get();
	}

	@Override
	public RecipeType<? extends Recipe<RecipeInput>> getType() {
		return IcariaRecipeTypes.ENTITY_CONCOCTING.get();
	}

	public String entity() {
		return this.entity;
	}
}
