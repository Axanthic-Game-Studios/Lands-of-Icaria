package com.axanthic.icaria.common.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;

import net.neoforged.neoforge.network.handling.IPayloadContext;

public class TotemRunnable implements Runnable {
	public IPayloadContext context;
	public TotemPacket packet;

	public TotemRunnable(TotemPacket pPacket, IPayloadContext pContext) {
		this.context = pContext;
		this.packet = pPacket;
	}

	@Override
	public void run() {
		var minecraft = Minecraft.getInstance();
		var player = this.context.player();
		minecraft.gameRenderer.displayItemActivation(this.packet.stack);
		minecraft.particleEngine.createTrackingEmitter(player, ParticleTypes.TOTEM_OF_UNDYING, 20);
		if (player.level() instanceof ClientLevel clientLevel) {
			clientLevel.playLocalSound(player.getX(), player.getY(), player.getZ(), this.packet.sound.value(), player.getSoundSource(), 1.0F, 1.0F, false);
		}
	}
}
