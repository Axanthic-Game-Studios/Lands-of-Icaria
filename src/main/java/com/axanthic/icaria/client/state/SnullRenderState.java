package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SnullRenderState extends LivingEntityRenderState {
	public boolean climbing;
	public float renderScale;
	public float shadowScale;
	public AnimationState hideAnimationState;
	public AnimationState hurtAnimationState;
	public AnimationState idleAnimationState;
	public AnimationState moveAnimationState;
	public AnimationState showAnimationState;
	public LivingEntity livingEntity;
}
