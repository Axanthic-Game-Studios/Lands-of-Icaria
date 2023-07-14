package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.world.carver.configuration.IcariaSoilCarverConfiguration;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CarverDebugSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;

import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaConfiguredCarvers {
    public static final ResourceKey<ConfiguredWorldCarver<?>> FOREST = IcariaConfiguredCarvers.registerKey("forest");
    public static final ResourceKey<ConfiguredWorldCarver<?>> SCRUBLAND = IcariaConfiguredCarvers.registerKey("scrubland");
    public static final ResourceKey<ConfiguredWorldCarver<?>> STEPPE = IcariaConfiguredCarvers.registerKey("steppe");
    public static final ResourceKey<ConfiguredWorldCarver<?>> DESERT = IcariaConfiguredCarvers.registerKey("desert");
    public static final ResourceKey<ConfiguredWorldCarver<?>> VOID = IcariaConfiguredCarvers.registerKey("void");

    public static void bootstrap(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        IcariaConfiguredCarvers.forestCarver(pContext);
        IcariaConfiguredCarvers.scrublandCarver(pContext);
        IcariaConfiguredCarvers.steppeCarver(pContext);
        IcariaConfiguredCarvers.desertCarver(pContext);
        IcariaConfiguredCarvers.voidCarver(pContext);
    }

    public static void forestCarver(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        var blocks = pContext.lookup(Registries.BLOCK);

        var carverConfiguration = IcariaConfiguredCarvers.defaultConfiguration(pContext);

        var fillerPrimary = blocks.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
        var fillerSecondary = blocks.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
        var fillerTertiary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();

        var topPrimary = blocks.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
        var topSecondary = blocks.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
        var topTertiary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();

        Optional<BlockState> topperPrimary = Optional.empty();
        Optional<BlockState> topperSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
        Optional<BlockState> topperTertiary = Optional.empty();

        pContext.register(IcariaConfiguredCarvers.FOREST, IcariaCarvers.FOREST.get().configured(new IcariaSoilCarverConfiguration(carverConfiguration, fillerPrimary, fillerSecondary, fillerTertiary, topPrimary, topSecondary, topTertiary, topperPrimary, topperSecondary, topperTertiary)));
    }

    public static void scrublandCarver(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        var blocks = pContext.lookup(Registries.BLOCK);

        var carverConfiguration = IcariaConfiguredCarvers.defaultConfiguration(pContext);

        var fillerPrimary = blocks.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
        var fillerSecondary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
        var fillerTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        var topPrimary = blocks.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
        var topSecondary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
        var topTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        Optional<BlockState> topperPrimary = Optional.empty();
        Optional<BlockState> topperSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
        Optional<BlockState> topperTertiary = Optional.empty();

        pContext.register(IcariaConfiguredCarvers.SCRUBLAND, IcariaCarvers.SCRUBLAND.get().configured(new IcariaSoilCarverConfiguration(carverConfiguration, fillerPrimary, fillerSecondary, fillerTertiary, topPrimary, topSecondary, topTertiary, topperPrimary, topperSecondary, topperTertiary)));
    }

    public static void steppeCarver(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        var blocks = pContext.lookup(Registries.BLOCK);

        var carverConfiguration = IcariaConfiguredCarvers.defaultConfiguration(pContext);

        var fillerPrimary = blocks.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
        var fillerSecondary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
        var fillerTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        var topPrimary = blocks.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
        var topSecondary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
        var topTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        Optional<BlockState> topperPrimary = Optional.empty();
        Optional<BlockState> topperSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
        Optional<BlockState> topperTertiary = Optional.empty();

        pContext.register(IcariaConfiguredCarvers.STEPPE, IcariaCarvers.STEPPE.get().configured(new IcariaSoilCarverConfiguration(carverConfiguration, fillerPrimary, fillerSecondary, fillerTertiary, topPrimary, topSecondary, topTertiary, topperPrimary, topperSecondary, topperTertiary)));
    }

    public static void desertCarver(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        var blocks = pContext.lookup(Registries.BLOCK);

        var carverConfiguration = IcariaConfiguredCarvers.defaultConfiguration(pContext);

        var fillerPrimary = blocks.getOrThrow(IcariaBlocks.GRAINEL.getKey()).get().defaultBlockState();
        var fillerSecondary = blocks.getOrThrow(IcariaBlocks.SILKSAND.getKey()).get().defaultBlockState();
        var fillerTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        var topPrimary = blocks.getOrThrow(IcariaBlocks.GRAINEL.getKey()).get().defaultBlockState();
        var topSecondary = blocks.getOrThrow(IcariaBlocks.SILKSAND.getKey()).get().defaultBlockState();
        var topTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        Optional<BlockState> topperPrimary = Optional.empty();
        Optional<BlockState> topperSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
        Optional<BlockState> topperTertiary = Optional.empty();

        pContext.register(IcariaConfiguredCarvers.DESERT, IcariaCarvers.DESERT.get().configured(new IcariaSoilCarverConfiguration(carverConfiguration, fillerPrimary, fillerSecondary, fillerTertiary, topPrimary, topSecondary, topTertiary, topperPrimary, topperSecondary, topperTertiary)));
    }

    public static void voidCarver(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        var blocks = pContext.lookup(Registries.BLOCK);

        var carverConfiguration = IcariaConfiguredCarvers.defaultConfiguration(pContext);

        var fillerPrimary = blocks.getOrThrow(IcariaBlocks.MARL.getKey()).get().defaultBlockState();
        var fillerSecondary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
        var fillerTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        var topPrimary = blocks.getOrThrow(IcariaBlocks.GRASSY_MARL.getKey()).get().defaultBlockState();
        var topSecondary = blocks.getOrThrow(IcariaBlocks.COARSE_MARL.getKey()).get().defaultBlockState();
        var topTertiary = blocks.getOrThrow(IcariaBlocks.LOAM.getKey()).get().defaultBlockState();

        Optional<BlockState> topperPrimary = Optional.empty();
        Optional<BlockState> topperSecondary = Optional.of(IcariaBlocks.RELICSTONE.get().defaultBlockState());
        Optional<BlockState> topperTertiary = Optional.empty();

        pContext.register(IcariaConfiguredCarvers.VOID, IcariaCarvers.VOID.get().configured(new IcariaSoilCarverConfiguration(carverConfiguration, fillerPrimary, fillerSecondary, fillerTertiary, topPrimary, topSecondary, topTertiary, topperPrimary, topperSecondary, topperTertiary)));
    }

    public static CarverConfiguration defaultConfiguration(BootstapContext<ConfiguredWorldCarver<?>> pContext) {
        return new CarverConfiguration(0, UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(67)), ConstantFloat.of(0.0F), VerticalAnchor.aboveBottom(8), CarverDebugSettings.of(false, Blocks.WARPED_BUTTON.defaultBlockState()), pContext.lookup(Registries.BLOCK).getOrThrow(BlockTags.OVERWORLD_CARVER_REPLACEABLES));
    }

    public static ResourceKey<ConfiguredWorldCarver<?>> registerKey(String pName) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, new ResourceLocation(IcariaInfo.ID, pName));
    }
}
