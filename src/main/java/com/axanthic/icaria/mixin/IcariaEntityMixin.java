package com.axanthic.icaria.mixin;

import org.spongepowered.asm.mixin.Mixin;

import com.axanthic.icaria.common.util.mixininterfaces.IIcariaEntityMixin;

import net.minecraft.world.entity.Entity;

@Mixin(value = Entity.class)
public class IcariaEntityMixin implements IIcariaEntityMixin {

	int icaria$greekDuration = 0;

	@Override
	public void icaria$setGreekFireDuration(int time) {
		this.icaria$greekDuration = time;
	}

	@Override
	public int icaria$getGreekFireDuration( ) {
		return icaria$greekDuration;
	}

}
