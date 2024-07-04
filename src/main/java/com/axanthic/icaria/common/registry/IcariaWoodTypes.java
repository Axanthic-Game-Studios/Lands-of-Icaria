package com.axanthic.icaria.common.registry;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWoodTypes {
	public static final WoodType CYPRESS = IcariaWoodTypes.register("cypress", IcariaBlockSetTypes.CYPRESS);
	public static final WoodType DROUGHTROOT = IcariaWoodTypes.register("droughtroot", IcariaBlockSetTypes.DROUGHTROOT);
	public static final WoodType FIR = IcariaWoodTypes.register("fir", IcariaBlockSetTypes.FIR);
	public static final WoodType LAUREL = IcariaWoodTypes.register("laurel", IcariaBlockSetTypes.LAUREL);
	public static final WoodType OLIVE = IcariaWoodTypes.register("olive", IcariaBlockSetTypes.OLIVE);
	public static final WoodType PLANE = IcariaWoodTypes.register("plane", IcariaBlockSetTypes.PLANE);
	public static final WoodType POPULUS = IcariaWoodTypes.register("populus", IcariaBlockSetTypes.POPULUS);

	public static void setup() {
		WoodType.register(IcariaWoodTypes.CYPRESS);
		WoodType.register(IcariaWoodTypes.DROUGHTROOT);
		WoodType.register(IcariaWoodTypes.FIR);
		WoodType.register(IcariaWoodTypes.LAUREL);
		WoodType.register(IcariaWoodTypes.OLIVE);
		WoodType.register(IcariaWoodTypes.PLANE);
		WoodType.register(IcariaWoodTypes.POPULUS);
	}

	public static WoodType register(String pName, BlockSetType pType) {
		return new WoodType(IcariaIdents.ID + ":" + pName, pType);
	}
}
