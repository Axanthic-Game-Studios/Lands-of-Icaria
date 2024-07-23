package com.axanthic.icaria.common.util;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public enum IcariaSummonSpellTypes {
	NONE(0),
	SUMMON(1);

	public final int id;

	IcariaSummonSpellTypes(int pId) {
		this.id = pId;
	}
}
