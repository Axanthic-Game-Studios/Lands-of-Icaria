package com.axanthic.loi.items;

import com.axanthic.loi.Resources;
import com.axanthic.loi.spells.AbstractSpell;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemConcoctionFlask extends ItemBasic {

	public String name;
	public AbstractSpell spell;

	public ItemConcoctionFlask(String name, AbstractSpell spell) {
		super("concoction_flask_" + name);
		this.name = name;
		this.spell = spell;
		this.setUnlocalizedName("generic.flask");
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
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		EntityPlayer entityplayer = entityLiving instanceof EntityPlayer ? (EntityPlayer)entityLiving : null;

		if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
			stack.shrink(1);
		}
		if (entityplayer instanceof EntityPlayerMP) {
			CriteriaTriggers.CONSUME_ITEM.trigger((EntityPlayerMP)entityplayer, stack);
		}
		if (!worldIn.isRemote) {
			spell.drinkConcoction(stack, worldIn, entityLiving);
		}
		if (entityplayer != null) {
			entityplayer.addStat(StatList.getObjectUseStats(this));
		}
		if (entityplayer == null || !entityplayer.capabilities.isCreativeMode) {
			if (stack.isEmpty()) {
				return new ItemStack(Resources.emptyFlask);
			}
			if (entityplayer != null) {
				entityplayer.inventory.addItemStackToInventory(new ItemStack(Resources.emptyFlask));
			}
		}
		return stack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	public int getColor() {
		return spell.getColor();
	}

	public AbstractSpell getSpell() {
		return spell;
	}

	public String getName() {
		return name;
	}
}
