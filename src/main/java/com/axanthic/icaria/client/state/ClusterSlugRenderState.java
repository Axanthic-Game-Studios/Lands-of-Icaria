package com.axanthic.icaria.client.state;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class ClusterSlugRenderState extends LivingEntityRenderState {
	public boolean climbing;
	public float renderScale;
	public float shadowScale;
	public float shadowStrength;
	public int color;
	public AnimationState hideAnimationState;
	public AnimationState hurtAnimationState;
	public AnimationState moveAnimationState;
	public AnimationState showAnimationState;
	public LivingEntity livingEntity;
}
