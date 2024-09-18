package com.axanthic.icaria.common.network.packet;

import com.axanthic.icaria.common.network.runnable.TotemRunnable;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.network.handling.IPayloadContext;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemPacket implements CustomPacketPayload {
	public Holder<SoundEvent> sound;

	public ItemStack stack;

	public static final StreamCodec<RegistryFriendlyByteBuf, TotemPacket> STREAM_CODEC = CustomPacketPayload.codec(TotemPacket::write, TotemPacket::new);

	public static final Type<TotemPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "totem"));

	public TotemPacket(ItemStack pStack, Holder<SoundEvent> pSound) {
		this.sound = pSound;
		this.stack = pStack;
	}

	public TotemPacket(RegistryFriendlyByteBuf pBuffer) {
		this(ItemStack.STREAM_CODEC.decode(pBuffer), SoundEvent.STREAM_CODEC.decode(pBuffer));
	}

	public static void handler(TotemPacket pPacket, IPayloadContext pContext) {
		pContext.enqueueWork(new TotemRunnable(pPacket, pContext));
	}

	public void write(RegistryFriendlyByteBuf pBuffer) {
		ItemStack.STREAM_CODEC.encode(pBuffer, this.stack);
		SoundEvent.STREAM_CODEC.encode(pBuffer, this.sound);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TotemPacket.TYPE;
	}
}
