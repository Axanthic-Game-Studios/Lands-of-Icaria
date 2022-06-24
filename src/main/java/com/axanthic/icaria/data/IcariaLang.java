package com.axanthic.icaria.data;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.data.DataGenerator;

import net.minecraftforge.common.data.LanguageProvider;

public class IcariaLang extends LanguageProvider {
	public IcariaLang(DataGenerator generator) {
		super(generator, IcariaInfo.MODID, "en_us");
	}

	@Override
	public void addTranslations() {

	}
}
