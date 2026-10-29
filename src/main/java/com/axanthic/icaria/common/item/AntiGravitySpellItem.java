package com.axanthic.icaria.common.item;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;
import com.axanthic.icaria.common.config.IcariaConfig;
import com.axanthic.icaria.common.registry.IcariaEntityTypes;

import net.minecraft.world.entity.EntityType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class AntiGravitySpellItem extends SpellItem {
	public AntiGravitySpellItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public float getInaccuracy() {
		return IcariaConfig.INACCURACY_ANTI_GRAVITY_SPELL.get().floatValue();
	}

	@Override
	public float getVelocity() {
		return IcariaConfig.VELOCITY_ANTI_GRAVITY_SPELL.get().floatValue();
	}

	@Override
	public int getCooldown() {
		return IcariaConfig.COOLDOWN_ANTI_GRAVITY_SPELL.get();
	}

	@Override
	public EntityType<?> getEntity() {
		return IcariaEntityTypes.ANTI_GRAVITY_SPELL.get();
	}
}
