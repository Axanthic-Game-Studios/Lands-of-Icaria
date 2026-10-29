package com.axanthic.icaria.data.provider.advancement;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import java.util.List;

import net.minecraft.data.advancements.AdvancementProvider;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaAdvancementProvider extends AdvancementProvider {
	public IcariaAdvancementProvider() {
		super(List.of(IcariaAdvancementSubProvider::new));
	}
}
