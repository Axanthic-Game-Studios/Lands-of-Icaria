package com.axanthic.icaria.common.config;

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

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, builder.build());
	}

	public static void registerServerConfig() {
		var builder = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, builder.build());
	}
}
