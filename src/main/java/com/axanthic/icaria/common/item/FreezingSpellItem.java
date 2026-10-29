package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.world.entity.EntityType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FreezingSpellItem extends SpellItem {
	public FreezingSpellItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public float getInaccuracy() {
		return IcariaConfig.INACCURACY_FREEZING_SPELL.get().floatValue();
	}

	@Override
	public float getVelocity() {
		return IcariaConfig.VELOCITY_FREEZING_SPELL.get().floatValue();
	}

	@Override
	public int getCooldown() {
		return IcariaConfig.COOLDOWN_FREEZING_SPELL.get();
	}

	@Override
	public EntityType<?> getEntity() {
		return IcariaEntityTypes.FREEZING_SPELL.get();
	}
}
