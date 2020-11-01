package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class ItemStews extends ItemFood implements IItemMeta {

	public ItemStews() {
		super(0, false);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("stew");
		this.setRegistryName(ModInformation.ID, "stew");
		this.setHasSubtypes(true);
        this.setMaxStackSize(1);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName() + "." + StewType.byMeta(stack.getMetadata()).name;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
		if (tab.equals(this.getCreativeTab())) {
			for (StewType type : StewType.values) {
				items.add(new ItemStack(this, 1, type.toMeta()));
			}
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 2;
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		return StewType.byMeta(stack.getMetadata()).food;
	}

	@Override
	public float getSaturationModifier(ItemStack stack) {
		return StewType.byMeta(stack.getMetadata()).saturation;
	}

	@Override
	public String[] getNames() {
		String[] names = new String[StewType.length];
		for (StewType type : StewType.values) {
			names[type.toMeta()] = type.name;
		}

		return names;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		StewType type = StewType.byMeta(stack.getMetadata());

		if (!worldIn.isRemote && type.effects != null && worldIn.rand.nextFloat() < type.effectProb) {
			for (PotionEffect effect : type.effects) {
				player.addPotionEffect(new PotionEffect(effect));
			}
		}
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		super.onItemUseFinish(stack, worldIn, entityLiving);
		return new ItemStack(Items.BOWL);
	}

	public enum StewType {
		FRUIT_SALAD("fruit_salad", 7, 1.2F, 1.0F,
				new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 1)),
		AETERNAE("aeternae", 8, 1.0F),
		CERVER("cerver", 5, 1.0F),
		SOW("sow", 5, 1.0F),
		ONION("onion", 2, 0.5F),
		CATOBLEPAS("catoblepas", 6, 1.0F);

		public static final StewType[] values = StewType.values();
		public static final int length = values.length;

		public final String name;
		public final int food;
		public final float saturation;
		public final float effectProb;
		public final PotionEffect[] effects;

		StewType(String name, int food, float saturation) {
			this.name = name;
			this.food = food;
			this.saturation = saturation;
			this.effectProb = 0.0F;
			this.effects = null;
		}

		StewType(String name, int food, float saturation, float effectProb, PotionEffect... effects) {
			this.name = name;
			this.food = food;
			this.saturation = saturation;
			this.effectProb = effectProb;
			this.effects = effects;
		}

		public static StewType byMeta(int meta) {
			return values[meta];
		}

		public int toMeta() {
			return ordinal();
		}
	}
}
