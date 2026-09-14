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

public record FisshhVariant(ClientAsset.ResourceTexture resourceTexture, ItemStackTemplate itemStackTemplate) {
	public static final Codec<FisshhVariant> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			ClientAsset.ResourceTexture.CODEC.fieldOf("resourceTexture").forGetter(FisshhVariant::resourceTexture),
			ItemStackTemplate.CODEC.fieldOf("itemStackTemplate").forGetter(FisshhVariant::itemStackTemplate)
		).apply(instance, FisshhVariant::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<FisshhVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(IcariaRegistries.FISSHH_VARIANT);
}
