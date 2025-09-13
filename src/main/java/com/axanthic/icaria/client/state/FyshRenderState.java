package com.axanthic.icaria.client.state;

import com.axanthic.icaria.common.variant.FyshVariant;

import javax.annotation.ParametersAreNonnullByDefault;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.Holder;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault

public class FyshRenderState extends LivingEntityRenderState {
	public float renderScale;
	public float shadowScale;
	public int id;
	public Holder<FyshVariant> fyshVariant;
}
