package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.state.properties.BlockSetType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockSetTypes {
	public static final BlockSetType CYPRESS = IcariaBlockSetTypes.create("cypress");
	public static final BlockSetType DROUGHTROOT = IcariaBlockSetTypes.create("droughtroot");
	public static final BlockSetType FIR = IcariaBlockSetTypes.create("fir");
	public static final BlockSetType LAUREL = IcariaBlockSetTypes.create("laurel");
	public static final BlockSetType OLIVE = IcariaBlockSetTypes.create("olive");
	public static final BlockSetType PLANE = IcariaBlockSetTypes.create("plane");
	public static final BlockSetType POPULUS = IcariaBlockSetTypes.create("populus");

	public static BlockSetType create(String pName) {
		return new BlockSetType(IcariaIds.ID + ":" + pName);
	}
}
