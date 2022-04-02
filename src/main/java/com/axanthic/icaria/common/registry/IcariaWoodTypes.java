package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;

public class IcariaWoodTypes {
	public static final WoodType CYPRESS = WoodType.create(new ResourceLocation(IcariaInfo.MODID, "cypress").toString());
	public static final WoodType DROUGHTROOT = WoodType.create(new ResourceLocation(IcariaInfo.MODID, "droughtroot").toString());
	public static final WoodType FIR = WoodType.create(new ResourceLocation(IcariaInfo.MODID, "fir").toString());
	public static final WoodType LAUREL = WoodType.create(new ResourceLocation(IcariaInfo.MODID, "laurel").toString());
	public static final WoodType OLIVE = WoodType.create(new ResourceLocation(IcariaInfo.MODID, "olive").toString());
	public static final WoodType PLANE = WoodType.create(new ResourceLocation(IcariaInfo.MODID, "plane").toString());
	public static final WoodType POPULUS = WoodType.create(new ResourceLocation(IcariaInfo.MODID, "populus").toString());

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
