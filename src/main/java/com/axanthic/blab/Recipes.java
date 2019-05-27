package com.axanthic.blab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import com.axanthic.blab.Resources.ArmorSet;
import com.axanthic.blab.Resources.StairSlabPair;
import com.axanthic.blab.Resources.ToolSet;
import com.axanthic.blab.Resources.WoodSet;
import com.axanthic.blab.blocks.BlockRock;
import com.axanthic.blab.blocks.BlockStorageGem;
import com.axanthic.blab.blocks.BlockStorageMetal;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

public class Recipes {

	static ResourceLocation group = new ResourceLocation("");

	public static Map<String, ItemStack> grindingRecipes = new HashMap<String, ItemStack>();
	public static Map<String, Integer> grinderFuel = new HashMap<String, Integer>();

	public static Map<Collection<String>, ItemStack> forgeRecipes = new HashMap<Collection<String>, ItemStack>();
	public static Collection<String> forgeIngredients = new ArrayList<String>();

	public static void registerRecipes() {
		addForgeRecipe(new ItemStack(Resources.ingot, 3, 3), new ItemStack(Resources.ingot, 1, 1), new ItemStack(Resources.ingot, 1, 0), new ItemStack(Resources.ingot, 1, 0));
		addForgeRecipe(new ItemStack(Resources.ingot, 2, 6), new ItemStack(Resources.ingot, 1, 1), new ItemStack(Resources.ingot, 1, 5), new ItemStack(Resources.resource, 1, 0));
		addForgeRecipe(new ItemStack(Resources.ingot, 2, 9), new ItemStack(Resources.ingot, 1, 7), new ItemStack(Resources.ingot, 1, 8), new ItemStack(Resources.resource, 1, 2));

		addGrinderRecipe(new ItemStack(Resources.resource, 1, 8), new ItemStack(Resources.resource, 1, 5));
		addGrinderRecipe(new ItemStack(Resources.resource, 1, 9), new ItemStack(Resources.resource, 1, 7));

		addGrinderFuel(new ItemStack(Items.BLAZE_POWDER), 1600);

		addRecipe(new ItemStack(Resources.laurelWreath), "laurel_wreath", new Object[]{"LLL", "L L", 'L', Resources.laurel.leaf});

		addRecipe(new ItemStack(Resources.aristonePacked), "packed_aristone", new Object[]{"AAA", "AAA", "AAA", 'A', Resources.aristone});

		addRecipe(new ItemStack(Resources.soil, 1, 1), "course_marl", new Object[]{"GS", "SG", 'G', Resources.grainelSand, 'S', new ItemStack(Resources.soil, 1, 0)});

		addRecipe(new ItemStack(Resources.soil, 1, 2), "loam_block", new Object[]{"LL", "LL", 'L', new ItemStack(Resources.resource, 1, 10)});
		addRecipe(new ItemStack(Resources.resource, 4, 10), "loam_lump", new Object[]{"L", 'L', new ItemStack(Resources.soil, 1, 2)});
		addRecipe(new ItemStack(Resources.resource, 1, 11), "loam_vase", new Object[]{"LLL", "L L", "LLL", 'L', new ItemStack(Resources.resource, 1, 10)});
		GameRegistry.addSmelting(new ItemStack(Resources.resource, 1, 11), new ItemStack(Resources.storageVase, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.resource, 1, 10), new ItemStack(Resources.resource, 1, 12), 0.1F);
		addRecipe(new ItemStack(Resources.loamBricks, 1, 0), "loam_bricks", new Object[]{"BB", "BB", 'B', new ItemStack(Resources.resource, 1, 12)});

		addRecipe(new ItemStack(Resources.kiln, 1, 0), "kiln_rock", new Object[]{"SSS", "S S", "SSS", 'S', new ItemStack(Resources.rock, 1, 0)});
		addRecipe(new ItemStack(Resources.kiln, 1, 0), "kiln_brick", new Object[]{"BBB", "B B", "BBB", 'B', new ItemStack(Resources.brick, 1, 0)});
		addRecipe(new ItemStack(Resources.grinder, 1, 0), "grinder_rock", new Object[]{"SSS", "SIS", "SSS", 'S', new ItemStack(Resources.rock, 1, 2), 'I', "ingotOrichalcum"});
		addRecipe(new ItemStack(Resources.grinder, 1, 0), "grinder_brick", new Object[]{"BBB", "BIB", "BBB", 'B', new ItemStack(Resources.brick, 1, 2), 'I', "ingotOrichalcum"});
		addRecipe(new ItemStack(Resources.forge, 1, 0), "forge", new Object[]{"LGL", "L L", "LGL", 'L', new ItemStack(Resources.loamBricks, 1, 0), 'G', new ItemStack(Resources.grainelStone, 1, 1)});

		addRecipe(new ItemStack(Resources.silkstoneSand, 1, 0), "silkstone_sand", new Object[]{"PP", "PP", 'P', new ItemStack(Resources.resource, 1, 4)});
		GameRegistry.addSmelting(new ItemStack(Resources.silkstoneSand, 1, 0), new ItemStack(Resources.rock, 1, 1), 0.1F);

		addRecipe(new ItemStack(Resources.grainelStone, 1, 0), "grainel_stone", new Object[]{"GG", "GG", 'G', new ItemStack(Resources.grainelSand, 1, 0)});
		addRecipe(new ItemStack(Resources.grainelStone, 4, 1), "grainel_stone_bricks", new Object[]{"GG", "GG", 'G', new ItemStack(Resources.grainelStone, 1, 0)});
		addRecipe(new ItemStack(Resources.grainelStone, 4, 2), "grainel_stone_bricks_chiseled", new Object[]{"S", "S", 'S', new ItemStack(Resources.grainiteBricks.slab, 1, 0)});
		GameRegistry.addSmelting(new ItemStack(Resources.grainelSand, 1, 0), new ItemStack(Resources.grainelGlass, 1, 0), 0.1F);
		addRecipe(new ItemStack(Resources.grainelGlassPane, 16, 0), "grainel_glass_pane", new Object[]{"GGG", "GGG", 'G', new ItemStack(Resources.grainelGlass, 1, 0)});

		GameRegistry.addSmelting(new ItemStack(Resources.rock, 1, 5), new ItemStack(Resources.relicstone, 1, 0), 0.1F);
		GameRegistry.addSmelting(new ItemStack(Resources.brick, 1, 5), new ItemStack(Resources.relicstone, 1, 1), 0.1F);
		addShapelessRecipe(new ItemStack(Resources.relicstone, 1, 2), "relicstone_bricks_mossy", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.brick, 1, 5)), new OreIngredient("vine")});
		addRecipe(new ItemStack(Resources.relicstone, 4, 4), "relicstone_tiles", new Object[]{"BB", "BB", 'B', new ItemStack(Resources.brick, 1, 5)});
		GameRegistry.addSmelting(new ItemStack(Resources.relicstone, 1, 4), new ItemStack(Resources.relicstone, 1, 5), 0.1F);
		addShapelessRecipe(new ItemStack(Resources.relicstone, 1, 6), "relicstone_tiles_mossy", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.relicstone, 1, 4)), new OreIngredient("vine")});
		addRecipe(new ItemStack(Resources.relicstone, 1, 8), "relicstone_chiseled", new Object[]{"S", "S", 'S', new ItemStack(Resources.relicstoneStone.slab, 1, 0)});
		addRecipe(new ItemStack(Resources.pillar, 2, 0), "relicstone_pillar", new Object[]{"B", "B", 'B', new ItemStack(Resources.brick, 1, 5)});
		addRecipe(new ItemStack(Resources.pillarHead, 2, 0), "relicstone_pillar_head", new Object[]{"T", "P", 'P', new ItemStack(Resources.pillar, 1, 0), 'T', new ItemStack(Resources.relicstone, 1, 4)});

		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 0), new ItemStack(Resources.resource, 1, 0), 0.1F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 1), new ItemStack(Resources.ingot, 1, 0), 0.3F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 2), new ItemStack(Resources.ingot, 1, 1), 0.4F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 3), new ItemStack(Resources.resource, 1, 1), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 4), new ItemStack(Resources.ingot, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 5), new ItemStack(Resources.ingot, 1, 5), 0.6F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 6), new ItemStack(Resources.ingot, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 7), new ItemStack(Resources.ingot, 1, 7), 0.8F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 8), new ItemStack(Resources.resource, 1, 2), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 9), new ItemStack(Resources.ingot, 1, 8), 0.9F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 10), new ItemStack(Resources.ingot, 1, 10), 1.0F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 12), new ItemStack(Resources.resource, 1, 3), 0.5F);

		for (int i = 0; i < BlockRock.StoneTypes.getNames().length; i++) {
			addRecipe(new ItemStack(Resources.brick, 4, i), BlockRock.StoneTypes.getNames()[i] + "_bricks", new Object[]{"RR", "RR", 'R', new ItemStack(Resources.rock, 1, i)});
		}

		for (int i = 0; i < BlockStorageMetal.MetalTypes.getNames().length; i++) {
			String name = BlockStorageMetal.MetalTypes.getNames()[i];
			String metal = upCase(name);
			addRecipe(new ItemStack(Resources.ingot, 1, i), name + "_unnugget", new Object[]{"NNN", "NNN", "NNN", 'N', "nugget" + metal});
			addRecipe(new ItemStack(Resources.metalBlock, 1, i), name + "_block", new Object[]{"III", "III", "III", 'I', "ingot" + metal});
			addRecipe(new ItemStack(Resources.nugget, 9, i), name + "_nugget", new Object[]{"I", 'I', "ingot" + metal});
			addRecipe(new ItemStack(Resources.ingot, 9, i), name + "_unblock", new Object[]{"B", 'B', "block" + metal});
		}

		for (int i = 0; i < BlockStorageGem.GemTypes.getNames().length; i++) {
			String name = BlockStorageGem.GemTypes.getNames()[i];
			String gem = upCase(name);
			addRecipe(new ItemStack(Resources.gemBlock, 1, i), name + "_block", new Object[]{"III", "III", "III", 'I', "gem" + gem});
			addRecipe(new ItemStack(Resources.resource, 9, i + 5), name + "_unblock", new Object[]{"B", 'B', "block" + gem});
		}

		registerWoodRecipe(Resources.plane);
		registerWoodRecipe(Resources.populus);
		registerWoodRecipe(Resources.cypress);
		registerWoodRecipe(Resources.fir);
		registerWoodRecipe(Resources.olive);
		registerWoodRecipe(Resources.laurel);
		registerWoodRecipe(Resources.droughtroot);

		registerSlabStairRecipe(Resources.yellowstoneStone);
		registerSlabStairRecipe(Resources.silkstoneStone);
		registerSlabStairRecipe(Resources.sunstoneStone);
		registerSlabStairRecipe(Resources.voidshaleStone);
		registerSlabStairRecipe(Resources.baetylStone);
		registerSlabStairRecipe(Resources.relicstoneStone);
		registerSlabStairRecipe(Resources.yellowstoneBrick);
		registerSlabStairRecipe(Resources.silkstoneBrick);
		registerSlabStairRecipe(Resources.sunstoneBrick);
		registerSlabStairRecipe(Resources.voidshaleBrick);
		registerSlabStairRecipe(Resources.baetylBrick);
		registerSlabStairRecipe(Resources.relicstoneBrick);
		registerSlabStairRecipe(Resources.relicstoneSmooth);
		registerSlabStairRecipe(Resources.relicstoneCrackBrick);
		registerSlabStairRecipe(Resources.relicstoneMossBrick);
		registerSlabStairRecipe(Resources.relicstoneTile);
		registerSlabStairRecipe(Resources.relicstoneCrackTile);
		registerSlabStairRecipe(Resources.relicstoneMossTile);
		registerSlabStairRecipe(Resources.grainiteStone);
		registerSlabStairRecipe(Resources.grainiteBricks);
		registerSlabStairRecipe(Resources.loamBrick);

		registerToolRecipe(Resources.chalkos);
		registerToolRecipe(Resources.kassiteros);
		registerToolRecipe(Resources.orichalcum);
		registerToolRecipe(Resources.vanadiumsteel);
		registerToolRecipe(Resources.sideros);
		registerToolRecipe(Resources.molybdenumsteel);

		registerArmorRecipe(Resources.chalkosArmor);
		registerArmorRecipe(Resources.kassiterosArmor);
		registerArmorRecipe(Resources.orichalcumArmor);
		registerArmorRecipe(Resources.vanadiumArmor);
	}

	public static void registerWoodRecipe(WoodSet set) {
		int meta = set.type.meta;
		addRecipe(new ItemStack(Resources.planks, 4, meta), set.type.unlocalizedName + "_planks", new Object[]{"L", 'L', set.log});
		addRecipe(new ItemStack(Resources.planks, 4, meta), set.type.unlocalizedName + "_stripped_planks", new Object[]{"L", 'L', set.strippedLog});
		GameRegistry.addSmelting(set.log, new ItemStack(Items.COAL, 1, 1), 0.1F);
		GameRegistry.addSmelting(set.strippedLog, new ItemStack(Items.COAL, 1, 1), 0.1F);
		addRecipe(new ItemStack(set.fence, 3), set.type.unlocalizedName + "_fence", new Object[]{"PSP", "PSP", 'S', "stickWood", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.fenceGate, 3), set.type.unlocalizedName + "_fence_gate", new Object[]{"SPS", "SPS", 'S', "stickWood", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.slab, 6), set.type.unlocalizedName + "_slab", new Object[]{"PPP", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.stairs, 4), set.type.unlocalizedName + "_stairs", new Object[]{"P  ", "PP ", "PPP", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.door, 3), set.type.unlocalizedName + "_door", new Object[]{"PP", "PP", "PP", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.trapdoor, 2), set.type.unlocalizedName + "_trapdoor", new Object[]{"PPP", "PPP", 'P', new ItemStack(Resources.planks, 1, meta)});
	}

	public static void registerSlabStairRecipe(StairSlabPair set) {
		ItemStack base = new ItemStack(set.baseItem, 1, set.baseMeta);
		addRecipe(new ItemStack(set.slab, 6), set.name + "_slab", new Object[]{"BBB", 'B', base});
		addRecipe(new ItemStack(set.stairs, 4), set.name + "_stairs", new Object[]{"B  ", "BB ", "BBB", 'B', base});
	}

	public static void registerToolRecipe(ToolSet set) {
		ItemStack material = set.bident.material.material.getRepairItemStack();
		String name = set.bident.material.material.name();
		addRecipe(new ItemStack(set.axe), name + "_axe", new Object[]{"MM", "MB", " B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.pickaxe), name + "_pickaxe", new Object[]{"MMM", " B ", " B ", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.shovel), name + "_shovel", new Object[]{"M", "B", "B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.sword), name + "_sword", new Object[]{"M", "M", "B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.dagger), name + "_dagger", new Object[]{"M", "B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.bident), name + "_bident", new Object[]{"M M", " B ", " B ", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.scythe), name + "_scythe", new Object[]{" MM", "M B", "  B", 'M', material, 'B', Items.BONE});
	}

	public static void registerArmorRecipe(ArmorSet set) {
		ItemStack material = set.material.getRepairItemStack();
		addRecipe(new ItemStack(set.helmet), set.material.getName() + "_helmet", new Object[]{"MMM", "M M", 'M', material});
		addRecipe(new ItemStack(set.chestplate), set.material.getName() + "_chestplate", new Object[]{"M M", "MMM", "MMM", 'M', material});
		addRecipe(new ItemStack(set.leggings), set.material.getName() + "_leggings", new Object[]{"MMM", "M M", "M M", 'M', material});
		addRecipe(new ItemStack(set.boots), set.material.getName() + "_boots", new Object[]{"M M", "M M", 'M', material});
	}

	public static void addRecipe(@Nonnull ItemStack output, String name, Object... params) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), group, output, params);
	}

	public static void addShapelessRecipe(@Nonnull ItemStack output, String name, Ingredient... params) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), group, output, params);
	}

	public static void addGrinderRecipe(ItemStack output, ItemStack input) {
		grindingRecipes.put(input.getItem().getRegistryName().toString() + ":" + input.getMetadata(), output);
	}

	public static void addGrinderFuel(ItemStack fuel, int burnTime) {
		grinderFuel.put(fuel.getItem().getRegistryName().toString() + ":" + fuel.getMetadata(), burnTime);
	}

	public static void addForgeRecipe(ItemStack output, ItemStack input1, ItemStack input2, ItemStack input3) {
		Collection ingredients  = new ArrayList(Arrays.asList(input1.getItem().getRegistryName().toString() + ":" + input1.getMetadata(), input2.getItem().getRegistryName().toString() + ":" + input2.getMetadata(), input3.getItem().getRegistryName().toString() + ":" + input3.getMetadata()));
		forgeIngredients.addAll(ingredients);
		forgeRecipes.put(ingredients,  output);
	}

	public static String upCase(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	public static void registerOredict() {
		OreDictionary.registerOre("oreLignite", new ItemStack(Resources.ore, 1, 0));
		OreDictionary.registerOre("oreChalkos", new ItemStack(Resources.ore, 1, 1));
		OreDictionary.registerOre("oreKassiteros", new ItemStack(Resources.ore, 1, 2));
		OreDictionary.registerOre("oreDolomite", new ItemStack(Resources.ore, 1, 3));
		OreDictionary.registerOre("oreMolibos", new ItemStack(Resources.ore, 1, 4));
		OreDictionary.registerOre("oreVanadium", new ItemStack(Resources.ore, 1, 5));
		OreDictionary.registerOre("oreSliver", new ItemStack(Resources.ore, 1, 6));
		OreDictionary.registerOre("oreSideros", new ItemStack(Resources.ore, 1, 7));
		OreDictionary.registerOre("oreAnthracite", new ItemStack(Resources.ore, 1, 8));
		OreDictionary.registerOre("oreMolybdenum", new ItemStack(Resources.ore, 1, 9));
		OreDictionary.registerOre("oreBluridium", new ItemStack(Resources.ore, 1, 10));
		OreDictionary.registerOre("oreHyliastrum", new ItemStack(Resources.ore, 1, 11));
		OreDictionary.registerOre("oreAbyssalEssence", new ItemStack(Resources.ore, 1, 12));

		OreDictionary.registerOre("ingotChalkos", new ItemStack(Resources.ingot, 1, 0));
		OreDictionary.registerOre("ingotKassiteros", new ItemStack(Resources.ingot, 1, 1));
		OreDictionary.registerOre("ingotMolibos", new ItemStack(Resources.ingot, 1, 2));
		OreDictionary.registerOre("ingotOrichalcum", new ItemStack(Resources.ingot, 1, 3));
		OreDictionary.registerOre("ingotSliver", new ItemStack(Resources.ingot, 1, 4));
		OreDictionary.registerOre("ingotVanadium", new ItemStack(Resources.ingot, 1, 5));
		OreDictionary.registerOre("ingotVanadiumSteel", new ItemStack(Resources.ingot, 1, 6));
		OreDictionary.registerOre("ingotSideros", new ItemStack(Resources.ingot, 1, 7));
		OreDictionary.registerOre("ingotMolybdenum", new ItemStack(Resources.ingot, 1, 8));
		OreDictionary.registerOre("ingotMolybdenumSteel", new ItemStack(Resources.ingot, 1, 9));
		OreDictionary.registerOre("ingotBluridium", new ItemStack(Resources.ingot, 1, 10));

		OreDictionary.registerOre("nuggetChalkos", new ItemStack(Resources.nugget, 1, 0));
		OreDictionary.registerOre("nuggetKassiteros", new ItemStack(Resources.nugget, 1, 1));
		OreDictionary.registerOre("nuggetMolibos", new ItemStack(Resources.nugget, 1, 2));
		OreDictionary.registerOre("nuggetOrichalcum", new ItemStack(Resources.nugget, 1, 3));
		OreDictionary.registerOre("nuggetSliver", new ItemStack(Resources.nugget, 1, 4));
		OreDictionary.registerOre("nuggetVanadium", new ItemStack(Resources.nugget, 1, 5));
		OreDictionary.registerOre("nuggetVanadiumSteel", new ItemStack(Resources.nugget, 1, 6));
		OreDictionary.registerOre("nuggetSideros", new ItemStack(Resources.nugget, 1, 7));
		OreDictionary.registerOre("nuggetMolybdenum", new ItemStack(Resources.nugget, 1, 8));
		OreDictionary.registerOre("nuggetMolybdenumSteel", new ItemStack(Resources.nugget, 1, 9));
		OreDictionary.registerOre("nuggetBluridium", new ItemStack(Resources.nugget, 1, 10));

		OreDictionary.registerOre("blockChalkos", new ItemStack(Resources.metalBlock, 1, 0));
		OreDictionary.registerOre("blockKassiteros", new ItemStack(Resources.metalBlock, 1, 1));
		OreDictionary.registerOre("blockMolibos", new ItemStack(Resources.metalBlock, 1, 2));
		OreDictionary.registerOre("blockOrichalcum", new ItemStack(Resources.metalBlock, 1, 3));
		OreDictionary.registerOre("blockSliver", new ItemStack(Resources.metalBlock, 1, 4));
		OreDictionary.registerOre("blockVanadium", new ItemStack(Resources.metalBlock, 1, 5));
		OreDictionary.registerOre("blockVanadiumSteel", new ItemStack(Resources.metalBlock, 1, 6));
		OreDictionary.registerOre("blockSideros", new ItemStack(Resources.metalBlock, 1, 7));
		OreDictionary.registerOre("blockMolybdenum", new ItemStack(Resources.metalBlock, 1, 8));
		OreDictionary.registerOre("blockMolybdenumSteel", new ItemStack(Resources.metalBlock, 1, 9));
		OreDictionary.registerOre("blockBluridium", new ItemStack(Resources.metalBlock, 1, 10));

		OreDictionary.registerOre("gemLignite", new ItemStack(Resources.resource, 1, 0));
		OreDictionary.registerOre("gemDolomite", new ItemStack(Resources.resource, 1, 1));
		OreDictionary.registerOre("gemAnthracite", new ItemStack(Resources.resource, 1, 2));
		OreDictionary.registerOre("dustAbyssalEssence", new ItemStack(Resources.resource, 1, 3));
		OreDictionary.registerOre("dustSilkstone", new ItemStack(Resources.resource, 1, 4));
		OreDictionary.registerOre("gemCalcite", new ItemStack(Resources.resource, 1, 5));
		OreDictionary.registerOre("gemJasper", new ItemStack(Resources.resource, 1, 6));
		OreDictionary.registerOre("gemZircon", new ItemStack(Resources.resource, 1, 7));
		OreDictionary.registerOre("dustCalcite", new ItemStack(Resources.resource, 1, 8));
		OreDictionary.registerOre("gemPolishedZircon", new ItemStack(Resources.resource, 1, 9));

		OreDictionary.registerOre("sand", new ItemStack(Resources.silkstoneSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockSand", new ItemStack(Resources.silkstoneSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("sand", new ItemStack(Resources.grainelSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockSand", new ItemStack(Resources.grainelSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("sandstone", new ItemStack(Resources.grainelStone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockSandstone", new ItemStack(Resources.grainelStone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockGlass", new ItemStack(Resources.grainelGlass, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(Resources.grainelGlassPane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stone", new ItemStack(Resources.relicstone, 1, 0));
		OreDictionary.registerOre("blockStone", new ItemStack(Resources.relicstone, 1, 0));

		OreDictionary.registerOre("blockCalcite", new ItemStack(Resources.gemBlock, 1, 0));
		OreDictionary.registerOre("blockJasper", new ItemStack(Resources.gemBlock, 1, 1));
		OreDictionary.registerOre("blockZircon", new ItemStack(Resources.gemBlock, 1, 2));

		OreDictionary.registerOre("plankWood", new ItemStack(Resources.planks, 1, OreDictionary.WILDCARD_VALUE));
		registerWoodOredict(Resources.plane);
		registerWoodOredict(Resources.populus);
		registerWoodOredict(Resources.cypress);
		registerWoodOredict(Resources.fir);
		registerWoodOredict(Resources.olive);
		registerWoodOredict(Resources.laurel);
		registerWoodOredict(Resources.droughtroot);
	}

	public static void registerWoodOredict(WoodSet set) {
		OreDictionary.registerOre("logWood", new ItemStack(set.log, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("logWood", new ItemStack(set.strippedLog, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeSapling", new ItemStack(set.sapling, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(set.leaf, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("fenceWood", new ItemStack(set.fence, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("fenceGateWood", new ItemStack(set.fenceGate, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("slabWood", new ItemStack(set.slab, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stairWood", new ItemStack(set.stairs, 1, OreDictionary.WILDCARD_VALUE));
	}
}
