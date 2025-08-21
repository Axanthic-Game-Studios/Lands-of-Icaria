package com.axanthic.icaria.common.registry;

import com.axanthic.icaria.common.entity.*;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaEntityTypes {
	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(Registries.ENTITY_TYPE, IcariaIdents.ID);

	public static final DeferredHolder<EntityType<?>, EntityType<AeternaeEntity>> AETERNAE = IcariaEntityTypes.register("aeternae", EntityType.Builder.of(AeternaeEntity::new, MobCategory.CREATURE).sized(0.99F, 1.49F).eyeHeight(1.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<ArachneEntity>> ARACHNE = IcariaEntityTypes.register("arachne", EntityType.Builder.of(ArachneEntity::new, MobCategory.MONSTER).sized(1.49F, 1.99F).eyeHeight(1.99F));
	public static final DeferredHolder<EntityType<?>, EntityType<ArachneDroneEntity>> ARACHNE_DRONE = IcariaEntityTypes.register("arachne_drone", EntityType.Builder.of(ArachneDroneEntity::new, MobCategory.MONSTER).sized(0.99F, 0.749F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<ArganHoundEntity>> ARGAN_HOUND = IcariaEntityTypes.register("argan_hound", EntityType.Builder.of(ArganHoundEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.749F));
	public static final DeferredHolder<EntityType<?>, EntityType<IcariaBarrelEntity>> BARREL = IcariaEntityTypes.register("barrel", EntityType.Builder.<IcariaBarrelEntity>of(IcariaBarrelEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<BidentEntity>> BIDENT = IcariaEntityTypes.register("bident", EntityType.Builder.<BidentEntity>of(BidentEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<CapellaEntity>> CAPELLA = IcariaEntityTypes.register("capella", EntityType.Builder.of(CapellaEntity::new, MobCategory.CREATURE).sized(0.749F, 0.99F).eyeHeight(0.749F));
	public static final DeferredHolder<EntityType<?>, EntityType<CatoblepasEntity>> CATOBLEPAS = IcariaEntityTypes.register("catoblepas", EntityType.Builder.of(CatoblepasEntity::new, MobCategory.CREATURE).sized(0.99F, 1.249F).eyeHeight(1.249F));
	public static final DeferredHolder<EntityType<?>, EntityType<CerverEntity>> CERVER = IcariaEntityTypes.register("cerver", EntityType.Builder.of(CerverEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.749F));
	public static final DeferredHolder<EntityType<?>, EntityType<CrocottaEntity>> CROCOTTA = IcariaEntityTypes.register("crocotta", EntityType.Builder.of(CrocottaEntity::new, MobCategory.MONSTER).sized(0.99F, 1.249F).eyeHeight(0.99F));
	public static final DeferredHolder<EntityType<?>, EntityType<FloatingBlockEntity>> FLOATING_BLOCK = IcariaEntityTypes.register("floating_block", EntityType.Builder.<FloatingBlockEntity>of(FloatingBlockEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<GreekFireGrenadeEntity>> GREEK_FIRE_GRENADE = IcariaEntityTypes.register("greek_fire_grenade", EntityType.Builder.<GreekFireGrenadeEntity>of(GreekFireGrenadeEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<ForestHagEntity>> CYPRESS_FOREST_HAG = IcariaEntityTypes.register("cypress_forest_hag", EntityType.Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.749F).eyeHeight(2.3749F));
	public static final DeferredHolder<EntityType<?>, EntityType<ForestHagEntity>> DROUGHTROOT_FOREST_HAG = IcariaEntityTypes.register("droughtroot_forest_hag", EntityType.Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final DeferredHolder<EntityType<?>, EntityType<ForestHagEntity>> FIR_FOREST_HAG = IcariaEntityTypes.register("fir_forest_hag", EntityType.Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final DeferredHolder<EntityType<?>, EntityType<ForestHagEntity>> LAUREL_FOREST_HAG = IcariaEntityTypes.register("laurel_forest_hag", EntityType.Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final DeferredHolder<EntityType<?>, EntityType<ForestHagEntity>> OLIVE_FOREST_HAG = IcariaEntityTypes.register("olive_forest_hag", EntityType.Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final DeferredHolder<EntityType<?>, EntityType<ForestHagEntity>> PLANE_FOREST_HAG = IcariaEntityTypes.register("plane_forest_hag", EntityType.Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final DeferredHolder<EntityType<?>, EntityType<ForestHagEntity>> POPULUS_FOREST_HAG = IcariaEntityTypes.register("populus_forest_hag", EntityType.Builder.of(ForestHagEntity::new, MobCategory.MONSTER).sized(0.99F, 2.49F).eyeHeight(2.1249F));
	public static final DeferredHolder<EntityType<?>, EntityType<HyliasterEntity>> HYLIASTER = IcariaEntityTypes.register("hyliaster", EntityType.Builder.of(HyliasterEntity::new, MobCategory.MONSTER).sized(0.749F, 0.749F).eyeHeight(0.3749F));
	public static final DeferredHolder<EntityType<?>, EntityType<EnderJellyfishEntity>> ENDER_JELLYFISH = IcariaEntityTypes.register("ender_jellyfish", EntityType.Builder.of(EnderJellyfishEntity::new, MobCategory.AMBIENT).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<FireJellyfishEntity>> FIRE_JELLYFISH = IcariaEntityTypes.register("fire_jellyfish", EntityType.Builder.of(FireJellyfishEntity::new, MobCategory.AMBIENT).fireImmune().sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<NatureJellyfishEntity>> NATURE_JELLYFISH = IcariaEntityTypes.register("nature_jellyfish", EntityType.Builder.of(NatureJellyfishEntity::new, MobCategory.AMBIENT).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<VoidJellyfishEntity>> VOID_JELLYFISH = IcariaEntityTypes.register("void_jellyfish", EntityType.Builder.of(VoidJellyfishEntity::new, MobCategory.AMBIENT).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<WaterJellyfishEntity>> WATER_JELLYFISH = IcariaEntityTypes.register("water_jellyfish", EntityType.Builder.of(WaterJellyfishEntity::new, MobCategory.AMBIENT).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<LootVaseEntity>> LOOT_VASE = IcariaEntityTypes.register("loot_vase", EntityType.Builder.<LootVaseEntity>of(LootVaseEntity::new, MobCategory.MISC).sized(0.99F, 0.99F).clientTrackingRange(10).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<MyrmekeDroneEntity>> MYRMEKE_DRONE = IcariaEntityTypes.register("myrmeke_drone", EntityType.Builder.of(MyrmekeDroneEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F).eyeHeight(0.249F));
	public static final DeferredHolder<EntityType<?>, EntityType<MyrmekeSoldierEntity>> MYRMEKE_SOLDIER = IcariaEntityTypes.register("myrmeke_soldier", EntityType.Builder.of(MyrmekeSoldierEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F).eyeHeight(0.249F));
	public static final DeferredHolder<EntityType<?>, EntityType<MyrmekeQueenEntity>> MYRMEKE_QUEEN = IcariaEntityTypes.register("myrmeke_queen", EntityType.Builder.of(MyrmekeQueenEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F).eyeHeight(0.249F));
	public static final DeferredHolder<EntityType<?>, EntityType<IcariaPaintingEntity>> PAINTING = IcariaEntityTypes.register("painting", EntityType.Builder.<IcariaPaintingEntity>of(IcariaPaintingEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<CaptainRevenantEntity>> CAPTAIN_REVENANT = IcariaEntityTypes.register("captain_revenant", EntityType.Builder.of(CaptainRevenantEntity::new, MobCategory.MONSTER).sized(0.49F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final DeferredHolder<EntityType<?>, EntityType<CivilianRevenantEntity>> CIVILIAN_REVENANT = IcariaEntityTypes.register("civilian_revenant", EntityType.Builder.of(CivilianRevenantEntity::new, MobCategory.MONSTER).sized(0.49F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final DeferredHolder<EntityType<?>, EntityType<CrawlerRevenantEntity>> CRAWLER_REVENANT = IcariaEntityTypes.register("crawler_revenant", EntityType.Builder.of(CrawlerRevenantEntity::new, MobCategory.MONSTER).sized(0.49F, 0.749F).eyeHeight(0.3749F).fireImmune());
	public static final DeferredHolder<EntityType<?>, EntityType<OvergrownRevenantEntity>> OVERGROWN_REVENANT = IcariaEntityTypes.register("overgrown_revenant", EntityType.Builder.of(OvergrownRevenantEntity::new, MobCategory.MONSTER).sized(0.49F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final DeferredHolder<EntityType<?>, EntityType<PyromancerRevenantEntity>> PYROMANCER_REVENANT = IcariaEntityTypes.register("pyromancer_revenant", EntityType.Builder.of(PyromancerRevenantEntity::new, MobCategory.MONSTER).sized(0.49F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final DeferredHolder<EntityType<?>, EntityType<NetherPyromancerRevenantEntity>> NETHER_PYROMANCER_REVENANT = IcariaEntityTypes.register("nether_pyromancer_revenant", EntityType.Builder.of(NetherPyromancerRevenantEntity::new, MobCategory.MONSTER).sized(0.49F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final DeferredHolder<EntityType<?>, EntityType<SoldierRevenantEntity>> SOLDIER_REVENANT = IcariaEntityTypes.register("soldier_revenant", EntityType.Builder.of(SoldierRevenantEntity::new, MobCategory.MONSTER).sized(0.49F, 1.99F).eyeHeight(1.749F).fireImmune());
	public static final DeferredHolder<EntityType<?>, EntityType<RugEntity>> RUG = IcariaEntityTypes.register("rug", EntityType.Builder.<RugEntity>of(RugEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<ScorpionEntity>> SCORPION = IcariaEntityTypes.register("scorpion", EntityType.Builder.of(ScorpionEntity::new, MobCategory.MONSTER).sized(1.49F, 0.99F).eyeHeight(0.749F));
	public static final DeferredHolder<EntityType<?>, EntityType<SlugEntity>> CRYSTAL_SLUG = IcariaEntityTypes.register("crystal_slug", EntityType.Builder.of(SlugEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<SnullEntity>> FOREST_SNULL = IcariaEntityTypes.register("forest_snull", EntityType.Builder.of(SnullEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<SnullEntity>> SNULL = IcariaEntityTypes.register("snull", EntityType.Builder.of(SnullEntity::new, MobCategory.MONSTER).sized(0.99F, 0.99F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<SolifugaeEntity>> SOLIFUGAE = IcariaEntityTypes.register("solifugae", EntityType.Builder.of(SolifugaeEntity::new, MobCategory.MONSTER).sized(0.99F, 0.49F).eyeHeight(0.49F));
	public static final DeferredHolder<EntityType<?>, EntityType<AntiGravitySpellEntity>> ANTI_GRAVITY_SPELL = IcariaEntityTypes.register("anti_gravity_spell", EntityType.Builder.of(AntiGravitySpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<FortifyingSpellEntity>> FORTIFYING_SPELL = IcariaEntityTypes.register("fortifying_spell", EntityType.Builder.of(FortifyingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<HealingSpellEntity>> HEALING_SPELL = IcariaEntityTypes.register("healing_spell", EntityType.Builder.of(HealingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<BubbleSpellEntity>> BUBBLE_SPELL = IcariaEntityTypes.register("bubble_spell", EntityType.Builder.of(BubbleSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<FreezingSpellEntity>> FREEZING_SPELL = IcariaEntityTypes.register("freezing_spell", EntityType.Builder.of(FreezingSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<MagicMissileSpellEntity>> MAGIC_MISSILE_SPELL = IcariaEntityTypes.register("magic_missile_spell", EntityType.Builder.of(MagicMissileSpellEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<StoolEntity>> STOOL = IcariaEntityTypes.register("stool", EntityType.Builder.of(StoolEntity::new, MobCategory.MISC).sized(0.749F, 0.749F).eyeHeight(0.3749F).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<ThogEntity>> THOG = IcariaEntityTypes.register("thog", EntityType.Builder.of(ThogEntity::new, MobCategory.CREATURE).sized(0.749F, 0.99F).eyeHeight(0.749F));
	public static final DeferredHolder<EntityType<?>, EntityType<VinegarEntity>> VINEGAR = IcariaEntityTypes.register("vinegar", EntityType.Builder.<VinegarEntity>of(VinegarEntity::new, MobCategory.MISC).sized(0.49F, 0.49F).clientTrackingRange(4).updateInterval(20).noLootTable());
	public static final DeferredHolder<EntityType<?>, EntityType<VinegaroonEntity>> VINEGAROON = IcariaEntityTypes.register("vinegaroon", EntityType.Builder.of(VinegaroonEntity::new, MobCategory.MONSTER).sized(1.49F, 0.749F).eyeHeight(0.749F));

	public static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String pName, EntityType.Builder<T> pBuilder) {
		return IcariaEntityTypes.ENTITY_TYPES.register(pName, () -> pBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pName))));
	}
}
