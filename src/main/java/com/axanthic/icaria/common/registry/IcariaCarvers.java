package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.carver.IcariaSoilWorldCarver;
import com.axanthic.icaria.common.world.carver.configuration.IcariaSoilCarverConfiguration;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.carver.WorldCarver;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaCarvers {
	public static final DeferredRegister<WorldCarver<?>> CARVERS = DeferredRegister.create(Registries.CARVER, IcariaInfo.ID);

	public static final RegistryObject<WorldCarver<IcariaSoilCarverConfiguration>> FOREST = IcariaCarvers.CARVERS.register("forest", () -> new IcariaSoilWorldCarver(IcariaSoilCarverConfiguration.CODEC));
	public static final RegistryObject<WorldCarver<IcariaSoilCarverConfiguration>> SCRUBLAND = IcariaCarvers.CARVERS.register("scrubland", () -> new IcariaSoilWorldCarver(IcariaSoilCarverConfiguration.CODEC));
	public static final RegistryObject<WorldCarver<IcariaSoilCarverConfiguration>> STEPPE = IcariaCarvers.CARVERS.register("steppe", () -> new IcariaSoilWorldCarver(IcariaSoilCarverConfiguration.CODEC));
	public static final RegistryObject<WorldCarver<IcariaSoilCarverConfiguration>> DESERT = IcariaCarvers.CARVERS.register("desert", () -> new IcariaSoilWorldCarver(IcariaSoilCarverConfiguration.CODEC));
	public static final RegistryObject<WorldCarver<IcariaSoilCarverConfiguration>> VOID = IcariaCarvers.CARVERS.register("void", () -> new IcariaSoilWorldCarver(IcariaSoilCarverConfiguration.CODEC));
}
