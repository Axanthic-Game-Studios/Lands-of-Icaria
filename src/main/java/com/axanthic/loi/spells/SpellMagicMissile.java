package com.axanthic.loi.spells;

import com.axanthic.loi.entity.EntitySpellWisp;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SpellMagicMissile extends AbstractSpell {

	@Override
	public int getColor() {
		return 0x8F50D9;
	}

	@Override
	public ActionResult<ItemStack> castSpell(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!playerIn.isCreative()) {
			playerIn.getHeldItem(handIn).shrink(1);
			playerIn.getCooldownTracker().setCooldown(playerIn.getHeldItem(handIn).getItem(), 20);
		}
		if (!worldIn.isRemote) {
			EntitySpellWisp entityWisp = new EntitySpellWisp(worldIn, playerIn, this);
			entityWisp.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 3.0F, 0.0F);
			worldIn.spawnEntity(entityWisp);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	@Override
	public void spellHit(RayTraceResult result, EntitySpellWisp entity) {
		if (result.typeOfHit.equals(RayTraceResult.Type.ENTITY) && result.entityHit instanceof EntityLivingBase) {
			((EntityLivingBase) result.entityHit).attackEntityFrom(DamageSource.causeIndirectMagicDamage(entity, entity.shootingEntity), 7.0F);
		} else if (result.typeOfHit.equals(RayTraceResult.Type.BLOCK)) {
			IBlockState blockstate = entity.world.getBlockState(result.getBlockPos());
			if (blockstate.getBlockHardness(entity.world, result.getBlockPos()) < 10 && blockstate.getBlockHardness(entity.world, result.getBlockPos()) > 0 && blockstate.getBlock().canEntityDestroy(blockstate, entity.world, result.getBlockPos(), entity.shootingEntity)) {
				entity.world.destroyBlock(result.getBlockPos(), false);
			}
		}
	}
}
