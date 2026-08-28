package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.common.payload.ChestLabelPayload;
import com.axanthic.icaria.common.registry.IcariaDataComponents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

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
