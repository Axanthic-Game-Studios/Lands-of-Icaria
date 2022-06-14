package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaLang extends LanguageProvider {
	public IcariaLang(DataGenerator generator) {
		super(generator, IcariaInfo.MODID, "en_us");
	}

	public void addFluid(Supplier<? extends ForgeFlowingFluid> supplier, String name) {
		ResourceLocation id = ForgeRegistries.FLUIDS.getKey(supplier.get());
		add("fluid." + Objects.requireNonNull(id).getNamespace() + "." + id.getPath(), name);
	}

	@Override
	public void addTranslations() {

	}
}
