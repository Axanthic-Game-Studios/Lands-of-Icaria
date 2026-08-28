package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CaptainRevenantRenderState extends LivingEntityRenderState {
	public boolean onRallying;
	public float attackTime;
	public int id;
	public int maxReequips;
	public int maxUnequips;
	public int reequips;
	public int unequips;
	public AnimationState rallyingAnimationState;
	public AnimationState reequipsAnimationState;
	public AnimationState unequipsAnimationState;
	public ItemStackRenderState itemStackRenderState;
	public LivingEntity livingEntity;
}
