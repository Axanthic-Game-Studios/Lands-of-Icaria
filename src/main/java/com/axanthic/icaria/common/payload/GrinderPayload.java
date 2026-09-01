package com.axanthic.icaria.common.payload;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.runnable.GrinderRunnable;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderPayload implements CustomPacketPayload {
	public boolean tickClient;

	public BlockPos blockPos;

	public static final StreamCodec<RegistryFriendlyByteBuf, GrinderPayload> STREAM_CODEC = CustomPacketPayload.codec(GrinderPayload::write, GrinderPayload::new);

	public static final Type<GrinderPayload> TYPE = new Type<>(IcariaIdentifiers.GRINDER_PAYLOAD_TYPE);

	public GrinderPayload(boolean pTickClient, BlockPos pBlockPos) {
		this.tickClient = pTickClient;
		this.blockPos = pBlockPos;
	}

	public GrinderPayload(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ByteBufCodecs.BOOL.decode(pRegistryFriendlyByteBuf), BlockPos.STREAM_CODEC.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(GrinderPayload pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new GrinderRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ByteBufCodecs.BOOL.encode(pRegistryFriendlyByteBuf, this.tickClient);
		BlockPos.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.blockPos);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return GrinderPayload.TYPE;
	}
}
