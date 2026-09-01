package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrystalSlugRenderState extends LivingEntityRenderState {
	public boolean climbing;
	public float blue;
	public float green;
	public float red;
	public float renderScale;
	public float shadowScale;
	public float shadowStrength;
	public AnimationState hideAnimationState;
	public AnimationState hurtAnimationState;
	public AnimationState moveAnimationState;
	public AnimationState showAnimationState;
	public LivingEntity livingEntity;
}
