package com.axanthic.loi.spells;

import com.axanthic.loi.Resources;
import com.axanthic.loi.entity.EntitySpellWisp;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SpellFreezing extends AbstractSpell {

	@Override
	public int getColor() {
		return 0xD7D7D7;
	}

	@Override
	public ActionResult<ItemStack> castSpell(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!playerIn.isCreative()) {
			playerIn.getHeldItem(handIn).shrink(1);
			playerIn.getCooldownTracker().setCooldown(playerIn.getHeldItem(handIn).getItem(), 10);
		}
		if (!worldIn.isRemote) {
			EntitySpellWisp entityWisp = new EntitySpellWisp(worldIn, playerIn, this);
			entityWisp.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.0F, 1.0F);
			worldIn.spawnEntity(entityWisp);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	@Override
	public void spellHit(RayTraceResult result, EntitySpellWisp entity) {
		if (result.typeOfHit.equals(RayTraceResult.Type.ENTITY) && result.entityHit instanceof EntityLivingBase) {
			((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(Resources.frozenEffect, 100));
		} else if (result.typeOfHit.equals(RayTraceResult.Type.BLOCK) && entity.world.isSideSolid(result.getBlockPos(), EnumFacing.UP) && entity.world.isAirBlock(result.getBlockPos().up())) {
			entity.world.setBlockState(result.getBlockPos().up(), Blocks.SNOW_LAYER.getDefaultState());
		}
	}
}
