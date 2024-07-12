package com.axanthic.icaria.client.particle.provider;

import com.axanthic.icaria.client.particle.IcariaPortalParticle;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaPortalParticleProvider implements ParticleProvider<SimpleParticleType> {
	public SpriteSet set;

	public IcariaPortalParticleProvider(SpriteSet pSet) {
		this.set = pSet;
	}

	@Override
	public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pSpeedX, double pSpeedY, double pSpeedZ) {
		var particle = new IcariaPortalParticle(pLevel, pX, pY, pZ, pSpeedX, pSpeedY, pSpeedZ);
		particle.pickSprite(this.set);
		return particle;
	}
}
