package com.axanthic.icaria.data;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaParticleTypes;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaParticleDescriptions extends ParticleDescriptionProvider {
	public IcariaParticleDescriptions(PackOutput pOutput, ExistingFileHelper pHelper) {
		super(pOutput, pHelper);
	}

	@Override
	public void addDescriptions() {
		this.spriteSet(IcariaParticleTypes.BUBBLE.get(), ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "bubble"), 6, false);
		this.spriteSet(IcariaParticleTypes.PORTAL.get(), ResourceLocation.withDefaultNamespace("generic"), 8, false);
		this.spriteSet(IcariaParticleTypes.STEAM.get(), ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "steam"), 12, false);
	}
}
