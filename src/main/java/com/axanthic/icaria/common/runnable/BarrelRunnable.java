package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.common.payload.BarrelPayload;
import com.axanthic.icaria.common.registry.IcariaAttachmentTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class BarrelRunnable implements Runnable {
	public BarrelPayload payload;

	public IPayloadContext payloadContext;

	public BarrelRunnable(BarrelPayload pPayload, IPayloadContext pPayloadContext) {
		this.payload = pPayload;
		this.payloadContext = pPayloadContext;
	}

	@Override
	public void run() {
		var player = this.payloadContext.player().level().getEntity(payload.id);
		if (player != null) {
			player.setData(IcariaAttachmentTypes.BARREL, this.payload.barrel);
			player.setData(IcariaAttachmentTypes.BARREL_BLOCK_STATE, this.payload.blockState);
		}
	}
}
