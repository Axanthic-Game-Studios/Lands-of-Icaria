package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources.CompleteToolMaterial;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.text.translation.I18n;

public class ToolDagger extends ItemTool implements IItemCustomReach {

	public CompleteToolMaterial material;

	public ToolDagger(CompleteToolMaterial material) {
		super(material.material.getAttackDamage(), material.attackSpeed, material.material, null);
		this.material = material;
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("generic.dagger");
		this.setRegistryName(ModInformation.ID, "dagger_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (I18n.canTranslate("item.dagger_" + toolMaterial.name().substring(ModInformation.ID.length() + 1) + ".name"))
			return I18n.translateToLocal("item.dagger_" + toolMaterial.name().substring(ModInformation.ID.length() + 1) + ".name");
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + material.material.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return I18n.translateToLocal(this.getUnlocalizedName() + ".name");
		}
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		return true;
	}

	@Override
	public float getDestroySpeed(ItemStack stack, IBlockState state){
		return 1.0F;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
		if (enchantment.equals(Enchantments.SWEEPING)) {
			return false;
		}
		if (enchantment.type.equals(EnumEnchantmentType.ALL) || enchantment.type.equals(EnumEnchantmentType.BREAKABLE) || enchantment.type.equals(EnumEnchantmentType.WEAPON)) {
			return true;
		}
		return false;
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(LandsOfIcaria.ATTACK_RANGE.getName(), new AttributeModifier(LandsOfIcaria.ATTACK_RANGE_MODIFIER, "Weapon modifier", (double)this.getReach() - 5.0D, 0));
		}
		return multimap;
	}

	@Override
	public float getReach() {
		return 3.0F;
	}
}
