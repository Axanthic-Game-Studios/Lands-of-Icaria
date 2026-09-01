package com.axanthic.icaria.data.registry;

import com.axanthic.icaria.common.registry.IcariaKeys;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.world.item.Instrument;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaInstruments {
	public static final ResourceKey<Instrument> FAIL_CAPELLA_HORN = IcariaInstruments.createKey("fail_capella_horn");

	public static void bootstrap(BootstrapContext<Instrument> pBootstrapContext) {
		IcariaInstruments.register(pBootstrapContext, IcariaInstruments.FAIL_CAPELLA_HORN, IcariaSoundEvents.CAPELLA_HORN_FAIL, 7.0F, 256.0F);
	}

	public static void register(BootstrapContext<Instrument> pBootstrapContext, ResourceKey<Instrument> pInstrument, SoundEvent pSoundEvent, float pDuration, float pRange) {
		pBootstrapContext.register(pInstrument, new Instrument(Holder.direct(pSoundEvent), pDuration, pRange, Component.translatable(Util.makeDescriptionId("instrument", pInstrument.identifier()))));
	}

	public static ResourceKey<Instrument> createKey(String pName) {
		return ResourceKey.create(Registries.INSTRUMENT, Identifier.fromNamespaceAndPath(IcariaKeys.ID, pName));
	}
}
