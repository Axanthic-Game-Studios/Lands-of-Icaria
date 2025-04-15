package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SoldierRevenantRenderState extends LivingEntityRenderState {
	public float attackTime;
	public int id;
	public LivingEntity livingEntity;
}
