package com.axanthic.icaria.common.world.structure;

import com.axanthic.icaria.common.registry.IcariaStructureTypes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;
import java.util.Optional;

import javax.annotation.ParametersAreNonnullByDefault;

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
import net.minecraft.world.level.levelgen.structure.structures.JigsawStructure;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaJigsawStructure extends Structure {
	public boolean useExpansionHack;

	public int maxDepth;
	public JigsawStructure.MaxDistance maxDistanceFromCenter;

	public DimensionPadding dimensionPadding;

	public HeightProvider minHeight;
	public HeightProvider maxHeight;

	public Holder<StructureTemplatePool> startPool;

	public LiquidSettings liquidSettings;

	public List<PoolAliasBinding> poolAliases;

	public Optional<Heightmap.Types> projectStartToHeightmap;
	public Optional<ResourceLocation> startJigsawName;

	public static final MapCodec<IcariaJigsawStructure> CODEC = RecordCodecBuilder.<IcariaJigsawStructure>mapCodec(
		instance -> instance.group(
			Structure.settingsCodec(instance),
			StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter(icariaJigsawStructure -> icariaJigsawStructure.startPool),
			ResourceLocation.CODEC.optionalFieldOf("start_jigsaw_name").forGetter(icariaJigsawStructure -> icariaJigsawStructure.startJigsawName),
			Codec.intRange(0, 64).fieldOf("size").forGetter(icariaJigsawStructure -> icariaJigsawStructure.maxDepth),
			HeightProvider.CODEC.fieldOf("min_height").forGetter(icariaJigsawStructure -> icariaJigsawStructure.minHeight),
			HeightProvider.CODEC.fieldOf("max_height").forGetter(icariaJigsawStructure -> icariaJigsawStructure.maxHeight),
			Codec.BOOL.fieldOf("use_expansion_hack").forGetter(icariaJigsawStructure -> icariaJigsawStructure.useExpansionHack),
			Heightmap.Types.CODEC.optionalFieldOf("project_start_to_heightmap").forGetter(icariaJigsawStructure -> icariaJigsawStructure.projectStartToHeightmap),
			JigsawStructure.MaxDistance.CODEC.fieldOf("max_distance_from_center").forGetter(icariaJigsawStructure -> icariaJigsawStructure.maxDistanceFromCenter),
			Codec.list(PoolAliasBinding.CODEC).optionalFieldOf("pool_aliases", List.of()).forGetter(icariaJigsawStructure -> icariaJigsawStructure.poolAliases),
			DimensionPadding.CODEC.optionalFieldOf("dimension_padding", DimensionPadding.ZERO).forGetter(icariaJigsawStructure -> icariaJigsawStructure.dimensionPadding),
			LiquidSettings.CODEC.optionalFieldOf("liquid_settings", LiquidSettings.APPLY_WATERLOGGING).forGetter(icariaJigsawStructure -> icariaJigsawStructure.liquidSettings)
		).apply(instance, IcariaJigsawStructure::new)
	).validate(IcariaJigsawStructure::verifyRange);

	public IcariaJigsawStructure(Structure.StructureSettings pStructureSettings, Holder<StructureTemplatePool> pStartPool, Optional<ResourceLocation> pStartJigsawName, int pMaxDepth, HeightProvider pMinHeight, HeightProvider pMaxHeight, boolean pUseExpansionHack, Optional<Heightmap.Types> pProjectStartToHeightmap, JigsawStructure.MaxDistance pMaxDistanceFromCenter, List<PoolAliasBinding> pPoolAliases, DimensionPadding pDimensionPadding, LiquidSettings pLiquidSettings) {
		super(pStructureSettings);
		this.startPool = pStartPool;
		this.startJigsawName = pStartJigsawName;
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

	public static int terrainAdaptation(IcariaJigsawStructure pStructure) {
		return switch (pStructure.terrainAdaptation()) {
			case NONE -> 0;
			case BURY, BEARD_THIN, BEARD_BOX, ENCAPSULATE -> 12;
		};
	}

	public static DataResult<IcariaJigsawStructure> verifyRange(IcariaJigsawStructure pStructure) {
		return pStructure.maxDistanceFromCenter.horizontal() + IcariaJigsawStructure.terrainAdaptation(pStructure) > 256 ? DataResult.error(() -> "Structure size including terrain adaptation must not exceed 256.") : DataResult.success(pStructure);
	}

	@Override
	public Optional<Structure.GenerationStub> findGenerationPoint(Structure.GenerationContext pGenerationContext) {
		var chunkGenerator = pGenerationContext.chunkGenerator();
		var chunkPos = pGenerationContext.chunkPos();
		var levelHeightAccessor = pGenerationContext.heightAccessor();
		var worldgenRandom = pGenerationContext.random();

		var worldGenerationContext = new WorldGenerationContext(chunkGenerator, levelHeightAccessor);

		var x = chunkPos.getMinBlockX() + worldgenRandom.nextInt(16);
		var z = chunkPos.getMinBlockZ() + worldgenRandom.nextInt(16);

		var noiseColumn = chunkGenerator.getBaseColumn(x, z, levelHeightAccessor, pGenerationContext.randomState());

		var i = this.minHeight.sample(worldgenRandom, worldGenerationContext);
		var j = this.maxHeight.sample(worldgenRandom, worldGenerationContext);

		var mutableBlockPos = new BlockPos.MutableBlockPos(x, j, z);

		while (i <= j) {
			var blockState = noiseColumn.getBlock(j);
			var blockStateBelow = noiseColumn.getBlock(--j);
			if (blockState.isAir() && blockStateBelow.isFaceSturdy(EmptyBlockGetter.INSTANCE, mutableBlockPos.setY(j), Direction.UP)) {
				break;
			}
		}

		if (i <= j) {
			var blockPos = new BlockPos(x, j, z);
			var poolAliasLookup = PoolAliasLookup.create(this.poolAliases, blockPos, pGenerationContext.seed());
			return JigsawPlacement.addPieces(pGenerationContext, this.startPool, this.startJigsawName, this.maxDepth, blockPos, this.useExpansionHack, this.projectStartToHeightmap, this.maxDistanceFromCenter, poolAliasLookup, this.dimensionPadding, this.liquidSettings);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public StructureType<?> type() {
		return IcariaStructureTypes.JIGSAW.get();
	}
}
