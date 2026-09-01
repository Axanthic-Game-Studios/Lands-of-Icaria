package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.registry.IcariaIdentifiers;
import com.axanthic.icaria.common.registry.IcariaParticleTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.client.data.ParticleDescriptionProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaParticleDescriptionProvider extends ParticleDescriptionProvider {
	public IcariaParticleDescriptionProvider(PackOutput pPackOutput) {
		super(pPackOutput);
	}

	@Override
	public void addDescriptions() {
		this.spriteSet(IcariaParticleTypes.BUBBLE.get(), IcariaIdentifiers.BUBBLE_PARTICLE, 6, false);
		this.spriteSet(IcariaParticleTypes.PORTAL.get(), IcariaIdentifiers.GENERIC_PARTICLE, 8, false);
		this.spriteSet(IcariaParticleTypes.STEAM.get(), IcariaIdentifiers.STEAM_PARTICLE, 12, false);
	}
}
