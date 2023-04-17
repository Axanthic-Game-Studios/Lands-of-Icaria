package com.axanthic.icaria.common.util;

import net.minecraft.util.Mth;

public class IcariaMath {
    public static final float HALFSQRT3 = Mth.sqrt(3.0F) / 2.0F;

    public static float rad(float pDeg) {
        return pDeg * Mth.PI / 180.0F;
    }
}
