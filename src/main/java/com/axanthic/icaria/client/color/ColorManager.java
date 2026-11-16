package com.axanthic.icaria.client.color;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ColorManager extends SimpleJsonResourceReloadListener<Color> {
	public static final Map<Identifier, Integer> CACHE = new HashMap<>();

	public ColorManager() {
		super(Color.CODEC, FileToIdConverter.json("colors"));
	}

	@Override
	public void apply(Map<Identifier, Color> pColors, ResourceManager pResourceManager, ProfilerFiller pProfilerFiller) {
		ColorManager.CACHE.clear();
		pColors.forEach((identifier, color) -> ColorManager.CACHE.put(identifier, 0xFF000000 | color.color()));
	}

	public static int fetch(Identifier pIdentifier) {
		return ColorManager.CACHE.getOrDefault(pIdentifier, 0xFFFFFFFF);
	}
}
