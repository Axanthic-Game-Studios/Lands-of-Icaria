package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaFluids;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault

public class PsilocybosFeature extends Feature<NoneFeatureConfiguration> {
    public PsilocybosFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();
        var direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int size = 2;

        var list = level.getBlockStates(new AABB(origin).inflate(size)).toList();

        boolean test = list.contains(IcariaBlocks.MEDITERRANEAN_WATER.get().defaultBlockState());

        for (int x = -size; x <= size; x++) {
            for (int y = -size; y <= size; y++) {
                for (int z = -size; z <= size; z++) {
                    if (test) {
                        this.placeHerb(level, origin.relative(direction, x).above(y).relative(direction.getClockWise(), z), 16);
                    }
                }
            }
        }

        return true;
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeHerb(pLevel, pPos);
        }
    }

    public void placeHerb(WorldGenLevel pLevel, BlockPos pPos) {
        if ((pLevel.getBlockState(pPos).isAir() || pLevel.getFluidState(pPos).is(IcariaFluids.MEDITERRANEAN_WATER.get())) && pLevel.getBlockState(pPos.above()).isAir() && pLevel.getBlockState(pPos.below()).is(BlockTags.DIRT)) {
            this.setBlock(pLevel, pPos, IcariaBlocks.PSILOCYBOS.get().defaultBlockState().setValue(IcariaBlockStateProperties.MEDITERRANEAN_WATERLOGGED, pLevel.getFluidState(pPos).is(IcariaFluids.MEDITERRANEAN_WATER.get())).setValue(BlockStateProperties.WATERLOGGED, pLevel.getFluidState(pPos).is(Fluids.WATER)));
        }
    }
}
