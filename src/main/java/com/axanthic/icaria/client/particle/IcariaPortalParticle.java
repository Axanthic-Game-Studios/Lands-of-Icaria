package com.axanthic.icaria.client.particle;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.PortalParticle;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalParticle extends PortalParticle {
	public IcariaPortalParticle(ClientLevel pClientLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
		super(pClientLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
		var f = this.random.nextFloat() * 0.4F + 0.4F;
		this.rCol = f;
		this.gCol = f;
		this.bCol = 0.0F;
	}
}
