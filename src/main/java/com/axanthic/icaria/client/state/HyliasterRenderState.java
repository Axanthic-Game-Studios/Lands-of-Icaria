package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class HyliasterRenderState extends LivingEntityRenderState {
	public float renderScale;
	public float shadowScale;
	public int size;
	public AnimationState moveAnimationState;
	public LivingEntity livingEntity;
}
