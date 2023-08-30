package com.axanthic.icaria.data.lang;

import com.axanthic.icaria.common.registry.IcariaBlocks;
import com.axanthic.icaria.common.registry.IcariaMobEffects;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;
import com.axanthic.icaria.common.registry.IcariaItems;
import com.axanthic.icaria.common.util.IcariaInfo;

import net.minecraft.data.PackOutput;

import net.minecraftforge.common.data.LanguageProvider;

public class IcariaGerman extends LanguageProvider {
	public IcariaGerman(PackOutput pPackOutput, String pId, String pLanguage) {
		super(pPackOutput, pId, pLanguage);
	}

	@Override
	public void addTranslations() {
		// ADVANCEMENTS
		this.add("advancement" + "." + IcariaInfo.ID + "." + "root" + "." + "title", "Die Lands of Icaria");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "captain_revenant" + "." + "title", "War es nicht schon längst tot?");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "loot_vase" + "." + "title", "Gewicht stemmen");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "storage_vase" + "." + "title", "Größer als eine Kiste!");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "chert_pickaxe" + "." + "title", "Hornstein-Werkzeuge");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "chalkos_pickaxe" + "." + "title", "Kuffar-Werkzeuge");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "kiln" + "." + "title", "Ich habe es gerockt!");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "kassiteros_pickaxe" + "." + "title", "Galmei-Werkzeuge");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "forge" + "." + "title", "Hier gehts heiß her!");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "orichalcum_pickaxe" + "." + "title", "Goldmessing-Werkzeuge");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "grinder" + "." + "title", "Das war mühlsame Arbeit!");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "fertilizing" + "." + "title", "Wie Essen für Pflanzen!");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "salting" + "." + "title", "Total versalzen");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "vanadiumsteel_pickaxe" + "." + "title", "Vanadinstahl-Werkzeuge");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "kettle" + "." + "title", "Das ist keine Teekanne!");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "sideros_pickaxe" + "." + "title", "Schirbel-Werkzeuge");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "molybdenumsteel_pickaxe" + "." + "title", "Molybdänstahl-Werkzeuge");

		this.add("advancement" + "." + IcariaInfo.ID + "." + "root" + "." + "description", "Reise in die Lands of Icaria");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "captain_revenant" + "." + "description", "Töte einen Kommandanten-Wiedergänger");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "loot_vase" + "." + "description", "Trage eine Beutevase umher");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "storage_vase" + "." + "description", "Stelle eine Speichervase auf");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "chert_pickaxe" + "." + "description", "Stelle eine Hornsteinspitzhacke her");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "chalkos_pickaxe" + "." + "description", "Stelle eine Kuffarspitzhacke her");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "kiln" + "." + "description", "Stelle einen Töpferofen auf");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "kassiteros_pickaxe" + "." + "description", "Stelle eine Galmeispitzhacke her");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "forge" + "." + "description", "Stelle eine Schmelze auf");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "orichalcum_pickaxe" + "." + "description", "Stelle eine Goldmessingspitzhacke her");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "grinder" + "." + "description", "Stelle eine Mühle auf");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "fertilizing" + "." + "description", "Dünge Ackerboden mit Calcit");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "salting" + "." + "description", "Füge Essen Salz hinzu");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "vanadiumsteel_pickaxe" + "." + "description", "Stelle eine Vanadinstahlspitzhacke her");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "kettle" + "." + "description", "Stelle einen Kessel auf");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "sideros_pickaxe" + "." + "description", "Stelle eine Schirbelspitzhacke her");
		this.add("advancement" + "." + IcariaInfo.ID + "." + "molybdenumsteel_pickaxe" + "." + "description", "Stelle eine Molybdänstahlspitzhacke her");

		// BIOMES
		this.add("biome" + "." + IcariaInfo.ID + "." + "desert", "Ikarische Wüste");
		this.add("biome" + "." + IcariaInfo.ID + "." + "forest", "Ikarischer Wald");
		this.add("biome" + "." + IcariaInfo.ID + "." + "scrubland", "Ikarisches Buschland");
		this.add("biome" + "." + IcariaInfo.ID + "." + "steppe", "Ikarische Steppe");
		this.add("biome" + "." + IcariaInfo.ID + "." + "void", "Ikarische Leere");

		// BLOCKS
		this.add(IcariaBlocks.GRASSY_MARL.get(), "Begraster Mergel");
		this.add(IcariaBlocks.MARL.get(), "Mergel");
		this.add(IcariaBlocks.MARL_CHERT.get(), "Hornsteinerz");
		this.add(IcariaBlocks.SURFACE_CHERT.get(), "Hornsteingeröll");
		this.add(IcariaBlocks.MARL_BONES.get(), "Verrottete Knochen");
		this.add(IcariaBlocks.SURFACE_BONES.get(), "Knochenreste");
		this.add(IcariaBlocks.MARL_LIGNITE.get(), "Braunkohleerz");
		this.add(IcariaBlocks.SURFACE_LIGNITE.get(), "Braunkohlegeröll");
		this.add(IcariaBlocks.COARSE_MARL.get(), "Grober Mergel");
		this.add(IcariaBlocks.DRY_LAKE_BED.get(), "Trockenes Seebett");

		this.add(IcariaBlocks.FARMLAND.get(), "Ackerboden");
		this.add(IcariaBlocks.FERTILIZED_FARMLAND.get(), "Gedüngter Ackerboden");

		this.add(IcariaBlocks.MARL_ADOBE.get(), "Mergel-Lehm");
		this.add(IcariaBlocks.MARL_ADOBE_DECO.stairs.get(), "Mergel-Lehmtreppe");
		this.add(IcariaBlocks.MARL_ADOBE_DECO.slab.get(), "Mergel-Lehmstufe");
		this.add(IcariaBlocks.MARL_ADOBE_DECO.wall.get(), "Mergel-Lehmmauer");

		this.add(IcariaBlocks.LOAM.get(), "Lehm");
		this.add(IcariaBlocks.LOAM_BRICKS.get(), "Lehmziegel");
		this.add(IcariaBlocks.LOAM_BRICK_DECO.stairs.get(), "Lehmziegeltreppe");
		this.add(IcariaBlocks.LOAM_BRICK_DECO.slab.get(), "Lehmziegelstufe");
		this.add(IcariaBlocks.LOAM_BRICK_DECO.wall.get(), "Lehmziegelmauer");

		this.add(IcariaBlocks.DOLOMITE_ADOBE.get(), "Dolomit-Lehm");
		this.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.stairs.get(), "Dolomit-Lehmtreppe");
		this.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.slab.get(), "Dolomit-Lehmstufe");
		this.add(IcariaBlocks.DOLOMITE_ADOBE_DECO.wall.get(), "Dolomit-Lehmmauer");
		this.add(IcariaBlocks.SMOOTH_DOLOMITE.get(), "Glatter Dolomit");
		this.add(IcariaBlocks.SMOOTH_DOLOMITE_DECO.stairs.get(), "Glatte Dolomittreppe");
		this.add(IcariaBlocks.SMOOTH_DOLOMITE_DECO.slab.get(), "Glatte Dolomitstufe");
		this.add(IcariaBlocks.SMOOTH_DOLOMITE_DECO.wall.get(), "Glatte Dolomitmauer");
		this.add(IcariaBlocks.DOLOMITE_BRICKS.get(), "Dolomitziegel");
		this.add(IcariaBlocks.DOLOMITE_PILLAR.get(), "Dolomitsäule");
		this.add(IcariaBlocks.DOLOMITE_PILLAR_HEAD.get(), "Dolomitsäulenende");

		this.add(IcariaBlocks.GRAINEL.get(), "Schluffsand");
		this.add(IcariaBlocks.GRAINEL_CHERT.get(), "Hornsteinerz");
		this.add(IcariaBlocks.GRAINGLASS.get(), "Schluffglas");
		this.add(IcariaBlocks.GRAINGLASS_PANE.get(), "Schluffglasscheibe");
		this.add(IcariaBlocks.HORIZONTAL_GRAINGLASS_PANE.get(), "Horizontale Schluffglasscheibe");
		this.add(IcariaBlocks.GRAINITE_ADOBE.get(), "Schluffstein-Lehm");
		this.add(IcariaBlocks.GRAINITE_ADOBE_DECO.stairs.get(), "Schluffstein-Lehmtreppe");
		this.add(IcariaBlocks.GRAINITE_ADOBE_DECO.slab.get(), "Schluffstein-Lehmstufe");
		this.add(IcariaBlocks.GRAINITE_ADOBE_DECO.wall.get(), "Schluffstein-Lehmmauer");
		this.add(IcariaBlocks.GRAINITE.get(), "Schluffstein");
		this.add(IcariaBlocks.GRAINITE_DECO.stairs.get(), "Schluffsteintreppe");
		this.add(IcariaBlocks.GRAINITE_DECO.slab.get(), "Schluffsteinstufe");
		this.add(IcariaBlocks.GRAINITE_DECO.wall.get(), "Schluffsteinmauer");
		this.add(IcariaBlocks.GRAINITE_BRICKS.get(), "Schluffsteinziegel");
		this.add(IcariaBlocks.GRAINITE_BRICK_DECO.stairs.get(), "Schluffsteinziegeltreppe");
		this.add(IcariaBlocks.GRAINITE_BRICK_DECO.slab.get(), "Schluffsteinziegelstufe");
		this.add(IcariaBlocks.GRAINITE_BRICK_DECO.wall.get(), "Schluffsteinziegelmauer");
		this.add(IcariaBlocks.CHISELED_GRAINITE.get(), "Gemeißelter Schluffstein");
		this.add(IcariaBlocks.GRAINITE_RUBBLE.get(), "Schluffsteingeröll");

		this.add(IcariaBlocks.YELLOWSTONE_ADOBE.get(), "Gelbstein-Lehm");
		this.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.stairs.get(), "Gelbstein-Lehmtreppe");
		this.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.slab.get(), "Gelbstein-Lehmstufe");
		this.add(IcariaBlocks.YELLOWSTONE_ADOBE_DECO.wall.get(), "Gelbstein-Lehmmauer");
		this.add(IcariaBlocks.COBBLED_YELLOWSTONE.get(), "Bruchgelbstein");
		this.add(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.stairs.get(), "Bruchgelbsteintreppe");
		this.add(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.slab.get(), "Bruchgelbsteinstufe");
		this.add(IcariaBlocks.COBBLED_YELLOWSTONE_DECO.wall.get(), "Bruchgelbsteinmauer");
		this.add(IcariaBlocks.YELLOWSTONE.get(), "Gelbsteinmauer");
		this.add(IcariaBlocks.YELLOWSTONE_DECO.stairs.get(), "Gelbsteintreppe");
		this.add(IcariaBlocks.YELLOWSTONE_DECO.slab.get(), "Gelbsteinstufe");
		this.add(IcariaBlocks.YELLOWSTONE_DECO.wall.get(), "Gelbsteinmauer");
		this.add(IcariaBlocks.YELLOWSTONE_BRICKS.get(), "Gelbsteinziegel");
		this.add(IcariaBlocks.YELLOWSTONE_BRICK_DECO.stairs.get(), "Gelbsteinziegeltreppe");
		this.add(IcariaBlocks.YELLOWSTONE_BRICK_DECO.slab.get(), "Gelbsteinziegelstufe");
		this.add(IcariaBlocks.YELLOWSTONE_BRICK_DECO.wall.get(), "Gelbsteinziegelmauer");
		this.add(IcariaBlocks.CHISELED_YELLOWSTONE.get(), "Gemeißelter Gelbstein");
		this.add(IcariaBlocks.YELLOWSTONE_RUBBLE.get(), "Gelbsteingeröll");

		this.add(IcariaBlocks.SILKSAND.get(), "Seidensand");
		this.add(IcariaBlocks.SILKGLASS.get(), "Seidenglass");
		this.add(IcariaBlocks.SILKGLASS_PANE.get(), "Seidenglassscheibe");
		this.add(IcariaBlocks.HORIZONTAL_SILKGLASS_PANE.get(), "Horizontale Seidenglassscheibe");
		this.add(IcariaBlocks.SILKSTONE_ADOBE.get(), "Seidenstein-Lehm");
		this.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.stairs.get(), "Seidenstein-Lehmtreppe");
		this.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.slab.get(), "Seidenstein-Lehmstufe");
		this.add(IcariaBlocks.SILKSTONE_ADOBE_DECO.wall.get(), "Seidenstein-Lehmmauer");
		this.add(IcariaBlocks.COBBLED_SILKSTONE.get(), "Bruchseidenstein");
		this.add(IcariaBlocks.COBBLED_SILKSTONE_DECO.stairs.get(), "Bruchseidensteintreppe");
		this.add(IcariaBlocks.COBBLED_SILKSTONE_DECO.slab.get(), "Bruchseidensteinstufe");
		this.add(IcariaBlocks.COBBLED_SILKSTONE_DECO.wall.get(), "Bruchseidensteinmauer");
		this.add(IcariaBlocks.SILKSTONE.get(), "Seidenstein");
		this.add(IcariaBlocks.SILKSTONE_DECO.stairs.get(), "Seidensteintreppe");
		this.add(IcariaBlocks.SILKSTONE_DECO.slab.get(), "Seidensteinstufe");
		this.add(IcariaBlocks.SILKSTONE_DECO.wall.get(), "Seidensteinmauer");
		this.add(IcariaBlocks.SILKSTONE_BRICKS.get(), "Seidensteinziegel");
		this.add(IcariaBlocks.SILKSTONE_BRICK_DECO.stairs.get(), "Seidensteinziegeltreppe");
		this.add(IcariaBlocks.SILKSTONE_BRICK_DECO.slab.get(), "Seidensteinziegelstufe");
		this.add(IcariaBlocks.SILKSTONE_BRICK_DECO.wall.get(), "Seidensteinziegelmauer");
		this.add(IcariaBlocks.CHISELED_SILKSTONE.get(), "Gemeißelter Seidenstein");
		this.add(IcariaBlocks.SILKSTONE_RUBBLE.get(), "Seidensteingeröll");

		this.add(IcariaBlocks.SUNSTONE_ADOBE.get(), "Sonnenstein-Lehm");
		this.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.stairs.get(), "Sonnenstein-Lehmtreppe");
		this.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.slab.get(), "Sonnenstein-Lehmstufe");
		this.add(IcariaBlocks.SUNSTONE_ADOBE_DECO.wall.get(), "Sonnenstein-Lehmmauer");
		this.add(IcariaBlocks.COBBLED_SUNSTONE.get(), "Bruchsonnenstein");
		this.add(IcariaBlocks.COBBLED_SUNSTONE_DECO.stairs.get(), "Bruchsonnensteintreppe");
		this.add(IcariaBlocks.COBBLED_SUNSTONE_DECO.slab.get(), "Bruchsonnensteinstufe");
		this.add(IcariaBlocks.COBBLED_SUNSTONE_DECO.wall.get(), "Bruchsonnensteinmauer");
		this.add(IcariaBlocks.SUNSTONE.get(), "Sonnenstein");
		this.add(IcariaBlocks.SUNSTONE_DECO.stairs.get(), "Sonnensteintreppe");
		this.add(IcariaBlocks.SUNSTONE_DECO.slab.get(), "Sonnensteinstufe");
		this.add(IcariaBlocks.SUNSTONE_DECO.wall.get(), "Sonnensteinmauer");
		this.add(IcariaBlocks.SUNSTONE_BRICKS.get(), "Sonnensteinziegel");
		this.add(IcariaBlocks.SUNSTONE_BRICK_DECO.stairs.get(), "Sonnensteinziegeltreppe");
		this.add(IcariaBlocks.SUNSTONE_BRICK_DECO.slab.get(), "Sonnensteinziegelstufe");
		this.add(IcariaBlocks.SUNSTONE_BRICK_DECO.wall.get(), "Sonnensteinziegelmauer");
		this.add(IcariaBlocks.CHISELED_SUNSTONE.get(), "Gemeißelter Sonnenstein");
		this.add(IcariaBlocks.SUNSTONE_RUBBLE.get(), "Sonnensteingeröll");

		this.add(IcariaBlocks.VOIDSHALE_ADOBE.get(), "Leerenschiefer-Lehm");
		this.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.stairs.get(), "Leerenschiefer-Lehmtreppe");
		this.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.slab.get(), "Leerenschiefer-Lehmstufe");
		this.add(IcariaBlocks.VOIDSHALE_ADOBE_DECO.wall.get(), "Leerenschiefer-Lehmmauer");
		this.add(IcariaBlocks.COBBLED_VOIDSHALE.get(), "Bruchleerenschiefer");
		this.add(IcariaBlocks.COBBLED_VOIDSHALE_DECO.stairs.get(), "Bruchleerenschiefertreppe");
		this.add(IcariaBlocks.COBBLED_VOIDSHALE_DECO.slab.get(), "Bruchleerenschieferstufe");
		this.add(IcariaBlocks.COBBLED_VOIDSHALE_DECO.wall.get(), "Bruchleerenschiefermauer");
		this.add(IcariaBlocks.VOIDSHALE.get(), "Leerenschiefer");
		this.add(IcariaBlocks.VOIDSHALE_DECO.stairs.get(), "Leerenschiefertreppe");
		this.add(IcariaBlocks.VOIDSHALE_DECO.slab.get(), "Leerenschieferstufe");
		this.add(IcariaBlocks.VOIDSHALE_DECO.wall.get(), "Leerenschiefermauer");
		this.add(IcariaBlocks.VOIDSHALE_BRICKS.get(), "Leerenschieferziegel");
		this.add(IcariaBlocks.VOIDSHALE_BRICK_DECO.stairs.get(), "Leerenschieferziegeltreppe");
		this.add(IcariaBlocks.VOIDSHALE_BRICK_DECO.slab.get(), "Leerenschieferziegelstufe");
		this.add(IcariaBlocks.VOIDSHALE_BRICK_DECO.wall.get(), "Leerenschieferziegelmauer");
		this.add(IcariaBlocks.CHISELED_VOIDSHALE.get(), "Gemeißelter Leerenschiefer");
		this.add(IcariaBlocks.VOIDSHALE_RUBBLE.get(), "Leerenschiefergeröll");

		this.add(IcariaBlocks.BAETYL_ADOBE.get(), "Bätyl-Lehm");
		this.add(IcariaBlocks.BAETYL_ADOBE_DECO.stairs.get(), "Bätyl-Lehmtreppe");
		this.add(IcariaBlocks.BAETYL_ADOBE_DECO.slab.get(), "Bätyl-Lehmstufe");
		this.add(IcariaBlocks.BAETYL_ADOBE_DECO.wall.get(), "Bätyl-Lehmmauer");
		this.add(IcariaBlocks.COBBLED_BAETYL.get(), "Bruchbätyl");
		this.add(IcariaBlocks.COBBLED_BAETYL_DECO.stairs.get(), "Bruchbätyltreppe");
		this.add(IcariaBlocks.COBBLED_BAETYL_DECO.slab.get(), "Bruchbätylstufe");
		this.add(IcariaBlocks.COBBLED_BAETYL_DECO.wall.get(), "Bruchbätylmauer");
		this.add(IcariaBlocks.BAETYL.get(), "Bätyl");
		this.add(IcariaBlocks.BAETYL_DECO.stairs.get(), "Bätyltreppe");
		this.add(IcariaBlocks.BAETYL_DECO.slab.get(), "Bätylstufe");
		this.add(IcariaBlocks.BAETYL_DECO.wall.get(), "Bätylmauer");
		this.add(IcariaBlocks.BAETYL_BRICKS.get(), "Bätylziegel");
		this.add(IcariaBlocks.BAETYL_BRICK_DECO.stairs.get(), "Bätylziegeltreppe");
		this.add(IcariaBlocks.BAETYL_BRICK_DECO.slab.get(), "Bätylziegelstufe");
		this.add(IcariaBlocks.BAETYL_BRICK_DECO.wall.get(), "Bätylziegelmauer");
		this.add(IcariaBlocks.CHISELED_BAETYL.get(), "Gemeißelter Bätyl");
		this.add(IcariaBlocks.BAETYL_RUBBLE.get(), "Bätylgeröll");

		this.add(IcariaBlocks.RELICSTONE.get(), "Reliktenstein");
		this.add(IcariaBlocks.RELICSTONE_DECO.stairs.get(), "Reliktensteintreppe");
		this.add(IcariaBlocks.RELICSTONE_DECO.slab.get(), "Reliktensteinstufe");
		this.add(IcariaBlocks.RELICSTONE_DECO.wall.get(), "Reliktensteinmauer");
		this.add(IcariaBlocks.SMOOTH_RELICSTONE.get(), "Glatter Reliktenstein");
		this.add(IcariaBlocks.SMOOTH_RELICSTONE_DECO.stairs.get(), "Glatte Reliktensteintreppe");
		this.add(IcariaBlocks.SMOOTH_RELICSTONE_DECO.slab.get(), "Glatte Reliktensteinstufe");
		this.add(IcariaBlocks.SMOOTH_RELICSTONE_DECO.wall.get(), "Glatte Reliktensteinmauer");
		this.add(IcariaBlocks.RELICSTONE_BRICKS.get(), "Reliktensteinziegel");
		this.add(IcariaBlocks.RELICSTONE_BRICK_DECO.stairs.get(), "Reliktensteinziegeltreppe");
		this.add(IcariaBlocks.RELICSTONE_BRICK_DECO.slab.get(), "Reliktensteinziegelstufe");
		this.add(IcariaBlocks.RELICSTONE_BRICK_DECO.wall.get(), "Reliktensteinziegelmauer");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_BRICKS.get(), "Rissige Reliktensteinziegel");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.stairs.get(), "Rissige Reliktensteinziegeltreppe");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.slab.get(), "Rissige Reliktensteinziegelstufe");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_BRICK_DECO.wall.get(), "Rissige Reliktensteinziegelmauer");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_BRICKS.get(), "Bemooste Reliktensteinziegel");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.stairs.get(), "Bemooste Reliktensteinziegeltreppe");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.slab.get(), "Bemooste Reliktensteinziegelstufe");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_BRICK_DECO.wall.get(), "Bemooste Reliktensteinziegelmauer");
		this.add(IcariaBlocks.RELICSTONE_TILES.get(), "Reliktensteinfliesen");
		this.add(IcariaBlocks.RELICSTONE_TILE_DECO.stairs.get(), "Reliktensteinfliesentreppe");
		this.add(IcariaBlocks.RELICSTONE_TILE_DECO.slab.get(), "Reliktensteinfliesenstufe");
		this.add(IcariaBlocks.RELICSTONE_TILE_DECO.wall.get(), "Reliktensteinfliesenmauer");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_TILES.get(), "Rissige Reliktensteinfliesen");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.stairs.get(), "Rissige Reliktensteinfliesentreppe");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.slab.get(), "Rissige Reliktensteinfliesenstufe");
		this.add(IcariaBlocks.CRACKED_RELICSTONE_TILE_DECO.wall.get(), "Rissige Reliktensteinfliesenmauer");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_TILES.get(), "Bemooste Reliktensteinfliesen");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.stairs.get(), "Bemooste Reliktensteinfliesentreppe");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.slab.get(), "Bemooste Reliktensteinfliesenstufe");
		this.add(IcariaBlocks.MOSSY_RELICSTONE_TILE_DECO.wall.get(), "Bemooste Reliktensteinfliesenmauer");
		this.add(IcariaBlocks.CHISELED_RELICSTONE.get(), "Gemeißelter Reliktenstein");
		this.add(IcariaBlocks.RELICSTONE_PILLAR.get(), "Reliktensteinsäule");
		this.add(IcariaBlocks.RELICSTONE_PILLAR_HEAD.get(), "Reliktensteinsäulenende");
		this.add(IcariaBlocks.RELICSTONE_RUBBLE.get(), "Reliktensteingeröll");

		this.add(IcariaBlocks.PLATOSHALE.get(), "Platoschiefer");
		this.add(IcariaBlocks.PLATOSHALE_DECO.stairs.get(), "Platoschiefertreppe");
		this.add(IcariaBlocks.PLATOSHALE_DECO.slab.get(), "Platoschieferstufe");
		this.add(IcariaBlocks.PLATOSHALE_DECO.wall.get(), "Platoschiefermauer");
		this.add(IcariaBlocks.BLURRED_PLATOSHALE.get(), "Bluritdurchzogener Platoschiefer");
		this.add(IcariaBlocks.PLATOSHALE_BRICKS.get(), "Platoschieferziegel");
		this.add(IcariaBlocks.PLATOSHALE_BRICK_DECO.stairs.get(), "Platoschieferziegeltreppe");
		this.add(IcariaBlocks.PLATOSHALE_BRICK_DECO.slab.get(), "Platoschieferziegelstufe");
		this.add(IcariaBlocks.PLATOSHALE_BRICK_DECO.wall.get(), "Platoschieferziegelmauer");
		this.add(IcariaBlocks.BLURRED_PLATOSHALE_BRICKS.get(), "Bluritdurchzogener Platoschieferziegel");
		this.add(IcariaBlocks.CHISELED_PLATOSHALE.get(), "Gemeißelter Platoschiefer");

		this.add(IcariaBlocks.QUARTZ_PILLAR_HEAD.get(), "Quartzsäulenende");

		this.add(IcariaBlocks.LIGNITE_ORE.get(), "Braunkohleerz");
		this.add(IcariaBlocks.CHALKOS_ORE.get(), "Kuffarerz");
		this.add(IcariaBlocks.KASSITEROS_ORE.get(), "Galmeierz");
		this.add(IcariaBlocks.DOLOMITE_ORE.get(), "Dolomiterz");
		this.add(IcariaBlocks.VANADIUM_ORE.get(), "Vanadinerz");
		this.add(IcariaBlocks.SLIVER_ORE.get(), "Slibbererz");
		this.add(IcariaBlocks.SIDEROS_ORE.get(), "Schirbelerz");
		this.add(IcariaBlocks.ANTHRACITE_ORE.get(), "Schwarzkohleerz");
		this.add(IcariaBlocks.MOLYBDENUM_ORE.get(), "Molybdänerz");
		this.add(IcariaBlocks.HYLIASTRUM_ORE.get(), "Hyliastrumerz");

		this.add(IcariaBlocks.CALCITE.get(), "Calcit");
		this.add(IcariaBlocks.BUDDING_CALCITE.get(), "Calcitknospenblock");
		this.add(IcariaBlocks.HALITE.get(), "Halit");
		this.add(IcariaBlocks.BUDDING_HALITE.get(), "Halitknospenblock");
		this.add(IcariaBlocks.JASPER.get(), "Jaspis");
		this.add(IcariaBlocks.BUDDING_JASPER.get(), "Jaspisknospenblock");
		this.add(IcariaBlocks.ZIRCON.get(), "Zirkon");
		this.add(IcariaBlocks.BUDDING_ZIRCON.get(), "Zirkonknospenblock");

		this.add(IcariaBlocks.CALCITE_CRYSTAL.get(), "Calcitkristall");
		this.add(IcariaBlocks.HALITE_CRYSTAL.get(), "Halitkristall");
		this.add(IcariaBlocks.JASPER_CRYSTAL.get(), "Jaspiskristall");
		this.add(IcariaBlocks.ZIRCON_CRYSTAL.get(), "Zirkonkristall");

		this.add(IcariaBlocks.ARISTONE.get(), "Aristein");
		this.add(IcariaBlocks.PACKED_ARISTONE.get(), "Komprimierter Aristein");

		this.add(IcariaBlocks.ENDER_JELLYFISH_JELLY_BLOCK.get(), "Ender-Quallengeleeblock");
		this.add(IcariaBlocks.FIRE_JELLYFISH_JELLY_BLOCK.get(), "Feuer-Quallengeleeblock");
		this.add(IcariaBlocks.NATURE_JELLYFISH_JELLY_BLOCK.get(), "Natur-Quallengeleeblock");
		this.add(IcariaBlocks.VOID_JELLYFISH_JELLY_BLOCK.get(), "Leeren-Quallengeleeblock");
		this.add(IcariaBlocks.WATER_JELLYFISH_JELLY_BLOCK.get(), "Wasser-Quallengeleeblock");
		this.add(IcariaBlocks.ARACHNE_STRING_BLOCK.get(), "Arachnefadenblock");
		this.add(IcariaBlocks.SPELT_BALE_BLOCK.get(), "Dinkelballen");
		this.add(IcariaBlocks.VINE_REED_BLOCK.get(), "Weinschilfblock");
		this.add(IcariaBlocks.VINE_SPROUT_BLOCK.get(), "Weinsprossenblock");
		this.add(IcariaBlocks.ROTTEN_BONES_BLOCK.get(), "Verrotteter Knochenblock");

		this.add(IcariaBlocks.RAW_CHALKOS_BLOCK.get(), "Rohkuffarblock");
		this.add(IcariaBlocks.RAW_KASSITEROS_BLOCK.get(), "Rohgalmeiblock");
		this.add(IcariaBlocks.RAW_VANADIUM_BLOCK.get(), "Rohvanadinblock");
		this.add(IcariaBlocks.SLIVER_BLOCK.get(), "Rohslibberblock");
		this.add(IcariaBlocks.RAW_SIDEROS_BLOCK.get(), "Rohschirbelblock");
		this.add(IcariaBlocks.RAW_MOLYBDENUM_BLOCK.get(), "Rohmolybdänblock");

		this.add(IcariaBlocks.CALCITE_BLOCK.get(), "Calcitblock");
		this.add(IcariaBlocks.HALITE_BLOCK.get(), "Halitblock");
		this.add(IcariaBlocks.JASPER_BLOCK.get(), "Jaspisblock");
		this.add(IcariaBlocks.ZIRCON_BLOCK.get(), "Zirkonblock");
		this.add(IcariaBlocks.CHERT_BLOCK.get(), "Hornsteinblock");
		this.add(IcariaBlocks.LIGNITE_BLOCK.get(), "Braunkohleblock");
		this.add(IcariaBlocks.CHALKOS_BLOCK.get(), "Kuffarblock");
		this.add(IcariaBlocks.KASSITEROS_BLOCK.get(), "Galmeiblock");
		this.add(IcariaBlocks.ORICHALCUM_BLOCK.get(), "Goldmessingblock");
		this.add(IcariaBlocks.VANADIUM_BLOCK.get(), "Vanadinblock");
		this.add(IcariaBlocks.VANADIUMSTEEL_BLOCK.get(), "Vanadinstahlblock");
		this.add(IcariaBlocks.SIDEROS_BLOCK.get(), "Schirbelblock");
		this.add(IcariaBlocks.ANTHRACITE_BLOCK.get(), "Schwarzkohleblock");
		this.add(IcariaBlocks.MOLYBDENUM_BLOCK.get(), "Molybdänblock");
		this.add(IcariaBlocks.MOLYBDENUMSTEEL_BLOCK.get(), "Molybdänstahlblock");
		this.add(IcariaBlocks.BLURIDIUM_BLOCK.get(), "Bluritblock");

		this.add(IcariaBlocks.VANADIUMSTEEL_BARS.get(), "Vanadinsthalgitter");
		this.add(IcariaBlocks.HORIZONTAL_VANADIUMSTEEL_BARS.get(), "Horizontale Vanadinstahlgitter");

		this.add(IcariaBlocks.VANADIUMSTEEL_CHAIN.get(), "Vanadinstahlkette");

		this.add(IcariaBlocks.KETTLE.get(), "Kessel");
		this.add(IcariaBlocks.GRINDER.get(), "Mühle");
		this.add(IcariaBlocks.KILN.get(), "Töpferofen");
		this.add(IcariaBlocks.FORGE.get(), "Schmelze");

		this.add(IcariaBlocks.CHEST.get(), "Truhe");
		this.add(IcariaBlocks.TRAPPED_CHEST.get(), "Redstone-Truhe");

		this.add(IcariaBlocks.BARREL.get(), "Fass");
		this.add(IcariaBlocks.BARREL_RACK.get(), "Fass-Gestell");

		this.add(IcariaBlocks.STORAGE_VASE.get(), "Speichervase");
		this.add(IcariaBlocks.WHITE_STORAGE_VASE.get(), "Weiße Speichervase");
		this.add(IcariaBlocks.LIGHT_GRAY_STORAGE_VASE.get(), "Hellgraue Speichervase");
		this.add(IcariaBlocks.GRAY_STORAGE_VASE.get(), "Graue Speichervase");
		this.add(IcariaBlocks.BLACK_STORAGE_VASE.get(), "Schwarze Speichervase");
		this.add(IcariaBlocks.BROWN_STORAGE_VASE.get(), "Braune Speichervase");
		this.add(IcariaBlocks.RED_STORAGE_VASE.get(), "Rote Speichervase");
		this.add(IcariaBlocks.ORANGE_STORAGE_VASE.get(), "Orange Speichervase");
		this.add(IcariaBlocks.YELLOW_STORAGE_VASE.get(), "Gelbe Speichervase");
		this.add(IcariaBlocks.LIME_STORAGE_VASE.get(), "Hellgrüne Speichervase");
		this.add(IcariaBlocks.GREEN_STORAGE_VASE.get(), "Grüne Speichervase");
		this.add(IcariaBlocks.CYAN_STORAGE_VASE.get(), "Türkise Speichervase");
		this.add(IcariaBlocks.LIGHT_BLUE_STORAGE_VASE.get(), "Hellblaue Speichervase");
		this.add(IcariaBlocks.BLUE_STORAGE_VASE.get(), "Blaue Speichervase");
		this.add(IcariaBlocks.PURPLE_STORAGE_VASE.get(), "Violette Speichervase");
		this.add(IcariaBlocks.MAGENTA_STORAGE_VASE.get(), "Magenta Speichervase");
		this.add(IcariaBlocks.PINK_STORAGE_VASE.get(), "Rosa Speichervase");

		this.add(IcariaBlocks.RED_LOOT_VASE.get(), "Rote Beutevase");
		this.add(IcariaBlocks.CYAN_LOOT_VASE.get(), "Türkise Beutevase");

		this.add(IcariaBlocks.DUNGEON_SPAWNER.get(), "Verlies-Spawner");
		this.add(IcariaBlocks.MYRMEKE_SPAWNER.get(), "Ameisen-Spawner");
		this.add(IcariaBlocks.RUIN_SPAWNER.get(), "Ruinen-Spawner");
		this.add(IcariaBlocks.VILLAGE_SPAWNER.get(), "Dorf-Spawner");

		this.add(IcariaBlocks.AETERNAE_SKULL.get(), "Äternschädel");
		this.add(IcariaBlocks.ARGAN_HOUND_SKULL.get(), "Arganischer Hundeschädel");
		this.add(IcariaBlocks.CATOBLEPAS_SKULL.get(), "Katoblepasschädel");
		this.add(IcariaBlocks.CERVER_SKULL.get(), "Pantherschädel");
		this.add(IcariaBlocks.CYPRESS_FOREST_HAG_SKULL.get(), "Zypressen-Baumwächterschädel");
		this.add(IcariaBlocks.DROUGHTROOT_FOREST_HAG_SKULL.get(), "Dürrwurzel-Baumwächterschädel");
		this.add(IcariaBlocks.FIR_FOREST_HAG_SKULL.get(), "Tannen-Baumwächterschädel");
		this.add(IcariaBlocks.LAUREL_FOREST_HAG_SKULL.get(), "Lorbeer-Baumwächterschädel");
		this.add(IcariaBlocks.OLIVE_FOREST_HAG_SKULL.get(), "Oliven-Baumwächterschädel");
		this.add(IcariaBlocks.PLANE_FOREST_HAG_SKULL.get(), "Plantanen-Baumwächterschädel");
		this.add(IcariaBlocks.POPULUS_FOREST_HAG_SKULL.get(), "Pappel-Baumwächterschädel");
		this.add(IcariaBlocks.REVENANT_SKULL.get(), "Wiedergängerschädel");
		this.add(IcariaBlocks.SOW_SKULL.get(), "Krommyonischer Sauschädel");

		this.add(IcariaBlocks.LIGNITE_TORCH.get(), "Braunkohlefackel");
		this.add(IcariaBlocks.ANTHRACITE_TORCH.get(), "Schwarzkohlefackel");

		this.add(IcariaBlocks.LAUREL_CHERRY_CAKE.get(), "Lorbeerkirschkuchen");
		this.add(IcariaBlocks.STRAWBERRY_CAKE.get(), "Erdbeerkuchen");
		this.add(IcariaBlocks.PHYSALIS_CAKE.get(), "Physaliskuchen");
		this.add(IcariaBlocks.VINE_BERRY_CAKE.get(), "Rankenbeerenkuchen");
		this.add(IcariaBlocks.VINE_SPROUT_CAKE.get(), "Rankensprossenkuchen");

		this.add(IcariaBlocks.CYPRESS_SAPLING.get(), "Zypressensetzling");
		this.add(IcariaBlocks.POTTED_CYPRESS_SAPLING.get(), "Eingetopfter Zypressensetzling");
		this.add(IcariaBlocks.CYPRESS_LEAVES.get(), "Zypressenlaub");
		this.add(IcariaBlocks.FALLEN_CYPRESS_LEAVES.get(), "Herabgefallenes Zypressenlaub");
		this.add(IcariaBlocks.CYPRESS_TWIGS.get(), "Zypressenzweige");
		this.add(IcariaBlocks.CYPRESS_WOOD.get(), "Zypressenholz");
		this.add(IcariaBlocks.STRIPPED_CYPRESS_WOOD.get(), "Entrindetes Zypressenholz");
		this.add(IcariaBlocks.CYPRESS_LOG.get(), "Zypressenstamm");
		this.add(IcariaBlocks.STRIPPED_CYPRESS_LOG.get(), "Entrindeter Zypressenstamm");
		this.add(IcariaBlocks.DEAD_CYPRESS_LOG.get(), "Toter Zypressenstamm");
		this.add(IcariaBlocks.STRIPPED_DEAD_CYPRESS_LOG.get(), "Entrindeter toter Zypressenstamm");
		this.add(IcariaBlocks.CYPRESS_PLANKS.get(), "Zypressenholzbretter");
		this.add(IcariaBlocks.CYPRESS_DECO.stairs.get(), "Zypressenholztreppe");
		this.add(IcariaBlocks.CYPRESS_DECO.slab.get(), "Zypressenholzstufe");
		this.add(IcariaBlocks.CYPRESS_DECO.fence.get(), "Zypressenholzzaun");
		this.add(IcariaBlocks.CYPRESS_DECO.gate.get(), "Zypressenholzzauntor");
		this.add(IcariaBlocks.CYPRESS_CRAFTING_TABLE.get(), "Zypressenholzwerkbank");
		this.add(IcariaBlocks.CYPRESS_DOOR.get(), "Zypressenholztür");
		this.add(IcariaBlocks.CYPRESS_TRAPDOOR.get(), "Zypressenholzfalltür");
		this.add(IcariaBlocks.CYPRESS_LADDER.get(), "Zypressenholzleiter");
		this.add(IcariaBlocks.CYPRESS_SIGN.get(), "Zypressenholzschild");
		this.add(IcariaBlocks.CYPRESS_HANGING_SIGN.get(), "Zypressenholzhängeschild");

		this.add(IcariaBlocks.DROUGHTROOT_SAPLING.get(), "Dürrwurzelsetzling");
		this.add(IcariaBlocks.POTTED_DROUGHTROOT_SAPLING.get(), "Eingetopfter Dürrwurzelsetzling");
		this.add(IcariaBlocks.DROUGHTROOT_LEAVES.get(), "Dürrwurzellaub");
		this.add(IcariaBlocks.FALLEN_DROUGHTROOT_LEAVES.get(), "Herabgefallenes Dürrwurzellaub");
		this.add(IcariaBlocks.DROUGHTROOT_TWIGS.get(), "Dürrwurzelzweige");
		this.add(IcariaBlocks.DROUGHTROOT_WOOD.get(), "Dürrwurzelholz");
		this.add(IcariaBlocks.STRIPPED_DROUGHTROOT_WOOD.get(), "Entrindetes Dürrwurzelholz");
		this.add(IcariaBlocks.DROUGHTROOT_LOG.get(), "Dürrwurzelstamm");
		this.add(IcariaBlocks.STRIPPED_DROUGHTROOT_LOG.get(), "Entrindeter Dürrwurzelstamm");
		this.add(IcariaBlocks.DEAD_DROUGHTROOT_LOG.get(), "Toter Dürrwurzelstamm");
		this.add(IcariaBlocks.STRIPPED_DEAD_DROUGHTROOT_LOG.get(), "Entrindeter toter Dürrwurzelstamm");
		this.add(IcariaBlocks.DROUGHTROOT_PLANKS.get(), "Dürrwurzelholzbretter");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.stairs.get(), "Dürrwurzelholztreppe");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.slab.get(), "Dürrwurzelholzstufe");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.fence.get(), "Dürrwurzelholzzaun");
		this.add(IcariaBlocks.DROUGHTROOT_DECO.gate.get(), "Dürrwurzelholzzauntor");
		this.add(IcariaBlocks.DROUGHTROOT_CRAFTING_TABLE.get(), "Dürrwurzelholzwerkbank");
		this.add(IcariaBlocks.DROUGHTROOT_DOOR.get(), "Dürrwurzelholztür");
		this.add(IcariaBlocks.DROUGHTROOT_TRAPDOOR.get(), "Dürrwurzelholzfalltür");
		this.add(IcariaBlocks.DROUGHTROOT_LADDER.get(), "Dürrwurzelholzleiter");
		this.add(IcariaBlocks.DROUGHTROOT_SIGN.get(), "Dürrwurzelholzschild");
		this.add(IcariaBlocks.DROUGHTROOT_HANGING_SIGN.get(), "Dürrwurzelholzhängeschild");

		this.add(IcariaBlocks.FIR_SAPLING.get(), "Tannensetzling");
		this.add(IcariaBlocks.POTTED_FIR_SAPLING.get(), "Eingetopfter Tannensetzling");
		this.add(IcariaBlocks.FIR_LEAVES.get(), "Tannenlaub");
		this.add(IcariaBlocks.FALLEN_FIR_LEAVES.get(), "Herbagefallenes Tannenlaub");
		this.add(IcariaBlocks.FIR_TWIGS.get(), "Tannenzweige");
		this.add(IcariaBlocks.FIR_WOOD.get(), "Tannenholz");
		this.add(IcariaBlocks.STRIPPED_FIR_WOOD.get(), "Entrindetes Tannenholz");
		this.add(IcariaBlocks.FIR_LOG.get(), "Tannenstamm");
		this.add(IcariaBlocks.STRIPPED_FIR_LOG.get(), "Entrindeter Tannenstamm");
		this.add(IcariaBlocks.DEAD_FIR_LOG.get(), "Toter Tannenstamm");
		this.add(IcariaBlocks.STRIPPED_DEAD_FIR_LOG.get(), "Entrindeter toter Tannenstamm");
		this.add(IcariaBlocks.FIR_PLANKS.get(), "Tannenholzbretter");
		this.add(IcariaBlocks.FIR_DECO.stairs.get(), "Tannenholztreppe");
		this.add(IcariaBlocks.FIR_DECO.slab.get(), "Tannenholzstufe");
		this.add(IcariaBlocks.FIR_DECO.fence.get(), "Tannenholzzaun");
		this.add(IcariaBlocks.FIR_DECO.gate.get(), "Tannenholzzauntor");
		this.add(IcariaBlocks.FIR_CRAFTING_TABLE.get(), "Tannenholzwerkbank");
		this.add(IcariaBlocks.FIR_DOOR.get(), "Tannenholztür");
		this.add(IcariaBlocks.FIR_TRAPDOOR.get(), "Tannenholzfalltür");
		this.add(IcariaBlocks.FIR_LADDER.get(), "Tannenholzleiter");
		this.add(IcariaBlocks.FIR_SIGN.get(), "Tannenholzschild");
		this.add(IcariaBlocks.FIR_HANGING_SIGN.get(), "Tannenholzhängeschild");

		this.add(IcariaBlocks.LAUREL_SAPLING.get(), "Lorbeersetzling");
		this.add(IcariaBlocks.POTTED_LAUREL_SAPLING.get(), "Eingetopfter Lorbeersetzling");
		this.add(IcariaBlocks.LAUREL_LEAVES.get(), "Lorbeerlaub");
		this.add(IcariaBlocks.FALLEN_LAUREL_LEAVES.get(), "Herbagefallenes Lorbeerlaub");
		this.add(IcariaBlocks.LAUREL_TWIGS.get(), "Lorbeerzweige");
		this.add(IcariaBlocks.LAUREL_WOOD.get(), "Lorbeerholz");
		this.add(IcariaBlocks.STRIPPED_LAUREL_WOOD.get(), "Entrindetes Lorbeerholz");
		this.add(IcariaBlocks.LAUREL_LOG.get(), "Lorbeerstamm");
		this.add(IcariaBlocks.STRIPPED_LAUREL_LOG.get(), "Entrindeter Lorbeerstamm");
		this.add(IcariaBlocks.DEAD_LAUREL_LOG.get(), "Toter Lorbeerstamm");
		this.add(IcariaBlocks.STRIPPED_DEAD_LAUREL_LOG.get(), "Entrindeter toter Lorbeerstamm");
		this.add(IcariaBlocks.LAUREL_PLANKS.get(), "Lorbeerholzbretter");
		this.add(IcariaBlocks.LAUREL_DECO.stairs.get(), "Lorbeerholztreppe");
		this.add(IcariaBlocks.LAUREL_DECO.slab.get(), "Lorbeerholzstufe");
		this.add(IcariaBlocks.LAUREL_DECO.fence.get(), "Lorbeerholzzaun");
		this.add(IcariaBlocks.LAUREL_DECO.gate.get(), "Lorbeerholzzauntor");
		this.add(IcariaBlocks.LAUREL_CRAFTING_TABLE.get(), "Lorbeerholzwerkbank");
		this.add(IcariaBlocks.LAUREL_DOOR.get(), "Lorbeerholztür");
		this.add(IcariaBlocks.LAUREL_TRAPDOOR.get(), "Lorbeerholzfalltür");
		this.add(IcariaBlocks.LAUREL_LADDER.get(), "Lorbeerholzleiter");
		this.add(IcariaBlocks.LAUREL_SIGN.get(), "Lorbeerholzschild");
		this.add(IcariaBlocks.LAUREL_HANGING_SIGN.get(), "Lorbeerholzhängeschild");

		this.add(IcariaBlocks.OLIVE_SAPLING.get(), "Olivensetzling");
		this.add(IcariaBlocks.POTTED_OLIVE_SAPLING.get(), "Eingetopfter Olivensetzling");
		this.add(IcariaBlocks.OLIVE_LEAVES.get(), "Olivenlaub");
		this.add(IcariaBlocks.FALLEN_OLIVE_LEAVES.get(), "Herbagefallenes Olivenlaub");
		this.add(IcariaBlocks.OLIVE_TWIGS.get(), "Olivenzweige");
		this.add(IcariaBlocks.OLIVE_WOOD.get(), "Olivenholz");
		this.add(IcariaBlocks.STRIPPED_OLIVE_WOOD.get(), "Entrindetes Olivenholz");
		this.add(IcariaBlocks.OLIVE_LOG.get(), "Olivenstamm");
		this.add(IcariaBlocks.STRIPPED_OLIVE_LOG.get(), "Entrindeter Olivenstamm");
		this.add(IcariaBlocks.DEAD_OLIVE_LOG.get(), "Toter Olivenstamm");
		this.add(IcariaBlocks.STRIPPED_DEAD_OLIVE_LOG.get(), "Entrindeter toter Olivenstamm");
		this.add(IcariaBlocks.OLIVE_PLANKS.get(), "Olivenholzbretter");
		this.add(IcariaBlocks.OLIVE_DECO.stairs.get(), "Olivenholztreppe");
		this.add(IcariaBlocks.OLIVE_DECO.slab.get(), "Olivenholzstufe");
		this.add(IcariaBlocks.OLIVE_DECO.fence.get(), "Olivenholzzaun");
		this.add(IcariaBlocks.OLIVE_DECO.gate.get(), "Olivenholzzauntor");
		this.add(IcariaBlocks.OLIVE_CRAFTING_TABLE.get(), "Olivenholzwerkbank");
		this.add(IcariaBlocks.OLIVE_DOOR.get(), "Olivenholztür");
		this.add(IcariaBlocks.OLIVE_TRAPDOOR.get(), "Olivenholzfalltür");
		this.add(IcariaBlocks.OLIVE_LADDER.get(), "Olivenholzleiter");
		this.add(IcariaBlocks.OLIVE_SIGN.get(), "Olivenholzschild");
		this.add(IcariaBlocks.OLIVE_HANGING_SIGN.get(), "Olivenholzhängeschild");

		this.add(IcariaBlocks.PLANE_SAPLING.get(), "Plantanensetzling");
		this.add(IcariaBlocks.POTTED_PLANE_SAPLING.get(), "Eingetopfter Plantanensetzling");
		this.add(IcariaBlocks.PLANE_LEAVES.get(), "Plantanenlaub");
		this.add(IcariaBlocks.FALLEN_PLANE_LEAVES.get(), "Herbagefallenes Plantanenlaub");
		this.add(IcariaBlocks.PLANE_TWIGS.get(), "Plantanenzweige");
		this.add(IcariaBlocks.PLANE_WOOD.get(), "Plantanenholz");
		this.add(IcariaBlocks.STRIPPED_PLANE_WOOD.get(), "Entrindetes Plantanenholz");
		this.add(IcariaBlocks.PLANE_LOG.get(), "Plantanenstamm");
		this.add(IcariaBlocks.STRIPPED_PLANE_LOG.get(), "Entrindeter Plantanenstamm");
		this.add(IcariaBlocks.DEAD_PLANE_LOG.get(), "Toter Plantanenstamm");
		this.add(IcariaBlocks.STRIPPED_DEAD_PLANE_LOG.get(), "Entrindeter toter Plantanenstamm");
		this.add(IcariaBlocks.PLANE_PLANKS.get(), "Plantanenholzbretter");
		this.add(IcariaBlocks.PLANE_DECO.stairs.get(), "Plantanenholztreppe");
		this.add(IcariaBlocks.PLANE_DECO.slab.get(), "Plantanenholzstufe");
		this.add(IcariaBlocks.PLANE_DECO.fence.get(), "Plantanenholzzaun");
		this.add(IcariaBlocks.PLANE_DECO.gate.get(), "Plantanenholzzauntor");
		this.add(IcariaBlocks.PLANE_CRAFTING_TABLE.get(), "Plantanenholzwerkbank");
		this.add(IcariaBlocks.PLANE_DOOR.get(), "Plantanenholztür");
		this.add(IcariaBlocks.PLANE_TRAPDOOR.get(), "Plantanenholzfalltür");
		this.add(IcariaBlocks.PLANE_LADDER.get(), "Plantanenholzleiter");
		this.add(IcariaBlocks.PLANE_SIGN.get(), "Plantanenholzschild");
		this.add(IcariaBlocks.PLANE_HANGING_SIGN.get(), "Plantanenholzhängeschild");

		this.add(IcariaBlocks.POPULUS_SAPLING.get(), "Pappelsetzling");
		this.add(IcariaBlocks.POTTED_POPULUS_SAPLING.get(), "Eingetopfter Pappelsetzling");
		this.add(IcariaBlocks.POPULUS_LEAVES.get(), "Pappellaub");
		this.add(IcariaBlocks.FALLEN_POPULUS_LEAVES.get(), "Herbagefallenes Pappellaub");
		this.add(IcariaBlocks.POPULUS_TWIGS.get(), "Pappelzweige");
		this.add(IcariaBlocks.POPULUS_WOOD.get(), "Pappelholz");
		this.add(IcariaBlocks.STRIPPED_POPULUS_WOOD.get(), "Entrindetes Pappelholz");
		this.add(IcariaBlocks.POPULUS_LOG.get(), "Pappelstamm");
		this.add(IcariaBlocks.STRIPPED_POPULUS_LOG.get(), "Entrindeter Pappelstamm");
		this.add(IcariaBlocks.DEAD_POPULUS_LOG.get(), "Toter Pappelstamm");
		this.add(IcariaBlocks.STRIPPED_DEAD_POPULUS_LOG.get(), "Entrindeter toter Pappelstamm");
		this.add(IcariaBlocks.POPULUS_PLANKS.get(), "Pappelholzbretter");
		this.add(IcariaBlocks.POPULUS_DECO.stairs.get(), "Pappelholztreppe");
		this.add(IcariaBlocks.POPULUS_DECO.slab.get(), "Pappelholzstufe");
		this.add(IcariaBlocks.POPULUS_DECO.fence.get(), "Pappelholzzaun");
		this.add(IcariaBlocks.POPULUS_DECO.gate.get(), "Pappelholzzauntor");
		this.add(IcariaBlocks.POPULUS_CRAFTING_TABLE.get(), "Pappelholzwerkbank");
		this.add(IcariaBlocks.POPULUS_DOOR.get(), "Pappelholztür");
		this.add(IcariaBlocks.POPULUS_TRAPDOOR.get(), "Pappelholzfalltür");
		this.add(IcariaBlocks.POPULUS_LADDER.get(), "Pappelholzleiter");
		this.add(IcariaBlocks.POPULUS_SIGN.get(), "Pappelholzschild");
		this.add(IcariaBlocks.POPULUS_HANGING_SIGN.get(), "Pappelholzhängeschild");

		this.add(IcariaBlocks.DEAD_BLOOMY_VINE.get(), "Blühende Ranken");
		this.add(IcariaBlocks.GROWING_BLOOMY_VINE.get(), "Blühende Ranken");
		this.add(IcariaBlocks.RIPE_BLOOMY_VINE.get(), "Blühende Ranken");
		this.add(IcariaBlocks.BLOOMING_BLOOMY_VINE.get(), "Blühende Ranken");
		this.add(IcariaBlocks.BLOOMY_VINE.get(), "Blühende Ranken");

		this.add(IcariaBlocks.DEAD_BRANCHY_VINE.get(), "Holzige Ranken");
		this.add(IcariaBlocks.GROWING_BRANCHY_VINE.get(), "Holzige Ranken");
		this.add(IcariaBlocks.BRANCHY_VINE.get(), "Holzige Ranken");

		this.add(IcariaBlocks.DEAD_BRUSHY_VINE.get(), "Dichte Ranken");
		this.add(IcariaBlocks.GROWING_BRUSHY_VINE.get(), "Dichte Ranken");
		this.add(IcariaBlocks.RIPE_BRUSHY_VINE.get(), "Dichte Ranken");
		this.add(IcariaBlocks.BRUSHY_VINE.get(), "Dichte Ranken");

		this.add(IcariaBlocks.DEAD_DRY_VINE.get(), "Trockene Ranken");
		this.add(IcariaBlocks.GROWING_DRY_VINE.get(), "Trockene Ranken");
		this.add(IcariaBlocks.DRY_VINE.get(), "Trockene Ranken");

		this.add(IcariaBlocks.DEAD_REEDY_VINE.get(), "Schilfige Ranken");
		this.add(IcariaBlocks.GROWING_REEDY_VINE.get(), "Schilfige Ranken");
		this.add(IcariaBlocks.REEDY_VINE.get(), "Schilfige Ranken");

		this.add(IcariaBlocks.DEAD_SWIRLY_VINE.get(), "Gewundene Ranken");
		this.add(IcariaBlocks.GROWING_SWIRLY_VINE.get(), "Gewundene Ranken");
		this.add(IcariaBlocks.SWIRLY_VINE.get(), "Gewundene Ranken");

		this.add(IcariaBlocks.DEAD_THORNY_VINE.get(), "Dornige Ranken");
		this.add(IcariaBlocks.GROWING_THORNY_VINE.get(), "Dornige Ranken");
		this.add(IcariaBlocks.THORNY_VINE.get(), "Dornige Ranken");

		this.add(IcariaBlocks.FERN.get(), "Farn");
		this.add(IcariaBlocks.POTTED_FERN.get(), "Eingetopfter Farn");

		this.add(IcariaBlocks.SMALL_GRASS.get(), "Kleines Gras");
		this.add(IcariaBlocks.MEDIUM_GRASS.get(), "Mittleres Gras");
		this.add(IcariaBlocks.LARGE_GRASS.get(), "Großes Gras");

		this.add(IcariaBlocks.SMALL_MIXED_GRAIN.get(), "Kleines gemischtes Wildgetreide");
		this.add(IcariaBlocks.MEDIUM_MIXED_GRAIN.get(), "Mittelgroßes gemischtes Wildgetreide");
		this.add(IcariaBlocks.MEDIUM_BROWN_GRAIN.get(), "Mittelgroßes braunes Wildgetreide");
		this.add(IcariaBlocks.MEDIUM_WHITE_GRAIN.get(), "Mittelgroßes weißes Wildgetreide");
		this.add(IcariaBlocks.MEDIUM_YELLOW_GRAIN.get(), "Mittelgroßes gelbes Wildgetreide");
		this.add(IcariaBlocks.LARGE_BROWN_GRAIN.get(), "Großes braunes Wildgetreide");

		this.add(IcariaBlocks.BLINDWEED.get(), "Blindgras");
		this.add(IcariaBlocks.POTTED_BLINDWEED.get(), "Eingetopftes Blindgras");
		this.add(IcariaBlocks.CHAMEOMILE.get(), "Kamille");
		this.add(IcariaBlocks.POTTED_CHAMEOMILE.get(), "Eingetopfte Kamille");
		this.add(IcariaBlocks.CHARMONDER.get(), "Charvendel");
		this.add(IcariaBlocks.POTTED_CHARMONDER.get(), "Eingetopfter Charvendel");
		this.add(IcariaBlocks.CLOVER.get(), "Klee");
		this.add(IcariaBlocks.POTTED_CLOVER.get(), "Eingetopfter Klee");
		this.add(IcariaBlocks.FIREHILT.get(), "Feuergriff");
		this.add(IcariaBlocks.POTTED_FIREHILT.get(), "Eingetopfter Feuergriff");
		this.add(IcariaBlocks.BLUE_HYDRACINTH.get(), "Blaue Hydrazinthe");
		this.add(IcariaBlocks.POTTED_BLUE_HYDRACINTH.get(), "Eingetopfte blaue Hydrazinthe");
		this.add(IcariaBlocks.PURPLE_HYDRACINTH.get(), "Violette Hydrazinthe");
		this.add(IcariaBlocks.POTTED_PURPLE_HYDRACINTH.get(), "Eingetopfte violette Hydrazinthe");
		this.add(IcariaBlocks.LIONFANGS.get(), "Löwenkralle");
		this.add(IcariaBlocks.POTTED_LIONFANGS.get(), "Eingetopfte Löwenkralle");
		this.add(IcariaBlocks.SPEARDROPS.get(), "Speertropfen");
		this.add(IcariaBlocks.POTTED_SPEARDROPS.get(), "Eingetopfte Speertropfen");
		this.add(IcariaBlocks.PURPLE_STAGHORN.get(), "Violettes Wildhorn");
		this.add(IcariaBlocks.POTTED_PURPLE_STAGHORN.get(), "Eingetopftes violetter Wildhorn");
		this.add(IcariaBlocks.YELLOW_STAGHORN.get(), "Gelbes Wildhorn");
		this.add(IcariaBlocks.POTTED_YELLOW_STAGHORN.get(), "Eingetopftes gelber Wildhorn");
		this.add(IcariaBlocks.BLUE_STORMCOTTON.get(), "Blaues Sturmgarn");
		this.add(IcariaBlocks.POTTED_BLUE_STORMCOTTON.get(), "Eingetopfter blaues Sturmgarn");
		this.add(IcariaBlocks.PINK_STORMCOTTON.get(), "Rosa Sturmgarn");
		this.add(IcariaBlocks.POTTED_PINK_STORMCOTTON.get(), "Eingetopfter rosa Sturmgarn");
		this.add(IcariaBlocks.PURPLE_STORMCOTTON.get(), "Violettes Sturmgarn");
		this.add(IcariaBlocks.POTTED_PURPLE_STORMCOTTON.get(), "Eingetopfter violettes Sturmgarn");
		this.add(IcariaBlocks.SUNKETTLE.get(), "Sonnenkessel");
		this.add(IcariaBlocks.POTTED_SUNKETTLE.get(), "Eingetopfter Sonnenkessel");
		this.add(IcariaBlocks.SUNSPONGE.get(), "Sonnenschwamm");
		this.add(IcariaBlocks.POTTED_SUNSPONGE.get(), "Eingetopfter Sonnenschwamm");
		this.add(IcariaBlocks.VOIDLILY.get(), "Leerenlilie");
		this.add(IcariaBlocks.POTTED_VOIDLILY.get(), "Eingetopfte Leerenlilie");

		this.add(IcariaBlocks.BOLBOS.get(), "Blasenkraut");
		this.add(IcariaBlocks.DATHULLA.get(), "Dathulla");
		this.add(IcariaBlocks.MONDANOS.get(), "Banales Kraut");
		this.add(IcariaBlocks.MOTH_AGARIC.get(), "Mottenpilz");
		this.add(IcariaBlocks.NAMDRAKE.get(), "Aalraune");
		this.add(IcariaBlocks.PSILOCYBOS.get(), "Psilocybinschilf");
		this.add(IcariaBlocks.ROWAN.get(), "Aschstrauch");
		this.add(IcariaBlocks.WILTED_ELM.get(), "Verwelkte Ulme");

		this.add(IcariaBlocks.BLUE_GROUND_FLOWERS.get(), "Blaue Bodenblüten");
		this.add(IcariaBlocks.CYAN_GROUND_FLOWERS.get(), "Türkise Bodenblüten");
		this.add(IcariaBlocks.PINK_GROUND_FLOWERS.get(), "Rosa Bodenblüten");
		this.add(IcariaBlocks.PURPLE_GROUND_FLOWERS.get(), "Violette Bodenblüten");
		this.add(IcariaBlocks.RED_GROUND_FLOWERS.get(), "Rote Bodenblüten");
		this.add(IcariaBlocks.WHITE_GROUND_FLOWERS.get(), "Weiße Bodenblüten");

		this.add(IcariaBlocks.FOREST_MOSS.get(), "Wald-Moos");
		this.add(IcariaBlocks.SCRUBLAND_MOSS.get(), "Buschland-Moos");
		this.add(IcariaBlocks.STEPPE_MOSS.get(), "Steppen-Moos");

		this.add(IcariaBlocks.PALM_FERN.get(), "Palmfarn");
		this.add(IcariaBlocks.POTTED_PALM_FERN.get(), "Eingetopfter Palmfarn");

		this.add(IcariaBlocks.WHITE_BROMELIA.get(), "Weiße Bromelie");
		this.add(IcariaBlocks.POTTED_WHITE_BROMELIA.get(), "Eingetopfte weiße Bromelie");
		this.add(IcariaBlocks.ORANGE_BROMELIA.get(), "Orange Bromelie");
		this.add(IcariaBlocks.POTTED_ORANGE_BROMELIA.get(), "Eingetopfte orange Bromelie");
		this.add(IcariaBlocks.PINK_BROMELIA.get(), "Rosa Bromelie");
		this.add(IcariaBlocks.POTTED_PINK_BROMELIA.get(), "Eingetopfte rosa Bromelie");
		this.add(IcariaBlocks.PURPLE_BROMELIA.get(), "Violette Bromelie");
		this.add(IcariaBlocks.POTTED_PURPLE_BROMELIA.get(), "Eingetopfte violette Bromelie");

		this.add(IcariaBlocks.GREEN_GROUND_SHROOMS.get(), "Grüne Lamellenpilze");
		this.add(IcariaBlocks.POTTED_GREEN_GROUND_SHROOMS.get(), "Eingetopfte grüne Lamellenpilze");
		this.add(IcariaBlocks.BROWN_GROUND_SHROOMS.get(), "Braune Lamellenpilze");
		this.add(IcariaBlocks.POTTED_BROWN_GROUND_SHROOMS.get(), "Eingetopfte braune Lamellenpilze");
		this.add(IcariaBlocks.LARGE_BROWN_GROUND_SHROOMS.get(), "Großer brauner Röhrling");
		this.add(IcariaBlocks.POTTED_LARGE_BROWN_GROUND_SHROOMS.get(), "Eingetopfte großer brauner Röhrling");

		this.add(IcariaBlocks.TINDER_FUNGUS_TREE_SHROOMS.get(), "Zunderschwamm");
		this.add(IcariaBlocks.TURKEY_TAIL_TREE_SHROOMS.get(), "Schmetterlingstramete");
		this.add(IcariaBlocks.UNNAMED_TREE_SHROOMS.get(), "Unbenannter Pilz");

		this.add(IcariaBlocks.CARDON_CACTUS.get(), "Cardon Kaktus");
		this.add(IcariaBlocks.POTTED_CARDON_CACTUS.get(), "Eingetopfter Cardon Kaktus");

		this.add(IcariaBlocks.STRAWBERRY_BUSH.get(), "Erdbeerstrauch");

		this.add(IcariaBlocks.SPELT_CROP.get(), "Dinkel");
		this.add(IcariaBlocks.STRAWBERRY_CROP.get(), "Erdbeere");
		this.add(IcariaBlocks.PHYSALIS_CROP.get(), "Physalis");
		this.add(IcariaBlocks.ONION_CROP.get(), "Zwiebel");

		this.add(IcariaBlocks.MEDITERRANEAN_WATER.get(), "Mediterranes Wasser");

		this.add(IcariaBlocks.GREEK_FIRE.get(), "Griechisches Feuer");

		this.add(IcariaBlocks.ICARIA_PORTAL.get(), "Icaria Portal");

		// CATEGORIES
		this.add("category" + "." + IcariaInfo.ID + "." + "grinding", "Mahlen");
		this.add("category" + "." + IcariaInfo.ID + "." + "firing", "Brennen");

		// EFFECTS
		this.add(IcariaMobEffects.BLINDNESS_IMMUNITY.get(), "Erblindungsimmunität");
		this.add(IcariaMobEffects.LIFESTEAL.get(), "Lebensraub");

		// ENTITY TYPES
		this.add(IcariaEntityTypes.AETERNAE.get(), "Ätern");
		this.add(IcariaEntityTypes.ARACHNE.get(), "Arachne");
		this.add(IcariaEntityTypes.ARACHNE_DRONE.get(), "Arachnendrohne");
		this.add(IcariaEntityTypes.ARGAN_HOUND.get(), "Arganischer Hund");
		this.add(IcariaEntityTypes.BIDENT.get(), "Zweizack");
		this.add(IcariaEntityTypes.CATOBLEPAS.get(), "Katoblepas");
		this.add(IcariaEntityTypes.CERVER.get(), "Panther");
		this.add(IcariaEntityTypes.CYPRESS_FOREST_HAG.get(), "Zypressen-Baumwächter");
		this.add(IcariaEntityTypes.DROUGHTROOT_FOREST_HAG.get(), "Dürrwurzel-Baumwächter");
		this.add(IcariaEntityTypes.FIR_FOREST_HAG.get(), "Tannen-Baumwächter");
		this.add(IcariaEntityTypes.LAUREL_FOREST_HAG.get(), "Lorbeer-Baumwächter");
		this.add(IcariaEntityTypes.OLIVE_FOREST_HAG.get(), "Oliven-Baumwächter");
		this.add(IcariaEntityTypes.PLANE_FOREST_HAG.get(), "Plantanen-Baumwächter");
		this.add(IcariaEntityTypes.POPULUS_FOREST_HAG.get(), "Pappel-Baumwächter");
		this.add(IcariaEntityTypes.GREEK_FIRE_GRENADE.get(), "Griechische Feuergranate");
		this.add(IcariaEntityTypes.HYLIASTER.get(), "Hyliaster");
		this.add(IcariaEntityTypes.ENDER_JELLYFISH.get(), "Enderqualle");
		this.add(IcariaEntityTypes.FIRE_JELLYFISH.get(), "Feuerqualle");
		this.add(IcariaEntityTypes.NATURE_JELLYFISH.get(), "Naturqualle");
		this.add(IcariaEntityTypes.VOID_JELLYFISH.get(), "Leerenqualle");
		this.add(IcariaEntityTypes.WATER_JELLYFISH.get(), "Wasserqualle");
		this.add(IcariaEntityTypes.LOOT_VASE.get(), "Beutevase");
		this.add(IcariaEntityTypes.MYRMEKE_DRONE.get(), "Ameisendrohne");
		this.add(IcariaEntityTypes.MYRMEKE_SOLDIER.get(), "Ameisensoldat");
		this.add(IcariaEntityTypes.MYRMEKE_QUEEN.get(), "Ameisenkönigin");
		this.add(IcariaEntityTypes.CAPTAIN_REVENANT.get(), "Kommandanten-Wiedergänger");
		this.add(IcariaEntityTypes.CIVILIAN_REVENANT.get(), "Zivilisten-Wiedergänger");
		this.add(IcariaEntityTypes.CRAWLER_REVENANT.get(), "Kriechender Wiedergänger");
		this.add(IcariaEntityTypes.OVERGROWN_REVENANT.get(), "Bewachsener Wiedergänger");
		this.add(IcariaEntityTypes.PYROMANCER_REVENANT.get(), "Pyromanen-Wiedergänger");
		this.add(IcariaEntityTypes.NETHER_PYROMANCER_REVENANT.get(), "Netherpyromanen-Wiedergänger");
		this.add(IcariaEntityTypes.SOLDIER_REVENANT.get(), "Soldaten-Wiedergänger");
		this.add(IcariaEntityTypes.SCORPION.get(), "Skorpion");
		this.add(IcariaEntityTypes.CRYSTAL_SLUG.get(), "Kristall-Nacktschnecke");
		this.add(IcariaEntityTypes.FOREST_SNULL.get(), "Wald Snull");
		this.add(IcariaEntityTypes.SNULL.get(), "Snull");
		this.add(IcariaEntityTypes.SOLIFUGAE.get(), "Walzenspinne");
		this.add(IcariaEntityTypes.SOW.get(), "Krommyonische Sau");
		this.add(IcariaEntityTypes.VINEGAR.get(), "Essig");
		this.add(IcariaEntityTypes.VINEGAROON.get(), "Geißelskorpion");

		// FLUIDS
		this.add("fluid" + "." + IcariaInfo.ID + "." + "mediterranean_water", "Mediterranes Wasser");

		// ITEMS
		this.add(IcariaItems.BONE_REMAINS.get(), "Knochenreste");
		this.add(IcariaItems.LOAM_LUMP.get(), "Lehmklumpen");
		this.add(IcariaItems.LOAM_BRICK.get(), "Lehmziegel");
		this.add(IcariaItems.CHERT.get(), "Hornstein");
		this.add(IcariaItems.ENDER_JELLYFISH_JELLY.get(), "Ender-Quallengelee");
		this.add(IcariaItems.FIRE_JELLYFISH_JELLY.get(), "Feuer-Quallengelee");
		this.add(IcariaItems.NATURE_JELLYFISH_JELLY.get(), "Natur-Quallengelee");
		this.add(IcariaItems.VOID_JELLYFISH_JELLY.get(), "Leeren-Quallengelee");
		this.add(IcariaItems.WATER_JELLYFISH_JELLY.get(), "Wasser-Quallengelee");
		this.add(IcariaItems.ARACHNE_STRING.get(), "Arachnenfaden");
		this.add(IcariaItems.SPELT.get(), "Dinkel");
		this.add(IcariaItems.VINE_REED.get(), "Weinschilf");
		this.add(IcariaItems.VINE_SPROUT.get(), "Rankensprosse");
		this.add(IcariaItems.ROTTEN_BONES.get(), "Verrottete Knochen");
		this.add(IcariaItems.CALCITE_SHARD.get(), "Calcitscherbe");
		this.add(IcariaItems.HALITE_SHARD.get(), "Halitscherbe");
		this.add(IcariaItems.JASPER_SHARD.get(), "Jaspisscherbe");
		this.add(IcariaItems.ZIRCON_SHARD.get(), "Zirkonscherbe");
		this.add(IcariaItems.CALCITE_DUST.get(), "Calcit-Staub");
		this.add(IcariaItems.HALITE_DUST.get(), "Halit-Staub");
		this.add(IcariaItems.LIGNITE.get(), "Braunkohle");
		this.add(IcariaItems.RAW_CHALKOS.get(), "Rohkuffar");
		this.add(IcariaItems.RAW_KASSITEROS.get(), "Rohgalmei");
		this.add(IcariaItems.DOLOMITE.get(), "Dolomit");
		this.add(IcariaItems.RAW_VANADIUM.get(), "Rohvanadin");
		this.add(IcariaItems.SLIVER.get(), "Slibber");
		this.add(IcariaItems.RAW_SIDEROS.get(), "Rohschirbel");
		this.add(IcariaItems.ANTHRACITE.get(), "Schwarzkohle");
		this.add(IcariaItems.RAW_MOLYBDENUM.get(), "Rohmolybdän");

		this.add(IcariaItems.CHALKOS_NUGGET.get(), "Kuffarklumpen");
		this.add(IcariaItems.KASSITEROS_NUGGET.get(), "Galmeiklumpen");
		this.add(IcariaItems.ORICHALCUM_NUGGET.get(), "Goldmessingklumpen");
		this.add(IcariaItems.VANADIUM_NUGGET.get(), "Vanadinklumpen");
		this.add(IcariaItems.VANADIUMSTEEL_NUGGET.get(), "Vanadinstahlklumpen");
		this.add(IcariaItems.SIDEROS_NUGGET.get(), "Schirbelklumpen");
		this.add(IcariaItems.MOLYBDENUM_NUGGET.get(), "Molybdänklumpen");
		this.add(IcariaItems.MOLYBDENUMSTEEL_NUGGET.get(), "Molybdänstahlklumpen");
		this.add(IcariaItems.BLURIDIUM_NUGGET.get(), "Bluritklumpen");

		this.add(IcariaItems.CHALKOS_INGOT.get(), "Kuffarbarren");
		this.add(IcariaItems.KASSITEROS_INGOT.get(), "Galmeibarren");
		this.add(IcariaItems.ORICHALCUM_INGOT.get(), "Goldmessingbarren");
		this.add(IcariaItems.VANADIUM_INGOT.get(), "Vanadinbarren");
		this.add(IcariaItems.VANADIUMSTEEL_INGOT.get(), "Vanadinstahlbarren");
		this.add(IcariaItems.SIDEROS_INGOT.get(), "Schirbelbarren");
		this.add(IcariaItems.MOLYBDENUM_INGOT.get(), "Molybdänbarren");
		this.add(IcariaItems.MOLYBDENUMSTEEL_INGOT.get(), "Molybdänstahlbarren");
		this.add(IcariaItems.BLURIDIUM_INGOT.get(), "Bluritbarren");

		this.add(IcariaItems.CHERT_TOOLS.sword.get(), "Hornsteinschwert");
		this.add(IcariaItems.CHERT_TOOLS.dagger.get(), "Hornsteindolch");
		this.add(IcariaItems.CHERT_TOOLS.shovel.get(), "Hornsteinschaufel");
		this.add(IcariaItems.CHERT_TOOLS.pickaxe.get(), "Hornsteinspitzhacke");
		this.add(IcariaItems.CHERT_TOOLS.axe.get(), "Hornsteinaxt");
		this.add(IcariaItems.CHERT_TOOLS.scythe.get(), "Hornsteinsense");
		this.add(IcariaItems.CHERT_TOOLS.bident.get(), "Hornsteinspeer");
		this.add(IcariaItems.CHALKOS_TOOLS.sword.get(), "Kuffarschwert");
		this.add(IcariaItems.CHALKOS_TOOLS.dagger.get(), "Kuffardolch");
		this.add(IcariaItems.CHALKOS_TOOLS.shovel.get(), "Kuffarschaufel");
		this.add(IcariaItems.CHALKOS_TOOLS.pickaxe.get(), "Kuffarspitzhacke");
		this.add(IcariaItems.CHALKOS_TOOLS.axe.get(), "Kuffaraxt");
		this.add(IcariaItems.CHALKOS_TOOLS.scythe.get(), "Kuffarsense");
		this.add(IcariaItems.CHALKOS_TOOLS.bident.get(), "Kuffarzweizack");
		this.add(IcariaItems.KASSITEROS_TOOLS.sword.get(), "Galmeischwert");
		this.add(IcariaItems.KASSITEROS_TOOLS.dagger.get(), "Galmeidolch");
		this.add(IcariaItems.KASSITEROS_TOOLS.shovel.get(), "Galmeischaufel");
		this.add(IcariaItems.KASSITEROS_TOOLS.pickaxe.get(), "Galmeispitzhacke");
		this.add(IcariaItems.KASSITEROS_TOOLS.axe.get(), "Galmeiaxt");
		this.add(IcariaItems.KASSITEROS_TOOLS.scythe.get(), "Galmeisense");
		this.add(IcariaItems.KASSITEROS_TOOLS.bident.get(), "Galmeizweizack");
		this.add(IcariaItems.ORICHALCUM_TOOLS.sword.get(), "Goldmessingschwert");
		this.add(IcariaItems.ORICHALCUM_TOOLS.dagger.get(), "Goldmessingdolch");
		this.add(IcariaItems.ORICHALCUM_TOOLS.shovel.get(), "Goldmessingschaufel");
		this.add(IcariaItems.ORICHALCUM_TOOLS.pickaxe.get(), "Goldmessingspitzhacke");
		this.add(IcariaItems.ORICHALCUM_TOOLS.axe.get(), "Goldmessingaxt");
		this.add(IcariaItems.ORICHALCUM_TOOLS.scythe.get(), "Goldmessingsense");
		this.add(IcariaItems.ORICHALCUM_TOOLS.bident.get(), "Goldmessingzweizack");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.sword.get(), "Vanadinstahlschwert");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.dagger.get(), "Vanadinstahldolch");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.shovel.get(), "Vanadinstahlschaufel");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.pickaxe.get(), "Vanadinstahlspitzhacke");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.axe.get(), "Vanadinstahlaxt");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.scythe.get(), "Vanadinstahlsense");
		this.add(IcariaItems.VANADIUMSTEEL_TOOLS.bident.get(), "Vanadinstahlzweizack");
		this.add(IcariaItems.SIDEROS_TOOLS.sword.get(), "Schirbelschwert");
		this.add(IcariaItems.SIDEROS_TOOLS.dagger.get(), "Schirbeldolch");
		this.add(IcariaItems.SIDEROS_TOOLS.shovel.get(), "Schirbelschaufel");
		this.add(IcariaItems.SIDEROS_TOOLS.pickaxe.get(), "Schirbelspitzhacke");
		this.add(IcariaItems.SIDEROS_TOOLS.axe.get(), "Schirbelaxt");
		this.add(IcariaItems.SIDEROS_TOOLS.scythe.get(), "Schirbelsense");
		this.add(IcariaItems.SIDEROS_TOOLS.bident.get(), "Schirbelzweizack");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.sword.get(), "Molybdänstahlschwert");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.dagger.get(), "Molybdänstahldolch");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.shovel.get(), "Molybdänstahlschaufel");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.pickaxe.get(), "Molybdänstahlspitzhacke");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.axe.get(), "Molybdänstahlaxt");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.scythe.get(), "Molybdänstahlsense");
		this.add(IcariaItems.MOLYBDENUMSTEEL_TOOLS.bident.get(), "Molybdänstahlzweizack");

		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.helmet.get(), "Äternen Lederkappe");
		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.chestplate.get(), "Äternen Lederjacke");
		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.leggings.get(), "Äternen Lederhose");
		this.add(IcariaItems.AETERNAE_HIDE_ARMOR.boots.get(), "Äternen Lederstiefel");
		this.add(IcariaItems.CHALKOS_ARMOR.helmet.get(), "Kuffarhelm");
		this.add(IcariaItems.CHALKOS_ARMOR.chestplate.get(), "Kuffarharnisch");
		this.add(IcariaItems.CHALKOS_ARMOR.leggings.get(), "Kuffarbeinschutz");
		this.add(IcariaItems.CHALKOS_ARMOR.boots.get(), "Kuffarstiefel");
		this.add(IcariaItems.KASSITEROS_ARMOR.helmet.get(), "Galmeihelm");
		this.add(IcariaItems.KASSITEROS_ARMOR.chestplate.get(), "Galmeiharnisch");
		this.add(IcariaItems.KASSITEROS_ARMOR.leggings.get(), "Galmeibeinschutz");
		this.add(IcariaItems.KASSITEROS_ARMOR.boots.get(), "Galmeistiefel");
		this.add(IcariaItems.ORICHALCUM_HELMET.get(), "Goldmessinghelm");
		this.add(IcariaItems.ORICHALCUM_CHESTPLATE.get(), "Goldmessingharnisch");
		this.add(IcariaItems.ORICHALCUM_LEGGINGS.get(), "Goldmessingbeinschutz");
		this.add(IcariaItems.ORICHALCUM_BOOTS.get(), "Goldmessingstiefel");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.helmet.get(), "Vanadinstahlhelm");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.chestplate.get(), "Vanadinstahlharnisch");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.leggings.get(), "Vanadinstahlbeinschutz");
		this.add(IcariaItems.VANADIUMSTEEL_ARMOR.boots.get(), "Vanadinstahlstiefel");
		this.add(IcariaItems.LAUREL_WREATH.get(), "Lorbeerkranz");

		this.add(IcariaItems.GREEK_FIRE_GRENADE.get(), "Griechische Feuergranate");

		this.add(IcariaItems.TOTEM_OF_PREVENTATION.get(), "Totem der Totems");
		this.add(IcariaItems.TOTEM_OF_STUFFING.get(), "Totem der Sättigung");
		this.add(IcariaItems.TOTEM_OF_UNBLINDING.get(), "Totem der Sicht");
		this.add(IcariaItems.TOTEM_OF_UNDROWNING.get(), "Totem der Atemluft");
		this.add(IcariaItems.TOTEM_OF_UNDYING.get(), "Totem der Unsterblichkeit");
		this.add(IcariaItems.TOTEM_OF_UNSHATTERING.get(), "Totem der Stabilität");
		this.add(IcariaItems.TOTEM_OF_UNSINKING.get(), "Totem der Endlossturzes");

		this.add(IcariaItems.UNFIRED_STORAGE_VASE.get(), "Ungebrannte Speichervase");
		this.add(IcariaItems.WHITE_UNFIRED_STORAGE_VASE.get(), "Weiße ungebrannte Speichervase");
		this.add(IcariaItems.LIGHT_GRAY_UNFIRED_STORAGE_VASE.get(), "Hellgraue ungebrannte Speichervase");
		this.add(IcariaItems.GRAY_UNFIRED_STORAGE_VASE.get(), "Graue ungebrannte Speichervase");
		this.add(IcariaItems.BLACK_UNFIRED_STORAGE_VASE.get(), "Schwarze ungebrannte Speichervase");
		this.add(IcariaItems.BROWN_UNFIRED_STORAGE_VASE.get(), "Braune ungebrannte Speichervase");
		this.add(IcariaItems.RED_UNFIRED_STORAGE_VASE.get(), "Rote ungebrannte Speichervase");
		this.add(IcariaItems.ORANGE_UNFIRED_STORAGE_VASE.get(), "Orange ungebrannte Speichervase");
		this.add(IcariaItems.YELLOW_UNFIRED_STORAGE_VASE.get(), "Gelbe ungebrannte Speichervase");
		this.add(IcariaItems.LIME_UNFIRED_STORAGE_VASE.get(), "Hellgrüne ungebrannte Speichervase");
		this.add(IcariaItems.GREEN_UNFIRED_STORAGE_VASE.get(), "Grüne ungebrannte Speichervase");
		this.add(IcariaItems.CYAN_UNFIRED_STORAGE_VASE.get(), "Türkise ungebrannte Speichervase");
		this.add(IcariaItems.LIGHT_BLUE_UNFIRED_STORAGE_VASE.get(), "Hellblaue ungebrannte Speichervase");
		this.add(IcariaItems.BLUE_UNFIRED_STORAGE_VASE.get(), "Blaue ungebrannte Speichervase");
		this.add(IcariaItems.PURPLE_UNFIRED_STORAGE_VASE.get(), "Violette ungebrannte Speichervase");
		this.add(IcariaItems.MAGENTA_UNFIRED_STORAGE_VASE.get(), "Magenta ungebrannte Speichervase");
		this.add(IcariaItems.PINK_UNFIRED_STORAGE_VASE.get(), "Rosa ungebrannte Speichervase");

		this.add(IcariaItems.EMPTY_FLASK.get(), "Leere Flasche");

		this.add(IcariaItems.EMPTY_VIAL.get(), "Leere Phiole");
		this.add(IcariaItems.HYLIASTRUM_VIAL.get(), "Hyliastrum Phiole");

		this.add(IcariaItems.CHEST_LABEL.get(), "Kistenetikett");

		this.add(IcariaItems.YELLOWSTONE_GEAR.get(), "Gelbsteinmahlrad");
		this.add(IcariaItems.SMALL_YELLOWSTONE_GEAR.get(), "Kleines Gelbsteinmahlrad");
		this.add(IcariaItems.UNFIRED_LOAM_GEAR.get(), "Ungebranntes Lehmmahlrad");
		this.add(IcariaItems.LOAM_GEAR.get(), "Lehmmahlrad");
		this.add(IcariaItems.SMALL_LOAM_GEAR.get(), "Kleines Lehmmahlrad");
		this.add(IcariaItems.VOIDSHALE_GEAR.get(), "Leerenschiefermahlrad");
		this.add(IcariaItems.SMALL_VOIDSHALE_GEAR.get(), "Kleines Leerenschiefermahlrad");
		this.add(IcariaItems.VANADIUM_GEAR.get(), "Vanadinmahlrad");
		this.add(IcariaItems.SMALL_VANADIUM_GEAR.get(), "Kleines Vanadinmahlrad");
		this.add(IcariaItems.BLUE_GEARFRAGMENT.get(), "Blaues Mahlradfragment");
		this.add(IcariaItems.GREEN_GEARFRAGMENT.get(), "Grünes Mahlradfragment");
		this.add(IcariaItems.YELLOW_GEARFRAGMENT.get(), "Gelbes Mahlradfragment");
		this.add(IcariaItems.DAEDALIAN_GEAR.get(), "Dädalisches Mahlrad");
		this.add(IcariaItems.SMALL_DAEDALIAN_GEAR.get(), "Kleines dädalisches Mahlrad");

		this.add(IcariaItems.AETERNAE_HIDE.get(), "Äternen Leder");
		this.add(IcariaItems.SPELT_FLOUR.get(), "Dinkelmehl");
		this.add(IcariaItems.SPELT_BREAD.get(), "Dinkelbrot");
		this.add(IcariaItems.VINEBERRIES.get(), "Rankenbeeren");
		this.add(IcariaItems.STRAWBERRIES.get(), "Erdbeeren");
		this.add(IcariaItems.PHYSALIS.get(), "Physalis");
		this.add(IcariaItems.LAUREL_CHERRY.get(), "Lorbeerkirsche");
		this.add(IcariaItems.BLACK_OLIVES.get(), "Schwarze Oliven");
		this.add(IcariaItems.GREEN_OLIVES.get(), "Grüne Oliven");
		this.add(IcariaItems.GARLIC.get(), "Knoblauch");
		this.add(IcariaItems.ONION.get(), "Zwiebel");
		this.add(IcariaItems.RAW_AETERNAE_MEAT.get(), "Rohes Wildsteak");
		this.add(IcariaItems.COOKED_AETERNAE_MEAT.get(), "Gekochtes Wildsteak");
		this.add(IcariaItems.RAW_CATOBLEPAS_MEAT.get(), "Rohes Rumpsteak");
		this.add(IcariaItems.COOKED_CATOBLEPAS_MEAT.get(), "Gekochtes Rumpsteak");
		this.add(IcariaItems.RAW_CERVER_MEAT.get(), "Rohes Raubkatzenfleisch");
		this.add(IcariaItems.COOKED_CERVER_MEAT.get(), "Gekochtes Raubkatzenfleisch");
		this.add(IcariaItems.RAW_SOW_MEAT.get(), "Roher Schweinrücken");
		this.add(IcariaItems.COOKED_SOW_MEAT.get(), "Gekochter Schweinrücken");
		this.add(IcariaItems.MYRMEKE_SCALES.get(), "Ameisenschuppen");
		this.add(IcariaItems.SLUG_SCALES.get(), "Nacktschneckenschuppen");
		this.add(IcariaItems.SNULL_CREAM.get(), "Snull Creme");
		this.add(IcariaItems.VINEGAR.get(), "Essig");

		this.add(IcariaItems.UNFIRED_LOAM_BOWL.get(), "Ungebrannte Lehmschüssel");
		this.add(IcariaItems.LOAM_BOWL.get(), "Lehmschüssel");
		this.add(IcariaItems.FRUIT_SALAD.get(), "Obstsalat");
		this.add(IcariaItems.ONION_SOUP.get(), "Zwiebelsuppe");
		this.add(IcariaItems.AETERNAE_STEW.get(), "Wildeintopf");
		this.add(IcariaItems.CATOBLEPAS_STEW.get(), "Rindereintopf");
		this.add(IcariaItems.CERVER_STEW.get(), "Raubkatzeneintopf");
		this.add(IcariaItems.SOW_STEW.get(), "Schweineeintopf");

		this.add(IcariaItems.SPELT_SEEDS.get(), "Dinkelsamen");
		this.add(IcariaItems.STRAWBERRY_SEEDS.get(), "Erdbeersamen");
		this.add(IcariaItems.PHYSALIS_SEEDS.get(), "Physalissamen");

		this.add(IcariaItems.AETERNAE_SPAWN_EGG.get(), "Ätern-Spawn-Ei");
		this.add(IcariaItems.ARACHNE_SPAWN_EGG.get(), "Arachnendrohnen-Spawn-Ei");
		this.add(IcariaItems.ARACHNE_DRONE_SPAWN_EGG.get(), "Arachnen-Spawn-Ei");
		this.add(IcariaItems.ARGAN_HOUND_SPAWN_EGG.get(), "Arganischer Hund-Spawn-Ei");
		this.add(IcariaItems.CATOBLEPAS_SPAWN_EGG.get(), "Katoblepas-Spawn-Ei");
		this.add(IcariaItems.CERVER_SPAWN_EGG.get(), "Panther-Spawn-Ei");
		this.add(IcariaItems.CYPRESS_FOREST_HAG_SPAWN_EGG.get(), "Zypressen-Baumwächter-Spawn-Ei");
		this.add(IcariaItems.DROUGHTROOT_FOREST_HAG_SPAWN_EGG.get(), "Dürrwurzel-Baumwächter-Spawn-Ei");
		this.add(IcariaItems.FIR_FOREST_HAG_SPAWN_EGG.get(), "Tannen-Baumwächter-Spawn-Ei");
		this.add(IcariaItems.LAUREL_FOREST_HAG_SPAWN_EGG.get(), "Lorbeer-Baumwächter-Spawn-Ei");
		this.add(IcariaItems.OLIVE_FOREST_HAG_SPAWN_EGG.get(), "Oliven-Baumwächter-Spawn-Ei");
		this.add(IcariaItems.PLANE_FOREST_HAG_SPAWN_EGG.get(), "Plantanen-Baumwächter-Spawn-Ei");
		this.add(IcariaItems.POPULUS_FOREST_HAG_SPAWN_EGG.get(), "Pappel-Baumwächter-Spawn-Ei");
		this.add(IcariaItems.HYLIASTER_SPAWN_EGG.get(), "Hyliaster-Spawn-Ei");
		this.add(IcariaItems.ENDER_JELLYFISH_SPAWN_EGG.get(), "Ender-Quallen-Spawn-Ei");
		this.add(IcariaItems.FIRE_JELLYFISH_SPAWN_EGG.get(), "Feuer-Quallen-Spawn-Ei");
		this.add(IcariaItems.NATURE_JELLYFISH_SPAWN_EGG.get(), "Natur-Quallen-Spawn-Ei");
		this.add(IcariaItems.VOID_JELLYFISH_SPAWN_EGG.get(), "Leeren-Quallen-Spawn-Ei");
		this.add(IcariaItems.WATER_JELLYFISH_SPAWN_EGG.get(), "Wasser-Quallen-Spawn-Ei");
		this.add(IcariaItems.MYRMEKE_DRONE_SPAWN_EGG.get(), "Ameisendrohnen-Spawn-Ei");
		this.add(IcariaItems.MYRMEKE_SOLDIER_SPAWN_EGG.get(), "Ameisensoldat-Spawn-Ei");
		this.add(IcariaItems.MYRMEKE_QUEEN_SPAWN_EGG.get(), "Ameisenkönigin-Spawn-Ei");
		this.add(IcariaItems.CAPTAIN_REVENANT_SPAWN_EGG.get(), "Kommandanten-Wiedergänger-Spawn-Ei");
		this.add(IcariaItems.CIVILIAN_REVENANT_SPAWN_EGG.get(), "Zivilisten-Wiedergänger-Spawn-Ei");
		this.add(IcariaItems.CRAWLER_REVENANT_SPAWN_EGG.get(), "Kriechender-Wiedergänger-Spawn-Ei");
		this.add(IcariaItems.OVERGROWN_REVENANT_SPAWN_EGG.get(), "Bewachsener-Wiedergänger-Spawn-Ei");
		this.add(IcariaItems.PYROMANCER_REVENANT_SPAWN_EGG.get(), "Pyromanen-Wiedergänger-Spawn-Ei");
		this.add(IcariaItems.NETHER_PYROMANCER_REVENANT_SPAWN_EGG.get(), "Netherpyromanen-Wiedergänger-Spawn-Ei");
		this.add(IcariaItems.SOLDIER_REVENANT_SPAWN_EGG.get(), "Soldaten-Wiedergänger-Spawn-Ei");
		this.add(IcariaItems.SCORPION_SPAWN_EGG.get(), "Skorpion-Spawn-Ei");
		this.add(IcariaItems.CRYSTAL_SLUG_SPAWN_EGG.get(), "Kristall-Nacktschnecken-Spawn-Ei");
		this.add(IcariaItems.FOREST_SNULL_SPAWN_EGG.get(), "Wald Snull Spawn Egg");
		this.add(IcariaItems.SNULL_SPAWN_EGG.get(), "Snull Spawn-Ei");
		this.add(IcariaItems.SOLIFUGAE_SPAWN_EGG.get(), "Walzenspinnen-Spawn-Ei");
		this.add(IcariaItems.SOW_SPAWN_EGG.get(), "Krommyonische Sau-Spawn-Ei");
		this.add(IcariaItems.VINEGAROON_SPAWN_EGG.get(), "Geißelskorpion-Spawn-Ei");

		this.add(IcariaItems.MEDITERRANEAN_WATER_BUCKET.get(), "Eimer mit mediterranem Wasser");

		// ITEM GROUPS
		this.add("itemgroup" + "." + IcariaInfo.ID + "." + "blocks", "Lands of Icaria Blöcke");
		this.add("itemgroup" + "." + IcariaInfo.ID + "." + "flora", "Lands of Icaria Flora");
		this.add("itemgroup" + "." + IcariaInfo.ID + "." + "items", "Lands of Icaria Gegenstände");

		// MENU TYPES
		this.add("menu" + "." + IcariaInfo.ID + "." + "grinder", "Mühle");
		this.add("menu" + "." + IcariaInfo.ID + "." + "kiln", "Töpferofen");
		this.add("menu" + "." + IcariaInfo.ID + "." + "storage_vase", "Speichervase");

		// MESSAGES
		this.add("message" + "." + IcariaInfo.ID + "." + "chest_label", "Name des Kistenetiketts zu lang");
		this.add("message" + "." + IcariaInfo.ID + "." + "loot_vase", "Schleichen zum Werfen der Beutevase");
	}
}
