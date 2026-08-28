package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class PyromancerRevenantRenderState extends LivingEntityRenderState {
	public float attackTime;
	public int id;
	public AnimationState reloadAnimationState;
	public AnimationState thrownAnimationState;
	public ItemStackRenderState itemStackRenderState;
	public LivingEntity livingEntity;
}
