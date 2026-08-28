package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class CrawlerRevenantRenderState extends LivingEntityRenderState {
	public float attackTime;
	public float shadowStrength;
	public int id;
	public int maxTick;
	public int tick;
	public ItemStackRenderState itemStackRenderState;
	public LivingEntity livingEntity;
}
