package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ArganHoundRenderState extends LivingEntityRenderState {
	public AnimationState attackAnimationState;
	public LivingEntity livingEntity;
}
