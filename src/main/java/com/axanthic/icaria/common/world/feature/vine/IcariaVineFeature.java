package com.axanthic.icaria.common.world.feature.vine;

import com.axanthic.icaria.common.block.IcariaVineBlock;
import com.axanthic.icaria.common.properties.Vine;
import com.axanthic.icaria.common.registry.IcariaBlockStateProperties;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("unused")

@ParametersAreNonnullByDefault

public class IcariaVineFeature extends Feature<NoneFeatureConfiguration> {
    public Block vine;

    public IcariaVineFeature(Codec<NoneFeatureConfiguration> pCodec, Block pVine) {
        super(pCodec);
        this.vine = pVine;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();

        for (var direction : Direction.Plane.HORIZONTAL) {
            this.placeVine(level, origin, direction);
        }

        return true;
    }

    public void placeVine(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.placeVine(pLevel, pPos, pDirection);
        }
    }

    public void placeVine(WorldGenLevel pLevel, BlockPos pPos, Direction pDirection) {
        if (pLevel.getBlockState(pPos).isAir() && (pLevel.getBlockState(pPos.relative(pDirection)).is(BlockTags.LEAVES) || pLevel.getBlockState(pPos.relative(pDirection)).isSolidRender(pLevel, pPos.relative(pDirection))) && IcariaVineBlock.isAcceptableNeighbour(pLevel, pPos.relative(pDirection), pDirection)) {
            if (pLevel.getRandom().nextBoolean()) {
                this.setBlock(pLevel, pPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.getPropForFace(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.NONE));
            } else {
                this.setBlock(pLevel, pPos, this.vine.defaultBlockState().setValue(IcariaVineBlock.getPropForFace(pDirection), true).setValue(IcariaBlockStateProperties.VINE, Vine.VINE));
            }
        }
    }
}
