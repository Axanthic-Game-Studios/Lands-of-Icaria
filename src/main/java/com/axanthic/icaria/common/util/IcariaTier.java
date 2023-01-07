package com.axanthic.icaria.common.util;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

@MethodsReturnNonnullByDefault

public class IcariaTier implements Tier {
	public float attackDamageBonus;
	public float speed;

	public int enchantmentValue;
	public int level;
	public int uses;

	public Supplier<Ingredient> repairIngredient;
	public TagKey<Block> tag;
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
	public float getAttackDamageBonus() {
		return this.attackDamageBonus;
	}

	@Override
	public float getSpeed() {
		return this.speed;
	}

	@Override
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}

	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public int getUses() {
		return this.uses;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}

	@Override
	public String toString() {
		return "ForgeTier[" + "level=" + this.level + ", " + "uses=" + this.uses + ", " + "speed=" + this.speed + ", " + "attackDamageBonus=" + this.attackDamageBonus + ", " + "enchantmentValue=" + this.enchantmentValue + ", " + "tag=" + this.tag + ", " + "repairIngredient=" + this.repairIngredient + ']';
	}

	@Override
	public TagKey<Block> getTag() {
		return this.tag;
	}
}
