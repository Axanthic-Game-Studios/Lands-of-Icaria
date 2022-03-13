package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.mixin.HoeItemAccess;
import com.mojang.datafixers.util.Pair;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class IcariaTillables {
	public static void setup() {
		Map<Block, Pair<Predicate<UseOnContext>, Consumer<UseOnContext>>> tillables = new IdentityHashMap<>(HoeItemAccess.getIcariaTillables());

		tillables.put(IcariaBlocks.MARL_GRASS.get(), Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(IcariaBlocks.FARMLAND.get().defaultBlockState())));
		tillables.put(IcariaBlocks.MARL.get(), Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(IcariaBlocks.FARMLAND.get().defaultBlockState())));
		tillables.put(IcariaBlocks.MARL_COARSE.get(), Pair.of(HoeItem::onlyIfAirAbove, HoeItem.changeIntoState(IcariaBlocks.MARL.get().defaultBlockState())));

		HoeItemAccess.setIcariaTillables(tillables);
	}
}
