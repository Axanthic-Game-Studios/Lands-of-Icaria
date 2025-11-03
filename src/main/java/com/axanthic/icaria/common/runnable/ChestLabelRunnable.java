package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.common.packet.ChestLabelPacket;
import com.axanthic.icaria.common.registry.IcariaDataComponents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestLabelRunnable implements Runnable {
	public IPayloadContext payloadContext;

	public ChestLabelPacket packet;

	public ChestLabelRunnable(ChestLabelPacket pPacket, IPayloadContext pPayloadContext) {
		this.payloadContext = pPayloadContext;
		this.packet = pPacket;
	}

	@Override
	public void run() {
		this.payloadContext.player().getMainHandItem().set(IcariaDataComponents.LABEL, this.packet.string);
	}
}
