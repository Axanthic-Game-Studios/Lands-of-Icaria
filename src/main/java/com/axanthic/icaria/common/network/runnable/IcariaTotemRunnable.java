package com.axanthic.icaria.common.network.runnable;

import com.axanthic.icaria.common.network.packet.IcariaTotemPacket;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTotemRunnable implements Runnable {
	public IPayloadContext payloadContext;

	public IcariaTotemPacket packet;

	public IcariaTotemRunnable(IcariaTotemPacket pPacket, IPayloadContext pPayloadContext) {
		this.payloadContext = pPayloadContext;
		this.packet = pPacket;
	}

	@Override
	public void run() {
		var minecraft = Minecraft.getInstance();
		var player = this.payloadContext.player();
		minecraft.gameRenderer.displayItemActivation(this.packet.stack);
		minecraft.particleEngine.createTrackingEmitter(player, ParticleTypes.TOTEM_OF_UNDYING, 20);
		if (player.level() instanceof ClientLevel clientLevel) {
			clientLevel.playLocalSound(player.getX(), player.getY(), player.getZ(), this.packet.soundEventHolder.value(), player.getSoundSource(), 1.0F, 1.0F, false);
		}
	}
}
