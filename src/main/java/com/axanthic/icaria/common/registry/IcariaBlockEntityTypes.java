package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.entity.*;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaBlockEntityTypes {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, IcariaKeys.ID);

	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<BathtubBlockEntity>> BATHTUB = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("bathtub", () -> new BlockEntityType<>(BathtubBlockEntity::new, IcariaBlocks.CYPRESS_BATHTUB.get(), IcariaBlocks.DROUGHTROOT_BATHTUB.get(), IcariaBlocks.FIR_BATHTUB.get(), IcariaBlocks.LAUREL_BATHTUB.get(), IcariaBlocks.OLIVE_BATHTUB.get(), IcariaBlocks.PLANE_BATHTUB.get(), IcariaBlocks.POPULUS_BATHTUB.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IcariaChestBlockEntity>> CHEST = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("chest", () -> new BlockEntityType<>(IcariaChestBlockEntity::new, IcariaBlocks.CHEST.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CrystalBlockEntity>> CRYSTAL = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("crystal", () -> new BlockEntityType<>(CrystalBlockEntity::new, IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaBlocks.HALITE_CRYSTAL.get(), IcariaBlocks.JASPER_CRYSTAL.get(), IcariaBlocks.ZIRCON_CRYSTAL.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FireplaceBlockEntity>> FIREPLACE = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("fireplace", () -> new BlockEntityType<>(FireplaceBlockEntity::new, IcariaBlocks.GRATE_FIREPLACE.get(), IcariaBlocks.POT_FIREPLACE.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FlowerPotCountertopBlockEntity>> FLOWER_POT_COUNTERTOP = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("flower_pot_countertop", () -> new BlockEntityType<>(FlowerPotCountertopBlockEntity::new, IcariaBlocks.CYPRESS_FLOWER_POT_COUNTERTOP.get(), IcariaBlocks.DROUGHTROOT_FLOWER_POT_COUNTERTOP.get(), IcariaBlocks.FIR_FLOWER_POT_COUNTERTOP.get(), IcariaBlocks.LAUREL_FLOWER_POT_COUNTERTOP.get(), IcariaBlocks.OLIVE_FLOWER_POT_COUNTERTOP.get(), IcariaBlocks.PLANE_FLOWER_POT_COUNTERTOP.get(), IcariaBlocks.POPULUS_FLOWER_POT_COUNTERTOP.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ForgeBlockEntity>> FORGE = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("forge", () -> new BlockEntityType<>(ForgeBlockEntity::new, IcariaBlocks.FORGE.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrinderBlockEntity>> GRINDER = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("grinder", () -> new BlockEntityType<>(GrinderBlockEntity::new, IcariaBlocks.GRINDER.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HutchBlockEntity>> HUTCH = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("hutch", () -> new BlockEntityType<>(HutchBlockEntity::new, IcariaBlocks.CYPRESS_HUTCH.get(), IcariaBlocks.CYPRESS_WALL_HUTCH.get(), IcariaBlocks.DROUGHTROOT_HUTCH.get(), IcariaBlocks.DROUGHTROOT_WALL_HUTCH.get(), IcariaBlocks.FIR_HUTCH.get(), IcariaBlocks.FIR_WALL_HUTCH.get(), IcariaBlocks.LAUREL_HUTCH.get(), IcariaBlocks.LAUREL_WALL_HUTCH.get(), IcariaBlocks.OLIVE_HUTCH.get(), IcariaBlocks.OLIVE_WALL_HUTCH.get(), IcariaBlocks.PLANE_HUTCH.get(), IcariaBlocks.PLANE_WALL_HUTCH.get(), IcariaBlocks.POPULUS_HUTCH.get(), IcariaBlocks.POPULUS_WALL_HUTCH.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KettleBlockEntity>> KETTLE = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("kettle", () -> new BlockEntityType<>(KettleBlockEntity::new, IcariaBlocks.KETTLE.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<KilnBlockEntity>> KILN = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("kiln", () -> new BlockEntityType<>(KilnBlockEntity::new, IcariaBlocks.KILN.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PotBlockEntity>> POT = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("pot", () -> new BlockEntityType<>(PotBlockEntity::new, IcariaBlocks.POT.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IcariaSignBlockEntity>> SIGN = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("sign", () -> new BlockEntityType<>(IcariaSignBlockEntity::new, IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_WALL_SIGN.get(), IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_WALL_SIGN.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StorageVaseBlockEntity>> STORAGE_VASE = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("storage_vase", () -> new BlockEntityType<>(StorageVaseBlockEntity::new, IcariaBlocks.STORAGE_VASE.get(), IcariaBlocks.WHITE_STORAGE_VASE.get(), IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), IcariaBlocks.GRAY_STORAGE_VASE.get(), IcariaBlocks.BLACK_STORAGE_VASE.get(), IcariaBlocks.BROWN_STORAGE_VASE.get(), IcariaBlocks.RED_STORAGE_VASE.get(), IcariaBlocks.ORANGE_STORAGE_VASE.get(), IcariaBlocks.YELLOW_STORAGE_VASE.get(), IcariaBlocks.LIME_STORAGE_VASE.get(), IcariaBlocks.GREEN_STORAGE_VASE.get(), IcariaBlocks.CYAN_STORAGE_VASE.get(), IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), IcariaBlocks.BLUE_STORAGE_VASE.get(), IcariaBlocks.PURPLE_STORAGE_VASE.get(), IcariaBlocks.MAGENTA_STORAGE_VASE.get(), IcariaBlocks.PINK_STORAGE_VASE.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<IcariaTrappedChestBlockEntity>> TRAPPED_CHEST = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("trapped_chest", () -> new BlockEntityType<>(IcariaTrappedChestBlockEntity::new, IcariaBlocks.TRAPPED_CHEST.get()));
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TroughBlockEntity>> TROUGH = IcariaBlockEntityTypes.BLOCK_ENTITY_TYPES.register("trough", () -> new BlockEntityType<>(TroughBlockEntity::new, IcariaBlocks.CYPRESS_TROUGH.get(), IcariaBlocks.DROUGHTROOT_TROUGH.get(), IcariaBlocks.FIR_TROUGH.get(), IcariaBlocks.LAUREL_TROUGH.get(), IcariaBlocks.OLIVE_TROUGH.get(), IcariaBlocks.PLANE_TROUGH.get(), IcariaBlocks.POPULUS_TROUGH.get()));
}
