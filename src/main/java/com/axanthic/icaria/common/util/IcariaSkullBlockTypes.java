package com.axanthic.icaria.common.util;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.SkullBlock;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum IcariaSkullBlockTypes implements SkullBlock.Type {
	AETERNAE("aeternae"),
	ARGAN_HOUND("argan_hound"),
	CAPELLA("capella"),
	CATOBLEPAS("catoblepas"),
	CERVER("cerver"),
	CROCOTTA("crocotta"),
	CYPRESS_FOREST_HAG("cypress_forest_hag"),
	DROUGHTROOT_FOREST_HAG("droughtroot_forest_hag"),
	FIR_FOREST_HAG("fir_forest_hag"),
	LAUREL_FOREST_HAG("laurel_forest_hag"),
	OLIVE_FOREST_HAG("olive_forest_hag"),
	PLANE_FOREST_HAG("plane_forest_hag"),
	POPULUS_FOREST_HAG("populus_forest_hag"),
	REVENANT("revenant"),
	SOW("sow");

	public final String name;

	IcariaSkullBlockTypes(String pName) {
		this.name = pName;
		SkullBlock.Type.TYPES.put(pName, this);
	}

	@Override
	public String getSerializedName() {
		return this.name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
