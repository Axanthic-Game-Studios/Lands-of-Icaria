package com.axanthic.icaria.client.particle.provider;

import com.axanthic.icaria.client.particle.IcariaSteamParticle;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSteamParticleProvider implements ParticleProvider<SimpleParticleType> {
	public SpriteSet spriteSet;

	public IcariaSteamParticleProvider(SpriteSet pSpriteSet) {
		this.spriteSet = pSpriteSet;
	}

	@Override
	public Particle createParticle(SimpleParticleType pSimpleParticleType, ClientLevel pClientLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, RandomSource pRandomSource) {
		return new IcariaSteamParticle(pClientLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.spriteSet);
	}
}
