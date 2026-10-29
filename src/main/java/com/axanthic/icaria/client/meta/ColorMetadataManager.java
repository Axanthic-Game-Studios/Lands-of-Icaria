package com.axanthic.icaria.client.meta;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ColorMetadataManager implements ResourceManagerReloadListener {
	public static final Map<Identifier, Integer> CACHE = new HashMap<>();

	@Override
	public void onResourceManagerReload(ResourceManager pResourceManager) {
		ColorMetadataManager.CACHE.clear();
	}

	public static int resolve(Identifier pIdentifier) {
		return ColorMetadataManager.CACHE.computeIfAbsent(pIdentifier, ColorMetadataManager::extract);
	}

	public static int extract(Identifier pIdentifier) {
		try {
			return Minecraft.getInstance()
				.getResourceManager()
				.getResourceOrThrow(pIdentifier.withPath(s -> "textures" + "/" + s + "." + "png"))
				.metadata()
				.getSection(ColorMetadataSection.TYPE)
				.map(colorMetadataSection -> 0xFF000000 | colorMetadataSection.color())
				.orElse(0xFFFFFFFF);
		} catch (Exception pException) {
			return 0xFFFFFFFF;
		}
	}
}
