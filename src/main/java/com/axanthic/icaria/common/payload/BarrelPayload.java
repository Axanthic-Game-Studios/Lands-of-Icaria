package com.axanthic.icaria.common.payload;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.registry.IcariaStreamCodecs;
import com.axanthic.icaria.common.runnable.BarrelRunnable;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BarrelPayload implements CustomPacketPayload {
	public boolean barrel;

	public int id;

	public BlockState blockState;

	public static final StreamCodec<RegistryFriendlyByteBuf, BarrelPayload> STREAM_CODEC = CustomPacketPayload.codec(BarrelPayload::write, BarrelPayload::new);

	public static final Type<BarrelPayload> TYPE = new Type<>(IcariaIdentifiers.BARREL_PAYLOAD_TYPE);

	public BarrelPayload(boolean pBarrel, int pId, BlockState pBlockState) {
		this.barrel = pBarrel;
		this.id = pId;
		this.blockState = pBlockState;
	}

	public BarrelPayload(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ByteBufCodecs.BOOL.decode(pRegistryFriendlyByteBuf), ByteBufCodecs.INT.decode(pRegistryFriendlyByteBuf), IcariaStreamCodecs.BLOCK_STATE.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(BarrelPayload pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new BarrelRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ByteBufCodecs.BOOL.encode(pRegistryFriendlyByteBuf, this.barrel);
		ByteBufCodecs.INT.encode(pRegistryFriendlyByteBuf, this.id);
		IcariaStreamCodecs.BLOCK_STATE.encode(pRegistryFriendlyByteBuf, this.blockState);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return BarrelPayload.TYPE;
	}
}
