package com.axanthic.icaria.client.state;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CapellaRenderState extends LivingEntityRenderState {
	public float renderScale;
	public float shadowScale;
	public int size;
	public AnimationState attackAnimationState;
	public AnimationState eatingAnimationState;
}
