package com.axanthic.icaria.client.meta;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.registry.IcariaIds;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.server.packs.metadata.MetadataSectionType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record ColorMetadataSection(int color) {
	public static final Codec<ColorMetadataSection> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			Codec.INT.fieldOf("color").forGetter(ColorMetadataSection::color)
		).apply(instance, ColorMetadataSection::new)
	);

	public static final MetadataSectionType<ColorMetadataSection> TYPE = new MetadataSectionType<>(IcariaIds.ID, ColorMetadataSection.CODEC);
}
