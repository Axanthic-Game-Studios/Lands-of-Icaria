package com.axanthic.loi.entity;

import com.axanthic.loi.spells.AbstractSpell;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntitySpellBubble extends EntitySpellWisp {

	public EntitySpellBubble(World worldIn) {
		super(worldIn);
		this.setSize(0.5F, 0.5F);
	}

	public EntitySpellBubble(World worldIn, double x, double y, double z) {
		this(worldIn);
		this.setPosition(x, y, z);
	}

	public EntitySpellBubble(World worldIn, EntityLivingBase shooter, AbstractSpell spell) {
		this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
		this.shootingEntity = shooter;
		this.spell = spell;
		this.dataManager.set(SPELL, spell.getName());
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate(){
		super.onUpdate();
		this.motionX *= 0.9;
		this.motionY *= 0.9;
		this.motionZ *= 0.9;
	}
}