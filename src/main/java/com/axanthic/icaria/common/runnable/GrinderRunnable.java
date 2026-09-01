package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.payload.GrinderPayload;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderRunnable implements Runnable {
	public GrinderPayload payload;

	public IPayloadContext payloadContext;

	public GrinderRunnable(GrinderPayload pPayload, IPayloadContext pPayloadContext) {
		this.payload = pPayload;
		this.payloadContext = pPayloadContext;
	}

	@Override
	public void run() {
		if (this.payloadContext.player().level().getBlockEntity(this.payload.blockPos) instanceof GrinderBlockEntity grinderBlockEntity) {
			grinderBlockEntity.tickClient = this.payload.tickClient;
		}
	}
}
