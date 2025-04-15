package com.axanthic.icaria.common.network.packet;

import com.axanthic.icaria.common.network.runnable.ChestLabelRunnable;
import com.axanthic.icaria.common.registry.IcariaIdents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelPacket implements CustomPacketPayload {
	public ItemStack itemStack;

	public String string;

	public static final StreamCodec<RegistryFriendlyByteBuf, ChestLabelPacket> STREAM_CODEC = CustomPacketPayload.codec(ChestLabelPacket::write, ChestLabelPacket::new);

	public static final Type<ChestLabelPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "chest_label"));

	public ChestLabelPacket(ItemStack pItemStack, String pString) {
		this.itemStack = pItemStack;
		this.string = pString;
	}

	public ChestLabelPacket(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ItemStack.STREAM_CODEC.decode(pRegistryFriendlyByteBuf), ByteBufCodecs.STRING_UTF8.decode(pRegistryFriendlyByteBuf));
	}

	public static void handler(ChestLabelPacket pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new ChestLabelRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ItemStack.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.itemStack);
		ByteBufCodecs.STRING_UTF8.encode(pRegistryFriendlyByteBuf, this.string);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return ChestLabelPacket.TYPE;
	}
}