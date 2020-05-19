package com.axanthic.loi.items;

import java.util.EnumMap;
import java.util.Map;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.utils.EnumFood;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemFoods extends ItemFood implements IItemMeta {
	protected Map<EnumFood, foodStats> foods;

//	public foodStats[] foods = new foodStats[] {
//		new foodStats("olive_green", 2, 0.3F),
//		new foodStats("olive_black", 2, 0.3F),
//		new foodStats("laurel_cherry", 4, 0.3F),
//		new foodStats("aeternae_meat", 3, 0.3F,
//				// 100% chance of 100 ticks (5 seconds) of hunger.
//				new PotionEffect(Potion.getPotionFromResourceLocation("hunger"), 100), 1.0F),
//		new foodStats("aeternae_meat_cooked", 8, 0.8F),
//		new foodStats("strawberry", 1, 0.3F),
//		new foodStats("physalis", 2, 0.5F),
//		new foodStats("sow_meat", 2, 0.3F,
//				// 100% chance of 400 ticks (20 seconds) of hunger.
//				new PotionEffect(Potion.getPotionFromResourceLocation("hunger"), 400), 1.0F),
//		new foodStats("sow_meat_cooked", 5, 0.8F),
//		new foodStats("catoblepas_meat", 2, 0.3F),
//		new foodStats("catoblepas_meat_cooked", 6, 0.8F)
//	};

	public ItemFoods() {
		super(0, false);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("food");
		this.setRegistryName(ModInformation.ID, "food");
		this.setHasSubtypes(true);
		
		/*
		 * NOTE:
		 * The order that items are inserted into the map here does NOT
		 * effect the order that the items appear in the MC creative tab.
		 * To change the in-game ordering:
		 *   1. Change the order of the constants in EnumFood.
		 *   2. Update data indexes in the relevant loot tables.
		 */
		foods = new EnumMap<EnumFood, foodStats>(EnumFood.class);
		foods.put(EnumFood.OLIVE_GREEN, new foodStats("olive_green", 2, 0.3F));
		foods.put(EnumFood.OLIVE_BLACK, new foodStats("olive_black", 2, 0.3F));
		foods.put(EnumFood.LAUREL_CHERRY, new foodStats("laurel_cherry", 4, 0.3F));
		foods.put(EnumFood.AETERNAE_MEAT, new foodStats("aeternae_meat", 3, 0.3F,
				// 100% chance of 100 ticks (5 seconds) of hunger.
				new PotionEffect(Potion.getPotionFromResourceLocation("hunger"), 100), 1.0F));
		foods.put(EnumFood.AETERNAE_MEAT_COOKED, new foodStats("aeternae_meat_cooked", 8, 0.8F));
		foods.put(EnumFood.STRAWBERRY, new foodStats("strawberry", 1, 0.3F));
		foods.put(EnumFood.PHYSALIS, new foodStats("physalis", 2, 0.5F));
		foods.put(EnumFood.SOW_MEAT, new foodStats("sow_meat", 2, 0.3F,
				// 100% chance of 400 ticks (20 seconds) of hunger.
				new PotionEffect(Potion.getPotionFromResourceLocation("hunger"), 400), 1.0F));
		foods.put(EnumFood.SOW_MEAT_COOKED, new foodStats("sow_meat_cooked", 5, 0.8F));
		foods.put(EnumFood.CATOBLEPAS_MEAT, new foodStats("catoblepas_meat", 2, 0.3F));
		foods.put(EnumFood.CATOBLEPAS_MEAT_COOKED, new foodStats("catoblepas_meat_cooked", 6, 0.8F));
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + foods.get(EnumFood.fromOrdinal(stack.getMetadata())).name;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (tab.equals(this.getCreativeTab())) {
			for (EnumFood food : EnumFood.valueArray) {
				items.add(new ItemStack(this, 1, food.ordinal()));
			}
		}
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		return foods.get(EnumFood.fromOrdinal(stack.getMetadata())).food;
	}

	@Override
	public float getSaturationModifier(ItemStack stack) {
		return foods.get(EnumFood.fromOrdinal(stack.getMetadata())).saturation;
	}

	@Override
	public String[] getNames() {
		String[] names = new String[EnumFood.valueArray.length];
		for (EnumFood food : EnumFood.valueArray) {
			int index = food.ordinal();
			names[index] = foods.get(food).name;
		}
		
		return names;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		foodStats item = foods.get(EnumFood.fromOrdinal(stack.getMetadata()));
		
		if (!worldIn.isRemote && item.effect != null && worldIn.rand.nextFloat() < item.effectProb) {
			player.addPotionEffect(new PotionEffect(item.effect));
		}
	}

	public class foodStats {
		String name;
		int food;
		float saturation;
		PotionEffect effect;
		float effectProb;

		public foodStats(String name, int food, float saturation) {
			this.name = name;
			this.food = food;
			this.saturation = saturation;
			this.effect = null;
			this.effectProb = 0.0F;
		}
		
		public foodStats(String name, int food, float saturation, PotionEffect effect, float effectProb) {
			this.name = name;
			this.food = food;
			this.saturation = saturation;
			this.effect = effect;
			this.effectProb = effectProb;
		}
	}
}
