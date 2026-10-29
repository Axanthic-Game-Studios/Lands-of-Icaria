package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.world.feature.*;
import com.axanthic.icaria.common.world.feature.herb.*;
import com.axanthic.icaria.common.world.feature.pillar.FallenRelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.pillar.RelicstonePillarFeature;
import com.axanthic.icaria.common.world.feature.tree.*;
import com.axanthic.icaria.common.world.feature.tree.fallen.*;
import com.axanthic.icaria.common.world.feature.tree.small.*;
import com.axanthic.icaria.common.world.feature.vine.*;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaFeatureTypes {
	public static final DeferredRegister<MapCodec<? extends Feature>> FEATURE_TYPES = DeferredRegister.create(Registries.FEATURE_TYPE, IcariaIds.ID);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> HIDDEN = IcariaFeatureTypes.FEATURE_TYPES.register("hidden", () -> HiddenFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SPIKE = IcariaFeatureTypes.FEATURE_TYPES.register("spike", () -> SpikeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> BOULDER = IcariaFeatureTypes.FEATURE_TYPES.register("boulder", () -> BoulderFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_PILLAR = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_pillar", () -> FallenRelicstonePillarFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> PILLAR = IcariaFeatureTypes.FEATURE_TYPES.register("pillar", () -> RelicstonePillarFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> CYPRESS_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("cypress_tree", () -> CypressTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> DROUGHTROOT_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("droughtroot_tree", () -> DroughtrootTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FIR_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fir_tree", () -> FirTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> LAUREL_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("laurel_tree", () -> LaurelTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> OLIVE_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("olive_tree", () -> OliveTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> PLANE_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("plane_tree", () -> PlaneTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> POPULUS_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("populus_tree", () -> PopulusTreeFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> DEAD_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("dead_tree", () -> DeadTreeFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_CYPRESS_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_cypress_tree", () -> FallenCypressTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_DROUGHTROOT_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_droughtroot_tree", () -> FallenDroughtrootTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_FIR_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_fir_tree", () -> FallenFirTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_LAUREL_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_laurel_tree", () -> FallenLaurelTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_OLIVE_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_olive_tree", () -> FallenOliveTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_PLANE_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_plane_tree", () -> FallenPlaneTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> FALLEN_POPULUS_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("fallen_populus_tree", () -> FallenPopulusTreeFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SMALL_CYPRESS_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("small_cypress_tree", () -> SmallCypressTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SMALL_DROUGHTROOT_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("small_droughtroot_tree", () -> SmallDroughtrootTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SMALL_FIR_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("small_fir_tree", () -> SmallFirTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SMALL_LAUREL_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("small_laurel_tree", () -> SmallLaurelTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SMALL_OLIVE_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("small_olive_tree", () -> SmallOliveTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SMALL_PLANE_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("small_plane_tree", () -> SmallPlaneTreeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SMALL_POPULUS_TREE = IcariaFeatureTypes.FEATURE_TYPES.register("small_populus_tree", () -> SmallPopulusTreeFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> BLOOMY_VINE = IcariaFeatureTypes.FEATURE_TYPES.register("bloomy_vine", () -> BloomyVineFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> BRANCHY_VINE = IcariaFeatureTypes.FEATURE_TYPES.register("branchy_vine", () -> BranchyVineFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> BRUSHY_VINE = IcariaFeatureTypes.FEATURE_TYPES.register("brushy_vine", () -> BrushyVineFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> DRY_VINE = IcariaFeatureTypes.FEATURE_TYPES.register("dry_vine", () -> DryVineFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> REEDY_VINE = IcariaFeatureTypes.FEATURE_TYPES.register("reedy_vine", () -> ReedyVineFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> SWIRLY_VINE = IcariaFeatureTypes.FEATURE_TYPES.register("swirly_vine", () -> SwirlyVineFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> THORNY_VINE = IcariaFeatureTypes.FEATURE_TYPES.register("thorny_vine", () -> ThornyVineFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> VOIDLILY = IcariaFeatureTypes.FEATURE_TYPES.register("voidlily", () -> VoidlilyFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> BOLBOS = IcariaFeatureTypes.FEATURE_TYPES.register("bolbos", () -> BolbosFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> DATHULLA = IcariaFeatureTypes.FEATURE_TYPES.register("dathulla", () -> DathullaFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> MONDANOS = IcariaFeatureTypes.FEATURE_TYPES.register("mondanos", () -> MondanosFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> MOTH_AGARIC = IcariaFeatureTypes.FEATURE_TYPES.register("moth_agaric", () -> MothAgaricFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> NAMDRAKE = IcariaFeatureTypes.FEATURE_TYPES.register("namdrake", () -> NamdrakeFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> PSILOCYBOS = IcariaFeatureTypes.FEATURE_TYPES.register("psilocybos", () -> PsilocybosFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> ROWAN = IcariaFeatureTypes.FEATURE_TYPES.register("rowan", () -> RowanFeature.CODEC);
	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> WILTED_ELM = IcariaFeatureTypes.FEATURE_TYPES.register("wilted_elm", () -> WiltedElmFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> GROUND_FLOWERS = IcariaFeatureTypes.FEATURE_TYPES.register("ground_flowers", () -> GroundFlowersFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> GROUND_SHROOMS = IcariaFeatureTypes.FEATURE_TYPES.register("ground_shrooms", () -> GroundShroomsFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> CARDON_CACTUS = IcariaFeatureTypes.FEATURE_TYPES.register("cardon_cactus", () -> CardonCactusFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> STRAWBERRY_BUSH = IcariaFeatureTypes.FEATURE_TYPES.register("strawberry_bush", () -> StrawberryBushFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> RUIN = IcariaFeatureTypes.FEATURE_TYPES.register("ruin", () -> RuinFeature.CODEC);

	public static final DeferredHolder<MapCodec<? extends Feature>, MapCodec<? extends Feature>> VILLAGE = IcariaFeatureTypes.FEATURE_TYPES.register("village", () -> VillageFeature.CODEC);
}
