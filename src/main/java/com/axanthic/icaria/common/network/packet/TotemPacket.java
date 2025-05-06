package com.axanthic.icaria.common.network.packet;

import com.axanthic.icaria.common.network.runnable.TotemRunnable;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemPacket implements CustomPacketPayload {
	public Holder<SoundEvent> soundEvent;

	public ItemStack itemStack;

	public static final StreamCodec<RegistryFriendlyByteBuf, TotemPacket> STREAM_CODEC = CustomPacketPayload.codec(TotemPacket::write, TotemPacket::new);

	public static final Type<TotemPacket> TYPE = new Type<>(IcariaResourceLocations.TOTEM_PACKET_TYPE);

	public TotemPacket(ItemStack pItemStack, Holder<SoundEvent> pSoundEvent) {
		this.itemStack = pItemStack;
		this.soundEvent = pSoundEvent;
	}

	public TotemPacket(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf), SoundEvent.STREAM_CODEC.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(TotemPacket pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new TotemRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.itemStack);
		SoundEvent.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.soundEvent);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TotemPacket.TYPE;
	}
}
