package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcariaEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, IcariaInfo.ID);

	public static final RegistryObject<EntityType<AeternaeEntity>> AETERNAE = IcariaEntityTypes.register("aeternae", Builder.of(AeternaeEntity::new, MobCategory.CREATURE).sized(1.249F, 1.749F));
	public static final RegistryObject<EntityType<ArachneEntity>> ARACHNE = IcariaEntityTypes.register("arachne", Builder.of(ArachneEntity::new, MobCategory.MONSTER).sized(1.49F, 1.99F));
	public static final RegistryObject<EntityType<ArachneDroneEntity>> ARACHNE_DRONE = IcariaEntityTypes.register("arachne_drone", Builder.of(ArachneDroneEntity::new, MobCategory.MONSTER).sized(0.749F, 0.49F));
	public static final RegistryObject<EntityType<ArganHoundEntity>> ARGAN_HOUND = IcariaEntityTypes.register("argan_hound", Builder.of(ArganHoundEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F));
	public static final RegistryObject<EntityType<IcariaBarrelEntity>> BARREL = IcariaEntityTypes.register("barrel", Builder.<IcariaBarrelEntity>of(IcariaBarrelEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20));
	public static final RegistryObject<EntityType<BidentEntity>> BIDENT = IcariaEntityTypes.register("bident", Builder.<BidentEntity>of(BidentEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<CatoblepasEntity>> CATOBLEPAS = IcariaEntityTypes.register("catoblepas", Builder.of(CatoblepasEntity::new, MobCategory.CREATURE).sized(1.249F, 1.249F));
	public static final RegistryObject<EntityType<CerverEntity>> CERVER = IcariaEntityTypes.register("cerver", Builder.of(CerverEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F));
	public static final RegistryObject<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = IcariaEntityTypes.register("floating_block", Builder.<FloatingBlockEntity>of(FloatingBlockEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20));
	public static final RegistryObject<EntityType<GreekFireGrenadeEntity>> GREEK_FIRE_GRENADE = IcariaEntityTypes.register("greek_fire_grenade", Builder.<GreekFireGrenadeEntity>of(GreekFireGrenadeEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<ForestHagEntity>> CYPRESS_FOREST_HAG = IcariaEntityTypes.register("cypress_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.99F));
	public static final RegistryObject<EntityType<ForestHagEntity>> DROUGHTROOT_FOREST_HAG = IcariaEntityTypes.register("droughtroot_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.99F));
	public static final RegistryObject<EntityType<ForestHagEntity>> FIR_FOREST_HAG = IcariaEntityTypes.register("fir_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.99F));
	public static final RegistryObject<EntityType<ForestHagEntity>> LAUREL_FOREST_HAG = IcariaEntityTypes.register("laurel_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.99F));
	public static final RegistryObject<EntityType<ForestHagEntity>> OLIVE_FOREST_HAG = IcariaEntityTypes.register("olive_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.99F));
	public static final RegistryObject<EntityType<ForestHagEntity>> PLANE_FOREST_HAG = IcariaEntityTypes.register("plane_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.99F));
	public static final RegistryObject<EntityType<ForestHagEntity>> POPULUS_FOREST_HAG = IcariaEntityTypes.register("populus_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.99F));
	public static final RegistryObject<EntityType<HyliasterEntity>> HYLIASTER = IcariaEntityTypes.register("hyliaster", Builder.of(HyliasterEntity::new, MobCategory.MONSTER).sized(0.18749F, 0.18749F));
	public static final RegistryObject<EntityType<JellyfishEntity>> ENDER_JELLYFISH = IcariaEntityTypes.register("ender_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<JellyfishEntity>> FIRE_JELLYFISH = IcariaEntityTypes.register("fire_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<JellyfishEntity>> NATURE_JELLYFISH = IcariaEntityTypes.register("nature_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<JellyfishEntity>> VOID_JELLYFISH = IcariaEntityTypes.register("void_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<JellyfishEntity>> WATER_JELLYFISH = IcariaEntityTypes.register("water_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<LootVaseEntity>> LOOT_VASE = IcariaEntityTypes.register("loot_vase", Builder.<LootVaseEntity>of(LootVaseEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20));
	public static final RegistryObject<EntityType<MyrmekeDroneEntity>> MYRMEKE_DRONE = IcariaEntityTypes.register("myrmeke_drone", Builder.of(MyrmekeDroneEntity::new, MobCategory.MONSTER).sized(0.749F, 0.49F));
	public static final RegistryObject<EntityType<MyrmekeSoldierEntity>> MYRMEKE_SOLDIER = IcariaEntityTypes.register("myrmeke_soldier", Builder.of(MyrmekeSoldierEntity::new, MobCategory.MONSTER).sized(0.749F, 0.49F));
	public static final RegistryObject<EntityType<MyrmekeQueenEntity>> MYRMEKE_QUEEN = IcariaEntityTypes.register("myrmeke_queen", Builder.of(MyrmekeQueenEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F));
	public static final RegistryObject<EntityType<CaptainRevenantEntity>> CAPTAIN_REVENANT = IcariaEntityTypes.register("captain_revenant", Builder.of(CaptainRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F));
	public static final RegistryObject<EntityType<CivilianRevenantEntity>> CIVILIAN_REVENANT = IcariaEntityTypes.register("civilian_revenant", Builder.of(CivilianRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F));
	public static final RegistryObject<EntityType<CrawlerRevenantEntity>> CRAWLER_REVENANT = IcariaEntityTypes.register("crawler_revenant", Builder.of(CrawlerRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<OvergrownRevenantEntity>> OVERGROWN_REVENANT = IcariaEntityTypes.register("overgrown_revenant", Builder.of(OvergrownRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F));
	public static final RegistryObject<EntityType<PyromancerRevenantEntity>> PYROMANCER_REVENANT = IcariaEntityTypes.register("pyromancer_revenant", Builder.of(PyromancerRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F));
	public static final RegistryObject<EntityType<NetherPyromancerRevenantEntity>> NETHER_PYROMANCER_REVENANT = IcariaEntityTypes.register("nether_pyromancer_revenant", Builder.of(NetherPyromancerRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F));
	public static final RegistryObject<EntityType<SoldierRevenantEntity>> SOLDIER_REVENANT = IcariaEntityTypes.register("soldier_revenant", Builder.of(SoldierRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F));
	public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION = IcariaEntityTypes.register("scorpion", Builder.of(ScorpionEntity::new, MobCategory.MONSTER).sized(1.49F, 0.99F));
	public static final RegistryObject<EntityType<SlugEntity>> CRYSTAL_SLUG = IcariaEntityTypes.register("crystal_slug", Builder.of(SlugEntity::new, MobCategory.CREATURE).sized(1.249F, 0.749F));
	public static final RegistryObject<EntityType<SnullEntity>> FOREST_SNULL = IcariaEntityTypes.register("forest_snull", Builder.of(SnullEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<SnullEntity>> SNULL = IcariaEntityTypes.register("snull", Builder.of(SnullEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F));
	public static final RegistryObject<EntityType<SolifugaeEntity>> SOLIFUGAE = IcariaEntityTypes.register("solifugae", Builder.of(SolifugaeEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F));
	public static final RegistryObject<EntityType<SowEntity>> SOW = IcariaEntityTypes.register("sow", Builder.of(SowEntity::new, MobCategory.CREATURE).sized(0.99F, 0.99F));
	public static final RegistryObject<EntityType<AntiGravitySpellEntity>> ANTI_GRAVITY_SPELL = IcariaEntityTypes.register("anti_gravity_spell", Builder.of(AntiGravitySpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<FortifyingSpellEntity>> FORTIFYING_SPELL = IcariaEntityTypes.register("fortifying_spell", Builder.of(FortifyingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<HealingSpellEntity>> HEALING_SPELL = IcariaEntityTypes.register("healing_spell", Builder.of(HealingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<BubbleSpellEntity>> BUBBLE_SPELL = IcariaEntityTypes.register("bubble_spell", Builder.of(BubbleSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<FreezingSpellEntity>> FREEZING_SPELL = IcariaEntityTypes.register("freezing_spell", Builder.of(FreezingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<MagicMissileSpellEntity>> MAGIC_MISSILE_SPELL = IcariaEntityTypes.register("magic_missile_spell", Builder.of(MagicMissileSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<VinegarEntity>> VINEGAR = IcariaEntityTypes.register("vinegar", Builder.<VinegarEntity>of(VinegarEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final RegistryObject<EntityType<VinegaroonEntity>> VINEGAROON = IcariaEntityTypes.register("vinegaroon", Builder.of(VinegaroonEntity::new, MobCategory.MONSTER).sized(1.49F, 0.749F));

	public static <T extends Entity> RegistryObject<EntityType<T>> register(String pName, Builder<T> pBuilder) {
		return IcariaEntityTypes.ENTITY_TYPES.register(pName, () -> pBuilder.build(IcariaInfo.ID + ":" + pName));
	}
}
