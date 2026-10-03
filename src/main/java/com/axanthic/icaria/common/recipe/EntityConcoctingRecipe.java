package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.block.KettleBlock;
import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
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

	public EntityType<?> entityType;

	public Ingredient ingredient;

	public static final MapCodec<EntityConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.INT.fieldOf("color").forGetter(EntityConcoctingRecipe::colour),
			Codec.INT.fieldOf("time").forGetter(EntityConcoctingRecipe::time),
			EntityType.CODEC.fieldOf("entityType").forGetter(EntityConcoctingRecipe::entityType),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(EntityConcoctingRecipe::ingredient)
		).apply(instance, EntityConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, EntityConcoctingRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.INT, EntityConcoctingRecipe::colour,
		ByteBufCodecs.INT, EntityConcoctingRecipe::time,
		EntityType.STREAM_CODEC, EntityConcoctingRecipe::entityType,
		Ingredient.CONTENTS_STREAM_CODEC, EntityConcoctingRecipe::ingredient,
		EntityConcoctingRecipe::new
	);

	public EntityConcoctingRecipe(int pColour, int pTime, EntityType<?> pEntityType, Ingredient pIngredient) {
		this.colour = pColour;
		this.time = pTime;
		this.entityType = pEntityType;
		this.ingredient = pIngredient;
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

	@Override
	public boolean showNotification() {
		return false;
	}

	public int colour() {
		return this.colour;
	}

	public int time() {
		return this.time;
	}

	public void performRecipe(BlockPos pBlockPos, Level pLevel) {
		var entity = this.entityType().create(pLevel, EntitySpawnReason.TRIGGERED);
		if (entity instanceof LivingEntity livingEntity) {
			var state = pLevel.getBlockState(pBlockPos);
			if (state.getBlock() instanceof KettleBlock kettleBlock) {
				var blockPos = pBlockPos.offset(pLevel.getRandom().nextInt(8) - 4, 0, pLevel.getRandom().nextInt(8) - 4);
				if (livingEntity instanceof ArachneDroneEntity arachneDroneEntity) {
					arachneDroneEntity.snapTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
					arachneDroneEntity.setSize(1);
					pLevel.addFreshEntity(livingEntity);
					pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
				} else if (livingEntity instanceof HyliasterEntity hyliasterEntity) {
					hyliasterEntity.snapTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
					hyliasterEntity.setSize(1);
					pLevel.addFreshEntity(livingEntity);
					pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
				} else if (livingEntity instanceof MyrmekeSoldierEntity myrmekeSoldierEntity) {
					myrmekeSoldierEntity.snapTo(blockPos, 0.0F, 0.0F);
					pLevel.addFreshEntity(livingEntity);
				} else if (livingEntity instanceof CaptainRevenantEntity captainRevenantEntity) {
					captainRevenantEntity.snapTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
					captainRevenantEntity.populateDefaultEquipmentSlots();
					pLevel.addFreshEntity(livingEntity);
					pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
				} else if (livingEntity instanceof CrawlerRevenantEntity crawlerRevenantEntity) {
					crawlerRevenantEntity.snapTo(blockPos, 0.0F, 0.0F);
					pLevel.addFreshEntity(livingEntity);
				} else if (livingEntity instanceof NetherPyromancerRevenantEntity netherPyromancerRevenantEntity) {
					netherPyromancerRevenantEntity.snapTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
					netherPyromancerRevenantEntity.populateDefaultEquipmentSlots();
					pLevel.addFreshEntity(livingEntity);
					pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
				} else if (livingEntity instanceof SoldierRevenantEntity soldierRevenantEntity) {
					soldierRevenantEntity.snapTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
					soldierRevenantEntity.populateDefaultEquipmentSlots();
					pLevel.addFreshEntity(livingEntity);
					pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
				} else if (livingEntity instanceof IcariaPathfinderMobEntity icariaPathfinderMobEntity) {
					icariaPathfinderMobEntity.snapTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
					icariaPathfinderMobEntity.setSize(1);
					pLevel.addFreshEntity(livingEntity);
					pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
				} else {
					livingEntity.snapTo(pBlockPos.getX() + kettleBlock.getX(state), pBlockPos.getY() + 0.75D, pBlockPos.getZ() + kettleBlock.getZ(state));
					pLevel.addFreshEntity(livingEntity);
					pLevel.playSound(null, pBlockPos, IcariaSoundEvents.KETTLE_POP, SoundSource.BLOCKS);
				}
			}
		}
	}

	public EntityType<?> entityType() {
		return this.entityType;
	}

	public Ingredient ingredient() {
		return this.ingredient;
	}

	@Override
	public ItemStack assemble(RecipeInput pRecipeInput) {
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

	@Override
	public String group() {
		return "";
	}
}
