package com.axanthic.icaria.common.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig.Type;

public class IcariaConfig {
	public static ForgeConfigSpec.BooleanValue RENDER_RAYS;

	public static void register() {
		registerClientConfigs();
		registerCommonConfigs();
		registerServerConfigs();
	}

	public static void registerClientConfigs() {
		ForgeConfigSpec.Builder CLIENT = new ForgeConfigSpec.Builder();
		CLIENT.comment("Render settings").push("renderSettings");

		RENDER_RAYS = CLIENT.comment("Default: true. Whether crystals and the Myrmeke queen should render rays.").define("renderRays", true);

		CLIENT.pop();
		ModLoadingContext.get().registerConfig(Type.CLIENT, CLIENT.build());
	}

	public static void registerCommonConfigs() {
		ForgeConfigSpec.Builder COMMON = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(Type.COMMON, COMMON.build());
	}

	public static void registerServerConfigs() {
		ForgeConfigSpec.Builder SERVER = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(Type.SERVER, SERVER.build());
	}
}
