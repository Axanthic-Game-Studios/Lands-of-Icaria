package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.google.common.collect.Multimap;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSharpBone extends ItemBasic implements IItemCustomReach {

	public ItemSharpBone() {
		super("bone_sharp");
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		stack.damageItem(1, attacker);
		return true;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) {
		stack.damageItem(1, entityLiving);
		return true;
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
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", 1.5D, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -1.0D, 0));
			multimap.put(LandsOfIcaria.ATTACK_RANGE.getName(), new AttributeModifier(LandsOfIcaria.ATTACK_RANGE_MODIFIER, "Weapon modifier", (double)this.getReach() - 5.0D, 0));
		}
		return multimap;
	}

	@Override
	public float getReach() {
		return 3.0F;
	}
}
