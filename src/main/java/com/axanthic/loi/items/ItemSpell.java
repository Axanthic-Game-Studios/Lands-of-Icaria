package com.axanthic.loi.items;

import com.axanthic.loi.spells.AbstractSpell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemSpell extends ItemBasic {

	public String name;
	public AbstractSpell spell;

	public ItemSpell(String name, AbstractSpell spell) {
		super("spell_" + name);
		this.name = name;
		this.spell = spell;
		this.setUnlocalizedName("generic.spell");
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("spell." + name + ".name"));
		} catch (Exception e) {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), "");
		}
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		return spell.castSpell(worldIn, playerIn, handIn);
	}

	public String getName() {
		return name;
	}
}
