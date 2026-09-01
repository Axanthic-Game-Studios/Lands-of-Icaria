package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.data.registry.IcariaConfiguredFeatures;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.level.block.grower.TreeGrower;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaTreeGrowers {
	public static final TreeGrower CYPRESS = new TreeGrower("cypress", Optional.empty(), Optional.of(IcariaConfiguredFeatures.CYPRESS_TREE), Optional.empty());
	public static final TreeGrower DROUGHTROOT = new TreeGrower("droughtroot", Optional.empty(), Optional.of(IcariaConfiguredFeatures.DROUGHTROOT_TREE), Optional.empty());
	public static final TreeGrower FIR = new TreeGrower("fir", Optional.empty(), Optional.of(IcariaConfiguredFeatures.FIR_TREE), Optional.empty());
	public static final TreeGrower LAUREL = new TreeGrower("laurel", Optional.empty(), Optional.of(IcariaConfiguredFeatures.LAUREL_TREE), Optional.empty());
	public static final TreeGrower OLIVE = new TreeGrower("olive", Optional.empty(), Optional.of(IcariaConfiguredFeatures.OLIVE_TREE), Optional.empty());
	public static final TreeGrower PLANE = new TreeGrower("plane", Optional.empty(), Optional.of(IcariaConfiguredFeatures.PLANE_TREE), Optional.empty());
	public static final TreeGrower POPULUS = new TreeGrower("populus", Optional.empty(), Optional.of(IcariaConfiguredFeatures.POPULUS_TREE), Optional.empty());
}
