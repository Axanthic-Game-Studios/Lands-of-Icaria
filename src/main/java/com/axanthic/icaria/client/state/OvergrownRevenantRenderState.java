package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class OvergrownRevenantRenderState extends LivingEntityRenderState {
	public float attackTime;
	public float blue;
	public float green;
	public float red;
	public int id;
	public LivingEntity livingEntity;
}
