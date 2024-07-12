package com.axanthic.icaria.client.particle.provider;

import com.axanthic.icaria.client.particle.IcariaSteamParticle;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSteamParticleProvider implements ParticleProvider<SimpleParticleType> {
	public SpriteSet set;

	public IcariaSteamParticleProvider(SpriteSet pSet) {
		this.set = pSet;
	}

	@Override
	public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pSpeedX, double pSpeedY, double pSpeedZ) {
		return new IcariaSteamParticle(pLevel, pX, pY, pZ, pSpeedX, pSpeedY, pSpeedZ, this.set);
	}
}
