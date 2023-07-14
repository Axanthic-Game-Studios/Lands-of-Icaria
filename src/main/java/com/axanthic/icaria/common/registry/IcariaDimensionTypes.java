package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.dimension.DimensionType;

import java.util.OptionalLong;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class IcariaDimensionTypes {
    public static final ResourceKey<DimensionType> ICARIA = ResourceKey.create(Registries.DIMENSION_TYPE, new ResourceLocation(IcariaInfo.ID, "icaria"));

    public static void bootstrap(BootstapContext<DimensionType> pContext) {
        pContext.register(IcariaDimensionTypes.ICARIA, new DimensionType(OptionalLong.empty(), true, false, false, true, 1.0D, false, false, -64, 384, 384, BlockTags.INFINIBURN_OVERWORLD, IcariaResourceLocations.ICARIA, 0.0F, new DimensionType.MonsterSettings(false, false, UniformInt.of(0, 7), 0)));
    }
}
