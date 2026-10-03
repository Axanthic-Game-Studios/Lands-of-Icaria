package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaWoodTypes {
	public static final WoodType CYPRESS = IcariaWoodTypes.create("cypress", IcariaBlockSetTypes.CYPRESS);
	public static final WoodType DROUGHTROOT = IcariaWoodTypes.create("droughtroot", IcariaBlockSetTypes.DROUGHTROOT);
	public static final WoodType FIR = IcariaWoodTypes.create("fir", IcariaBlockSetTypes.FIR);
	public static final WoodType LAUREL = IcariaWoodTypes.create("laurel", IcariaBlockSetTypes.LAUREL);
	public static final WoodType OLIVE = IcariaWoodTypes.create("olive", IcariaBlockSetTypes.OLIVE);
	public static final WoodType PLANE = IcariaWoodTypes.create("plane", IcariaBlockSetTypes.PLANE);
	public static final WoodType POPULUS = IcariaWoodTypes.create("populus", IcariaBlockSetTypes.POPULUS);

	public static WoodType create(String pName, BlockSetType pBlockSetType) {
		return new WoodType(IcariaIds.ID + ":" + pName, pBlockSetType);
	}
}
