package com.axanthic.icaria.common.config;

import com.axanthic.icaria.Icaria;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class IcariaConfig {
	public static ForgeConfigSpec.BooleanValue RENDER_CRYSTAL_RAYS;
	public static ForgeConfigSpec.BooleanValue RENDER_FORGE_ITEMS;
	public static ForgeConfigSpec.BooleanValue RENDER_GRINDER_GEARS;
	public static ForgeConfigSpec.BooleanValue RENDER_KETTLE_ITEMS;
	public static ForgeConfigSpec.BooleanValue RENDER_KILN_ITEMS;
	public static ForgeConfigSpec.BooleanValue FORGE_SOUNDS;
	public static ForgeConfigSpec.BooleanValue GRINDER_SOUNDS;
	public static ForgeConfigSpec.BooleanValue KETTLE_SOUNDS;
	public static ForgeConfigSpec.BooleanValue KILN_SOUNDS;
	public static ForgeConfigSpec.BooleanValue SPAWN_ARACHNIDS;

	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_CRYSTAL_RAYS;
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_FORGE_ITEMS;
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_GRINDER_GEARS;
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_KETTLE_ITEMS;
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_KILN_ITEMS;

	public static ForgeConfigSpec.DoubleValue ANTI_GRAVITY_BLOCK_GRAVITY;
	public static ForgeConfigSpec.IntValue ANTI_GRAVITY_LEVITATION_DURATION;

	public static ForgeConfigSpec.DoubleValue BUBBLE_GRAVITY;
	public static ForgeConfigSpec.DoubleValue BUBBLE_DAMAGE;
	public static ForgeConfigSpec.IntValue BUBBLE_DURATION;
	public static ForgeConfigSpec.IntValue BUBBLE_MIN_COUNT;
	public static ForgeConfigSpec.IntValue BUBBLE_MAX_COUNT;

	public static ForgeConfigSpec.IntValue FORTIFYING_LEVEL;
	public static ForgeConfigSpec.IntValue FORTIFYING_DURATION;

	public static ForgeConfigSpec.IntValue FREEZING_DURATION;

	public static ForgeConfigSpec.IntValue HEALING_EXPONENT;

	public static ForgeConfigSpec.BooleanValue MAGIC_MISSILE_DIGGING;
	public static ForgeConfigSpec.DoubleValue MAGIC_MISSILE_DAMAGE;

	public static void registerClientConfig() {
		var builder = new ForgeConfigSpec.Builder();

		builder.comment("Render settings").push("renderSettings");

		IcariaConfig.RENDER_CRYSTAL_RAYS = builder.comment("Default: true. Whether a Crystal should render rays.").define("renderRays", true);
		IcariaConfig.RENDER_DISTANCE_CRYSTAL_RAYS = builder.comment("Default: 256. Whether a Crystal should render rays based on distance to a player.").defineInRange("raysDistance", 256, 64, 1024);
		IcariaConfig.RENDER_FORGE_ITEMS = builder.comment("Default: true. Whether a Forge should render items.").define("renderItems", true);
		IcariaConfig.RENDER_DISTANCE_FORGE_ITEMS = builder.comment("Default: 256. Whether a Forge should render items based on distance to a player.").defineInRange("itemsDistance", 256, 64, 1024);
		IcariaConfig.RENDER_GRINDER_GEARS = builder.comment("Default: true. Whether a Grinder should render gears.").define("renderGears", true);
		IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS = builder.comment("Default: 256. Whether a Grinder should render gears based on distance to a player.").defineInRange("gearsDistance", 256, 64, 1024);
		IcariaConfig.RENDER_KETTLE_ITEMS = builder.comment("Default: true. Whether a Kettle should render items.").define("renderItems", true);
		IcariaConfig.RENDER_DISTANCE_KETTLE_ITEMS = builder.comment("Default: 256. Whether a Kettle should render items based on distance to a player.").defineInRange("itemsDistance", 256, 64, 1024);
		IcariaConfig.RENDER_KILN_ITEMS = builder.comment("Default: true. Whether a Kiln should render items.").define("renderItems", true);
		IcariaConfig.RENDER_DISTANCE_KILN_ITEMS = builder.comment("Default: 256. Whether a Kiln should render items based on distance to a player.").defineInRange("itemsDistance", 256, 64, 1024);

		builder.pop();

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, builder.build());
	}

	public static void registerCommonConfig() {
		var builder = new ForgeConfigSpec.Builder();

		builder.comment("Sound settings").push("soundSettings");

		IcariaConfig.FORGE_SOUNDS = builder.comment("Default: true. Whether a Forge should play sounds.").define("forgeSounds", true);
		IcariaConfig.GRINDER_SOUNDS = builder.comment("Default: true. Whether a Grinder should play sounds.").define("grinderSounds", true);
		IcariaConfig.KETTLE_SOUNDS = builder.comment("Default: true. Whether a Kettle should play sounds.").define("kettleSounds", true);
		IcariaConfig.KILN_SOUNDS = builder.comment("Default: true. Whether a Kiln should play sounds.").define("kilnSounds", true);

		builder.pop();
		builder.comment("Spawn settings").push("spawnSettings");

		IcariaConfig.SPAWN_ARACHNIDS = builder.comment("Default: true. Whether arachnids should spawn.").define("spawnArachnids", true);

		builder.pop();

		builder.comment("Spell Config").push("spellConfig");

		builder.comment("Configuration for the Spell Anti Gravity").push("antiGravitySpell");
		IcariaConfig.ANTI_GRAVITY_BLOCK_GRAVITY = builder.comment("Default: 0.05. The gravity value a block should experience.").defineInRange("antiGravityBlockGravity", 0.05d, 0.01d, 1.0d);
		IcariaConfig.ANTI_GRAVITY_LEVITATION_DURATION = builder.comment("Default: 300, The duration the Levitation effect should persist on Entities.").defineInRange("antiGravityLevitationDuration", 300,	20, 3600);
		builder.pop();

		builder.comment("Configuration for the Spell Bubble").push("bubbleSpell");
		IcariaConfig.BUBBLE_GRAVITY = builder.comment("Default: 0.00. The gravity the bubbles experience.").defineInRange("bubbleGravity", 0.00d, -1.00d, 1.00d);
		IcariaConfig.BUBBLE_DAMAGE = builder.comment("Default: 2.0. The amount of damage a bubble should deal.").defineInRange("bubbleDamage", 2.0d, -32768.0, 32768.0d);
		IcariaConfig.BUBBLE_DURATION = builder.comment("Default: 400. The amount of ticks a bubble should live.").defineInRange("bubbleDuration", 400, 20, 3600);
		IcariaConfig.BUBBLE_MIN_COUNT = builder.comment("Default: 4. The minimum amount of Bubbles that will be sent out.").defineInRange("bubbleMinCount", 4, 0, 16);
		IcariaConfig.BUBBLE_MAX_COUNT = builder.comment("Default: 4. The maximum amount of extra Bubbles that will be sent out.").defineInRange("bubbleMaxCount", 4, 0, 16);
		builder.pop();

		builder.comment("Configuration for the Spell Fortifying").push("fortifyingSpell");
		IcariaConfig.FORTIFYING_LEVEL = builder.comment("Default: 0. The Effect level Fortifying should apply.").defineInRange("fortifyingLevel", 0, 0, 5);
		IcariaConfig.FORTIFYING_DURATION = builder.comment("Default: 300. The Effect duration Fortifying should apply.").defineInRange("fortifyingDuration", 300, 20, 3600);
		builder.pop();

		builder.comment("Configuration for the Spell Freezing").push("freezingSpell");
		IcariaConfig.FREEZING_DURATION = builder.comment("Default: 100. The Effect duration Freezing should apply").defineInRange("freezingDuration", 100, 20, 3600);
		builder.pop();

		builder.comment("Configuration for the Spell Heal").push("healSpell");
		IcariaConfig.HEALING_EXPONENT = builder.comment("Default: 1. The exponent of healing 2^(healExponent+2) | 4 " + "<< healExponent").defineInRange("healExponent", 1, 0, 16);
		builder.pop();

		builder.comment("Configuration for the Spell Magic Missile").push("magicMissileSpell");
		IcariaConfig.MAGIC_MISSILE_DIGGING = builder.comment("Default: false. Should the Magic Missile Spell be capable of mining").define("magicMissileDigging",	false);
		IcariaConfig.MAGIC_MISSILE_DAMAGE = builder.comment("Default: 8.0. How much damage the Magic Missile Spell should deal").defineInRange("magicMissileDamage",	8.0d, -32768.0d, 32768.0d);
		builder.pop();

		builder.pop();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, builder.build());
	}

	public static void registerServerConfig() {
		var builder = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, builder.build());
	}
}
