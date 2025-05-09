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
		var player = this.payloadContext.player().level().getEntity(packet.id);
		if (player != null) {
			player.setData(IcariaAttachmentTypes.LOOT_VASE, this.packet.lootVase);
			player.setData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_POS, this.packet.blockPos);
			player.setData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE, this.packet.blockState);
		}
	}
}
