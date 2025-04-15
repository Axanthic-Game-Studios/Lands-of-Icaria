package com.axanthic.icaria.data.provider;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaParticleTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaParticleDescriptionProvider extends ParticleDescriptionProvider {
	public IcariaParticleDescriptionProvider(PackOutput pPackOutput, ExistingFileHelper pExistingFileHelper) {
		super(pPackOutput, pExistingFileHelper);
	}

	@Override
	public void addDescriptions() {
		this.spriteSet(IcariaParticleTypes.BUBBLE.get(), ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "bubble"), 6, false);
		this.spriteSet(IcariaParticleTypes.PORTAL.get(), ResourceLocation.fromNamespaceAndPath(IcariaIdents.MC, "generic"), 8, false);
		this.spriteSet(IcariaParticleTypes.STEAM.get(), ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, "steam"), 12, false);
	}
}
