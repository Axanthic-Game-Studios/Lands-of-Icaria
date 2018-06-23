package com.axanthic.blab;

import java.util.ArrayList;
import java.util.List;

import com.axanthic.blab.blocks.*;
import com.axanthic.blab.items.*;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class Resources {

	public static final SoundType SILENCE = new SoundType(-10.0F, 1.0F, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL, SoundEvents.ITEM_HOE_TILL);
	public static final String[] metals = new String[]{"chalkos", "kassiteros", "molibos", "orichalcum", "sliver", "vanadium", "vanadiumsteel", "sideros", "molybdenum", "molybdenumsteel", "bluridium", "yilaster"};

	public static List<Item> items = new ArrayList<Item>();
	public static List<ItemBlock> blocks = new ArrayList<ItemBlock>();

	public static Item stickWimba = new ItemBasic("wimba_stick");
	public static ItemMeta resource = new ItemResource();
	public static ItemMeta ingot = new ItemMetaMaterial("ingot", metals);
	public static ItemMeta nugget = new ItemMetaMaterial("nugget", metals);

	public static toolSet chalkos = new toolSet(new CompleteToolMaterial("chalkos", -1.0F, 1, 174, 5.0F, 1.0F, 15, new ItemStack(ingot, 1, 0)));
	public static toolSet kassiteros = new toolSet(new CompleteToolMaterial("kassiteros", -1.1F, 2, 234, 5.0F, 1.5F, 15, new ItemStack(ingot, 1, 1)));
	public static toolSet orichalcum = new toolSet(new CompleteToolMaterial("orichalcum", -0.8F, 3, 385, 6.0F, 2.0F, 19, new ItemStack(ingot, 1, 3)));
	public static toolSet vanadiumsteel = new toolSet(new CompleteToolMaterial("vanadiumsteel", -1.0F, 3, 424, 4.0F, 3.0F, 11, new ItemStack(ingot, 1, 6)));
	public static toolSet sideros = new toolSet(new CompleteToolMaterial("sideros", -1.1F, 4, 528, 7.0F, 2.5F, 14, new ItemStack(ingot, 1, 7)));
	public static toolSet molybdenumsteel = new toolSet(new CompleteToolMaterial("molybdenumsteel", -1.2F, 4, 673, 7.5F, 2.0F, 12, new ItemStack(ingot, 1, 9)));

	public static ItemBlockMeta soil = new ItemBlockMeta(new BlockSoil());
	public static ItemBlock grass = new ItemBlock(new BlockSoilGrass());
	public static ItemBlockMeta rock = new ItemBlockMetaMaterial(new BlockRock("rock"));
	public static ItemBlockMeta brick = new ItemBlockMetaMaterial(new BlockRock("bricks"));
	public static ItemBlockMeta ore = new ItemBlockMetaMaterial(new BlockOre());
	public static ItemBlock calcite = new ItemBlock(new BlockGem("calcite"));
	public static ItemBlock jasper = new ItemBlock(new BlockGem("jasper"));
	public static ItemBlock zircon = new ItemBlock(new BlockGem("zircon"));
	public static ItemBlock pillar = new ItemBlock(new BlockPillar());
	public static ItemBlock pillarHead = new ItemBlock(new BlockPillarHead());
	public static ItemBlock black = new ItemBlock(new BlockBasic(Material.ROCK, 10, "black", MapColor.BLACK).setSoundType(SILENCE));

	public static void registerItems() {
		items.add(stickWimba);
		items.add(resource);
		items.add(ingot);
		items.add(nugget);

		chalkos.register();
		kassiteros.register();
		orichalcum.register();
		vanadiumsteel.register();
		sideros.register();
		molybdenumsteel.register();
	}

	public static void registerBlocks() {
		registerBlock(soil);
		registerBlock(grass);
		registerBlock(rock);
		registerBlock(brick);
		registerBlock(ore);
		registerBlock(calcite);
		registerBlock(jasper);
		registerBlock(zircon);
		registerBlock(pillar);
		registerBlock(pillarHead);
		registerBlock(black);
	}

	public static void registerBlock(ItemBlock block) {
		blocks.add((ItemBlock) block.setRegistryName(block.getBlock().getRegistryName()));
	}

	public static class CompleteToolMaterial {

		public ToolMaterial material;
		public float attackSpeed;

		public CompleteToolMaterial(String name, float attackSpeed, int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, ItemStack repair) {
			this.material = EnumHelper.addToolMaterial(ModInformation.ID + ":" + name, harvestLevel, maxUses, efficiency, damage, enchantability).setRepairItem(repair);
			this.attackSpeed = attackSpeed;
		}
	}

	public static class toolSet {

		public ToolAxe axe;
		public ToolPickaxe pickaxe;
		public ToolShovel shovel;
		public ToolSword sword;
		public ToolDagger dagger;
		public ToolBident bident;
		public ToolScythe scythe;

		public toolSet(CompleteToolMaterial material) {
			axe = new ToolAxe(material);
			pickaxe = new ToolPickaxe(material);
			shovel = new ToolShovel(material);
			sword = new ToolSword(material);
			dagger = new ToolDagger(material);
			bident = new ToolBident(material);
			scythe = new ToolScythe(material);
		}

		public void register() {
			items.add(axe);
			items.add(pickaxe);
			items.add(shovel);
			items.add(sword);
			items.add(dagger);
			items.add(bident);
			items.add(scythe);
		}
	}
}
