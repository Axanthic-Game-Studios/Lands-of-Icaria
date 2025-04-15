package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Instrument;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaInstruments {
	public static final ResourceKey<Instrument> FAIL_CAPELLA_HORN = IcariaInstruments.createKey("fail_capella_horn");

	public static void bootstrap(BootstrapContext<Instrument> pBootstrapContext) {
		IcariaInstruments.register(pBootstrapContext, IcariaInstruments.FAIL_CAPELLA_HORN, IcariaSoundEvents.CAPELLA_HORN_FAIL, 7.0F, 256.0F);
	}

	public static void register(BootstrapContext<Instrument> pBootstrapContext, ResourceKey<Instrument> pInstruments, SoundEvent pSoundEvent, float pDuration, float pRange) {
		pBootstrapContext.register(pInstruments, new Instrument(Holder.direct(pSoundEvent), pDuration, pRange, Component.translatable(Util.makeDescriptionId("instrument", pInstruments.location()))));
	}

	public static ResourceKey<Instrument> createKey(String pName) {
		return ResourceKey.create(Registries.INSTRUMENT, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName));
	}
}
