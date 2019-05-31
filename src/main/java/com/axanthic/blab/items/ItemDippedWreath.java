package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import ibxm.Player;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.event.GuiScreenEvent.PotionShiftEvent;
import net.minecraftforge.common.util.EnumHelper;

public class ItemDippedWreath extends ItemArmor {
	
	public ItemDippedWreath() {
		super(EnumHelper.addArmorMaterial("laurel", ModInformation.ID + ":" + "armor_laurel_dipped", 0, new int[]{0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F), 0, EntityEquipmentSlot.HEAD);
		this.setCreativeTab(Blab.modTabItems);
		this.setUnlocalizedName("dipped_wreath");
		this.setRegistryName(ModInformation.ID, "dipped_wreath");
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		return HashMultimap.<String, AttributeModifier>create();
	}
	
	/**
	 * This tells the game to do something constantly while it exists
	 * However with the IF statement that I included, it only works when it's equipped
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack ItemStack){
		if(player.inventory.armorItemInSlot(3).getItem().equals(this)) {
			player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 1, 1));
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 1, 1));
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 1, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 1, 1));
		}
	}
	@Override /**This gives it the enchantment effect*/
	public boolean hasEffect(ItemStack stack) {
		return true;
	}
}
