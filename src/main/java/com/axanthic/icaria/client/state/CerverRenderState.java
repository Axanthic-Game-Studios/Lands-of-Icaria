package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CerverRenderState extends LivingEntityRenderState {
	public AnimationState attackAnimationState;
}
