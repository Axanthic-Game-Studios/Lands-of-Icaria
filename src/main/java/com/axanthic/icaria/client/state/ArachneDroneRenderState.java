package com.axanthic.icaria.client.state;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArachneDroneRenderState extends LivingEntityRenderState {
	public float renderScale;
	public float shadowScale;
	public AnimationState attackAnimationState;
	public LivingEntity livingEntity;
}
