package com.axanthic.icaria.common.variant;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaRegistryIds;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.core.ClientAsset;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStackTemplate;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FyshVariant(ClientAsset.ResourceTexture resourceTexture, ItemStackTemplate itemStackTemplate) {
	public static final Codec<FyshVariant> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			ClientAsset.ResourceTexture.CODEC.fieldOf("resourceTexture").forGetter(FyshVariant::resourceTexture),
			ItemStackTemplate.CODEC.fieldOf("itemStackTemplate").forGetter(FyshVariant::itemStackTemplate)
		).apply(instance, FyshVariant::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<FyshVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(IcariaRegistryIds.FYSH_VARIANT);
}
