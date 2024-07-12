package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, IcariaIdents.ID);

	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BUBBLE = IcariaParticleTypes.PARTICLE_TYPES.register("bubble", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PORTAL = IcariaParticleTypes.PARTICLE_TYPES.register("portal", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STEAM = IcariaParticleTypes.PARTICLE_TYPES.register("steam", () -> new SimpleParticleType(false));
}
