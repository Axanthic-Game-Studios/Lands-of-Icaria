package com.axanthic.icaria.common.combiner;

import com.axanthic.icaria.common.menu.provider.ChestMenuProvider;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.CompoundContainer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ChestBlockCombiner implements DoubleBlockCombiner.Combiner<ChestBlockEntity, Optional<MenuProvider>> {

	@Override
	public Optional<MenuProvider> acceptDouble(ChestBlockEntity pFirst, ChestBlockEntity pSecond) {
		return Optional.of(new ChestMenuProvider(pFirst, pSecond, new CompoundContainer(pFirst, pSecond)));
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
