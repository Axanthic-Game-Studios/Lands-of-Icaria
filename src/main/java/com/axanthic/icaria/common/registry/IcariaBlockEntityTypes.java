package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.block.entity.*;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockEntityTypes {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, IcariaIdents.ID);

	public static final Supplier<BlockEntityType<IcariaChestBlockEntity>> CHEST = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("icaria_chest", () -> BlockEntityType.Builder.of(IcariaChestBlockEntity::new, IcariaBlocks.CHEST.get()).build(null));
	public static final Supplier<BlockEntityType<CrystalBlockEntity>> CRYSTAL = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("crystal", () -> BlockEntityType.Builder.of(CrystalBlockEntity::new, IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaBlocks.HALITE_CRYSTAL.get(), IcariaBlocks.JASPER_CRYSTAL.get(), IcariaBlocks.ZIRCON_CRYSTAL.get()).build(null));
	public static final Supplier<BlockEntityType<ForgeBlockEntity>> FORGE = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("forge", () -> BlockEntityType.Builder.of(ForgeBlockEntity::new, IcariaBlocks.FORGE.get()).build(null));
	public static final Supplier<BlockEntityType<ForgeRedirectorBlockEntity>> FORGE_REDIRECTOR = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("forge_redirector", () -> BlockEntityType.Builder.of(ForgeRedirectorBlockEntity::new, IcariaBlocks.FORGE.get()).build(null));
	public static final Supplier<BlockEntityType<GrinderBlockEntity>> GRINDER = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("grinder", () -> BlockEntityType.Builder.of(GrinderBlockEntity::new, IcariaBlocks.GRINDER.get()).build(null));
	public static final Supplier<BlockEntityType<GrinderRedirectorBlockEntity>> GRINDER_REDIRECTOR = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("grinder_redirector", () -> BlockEntityType.Builder.of(GrinderRedirectorBlockEntity::new, IcariaBlocks.GRINDER.get()).build(null));
	public static final Supplier<BlockEntityType<IcariaHangingSignBlockEntity>> HANGING_SIGN = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("icaria_hanging_sign", () -> BlockEntityType.Builder.of(IcariaHangingSignBlockEntity::new, IcariaBlocks.CYPRESS_HANGING_SIGN.get(), IcariaBlocks.CYPRESS_WALL_HANGING_SIGN.get(), IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_HANGING_SIGN.get(), IcariaBlocks.FIR_HANGING_SIGN.get(), IcariaBlocks.FIR_WALL_HANGING_SIGN.get(), IcariaBlocks.LAUREL_HANGING_SIGN.get(), IcariaBlocks.LAUREL_WALL_HANGING_SIGN.get(), IcariaBlocks.OLIVE_HANGING_SIGN.get(), IcariaBlocks.OLIVE_WALL_HANGING_SIGN.get(), IcariaBlocks.PLANE_HANGING_SIGN.get(), IcariaBlocks.PLANE_WALL_HANGING_SIGN.get(), IcariaBlocks.POPULUS_HANGING_SIGN.get(), IcariaBlocks.POPULUS_WALL_HANGING_SIGN.get()).build(null));
	public static final Supplier<BlockEntityType<KettleBlockEntity>> KETTLE = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("kettle", () -> BlockEntityType.Builder.of(KettleBlockEntity::new, IcariaBlocks.KETTLE.get()).build(null));
	public static final Supplier<BlockEntityType<KilnBlockEntity>> KILN = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("kiln", () -> BlockEntityType.Builder.of(KilnBlockEntity::new, IcariaBlocks.KILN.get()).build(null));
	public static final Supplier<BlockEntityType<KilnRedirectorBlockEntity>> KILN_REDIRECTOR = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("kiln_redirector", () -> BlockEntityType.Builder.of(KilnRedirectorBlockEntity::new, IcariaBlocks.KILN.get()).build(null));
	public static final Supplier<BlockEntityType<IcariaSignBlockEntity>> SIGN = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("icaria_sign", () -> BlockEntityType.Builder.of(IcariaSignBlockEntity::new, IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_WALL_SIGN.get(), IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_WALL_SIGN.get()).build(null));
	public static final Supplier<BlockEntityType<IcariaSkullBlockEntity>> SKULL = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("icaria_skull", () -> BlockEntityType.Builder.of(IcariaSkullBlockEntity::new, IcariaBlocks.AETERNAE_SKULL.get(), IcariaBlocks.AETERNAE_WALL_SKULL.get(), IcariaBlocks.ARGAN_HOUND_SKULL.get(), IcariaBlocks.ARGAN_HOUND_WALL_SKULL.get(), IcariaBlocks.CAPELLA_SKULL.get(), IcariaBlocks.CAPELLA_WALL_SKULL.get(), IcariaBlocks.CATOBLEPAS_SKULL.get(), IcariaBlocks.CATOBLEPAS_WALL_SKULL.get(), IcariaBlocks.CERVER_SKULL.get(), IcariaBlocks.CERVER_WALL_SKULL.get(), IcariaBlocks.CROCOTTA_SKULL.get(), IcariaBlocks.CROCOTTA_WALL_SKULL.get(), IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get(), IcariaBlocks.CYPRESS_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get(), IcariaBlocks.DROUGHTROOT_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.FIR_FOREST_HAG_SKULL.get(), IcariaBlocks.FIR_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get(), IcariaBlocks.LAUREL_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get(), IcariaBlocks.OLIVE_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.PLANE_FOREST_HAG_SKULL.get(), IcariaBlocks.PLANE_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get(), IcariaBlocks.POPULUS_FOREST_HAG_WALL_SKULL.get(), IcariaBlocks.REVENANT_SKULL.get(), IcariaBlocks.REVENANT_WALL_SKULL.get(), IcariaBlocks.SOW_SKULL.get(), IcariaBlocks.SOW_WALL_SKULL.get()).build(null));
	public static final Supplier<BlockEntityType<StorageVaseBlockEntity>> STORAGE_VASE = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("storage_vase", () -> BlockEntityType.Builder.of(StorageVaseBlockEntity::new, IcariaBlocks.STORAGE_VASE.get(), IcariaBlocks.WHITE_STORAGE_VASE.get(), IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), IcariaBlocks.GRAY_STORAGE_VASE.get(), IcariaBlocks.BLACK_STORAGE_VASE.get(), IcariaBlocks.BROWN_STORAGE_VASE.get(), IcariaBlocks.RED_STORAGE_VASE.get(), IcariaBlocks.ORANGE_STORAGE_VASE.get(), IcariaBlocks.YELLOW_STORAGE_VASE.get(), IcariaBlocks.LIME_STORAGE_VASE.get(), IcariaBlocks.GREEN_STORAGE_VASE.get(), IcariaBlocks.CYAN_STORAGE_VASE.get(), IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), IcariaBlocks.BLUE_STORAGE_VASE.get(), IcariaBlocks.PURPLE_STORAGE_VASE.get(), IcariaBlocks.MAGENTA_STORAGE_VASE.get(), IcariaBlocks.PINK_STORAGE_VASE.get()).build(null));
	public static final Supplier<BlockEntityType<IcariaSpawnerBlockEntity>> SPAWNER = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("icaria_spawner", () -> BlockEntityType.Builder.of(IcariaSpawnerBlockEntity::new, IcariaBlocks.ARACHNE_SPAWNER.get(), IcariaBlocks.REVENANT_SPAWNER.get()).build(null));
	public static final Supplier<BlockEntityType<IcariaTrappedChestBlockEntity>> TRAPPED_CHEST = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("icaria_trapped_chest", () -> BlockEntityType.Builder.of(IcariaTrappedChestBlockEntity::new, IcariaBlocks.TRAPPED_CHEST.get()).build(null));
	public static final Supplier<BlockEntityType<TroughBlockEntity>> TROUGH = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("trough", () -> BlockEntityType.Builder.of(TroughBlockEntity::new, IcariaBlocks.CYPRESS_TROUGH.get(), IcariaBlocks.DROUGHTROOT_TROUGH.get(), IcariaBlocks.FIR_TROUGH.get(), IcariaBlocks.LAUREL_TROUGH.get(), IcariaBlocks.OLIVE_TROUGH.get(), IcariaBlocks.PLANE_TROUGH.get(), IcariaBlocks.POPULUS_TROUGH.get()).build(null));
}
