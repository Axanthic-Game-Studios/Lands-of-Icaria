package com.axanthic.icaria.util;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class IcariaTier implements Tier {

	private final int level;
	private final int uses;
	private final float speed;
	private final float attackDamageBonus;
	private final int enchantmentValue;
	@Nonnull
	private final Tag<Block> tag;
	@Nonnull
	private final Supplier<Ingredient> repairIngredient;
	public final Tier vanillaEquivalent;

	public IcariaTier(int level, int uses, float speed, float attackDamageBonus, int enchantmentValue, @Nonnull Tag<Block> tag, @Nonnull Supplier<Ingredient> repairIngredient, Tier vanillaEquivalent) {
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

	@Nonnull
	public Tag<Block> getTag() {
		return this.tag;
	}

	@Nonnull
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