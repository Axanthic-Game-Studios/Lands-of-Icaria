package com.axanthic.icaria.common.util;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

@MethodsReturnNonnullByDefault

public class IcariaTier implements Tier {
	public int level;
	public int uses;
	public float speed;
	public float attackDamageBonus;
	public int enchantmentValue;
	public TagKey<Block> tag;
	public Supplier<Ingredient> repairIngredient;
	public Tier vanillaEquivalent;

	public IcariaTier(int level, int uses, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Block> tag, Supplier<Ingredient> repairIngredient, Tier vanillaEquivalent) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.attackDamageBonus = attackDamageBonus;
		this.enchantmentValue = enchantmentValue;
		this.tag = tag;
		this.repairIngredient = repairIngredient;
		this.vanillaEquivalent = vanillaEquivalent;
	}

	@Override
	public int getUses() {
		return this.uses;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public float getAttackDamageBonus() {
		return this.attackDamageBonus;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public TagKey<Block> getTag() {
		return this.tag;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String toString() {
		return "ForgeTier[" +
			"level=" + level + ", " +
			"uses=" + uses + ", " +
			"speed=" + speed + ", " +
			"attackDamageBonus=" + attackDamageBonus + ", " +
			"enchantmentValue=" + enchantmentValue + ", " +
			"tag=" + tag + ", " +
			"repairIngredient=" + repairIngredient + ']';
	}
}
