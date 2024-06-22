package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.entity.*;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType.Builder;
import net.minecraft.world.entity.MobCategory;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@MethodsReturnNonnullByDefault

public class IcariaEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, IcariaInfo.ID);

	public static final Supplier<EntityType<AeternaeEntity>> AETERNAE = IcariaEntityTypes.register("aeternae", Builder.of(AeternaeEntity::new, MobCategory.CREATURE).sized(1.249F, 1.49F).eyeHeight(1.48F));
	public static final Supplier<EntityType<ArachneEntity>> ARACHNE = IcariaEntityTypes.register("arachne", Builder.of(ArachneEntity::new, MobCategory.MONSTER).sized(1.49F, 1.99F).eyeHeight(1.98F));
	public static final Supplier<EntityType<ArachneDroneEntity>> ARACHNE_DRONE = IcariaEntityTypes.register("arachne_drone", Builder.of(ArachneDroneEntity::new, MobCategory.MONSTER).sized(0.749F, 0.49F).eyeHeight(0.48F));
	public static final Supplier<EntityType<ArganHoundEntity>> ARGAN_HOUND = IcariaEntityTypes.register("argan_hound", Builder.of(ArganHoundEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.749F));
	public static final Supplier<EntityType<IcariaBarrelEntity>> BARREL = IcariaEntityTypes.register("barrel", Builder.<IcariaBarrelEntity>of(IcariaBarrelEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20));
	public static final Supplier<EntityType<BidentEntity>> BIDENT = IcariaEntityTypes.register("bident", Builder.<BidentEntity>of(BidentEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<CatoblepasEntity>> CATOBLEPAS = IcariaEntityTypes.register("catoblepas", Builder.of(CatoblepasEntity::new, MobCategory.CREATURE).sized(1.249F, 1.249F).eyeHeight(1.248F));
	public static final Supplier<EntityType<CerverEntity>> CERVER = IcariaEntityTypes.register("cerver", Builder.of(CerverEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.749F));
	public static final Supplier<EntityType<FloatingBlockEntity>> FLOATING_BLOCK = IcariaEntityTypes.register("floating_block", Builder.<FloatingBlockEntity>of(FloatingBlockEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20));
	public static final Supplier<EntityType<GreekFireGrenadeEntity>> GREEK_FIRE_GRENADE = IcariaEntityTypes.register("greek_fire_grenade", Builder.<GreekFireGrenadeEntity>of(GreekFireGrenadeEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<ForestHagEntity>> CYPRESS_FOREST_HAG = IcariaEntityTypes.register("cypress_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.749F).eyeHeight(2.3749F));
	public static final Supplier<EntityType<ForestHagEntity>> DROUGHTROOT_FOREST_HAG = IcariaEntityTypes.register("droughtroot_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final Supplier<EntityType<ForestHagEntity>> FIR_FOREST_HAG = IcariaEntityTypes.register("fir_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final Supplier<EntityType<ForestHagEntity>> LAUREL_FOREST_HAG = IcariaEntityTypes.register("laurel_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final Supplier<EntityType<ForestHagEntity>> OLIVE_FOREST_HAG = IcariaEntityTypes.register("olive_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.12749F));
	public static final Supplier<EntityType<ForestHagEntity>> PLANE_FOREST_HAG = IcariaEntityTypes.register("plane_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.12749F));
	public static final Supplier<EntityType<ForestHagEntity>> POPULUS_FOREST_HAG = IcariaEntityTypes.register("populus_forest_hag", Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.12749F));
	public static final Supplier<EntityType<HyliasterEntity>> HYLIASTER = IcariaEntityTypes.register("hyliaster", Builder.of(HyliasterEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final Supplier<EntityType<JellyfishEntity>> ENDER_JELLYFISH = IcariaEntityTypes.register("ender_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.AMBIENT).sized(0.749F, 0.749F).eyeHeight(0.49F));
	public static final Supplier<EntityType<JellyfishEntity>> FIRE_JELLYFISH = IcariaEntityTypes.register("fire_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.AMBIENT).fireImmune().sized(0.749F, 0.749F).eyeHeight(0.49F));
	public static final Supplier<EntityType<JellyfishEntity>> NATURE_JELLYFISH = IcariaEntityTypes.register("nature_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.AMBIENT).sized(0.749F, 0.749F).eyeHeight(0.49F));
	public static final Supplier<EntityType<JellyfishEntity>> VOID_JELLYFISH = IcariaEntityTypes.register("void_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.AMBIENT).sized(0.749F, 0.749F).eyeHeight(0.49F));
	public static final Supplier<EntityType<JellyfishEntity>> WATER_JELLYFISH = IcariaEntityTypes.register("water_jellyfish", Builder.of(JellyfishEntity::new, MobCategory.AMBIENT).sized(0.749F, 0.749F).eyeHeight(0.49F));
	public static final Supplier<EntityType<LootVaseEntity>> LOOT_VASE = IcariaEntityTypes.register("loot_vase", Builder.<LootVaseEntity>of(LootVaseEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20));
	public static final Supplier<EntityType<MyrmekeDroneEntity>> MYRMEKE_DRONE = IcariaEntityTypes.register("myrmeke_drone", Builder.of(MyrmekeDroneEntity::new, MobCategory.MONSTER).sized(0.749F, 0.49F).eyeHeight(0.249F));
	public static final Supplier<EntityType<MyrmekeSoldierEntity>> MYRMEKE_SOLDIER = IcariaEntityTypes.register("myrmeke_soldier", Builder.of(MyrmekeSoldierEntity::new, MobCategory.MONSTER).sized(0.749F, 0.49F).eyeHeight(0.249F));
	public static final Supplier<EntityType<MyrmekeQueenEntity>> MYRMEKE_QUEEN = IcariaEntityTypes.register("myrmeke_queen", Builder.of(MyrmekeQueenEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F).eyeHeight(0.249F));
	public static final Supplier<EntityType<CaptainRevenantEntity>> CAPTAIN_REVENANT = IcariaEntityTypes.register("captain_revenant", Builder.of(CaptainRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final Supplier<EntityType<CivilianRevenantEntity>> CIVILIAN_REVENANT = IcariaEntityTypes.register("civilian_revenant", Builder.of(CivilianRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final Supplier<EntityType<CrawlerRevenantEntity>> CRAWLER_REVENANT = IcariaEntityTypes.register("crawler_revenant", Builder.of(CrawlerRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 0.749F).eyeHeight(0.3749F).fireImmune());
	public static final Supplier<EntityType<OvergrownRevenantEntity>> OVERGROWN_REVENANT = IcariaEntityTypes.register("overgrown_revenant", Builder.of(OvergrownRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final Supplier<EntityType<PyromancerRevenantEntity>> PYROMANCER_REVENANT = IcariaEntityTypes.register("pyromancer_revenant", Builder.of(PyromancerRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final Supplier<EntityType<NetherPyromancerRevenantEntity>> NETHER_PYROMANCER_REVENANT = IcariaEntityTypes.register("nether_pyromancer_revenant", Builder.of(NetherPyromancerRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final Supplier<EntityType<SoldierRevenantEntity>> SOLDIER_REVENANT = IcariaEntityTypes.register("soldier_revenant", Builder.of(SoldierRevenantEntity::new, MobCategory.MONSTER).sized(0.749F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final Supplier<EntityType<ScorpionEntity>> SCORPION = IcariaEntityTypes.register("scorpion", Builder.of(ScorpionEntity::new, MobCategory.MONSTER).sized(1.49F, 0.99F).eyeHeight(0.6249F));
	public static final Supplier<EntityType<SlugEntity>> CRYSTAL_SLUG = IcariaEntityTypes.register("crystal_slug", Builder.of(SlugEntity::new, MobCategory.AMBIENT).sized(1.249F, 0.749F).eyeHeight(0.748F));
	public static final Supplier<EntityType<SnullEntity>> FOREST_SNULL = IcariaEntityTypes.register("forest_snull", Builder.of(SnullEntity::new, MobCategory.AMBIENT).sized(0.749F, 0.749F).eyeHeight(0.6249F));
	public static final Supplier<EntityType<SnullEntity>> SNULL = IcariaEntityTypes.register("snull", Builder.of(SnullEntity::new, MobCategory.AMBIENT).sized(0.749F, 0.749F).eyeHeight(0.6249F));
	public static final Supplier<EntityType<SolifugaeEntity>> SOLIFUGAE = IcariaEntityTypes.register("solifugae", Builder.of(SolifugaeEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F).eyeHeight(0.48F));
	public static final Supplier<EntityType<SowEntity>> SOW = IcariaEntityTypes.register("sow", Builder.of(SowEntity::new, MobCategory.CREATURE).sized(0.749F, 0.749F).eyeHeight(0.6249F));
	public static final Supplier<EntityType<AntiGravitySpellEntity>> ANTI_GRAVITY_SPELL = IcariaEntityTypes.register("anti_gravity_spell", Builder.of(AntiGravitySpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<FortifyingSpellEntity>> FORTIFYING_SPELL = IcariaEntityTypes.register("fortifying_spell", Builder.of(FortifyingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<HealingSpellEntity>> HEALING_SPELL = IcariaEntityTypes.register("healing_spell", Builder.of(HealingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<BubbleSpellEntity>> BUBBLE_SPELL = IcariaEntityTypes.register("bubble_spell", Builder.of(BubbleSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<FreezingSpellEntity>> FREEZING_SPELL = IcariaEntityTypes.register("freezing_spell", Builder.of(FreezingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<MagicMissileSpellEntity>> MAGIC_MISSILE_SPELL = IcariaEntityTypes.register("magic_missile_spell", Builder.of(MagicMissileSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<VinegarEntity>> VINEGAR = IcariaEntityTypes.register("vinegar", Builder.<VinegarEntity>of(VinegarEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20));
	public static final Supplier<EntityType<VinegaroonEntity>> VINEGAROON = IcariaEntityTypes.register("vinegaroon", Builder.of(VinegaroonEntity::new, MobCategory.MONSTER).sized(1.49F, 0.749F).eyeHeight(0.748F));

	public static <T extends Entity> Supplier<EntityType<T>> register(String pName, Builder<T> pBuilder) {
		return IcariaEntityTypes.ENTITY_TYPES.register(pName, () -> pBuilder.build(IcariaInfo.ID + ":" + pName));
	}
}
