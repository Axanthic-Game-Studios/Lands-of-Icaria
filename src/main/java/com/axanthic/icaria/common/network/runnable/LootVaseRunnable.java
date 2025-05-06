package com.axanthic.icaria.common.network.runnable;

import com.axanthic.icaria.common.network.packet.LootVasePacket;
import com.axanthic.icaria.common.registry.IcariaAttachmentTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseRunnable implements Runnable {
	public IPayloadContext payloadContext;

	public LootVasePacket packet;

	public LootVaseRunnable(LootVasePacket pPacket, IPayloadContext pPayloadContext) {
		this.payloadContext = pPayloadContext;
		this.packet = pPacket;
	}

	@Override
	public void run() {
		this.payloadContext.player().setData(IcariaAttachmentTypes.LOOT_VASE, this.packet.lootVase);
		this.payloadContext.player().setData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_POS, this.packet.blockPos);
		this.payloadContext.player().setData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE, this.packet.blockState);
	}
}
