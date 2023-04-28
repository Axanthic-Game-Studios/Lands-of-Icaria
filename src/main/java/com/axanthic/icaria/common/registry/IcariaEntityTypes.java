package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class IcariaEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, IcariaInfo.ID);

	public static final RegistryObject<EntityType<AeternaeEntity>> AETERNAE = register("aeternae", Builder.of(AeternaeEntity::new, MobCategory.CREATURE).sized(1.25F, 1.75F));
	public static final RegistryObject<EntityType<ArachneEntity>> ARACHNE = register("arachne", Builder.of(ArachneEntity::new, MobCategory.CREATURE).sized(2.0F, 2.0F));
	public static final RegistryObject<EntityType<ArachneDroneEntity>> ARACHNE_DRONE = register("arachne_drone", Builder.of(ArachneDroneEntity::new, MobCategory.CREATURE).sized(1.0F, 0.5F));
	public static final RegistryObject<EntityType<ArganHoundEntity>> ARGAN_HOUND = register("argan_hound", Builder.of(ArganHoundEntity::new, MobCategory.CREATURE).sized(1.25F, 1.0F));
	public static final RegistryObject<EntityType<BidentEntity>> BIDENT = register("bident", Builder.<BidentEntity>of(BidentEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<CatoblepasEntity>> CATOBLEPAS = register("catoblepas", Builder.of(CatoblepasEntity::new, MobCategory.CREATURE).sized(1.25F, 1.25F));
	public static final RegistryObject<EntityType<CerverEntity>> CERVER = register("cerver", Builder.of(CerverEntity::new, MobCategory.CREATURE).sized(1.25F, 1.0F));
	public static final RegistryObject<EntityType<GreekFireGrenadeEntity>> GREEK_FIRE_GRENADE = register("greek_fire_grenade", Builder.<GreekFireGrenadeEntity>of(GreekFireGrenadeEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<ForestHagEntity>> CYPRESS_FOREST_HAG = register("cypress_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.CREATURE).sized(1.0F, 3.0F));
	public static final RegistryObject<EntityType<ForestHagEntity>> DROUGHTROOT_FOREST_HAG = register("droughtroot_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.CREATURE).sized(1.0F, 3.0F));
	public static final RegistryObject<EntityType<ForestHagEntity>> FIR_FOREST_HAG = register("fir_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.CREATURE).sized(1.0F, 3.0F));
	public static final RegistryObject<EntityType<ForestHagEntity>> LAUREL_FOREST_HAG = register("laurel_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.CREATURE).sized(1.0F, 3.0F));
	public static final RegistryObject<EntityType<ForestHagEntity>> OLIVE_FOREST_HAG = register("olive_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.CREATURE).sized(1.0F, 3.0F));
	public static final RegistryObject<EntityType<ForestHagEntity>> PLANE_FOREST_HAG = register("plane_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.CREATURE).sized(1.0F, 3.0F));
	public static final RegistryObject<EntityType<ForestHagEntity>> POPULUS_FOREST_HAG = register("populus_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.CREATURE).sized(1.0F, 3.0F));
	public static final RegistryObject<EntityType<HyliasterEntity>> HYLIASTER = register("hyliaster", Builder.of(HyliasterEntity::new, MobCategory.CREATURE).sized(0.1875F, 0.1875F));
	public static final RegistryObject<EntityType<JellyfishEntity>> ENDER_JELLYFISH = register("ender_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<JellyfishEntity>> FIRE_JELLYFISH = register("fire_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<JellyfishEntity>> NATURE_JELLYFISH = register("nature_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<JellyfishEntity>> VOID_JELLYFISH = register("void_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<JellyfishEntity>> WATER_JELLYFISH = register("water_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<MyrmekeDroneEntity>> MYRMEKE_DRONE = register("myrmeke_drone", Builder.of(MyrmekeDroneEntity::new, MobCategory.CREATURE).sized(1.0F, 0.5F));
	public static final RegistryObject<EntityType<MyrmekeSoldierEntity>> MYRMEKE_SOLDIER = register("myrmeke_soldier", Builder.of(MyrmekeSoldierEntity::new, MobCategory.CREATURE).sized(1.0F, 0.5F));
	public static final RegistryObject<EntityType<MyrmekeQueenEntity>> MYRMEKE_QUEEN = register("myrmeke_queen", Builder.of(MyrmekeQueenEntity::new, MobCategory.CREATURE).sized(1.25F, 0.5F));
	public static final RegistryObject<EntityType<CaptainRevenantEntity>> CAPTAIN_REVENANT = register("captain_revenant", Builder.of(CaptainRevenantEntity::new, MobCategory.CREATURE).sized(0.75F, 2.0F));
	public static final RegistryObject<EntityType<CivilianRevenantEntity>> CIVILIAN_REVENANT = register("civilian_revenant", Builder.of(CivilianRevenantEntity::new, MobCategory.CREATURE).sized(0.75F, 2.0F));
	public static final RegistryObject<EntityType<CrawlerRevenantEntity>> CRAWLER_REVENANT = register("crawler_revenant", Builder.of(CrawlerRevenantEntity::new, MobCategory.CREATURE).sized(1.0F, 0.75F));
	public static final RegistryObject<EntityType<OvergrownRevenantEntity>> OVERGROWN_REVENANT = register("overgrown_revenant", Builder.of(OvergrownRevenantEntity::new, MobCategory.CREATURE).sized(0.75F, 2.0F));
	public static final RegistryObject<EntityType<PyromancerRevenantEntity>> PYROMANCER_REVENANT = register("pyromancer_revenant", Builder.of(PyromancerRevenantEntity::new, MobCategory.CREATURE).sized(0.75F, 2.0F));
	public static final RegistryObject<EntityType<NetherPyromancerRevenantEntity>> NETHER_PYROMANCER_REVENANT = register("nether_pyromancer_revenant", Builder.of(NetherPyromancerRevenantEntity::new, MobCategory.CREATURE).sized(0.75F, 2.0F));
	public static final RegistryObject<EntityType<SoldierRevenantEntity>> SOLDIER_REVENANT = register("soldier_revenant", Builder.of(SoldierRevenantEntity::new, MobCategory.CREATURE).sized(0.75F, 2.0F));
	public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION = register("scorpion", Builder.of(ScorpionEntity::new, MobCategory.CREATURE).sized(1.5F, 1.0F));
	public static final RegistryObject<EntityType<SlugEntity>> CRYSTAL_SLUG = register("crystal_slug", Builder.of(SlugEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<SnullEntity>> FOREST_SNULL = register("forest_snull", Builder.of(SnullEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<SnullEntity>> SNULL = register("snull", Builder.of(SnullEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));
	public static final RegistryObject<EntityType<SowEntity>> SOW = register("sow", Builder.of(SowEntity::new, MobCategory.CREATURE).sized(1.0F, 1.0F));

	public static <T extends Entity> RegistryObject<EntityType<T>> register(String pName, Builder<T> pBuilder) {
		return ENTITY_TYPES.register(pName, () -> pBuilder.build(IcariaInfo.ID + ":" + pName));
	}
}