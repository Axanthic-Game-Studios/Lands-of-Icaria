package com.axanthic.icaria.common.entity;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireJellyfishEntity extends JellyfishEntity {
	public FireJellyfishEntity(EntityType<? extends FireJellyfishEntity> pEntityType, Level pLevel) {
		super(pEntityType, pLevel);
	}

	@Override
	public void touch(Player pPlayer) {
		var i = this.getSize() * 5;
		pPlayer.igniteForSeconds(i);
	}
}
