package com.axanthic.icaria.common.payload;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.registry.IcariaStreamCodecs;
import com.axanthic.icaria.common.runnable.LootVaseRunnable;

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

public class LootVasePayload implements CustomPacketPayload {
	public boolean lootVase;

	public int id;

	public BlockState blockState;

	public static final StreamCodec<RegistryFriendlyByteBuf, LootVasePayload> STREAM_CODEC = CustomPacketPayload.codec(LootVasePayload::write, LootVasePayload::new);

	public static final Type<LootVasePayload> TYPE = new Type<>(IcariaIdentifiers.LOOT_VASE_PAYLOAD_TYPE);

	public LootVasePayload(boolean pLootVase, int pId, BlockState pBlockState) {
		this.lootVase = pLootVase;
		this.id = pId;
		this.blockState = pBlockState;
	}

	public LootVasePayload(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		this(ByteBufCodecs.BOOL.decode(pRegistryFriendlyByteBuf), ByteBufCodecs.INT.decode(pRegistryFriendlyByteBuf), IcariaStreamCodecs.BLOCK_STATE.decode(pRegistryFriendlyByteBuf));
	}

	public static void handle(LootVasePayload pPacket, IPayloadContext pPayloadContext) {
		pPayloadContext.enqueueWork(new LootVaseRunnable(pPacket, pPayloadContext));
	}

	public void write(RegistryFriendlyByteBuf pRegistryFriendlyByteBuf) {
		ByteBufCodecs.BOOL.encode(pRegistryFriendlyByteBuf, this.lootVase);
		ByteBufCodecs.INT.encode(pRegistryFriendlyByteBuf, this.id);
		IcariaStreamCodecs.BLOCK_STATE.encode(pRegistryFriendlyByteBuf, this.blockState);
	}

	@Override
	public Type<? extends CustomPacketPayload> type() {
		return LootVasePayload.TYPE;
	}
}
