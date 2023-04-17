package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.level.block.state.properties.WoodType;

public class IcariaWoodTypes {
	public static final WoodType CYPRESS = new WoodType(IcariaInfo.ID + ":cypress", IcariaBlockSetTypes.CYPRESS);
	public static final WoodType DROUGHTROOT = new WoodType(IcariaInfo.ID + ":droughtroot", IcariaBlockSetTypes.DROUGHTROOT);
	public static final WoodType FIR = new WoodType(IcariaInfo.ID + ":fir", IcariaBlockSetTypes.FIR);
	public static final WoodType LAUREL = new WoodType(IcariaInfo.ID + ":laurel", IcariaBlockSetTypes.LAUREL);
	public static final WoodType OLIVE = new WoodType(IcariaInfo.ID + ":olive", IcariaBlockSetTypes.OLIVE);
	public static final WoodType PLANE = new WoodType(IcariaInfo.ID + ":plane", IcariaBlockSetTypes.PLANE);
	public static final WoodType POPULUS = new WoodType(IcariaInfo.ID + ":populus", IcariaBlockSetTypes.POPULUS);

	public static void setup() {
		WoodType.register(IcariaWoodTypes.CYPRESS);
		WoodType.register(IcariaWoodTypes.DROUGHTROOT);
		WoodType.register(IcariaWoodTypes.FIR);
		WoodType.register(IcariaWoodTypes.LAUREL);
		WoodType.register(IcariaWoodTypes.OLIVE);
		WoodType.register(IcariaWoodTypes.PLANE);
		WoodType.register(IcariaWoodTypes.POPULUS);
	}
}
