package com.axanthic.icaria.common.world.structure;

import com.axanthic.icaria.common.registry.IcariaStructureTypes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldGenerationContext;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.JigsawPlacement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasBinding;
import net.minecraft.world.level.levelgen.structure.pools.alias.PoolAliasLookup;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

import java.util.List;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaJigsawStructure extends Structure {
    public boolean useExpansionHack;

    public int maxDepth;
    public int maxDistanceFromCenter;

    public DimensionPadding dimensionPadding;

    public HeightProvider startHeight;

    public Holder<StructureTemplatePool> startPool;

    public LiquidSettings liquidSettings;

    public List<PoolAliasBinding> poolAliases;

    public static final MapCodec<IcariaJigsawStructure> CODEC = RecordCodecBuilder.<IcariaJigsawStructure>mapCodec((pInstance) -> pInstance.group(Structure.settingsCodec(pInstance), StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter((pStructure) -> pStructure.startPool), ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter((pStructure) -> pStructure.startJigsawName), Codec.intRange(0, 64).fieldOf("size").forGetter((pStructure) -> pStructure.maxDepth), HeightProvider.CODEC.fieldOf("start_height").forGetter((pStructure) -> pStructure.startHeight), Codec.BOOL.fieldOf("use_expansion_hack").forGetter((pStructure) -> pStructure.useExpansionHack), Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter((pStructure) -> pStructure.projectStartToHeightmap), Codec.intRange(1, 256).fieldOf("max_distance_from_center").forGetter((pStructure) -> pStructure.maxDistanceFromCenter), Codec.list(PoolAliasBinding.CODEC).optionalFieldOf("pool_aliases", List.of()).forGetter((pStructure) -> pStructure.poolAliases), DimensionPadding.CODEC.optionalFieldOf("dimension_padding", DimensionPadding.ZERO).forGetter((pStructure) -> pStructure.dimensionPadding), LiquidSettings.CODEC.optionalFieldOf("liquid_settings", LiquidSettings.APPLY_WATERLOGGING).forGetter((pStructure) -> pStructure.liquidSettings)).apply(pInstance, IcariaJigsawStructure::new)).validate(IcariaJigsawStructure::verifyRange);

    public Optional<Heightmap.Types> projectStartToHeightmap;
    public Optional<ResourceLocation> startJigsawName;

    public IcariaJigsawStructure(Structure.StructureSettings pStructureSettings, Holder<StructureTemplatePool> pStartPool, Optional<ResourceLocation> pStartJigsaw, int pMaxDepth, HeightProvider pStartHeight, boolean pUseExpansionHack, Optional<Heightmap.Types> pProjectStartToHeightmap, int pMaxDistanceFromCenter, List<PoolAliasBinding> pPoolAliases, DimensionPadding pDimensionPadding, LiquidSettings pLiquidSettings) {
        super(pStructureSettings);
        this.startPool = pStartPool;
        this.startJigsawName = pStartJigsaw;
        this.maxDepth = pMaxDepth;
        this.startHeight = pStartHeight;
        this.useExpansionHack = pUseExpansionHack;
        this.projectStartToHeightmap = pProjectStartToHeightmap;
        this.maxDistanceFromCenter = pMaxDistanceFromCenter;
        this.poolAliases = pPoolAliases;
        this.dimensionPadding = pDimensionPadding;
        this.liquidSettings = pLiquidSettings;
    }

    public static DataResult<IcariaJigsawStructure> verifyRange(IcariaJigsawStructure pStructure) {
        int i = switch (pStructure.terrainAdaptation()) {
            case NONE -> 0;
            case BURY, BEARD_THIN, BEARD_BOX, ENCAPSULATE -> 12;
        };

        return pStructure.maxDistanceFromCenter + i > 256 ? DataResult.error(() -> "Structure size including terrain adaptation must not exceed 256") : DataResult.success(pStructure);
    }

    @Override
    public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext pContext) {
        int i = this.startHeight.sample(pContext.random(), new WorldGenerationContext(pContext.chunkGenerator(), pContext.heightAccessor()));
        var chunkPos = pContext.chunkPos();
        var blockPos = new BlockPos(chunkPos.getMinBlockX(), i, chunkPos.getMinBlockZ());
        return JigsawPlacement.addPieces(pContext, this.startPool, this.startJigsawName, this.maxDepth, blockPos, this.useExpansionHack, this.projectStartToHeightmap, this.maxDistanceFromCenter, PoolAliasLookup.create(this.poolAliases, blockPos, pContext.seed()), this.dimensionPadding, this.liquidSettings);
    }

    @Override
    public StructureType<?> type() {
        return IcariaStructureTypes.JIGSAW.get();
    }
}
