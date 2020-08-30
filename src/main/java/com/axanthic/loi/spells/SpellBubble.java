package com.axanthic.loi.spells;

import com.axanthic.loi.entity.EntitySpellBubble;
import com.axanthic.loi.entity.EntitySpellWisp;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class SpellBubble extends AbstractSpell {

	@Override
	public int getColor() {
		return 0x0094FF;
	}

	@Override
	public ActionResult<ItemStack> castSpell(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!playerIn.isCreative()) {
			playerIn.getHeldItem(handIn).shrink(1);
			playerIn.getCooldownTracker().setCooldown(playerIn.getHeldItem(handIn).getItem(), 20);
		}
		if (!worldIn.isRemote) {
			for (int i = 0; i < worldIn.rand.nextInt(5) + 3; ++i) {
				EntitySpellWisp bubble = new EntitySpellBubble(worldIn, playerIn, this);
				bubble.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.5F, 20.0F);
				worldIn.spawnEntity(bubble);
			}
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}

	@Override
	public void spellHit(RayTraceResult result, EntitySpellWisp entity) {
		if (result.typeOfHit.equals(RayTraceResult.Type.ENTITY) && result.entityHit instanceof EntityLivingBase) {
			((EntityLivingBase) result.entityHit).attackEntityFrom(DamageSource.causeIndirectMagicDamage(entity, entity.shootingEntity), 3.0F);
		}
	}
}
