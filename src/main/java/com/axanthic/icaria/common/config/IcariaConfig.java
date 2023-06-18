package com.axanthic.icaria.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public class IcariaConfig {
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_GEARS;
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_RAYS;

	public static ForgeConfigSpec.BooleanValue RENDER_GEARS;
	public static ForgeConfigSpec.BooleanValue RENDER_RAYS;
	public static ForgeConfigSpec.BooleanValue GRINDER_SOUNDS;
	public static ForgeConfigSpec.BooleanValue SPAWN_ARACHNIDS;

	public static void registerClientConfig() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		builder.comment("Render settings").push("renderSettings");

		IcariaConfig.RENDER_GEARS = builder.comment("Default: true. Whether grinders should render their gears.").define("renderGears", true);
		IcariaConfig.RENDER_DISTANCE_GEARS = builder.comment("Default: 256. Whether grinders should render their gears based on range to players.").defineInRange("gearsDistance", 256, 64, 1024);
		IcariaConfig.RENDER_RAYS = builder.comment("Default: true. Whether crystals should render their rays.").define("renderRays", true);
		IcariaConfig.RENDER_DISTANCE_RAYS = builder.comment("Default: 256. Whether crystals should render their rays based on range to players.").defineInRange("raysDistance", 256, 64, 1024);

		builder.pop();

		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, builder.build());
	}

	public static void registerCommonConfig() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		builder.comment("Sound settings").push("soundSettings");

		IcariaConfig.GRINDER_SOUNDS = builder.comment("Default: true. Whether grinders should play sound.").define("grinderSounds", true);

		builder.pop();
		builder.comment("Spawn settings").push("spawnSettings");

		IcariaConfig.SPAWN_ARACHNIDS = builder.comment("Default: true. Whether arachnids should do spawn.").define("spawnArachnids", true);

		builder.pop();

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, builder.build());
	}

	public static void registerServerConfig() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, builder.build());
	}
}
