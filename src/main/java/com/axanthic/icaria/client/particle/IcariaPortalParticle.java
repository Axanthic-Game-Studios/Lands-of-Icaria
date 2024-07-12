package com.axanthic.icaria.client.particle;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.PortalParticle;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalParticle extends PortalParticle {
	public IcariaPortalParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pSpeedX, double pSpeedY, double pSpeedZ) {
		super(pLevel, pX, pY, pZ, pSpeedX, pSpeedY, pSpeedZ);
		float col = this.random.nextFloat() * 0.4F + 0.4F;
		this.rCol = col;
		this.gCol = col;
		this.bCol = 0.0F;
	}
}
