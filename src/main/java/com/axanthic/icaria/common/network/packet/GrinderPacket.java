package com.axanthic.icaria.common.network.packet;

import com.axanthic.icaria.common.network.runnable.GrinderRunnable;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderPacket implements CustomPacketPayload {
	public boolean tickClient;

	public BlockPos blockPos;

	public static final StreamCodec<RegistryFriendlyByteBuf, GrinderPacket> STREAM_CODEC = CustomPacketPayload.codec(GrinderPacket::write, GrinderPacket::new);

	public static final Type<GrinderPacket> TYPE = new Type<>(IcariaResourceLocations.GRINDER_PACKET_TYPE);

	public GrinderPacket(boolean pTickClient, BlockPos pBlockPos) {
		this.tickClient = pTickClient;
		this.blockPos = pBlockPos;
	}

	public GrinderPacket(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ByteBufCodecs.BOOL.decode(pRegistryFriendlyByteBuf), BlockPos.STREAM_CODEC.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(GrinderPacket pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new GrinderRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ByteBufCodecs.BOOL.encode(pRegistryFriendlyByteBuf, this.tickClient);
		BlockPos.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.blockPos);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return GrinderPacket.TYPE;
	}
}
