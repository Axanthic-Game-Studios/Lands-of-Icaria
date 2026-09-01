package com.axanthic.icaria.common.registry;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(Registries.PARTICLE_TYPE, IcariaKeys.ID);

	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BUBBLE = IcariaParticleTypes.PARTICLE_TYPES.register("bubble", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PORTAL = IcariaParticleTypes.PARTICLE_TYPES.register("portal", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STEAM = IcariaParticleTypes.PARTICLE_TYPES.register("steam", () -> new SimpleParticleType(false));
}
