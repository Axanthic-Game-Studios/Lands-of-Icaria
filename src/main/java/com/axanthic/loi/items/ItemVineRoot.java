package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;

import net.minecraft.entity.EntityLivingBase;
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
        	if(this.getDamage(stack) >= this.getMaxDamage(stack)) {
        		stack.shrink(1);
        	}
        }
        return stack;
    }

}
