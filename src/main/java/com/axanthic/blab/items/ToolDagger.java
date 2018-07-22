package com.axanthic.blab.items;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;
import com.axanthic.blab.Resources.CompleteToolMaterial;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.text.translation.I18n;

public class ToolDagger extends ItemTool implements IItemCustomReach {

	public CompleteToolMaterial material;

	public ToolDagger(CompleteToolMaterial material) {
		super(material.material.getAttackDamage(), material.attackSpeed, material.material, null);
		this.material = material;
		this.setCreativeTab(Blab.modTabItems);
		this.setUnlocalizedName("generic.dagger");
		this.setRegistryName(ModInformation.ID, "dagger_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + material.material.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
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
		if (enchantment.type.equals(EnumEnchantmentType.ALL) || enchantment.type.equals(EnumEnchantmentType.BREAKABLE) || enchantment.type.equals(EnumEnchantmentType.WEAPON)) {
			return true;
		}
		return enchantment.type.canEnchantItem(stack.getItem());
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(equipmentSlot);

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(Blab.ATTACK_RANGE.getName(), new AttributeModifier(Blab.ATTACK_RANGE_MODIFIER, "Weapon modifier", (double)this.getReach() - 5.0D, 0));
		}
		return multimap;
	}

	@Override
	public float getReach() {
		return 3.0F;
	}
}
