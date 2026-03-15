package com.axanthic.icaria.common.config;

import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfig {
	public static ModConfigSpec.BooleanValue RENDER_CRYSTAL_RAYS;
	public static ModConfigSpec.BooleanValue SPAWN_ARACHNIDS;

	public static ModConfigSpec.IntValue RENDER_DISTANCE_CRYSTAL_RAYS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_FIREPLACE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_FORGE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_GRINDER_GEARS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_KETTLE_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_KILN_ITEMS;
	public static ModConfigSpec.IntValue RENDER_DISTANCE_SHELF_ITEMS;

	public static void registerClientConfig() {
		var builder = new ModConfigSpec.Builder();

		builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_settings").comment("Render Settings").push("Render Settings");

		IcariaConfig.RENDER_CRYSTAL_RAYS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_crystal_rays").comment("Default: true. Whether a Crystal should render Rays.").define("Render Crystal Rays", true);

		builder.pop();
		builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_settings").comment("Render Distance Settings").push("Render Distance Settings");

		IcariaConfig.RENDER_DISTANCE_CRYSTAL_RAYS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_crystal_rays").comment("Whether a Crystal should render Rays based on Distance to a Player.").defineInRange("Render Distance Crystal Rays", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_FIREPLACE_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_fireplace_items").comment("Whether a Fireplace should render Items based on Distance to a Player.").defineInRange("Render Distance Fireplace Items", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_FORGE_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_forge_items").comment("Whether a Forge should render Items based on Distance to a Player.").defineInRange("Render Distance Forge Items", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_grinder_gears").comment("Whether a Grinder should render Gears based on Distance to a Player.").defineInRange("Render Distance Grinder Gears", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_KETTLE_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_kettle_items").comment("Whether a Kettle should render Items based on Distance to a Player.").defineInRange("Render Distance Kettle Items", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_KILN_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_kiln_items").comment("Whether a Kiln should render Items based on Distance to a Player.").defineInRange("Render Distance Kiln Items", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_SHELF_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_distance_shelf_items").comment("Whether a Shelf should render Items based on Distance to a Player.").defineInRange("Render Distance Shelf Items", 256, 64, 1024);

		builder.pop();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.CLIENT, builder.build());
	}

	public static void registerCommonConfig() {
		var builder = new ModConfigSpec.Builder();

		builder.translation("configuration" + "." + IcariaIdents.ID + "." + "spawn_settings").comment("Spawn Settings").push("Spawn Settings");

		IcariaConfig.SPAWN_ARACHNIDS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "spawn_arachnids").comment("Default: true. Whether Arachnids should spawn.").define("Spawn Arachnids", true);

		builder.pop();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, builder.build());
	}

	public static void registerServerConfig() {
		var builder = new ModConfigSpec.Builder();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, builder.build());
	}
}
