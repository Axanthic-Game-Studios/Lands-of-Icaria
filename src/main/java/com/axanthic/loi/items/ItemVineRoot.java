package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemVineRoot extends ItemFood{

	public ItemVineRoot() {
		super(0, 1.0F, false);
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("vineroot");
		this.setRegistryName(ModInformation.ID, "vineroot");
		this.setHasSubtypes(true);
		this.setAlwaysEdible();
		this.setMaxDamage(24);
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	 public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	    {
	        ItemStack itemstack = playerIn.getHeldItem(handIn);
	        playerIn.setActiveHand(handIn);
	        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	    }
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
        	this.setDamage(stack, stack.getItemDamage() + 1);
        	((EntityPlayer) entityLiving).getCooldownTracker().setCooldown(stack.getItem(), 400);
        	//((EntityPlayer) entityLiving).dropItem(false);
        	if(this.getDamage(stack) >= this.getMaxDamage(stack)) {
        		this.setDamage(stack, 0);
        		stack.shrink(1);
        	}
        }
        return stack;
    }
	
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(entityIn instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)entityIn;
			ItemStack itemstack = stack.copy();
			itemstack.setCount(1);
			if(stack.getCount() > 1 && !player.isCreative()) {
				if(player.addItemStackToInventory(itemstack)) {
					System.out.print("Player Can Add Item");
					player.inventory.addItemStackToInventory(itemstack);
					stack.shrink(1);
				}else {
					stack.shrink(1);
					player.dropItem(stack, true);
				}
			}
		}
    }
}
