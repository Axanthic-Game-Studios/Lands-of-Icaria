package com.axanthic.icaria.common.variant;

import com.axanthic.icaria.data.registry.IcariaRegistries;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.ClientAsset;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStackTemplate;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FeeshVariant(ClientAsset.ResourceTexture resourceTexture, ItemStackTemplate itemStackTemplate) {
	public static final Codec<FeeshVariant> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			ClientAsset.ResourceTexture.CODEC.fieldOf("resourceTexture").forGetter(FeeshVariant::resourceTexture),
			ItemStackTemplate.CODEC.fieldOf("itemStackTemplate").forGetter(FeeshVariant::itemStackTemplate)
		).apply(instance, FeeshVariant::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<FeeshVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(IcariaRegistries.FEESH_VARIANT);
}
