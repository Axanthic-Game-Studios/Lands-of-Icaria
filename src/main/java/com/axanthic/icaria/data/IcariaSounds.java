package com.axanthic.icaria.data;

import com.axanthic.icaria.common.registry.IcariaIdents;
import com.axanthic.icaria.common.registry.IcariaSoundEvents;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class IcariaSounds extends SoundDefinitionsProvider {
	public IcariaSounds(PackOutput pOutput, String pId, ExistingFileHelper pHelper) {
		super(pOutput, pId, pHelper);
	}

	@Override
	public void registerSounds() {
		this.register(IcariaSoundEvents.BARREL_BREAK, "block", "barrel", "break", 4);
		this.register(IcariaSoundEvents.GRINDER_GRIND, "block", "grinder", "grind", 31);
		this.register(IcariaSoundEvents.KETTLE_CONCOCT, "block", "kettle", "concoct", 4);
		this.register(IcariaSoundEvents.KETTLE_CONSUME, SoundEvents.VILLAGER_WORK_LEATHERWORKER, "kettle", "consume");
		this.register(IcariaSoundEvents.KETTLE_POP, SoundEvents.ITEM_PICKUP, "kettle", "pop");
		this.register(IcariaSoundEvents.VASE_BREAK, "block", "vase", "break", 4);
		this.register(IcariaSoundEvents.AETERNAE_AMBIENT, SoundEvents.COW_AMBIENT, "aeternae", "ambient");
		this.register(IcariaSoundEvents.AETERNAE_DEATH, SoundEvents.COW_DEATH, "aeternae", "death");
		this.register(IcariaSoundEvents.AETERNAE_HURT, SoundEvents.COW_HURT, "aeternae", "hurt");
		this.register(IcariaSoundEvents.AETERNAE_STEP, SoundEvents.COW_STEP, "aeternae", "step");
		this.register(IcariaSoundEvents.ARACHNE_AMBIENT, SoundEvents.SPIDER_AMBIENT, "arachne", "ambient");
		this.register(IcariaSoundEvents.ARACHNE_DEATH, SoundEvents.SPIDER_DEATH, "arachne", "death");
		this.register(IcariaSoundEvents.ARACHNE_HURT, SoundEvents.SPIDER_HURT, "arachne", "hurt");
		this.register(IcariaSoundEvents.ARACHNE_STEP, SoundEvents.SPIDER_STEP, "arachne", "step");
		this.register(IcariaSoundEvents.ARACHNE_DRONE_AMBIENT, SoundEvents.SPIDER_AMBIENT, "arachne_drone", "ambient");
		this.register(IcariaSoundEvents.ARACHNE_DRONE_DEATH, SoundEvents.SPIDER_DEATH, "arachne_drone", "death");
		this.register(IcariaSoundEvents.ARACHNE_DRONE_HURT, SoundEvents.SPIDER_HURT, "arachne_drone", "hurt");
		this.register(IcariaSoundEvents.ARACHNE_DRONE_STEP, SoundEvents.SPIDER_STEP, "arachne_drone", "step");
		this.register(IcariaSoundEvents.ARGAN_HOUND_AMBIENT, SoundEvents.WOLF_AMBIENT, "argan_hound", "ambient");
		this.register(IcariaSoundEvents.ARGAN_HOUND_DEATH, SoundEvents.WOLF_DEATH, "argan_hound", "death");
		this.register(IcariaSoundEvents.ARGAN_HOUND_HURT, SoundEvents.WOLF_HURT, "argan_hound", "hurt");
		this.register(IcariaSoundEvents.ARGAN_HOUND_STEP, SoundEvents.WOLF_STEP, "argan_hound", "step");
		this.register(IcariaSoundEvents.CAPELLA_AMBIENT, SoundEvents.GOAT_AMBIENT, "capella", "ambient");
		this.register(IcariaSoundEvents.CAPELLA_DEATH, SoundEvents.GOAT_DEATH, "capella", "death");
		this.register(IcariaSoundEvents.CAPELLA_HURT, SoundEvents.GOAT_HURT, "capella", "hurt");
		this.register(IcariaSoundEvents.CAPELLA_STEP, SoundEvents.GOAT_STEP, "capella", "step");
		this.register(IcariaSoundEvents.CATOBLEPAS_AMBIENT, SoundEvents.COW_AMBIENT, "catoblepas", "ambient");
		this.register(IcariaSoundEvents.CATOBLEPAS_DEATH, SoundEvents.COW_DEATH, "catoblepas", "death");
		this.register(IcariaSoundEvents.CATOBLEPAS_HURT, SoundEvents.COW_HURT, "catoblepas", "hurt");
		this.register(IcariaSoundEvents.CATOBLEPAS_MILK, SoundEvents.COW_MILK, "catoblepas", "milk");
		this.register(IcariaSoundEvents.CATOBLEPAS_STEP, SoundEvents.COW_STEP, "catoblepas", "step");
		this.register(IcariaSoundEvents.CERVER_AMBIENT, SoundEvents.CAT_AMBIENT, "cerver", "ambient");
		this.register(IcariaSoundEvents.CERVER_DEATH, SoundEvents.CAT_DEATH, "cerver", "death");
		this.register(IcariaSoundEvents.CERVER_HURT, SoundEvents.CAT_HURT, "cerver", "hurt");
		this.register(IcariaSoundEvents.CROCOTTA_AMBIENT, "entity", "crocotta", "ambient", 6);
		this.register(IcariaSoundEvents.CROCOTTA_DEATH, "entity", "crocotta", "death", 3);
		this.register(IcariaSoundEvents.CROCOTTA_HURT, "entity", "crocotta", "hurt", 3);
		this.register(IcariaSoundEvents.CROCOTTA_STEP, SoundEvents.WOLF_STEP, "crocotta", "step");
		this.register(IcariaSoundEvents.FOREST_HAG_AMBIENT, SoundEvents.ENDERMAN_AMBIENT, "forest_hag", "ambient");
		this.register(IcariaSoundEvents.FOREST_HAG_DEATH, SoundEvents.ENDERMAN_DEATH, "forest_hag", "death");
		this.register(IcariaSoundEvents.FOREST_HAG_HURT, SoundEvents.ENDERMAN_HURT, "forest_hag", "hurt");
		this.register(IcariaSoundEvents.FOREST_HAG_SCREAM, SoundEvents.ENDERMAN_SCREAM, "forest_hag", "scream");
		this.register(IcariaSoundEvents.FOREST_HAG_TARGET, SoundEvents.ENDERMAN_STARE, "forest_hag", "target");
		this.register(IcariaSoundEvents.HYLIASTER_DEATH, SoundEvents.SLIME_DEATH, "hyliaster", "death");
		this.register(IcariaSoundEvents.HYLIASTER_HURT, SoundEvents.SLIME_HURT, "hyliaster", "hurt");
		this.register(IcariaSoundEvents.HYLIASTER_SQUISH, SoundEvents.SLIME_SQUISH, "hyliaster", "squish");
		this.register(IcariaSoundEvents.JELLYFISH_AMBIENT, SoundEvents.SQUID_AMBIENT, "jellyfish", "ambient");
		this.register(IcariaSoundEvents.JELLYFISH_DEATH, SoundEvents.SQUID_DEATH, "jellyfish", "death");
		this.register(IcariaSoundEvents.JELLYFISH_HURT, SoundEvents.SQUID_HURT, "jellyfish", "hurt");
		this.register(IcariaSoundEvents.MYRMEKE_DRONE_AMBIENT, SoundEvents.SPIDER_AMBIENT, "myrmeke_drone", "ambient");
		this.register(IcariaSoundEvents.MYRMEKE_DRONE_DEATH, SoundEvents.SPIDER_DEATH, "myrmeke_drone", "death");
		this.register(IcariaSoundEvents.MYRMEKE_DRONE_HURT, SoundEvents.SPIDER_HURT, "myrmeke_drone", "hurt");
		this.register(IcariaSoundEvents.MYRMEKE_DRONE_STEP, SoundEvents.SPIDER_STEP, "myrmeke_drone", "step");
		this.register(IcariaSoundEvents.MYRMEKE_SOLDIER_AMBIENT, SoundEvents.SPIDER_AMBIENT, "myrmeke_soldier", "ambient");
		this.register(IcariaSoundEvents.MYRMEKE_SOLDIER_DEATH, SoundEvents.SPIDER_DEATH, "myrmeke_soldier", "death");
		this.register(IcariaSoundEvents.MYRMEKE_SOLDIER_HURT, SoundEvents.SPIDER_HURT, "myrmeke_soldier", "hurt");
		this.register(IcariaSoundEvents.MYRMEKE_SOLDIER_STEP, SoundEvents.SPIDER_STEP, "myrmeke_soldier", "step");
		this.register(IcariaSoundEvents.MYRMEKE_QUEEN_AMBIENT, SoundEvents.SPIDER_AMBIENT, "myrmeke_queen", "ambient");
		this.register(IcariaSoundEvents.MYRMEKE_QUEEN_DEATH, SoundEvents.SPIDER_DEATH, "myrmeke_queen", "death");
		this.register(IcariaSoundEvents.MYRMEKE_QUEEN_HURT, SoundEvents.SPIDER_HURT, "myrmeke_queen", "hurt");
		this.register(IcariaSoundEvents.MYRMEKE_QUEEN_STEP, SoundEvents.SPIDER_STEP, "myrmeke_queen", "step");
		this.register(IcariaSoundEvents.REVENANT_AMBIENT, "entity", "revenant", "ambient", 3);
		this.register(IcariaSoundEvents.REVENANT_DEATH, "entity", "revenant", "death", 1);
		this.register(IcariaSoundEvents.REVENANT_HURT, "entity", "revenant", "hurt", 3);
		this.register(IcariaSoundEvents.REVENANT_STEP, SoundEvents.SKELETON_STEP, "revenant", "step");
		this.register(IcariaSoundEvents.CAPTAIN_REVENANT_DEATH, "entity", "captain_revenant", "death", 1);
		this.register(IcariaSoundEvents.CAPTAIN_REVENANT_HURT, "entity", "captain_revenant", "hurt", 3);
		this.register(IcariaSoundEvents.CAPTAIN_REVENANT_RALLY, "entity", "captain_revenant", "rally", 1);
		this.register(IcariaSoundEvents.CAPTAIN_REVENANT_STEP, "entity", "captain_revenant", "step", 4);
		this.register(IcariaSoundEvents.NETHER_PYROMANCER_REVENANT_AMBIENT, "entity", "nether_pyromancer_revenant", "ambient", 3);
		this.register(IcariaSoundEvents.SOLDIER_REVENANT_DEATH, "entity", "soldier_revenant", "death", 1);
		this.register(IcariaSoundEvents.SOLDIER_REVENANT_HURT, "entity", "soldier_revenant", "hurt", 3);
		this.register(IcariaSoundEvents.SOLDIER_REVENANT_STEP, "entity", "soldier_revenant", "step", 4);
		this.register(IcariaSoundEvents.SCORPION_AMBIENT, "entity", "scorpion", "ambient", 4);
		this.register(IcariaSoundEvents.SCORPION_DEATH, "entity", "scorpion", "death", 1);
		this.register(IcariaSoundEvents.SCORPION_HURT, "entity", "scorpion", "hurt", 3);
		this.register(IcariaSoundEvents.SCORPION_STEP, SoundEvents.SPIDER_STEP, "scorpion", "step");
		this.register(IcariaSoundEvents.SLUG_AMBIENT, SoundEvents.SLIME_SQUISH, "slug", "ambient");
		this.register(IcariaSoundEvents.SLUG_DEATH, SoundEvents.SLIME_DEATH, "slug", "death");
		this.register(IcariaSoundEvents.SLUG_HURT, SoundEvents.SLIME_HURT, "slug", "hurt");
		this.register(IcariaSoundEvents.SNULL_AMBIENT, SoundEvents.SLIME_SQUISH, "snull", "ambient");
		this.register(IcariaSoundEvents.SNULL_DEATH, SoundEvents.SLIME_DEATH, "snull", "death");
		this.register(IcariaSoundEvents.SNULL_HURT, SoundEvents.SLIME_HURT, "snull", "hurt");
		this.register(IcariaSoundEvents.SOLIFUGAE_AMBIENT, SoundEvents.SPIDER_AMBIENT, "solifugae", "ambient");
		this.register(IcariaSoundEvents.SOLIFUGAE_DEATH, SoundEvents.SPIDER_DEATH, "solifugae", "death");
		this.register(IcariaSoundEvents.SOLIFUGAE_HURT, SoundEvents.SPIDER_HURT, "solifugae", "hurt");
		this.register(IcariaSoundEvents.SOLIFUGAE_STEP, SoundEvents.SPIDER_STEP, "solifugae", "step");
		this.register(IcariaSoundEvents.SOW_AMBIENT, SoundEvents.PIG_AMBIENT, "sow", "ambient");
		this.register(IcariaSoundEvents.SOW_DEATH, SoundEvents.PIG_DEATH, "sow", "death");
		this.register(IcariaSoundEvents.SOW_HURT, SoundEvents.PIG_HURT, "sow", "hurt");
		this.register(IcariaSoundEvents.SOW_STEP, SoundEvents.PIG_STEP, "sow", "step");
		this.register(IcariaSoundEvents.VINEGAROON_AMBIENT, "entity", "vinegaroon", "ambient", 4);
		this.register(IcariaSoundEvents.VINEGAROON_DEATH, "entity", "vinegaroon", "death", 1);
		this.register(IcariaSoundEvents.VINEGAROON_HURT, "entity", "vinegaroon", "hurt", 3);
		this.register(IcariaSoundEvents.VINEGAROON_SHOOT, SoundEvents.ARROW_SHOOT, "vinegaroon", "shoot");
		this.register(IcariaSoundEvents.VINEGAROON_STEP, SoundEvents.SPIDER_STEP, "vinegaroon", "step");
		this.register(IcariaSoundEvents.LAUREL_WREATH_EQUIP, SoundEvents.ARMOR_EQUIP_GENERIC, "laurel_wreath", "equip");
		this.register(IcariaSoundEvents.AETERNAE_HIDE_ARMOR_EQUIP, SoundEvents.ARMOR_EQUIP_LEATHER, "aeternae_hide_armor", "equip");
		this.register(IcariaSoundEvents.CHALKOS_ARMOR_EQUIP, SoundEvents.ARMOR_EQUIP_IRON, "chalkos_armor", "equip");
		this.register(IcariaSoundEvents.KASSITEROS_ARMOR_EQUIP, SoundEvents.ARMOR_EQUIP_IRON, "kassiteros_armor", "equip");
		this.register(IcariaSoundEvents.ORICHALCUM_ARMOR_EQUIP, SoundEvents.ARMOR_EQUIP_GOLD, "orichalcum_armor", "equip");
		this.register(IcariaSoundEvents.VANADIUMSTEEL_ARMOR_EQUIP, SoundEvents.ARMOR_EQUIP_CHAIN, "vanadiumsteel_armor", "equip");
		this.register(IcariaSoundEvents.BIDENT_HIT, SoundEvents.TRIDENT_HIT, "bident", "hit");
		this.register(IcariaSoundEvents.BIDENT_HIT_GROUND, SoundEvents.TRIDENT_HIT_GROUND, "bident", "hit_ground");
		this.register(IcariaSoundEvents.BIDENT_THROW, SoundEvents.TRIDENT_THROW, "bident", "throw");
		this.register(IcariaSoundEvents.CALCITE_FERTILIZE, SoundEvents.HOE_TILL, "calcite", "fertilize");
		this.register(IcariaSoundEvents.CHEST_LABEL_APPLY, SoundEvents.AXE_STRIP, "chest_label", "apply");
		this.register(IcariaSoundEvents.CHEST_LABEL_CLEAR, SoundEvents.AXE_STRIP, "chest_label", "clear");
		this.register(IcariaSoundEvents.CHEST_LABEL_RESET, SoundEvents.VILLAGER_WORK_CARTOGRAPHER, "chest_label", "reset");
		this.register(IcariaSoundEvents.GREEK_FIRE_GRENADE_THROW, SoundEvents.WITCH_THROW, "greek_fire_grenade", "throw");
		this.register(IcariaSoundEvents.OLIVES_POP, SoundEvents.CAVE_VINES_PICK_BERRIES, "olives", "pop");
		this.register(IcariaSoundEvents.SPELL_SHOOT, SoundEvents.ARROW_SHOOT, "spell", "shoot");
		this.register(IcariaSoundEvents.BUBBLE_SPELL_POP, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, "bubble_spell", "pop");
		this.register(IcariaSoundEvents.BUBBLE_SPELL_SHOOT, "item", "bubble_spell", "shoot", 3);
		this.register(IcariaSoundEvents.VIAL_EMPTY, SoundEvents.BOTTLE_EMPTY, "vial", "empty");
		this.register(IcariaSoundEvents.VIAL_FILL, SoundEvents.BOTTLE_FILL, "vial", "fill");
	}

	public void register(SoundEvent pEvent, String pCategory, String pObject, String pAction, int pSounds) {
		var definition = SoundDefinition.definition();
		for (int i = 0; i < pSounds; i++) {
			definition.with(SoundDefinition.Sound.sound(ResourceLocation.fromNamespaceAndPath(IcariaIdents.ID, pCategory + "/" + pObject + "/" + pAction + "_" + (i < 10 ? "0" : "") + i), SoundDefinition.SoundType.SOUND));
		}

		this.add(pEvent, definition.subtitle("subtitle" + "." + IcariaIdents.ID + "." + pObject + "." + pAction));
	}

	public void register(SoundEvent pNew, SoundEvent pOld, String pObject, String pAction) {
		this.add(pNew, SoundDefinition.definition().with(SoundDefinition.Sound.sound(pOld.getLocation(), SoundDefinition.SoundType.EVENT)).subtitle("subtitle" + "." + IcariaIdents.ID + "." + pObject + "." + pAction));
	}

	public void register(SoundEvent pNew, Holder<SoundEvent> pOld, String pObject, String pAction) {
		this.add(pNew, SoundDefinition.definition().with(SoundDefinition.Sound.sound(pOld.value().getLocation(), SoundDefinition.SoundType.EVENT)).subtitle("subtitle" + "." + IcariaIdents.ID + "." + pObject + "." + pAction));
	}
}
