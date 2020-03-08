package com.axanthic.loi.items;

import com.axanthic.loi.spells.ISpell;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemSpell extends ItemBasic {
	
	ISpell spell;

	public ItemSpell(String name, ISpell spell) {
		super("spell_" + name);
		this.spell = spell;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		return spell.castSpell(worldIn, playerIn, handIn);
	}
}
