package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.util.IcariaInfo;
import com.axanthic.icaria.common.entities.ThrownBident;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaEntities {

	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, IcariaInfo.MODID);

	public static final RegistryObject<EntityType<ThrownBident>> BIDENT = register("bident", EntityType.Builder.<ThrownBident>of(ThrownBident::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> sup) {
		return ENTITIES.register(name, () -> sup.build(IcariaInfo.MODID + ":" + name));
	}
}
