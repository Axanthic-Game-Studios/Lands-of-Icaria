package com.axanthic.icaria.common.network.packet;

import com.axanthic.icaria.common.network.runnable.ChestLabelRunnable;
import com.axanthic.icaria.common.registry.IcariaIdents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.network.handling.IPayloadContext;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelPacket implements CustomPacketPayload {
	public ItemStack stack;

	public String string;

	public static final StreamCodec<RegistryFriendlyByteBuf, ChestLabelPacket> STREAM_CODEC = CustomPacketPayload.codec(ChestLabelPacket::write, ChestLabelPacket::new);

	public static final Type<ChestLabelPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "chest_label"));

	public ChestLabelPacket(ItemStack pStack, String pString) {
		this.stack = pStack;
		this.string = pString;
	}

	public ChestLabelPacket(RegistryFriendlyByteBuf pBuffer) {
		this(ItemStack.STREAM_CODEC.decode(pBuffer), ByteBufCodecs.STRING_UTF8.decode(pBuffer));
	}

	public static void handler(ChestLabelPacket pPacket, IPayloadContext pContext) {
		pContext.enqueueWork(new ChestLabelRunnable(pPacket, pContext));
	}

	public void write(RegistryFriendlyByteBuf pBuffer) {
		ItemStack.STREAM_CODEC.encode(pBuffer, this.stack);
		ByteBufCodecs.STRING_UTF8.encode(pBuffer, this.string);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ChestLabelPacket.TYPE;
	}
}
