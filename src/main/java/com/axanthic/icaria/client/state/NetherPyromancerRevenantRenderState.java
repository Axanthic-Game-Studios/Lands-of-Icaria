package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class NetherPyromancerRevenantRenderState extends LivingEntityRenderState {
	public float attackTime;
	public int id;
	public AnimationState reloadAnimationState;
	public AnimationState thrownAnimationState;
	public ItemStackRenderState itemStackRenderState;
	public LivingEntity livingEntity;
}
