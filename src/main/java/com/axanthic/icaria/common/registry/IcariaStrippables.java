package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.mixin.AxeItemMixin;

import java.util.IdentityHashMap;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaStrippables {

	public static void setup() {
		var identityHashMap = new IdentityHashMap<>(AxeItemMixin.getIcariaStrippables());

		identityHashMap.put(IcariaBlocks.CYPRESS_WOOD.get(), IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		identityHashMap.put(IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		identityHashMap.put(IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		identityHashMap.put(IcariaBlocks.DROUGHTROOT_WOOD.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		identityHashMap.put(IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		identityHashMap.put(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		identityHashMap.put(IcariaBlocks.FIR_WOOD.get(), IcariaBlocks.STRIPPED_FIR_WOOD.get());
		identityHashMap.put(IcariaBlocks.FIR_LOG.get(), IcariaBlocks.STRIPPED_FIR_LOG.get());
		identityHashMap.put(IcariaBlocks.DEAD_FIR_LOG.get(), IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		identityHashMap.put(IcariaBlocks.LAUREL_WOOD.get(), IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		identityHashMap.put(IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		identityHashMap.put(IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		identityHashMap.put(IcariaBlocks.OLIVE_WOOD.get(), IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		identityHashMap.put(IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		identityHashMap.put(IcariaBlocks.DEAD_OLIVE_LOG.get(), IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		identityHashMap.put(IcariaBlocks.PLANE_WOOD.get(), IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		identityHashMap.put(IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get());
		identityHashMap.put(IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		identityHashMap.put(IcariaBlocks.POPULUS_WOOD.get(), IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		identityHashMap.put(IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		identityHashMap.put(IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());

		AxeItemMixin.setIcariaStrippables(identityHashMap);
	}
}
