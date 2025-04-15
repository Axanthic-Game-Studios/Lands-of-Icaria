package com.axanthic.icaria.client.state;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FireJellyfishRenderState extends LivingEntityRenderState {
	public float renderScale;
	public float shadowScale;
	public float tentacleAngle;
	public float xBodyRot;
	public float zBodyRot;
	public int size;
	public LivingEntity livingEntity;
}
