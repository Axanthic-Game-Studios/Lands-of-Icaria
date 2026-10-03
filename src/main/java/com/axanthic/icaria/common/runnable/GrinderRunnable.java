package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.payload.GrinderPayload;

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
