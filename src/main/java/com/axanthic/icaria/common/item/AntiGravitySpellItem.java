package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AntiGravitySpellItem extends SpellItem {
	public AntiGravitySpellItem(float pInaccuracy, float pVelocity, int pColour, int pCooldown, Properties pProperties) {
		super(pInaccuracy, pVelocity, pColour, pCooldown, pProperties);
	}

	@Override
	public EntityType<?> getEntity() {
		return IcariaEntityTypes.ANTI_GRAVITY_SPELL.get();
	}
}
