package com.axanthic.blab;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;

import java.io.File;

public class ConfigHandler {

	public static Configuration config;

	// Categories
	public static String compat = "Compatibility";

	public static Boolean albedo = true;

	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}

	public static void syncConfig() {
		config.setCategoryComment(compat, "Cross mod compatibility settings");
		
		albedo = Loader.isModLoaded("albedo") && config.getBoolean("albedo", compat, albedo, "Albedo compatibility");

		if(config.hasChanged())
			config.save();
	}
}
