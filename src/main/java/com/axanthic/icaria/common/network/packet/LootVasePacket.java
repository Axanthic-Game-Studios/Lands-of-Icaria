package com.axanthic.icaria.common.network.packet;

import com.axanthic.icaria.common.network.runnable.LootVaseRunnable;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;
import com.axanthic.icaria.common.registry.IcariaStreamCodecs;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.level.block.state.BlockState;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVasePacket implements CustomPacketPayload {
	public boolean lootVase;

	public BlockPos blockPos;

	public BlockState blockState;

	public static final StreamCodec<RegistryFriendlyByteBuf, LootVasePacket> STREAM_CODEC = CustomPacketPayload.codec(LootVasePacket::write, LootVasePacket::new);

	public static final Type<LootVasePacket> TYPE = new Type<>(IcariaResourceLocations.LOOT_VASE_PACKET_TYPE);

	public LootVasePacket(boolean pLootVase, BlockPos pBlockPos, BlockState pBlockState) {
		this.lootVase = pLootVase;
		this.blockPos = pBlockPos;
		this.blockState = pBlockState;
	}

	public LootVasePacket(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ByteBufCodecs.BOOL.decode(pRegistryFriendlyByteBuf), BlockPos.STREAM_CODEC.decode(pRegistryFriendlyByteBuf), IcariaStreamCodecs.BLOCK_STATE.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(LootVasePacket pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new LootVaseRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ByteBufCodecs.BOOL.encode(pRegistryFriendlyByteBuf, this.lootVase);
		BlockPos.STREAM_CODEC.encode(pRegistryFriendlyByteBuf, this.blockPos);
		IcariaStreamCodecs.BLOCK_STATE.encode(pRegistryFriendlyByteBuf, this.blockState);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return LootVasePacket.TYPE;
	}
}
