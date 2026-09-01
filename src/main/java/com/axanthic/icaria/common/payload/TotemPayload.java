package com.axanthic.icaria.common.payload;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.runnable.TotemRunnable;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemPayload implements CustomPacketPayload {
	public int id;

	public ItemStack itemStack;

	public static final StreamCodec<RegistryFriendlyByteBuf, TotemPayload> STREAM_CODEC = CustomPacketPayload.codec(TotemPayload::write, TotemPayload::new);

	public static final Type<TotemPayload> TYPE = new Type<>(IcariaIdentifiers.TOTEM_PAYLOAD_TYPE);

	public TotemPayload(int pId, ItemStack pItemStack) {
		this.id = pId;
		this.itemStack = pItemStack;
	}

	public TotemPayload(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ByteBufCodecs.INT.decode(pRegistryFriendlyByteBuf), ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(TotemPayload pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new TotemRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ByteBufCodecs.INT.encode(pRegistryFriendlyByteBuf, this.id);
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.itemStack);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return TotemPayload.TYPE;
	}
}
