package com.axanthic.icaria.common.entity;

import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

public interface IcariaBreedableEntity {

    @Nullable
    IcariaAnimalEntity getBreedOffspring(ServerLevel pLevel, IcariaAnimalEntity pEntity);
}
