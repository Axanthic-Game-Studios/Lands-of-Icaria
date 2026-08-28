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

public record FicheVariant(ClientAsset.ResourceTexture clientAsset, ItemStack itemStack) {
	public static final Codec<FicheVariant> CODEC = RecordCodecBuilder.create(
		instance -> instance.group(
			ClientAsset.ResourceTexture.CODEC.fieldOf("asset").forGetter(FicheVariant::clientAsset),
			ItemStack.CODEC.fieldOf("stack").forGetter(FicheVariant::itemStack)
		).apply(instance, FicheVariant::new)
	);

	public static final StreamCodec<RegistryFriendlyByteBuf, Holder<FicheVariant>> STREAM_CODEC = ByteBufCodecs.holderRegistry(IcariaRegistries.FICHE_VARIANT);
}
