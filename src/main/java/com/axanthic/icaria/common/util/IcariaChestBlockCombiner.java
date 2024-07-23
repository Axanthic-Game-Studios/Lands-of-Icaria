package com.axanthic.icaria.common.util;

import com.axanthic.icaria.common.menu.provider.IcariaChestMenuProvider;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.CompoundContainer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaChestBlockCombiner implements DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> {

	@Override
	public Optional<MenuProvider> acceptDouble(ChestBlockEntity pFirst, ChestBlockEntity pSecond) {
		return Optional.of(new IcariaChestMenuProvider(pFirst, pSecond, new CompoundContainer(pFirst, pSecond)));
	}

	@Override
	public Optional<MenuProvider> acceptSingle(ChestBlockEntity pSingle) {
		return Optional.of(pSingle);
	}

	@Override
	public Optional<MenuProvider> acceptNone() {
		return Optional.empty();
	}
}
