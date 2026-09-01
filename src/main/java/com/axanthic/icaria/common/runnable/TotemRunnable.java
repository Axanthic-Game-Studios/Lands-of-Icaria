package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.common.payload.TotemPayload;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;

import net.neoforged.neoforge.network.handling.IPayloadContext;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class TotemRunnable implements Runnable {
	public TotemPayload payload;

	public IPayloadContext payloadContext;

	public TotemRunnable(TotemPayload pPayload, IPayloadContext pPayloadContext) {
		this.payload = pPayload;
		this.payloadContext = pPayloadContext;
	}

	@Override
	public void run() {
		var minecraft = Minecraft.getInstance();
		var player = this.payloadContext.player().level().getEntity(payload.id);
		if (player != null && player.level() instanceof ClientLevel clientLevel) {
			clientLevel.playLocalSound(player.getX(), player.getY(), player.getZ(), SoundEvents.TOTEM_USE, player.getSoundSource(), 1.0F, 1.0F, false);
			minecraft.particleEngine.createTrackingEmitter(player, ParticleTypes.TOTEM_OF_UNDYING, 20);
			if (player == this.payloadContext.player()) {
				minecraft.gameRenderer.displayItemActivation(this.payload.itemStack);
			}
		}
	}
}
