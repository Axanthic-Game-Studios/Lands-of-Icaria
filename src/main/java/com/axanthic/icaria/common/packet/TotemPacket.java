package com.axanthic.icaria.common.packet;

import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.runnable.TotemRunnable;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemPacket implements CustomPacketPayload {
	public int id;

	public ItemStack itemStack;

	public static final StreamCodec<RegistryFriendlyByteBuf, TotemPacket> STREAM_CODEC = CustomPacketPayload.codec(TotemPacket::write, TotemPacket::new);

	public static final Type<TotemPacket> TYPE = new Type<>(IcariaResourceLocations.TOTEM_PACKET_TYPE);

	public TotemPacket(int pId, ItemStack pItemStack) {
		this.id = pId;
		this.itemStack = pItemStack;
	}

	public TotemPacket(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ByteBufCodecs.INT.decode(pRegistryFriendlyByteBuf), ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(TotemPacket pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new TotemRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ByteBufCodecs.INT.encode(pRegistryFriendlyByteBuf, this.id);
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.itemStack);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TotemPacket.TYPE;
	}
}
