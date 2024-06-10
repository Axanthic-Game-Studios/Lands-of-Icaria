package com.axanthic.icaria.common.config;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class IcariaConfig {
	public static ModConfigSpec.BooleanValue RENDER_CRYSTAL_RAYS;
	public static ModConfigSpec.BooleanValue RENDER_FORGE_ITEMS;
	public static ModConfigSpec.BooleanValue RENDER_GRINDER_GEARS;
	public static ModConfigSpec.BooleanValue RENDER_KETTLE_ITEMS;
	public static ModConfigSpec.BooleanValue RENDER_KILN_ITEMS;
	public static ModConfigSpec.BooleanValue FORGE_SOUNDS;
	public static ModConfigSpec.BooleanValue GRINDER_SOUNDS;
	public static ModConfigSpec.BooleanValue KETTLE_SOUNDS;
	public static ModConfigSpec.BooleanValue KILN_SOUNDS;
	public static ModConfigSpec.BooleanValue SPAWN_ARACHNIDS;

	public static ModConfigSpec.IntValue RENDER_DISTANCE_CRYSTAL_RAYS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_FORGE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_GRINDER_GEARS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_KETTLE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_KILN_ITEMS;

	public static void registerClientConfig() {
		var builder = new ModConfigSpec.Builder();

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
		var builder = new ModConfigSpec.Builder();

		builder.comment("Sound settings").push("soundSettings");

		IcariaConfig.FORGE_SOUNDS = builder.comment("Default: true. Whether a Forge should play sounds.").define("forgeSounds", true);
		IcariaConfig.GRINDER_SOUNDS = builder.comment("Default: true. Whether a Grinder should play sounds.").define("grinderSounds", true);
		IcariaConfig.KETTLE_SOUNDS = builder.comment("Default: true. Whether a Kettle should play sounds.").define("kettleSounds", true);
		IcariaConfig.KILN_SOUNDS = builder.comment("Default: true. Whether a Kiln should play sounds.").define("kilnSounds", true);

		builder.pop();
		builder.comment("Spawn settings").push("spawnSettings");

		IcariaConfig.SPAWN_ARACHNIDS = builder.comment("Default: true. Whether arachnids should spawn.").define("spawnArachnids", true);

		builder.pop();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, builder.build());
	}

	public static void registerServerConfig() {
		var builder = new ModConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, builder.build());
	}
}
