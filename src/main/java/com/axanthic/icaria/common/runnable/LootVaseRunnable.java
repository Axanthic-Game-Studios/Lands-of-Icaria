package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.common.payload.LootVasePayload;
import com.axanthic.icaria.common.registry.IcariaAttachmentTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class LootVaseRunnable implements Runnable {
	public LootVasePayload payload;

	public IPayloadContext payloadContext;

	public LootVaseRunnable(LootVasePayload pPayload, IPayloadContext pPayloadContext) {
		this.payload = pPayload;
		this.payloadContext = pPayloadContext;
	}

	@Override
	public void run() {
		var player = this.payloadContext.player().level().getEntity(payload.id);
		if (player != null) {
			player.setData(IcariaAttachmentTypes.LOOT_VASE, this.payload.lootVase);
			player.setData(IcariaAttachmentTypes.LOOT_VASE_BLOCK_STATE, this.payload.blockState);
		}
	}
}
