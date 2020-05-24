package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityGrenade;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemGrenade extends Item {

	public ItemGrenade() {
		super();
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("greek_fire_grenade");
		this.setRegistryName(ModInformation.ID, "greek_fire_grenade");
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (entityLiving instanceof EntityPlayer) {
			EntityPlayer entityplayer = (EntityPlayer)entityLiving;

			if (!entityplayer.capabilities.isCreativeMode) {
				stack.shrink(1);
			}

			float f = getVelocity(net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, getMaxItemUseDuration(stack) - timeLeft, true));
			if ((double)f < 0.1D)
				return;

			if (!worldIn.isRemote) {
				stack.damageItem(1, entityplayer);
				EntityGrenade entityGrenade = new EntityGrenade(worldIn, entityplayer);
				entityGrenade.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 1.0F, 1.0F);

				worldIn.spawnEntity(entityGrenade);
			}
			worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			entityplayer.addStat(StatList.getObjectUseStats(this));
		}
	}

	public static float getVelocity(int charge) {
		float f = (float)charge / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		if (f > 1.0F) {
			f = 1.0F;
		}
		return f;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, true);
		if (ret != null)
			return ret;

		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
	}
}
