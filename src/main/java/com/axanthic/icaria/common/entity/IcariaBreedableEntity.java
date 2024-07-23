package com.axanthic.icaria.common.entity;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public interface IcariaBreedableEntity {

	@Nullable
	IcariaAnimalEntity getBreedOffspring(ServerLevel pLevel, IcariaAnimalEntity pEntity);
}
