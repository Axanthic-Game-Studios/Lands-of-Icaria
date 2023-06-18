package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.mixin.AxeItemMixin;

import java.util.IdentityHashMap;

public class IcariaStrippables {
	public static void setup() {
		var strippables = new IdentityHashMap<>(AxeItemMixin.getIcariaStrippables());

		strippables.put(IcariaBlocks.CYPRESS_WOOD.get(), IcariaBlocks.STRIPPED_CYPRESS_WOOD.get());
		strippables.put(IcariaBlocks.CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_CYPRESS_LOG.get());
		strippables.put(IcariaBlocks.DEAD_CYPRESS_LOG.get(), IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get());
		strippables.put(IcariaBlocks.DROUGHTROOT_WOOD.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get());
		strippables.put(IcariaBlocks.DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get());
		strippables.put(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get());
		strippables.put(IcariaBlocks.FIR_WOOD.get(), IcariaBlocks.STRIPPED_FIR_WOOD.get());
		strippables.put(IcariaBlocks.FIR_LOG.get(), IcariaBlocks.STRIPPED_FIR_LOG.get());
		strippables.put(IcariaBlocks.DEAD_FIR_LOG.get(), IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get());
		strippables.put(IcariaBlocks.LAUREL_WOOD.get(), IcariaBlocks.STRIPPED_LAUREL_WOOD.get());
		strippables.put(IcariaBlocks.LAUREL_LOG.get(), IcariaBlocks.STRIPPED_LAUREL_LOG.get());
		strippables.put(IcariaBlocks.DEAD_LAUREL_LOG.get(), IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get());
		strippables.put(IcariaBlocks.OLIVE_WOOD.get(), IcariaBlocks.STRIPPED_OLIVE_WOOD.get());
		strippables.put(IcariaBlocks.OLIVE_LOG.get(), IcariaBlocks.STRIPPED_OLIVE_LOG.get());
		strippables.put(IcariaBlocks.DEAD_OLIVE_LOG.get(), IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get());
		strippables.put(IcariaBlocks.PLANE_WOOD.get(), IcariaBlocks.STRIPPED_PLANE_WOOD.get());
		strippables.put(IcariaBlocks.PLANE_LOG.get(), IcariaBlocks.STRIPPED_PLANE_LOG.get());
		strippables.put(IcariaBlocks.DEAD_PLANE_LOG.get(), IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get());
		strippables.put(IcariaBlocks.POPULUS_WOOD.get(), IcariaBlocks.STRIPPED_POPULUS_WOOD.get());
		strippables.put(IcariaBlocks.POPULUS_LOG.get(), IcariaBlocks.STRIPPED_POPULUS_LOG.get());
		strippables.put(IcariaBlocks.DEAD_POPULUS_LOG.get(), IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get());

		AxeItemMixin.setIcariaStrippables(strippables);
	}
}
