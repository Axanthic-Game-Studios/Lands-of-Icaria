package com.axanthic.icaria.common.variant;

import com.axanthic.icaria.data.registry.IcariaRegistries;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.ClientAsset;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public record FyshVariant(ClientAsset.ResourceTexture clientAsset, ItemStack itemStack) {
	public static final Codec<FyshVariant> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			ClientAsset.ResourceTexture.CODEC.fieldOf("asset").forGetter(FyshVariant::clientAsset),
			ItemStack.CODEC.fieldOf("stack").forGetter(FyshVariant::itemStack)
		).apply(instance, FyshVariant::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<FyshVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(IcariaRegistries.FYSH_VARIANT);
}
