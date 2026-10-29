package com.axanthic.icaria.common.config;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfig {
	public static ModConfigSpec.BooleanValue SPAWN_ARACHNIDS;

	public static ModConfigSpec.DoubleValue DAMAGE_BUBBLE_SPELL;
	public static ModConfigSpec.DoubleValue DAMAGE_MAGIC_MISSILE_SPELL;
	public static ModConfigSpec.DoubleValue HEALTH_HEALING_SPELL;
	public static ModConfigSpec.DoubleValue INACCURACY_ANTI_GRAVITY_SPELL;
	public static ModConfigSpec.DoubleValue INACCURACY_BUBBLE_SPELL;
	public static ModConfigSpec.DoubleValue INACCURACY_FORTIFYING_SPELL;
	public static ModConfigSpec.DoubleValue INACCURACY_FREEZING_SPELL;
	public static ModConfigSpec.DoubleValue INACCURACY_HEALING_SPELL;
	public static ModConfigSpec.DoubleValue INACCURACY_MAGIC_MISSILE_SPELL;
	public static ModConfigSpec.DoubleValue VELOCITY_ANTI_GRAVITY_SPELL;
	public static ModConfigSpec.DoubleValue VELOCITY_BUBBLE_SPELL;
	public static ModConfigSpec.DoubleValue VELOCITY_FORTIFYING_SPELL;
	public static ModConfigSpec.DoubleValue VELOCITY_FREEZING_SPELL;
	public static ModConfigSpec.DoubleValue VELOCITY_HEALING_SPELL;
	public static ModConfigSpec.DoubleValue VELOCITY_MAGIC_MISSILE_SPELL;

	public static ModConfigSpec.IntValue COOLDOWN_ANTI_GRAVITY_SPELL;
	public static ModConfigSpec.IntValue COOLDOWN_BUBBLE_SPELL;
	public static ModConfigSpec.IntValue COOLDOWN_FORTIFYING_SPELL;
	public static ModConfigSpec.IntValue COOLDOWN_FREEZING_SPELL;
	public static ModConfigSpec.IntValue COOLDOWN_HEALING_SPELL;
	public static ModConfigSpec.IntValue COOLDOWN_MAGIC_MISSILE_SPELL;
	public static ModConfigSpec.IntValue EFFECT_AMPLIFIER_ANTI_GRAVITY_SPELL;
	public static ModConfigSpec.IntValue EFFECT_AMPLIFIER_FORTIFYING_SPELL;
	public static ModConfigSpec.IntValue EFFECT_AMPLIFIER_FREEZING_SPELL;
	public static ModConfigSpec.IntValue EFFECT_DURATION_ANTI_GRAVITY_SPELL;
	public static ModConfigSpec.IntValue EFFECT_DURATION_FORTIFYING_SPELL;
	public static ModConfigSpec.IntValue EFFECT_DURATION_FREEZING_SPELL;
	public static ModConfigSpec.IntValue MINIMUM_BUBBLE_AMOUNT_BUBBLE_SPELL;
	public static ModConfigSpec.IntValue MAXIMUM_BUBBLE_AMOUNT_BUBBLE_SPELL;
	public static ModConfigSpec.IntValue MINIMUM_BUBBLE_LIFETIME_BUBBLE_SPELL;
	public static ModConfigSpec.IntValue MAXIMUM_BUBBLE_LIFETIME_BUBBLE_SPELL;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_CLUSTER_RAYS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_FIREPLACE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_FORGE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_GRINDER_GEARS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_HUTCH_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_KETTLE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_KILN_ITEMS;

	public static void registerClientConfig() {
		var builder = new ModConfigSpec.Builder();

		builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_configuration").comment("Render Configuration").push("Render Configuration");

		IcariaConfig.RENDER_DISTANCE_CLUSTER_RAYS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_distance_cluster_rays").comment("Whether a Cluster should render Rays based on the given Distance.").defineInRange("Cluster Rays Render Distance", 256, 0, Integer.MAX_VALUE);
		IcariaConfig.RENDER_DISTANCE_FIREPLACE_ITEMS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_distance_fireplace_items").comment("Whether a Fireplace should render Items based on the given Distance.").defineInRange("Fireplace Items Render Distance", 256, 0, Integer.MAX_VALUE);
		IcariaConfig.RENDER_DISTANCE_FORGE_ITEMS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_distance_forge_items").comment("Whether a Forge should render Items based on the given Distance.").defineInRange("Forge Items Render Distance", 256, 0, Integer.MAX_VALUE);
		IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_distance_grinder_gears").comment("Whether a Grinder should render Gears based on the given Distance.").defineInRange("Grinder Gears Render Distance", 256, 0, Integer.MAX_VALUE);
		IcariaConfig.RENDER_DISTANCE_HUTCH_ITEMS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_distance_hutch_items").comment("Whether a Hutch should render Items based on the given Distance.").defineInRange("Hutch Items Render Distance", 256, 0, Integer.MAX_VALUE);
		IcariaConfig.RENDER_DISTANCE_KETTLE_ITEMS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_distance_kettle_items").comment("Whether a Kettle should render Items based on the given Distance.").defineInRange("Kettle Items Render Distance", 256, 0, Integer.MAX_VALUE);
		IcariaConfig.RENDER_DISTANCE_KILN_ITEMS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "render_distance_kiln_items").comment("Whether a Kiln should render Items based on the given Distance.").defineInRange("Kiln Items Render Distance", 256, 0, Integer.MAX_VALUE);

		builder.pop();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.CLIENT, builder.build());
	}

	public static void registerLocalConfig() {
		var builder = new ModConfigSpec.Builder();

		builder.translation("configuration" + "." + IcariaIds.ID + "." + "spawn_configuration").comment("Spawn Configuration").push("Spawn Configuration");

		IcariaConfig.SPAWN_ARACHNIDS = builder.translation("configuration" + "." + IcariaIds.ID + "." + "spawn_arachnids").comment("Default: true. Whether Arachnids should spawn.").define("Spawn Arachnids", true);

		builder.pop();
		builder.translation("configuration" + "." + IcariaIds.ID + "." + "spell_configuration").comment("Spell Configuration").push("Spell Configuration");

		IcariaConfig.DAMAGE_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "damage_bubble_spell").comment("Whether a Bubble Spell should deal Damage based on the given Value.").defineInRange("Bubble Spell Damage", 2.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.DAMAGE_MAGIC_MISSILE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "damage_magic_missile_spell").comment("Whether a Magic Missile Spell should apply Damage based on the given Value.").defineInRange("Magic Missile Spell Damage", 8.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.HEALTH_HEALING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "health_healing_spell").comment("Whether a Healing Spell should apply Health based on the given Value.").defineInRange("Healing Spell Health", 8.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.INACCURACY_ANTI_GRAVITY_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "inaccuracy_anti_gravity_spell").comment("Whether an Anti Gravity Spell should apply an Inaccuracy based on the given Value").defineInRange("Anti Gravity Spell Inaccuracy", 0.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.INACCURACY_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "inaccuracy_bubble_spell").comment("Whether a Bubble Spell should apply an Inaccuracy based on the given Value").defineInRange("Bubble Spell Inaccuracy", 20.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.INACCURACY_FORTIFYING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "inaccuracy_fortifying_spell").comment("Whether a Fortifying Spell should apply an Inaccuracy based on the given Value").defineInRange("Fortifying Spell Inaccuracy", 0.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.INACCURACY_FREEZING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "inaccuracy_freezing_spell").comment("Whether a Freezing Spell should apply an Inaccuracy based on the given Value").defineInRange("Freezing Spell Inaccuracy", 0.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.INACCURACY_HEALING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "inaccuracy_healing_spell").comment("Whether a Healing Spell should apply an Inaccuracy based on the given Value").defineInRange("Healing Spell Inaccuracy", 0.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.INACCURACY_MAGIC_MISSILE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "inaccuracy_magic_missile_spell").comment("Whether a Magic Missile Spell should apply an Inaccuracy based on the given Value").defineInRange("Magic Missile Spell Inaccuracy", 0.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.VELOCITY_ANTI_GRAVITY_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "velocity_anti_gravity_spell").comment("Whether an Anti Gravity Spell should apply a Velocity based on the given Value").defineInRange("Anti Gravity Spell Velocity", 1.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.VELOCITY_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "velocity_bubble_spell").comment("Whether a Bubble Spell should apply a Velocity based on the given Value").defineInRange("Bubble Spell Velocity", 0.1D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.VELOCITY_FORTIFYING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "velocity_fortifying_spell").comment("Whether a Fortifying Spell should apply a Velocity based on the given Value").defineInRange("Fortifying Spell Velocity", 1.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.VELOCITY_FREEZING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "velocity_freezing_spell").comment("Whether a Freezing Spell should apply a Velocity based on the given Value").defineInRange("Freezing Spell Velocity", 1.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.VELOCITY_HEALING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "velocity_healing_spell").comment("Whether a Healing Spell should apply a Velocity based on the given Value").defineInRange("Healing Spell Velocity", 1.0D, 0.0D, Integer.MAX_VALUE);
		IcariaConfig.VELOCITY_MAGIC_MISSILE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "velocity_magic_missile_spell").comment("Whether a Magic Missile Spell should apply a Velocity based on the given Value").defineInRange("Magic Missile Spell Velocity", 1.0D, 0.0D, Integer.MAX_VALUE);

		IcariaConfig.COOLDOWN_ANTI_GRAVITY_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "cooldown_anti_gravity_spell").comment("Whether an Anti Gravity Spell should apply a Cooldown based on the given Value.").defineInRange("Anti Gravity Spell Cooldown", 20, 0, Integer.MAX_VALUE);
		IcariaConfig.COOLDOWN_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "cooldown_bubble_spell").comment("Whether a Bubble Spell should apply a Cooldown based on the given Value.").defineInRange("Bubble Spell Cooldown", 20, 0, Integer.MAX_VALUE);
		IcariaConfig.COOLDOWN_FORTIFYING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "cooldown_fortifying_spell").comment("Whether a Fortifying Spell should apply a Cooldown based on the given Value.").defineInRange("Fortifying Spell Cooldown", 20, 0, Integer.MAX_VALUE);
		IcariaConfig.COOLDOWN_FREEZING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "cooldown_freezing_spell").comment("Whether a Freezing Spell should apply a Cooldown based on the given Value.").defineInRange("Freezing Spell Cooldown", 20, 0, Integer.MAX_VALUE);
		IcariaConfig.COOLDOWN_HEALING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "cooldown_healing_spell").comment("Whether a Healing Spell should apply a Cooldown based on the given Value.").defineInRange("Healing Spell Cooldown", 20, 0, Integer.MAX_VALUE);
		IcariaConfig.COOLDOWN_MAGIC_MISSILE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "cooldown_magic_missile_spell").comment("Whether a Magic Missile Spell should apply a Cooldown based on the given Value.").defineInRange("Magic Missile Spell Cooldown", 20, 0, Integer.MAX_VALUE);
		IcariaConfig.EFFECT_AMPLIFIER_ANTI_GRAVITY_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "effect_amplifier_anti_gravity_spell").comment("Whether an Anti Gravity Spell should apply its Effect with an Amplifier based on the given Value.").defineInRange("Anti Gravity Spell Effect Amplifier", 0, 0, 255);
		IcariaConfig.EFFECT_AMPLIFIER_FORTIFYING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "effect_amplifier_fortifying_spell").comment("Whether a Fortifying Spell should apply its Effect with an Amplifier based on the given Value.").defineInRange("Fortifying Spell Effect Amplifier", 0, 0, 255);
		IcariaConfig.EFFECT_AMPLIFIER_FREEZING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "effect_amplifier_freezing_spell").comment("Whether a Freezing Spell should apply its Effect with an Amplifier based on the given Value.").defineInRange("Freezing Spell Effect Amplifier", 0, 0, 255);
		IcariaConfig.EFFECT_DURATION_ANTI_GRAVITY_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "effect_duration_anti_gravity_spell").comment("Whether an Anti Gravity Spell should apply its Effect with Duration based on the given Value.").defineInRange("Anti Gravity Spell Effect Duration", 300, 0, Integer.MAX_VALUE);
		IcariaConfig.EFFECT_DURATION_FORTIFYING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "effect_duration_fortifying_spell").comment("Whether a Fortifying Spell should apply its Effect with Duration based on the given Value.").defineInRange("Fortifying Spell Effect Duration", 300, 0, Integer.MAX_VALUE);
		IcariaConfig.EFFECT_DURATION_FREEZING_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "effect_duration_freezing_spell").comment("Whether a Freezing Spell should apply its Effect with Duration based on the given Value.").defineInRange("Freezing Spell Effect Duration", 300, 0, Integer.MAX_VALUE);
		IcariaConfig.MINIMUM_BUBBLE_AMOUNT_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "minimum_bubble_amount_bubble_spell").comment("Whether a Bubble Spell should spawn Bubbles based on the given Minimum.").defineInRange("Minimum Bubble Spell Bubble Amount", 4, 0, Integer.MAX_VALUE);
		IcariaConfig.MAXIMUM_BUBBLE_AMOUNT_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "maximum_bubble_amount_bubble_spell").comment("Whether a Bubble Spell should spawn Bubbles based on the given Maximum.").defineInRange("Maximum Bubble Spell Bubble Amount", 8, 0, Integer.MAX_VALUE);
		IcariaConfig.MINIMUM_BUBBLE_LIFETIME_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "minimum_bubble_lifetime_bubble_spell").comment("Whether a Bubble Spell should spawn Bubbles with Lifetime based on the given Minimum.").defineInRange("Minimum Bubble Spell Bubble Lifetime", 200, 0, Integer.MAX_VALUE);
		IcariaConfig.MAXIMUM_BUBBLE_LIFETIME_BUBBLE_SPELL = builder.translation("configuration" + "." + IcariaIds.ID + "." + "maximum_bubble_lifetime_bubble_spell").comment("Whether a Bubble Spell should spawn Bubbles with Lifetime based on the given Maximum.").defineInRange("Maximum Bubble Spell Bubble Lifetime", 400, 0, Integer.MAX_VALUE);

		builder.pop();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.LOCAL, builder.build());
	}
}
