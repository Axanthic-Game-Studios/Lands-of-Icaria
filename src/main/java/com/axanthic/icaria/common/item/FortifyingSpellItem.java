package com.axanthic.icaria.common.item;

import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.world.entity.EntityType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FortifyingSpellItem extends SpellItem {
	public FortifyingSpellItem(float pInaccuracy, float pVelocity, int pColour, int pCooldown, Properties pProperties) {
		super(pInaccuracy, pVelocity, pColour, pCooldown, pProperties);
	}

	@Override
	public EntityType<?> getEntity() {
		return IcariaEntityTypes.FORTIFYING_SPELL.get();
	}
}
