package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemFoods extends ItemFood implements IItemMeta {

	public foodStats[] foods = new foodStats[] {
		new foodStats("olive_green", 2, 0.3F),
		new foodStats("olive_black", 2, 0.3F),
		new foodStats("laurel_cherry", 4, 0.3F),
		new foodStats("aeternae_meat", 3, 0.3F),
		new foodStats("aeternae_meat_cooked", 8, 0.8F),
		new foodStats("strawberry", 1, 0.3F),
		new foodStats("physalis", 2, 0.5F),
		new foodStats("sow_meat", 2, 0.0F,
				// 100% chance of 400 ticks (20 seconds) of hunger.
				new PotionEffect(Potion.getPotionFromResourceLocation("hunger"), 400), 1.0F),
		new foodStats("sow_meat_cooked", 5, 0.8F)
	};

	public ItemFoods() {
		super(0, false);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("food");
		this.setRegistryName(ModInformation.ID, "food");
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + foods[stack.getMetadata()].name;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (tab.equals(this.getCreativeTab()))
			for (int i = 0; i < foods.length; i++) {
				items.add(new ItemStack(this, 1, i));
			}
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		return foods[stack.getMetadata()].food;
	}

	@Override
	public float getSaturationModifier(ItemStack stack) {
		return foods[stack.getMetadata()].saturation;
	}

	@Override
	public String[] getNames() {
		String[] names = new String[foods.length];
		for (int i = 0; i < foods.length; ++i) {
			names[i] = foods[i].name;
		}
		return names;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		foodStats item = foods[stack.getMetadata()];
		
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
