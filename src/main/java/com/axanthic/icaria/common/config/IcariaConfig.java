package com.axanthic.icaria.common.config;

import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

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

		builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_settings").comment("Render Settings").push("renderSettings");

		IcariaConfig.RENDER_CRYSTAL_RAYS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_crystal").comment("Default: true. Whether a Crystal should render rays.").define("renderCrystal", true);
		IcariaConfig.RENDER_FORGE_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_forge").comment("Default: true. Whether a Forge should render items.").define("renderForge", true);
		IcariaConfig.RENDER_GRINDER_GEARS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_grinder").comment("Default: true. Whether a Grinder should render gears.").define("renderGrinder", true);
		IcariaConfig.RENDER_KETTLE_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_kettle").comment("Default: true. Whether a Kettle should render items.").define("renderKettle", true);
		IcariaConfig.RENDER_KILN_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "render_kiln").comment("Default: true. Whether a Kiln should render items.").define("renderKiln", true);
		IcariaConfig.RENDER_DISTANCE_CRYSTAL_RAYS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "crystal_distance").comment("Default: 256. Whether a Crystal should render rays based on distance to a player.").defineInRange("crystalDistance", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_FORGE_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "forge_distance").comment("Default: 256. Whether a Forge should render items based on distance to a player.").defineInRange("forgeDistance", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_GRINDER_GEARS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "grinder_distance").comment("Default: 256. Whether a Grinder should render gears based on distance to a player.").defineInRange("grinderDistance", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_KETTLE_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "kettle_distance").comment("Default: 256. Whether a Kettle should render items based on distance to a player.").defineInRange("kettleDistance", 256, 64, 1024);
		IcariaConfig.RENDER_DISTANCE_KILN_ITEMS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "kiln_distance").comment("Default: 256. Whether a Kiln should render items based on distance to a player.").defineInRange("kilnDistance", 256, 64, 1024);

		builder.pop();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.CLIENT, builder.build());
	}

	public static void registerCommonConfig() {
		var builder = new ModConfigSpec.Builder();

		builder.translation("configuration" + "." + IcariaIdents.ID + "." + "sound_settings").comment("Sound Settings").push("soundSettings");

		IcariaConfig.FORGE_SOUNDS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "forge_sounds").comment("Default: true. Whether a Forge should play sounds.").define("forgeSounds", true);
		IcariaConfig.GRINDER_SOUNDS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "grinder_sounds").comment("Default: true. Whether a Grinder should play sounds.").define("grinderSounds", true);
		IcariaConfig.KETTLE_SOUNDS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "kettle_sounds").comment("Default: true. Whether a Kettle should play sounds.").define("kettleSounds", true);
		IcariaConfig.KILN_SOUNDS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "kiln_sounds").comment("Default: true. Whether a Kiln should play sounds.").define("kilnSounds", true);

		builder.pop();
		builder.translation("configuration" + "." + IcariaIdents.ID + "." + "spawn_settings").comment("Spawn Settings").push("spawnSettings");

		IcariaConfig.SPAWN_ARACHNIDS = builder.translation("configuration" + "." + IcariaIdents.ID + "." + "spawn_arachnids").comment("Default: true. Whether arachnids should spawn.").define("spawnArachnids", true);

		builder.pop();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.COMMON, builder.build());
	}

	public static void registerServerConfig() {
		var builder = new ModConfigSpec.Builder();

		ModLoadingContext.get().getActiveContainer().registerConfig(ModConfig.Type.SERVER, builder.build());
	}
}
