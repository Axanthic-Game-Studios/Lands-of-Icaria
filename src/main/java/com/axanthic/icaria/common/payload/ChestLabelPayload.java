package com.axanthic.icaria.common.payload;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.runnable.ChestLabelRunnable;

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

public class ChestLabelPayload implements CustomPacketPayload {
	public ItemStack itemStack;

	public String string;

	public static final StreamCodec<RegistryFriendlyByteBuf, ChestLabelPayload> STREAM_CODEC = CustomPacketPayload.codec(ChestLabelPayload::write, ChestLabelPayload::new);

	public static final Type<ChestLabelPayload> TYPE = new Type<>(IcariaIdentifiers.CHEST_LABEL_PAYLOAD_TYPE);

	public ChestLabelPayload(ItemStack pItemStack, String pString) {
		this.itemStack = pItemStack;
		this.string = pString;
	}

	public ChestLabelPayload(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf), ByteBufCodecs.STRING_UTF8.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(ChestLabelPayload pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new ChestLabelRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.itemStack);
		ByteBufCodecs.STRING_UTF8.encode(pRegistryFriendlyByteBuf, this.string);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ChestLabelPayload.TYPE;
	}
}