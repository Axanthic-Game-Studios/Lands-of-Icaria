package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class IcariaDimensions {
    public static final ResourceKey<Level> ICARIA = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(IcariaInfo.MODID, "icaria"));
}
