package com.axanthic.icaria.common.entity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class WaterJellyfishEntity extends JellyfishEntity {
	public WaterJellyfishEntity(EntityType<? extends WaterJellyfishEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public void touch(Player pPlayer) {
		var mobEffectInstance = new MobEffectInstance(MobEffects.SLOWNESS, this.getSize() * 100, 0);
		pPlayer.addEffect(mobEffectInstance, this);
	}
}
