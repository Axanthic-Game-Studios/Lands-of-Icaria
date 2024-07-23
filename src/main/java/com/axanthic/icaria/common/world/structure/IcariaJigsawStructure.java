package com.axanthic.icaria.common.world.structure;

import com.axanthic.icaria.common.registry.IcariaStructureTypes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.EmptyBlockGetter;
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

	public HeightProvider minHeight;
	public HeightProvider maxHeight;

	public Holder<StructureTemplatePool> startPool;

	public LiquidSettings liquidSettings;

	public List<PoolAliasBinding> poolAliases;

	public static final MapCodec<IcariaJigsawStructure> CODEC = RecordCodecBuilder.<IcariaJigsawStructure>mapCodec((pInstance) -> pInstance.group(Structure.settingsCodec(pInstance), StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter((pStructure) -> pStructure.startPool), ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter((pStructure) -> pStructure.startJigsawName), Codec.intRange(0, 64).fieldOf("size").forGetter((pStructure) -> pStructure.maxDepth), HeightProvider.CODEC.fieldOf("min_height").forGetter((pStructure) -> pStructure.minHeight), HeightProvider.CODEC.fieldOf("max_height").forGetter((pStructure) -> pStructure.maxHeight), Codec.BOOL.fieldOf("use_expansion_hack").forGetter((pStructure) -> pStructure.useExpansionHack), Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter((pStructure) -> pStructure.projectStartToHeightmap), Codec.intRange(1, 256).fieldOf("max_distance_from_center").forGetter((pStructure) -> pStructure.maxDistanceFromCenter), Codec.list(PoolAliasBinding.CODEC).optionalFieldOf("pool_aliases", List.of()).forGetter((pStructure) -> pStructure.poolAliases), DimensionPadding.CODEC.optionalFieldOf("dimension_padding", DimensionPadding.ZERO).forGetter((pStructure) -> pStructure.dimensionPadding), LiquidSettings.CODEC.optionalFieldOf("liquid_settings", LiquidSettings.APPLY_WATERLOGGING).forGetter((pStructure) -> pStructure.liquidSettings)).apply(pInstance, IcariaJigsawStructure::new)).validate(IcariaJigsawStructure::verifyRange);

	public Optional<Heightmap.Types> projectStartToHeightmap;
	public Optional<ResourceLocation> startJigsawName;

	public IcariaJigsawStructure(Structure.StructureSettings pStructureSettings, Holder<StructureTemplatePool> pStartPool, Optional<ResourceLocation> pStartJigsaw, int pMaxDepth, HeightProvider pMinHeight, HeightProvider pMaxHeight, boolean pUseExpansionHack, Optional<Heightmap.Types> pProjectStartToHeightmap, int pMaxDistanceFromCenter, List<PoolAliasBinding> pPoolAliases, DimensionPadding pDimensionPadding, LiquidSettings pLiquidSettings) {
		super(pStructureSettings);
		this.startPool = pStartPool;
		this.startJigsawName = pStartJigsaw;
		this.maxDepth = pMaxDepth;
		this.minHeight = pMinHeight;
		this.maxHeight = pMaxHeight;
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
		var chunkPos = pContext.chunkPos();
		var chunkGenerator = pContext.chunkGenerator();
		var levelHeightAccessor = pContext.heightAccessor();
		var worldGenerationContext = new WorldGenerationContext(chunkGenerator, levelHeightAccessor);
		var worldgenRandom = pContext.random();

		int x = chunkPos.getMinBlockX() + worldgenRandom.nextInt(16);
		int z = chunkPos.getMinBlockZ() + worldgenRandom.nextInt(16);

		var noiseColumn = chunkGenerator.getBaseColumn(x, z, levelHeightAccessor, pContext.randomState());

		int i = this.minHeight.sample(worldgenRandom, worldGenerationContext);
		int j = this.maxHeight.sample(worldgenRandom, worldGenerationContext);

		var mutableBlockPos = new BlockPos.MutableBlockPos(x, j, z);

		while (j > i) {
			var blockState = noiseColumn.getBlock(j);
			var belowState = noiseColumn.getBlock(--j);
			if (blockState.isAir() && belowState.isFaceSturdy(EmptyBlockGetter.INSTANCE, mutableBlockPos.setY(j), Direction.UP)) {
				break;
			}
		}

		if (j <= i) {
			return Optional.empty();
		} else {
			var blockPos = new BlockPos(x, j, z);
			var poolAliasLookup = PoolAliasLookup.create(this.poolAliases, blockPos, pContext.seed());
			return JigsawPlacement.addPieces(pContext, this.startPool, this.startJigsawName, this.maxDepth, blockPos, this.useExpansionHack, this.projectStartToHeightmap, this.maxDistanceFromCenter, poolAliasLookup, this.dimensionPadding, this.liquidSettings);
		}
	}

	@Override
	public StructureType<?> type() {
		return IcariaStructureTypes.JIGSAW.get();
	}
}
