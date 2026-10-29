package com.axanthic.icaria.client.state;

import com.axanthic.icaria.annotation.MethodsReturnNonnullByDefault;
import com.axanthic.icaria.annotation.ParametersAreNonnullByDefault;

import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.world.entity.EntityType;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class SpellRenderState extends EntityRenderState {
	public float xRot;
	public float xRotOld;
	public float yRot;
	public float yRotOld;
	public EntityType<?> entityType;
}
