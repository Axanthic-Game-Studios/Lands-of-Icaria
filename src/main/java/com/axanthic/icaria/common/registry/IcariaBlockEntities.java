package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.entities.CrystalBlockEntity;
import com.axanthic.icaria.common.entities.IcariaSignBlockEntity;
import com.axanthic.icaria.common.entities.StorageVaseBlockEntity;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.level.block.entity.BlockEntityType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, IcariaInfo.MODID);

	public static final RegistryObject<BlockEntityType<CrystalBlockEntity>> CRYSTAL = BLOCK_ENTITIES.register("crystal", () -> BlockEntityType.Builder.of(CrystalBlockEntity::new, IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaBlocks.HALITE_CRYSTAL.get(), IcariaBlocks.JASPER_CRYSTAL.get(), IcariaBlocks.ZIRCON_CRYSTAL.get()).build(null));
	public static final RegistryObject<BlockEntityType<IcariaSignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(IcariaSignBlockEntity::new, IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_WALL_SIGN.get(), IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_WALL_SIGN.get()).build(null));
	public static final RegistryObject<BlockEntityType<StorageVaseBlockEntity>> STORAGE_VASE = BLOCK_ENTITIES.register("storage_vase", () -> BlockEntityType.Builder.of(StorageVaseBlockEntity::new, IcariaBlocks.STORAGE_VASE.get(), IcariaBlocks.WHITE_STORAGE_VASE.get(), IcariaBlocks.ORANGE_STORAGE_VASE.get(), IcariaBlocks.MAGENTA_STORAGE_VASE.get(), IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), IcariaBlocks.YELLOW_STORAGE_VASE.get(), IcariaBlocks.LIME_STORAGE_VASE.get(), IcariaBlocks.PINK_STORAGE_VASE.get(), IcariaBlocks.GRAY_STORAGE_VASE.get(), IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), IcariaBlocks.CYAN_STORAGE_VASE.get(), IcariaBlocks.PURPLE_STORAGE_VASE.get(), IcariaBlocks.BLUE_STORAGE_VASE.get(), IcariaBlocks.BROWN_STORAGE_VASE.get(), IcariaBlocks.GREEN_STORAGE_VASE.get(), IcariaBlocks.RED_STORAGE_VASE.get(), IcariaBlocks.BLACK_STORAGE_VASE.get()).build(null));
}