package com.axanthic.blab;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.blab.blocks.BlockBasic;
import com.axanthic.blab.blocks.BlockFlower;
import com.axanthic.blab.blocks.BlockGem;
import com.axanthic.blab.blocks.BlockGravity;
import com.axanthic.blab.blocks.BlockLeaf;
import com.axanthic.blab.blocks.BlockLog;
import com.axanthic.blab.blocks.BlockOre;
import com.axanthic.blab.blocks.BlockPillar;
import com.axanthic.blab.blocks.BlockPillarHead;
import com.axanthic.blab.blocks.BlockPlanks;
import com.axanthic.blab.blocks.BlockRock;
import com.axanthic.blab.blocks.BlockSapling;
import com.axanthic.blab.blocks.BlockSoil;
import com.axanthic.blab.blocks.BlockSoilGrass;
import com.axanthic.blab.blocks.BlockTallGrass;
import com.axanthic.blab.items.ItemBlockMaterial;
import com.axanthic.blab.items.ItemBlockMeta;
import com.axanthic.blab.items.ItemBlockMetaMaterial;
import com.axanthic.blab.items.ItemCustomArmor;
import com.axanthic.blab.items.ItemDimensionTeleporter;
import com.axanthic.blab.items.ItemLaurelWreath;
import com.axanthic.blab.items.ItemMeta;
import com.axanthic.blab.items.ItemMetaMaterial;
import com.axanthic.blab.items.ItemResource;
import com.axanthic.blab.items.ItemSharpBone;
import com.axanthic.blab.items.ToolAxe;
import com.axanthic.blab.items.ToolBident;
import com.axanthic.blab.items.ToolDagger;
import com.axanthic.blab.items.ToolPickaxe;
import com.axanthic.blab.items.ToolScythe;
import com.axanthic.blab.items.ToolShovel;
import com.axanthic.blab.items.ToolSword;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class Resources {

	public static final SoundType SILENCE = new SoundType(-10.0F, 1.0F, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL);
	public static final String[] metals = new String[]{"chalkos", "kassiteros", "molibos", "orichalcum", "sliver", "vanadium", "vanadiumsteel", "sideros", "molybdenum", "molybdenumsteel", "bluridium"};

	public static List<Item> items = new ArrayList<Item>();
	public static List<ItemBlock> blocks = new ArrayList<ItemBlock>();

	public static Item dimensionTp = new ItemDimensionTeleporter().setUnlocalizedName("dimension_teleporter").setRegistryName("dimension_teleporter");
	public static ItemMeta resource = new ItemResource();
	public static Item sharpBone = new ItemSharpBone();
	public static Item laurelWreath = new ItemLaurelWreath();
	public static ItemMeta ingot = new ItemMetaMaterial("ingot", Resources.metals);
	public static ItemMeta nugget = new ItemMetaMaterial("nugget", Resources.metals);

	public static ToolSet chalkos = new ToolSet(new CompleteToolMaterial("chalkos", -1.0F, 1, 174, 5.0F, 1.0F, 15, new ItemStack(Resources.ingot, 1, 0)));
	public static ToolSet kassiteros = new ToolSet(new CompleteToolMaterial("kassiteros", -1.1F, 2, 234, 5.0F, 1.5F, 15, new ItemStack(Resources.ingot, 1, 1)));
	public static ToolSet orichalcum = new ToolSet(new CompleteToolMaterial("orichalcum", -0.8F, 3, 385, 6.0F, 2.0F, 19, new ItemStack(Resources.ingot, 1, 3)));
	public static ToolSet vanadiumsteel = new ToolSet(new CompleteToolMaterial("vanadiumsteel", -1.0F, 3, 424, 4.0F, 3.0F, 11, new ItemStack(Resources.ingot, 1, 6)));
	public static ToolSet sideros = new ToolSet(new CompleteToolMaterial("sideros", -1.1F, 4, 528, 7.0F, 2.5F, 14, new ItemStack(Resources.ingot, 1, 7)));
	public static ToolSet molybdenumsteel = new ToolSet(new CompleteToolMaterial("molybdenumsteel", -1.2F, 4, 673, 7.5F, 2.0F, 12, new ItemStack(Resources.ingot, 1, 9)));

	public static ArmorSet chalkosArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "chalkos", ModInformation.ID + ":" + "armor_chalkos", 11, new int[]{1, 3, 4, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F).setRepairItem(new ItemStack(Resources.ingot, 1, 0)));
	public static ArmorSet kassiterosArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "kassiteros", ModInformation.ID + ":" + "armor_kassiteros", 15, new int[]{2, 3, 5, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F).setRepairItem(new ItemStack(Resources.ingot, 1, 1)));
	public static ArmorSet orichalcumArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "orichalcum", ModInformation.ID + ":" + "armor_orichalcum", 24, new int[]{2, 4, 6, 2}, 19, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F).setRepairItem(new ItemStack(Resources.ingot, 1, 3)));
	public static ArmorSet vanadiumArmor = new ArmorSet(EnumHelper.addArmorMaterial(ModInformation.ID + ":" + "vanadiumsteel", ModInformation.ID + ":" + "armor_vanadiumsteel", 27, new int[]{3, 5, 7, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5F).setRepairItem(new ItemStack(Resources.ingot, 1, 5)));

	public static WoodSet plane = new WoodSet(BlockPlanks.WoodTypes.PLANE);
	public static WoodSet populus = new WoodSet(BlockPlanks.WoodTypes.POPULUS);
	public static WoodSet cypress = new WoodSet(BlockPlanks.WoodTypes.CYPRESS);
	public static WoodSet fir = new WoodSet(BlockPlanks.WoodTypes.FIR);
	public static WoodSet olive = new WoodSet(BlockPlanks.WoodTypes.OLIVE);
	public static WoodSet laurel = new WoodSet(BlockPlanks.WoodTypes.LAUREL);

	public static ItemBlockMeta soil = new ItemBlockMeta(new BlockSoil());
	public static ItemBlock grass = new ItemBlock(new BlockSoilGrass());
	public static ItemBlock tallGrass = new ItemBlock(new BlockTallGrass());
	public static ItemBlockMeta flower = new ItemBlockMeta(new BlockFlower());
	public static ItemBlockMeta planks = new ItemBlockMetaMaterial(new BlockPlanks());
	public static ItemBlockMeta rock = new ItemBlockMetaMaterial(new BlockRock("rock"));
	public static ItemBlockMeta brick = new ItemBlockMetaMaterial(new BlockRock("bricks"));
	public static ItemBlockMeta ore = new ItemBlockMetaMaterial(new BlockOre());
	public static ItemBlock silkstoneSand = new ItemBlock(new BlockGravity(Material.SAND, 1.2F, "silkstone_sand", MapColor.PINK_STAINED_HARDENED_CLAY).setSoundType(SoundType.SAND));
	public static ItemBlock calcite = new ItemBlock(new BlockGem("calcite"));
	public static ItemBlock jasper = new ItemBlock(new BlockGem("jasper"));
	public static ItemBlock zircon = new ItemBlock(new BlockGem("zircon"));
	public static ItemBlock relicstone = new ItemBlock(new BlockBasic(Material.ROCK, 1.2F, "smooth_relicstone", MapColor.WOOD).setSoundType(SoundType.STONE));
	public static ItemBlock pillar = new ItemBlock(new BlockPillar());
	public static ItemBlock pillarHead = new ItemBlock(new BlockPillarHead());

	public static void registerItems() {
		Resources.items.add(Resources.dimensionTp);
		Resources.items.add(Resources.resource);
		Resources.items.add(Resources.sharpBone);
		Resources.items.add(Resources.laurelWreath);
		Resources.items.add(Resources.ingot);
		Resources.items.add(Resources.nugget);

		Resources.chalkos.register();
		Resources.kassiteros.register();
		Resources.orichalcum.register();
		Resources.vanadiumsteel.register();
		Resources.sideros.register();
		Resources.molybdenumsteel.register();

		Resources.chalkosArmor.register();
		Resources.kassiterosArmor.register();
		Resources.orichalcumArmor.register();
		Resources.vanadiumArmor.register();
	}

	public static void registerBlocks() {
		Resources.registerBlock(Resources.soil);
		Resources.registerBlock(Resources.grass);
		Resources.registerBlock(Resources.tallGrass);
		Resources.registerBlock(Resources.flower);
		Resources.registerBlock(Resources.planks);
		Resources.registerBlock(Resources.rock);
		Resources.registerBlock(Resources.brick);
		Resources.registerBlock(Resources.ore);
		Resources.registerBlock(Resources.silkstoneSand);
		Resources.registerBlock(Resources.calcite);
		Resources.registerBlock(Resources.jasper);
		Resources.registerBlock(Resources.zircon);
		Resources.registerBlock(Resources.relicstone);
		Resources.registerBlock(Resources.pillar);
		Resources.registerBlock(Resources.pillarHead);
		
		Resources.plane.register();
		Resources.populus.register();
		Resources.cypress.register();
		Resources.fir.register();
		Resources.olive.register();
		Resources.laurel.register();
	}

	public static void registerBlock(final ItemBlock block) {
		Resources.blocks.add((ItemBlock) block.setRegistryName(block.getBlock().getRegistryName()));
	}

	public static class CompleteToolMaterial {

		public ToolMaterial material;
		public float attackSpeed;

		public CompleteToolMaterial(final String name, final float attackSpeed, final int harvestLevel, final int maxUses, final float efficiency, final float damage, final int enchantability, final ItemStack repair) {
			this.material = EnumHelper.addToolMaterial(ModInformation.ID + ":" + name, harvestLevel, maxUses, efficiency, damage, enchantability).setRepairItem(repair);
			this.attackSpeed = attackSpeed;
		}
	}

	public static class ToolSet {

		public ToolAxe axe;
		public ToolPickaxe pickaxe;
		public ToolShovel shovel;
		public ToolSword sword;
		public ToolDagger dagger;
		public ToolBident bident;
		public ToolScythe scythe;

		public ToolSet(final CompleteToolMaterial material) {
			this.axe = new ToolAxe(material);
			this.pickaxe = new ToolPickaxe(material);
			this.shovel = new ToolShovel(material);
			this.sword = new ToolSword(material);
			this.dagger = new ToolDagger(material);
			this.bident = new ToolBident(material);
			this.scythe = new ToolScythe(material);
		}

		public void register() {
			Resources.items.add(this.axe);
			Resources.items.add(this.pickaxe);
			Resources.items.add(this.shovel);
			Resources.items.add(this.sword);
			Resources.items.add(this.dagger);
			Resources.items.add(this.bident);
			Resources.items.add(this.scythe);
		}
	}

	public static class ArmorSet {

		public Item helmet;
		public Item chestplate;
		public Item leggings;
		public Item boots;

		public ArmorSet(final ItemArmor.ArmorMaterial material) {
			this.helmet = new ItemCustomArmor(material, EntityEquipmentSlot.HEAD);
			this.chestplate = new ItemCustomArmor(material, EntityEquipmentSlot.CHEST);
			this.leggings = new ItemCustomArmor(material, EntityEquipmentSlot.LEGS);
			this.boots = new ItemCustomArmor(material, EntityEquipmentSlot.FEET);
		}

		public void register() {
			Resources.items.add(this.helmet);
			Resources.items.add(this.chestplate);
			Resources.items.add(this.leggings);
			Resources.items.add(this.boots);
		}
	}

	public static class WoodSet {

		public ItemBlockMaterial log;
		public ItemBlockMaterial strippedLog;
		public ItemBlockMaterial sapling;
		public ItemBlockMaterial leaf;

		public WoodSet(final BlockPlanks.WoodTypes type) {
			this.strippedLog = new ItemBlockMaterial(new BlockLog(type, type.mapColor, null));
			this.log = new ItemBlockMaterial(new BlockLog(type, type.logColor, strippedLog));
			this.sapling = new ItemBlockMaterial(new BlockSapling(type));
			this.leaf = new ItemBlockMaterial(new BlockLeaf(type, sapling));
		}

		public void register() {
			Resources.registerBlock(log);
			Resources.registerBlock(strippedLog);
			Resources.registerBlock(sapling);
			Resources.registerBlock(leaf);
		}
	}
}
