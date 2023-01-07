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
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
		builder.comment("Render settings").push("renderSettings");

		RENDER_RAYS = builder.comment("Default: true. Whether crystals and the Myrmeke queen should render rays.").define("renderRays", true);

		builder.pop();
		ModLoadingContext.get().registerConfig(Type.CLIENT, builder.build());
	}

	public static void registerCommonConfigs() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(Type.COMMON, builder.build());
	}

	public static void registerServerConfigs() {
		ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

		ModLoadingContext.get().registerConfig(Type.SERVER, builder.build());
	}
}
