package com.axanthic.icaria.common.network.packet;

import com.axanthic.icaria.common.network.runnable.IcariaTotemRunnable;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTotemPacket implements CustomPacketPayload {
	public Holder<SoundEvent> soundEventHolder;

	public ItemStack stack;

	public static final StreamCodec<RegistryFriendlyByteBuf, IcariaTotemPacket> STREAM_CODEC = CustomPacketPayload.codec(IcariaTotemPacket::write, IcariaTotemPacket::new);

	public static final Type<IcariaTotemPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "icaria_totem"));

	public IcariaTotemPacket(ItemStack pItemStack, Holder<SoundEvent> pSoundEvent) {
		this.stack = pItemStack;
		this.soundEventHolder = pSoundEvent;
	}

	public IcariaTotemPacket(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf), SoundEvent.STREAM_CODEC.decode(pRegistryFriendlyByteBuf));
	}

	public static void handler(IcariaTotemPacket pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new IcariaTotemRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.stack);
		SoundEvent.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.soundEventHolder);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return IcariaTotemPacket.TYPE;
	}
}
