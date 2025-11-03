package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.common.entity.GrinderBlockEntity;
import com.axanthic.icaria.common.packet.GrinderPacket;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class GrinderRunnable implements Runnable {
	public IPayloadContext payloadContext;

	public GrinderPacket packet;

	public GrinderRunnable(GrinderPacket pPacket, IPayloadContext pPayloadContext) {
		this.payloadContext = pPayloadContext;
		this.packet = pPacket;
	}

	@Override
	public void run() {
		if (this.payloadContext.player().level().getBlockEntity(this.packet.blockPos) instanceof GrinderBlockEntity grinderBlockEntity) {
			grinderBlockEntity.tickClient = this.packet.tickClient;
		}
	}
}
