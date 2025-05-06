package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.registry.IcariaParticleTypes;
import com.axanthic.icaria.common.registry.IcariaResourceLocations;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaParticleDescriptionProvider extends ParticleDescriptionProvider {
	public IcariaParticleDescriptionProvider(PackOutput pPackOutput) {
		super(pPackOutput);
	}

	@Override
	public void addDescriptions() {
		this.spriteSet(IcariaParticleTypes.BUBBLE.get(), IcariaResourceLocations.BUBBLE_PARTICLE, 6, false);
		this.spriteSet(IcariaParticleTypes.PORTAL.get(), IcariaResourceLocations.GENERIC_PARTICLE, 8, false);
		this.spriteSet(IcariaParticleTypes.STEAM.get(), IcariaResourceLocations.STEAM_PARTICLE, 12, false);
	}
}
