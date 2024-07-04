package com.axanthic.icaria.common.math;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.util.Mth;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaMath {
    public static float rad(float pDeg) {
        return pDeg * Mth.PI / 180.0F;
    }
}
