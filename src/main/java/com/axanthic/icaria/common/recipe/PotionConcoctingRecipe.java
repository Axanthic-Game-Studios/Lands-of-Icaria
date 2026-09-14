package com.axanthic.icaria.common.recipe;

import com.axanthic.icaria.common.registry.IcariaRecipeBookCategories;
import com.axanthic.icaria.common.registry.IcariaRecipeSerializers;
import com.axanthic.icaria.common.registry.IcariaRecipeTypes;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
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

	public PotionContents potionContents;

	public static final MapCodec<PotionConcoctingRecipe> CODEC = RecordCodecBuilder.mapCodec(
		instance -> instance.group(
			Codec.FLOAT.fieldOf("radius").forGetter(PotionConcoctingRecipe::radius),
			Codec.INT.fieldOf("colour").forGetter(PotionConcoctingRecipe::colour),
			Codec.INT.fieldOf("duration").forGetter(PotionConcoctingRecipe::duration),
			Codec.INT.fieldOf("time").forGetter(PotionConcoctingRecipe::time),
			Ingredient.CODEC.fieldOf("ingredient").forGetter(PotionConcoctingRecipe::ingredient),
			PotionContents.CODEC.fieldOf("potionContents").forGetter(PotionConcoctingRecipe::potionContents)
		).apply(instance, PotionConcoctingRecipe::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, PotionConcoctingRecipe> STREAM_CODEC = StreamCodec.composite(
		ByteBufCodecs.FLOAT, PotionConcoctingRecipe::radius,
		ByteBufCodecs.INT, PotionConcoctingRecipe::colour,
		ByteBufCodecs.INT, PotionConcoctingRecipe::duration,
		ByteBufCodecs.INT, PotionConcoctingRecipe::time,
		Ingredient.CONTENTS_STREAM_CODEC, PotionConcoctingRecipe::ingredient,
		PotionContents.STREAM_CODEC, PotionConcoctingRecipe::potionContents,
		PotionConcoctingRecipe::new
	);

	public PotionConcoctingRecipe(float pRadius, int pColour, int pDuration, int pTime, Ingredient pIngredient, PotionContents pPotionContents) {
		this.radius = pRadius;
		this.colour = pColour;
		this.duration = pDuration;
		this.time = pTime;
		this.ingredient = pIngredient;
		this.potionContents = pPotionContents;
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
			entity.snapTo(pBlockPos.getX() + 0.5D, pBlockPos.getY(), pBlockPos.getZ() + 0.5D);
			entity.setDuration(this.duration());
			entity.setPotionContents(this.potionContents());
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

	public PotionContents potionContents() {
		return this.potionContents;
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

	@Override
	public String group() {
		return "";
	}
}
