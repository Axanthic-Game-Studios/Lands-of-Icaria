package com.axanthic.icaria.client.state;

import com.mojang.logging.annotations.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.EntityRenderState;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellRenderState extends EntityRenderState {
	public float xRot;
	public float xRotOld;
	public float yRot;
	public float yRotOld;
	public int color;
}
