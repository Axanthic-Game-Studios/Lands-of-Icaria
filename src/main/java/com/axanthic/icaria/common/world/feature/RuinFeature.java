package com.axanthic.icaria.common.world.feature;

import com.axanthic.icaria.common.block.entity.IcariaSpawnerBlockEntity;
import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import com.mojang.serialization.Codec;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.ArrayList;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class RuinFeature extends Feature<NoneFeatureConfiguration> {
    public ArrayList<EntityType<?>> mobs = new ArrayList<>();

    public RuinFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        var level = pContext.level();
        var origin = pContext.origin();
        var random = pContext.random();

        this.setMobs();

        for (int x = 0; x < 16; x++) {
            int pX = origin.getX() + x;
            for (int z = 0; z < 16; z++) {
                int pZ = origin.getZ() + z;
                for (int y = 40; y < 48; y++) {
                    var blockPos = new BlockPos(pX, y, pZ);
                    var belowPos = new BlockPos(pX, y, pZ).below();
                    var oldState = level.getBlockState(belowPos);
                    var newState = oldState.is(IcariaBlocks.MARL.get()) ? IcariaBlocks.GRASSY_MARL.get().defaultBlockState() : oldState;

                    this.replaceRelicstone(level, blockPos, newState, 10);

                    this.setMobsForSpawners(level, blockPos, random);
                }
            }
        }

        return true;
    }

    public void replaceRelicstone(WorldGenLevel pLevel, BlockPos pPos, BlockState pState, int pChance) {
        if (pLevel.getRandom().nextInt(pChance) == 0) {
            this.replaceRelicstone(pLevel, pPos, pState);
        }
    }

    public void replaceRelicstone(WorldGenLevel pLevel, BlockPos pPos, BlockState pState) {
        if (pLevel.getBlockState(pPos).is(IcariaBlocks.RELICSTONE.get())) {
            this.setBlock(pLevel, pPos, pState);
        }
    }

    public void setMobsForSpawners(WorldGenLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getBlockEntity(pPos) instanceof IcariaSpawnerBlockEntity blockEntity) {
            blockEntity.setEntityId(this.getMob(pRandom), pRandom);
        }
    }

    public void setMobs() {
        this.mobs.add(IcariaEntityTypes.CIVILIAN_REVENANT.get());
        this.mobs.add(IcariaEntityTypes.PYROMANCER_REVENANT.get());
        this.mobs.add(IcariaEntityTypes.SOLDIER_REVENANT.get());
    }

    public EntityType<?> getMob(RandomSource pRandom) {
        return this.mobs.get(pRandom.nextInt(this.mobs.size()));
    }
}
