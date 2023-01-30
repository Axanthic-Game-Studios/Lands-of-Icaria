package com.axanthic.icaria.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

public class IcariaConfig {
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_GEARS;
	public static ForgeConfigSpec.IntValue RENDER_DISTANCE_RAYS;
	public static ForgeConfigSpec.DoubleValue SOUND_VOLUME_GRINDER;
	public static ForgeConfigSpec.BooleanValue RENDER_GEARS;
	public static ForgeConfigSpec.BooleanValue RENDER_RAYS;
	public static ForgeConfigSpec.BooleanValue SOUND_GRINDER;

	public static void register() {
		registerClientConfigs();
		registerCommonConfigs();
		registerServerConfigs();
	}

	public static void registerClientConfigs() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.comment("Render settings").push("renderSettings");

		RENDER_GEARS = builder.comment("Default: true. Whether grinders should render their gears.").define("renderGears", true);
		RENDER_DISTANCE_GEARS = builder.comment("Default: 64. Whether grinders should render their gears based on range to players.").defineInRange("gearsDistance", 64, 16, 256);
		RENDER_RAYS = builder.comment("Default: true. Whether crystals should render their rays.").define("renderRays", true);
		RENDER_DISTANCE_RAYS = builder.comment("Default: 64. Whether crystals should render their rays based on range to players.").defineInRange("raysDistance", 64, 16, 256);

		builder.pop();
		ModLoadingContext.get().registerConfig(Type.CLIENT, builder.build());
	}

	public static void registerCommonConfigs() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.comment("Sound settings").push("soundSettings");

		SOUND_GRINDER = builder.comment("Default: true. Whether grinders should play sound.").define("soundGrinder", true);
		SOUND_VOLUME_GRINDER = builder.comment("Default: 1.0. Whether grinders should play sound based on volume.").defineInRange("volumeGrinder", 1.0D, 0.0D, 1.0D);

		builder.pop();
		ModLoadingContext.get().registerConfig(Type.COMMON, builder.build());
	}

	public static void registerServerConfigs() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(Type.SERVER, builder.build());
	}
}
