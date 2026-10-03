package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.ids.IcariaConfiguredFeatureIds;

import java.util.Optional;

import net.minecraft.world.level.block.grower.TreeGrower;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTreeGrowers {
	public static final TreeGrower CYPRESS = new TreeGrower("cypress", Optional.empty(), Optional.of(IcariaConfiguredFeatureIds.CYPRESS_TREE), Optional.empty());
	public static final TreeGrower DROUGHTROOT = new TreeGrower("droughtroot", Optional.empty(), Optional.of(IcariaConfiguredFeatureIds.DROUGHTROOT_TREE), Optional.empty());
	public static final TreeGrower FIR = new TreeGrower("fir", Optional.empty(), Optional.of(IcariaConfiguredFeatureIds.FIR_TREE), Optional.empty());
	public static final TreeGrower LAUREL = new TreeGrower("laurel", Optional.empty(), Optional.of(IcariaConfiguredFeatureIds.LAUREL_TREE), Optional.empty());
	public static final TreeGrower OLIVE = new TreeGrower("olive", Optional.empty(), Optional.of(IcariaConfiguredFeatureIds.OLIVE_TREE), Optional.empty());
	public static final TreeGrower PLANE = new TreeGrower("plane", Optional.empty(), Optional.of(IcariaConfiguredFeatureIds.PLANE_TREE), Optional.empty());
	public static final TreeGrower POPULUS = new TreeGrower("populus", Optional.empty(), Optional.of(IcariaConfiguredFeatureIds.POPULUS_TREE), Optional.empty());
}
