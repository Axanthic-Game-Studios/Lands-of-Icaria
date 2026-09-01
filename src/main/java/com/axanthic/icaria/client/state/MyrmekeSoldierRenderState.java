package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class MyrmekeSoldierRenderState extends LivingEntityRenderState {
	public float shadowStrength;
	public int maxTick;
	public int tick;
	public AnimationState attackAnimationState;
	public LivingEntity livingEntity;
}
