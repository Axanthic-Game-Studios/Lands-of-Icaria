package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.entities.CrystalBlockEntity;
import com.axanthic.icaria.common.entities.IcariaSignBlockEntity;
import com.axanthic.icaria.common.util.IcariaInfo;
import com.axanthic.icaria.common.entities.ThrownBidentEntity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, IcariaInfo.MODID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, IcariaInfo.MODID);

	public static final RegistryObject<EntityType<ThrownBidentEntity>> BIDENT = register("bident", Builder.<ThrownBidentEntity>of(ThrownBidentEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));

	public static final RegistryObject<BlockEntityType<CrystalBlockEntity>> CRYSTAL = BLOCK_ENTITIES.register("crystal", () -> BlockEntityType.Builder.of(CrystalBlockEntity::new, IcariaBlocks.CALCITE_CRYSTAL.get(), IcariaBlocks.HALITE_CRYSTAL.get(), IcariaBlocks.JASPER_CRYSTAL.get(), IcariaBlocks.ZIRCON_CRYSTAL.get()).build(null));
	public static final RegistryObject<BlockEntityType<IcariaSignBlockEntity>> SIGN = BLOCK_ENTITIES.register("sign", () -> BlockEntityType.Builder.of(IcariaSignBlockEntity::new, IcariaBlocks.CYPRESS_SIGN.get(), IcariaBlocks.CYPRESS_WALL_SIGN.get(), IcariaBlocks.DROUGHTROOT_SIGN.get(), IcariaBlocks.DROUGHTROOT_WALL_SIGN.get(), IcariaBlocks.FIR_SIGN.get(), IcariaBlocks.FIR_WALL_SIGN.get(), IcariaBlocks.LAUREL_SIGN.get(), IcariaBlocks.LAUREL_WALL_SIGN.get(), IcariaBlocks.OLIVE_SIGN.get(), IcariaBlocks.OLIVE_WALL_SIGN.get(), IcariaBlocks.PLANE_SIGN.get(), IcariaBlocks.PLANE_WALL_SIGN.get(), IcariaBlocks.POPULUS_SIGN.get(), IcariaBlocks.POPULUS_WALL_SIGN.get()).build(null));

	public static <T extends Entity> RegistryObject<EntityType<T>> register(String name, Builder<T> builder) {
		return ENTITIES.register(name, () -> builder.build(IcariaInfo.MODID + ":" + name));
	}
}
