package com.axanthic.icaria.common.runnable;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.payload.TotemPayload;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
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
		var player = this.payloadContext.player();
		var entity = player.level().getEntity(this.payload.id);
		if (entity != null && entity.level() instanceof ClientLevel clientLevel) {
			clientLevel.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), SoundEvents.TOTEM_USE, entity.getSoundSource(), 1.0F, 1.0F, false);
			Minecraft.getInstance().particleEngine.createTrackingEmitter(entity, ParticleTypes.TOTEM_OF_UNDYING, 20);
			if (entity == player && player instanceof LocalPlayer localPlayer) {
				localPlayer.displayItemActivation(this.payload.itemStack);
			}
		}
	}
}
