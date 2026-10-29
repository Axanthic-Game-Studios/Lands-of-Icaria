package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaFeatureIds;

import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.grower.TreeGrower;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTreeGrowers {
	public static final TreeGrower CYPRESS = new TreeGrower("cypress", WeightedList.of(IcariaFeatureIds.CYPRESS_TREE), WeightedList.of(), WeightedList.of(), IcariaFeatureIds.CYPRESS_TREE);
	public static final TreeGrower DROUGHTROOT = new TreeGrower("droughtroot", WeightedList.of(IcariaFeatureIds.DROUGHTROOT_TREE), WeightedList.of(), WeightedList.of(), IcariaFeatureIds.DROUGHTROOT_TREE);
	public static final TreeGrower FIR = new TreeGrower("fir", WeightedList.of(IcariaFeatureIds.FIR_TREE), WeightedList.of(), WeightedList.of(), IcariaFeatureIds.FIR_TREE);
	public static final TreeGrower LAUREL = new TreeGrower("laurel", WeightedList.of(IcariaFeatureIds.LAUREL_TREE), WeightedList.of(), WeightedList.of(), IcariaFeatureIds.LAUREL_TREE);
	public static final TreeGrower OLIVE = new TreeGrower("olive", WeightedList.of(IcariaFeatureIds.OLIVE_TREE), WeightedList.of(), WeightedList.of(), IcariaFeatureIds.OLIVE_TREE);
	public static final TreeGrower PLANE = new TreeGrower("plane", WeightedList.of(IcariaFeatureIds.PLANE_TREE), WeightedList.of(), WeightedList.of(), IcariaFeatureIds.PLANE_TREE);
	public static final TreeGrower POPULUS = new TreeGrower("populus", WeightedList.of(IcariaFeatureIds.POPULUS_TREE), WeightedList.of(), WeightedList.of(), IcariaFeatureIds.POPULUS_TREE);
}
