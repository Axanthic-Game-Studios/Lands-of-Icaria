package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.payload.ChestLabelPayload;
import com.axanthic.icaria.common.registry.IcariaDataComponents;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelRunnable implements Runnable {
	public ChestLabelPayload payload;

	public IPayloadContext payloadContext;

	public ChestLabelRunnable(ChestLabelPayload pPayload, IPayloadContext pPayloadContext) {
		this.payload = pPayload;
		this.payloadContext = pPayloadContext;
	}

	@Override
	public void run() {
		this.payloadContext.player().getMainHandItem().set(IcariaDataComponents.LABEL, this.payload.string);
	}
}
